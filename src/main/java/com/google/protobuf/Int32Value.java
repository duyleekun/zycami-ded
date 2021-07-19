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
import com.google.protobuf.Int32Value$1;
import com.google.protobuf.Int32Value$Builder;
import com.google.protobuf.Int32ValueOrBuilder;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import com.google.protobuf.WrappersProto;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

public final class Int32Value
extends GeneratedMessageV3
implements Int32ValueOrBuilder {
    private static final Int32Value DEFAULT_INSTANCE;
    private static final Parser PARSER;
    public static final int VALUE_FIELD_NUMBER = 1;
    private static final long serialVersionUID;
    private byte memoizedIsInitialized = (byte)-1;
    private int value_;

    static {
        Object object = new Int32Value();
        DEFAULT_INSTANCE = object;
        PARSER = object = new Int32Value$1();
    }

    private Int32Value() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Int32Value(CodedInputStream object, ExtensionRegistryLite object2) {
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
                            this.value_ = n10 = ((CodedInputStream)object).readInt32();
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

    public /* synthetic */ Int32Value(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Int32Value$1 int32Value$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private Int32Value(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
    }

    public /* synthetic */ Int32Value(GeneratedMessageV3$Builder generatedMessageV3$Builder, Int32Value$1 int32Value$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ int access$302(Int32Value int32Value, int n10) {
        int32Value.value_ = n10;
        return n10;
    }

    public static /* synthetic */ Parser access$400() {
        return PARSER;
    }

    public static Int32Value getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return WrappersProto.internal_static_google_protobuf_Int32Value_descriptor;
    }

    public static Int32Value$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Int32Value$Builder newBuilder(Int32Value int32Value) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(int32Value);
    }

    public static Int32Value of(int n10) {
        return Int32Value.newBuilder().setValue(n10).build();
    }

    public static Int32Value parseDelimitedFrom(InputStream inputStream) {
        return (Int32Value)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Int32Value parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Int32Value)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Int32Value parseFrom(ByteString byteString) {
        return (Int32Value)PARSER.parseFrom(byteString);
    }

    public static Int32Value parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Int32Value)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Int32Value parseFrom(CodedInputStream codedInputStream) {
        return (Int32Value)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Int32Value parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Int32Value)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Int32Value parseFrom(InputStream inputStream) {
        return (Int32Value)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Int32Value parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Int32Value)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Int32Value parseFrom(ByteBuffer byteBuffer) {
        return (Int32Value)PARSER.parseFrom(byteBuffer);
    }

    public static Int32Value parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Int32Value)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Int32Value parseFrom(byte[] byArray) {
        return (Int32Value)PARSER.parseFrom(byArray);
    }

    public static Int32Value parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (Int32Value)PARSER.parseFrom(byArray, extensionRegistryLite);
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
        int n11 = object instanceof Int32Value;
        if (n11 == 0) {
            return super.equals(object);
        }
        object = (Int32Value)object;
        n11 = this.getValue();
        if (n11 != (n10 = ((Int32Value)object).getValue())) {
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

    public Int32Value getDefaultInstanceForType() {
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
        n11 = this.value_;
        if (n11 != 0) {
            int n12 = 1;
            n11 = CodedOutputStream.computeInt32Size(n12, n11);
            n10 = 0 + n11;
        }
        n11 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n10 += n11;
        return n10;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public int getValue() {
        return this.value_;
    }

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        int n11 = Int32Value.getDescriptor().hashCode();
        n10 = ((779 + n11) * 37 + 1) * 53;
        n11 = this.getValue();
        n10 = (n10 + n11) * 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_Int32Value_fieldAccessorTable.ensureFieldAccessorsInitialized(Int32Value.class, Int32Value$Builder.class);
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

    public Int32Value$Builder newBuilderForType() {
        return Int32Value.newBuilder();
    }

    public Int32Value$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        Int32Value$Builder int32Value$Builder = new Int32Value$Builder(generatedMessageV3$BuilderParent, null);
        return int32Value$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new Int32Value();
        return object;
    }

    public Int32Value$Builder toBuilder() {
        Int32ValueOrBuilder int32ValueOrBuilder = DEFAULT_INSTANCE;
        if (this == int32ValueOrBuilder) {
            int32ValueOrBuilder = new Int32Value$Builder(null);
        } else {
            int32ValueOrBuilder = new Int32Value$Builder(null);
            int32ValueOrBuilder = ((Int32Value$Builder)int32ValueOrBuilder).mergeFrom(this);
        }
        return int32ValueOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        int n10 = this.value_;
        if (n10 != 0) {
            int n11 = 1;
            codedOutputStream.writeInt32(n11, n10);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

