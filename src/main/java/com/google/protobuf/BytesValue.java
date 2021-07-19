/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.BytesValue$1;
import com.google.protobuf.BytesValue$Builder;
import com.google.protobuf.BytesValueOrBuilder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
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
import com.google.protobuf.WrappersProto;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

public final class BytesValue
extends GeneratedMessageV3
implements BytesValueOrBuilder {
    private static final BytesValue DEFAULT_INSTANCE;
    private static final Parser PARSER;
    public static final int VALUE_FIELD_NUMBER = 1;
    private static final long serialVersionUID;
    private byte memoizedIsInitialized = (byte)-1;
    private ByteString value_;

    static {
        Object object = new BytesValue();
        DEFAULT_INSTANCE = object;
        PARSER = object = new BytesValue$1();
    }

    private BytesValue() {
        ByteString byteString;
        this.value_ = byteString = ByteString.EMPTY;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private BytesValue(CodedInputStream object, ExtensionRegistryLite object2) {
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
                        int n11 = 10;
                        if (n10 != n11) {
                            if ((n10 = (int)(this.parseUnknownField((CodedInputStream)object, unknownFieldSet$Builder, (ExtensionRegistryLite)object2, n10) ? 1 : 0)) != 0) continue;
                        } else {
                            ByteString byteString;
                            this.value_ = byteString = ((CodedInputStream)object).readBytes();
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

    public /* synthetic */ BytesValue(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, BytesValue$1 bytesValue$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private BytesValue(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
    }

    public /* synthetic */ BytesValue(GeneratedMessageV3$Builder generatedMessageV3$Builder, BytesValue$1 bytesValue$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ ByteString access$302(BytesValue bytesValue, ByteString byteString) {
        bytesValue.value_ = byteString;
        return byteString;
    }

    public static /* synthetic */ Parser access$400() {
        return PARSER;
    }

    public static BytesValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return WrappersProto.internal_static_google_protobuf_BytesValue_descriptor;
    }

    public static BytesValue$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static BytesValue$Builder newBuilder(BytesValue bytesValue) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(bytesValue);
    }

    public static BytesValue of(ByteString byteString) {
        return BytesValue.newBuilder().setValue(byteString).build();
    }

    public static BytesValue parseDelimitedFrom(InputStream inputStream) {
        return (BytesValue)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static BytesValue parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BytesValue)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static BytesValue parseFrom(ByteString byteString) {
        return (BytesValue)PARSER.parseFrom(byteString);
    }

    public static BytesValue parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (BytesValue)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static BytesValue parseFrom(CodedInputStream codedInputStream) {
        return (BytesValue)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static BytesValue parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BytesValue)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static BytesValue parseFrom(InputStream inputStream) {
        return (BytesValue)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static BytesValue parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BytesValue)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static BytesValue parseFrom(ByteBuffer byteBuffer) {
        return (BytesValue)PARSER.parseFrom(byteBuffer);
    }

    public static BytesValue parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (BytesValue)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static BytesValue parseFrom(byte[] byArray) {
        return (BytesValue)PARSER.parseFrom(byArray);
    }

    public static BytesValue parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (BytesValue)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof BytesValue;
        if (!bl3) {
            return super.equals(object);
        }
        object = (BytesValue)object;
        Object object2 = this.getValue();
        ByteString byteString = ((BytesValue)object).getValue();
        bl3 = ((ByteString)object2).equals(byteString);
        byteString = null;
        if (!bl3) {
            return false;
        }
        object2 = this.unknownFields;
        object = ((GeneratedMessageV3)object).unknownFields;
        boolean bl4 = ((UnknownFieldSet)object2).equals(object);
        if (!bl4) {
            return false;
        }
        return bl2;
    }

    public BytesValue getDefaultInstanceForType() {
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
        ByteString byteString = this.value_;
        n11 = (int)(byteString.isEmpty() ? 1 : 0);
        if (n11 == 0) {
            ByteString byteString2 = this.value_;
            n11 = CodedOutputStream.computeBytesSize(1, byteString2);
            n10 = 0 + n11;
        }
        n11 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n10 += n11;
        return n10;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public ByteString getValue() {
        return this.value_;
    }

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        int n11 = BytesValue.getDescriptor().hashCode();
        n10 = ((779 + n11) * 37 + 1) * 53;
        n11 = this.getValue().hashCode();
        n10 = (n10 + n11) * 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_BytesValue_fieldAccessorTable.ensureFieldAccessorsInitialized(BytesValue.class, BytesValue$Builder.class);
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

    public BytesValue$Builder newBuilderForType() {
        return BytesValue.newBuilder();
    }

    public BytesValue$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        BytesValue$Builder bytesValue$Builder = new BytesValue$Builder(generatedMessageV3$BuilderParent, null);
        return bytesValue$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new BytesValue();
        return object;
    }

    public BytesValue$Builder toBuilder() {
        BytesValueOrBuilder bytesValueOrBuilder = DEFAULT_INSTANCE;
        if (this == bytesValueOrBuilder) {
            bytesValueOrBuilder = new BytesValue$Builder(null);
        } else {
            bytesValueOrBuilder = new BytesValue$Builder(null);
            bytesValueOrBuilder = ((BytesValue$Builder)bytesValueOrBuilder).mergeFrom(this);
        }
        return bytesValueOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        ByteString byteString = this.value_;
        int n10 = (int)(byteString.isEmpty() ? 1 : 0);
        if (n10 == 0) {
            n10 = 1;
            ByteString byteString2 = this.value_;
            codedOutputStream.writeBytes(n10, byteString2);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

