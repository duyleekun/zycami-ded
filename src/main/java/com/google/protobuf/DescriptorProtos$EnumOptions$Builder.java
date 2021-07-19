/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$EnumOptions;
import com.google.protobuf.DescriptorProtos$EnumOptionsOrBuilder;
import com.google.protobuf.DescriptorProtos$UninterpretedOption;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$Builder;
import com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage$GeneratedExtension;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$ExtendableBuilder;
import com.google.protobuf.GeneratedMessageV3$ExtendableMessage;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class DescriptorProtos$EnumOptions$Builder
extends GeneratedMessageV3$ExtendableBuilder
implements DescriptorProtos$EnumOptionsOrBuilder {
    private boolean allowAlias_;
    private int bitField0_;
    private boolean deprecated_;
    private RepeatedFieldBuilderV3 uninterpretedOptionBuilder_;
    private List uninterpretedOption_;

    private DescriptorProtos$EnumOptions$Builder() {
        List list;
        this.uninterpretedOption_ = list = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$EnumOptions$Builder(DescriptorProtos$1 descriptorProtos$1) {
        this();
    }

    private DescriptorProtos$EnumOptions$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        this.uninterpretedOption_ = object = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$EnumOptions$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$BuilderParent);
    }

    private void ensureUninterpretedOptionIsMutable() {
        int n10 = this.bitField0_ & 4;
        if (n10 == 0) {
            ArrayList arrayList;
            List list = this.uninterpretedOption_;
            this.uninterpretedOption_ = arrayList = new ArrayList(list);
            this.bitField0_ = n10 = this.bitField0_ | 4;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$21000();
    }

    private RepeatedFieldBuilderV3 getUninterpretedOptionFieldBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.uninterpretedOptionBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            List list = this.uninterpretedOption_;
            int n10 = this.bitField0_ & 4;
            n10 = n10 != 0 ? 1 : 0;
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.uninterpretedOptionBuilder_ = repeatedFieldBuilderV3 = new RepeatedFieldBuilderV3(list, n10 != 0, generatedMessageV3$BuilderParent, bl2);
            repeatedFieldBuilderV3 = null;
            this.uninterpretedOption_ = null;
        }
        return this.uninterpretedOptionBuilder_;
    }

    private void maybeForceBuilderInitialization() {
        boolean bl2 = GeneratedMessageV3.alwaysUseFieldBuilders;
        if (bl2) {
            this.getUninterpretedOptionFieldBuilder();
        }
    }

    public DescriptorProtos$EnumOptions$Builder addAllUninterpretedOption(Iterable iterable) {
        Object object = this.uninterpretedOptionBuilder_;
        if (object == null) {
            this.ensureUninterpretedOptionIsMutable();
            object = this.uninterpretedOption_;
            AbstractMessageLite$Builder.addAll(iterable, (List)object);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addAllMessages(iterable);
        }
        return this;
    }

    public DescriptorProtos$EnumOptions$Builder addExtension(GeneratedMessage$GeneratedExtension generatedMessage$GeneratedExtension, Object object) {
        return (DescriptorProtos$EnumOptions$Builder)super.addExtension(generatedMessage$GeneratedExtension, object);
    }

    public DescriptorProtos$EnumOptions$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$EnumOptions$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$EnumOptions$Builder addUninterpretedOption(int n10, DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOptionOrBuilder) {
        Object object = this.uninterpretedOptionBuilder_;
        if (object == null) {
            this.ensureUninterpretedOptionIsMutable();
            object = this.uninterpretedOption_;
            descriptorProtos$UninterpretedOptionOrBuilder = ((DescriptorProtos$UninterpretedOption$Builder)descriptorProtos$UninterpretedOptionOrBuilder).build();
            object.add(n10, descriptorProtos$UninterpretedOptionOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$UninterpretedOptionOrBuilder = ((DescriptorProtos$UninterpretedOption$Builder)descriptorProtos$UninterpretedOptionOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage(n10, (AbstractMessage)((Object)descriptorProtos$UninterpretedOptionOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$EnumOptions$Builder addUninterpretedOption(int n10, DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
        Object object = this.uninterpretedOptionBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$UninterpretedOption);
            this.ensureUninterpretedOptionIsMutable();
            object = this.uninterpretedOption_;
            object.add(n10, descriptorProtos$UninterpretedOption);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(n10, descriptorProtos$UninterpretedOption);
        }
        return this;
    }

    public DescriptorProtos$EnumOptions$Builder addUninterpretedOption(DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOptionOrBuilder) {
        Object object = this.uninterpretedOptionBuilder_;
        if (object == null) {
            this.ensureUninterpretedOptionIsMutable();
            object = this.uninterpretedOption_;
            descriptorProtos$UninterpretedOptionOrBuilder = ((DescriptorProtos$UninterpretedOption$Builder)descriptorProtos$UninterpretedOptionOrBuilder).build();
            object.add(descriptorProtos$UninterpretedOptionOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$UninterpretedOptionOrBuilder = ((DescriptorProtos$UninterpretedOption$Builder)descriptorProtos$UninterpretedOptionOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage((AbstractMessage)((Object)descriptorProtos$UninterpretedOptionOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$EnumOptions$Builder addUninterpretedOption(DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
        Object object = this.uninterpretedOptionBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$UninterpretedOption);
            this.ensureUninterpretedOptionIsMutable();
            object = this.uninterpretedOption_;
            object.add(descriptorProtos$UninterpretedOption);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(descriptorProtos$UninterpretedOption);
        }
        return this;
    }

    public DescriptorProtos$UninterpretedOption$Builder addUninterpretedOptionBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getUninterpretedOptionFieldBuilder();
        DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption = DescriptorProtos$UninterpretedOption.getDefaultInstance();
        return (DescriptorProtos$UninterpretedOption$Builder)repeatedFieldBuilderV3.addBuilder(descriptorProtos$UninterpretedOption);
    }

    public DescriptorProtos$UninterpretedOption$Builder addUninterpretedOptionBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getUninterpretedOptionFieldBuilder();
        DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption = DescriptorProtos$UninterpretedOption.getDefaultInstance();
        return (DescriptorProtos$UninterpretedOption$Builder)repeatedFieldBuilderV3.addBuilder(n10, descriptorProtos$UninterpretedOption);
    }

    public DescriptorProtos$EnumOptions build() {
        DescriptorProtos$EnumOptions descriptorProtos$EnumOptions = this.buildPartial();
        boolean bl2 = descriptorProtos$EnumOptions.isInitialized();
        if (bl2) {
            return descriptorProtos$EnumOptions;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(descriptorProtos$EnumOptions);
    }

    public DescriptorProtos$EnumOptions buildPartial() {
        List list = null;
        DescriptorProtos$EnumOptions descriptorProtos$EnumOptions = new DescriptorProtos$EnumOptions(this, null);
        int n10 = this.bitField0_;
        int n11 = n10 & 1;
        if (n11 != 0) {
            n11 = (int)(this.allowAlias_ ? 1 : 0);
            DescriptorProtos$EnumOptions.access$21502(descriptorProtos$EnumOptions, n11 != 0);
            n11 = 1;
        } else {
            n11 = 0;
        }
        if ((n10 &= 2) != 0) {
            n10 = (int)(this.deprecated_ ? 1 : 0);
            DescriptorProtos$EnumOptions.access$21602(descriptorProtos$EnumOptions, n10 != 0);
            n11 |= 2;
        }
        if ((list = this.uninterpretedOptionBuilder_) == null) {
            n10 = this.bitField0_ & 4;
            if (n10 != 0) {
                this.uninterpretedOption_ = list = Collections.unmodifiableList(this.uninterpretedOption_);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
            }
            list = this.uninterpretedOption_;
            DescriptorProtos$EnumOptions.access$21702(descriptorProtos$EnumOptions, list);
        } else {
            list = ((RepeatedFieldBuilderV3)((Object)list)).build();
            DescriptorProtos$EnumOptions.access$21702(descriptorProtos$EnumOptions, list);
        }
        DescriptorProtos$EnumOptions.access$21802(descriptorProtos$EnumOptions, n11);
        this.onBuilt();
        return descriptorProtos$EnumOptions;
    }

    public DescriptorProtos$EnumOptions$Builder clear() {
        int n10;
        int n11;
        super.clear();
        this.allowAlias_ = false;
        this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
        this.deprecated_ = false;
        this.bitField0_ = n10 = n11 & 0xFFFFFFFD;
        Object object = this.uninterpretedOptionBuilder_;
        if (object == null) {
            this.uninterpretedOption_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public DescriptorProtos$EnumOptions$Builder clearAllowAlias() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.allowAlias_ = false;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$EnumOptions$Builder clearDeprecated() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        this.deprecated_ = false;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$EnumOptions$Builder clearExtension(GeneratedMessage$GeneratedExtension generatedMessage$GeneratedExtension) {
        return (DescriptorProtos$EnumOptions$Builder)super.clearExtension(generatedMessage$GeneratedExtension);
    }

    public DescriptorProtos$EnumOptions$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (DescriptorProtos$EnumOptions$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public DescriptorProtos$EnumOptions$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (DescriptorProtos$EnumOptions$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public DescriptorProtos$EnumOptions$Builder clearUninterpretedOption() {
        Object object = this.uninterpretedOptionBuilder_;
        if (object == null) {
            int n10;
            this.uninterpretedOption_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public DescriptorProtos$EnumOptions$Builder clone() {
        return (DescriptorProtos$EnumOptions$Builder)super.clone();
    }

    public boolean getAllowAlias() {
        return this.allowAlias_;
    }

    public DescriptorProtos$EnumOptions getDefaultInstanceForType() {
        return DescriptorProtos$EnumOptions.getDefaultInstance();
    }

    public boolean getDeprecated() {
        return this.deprecated_;
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.access$21000();
    }

    public DescriptorProtos$UninterpretedOption getUninterpretedOption(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.uninterpretedOptionBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (DescriptorProtos$UninterpretedOption)this.uninterpretedOption_.get(n10);
        }
        return (DescriptorProtos$UninterpretedOption)repeatedFieldBuilderV3.getMessage(n10);
    }

    public DescriptorProtos$UninterpretedOption$Builder getUninterpretedOptionBuilder(int n10) {
        return (DescriptorProtos$UninterpretedOption$Builder)this.getUninterpretedOptionFieldBuilder().getBuilder(n10);
    }

    public List getUninterpretedOptionBuilderList() {
        return this.getUninterpretedOptionFieldBuilder().getBuilderList();
    }

    public int getUninterpretedOptionCount() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.uninterpretedOptionBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return this.uninterpretedOption_.size();
        }
        return repeatedFieldBuilderV3.getCount();
    }

    public List getUninterpretedOptionList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.uninterpretedOptionBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return Collections.unmodifiableList(this.uninterpretedOption_);
        }
        return repeatedFieldBuilderV3.getMessageList();
    }

    public DescriptorProtos$UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.uninterpretedOptionBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (DescriptorProtos$UninterpretedOptionOrBuilder)this.uninterpretedOption_.get(n10);
        }
        return (DescriptorProtos$UninterpretedOptionOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(n10);
    }

    public List getUninterpretedOptionOrBuilderList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.uninterpretedOptionBuilder_;
        if (repeatedFieldBuilderV3 != null) {
            return repeatedFieldBuilderV3.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(this.uninterpretedOption_);
    }

    public boolean hasAllowAlias() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean hasDeprecated() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$21100().ensureFieldAccessorsInitialized(DescriptorProtos$EnumOptions.class, DescriptorProtos$EnumOptions$Builder.class);
    }

    public final boolean isInitialized() {
        int n10;
        int n11;
        for (n11 = 0; n11 < (n10 = this.getUninterpretedOptionCount()); ++n11) {
            DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption = this.getUninterpretedOption(n11);
            n10 = (int)(descriptorProtos$UninterpretedOption.isInitialized() ? 1 : 0);
            if (n10 != 0) continue;
            return false;
        }
        n11 = (int)(this.extensionsAreInitialized() ? 1 : 0);
        return n11 != 0;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public DescriptorProtos$EnumOptions$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = DescriptorProtos$EnumOptions.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (DescriptorProtos$EnumOptions)object;
            if (object == null) break block7;
            this.mergeFrom((DescriptorProtos$EnumOptions)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (DescriptorProtos$EnumOptions)object2;
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
            this.mergeFrom((DescriptorProtos$EnumOptions)object3);
        }
        throw var1_6;
    }

    public DescriptorProtos$EnumOptions$Builder mergeFrom(DescriptorProtos$EnumOptions messageLite) {
        boolean bl2;
        Object object = DescriptorProtos$EnumOptions.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        boolean n10 = ((DescriptorProtos$EnumOptions)messageLite).hasAllowAlias();
        if (n10) {
            boolean bl3 = ((DescriptorProtos$EnumOptions)messageLite).getAllowAlias();
            this.setAllowAlias(bl3);
        }
        if (bl2 = ((DescriptorProtos$EnumOptions)messageLite).hasDeprecated()) {
            boolean bl4 = ((DescriptorProtos$EnumOptions)messageLite).getDeprecated();
            this.setDeprecated(bl4);
        }
        if ((object = this.uninterpretedOptionBuilder_) == null) {
            object = DescriptorProtos$EnumOptions.access$21700((DescriptorProtos$EnumOptions)messageLite);
            boolean bl5 = object.isEmpty();
            if (!bl5) {
                object = this.uninterpretedOption_;
                boolean bl6 = object.isEmpty();
                if (bl6) {
                    int n11;
                    this.uninterpretedOption_ = object = DescriptorProtos$EnumOptions.access$21700((DescriptorProtos$EnumOptions)messageLite);
                    this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFB;
                } else {
                    this.ensureUninterpretedOptionIsMutable();
                    object = this.uninterpretedOption_;
                    List list = DescriptorProtos$EnumOptions.access$21700((DescriptorProtos$EnumOptions)messageLite);
                    object.addAll(list);
                }
                this.onChanged();
            }
        } else {
            object = DescriptorProtos$EnumOptions.access$21700((DescriptorProtos$EnumOptions)messageLite);
            boolean bl7 = object.isEmpty();
            if (!bl7) {
                object = this.uninterpretedOptionBuilder_;
                boolean bl8 = ((RepeatedFieldBuilderV3)object).isEmpty();
                if (bl8) {
                    int n12;
                    List list;
                    this.uninterpretedOptionBuilder_.dispose();
                    boolean bl9 = false;
                    object = null;
                    this.uninterpretedOptionBuilder_ = null;
                    this.uninterpretedOption_ = list = DescriptorProtos$EnumOptions.access$21700((DescriptorProtos$EnumOptions)messageLite);
                    this.bitField0_ = n12 = this.bitField0_ & 0xFFFFFFFB;
                    n12 = (int)(GeneratedMessageV3.alwaysUseFieldBuilders ? 1 : 0);
                    if (n12 != 0) {
                        object = this.getUninterpretedOptionFieldBuilder();
                    }
                    this.uninterpretedOptionBuilder_ = object;
                } else {
                    object = this.uninterpretedOptionBuilder_;
                    List list = DescriptorProtos$EnumOptions.access$21700((DescriptorProtos$EnumOptions)messageLite);
                    ((RepeatedFieldBuilderV3)object).addAllMessages(list);
                }
            }
        }
        this.mergeExtensionFields((GeneratedMessageV3$ExtendableMessage)messageLite);
        messageLite = ((GeneratedMessageV3)messageLite).unknownFields;
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$EnumOptions$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof DescriptorProtos$EnumOptions;
        if (bl2) {
            message = (DescriptorProtos$EnumOptions)message;
            return this.mergeFrom((DescriptorProtos$EnumOptions)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final DescriptorProtos$EnumOptions$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$EnumOptions$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public DescriptorProtos$EnumOptions$Builder removeUninterpretedOption(int n10) {
        Object object = this.uninterpretedOptionBuilder_;
        if (object == null) {
            this.ensureUninterpretedOptionIsMutable();
            object = this.uninterpretedOption_;
            object.remove(n10);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).remove(n10);
        }
        return this;
    }

    public DescriptorProtos$EnumOptions$Builder setAllowAlias(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.allowAlias_ = bl2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$EnumOptions$Builder setDeprecated(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.deprecated_ = bl2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$EnumOptions$Builder setExtension(GeneratedMessage$GeneratedExtension generatedMessage$GeneratedExtension, int n10, Object object) {
        return (DescriptorProtos$EnumOptions$Builder)super.setExtension(generatedMessage$GeneratedExtension, n10, object);
    }

    public DescriptorProtos$EnumOptions$Builder setExtension(GeneratedMessage$GeneratedExtension generatedMessage$GeneratedExtension, Object object) {
        return (DescriptorProtos$EnumOptions$Builder)super.setExtension(generatedMessage$GeneratedExtension, object);
    }

    public DescriptorProtos$EnumOptions$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$EnumOptions$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$EnumOptions$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (DescriptorProtos$EnumOptions$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public DescriptorProtos$EnumOptions$Builder setUninterpretedOption(int n10, DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOptionOrBuilder) {
        Object object = this.uninterpretedOptionBuilder_;
        if (object == null) {
            this.ensureUninterpretedOptionIsMutable();
            object = this.uninterpretedOption_;
            descriptorProtos$UninterpretedOptionOrBuilder = ((DescriptorProtos$UninterpretedOption$Builder)descriptorProtos$UninterpretedOptionOrBuilder).build();
            object.set(n10, descriptorProtos$UninterpretedOptionOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$UninterpretedOptionOrBuilder = ((DescriptorProtos$UninterpretedOption$Builder)descriptorProtos$UninterpretedOptionOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).setMessage(n10, (AbstractMessage)((Object)descriptorProtos$UninterpretedOptionOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$EnumOptions$Builder setUninterpretedOption(int n10, DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
        Object object = this.uninterpretedOptionBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$UninterpretedOption);
            this.ensureUninterpretedOptionIsMutable();
            object = this.uninterpretedOption_;
            object.set(n10, descriptorProtos$UninterpretedOption);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).setMessage(n10, descriptorProtos$UninterpretedOption);
        }
        return this;
    }

    public final DescriptorProtos$EnumOptions$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$EnumOptions$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

