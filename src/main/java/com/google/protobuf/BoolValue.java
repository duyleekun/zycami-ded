/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.BoolValue$1;
import com.google.protobuf.BoolValue$Builder;
import com.google.protobuf.BoolValueOrBuilder;
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

public final class BoolValue
extends GeneratedMessageV3
implements BoolValueOrBuilder {
    private static final BoolValue DEFAULT_INSTANCE;
    private static final Parser PARSER;
    public static final int VALUE_FIELD_NUMBER = 1;
    private static final long serialVersionUID;
    private byte memoizedIsInitialized = (byte)-1;
    private boolean value_;

    static {
        Object object = new BoolValue();
        DEFAULT_INSTANCE = object;
        PARSER = object = new BoolValue$1();
    }

    private BoolValue() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private BoolValue(CodedInputStream object, ExtensionRegistryLite object2) {
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
                            n10 = (int)(((CodedInputStream)object).readBool() ? 1 : 0);
                            this.value_ = n10;
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

    public /* synthetic */ BoolValue(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, BoolValue$1 boolValue$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private BoolValue(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
    }

    public /* synthetic */ BoolValue(GeneratedMessageV3$Builder generatedMessageV3$Builder, BoolValue$1 boolValue$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ boolean access$302(BoolValue boolValue, boolean bl2) {
        boolValue.value_ = bl2;
        return bl2;
    }

    public static /* synthetic */ Parser access$400() {
        return PARSER;
    }

    public static BoolValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return WrappersProto.internal_static_google_protobuf_BoolValue_descriptor;
    }

    public static BoolValue$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static BoolValue$Builder newBuilder(BoolValue boolValue) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(boolValue);
    }

    public static BoolValue of(boolean bl2) {
        return BoolValue.newBuilder().setValue(bl2).build();
    }

    public static BoolValue parseDelimitedFrom(InputStream inputStream) {
        return (BoolValue)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static BoolValue parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BoolValue)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static BoolValue parseFrom(ByteString byteString) {
        return (BoolValue)PARSER.parseFrom(byteString);
    }

    public static BoolValue parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (BoolValue)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static BoolValue parseFrom(CodedInputStream codedInputStream) {
        return (BoolValue)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static BoolValue parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BoolValue)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static BoolValue parseFrom(InputStream inputStream) {
        return (BoolValue)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static BoolValue parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BoolValue)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static BoolValue parseFrom(ByteBuffer byteBuffer) {
        return (BoolValue)PARSER.parseFrom(byteBuffer);
    }

    public static BoolValue parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (BoolValue)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static BoolValue parseFrom(byte[] byArray) {
        return (BoolValue)PARSER.parseFrom(byArray);
    }

    public static BoolValue parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (BoolValue)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3 = true;
        if (object == this) {
            return bl3;
        }
        boolean bl4 = object instanceof BoolValue;
        if (!bl4) {
            return super.equals(object);
        }
        object = (BoolValue)object;
        bl4 = this.getValue();
        if (bl4 != (bl2 = ((BoolValue)object).getValue())) {
            return false;
        }
        UnknownFieldSet unknownFieldSet = this.unknownFields;
        object = ((GeneratedMessageV3)object).unknownFields;
        boolean bl5 = unknownFieldSet.equals(object);
        if (!bl5) {
            return false;
        }
        return bl3;
    }

    public BoolValue getDefaultInstanceForType() {
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
        n11 = (int)(this.value_ ? 1 : 0);
        if (n11 != 0) {
            int n12 = 1;
            n11 = CodedOutputStream.computeBoolSize(n12, n11 != 0);
            n10 = 0 + n11;
        }
        n11 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n10 += n11;
        return n10;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public boolean getValue() {
        return this.value_;
    }

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        int n11 = BoolValue.getDescriptor().hashCode();
        n10 = ((779 + n11) * 37 + 1) * 53;
        n11 = Internal.hashBoolean(this.getValue());
        n10 = (n10 + n11) * 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_BoolValue_fieldAccessorTable.ensureFieldAccessorsInitialized(BoolValue.class, BoolValue$Builder.class);
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

    public BoolValue$Builder newBuilderForType() {
        return BoolValue.newBuilder();
    }

    public BoolValue$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        BoolValue$Builder boolValue$Builder = new BoolValue$Builder(generatedMessageV3$BuilderParent, null);
        return boolValue$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new BoolValue();
        return object;
    }

    public BoolValue$Builder toBuilder() {
        BoolValueOrBuilder boolValueOrBuilder = DEFAULT_INSTANCE;
        if (this == boolValueOrBuilder) {
            boolValueOrBuilder = new BoolValue$Builder(null);
        } else {
            boolValueOrBuilder = new BoolValue$Builder(null);
            boolValueOrBuilder = ((BoolValue$Builder)boolValueOrBuilder).mergeFrom(this);
        }
        return boolValueOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        boolean bl2 = this.value_;
        if (bl2) {
            int n10 = 1;
            codedOutputStream.writeBool(n10, bl2);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

