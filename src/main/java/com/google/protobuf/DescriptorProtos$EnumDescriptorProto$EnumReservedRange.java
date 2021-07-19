/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto$EnumReservedRange$1;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.GeneratedMessageV3$UnusedPrivateParameter;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

public final class DescriptorProtos$EnumDescriptorProto$EnumReservedRange
extends GeneratedMessageV3
implements DescriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder {
    private static final DescriptorProtos$EnumDescriptorProto$EnumReservedRange DEFAULT_INSTANCE;
    public static final int END_FIELD_NUMBER = 2;
    public static final Parser PARSER;
    public static final int START_FIELD_NUMBER = 1;
    private static final long serialVersionUID;
    private int bitField0_;
    private int end_;
    private byte memoizedIsInitialized = (byte)-1;
    private int start_;

    static {
        Object object = new DescriptorProtos$EnumDescriptorProto$EnumReservedRange();
        DEFAULT_INSTANCE = object;
        PARSER = object = new DescriptorProtos$EnumDescriptorProto$EnumReservedRange$1();
    }

    private DescriptorProtos$EnumDescriptorProto$EnumReservedRange() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private DescriptorProtos$EnumDescriptorProto$EnumReservedRange(CodedInputStream object, ExtensionRegistryLite object2) {
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
                    block11: {
                        int n12 = ((CodedInputStream)object).readTag();
                        n11 = 1;
                        if (n12 != 0) {
                            int n13 = 8;
                            if (n12 != n13) {
                                n13 = 16;
                                if (n12 != n13) {
                                    if ((n12 = (int)(this.parseUnknownField((CodedInputStream)object, unknownFieldSet$Builder, (ExtensionRegistryLite)object2, n12) ? 1 : 0)) != 0) continue;
                                    break block11;
                                } else {
                                    this.bitField0_ = n12 = this.bitField0_ | 2;
                                    this.end_ = n12 = ((CodedInputStream)object).readInt32();
                                    continue;
                                }
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

    public /* synthetic */ DescriptorProtos$EnumDescriptorProto$EnumReservedRange(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DescriptorProtos$1 descriptorProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private DescriptorProtos$EnumDescriptorProto$EnumReservedRange(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
    }

    public /* synthetic */ DescriptorProtos$EnumDescriptorProto$EnumReservedRange(GeneratedMessageV3$Builder generatedMessageV3$Builder, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ int access$10202(DescriptorProtos$EnumDescriptorProto$EnumReservedRange descriptorProtos$EnumDescriptorProto$EnumReservedRange, int n10) {
        descriptorProtos$EnumDescriptorProto$EnumReservedRange.start_ = n10;
        return n10;
    }

    public static /* synthetic */ int access$10302(DescriptorProtos$EnumDescriptorProto$EnumReservedRange descriptorProtos$EnumDescriptorProto$EnumReservedRange, int n10) {
        descriptorProtos$EnumDescriptorProto$EnumReservedRange.end_ = n10;
        return n10;
    }

    public static /* synthetic */ int access$10402(DescriptorProtos$EnumDescriptorProto$EnumReservedRange descriptorProtos$EnumDescriptorProto$EnumReservedRange, int n10) {
        descriptorProtos$EnumDescriptorProto$EnumReservedRange.bitField0_ = n10;
        return n10;
    }

    public static DescriptorProtos$EnumDescriptorProto$EnumReservedRange getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$9700();
    }

    public static DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder newBuilder(DescriptorProtos$EnumDescriptorProto$EnumReservedRange descriptorProtos$EnumDescriptorProto$EnumReservedRange) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$EnumDescriptorProto$EnumReservedRange);
    }

    public static DescriptorProtos$EnumDescriptorProto$EnumReservedRange parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$EnumDescriptorProto$EnumReservedRange)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$EnumDescriptorProto$EnumReservedRange parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumDescriptorProto$EnumReservedRange)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$EnumDescriptorProto$EnumReservedRange parseFrom(ByteString byteString) {
        return (DescriptorProtos$EnumDescriptorProto$EnumReservedRange)PARSER.parseFrom(byteString);
    }

    public static DescriptorProtos$EnumDescriptorProto$EnumReservedRange parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumDescriptorProto$EnumReservedRange)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DescriptorProtos$EnumDescriptorProto$EnumReservedRange parseFrom(CodedInputStream codedInputStream) {
        return (DescriptorProtos$EnumDescriptorProto$EnumReservedRange)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static DescriptorProtos$EnumDescriptorProto$EnumReservedRange parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumDescriptorProto$EnumReservedRange)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$EnumDescriptorProto$EnumReservedRange parseFrom(InputStream inputStream) {
        return (DescriptorProtos$EnumDescriptorProto$EnumReservedRange)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$EnumDescriptorProto$EnumReservedRange parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumDescriptorProto$EnumReservedRange)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$EnumDescriptorProto$EnumReservedRange parseFrom(ByteBuffer byteBuffer) {
        return (DescriptorProtos$EnumDescriptorProto$EnumReservedRange)PARSER.parseFrom(byteBuffer);
    }

    public static DescriptorProtos$EnumDescriptorProto$EnumReservedRange parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumDescriptorProto$EnumReservedRange)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static DescriptorProtos$EnumDescriptorProto$EnumReservedRange parseFrom(byte[] byArray) {
        return (DescriptorProtos$EnumDescriptorProto$EnumReservedRange)PARSER.parseFrom(byArray);
    }

    public static DescriptorProtos$EnumDescriptorProto$EnumReservedRange parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumDescriptorProto$EnumReservedRange)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        int n10;
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        int n11 = object instanceof DescriptorProtos$EnumDescriptorProto$EnumReservedRange;
        if (n11 == 0) {
            return super.equals(object);
        }
        object = (DescriptorProtos$EnumDescriptorProto$EnumReservedRange)object;
        n11 = this.hasStart();
        if (n11 != (n10 = ((DescriptorProtos$EnumDescriptorProto$EnumReservedRange)object).hasStart())) {
            return false;
        }
        n11 = this.hasStart();
        if (n11 != 0 && (n11 = this.getStart()) != (n10 = ((DescriptorProtos$EnumDescriptorProto$EnumReservedRange)object).getStart())) {
            return false;
        }
        n11 = (int)(this.hasEnd() ? 1 : 0);
        if (n11 != (n10 = (int)(((DescriptorProtos$EnumDescriptorProto$EnumReservedRange)object).hasEnd() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasEnd() ? 1 : 0);
        if (n11 != 0 && (n11 = this.getEnd()) != (n10 = ((DescriptorProtos$EnumDescriptorProto$EnumReservedRange)object).getEnd())) {
            return false;
        }
        UnknownFieldSet unknownFieldSet = this.unknownFields;
        object = ((GeneratedMessageV3)object).unknownFields;
        boolean bl3 = unknownFieldSet.equals(object);
        if (!bl3) {
            return false;
        }
        return bl2;
    }

    public DescriptorProtos$EnumDescriptorProto$EnumReservedRange getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public int getEnd() {
        return this.end_;
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
        Descriptors$Descriptor descriptors$Descriptor = DescriptorProtos$EnumDescriptorProto$EnumReservedRange.getDescriptor();
        int n11 = descriptors$Descriptor.hashCode();
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
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$9800().ensureFieldAccessorsInitialized(DescriptorProtos$EnumDescriptorProto$EnumReservedRange.class, DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder.class);
    }

    public final boolean isInitialized() {
        byte by2 = this.memoizedIsInitialized;
        byte by3 = 1;
        if (by2 == by3) {
            return by3 != 0;
        }
        if (!by2) {
            return false;
        }
        this.memoizedIsInitialized = by3;
        return by3 != 0;
    }

    public DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder newBuilderForType() {
        return DescriptorProtos$EnumDescriptorProto$EnumReservedRange.newBuilder();
    }

    public DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder descriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder = new DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder(generatedMessageV3$BuilderParent, null);
        return descriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new DescriptorProtos$EnumDescriptorProto$EnumReservedRange();
        return object;
    }

    public DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder toBuilder() {
        DescriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder descriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder = DEFAULT_INSTANCE;
        if (this == descriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder) {
            descriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder = new DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder(null);
        } else {
            descriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder = new DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder(null);
            descriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder = ((DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder)descriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder).mergeFrom(this);
        }
        return descriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder;
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
        this.unknownFields.writeTo(codedOutputStream);
    }
}

