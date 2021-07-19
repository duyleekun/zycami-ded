/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$UninterpretedOption;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePart;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePart$Builder;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePartOrBuilder;
import com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
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

public final class DescriptorProtos$UninterpretedOption$Builder
extends GeneratedMessageV3$Builder
implements DescriptorProtos$UninterpretedOptionOrBuilder {
    private Object aggregateValue_;
    private int bitField0_;
    private double doubleValue_;
    private Object identifierValue_;
    private RepeatedFieldBuilderV3 nameBuilder_;
    private List name_;
    private long negativeIntValue_;
    private long positiveIntValue_;
    private ByteString stringValue_;

    private DescriptorProtos$UninterpretedOption$Builder() {
        ByteString byteString;
        Object object = Collections.emptyList();
        this.name_ = object;
        this.identifierValue_ = object = "";
        this.stringValue_ = byteString = ByteString.EMPTY;
        this.aggregateValue_ = object;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$UninterpretedOption$Builder(DescriptorProtos$1 descriptorProtos$1) {
        this();
    }

    private DescriptorProtos$UninterpretedOption$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        ByteString byteString;
        this.name_ = object = Collections.emptyList();
        this.identifierValue_ = object = "";
        this.stringValue_ = byteString = ByteString.EMPTY;
        this.aggregateValue_ = object;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$UninterpretedOption$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$BuilderParent);
    }

    private void ensureNameIsMutable() {
        int n10 = this.bitField0_ & 1;
        if (n10 == 0) {
            ArrayList arrayList;
            List list = this.name_;
            this.name_ = arrayList = new ArrayList(list);
            this.bitField0_ = n10 = this.bitField0_ | 1;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$24800();
    }

    private RepeatedFieldBuilderV3 getNameFieldBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.nameBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            List list = this.name_;
            int n10 = this.bitField0_;
            int n11 = 1;
            if ((n10 &= n11) == 0) {
                n11 = 0;
            }
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.nameBuilder_ = repeatedFieldBuilderV3 = new RepeatedFieldBuilderV3(list, n11 != 0, generatedMessageV3$BuilderParent, bl2);
            repeatedFieldBuilderV3 = null;
            this.name_ = null;
        }
        return this.nameBuilder_;
    }

    private void maybeForceBuilderInitialization() {
        boolean bl2 = GeneratedMessageV3.alwaysUseFieldBuilders;
        if (bl2) {
            this.getNameFieldBuilder();
        }
    }

    public DescriptorProtos$UninterpretedOption$Builder addAllName(Iterable iterable) {
        Object object = this.nameBuilder_;
        if (object == null) {
            this.ensureNameIsMutable();
            object = this.name_;
            AbstractMessageLite$Builder.addAll(iterable, (List)object);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addAllMessages(iterable);
        }
        return this;
    }

    public DescriptorProtos$UninterpretedOption$Builder addName(int n10, DescriptorProtos$UninterpretedOption$NamePart$Builder descriptorProtos$UninterpretedOption$NamePartOrBuilder) {
        Object object = this.nameBuilder_;
        if (object == null) {
            this.ensureNameIsMutable();
            object = this.name_;
            descriptorProtos$UninterpretedOption$NamePartOrBuilder = ((DescriptorProtos$UninterpretedOption$NamePart$Builder)descriptorProtos$UninterpretedOption$NamePartOrBuilder).build();
            object.add(n10, descriptorProtos$UninterpretedOption$NamePartOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$UninterpretedOption$NamePartOrBuilder = ((DescriptorProtos$UninterpretedOption$NamePart$Builder)descriptorProtos$UninterpretedOption$NamePartOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage(n10, (AbstractMessage)((Object)descriptorProtos$UninterpretedOption$NamePartOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$UninterpretedOption$Builder addName(int n10, DescriptorProtos$UninterpretedOption$NamePart descriptorProtos$UninterpretedOption$NamePart) {
        Object object = this.nameBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$UninterpretedOption$NamePart);
            this.ensureNameIsMutable();
            object = this.name_;
            object.add(n10, descriptorProtos$UninterpretedOption$NamePart);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(n10, descriptorProtos$UninterpretedOption$NamePart);
        }
        return this;
    }

    public DescriptorProtos$UninterpretedOption$Builder addName(DescriptorProtos$UninterpretedOption$NamePart$Builder descriptorProtos$UninterpretedOption$NamePartOrBuilder) {
        Object object = this.nameBuilder_;
        if (object == null) {
            this.ensureNameIsMutable();
            object = this.name_;
            descriptorProtos$UninterpretedOption$NamePartOrBuilder = ((DescriptorProtos$UninterpretedOption$NamePart$Builder)descriptorProtos$UninterpretedOption$NamePartOrBuilder).build();
            object.add(descriptorProtos$UninterpretedOption$NamePartOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$UninterpretedOption$NamePartOrBuilder = ((DescriptorProtos$UninterpretedOption$NamePart$Builder)descriptorProtos$UninterpretedOption$NamePartOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage((AbstractMessage)((Object)descriptorProtos$UninterpretedOption$NamePartOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$UninterpretedOption$Builder addName(DescriptorProtos$UninterpretedOption$NamePart descriptorProtos$UninterpretedOption$NamePart) {
        Object object = this.nameBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$UninterpretedOption$NamePart);
            this.ensureNameIsMutable();
            object = this.name_;
            object.add(descriptorProtos$UninterpretedOption$NamePart);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(descriptorProtos$UninterpretedOption$NamePart);
        }
        return this;
    }

    public DescriptorProtos$UninterpretedOption$NamePart$Builder addNameBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getNameFieldBuilder();
        DescriptorProtos$UninterpretedOption$NamePart descriptorProtos$UninterpretedOption$NamePart = DescriptorProtos$UninterpretedOption$NamePart.getDefaultInstance();
        return (DescriptorProtos$UninterpretedOption$NamePart$Builder)repeatedFieldBuilderV3.addBuilder(descriptorProtos$UninterpretedOption$NamePart);
    }

    public DescriptorProtos$UninterpretedOption$NamePart$Builder addNameBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getNameFieldBuilder();
        DescriptorProtos$UninterpretedOption$NamePart descriptorProtos$UninterpretedOption$NamePart = DescriptorProtos$UninterpretedOption$NamePart.getDefaultInstance();
        return (DescriptorProtos$UninterpretedOption$NamePart$Builder)repeatedFieldBuilderV3.addBuilder(n10, descriptorProtos$UninterpretedOption$NamePart);
    }

    public DescriptorProtos$UninterpretedOption$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$UninterpretedOption$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$UninterpretedOption build() {
        DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption = this.buildPartial();
        boolean bl2 = descriptorProtos$UninterpretedOption.isInitialized();
        if (bl2) {
            return descriptorProtos$UninterpretedOption;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(descriptorProtos$UninterpretedOption);
    }

    public DescriptorProtos$UninterpretedOption buildPartial() {
        long l10;
        int n10;
        Object object = null;
        DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption = new DescriptorProtos$UninterpretedOption(this, null);
        int n11 = this.bitField0_;
        Object object2 = this.nameBuilder_;
        if (object2 == null) {
            n10 = n11 & 1;
            if (n10 != 0) {
                this.name_ = object2 = Collections.unmodifiableList(this.name_);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
            }
            object2 = this.name_;
            DescriptorProtos$UninterpretedOption.access$26202(descriptorProtos$UninterpretedOption, object2);
        } else {
            object2 = ((RepeatedFieldBuilderV3)object2).build();
            DescriptorProtos$UninterpretedOption.access$26202(descriptorProtos$UninterpretedOption, (List)object2);
        }
        n10 = n11 & 2;
        if (n10 != 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object2 = null;
        }
        Object object3 = this.identifierValue_;
        DescriptorProtos$UninterpretedOption.access$26302(descriptorProtos$UninterpretedOption, object3);
        int n12 = n11 & 4;
        if (n12 != 0) {
            l10 = this.positiveIntValue_;
            DescriptorProtos$UninterpretedOption.access$26402(descriptorProtos$UninterpretedOption, l10);
            n10 |= 2;
        }
        if ((n12 = n11 & 8) != 0) {
            l10 = this.negativeIntValue_;
            DescriptorProtos$UninterpretedOption.access$26502(descriptorProtos$UninterpretedOption, l10);
            n10 |= 4;
        }
        if ((n12 = n11 & 0x10) != 0) {
            double d10 = this.doubleValue_;
            DescriptorProtos$UninterpretedOption.access$26602(descriptorProtos$UninterpretedOption, d10);
            n10 |= 8;
        }
        if ((n12 = n11 & 0x20) != 0) {
            n10 |= 0x10;
        }
        object3 = this.stringValue_;
        DescriptorProtos$UninterpretedOption.access$26702(descriptorProtos$UninterpretedOption, (ByteString)object3);
        if ((n11 &= 0x40) != 0) {
            n10 |= 0x20;
        }
        object = this.aggregateValue_;
        DescriptorProtos$UninterpretedOption.access$26802(descriptorProtos$UninterpretedOption, object);
        DescriptorProtos$UninterpretedOption.access$26902(descriptorProtos$UninterpretedOption, n10);
        this.onBuilt();
        return descriptorProtos$UninterpretedOption;
    }

    public DescriptorProtos$UninterpretedOption$Builder clear() {
        ByteString byteString;
        long l10;
        int n10;
        int n11;
        super.clear();
        Object object = this.nameBuilder_;
        if (object == null) {
            this.name_ = object = Collections.emptyList();
            this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        this.identifierValue_ = object = "";
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        this.positiveIntValue_ = l10 = 0L;
        this.bitField0_ = n10 &= 0xFFFFFFFB;
        this.negativeIntValue_ = l10;
        this.bitField0_ = n10 &= 0xFFFFFFF7;
        this.doubleValue_ = 0.0;
        this.bitField0_ = n10 &= 0xFFFFFFEF;
        this.stringValue_ = byteString = ByteString.EMPTY;
        this.bitField0_ = n10 &= 0xFFFFFFDF;
        this.aggregateValue_ = object;
        this.bitField0_ = n11 = n10 & 0xFFFFFFBF;
        return this;
    }

    public DescriptorProtos$UninterpretedOption$Builder clearAggregateValue() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFBF;
        String string2 = DescriptorProtos$UninterpretedOption.getDefaultInstance().getAggregateValue();
        this.aggregateValue_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$UninterpretedOption$Builder clearDoubleValue() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFEF;
        this.doubleValue_ = 0.0;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$UninterpretedOption$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (DescriptorProtos$UninterpretedOption$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public DescriptorProtos$UninterpretedOption$Builder clearIdentifierValue() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        String string2 = DescriptorProtos$UninterpretedOption.getDefaultInstance().getIdentifierValue();
        this.identifierValue_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$UninterpretedOption$Builder clearName() {
        Object object = this.nameBuilder_;
        if (object == null) {
            int n10;
            this.name_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public DescriptorProtos$UninterpretedOption$Builder clearNegativeIntValue() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
        this.negativeIntValue_ = 0L;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$UninterpretedOption$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (DescriptorProtos$UninterpretedOption$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public DescriptorProtos$UninterpretedOption$Builder clearPositiveIntValue() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        this.positiveIntValue_ = 0L;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$UninterpretedOption$Builder clearStringValue() {
        ByteString byteString;
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFDF;
        this.stringValue_ = byteString = DescriptorProtos$UninterpretedOption.getDefaultInstance().getStringValue();
        this.onChanged();
        return this;
    }

    public DescriptorProtos$UninterpretedOption$Builder clone() {
        return (DescriptorProtos$UninterpretedOption$Builder)super.clone();
    }

    public String getAggregateValue() {
        Object object = this.aggregateValue_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.aggregateValue_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getAggregateValueBytes() {
        Object object = this.aggregateValue_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.aggregateValue_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public DescriptorProtos$UninterpretedOption getDefaultInstanceForType() {
        return DescriptorProtos$UninterpretedOption.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.access$24800();
    }

    public double getDoubleValue() {
        return this.doubleValue_;
    }

    public String getIdentifierValue() {
        Object object = this.identifierValue_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.identifierValue_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getIdentifierValueBytes() {
        Object object = this.identifierValue_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.identifierValue_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public DescriptorProtos$UninterpretedOption$NamePart getName(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.nameBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (DescriptorProtos$UninterpretedOption$NamePart)this.name_.get(n10);
        }
        return (DescriptorProtos$UninterpretedOption$NamePart)repeatedFieldBuilderV3.getMessage(n10);
    }

    public DescriptorProtos$UninterpretedOption$NamePart$Builder getNameBuilder(int n10) {
        return (DescriptorProtos$UninterpretedOption$NamePart$Builder)this.getNameFieldBuilder().getBuilder(n10);
    }

    public List getNameBuilderList() {
        return this.getNameFieldBuilder().getBuilderList();
    }

    public int getNameCount() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.nameBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return this.name_.size();
        }
        return repeatedFieldBuilderV3.getCount();
    }

    public List getNameList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.nameBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return Collections.unmodifiableList(this.name_);
        }
        return repeatedFieldBuilderV3.getMessageList();
    }

    public DescriptorProtos$UninterpretedOption$NamePartOrBuilder getNameOrBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.nameBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (DescriptorProtos$UninterpretedOption$NamePartOrBuilder)this.name_.get(n10);
        }
        return (DescriptorProtos$UninterpretedOption$NamePartOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(n10);
    }

    public List getNameOrBuilderList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.nameBuilder_;
        if (repeatedFieldBuilderV3 != null) {
            return repeatedFieldBuilderV3.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(this.name_);
    }

    public long getNegativeIntValue() {
        return this.negativeIntValue_;
    }

    public long getPositiveIntValue() {
        return this.positiveIntValue_;
    }

    public ByteString getStringValue() {
        return this.stringValue_;
    }

    public boolean hasAggregateValue() {
        int n10 = this.bitField0_ & 0x40;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasDoubleValue() {
        int n10 = this.bitField0_ & 0x10;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasIdentifierValue() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasNegativeIntValue() {
        int n10 = this.bitField0_ & 8;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasPositiveIntValue() {
        int n10 = this.bitField0_ & 4;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasStringValue() {
        int n10 = this.bitField0_ & 0x20;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$24900().ensureFieldAccessorsInitialized(DescriptorProtos$UninterpretedOption.class, DescriptorProtos$UninterpretedOption$Builder.class);
    }

    public final boolean isInitialized() {
        int n10;
        for (int i10 = 0; i10 < (n10 = this.getNameCount()); ++i10) {
            DescriptorProtos$UninterpretedOption$NamePart descriptorProtos$UninterpretedOption$NamePart = this.getName(i10);
            n10 = (int)(descriptorProtos$UninterpretedOption$NamePart.isInitialized() ? 1 : 0);
            if (n10 != 0) continue;
            return false;
        }
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
    public DescriptorProtos$UninterpretedOption$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = DescriptorProtos$UninterpretedOption.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (DescriptorProtos$UninterpretedOption)object;
            if (object == null) break block7;
            this.mergeFrom((DescriptorProtos$UninterpretedOption)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (DescriptorProtos$UninterpretedOption)object2;
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
            this.mergeFrom((DescriptorProtos$UninterpretedOption)object3);
        }
        throw var1_6;
    }

    public DescriptorProtos$UninterpretedOption$Builder mergeFrom(DescriptorProtos$UninterpretedOption messageLite) {
        boolean bl2;
        boolean bl3;
        boolean bl4;
        boolean bl5;
        long l10;
        boolean bl6;
        boolean bl7;
        Object object = DescriptorProtos$UninterpretedOption.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        object = this.nameBuilder_;
        if (object == null) {
            object = DescriptorProtos$UninterpretedOption.access$26200((DescriptorProtos$UninterpretedOption)messageLite);
            boolean n10 = object.isEmpty();
            if (!n10) {
                object = this.name_;
                boolean bl8 = object.isEmpty();
                if (bl8) {
                    int n11;
                    this.name_ = object = DescriptorProtos$UninterpretedOption.access$26200((DescriptorProtos$UninterpretedOption)messageLite);
                    this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
                } else {
                    this.ensureNameIsMutable();
                    object = this.name_;
                    List list = DescriptorProtos$UninterpretedOption.access$26200((DescriptorProtos$UninterpretedOption)messageLite);
                    object.addAll(list);
                }
                this.onChanged();
            }
        } else {
            object = DescriptorProtos$UninterpretedOption.access$26200((DescriptorProtos$UninterpretedOption)messageLite);
            boolean bl9 = object.isEmpty();
            if (!bl9) {
                object = this.nameBuilder_;
                boolean bl10 = ((RepeatedFieldBuilderV3)object).isEmpty();
                if (bl10) {
                    int n12;
                    List list;
                    this.nameBuilder_.dispose();
                    boolean bl11 = false;
                    object = null;
                    this.nameBuilder_ = null;
                    this.name_ = list = DescriptorProtos$UninterpretedOption.access$26200((DescriptorProtos$UninterpretedOption)messageLite);
                    this.bitField0_ = n12 = this.bitField0_ & 0xFFFFFFFE;
                    n12 = (int)(GeneratedMessageV3.alwaysUseFieldBuilders ? 1 : 0);
                    if (n12 != 0) {
                        object = this.getNameFieldBuilder();
                    }
                    this.nameBuilder_ = object;
                } else {
                    object = this.nameBuilder_;
                    List list = DescriptorProtos$UninterpretedOption.access$26200((DescriptorProtos$UninterpretedOption)messageLite);
                    ((RepeatedFieldBuilderV3)object).addAllMessages(list);
                }
            }
        }
        if (bl7 = ((DescriptorProtos$UninterpretedOption)messageLite).hasIdentifierValue()) {
            int n13;
            this.bitField0_ = n13 = this.bitField0_ | 2;
            this.identifierValue_ = object = DescriptorProtos$UninterpretedOption.access$26300((DescriptorProtos$UninterpretedOption)messageLite);
            this.onChanged();
        }
        if (bl6 = ((DescriptorProtos$UninterpretedOption)messageLite).hasPositiveIntValue()) {
            l10 = ((DescriptorProtos$UninterpretedOption)messageLite).getPositiveIntValue();
            this.setPositiveIntValue(l10);
        }
        if (bl5 = ((DescriptorProtos$UninterpretedOption)messageLite).hasNegativeIntValue()) {
            l10 = ((DescriptorProtos$UninterpretedOption)messageLite).getNegativeIntValue();
            this.setNegativeIntValue(l10);
        }
        if (bl4 = ((DescriptorProtos$UninterpretedOption)messageLite).hasDoubleValue()) {
            double d10 = ((DescriptorProtos$UninterpretedOption)messageLite).getDoubleValue();
            this.setDoubleValue(d10);
        }
        if (bl3 = ((DescriptorProtos$UninterpretedOption)messageLite).hasStringValue()) {
            object = ((DescriptorProtos$UninterpretedOption)messageLite).getStringValue();
            this.setStringValue((ByteString)object);
        }
        if (bl2 = ((DescriptorProtos$UninterpretedOption)messageLite).hasAggregateValue()) {
            int n14;
            this.bitField0_ = n14 = this.bitField0_ | 0x40;
            this.aggregateValue_ = object = DescriptorProtos$UninterpretedOption.access$26800((DescriptorProtos$UninterpretedOption)messageLite);
            this.onChanged();
        }
        messageLite = ((GeneratedMessageV3)messageLite).unknownFields;
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$UninterpretedOption$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof DescriptorProtos$UninterpretedOption;
        if (bl2) {
            message = (DescriptorProtos$UninterpretedOption)message;
            return this.mergeFrom((DescriptorProtos$UninterpretedOption)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final DescriptorProtos$UninterpretedOption$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$UninterpretedOption$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public DescriptorProtos$UninterpretedOption$Builder removeName(int n10) {
        Object object = this.nameBuilder_;
        if (object == null) {
            this.ensureNameIsMutable();
            object = this.name_;
            object.remove(n10);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).remove(n10);
        }
        return this;
    }

    public DescriptorProtos$UninterpretedOption$Builder setAggregateValue(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x40;
        this.aggregateValue_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$UninterpretedOption$Builder setAggregateValueBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x40;
        this.aggregateValue_ = byteString;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$UninterpretedOption$Builder setDoubleValue(double d10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x10;
        this.doubleValue_ = d10;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$UninterpretedOption$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$UninterpretedOption$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$UninterpretedOption$Builder setIdentifierValue(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.identifierValue_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$UninterpretedOption$Builder setIdentifierValueBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.identifierValue_ = byteString;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$UninterpretedOption$Builder setName(int n10, DescriptorProtos$UninterpretedOption$NamePart$Builder descriptorProtos$UninterpretedOption$NamePartOrBuilder) {
        Object object = this.nameBuilder_;
        if (object == null) {
            this.ensureNameIsMutable();
            object = this.name_;
            descriptorProtos$UninterpretedOption$NamePartOrBuilder = ((DescriptorProtos$UninterpretedOption$NamePart$Builder)descriptorProtos$UninterpretedOption$NamePartOrBuilder).build();
            object.set(n10, descriptorProtos$UninterpretedOption$NamePartOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$UninterpretedOption$NamePartOrBuilder = ((DescriptorProtos$UninterpretedOption$NamePart$Builder)descriptorProtos$UninterpretedOption$NamePartOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).setMessage(n10, (AbstractMessage)((Object)descriptorProtos$UninterpretedOption$NamePartOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$UninterpretedOption$Builder setName(int n10, DescriptorProtos$UninterpretedOption$NamePart descriptorProtos$UninterpretedOption$NamePart) {
        Object object = this.nameBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$UninterpretedOption$NamePart);
            this.ensureNameIsMutable();
            object = this.name_;
            object.set(n10, descriptorProtos$UninterpretedOption$NamePart);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).setMessage(n10, descriptorProtos$UninterpretedOption$NamePart);
        }
        return this;
    }

    public DescriptorProtos$UninterpretedOption$Builder setNegativeIntValue(long l10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 8;
        this.negativeIntValue_ = l10;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$UninterpretedOption$Builder setPositiveIntValue(long l10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.positiveIntValue_ = l10;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$UninterpretedOption$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (DescriptorProtos$UninterpretedOption$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public DescriptorProtos$UninterpretedOption$Builder setStringValue(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x20;
        this.stringValue_ = byteString;
        this.onChanged();
        return this;
    }

    public final DescriptorProtos$UninterpretedOption$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$UninterpretedOption$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

