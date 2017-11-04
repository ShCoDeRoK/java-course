package ru.mipt.java2017.hw2;

import com.google.common.util.concurrent.ListenableFuture;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import jdk.internal.util.xml.impl.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client {

  private static final Logger logger = LoggerFactory.getLogger("Client");

  private static ArrayList<Client> clients;

  private final ManagedChannel channel;
  private final WorkerGrpc.WorkerFutureStub futureStub;

  private Client(String host, int port) {
    this(ManagedChannelBuilder.forAddress(host, port)
        .usePlaintext(true)
        .build());
  }

  Client(ManagedChannel channel) {
    this.channel = channel;
    futureStub = WorkerGrpc.newFutureStub(channel);
  }

  private void shutdown() throws InterruptedException {
    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
  }

  private static void create(HashMap<SumRequest, ListenableFuture<SumReply>> futures,
      HashMap<SumRequest, Integer> assigned,
      ArrayList<Client> clients,
      long from, long to) {
    long numServers = 0;
    for (Client client : clients) {
      if (client != null)
        ++numServers;
    }
    if (numServers == 0) {
      logger.error("No servers");
      System.exit(1);
    }
    int deadServers = 0;
    for (int i = 0; i < clients.size(); ++i) {
      if (clients.get(i) == null) {
        ++deadServers;
        continue;
      }
      SumRequest request = SumRequest.newBuilder()
          .setStart(from + (i - deadServers) * (to - from) / numServers)
          .setEnd(from + (i - deadServers + 1) * (to - from) / numServers)
          .build();
      futures.put(request, clients.get(i).futureStub.calculateSum(request));
      assigned.put(request, i);
    }
  }

  private static long request(long from, long to, ArrayList<Client> clients) throws InterruptedException {
    long sum = 0;
    HashMap<SumRequest, ListenableFuture<SumReply>> futures = new HashMap<>();
    HashMap<SumRequest, Integer> assigned = new HashMap<>();
    create(futures, assigned, clients, from, to);
    while (!futures.isEmpty()) {
      SumRequest request = futures.keySet().iterator().next();
      try {
        sum += futures.get(request).get().getSum();
      } catch (ExecutionException e) {
        logger.warn("server {} broken", assigned.get(request));
        Client client = clients.get(assigned.get(request));
        if (client != null) {
          client.shutdown();
          clients.set(assigned.get(request), null);
        }
        create(futures, assigned, clients, request.getStart(), request.getEnd());
      }
      finally {
        futures.remove(request);
        assigned.remove(request);
      }
    }
    return sum;
  }

  public static void main(String[] args) throws Exception{
    if (args.length < 2 || args.length % 2 != 0) {
      logger.error("Bad arguments");
      System.exit(1);
    }
    for (int i = 2; i < args.length; i += 2) {
      clients.add(new Client((args[i]), Integer.parseInt(args[i + 1])));
    }
    try {
      long sum = request(Long.parseLong(args[0]), Long.parseLong(args[1]) + 1, clients);
      logger.info("Sum succesfully calculated");
      System.out.println(sum);
    } catch (InterruptedException e) {
      logger.error("Interruption exception");
    }
    finally {
      for (Client client : clients) {
        if (client != null) {
          client.shutdown();
        }
      }
    }
  }
}