package ru.mipt.java2017.hw2;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.7.0)",
    comments = "Source: prime.proto")
public final class WorkerGrpc {

  private WorkerGrpc() {}

  public static final String SERVICE_NAME = "ru.mipt.java2017.hw2.Worker";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ru.mipt.java2017.hw2.SumRequest,
      ru.mipt.java2017.hw2.SumReply> METHOD_CALCULATE_SUM =
      io.grpc.MethodDescriptor.<ru.mipt.java2017.hw2.SumRequest, ru.mipt.java2017.hw2.SumReply>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "ru.mipt.java2017.hw2.Worker", "CalculateSum"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              ru.mipt.java2017.hw2.SumRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              ru.mipt.java2017.hw2.SumReply.getDefaultInstance()))
          .setSchemaDescriptor(new WorkerMethodDescriptorSupplier("CalculateSum"))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WorkerStub newStub(io.grpc.Channel channel) {
    return new WorkerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WorkerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new WorkerBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WorkerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new WorkerFutureStub(channel);
  }

  /**
   */
  public static abstract class WorkerImplBase implements io.grpc.BindableService {

    /**
     */
    public void calculateSum(ru.mipt.java2017.hw2.SumRequest request,
        io.grpc.stub.StreamObserver<ru.mipt.java2017.hw2.SumReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CALCULATE_SUM, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_CALCULATE_SUM,
            asyncUnaryCall(
              new MethodHandlers<
                ru.mipt.java2017.hw2.SumRequest,
                ru.mipt.java2017.hw2.SumReply>(
                  this, METHODID_CALCULATE_SUM)))
          .build();
    }
  }

  /**
   */
  public static final class WorkerStub extends io.grpc.stub.AbstractStub<WorkerStub> {
    private WorkerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WorkerStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkerStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WorkerStub(channel, callOptions);
    }

    /**
     */
    public void calculateSum(ru.mipt.java2017.hw2.SumRequest request,
        io.grpc.stub.StreamObserver<ru.mipt.java2017.hw2.SumReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CALCULATE_SUM, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class WorkerBlockingStub extends io.grpc.stub.AbstractStub<WorkerBlockingStub> {
    private WorkerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WorkerBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkerBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WorkerBlockingStub(channel, callOptions);
    }

    /**
     */
    public ru.mipt.java2017.hw2.SumReply calculateSum(ru.mipt.java2017.hw2.SumRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CALCULATE_SUM, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class WorkerFutureStub extends io.grpc.stub.AbstractStub<WorkerFutureStub> {
    private WorkerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WorkerFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkerFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WorkerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ru.mipt.java2017.hw2.SumReply> calculateSum(
        ru.mipt.java2017.hw2.SumRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CALCULATE_SUM, getCallOptions()), request);
    }
  }

  private static final int METHODID_CALCULATE_SUM = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final WorkerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(WorkerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CALCULATE_SUM:
          serviceImpl.calculateSum((ru.mipt.java2017.hw2.SumRequest) request,
              (io.grpc.stub.StreamObserver<ru.mipt.java2017.hw2.SumReply>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class WorkerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WorkerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ru.mipt.java2017.hw2.SumPrimesProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Worker");
    }
  }

  private static final class WorkerFileDescriptorSupplier
      extends WorkerBaseDescriptorSupplier {
    WorkerFileDescriptorSupplier() {}
  }

  private static final class WorkerMethodDescriptorSupplier
      extends WorkerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    WorkerMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (WorkerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WorkerFileDescriptorSupplier())
              .addMethod(METHOD_CALCULATE_SUM)
              .build();
        }
      }
    }
    return result;
  }
}
