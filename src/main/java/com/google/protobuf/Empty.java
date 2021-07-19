/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Empty$1;
import com.google.protobuf.Empty$Builder;
import com.google.protobuf.EmptyOrBuilder;
import com.google.protobuf.EmptyProto;
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

public final class Empty
extends GeneratedMessageV3
implements EmptyOrBuilder {
    private static final Empty DEFAULT_INSTANCE;
    private static final Parser PARSER;
    private static final long serialVersionUID;
    private byte memoizedIsInitialized = (byte)-1;

    static {
        Object object = new Empty();
        DEFAULT_INSTANCE = object;
        PARSER = object = new Empty$1();
    }

    private Empty() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Empty(CodedInputStream object, ExtensionRegistryLite object2) {
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
                    if (n10 != 0 && (n10 = (int)(this.parseUnknownField((CodedInputStream)object, unknownFieldSet$Builder, (ExtensionRegistryLite)object2, n10) ? 1 : 0)) != 0) continue;
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

    public /* synthetic */ Empty(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Empty$1 empty$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private Empty(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
    }

    public /* synthetic */ Empty(GeneratedMessageV3$Builder generatedMessageV3$Builder, Empty$1 empty$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ Parser access$300() {
        return PARSER;
    }

    public static Empty getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return EmptyProto.internal_static_google_protobuf_Empty_descriptor;
    }

    public static Empty$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Empty$Builder newBuilder(Empty empty) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(empty);
    }

    public static Empty parseDelimitedFrom(InputStream inputStream) {
        return (Empty)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Empty parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Empty)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Empty parseFrom(ByteString byteString) {
        return (Empty)PARSER.parseFrom(byteString);
    }

    public static Empty parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Empty)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Empty parseFrom(CodedInputStream codedInputStream) {
        return (Empty)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Empty parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Empty)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Empty parseFrom(InputStream inputStream) {
        return (Empty)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Empty parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Empty)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Empty parseFrom(ByteBuffer byteBuffer) {
        return (Empty)PARSER.parseFrom(byteBuffer);
    }

    public static Empty parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Empty)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Empty parseFrom(byte[] byArray) {
        return (Empty)PARSER.parseFrom(byArray);
    }

    public static Empty parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (Empty)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof Empty;
        if (!bl3) {
            return super.equals(object);
        }
        object = (Empty)object;
        UnknownFieldSet unknownFieldSet = this.unknownFields;
        object = ((GeneratedMessageV3)object).unknownFields;
        boolean bl4 = unknownFieldSet.equals(object);
        if (!bl4) {
            return false;
        }
        return bl2;
    }

    public Empty getDefaultInstanceForType() {
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
        this.memoizedSize = n10 = this.unknownFields.getSerializedSize() + 0;
        return n10;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        int n11 = Empty.getDescriptor().hashCode();
        n10 = (779 + n11) * 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return EmptyProto.internal_static_google_protobuf_Empty_fieldAccessorTable.ensureFieldAccessorsInitialized(Empty.class, Empty$Builder.class);
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

    public Empty$Builder newBuilderForType() {
        return Empty.newBuilder();
    }

    public Empty$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        Empty$Builder empty$Builder = new Empty$Builder(generatedMessageV3$BuilderParent, null);
        return empty$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new Empty();
        return object;
    }

    public Empty$Builder toBuilder() {
        EmptyOrBuilder emptyOrBuilder = DEFAULT_INSTANCE;
        if (this == emptyOrBuilder) {
            emptyOrBuilder = new Empty$Builder(null);
        } else {
            emptyOrBuilder = new Empty$Builder(null);
            emptyOrBuilder = ((Empty$Builder)emptyOrBuilder).mergeFrom(this);
        }
        return emptyOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        this.unknownFields.writeTo(codedOutputStream);
    }
}

