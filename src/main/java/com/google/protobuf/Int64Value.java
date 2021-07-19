/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.GeneratedMessageV3$UnusedPrivateParameter;
import com.google.protobuf.Int64Value$1;
import com.google.protobuf.Int64Value$Builder;
import com.google.protobuf.Int64ValueOrBuilder;
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

public final class Int64Value
extends GeneratedMessageV3
implements Int64ValueOrBuilder {
    private static final Int64Value DEFAULT_INSTANCE;
    private static final Parser PARSER;
    public static final int VALUE_FIELD_NUMBER = 1;
    private static final long serialVersionUID;
    private byte memoizedIsInitialized = (byte)-1;
    private long value_;

    static {
        Object object = new Int64Value();
        DEFAULT_INSTANCE = object;
        PARSER = object = new Int64Value$1();
    }

    private Int64Value() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Int64Value(CodedInputStream object, ExtensionRegistryLite object2) {
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
                        int n11 = 8;
                        if (n10 != n11) {
                            if ((n10 = (int)(this.parseUnknownField((CodedInputStream)object, unknownFieldSet$Builder, (ExtensionRegistryLite)object2, n10) ? 1 : 0)) != 0) continue;
                        } else {
                            long l10;
                            this.value_ = l10 = ((CodedInputStream)object).readInt64();
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

    public /* synthetic */ Int64Value(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Int64Value$1 int64Value$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private Int64Value(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
    }

    public /* synthetic */ Int64Value(GeneratedMessageV3$Builder generatedMessageV3$Builder, Int64Value$1 int64Value$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ long access$302(Int64Value int64Value, long l10) {
        int64Value.value_ = l10;
        return l10;
    }

    public static /* synthetic */ Parser access$400() {
        return PARSER;
    }

    public static Int64Value getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return WrappersProto.internal_static_google_protobuf_Int64Value_descriptor;
    }

    public static Int64Value$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Int64Value$Builder newBuilder(Int64Value int64Value) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(int64Value);
    }

    public static Int64Value of(long l10) {
        return Int64Value.newBuilder().setValue(l10).build();
    }

    public static Int64Value parseDelimitedFrom(InputStream inputStream) {
        return (Int64Value)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Int64Value parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Int64Value)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Int64Value parseFrom(ByteString byteString) {
        return (Int64Value)PARSER.parseFrom(byteString);
    }

    public static Int64Value parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Int64Value)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Int64Value parseFrom(CodedInputStream codedInputStream) {
        return (Int64Value)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Int64Value parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Int64Value)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Int64Value parseFrom(InputStream inputStream) {
        return (Int64Value)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Int64Value parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Int64Value)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Int64Value parseFrom(ByteBuffer byteBuffer) {
        return (Int64Value)PARSER.parseFrom(byteBuffer);
    }

    public static Int64Value parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Int64Value)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Int64Value parseFrom(byte[] byArray) {
        return (Int64Value)PARSER.parseFrom(byArray);
    }

    public static Int64Value parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (Int64Value)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        long l10;
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        Object object2 = object instanceof Int64Value;
        if (!object2) {
            return super.equals(object);
        }
        object = (Int64Value)object;
        long l11 = this.getValue();
        long l12 = l11 - (l10 = ((Int64Value)object).getValue());
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

    public Int64Value getDefaultInstanceForType() {
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
        long l10 = this.value_;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            object = 1;
            n11 = CodedOutputStream.computeInt64Size((int)object, l10);
            n10 = 0 + n11;
        }
        n11 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n10 += n11;
        return n10;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public long getValue() {
        return this.value_;
    }

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        int n11 = Int64Value.getDescriptor().hashCode();
        n10 = ((779 + n11) * 37 + 1) * 53;
        n11 = Internal.hashLong(this.getValue());
        n10 = (n10 + n11) * 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_Int64Value_fieldAccessorTable.ensureFieldAccessorsInitialized(Int64Value.class, Int64Value$Builder.class);
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

    public Int64Value$Builder newBuilderForType() {
        return Int64Value.newBuilder();
    }

    public Int64Value$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        Int64Value$Builder int64Value$Builder = new Int64Value$Builder(generatedMessageV3$BuilderParent, null);
        return int64Value$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new Int64Value();
        return object;
    }

    public Int64Value$Builder toBuilder() {
        Int64ValueOrBuilder int64ValueOrBuilder = DEFAULT_INSTANCE;
        if (this == int64ValueOrBuilder) {
            int64ValueOrBuilder = new Int64Value$Builder(null);
        } else {
            int64ValueOrBuilder = new Int64Value$Builder(null);
            int64ValueOrBuilder = ((Int64Value$Builder)int64ValueOrBuilder).mergeFrom(this);
        }
        return int64ValueOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        long l10 = this.value_;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            object = 1;
            codedOutputStream.writeInt64((int)object, l10);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

