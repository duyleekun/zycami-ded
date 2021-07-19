/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.EnumValue;
import com.google.protobuf.EnumValue$1;
import com.google.protobuf.EnumValueOrBuilder;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Option;
import com.google.protobuf.Option$Builder;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.TypeProto;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class EnumValue$Builder
extends GeneratedMessageV3$Builder
implements EnumValueOrBuilder {
    private int bitField0_;
    private Object name_ = "";
    private int number_;
    private RepeatedFieldBuilderV3 optionsBuilder_;
    private List options_;

    private EnumValue$Builder() {
        List list;
        this.options_ = list = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ EnumValue$Builder(EnumValue$1 enumValue$1) {
        this();
    }

    private EnumValue$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        this.options_ = object = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ EnumValue$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, EnumValue$1 enumValue$1) {
        this(generatedMessageV3$BuilderParent);
    }

    private void ensureOptionsIsMutable() {
        int n10 = this.bitField0_ & 1;
        if (n10 == 0) {
            ArrayList arrayList;
            List list = this.options_;
            this.options_ = arrayList = new ArrayList(list);
            this.bitField0_ = n10 = this.bitField0_ | 1;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_EnumValue_descriptor;
    }

    private RepeatedFieldBuilderV3 getOptionsFieldBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.optionsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            List list = this.options_;
            int n10 = this.bitField0_;
            int n11 = 1;
            if ((n10 &= n11) == 0) {
                n11 = 0;
            }
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.optionsBuilder_ = repeatedFieldBuilderV3 = new RepeatedFieldBuilderV3(list, n11 != 0, generatedMessageV3$BuilderParent, bl2);
            repeatedFieldBuilderV3 = null;
            this.options_ = null;
        }
        return this.optionsBuilder_;
    }

    private void maybeForceBuilderInitialization() {
        boolean bl2 = GeneratedMessageV3.alwaysUseFieldBuilders;
        if (bl2) {
            this.getOptionsFieldBuilder();
        }
    }

    public EnumValue$Builder addAllOptions(Iterable iterable) {
        Object object = this.optionsBuilder_;
        if (object == null) {
            this.ensureOptionsIsMutable();
            object = this.options_;
            AbstractMessageLite$Builder.addAll(iterable, (List)object);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addAllMessages(iterable);
        }
        return this;
    }

    public EnumValue$Builder addOptions(int n10, Option$Builder messageOrBuilder) {
        Object object = this.optionsBuilder_;
        if (object == null) {
            this.ensureOptionsIsMutable();
            object = this.options_;
            messageOrBuilder = ((Option$Builder)messageOrBuilder).build();
            object.add(n10, messageOrBuilder);
            this.onChanged();
        } else {
            messageOrBuilder = ((Option$Builder)messageOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage(n10, (AbstractMessage)messageOrBuilder);
        }
        return this;
    }

    public EnumValue$Builder addOptions(int n10, Option option) {
        Object object = this.optionsBuilder_;
        if (object == null) {
            Objects.requireNonNull(option);
            this.ensureOptionsIsMutable();
            object = this.options_;
            object.add(n10, option);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(n10, option);
        }
        return this;
    }

    public EnumValue$Builder addOptions(Option$Builder messageOrBuilder) {
        Object object = this.optionsBuilder_;
        if (object == null) {
            this.ensureOptionsIsMutable();
            object = this.options_;
            messageOrBuilder = ((Option$Builder)messageOrBuilder).build();
            object.add(messageOrBuilder);
            this.onChanged();
        } else {
            messageOrBuilder = ((Option$Builder)messageOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage((AbstractMessage)messageOrBuilder);
        }
        return this;
    }

    public EnumValue$Builder addOptions(Option option) {
        Object object = this.optionsBuilder_;
        if (object == null) {
            Objects.requireNonNull(option);
            this.ensureOptionsIsMutable();
            object = this.options_;
            object.add(option);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(option);
        }
        return this;
    }

    public Option$Builder addOptionsBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getOptionsFieldBuilder();
        Option option = Option.getDefaultInstance();
        return (Option$Builder)repeatedFieldBuilderV3.addBuilder(option);
    }

    public Option$Builder addOptionsBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getOptionsFieldBuilder();
        Option option = Option.getDefaultInstance();
        return (Option$Builder)repeatedFieldBuilderV3.addBuilder(n10, option);
    }

    public EnumValue$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (EnumValue$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public EnumValue build() {
        EnumValue enumValue = this.buildPartial();
        boolean bl2 = enumValue.isInitialized();
        if (bl2) {
            return enumValue;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(enumValue);
    }

    public EnumValue buildPartial() {
        EnumValue enumValue = new EnumValue(this, null);
        List list = this.name_;
        EnumValue.access$302(enumValue, list);
        int n10 = this.number_;
        EnumValue.access$402(enumValue, n10);
        list = this.optionsBuilder_;
        if (list == null) {
            n10 = this.bitField0_ & 1;
            if (n10 != 0) {
                this.options_ = list = Collections.unmodifiableList(this.options_);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
            }
            list = this.options_;
            EnumValue.access$502(enumValue, list);
        } else {
            list = ((RepeatedFieldBuilderV3)((Object)list)).build();
            EnumValue.access$502(enumValue, list);
        }
        this.onBuilt();
        return enumValue;
    }

    public EnumValue$Builder clear() {
        super.clear();
        this.name_ = "";
        int n10 = 0;
        this.number_ = 0;
        Object object = this.optionsBuilder_;
        if (object == null) {
            this.options_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public EnumValue$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (EnumValue$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public EnumValue$Builder clearName() {
        String string2 = EnumValue.getDefaultInstance().getName();
        this.name_ = string2;
        this.onChanged();
        return this;
    }

    public EnumValue$Builder clearNumber() {
        this.number_ = 0;
        this.onChanged();
        return this;
    }

    public EnumValue$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (EnumValue$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public EnumValue$Builder clearOptions() {
        Object object = this.optionsBuilder_;
        if (object == null) {
            int n10;
            this.options_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public EnumValue$Builder clone() {
        return (EnumValue$Builder)super.clone();
    }

    public EnumValue getDefaultInstanceForType() {
        return EnumValue.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return TypeProto.internal_static_google_protobuf_EnumValue_descriptor;
    }

    public String getName() {
        Object object = this.name_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            this.name_ = object = ((ByteString)object).toStringUtf8();
            return object;
        }
        return (String)object;
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

    public int getNumber() {
        return this.number_;
    }

    public Option getOptions(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.optionsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (Option)this.options_.get(n10);
        }
        return (Option)repeatedFieldBuilderV3.getMessage(n10);
    }

    public Option$Builder getOptionsBuilder(int n10) {
        return (Option$Builder)this.getOptionsFieldBuilder().getBuilder(n10);
    }

    public List getOptionsBuilderList() {
        return this.getOptionsFieldBuilder().getBuilderList();
    }

    public int getOptionsCount() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.optionsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return this.options_.size();
        }
        return repeatedFieldBuilderV3.getCount();
    }

    public List getOptionsList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.optionsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return Collections.unmodifiableList(this.options_);
        }
        return repeatedFieldBuilderV3.getMessageList();
    }

    public OptionOrBuilder getOptionsOrBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.optionsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (OptionOrBuilder)this.options_.get(n10);
        }
        return (OptionOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(n10);
    }

    public List getOptionsOrBuilderList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.optionsBuilder_;
        if (repeatedFieldBuilderV3 != null) {
            return repeatedFieldBuilderV3.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(this.options_);
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_EnumValue_fieldAccessorTable.ensureFieldAccessorsInitialized(EnumValue.class, EnumValue$Builder.class);
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
    public EnumValue$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = EnumValue.access$600();
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (EnumValue)object;
            if (object == null) break block7;
            this.mergeFrom((EnumValue)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (EnumValue)object2;
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
            this.mergeFrom((EnumValue)object3);
        }
        throw var1_6;
    }

    public EnumValue$Builder mergeFrom(EnumValue messageLite) {
        int n10;
        Object object = EnumValue.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        object = ((EnumValue)messageLite).getName();
        boolean n102 = ((String)object).isEmpty();
        if (!n102) {
            this.name_ = object = EnumValue.access$300((EnumValue)messageLite);
            this.onChanged();
        }
        if ((n10 = ((EnumValue)messageLite).getNumber()) != 0) {
            int n11 = ((EnumValue)messageLite).getNumber();
            this.setNumber(n11);
        }
        if ((object = this.optionsBuilder_) == null) {
            object = EnumValue.access$500((EnumValue)messageLite);
            boolean bl2 = object.isEmpty();
            if (!bl2) {
                object = this.options_;
                boolean bl3 = object.isEmpty();
                if (bl3) {
                    int n12;
                    this.options_ = object = EnumValue.access$500((EnumValue)messageLite);
                    this.bitField0_ = n12 = this.bitField0_ & 0xFFFFFFFE;
                } else {
                    this.ensureOptionsIsMutable();
                    object = this.options_;
                    List list = EnumValue.access$500((EnumValue)messageLite);
                    object.addAll(list);
                }
                this.onChanged();
            }
        } else {
            object = EnumValue.access$500((EnumValue)messageLite);
            boolean bl4 = object.isEmpty();
            if (!bl4) {
                object = this.optionsBuilder_;
                boolean bl5 = ((RepeatedFieldBuilderV3)object).isEmpty();
                if (bl5) {
                    int n13;
                    List list;
                    this.optionsBuilder_.dispose();
                    boolean bl6 = false;
                    object = null;
                    this.optionsBuilder_ = null;
                    this.options_ = list = EnumValue.access$500((EnumValue)messageLite);
                    this.bitField0_ = n13 = this.bitField0_ & 0xFFFFFFFE;
                    n13 = (int)(GeneratedMessageV3.alwaysUseFieldBuilders ? 1 : 0);
                    if (n13 != 0) {
                        object = this.getOptionsFieldBuilder();
                    }
                    this.optionsBuilder_ = object;
                } else {
                    object = this.optionsBuilder_;
                    List list = EnumValue.access$500((EnumValue)messageLite);
                    ((RepeatedFieldBuilderV3)object).addAllMessages(list);
                }
            }
        }
        messageLite = ((GeneratedMessageV3)messageLite).unknownFields;
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    public EnumValue$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof EnumValue;
        if (bl2) {
            message = (EnumValue)message;
            return this.mergeFrom((EnumValue)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final EnumValue$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (EnumValue$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public EnumValue$Builder removeOptions(int n10) {
        Object object = this.optionsBuilder_;
        if (object == null) {
            this.ensureOptionsIsMutable();
            object = this.options_;
            object.remove(n10);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).remove(n10);
        }
        return this;
    }

    public EnumValue$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (EnumValue$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public EnumValue$Builder setName(String string2) {
        Objects.requireNonNull(string2);
        this.name_ = string2;
        this.onChanged();
        return this;
    }

    public EnumValue$Builder setNameBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.name_ = byteString;
        this.onChanged();
        return this;
    }

    public EnumValue$Builder setNumber(int n10) {
        this.number_ = n10;
        this.onChanged();
        return this;
    }

    public EnumValue$Builder setOptions(int n10, Option$Builder messageOrBuilder) {
        Object object = this.optionsBuilder_;
        if (object == null) {
            this.ensureOptionsIsMutable();
            object = this.options_;
            messageOrBuilder = ((Option$Builder)messageOrBuilder).build();
            object.set(n10, messageOrBuilder);
            this.onChanged();
        } else {
            messageOrBuilder = ((Option$Builder)messageOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).setMessage(n10, (AbstractMessage)messageOrBuilder);
        }
        return this;
    }

    public EnumValue$Builder setOptions(int n10, Option option) {
        Object object = this.optionsBuilder_;
        if (object == null) {
            Objects.requireNonNull(option);
            this.ensureOptionsIsMutable();
            object = this.options_;
            object.set(n10, option);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).setMessage(n10, option);
        }
        return this;
    }

    public EnumValue$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (EnumValue$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public final EnumValue$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (EnumValue$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

