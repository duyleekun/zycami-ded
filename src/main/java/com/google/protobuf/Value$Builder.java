/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.ListValue;
import com.google.protobuf.ListValue$Builder;
import com.google.protobuf.ListValueOrBuilder;
import com.google.protobuf.Message;
import com.google.protobuf.NullValue;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.Struct;
import com.google.protobuf.Struct$Builder;
import com.google.protobuf.StructOrBuilder;
import com.google.protobuf.StructProto;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.Value;
import com.google.protobuf.Value$1;
import com.google.protobuf.Value$2;
import com.google.protobuf.Value$KindCase;
import com.google.protobuf.ValueOrBuilder;
import java.io.IOException;
import java.util.Objects;

public final class Value$Builder
extends GeneratedMessageV3$Builder
implements ValueOrBuilder {
    private int kindCase_ = 0;
    private Object kind_;
    private SingleFieldBuilderV3 listValueBuilder_;
    private SingleFieldBuilderV3 structValueBuilder_;

    private Value$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private Value$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        super(generatedMessageV3$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Value$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, Value$1 value$1) {
        this(generatedMessageV3$BuilderParent);
    }

    public /* synthetic */ Value$Builder(Value$1 value$1) {
        this();
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return StructProto.internal_static_google_protobuf_Value_descriptor;
    }

    private SingleFieldBuilderV3 getListValueFieldBuilder() {
        Object object = this.listValueBuilder_;
        int n10 = 6;
        if (object == null) {
            int n11 = this.kindCase_;
            if (n11 != n10) {
                this.kind_ = object = ListValue.getDefaultInstance();
            }
            ListValue listValue = (ListValue)this.kind_;
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.listValueBuilder_ = object = new SingleFieldBuilderV3(listValue, generatedMessageV3$BuilderParent, bl2);
            n11 = 0;
            object = null;
            this.kind_ = null;
        }
        this.kindCase_ = n10;
        this.onChanged();
        return this.listValueBuilder_;
    }

    private SingleFieldBuilderV3 getStructValueFieldBuilder() {
        Object object = this.structValueBuilder_;
        int n10 = 5;
        if (object == null) {
            int n11 = this.kindCase_;
            if (n11 != n10) {
                this.kind_ = object = Struct.getDefaultInstance();
            }
            Struct struct = (Struct)this.kind_;
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.structValueBuilder_ = object = new SingleFieldBuilderV3(struct, generatedMessageV3$BuilderParent, bl2);
            n11 = 0;
            object = null;
            this.kind_ = null;
        }
        this.kindCase_ = n10;
        this.onChanged();
        return this.structValueBuilder_;
    }

    private void maybeForceBuilderInitialization() {
    }

    public Value$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Value$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public Value build() {
        Message message = this.buildPartial();
        boolean bl2 = ((Value)message).isInitialized();
        if (bl2) {
            return message;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(message);
    }

    public Value buildPartial() {
        Object object = null;
        Value value = new Value(this, null);
        int n10 = this.kindCase_;
        int n11 = 1;
        if (n10 == n11) {
            object = this.kind_;
            Value.access$302(value, object);
        }
        if ((n10 = this.kindCase_) == (n11 = 2)) {
            object = this.kind_;
            Value.access$302(value, object);
        }
        if ((n10 = this.kindCase_) == (n11 = 3)) {
            object = this.kind_;
            Value.access$302(value, object);
        }
        if ((n10 = this.kindCase_) == (n11 = 4)) {
            object = this.kind_;
            Value.access$302(value, object);
        }
        if ((n10 = this.kindCase_) == (n11 = 5)) {
            object = this.structValueBuilder_;
            if (object == null) {
                object = this.kind_;
                Value.access$302(value, object);
            } else {
                object = ((SingleFieldBuilderV3)object).build();
                Value.access$302(value, object);
            }
        }
        if ((n10 = this.kindCase_) == (n11 = 6)) {
            object = this.listValueBuilder_;
            if (object == null) {
                object = this.kind_;
                Value.access$302(value, object);
            } else {
                object = ((SingleFieldBuilderV3)object).build();
                Value.access$302(value, object);
            }
        }
        n10 = this.kindCase_;
        Value.access$402(value, n10);
        this.onBuilt();
        return value;
    }

    public Value$Builder clear() {
        super.clear();
        this.kindCase_ = 0;
        this.kind_ = null;
        return this;
    }

    public Value$Builder clearBoolValue() {
        int n10 = this.kindCase_;
        int n11 = 4;
        if (n10 == n11) {
            this.kindCase_ = 0;
            n10 = 0;
            this.kind_ = null;
            this.onChanged();
        }
        return this;
    }

    public Value$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (Value$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public Value$Builder clearKind() {
        this.kindCase_ = 0;
        this.kind_ = null;
        this.onChanged();
        return this;
    }

    public Value$Builder clearListValue() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.listValueBuilder_;
        int n10 = 6;
        if (singleFieldBuilderV3 == null) {
            int n11 = this.kindCase_;
            if (n11 == n10) {
                this.kindCase_ = 0;
                this.kind_ = null;
                this.onChanged();
            }
        } else {
            int n12 = this.kindCase_;
            if (n12 == n10) {
                this.kindCase_ = 0;
                this.kind_ = null;
            }
            singleFieldBuilderV3.clear();
        }
        return this;
    }

    public Value$Builder clearNullValue() {
        int n10 = this.kindCase_;
        int n11 = 1;
        if (n10 == n11) {
            this.kindCase_ = 0;
            n10 = 0;
            this.kind_ = null;
            this.onChanged();
        }
        return this;
    }

    public Value$Builder clearNumberValue() {
        int n10 = this.kindCase_;
        int n11 = 2;
        if (n10 == n11) {
            this.kindCase_ = 0;
            n10 = 0;
            this.kind_ = null;
            this.onChanged();
        }
        return this;
    }

    public Value$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (Value$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public Value$Builder clearStringValue() {
        int n10 = this.kindCase_;
        int n11 = 3;
        if (n10 == n11) {
            this.kindCase_ = 0;
            n10 = 0;
            this.kind_ = null;
            this.onChanged();
        }
        return this;
    }

    public Value$Builder clearStructValue() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.structValueBuilder_;
        int n10 = 5;
        if (singleFieldBuilderV3 == null) {
            int n11 = this.kindCase_;
            if (n11 == n10) {
                this.kindCase_ = 0;
                this.kind_ = null;
                this.onChanged();
            }
        } else {
            int n12 = this.kindCase_;
            if (n12 == n10) {
                this.kindCase_ = 0;
                this.kind_ = null;
            }
            singleFieldBuilderV3.clear();
        }
        return this;
    }

    public Value$Builder clone() {
        return (Value$Builder)super.clone();
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
        return Value.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return StructProto.internal_static_google_protobuf_Value_descriptor;
    }

    public Value$KindCase getKindCase() {
        return Value$KindCase.forNumber(this.kindCase_);
    }

    public ListValue getListValue() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.listValueBuilder_;
        int n10 = 6;
        if (singleFieldBuilderV3 == null) {
            int n11 = this.kindCase_;
            if (n11 == n10) {
                return (ListValue)this.kind_;
            }
            return ListValue.getDefaultInstance();
        }
        int n12 = this.kindCase_;
        if (n12 == n10) {
            return (ListValue)singleFieldBuilderV3.getMessage();
        }
        return ListValue.getDefaultInstance();
    }

    public ListValue$Builder getListValueBuilder() {
        return (ListValue$Builder)this.getListValueFieldBuilder().getBuilder();
    }

    public ListValueOrBuilder getListValueOrBuilder() {
        SingleFieldBuilderV3 singleFieldBuilderV3;
        int n10 = this.kindCase_;
        int n11 = 6;
        if (n10 == n11 && (singleFieldBuilderV3 = this.listValueBuilder_) != null) {
            return (ListValueOrBuilder)singleFieldBuilderV3.getMessageOrBuilder();
        }
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

    public String getStringValue() {
        int n10 = this.kindCase_;
        int n11 = 3;
        Object object = n10 == n11 ? this.kind_ : "";
        int n12 = object instanceof String;
        if (n12 == 0) {
            object = ((ByteString)object).toStringUtf8();
            n12 = this.kindCase_;
            if (n12 == n11) {
                this.kind_ = object;
            }
            return object;
        }
        return (String)object;
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
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.structValueBuilder_;
        int n10 = 5;
        if (singleFieldBuilderV3 == null) {
            int n11 = this.kindCase_;
            if (n11 == n10) {
                return (Struct)this.kind_;
            }
            return Struct.getDefaultInstance();
        }
        int n12 = this.kindCase_;
        if (n12 == n10) {
            return (Struct)singleFieldBuilderV3.getMessage();
        }
        return Struct.getDefaultInstance();
    }

    public Struct$Builder getStructValueBuilder() {
        return (Struct$Builder)this.getStructValueFieldBuilder().getBuilder();
    }

    public StructOrBuilder getStructValueOrBuilder() {
        SingleFieldBuilderV3 singleFieldBuilderV3;
        int n10 = this.kindCase_;
        int n11 = 5;
        if (n10 == n11 && (singleFieldBuilderV3 = this.structValueBuilder_) != null) {
            return (StructOrBuilder)singleFieldBuilderV3.getMessageOrBuilder();
        }
        if (n10 == n11) {
            return (Struct)this.kind_;
        }
        return Struct.getDefaultInstance();
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

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return StructProto.internal_static_google_protobuf_Value_fieldAccessorTable.ensureFieldAccessorsInitialized(Value.class, Value$Builder.class);
    }

    public final boolean isInitialized() {
        return true;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Value$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = Value.access$500();
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (Value)object;
            if (object == null) break block7;
            this.mergeFrom((Value)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (Value)object2;
            }
            try {
                IOException iOException = invalidProtocolBufferException.unwrapIOException();
                throw iOException;
            }
            catch (Throwable throwable) {
                object3 = object2;
            }
        }
        if (object3 != null) {
            this.mergeFrom((Value)object3);
        }
        throw var1_6;
    }

    public Value$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof Value;
        if (bl2) {
            message = (Value)message;
            return this.mergeFrom((Value)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public Value$Builder mergeFrom(Value messageLite) {
        Object object = Value.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        object = Value$2.$SwitchMap$com$google$protobuf$Value$KindCase;
        Value$KindCase value$KindCase = messageLite.getKindCase();
        int n10 = value$KindCase.ordinal();
        Object object2 = object[n10];
        switch (object2) {
            default: {
                break;
            }
            case 6: {
                object = messageLite.getListValue();
                this.mergeListValue((ListValue)object);
                break;
            }
            case 5: {
                object = messageLite.getStructValue();
                this.mergeStructValue((Struct)object);
                break;
            }
            case 4: {
                object2 = messageLite.getBoolValue();
                this.setBoolValue((boolean)object2);
                break;
            }
            case 3: {
                object2 = 3;
                this.kindCase_ = (int)object2;
                this.kind_ = object = Value.access$300(messageLite);
                this.onChanged();
                break;
            }
            case 2: {
                double d10 = messageLite.getNumberValue();
                this.setNumberValue(d10);
                break;
            }
            case 1: {
                object2 = messageLite.getNullValueValue();
                this.setNullValueValue((int)object2);
            }
        }
        messageLite = messageLite.unknownFields;
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    public Value$Builder mergeListValue(ListValue listValue) {
        Object object = this.listValueBuilder_;
        int n10 = 6;
        if (object == null) {
            ListValue listValue2;
            int n11 = this.kindCase_;
            if (n11 == n10 && (object = this.kind_) != (listValue2 = ListValue.getDefaultInstance())) {
                object = ListValue.newBuilder((ListValue)this.kind_);
                listValue = ((ListValue$Builder)object).mergeFrom(listValue).buildPartial();
                this.kind_ = listValue;
            } else {
                this.kind_ = listValue;
            }
            this.onChanged();
        } else {
            int n12 = this.kindCase_;
            if (n12 == n10) {
                ((SingleFieldBuilderV3)object).mergeFrom(listValue);
            }
            object = this.listValueBuilder_;
            ((SingleFieldBuilderV3)object).setMessage(listValue);
        }
        this.kindCase_ = n10;
        return this;
    }

    public Value$Builder mergeStructValue(Struct message) {
        Object object = this.structValueBuilder_;
        int n10 = 5;
        if (object == null) {
            Struct struct;
            int n11 = this.kindCase_;
            if (n11 == n10 && (object = this.kind_) != (struct = Struct.getDefaultInstance())) {
                object = Struct.newBuilder((Struct)this.kind_);
                message = ((Struct$Builder)object).mergeFrom((Struct)message).buildPartial();
                this.kind_ = message;
            } else {
                this.kind_ = message;
            }
            this.onChanged();
        } else {
            int n12 = this.kindCase_;
            if (n12 == n10) {
                ((SingleFieldBuilderV3)object).mergeFrom((AbstractMessage)message);
            }
            object = this.structValueBuilder_;
            ((SingleFieldBuilderV3)object).setMessage((AbstractMessage)message);
        }
        this.kindCase_ = n10;
        return this;
    }

    public final Value$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Value$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public Value$Builder setBoolValue(boolean bl2) {
        this.kindCase_ = 4;
        Boolean bl3 = bl2;
        this.kind_ = bl3;
        this.onChanged();
        return this;
    }

    public Value$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Value$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public Value$Builder setListValue(ListValue$Builder listValueOrBuilder) {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.listValueBuilder_;
        if (singleFieldBuilderV3 == null) {
            listValueOrBuilder = listValueOrBuilder.build();
            this.kind_ = listValueOrBuilder;
            this.onChanged();
        } else {
            listValueOrBuilder = listValueOrBuilder.build();
            singleFieldBuilderV3.setMessage((AbstractMessage)((Object)listValueOrBuilder));
        }
        this.kindCase_ = 6;
        return this;
    }

    public Value$Builder setListValue(ListValue listValue) {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.listValueBuilder_;
        if (singleFieldBuilderV3 == null) {
            Objects.requireNonNull(listValue);
            this.kind_ = listValue;
            this.onChanged();
        } else {
            singleFieldBuilderV3.setMessage(listValue);
        }
        this.kindCase_ = 6;
        return this;
    }

    public Value$Builder setNullValue(NullValue object) {
        Objects.requireNonNull(object);
        this.kindCase_ = 1;
        this.kind_ = object = Integer.valueOf(((NullValue)object).getNumber());
        this.onChanged();
        return this;
    }

    public Value$Builder setNullValueValue(int n10) {
        this.kindCase_ = 1;
        Integer n11 = n10;
        this.kind_ = n11;
        this.onChanged();
        return this;
    }

    public Value$Builder setNumberValue(double d10) {
        this.kindCase_ = 2;
        Double d11 = d10;
        this.kind_ = d11;
        this.onChanged();
        return this;
    }

    public Value$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (Value$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public Value$Builder setStringValue(String string2) {
        Objects.requireNonNull(string2);
        this.kindCase_ = 3;
        this.kind_ = string2;
        this.onChanged();
        return this;
    }

    public Value$Builder setStringValueBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.kindCase_ = 3;
        this.kind_ = byteString;
        this.onChanged();
        return this;
    }

    public Value$Builder setStructValue(Struct$Builder messageOrBuilder) {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.structValueBuilder_;
        if (singleFieldBuilderV3 == null) {
            messageOrBuilder = messageOrBuilder.build();
            this.kind_ = messageOrBuilder;
            this.onChanged();
        } else {
            messageOrBuilder = messageOrBuilder.build();
            singleFieldBuilderV3.setMessage((AbstractMessage)messageOrBuilder);
        }
        this.kindCase_ = 5;
        return this;
    }

    public Value$Builder setStructValue(Struct struct) {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.structValueBuilder_;
        if (singleFieldBuilderV3 == null) {
            Objects.requireNonNull(struct);
            this.kind_ = struct;
            this.onChanged();
        } else {
            singleFieldBuilderV3.setMessage(struct);
        }
        this.kindCase_ = 5;
        return this;
    }

    public final Value$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Value$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

