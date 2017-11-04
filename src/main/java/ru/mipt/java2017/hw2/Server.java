package ru.mipt.java2017.hw2;


import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.*;

public class Server {

  private static final Logger logger = LoggerFactory.getLogger("Server");

  private io.grpc.Server server;

  private static int threads, port;

  private void start() throws IOException {
    server = ServerBuilder.forPort(port)
        .addService(new WorkerImpl())
        .build()
        .start();
    logger.info("Server started, listening on " + port);
    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        System.err.println("*** shutting down gRPC server since JVM is shutting down");
        Server.this.stop();
        System.err.println("*** server shut down");
      }
    });
  }

  private void stop() {
    if (server != null) {
      server.shutdown();
    }
  }

  private void blockUntilShutDown() throws InterruptedException {
    if (server != null) {
      server.awaitTermination();
    }
  }

  Server(int threads, int port) {
    this.threads = threads;
    this.port = port;
  }

  public static void main(String[] args) throws IOException, InterruptedException {
    if (args.length != 2) {
      logger.error("Bad arguments");
      System.exit(1);
    }
    final Server server = new Server(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
    server.start();
    server.blockUntilShutDown();
  }

  private static class Calculator implements Callable<Long> {
    private long from, to;
    Calculator(long from, long to) {
      this.from = from;
      this.to = to;
    }

    private boolean isPrime(long n) {
      for (int i = 2; i * i <= n; ++i) {
        if (n % i == 0)
          return false;
      }
      return n != 1;
    }
    @Override
    public Long call() {
      long sum = 0;
      for (long i = from; i < to; ++i) {
        if (isPrime(i))
          sum += i;
      }
      logger.info("Sum from {} to {} is {}", from, to, sum);
      return sum;
    }
  }

  private static long calcSum(long from, long to) {
    ExecutorService executor = Executors.newFixedThreadPool(threads);
    ArrayList<Calculator> procs = new ArrayList<>();
    for (int i = 0; i < threads; ++i) {
      long a = from + i * (to - from) / threads;
      long b = from + (i + 1) * (to - from) / threads;
      logger.info("Created thread from {} to {}", a, b);
      procs.add(new Calculator(a, b));
    }
    long sum = 0;
    try {
      for (Future<Long> future : executor.invokeAll(procs)) {
        sum += future.get();
      }
    } catch (InterruptedException e) {
      logger.error("Interrupted exception");
      return -1;
    } catch (ExecutionException e) {
      logger.error("Execution exception", e);
      return -1;
    }
    return sum;
  }

  private static class WorkerImpl extends WorkerGrpc.WorkerImplBase{
    @Override
    public void calculateSum(SumRequest req, StreamObserver<SumReply> responseObserver) {
      logger.info("Got request from client: {} - {}", req.getStart(), req.getEnd());
      long sum = calcSum(req.getStart(), req.getEnd());
      logger.info("sum from {} to {} calculated: {}", req.getStart(), req.getEnd(), sum);
      SumReply reply = SumReply.newBuilder().setSum(sum).build();
      responseObserver.onNext(reply);
      responseObserver.onCompleted();
    }
  }
}
