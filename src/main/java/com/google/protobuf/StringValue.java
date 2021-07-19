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
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.StringValue$1;
import com.google.protobuf.StringValue$Builder;
import com.google.protobuf.StringValueOrBuilder;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import com.google.protobuf.WrappersProto;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

public final class StringValue
extends GeneratedMessageV3
implements StringValueOrBuilder {
    private static final StringValue DEFAULT_INSTANCE;
    private static final Parser PARSER;
    public static final int VALUE_FIELD_NUMBER = 1;
    private static final long serialVersionUID;
    private byte memoizedIsInitialized = (byte)-1;
    private volatile Object value_;

    static {
        Object object = new StringValue();
        DEFAULT_INSTANCE = object;
        PARSER = object = new StringValue$1();
    }

    private StringValue() {
        this.value_ = "";
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private StringValue(CodedInputStream object, ExtensionRegistryLite object2) {
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
                            String string2 = ((CodedInputStream)object).readStringRequireUtf8();
                            this.value_ = string2;
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

    public /* synthetic */ StringValue(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, StringValue$1 stringValue$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private StringValue(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
    }

    public /* synthetic */ StringValue(GeneratedMessageV3$Builder generatedMessageV3$Builder, StringValue$1 stringValue$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ Object access$300(StringValue stringValue) {
        return stringValue.value_;
    }

    public static /* synthetic */ Object access$302(StringValue stringValue, Object object) {
        stringValue.value_ = object;
        return object;
    }

    public static /* synthetic */ Parser access$400() {
        return PARSER;
    }

    public static StringValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return WrappersProto.internal_static_google_protobuf_StringValue_descriptor;
    }

    public static StringValue$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static StringValue$Builder newBuilder(StringValue stringValue) {
        return ((StringValue$Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(stringValue);
    }

    public static StringValue of(String string2) {
        return StringValue.newBuilder().setValue(string2).build();
    }

    public static StringValue parseDelimitedFrom(InputStream inputStream) {
        return (StringValue)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static StringValue parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (StringValue)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static StringValue parseFrom(ByteString byteString) {
        return (StringValue)PARSER.parseFrom(byteString);
    }

    public static StringValue parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (StringValue)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static StringValue parseFrom(CodedInputStream codedInputStream) {
        return (StringValue)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static StringValue parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (StringValue)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static StringValue parseFrom(InputStream inputStream) {
        return (StringValue)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static StringValue parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (StringValue)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static StringValue parseFrom(ByteBuffer byteBuffer) {
        return (StringValue)PARSER.parseFrom(byteBuffer);
    }

    public static StringValue parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (StringValue)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static StringValue parseFrom(byte[] byArray) {
        return (StringValue)PARSER.parseFrom(byArray);
    }

    public static StringValue parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (StringValue)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof StringValue;
        if (!bl3) {
            return super.equals(object);
        }
        object = (StringValue)object;
        Object object2 = this.getValue();
        String string2 = ((StringValue)object).getValue();
        bl3 = ((String)object2).equals(string2);
        string2 = null;
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

    public StringValue getDefaultInstanceForType() {
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
        ByteString byteString = this.getValueBytes();
        n11 = (int)(byteString.isEmpty() ? 1 : 0);
        if (n11 == 0) {
            Object object = this.value_;
            n11 = GeneratedMessageV3.computeStringSize(1, object);
            n10 = 0 + n11;
        }
        n11 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n10 += n11;
        return n10;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public String getValue() {
        Object object = this.value_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        this.value_ = object = ((ByteString)object).toStringUtf8();
        return object;
    }

    public ByteString getValueBytes() {
        Object object = this.value_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.value_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        int n11 = StringValue.getDescriptor().hashCode();
        n10 = ((779 + n11) * 37 + 1) * 53;
        n11 = this.getValue().hashCode();
        n10 = (n10 + n11) * 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_StringValue_fieldAccessorTable.ensureFieldAccessorsInitialized(StringValue.class, StringValue$Builder.class);
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

    public StringValue$Builder newBuilderForType() {
        return StringValue.newBuilder();
    }

    public StringValue$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        StringValue$Builder stringValue$Builder = new StringValue$Builder(generatedMessageV3$BuilderParent, null);
        return stringValue$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new StringValue();
        return object;
    }

    public StringValue$Builder toBuilder() {
        StringValueOrBuilder stringValueOrBuilder = DEFAULT_INSTANCE;
        if (this == stringValueOrBuilder) {
            stringValueOrBuilder = new StringValue$Builder(null);
        } else {
            stringValueOrBuilder = new StringValue$Builder(null);
            stringValueOrBuilder = ((StringValue$Builder)stringValueOrBuilder).mergeFrom(this);
        }
        return stringValueOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        ByteString byteString = this.getValueBytes();
        int n10 = (int)(byteString.isEmpty() ? 1 : 0);
        if (n10 == 0) {
            n10 = 1;
            Object object = this.value_;
            GeneratedMessageV3.writeString(codedOutputStream, n10, object);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

