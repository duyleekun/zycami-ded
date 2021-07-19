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
import com.google.protobuf.DescriptorProtos$ServiceOptions;
import com.google.protobuf.DescriptorProtos$ServiceOptionsOrBuilder;
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

public final class DescriptorProtos$ServiceOptions$Builder
extends GeneratedMessageV3$ExtendableBuilder
implements DescriptorProtos$ServiceOptionsOrBuilder {
    private int bitField0_;
    private boolean deprecated_;
    private RepeatedFieldBuilderV3 uninterpretedOptionBuilder_;
    private List uninterpretedOption_;

    private DescriptorProtos$ServiceOptions$Builder() {
        List list;
        this.uninterpretedOption_ = list = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$ServiceOptions$Builder(DescriptorProtos$1 descriptorProtos$1) {
        this();
    }

    private DescriptorProtos$ServiceOptions$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        this.uninterpretedOption_ = object = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$ServiceOptions$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$BuilderParent);
    }

    private void ensureUninterpretedOptionIsMutable() {
        int n10 = this.bitField0_ & 2;
        if (n10 == 0) {
            ArrayList arrayList;
            List list = this.uninterpretedOption_;
            this.uninterpretedOption_ = arrayList = new ArrayList(list);
            this.bitField0_ = n10 = this.bitField0_ | 2;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$22900();
    }

    private RepeatedFieldBuilderV3 getUninterpretedOptionFieldBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.uninterpretedOptionBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            List list = this.uninterpretedOption_;
            int n10 = this.bitField0_ & 2;
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

    public DescriptorProtos$ServiceOptions$Builder addAllUninterpretedOption(Iterable iterable) {
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

    public DescriptorProtos$ServiceOptions$Builder addExtension(GeneratedMessage$GeneratedExtension generatedMessage$GeneratedExtension, Object object) {
        return (DescriptorProtos$ServiceOptions$Builder)super.addExtension(generatedMessage$GeneratedExtension, object);
    }

    public DescriptorProtos$ServiceOptions$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$ServiceOptions$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$ServiceOptions$Builder addUninterpretedOption(int n10, DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOptionOrBuilder) {
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

    public DescriptorProtos$ServiceOptions$Builder addUninterpretedOption(int n10, DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
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

    public DescriptorProtos$ServiceOptions$Builder addUninterpretedOption(DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOptionOrBuilder) {
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

    public DescriptorProtos$ServiceOptions$Builder addUninterpretedOption(DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
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

    public DescriptorProtos$ServiceOptions build() {
        DescriptorProtos$ServiceOptions descriptorProtos$ServiceOptions = this.buildPartial();
        boolean bl2 = descriptorProtos$ServiceOptions.isInitialized();
        if (bl2) {
            return descriptorProtos$ServiceOptions;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(descriptorProtos$ServiceOptions);
    }

    public DescriptorProtos$ServiceOptions buildPartial() {
        List list = null;
        DescriptorProtos$ServiceOptions descriptorProtos$ServiceOptions = new DescriptorProtos$ServiceOptions(this, null);
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) != 0) {
            n10 = (int)(this.deprecated_ ? 1 : 0);
            DescriptorProtos$ServiceOptions.access$23402(descriptorProtos$ServiceOptions, n10 != 0);
        } else {
            n11 = 0;
        }
        list = this.uninterpretedOptionBuilder_;
        if (list == null) {
            n10 = this.bitField0_ & 2;
            if (n10 != 0) {
                this.uninterpretedOption_ = list = Collections.unmodifiableList(this.uninterpretedOption_);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
            }
            list = this.uninterpretedOption_;
            DescriptorProtos$ServiceOptions.access$23502(descriptorProtos$ServiceOptions, list);
        } else {
            list = ((RepeatedFieldBuilderV3)((Object)list)).build();
            DescriptorProtos$ServiceOptions.access$23502(descriptorProtos$ServiceOptions, list);
        }
        DescriptorProtos$ServiceOptions.access$23602(descriptorProtos$ServiceOptions, n11);
        this.onBuilt();
        return descriptorProtos$ServiceOptions;
    }

    public DescriptorProtos$ServiceOptions$Builder clear() {
        int n10;
        super.clear();
        this.deprecated_ = false;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        Object object = this.uninterpretedOptionBuilder_;
        if (object == null) {
            this.uninterpretedOption_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public DescriptorProtos$ServiceOptions$Builder clearDeprecated() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.deprecated_ = false;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$ServiceOptions$Builder clearExtension(GeneratedMessage$GeneratedExtension generatedMessage$GeneratedExtension) {
        return (DescriptorProtos$ServiceOptions$Builder)super.clearExtension(generatedMessage$GeneratedExtension);
    }

    public DescriptorProtos$ServiceOptions$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (DescriptorProtos$ServiceOptions$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public DescriptorProtos$ServiceOptions$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (DescriptorProtos$ServiceOptions$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public DescriptorProtos$ServiceOptions$Builder clearUninterpretedOption() {
        Object object = this.uninterpretedOptionBuilder_;
        if (object == null) {
            int n10;
            this.uninterpretedOption_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public DescriptorProtos$ServiceOptions$Builder clone() {
        return (DescriptorProtos$ServiceOptions$Builder)super.clone();
    }

    public DescriptorProtos$ServiceOptions getDefaultInstanceForType() {
        return DescriptorProtos$ServiceOptions.getDefaultInstance();
    }

    public boolean getDeprecated() {
        return this.deprecated_;
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.access$22900();
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

    public boolean hasDeprecated() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$23000().ensureFieldAccessorsInitialized(DescriptorProtos$ServiceOptions.class, DescriptorProtos$ServiceOptions$Builder.class);
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
    public DescriptorProtos$ServiceOptions$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = DescriptorProtos$ServiceOptions.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (DescriptorProtos$ServiceOptions)object;
            if (object == null) break block7;
            this.mergeFrom((DescriptorProtos$ServiceOptions)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (DescriptorProtos$ServiceOptions)object2;
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
            this.mergeFrom((DescriptorProtos$ServiceOptions)object3);
        }
        throw var1_6;
    }

    public DescriptorProtos$ServiceOptions$Builder mergeFrom(DescriptorProtos$ServiceOptions messageLite) {
        Object object = DescriptorProtos$ServiceOptions.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        boolean n10 = ((DescriptorProtos$ServiceOptions)messageLite).hasDeprecated();
        if (n10) {
            boolean bl2 = ((DescriptorProtos$ServiceOptions)messageLite).getDeprecated();
            this.setDeprecated(bl2);
        }
        if ((object = this.uninterpretedOptionBuilder_) == null) {
            object = DescriptorProtos$ServiceOptions.access$23500((DescriptorProtos$ServiceOptions)messageLite);
            boolean bl3 = object.isEmpty();
            if (!bl3) {
                object = this.uninterpretedOption_;
                boolean bl4 = object.isEmpty();
                if (bl4) {
                    int n11;
                    this.uninterpretedOption_ = object = DescriptorProtos$ServiceOptions.access$23500((DescriptorProtos$ServiceOptions)messageLite);
                    this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFD;
                } else {
                    this.ensureUninterpretedOptionIsMutable();
                    object = this.uninterpretedOption_;
                    List list = DescriptorProtos$ServiceOptions.access$23500((DescriptorProtos$ServiceOptions)messageLite);
                    object.addAll(list);
                }
                this.onChanged();
            }
        } else {
            object = DescriptorProtos$ServiceOptions.access$23500((DescriptorProtos$ServiceOptions)messageLite);
            boolean bl5 = object.isEmpty();
            if (!bl5) {
                object = this.uninterpretedOptionBuilder_;
                boolean bl6 = ((RepeatedFieldBuilderV3)object).isEmpty();
                if (bl6) {
                    int n12;
                    List list;
                    this.uninterpretedOptionBuilder_.dispose();
                    boolean bl7 = false;
                    object = null;
                    this.uninterpretedOptionBuilder_ = null;
                    this.uninterpretedOption_ = list = DescriptorProtos$ServiceOptions.access$23500((DescriptorProtos$ServiceOptions)messageLite);
                    this.bitField0_ = n12 = this.bitField0_ & 0xFFFFFFFD;
                    n12 = (int)(GeneratedMessageV3.alwaysUseFieldBuilders ? 1 : 0);
                    if (n12 != 0) {
                        object = this.getUninterpretedOptionFieldBuilder();
                    }
                    this.uninterpretedOptionBuilder_ = object;
                } else {
                    object = this.uninterpretedOptionBuilder_;
                    List list = DescriptorProtos$ServiceOptions.access$23500((DescriptorProtos$ServiceOptions)messageLite);
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

    public DescriptorProtos$ServiceOptions$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof DescriptorProtos$ServiceOptions;
        if (bl2) {
            message = (DescriptorProtos$ServiceOptions)message;
            return this.mergeFrom((DescriptorProtos$ServiceOptions)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final DescriptorProtos$ServiceOptions$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$ServiceOptions$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public DescriptorProtos$ServiceOptions$Builder removeUninterpretedOption(int n10) {
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

    public DescriptorProtos$ServiceOptions$Builder setDeprecated(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.deprecated_ = bl2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$ServiceOptions$Builder setExtension(GeneratedMessage$GeneratedExtension generatedMessage$GeneratedExtension, int n10, Object object) {
        return (DescriptorProtos$ServiceOptions$Builder)super.setExtension(generatedMessage$GeneratedExtension, n10, object);
    }

    public DescriptorProtos$ServiceOptions$Builder setExtension(GeneratedMessage$GeneratedExtension generatedMessage$GeneratedExtension, Object object) {
        return (DescriptorProtos$ServiceOptions$Builder)super.setExtension(generatedMessage$GeneratedExtension, object);
    }

    public DescriptorProtos$ServiceOptions$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$ServiceOptions$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$ServiceOptions$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (DescriptorProtos$ServiceOptions$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public DescriptorProtos$ServiceOptions$Builder setUninterpretedOption(int n10, DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOptionOrBuilder) {
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

    public DescriptorProtos$ServiceOptions$Builder setUninterpretedOption(int n10, DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
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

    public final DescriptorProtos$ServiceOptions$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$ServiceOptions$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

