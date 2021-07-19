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
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto$EnumReservedRange;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$EnumOptions;
import com.google.protobuf.DescriptorProtos$EnumOptions$Builder;
import com.google.protobuf.DescriptorProtos$EnumOptionsOrBuilder;
import com.google.protobuf.DescriptorProtos$EnumValueDescriptorProto;
import com.google.protobuf.DescriptorProtos$EnumValueDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$EnumValueDescriptorProtoOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class DescriptorProtos$EnumDescriptorProto$Builder
extends GeneratedMessageV3$Builder
implements DescriptorProtos$EnumDescriptorProtoOrBuilder {
    private int bitField0_;
    private Object name_ = "";
    private SingleFieldBuilderV3 optionsBuilder_;
    private DescriptorProtos$EnumOptions options_;
    private LazyStringList reservedName_;
    private RepeatedFieldBuilderV3 reservedRangeBuilder_;
    private List reservedRange_;
    private RepeatedFieldBuilderV3 valueBuilder_;
    private List value_;

    private DescriptorProtos$EnumDescriptorProto$Builder() {
        LazyStringList lazyStringList;
        this.value_ = lazyStringList = Collections.emptyList();
        this.reservedRange_ = lazyStringList = Collections.emptyList();
        this.reservedName_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$EnumDescriptorProto$Builder(DescriptorProtos$1 descriptorProtos$1) {
        this();
    }

    private DescriptorProtos$EnumDescriptorProto$Builder(GeneratedMessageV3$BuilderParent lazyStringList) {
        super((GeneratedMessageV3$BuilderParent)((Object)lazyStringList));
        lazyStringList = Collections.emptyList();
        this.value_ = lazyStringList;
        this.reservedRange_ = lazyStringList = Collections.emptyList();
        this.reservedName_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$EnumDescriptorProto$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$BuilderParent);
    }

    private void ensureReservedNameIsMutable() {
        int n10 = this.bitField0_ & 0x10;
        if (n10 == 0) {
            LazyStringList lazyStringList = this.reservedName_;
            LazyStringArrayList lazyStringArrayList = new LazyStringArrayList(lazyStringList);
            this.reservedName_ = lazyStringArrayList;
            this.bitField0_ = n10 = this.bitField0_ | 0x10;
        }
    }

    private void ensureReservedRangeIsMutable() {
        int n10 = this.bitField0_ & 8;
        if (n10 == 0) {
            ArrayList arrayList;
            List list = this.reservedRange_;
            this.reservedRange_ = arrayList = new ArrayList(list);
            this.bitField0_ = n10 = this.bitField0_ | 8;
        }
    }

    private void ensureValueIsMutable() {
        int n10 = this.bitField0_ & 2;
        if (n10 == 0) {
            ArrayList arrayList;
            List list = this.value_;
            this.value_ = arrayList = new ArrayList(list);
            this.bitField0_ = n10 = this.bitField0_ | 2;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$9500();
    }

    private SingleFieldBuilderV3 getOptionsFieldBuilder() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.optionsBuilder_;
        if (singleFieldBuilderV3 == null) {
            DescriptorProtos$EnumOptions descriptorProtos$EnumOptions = this.getOptions();
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.optionsBuilder_ = singleFieldBuilderV3 = new SingleFieldBuilderV3(descriptorProtos$EnumOptions, generatedMessageV3$BuilderParent, bl2);
            singleFieldBuilderV3 = null;
            this.options_ = null;
        }
        return this.optionsBuilder_;
    }

    private RepeatedFieldBuilderV3 getReservedRangeFieldBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.reservedRangeBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            List list = this.reservedRange_;
            int n10 = this.bitField0_ & 8;
            n10 = n10 != 0 ? 1 : 0;
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.reservedRangeBuilder_ = repeatedFieldBuilderV3 = new RepeatedFieldBuilderV3(list, n10 != 0, generatedMessageV3$BuilderParent, bl2);
            repeatedFieldBuilderV3 = null;
            this.reservedRange_ = null;
        }
        return this.reservedRangeBuilder_;
    }

    private RepeatedFieldBuilderV3 getValueFieldBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.valueBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            List list = this.value_;
            int n10 = this.bitField0_ & 2;
            n10 = n10 != 0 ? 1 : 0;
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.valueBuilder_ = repeatedFieldBuilderV3 = new RepeatedFieldBuilderV3(list, n10 != 0, generatedMessageV3$BuilderParent, bl2);
            repeatedFieldBuilderV3 = null;
            this.value_ = null;
        }
        return this.valueBuilder_;
    }

    private void maybeForceBuilderInitialization() {
        boolean bl2 = GeneratedMessageV3.alwaysUseFieldBuilders;
        if (bl2) {
            this.getValueFieldBuilder();
            this.getOptionsFieldBuilder();
            this.getReservedRangeFieldBuilder();
        }
    }

    public DescriptorProtos$EnumDescriptorProto$Builder addAllReservedName(Iterable iterable) {
        this.ensureReservedNameIsMutable();
        LazyStringList lazyStringList = this.reservedName_;
        AbstractMessageLite$Builder.addAll(iterable, lazyStringList);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder addAllReservedRange(Iterable iterable) {
        Object object = this.reservedRangeBuilder_;
        if (object == null) {
            this.ensureReservedRangeIsMutable();
            object = this.reservedRange_;
            AbstractMessageLite$Builder.addAll(iterable, (List)object);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addAllMessages(iterable);
        }
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder addAllValue(Iterable iterable) {
        Object object = this.valueBuilder_;
        if (object == null) {
            this.ensureValueIsMutable();
            object = this.value_;
            AbstractMessageLite$Builder.addAll(iterable, (List)object);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addAllMessages(iterable);
        }
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$EnumDescriptorProto$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$EnumDescriptorProto$Builder addReservedName(String string2) {
        Objects.requireNonNull(string2);
        this.ensureReservedNameIsMutable();
        this.reservedName_.add(string2);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder addReservedNameBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        this.ensureReservedNameIsMutable();
        this.reservedName_.add(byteString);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder addReservedRange(int n10, DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder descriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder) {
        Object object = this.reservedRangeBuilder_;
        if (object == null) {
            this.ensureReservedRangeIsMutable();
            object = this.reservedRange_;
            descriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder = ((DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder)descriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder).build();
            object.add(n10, descriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder = ((DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder)descriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage(n10, (AbstractMessage)((Object)descriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder addReservedRange(int n10, DescriptorProtos$EnumDescriptorProto$EnumReservedRange descriptorProtos$EnumDescriptorProto$EnumReservedRange) {
        Object object = this.reservedRangeBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$EnumDescriptorProto$EnumReservedRange);
            this.ensureReservedRangeIsMutable();
            object = this.reservedRange_;
            object.add(n10, descriptorProtos$EnumDescriptorProto$EnumReservedRange);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(n10, descriptorProtos$EnumDescriptorProto$EnumReservedRange);
        }
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder addReservedRange(DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder descriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder) {
        Object object = this.reservedRangeBuilder_;
        if (object == null) {
            this.ensureReservedRangeIsMutable();
            object = this.reservedRange_;
            descriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder = ((DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder)descriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder).build();
            object.add(descriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder = ((DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder)descriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage((AbstractMessage)((Object)descriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder addReservedRange(DescriptorProtos$EnumDescriptorProto$EnumReservedRange descriptorProtos$EnumDescriptorProto$EnumReservedRange) {
        Object object = this.reservedRangeBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$EnumDescriptorProto$EnumReservedRange);
            this.ensureReservedRangeIsMutable();
            object = this.reservedRange_;
            object.add(descriptorProtos$EnumDescriptorProto$EnumReservedRange);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(descriptorProtos$EnumDescriptorProto$EnumReservedRange);
        }
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder addReservedRangeBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getReservedRangeFieldBuilder();
        DescriptorProtos$EnumDescriptorProto$EnumReservedRange descriptorProtos$EnumDescriptorProto$EnumReservedRange = DescriptorProtos$EnumDescriptorProto$EnumReservedRange.getDefaultInstance();
        return (DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder)repeatedFieldBuilderV3.addBuilder(descriptorProtos$EnumDescriptorProto$EnumReservedRange);
    }

    public DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder addReservedRangeBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getReservedRangeFieldBuilder();
        DescriptorProtos$EnumDescriptorProto$EnumReservedRange descriptorProtos$EnumDescriptorProto$EnumReservedRange = DescriptorProtos$EnumDescriptorProto$EnumReservedRange.getDefaultInstance();
        return (DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder)repeatedFieldBuilderV3.addBuilder(n10, descriptorProtos$EnumDescriptorProto$EnumReservedRange);
    }

    public DescriptorProtos$EnumDescriptorProto$Builder addValue(int n10, DescriptorProtos$EnumValueDescriptorProto$Builder descriptorProtos$EnumValueDescriptorProtoOrBuilder) {
        Object object = this.valueBuilder_;
        if (object == null) {
            this.ensureValueIsMutable();
            object = this.value_;
            descriptorProtos$EnumValueDescriptorProtoOrBuilder = ((DescriptorProtos$EnumValueDescriptorProto$Builder)descriptorProtos$EnumValueDescriptorProtoOrBuilder).build();
            object.add(n10, descriptorProtos$EnumValueDescriptorProtoOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$EnumValueDescriptorProtoOrBuilder = ((DescriptorProtos$EnumValueDescriptorProto$Builder)descriptorProtos$EnumValueDescriptorProtoOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage(n10, (AbstractMessage)((Object)descriptorProtos$EnumValueDescriptorProtoOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder addValue(int n10, DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto) {
        Object object = this.valueBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$EnumValueDescriptorProto);
            this.ensureValueIsMutable();
            object = this.value_;
            object.add(n10, descriptorProtos$EnumValueDescriptorProto);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(n10, descriptorProtos$EnumValueDescriptorProto);
        }
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder addValue(DescriptorProtos$EnumValueDescriptorProto$Builder descriptorProtos$EnumValueDescriptorProtoOrBuilder) {
        Object object = this.valueBuilder_;
        if (object == null) {
            this.ensureValueIsMutable();
            object = this.value_;
            descriptorProtos$EnumValueDescriptorProtoOrBuilder = ((DescriptorProtos$EnumValueDescriptorProto$Builder)descriptorProtos$EnumValueDescriptorProtoOrBuilder).build();
            object.add(descriptorProtos$EnumValueDescriptorProtoOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$EnumValueDescriptorProtoOrBuilder = ((DescriptorProtos$EnumValueDescriptorProto$Builder)descriptorProtos$EnumValueDescriptorProtoOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage((AbstractMessage)((Object)descriptorProtos$EnumValueDescriptorProtoOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder addValue(DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto) {
        Object object = this.valueBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$EnumValueDescriptorProto);
            this.ensureValueIsMutable();
            object = this.value_;
            object.add(descriptorProtos$EnumValueDescriptorProto);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(descriptorProtos$EnumValueDescriptorProto);
        }
        return this;
    }

    public DescriptorProtos$EnumValueDescriptorProto$Builder addValueBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getValueFieldBuilder();
        DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto = DescriptorProtos$EnumValueDescriptorProto.getDefaultInstance();
        return (DescriptorProtos$EnumValueDescriptorProto$Builder)repeatedFieldBuilderV3.addBuilder(descriptorProtos$EnumValueDescriptorProto);
    }

    public DescriptorProtos$EnumValueDescriptorProto$Builder addValueBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getValueFieldBuilder();
        DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto = DescriptorProtos$EnumValueDescriptorProto.getDefaultInstance();
        return (DescriptorProtos$EnumValueDescriptorProto$Builder)repeatedFieldBuilderV3.addBuilder(n10, descriptorProtos$EnumValueDescriptorProto);
    }

    public DescriptorProtos$EnumDescriptorProto build() {
        DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto = this.buildPartial();
        boolean bl2 = descriptorProtos$EnumDescriptorProto.isInitialized();
        if (bl2) {
            return descriptorProtos$EnumDescriptorProto;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(descriptorProtos$EnumDescriptorProto);
    }

    public DescriptorProtos$EnumDescriptorProto buildPartial() {
        Object object = null;
        DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto = new DescriptorProtos$EnumDescriptorProto(this, null);
        int n10 = this.bitField0_;
        int n11 = n10 & 1;
        n11 = n11 != 0 ? 1 : 0;
        List list = this.name_;
        DescriptorProtos$EnumDescriptorProto.access$10902(descriptorProtos$EnumDescriptorProto, list);
        list = this.valueBuilder_;
        if (list == null) {
            int n12 = this.bitField0_ & 2;
            if (n12 != 0) {
                this.value_ = list = Collections.unmodifiableList(this.value_);
                this.bitField0_ = n12 = this.bitField0_ & 0xFFFFFFFD;
            }
            list = this.value_;
            DescriptorProtos$EnumDescriptorProto.access$11002(descriptorProtos$EnumDescriptorProto, list);
        } else {
            list = ((RepeatedFieldBuilderV3)((Object)list)).build();
            DescriptorProtos$EnumDescriptorProto.access$11002(descriptorProtos$EnumDescriptorProto, list);
        }
        if ((n10 &= 4) != 0) {
            object = this.optionsBuilder_;
            if (object == null) {
                object = this.options_;
                DescriptorProtos$EnumDescriptorProto.access$11102(descriptorProtos$EnumDescriptorProto, (DescriptorProtos$EnumOptions)object);
            } else {
                object = (DescriptorProtos$EnumOptions)((SingleFieldBuilderV3)object).build();
                DescriptorProtos$EnumDescriptorProto.access$11102(descriptorProtos$EnumDescriptorProto, (DescriptorProtos$EnumOptions)object);
            }
            n11 |= 2;
        }
        if ((object = this.reservedRangeBuilder_) == null) {
            n10 = this.bitField0_ & 8;
            if (n10 != 0) {
                this.reservedRange_ = object = Collections.unmodifiableList(this.reservedRange_);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
            }
            object = this.reservedRange_;
            DescriptorProtos$EnumDescriptorProto.access$11202(descriptorProtos$EnumDescriptorProto, object);
        } else {
            object = ((RepeatedFieldBuilderV3)object).build();
            DescriptorProtos$EnumDescriptorProto.access$11202(descriptorProtos$EnumDescriptorProto, (List)object);
        }
        n10 = this.bitField0_ & 0x10;
        if (n10 != 0) {
            this.reservedName_ = object = this.reservedName_.getUnmodifiableView();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFEF;
        }
        object = this.reservedName_;
        DescriptorProtos$EnumDescriptorProto.access$11302(descriptorProtos$EnumDescriptorProto, (LazyStringList)object);
        DescriptorProtos$EnumDescriptorProto.access$11402(descriptorProtos$EnumDescriptorProto, n11);
        this.onBuilt();
        return descriptorProtos$EnumDescriptorProto;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder clear() {
        int n10;
        super.clear();
        this.name_ = "";
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        LazyStringList lazyStringList = this.valueBuilder_;
        if (lazyStringList == null) {
            lazyStringList = Collections.emptyList();
            this.value_ = lazyStringList;
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        } else {
            ((RepeatedFieldBuilderV3)((Object)lazyStringList)).clear();
        }
        lazyStringList = this.optionsBuilder_;
        if (lazyStringList == null) {
            n10 = 0;
            lazyStringList = null;
            this.options_ = null;
        } else {
            ((SingleFieldBuilderV3)((Object)lazyStringList)).clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        lazyStringList = this.reservedRangeBuilder_;
        if (lazyStringList == null) {
            lazyStringList = Collections.emptyList();
            this.reservedRange_ = lazyStringList;
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
        } else {
            ((RepeatedFieldBuilderV3)((Object)lazyStringList)).clear();
        }
        this.reservedName_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFEF;
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (DescriptorProtos$EnumDescriptorProto$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public DescriptorProtos$EnumDescriptorProto$Builder clearName() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        String string2 = DescriptorProtos$EnumDescriptorProto.getDefaultInstance().getName();
        this.name_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (DescriptorProtos$EnumDescriptorProto$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public DescriptorProtos$EnumDescriptorProto$Builder clearOptions() {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.optionsBuilder_;
        if (singleFieldBuilderV3 == null) {
            n10 = 0;
            singleFieldBuilderV3 = null;
            this.options_ = null;
            this.onChanged();
        } else {
            singleFieldBuilderV3.clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder clearReservedName() {
        int n10;
        LazyStringList lazyStringList;
        this.reservedName_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFEF;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder clearReservedRange() {
        Object object = this.reservedRangeBuilder_;
        if (object == null) {
            int n10;
            this.reservedRange_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder clearValue() {
        Object object = this.valueBuilder_;
        if (object == null) {
            int n10;
            this.value_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder clone() {
        return (DescriptorProtos$EnumDescriptorProto$Builder)super.clone();
    }

    public DescriptorProtos$EnumDescriptorProto getDefaultInstanceForType() {
        return DescriptorProtos$EnumDescriptorProto.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.access$9500();
    }

    public String getName() {
        Object object = this.name_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.name_ = string2;
            }
            return string2;
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

    public DescriptorProtos$EnumOptions getOptions() {
        Object object = this.optionsBuilder_;
        if (object == null) {
            object = this.options_;
            if (object == null) {
                object = DescriptorProtos$EnumOptions.getDefaultInstance();
            }
            return object;
        }
        return (DescriptorProtos$EnumOptions)((SingleFieldBuilderV3)object).getMessage();
    }

    public DescriptorProtos$EnumOptions$Builder getOptionsBuilder() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.onChanged();
        return (DescriptorProtos$EnumOptions$Builder)this.getOptionsFieldBuilder().getBuilder();
    }

    public DescriptorProtos$EnumOptionsOrBuilder getOptionsOrBuilder() {
        Object object = this.optionsBuilder_;
        if (object != null) {
            return (DescriptorProtos$EnumOptionsOrBuilder)((SingleFieldBuilderV3)object).getMessageOrBuilder();
        }
        object = this.options_;
        if (object == null) {
            object = DescriptorProtos$EnumOptions.getDefaultInstance();
        }
        return object;
    }

    public String getReservedName(int n10) {
        return (String)this.reservedName_.get(n10);
    }

    public ByteString getReservedNameBytes(int n10) {
        return this.reservedName_.getByteString(n10);
    }

    public int getReservedNameCount() {
        return this.reservedName_.size();
    }

    public ProtocolStringList getReservedNameList() {
        return this.reservedName_.getUnmodifiableView();
    }

    public DescriptorProtos$EnumDescriptorProto$EnumReservedRange getReservedRange(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.reservedRangeBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (DescriptorProtos$EnumDescriptorProto$EnumReservedRange)this.reservedRange_.get(n10);
        }
        return (DescriptorProtos$EnumDescriptorProto$EnumReservedRange)repeatedFieldBuilderV3.getMessage(n10);
    }

    public DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder getReservedRangeBuilder(int n10) {
        return (DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder)this.getReservedRangeFieldBuilder().getBuilder(n10);
    }

    public List getReservedRangeBuilderList() {
        return this.getReservedRangeFieldBuilder().getBuilderList();
    }

    public int getReservedRangeCount() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.reservedRangeBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return this.reservedRange_.size();
        }
        return repeatedFieldBuilderV3.getCount();
    }

    public List getReservedRangeList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.reservedRangeBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return Collections.unmodifiableList(this.reservedRange_);
        }
        return repeatedFieldBuilderV3.getMessageList();
    }

    public DescriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder getReservedRangeOrBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.reservedRangeBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (DescriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder)this.reservedRange_.get(n10);
        }
        return (DescriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(n10);
    }

    public List getReservedRangeOrBuilderList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.reservedRangeBuilder_;
        if (repeatedFieldBuilderV3 != null) {
            return repeatedFieldBuilderV3.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(this.reservedRange_);
    }

    public DescriptorProtos$EnumValueDescriptorProto getValue(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.valueBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (DescriptorProtos$EnumValueDescriptorProto)this.value_.get(n10);
        }
        return (DescriptorProtos$EnumValueDescriptorProto)repeatedFieldBuilderV3.getMessage(n10);
    }

    public DescriptorProtos$EnumValueDescriptorProto$Builder getValueBuilder(int n10) {
        return (DescriptorProtos$EnumValueDescriptorProto$Builder)this.getValueFieldBuilder().getBuilder(n10);
    }

    public List getValueBuilderList() {
        return this.getValueFieldBuilder().getBuilderList();
    }

    public int getValueCount() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.valueBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return this.value_.size();
        }
        return repeatedFieldBuilderV3.getCount();
    }

    public List getValueList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.valueBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return Collections.unmodifiableList(this.value_);
        }
        return repeatedFieldBuilderV3.getMessageList();
    }

    public DescriptorProtos$EnumValueDescriptorProtoOrBuilder getValueOrBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.valueBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (DescriptorProtos$EnumValueDescriptorProtoOrBuilder)this.value_.get(n10);
        }
        return (DescriptorProtos$EnumValueDescriptorProtoOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(n10);
    }

    public List getValueOrBuilderList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.valueBuilder_;
        if (repeatedFieldBuilderV3 != null) {
            return repeatedFieldBuilderV3.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(this.value_);
    }

    public boolean hasName() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean hasOptions() {
        int n10 = this.bitField0_ & 4;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$9600().ensureFieldAccessorsInitialized(DescriptorProtos$EnumDescriptorProto.class, DescriptorProtos$EnumDescriptorProto$Builder.class);
    }

    public final boolean isInitialized() {
        int n10;
        int n11;
        DescriptorProtos$EnumOptions descriptorProtos$EnumOptions = null;
        for (n11 = 0; n11 < (n10 = this.getValueCount()); ++n11) {
            DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto = this.getValue(n11);
            n10 = (int)(descriptorProtos$EnumValueDescriptorProto.isInitialized() ? 1 : 0);
            if (n10 != 0) continue;
            return false;
        }
        n11 = (int)(this.hasOptions() ? 1 : 0);
        return n11 == 0 || (n11 = (int)((descriptorProtos$EnumOptions = this.getOptions()).isInitialized() ? 1 : 0)) != 0;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public DescriptorProtos$EnumDescriptorProto$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = DescriptorProtos$EnumDescriptorProto.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (DescriptorProtos$EnumDescriptorProto)object;
            if (object == null) break block7;
            this.mergeFrom((DescriptorProtos$EnumDescriptorProto)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (DescriptorProtos$EnumDescriptorProto)object2;
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
            this.mergeFrom((DescriptorProtos$EnumDescriptorProto)object3);
        }
        throw var1_6;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder mergeFrom(DescriptorProtos$EnumDescriptorProto messageLite) {
        Object object = DescriptorProtos$EnumDescriptorProto.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        int n10 = messageLite.hasName();
        if (n10 != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 1;
            this.name_ = object = DescriptorProtos$EnumDescriptorProto.access$10900(messageLite);
            this.onChanged();
        }
        object = this.valueBuilder_;
        Object object2 = null;
        if (object == null) {
            object = DescriptorProtos$EnumDescriptorProto.access$11000(messageLite);
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 == 0) {
                object = this.value_;
                n10 = (int)(object.isEmpty() ? 1 : 0);
                if (n10 != 0) {
                    this.value_ = object = DescriptorProtos$EnumDescriptorProto.access$11000(messageLite);
                    this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
                } else {
                    this.ensureValueIsMutable();
                    object = this.value_;
                    List list = DescriptorProtos$EnumDescriptorProto.access$11000(messageLite);
                    object.addAll(list);
                }
                this.onChanged();
            }
        } else {
            object = DescriptorProtos$EnumDescriptorProto.access$11000(messageLite);
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 == 0) {
                object = this.valueBuilder_;
                n10 = (int)(((RepeatedFieldBuilderV3)object).isEmpty() ? 1 : 0);
                if (n10 != 0) {
                    this.valueBuilder_.dispose();
                    this.valueBuilder_ = null;
                    this.value_ = object = DescriptorProtos$EnumDescriptorProto.access$11000(messageLite);
                    this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
                    n10 = (int)(GeneratedMessageV3.alwaysUseFieldBuilders ? 1 : 0);
                    if (n10 != 0) {
                        object = this.getValueFieldBuilder();
                    } else {
                        n10 = 0;
                        object = null;
                    }
                    this.valueBuilder_ = object;
                } else {
                    object = this.valueBuilder_;
                    List list = DescriptorProtos$EnumDescriptorProto.access$11000(messageLite);
                    ((RepeatedFieldBuilderV3)object).addAllMessages(list);
                }
            }
        }
        if ((n10 = (int)(messageLite.hasOptions() ? 1 : 0)) != 0) {
            object = messageLite.getOptions();
            this.mergeOptions((DescriptorProtos$EnumOptions)object);
        }
        if ((object = this.reservedRangeBuilder_) == null) {
            object = DescriptorProtos$EnumDescriptorProto.access$11200(messageLite);
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 == 0) {
                object = this.reservedRange_;
                n10 = (int)(object.isEmpty() ? 1 : 0);
                if (n10 != 0) {
                    this.reservedRange_ = object = DescriptorProtos$EnumDescriptorProto.access$11200(messageLite);
                    this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
                } else {
                    this.ensureReservedRangeIsMutable();
                    object = this.reservedRange_;
                    object2 = DescriptorProtos$EnumDescriptorProto.access$11200(messageLite);
                    object.addAll(object2);
                }
                this.onChanged();
            }
        } else {
            object = DescriptorProtos$EnumDescriptorProto.access$11200(messageLite);
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 == 0) {
                object = this.reservedRangeBuilder_;
                n10 = (int)(((RepeatedFieldBuilderV3)object).isEmpty() ? 1 : 0);
                if (n10 != 0) {
                    this.reservedRangeBuilder_.dispose();
                    this.reservedRangeBuilder_ = null;
                    this.reservedRange_ = object = DescriptorProtos$EnumDescriptorProto.access$11200(messageLite);
                    this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
                    n10 = (int)(GeneratedMessageV3.alwaysUseFieldBuilders ? 1 : 0);
                    if (n10 != 0) {
                        object2 = this.getReservedRangeFieldBuilder();
                    }
                    this.reservedRangeBuilder_ = object2;
                } else {
                    object = this.reservedRangeBuilder_;
                    object2 = DescriptorProtos$EnumDescriptorProto.access$11200(messageLite);
                    ((RepeatedFieldBuilderV3)object).addAllMessages((Iterable)object2);
                }
            }
        }
        if ((n10 = (int)((object = DescriptorProtos$EnumDescriptorProto.access$11300(messageLite)).isEmpty() ? 1 : 0)) == 0) {
            object = this.reservedName_;
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 != 0) {
                this.reservedName_ = object = DescriptorProtos$EnumDescriptorProto.access$11300(messageLite);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFEF;
            } else {
                this.ensureReservedNameIsMutable();
                object = this.reservedName_;
                object2 = DescriptorProtos$EnumDescriptorProto.access$11300(messageLite);
                object.addAll(object2);
            }
            this.onChanged();
        }
        messageLite = messageLite.unknownFields;
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof DescriptorProtos$EnumDescriptorProto;
        if (bl2) {
            message = (DescriptorProtos$EnumDescriptorProto)message;
            return this.mergeFrom((DescriptorProtos$EnumDescriptorProto)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder mergeOptions(DescriptorProtos$EnumOptions descriptorProtos$EnumOptions) {
        int n10;
        Object object = this.optionsBuilder_;
        if (object == null) {
            DescriptorProtos$EnumOptions descriptorProtos$EnumOptions2;
            int n11 = this.bitField0_ & 4;
            if (n11 != 0 && (object = this.options_) != null && object != (descriptorProtos$EnumOptions2 = DescriptorProtos$EnumOptions.getDefaultInstance())) {
                object = DescriptorProtos$EnumOptions.newBuilder(this.options_);
                this.options_ = descriptorProtos$EnumOptions = ((DescriptorProtos$EnumOptions$Builder)object).mergeFrom(descriptorProtos$EnumOptions).buildPartial();
            } else {
                this.options_ = descriptorProtos$EnumOptions;
            }
            this.onChanged();
        } else {
            ((SingleFieldBuilderV3)object).mergeFrom(descriptorProtos$EnumOptions);
        }
        this.bitField0_ = n10 = this.bitField0_ | 4;
        return this;
    }

    public final DescriptorProtos$EnumDescriptorProto$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$EnumDescriptorProto$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public DescriptorProtos$EnumDescriptorProto$Builder removeReservedRange(int n10) {
        Object object = this.reservedRangeBuilder_;
        if (object == null) {
            this.ensureReservedRangeIsMutable();
            object = this.reservedRange_;
            object.remove(n10);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).remove(n10);
        }
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder removeValue(int n10) {
        Object object = this.valueBuilder_;
        if (object == null) {
            this.ensureValueIsMutable();
            object = this.value_;
            object.remove(n10);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).remove(n10);
        }
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$EnumDescriptorProto$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$EnumDescriptorProto$Builder setName(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.name_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder setNameBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.name_ = byteString;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder setOptions(DescriptorProtos$EnumOptions$Builder descriptorProtos$EnumOptionsOrBuilder) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.optionsBuilder_;
        if (singleFieldBuilderV3 == null) {
            descriptorProtos$EnumOptionsOrBuilder = descriptorProtos$EnumOptionsOrBuilder.build();
            this.options_ = descriptorProtos$EnumOptionsOrBuilder;
            this.onChanged();
        } else {
            descriptorProtos$EnumOptionsOrBuilder = descriptorProtos$EnumOptionsOrBuilder.build();
            singleFieldBuilderV3.setMessage((AbstractMessage)((Object)descriptorProtos$EnumOptionsOrBuilder));
        }
        this.bitField0_ = n10 = this.bitField0_ | 4;
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder setOptions(DescriptorProtos$EnumOptions descriptorProtos$EnumOptions) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.optionsBuilder_;
        if (singleFieldBuilderV3 == null) {
            Objects.requireNonNull(descriptorProtos$EnumOptions);
            this.options_ = descriptorProtos$EnumOptions;
            this.onChanged();
        } else {
            singleFieldBuilderV3.setMessage(descriptorProtos$EnumOptions);
        }
        this.bitField0_ = n10 = this.bitField0_ | 4;
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (DescriptorProtos$EnumDescriptorProto$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public DescriptorProtos$EnumDescriptorProto$Builder setReservedName(int n10, String string2) {
        Objects.requireNonNull(string2);
        this.ensureReservedNameIsMutable();
        this.reservedName_.set(n10, string2);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder setReservedRange(int n10, DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder descriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder) {
        Object object = this.reservedRangeBuilder_;
        if (object == null) {
            this.ensureReservedRangeIsMutable();
            object = this.reservedRange_;
            descriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder = ((DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder)descriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder).build();
            object.set(n10, descriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder = ((DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder)descriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).setMessage(n10, (AbstractMessage)((Object)descriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder setReservedRange(int n10, DescriptorProtos$EnumDescriptorProto$EnumReservedRange descriptorProtos$EnumDescriptorProto$EnumReservedRange) {
        Object object = this.reservedRangeBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$EnumDescriptorProto$EnumReservedRange);
            this.ensureReservedRangeIsMutable();
            object = this.reservedRange_;
            object.set(n10, descriptorProtos$EnumDescriptorProto$EnumReservedRange);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).setMessage(n10, descriptorProtos$EnumDescriptorProto$EnumReservedRange);
        }
        return this;
    }

    public final DescriptorProtos$EnumDescriptorProto$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$EnumDescriptorProto$Builder)super.setUnknownFields(unknownFieldSet);
    }

    public DescriptorProtos$EnumDescriptorProto$Builder setValue(int n10, DescriptorProtos$EnumValueDescriptorProto$Builder descriptorProtos$EnumValueDescriptorProtoOrBuilder) {
        Object object = this.valueBuilder_;
        if (object == null) {
            this.ensureValueIsMutable();
            object = this.value_;
            descriptorProtos$EnumValueDescriptorProtoOrBuilder = ((DescriptorProtos$EnumValueDescriptorProto$Builder)descriptorProtos$EnumValueDescriptorProtoOrBuilder).build();
            object.set(n10, descriptorProtos$EnumValueDescriptorProtoOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$EnumValueDescriptorProtoOrBuilder = ((DescriptorProtos$EnumValueDescriptorProto$Builder)descriptorProtos$EnumValueDescriptorProtoOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).setMessage(n10, (AbstractMessage)((Object)descriptorProtos$EnumValueDescriptorProtoOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder setValue(int n10, DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto) {
        Object object = this.valueBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$EnumValueDescriptorProto);
            this.ensureValueIsMutable();
            object = this.value_;
            object.set(n10, descriptorProtos$EnumValueDescriptorProto);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).setMessage(n10, descriptorProtos$EnumValueDescriptorProto);
        }
        return this;
    }
}

