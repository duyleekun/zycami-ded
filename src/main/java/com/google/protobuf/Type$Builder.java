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
import com.google.protobuf.Field$Builder;
import com.google.protobuf.FieldOrBuilder;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.Option;
import com.google.protobuf.Option$Builder;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.SourceContext;
import com.google.protobuf.SourceContext$Builder;
import com.google.protobuf.SourceContextOrBuilder;
import com.google.protobuf.Syntax;
import com.google.protobuf.Type;
import com.google.protobuf.Type$1;
import com.google.protobuf.TypeOrBuilder;
import com.google.protobuf.TypeProto;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Type$Builder
extends GeneratedMessageV3$Builder
implements TypeOrBuilder {
    private int bitField0_;
    private RepeatedFieldBuilderV3 fieldsBuilder_;
    private List fields_;
    private Object name_ = "";
    private LazyStringList oneofs_;
    private RepeatedFieldBuilderV3 optionsBuilder_;
    private List options_;
    private SingleFieldBuilderV3 sourceContextBuilder_;
    private SourceContext sourceContext_;
    private int syntax_;

    private Type$Builder() {
        List list;
        this.fields_ = list = Collections.emptyList();
        this.oneofs_ = list = LazyStringArrayList.EMPTY;
        list = Collections.emptyList();
        this.options_ = list;
        this.syntax_ = 0;
        this.maybeForceBuilderInitialization();
    }

    private Type$Builder(GeneratedMessageV3$BuilderParent list) {
        super((GeneratedMessageV3$BuilderParent)((Object)list));
        list = Collections.emptyList();
        this.fields_ = list;
        list = LazyStringArrayList.EMPTY;
        this.oneofs_ = list;
        this.options_ = list = Collections.emptyList();
        this.syntax_ = 0;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Type$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, Type$1 type$1) {
        this(generatedMessageV3$BuilderParent);
    }

    public /* synthetic */ Type$Builder(Type$1 type$1) {
        this();
    }

    private void ensureFieldsIsMutable() {
        int n10 = this.bitField0_ & 1;
        if (n10 == 0) {
            ArrayList arrayList;
            List list = this.fields_;
            this.fields_ = arrayList = new ArrayList(list);
            this.bitField0_ = n10 = this.bitField0_ | 1;
        }
    }

    private void ensureOneofsIsMutable() {
        int n10 = this.bitField0_ & 2;
        if (n10 == 0) {
            LazyStringList lazyStringList = this.oneofs_;
            LazyStringArrayList lazyStringArrayList = new LazyStringArrayList(lazyStringList);
            this.oneofs_ = lazyStringArrayList;
            this.bitField0_ = n10 = this.bitField0_ | 2;
        }
    }

    private void ensureOptionsIsMutable() {
        int n10 = this.bitField0_ & 4;
        if (n10 == 0) {
            ArrayList arrayList;
            List list = this.options_;
            this.options_ = arrayList = new ArrayList(list);
            this.bitField0_ = n10 = this.bitField0_ | 4;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_Type_descriptor;
    }

    private RepeatedFieldBuilderV3 getFieldsFieldBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.fieldsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            List list = this.fields_;
            int n10 = this.bitField0_;
            int n11 = 1;
            if ((n10 &= n11) == 0) {
                n11 = 0;
            }
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.fieldsBuilder_ = repeatedFieldBuilderV3 = new RepeatedFieldBuilderV3(list, n11 != 0, generatedMessageV3$BuilderParent, bl2);
            repeatedFieldBuilderV3 = null;
            this.fields_ = null;
        }
        return this.fieldsBuilder_;
    }

    private RepeatedFieldBuilderV3 getOptionsFieldBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.optionsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            List list = this.options_;
            int n10 = this.bitField0_ & 4;
            n10 = n10 != 0 ? 1 : 0;
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.optionsBuilder_ = repeatedFieldBuilderV3 = new RepeatedFieldBuilderV3(list, n10 != 0, generatedMessageV3$BuilderParent, bl2);
            repeatedFieldBuilderV3 = null;
            this.options_ = null;
        }
        return this.optionsBuilder_;
    }

    private SingleFieldBuilderV3 getSourceContextFieldBuilder() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.sourceContextBuilder_;
        if (singleFieldBuilderV3 == null) {
            SourceContext sourceContext = this.getSourceContext();
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.sourceContextBuilder_ = singleFieldBuilderV3 = new SingleFieldBuilderV3(sourceContext, generatedMessageV3$BuilderParent, bl2);
            singleFieldBuilderV3 = null;
            this.sourceContext_ = null;
        }
        return this.sourceContextBuilder_;
    }

    private void maybeForceBuilderInitialization() {
        boolean bl2 = GeneratedMessageV3.alwaysUseFieldBuilders;
        if (bl2) {
            this.getFieldsFieldBuilder();
            this.getOptionsFieldBuilder();
        }
    }

    public Type$Builder addAllFields(Iterable iterable) {
        Object object = this.fieldsBuilder_;
        if (object == null) {
            this.ensureFieldsIsMutable();
            object = this.fields_;
            AbstractMessageLite$Builder.addAll(iterable, (List)object);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addAllMessages(iterable);
        }
        return this;
    }

    public Type$Builder addAllOneofs(Iterable iterable) {
        this.ensureOneofsIsMutable();
        LazyStringList lazyStringList = this.oneofs_;
        AbstractMessageLite$Builder.addAll(iterable, lazyStringList);
        this.onChanged();
        return this;
    }

    public Type$Builder addAllOptions(Iterable iterable) {
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

    public Type$Builder addFields(int n10, Field$Builder fieldOrBuilder) {
        Object object = this.fieldsBuilder_;
        if (object == null) {
            this.ensureFieldsIsMutable();
            object = this.fields_;
            fieldOrBuilder = ((Field$Builder)fieldOrBuilder).build();
            object.add(n10, fieldOrBuilder);
            this.onChanged();
        } else {
            fieldOrBuilder = ((Field$Builder)fieldOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage(n10, (AbstractMessage)((Object)fieldOrBuilder));
        }
        return this;
    }

    public Type$Builder addFields(int n10, Field field) {
        Object object = this.fieldsBuilder_;
        if (object == null) {
            Objects.requireNonNull(field);
            this.ensureFieldsIsMutable();
            object = this.fields_;
            object.add(n10, field);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(n10, field);
        }
        return this;
    }

    public Type$Builder addFields(Field$Builder fieldOrBuilder) {
        Object object = this.fieldsBuilder_;
        if (object == null) {
            this.ensureFieldsIsMutable();
            object = this.fields_;
            fieldOrBuilder = ((Field$Builder)fieldOrBuilder).build();
            object.add(fieldOrBuilder);
            this.onChanged();
        } else {
            fieldOrBuilder = ((Field$Builder)fieldOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage((AbstractMessage)((Object)fieldOrBuilder));
        }
        return this;
    }

    public Type$Builder addFields(Field field) {
        Object object = this.fieldsBuilder_;
        if (object == null) {
            Objects.requireNonNull(field);
            this.ensureFieldsIsMutable();
            object = this.fields_;
            object.add(field);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(field);
        }
        return this;
    }

    public Field$Builder addFieldsBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getFieldsFieldBuilder();
        Field field = Field.getDefaultInstance();
        return (Field$Builder)repeatedFieldBuilderV3.addBuilder(field);
    }

    public Field$Builder addFieldsBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getFieldsFieldBuilder();
        Field field = Field.getDefaultInstance();
        return (Field$Builder)repeatedFieldBuilderV3.addBuilder(n10, field);
    }

    public Type$Builder addOneofs(String string2) {
        Objects.requireNonNull(string2);
        this.ensureOneofsIsMutable();
        this.oneofs_.add(string2);
        this.onChanged();
        return this;
    }

    public Type$Builder addOneofsBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.ensureOneofsIsMutable();
        this.oneofs_.add(byteString);
        this.onChanged();
        return this;
    }

    public Type$Builder addOptions(int n10, Option$Builder messageOrBuilder) {
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

    public Type$Builder addOptions(int n10, Option option) {
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

    public Type$Builder addOptions(Option$Builder messageOrBuilder) {
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

    public Type$Builder addOptions(Option option) {
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

    public Type$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Type$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public Type build() {
        Message message = this.buildPartial();
        boolean bl2 = ((Type)message).isInitialized();
        if (bl2) {
            return message;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(message);
    }

    public Type buildPartial() {
        int n10 = 0;
        Type type = new Type(this, null);
        Object object = this.name_;
        Type.access$302(type, object);
        object = this.fieldsBuilder_;
        if (object == null) {
            n10 = this.bitField0_ & 1;
            if (n10 != 0) {
                object = Collections.unmodifiableList(this.fields_);
                this.fields_ = object;
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
            }
            object = this.fields_;
            Type.access$402(type, object);
        } else {
            object = ((RepeatedFieldBuilderV3)object).build();
            Type.access$402(type, (List)object);
        }
        n10 = this.bitField0_ & 2;
        if (n10 != 0) {
            object = this.oneofs_.getUnmodifiableView();
            this.oneofs_ = object;
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        }
        object = this.oneofs_;
        Type.access$502(type, (LazyStringList)object);
        object = this.optionsBuilder_;
        if (object == null) {
            n10 = this.bitField0_ & 4;
            if (n10 != 0) {
                object = Collections.unmodifiableList(this.options_);
                this.options_ = object;
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
            }
            object = this.options_;
            Type.access$602(type, object);
        } else {
            object = ((RepeatedFieldBuilderV3)object).build();
            Type.access$602(type, (List)object);
        }
        object = this.sourceContextBuilder_;
        if (object == null) {
            object = this.sourceContext_;
            Type.access$702(type, (SourceContext)object);
        } else {
            object = (SourceContext)((SingleFieldBuilderV3)object).build();
            Type.access$702(type, (SourceContext)object);
        }
        n10 = this.syntax_;
        Type.access$802(type, n10);
        this.onBuilt();
        return type;
    }

    public Type$Builder clear() {
        int n10;
        super.clear();
        this.name_ = "";
        Object object = this.fieldsBuilder_;
        if (object == null) {
            this.fields_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        this.oneofs_ = object = LazyStringArrayList.EMPTY;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        object = this.optionsBuilder_;
        if (object == null) {
            object = Collections.emptyList();
            this.options_ = object;
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        object = this.sourceContextBuilder_;
        if (object == null) {
            this.sourceContext_ = null;
        } else {
            this.sourceContext_ = null;
            this.sourceContextBuilder_ = null;
        }
        this.syntax_ = 0;
        return this;
    }

    public Type$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (Type$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public Type$Builder clearFields() {
        Object object = this.fieldsBuilder_;
        if (object == null) {
            int n10;
            this.fields_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public Type$Builder clearName() {
        String string2 = Type.getDefaultInstance().getName();
        this.name_ = string2;
        this.onChanged();
        return this;
    }

    public Type$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (Type$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public Type$Builder clearOneofs() {
        int n10;
        LazyStringList lazyStringList;
        this.oneofs_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        this.onChanged();
        return this;
    }

    public Type$Builder clearOptions() {
        Object object = this.optionsBuilder_;
        if (object == null) {
            int n10;
            this.options_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public Type$Builder clearSourceContext() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.sourceContextBuilder_;
        if (singleFieldBuilderV3 == null) {
            this.sourceContext_ = null;
            this.onChanged();
        } else {
            this.sourceContext_ = null;
            this.sourceContextBuilder_ = null;
        }
        return this;
    }

    public Type$Builder clearSyntax() {
        this.syntax_ = 0;
        this.onChanged();
        return this;
    }

    public Type$Builder clone() {
        return (Type$Builder)super.clone();
    }

    public Type getDefaultInstanceForType() {
        return Type.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return TypeProto.internal_static_google_protobuf_Type_descriptor;
    }

    public Field getFields(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.fieldsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (Field)this.fields_.get(n10);
        }
        return (Field)repeatedFieldBuilderV3.getMessage(n10);
    }

    public Field$Builder getFieldsBuilder(int n10) {
        return (Field$Builder)this.getFieldsFieldBuilder().getBuilder(n10);
    }

    public List getFieldsBuilderList() {
        return this.getFieldsFieldBuilder().getBuilderList();
    }

    public int getFieldsCount() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.fieldsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return this.fields_.size();
        }
        return repeatedFieldBuilderV3.getCount();
    }

    public List getFieldsList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.fieldsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return Collections.unmodifiableList(this.fields_);
        }
        return repeatedFieldBuilderV3.getMessageList();
    }

    public FieldOrBuilder getFieldsOrBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.fieldsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (FieldOrBuilder)this.fields_.get(n10);
        }
        return (FieldOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(n10);
    }

    public List getFieldsOrBuilderList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.fieldsBuilder_;
        if (repeatedFieldBuilderV3 != null) {
            return repeatedFieldBuilderV3.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(this.fields_);
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

    public String getOneofs(int n10) {
        return (String)this.oneofs_.get(n10);
    }

    public ByteString getOneofsBytes(int n10) {
        return this.oneofs_.getByteString(n10);
    }

    public int getOneofsCount() {
        return this.oneofs_.size();
    }

    public ProtocolStringList getOneofsList() {
        return this.oneofs_.getUnmodifiableView();
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

    public SourceContext getSourceContext() {
        Object object = this.sourceContextBuilder_;
        if (object == null) {
            object = this.sourceContext_;
            if (object == null) {
                object = SourceContext.getDefaultInstance();
            }
            return object;
        }
        return (SourceContext)((SingleFieldBuilderV3)object).getMessage();
    }

    public SourceContext$Builder getSourceContextBuilder() {
        this.onChanged();
        return (SourceContext$Builder)this.getSourceContextFieldBuilder().getBuilder();
    }

    public SourceContextOrBuilder getSourceContextOrBuilder() {
        Object object = this.sourceContextBuilder_;
        if (object != null) {
            return (SourceContextOrBuilder)((SingleFieldBuilderV3)object).getMessageOrBuilder();
        }
        object = this.sourceContext_;
        if (object == null) {
            object = SourceContext.getDefaultInstance();
        }
        return object;
    }

    public Syntax getSyntax() {
        int n10 = this.syntax_;
        Syntax syntax = Syntax.valueOf(n10);
        if (syntax == null) {
            syntax = Syntax.UNRECOGNIZED;
        }
        return syntax;
    }

    public int getSyntaxValue() {
        return this.syntax_;
    }

    public boolean hasSourceContext() {
        boolean bl2;
        Object object = this.sourceContextBuilder_;
        if (object == null && (object = this.sourceContext_) == null) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_Type_fieldAccessorTable.ensureFieldAccessorsInitialized(Type.class, Type$Builder.class);
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
    public Type$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = Type.access$900();
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (Type)object;
            if (object == null) break block7;
            this.mergeFrom((Type)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (Type)object2;
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
            this.mergeFrom((Type)object3);
        }
        throw var1_6;
    }

    public Type$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof Type;
        if (bl2) {
            message = (Type)message;
            return this.mergeFrom((Type)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public Type$Builder mergeFrom(Type messageLite) {
        int n10;
        boolean bl2;
        boolean bl3;
        List list;
        Object object = Type.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        object = ((Type)messageLite).getName();
        boolean n102 = ((String)object).isEmpty();
        if (!n102) {
            this.name_ = object = Type.access$300((Type)messageLite);
            this.onChanged();
        }
        object = this.fieldsBuilder_;
        Object object2 = null;
        if (object == null) {
            object = Type.access$400((Type)messageLite);
            boolean bl4 = object.isEmpty();
            if (!bl4) {
                object = this.fields_;
                boolean bl5 = object.isEmpty();
                if (bl5) {
                    int n11;
                    this.fields_ = object = Type.access$400((Type)messageLite);
                    this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
                } else {
                    this.ensureFieldsIsMutable();
                    object = this.fields_;
                    list = Type.access$400((Type)messageLite);
                    object.addAll(list);
                }
                this.onChanged();
            }
        } else {
            object = Type.access$400((Type)messageLite);
            boolean bl6 = object.isEmpty();
            if (!bl6) {
                object = this.fieldsBuilder_;
                boolean bl7 = ((RepeatedFieldBuilderV3)object).isEmpty();
                if (bl7) {
                    int n12;
                    this.fieldsBuilder_.dispose();
                    this.fieldsBuilder_ = null;
                    this.fields_ = object = Type.access$400((Type)messageLite);
                    this.bitField0_ = n12 = this.bitField0_ & 0xFFFFFFFE;
                    boolean bl8 = GeneratedMessageV3.alwaysUseFieldBuilders;
                    if (bl8) {
                        object = this.getFieldsFieldBuilder();
                    } else {
                        boolean bl9 = false;
                        object = null;
                    }
                    this.fieldsBuilder_ = object;
                } else {
                    object = this.fieldsBuilder_;
                    list = Type.access$400((Type)messageLite);
                    ((RepeatedFieldBuilderV3)object).addAllMessages(list);
                }
            }
        }
        if (!(bl3 = (object = Type.access$500((Type)messageLite)).isEmpty())) {
            object = this.oneofs_;
            boolean bl10 = object.isEmpty();
            if (bl10) {
                int n13;
                this.oneofs_ = object = Type.access$500((Type)messageLite);
                this.bitField0_ = n13 = this.bitField0_ & 0xFFFFFFFD;
            } else {
                this.ensureOneofsIsMutable();
                object = this.oneofs_;
                list = Type.access$500((Type)messageLite);
                object.addAll(list);
            }
            this.onChanged();
        }
        if ((object = this.optionsBuilder_) == null) {
            object = Type.access$600((Type)messageLite);
            boolean bl11 = object.isEmpty();
            if (!bl11) {
                object = this.options_;
                boolean bl12 = object.isEmpty();
                if (bl12) {
                    int n14;
                    this.options_ = object = Type.access$600((Type)messageLite);
                    this.bitField0_ = n14 = this.bitField0_ & 0xFFFFFFFB;
                } else {
                    this.ensureOptionsIsMutable();
                    object = this.options_;
                    object2 = Type.access$600((Type)messageLite);
                    object.addAll(object2);
                }
                this.onChanged();
            }
        } else {
            object = Type.access$600((Type)messageLite);
            boolean bl13 = object.isEmpty();
            if (!bl13) {
                object = this.optionsBuilder_;
                boolean bl14 = ((RepeatedFieldBuilderV3)object).isEmpty();
                if (bl14) {
                    int n15;
                    this.optionsBuilder_.dispose();
                    this.optionsBuilder_ = null;
                    this.options_ = object = Type.access$600((Type)messageLite);
                    this.bitField0_ = n15 = this.bitField0_ & 0xFFFFFFFB;
                    boolean bl15 = GeneratedMessageV3.alwaysUseFieldBuilders;
                    if (bl15) {
                        object2 = this.getOptionsFieldBuilder();
                    }
                    this.optionsBuilder_ = object2;
                } else {
                    object = this.optionsBuilder_;
                    object2 = Type.access$600((Type)messageLite);
                    ((RepeatedFieldBuilderV3)object).addAllMessages((Iterable)object2);
                }
            }
        }
        if (bl2 = ((Type)messageLite).hasSourceContext()) {
            object = ((Type)messageLite).getSourceContext();
            this.mergeSourceContext((SourceContext)object);
        }
        if ((n10 = Type.access$800((Type)messageLite)) != 0) {
            int n16 = ((Type)messageLite).getSyntaxValue();
            this.setSyntaxValue(n16);
        }
        messageLite = ((GeneratedMessageV3)messageLite).unknownFields;
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    public Type$Builder mergeSourceContext(SourceContext message) {
        Object object = this.sourceContextBuilder_;
        if (object == null) {
            object = this.sourceContext_;
            if (object != null) {
                object = SourceContext.newBuilder((SourceContext)object);
                this.sourceContext_ = message = ((SourceContext$Builder)object).mergeFrom((SourceContext)message).buildPartial();
            } else {
                this.sourceContext_ = message;
            }
            this.onChanged();
        } else {
            ((SingleFieldBuilderV3)object).mergeFrom((AbstractMessage)message);
        }
        return this;
    }

    public final Type$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Type$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public Type$Builder removeFields(int n10) {
        Object object = this.fieldsBuilder_;
        if (object == null) {
            this.ensureFieldsIsMutable();
            object = this.fields_;
            object.remove(n10);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).remove(n10);
        }
        return this;
    }

    public Type$Builder removeOptions(int n10) {
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

    public Type$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Type$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public Type$Builder setFields(int n10, Field$Builder fieldOrBuilder) {
        Object object = this.fieldsBuilder_;
        if (object == null) {
            this.ensureFieldsIsMutable();
            object = this.fields_;
            fieldOrBuilder = ((Field$Builder)fieldOrBuilder).build();
            object.set(n10, fieldOrBuilder);
            this.onChanged();
        } else {
            fieldOrBuilder = ((Field$Builder)fieldOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).setMessage(n10, (AbstractMessage)((Object)fieldOrBuilder));
        }
        return this;
    }

    public Type$Builder setFields(int n10, Field field) {
        Object object = this.fieldsBuilder_;
        if (object == null) {
            Objects.requireNonNull(field);
            this.ensureFieldsIsMutable();
            object = this.fields_;
            object.set(n10, field);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).setMessage(n10, field);
        }
        return this;
    }

    public Type$Builder setName(String string2) {
        Objects.requireNonNull(string2);
        this.name_ = string2;
        this.onChanged();
        return this;
    }

    public Type$Builder setNameBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.name_ = byteString;
        this.onChanged();
        return this;
    }

    public Type$Builder setOneofs(int n10, String string2) {
        Objects.requireNonNull(string2);
        this.ensureOneofsIsMutable();
        this.oneofs_.set(n10, string2);
        this.onChanged();
        return this;
    }

    public Type$Builder setOptions(int n10, Option$Builder messageOrBuilder) {
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

    public Type$Builder setOptions(int n10, Option option) {
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

    public Type$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (Type$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public Type$Builder setSourceContext(SourceContext$Builder messageOrBuilder) {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.sourceContextBuilder_;
        if (singleFieldBuilderV3 == null) {
            messageOrBuilder = messageOrBuilder.build();
            this.sourceContext_ = messageOrBuilder;
            this.onChanged();
        } else {
            messageOrBuilder = messageOrBuilder.build();
            singleFieldBuilderV3.setMessage((AbstractMessage)messageOrBuilder);
        }
        return this;
    }

    public Type$Builder setSourceContext(SourceContext sourceContext) {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.sourceContextBuilder_;
        if (singleFieldBuilderV3 == null) {
            Objects.requireNonNull(sourceContext);
            this.sourceContext_ = sourceContext;
            this.onChanged();
        } else {
            singleFieldBuilderV3.setMessage(sourceContext);
        }
        return this;
    }

    public Type$Builder setSyntax(Syntax syntax) {
        int n10;
        Objects.requireNonNull(syntax);
        this.syntax_ = n10 = syntax.getNumber();
        this.onChanged();
        return this;
    }

    public Type$Builder setSyntaxValue(int n10) {
        this.syntax_ = n10;
        this.onChanged();
        return this;
    }

    public final Type$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Type$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

