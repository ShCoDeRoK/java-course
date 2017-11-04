// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: main/proto/prime.proto

package ru.mipt.java2017.hw2;

/**
 * Protobuf type {@code ru.mipt.java2017.hw2.SumRequest}
 */
public final class SumRequest extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:ru.mipt.java2017.hw2.SumRequest)
    SumRequestOrBuilder {
  // Use SumRequest.newBuilder() to construct.
  private SumRequest(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
    this.unknownFields = builder.getUnknownFields();
  }
  private SumRequest(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

  private static final SumRequest defaultInstance;
  public static SumRequest getDefaultInstance() {
    return defaultInstance;
  }

  public SumRequest getDefaultInstanceForType() {
    return defaultInstance;
  }

  private final com.google.protobuf.UnknownFieldSet unknownFields;
  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
      getUnknownFields() {
    return this.unknownFields;
  }
  private SumRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    initFields();
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownField(input, unknownFields,
                                   extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 8: {
            bitField0_ |= 0x00000001;
            start_ = input.readInt64();
            break;
          }
          case 16: {
            bitField0_ |= 0x00000002;
            end_ = input.readInt64();
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e.getMessage()).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return ru.mipt.java2017.hw2.SumPrimesProto.internal_static_ru_mipt_java2017_hw2_SumRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ru.mipt.java2017.hw2.SumPrimesProto.internal_static_ru_mipt_java2017_hw2_SumRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ru.mipt.java2017.hw2.SumRequest.class, ru.mipt.java2017.hw2.SumRequest.Builder.class);
  }

  public static com.google.protobuf.Parser<SumRequest> PARSER =
      new com.google.protobuf.AbstractParser<SumRequest>() {
    public SumRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new SumRequest(input, extensionRegistry);
    }
  };

  @java.lang.Override
  public com.google.protobuf.Parser<SumRequest> getParserForType() {
    return PARSER;
  }

  private int bitField0_;
  public static final int START_FIELD_NUMBER = 1;
  private long start_;
  /**
   * <code>required int64 start = 1;</code>
   */
  public boolean hasStart() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>required int64 start = 1;</code>
   */
  public long getStart() {
    return start_;
  }

  public static final int END_FIELD_NUMBER = 2;
  private long end_;
  /**
   * <code>required int64 end = 2;</code>
   */
  public boolean hasEnd() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <code>required int64 end = 2;</code>
   */
  public long getEnd() {
    return end_;
  }

  private void initFields() {
    start_ = 0L;
    end_ = 0L;
  }
  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    if (!hasStart()) {
      memoizedIsInitialized = 0;
      return false;
    }
    if (!hasEnd()) {
      memoizedIsInitialized = 0;
      return false;
    }
    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    getSerializedSize();
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      output.writeInt64(1, start_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeInt64(2, end_);
    }
    getUnknownFields().writeTo(output);
  }

  private int memoizedSerializedSize = -1;
  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, start_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(2, end_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSerializedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  protected java.lang.Object writeReplace()
      throws java.io.ObjectStreamException {
    return super.writeReplace();
  }

  public static ru.mipt.java2017.hw2.SumRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ru.mipt.java2017.hw2.SumRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ru.mipt.java2017.hw2.SumRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ru.mipt.java2017.hw2.SumRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ru.mipt.java2017.hw2.SumRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static ru.mipt.java2017.hw2.SumRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }
  public static ru.mipt.java2017.hw2.SumRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input);
  }
  public static ru.mipt.java2017.hw2.SumRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  public static ru.mipt.java2017.hw2.SumRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static ru.mipt.java2017.hw2.SumRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }

  public static Builder newBuilder() { return Builder.create(); }
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder(ru.mipt.java2017.hw2.SumRequest prototype) {
    return newBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() { return newBuilder(this); }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessage.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code ru.mipt.java2017.hw2.SumRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ru.mipt.java2017.hw2.SumRequest)
      ru.mipt.java2017.hw2.SumRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ru.mipt.java2017.hw2.SumPrimesProto.internal_static_ru_mipt_java2017_hw2_SumRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ru.mipt.java2017.hw2.SumPrimesProto.internal_static_ru_mipt_java2017_hw2_SumRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ru.mipt.java2017.hw2.SumRequest.class, ru.mipt.java2017.hw2.SumRequest.Builder.class);
    }

    // Construct using ru.mipt.java2017.hw2.SumRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
      }
    }
    private static Builder create() {
      return new Builder();
    }

    public Builder clear() {
      super.clear();
      start_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000001);
      end_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    public Builder clone() {
      return create().mergeFrom(buildPartial());
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ru.mipt.java2017.hw2.SumPrimesProto.internal_static_ru_mipt_java2017_hw2_SumRequest_descriptor;
    }

    public ru.mipt.java2017.hw2.SumRequest getDefaultInstanceForType() {
      return ru.mipt.java2017.hw2.SumRequest.getDefaultInstance();
    }

    public ru.mipt.java2017.hw2.SumRequest build() {
      ru.mipt.java2017.hw2.SumRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public ru.mipt.java2017.hw2.SumRequest buildPartial() {
      ru.mipt.java2017.hw2.SumRequest result = new ru.mipt.java2017.hw2.SumRequest(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.start_ = start_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.end_ = end_;
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof ru.mipt.java2017.hw2.SumRequest) {
        return mergeFrom((ru.mipt.java2017.hw2.SumRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ru.mipt.java2017.hw2.SumRequest other) {
      if (other == ru.mipt.java2017.hw2.SumRequest.getDefaultInstance()) return this;
      if (other.hasStart()) {
        setStart(other.getStart());
      }
      if (other.hasEnd()) {
        setEnd(other.getEnd());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      return this;
    }

    public final boolean isInitialized() {
      if (!hasStart()) {
        
        return false;
      }
      if (!hasEnd()) {
        
        return false;
      }
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      ru.mipt.java2017.hw2.SumRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ru.mipt.java2017.hw2.SumRequest) e.getUnfinishedMessage();
        throw e;
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private long start_ ;
    /**
     * <code>required int64 start = 1;</code>
     */
    public boolean hasStart() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required int64 start = 1;</code>
     */
    public long getStart() {
      return start_;
    }
    /**
     * <code>required int64 start = 1;</code>
     */
    public Builder setStart(long value) {
      bitField0_ |= 0x00000001;
      start_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>required int64 start = 1;</code>
     */
    public Builder clearStart() {
      bitField0_ = (bitField0_ & ~0x00000001);
      start_ = 0L;
      onChanged();
      return this;
    }

    private long end_ ;
    /**
     * <code>required int64 end = 2;</code>
     */
    public boolean hasEnd() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required int64 end = 2;</code>
     */
    public long getEnd() {
      return end_;
    }
    /**
     * <code>required int64 end = 2;</code>
     */
    public Builder setEnd(long value) {
      bitField0_ |= 0x00000002;
      end_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>required int64 end = 2;</code>
     */
    public Builder clearEnd() {
      bitField0_ = (bitField0_ & ~0x00000002);
      end_ = 0L;
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:ru.mipt.java2017.hw2.SumRequest)
  }

  static {
    defaultInstance = new SumRequest(true);
    defaultInstance.initFields();
  }

  // @@protoc_insertion_point(class_scope:ru.mipt.java2017.hw2.SumRequest)
}

