/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.DoubleValue$1;
import com.google.protobuf.DoubleValue$Builder;
import com.google.protobuf.DoubleValueOrBuilder;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.GeneratedMessageV3$UnusedPrivateParameter;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import com.google.protobuf.WrappersProto;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

public final class DoubleValue
extends GeneratedMessageV3
implements DoubleValueOrBuilder {
    private static final DoubleValue DEFAULT_INSTANCE;
    private static final Parser PARSER;
    public static final int VALUE_FIELD_NUMBER = 1;
    private static final long serialVersionUID;
    private byte memoizedIsInitialized = (byte)-1;
    private double value_;

    static {
        Object object = new DoubleValue();
        DEFAULT_INSTANCE = object;
        PARSER = object = new DoubleValue$1();
    }

    private DoubleValue() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private DoubleValue(CodedInputStream object, ExtensionRegistryLite object2) {
        this();
        Throwable throwable2;
        Objects.requireNonNull(object2);
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        boolean bl2 = false;
        while (true) {
            if (bl2) {
                this.unknownFields = object = unknownFieldSet$Builder.build();
                this.makeExtensionsImmutable();
                return;
            }
            try {
                try {
                    int n10 = ((CodedInputStream)object).readTag();
                    boolean bl3 = true;
                    if (n10 != 0) {
                        int n11 = 9;
                        if (n10 != n11) {
                            if ((n10 = (int)(this.parseUnknownField((CodedInputStream)object, unknownFieldSet$Builder, (ExtensionRegistryLite)object2, n10) ? 1 : 0)) != 0) continue;
                        } else {
                            double d10;
                            this.value_ = d10 = ((CodedInputStream)object).readDouble();
                            continue;
                        }
                    }
                    bl2 = bl3;
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

    public /* synthetic */ DoubleValue(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DoubleValue$1 doubleValue$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private DoubleValue(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
    }

    public /* synthetic */ DoubleValue(GeneratedMessageV3$Builder generatedMessageV3$Builder, DoubleValue$1 doubleValue$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ double access$302(DoubleValue doubleValue, double d10) {
        doubleValue.value_ = d10;
        return d10;
    }

    public static /* synthetic */ Parser access$400() {
        return PARSER;
    }

    public static DoubleValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return WrappersProto.internal_static_google_protobuf_DoubleValue_descriptor;
    }

    public static DoubleValue$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DoubleValue$Builder newBuilder(DoubleValue doubleValue) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(doubleValue);
    }

    public static DoubleValue of(double d10) {
        return DoubleValue.newBuilder().setValue(d10).build();
    }

    public static DoubleValue parseDelimitedFrom(InputStream inputStream) {
        return (DoubleValue)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static DoubleValue parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DoubleValue)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DoubleValue parseFrom(ByteString byteString) {
        return (DoubleValue)PARSER.parseFrom(byteString);
    }

    public static DoubleValue parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DoubleValue)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DoubleValue parseFrom(CodedInputStream codedInputStream) {
        return (DoubleValue)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static DoubleValue parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DoubleValue)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static DoubleValue parseFrom(InputStream inputStream) {
        return (DoubleValue)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static DoubleValue parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DoubleValue)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DoubleValue parseFrom(ByteBuffer byteBuffer) {
        return (DoubleValue)PARSER.parseFrom(byteBuffer);
    }

    public static DoubleValue parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (DoubleValue)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static DoubleValue parseFrom(byte[] byArray) {
        return (DoubleValue)PARSER.parseFrom(byArray);
    }

    public static DoubleValue parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (DoubleValue)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        double d10;
        long l10;
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        Object object2 = object instanceof DoubleValue;
        if (!object2) {
            return super.equals(object);
        }
        object = (DoubleValue)object;
        double d11 = this.getValue();
        long l11 = Double.doubleToLongBits(d11);
        long l12 = l11 - (l10 = Double.doubleToLongBits(d10 = ((DoubleValue)object).getValue()));
        object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2) {
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

    public DoubleValue getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
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
        double d10 = this.value_;
        double d11 = 0.0;
        double d12 = d10 - d11;
        Object object = d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1);
        if (object != false) {
            object = true;
            n11 = CodedOutputStream.computeDoubleSize((int)object, d10);
            n10 = 0 + n11;
        }
        n11 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n10 += n11;
        return n10;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public double getValue() {
        return this.value_;
    }

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        int n11 = DoubleValue.getDescriptor().hashCode();
        n10 = ((779 + n11) * 37 + 1) * 53;
        n11 = Internal.hashLong(Double.doubleToLongBits(this.getValue()));
        n10 = (n10 + n11) * 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_DoubleValue_fieldAccessorTable.ensureFieldAccessorsInitialized(DoubleValue.class, DoubleValue$Builder.class);
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

    public DoubleValue$Builder newBuilderForType() {
        return DoubleValue.newBuilder();
    }

    public DoubleValue$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        DoubleValue$Builder doubleValue$Builder = new DoubleValue$Builder(generatedMessageV3$BuilderParent, null);
        return doubleValue$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new DoubleValue();
        return object;
    }

    public DoubleValue$Builder toBuilder() {
        DoubleValueOrBuilder doubleValueOrBuilder = DEFAULT_INSTANCE;
        if (this == doubleValueOrBuilder) {
            doubleValueOrBuilder = new DoubleValue$Builder(null);
        } else {
            doubleValueOrBuilder = new DoubleValue$Builder(null);
            doubleValueOrBuilder = ((DoubleValue$Builder)doubleValueOrBuilder).mergeFrom(this);
        }
        return doubleValueOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        double d10 = this.value_;
        double d11 = 0.0;
        double d12 = d10 - d11;
        Object object = d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1);
        if (object != false) {
            object = true;
            codedOutputStream.writeDouble((int)object, d10);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

