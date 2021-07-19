/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Any;
import com.google.protobuf.Any$Builder;
import com.google.protobuf.AnyOrBuilder;
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
import com.google.protobuf.MessageLite;
import com.google.protobuf.Option$1;
import com.google.protobuf.Option$Builder;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.TypeProto;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Objects;

public final class Option
extends GeneratedMessageV3
implements OptionOrBuilder {
    private static final Option DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    private static final Parser PARSER;
    public static final int VALUE_FIELD_NUMBER = 2;
    private static final long serialVersionUID;
    private byte memoizedIsInitialized = (byte)-1;
    private volatile Object name_;
    private Any value_;

    static {
        Object object = new Option();
        DEFAULT_INSTANCE = object;
        PARSER = object = new Option$1();
    }

    private Option() {
        this.name_ = "";
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Option(CodedInputStream object, ExtensionRegistryLite object2) {
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
                    block12: {
                        int n10 = ((CodedInputStream)object).readTag();
                        bl3 = true;
                        if (n10 != 0) {
                            Object object3;
                            int n11 = 10;
                            if (n10 != n11) {
                                n11 = 18;
                                if (n10 != n11) {
                                    if ((n10 = (int)(this.parseUnknownField((CodedInputStream)object, unknownFieldSet$Builder, (ExtensionRegistryLite)object2, n10) ? 1 : 0)) != 0) continue;
                                    break block12;
                                } else {
                                    n10 = 0;
                                    object3 = null;
                                    Object object4 = this.value_;
                                    if (object4 != null) {
                                        object3 = ((Any)object4).toBuilder();
                                    }
                                    object4 = Any.parser();
                                    object4 = ((CodedInputStream)object).readMessage((Parser)object4, (ExtensionRegistryLite)object2);
                                    this.value_ = object4 = (Any)object4;
                                    if (object3 == null) continue;
                                    ((Any$Builder)object3).mergeFrom((Any)object4);
                                    this.value_ = object3 = ((Any$Builder)object3).buildPartial();
                                    continue;
                                }
                            }
                            this.name_ = object3 = ((CodedInputStream)object).readStringRequireUtf8();
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

    public /* synthetic */ Option(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Option$1 option$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private Option(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
    }

    public /* synthetic */ Option(GeneratedMessageV3$Builder generatedMessageV3$Builder, Option$1 option$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ Object access$300(Option option) {
        return option.name_;
    }

    public static /* synthetic */ Object access$302(Option option, Object object) {
        option.name_ = object;
        return object;
    }

    public static /* synthetic */ Any access$402(Option option, Any any) {
        option.value_ = any;
        return any;
    }

    public static /* synthetic */ Parser access$500() {
        return PARSER;
    }

    public static Option getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_Option_descriptor;
    }

    public static Option$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Option$Builder newBuilder(Option option) {
        return ((Option$Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(option);
    }

    public static Option parseDelimitedFrom(InputStream inputStream) {
        return (Option)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Option parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Option)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Option parseFrom(ByteString byteString) {
        return (Option)PARSER.parseFrom(byteString);
    }

    public static Option parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Option)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Option parseFrom(CodedInputStream codedInputStream) {
        return (Option)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Option parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Option)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Option parseFrom(InputStream inputStream) {
        return (Option)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Option parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Option)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Option parseFrom(ByteBuffer byteBuffer) {
        return (Option)PARSER.parseFrom(byteBuffer);
    }

    public static Option parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Option)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Option parseFrom(byte[] byArray) {
        return (Option)PARSER.parseFrom(byArray);
    }

    public static Option parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (Option)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        Any any;
        boolean bl2;
        boolean bl3 = true;
        if (object == this) {
            return bl3;
        }
        boolean bl4 = object instanceof Option;
        if (!bl4) {
            return super.equals(object);
        }
        object = (Option)object;
        Object object2 = this.getName();
        String string2 = ((Option)object).getName();
        bl4 = ((String)object2).equals(string2);
        string2 = null;
        if (!bl4) {
            return false;
        }
        bl4 = this.hasValue();
        if (bl4 != (bl2 = ((Option)object).hasValue())) {
            return false;
        }
        bl4 = this.hasValue();
        if (bl4 && !(bl4 = ((Any)(object2 = this.getValue())).equals(any = ((Option)object).getValue()))) {
            return false;
        }
        object2 = this.unknownFields;
        object = ((GeneratedMessageV3)object).unknownFields;
        boolean bl5 = ((UnknownFieldSet)object2).equals(object);
        if (!bl5) {
            return false;
        }
        return bl3;
    }

    public Option getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public String getName() {
        Object object = this.name_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        this.name_ = object = ((ByteString)object).toStringUtf8();
        return object;
    }

    public ByteString getNameBytes() {
        Object object = this.name_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.name_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
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
        Serializable serializable = this.getNameBytes();
        n11 = (int)(serializable.isEmpty() ? 1 : 0);
        if (n11 == 0) {
            object = this.name_;
            n11 = GeneratedMessageV3.computeStringSize(1, object);
            n10 = 0 + n11;
        }
        if ((serializable = this.value_) != null) {
            object = this.getValue();
            n11 = CodedOutputStream.computeMessageSize(2, (MessageLite)object);
            n10 += n11;
        }
        n11 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n10 += n11;
        return n10;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public Any getValue() {
        Any any = this.value_;
        if (any == null) {
            any = Any.getDefaultInstance();
        }
        return any;
    }

    public AnyOrBuilder getValueOrBuilder() {
        return this.getValue();
    }

    public boolean hasValue() {
        boolean bl2;
        Any any = this.value_;
        if (any != null) {
            bl2 = true;
        } else {
            bl2 = false;
            any = null;
        }
        return bl2;
    }

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        int n11 = Option.getDescriptor().hashCode();
        n10 = ((779 + n11) * 37 + 1) * 53;
        Object object = this.getName();
        n11 = ((String)object).hashCode();
        n10 += n11;
        n11 = (int)(this.hasValue() ? 1 : 0);
        if (n11 != 0) {
            n10 = (n10 * 37 + 2) * 53;
            object = this.getValue();
            n11 = ((Any)object).hashCode();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_Option_fieldAccessorTable.ensureFieldAccessorsInitialized(Option.class, Option$Builder.class);
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

    public Option$Builder newBuilderForType() {
        return Option.newBuilder();
    }

    public Option$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        Option$Builder option$Builder = new Option$Builder(generatedMessageV3$BuilderParent, null);
        return option$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new Option();
        return object;
    }

    public Option$Builder toBuilder() {
        OptionOrBuilder optionOrBuilder = DEFAULT_INSTANCE;
        if (this == optionOrBuilder) {
            optionOrBuilder = new Option$Builder(null);
        } else {
            optionOrBuilder = new Option$Builder(null);
            optionOrBuilder = ((Option$Builder)optionOrBuilder).mergeFrom(this);
        }
        return optionOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        Object object;
        Serializable serializable = this.getNameBytes();
        int n10 = serializable.isEmpty();
        if (n10 == 0) {
            n10 = 1;
            object = this.name_;
            GeneratedMessageV3.writeString(codedOutputStream, n10, object);
        }
        if ((serializable = this.value_) != null) {
            n10 = 2;
            object = this.getValue();
            codedOutputStream.writeMessage(n10, (MessageLite)object);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

