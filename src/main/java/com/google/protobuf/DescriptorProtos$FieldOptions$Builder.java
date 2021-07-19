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
import com.google.protobuf.DescriptorProtos$FieldOptions;
import com.google.protobuf.DescriptorProtos$FieldOptions$CType;
import com.google.protobuf.DescriptorProtos$FieldOptions$JSType;
import com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder;
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

public final class DescriptorProtos$FieldOptions$Builder
extends GeneratedMessageV3$ExtendableBuilder
implements DescriptorProtos$FieldOptionsOrBuilder {
    private int bitField0_;
    private int ctype_ = 0;
    private boolean deprecated_;
    private int jstype_ = 0;
    private boolean lazy_;
    private boolean packed_;
    private RepeatedFieldBuilderV3 uninterpretedOptionBuilder_;
    private List uninterpretedOption_;
    private boolean weak_;

    private DescriptorProtos$FieldOptions$Builder() {
        List list;
        this.uninterpretedOption_ = list = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$FieldOptions$Builder(DescriptorProtos$1 descriptorProtos$1) {
        this();
    }

    private DescriptorProtos$FieldOptions$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        this.uninterpretedOption_ = object = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$FieldOptions$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$BuilderParent);
    }

    private void ensureUninterpretedOptionIsMutable() {
        int n10 = this.bitField0_ & 0x40;
        if (n10 == 0) {
            ArrayList arrayList;
            List list = this.uninterpretedOption_;
            this.uninterpretedOption_ = arrayList = new ArrayList(list);
            this.bitField0_ = n10 = this.bitField0_ | 0x40;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$18900();
    }

    private RepeatedFieldBuilderV3 getUninterpretedOptionFieldBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.uninterpretedOptionBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            List list = this.uninterpretedOption_;
            int n10 = this.bitField0_ & 0x40;
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

    public DescriptorProtos$FieldOptions$Builder addAllUninterpretedOption(Iterable iterable) {
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

    public DescriptorProtos$FieldOptions$Builder addExtension(GeneratedMessage$GeneratedExtension generatedMessage$GeneratedExtension, Object object) {
        return (DescriptorProtos$FieldOptions$Builder)super.addExtension(generatedMessage$GeneratedExtension, object);
    }

    public DescriptorProtos$FieldOptions$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$FieldOptions$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$FieldOptions$Builder addUninterpretedOption(int n10, DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOptionOrBuilder) {
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

    public DescriptorProtos$FieldOptions$Builder addUninterpretedOption(int n10, DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
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

    public DescriptorProtos$FieldOptions$Builder addUninterpretedOption(DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOptionOrBuilder) {
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

    public DescriptorProtos$FieldOptions$Builder addUninterpretedOption(DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
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

    public DescriptorProtos$FieldOptions build() {
        DescriptorProtos$FieldOptions descriptorProtos$FieldOptions = this.buildPartial();
        boolean bl2 = descriptorProtos$FieldOptions.isInitialized();
        if (bl2) {
            return descriptorProtos$FieldOptions;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(descriptorProtos$FieldOptions);
    }

    public DescriptorProtos$FieldOptions buildPartial() {
        int n10;
        int n11;
        List list = null;
        DescriptorProtos$FieldOptions descriptorProtos$FieldOptions = new DescriptorProtos$FieldOptions(this, null);
        int n102 = this.bitField0_;
        int n112 = n102 & 1;
        n112 = n112 != 0 ? 1 : 0;
        int bl2 = this.ctype_;
        DescriptorProtos$FieldOptions.access$19402(descriptorProtos$FieldOptions, bl2);
        int n12 = n102 & 2;
        if (n12 != 0) {
            boolean bl3 = this.packed_;
            DescriptorProtos$FieldOptions.access$19502(descriptorProtos$FieldOptions, bl3);
            n112 |= 2;
        }
        if ((n11 = n102 & 4) != 0) {
            n112 |= 4;
        }
        int n13 = this.jstype_;
        DescriptorProtos$FieldOptions.access$19602(descriptorProtos$FieldOptions, n13);
        int n14 = n102 & 8;
        if (n14 != 0) {
            boolean bl4 = this.lazy_;
            DescriptorProtos$FieldOptions.access$19702(descriptorProtos$FieldOptions, bl4);
            n112 |= 8;
        }
        if ((n10 = n102 & 0x10) != 0) {
            boolean bl5 = this.deprecated_;
            DescriptorProtos$FieldOptions.access$19802(descriptorProtos$FieldOptions, bl5);
            n112 |= 0x10;
        }
        if ((n102 &= 0x20) != 0) {
            n102 = (int)(this.weak_ ? 1 : 0);
            DescriptorProtos$FieldOptions.access$19902(descriptorProtos$FieldOptions, n102 != 0);
            n112 |= 0x20;
        }
        if ((list = this.uninterpretedOptionBuilder_) == null) {
            n102 = this.bitField0_ & 0x40;
            if (n102 != 0) {
                this.uninterpretedOption_ = list = Collections.unmodifiableList(this.uninterpretedOption_);
                this.bitField0_ = n102 = this.bitField0_ & 0xFFFFFFBF;
            }
            list = this.uninterpretedOption_;
            DescriptorProtos$FieldOptions.access$20002(descriptorProtos$FieldOptions, list);
        } else {
            list = ((RepeatedFieldBuilderV3)((Object)list)).build();
            DescriptorProtos$FieldOptions.access$20002(descriptorProtos$FieldOptions, list);
        }
        DescriptorProtos$FieldOptions.access$20102(descriptorProtos$FieldOptions, n112);
        this.onBuilt();
        return descriptorProtos$FieldOptions;
    }

    public DescriptorProtos$FieldOptions$Builder clear() {
        int n10;
        int n11;
        super.clear();
        this.ctype_ = 0;
        this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
        this.packed_ = false;
        this.bitField0_ = n11 &= 0xFFFFFFFD;
        this.jstype_ = 0;
        this.bitField0_ = n11 &= 0xFFFFFFFB;
        this.lazy_ = false;
        this.bitField0_ = n11 &= 0xFFFFFFF7;
        this.deprecated_ = false;
        this.bitField0_ = n11 &= 0xFFFFFFEF;
        this.weak_ = false;
        this.bitField0_ = n10 = n11 & 0xFFFFFFDF;
        Object object = this.uninterpretedOptionBuilder_;
        if (object == null) {
            this.uninterpretedOption_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFBF;
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public DescriptorProtos$FieldOptions$Builder clearCtype() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.ctype_ = 0;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldOptions$Builder clearDeprecated() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFEF;
        this.deprecated_ = false;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldOptions$Builder clearExtension(GeneratedMessage$GeneratedExtension generatedMessage$GeneratedExtension) {
        return (DescriptorProtos$FieldOptions$Builder)super.clearExtension(generatedMessage$GeneratedExtension);
    }

    public DescriptorProtos$FieldOptions$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (DescriptorProtos$FieldOptions$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public DescriptorProtos$FieldOptions$Builder clearJstype() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        this.jstype_ = 0;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldOptions$Builder clearLazy() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
        this.lazy_ = false;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldOptions$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (DescriptorProtos$FieldOptions$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public DescriptorProtos$FieldOptions$Builder clearPacked() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        this.packed_ = false;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldOptions$Builder clearUninterpretedOption() {
        Object object = this.uninterpretedOptionBuilder_;
        if (object == null) {
            int n10;
            this.uninterpretedOption_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFBF;
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public DescriptorProtos$FieldOptions$Builder clearWeak() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFDF;
        this.weak_ = false;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldOptions$Builder clone() {
        return (DescriptorProtos$FieldOptions$Builder)super.clone();
    }

    public DescriptorProtos$FieldOptions$CType getCtype() {
        int n10 = this.ctype_;
        DescriptorProtos$FieldOptions$CType descriptorProtos$FieldOptions$CType = DescriptorProtos$FieldOptions$CType.valueOf(n10);
        if (descriptorProtos$FieldOptions$CType == null) {
            descriptorProtos$FieldOptions$CType = DescriptorProtos$FieldOptions$CType.STRING;
        }
        return descriptorProtos$FieldOptions$CType;
    }

    public DescriptorProtos$FieldOptions getDefaultInstanceForType() {
        return DescriptorProtos$FieldOptions.getDefaultInstance();
    }

    public boolean getDeprecated() {
        return this.deprecated_;
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.access$18900();
    }

    public DescriptorProtos$FieldOptions$JSType getJstype() {
        int n10 = this.jstype_;
        DescriptorProtos$FieldOptions$JSType descriptorProtos$FieldOptions$JSType = DescriptorProtos$FieldOptions$JSType.valueOf(n10);
        if (descriptorProtos$FieldOptions$JSType == null) {
            descriptorProtos$FieldOptions$JSType = DescriptorProtos$FieldOptions$JSType.JS_NORMAL;
        }
        return descriptorProtos$FieldOptions$JSType;
    }

    public boolean getLazy() {
        return this.lazy_;
    }

    public boolean getPacked() {
        return this.packed_;
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

    public boolean getWeak() {
        return this.weak_;
    }

    public boolean hasCtype() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean hasDeprecated() {
        int n10 = this.bitField0_ & 0x10;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasJstype() {
        int n10 = this.bitField0_ & 4;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasLazy() {
        int n10 = this.bitField0_ & 8;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasPacked() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasWeak() {
        int n10 = this.bitField0_ & 0x20;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$19000().ensureFieldAccessorsInitialized(DescriptorProtos$FieldOptions.class, DescriptorProtos$FieldOptions$Builder.class);
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
    public DescriptorProtos$FieldOptions$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = DescriptorProtos$FieldOptions.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (DescriptorProtos$FieldOptions)object;
            if (object == null) break block7;
            this.mergeFrom((DescriptorProtos$FieldOptions)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (DescriptorProtos$FieldOptions)object2;
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
            this.mergeFrom((DescriptorProtos$FieldOptions)object3);
        }
        throw var1_6;
    }

    public DescriptorProtos$FieldOptions$Builder mergeFrom(DescriptorProtos$FieldOptions messageLite) {
        boolean bl2;
        boolean bl3;
        boolean bl4;
        boolean bl5;
        boolean bl6;
        Object object = DescriptorProtos$FieldOptions.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        boolean n10 = ((DescriptorProtos$FieldOptions)messageLite).hasCtype();
        if (n10) {
            object = ((DescriptorProtos$FieldOptions)messageLite).getCtype();
            this.setCtype((DescriptorProtos$FieldOptions$CType)object);
        }
        if (bl6 = ((DescriptorProtos$FieldOptions)messageLite).hasPacked()) {
            boolean bl7 = ((DescriptorProtos$FieldOptions)messageLite).getPacked();
            this.setPacked(bl7);
        }
        if (bl5 = ((DescriptorProtos$FieldOptions)messageLite).hasJstype()) {
            object = ((DescriptorProtos$FieldOptions)messageLite).getJstype();
            this.setJstype((DescriptorProtos$FieldOptions$JSType)object);
        }
        if (bl4 = ((DescriptorProtos$FieldOptions)messageLite).hasLazy()) {
            boolean bl8 = ((DescriptorProtos$FieldOptions)messageLite).getLazy();
            this.setLazy(bl8);
        }
        if (bl3 = ((DescriptorProtos$FieldOptions)messageLite).hasDeprecated()) {
            boolean bl9 = ((DescriptorProtos$FieldOptions)messageLite).getDeprecated();
            this.setDeprecated(bl9);
        }
        if (bl2 = ((DescriptorProtos$FieldOptions)messageLite).hasWeak()) {
            boolean bl10 = ((DescriptorProtos$FieldOptions)messageLite).getWeak();
            this.setWeak(bl10);
        }
        if ((object = this.uninterpretedOptionBuilder_) == null) {
            object = DescriptorProtos$FieldOptions.access$20000((DescriptorProtos$FieldOptions)messageLite);
            boolean bl11 = object.isEmpty();
            if (!bl11) {
                object = this.uninterpretedOption_;
                boolean bl12 = object.isEmpty();
                if (bl12) {
                    int n11;
                    this.uninterpretedOption_ = object = DescriptorProtos$FieldOptions.access$20000((DescriptorProtos$FieldOptions)messageLite);
                    this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFBF;
                } else {
                    this.ensureUninterpretedOptionIsMutable();
                    object = this.uninterpretedOption_;
                    List list = DescriptorProtos$FieldOptions.access$20000((DescriptorProtos$FieldOptions)messageLite);
                    object.addAll(list);
                }
                this.onChanged();
            }
        } else {
            object = DescriptorProtos$FieldOptions.access$20000((DescriptorProtos$FieldOptions)messageLite);
            boolean bl13 = object.isEmpty();
            if (!bl13) {
                object = this.uninterpretedOptionBuilder_;
                boolean bl14 = ((RepeatedFieldBuilderV3)object).isEmpty();
                if (bl14) {
                    int n12;
                    List list;
                    this.uninterpretedOptionBuilder_.dispose();
                    boolean bl15 = false;
                    object = null;
                    this.uninterpretedOptionBuilder_ = null;
                    this.uninterpretedOption_ = list = DescriptorProtos$FieldOptions.access$20000((DescriptorProtos$FieldOptions)messageLite);
                    this.bitField0_ = n12 = this.bitField0_ & 0xFFFFFFBF;
                    n12 = (int)(GeneratedMessageV3.alwaysUseFieldBuilders ? 1 : 0);
                    if (n12 != 0) {
                        object = this.getUninterpretedOptionFieldBuilder();
                    }
                    this.uninterpretedOptionBuilder_ = object;
                } else {
                    object = this.uninterpretedOptionBuilder_;
                    List list = DescriptorProtos$FieldOptions.access$20000((DescriptorProtos$FieldOptions)messageLite);
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

    public DescriptorProtos$FieldOptions$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof DescriptorProtos$FieldOptions;
        if (bl2) {
            message = (DescriptorProtos$FieldOptions)message;
            return this.mergeFrom((DescriptorProtos$FieldOptions)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final DescriptorProtos$FieldOptions$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$FieldOptions$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public DescriptorProtos$FieldOptions$Builder removeUninterpretedOption(int n10) {
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

    public DescriptorProtos$FieldOptions$Builder setCtype(DescriptorProtos$FieldOptions$CType descriptorProtos$FieldOptions$CType) {
        int n10;
        int n11;
        Objects.requireNonNull(descriptorProtos$FieldOptions$CType);
        this.bitField0_ = n11 = this.bitField0_ | 1;
        this.ctype_ = n10 = descriptorProtos$FieldOptions$CType.getNumber();
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldOptions$Builder setDeprecated(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x10;
        this.deprecated_ = bl2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldOptions$Builder setExtension(GeneratedMessage$GeneratedExtension generatedMessage$GeneratedExtension, int n10, Object object) {
        return (DescriptorProtos$FieldOptions$Builder)super.setExtension(generatedMessage$GeneratedExtension, n10, object);
    }

    public DescriptorProtos$FieldOptions$Builder setExtension(GeneratedMessage$GeneratedExtension generatedMessage$GeneratedExtension, Object object) {
        return (DescriptorProtos$FieldOptions$Builder)super.setExtension(generatedMessage$GeneratedExtension, object);
    }

    public DescriptorProtos$FieldOptions$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$FieldOptions$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$FieldOptions$Builder setJstype(DescriptorProtos$FieldOptions$JSType descriptorProtos$FieldOptions$JSType) {
        int n10;
        int n11;
        Objects.requireNonNull(descriptorProtos$FieldOptions$JSType);
        this.bitField0_ = n11 = this.bitField0_ | 4;
        this.jstype_ = n10 = descriptorProtos$FieldOptions$JSType.getNumber();
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldOptions$Builder setLazy(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 8;
        this.lazy_ = bl2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldOptions$Builder setPacked(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.packed_ = bl2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldOptions$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (DescriptorProtos$FieldOptions$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public DescriptorProtos$FieldOptions$Builder setUninterpretedOption(int n10, DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOptionOrBuilder) {
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

    public DescriptorProtos$FieldOptions$Builder setUninterpretedOption(int n10, DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
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

    public final DescriptorProtos$FieldOptions$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$FieldOptions$Builder)super.setUnknownFields(unknownFieldSet);
    }

    public DescriptorProtos$FieldOptions$Builder setWeak(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x20;
        this.weak_ = bl2;
        this.onChanged();
        return this;
    }
}

