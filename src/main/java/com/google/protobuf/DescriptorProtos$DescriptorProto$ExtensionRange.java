/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRange$1;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRange$Builder;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder;
import com.google.protobuf.DescriptorProtos$ExtensionRangeOptions;
import com.google.protobuf.DescriptorProtos$ExtensionRangeOptions$Builder;
import com.google.protobuf.DescriptorProtos$ExtensionRangeOptionsOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.GeneratedMessageV3$UnusedPrivateParameter;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

public final class DescriptorProtos$DescriptorProto$ExtensionRange
extends GeneratedMessageV3
implements DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder {
    private static final DescriptorProtos$DescriptorProto$ExtensionRange DEFAULT_INSTANCE;
    public static final int END_FIELD_NUMBER = 2;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    public static final Parser PARSER;
    public static final int START_FIELD_NUMBER = 1;
    private static final long serialVersionUID;
    private int bitField0_;
    private int end_;
    private byte memoizedIsInitialized = (byte)-1;
    private DescriptorProtos$ExtensionRangeOptions options_;
    private int start_;

    static {
        Object object = new DescriptorProtos$DescriptorProto$ExtensionRange();
        DEFAULT_INSTANCE = object;
        PARSER = object = new DescriptorProtos$DescriptorProto$ExtensionRange$1();
    }

    private DescriptorProtos$DescriptorProto$ExtensionRange() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private DescriptorProtos$DescriptorProto$ExtensionRange(CodedInputStream object, ExtensionRegistryLite object2) {
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
                    block14: {
                        int n12 = ((CodedInputStream)object).readTag();
                        n11 = 1;
                        if (n12 != 0) {
                            int n13 = 8;
                            if (n12 != n13) {
                                n13 = 16;
                                if (n12 != n13) {
                                    n13 = 26;
                                    if (n12 != n13) {
                                        if ((n12 = (int)(this.parseUnknownField((CodedInputStream)object, unknownFieldSet$Builder, (ExtensionRegistryLite)object2, n12) ? 1 : 0)) != 0) continue;
                                        break block14;
                                    } else {
                                        n12 = 0;
                                        DescriptorProtos$ExtensionRangeOptionsOrBuilder descriptorProtos$ExtensionRangeOptionsOrBuilder = null;
                                        n11 = this.bitField0_ & 4;
                                        if (n11 != 0) {
                                            descriptorProtos$ExtensionRangeOptionsOrBuilder = this.options_;
                                            descriptorProtos$ExtensionRangeOptionsOrBuilder = ((DescriptorProtos$ExtensionRangeOptions)descriptorProtos$ExtensionRangeOptionsOrBuilder).toBuilder();
                                        }
                                        Object object3 = DescriptorProtos$ExtensionRangeOptions.PARSER;
                                        object3 = ((CodedInputStream)object).readMessage((Parser)object3, (ExtensionRegistryLite)object2);
                                        this.options_ = object3 = (DescriptorProtos$ExtensionRangeOptions)object3;
                                        if (descriptorProtos$ExtensionRangeOptionsOrBuilder != null) {
                                            ((DescriptorProtos$ExtensionRangeOptions$Builder)descriptorProtos$ExtensionRangeOptionsOrBuilder).mergeFrom((DescriptorProtos$ExtensionRangeOptions)object3);
                                            descriptorProtos$ExtensionRangeOptionsOrBuilder = ((DescriptorProtos$ExtensionRangeOptions$Builder)descriptorProtos$ExtensionRangeOptionsOrBuilder).buildPartial();
                                            this.options_ = descriptorProtos$ExtensionRangeOptionsOrBuilder;
                                        }
                                        this.bitField0_ = n12 = this.bitField0_ | 4;
                                        continue;
                                    }
                                }
                                this.bitField0_ = n12 = this.bitField0_ | 2;
                                this.end_ = n12 = ((CodedInputStream)object).readInt32();
                                continue;
                            }
                            this.bitField0_ = n12 = this.bitField0_ | n11;
                            this.start_ = n12 = ((CodedInputStream)object).readInt32();
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

    public /* synthetic */ DescriptorProtos$DescriptorProto$ExtensionRange(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DescriptorProtos$1 descriptorProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private DescriptorProtos$DescriptorProto$ExtensionRange(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
    }

    public /* synthetic */ DescriptorProtos$DescriptorProto$ExtensionRange(GeneratedMessageV3$Builder generatedMessageV3$Builder, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ int access$3302(DescriptorProtos$DescriptorProto$ExtensionRange descriptorProtos$DescriptorProto$ExtensionRange, int n10) {
        descriptorProtos$DescriptorProto$ExtensionRange.start_ = n10;
        return n10;
    }

    public static /* synthetic */ int access$3402(DescriptorProtos$DescriptorProto$ExtensionRange descriptorProtos$DescriptorProto$ExtensionRange, int n10) {
        descriptorProtos$DescriptorProto$ExtensionRange.end_ = n10;
        return n10;
    }

    public static /* synthetic */ DescriptorProtos$ExtensionRangeOptions access$3502(DescriptorProtos$DescriptorProto$ExtensionRange descriptorProtos$DescriptorProto$ExtensionRange, DescriptorProtos$ExtensionRangeOptions descriptorProtos$ExtensionRangeOptions) {
        descriptorProtos$DescriptorProto$ExtensionRange.options_ = descriptorProtos$ExtensionRangeOptions;
        return descriptorProtos$ExtensionRangeOptions;
    }

    public static /* synthetic */ int access$3602(DescriptorProtos$DescriptorProto$ExtensionRange descriptorProtos$DescriptorProto$ExtensionRange, int n10) {
        descriptorProtos$DescriptorProto$ExtensionRange.bitField0_ = n10;
        return n10;
    }

    public static DescriptorProtos$DescriptorProto$ExtensionRange getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$2800();
    }

    public static DescriptorProtos$DescriptorProto$ExtensionRange$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DescriptorProtos$DescriptorProto$ExtensionRange$Builder newBuilder(DescriptorProtos$DescriptorProto$ExtensionRange descriptorProtos$DescriptorProto$ExtensionRange) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$DescriptorProto$ExtensionRange);
    }

    public static DescriptorProtos$DescriptorProto$ExtensionRange parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$DescriptorProto$ExtensionRange)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$DescriptorProto$ExtensionRange parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$DescriptorProto$ExtensionRange)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$DescriptorProto$ExtensionRange parseFrom(ByteString byteString) {
        return (DescriptorProtos$DescriptorProto$ExtensionRange)PARSER.parseFrom(byteString);
    }

    public static DescriptorProtos$DescriptorProto$ExtensionRange parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$DescriptorProto$ExtensionRange)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DescriptorProtos$DescriptorProto$ExtensionRange parseFrom(CodedInputStream codedInputStream) {
        return (DescriptorProtos$DescriptorProto$ExtensionRange)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static DescriptorProtos$DescriptorProto$ExtensionRange parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$DescriptorProto$ExtensionRange)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$DescriptorProto$ExtensionRange parseFrom(InputStream inputStream) {
        return (DescriptorProtos$DescriptorProto$ExtensionRange)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$DescriptorProto$ExtensionRange parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$DescriptorProto$ExtensionRange)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$DescriptorProto$ExtensionRange parseFrom(ByteBuffer byteBuffer) {
        return (DescriptorProtos$DescriptorProto$ExtensionRange)PARSER.parseFrom(byteBuffer);
    }

    public static DescriptorProtos$DescriptorProto$ExtensionRange parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$DescriptorProto$ExtensionRange)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static DescriptorProtos$DescriptorProto$ExtensionRange parseFrom(byte[] byArray) {
        return (DescriptorProtos$DescriptorProto$ExtensionRange)PARSER.parseFrom(byArray);
    }

    public static DescriptorProtos$DescriptorProto$ExtensionRange parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$DescriptorProto$ExtensionRange)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        DescriptorProtos$ExtensionRangeOptions descriptorProtos$ExtensionRangeOptions;
        MessageLite messageLite;
        int n10;
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        int n11 = object instanceof DescriptorProtos$DescriptorProto$ExtensionRange;
        if (n11 == 0) {
            return super.equals(object);
        }
        object = (DescriptorProtos$DescriptorProto$ExtensionRange)object;
        n11 = this.hasStart();
        if (n11 != (n10 = ((DescriptorProtos$DescriptorProto$ExtensionRange)object).hasStart())) {
            return false;
        }
        n11 = this.hasStart();
        if (n11 != 0 && (n11 = this.getStart()) != (n10 = ((DescriptorProtos$DescriptorProto$ExtensionRange)object).getStart())) {
            return false;
        }
        n11 = (int)(this.hasEnd() ? 1 : 0);
        if (n11 != (n10 = (int)(((DescriptorProtos$DescriptorProto$ExtensionRange)object).hasEnd() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasEnd() ? 1 : 0);
        if (n11 != 0 && (n11 = this.getEnd()) != (n10 = ((DescriptorProtos$DescriptorProto$ExtensionRange)object).getEnd())) {
            return false;
        }
        n11 = (int)(this.hasOptions() ? 1 : 0);
        if (n11 != (n10 = (int)(((DescriptorProtos$DescriptorProto$ExtensionRange)object).hasOptions() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasOptions() ? 1 : 0);
        if (n11 != 0 && (n11 = (int)(((DescriptorProtos$ExtensionRangeOptions)(messageLite = this.getOptions())).equals(descriptorProtos$ExtensionRangeOptions = ((DescriptorProtos$DescriptorProto$ExtensionRange)object).getOptions()) ? 1 : 0)) == 0) {
            return false;
        }
        messageLite = this.unknownFields;
        object = ((GeneratedMessageV3)object).unknownFields;
        boolean bl3 = ((UnknownFieldSet)messageLite).equals(object);
        if (!bl3) {
            return false;
        }
        return bl2;
    }

    public DescriptorProtos$DescriptorProto$ExtensionRange getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public int getEnd() {
        return this.end_;
    }

    public DescriptorProtos$ExtensionRangeOptions getOptions() {
        DescriptorProtos$ExtensionRangeOptions descriptorProtos$ExtensionRangeOptions = this.options_;
        if (descriptorProtos$ExtensionRangeOptions == null) {
            descriptorProtos$ExtensionRangeOptions = DescriptorProtos$ExtensionRangeOptions.getDefaultInstance();
        }
        return descriptorProtos$ExtensionRangeOptions;
    }

    public DescriptorProtos$ExtensionRangeOptionsOrBuilder getOptionsOrBuilder() {
        DescriptorProtos$ExtensionRangeOptions descriptorProtos$ExtensionRangeOptions = this.options_;
        if (descriptorProtos$ExtensionRangeOptions == null) {
            descriptorProtos$ExtensionRangeOptions = DescriptorProtos$ExtensionRangeOptions.getDefaultInstance();
        }
        return descriptorProtos$ExtensionRangeOptions;
    }

    public Parser getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int n10 = this.memoizedSize;
        int n11 = -1;
        if (n10 != n11) {
            return n10;
        }
        n10 = 0;
        n11 = this.bitField0_;
        int n12 = 1;
        if ((n11 &= n12) != 0) {
            n11 = this.start_;
            n11 = CodedOutputStream.computeInt32Size(n12, n11);
            n10 = 0 + n11;
        }
        n11 = this.bitField0_;
        n12 = 2;
        if ((n11 &= n12) != 0) {
            n11 = this.end_;
            n11 = CodedOutputStream.computeInt32Size(n12, n11);
            n10 += n11;
        }
        if ((n11 = this.bitField0_ & 4) != 0) {
            DescriptorProtos$ExtensionRangeOptions descriptorProtos$ExtensionRangeOptions = this.getOptions();
            n11 = CodedOutputStream.computeMessageSize(3, descriptorProtos$ExtensionRangeOptions);
            n10 += n11;
        }
        n11 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n10 += n11;
        return n10;
    }

    public int getStart() {
        return this.start_;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public boolean hasEnd() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasOptions() {
        int n10 = this.bitField0_ & 4;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasStart() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        Object object = DescriptorProtos$DescriptorProto$ExtensionRange.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = (int)(this.hasStart() ? 1 : 0);
        if (n11 != 0) {
            n10 = (n10 * 37 + 1) * 53;
            n11 = this.getStart();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasEnd() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 2) * 53;
            n11 = this.getEnd();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasOptions() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 3) * 53;
            object = this.getOptions();
            n11 = ((DescriptorProtos$ExtensionRangeOptions)object).hashCode();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$2900().ensureFieldAccessorsInitialized(DescriptorProtos$DescriptorProto$ExtensionRange.class, DescriptorProtos$DescriptorProto$ExtensionRange$Builder.class);
    }

    public final boolean isInitialized() {
        DescriptorProtos$ExtensionRangeOptions descriptorProtos$ExtensionRangeOptions;
        byte by2 = this.memoizedIsInitialized;
        byte by3 = 1;
        if (by2 == by3) {
            return by3 != 0;
        }
        if (!by2) {
            return false;
        }
        by2 = this.hasOptions();
        if (by2 && !(by2 = (descriptorProtos$ExtensionRangeOptions = this.getOptions()).isInitialized())) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        this.memoizedIsInitialized = by3;
        return by3 != 0;
    }

    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder newBuilderForType() {
        return DescriptorProtos$DescriptorProto$ExtensionRange.newBuilder();
    }

    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        DescriptorProtos$DescriptorProto$ExtensionRange$Builder descriptorProtos$DescriptorProto$ExtensionRange$Builder = new DescriptorProtos$DescriptorProto$ExtensionRange$Builder(generatedMessageV3$BuilderParent, null);
        return descriptorProtos$DescriptorProto$ExtensionRange$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new DescriptorProtos$DescriptorProto$ExtensionRange();
        return object;
    }

    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder toBuilder() {
        DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder descriptorProtos$DescriptorProto$ExtensionRangeOrBuilder = DEFAULT_INSTANCE;
        if (this == descriptorProtos$DescriptorProto$ExtensionRangeOrBuilder) {
            descriptorProtos$DescriptorProto$ExtensionRangeOrBuilder = new DescriptorProtos$DescriptorProto$ExtensionRange$Builder(null);
        } else {
            descriptorProtos$DescriptorProto$ExtensionRangeOrBuilder = new DescriptorProtos$DescriptorProto$ExtensionRange$Builder(null);
            descriptorProtos$DescriptorProto$ExtensionRangeOrBuilder = ((DescriptorProtos$DescriptorProto$ExtensionRange$Builder)descriptorProtos$DescriptorProto$ExtensionRangeOrBuilder).mergeFrom(this);
        }
        return descriptorProtos$DescriptorProto$ExtensionRangeOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) != 0) {
            n10 = this.start_;
            codedOutputStream.writeInt32(n11, n10);
        }
        n10 = this.bitField0_;
        n11 = 2;
        if ((n10 &= n11) != 0) {
            n10 = this.end_;
            codedOutputStream.writeInt32(n11, n10);
        }
        if ((n10 = this.bitField0_ & 4) != 0) {
            n10 = 3;
            DescriptorProtos$ExtensionRangeOptions descriptorProtos$ExtensionRangeOptions = this.getOptions();
            codedOutputStream.writeMessage(n10, descriptorProtos$ExtensionRangeOptions);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

