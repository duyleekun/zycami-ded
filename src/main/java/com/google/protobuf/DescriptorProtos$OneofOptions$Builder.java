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
import com.google.protobuf.DescriptorProtos$OneofOptions;
import com.google.protobuf.DescriptorProtos$OneofOptionsOrBuilder;
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

public final class DescriptorProtos$OneofOptions$Builder
extends GeneratedMessageV3$ExtendableBuilder
implements DescriptorProtos$OneofOptionsOrBuilder {
    private int bitField0_;
    private RepeatedFieldBuilderV3 uninterpretedOptionBuilder_;
    private List uninterpretedOption_;

    private DescriptorProtos$OneofOptions$Builder() {
        List list;
        this.uninterpretedOption_ = list = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$OneofOptions$Builder(DescriptorProtos$1 descriptorProtos$1) {
        this();
    }

    private DescriptorProtos$OneofOptions$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        this.uninterpretedOption_ = object = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$OneofOptions$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$BuilderParent);
    }

    private void ensureUninterpretedOptionIsMutable() {
        int n10 = this.bitField0_ & 1;
        if (n10 == 0) {
            ArrayList arrayList;
            List list = this.uninterpretedOption_;
            this.uninterpretedOption_ = arrayList = new ArrayList(list);
            this.bitField0_ = n10 = this.bitField0_ | 1;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$20300();
    }

    private RepeatedFieldBuilderV3 getUninterpretedOptionFieldBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.uninterpretedOptionBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            List list = this.uninterpretedOption_;
            int n10 = this.bitField0_;
            int n11 = 1;
            if ((n10 &= n11) == 0) {
                n11 = 0;
            }
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.uninterpretedOptionBuilder_ = repeatedFieldBuilderV3 = new RepeatedFieldBuilderV3(list, n11 != 0, generatedMessageV3$BuilderParent, bl2);
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

    public DescriptorProtos$OneofOptions$Builder addAllUninterpretedOption(Iterable iterable) {
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

    public DescriptorProtos$OneofOptions$Builder addExtension(GeneratedMessage$GeneratedExtension generatedMessage$GeneratedExtension, Object object) {
        return (DescriptorProtos$OneofOptions$Builder)super.addExtension(generatedMessage$GeneratedExtension, object);
    }

    public DescriptorProtos$OneofOptions$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$OneofOptions$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$OneofOptions$Builder addUninterpretedOption(int n10, DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOptionOrBuilder) {
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

    public DescriptorProtos$OneofOptions$Builder addUninterpretedOption(int n10, DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
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

    public DescriptorProtos$OneofOptions$Builder addUninterpretedOption(DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOptionOrBuilder) {
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

    public DescriptorProtos$OneofOptions$Builder addUninterpretedOption(DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
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

    public DescriptorProtos$OneofOptions build() {
        DescriptorProtos$OneofOptions descriptorProtos$OneofOptions = this.buildPartial();
        boolean bl2 = descriptorProtos$OneofOptions.isInitialized();
        if (bl2) {
            return descriptorProtos$OneofOptions;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(descriptorProtos$OneofOptions);
    }

    public DescriptorProtos$OneofOptions buildPartial() {
        List list = null;
        DescriptorProtos$OneofOptions descriptorProtos$OneofOptions = new DescriptorProtos$OneofOptions(this, null);
        int n10 = this.bitField0_;
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.uninterpretedOptionBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            if ((n10 &= 1) != 0) {
                this.uninterpretedOption_ = list = Collections.unmodifiableList(this.uninterpretedOption_);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
            }
            list = this.uninterpretedOption_;
            DescriptorProtos$OneofOptions.access$20802(descriptorProtos$OneofOptions, list);
        } else {
            list = repeatedFieldBuilderV3.build();
            DescriptorProtos$OneofOptions.access$20802(descriptorProtos$OneofOptions, list);
        }
        this.onBuilt();
        return descriptorProtos$OneofOptions;
    }

    public DescriptorProtos$OneofOptions$Builder clear() {
        super.clear();
        Object object = this.uninterpretedOptionBuilder_;
        if (object == null) {
            int n10;
            this.uninterpretedOption_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public DescriptorProtos$OneofOptions$Builder clearExtension(GeneratedMessage$GeneratedExtension generatedMessage$GeneratedExtension) {
        return (DescriptorProtos$OneofOptions$Builder)super.clearExtension(generatedMessage$GeneratedExtension);
    }

    public DescriptorProtos$OneofOptions$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (DescriptorProtos$OneofOptions$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public DescriptorProtos$OneofOptions$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (DescriptorProtos$OneofOptions$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public DescriptorProtos$OneofOptions$Builder clearUninterpretedOption() {
        Object object = this.uninterpretedOptionBuilder_;
        if (object == null) {
            int n10;
            this.uninterpretedOption_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public DescriptorProtos$OneofOptions$Builder clone() {
        return (DescriptorProtos$OneofOptions$Builder)super.clone();
    }

    public DescriptorProtos$OneofOptions getDefaultInstanceForType() {
        return DescriptorProtos$OneofOptions.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.access$20300();
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

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$20400().ensureFieldAccessorsInitialized(DescriptorProtos$OneofOptions.class, DescriptorProtos$OneofOptions$Builder.class);
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
    public DescriptorProtos$OneofOptions$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = DescriptorProtos$OneofOptions.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (DescriptorProtos$OneofOptions)object;
            if (object == null) break block7;
            this.mergeFrom((DescriptorProtos$OneofOptions)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (DescriptorProtos$OneofOptions)object2;
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
            this.mergeFrom((DescriptorProtos$OneofOptions)object3);
        }
        throw var1_6;
    }

    public DescriptorProtos$OneofOptions$Builder mergeFrom(DescriptorProtos$OneofOptions messageLite) {
        Object object = DescriptorProtos$OneofOptions.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        object = this.uninterpretedOptionBuilder_;
        if (object == null) {
            object = DescriptorProtos$OneofOptions.access$20800(messageLite);
            int n10 = object.isEmpty();
            if (n10 == 0) {
                object = this.uninterpretedOption_;
                n10 = object.isEmpty();
                if (n10 != 0) {
                    this.uninterpretedOption_ = object = DescriptorProtos$OneofOptions.access$20800(messageLite);
                    this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
                } else {
                    this.ensureUninterpretedOptionIsMutable();
                    object = this.uninterpretedOption_;
                    List list = DescriptorProtos$OneofOptions.access$20800(messageLite);
                    object.addAll(list);
                }
                this.onChanged();
            }
        } else {
            object = DescriptorProtos$OneofOptions.access$20800(messageLite);
            boolean bl2 = object.isEmpty();
            if (!bl2) {
                object = this.uninterpretedOptionBuilder_;
                bl2 = ((RepeatedFieldBuilderV3)object).isEmpty();
                if (bl2) {
                    int n11;
                    List list;
                    this.uninterpretedOptionBuilder_.dispose();
                    bl2 = false;
                    object = null;
                    this.uninterpretedOptionBuilder_ = null;
                    this.uninterpretedOption_ = list = DescriptorProtos$OneofOptions.access$20800(messageLite);
                    this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
                    n11 = (int)(GeneratedMessageV3.alwaysUseFieldBuilders ? 1 : 0);
                    if (n11 != 0) {
                        object = this.getUninterpretedOptionFieldBuilder();
                    }
                    this.uninterpretedOptionBuilder_ = object;
                } else {
                    object = this.uninterpretedOptionBuilder_;
                    List list = DescriptorProtos$OneofOptions.access$20800(messageLite);
                    ((RepeatedFieldBuilderV3)object).addAllMessages(list);
                }
            }
        }
        this.mergeExtensionFields((GeneratedMessageV3$ExtendableMessage)messageLite);
        messageLite = messageLite.unknownFields;
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$OneofOptions$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof DescriptorProtos$OneofOptions;
        if (bl2) {
            message = (DescriptorProtos$OneofOptions)message;
            return this.mergeFrom((DescriptorProtos$OneofOptions)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final DescriptorProtos$OneofOptions$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$OneofOptions$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public DescriptorProtos$OneofOptions$Builder removeUninterpretedOption(int n10) {
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

    public DescriptorProtos$OneofOptions$Builder setExtension(GeneratedMessage$GeneratedExtension generatedMessage$GeneratedExtension, int n10, Object object) {
        return (DescriptorProtos$OneofOptions$Builder)super.setExtension(generatedMessage$GeneratedExtension, n10, object);
    }

    public DescriptorProtos$OneofOptions$Builder setExtension(GeneratedMessage$GeneratedExtension generatedMessage$GeneratedExtension, Object object) {
        return (DescriptorProtos$OneofOptions$Builder)super.setExtension(generatedMessage$GeneratedExtension, object);
    }

    public DescriptorProtos$OneofOptions$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$OneofOptions$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$OneofOptions$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (DescriptorProtos$OneofOptions$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public DescriptorProtos$OneofOptions$Builder setUninterpretedOption(int n10, DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOptionOrBuilder) {
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

    public DescriptorProtos$OneofOptions$Builder setUninterpretedOption(int n10, DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
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

    public final DescriptorProtos$OneofOptions$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$OneofOptions$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

