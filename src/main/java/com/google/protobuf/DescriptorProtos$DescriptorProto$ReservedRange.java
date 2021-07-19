/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRange$1;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRange$Builder;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder;
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

public final class DescriptorProtos$DescriptorProto$ReservedRange
extends GeneratedMessageV3
implements DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder {
    private static final DescriptorProtos$DescriptorProto$ReservedRange DEFAULT_INSTANCE;
    public static final int END_FIELD_NUMBER = 2;
    public static final Parser PARSER;
    public static final int START_FIELD_NUMBER = 1;
    private static final long serialVersionUID;
    private int bitField0_;
    private int end_;
    private byte memoizedIsInitialized = (byte)-1;
    private int start_;

    static {
        Object object = new DescriptorProtos$DescriptorProto$ReservedRange();
        DEFAULT_INSTANCE = object;
        PARSER = object = new DescriptorProtos$DescriptorProto$ReservedRange$1();
    }

    private DescriptorProtos$DescriptorProto$ReservedRange() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private DescriptorProtos$DescriptorProto$ReservedRange(CodedInputStream object, ExtensionRegistryLite object2) {
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

    public /* synthetic */ DescriptorProtos$DescriptorProto$ReservedRange(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DescriptorProtos$1 descriptorProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private DescriptorProtos$DescriptorProto$ReservedRange(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
    }

    public /* synthetic */ DescriptorProtos$DescriptorProto$ReservedRange(GeneratedMessageV3$Builder generatedMessageV3$Builder, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ int access$4302(DescriptorProtos$DescriptorProto$ReservedRange descriptorProtos$DescriptorProto$ReservedRange, int n10) {
        descriptorProtos$DescriptorProto$ReservedRange.start_ = n10;
        return n10;
    }

    public static /* synthetic */ int access$4402(DescriptorProtos$DescriptorProto$ReservedRange descriptorProtos$DescriptorProto$ReservedRange, int n10) {
        descriptorProtos$DescriptorProto$ReservedRange.end_ = n10;
        return n10;
    }

    public static /* synthetic */ int access$4502(DescriptorProtos$DescriptorProto$ReservedRange descriptorProtos$DescriptorProto$ReservedRange, int n10) {
        descriptorProtos$DescriptorProto$ReservedRange.bitField0_ = n10;
        return n10;
    }

    public static DescriptorProtos$DescriptorProto$ReservedRange getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$3800();
    }

    public static DescriptorProtos$DescriptorProto$ReservedRange$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DescriptorProtos$DescriptorProto$ReservedRange$Builder newBuilder(DescriptorProtos$DescriptorProto$ReservedRange descriptorProtos$DescriptorProto$ReservedRange) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$DescriptorProto$ReservedRange);
    }

    public static DescriptorProtos$DescriptorProto$ReservedRange parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$DescriptorProto$ReservedRange)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$DescriptorProto$ReservedRange parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$DescriptorProto$ReservedRange)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$DescriptorProto$ReservedRange parseFrom(ByteString byteString) {
        return (DescriptorProtos$DescriptorProto$ReservedRange)PARSER.parseFrom(byteString);
    }

    public static DescriptorProtos$DescriptorProto$ReservedRange parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$DescriptorProto$ReservedRange)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DescriptorProtos$DescriptorProto$ReservedRange parseFrom(CodedInputStream codedInputStream) {
        return (DescriptorProtos$DescriptorProto$ReservedRange)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static DescriptorProtos$DescriptorProto$ReservedRange parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$DescriptorProto$ReservedRange)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$DescriptorProto$ReservedRange parseFrom(InputStream inputStream) {
        return (DescriptorProtos$DescriptorProto$ReservedRange)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$DescriptorProto$ReservedRange parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$DescriptorProto$ReservedRange)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$DescriptorProto$ReservedRange parseFrom(ByteBuffer byteBuffer) {
        return (DescriptorProtos$DescriptorProto$ReservedRange)PARSER.parseFrom(byteBuffer);
    }

    public static DescriptorProtos$DescriptorProto$ReservedRange parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$DescriptorProto$ReservedRange)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static DescriptorProtos$DescriptorProto$ReservedRange parseFrom(byte[] byArray) {
        return (DescriptorProtos$DescriptorProto$ReservedRange)PARSER.parseFrom(byArray);
    }

    public static DescriptorProtos$DescriptorProto$ReservedRange parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$DescriptorProto$ReservedRange)PARSER.parseFrom(byArray, extensionRegistryLite);
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
        int n11 = object instanceof DescriptorProtos$DescriptorProto$ReservedRange;
        if (n11 == 0) {
            return super.equals(object);
        }
        object = (DescriptorProtos$DescriptorProto$ReservedRange)object;
        n11 = this.hasStart();
        if (n11 != (n10 = ((DescriptorProtos$DescriptorProto$ReservedRange)object).hasStart())) {
            return false;
        }
        n11 = this.hasStart();
        if (n11 != 0 && (n11 = this.getStart()) != (n10 = ((DescriptorProtos$DescriptorProto$ReservedRange)object).getStart())) {
            return false;
        }
        n11 = (int)(this.hasEnd() ? 1 : 0);
        if (n11 != (n10 = (int)(((DescriptorProtos$DescriptorProto$ReservedRange)object).hasEnd() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasEnd() ? 1 : 0);
        if (n11 != 0 && (n11 = this.getEnd()) != (n10 = ((DescriptorProtos$DescriptorProto$ReservedRange)object).getEnd())) {
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

    public DescriptorProtos$DescriptorProto$ReservedRange getDefaultInstanceForType() {
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
        Descriptors$Descriptor descriptors$Descriptor = DescriptorProtos$DescriptorProto$ReservedRange.getDescriptor();
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
        return DescriptorProtos.access$3900().ensureFieldAccessorsInitialized(DescriptorProtos$DescriptorProto$ReservedRange.class, DescriptorProtos$DescriptorProto$ReservedRange$Builder.class);
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

    public DescriptorProtos$DescriptorProto$ReservedRange$Builder newBuilderForType() {
        return DescriptorProtos$DescriptorProto$ReservedRange.newBuilder();
    }

    public DescriptorProtos$DescriptorProto$ReservedRange$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        DescriptorProtos$DescriptorProto$ReservedRange$Builder descriptorProtos$DescriptorProto$ReservedRange$Builder = new DescriptorProtos$DescriptorProto$ReservedRange$Builder(generatedMessageV3$BuilderParent, null);
        return descriptorProtos$DescriptorProto$ReservedRange$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new DescriptorProtos$DescriptorProto$ReservedRange();
        return object;
    }

    public DescriptorProtos$DescriptorProto$ReservedRange$Builder toBuilder() {
        DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder descriptorProtos$DescriptorProto$ReservedRangeOrBuilder = DEFAULT_INSTANCE;
        if (this == descriptorProtos$DescriptorProto$ReservedRangeOrBuilder) {
            descriptorProtos$DescriptorProto$ReservedRangeOrBuilder = new DescriptorProtos$DescriptorProto$ReservedRange$Builder(null);
        } else {
            descriptorProtos$DescriptorProto$ReservedRangeOrBuilder = new DescriptorProtos$DescriptorProto$ReservedRange$Builder(null);
            descriptorProtos$DescriptorProto$ReservedRangeOrBuilder = ((DescriptorProtos$DescriptorProto$ReservedRange$Builder)descriptorProtos$DescriptorProto$ReservedRangeOrBuilder).mergeFrom(this);
        }
        return descriptorProtos$DescriptorProto$ReservedRangeOrBuilder;
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

