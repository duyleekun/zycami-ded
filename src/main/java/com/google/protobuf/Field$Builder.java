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
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Field;
import com.google.protobuf.Field$1;
import com.google.protobuf.Field$Cardinality;
import com.google.protobuf.Field$Kind;
import com.google.protobuf.FieldOrBuilder;
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

public final class Field$Builder
extends GeneratedMessageV3$Builder
implements FieldOrBuilder {
    private int bitField0_;
    private int cardinality_ = 0;
    private Object defaultValue_;
    private Object jsonName_;
    private int kind_ = 0;
    private Object name_;
    private int number_;
    private int oneofIndex_;
    private RepeatedFieldBuilderV3 optionsBuilder_;
    private List options_;
    private boolean packed_;
    private Object typeUrl_;

    private Field$Builder() {
        List list;
        String string2 = "";
        this.name_ = string2;
        this.typeUrl_ = string2;
        this.options_ = list = Collections.emptyList();
        this.jsonName_ = string2;
        this.defaultValue_ = string2;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Field$Builder(Field$1 field$1) {
        this();
    }

    private Field$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        List list;
        this.name_ = object = "";
        this.typeUrl_ = object;
        this.options_ = list = Collections.emptyList();
        this.jsonName_ = object;
        this.defaultValue_ = object;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Field$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, Field$1 field$1) {
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
        return TypeProto.internal_static_google_protobuf_Field_descriptor;
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

    public Field$Builder addAllOptions(Iterable iterable) {
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

    public Field$Builder addOptions(int n10, Option$Builder messageOrBuilder) {
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

    public Field$Builder addOptions(int n10, Option option) {
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

    public Field$Builder addOptions(Option$Builder messageOrBuilder) {
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

    public Field$Builder addOptions(Option option) {
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

    public Field$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Field$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public Field build() {
        Field field = this.buildPartial();
        boolean bl2 = field.isInitialized();
        if (bl2) {
            return field;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(field);
    }

    public Field buildPartial() {
        Field field = new Field(this, null);
        int n10 = this.kind_;
        Field.access$302(field, n10);
        n10 = this.cardinality_;
        Field.access$402(field, n10);
        n10 = this.number_;
        Field.access$502(field, n10);
        Object object = this.name_;
        Field.access$602(field, object);
        object = this.typeUrl_;
        Field.access$702(field, object);
        n10 = this.oneofIndex_;
        Field.access$802(field, n10);
        n10 = (int)(this.packed_ ? 1 : 0);
        Field.access$902(field, n10 != 0);
        object = this.optionsBuilder_;
        if (object == null) {
            n10 = this.bitField0_ & 1;
            if (n10 != 0) {
                object = Collections.unmodifiableList(this.options_);
                this.options_ = object;
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
            }
            object = this.options_;
            Field.access$1002(field, object);
        } else {
            object = ((RepeatedFieldBuilderV3)object).build();
            Field.access$1002(field, (List)object);
        }
        object = this.jsonName_;
        Field.access$1102(field, object);
        object = this.defaultValue_;
        Field.access$1202(field, object);
        this.onBuilt();
        return field;
    }

    public Field$Builder clear() {
        super.clear();
        int n10 = 0;
        this.kind_ = 0;
        this.cardinality_ = 0;
        this.number_ = 0;
        String string2 = "";
        this.name_ = string2;
        this.typeUrl_ = string2;
        this.oneofIndex_ = 0;
        this.packed_ = false;
        Object object = this.optionsBuilder_;
        if (object == null) {
            this.options_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        this.jsonName_ = string2;
        this.defaultValue_ = string2;
        return this;
    }

    public Field$Builder clearCardinality() {
        this.cardinality_ = 0;
        this.onChanged();
        return this;
    }

    public Field$Builder clearDefaultValue() {
        String string2 = Field.getDefaultInstance().getDefaultValue();
        this.defaultValue_ = string2;
        this.onChanged();
        return this;
    }

    public Field$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (Field$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public Field$Builder clearJsonName() {
        String string2 = Field.getDefaultInstance().getJsonName();
        this.jsonName_ = string2;
        this.onChanged();
        return this;
    }

    public Field$Builder clearKind() {
        this.kind_ = 0;
        this.onChanged();
        return this;
    }

    public Field$Builder clearName() {
        String string2 = Field.getDefaultInstance().getName();
        this.name_ = string2;
        this.onChanged();
        return this;
    }

    public Field$Builder clearNumber() {
        this.number_ = 0;
        this.onChanged();
        return this;
    }

    public Field$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (Field$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public Field$Builder clearOneofIndex() {
        this.oneofIndex_ = 0;
        this.onChanged();
        return this;
    }

    public Field$Builder clearOptions() {
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

    public Field$Builder clearPacked() {
        this.packed_ = false;
        this.onChanged();
        return this;
    }

    public Field$Builder clearTypeUrl() {
        String string2 = Field.getDefaultInstance().getTypeUrl();
        this.typeUrl_ = string2;
        this.onChanged();
        return this;
    }

    public Field$Builder clone() {
        return (Field$Builder)super.clone();
    }

    public Field$Cardinality getCardinality() {
        int n10 = this.cardinality_;
        Field$Cardinality field$Cardinality = Field$Cardinality.valueOf(n10);
        if (field$Cardinality == null) {
            field$Cardinality = Field$Cardinality.UNRECOGNIZED;
        }
        return field$Cardinality;
    }

    public int getCardinalityValue() {
        return this.cardinality_;
    }

    public Field getDefaultInstanceForType() {
        return Field.getDefaultInstance();
    }

    public String getDefaultValue() {
        Object object = this.defaultValue_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            this.defaultValue_ = object = ((ByteString)object).toStringUtf8();
            return object;
        }
        return (String)object;
    }

    public ByteString getDefaultValueBytes() {
        Object object = this.defaultValue_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.defaultValue_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return TypeProto.internal_static_google_protobuf_Field_descriptor;
    }

    public String getJsonName() {
        Object object = this.jsonName_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            this.jsonName_ = object = ((ByteString)object).toStringUtf8();
            return object;
        }
        return (String)object;
    }

    public ByteString getJsonNameBytes() {
        Object object = this.jsonName_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.jsonName_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public Field$Kind getKind() {
        int n10 = this.kind_;
        Field$Kind field$Kind = Field$Kind.valueOf(n10);
        if (field$Kind == null) {
            field$Kind = Field$Kind.UNRECOGNIZED;
        }
        return field$Kind;
    }

    public int getKindValue() {
        return this.kind_;
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

    public int getOneofIndex() {
        return this.oneofIndex_;
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

    public boolean getPacked() {
        return this.packed_;
    }

    public String getTypeUrl() {
        Object object = this.typeUrl_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            this.typeUrl_ = object = ((ByteString)object).toStringUtf8();
            return object;
        }
        return (String)object;
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

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_Field_fieldAccessorTable.ensureFieldAccessorsInitialized(Field.class, Field$Builder.class);
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
    public Field$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = Field.access$1300();
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (Field)object;
            if (object == null) break block7;
            this.mergeFrom((Field)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (Field)object2;
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
            this.mergeFrom((Field)object3);
        }
        throw var1_6;
    }

    public Field$Builder mergeFrom(Field messageLite) {
        boolean bl2;
        boolean bl3;
        boolean bl4;
        int n10;
        boolean bl5;
        boolean bl6;
        int n11;
        int n12;
        Object object = Field.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        int n102 = Field.access$300((Field)messageLite);
        if (n102 != 0) {
            int n13 = ((Field)messageLite).getKindValue();
            this.setKindValue(n13);
        }
        if ((n12 = Field.access$400((Field)messageLite)) != 0) {
            int n14 = ((Field)messageLite).getCardinalityValue();
            this.setCardinalityValue(n14);
        }
        if ((n11 = ((Field)messageLite).getNumber()) != 0) {
            int n15 = ((Field)messageLite).getNumber();
            this.setNumber(n15);
        }
        if (!(bl6 = ((String)(object = ((Field)messageLite).getName())).isEmpty())) {
            this.name_ = object = Field.access$600((Field)messageLite);
            this.onChanged();
        }
        if (!(bl5 = ((String)(object = ((Field)messageLite).getTypeUrl())).isEmpty())) {
            this.typeUrl_ = object = Field.access$700((Field)messageLite);
            this.onChanged();
        }
        if ((n10 = ((Field)messageLite).getOneofIndex()) != 0) {
            int n16 = ((Field)messageLite).getOneofIndex();
            this.setOneofIndex(n16);
        }
        if (bl4 = ((Field)messageLite).getPacked()) {
            boolean bl7 = ((Field)messageLite).getPacked();
            this.setPacked(bl7);
        }
        if ((object = this.optionsBuilder_) == null) {
            object = Field.access$1000((Field)messageLite);
            boolean bl8 = object.isEmpty();
            if (!bl8) {
                object = this.options_;
                boolean bl9 = object.isEmpty();
                if (bl9) {
                    int n17;
                    this.options_ = object = Field.access$1000((Field)messageLite);
                    this.bitField0_ = n17 = this.bitField0_ & 0xFFFFFFFE;
                } else {
                    this.ensureOptionsIsMutable();
                    object = this.options_;
                    List list = Field.access$1000((Field)messageLite);
                    object.addAll(list);
                }
                this.onChanged();
            }
        } else {
            object = Field.access$1000((Field)messageLite);
            boolean bl10 = object.isEmpty();
            if (!bl10) {
                object = this.optionsBuilder_;
                boolean bl11 = ((RepeatedFieldBuilderV3)object).isEmpty();
                if (bl11) {
                    int n18;
                    List list;
                    this.optionsBuilder_.dispose();
                    boolean bl12 = false;
                    object = null;
                    this.optionsBuilder_ = null;
                    this.options_ = list = Field.access$1000((Field)messageLite);
                    this.bitField0_ = n18 = this.bitField0_ & 0xFFFFFFFE;
                    n18 = (int)(GeneratedMessageV3.alwaysUseFieldBuilders ? 1 : 0);
                    if (n18 != 0) {
                        object = this.getOptionsFieldBuilder();
                    }
                    this.optionsBuilder_ = object;
                } else {
                    object = this.optionsBuilder_;
                    List list = Field.access$1000((Field)messageLite);
                    ((RepeatedFieldBuilderV3)object).addAllMessages(list);
                }
            }
        }
        if (!(bl3 = ((String)(object = ((Field)messageLite).getJsonName())).isEmpty())) {
            this.jsonName_ = object = Field.access$1100((Field)messageLite);
            this.onChanged();
        }
        if (!(bl2 = ((String)(object = ((Field)messageLite).getDefaultValue())).isEmpty())) {
            this.defaultValue_ = object = Field.access$1200((Field)messageLite);
            this.onChanged();
        }
        messageLite = ((GeneratedMessageV3)messageLite).unknownFields;
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    public Field$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof Field;
        if (bl2) {
            message = (Field)message;
            return this.mergeFrom((Field)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final Field$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Field$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public Field$Builder removeOptions(int n10) {
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

    public Field$Builder setCardinality(Field$Cardinality field$Cardinality) {
        int n10;
        Objects.requireNonNull(field$Cardinality);
        this.cardinality_ = n10 = field$Cardinality.getNumber();
        this.onChanged();
        return this;
    }

    public Field$Builder setCardinalityValue(int n10) {
        this.cardinality_ = n10;
        this.onChanged();
        return this;
    }

    public Field$Builder setDefaultValue(String string2) {
        Objects.requireNonNull(string2);
        this.defaultValue_ = string2;
        this.onChanged();
        return this;
    }

    public Field$Builder setDefaultValueBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.defaultValue_ = byteString;
        this.onChanged();
        return this;
    }

    public Field$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Field$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public Field$Builder setJsonName(String string2) {
        Objects.requireNonNull(string2);
        this.jsonName_ = string2;
        this.onChanged();
        return this;
    }

    public Field$Builder setJsonNameBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.jsonName_ = byteString;
        this.onChanged();
        return this;
    }

    public Field$Builder setKind(Field$Kind field$Kind) {
        int n10;
        Objects.requireNonNull(field$Kind);
        this.kind_ = n10 = field$Kind.getNumber();
        this.onChanged();
        return this;
    }

    public Field$Builder setKindValue(int n10) {
        this.kind_ = n10;
        this.onChanged();
        return this;
    }

    public Field$Builder setName(String string2) {
        Objects.requireNonNull(string2);
        this.name_ = string2;
        this.onChanged();
        return this;
    }

    public Field$Builder setNameBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.name_ = byteString;
        this.onChanged();
        return this;
    }

    public Field$Builder setNumber(int n10) {
        this.number_ = n10;
        this.onChanged();
        return this;
    }

    public Field$Builder setOneofIndex(int n10) {
        this.oneofIndex_ = n10;
        this.onChanged();
        return this;
    }

    public Field$Builder setOptions(int n10, Option$Builder messageOrBuilder) {
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

    public Field$Builder setOptions(int n10, Option option) {
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

    public Field$Builder setPacked(boolean bl2) {
        this.packed_ = bl2;
        this.onChanged();
        return this;
    }

    public Field$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (Field$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public Field$Builder setTypeUrl(String string2) {
        Objects.requireNonNull(string2);
        this.typeUrl_ = string2;
        this.onChanged();
        return this;
    }

    public Field$Builder setTypeUrlBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.typeUrl_ = byteString;
        this.onChanged();
        return this;
    }

    public final Field$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Field$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

