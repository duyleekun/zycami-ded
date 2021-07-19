/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.ListValue;
import com.google.protobuf.ListValue$1;
import com.google.protobuf.ListValueOrBuilder;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.StructProto;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.Value;
import com.google.protobuf.Value$Builder;
import com.google.protobuf.ValueOrBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class ListValue$Builder
extends GeneratedMessageV3$Builder
implements ListValueOrBuilder {
    private int bitField0_;
    private RepeatedFieldBuilderV3 valuesBuilder_;
    private List values_;

    private ListValue$Builder() {
        List list;
        this.values_ = list = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }

    private ListValue$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        this.values_ = object = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ ListValue$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, ListValue$1 listValue$1) {
        this(generatedMessageV3$BuilderParent);
    }

    public /* synthetic */ ListValue$Builder(ListValue$1 listValue$1) {
        this();
    }

    private void ensureValuesIsMutable() {
        int n10 = this.bitField0_ & 1;
        if (n10 == 0) {
            ArrayList arrayList;
            List list = this.values_;
            this.values_ = arrayList = new ArrayList(list);
            this.bitField0_ = n10 = this.bitField0_ | 1;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return StructProto.internal_static_google_protobuf_ListValue_descriptor;
    }

    private RepeatedFieldBuilderV3 getValuesFieldBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.valuesBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            List list = this.values_;
            int n10 = this.bitField0_;
            int n11 = 1;
            if ((n10 &= n11) == 0) {
                n11 = 0;
            }
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.valuesBuilder_ = repeatedFieldBuilderV3 = new RepeatedFieldBuilderV3(list, n11 != 0, generatedMessageV3$BuilderParent, bl2);
            repeatedFieldBuilderV3 = null;
            this.values_ = null;
        }
        return this.valuesBuilder_;
    }

    private void maybeForceBuilderInitialization() {
        boolean bl2 = GeneratedMessageV3.alwaysUseFieldBuilders;
        if (bl2) {
            this.getValuesFieldBuilder();
        }
    }

    public ListValue$Builder addAllValues(Iterable iterable) {
        Object object = this.valuesBuilder_;
        if (object == null) {
            this.ensureValuesIsMutable();
            object = this.values_;
            AbstractMessageLite$Builder.addAll(iterable, (List)object);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addAllMessages(iterable);
        }
        return this;
    }

    public ListValue$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (ListValue$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public ListValue$Builder addValues(int n10, Value$Builder messageOrBuilder) {
        Object object = this.valuesBuilder_;
        if (object == null) {
            this.ensureValuesIsMutable();
            object = this.values_;
            messageOrBuilder = ((Value$Builder)messageOrBuilder).build();
            object.add(n10, messageOrBuilder);
            this.onChanged();
        } else {
            messageOrBuilder = ((Value$Builder)messageOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage(n10, (AbstractMessage)messageOrBuilder);
        }
        return this;
    }

    public ListValue$Builder addValues(int n10, Value value) {
        Object object = this.valuesBuilder_;
        if (object == null) {
            Objects.requireNonNull(value);
            this.ensureValuesIsMutable();
            object = this.values_;
            object.add(n10, value);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(n10, value);
        }
        return this;
    }

    public ListValue$Builder addValues(Value$Builder messageOrBuilder) {
        Object object = this.valuesBuilder_;
        if (object == null) {
            this.ensureValuesIsMutable();
            object = this.values_;
            messageOrBuilder = ((Value$Builder)messageOrBuilder).build();
            object.add(messageOrBuilder);
            this.onChanged();
        } else {
            messageOrBuilder = ((Value$Builder)messageOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage((AbstractMessage)messageOrBuilder);
        }
        return this;
    }

    public ListValue$Builder addValues(Value value) {
        Object object = this.valuesBuilder_;
        if (object == null) {
            Objects.requireNonNull(value);
            this.ensureValuesIsMutable();
            object = this.values_;
            object.add(value);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(value);
        }
        return this;
    }

    public Value$Builder addValuesBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getValuesFieldBuilder();
        Value value = Value.getDefaultInstance();
        return (Value$Builder)repeatedFieldBuilderV3.addBuilder(value);
    }

    public Value$Builder addValuesBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getValuesFieldBuilder();
        Value value = Value.getDefaultInstance();
        return (Value$Builder)repeatedFieldBuilderV3.addBuilder(n10, value);
    }

    public ListValue build() {
        ListValue listValue = this.buildPartial();
        boolean bl2 = listValue.isInitialized();
        if (bl2) {
            return listValue;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(listValue);
    }

    public ListValue buildPartial() {
        List list = null;
        ListValue listValue = new ListValue(this, null);
        int n10 = this.bitField0_;
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.valuesBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            if ((n10 &= 1) != 0) {
                this.values_ = list = Collections.unmodifiableList(this.values_);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
            }
            list = this.values_;
            ListValue.access$302(listValue, list);
        } else {
            list = repeatedFieldBuilderV3.build();
            ListValue.access$302(listValue, list);
        }
        this.onBuilt();
        return listValue;
    }

    public ListValue$Builder clear() {
        super.clear();
        Object object = this.valuesBuilder_;
        if (object == null) {
            int n10;
            this.values_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public ListValue$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (ListValue$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public ListValue$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (ListValue$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public ListValue$Builder clearValues() {
        Object object = this.valuesBuilder_;
        if (object == null) {
            int n10;
            this.values_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public ListValue$Builder clone() {
        return (ListValue$Builder)super.clone();
    }

    public ListValue getDefaultInstanceForType() {
        return ListValue.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return StructProto.internal_static_google_protobuf_ListValue_descriptor;
    }

    public Value getValues(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.valuesBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (Value)this.values_.get(n10);
        }
        return (Value)repeatedFieldBuilderV3.getMessage(n10);
    }

    public Value$Builder getValuesBuilder(int n10) {
        return (Value$Builder)this.getValuesFieldBuilder().getBuilder(n10);
    }

    public List getValuesBuilderList() {
        return this.getValuesFieldBuilder().getBuilderList();
    }

    public int getValuesCount() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.valuesBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return this.values_.size();
        }
        return repeatedFieldBuilderV3.getCount();
    }

    public List getValuesList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.valuesBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return Collections.unmodifiableList(this.values_);
        }
        return repeatedFieldBuilderV3.getMessageList();
    }

    public ValueOrBuilder getValuesOrBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.valuesBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (ValueOrBuilder)this.values_.get(n10);
        }
        return (ValueOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(n10);
    }

    public List getValuesOrBuilderList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.valuesBuilder_;
        if (repeatedFieldBuilderV3 != null) {
            return repeatedFieldBuilderV3.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(this.values_);
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return StructProto.internal_static_google_protobuf_ListValue_fieldAccessorTable.ensureFieldAccessorsInitialized(ListValue.class, ListValue$Builder.class);
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
    public ListValue$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = ListValue.access$400();
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (ListValue)object;
            if (object == null) break block7;
            this.mergeFrom((ListValue)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (ListValue)object2;
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
            this.mergeFrom((ListValue)object3);
        }
        throw var1_6;
    }

    public ListValue$Builder mergeFrom(ListValue messageLite) {
        Object object = ListValue.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        object = this.valuesBuilder_;
        if (object == null) {
            object = ListValue.access$300(messageLite);
            int n10 = object.isEmpty();
            if (n10 == 0) {
                object = this.values_;
                n10 = object.isEmpty();
                if (n10 != 0) {
                    this.values_ = object = ListValue.access$300(messageLite);
                    this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
                } else {
                    this.ensureValuesIsMutable();
                    object = this.values_;
                    List list = ListValue.access$300(messageLite);
                    object.addAll(list);
                }
                this.onChanged();
            }
        } else {
            object = ListValue.access$300(messageLite);
            boolean bl2 = object.isEmpty();
            if (!bl2) {
                object = this.valuesBuilder_;
                bl2 = ((RepeatedFieldBuilderV3)object).isEmpty();
                if (bl2) {
                    int n11;
                    List list;
                    this.valuesBuilder_.dispose();
                    bl2 = false;
                    object = null;
                    this.valuesBuilder_ = null;
                    this.values_ = list = ListValue.access$300(messageLite);
                    this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
                    n11 = (int)(GeneratedMessageV3.alwaysUseFieldBuilders ? 1 : 0);
                    if (n11 != 0) {
                        object = this.getValuesFieldBuilder();
                    }
                    this.valuesBuilder_ = object;
                } else {
                    object = this.valuesBuilder_;
                    List list = ListValue.access$300(messageLite);
                    ((RepeatedFieldBuilderV3)object).addAllMessages(list);
                }
            }
        }
        messageLite = messageLite.unknownFields;
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    public ListValue$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof ListValue;
        if (bl2) {
            message = (ListValue)message;
            return this.mergeFrom((ListValue)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final ListValue$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (ListValue$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public ListValue$Builder removeValues(int n10) {
        Object object = this.valuesBuilder_;
        if (object == null) {
            this.ensureValuesIsMutable();
            object = this.values_;
            object.remove(n10);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).remove(n10);
        }
        return this;
    }

    public ListValue$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (ListValue$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public ListValue$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (ListValue$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public final ListValue$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (ListValue$Builder)super.setUnknownFields(unknownFieldSet);
    }

    public ListValue$Builder setValues(int n10, Value$Builder messageOrBuilder) {
        Object object = this.valuesBuilder_;
        if (object == null) {
            this.ensureValuesIsMutable();
            object = this.values_;
            messageOrBuilder = ((Value$Builder)messageOrBuilder).build();
            object.set(n10, messageOrBuilder);
            this.onChanged();
        } else {
            messageOrBuilder = ((Value$Builder)messageOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).setMessage(n10, (AbstractMessage)messageOrBuilder);
        }
        return this;
    }

    public ListValue$Builder setValues(int n10, Value value) {
        Object object = this.valuesBuilder_;
        if (object == null) {
            Objects.requireNonNull(value);
            this.ensureValuesIsMutable();
            object = this.values_;
            object.set(n10, value);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).setMessage(n10, value);
        }
        return this;
    }
}

