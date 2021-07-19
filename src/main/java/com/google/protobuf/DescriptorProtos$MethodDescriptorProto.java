/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$MethodDescriptorProto$1;
import com.google.protobuf.DescriptorProtos$MethodDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$MethodOptions;
import com.google.protobuf.DescriptorProtos$MethodOptions$Builder;
import com.google.protobuf.DescriptorProtos$MethodOptionsOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.GeneratedMessageV3$UnusedPrivateParameter;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

public final class DescriptorProtos$MethodDescriptorProto
extends GeneratedMessageV3
implements DescriptorProtos$MethodDescriptorProtoOrBuilder {
    public static final int CLIENT_STREAMING_FIELD_NUMBER = 5;
    private static final DescriptorProtos$MethodDescriptorProto DEFAULT_INSTANCE;
    public static final int INPUT_TYPE_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 4;
    public static final int OUTPUT_TYPE_FIELD_NUMBER = 3;
    public static final Parser PARSER;
    public static final int SERVER_STREAMING_FIELD_NUMBER = 6;
    private static final long serialVersionUID;
    private int bitField0_;
    private boolean clientStreaming_;
    private volatile Object inputType_;
    private byte memoizedIsInitialized = (byte)-1;
    private volatile Object name_;
    private DescriptorProtos$MethodOptions options_;
    private volatile Object outputType_;
    private boolean serverStreaming_;

    static {
        Object object = new DescriptorProtos$MethodDescriptorProto();
        DEFAULT_INSTANCE = object;
        PARSER = object = new DescriptorProtos$MethodDescriptorProto$1();
    }

    private DescriptorProtos$MethodDescriptorProto() {
        String string2 = "";
        this.name_ = string2;
        this.inputType_ = string2;
        this.outputType_ = string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private DescriptorProtos$MethodDescriptorProto(CodedInputStream object, ExtensionRegistryLite object2) {
        this();
        Throwable throwable2;
        Objects.requireNonNull(object2);
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        int n10 = 0;
        while (true) {
            if (n10 != 0) {
                this.unknownFields = object = unknownFieldSet$Builder.build();
                this.makeExtensionsImmutable();
                return;
            }
            try {
                try {
                    int n11;
                    block17: {
                        int n12 = ((CodedInputStream)object).readTag();
                        n11 = 1;
                        if (n12 != 0) {
                            Object object3;
                            int n13 = 10;
                            if (n12 != n13) {
                                n13 = 18;
                                if (n12 != n13) {
                                    n13 = 26;
                                    if (n12 != n13) {
                                        n13 = 34;
                                        if (n12 != n13) {
                                            n13 = 40;
                                            if (n12 != n13) {
                                                n13 = 48;
                                                if (n12 != n13) {
                                                    if ((n12 = (int)(this.parseUnknownField((CodedInputStream)object, unknownFieldSet$Builder, (ExtensionRegistryLite)object2, n12) ? 1 : 0)) != 0) continue;
                                                    break block17;
                                                } else {
                                                    this.bitField0_ = n12 = this.bitField0_ | 0x20;
                                                    n12 = (int)(((CodedInputStream)object).readBool() ? 1 : 0);
                                                    this.serverStreaming_ = n12;
                                                    continue;
                                                }
                                            }
                                            this.bitField0_ = n12 = this.bitField0_ | 0x10;
                                            n12 = (int)(((CodedInputStream)object).readBool() ? 1 : 0);
                                            this.clientStreaming_ = n12;
                                            continue;
                                        }
                                        n12 = 0;
                                        object3 = null;
                                        n11 = this.bitField0_ & 8;
                                        if (n11 != 0) {
                                            object3 = this.options_;
                                            object3 = ((DescriptorProtos$MethodOptions)object3).toBuilder();
                                        }
                                        Object object4 = DescriptorProtos$MethodOptions.PARSER;
                                        object4 = ((CodedInputStream)object).readMessage((Parser)object4, (ExtensionRegistryLite)object2);
                                        this.options_ = object4 = (DescriptorProtos$MethodOptions)object4;
                                        if (object3 != null) {
                                            ((DescriptorProtos$MethodOptions$Builder)object3).mergeFrom((DescriptorProtos$MethodOptions)object4);
                                            this.options_ = object3 = ((DescriptorProtos$MethodOptions$Builder)object3).buildPartial();
                                        }
                                        this.bitField0_ = n12 = this.bitField0_ | 8;
                                        continue;
                                    }
                                    object3 = ((CodedInputStream)object).readBytes();
                                    this.bitField0_ = n11 = this.bitField0_ | 4;
                                    this.outputType_ = object3;
                                    continue;
                                }
                                object3 = ((CodedInputStream)object).readBytes();
                                this.bitField0_ = n11 = this.bitField0_ | 2;
                                this.inputType_ = object3;
                                continue;
                            }
                            object3 = ((CodedInputStream)object).readBytes();
                            n13 = this.bitField0_;
                            this.bitField0_ = n11 |= n13;
                            this.name_ = object3;
                            continue;
                        }
                    }
                    n10 = n11;
                    continue;
                }
                catch (IOException iOException) {
                    object2 = new InvalidProtocolBufferException(iOException);
                    InvalidProtocolBufferException invalidProtocolBufferException = ((InvalidProtocolBufferException)object2).setUnfinishedMessage(this);
                    throw invalidProtocolBufferException;
                }
                catch (InvalidProtocolBufferException invalidProtocolBufferException) {
                    InvalidProtocolBufferException invalidProtocolBufferException2 = invalidProtocolBufferException.setUnfinishedMessage(this);
                    throw invalidProtocolBufferException2;
                }
            }
            catch (Throwable throwable2) {}
            break;
        }
        this.unknownFields = object2 = unknownFieldSet$Builder.build();
        this.makeExtensionsImmutable();
        throw throwable2;
    }

    public /* synthetic */ DescriptorProtos$MethodDescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DescriptorProtos$1 descriptorProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private DescriptorProtos$MethodDescriptorProto(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
    }

    public /* synthetic */ DescriptorProtos$MethodDescriptorProto(GeneratedMessageV3$Builder generatedMessageV3$Builder, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ Object access$14100(DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto) {
        return descriptorProtos$MethodDescriptorProto.name_;
    }

    public static /* synthetic */ Object access$14102(DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto, Object object) {
        descriptorProtos$MethodDescriptorProto.name_ = object;
        return object;
    }

    public static /* synthetic */ Object access$14200(DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto) {
        return descriptorProtos$MethodDescriptorProto.inputType_;
    }

    public static /* synthetic */ Object access$14202(DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto, Object object) {
        descriptorProtos$MethodDescriptorProto.inputType_ = object;
        return object;
    }

    public static /* synthetic */ Object access$14300(DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto) {
        return descriptorProtos$MethodDescriptorProto.outputType_;
    }

    public static /* synthetic */ Object access$14302(DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto, Object object) {
        descriptorProtos$MethodDescriptorProto.outputType_ = object;
        return object;
    }

    public static /* synthetic */ DescriptorProtos$MethodOptions access$14402(DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto, DescriptorProtos$MethodOptions descriptorProtos$MethodOptions) {
        descriptorProtos$MethodDescriptorProto.options_ = descriptorProtos$MethodOptions;
        return descriptorProtos$MethodOptions;
    }

    public static /* synthetic */ boolean access$14502(DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto, boolean bl2) {
        descriptorProtos$MethodDescriptorProto.clientStreaming_ = bl2;
        return bl2;
    }

    public static /* synthetic */ boolean access$14602(DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto, boolean bl2) {
        descriptorProtos$MethodDescriptorProto.serverStreaming_ = bl2;
        return bl2;
    }

    public static /* synthetic */ int access$14702(DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto, int n10) {
        descriptorProtos$MethodDescriptorProto.bitField0_ = n10;
        return n10;
    }

    public static DescriptorProtos$MethodDescriptorProto getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$13600();
    }

    public static DescriptorProtos$MethodDescriptorProto$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DescriptorProtos$MethodDescriptorProto$Builder newBuilder(DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$MethodDescriptorProto);
    }

    public static DescriptorProtos$MethodDescriptorProto parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$MethodDescriptorProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$MethodDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$MethodDescriptorProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$MethodDescriptorProto parseFrom(ByteString byteString) {
        return (DescriptorProtos$MethodDescriptorProto)PARSER.parseFrom(byteString);
    }

    public static DescriptorProtos$MethodDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$MethodDescriptorProto)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DescriptorProtos$MethodDescriptorProto parseFrom(CodedInputStream codedInputStream) {
        return (DescriptorProtos$MethodDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static DescriptorProtos$MethodDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$MethodDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$MethodDescriptorProto parseFrom(InputStream inputStream) {
        return (DescriptorProtos$MethodDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$MethodDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$MethodDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$MethodDescriptorProto parseFrom(ByteBuffer byteBuffer) {
        return (DescriptorProtos$MethodDescriptorProto)PARSER.parseFrom(byteBuffer);
    }

    public static DescriptorProtos$MethodDescriptorProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$MethodDescriptorProto)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static DescriptorProtos$MethodDescriptorProto parseFrom(byte[] byArray) {
        return (DescriptorProtos$MethodDescriptorProto)PARSER.parseFrom(byArray);
    }

    public static DescriptorProtos$MethodDescriptorProto parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$MethodDescriptorProto)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2;
        boolean bl3 = true;
        if (object == this) {
            return bl3;
        }
        boolean bl4 = object instanceof DescriptorProtos$MethodDescriptorProto;
        if (!bl4) {
            return super.equals(object);
        }
        object = (DescriptorProtos$MethodDescriptorProto)object;
        bl4 = this.hasName();
        if (bl4 != (bl2 = ((DescriptorProtos$MethodDescriptorProto)object).hasName())) {
            return false;
        }
        bl4 = this.hasName();
        if (bl4 && !(bl4 = ((String)(object3 = this.getName())).equals(object2 = ((DescriptorProtos$MethodDescriptorProto)object).getName()))) {
            return false;
        }
        bl4 = this.hasInputType();
        if (bl4 != (bl2 = ((DescriptorProtos$MethodDescriptorProto)object).hasInputType())) {
            return false;
        }
        bl4 = this.hasInputType();
        if (bl4 && !(bl4 = ((String)(object3 = this.getInputType())).equals(object2 = ((DescriptorProtos$MethodDescriptorProto)object).getInputType()))) {
            return false;
        }
        bl4 = this.hasOutputType();
        if (bl4 != (bl2 = ((DescriptorProtos$MethodDescriptorProto)object).hasOutputType())) {
            return false;
        }
        bl4 = this.hasOutputType();
        if (bl4 && !(bl4 = ((String)(object3 = this.getOutputType())).equals(object2 = ((DescriptorProtos$MethodDescriptorProto)object).getOutputType()))) {
            return false;
        }
        bl4 = this.hasOptions();
        if (bl4 != (bl2 = ((DescriptorProtos$MethodDescriptorProto)object).hasOptions())) {
            return false;
        }
        bl4 = this.hasOptions();
        if (bl4 && !(bl4 = ((DescriptorProtos$MethodOptions)(object3 = this.getOptions())).equals(object2 = ((DescriptorProtos$MethodDescriptorProto)object).getOptions()))) {
            return false;
        }
        bl4 = this.hasClientStreaming();
        if (bl4 != (bl2 = ((DescriptorProtos$MethodDescriptorProto)object).hasClientStreaming())) {
            return false;
        }
        bl4 = this.hasClientStreaming();
        if (bl4 && (bl4 = this.getClientStreaming()) != (bl2 = ((DescriptorProtos$MethodDescriptorProto)object).getClientStreaming())) {
            return false;
        }
        bl4 = this.hasServerStreaming();
        if (bl4 != (bl2 = ((DescriptorProtos$MethodDescriptorProto)object).hasServerStreaming())) {
            return false;
        }
        bl4 = this.hasServerStreaming();
        if (bl4 && (bl4 = this.getServerStreaming()) != (bl2 = ((DescriptorProtos$MethodDescriptorProto)object).getServerStreaming())) {
            return false;
        }
        object3 = this.unknownFields;
        object = ((GeneratedMessageV3)object).unknownFields;
        boolean bl5 = ((UnknownFieldSet)object3).equals(object);
        if (!bl5) {
            return false;
        }
        return bl3;
    }

    public boolean getClientStreaming() {
        return this.clientStreaming_;
    }

    public DescriptorProtos$MethodDescriptorProto getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public String getInputType() {
        Object object = this.inputType_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.inputType_ = string2;
        }
        return string2;
    }

    public ByteString getInputTypeBytes() {
        Object object = this.inputType_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.inputType_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public String getName() {
        Object object = this.name_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.name_ = string2;
        }
        return string2;
    }

    public ByteString getNameBytes() {
        Object object = this.name_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.name_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public DescriptorProtos$MethodOptions getOptions() {
        DescriptorProtos$MethodOptions descriptorProtos$MethodOptions = this.options_;
        if (descriptorProtos$MethodOptions == null) {
            descriptorProtos$MethodOptions = DescriptorProtos$MethodOptions.getDefaultInstance();
        }
        return descriptorProtos$MethodOptions;
    }

    public DescriptorProtos$MethodOptionsOrBuilder getOptionsOrBuilder() {
        DescriptorProtos$MethodOptions descriptorProtos$MethodOptions = this.options_;
        if (descriptorProtos$MethodOptions == null) {
            descriptorProtos$MethodOptions = DescriptorProtos$MethodOptions.getDefaultInstance();
        }
        return descriptorProtos$MethodOptions;
    }

    public String getOutputType() {
        Object object = this.outputType_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.outputType_ = string2;
        }
        return string2;
    }

    public ByteString getOutputTypeBytes() {
        Object object = this.outputType_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.outputType_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public Parser getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        Object object;
        int n10 = this.memoizedSize;
        int n11 = -1;
        if (n10 != n11) {
            return n10;
        }
        n10 = 0;
        n11 = this.bitField0_;
        int n12 = 1;
        if ((n11 &= n12) != 0) {
            object = this.name_;
            n11 = GeneratedMessageV3.computeStringSize(n12, object);
            n10 = 0 + n11;
        }
        n11 = this.bitField0_;
        n12 = 2;
        if ((n11 &= n12) != 0) {
            object = this.inputType_;
            n11 = GeneratedMessageV3.computeStringSize(n12, object);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 4;
        if ((n11 &= n12) != 0) {
            Object object2 = this.outputType_;
            n11 = GeneratedMessageV3.computeStringSize(3, object2);
            n10 += n11;
        }
        if ((n11 = this.bitField0_ & 8) != 0) {
            object = this.getOptions();
            n11 = CodedOutputStream.computeMessageSize(n12, (MessageLite)object);
            n10 += n11;
        }
        if ((n11 = this.bitField0_ & 0x10) != 0) {
            n12 = (int)(this.clientStreaming_ ? 1 : 0);
            n11 = CodedOutputStream.computeBoolSize(5, n12 != 0);
            n10 += n11;
        }
        if ((n11 = this.bitField0_ & 0x20) != 0) {
            n12 = this.serverStreaming_;
            n11 = CodedOutputStream.computeBoolSize(6, n12 != 0);
            n10 += n11;
        }
        n11 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n10 += n11;
        return n10;
    }

    public boolean getServerStreaming() {
        return this.serverStreaming_;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public boolean hasClientStreaming() {
        int n10 = this.bitField0_ & 0x10;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasInputType() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasName() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean hasOptions() {
        int n10 = this.bitField0_ & 8;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasOutputType() {
        int n10 = this.bitField0_ & 4;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasServerStreaming() {
        int n10 = this.bitField0_ & 0x20;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        Object object = DescriptorProtos$MethodDescriptorProto.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = (int)(this.hasName() ? 1 : 0);
        if (n11 != 0) {
            n10 = (n10 * 37 + 1) * 53;
            object = this.getName();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasInputType() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 2) * 53;
            object = this.getInputType();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasOutputType() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 3) * 53;
            object = this.getOutputType();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasOptions() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 4) * 53;
            object = this.getOptions();
            n11 = ((DescriptorProtos$MethodOptions)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasClientStreaming() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 5) * 53;
            n11 = Internal.hashBoolean(this.getClientStreaming());
            n10 += n11;
        }
        if ((n11 = (int)(this.hasServerStreaming() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 6) * 53;
            n11 = Internal.hashBoolean(this.getServerStreaming());
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$13700().ensureFieldAccessorsInitialized(DescriptorProtos$MethodDescriptorProto.class, DescriptorProtos$MethodDescriptorProto$Builder.class);
    }

    public final boolean isInitialized() {
        DescriptorProtos$MethodOptions descriptorProtos$MethodOptions;
        byte by2 = this.memoizedIsInitialized;
        byte by3 = 1;
        if (by2 == by3) {
            return by3 != 0;
        }
        if (!by2) {
            return false;
        }
        by2 = this.hasOptions();
        if (by2 && !(by2 = (descriptorProtos$MethodOptions = this.getOptions()).isInitialized())) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        this.memoizedIsInitialized = by3;
        return by3 != 0;
    }

    public DescriptorProtos$MethodDescriptorProto$Builder newBuilderForType() {
        return DescriptorProtos$MethodDescriptorProto.newBuilder();
    }

    public DescriptorProtos$MethodDescriptorProto$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        DescriptorProtos$MethodDescriptorProto$Builder descriptorProtos$MethodDescriptorProto$Builder = new DescriptorProtos$MethodDescriptorProto$Builder(generatedMessageV3$BuilderParent, null);
        return descriptorProtos$MethodDescriptorProto$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new DescriptorProtos$MethodDescriptorProto();
        return object;
    }

    public DescriptorProtos$MethodDescriptorProto$Builder toBuilder() {
        DescriptorProtos$MethodDescriptorProtoOrBuilder descriptorProtos$MethodDescriptorProtoOrBuilder = DEFAULT_INSTANCE;
        if (this == descriptorProtos$MethodDescriptorProtoOrBuilder) {
            descriptorProtos$MethodDescriptorProtoOrBuilder = new DescriptorProtos$MethodDescriptorProto$Builder(null);
        } else {
            descriptorProtos$MethodDescriptorProtoOrBuilder = new DescriptorProtos$MethodDescriptorProto$Builder(null);
            descriptorProtos$MethodDescriptorProtoOrBuilder = ((DescriptorProtos$MethodDescriptorProto$Builder)descriptorProtos$MethodDescriptorProtoOrBuilder).mergeFrom(this);
        }
        return descriptorProtos$MethodDescriptorProtoOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        Object object;
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) != 0) {
            object = this.name_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        n10 = this.bitField0_;
        n11 = 2;
        if ((n10 &= n11) != 0) {
            object = this.inputType_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        n10 = this.bitField0_;
        n11 = 4;
        if ((n10 &= n11) != 0) {
            n10 = 3;
            Object object2 = this.outputType_;
            GeneratedMessageV3.writeString(codedOutputStream, n10, object2);
        }
        if ((n10 = this.bitField0_ & 8) != 0) {
            object = this.getOptions();
            codedOutputStream.writeMessage(n11, (MessageLite)object);
        }
        if ((n10 = this.bitField0_ & 0x10) != 0) {
            n10 = 5;
            n11 = (int)(this.clientStreaming_ ? 1 : 0);
            codedOutputStream.writeBool(n10, n11 != 0);
        }
        if ((n10 = this.bitField0_ & 0x20) != 0) {
            n10 = 6;
            n11 = this.serverStreaming_;
            codedOutputStream.writeBool(n10, n11 != 0);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

