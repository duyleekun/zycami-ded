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
import com.google.protobuf.DescriptorProtos$MethodOptions;
import com.google.protobuf.DescriptorProtos$MethodOptions$IdempotencyLevel;
import com.google.protobuf.DescriptorProtos$MethodOptionsOrBuilder;
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

public final class DescriptorProtos$MethodOptions$Builder
extends GeneratedMessageV3$ExtendableBuilder
implements DescriptorProtos$MethodOptionsOrBuilder {
    private int bitField0_;
    private boolean deprecated_;
    private int idempotencyLevel_ = 0;
    private RepeatedFieldBuilderV3 uninterpretedOptionBuilder_;
    private List uninterpretedOption_;

    private DescriptorProtos$MethodOptions$Builder() {
        List list;
        this.uninterpretedOption_ = list = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$MethodOptions$Builder(DescriptorProtos$1 descriptorProtos$1) {
        this();
    }

    private DescriptorProtos$MethodOptions$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        this.uninterpretedOption_ = object = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$MethodOptions$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, DescriptorProtos$1 descriptorProtos$1) {
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
        return DescriptorProtos.access$23800();
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

    public DescriptorProtos$MethodOptions$Builder addAllUninterpretedOption(Iterable iterable) {
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

    public DescriptorProtos$MethodOptions$Builder addExtension(GeneratedMessage$GeneratedExtension generatedMessage$GeneratedExtension, Object object) {
        return (DescriptorProtos$MethodOptions$Builder)super.addExtension(generatedMessage$GeneratedExtension, object);
    }

    public DescriptorProtos$MethodOptions$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$MethodOptions$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$MethodOptions$Builder addUninterpretedOption(int n10, DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOptionOrBuilder) {
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

    public DescriptorProtos$MethodOptions$Builder addUninterpretedOption(int n10, DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
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

    public DescriptorProtos$MethodOptions$Builder addUninterpretedOption(DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOptionOrBuilder) {
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

    public DescriptorProtos$MethodOptions$Builder addUninterpretedOption(DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
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

    public DescriptorProtos$MethodOptions build() {
        DescriptorProtos$MethodOptions descriptorProtos$MethodOptions = this.buildPartial();
        boolean bl2 = descriptorProtos$MethodOptions.isInitialized();
        if (bl2) {
            return descriptorProtos$MethodOptions;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(descriptorProtos$MethodOptions);
    }

    public DescriptorProtos$MethodOptions buildPartial() {
        List list = null;
        DescriptorProtos$MethodOptions descriptorProtos$MethodOptions = new DescriptorProtos$MethodOptions(this, null);
        int n10 = this.bitField0_;
        int n11 = n10 & 1;
        if (n11 != 0) {
            n11 = (int)(this.deprecated_ ? 1 : 0);
            DescriptorProtos$MethodOptions.access$24302(descriptorProtos$MethodOptions, n11 != 0);
            n11 = 1;
        } else {
            n11 = 0;
        }
        if ((n10 &= 2) != 0) {
            n11 |= 2;
        }
        n10 = this.idempotencyLevel_;
        DescriptorProtos$MethodOptions.access$24402(descriptorProtos$MethodOptions, n10);
        list = this.uninterpretedOptionBuilder_;
        if (list == null) {
            n10 = this.bitField0_ & 4;
            if (n10 != 0) {
                this.uninterpretedOption_ = list = Collections.unmodifiableList(this.uninterpretedOption_);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
            }
            list = this.uninterpretedOption_;
            DescriptorProtos$MethodOptions.access$24502(descriptorProtos$MethodOptions, list);
        } else {
            list = ((RepeatedFieldBuilderV3)((Object)list)).build();
            DescriptorProtos$MethodOptions.access$24502(descriptorProtos$MethodOptions, list);
        }
        DescriptorProtos$MethodOptions.access$24602(descriptorProtos$MethodOptions, n11);
        this.onBuilt();
        return descriptorProtos$MethodOptions;
    }

    public DescriptorProtos$MethodOptions$Builder clear() {
        int n10;
        int n11;
        super.clear();
        this.deprecated_ = false;
        this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
        this.idempotencyLevel_ = 0;
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

    public DescriptorProtos$MethodOptions$Builder clearDeprecated() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.deprecated_ = false;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$MethodOptions$Builder clearExtension(GeneratedMessage$GeneratedExtension generatedMessage$GeneratedExtension) {
        return (DescriptorProtos$MethodOptions$Builder)super.clearExtension(generatedMessage$GeneratedExtension);
    }

    public DescriptorProtos$MethodOptions$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (DescriptorProtos$MethodOptions$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public DescriptorProtos$MethodOptions$Builder clearIdempotencyLevel() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        this.idempotencyLevel_ = 0;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$MethodOptions$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (DescriptorProtos$MethodOptions$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public DescriptorProtos$MethodOptions$Builder clearUninterpretedOption() {
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

    public DescriptorProtos$MethodOptions$Builder clone() {
        return (DescriptorProtos$MethodOptions$Builder)super.clone();
    }

    public DescriptorProtos$MethodOptions getDefaultInstanceForType() {
        return DescriptorProtos$MethodOptions.getDefaultInstance();
    }

    public boolean getDeprecated() {
        return this.deprecated_;
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.access$23800();
    }

    public DescriptorProtos$MethodOptions$IdempotencyLevel getIdempotencyLevel() {
        int n10 = this.idempotencyLevel_;
        DescriptorProtos$MethodOptions$IdempotencyLevel descriptorProtos$MethodOptions$IdempotencyLevel = DescriptorProtos$MethodOptions$IdempotencyLevel.valueOf(n10);
        if (descriptorProtos$MethodOptions$IdempotencyLevel == null) {
            descriptorProtos$MethodOptions$IdempotencyLevel = DescriptorProtos$MethodOptions$IdempotencyLevel.IDEMPOTENCY_UNKNOWN;
        }
        return descriptorProtos$MethodOptions$IdempotencyLevel;
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

    public boolean hasIdempotencyLevel() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$23900().ensureFieldAccessorsInitialized(DescriptorProtos$MethodOptions.class, DescriptorProtos$MethodOptions$Builder.class);
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
    public DescriptorProtos$MethodOptions$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = DescriptorProtos$MethodOptions.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (DescriptorProtos$MethodOptions)object;
            if (object == null) break block7;
            this.mergeFrom((DescriptorProtos$MethodOptions)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (DescriptorProtos$MethodOptions)object2;
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
            this.mergeFrom((DescriptorProtos$MethodOptions)object3);
        }
        throw var1_6;
    }

    public DescriptorProtos$MethodOptions$Builder mergeFrom(DescriptorProtos$MethodOptions messageLite) {
        boolean bl2;
        Object object = DescriptorProtos$MethodOptions.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        boolean n10 = ((DescriptorProtos$MethodOptions)messageLite).hasDeprecated();
        if (n10) {
            boolean bl3 = ((DescriptorProtos$MethodOptions)messageLite).getDeprecated();
            this.setDeprecated(bl3);
        }
        if (bl2 = ((DescriptorProtos$MethodOptions)messageLite).hasIdempotencyLevel()) {
            object = ((DescriptorProtos$MethodOptions)messageLite).getIdempotencyLevel();
            this.setIdempotencyLevel((DescriptorProtos$MethodOptions$IdempotencyLevel)object);
        }
        if ((object = this.uninterpretedOptionBuilder_) == null) {
            object = DescriptorProtos$MethodOptions.access$24500((DescriptorProtos$MethodOptions)messageLite);
            boolean bl4 = object.isEmpty();
            if (!bl4) {
                object = this.uninterpretedOption_;
                boolean bl5 = object.isEmpty();
                if (bl5) {
                    int n11;
                    this.uninterpretedOption_ = object = DescriptorProtos$MethodOptions.access$24500((DescriptorProtos$MethodOptions)messageLite);
                    this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFB;
                } else {
                    this.ensureUninterpretedOptionIsMutable();
                    object = this.uninterpretedOption_;
                    List list = DescriptorProtos$MethodOptions.access$24500((DescriptorProtos$MethodOptions)messageLite);
                    object.addAll(list);
                }
                this.onChanged();
            }
        } else {
            object = DescriptorProtos$MethodOptions.access$24500((DescriptorProtos$MethodOptions)messageLite);
            boolean bl6 = object.isEmpty();
            if (!bl6) {
                object = this.uninterpretedOptionBuilder_;
                boolean bl7 = ((RepeatedFieldBuilderV3)object).isEmpty();
                if (bl7) {
                    int n12;
                    List list;
                    this.uninterpretedOptionBuilder_.dispose();
                    boolean bl8 = false;
                    object = null;
                    this.uninterpretedOptionBuilder_ = null;
                    this.uninterpretedOption_ = list = DescriptorProtos$MethodOptions.access$24500((DescriptorProtos$MethodOptions)messageLite);
                    this.bitField0_ = n12 = this.bitField0_ & 0xFFFFFFFB;
                    n12 = (int)(GeneratedMessageV3.alwaysUseFieldBuilders ? 1 : 0);
                    if (n12 != 0) {
                        object = this.getUninterpretedOptionFieldBuilder();
                    }
                    this.uninterpretedOptionBuilder_ = object;
                } else {
                    object = this.uninterpretedOptionBuilder_;
                    List list = DescriptorProtos$MethodOptions.access$24500((DescriptorProtos$MethodOptions)messageLite);
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

    public DescriptorProtos$MethodOptions$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof DescriptorProtos$MethodOptions;
        if (bl2) {
            message = (DescriptorProtos$MethodOptions)message;
            return this.mergeFrom((DescriptorProtos$MethodOptions)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final DescriptorProtos$MethodOptions$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$MethodOptions$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public DescriptorProtos$MethodOptions$Builder removeUninterpretedOption(int n10) {
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

    public DescriptorProtos$MethodOptions$Builder setDeprecated(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.deprecated_ = bl2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$MethodOptions$Builder setExtension(GeneratedMessage$GeneratedExtension generatedMessage$GeneratedExtension, int n10, Object object) {
        return (DescriptorProtos$MethodOptions$Builder)super.setExtension(generatedMessage$GeneratedExtension, n10, object);
    }

    public DescriptorProtos$MethodOptions$Builder setExtension(GeneratedMessage$GeneratedExtension generatedMessage$GeneratedExtension, Object object) {
        return (DescriptorProtos$MethodOptions$Builder)super.setExtension(generatedMessage$GeneratedExtension, object);
    }

    public DescriptorProtos$MethodOptions$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$MethodOptions$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$MethodOptions$Builder setIdempotencyLevel(DescriptorProtos$MethodOptions$IdempotencyLevel descriptorProtos$MethodOptions$IdempotencyLevel) {
        int n10;
        int n11;
        Objects.requireNonNull(descriptorProtos$MethodOptions$IdempotencyLevel);
        this.bitField0_ = n11 = this.bitField0_ | 2;
        this.idempotencyLevel_ = n10 = descriptorProtos$MethodOptions$IdempotencyLevel.getNumber();
        this.onChanged();
        return this;
    }

    public DescriptorProtos$MethodOptions$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (DescriptorProtos$MethodOptions$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public DescriptorProtos$MethodOptions$Builder setUninterpretedOption(int n10, DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOptionOrBuilder) {
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

    public DescriptorProtos$MethodOptions$Builder setUninterpretedOption(int n10, DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
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

    public final DescriptorProtos$MethodOptions$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$MethodOptions$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

