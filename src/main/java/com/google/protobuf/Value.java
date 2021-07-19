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
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.ListValue;
import com.google.protobuf.ListValue$Builder;
import com.google.protobuf.ListValueOrBuilder;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.NullValue;
import com.google.protobuf.Parser;
import com.google.protobuf.Struct;
import com.google.protobuf.Struct$Builder;
import com.google.protobuf.StructOrBuilder;
import com.google.protobuf.StructProto;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import com.google.protobuf.Value$1;
import com.google.protobuf.Value$Builder;
import com.google.protobuf.Value$KindCase;
import com.google.protobuf.ValueOrBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

public final class Value
extends GeneratedMessageV3
implements ValueOrBuilder {
    public static final int BOOL_VALUE_FIELD_NUMBER = 4;
    private static final Value DEFAULT_INSTANCE;
    public static final int LIST_VALUE_FIELD_NUMBER = 6;
    public static final int NULL_VALUE_FIELD_NUMBER = 1;
    public static final int NUMBER_VALUE_FIELD_NUMBER = 2;
    private static final Parser PARSER;
    public static final int STRING_VALUE_FIELD_NUMBER = 3;
    public static final int STRUCT_VALUE_FIELD_NUMBER = 5;
    private static final long serialVersionUID;
    private int kindCase_ = 0;
    private Object kind_;
    private byte memoizedIsInitialized = (byte)-1;

    static {
        Object object = new Value();
        DEFAULT_INSTANCE = object;
        PARSER = object = new Value$1();
    }

    private Value() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Value(CodedInputStream object, ExtensionRegistryLite object2) {
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
                    block19: {
                        int n12 = ((CodedInputStream)object).readTag();
                        n11 = 1;
                        if (n12 != 0) {
                            Object object3;
                            int n13 = 8;
                            if (n12 != n13) {
                                n13 = 17;
                                if (n12 != n13) {
                                    n13 = 26;
                                    if (n12 != n13) {
                                        n13 = 32;
                                        if (n12 != n13) {
                                            n13 = 42;
                                            Message$Builder message$Builder = null;
                                            if (n12 != n13) {
                                                n13 = 50;
                                                if (n12 != n13) {
                                                    if ((n12 = (int)(this.parseUnknownField((CodedInputStream)object, unknownFieldSet$Builder, (ExtensionRegistryLite)object2, n12) ? 1 : 0)) != 0) continue;
                                                    break block19;
                                                } else {
                                                    n12 = this.kindCase_;
                                                    n11 = 6;
                                                    if (n12 == n11) {
                                                        object3 = this.kind_;
                                                        object3 = (ListValue)object3;
                                                        message$Builder = ((ListValue)object3).toBuilder();
                                                    }
                                                    object3 = ListValue.parser();
                                                    this.kind_ = object3 = ((CodedInputStream)object).readMessage((Parser)object3, (ExtensionRegistryLite)object2);
                                                    if (message$Builder != null) {
                                                        object3 = (ListValue)object3;
                                                        ((ListValue$Builder)message$Builder).mergeFrom((ListValue)object3);
                                                        this.kind_ = object3 = ((ListValue$Builder)message$Builder).buildPartial();
                                                    }
                                                    this.kindCase_ = n11;
                                                    continue;
                                                }
                                            }
                                            n12 = this.kindCase_;
                                            n11 = 5;
                                            if (n12 == n11) {
                                                object3 = this.kind_;
                                                object3 = (Struct)object3;
                                                message$Builder = ((Struct)object3).toBuilder();
                                            }
                                            object3 = Struct.parser();
                                            this.kind_ = object3 = ((CodedInputStream)object).readMessage((Parser)object3, (ExtensionRegistryLite)object2);
                                            if (message$Builder != null) {
                                                object3 = (Struct)object3;
                                                ((Struct$Builder)message$Builder).mergeFrom((Struct)object3);
                                                this.kind_ = object3 = ((Struct$Builder)message$Builder).buildPartial();
                                            }
                                            this.kindCase_ = n11;
                                            continue;
                                        }
                                        this.kindCase_ = n12 = 4;
                                        n12 = (int)(((CodedInputStream)object).readBool() ? 1 : 0);
                                        this.kind_ = object3 = Boolean.valueOf(n12 != 0);
                                        continue;
                                    }
                                    object3 = ((CodedInputStream)object).readStringRequireUtf8();
                                    this.kindCase_ = n11 = 3;
                                    this.kind_ = object3;
                                    continue;
                                }
                                this.kindCase_ = n12 = 2;
                                double d10 = ((CodedInputStream)object).readDouble();
                                this.kind_ = object3 = Double.valueOf(d10);
                                continue;
                            }
                            n12 = ((CodedInputStream)object).readEnum();
                            this.kindCase_ = n11;
                            this.kind_ = object3 = Integer.valueOf(n12);
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

    public /* synthetic */ Value(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Value$1 value$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private Value(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
    }

    public /* synthetic */ Value(GeneratedMessageV3$Builder generatedMessageV3$Builder, Value$1 value$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ Object access$300(Value value) {
        return value.kind_;
    }

    public static /* synthetic */ Object access$302(Value value, Object object) {
        value.kind_ = object;
        return object;
    }

    public static /* synthetic */ int access$402(Value value, int n10) {
        value.kindCase_ = n10;
        return n10;
    }

    public static /* synthetic */ Parser access$500() {
        return PARSER;
    }

    public static Value getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return StructProto.internal_static_google_protobuf_Value_descriptor;
    }

    public static Value$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Value$Builder newBuilder(Value value) {
        return ((Value$Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(value);
    }

    public static Value parseDelimitedFrom(InputStream inputStream) {
        return (Value)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Value parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Value)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Value parseFrom(ByteString byteString) {
        return (Value)PARSER.parseFrom(byteString);
    }

    public static Value parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Value)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Value parseFrom(CodedInputStream codedInputStream) {
        return (Value)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Value parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Value)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Value parseFrom(InputStream inputStream) {
        return (Value)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Value parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Value)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Value parseFrom(ByteBuffer byteBuffer) {
        return (Value)PARSER.parseFrom(byteBuffer);
    }

    public static Value parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Value)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Value parseFrom(byte[] byArray) {
        return (Value)PARSER.parseFrom(byArray);
    }

    public static Value parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (Value)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean n10 = object instanceof Value;
        if (!n10) {
            return super.equals(object);
        }
        object = (Value)object;
        Object object2 = this.getKindCase();
        Value$KindCase value$KindCase = ((Value)object).getKindCase();
        boolean bl3 = ((Enum)object2).equals(value$KindCase);
        value$KindCase = null;
        if (!bl3) {
            return false;
        }
        int n11 = this.kindCase_;
        switch (n11) {
            default: {
                break;
            }
            case 6: {
                object2 = this.getListValue();
                ListValue listValue = ((Value)object).getListValue();
                boolean bl4 = ((ListValue)object2).equals(listValue);
                if (bl4) break;
                return false;
            }
            case 5: {
                object2 = this.getStructValue();
                Struct struct = ((Value)object).getStructValue();
                boolean bl5 = ((Struct)object2).equals(struct);
                if (bl5) break;
                return false;
            }
            case 4: {
                boolean bl6 = this.getBoolValue();
                boolean bl7 = ((Value)object).getBoolValue();
                if (bl6 == bl7) break;
                return false;
            }
            case 3: {
                object2 = this.getStringValue();
                String string2 = ((Value)object).getStringValue();
                boolean bl8 = ((String)object2).equals(string2);
                if (bl8) break;
                return false;
            }
            case 2: {
                double d10 = this.getNumberValue();
                long l10 = Double.doubleToLongBits(d10);
                double d11 = ((Value)object).getNumberValue();
                long l11 = Double.doubleToLongBits(d11);
                long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                if (l12 == false) break;
                return false;
            }
            case 1: {
                int n12 = this.getNullValueValue();
                int n13 = ((Value)object).getNullValueValue();
                if (n12 == n13) break;
                return false;
            }
        }
        object2 = this.unknownFields;
        object = ((GeneratedMessageV3)object).unknownFields;
        boolean bl9 = ((UnknownFieldSet)object2).equals(object);
        if (!bl9) {
            return false;
        }
        return bl2;
    }

    public boolean getBoolValue() {
        int n10 = this.kindCase_;
        int n11 = 4;
        if (n10 == n11) {
            return (Boolean)this.kind_;
        }
        return false;
    }

    public Value getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public Value$KindCase getKindCase() {
        return Value$KindCase.forNumber(this.kindCase_);
    }

    public ListValue getListValue() {
        int n10 = this.kindCase_;
        int n11 = 6;
        if (n10 == n11) {
            return (ListValue)this.kind_;
        }
        return ListValue.getDefaultInstance();
    }

    public ListValueOrBuilder getListValueOrBuilder() {
        int n10 = this.kindCase_;
        int n11 = 6;
        if (n10 == n11) {
            return (ListValue)this.kind_;
        }
        return ListValue.getDefaultInstance();
    }

    public NullValue getNullValue() {
        int n10 = this.kindCase_;
        int n11 = 1;
        if (n10 == n11) {
            n10 = (Integer)this.kind_;
            NullValue nullValue = NullValue.valueOf(n10);
            if (nullValue == null) {
                nullValue = NullValue.UNRECOGNIZED;
            }
            return nullValue;
        }
        return NullValue.NULL_VALUE;
    }

    public int getNullValueValue() {
        int n10 = this.kindCase_;
        int n11 = 1;
        if (n10 == n11) {
            return (Integer)this.kind_;
        }
        return 0;
    }

    public double getNumberValue() {
        int n10 = this.kindCase_;
        int n11 = 2;
        if (n10 == n11) {
            return (Double)this.kind_;
        }
        return 0.0;
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
        n11 = this.kindCase_;
        int n12 = 1;
        if (n11 == n12) {
            object = (Integer)this.kind_;
            n11 = (Integer)object;
            n11 = CodedOutputStream.computeEnumSize(n12, n11);
            n10 = 0 + n11;
        }
        if ((n11 = this.kindCase_) == (n12 = 2)) {
            object = (Double)this.kind_;
            double d10 = (Double)object;
            n11 = CodedOutputStream.computeDoubleSize(n12, d10);
            n10 += n11;
        }
        if ((n11 = this.kindCase_) == (n12 = 3)) {
            object = this.kind_;
            n11 = GeneratedMessageV3.computeStringSize(n12, object);
            n10 += n11;
        }
        if ((n11 = this.kindCase_) == (n12 = 4)) {
            object = (Boolean)this.kind_;
            n11 = (int)(((Boolean)object).booleanValue() ? 1 : 0);
            n11 = CodedOutputStream.computeBoolSize(n12, n11 != 0);
            n10 += n11;
        }
        if ((n11 = this.kindCase_) == (n12 = 5)) {
            object = (Struct)this.kind_;
            n11 = CodedOutputStream.computeMessageSize(n12, (MessageLite)object);
            n10 += n11;
        }
        if ((n11 = this.kindCase_) == (n12 = 6)) {
            object = (ListValue)this.kind_;
            n11 = CodedOutputStream.computeMessageSize(n12, (MessageLite)object);
            n10 += n11;
        }
        n11 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n10 += n11;
        return n10;
    }

    public String getStringValue() {
        int n10 = this.kindCase_;
        int n11 = 3;
        Object object = n10 == n11 ? this.kind_ : "";
        int n12 = object instanceof String;
        if (n12 != 0) {
            return (String)object;
        }
        object = ((ByteString)object).toStringUtf8();
        n12 = this.kindCase_;
        if (n12 == n11) {
            this.kind_ = object;
        }
        return object;
    }

    public ByteString getStringValueBytes() {
        int n10 = this.kindCase_;
        int n11 = 3;
        Object object = n10 == n11 ? this.kind_ : "";
        int n12 = object instanceof String;
        if (n12 != 0) {
            object = ByteString.copyFromUtf8((String)object);
            n12 = this.kindCase_;
            if (n12 == n11) {
                this.kind_ = object;
            }
            return object;
        }
        return (ByteString)object;
    }

    public Struct getStructValue() {
        int n10 = this.kindCase_;
        int n11 = 5;
        if (n10 == n11) {
            return (Struct)this.kind_;
        }
        return Struct.getDefaultInstance();
    }

    public StructOrBuilder getStructValueOrBuilder() {
        int n10 = this.kindCase_;
        int n11 = 5;
        if (n10 == n11) {
            return (Struct)this.kind_;
        }
        return Struct.getDefaultInstance();
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public boolean hasListValue() {
        int n10 = this.kindCase_;
        int n11 = 6;
        n10 = n10 == n11 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasStructValue() {
        int n10 = this.kindCase_;
        int n11 = 5;
        n10 = n10 == n11 ? 1 : 0;
        return n10 != 0;
    }

    public int hashCode() {
        int n10;
        int n11;
        block9: {
            n11 = this.memoizedHashCode;
            if (n11 != 0) {
                return n11;
            }
            Object object = Value.getDescriptor();
            n10 = object.hashCode();
            n11 = 779 + n10;
            n10 = this.kindCase_;
            switch (n10) {
                default: {
                    break block9;
                }
                case 6: {
                    n11 = (n11 * 37 + 6) * 53;
                    object = this.getListValue();
                    n10 = ((ListValue)object).hashCode();
                    break;
                }
                case 5: {
                    n11 = (n11 * 37 + 5) * 53;
                    object = this.getStructValue();
                    n10 = ((Struct)object).hashCode();
                    break;
                }
                case 4: {
                    n11 = (n11 * 37 + 4) * 53;
                    n10 = Internal.hashBoolean(this.getBoolValue());
                    break;
                }
                case 3: {
                    n11 = (n11 * 37 + 3) * 53;
                    object = this.getStringValue();
                    n10 = ((String)object).hashCode();
                    break;
                }
                case 2: {
                    n11 = (n11 * 37 + 2) * 53;
                    double d10 = this.getNumberValue();
                    long l10 = Double.doubleToLongBits(d10);
                    n10 = Internal.hashLong(l10);
                    break;
                }
                case 1: {
                    n11 = (n11 * 37 + 1) * 53;
                    n10 = this.getNullValueValue();
                }
            }
            n11 += n10;
        }
        n11 *= 29;
        n10 = this.unknownFields.hashCode();
        this.memoizedHashCode = n11 += n10;
        return n11;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return StructProto.internal_static_google_protobuf_Value_fieldAccessorTable.ensureFieldAccessorsInitialized(Value.class, Value$Builder.class);
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

    public Value$Builder newBuilderForType() {
        return Value.newBuilder();
    }

    public Value$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        Value$Builder value$Builder = new Value$Builder(generatedMessageV3$BuilderParent, null);
        return value$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new Value();
        return object;
    }

    public Value$Builder toBuilder() {
        ValueOrBuilder valueOrBuilder = DEFAULT_INSTANCE;
        if (this == valueOrBuilder) {
            valueOrBuilder = new Value$Builder(null);
        } else {
            valueOrBuilder = new Value$Builder(null);
            valueOrBuilder = ((Value$Builder)valueOrBuilder).mergeFrom(this);
        }
        return valueOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        Object object;
        int n10 = this.kindCase_;
        int n11 = 1;
        if (n10 == n11) {
            object = (Integer)this.kind_;
            n10 = (Integer)object;
            codedOutputStream.writeEnum(n11, n10);
        }
        if ((n10 = this.kindCase_) == (n11 = 2)) {
            object = (Double)this.kind_;
            double d10 = (Double)object;
            codedOutputStream.writeDouble(n11, d10);
        }
        if ((n10 = this.kindCase_) == (n11 = 3)) {
            object = this.kind_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        if ((n10 = this.kindCase_) == (n11 = 4)) {
            object = (Boolean)this.kind_;
            n10 = (int)(((Boolean)object).booleanValue() ? 1 : 0);
            codedOutputStream.writeBool(n11, n10 != 0);
        }
        if ((n10 = this.kindCase_) == (n11 = 5)) {
            object = (Struct)this.kind_;
            codedOutputStream.writeMessage(n11, (MessageLite)object);
        }
        if ((n10 = this.kindCase_) == (n11 = 6)) {
            object = (ListValue)this.kind_;
            codedOutputStream.writeMessage(n11, (MessageLite)object);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

