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
import com.google.protobuf.DescriptorProtos$MessageOptions;
import com.google.protobuf.DescriptorProtos$MessageOptionsOrBuilder;
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

public final class DescriptorProtos$MessageOptions$Builder
extends GeneratedMessageV3$ExtendableBuilder
implements DescriptorProtos$MessageOptionsOrBuilder {
    private int bitField0_;
    private boolean deprecated_;
    private boolean mapEntry_;
    private boolean messageSetWireFormat_;
    private boolean noStandardDescriptorAccessor_;
    private RepeatedFieldBuilderV3 uninterpretedOptionBuilder_;
    private List uninterpretedOption_;

    private DescriptorProtos$MessageOptions$Builder() {
        List list;
        this.uninterpretedOption_ = list = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$MessageOptions$Builder(DescriptorProtos$1 descriptorProtos$1) {
        this();
    }

    private DescriptorProtos$MessageOptions$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        this.uninterpretedOption_ = object = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$MessageOptions$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$BuilderParent);
    }

    private void ensureUninterpretedOptionIsMutable() {
        int n10 = this.bitField0_ & 0x10;
        if (n10 == 0) {
            ArrayList arrayList;
            List list = this.uninterpretedOption_;
            this.uninterpretedOption_ = arrayList = new ArrayList(list);
            this.bitField0_ = n10 = this.bitField0_ | 0x10;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$17700();
    }

    private RepeatedFieldBuilderV3 getUninterpretedOptionFieldBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.uninterpretedOptionBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            List list = this.uninterpretedOption_;
            int n10 = this.bitField0_ & 0x10;
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

    public DescriptorProtos$MessageOptions$Builder addAllUninterpretedOption(Iterable iterable) {
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

    public DescriptorProtos$MessageOptions$Builder addExtension(GeneratedMessage$GeneratedExtension generatedMessage$GeneratedExtension, Object object) {
        return (DescriptorProtos$MessageOptions$Builder)super.addExtension(generatedMessage$GeneratedExtension, object);
    }

    public DescriptorProtos$MessageOptions$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$MessageOptions$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$MessageOptions$Builder addUninterpretedOption(int n10, DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOptionOrBuilder) {
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

    public DescriptorProtos$MessageOptions$Builder addUninterpretedOption(int n10, DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
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

    public DescriptorProtos$MessageOptions$Builder addUninterpretedOption(DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOptionOrBuilder) {
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

    public DescriptorProtos$MessageOptions$Builder addUninterpretedOption(DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
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

    public DescriptorProtos$MessageOptions build() {
        DescriptorProtos$MessageOptions descriptorProtos$MessageOptions = this.buildPartial();
        boolean bl2 = descriptorProtos$MessageOptions.isInitialized();
        if (bl2) {
            return descriptorProtos$MessageOptions;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(descriptorProtos$MessageOptions);
    }

    public DescriptorProtos$MessageOptions buildPartial() {
        int n10;
        List list = null;
        DescriptorProtos$MessageOptions descriptorProtos$MessageOptions = new DescriptorProtos$MessageOptions(this, null);
        int n102 = this.bitField0_;
        int n11 = n102 & 1;
        if (n11 != 0) {
            n11 = (int)(this.messageSetWireFormat_ ? 1 : 0);
            DescriptorProtos$MessageOptions.access$18202(descriptorProtos$MessageOptions, n11 != 0);
            n11 = 1;
        } else {
            n11 = 0;
        }
        int bl2 = n102 & 2;
        if (bl2 != 0) {
            boolean bl3 = this.noStandardDescriptorAccessor_;
            DescriptorProtos$MessageOptions.access$18302(descriptorProtos$MessageOptions, bl3);
            n11 |= 2;
        }
        if ((n10 = n102 & 4) != 0) {
            boolean bl4 = this.deprecated_;
            DescriptorProtos$MessageOptions.access$18402(descriptorProtos$MessageOptions, bl4);
            n11 |= 4;
        }
        if ((n102 &= 8) != 0) {
            n102 = (int)(this.mapEntry_ ? 1 : 0);
            DescriptorProtos$MessageOptions.access$18502(descriptorProtos$MessageOptions, n102 != 0);
            n11 |= 8;
        }
        if ((list = this.uninterpretedOptionBuilder_) == null) {
            n102 = this.bitField0_ & 0x10;
            if (n102 != 0) {
                this.uninterpretedOption_ = list = Collections.unmodifiableList(this.uninterpretedOption_);
                this.bitField0_ = n102 = this.bitField0_ & 0xFFFFFFEF;
            }
            list = this.uninterpretedOption_;
            DescriptorProtos$MessageOptions.access$18602(descriptorProtos$MessageOptions, list);
        } else {
            list = ((RepeatedFieldBuilderV3)((Object)list)).build();
            DescriptorProtos$MessageOptions.access$18602(descriptorProtos$MessageOptions, list);
        }
        DescriptorProtos$MessageOptions.access$18702(descriptorProtos$MessageOptions, n11);
        this.onBuilt();
        return descriptorProtos$MessageOptions;
    }

    public DescriptorProtos$MessageOptions$Builder clear() {
        int n10;
        int n11;
        super.clear();
        this.messageSetWireFormat_ = false;
        this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
        this.noStandardDescriptorAccessor_ = false;
        this.bitField0_ = n11 &= 0xFFFFFFFD;
        this.deprecated_ = false;
        this.bitField0_ = n11 &= 0xFFFFFFFB;
        this.mapEntry_ = false;
        this.bitField0_ = n10 = n11 & 0xFFFFFFF7;
        Object object = this.uninterpretedOptionBuilder_;
        if (object == null) {
            this.uninterpretedOption_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFEF;
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public DescriptorProtos$MessageOptions$Builder clearDeprecated() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        this.deprecated_ = false;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$MessageOptions$Builder clearExtension(GeneratedMessage$GeneratedExtension generatedMessage$GeneratedExtension) {
        return (DescriptorProtos$MessageOptions$Builder)super.clearExtension(generatedMessage$GeneratedExtension);
    }

    public DescriptorProtos$MessageOptions$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (DescriptorProtos$MessageOptions$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public DescriptorProtos$MessageOptions$Builder clearMapEntry() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
        this.mapEntry_ = false;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$MessageOptions$Builder clearMessageSetWireFormat() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.messageSetWireFormat_ = false;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$MessageOptions$Builder clearNoStandardDescriptorAccessor() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        this.noStandardDescriptorAccessor_ = false;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$MessageOptions$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (DescriptorProtos$MessageOptions$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public DescriptorProtos$MessageOptions$Builder clearUninterpretedOption() {
        Object object = this.uninterpretedOptionBuilder_;
        if (object == null) {
            int n10;
            this.uninterpretedOption_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFEF;
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public DescriptorProtos$MessageOptions$Builder clone() {
        return (DescriptorProtos$MessageOptions$Builder)super.clone();
    }

    public DescriptorProtos$MessageOptions getDefaultInstanceForType() {
        return DescriptorProtos$MessageOptions.getDefaultInstance();
    }

    public boolean getDeprecated() {
        return this.deprecated_;
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.access$17700();
    }

    public boolean getMapEntry() {
        return this.mapEntry_;
    }

    public boolean getMessageSetWireFormat() {
        return this.messageSetWireFormat_;
    }

    public boolean getNoStandardDescriptorAccessor() {
        return this.noStandardDescriptorAccessor_;
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
        int n10 = this.bitField0_ & 4;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasMapEntry() {
        int n10 = this.bitField0_ & 8;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasMessageSetWireFormat() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean hasNoStandardDescriptorAccessor() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$17800().ensureFieldAccessorsInitialized(DescriptorProtos$MessageOptions.class, DescriptorProtos$MessageOptions$Builder.class);
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
    public DescriptorProtos$MessageOptions$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = DescriptorProtos$MessageOptions.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (DescriptorProtos$MessageOptions)object;
            if (object == null) break block7;
            this.mergeFrom((DescriptorProtos$MessageOptions)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (DescriptorProtos$MessageOptions)object2;
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
            this.mergeFrom((DescriptorProtos$MessageOptions)object3);
        }
        throw var1_6;
    }

    public DescriptorProtos$MessageOptions$Builder mergeFrom(DescriptorProtos$MessageOptions messageLite) {
        boolean bl2;
        boolean bl3;
        boolean bl4;
        Object object = DescriptorProtos$MessageOptions.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        boolean n10 = ((DescriptorProtos$MessageOptions)messageLite).hasMessageSetWireFormat();
        if (n10) {
            boolean bl5 = ((DescriptorProtos$MessageOptions)messageLite).getMessageSetWireFormat();
            this.setMessageSetWireFormat(bl5);
        }
        if (bl4 = ((DescriptorProtos$MessageOptions)messageLite).hasNoStandardDescriptorAccessor()) {
            boolean bl6 = ((DescriptorProtos$MessageOptions)messageLite).getNoStandardDescriptorAccessor();
            this.setNoStandardDescriptorAccessor(bl6);
        }
        if (bl3 = ((DescriptorProtos$MessageOptions)messageLite).hasDeprecated()) {
            boolean bl7 = ((DescriptorProtos$MessageOptions)messageLite).getDeprecated();
            this.setDeprecated(bl7);
        }
        if (bl2 = ((DescriptorProtos$MessageOptions)messageLite).hasMapEntry()) {
            boolean bl8 = ((DescriptorProtos$MessageOptions)messageLite).getMapEntry();
            this.setMapEntry(bl8);
        }
        if ((object = this.uninterpretedOptionBuilder_) == null) {
            object = DescriptorProtos$MessageOptions.access$18600((DescriptorProtos$MessageOptions)messageLite);
            boolean bl9 = object.isEmpty();
            if (!bl9) {
                object = this.uninterpretedOption_;
                boolean bl10 = object.isEmpty();
                if (bl10) {
                    int n11;
                    this.uninterpretedOption_ = object = DescriptorProtos$MessageOptions.access$18600((DescriptorProtos$MessageOptions)messageLite);
                    this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFEF;
                } else {
                    this.ensureUninterpretedOptionIsMutable();
                    object = this.uninterpretedOption_;
                    List list = DescriptorProtos$MessageOptions.access$18600((DescriptorProtos$MessageOptions)messageLite);
                    object.addAll(list);
                }
                this.onChanged();
            }
        } else {
            object = DescriptorProtos$MessageOptions.access$18600((DescriptorProtos$MessageOptions)messageLite);
            boolean bl11 = object.isEmpty();
            if (!bl11) {
                object = this.uninterpretedOptionBuilder_;
                boolean bl12 = ((RepeatedFieldBuilderV3)object).isEmpty();
                if (bl12) {
                    int n12;
                    List list;
                    this.uninterpretedOptionBuilder_.dispose();
                    boolean bl13 = false;
                    object = null;
                    this.uninterpretedOptionBuilder_ = null;
                    this.uninterpretedOption_ = list = DescriptorProtos$MessageOptions.access$18600((DescriptorProtos$MessageOptions)messageLite);
                    this.bitField0_ = n12 = this.bitField0_ & 0xFFFFFFEF;
                    n12 = (int)(GeneratedMessageV3.alwaysUseFieldBuilders ? 1 : 0);
                    if (n12 != 0) {
                        object = this.getUninterpretedOptionFieldBuilder();
                    }
                    this.uninterpretedOptionBuilder_ = object;
                } else {
                    object = this.uninterpretedOptionBuilder_;
                    List list = DescriptorProtos$MessageOptions.access$18600((DescriptorProtos$MessageOptions)messageLite);
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

    public DescriptorProtos$MessageOptions$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof DescriptorProtos$MessageOptions;
        if (bl2) {
            message = (DescriptorProtos$MessageOptions)message;
            return this.mergeFrom((DescriptorProtos$MessageOptions)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final DescriptorProtos$MessageOptions$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$MessageOptions$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public DescriptorProtos$MessageOptions$Builder removeUninterpretedOption(int n10) {
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

    public DescriptorProtos$MessageOptions$Builder setDeprecated(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.deprecated_ = bl2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$MessageOptions$Builder setExtension(GeneratedMessage$GeneratedExtension generatedMessage$GeneratedExtension, int n10, Object object) {
        return (DescriptorProtos$MessageOptions$Builder)super.setExtension(generatedMessage$GeneratedExtension, n10, object);
    }

    public DescriptorProtos$MessageOptions$Builder setExtension(GeneratedMessage$GeneratedExtension generatedMessage$GeneratedExtension, Object object) {
        return (DescriptorProtos$MessageOptions$Builder)super.setExtension(generatedMessage$GeneratedExtension, object);
    }

    public DescriptorProtos$MessageOptions$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$MessageOptions$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$MessageOptions$Builder setMapEntry(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 8;
        this.mapEntry_ = bl2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$MessageOptions$Builder setMessageSetWireFormat(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.messageSetWireFormat_ = bl2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$MessageOptions$Builder setNoStandardDescriptorAccessor(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.noStandardDescriptorAccessor_ = bl2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$MessageOptions$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (DescriptorProtos$MessageOptions$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public DescriptorProtos$MessageOptions$Builder setUninterpretedOption(int n10, DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOptionOrBuilder) {
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

    public DescriptorProtos$MessageOptions$Builder setUninterpretedOption(int n10, DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
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

    public final DescriptorProtos$MessageOptions$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$MessageOptions$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

