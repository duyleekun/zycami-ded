/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Any$1;
import com.google.protobuf.Any$Builder;
import com.google.protobuf.AnyOrBuilder;
import com.google.protobuf.AnyProto;
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
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

public final class Any
extends GeneratedMessageV3
implements AnyOrBuilder {
    private static final Any DEFAULT_INSTANCE;
    private static final Parser PARSER;
    public static final int TYPE_URL_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    private static final long serialVersionUID;
    private volatile Message cachedUnpackValue;
    private byte memoizedIsInitialized = (byte)-1;
    private volatile Object typeUrl_;
    private ByteString value_;

    static {
        Object object = new Any();
        DEFAULT_INSTANCE = object;
        PARSER = object = new Any$1();
    }

    private Any() {
        ByteString byteString;
        this.typeUrl_ = "";
        this.value_ = byteString = ByteString.EMPTY;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Any(CodedInputStream object, ExtensionRegistryLite object2) {
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
                    boolean bl3;
                    block11: {
                        int n10 = ((CodedInputStream)object).readTag();
                        bl3 = true;
                        if (n10 != 0) {
                            Object object3;
                            int n11 = 10;
                            if (n10 != n11) {
                                n11 = 18;
                                if (n10 != n11) {
                                    if ((n10 = (int)(this.parseUnknownField((CodedInputStream)object, unknownFieldSet$Builder, (ExtensionRegistryLite)object2, n10) ? 1 : 0)) != 0) continue;
                                    break block11;
                                } else {
                                    this.value_ = object3 = ((CodedInputStream)object).readBytes();
                                    continue;
                                }
                            }
                            this.typeUrl_ = object3 = ((CodedInputStream)object).readStringRequireUtf8();
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

    public /* synthetic */ Any(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Any$1 any$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private Any(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
    }

    public /* synthetic */ Any(GeneratedMessageV3$Builder generatedMessageV3$Builder, Any$1 any$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ Object access$300(Any any) {
        return any.typeUrl_;
    }

    public static /* synthetic */ Object access$302(Any any, Object object) {
        any.typeUrl_ = object;
        return object;
    }

    public static /* synthetic */ ByteString access$402(Any any, ByteString byteString) {
        any.value_ = byteString;
        return byteString;
    }

    public static /* synthetic */ Parser access$500() {
        return PARSER;
    }

    public static Any getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return AnyProto.internal_static_google_protobuf_Any_descriptor;
    }

    private static String getTypeNameFromTypeUrl(String string2) {
        int n10;
        int n11 = string2.lastIndexOf(47);
        string2 = n11 == (n10 = -1) ? "" : string2.substring(++n11);
        return string2;
    }

    private static String getTypeUrl(String string2, Descriptors$Descriptor descriptors$Descriptor) {
        CharSequence charSequence = "/";
        boolean bl2 = string2.endsWith((String)charSequence);
        if (bl2) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string2);
            string2 = descriptors$Descriptor.getFullName();
            ((StringBuilder)charSequence).append(string2);
            string2 = ((StringBuilder)charSequence).toString();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append((String)charSequence);
            string2 = descriptors$Descriptor.getFullName();
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
        }
        return string2;
    }

    public static Any$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Any$Builder newBuilder(Any any) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(any);
    }

    public static Any pack(Message object) {
        Any$Builder any$Builder = Any.newBuilder();
        Object object2 = object.getDescriptorForType();
        object2 = Any.getTypeUrl("type.googleapis.com", (Descriptors$Descriptor)object2);
        any$Builder = any$Builder.setTypeUrl((String)object2);
        object = object.toByteString();
        return any$Builder.setValue((ByteString)object).build();
    }

    public static Any pack(Message object, String object2) {
        Any$Builder any$Builder = Any.newBuilder();
        Descriptors$Descriptor descriptors$Descriptor = object.getDescriptorForType();
        object2 = Any.getTypeUrl((String)object2, descriptors$Descriptor);
        object2 = any$Builder.setTypeUrl((String)object2);
        object = object.toByteString();
        return ((Any$Builder)object2).setValue((ByteString)object).build();
    }

    public static Any parseDelimitedFrom(InputStream inputStream) {
        return (Any)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Any parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Any)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Any parseFrom(ByteString byteString) {
        return (Any)PARSER.parseFrom(byteString);
    }

    public static Any parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Any)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Any parseFrom(CodedInputStream codedInputStream) {
        return (Any)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Any parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Any)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Any parseFrom(InputStream inputStream) {
        return (Any)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Any parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Any)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Any parseFrom(ByteBuffer byteBuffer) {
        return (Any)PARSER.parseFrom(byteBuffer);
    }

    public static Any parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Any)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Any parseFrom(byte[] byArray) {
        return (Any)PARSER.parseFrom(byArray);
    }

    public static Any parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (Any)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        ByteString byteString;
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof Any;
        if (!bl3) {
            return super.equals(object);
        }
        object = (Any)object;
        Object object2 = this.getTypeUrl();
        String string2 = ((Any)object).getTypeUrl();
        bl3 = ((String)object2).equals(string2);
        string2 = null;
        if (!bl3) {
            return false;
        }
        object2 = this.getValue();
        bl3 = ((ByteString)object2).equals(byteString = ((Any)object).getValue());
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

    public Any getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
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
        ByteString byteString = this.getTypeUrlBytes();
        n11 = (int)(byteString.isEmpty() ? 1 : 0);
        if (n11 == 0) {
            object = this.typeUrl_;
            n11 = GeneratedMessageV3.computeStringSize(1, object);
            n10 = 0 + n11;
        }
        if ((n11 = (int)((byteString = this.value_).isEmpty() ? 1 : 0)) == 0) {
            object = this.value_;
            n11 = CodedOutputStream.computeBytesSize(2, (ByteString)object);
            n10 += n11;
        }
        n11 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n10 += n11;
        return n10;
    }

    public String getTypeUrl() {
        Object object = this.typeUrl_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        this.typeUrl_ = object = ((ByteString)object).toStringUtf8();
        return object;
    }

    public ByteString getTypeUrlBytes() {
        Object object = this.typeUrl_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.typeUrl_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
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
        int n11 = Any.getDescriptor().hashCode();
        n10 = ((779 + n11) * 37 + 1) * 53;
        n11 = this.getTypeUrl().hashCode();
        n10 = ((n10 + n11) * 37 + 2) * 53;
        n11 = this.getValue().hashCode();
        n10 = (n10 + n11) * 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return AnyProto.internal_static_google_protobuf_Any_fieldAccessorTable.ensureFieldAccessorsInitialized(Any.class, Any$Builder.class);
    }

    public boolean is(Class object) {
        object = (Message)Internal.getDefaultInstance((Class)object);
        String string2 = Any.getTypeNameFromTypeUrl(this.getTypeUrl());
        object = object.getDescriptorForType().getFullName();
        return string2.equals(object);
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

    public Any$Builder newBuilderForType() {
        return Any.newBuilder();
    }

    public Any$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        Any$Builder any$Builder = new Any$Builder(generatedMessageV3$BuilderParent, null);
        return any$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new Any();
        return object;
    }

    public Any$Builder toBuilder() {
        AnyOrBuilder anyOrBuilder = DEFAULT_INSTANCE;
        if (this == anyOrBuilder) {
            anyOrBuilder = new Any$Builder(null);
        } else {
            anyOrBuilder = new Any$Builder(null);
            anyOrBuilder = ((Any$Builder)anyOrBuilder).mergeFrom(this);
        }
        return anyOrBuilder;
    }

    public Message unpack(Class object) {
        boolean bl2;
        Class<?> clazz = this.cachedUnpackValue;
        if (clazz != null) {
            clazz = this.cachedUnpackValue.getClass();
            if (clazz == object) {
                return this.cachedUnpackValue;
            }
            bl2 = true;
        } else {
            bl2 = false;
            clazz = null;
        }
        if (!bl2 && (bl2 = this.is((Class)object))) {
            object = ((Message)Internal.getDefaultInstance((Class)object)).getParserForType();
            clazz = this.getValue();
            this.cachedUnpackValue = object = (Message)object.parseFrom((ByteString)((Object)clazz));
            return object;
        }
        object = new InvalidProtocolBufferException("Type of the Any message does not match the given class.");
        throw object;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        Object object;
        ByteString byteString = this.getTypeUrlBytes();
        int n10 = (int)(byteString.isEmpty() ? 1 : 0);
        if (n10 == 0) {
            n10 = 1;
            object = this.typeUrl_;
            GeneratedMessageV3.writeString(codedOutputStream, n10, object);
        }
        if ((n10 = (byteString = this.value_).isEmpty()) == 0) {
            n10 = 2;
            object = this.value_;
            codedOutputStream.writeBytes(n10, (ByteString)object);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

