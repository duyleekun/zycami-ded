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
import com.google.protobuf.Enum;
import com.google.protobuf.Enum$1;
import com.google.protobuf.EnumOrBuilder;
import com.google.protobuf.EnumValue;
import com.google.protobuf.EnumValue$Builder;
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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.SourceContext;
import com.google.protobuf.SourceContext$Builder;
import com.google.protobuf.SourceContextOrBuilder;
import com.google.protobuf.Syntax;
import com.google.protobuf.TypeProto;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Enum$Builder
extends GeneratedMessageV3$Builder
implements EnumOrBuilder {
    private int bitField0_;
    private RepeatedFieldBuilderV3 enumvalueBuilder_;
    private List enumvalue_;
    private Object name_ = "";
    private RepeatedFieldBuilderV3 optionsBuilder_;
    private List options_;
    private SingleFieldBuilderV3 sourceContextBuilder_;
    private SourceContext sourceContext_;
    private int syntax_;

    private Enum$Builder() {
        List list;
        this.enumvalue_ = list = Collections.emptyList();
        this.options_ = list = Collections.emptyList();
        this.syntax_ = 0;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Enum$Builder(Enum$1 enum$1) {
        this();
    }

    private Enum$Builder(GeneratedMessageV3$BuilderParent list) {
        super((GeneratedMessageV3$BuilderParent)((Object)list));
        list = Collections.emptyList();
        this.enumvalue_ = list;
        this.options_ = list = Collections.emptyList();
        this.syntax_ = 0;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Enum$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, Enum$1 enum$1) {
        this(generatedMessageV3$BuilderParent);
    }

    private void ensureEnumvalueIsMutable() {
        int n10 = this.bitField0_ & 1;
        if (n10 == 0) {
            ArrayList arrayList;
            List list = this.enumvalue_;
            this.enumvalue_ = arrayList = new ArrayList(list);
            this.bitField0_ = n10 = this.bitField0_ | 1;
        }
    }

    private void ensureOptionsIsMutable() {
        int n10 = this.bitField0_ & 2;
        if (n10 == 0) {
            ArrayList arrayList;
            List list = this.options_;
            this.options_ = arrayList = new ArrayList(list);
            this.bitField0_ = n10 = this.bitField0_ | 2;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_Enum_descriptor;
    }

    private RepeatedFieldBuilderV3 getEnumvalueFieldBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.enumvalueBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            List list = this.enumvalue_;
            int n10 = this.bitField0_;
            int n11 = 1;
            if ((n10 &= n11) == 0) {
                n11 = 0;
            }
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.enumvalueBuilder_ = repeatedFieldBuilderV3 = new RepeatedFieldBuilderV3(list, n11 != 0, generatedMessageV3$BuilderParent, bl2);
            repeatedFieldBuilderV3 = null;
            this.enumvalue_ = null;
        }
        return this.enumvalueBuilder_;
    }

    private RepeatedFieldBuilderV3 getOptionsFieldBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.optionsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            List list = this.options_;
            int n10 = this.bitField0_ & 2;
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
            this.getEnumvalueFieldBuilder();
            this.getOptionsFieldBuilder();
        }
    }

    public Enum$Builder addAllEnumvalue(Iterable iterable) {
        Object object = this.enumvalueBuilder_;
        if (object == null) {
            this.ensureEnumvalueIsMutable();
            object = this.enumvalue_;
            AbstractMessageLite$Builder.addAll(iterable, (List)object);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addAllMessages(iterable);
        }
        return this;
    }

    public Enum$Builder addAllOptions(Iterable iterable) {
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

    public Enum$Builder addEnumvalue(int n10, EnumValue$Builder enumValueOrBuilder) {
        Object object = this.enumvalueBuilder_;
        if (object == null) {
            this.ensureEnumvalueIsMutable();
            object = this.enumvalue_;
            enumValueOrBuilder = ((EnumValue$Builder)enumValueOrBuilder).build();
            object.add(n10, enumValueOrBuilder);
            this.onChanged();
        } else {
            enumValueOrBuilder = ((EnumValue$Builder)enumValueOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage(n10, (AbstractMessage)((Object)enumValueOrBuilder));
        }
        return this;
    }

    public Enum$Builder addEnumvalue(int n10, EnumValue enumValue) {
        Object object = this.enumvalueBuilder_;
        if (object == null) {
            Objects.requireNonNull(enumValue);
            this.ensureEnumvalueIsMutable();
            object = this.enumvalue_;
            object.add(n10, enumValue);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(n10, enumValue);
        }
        return this;
    }

    public Enum$Builder addEnumvalue(EnumValue$Builder enumValueOrBuilder) {
        Object object = this.enumvalueBuilder_;
        if (object == null) {
            this.ensureEnumvalueIsMutable();
            object = this.enumvalue_;
            enumValueOrBuilder = ((EnumValue$Builder)enumValueOrBuilder).build();
            object.add(enumValueOrBuilder);
            this.onChanged();
        } else {
            enumValueOrBuilder = ((EnumValue$Builder)enumValueOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage((AbstractMessage)((Object)enumValueOrBuilder));
        }
        return this;
    }

    public Enum$Builder addEnumvalue(EnumValue enumValue) {
        Object object = this.enumvalueBuilder_;
        if (object == null) {
            Objects.requireNonNull(enumValue);
            this.ensureEnumvalueIsMutable();
            object = this.enumvalue_;
            object.add(enumValue);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(enumValue);
        }
        return this;
    }

    public EnumValue$Builder addEnumvalueBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getEnumvalueFieldBuilder();
        EnumValue enumValue = EnumValue.getDefaultInstance();
        return (EnumValue$Builder)repeatedFieldBuilderV3.addBuilder(enumValue);
    }

    public EnumValue$Builder addEnumvalueBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getEnumvalueFieldBuilder();
        EnumValue enumValue = EnumValue.getDefaultInstance();
        return (EnumValue$Builder)repeatedFieldBuilderV3.addBuilder(n10, enumValue);
    }

    public Enum$Builder addOptions(int n10, Option$Builder messageOrBuilder) {
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

    public Enum$Builder addOptions(int n10, Option option) {
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

    public Enum$Builder addOptions(Option$Builder messageOrBuilder) {
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

    public Enum$Builder addOptions(Option option) {
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

    public Enum$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Enum$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public Enum build() {
        Enum enum_ = this.buildPartial();
        boolean bl2 = enum_.isInitialized();
        if (bl2) {
            return enum_;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(enum_);
    }

    public Enum buildPartial() {
        int n10 = 0;
        Enum enum_ = new Enum(this, null);
        Object object = this.name_;
        Enum.access$302(enum_, object);
        object = this.enumvalueBuilder_;
        if (object == null) {
            n10 = this.bitField0_ & 1;
            if (n10 != 0) {
                object = Collections.unmodifiableList(this.enumvalue_);
                this.enumvalue_ = object;
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
            }
            object = this.enumvalue_;
            Enum.access$402(enum_, object);
        } else {
            object = ((RepeatedFieldBuilderV3)object).build();
            Enum.access$402(enum_, (List)object);
        }
        object = this.optionsBuilder_;
        if (object == null) {
            n10 = this.bitField0_ & 2;
            if (n10 != 0) {
                object = Collections.unmodifiableList(this.options_);
                this.options_ = object;
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
            }
            object = this.options_;
            Enum.access$502(enum_, object);
        } else {
            object = ((RepeatedFieldBuilderV3)object).build();
            Enum.access$502(enum_, (List)object);
        }
        object = this.sourceContextBuilder_;
        if (object == null) {
            object = this.sourceContext_;
            Enum.access$602(enum_, (SourceContext)object);
        } else {
            object = (SourceContext)((SingleFieldBuilderV3)object).build();
            Enum.access$602(enum_, (SourceContext)object);
        }
        n10 = this.syntax_;
        Enum.access$702(enum_, n10);
        this.onBuilt();
        return enum_;
    }

    public Enum$Builder clear() {
        int n10;
        super.clear();
        this.name_ = "";
        Object object = this.enumvalueBuilder_;
        if (object == null) {
            this.enumvalue_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        object = this.optionsBuilder_;
        if (object == null) {
            object = Collections.emptyList();
            this.options_ = object;
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
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

    public Enum$Builder clearEnumvalue() {
        Object object = this.enumvalueBuilder_;
        if (object == null) {
            int n10;
            this.enumvalue_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public Enum$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (Enum$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public Enum$Builder clearName() {
        String string2 = Enum.getDefaultInstance().getName();
        this.name_ = string2;
        this.onChanged();
        return this;
    }

    public Enum$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (Enum$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public Enum$Builder clearOptions() {
        Object object = this.optionsBuilder_;
        if (object == null) {
            int n10;
            this.options_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public Enum$Builder clearSourceContext() {
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

    public Enum$Builder clearSyntax() {
        this.syntax_ = 0;
        this.onChanged();
        return this;
    }

    public Enum$Builder clone() {
        return (Enum$Builder)super.clone();
    }

    public Enum getDefaultInstanceForType() {
        return Enum.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return TypeProto.internal_static_google_protobuf_Enum_descriptor;
    }

    public EnumValue getEnumvalue(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.enumvalueBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (EnumValue)this.enumvalue_.get(n10);
        }
        return (EnumValue)repeatedFieldBuilderV3.getMessage(n10);
    }

    public EnumValue$Builder getEnumvalueBuilder(int n10) {
        return (EnumValue$Builder)this.getEnumvalueFieldBuilder().getBuilder(n10);
    }

    public List getEnumvalueBuilderList() {
        return this.getEnumvalueFieldBuilder().getBuilderList();
    }

    public int getEnumvalueCount() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.enumvalueBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return this.enumvalue_.size();
        }
        return repeatedFieldBuilderV3.getCount();
    }

    public List getEnumvalueList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.enumvalueBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return Collections.unmodifiableList(this.enumvalue_);
        }
        return repeatedFieldBuilderV3.getMessageList();
    }

    public EnumValueOrBuilder getEnumvalueOrBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.enumvalueBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (EnumValueOrBuilder)this.enumvalue_.get(n10);
        }
        return (EnumValueOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(n10);
    }

    public List getEnumvalueOrBuilderList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.enumvalueBuilder_;
        if (repeatedFieldBuilderV3 != null) {
            return repeatedFieldBuilderV3.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(this.enumvalue_);
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
        return TypeProto.internal_static_google_protobuf_Enum_fieldAccessorTable.ensureFieldAccessorsInitialized(Enum.class, Enum$Builder.class);
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
    public Enum$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = Enum.access$800();
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (Enum)object;
            if (object == null) break block7;
            this.mergeFrom((Enum)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (Enum)object2;
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
            this.mergeFrom((Enum)object3);
        }
        throw var1_6;
    }

    public Enum$Builder mergeFrom(Enum messageLite) {
        int n10;
        boolean bl2;
        Object object = Enum.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        object = ((Enum)messageLite).getName();
        boolean n102 = ((String)object).isEmpty();
        if (!n102) {
            this.name_ = object = Enum.access$300((Enum)messageLite);
            this.onChanged();
        }
        object = this.enumvalueBuilder_;
        Object object2 = null;
        if (object == null) {
            object = Enum.access$400((Enum)messageLite);
            boolean bl3 = object.isEmpty();
            if (!bl3) {
                object = this.enumvalue_;
                boolean bl4 = object.isEmpty();
                if (bl4) {
                    int n11;
                    this.enumvalue_ = object = Enum.access$400((Enum)messageLite);
                    this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
                } else {
                    this.ensureEnumvalueIsMutable();
                    object = this.enumvalue_;
                    List list = Enum.access$400((Enum)messageLite);
                    object.addAll(list);
                }
                this.onChanged();
            }
        } else {
            object = Enum.access$400((Enum)messageLite);
            boolean bl5 = object.isEmpty();
            if (!bl5) {
                object = this.enumvalueBuilder_;
                boolean bl6 = ((RepeatedFieldBuilderV3)object).isEmpty();
                if (bl6) {
                    int n12;
                    this.enumvalueBuilder_.dispose();
                    this.enumvalueBuilder_ = null;
                    this.enumvalue_ = object = Enum.access$400((Enum)messageLite);
                    this.bitField0_ = n12 = this.bitField0_ & 0xFFFFFFFE;
                    boolean bl7 = GeneratedMessageV3.alwaysUseFieldBuilders;
                    if (bl7) {
                        object = this.getEnumvalueFieldBuilder();
                    } else {
                        boolean bl8 = false;
                        object = null;
                    }
                    this.enumvalueBuilder_ = object;
                } else {
                    object = this.enumvalueBuilder_;
                    List list = Enum.access$400((Enum)messageLite);
                    ((RepeatedFieldBuilderV3)object).addAllMessages(list);
                }
            }
        }
        if ((object = this.optionsBuilder_) == null) {
            object = Enum.access$500((Enum)messageLite);
            boolean bl9 = object.isEmpty();
            if (!bl9) {
                object = this.options_;
                boolean bl10 = object.isEmpty();
                if (bl10) {
                    int n13;
                    this.options_ = object = Enum.access$500((Enum)messageLite);
                    this.bitField0_ = n13 = this.bitField0_ & 0xFFFFFFFD;
                } else {
                    this.ensureOptionsIsMutable();
                    object = this.options_;
                    object2 = Enum.access$500((Enum)messageLite);
                    object.addAll(object2);
                }
                this.onChanged();
            }
        } else {
            object = Enum.access$500((Enum)messageLite);
            boolean bl11 = object.isEmpty();
            if (!bl11) {
                object = this.optionsBuilder_;
                boolean bl12 = ((RepeatedFieldBuilderV3)object).isEmpty();
                if (bl12) {
                    int n14;
                    this.optionsBuilder_.dispose();
                    this.optionsBuilder_ = null;
                    this.options_ = object = Enum.access$500((Enum)messageLite);
                    this.bitField0_ = n14 = this.bitField0_ & 0xFFFFFFFD;
                    boolean bl13 = GeneratedMessageV3.alwaysUseFieldBuilders;
                    if (bl13) {
                        object2 = this.getOptionsFieldBuilder();
                    }
                    this.optionsBuilder_ = object2;
                } else {
                    object = this.optionsBuilder_;
                    object2 = Enum.access$500((Enum)messageLite);
                    ((RepeatedFieldBuilderV3)object).addAllMessages((Iterable)object2);
                }
            }
        }
        if (bl2 = ((Enum)messageLite).hasSourceContext()) {
            object = ((Enum)messageLite).getSourceContext();
            this.mergeSourceContext((SourceContext)object);
        }
        if ((n10 = Enum.access$700((Enum)messageLite)) != 0) {
            int n15 = ((Enum)messageLite).getSyntaxValue();
            this.setSyntaxValue(n15);
        }
        messageLite = ((GeneratedMessageV3)messageLite).unknownFields;
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    public Enum$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof Enum;
        if (bl2) {
            message = (Enum)message;
            return this.mergeFrom((Enum)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public Enum$Builder mergeSourceContext(SourceContext message) {
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

    public final Enum$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Enum$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public Enum$Builder removeEnumvalue(int n10) {
        Object object = this.enumvalueBuilder_;
        if (object == null) {
            this.ensureEnumvalueIsMutable();
            object = this.enumvalue_;
            object.remove(n10);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).remove(n10);
        }
        return this;
    }

    public Enum$Builder removeOptions(int n10) {
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

    public Enum$Builder setEnumvalue(int n10, EnumValue$Builder enumValueOrBuilder) {
        Object object = this.enumvalueBuilder_;
        if (object == null) {
            this.ensureEnumvalueIsMutable();
            object = this.enumvalue_;
            enumValueOrBuilder = ((EnumValue$Builder)enumValueOrBuilder).build();
            object.set(n10, enumValueOrBuilder);
            this.onChanged();
        } else {
            enumValueOrBuilder = ((EnumValue$Builder)enumValueOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).setMessage(n10, (AbstractMessage)((Object)enumValueOrBuilder));
        }
        return this;
    }

    public Enum$Builder setEnumvalue(int n10, EnumValue enumValue) {
        Object object = this.enumvalueBuilder_;
        if (object == null) {
            Objects.requireNonNull(enumValue);
            this.ensureEnumvalueIsMutable();
            object = this.enumvalue_;
            object.set(n10, enumValue);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).setMessage(n10, enumValue);
        }
        return this;
    }

    public Enum$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Enum$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public Enum$Builder setName(String string2) {
        Objects.requireNonNull(string2);
        this.name_ = string2;
        this.onChanged();
        return this;
    }

    public Enum$Builder setNameBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.name_ = byteString;
        this.onChanged();
        return this;
    }

    public Enum$Builder setOptions(int n10, Option$Builder messageOrBuilder) {
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

    public Enum$Builder setOptions(int n10, Option option) {
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

    public Enum$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (Enum$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public Enum$Builder setSourceContext(SourceContext$Builder messageOrBuilder) {
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

    public Enum$Builder setSourceContext(SourceContext sourceContext) {
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

    public Enum$Builder setSyntax(Syntax syntax) {
        int n10;
        Objects.requireNonNull(syntax);
        this.syntax_ = n10 = syntax.getNumber();
        this.onChanged();
        return this;
    }

    public Enum$Builder setSyntaxValue(int n10) {
        this.syntax_ = n10;
        this.onChanged();
        return this;
    }

    public final Enum$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Enum$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

