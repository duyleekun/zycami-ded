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
import com.google.protobuf.DescriptorProtos$DescriptorProto;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRange;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRange$Builder;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRange;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRange$Builder;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder;
import com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$MessageOptions;
import com.google.protobuf.DescriptorProtos$MessageOptions$Builder;
import com.google.protobuf.DescriptorProtos$MessageOptionsOrBuilder;
import com.google.protobuf.DescriptorProtos$OneofDescriptorProto;
import com.google.protobuf.DescriptorProtos$OneofDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$OneofDescriptorProtoOrBuilder;
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

public final class DescriptorProtos$DescriptorProto$Builder
extends GeneratedMessageV3$Builder
implements DescriptorProtos$DescriptorProtoOrBuilder {
    private int bitField0_;
    private RepeatedFieldBuilderV3 enumTypeBuilder_;
    private List enumType_;
    private RepeatedFieldBuilderV3 extensionBuilder_;
    private RepeatedFieldBuilderV3 extensionRangeBuilder_;
    private List extensionRange_;
    private List extension_;
    private RepeatedFieldBuilderV3 fieldBuilder_;
    private List field_;
    private Object name_ = "";
    private RepeatedFieldBuilderV3 nestedTypeBuilder_;
    private List nestedType_;
    private RepeatedFieldBuilderV3 oneofDeclBuilder_;
    private List oneofDecl_;
    private SingleFieldBuilderV3 optionsBuilder_;
    private DescriptorProtos$MessageOptions options_;
    private LazyStringList reservedName_;
    private RepeatedFieldBuilderV3 reservedRangeBuilder_;
    private List reservedRange_;

    private DescriptorProtos$DescriptorProto$Builder() {
        LazyStringList lazyStringList;
        this.field_ = lazyStringList = Collections.emptyList();
        this.extension_ = lazyStringList = Collections.emptyList();
        this.nestedType_ = lazyStringList = Collections.emptyList();
        this.enumType_ = lazyStringList = Collections.emptyList();
        this.extensionRange_ = lazyStringList = Collections.emptyList();
        this.oneofDecl_ = lazyStringList = Collections.emptyList();
        this.reservedRange_ = lazyStringList = Collections.emptyList();
        this.reservedName_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$DescriptorProto$Builder(DescriptorProtos$1 descriptorProtos$1) {
        this();
    }

    private DescriptorProtos$DescriptorProto$Builder(GeneratedMessageV3$BuilderParent lazyStringList) {
        super((GeneratedMessageV3$BuilderParent)((Object)lazyStringList));
        lazyStringList = Collections.emptyList();
        this.field_ = lazyStringList;
        this.extension_ = lazyStringList = Collections.emptyList();
        this.nestedType_ = lazyStringList = Collections.emptyList();
        this.enumType_ = lazyStringList = Collections.emptyList();
        this.extensionRange_ = lazyStringList = Collections.emptyList();
        this.oneofDecl_ = lazyStringList = Collections.emptyList();
        this.reservedRange_ = lazyStringList = Collections.emptyList();
        this.reservedName_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$DescriptorProto$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$BuilderParent);
    }

    private void ensureEnumTypeIsMutable() {
        int n10 = this.bitField0_ & 0x10;
        if (n10 == 0) {
            ArrayList arrayList;
            List list = this.enumType_;
            this.enumType_ = arrayList = new ArrayList(list);
            this.bitField0_ = n10 = this.bitField0_ | 0x10;
        }
    }

    private void ensureExtensionIsMutable() {
        int n10 = this.bitField0_ & 4;
        if (n10 == 0) {
            ArrayList arrayList;
            List list = this.extension_;
            this.extension_ = arrayList = new ArrayList(list);
            this.bitField0_ = n10 = this.bitField0_ | 4;
        }
    }

    private void ensureExtensionRangeIsMutable() {
        int n10 = this.bitField0_ & 0x20;
        if (n10 == 0) {
            ArrayList arrayList;
            List list = this.extensionRange_;
            this.extensionRange_ = arrayList = new ArrayList(list);
            this.bitField0_ = n10 = this.bitField0_ | 0x20;
        }
    }

    private void ensureFieldIsMutable() {
        int n10 = this.bitField0_ & 2;
        if (n10 == 0) {
            ArrayList arrayList;
            List list = this.field_;
            this.field_ = arrayList = new ArrayList(list);
            this.bitField0_ = n10 = this.bitField0_ | 2;
        }
    }

    private void ensureNestedTypeIsMutable() {
        int n10 = this.bitField0_ & 8;
        if (n10 == 0) {
            ArrayList arrayList;
            List list = this.nestedType_;
            this.nestedType_ = arrayList = new ArrayList(list);
            this.bitField0_ = n10 = this.bitField0_ | 8;
        }
    }

    private void ensureOneofDeclIsMutable() {
        int n10 = this.bitField0_ & 0x40;
        if (n10 == 0) {
            ArrayList arrayList;
            List list = this.oneofDecl_;
            this.oneofDecl_ = arrayList = new ArrayList(list);
            this.bitField0_ = n10 = this.bitField0_ | 0x40;
        }
    }

    private void ensureReservedNameIsMutable() {
        int n10 = this.bitField0_ & 0x200;
        if (n10 == 0) {
            LazyStringList lazyStringList = this.reservedName_;
            LazyStringArrayList lazyStringArrayList = new LazyStringArrayList(lazyStringList);
            this.reservedName_ = lazyStringArrayList;
            this.bitField0_ = n10 = this.bitField0_ | 0x200;
        }
    }

    private void ensureReservedRangeIsMutable() {
        int n10 = this.bitField0_ & 0x100;
        if (n10 == 0) {
            ArrayList arrayList;
            List list = this.reservedRange_;
            this.reservedRange_ = arrayList = new ArrayList(list);
            this.bitField0_ = n10 = this.bitField0_ | 0x100;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$2600();
    }

    private RepeatedFieldBuilderV3 getEnumTypeFieldBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.enumTypeBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            List list = this.enumType_;
            int n10 = this.bitField0_ & 0x10;
            n10 = n10 != 0 ? 1 : 0;
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.enumTypeBuilder_ = repeatedFieldBuilderV3 = new RepeatedFieldBuilderV3(list, n10 != 0, generatedMessageV3$BuilderParent, bl2);
            repeatedFieldBuilderV3 = null;
            this.enumType_ = null;
        }
        return this.enumTypeBuilder_;
    }

    private RepeatedFieldBuilderV3 getExtensionFieldBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.extensionBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            List list = this.extension_;
            int n10 = this.bitField0_ & 4;
            n10 = n10 != 0 ? 1 : 0;
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.extensionBuilder_ = repeatedFieldBuilderV3 = new RepeatedFieldBuilderV3(list, n10 != 0, generatedMessageV3$BuilderParent, bl2);
            repeatedFieldBuilderV3 = null;
            this.extension_ = null;
        }
        return this.extensionBuilder_;
    }

    private RepeatedFieldBuilderV3 getExtensionRangeFieldBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.extensionRangeBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            List list = this.extensionRange_;
            int n10 = this.bitField0_ & 0x20;
            n10 = n10 != 0 ? 1 : 0;
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.extensionRangeBuilder_ = repeatedFieldBuilderV3 = new RepeatedFieldBuilderV3(list, n10 != 0, generatedMessageV3$BuilderParent, bl2);
            repeatedFieldBuilderV3 = null;
            this.extensionRange_ = null;
        }
        return this.extensionRangeBuilder_;
    }

    private RepeatedFieldBuilderV3 getFieldFieldBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.fieldBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            List list = this.field_;
            int n10 = this.bitField0_ & 2;
            n10 = n10 != 0 ? 1 : 0;
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.fieldBuilder_ = repeatedFieldBuilderV3 = new RepeatedFieldBuilderV3(list, n10 != 0, generatedMessageV3$BuilderParent, bl2);
            repeatedFieldBuilderV3 = null;
            this.field_ = null;
        }
        return this.fieldBuilder_;
    }

    private RepeatedFieldBuilderV3 getNestedTypeFieldBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.nestedTypeBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            List list = this.nestedType_;
            int n10 = this.bitField0_ & 8;
            n10 = n10 != 0 ? 1 : 0;
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.nestedTypeBuilder_ = repeatedFieldBuilderV3 = new RepeatedFieldBuilderV3(list, n10 != 0, generatedMessageV3$BuilderParent, bl2);
            repeatedFieldBuilderV3 = null;
            this.nestedType_ = null;
        }
        return this.nestedTypeBuilder_;
    }

    private RepeatedFieldBuilderV3 getOneofDeclFieldBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.oneofDeclBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            List list = this.oneofDecl_;
            int n10 = this.bitField0_ & 0x40;
            n10 = n10 != 0 ? 1 : 0;
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.oneofDeclBuilder_ = repeatedFieldBuilderV3 = new RepeatedFieldBuilderV3(list, n10 != 0, generatedMessageV3$BuilderParent, bl2);
            repeatedFieldBuilderV3 = null;
            this.oneofDecl_ = null;
        }
        return this.oneofDeclBuilder_;
    }

    private SingleFieldBuilderV3 getOptionsFieldBuilder() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.optionsBuilder_;
        if (singleFieldBuilderV3 == null) {
            DescriptorProtos$MessageOptions descriptorProtos$MessageOptions = this.getOptions();
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.optionsBuilder_ = singleFieldBuilderV3 = new SingleFieldBuilderV3(descriptorProtos$MessageOptions, generatedMessageV3$BuilderParent, bl2);
            singleFieldBuilderV3 = null;
            this.options_ = null;
        }
        return this.optionsBuilder_;
    }

    private RepeatedFieldBuilderV3 getReservedRangeFieldBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.reservedRangeBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            List list = this.reservedRange_;
            int n10 = this.bitField0_ & 0x100;
            n10 = n10 != 0 ? 1 : 0;
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.reservedRangeBuilder_ = repeatedFieldBuilderV3 = new RepeatedFieldBuilderV3(list, n10 != 0, generatedMessageV3$BuilderParent, bl2);
            repeatedFieldBuilderV3 = null;
            this.reservedRange_ = null;
        }
        return this.reservedRangeBuilder_;
    }

    private void maybeForceBuilderInitialization() {
        boolean bl2 = GeneratedMessageV3.alwaysUseFieldBuilders;
        if (bl2) {
            this.getFieldFieldBuilder();
            this.getExtensionFieldBuilder();
            this.getNestedTypeFieldBuilder();
            this.getEnumTypeFieldBuilder();
            this.getExtensionRangeFieldBuilder();
            this.getOneofDeclFieldBuilder();
            this.getOptionsFieldBuilder();
            this.getReservedRangeFieldBuilder();
        }
    }

    public DescriptorProtos$DescriptorProto$Builder addAllEnumType(Iterable iterable) {
        Object object = this.enumTypeBuilder_;
        if (object == null) {
            this.ensureEnumTypeIsMutable();
            object = this.enumType_;
            AbstractMessageLite$Builder.addAll(iterable, (List)object);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addAllMessages(iterable);
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addAllExtension(Iterable iterable) {
        Object object = this.extensionBuilder_;
        if (object == null) {
            this.ensureExtensionIsMutable();
            object = this.extension_;
            AbstractMessageLite$Builder.addAll(iterable, (List)object);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addAllMessages(iterable);
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addAllExtensionRange(Iterable iterable) {
        Object object = this.extensionRangeBuilder_;
        if (object == null) {
            this.ensureExtensionRangeIsMutable();
            object = this.extensionRange_;
            AbstractMessageLite$Builder.addAll(iterable, (List)object);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addAllMessages(iterable);
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addAllField(Iterable iterable) {
        Object object = this.fieldBuilder_;
        if (object == null) {
            this.ensureFieldIsMutable();
            object = this.field_;
            AbstractMessageLite$Builder.addAll(iterable, (List)object);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addAllMessages(iterable);
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addAllNestedType(Iterable iterable) {
        Object object = this.nestedTypeBuilder_;
        if (object == null) {
            this.ensureNestedTypeIsMutable();
            object = this.nestedType_;
            AbstractMessageLite$Builder.addAll(iterable, (List)object);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addAllMessages(iterable);
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addAllOneofDecl(Iterable iterable) {
        Object object = this.oneofDeclBuilder_;
        if (object == null) {
            this.ensureOneofDeclIsMutable();
            object = this.oneofDecl_;
            AbstractMessageLite$Builder.addAll(iterable, (List)object);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addAllMessages(iterable);
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addAllReservedName(Iterable iterable) {
        this.ensureReservedNameIsMutable();
        LazyStringList lazyStringList = this.reservedName_;
        AbstractMessageLite$Builder.addAll(iterable, lazyStringList);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addAllReservedRange(Iterable iterable) {
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

    public DescriptorProtos$DescriptorProto$Builder addEnumType(int n10, DescriptorProtos$EnumDescriptorProto$Builder descriptorProtos$EnumDescriptorProtoOrBuilder) {
        Object object = this.enumTypeBuilder_;
        if (object == null) {
            this.ensureEnumTypeIsMutable();
            object = this.enumType_;
            descriptorProtos$EnumDescriptorProtoOrBuilder = ((DescriptorProtos$EnumDescriptorProto$Builder)descriptorProtos$EnumDescriptorProtoOrBuilder).build();
            object.add(n10, descriptorProtos$EnumDescriptorProtoOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$EnumDescriptorProtoOrBuilder = ((DescriptorProtos$EnumDescriptorProto$Builder)descriptorProtos$EnumDescriptorProtoOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage(n10, (AbstractMessage)((Object)descriptorProtos$EnumDescriptorProtoOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addEnumType(int n10, DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto) {
        Object object = this.enumTypeBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$EnumDescriptorProto);
            this.ensureEnumTypeIsMutable();
            object = this.enumType_;
            object.add(n10, descriptorProtos$EnumDescriptorProto);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(n10, descriptorProtos$EnumDescriptorProto);
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addEnumType(DescriptorProtos$EnumDescriptorProto$Builder descriptorProtos$EnumDescriptorProtoOrBuilder) {
        Object object = this.enumTypeBuilder_;
        if (object == null) {
            this.ensureEnumTypeIsMutable();
            object = this.enumType_;
            descriptorProtos$EnumDescriptorProtoOrBuilder = ((DescriptorProtos$EnumDescriptorProto$Builder)descriptorProtos$EnumDescriptorProtoOrBuilder).build();
            object.add(descriptorProtos$EnumDescriptorProtoOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$EnumDescriptorProtoOrBuilder = ((DescriptorProtos$EnumDescriptorProto$Builder)descriptorProtos$EnumDescriptorProtoOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage((AbstractMessage)((Object)descriptorProtos$EnumDescriptorProtoOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addEnumType(DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto) {
        Object object = this.enumTypeBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$EnumDescriptorProto);
            this.ensureEnumTypeIsMutable();
            object = this.enumType_;
            object.add(descriptorProtos$EnumDescriptorProto);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(descriptorProtos$EnumDescriptorProto);
        }
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder addEnumTypeBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getEnumTypeFieldBuilder();
        DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto = DescriptorProtos$EnumDescriptorProto.getDefaultInstance();
        return (DescriptorProtos$EnumDescriptorProto$Builder)repeatedFieldBuilderV3.addBuilder(descriptorProtos$EnumDescriptorProto);
    }

    public DescriptorProtos$EnumDescriptorProto$Builder addEnumTypeBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getEnumTypeFieldBuilder();
        DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto = DescriptorProtos$EnumDescriptorProto.getDefaultInstance();
        return (DescriptorProtos$EnumDescriptorProto$Builder)repeatedFieldBuilderV3.addBuilder(n10, descriptorProtos$EnumDescriptorProto);
    }

    public DescriptorProtos$DescriptorProto$Builder addExtension(int n10, DescriptorProtos$FieldDescriptorProto$Builder descriptorProtos$FieldDescriptorProtoOrBuilder) {
        Object object = this.extensionBuilder_;
        if (object == null) {
            this.ensureExtensionIsMutable();
            object = this.extension_;
            descriptorProtos$FieldDescriptorProtoOrBuilder = ((DescriptorProtos$FieldDescriptorProto$Builder)descriptorProtos$FieldDescriptorProtoOrBuilder).build();
            object.add(n10, descriptorProtos$FieldDescriptorProtoOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$FieldDescriptorProtoOrBuilder = ((DescriptorProtos$FieldDescriptorProto$Builder)descriptorProtos$FieldDescriptorProtoOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage(n10, (AbstractMessage)((Object)descriptorProtos$FieldDescriptorProtoOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addExtension(int n10, DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
        Object object = this.extensionBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$FieldDescriptorProto);
            this.ensureExtensionIsMutable();
            object = this.extension_;
            object.add(n10, descriptorProtos$FieldDescriptorProto);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(n10, descriptorProtos$FieldDescriptorProto);
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addExtension(DescriptorProtos$FieldDescriptorProto$Builder descriptorProtos$FieldDescriptorProtoOrBuilder) {
        Object object = this.extensionBuilder_;
        if (object == null) {
            this.ensureExtensionIsMutable();
            object = this.extension_;
            descriptorProtos$FieldDescriptorProtoOrBuilder = ((DescriptorProtos$FieldDescriptorProto$Builder)descriptorProtos$FieldDescriptorProtoOrBuilder).build();
            object.add(descriptorProtos$FieldDescriptorProtoOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$FieldDescriptorProtoOrBuilder = ((DescriptorProtos$FieldDescriptorProto$Builder)descriptorProtos$FieldDescriptorProtoOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage((AbstractMessage)((Object)descriptorProtos$FieldDescriptorProtoOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addExtension(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
        Object object = this.extensionBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$FieldDescriptorProto);
            this.ensureExtensionIsMutable();
            object = this.extension_;
            object.add(descriptorProtos$FieldDescriptorProto);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(descriptorProtos$FieldDescriptorProto);
        }
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder addExtensionBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getExtensionFieldBuilder();
        DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto = DescriptorProtos$FieldDescriptorProto.getDefaultInstance();
        return (DescriptorProtos$FieldDescriptorProto$Builder)repeatedFieldBuilderV3.addBuilder(descriptorProtos$FieldDescriptorProto);
    }

    public DescriptorProtos$FieldDescriptorProto$Builder addExtensionBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getExtensionFieldBuilder();
        DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto = DescriptorProtos$FieldDescriptorProto.getDefaultInstance();
        return (DescriptorProtos$FieldDescriptorProto$Builder)repeatedFieldBuilderV3.addBuilder(n10, descriptorProtos$FieldDescriptorProto);
    }

    public DescriptorProtos$DescriptorProto$Builder addExtensionRange(int n10, DescriptorProtos$DescriptorProto$ExtensionRange$Builder descriptorProtos$DescriptorProto$ExtensionRangeOrBuilder) {
        Object object = this.extensionRangeBuilder_;
        if (object == null) {
            this.ensureExtensionRangeIsMutable();
            object = this.extensionRange_;
            descriptorProtos$DescriptorProto$ExtensionRangeOrBuilder = ((DescriptorProtos$DescriptorProto$ExtensionRange$Builder)descriptorProtos$DescriptorProto$ExtensionRangeOrBuilder).build();
            object.add(n10, descriptorProtos$DescriptorProto$ExtensionRangeOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$DescriptorProto$ExtensionRangeOrBuilder = ((DescriptorProtos$DescriptorProto$ExtensionRange$Builder)descriptorProtos$DescriptorProto$ExtensionRangeOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage(n10, (AbstractMessage)((Object)descriptorProtos$DescriptorProto$ExtensionRangeOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addExtensionRange(int n10, DescriptorProtos$DescriptorProto$ExtensionRange descriptorProtos$DescriptorProto$ExtensionRange) {
        Object object = this.extensionRangeBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$DescriptorProto$ExtensionRange);
            this.ensureExtensionRangeIsMutable();
            object = this.extensionRange_;
            object.add(n10, descriptorProtos$DescriptorProto$ExtensionRange);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(n10, descriptorProtos$DescriptorProto$ExtensionRange);
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addExtensionRange(DescriptorProtos$DescriptorProto$ExtensionRange$Builder descriptorProtos$DescriptorProto$ExtensionRangeOrBuilder) {
        Object object = this.extensionRangeBuilder_;
        if (object == null) {
            this.ensureExtensionRangeIsMutable();
            object = this.extensionRange_;
            descriptorProtos$DescriptorProto$ExtensionRangeOrBuilder = ((DescriptorProtos$DescriptorProto$ExtensionRange$Builder)descriptorProtos$DescriptorProto$ExtensionRangeOrBuilder).build();
            object.add(descriptorProtos$DescriptorProto$ExtensionRangeOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$DescriptorProto$ExtensionRangeOrBuilder = ((DescriptorProtos$DescriptorProto$ExtensionRange$Builder)descriptorProtos$DescriptorProto$ExtensionRangeOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage((AbstractMessage)((Object)descriptorProtos$DescriptorProto$ExtensionRangeOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addExtensionRange(DescriptorProtos$DescriptorProto$ExtensionRange descriptorProtos$DescriptorProto$ExtensionRange) {
        Object object = this.extensionRangeBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$DescriptorProto$ExtensionRange);
            this.ensureExtensionRangeIsMutable();
            object = this.extensionRange_;
            object.add(descriptorProtos$DescriptorProto$ExtensionRange);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(descriptorProtos$DescriptorProto$ExtensionRange);
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder addExtensionRangeBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getExtensionRangeFieldBuilder();
        DescriptorProtos$DescriptorProto$ExtensionRange descriptorProtos$DescriptorProto$ExtensionRange = DescriptorProtos$DescriptorProto$ExtensionRange.getDefaultInstance();
        return (DescriptorProtos$DescriptorProto$ExtensionRange$Builder)repeatedFieldBuilderV3.addBuilder(descriptorProtos$DescriptorProto$ExtensionRange);
    }

    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder addExtensionRangeBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getExtensionRangeFieldBuilder();
        DescriptorProtos$DescriptorProto$ExtensionRange descriptorProtos$DescriptorProto$ExtensionRange = DescriptorProtos$DescriptorProto$ExtensionRange.getDefaultInstance();
        return (DescriptorProtos$DescriptorProto$ExtensionRange$Builder)repeatedFieldBuilderV3.addBuilder(n10, descriptorProtos$DescriptorProto$ExtensionRange);
    }

    public DescriptorProtos$DescriptorProto$Builder addField(int n10, DescriptorProtos$FieldDescriptorProto$Builder descriptorProtos$FieldDescriptorProtoOrBuilder) {
        Object object = this.fieldBuilder_;
        if (object == null) {
            this.ensureFieldIsMutable();
            object = this.field_;
            descriptorProtos$FieldDescriptorProtoOrBuilder = ((DescriptorProtos$FieldDescriptorProto$Builder)descriptorProtos$FieldDescriptorProtoOrBuilder).build();
            object.add(n10, descriptorProtos$FieldDescriptorProtoOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$FieldDescriptorProtoOrBuilder = ((DescriptorProtos$FieldDescriptorProto$Builder)descriptorProtos$FieldDescriptorProtoOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage(n10, (AbstractMessage)((Object)descriptorProtos$FieldDescriptorProtoOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addField(int n10, DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
        Object object = this.fieldBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$FieldDescriptorProto);
            this.ensureFieldIsMutable();
            object = this.field_;
            object.add(n10, descriptorProtos$FieldDescriptorProto);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(n10, descriptorProtos$FieldDescriptorProto);
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addField(DescriptorProtos$FieldDescriptorProto$Builder descriptorProtos$FieldDescriptorProtoOrBuilder) {
        Object object = this.fieldBuilder_;
        if (object == null) {
            this.ensureFieldIsMutable();
            object = this.field_;
            descriptorProtos$FieldDescriptorProtoOrBuilder = ((DescriptorProtos$FieldDescriptorProto$Builder)descriptorProtos$FieldDescriptorProtoOrBuilder).build();
            object.add(descriptorProtos$FieldDescriptorProtoOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$FieldDescriptorProtoOrBuilder = ((DescriptorProtos$FieldDescriptorProto$Builder)descriptorProtos$FieldDescriptorProtoOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage((AbstractMessage)((Object)descriptorProtos$FieldDescriptorProtoOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addField(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
        Object object = this.fieldBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$FieldDescriptorProto);
            this.ensureFieldIsMutable();
            object = this.field_;
            object.add(descriptorProtos$FieldDescriptorProto);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(descriptorProtos$FieldDescriptorProto);
        }
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder addFieldBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getFieldFieldBuilder();
        DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto = DescriptorProtos$FieldDescriptorProto.getDefaultInstance();
        return (DescriptorProtos$FieldDescriptorProto$Builder)repeatedFieldBuilderV3.addBuilder(descriptorProtos$FieldDescriptorProto);
    }

    public DescriptorProtos$FieldDescriptorProto$Builder addFieldBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getFieldFieldBuilder();
        DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto = DescriptorProtos$FieldDescriptorProto.getDefaultInstance();
        return (DescriptorProtos$FieldDescriptorProto$Builder)repeatedFieldBuilderV3.addBuilder(n10, descriptorProtos$FieldDescriptorProto);
    }

    public DescriptorProtos$DescriptorProto$Builder addNestedType(int n10, DescriptorProtos$DescriptorProto$Builder descriptorProtos$DescriptorProtoOrBuilder) {
        Object object = this.nestedTypeBuilder_;
        if (object == null) {
            this.ensureNestedTypeIsMutable();
            object = this.nestedType_;
            descriptorProtos$DescriptorProtoOrBuilder = ((DescriptorProtos$DescriptorProto$Builder)descriptorProtos$DescriptorProtoOrBuilder).build();
            object.add(n10, descriptorProtos$DescriptorProtoOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$DescriptorProtoOrBuilder = ((DescriptorProtos$DescriptorProto$Builder)descriptorProtos$DescriptorProtoOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage(n10, (AbstractMessage)((Object)descriptorProtos$DescriptorProtoOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addNestedType(int n10, DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        Object object = this.nestedTypeBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$DescriptorProto);
            this.ensureNestedTypeIsMutable();
            object = this.nestedType_;
            object.add(n10, descriptorProtos$DescriptorProto);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(n10, descriptorProtos$DescriptorProto);
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addNestedType(DescriptorProtos$DescriptorProto$Builder descriptorProtos$DescriptorProtoOrBuilder) {
        Object object = this.nestedTypeBuilder_;
        if (object == null) {
            this.ensureNestedTypeIsMutable();
            object = this.nestedType_;
            descriptorProtos$DescriptorProtoOrBuilder = ((DescriptorProtos$DescriptorProto$Builder)descriptorProtos$DescriptorProtoOrBuilder).build();
            object.add(descriptorProtos$DescriptorProtoOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$DescriptorProtoOrBuilder = ((DescriptorProtos$DescriptorProto$Builder)descriptorProtos$DescriptorProtoOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage((AbstractMessage)((Object)descriptorProtos$DescriptorProtoOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addNestedType(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        Object object = this.nestedTypeBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$DescriptorProto);
            this.ensureNestedTypeIsMutable();
            object = this.nestedType_;
            object.add(descriptorProtos$DescriptorProto);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(descriptorProtos$DescriptorProto);
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addNestedTypeBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getNestedTypeFieldBuilder();
        DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto = DescriptorProtos$DescriptorProto.getDefaultInstance();
        return (DescriptorProtos$DescriptorProto$Builder)repeatedFieldBuilderV3.addBuilder(descriptorProtos$DescriptorProto);
    }

    public DescriptorProtos$DescriptorProto$Builder addNestedTypeBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getNestedTypeFieldBuilder();
        DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto = DescriptorProtos$DescriptorProto.getDefaultInstance();
        return (DescriptorProtos$DescriptorProto$Builder)repeatedFieldBuilderV3.addBuilder(n10, descriptorProtos$DescriptorProto);
    }

    public DescriptorProtos$DescriptorProto$Builder addOneofDecl(int n10, DescriptorProtos$OneofDescriptorProto$Builder descriptorProtos$OneofDescriptorProtoOrBuilder) {
        Object object = this.oneofDeclBuilder_;
        if (object == null) {
            this.ensureOneofDeclIsMutable();
            object = this.oneofDecl_;
            descriptorProtos$OneofDescriptorProtoOrBuilder = ((DescriptorProtos$OneofDescriptorProto$Builder)descriptorProtos$OneofDescriptorProtoOrBuilder).build();
            object.add(n10, descriptorProtos$OneofDescriptorProtoOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$OneofDescriptorProtoOrBuilder = ((DescriptorProtos$OneofDescriptorProto$Builder)descriptorProtos$OneofDescriptorProtoOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage(n10, (AbstractMessage)((Object)descriptorProtos$OneofDescriptorProtoOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addOneofDecl(int n10, DescriptorProtos$OneofDescriptorProto descriptorProtos$OneofDescriptorProto) {
        Object object = this.oneofDeclBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$OneofDescriptorProto);
            this.ensureOneofDeclIsMutable();
            object = this.oneofDecl_;
            object.add(n10, descriptorProtos$OneofDescriptorProto);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(n10, descriptorProtos$OneofDescriptorProto);
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addOneofDecl(DescriptorProtos$OneofDescriptorProto$Builder descriptorProtos$OneofDescriptorProtoOrBuilder) {
        Object object = this.oneofDeclBuilder_;
        if (object == null) {
            this.ensureOneofDeclIsMutable();
            object = this.oneofDecl_;
            descriptorProtos$OneofDescriptorProtoOrBuilder = ((DescriptorProtos$OneofDescriptorProto$Builder)descriptorProtos$OneofDescriptorProtoOrBuilder).build();
            object.add(descriptorProtos$OneofDescriptorProtoOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$OneofDescriptorProtoOrBuilder = ((DescriptorProtos$OneofDescriptorProto$Builder)descriptorProtos$OneofDescriptorProtoOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage((AbstractMessage)((Object)descriptorProtos$OneofDescriptorProtoOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addOneofDecl(DescriptorProtos$OneofDescriptorProto descriptorProtos$OneofDescriptorProto) {
        Object object = this.oneofDeclBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$OneofDescriptorProto);
            this.ensureOneofDeclIsMutable();
            object = this.oneofDecl_;
            object.add(descriptorProtos$OneofDescriptorProto);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(descriptorProtos$OneofDescriptorProto);
        }
        return this;
    }

    public DescriptorProtos$OneofDescriptorProto$Builder addOneofDeclBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getOneofDeclFieldBuilder();
        DescriptorProtos$OneofDescriptorProto descriptorProtos$OneofDescriptorProto = DescriptorProtos$OneofDescriptorProto.getDefaultInstance();
        return (DescriptorProtos$OneofDescriptorProto$Builder)repeatedFieldBuilderV3.addBuilder(descriptorProtos$OneofDescriptorProto);
    }

    public DescriptorProtos$OneofDescriptorProto$Builder addOneofDeclBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getOneofDeclFieldBuilder();
        DescriptorProtos$OneofDescriptorProto descriptorProtos$OneofDescriptorProto = DescriptorProtos$OneofDescriptorProto.getDefaultInstance();
        return (DescriptorProtos$OneofDescriptorProto$Builder)repeatedFieldBuilderV3.addBuilder(n10, descriptorProtos$OneofDescriptorProto);
    }

    public DescriptorProtos$DescriptorProto$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$DescriptorProto$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$DescriptorProto$Builder addReservedName(String string2) {
        Objects.requireNonNull(string2);
        this.ensureReservedNameIsMutable();
        this.reservedName_.add(string2);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addReservedNameBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        this.ensureReservedNameIsMutable();
        this.reservedName_.add(byteString);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addReservedRange(int n10, DescriptorProtos$DescriptorProto$ReservedRange$Builder descriptorProtos$DescriptorProto$ReservedRangeOrBuilder) {
        Object object = this.reservedRangeBuilder_;
        if (object == null) {
            this.ensureReservedRangeIsMutable();
            object = this.reservedRange_;
            descriptorProtos$DescriptorProto$ReservedRangeOrBuilder = ((DescriptorProtos$DescriptorProto$ReservedRange$Builder)descriptorProtos$DescriptorProto$ReservedRangeOrBuilder).build();
            object.add(n10, descriptorProtos$DescriptorProto$ReservedRangeOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$DescriptorProto$ReservedRangeOrBuilder = ((DescriptorProtos$DescriptorProto$ReservedRange$Builder)descriptorProtos$DescriptorProto$ReservedRangeOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage(n10, (AbstractMessage)((Object)descriptorProtos$DescriptorProto$ReservedRangeOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addReservedRange(int n10, DescriptorProtos$DescriptorProto$ReservedRange descriptorProtos$DescriptorProto$ReservedRange) {
        Object object = this.reservedRangeBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$DescriptorProto$ReservedRange);
            this.ensureReservedRangeIsMutable();
            object = this.reservedRange_;
            object.add(n10, descriptorProtos$DescriptorProto$ReservedRange);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(n10, descriptorProtos$DescriptorProto$ReservedRange);
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addReservedRange(DescriptorProtos$DescriptorProto$ReservedRange$Builder descriptorProtos$DescriptorProto$ReservedRangeOrBuilder) {
        Object object = this.reservedRangeBuilder_;
        if (object == null) {
            this.ensureReservedRangeIsMutable();
            object = this.reservedRange_;
            descriptorProtos$DescriptorProto$ReservedRangeOrBuilder = ((DescriptorProtos$DescriptorProto$ReservedRange$Builder)descriptorProtos$DescriptorProto$ReservedRangeOrBuilder).build();
            object.add(descriptorProtos$DescriptorProto$ReservedRangeOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$DescriptorProto$ReservedRangeOrBuilder = ((DescriptorProtos$DescriptorProto$ReservedRange$Builder)descriptorProtos$DescriptorProto$ReservedRangeOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage((AbstractMessage)((Object)descriptorProtos$DescriptorProto$ReservedRangeOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addReservedRange(DescriptorProtos$DescriptorProto$ReservedRange descriptorProtos$DescriptorProto$ReservedRange) {
        Object object = this.reservedRangeBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$DescriptorProto$ReservedRange);
            this.ensureReservedRangeIsMutable();
            object = this.reservedRange_;
            object.add(descriptorProtos$DescriptorProto$ReservedRange);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(descriptorProtos$DescriptorProto$ReservedRange);
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$ReservedRange$Builder addReservedRangeBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getReservedRangeFieldBuilder();
        DescriptorProtos$DescriptorProto$ReservedRange descriptorProtos$DescriptorProto$ReservedRange = DescriptorProtos$DescriptorProto$ReservedRange.getDefaultInstance();
        return (DescriptorProtos$DescriptorProto$ReservedRange$Builder)repeatedFieldBuilderV3.addBuilder(descriptorProtos$DescriptorProto$ReservedRange);
    }

    public DescriptorProtos$DescriptorProto$ReservedRange$Builder addReservedRangeBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getReservedRangeFieldBuilder();
        DescriptorProtos$DescriptorProto$ReservedRange descriptorProtos$DescriptorProto$ReservedRange = DescriptorProtos$DescriptorProto$ReservedRange.getDefaultInstance();
        return (DescriptorProtos$DescriptorProto$ReservedRange$Builder)repeatedFieldBuilderV3.addBuilder(n10, descriptorProtos$DescriptorProto$ReservedRange);
    }

    public DescriptorProtos$DescriptorProto build() {
        DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto = this.buildPartial();
        boolean bl2 = descriptorProtos$DescriptorProto.isInitialized();
        if (bl2) {
            return descriptorProtos$DescriptorProto;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(descriptorProtos$DescriptorProto);
    }

    public DescriptorProtos$DescriptorProto buildPartial() {
        int n10;
        Object object = null;
        DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto = new DescriptorProtos$DescriptorProto(this, null);
        int n11 = this.bitField0_;
        int n12 = n11 & 1;
        n12 = n12 != 0 ? 1 : 0;
        List list = this.name_;
        DescriptorProtos$DescriptorProto.access$5002(descriptorProtos$DescriptorProto, list);
        list = this.fieldBuilder_;
        if (list == null) {
            n10 = this.bitField0_ & 2;
            if (n10 != 0) {
                list = Collections.unmodifiableList(this.field_);
                this.field_ = list;
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
            }
            list = this.field_;
            DescriptorProtos$DescriptorProto.access$5102(descriptorProtos$DescriptorProto, list);
        } else {
            list = ((RepeatedFieldBuilderV3)((Object)list)).build();
            DescriptorProtos$DescriptorProto.access$5102(descriptorProtos$DescriptorProto, list);
        }
        list = this.extensionBuilder_;
        if (list == null) {
            n10 = this.bitField0_ & 4;
            if (n10 != 0) {
                list = Collections.unmodifiableList(this.extension_);
                this.extension_ = list;
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
            }
            list = this.extension_;
            DescriptorProtos$DescriptorProto.access$5202(descriptorProtos$DescriptorProto, list);
        } else {
            list = ((RepeatedFieldBuilderV3)((Object)list)).build();
            DescriptorProtos$DescriptorProto.access$5202(descriptorProtos$DescriptorProto, list);
        }
        list = this.nestedTypeBuilder_;
        if (list == null) {
            n10 = this.bitField0_ & 8;
            if (n10 != 0) {
                list = Collections.unmodifiableList(this.nestedType_);
                this.nestedType_ = list;
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
            }
            list = this.nestedType_;
            DescriptorProtos$DescriptorProto.access$5302(descriptorProtos$DescriptorProto, list);
        } else {
            list = ((RepeatedFieldBuilderV3)((Object)list)).build();
            DescriptorProtos$DescriptorProto.access$5302(descriptorProtos$DescriptorProto, list);
        }
        list = this.enumTypeBuilder_;
        if (list == null) {
            n10 = this.bitField0_ & 0x10;
            if (n10 != 0) {
                list = Collections.unmodifiableList(this.enumType_);
                this.enumType_ = list;
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFEF;
            }
            list = this.enumType_;
            DescriptorProtos$DescriptorProto.access$5402(descriptorProtos$DescriptorProto, list);
        } else {
            list = ((RepeatedFieldBuilderV3)((Object)list)).build();
            DescriptorProtos$DescriptorProto.access$5402(descriptorProtos$DescriptorProto, list);
        }
        list = this.extensionRangeBuilder_;
        if (list == null) {
            n10 = this.bitField0_ & 0x20;
            if (n10 != 0) {
                this.extensionRange_ = list = Collections.unmodifiableList(this.extensionRange_);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFDF;
            }
            list = this.extensionRange_;
            DescriptorProtos$DescriptorProto.access$5502(descriptorProtos$DescriptorProto, list);
        } else {
            list = ((RepeatedFieldBuilderV3)((Object)list)).build();
            DescriptorProtos$DescriptorProto.access$5502(descriptorProtos$DescriptorProto, list);
        }
        list = this.oneofDeclBuilder_;
        if (list == null) {
            n10 = this.bitField0_ & 0x40;
            if (n10 != 0) {
                this.oneofDecl_ = list = Collections.unmodifiableList(this.oneofDecl_);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFBF;
            }
            list = this.oneofDecl_;
            DescriptorProtos$DescriptorProto.access$5602(descriptorProtos$DescriptorProto, list);
        } else {
            list = ((RepeatedFieldBuilderV3)((Object)list)).build();
            DescriptorProtos$DescriptorProto.access$5602(descriptorProtos$DescriptorProto, list);
        }
        if ((n11 &= 0x80) != 0) {
            object = this.optionsBuilder_;
            if (object == null) {
                object = this.options_;
                DescriptorProtos$DescriptorProto.access$5702(descriptorProtos$DescriptorProto, (DescriptorProtos$MessageOptions)object);
            } else {
                object = (DescriptorProtos$MessageOptions)((SingleFieldBuilderV3)object).build();
                DescriptorProtos$DescriptorProto.access$5702(descriptorProtos$DescriptorProto, (DescriptorProtos$MessageOptions)object);
            }
            n12 |= 2;
        }
        if ((object = this.reservedRangeBuilder_) == null) {
            n11 = this.bitField0_ & 0x100;
            if (n11 != 0) {
                this.reservedRange_ = object = Collections.unmodifiableList(this.reservedRange_);
                this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFEFF;
            }
            object = this.reservedRange_;
            DescriptorProtos$DescriptorProto.access$5802(descriptorProtos$DescriptorProto, object);
        } else {
            object = ((RepeatedFieldBuilderV3)object).build();
            DescriptorProtos$DescriptorProto.access$5802(descriptorProtos$DescriptorProto, (List)object);
        }
        n11 = this.bitField0_ & 0x200;
        if (n11 != 0) {
            this.reservedName_ = object = this.reservedName_.getUnmodifiableView();
            this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFDFF;
        }
        object = this.reservedName_;
        DescriptorProtos$DescriptorProto.access$5902(descriptorProtos$DescriptorProto, (LazyStringList)object);
        DescriptorProtos$DescriptorProto.access$6002(descriptorProtos$DescriptorProto, n12);
        this.onBuilt();
        return descriptorProtos$DescriptorProto;
    }

    public DescriptorProtos$DescriptorProto$Builder clear() {
        int n10;
        super.clear();
        this.name_ = "";
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        LazyStringList lazyStringList = this.fieldBuilder_;
        if (lazyStringList == null) {
            lazyStringList = Collections.emptyList();
            this.field_ = lazyStringList;
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        } else {
            ((RepeatedFieldBuilderV3)((Object)lazyStringList)).clear();
        }
        lazyStringList = this.extensionBuilder_;
        if (lazyStringList == null) {
            lazyStringList = Collections.emptyList();
            this.extension_ = lazyStringList;
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        } else {
            ((RepeatedFieldBuilderV3)((Object)lazyStringList)).clear();
        }
        lazyStringList = this.nestedTypeBuilder_;
        if (lazyStringList == null) {
            lazyStringList = Collections.emptyList();
            this.nestedType_ = lazyStringList;
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
        } else {
            ((RepeatedFieldBuilderV3)((Object)lazyStringList)).clear();
        }
        lazyStringList = this.enumTypeBuilder_;
        if (lazyStringList == null) {
            lazyStringList = Collections.emptyList();
            this.enumType_ = lazyStringList;
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFEF;
        } else {
            ((RepeatedFieldBuilderV3)((Object)lazyStringList)).clear();
        }
        lazyStringList = this.extensionRangeBuilder_;
        if (lazyStringList == null) {
            lazyStringList = Collections.emptyList();
            this.extensionRange_ = lazyStringList;
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFDF;
        } else {
            ((RepeatedFieldBuilderV3)((Object)lazyStringList)).clear();
        }
        lazyStringList = this.oneofDeclBuilder_;
        if (lazyStringList == null) {
            lazyStringList = Collections.emptyList();
            this.oneofDecl_ = lazyStringList;
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFBF;
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
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFF7F;
        lazyStringList = this.reservedRangeBuilder_;
        if (lazyStringList == null) {
            lazyStringList = Collections.emptyList();
            this.reservedRange_ = lazyStringList;
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFEFF;
        } else {
            ((RepeatedFieldBuilderV3)((Object)lazyStringList)).clear();
        }
        this.reservedName_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFDFF;
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder clearEnumType() {
        Object object = this.enumTypeBuilder_;
        if (object == null) {
            int n10;
            this.enumType_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFEF;
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder clearExtension() {
        Object object = this.extensionBuilder_;
        if (object == null) {
            int n10;
            this.extension_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder clearExtensionRange() {
        Object object = this.extensionRangeBuilder_;
        if (object == null) {
            int n10;
            this.extensionRange_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFDF;
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder clearField() {
        Object object = this.fieldBuilder_;
        if (object == null) {
            int n10;
            this.field_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (DescriptorProtos$DescriptorProto$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public DescriptorProtos$DescriptorProto$Builder clearName() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        String string2 = DescriptorProtos$DescriptorProto.getDefaultInstance().getName();
        this.name_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder clearNestedType() {
        Object object = this.nestedTypeBuilder_;
        if (object == null) {
            int n10;
            this.nestedType_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (DescriptorProtos$DescriptorProto$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public DescriptorProtos$DescriptorProto$Builder clearOneofDecl() {
        Object object = this.oneofDeclBuilder_;
        if (object == null) {
            int n10;
            this.oneofDecl_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFBF;
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder clearOptions() {
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
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFF7F;
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder clearReservedName() {
        int n10;
        LazyStringList lazyStringList;
        this.reservedName_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFDFF;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder clearReservedRange() {
        Object object = this.reservedRangeBuilder_;
        if (object == null) {
            int n10;
            this.reservedRange_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFEFF;
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder clone() {
        return (DescriptorProtos$DescriptorProto$Builder)super.clone();
    }

    public DescriptorProtos$DescriptorProto getDefaultInstanceForType() {
        return DescriptorProtos$DescriptorProto.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.access$2600();
    }

    public DescriptorProtos$EnumDescriptorProto getEnumType(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.enumTypeBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (DescriptorProtos$EnumDescriptorProto)this.enumType_.get(n10);
        }
        return (DescriptorProtos$EnumDescriptorProto)repeatedFieldBuilderV3.getMessage(n10);
    }

    public DescriptorProtos$EnumDescriptorProto$Builder getEnumTypeBuilder(int n10) {
        return (DescriptorProtos$EnumDescriptorProto$Builder)this.getEnumTypeFieldBuilder().getBuilder(n10);
    }

    public List getEnumTypeBuilderList() {
        return this.getEnumTypeFieldBuilder().getBuilderList();
    }

    public int getEnumTypeCount() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.enumTypeBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return this.enumType_.size();
        }
        return repeatedFieldBuilderV3.getCount();
    }

    public List getEnumTypeList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.enumTypeBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return Collections.unmodifiableList(this.enumType_);
        }
        return repeatedFieldBuilderV3.getMessageList();
    }

    public DescriptorProtos$EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.enumTypeBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (DescriptorProtos$EnumDescriptorProtoOrBuilder)this.enumType_.get(n10);
        }
        return (DescriptorProtos$EnumDescriptorProtoOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(n10);
    }

    public List getEnumTypeOrBuilderList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.enumTypeBuilder_;
        if (repeatedFieldBuilderV3 != null) {
            return repeatedFieldBuilderV3.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(this.enumType_);
    }

    public DescriptorProtos$FieldDescriptorProto getExtension(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.extensionBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (DescriptorProtos$FieldDescriptorProto)this.extension_.get(n10);
        }
        return (DescriptorProtos$FieldDescriptorProto)repeatedFieldBuilderV3.getMessage(n10);
    }

    public DescriptorProtos$FieldDescriptorProto$Builder getExtensionBuilder(int n10) {
        return (DescriptorProtos$FieldDescriptorProto$Builder)this.getExtensionFieldBuilder().getBuilder(n10);
    }

    public List getExtensionBuilderList() {
        return this.getExtensionFieldBuilder().getBuilderList();
    }

    public int getExtensionCount() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.extensionBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return this.extension_.size();
        }
        return repeatedFieldBuilderV3.getCount();
    }

    public List getExtensionList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.extensionBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return Collections.unmodifiableList(this.extension_);
        }
        return repeatedFieldBuilderV3.getMessageList();
    }

    public DescriptorProtos$FieldDescriptorProtoOrBuilder getExtensionOrBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.extensionBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (DescriptorProtos$FieldDescriptorProtoOrBuilder)this.extension_.get(n10);
        }
        return (DescriptorProtos$FieldDescriptorProtoOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(n10);
    }

    public List getExtensionOrBuilderList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.extensionBuilder_;
        if (repeatedFieldBuilderV3 != null) {
            return repeatedFieldBuilderV3.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(this.extension_);
    }

    public DescriptorProtos$DescriptorProto$ExtensionRange getExtensionRange(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.extensionRangeBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (DescriptorProtos$DescriptorProto$ExtensionRange)this.extensionRange_.get(n10);
        }
        return (DescriptorProtos$DescriptorProto$ExtensionRange)repeatedFieldBuilderV3.getMessage(n10);
    }

    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder getExtensionRangeBuilder(int n10) {
        return (DescriptorProtos$DescriptorProto$ExtensionRange$Builder)this.getExtensionRangeFieldBuilder().getBuilder(n10);
    }

    public List getExtensionRangeBuilderList() {
        return this.getExtensionRangeFieldBuilder().getBuilderList();
    }

    public int getExtensionRangeCount() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.extensionRangeBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return this.extensionRange_.size();
        }
        return repeatedFieldBuilderV3.getCount();
    }

    public List getExtensionRangeList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.extensionRangeBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return Collections.unmodifiableList(this.extensionRange_);
        }
        return repeatedFieldBuilderV3.getMessageList();
    }

    public DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder getExtensionRangeOrBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.extensionRangeBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder)this.extensionRange_.get(n10);
        }
        return (DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(n10);
    }

    public List getExtensionRangeOrBuilderList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.extensionRangeBuilder_;
        if (repeatedFieldBuilderV3 != null) {
            return repeatedFieldBuilderV3.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(this.extensionRange_);
    }

    public DescriptorProtos$FieldDescriptorProto getField(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.fieldBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (DescriptorProtos$FieldDescriptorProto)this.field_.get(n10);
        }
        return (DescriptorProtos$FieldDescriptorProto)repeatedFieldBuilderV3.getMessage(n10);
    }

    public DescriptorProtos$FieldDescriptorProto$Builder getFieldBuilder(int n10) {
        return (DescriptorProtos$FieldDescriptorProto$Builder)this.getFieldFieldBuilder().getBuilder(n10);
    }

    public List getFieldBuilderList() {
        return this.getFieldFieldBuilder().getBuilderList();
    }

    public int getFieldCount() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.fieldBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return this.field_.size();
        }
        return repeatedFieldBuilderV3.getCount();
    }

    public List getFieldList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.fieldBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return Collections.unmodifiableList(this.field_);
        }
        return repeatedFieldBuilderV3.getMessageList();
    }

    public DescriptorProtos$FieldDescriptorProtoOrBuilder getFieldOrBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.fieldBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (DescriptorProtos$FieldDescriptorProtoOrBuilder)this.field_.get(n10);
        }
        return (DescriptorProtos$FieldDescriptorProtoOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(n10);
    }

    public List getFieldOrBuilderList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.fieldBuilder_;
        if (repeatedFieldBuilderV3 != null) {
            return repeatedFieldBuilderV3.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(this.field_);
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

    public DescriptorProtos$DescriptorProto getNestedType(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.nestedTypeBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (DescriptorProtos$DescriptorProto)this.nestedType_.get(n10);
        }
        return (DescriptorProtos$DescriptorProto)repeatedFieldBuilderV3.getMessage(n10);
    }

    public DescriptorProtos$DescriptorProto$Builder getNestedTypeBuilder(int n10) {
        return (DescriptorProtos$DescriptorProto$Builder)this.getNestedTypeFieldBuilder().getBuilder(n10);
    }

    public List getNestedTypeBuilderList() {
        return this.getNestedTypeFieldBuilder().getBuilderList();
    }

    public int getNestedTypeCount() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.nestedTypeBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return this.nestedType_.size();
        }
        return repeatedFieldBuilderV3.getCount();
    }

    public List getNestedTypeList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.nestedTypeBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return Collections.unmodifiableList(this.nestedType_);
        }
        return repeatedFieldBuilderV3.getMessageList();
    }

    public DescriptorProtos$DescriptorProtoOrBuilder getNestedTypeOrBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.nestedTypeBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (DescriptorProtos$DescriptorProtoOrBuilder)this.nestedType_.get(n10);
        }
        return (DescriptorProtos$DescriptorProtoOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(n10);
    }

    public List getNestedTypeOrBuilderList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.nestedTypeBuilder_;
        if (repeatedFieldBuilderV3 != null) {
            return repeatedFieldBuilderV3.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(this.nestedType_);
    }

    public DescriptorProtos$OneofDescriptorProto getOneofDecl(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.oneofDeclBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (DescriptorProtos$OneofDescriptorProto)this.oneofDecl_.get(n10);
        }
        return (DescriptorProtos$OneofDescriptorProto)repeatedFieldBuilderV3.getMessage(n10);
    }

    public DescriptorProtos$OneofDescriptorProto$Builder getOneofDeclBuilder(int n10) {
        return (DescriptorProtos$OneofDescriptorProto$Builder)this.getOneofDeclFieldBuilder().getBuilder(n10);
    }

    public List getOneofDeclBuilderList() {
        return this.getOneofDeclFieldBuilder().getBuilderList();
    }

    public int getOneofDeclCount() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.oneofDeclBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return this.oneofDecl_.size();
        }
        return repeatedFieldBuilderV3.getCount();
    }

    public List getOneofDeclList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.oneofDeclBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return Collections.unmodifiableList(this.oneofDecl_);
        }
        return repeatedFieldBuilderV3.getMessageList();
    }

    public DescriptorProtos$OneofDescriptorProtoOrBuilder getOneofDeclOrBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.oneofDeclBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (DescriptorProtos$OneofDescriptorProtoOrBuilder)this.oneofDecl_.get(n10);
        }
        return (DescriptorProtos$OneofDescriptorProtoOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(n10);
    }

    public List getOneofDeclOrBuilderList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.oneofDeclBuilder_;
        if (repeatedFieldBuilderV3 != null) {
            return repeatedFieldBuilderV3.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(this.oneofDecl_);
    }

    public DescriptorProtos$MessageOptions getOptions() {
        Object object = this.optionsBuilder_;
        if (object == null) {
            object = this.options_;
            if (object == null) {
                object = DescriptorProtos$MessageOptions.getDefaultInstance();
            }
            return object;
        }
        return (DescriptorProtos$MessageOptions)((SingleFieldBuilderV3)object).getMessage();
    }

    public DescriptorProtos$MessageOptions$Builder getOptionsBuilder() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x80;
        this.onChanged();
        return (DescriptorProtos$MessageOptions$Builder)this.getOptionsFieldBuilder().getBuilder();
    }

    public DescriptorProtos$MessageOptionsOrBuilder getOptionsOrBuilder() {
        Object object = this.optionsBuilder_;
        if (object != null) {
            return (DescriptorProtos$MessageOptionsOrBuilder)((SingleFieldBuilderV3)object).getMessageOrBuilder();
        }
        object = this.options_;
        if (object == null) {
            object = DescriptorProtos$MessageOptions.getDefaultInstance();
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

    public DescriptorProtos$DescriptorProto$ReservedRange getReservedRange(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.reservedRangeBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (DescriptorProtos$DescriptorProto$ReservedRange)this.reservedRange_.get(n10);
        }
        return (DescriptorProtos$DescriptorProto$ReservedRange)repeatedFieldBuilderV3.getMessage(n10);
    }

    public DescriptorProtos$DescriptorProto$ReservedRange$Builder getReservedRangeBuilder(int n10) {
        return (DescriptorProtos$DescriptorProto$ReservedRange$Builder)this.getReservedRangeFieldBuilder().getBuilder(n10);
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

    public DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder getReservedRangeOrBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.reservedRangeBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder)this.reservedRange_.get(n10);
        }
        return (DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(n10);
    }

    public List getReservedRangeOrBuilderList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.reservedRangeBuilder_;
        if (repeatedFieldBuilderV3 != null) {
            return repeatedFieldBuilderV3.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(this.reservedRange_);
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
        int n10 = this.bitField0_ & 0x80;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$2700().ensureFieldAccessorsInitialized(DescriptorProtos$DescriptorProto.class, DescriptorProtos$DescriptorProto$Builder.class);
    }

    public final boolean isInitialized() {
        GeneratedMessageV3 generatedMessageV3;
        int n10;
        int n11;
        DescriptorProtos$MessageOptions descriptorProtos$MessageOptions = null;
        for (n11 = 0; n11 < (n10 = this.getFieldCount()); ++n11) {
            generatedMessageV3 = this.getField(n11);
            n10 = (int)(((DescriptorProtos$FieldDescriptorProto)generatedMessageV3).isInitialized() ? 1 : 0);
            if (n10 != 0) continue;
            return false;
        }
        descriptorProtos$MessageOptions = null;
        for (n11 = 0; n11 < (n10 = this.getExtensionCount()); ++n11) {
            generatedMessageV3 = this.getExtension(n11);
            n10 = (int)(((DescriptorProtos$FieldDescriptorProto)generatedMessageV3).isInitialized() ? 1 : 0);
            if (n10 != 0) continue;
            return false;
        }
        descriptorProtos$MessageOptions = null;
        for (n11 = 0; n11 < (n10 = this.getNestedTypeCount()); ++n11) {
            generatedMessageV3 = this.getNestedType(n11);
            n10 = (int)(((DescriptorProtos$DescriptorProto)generatedMessageV3).isInitialized() ? 1 : 0);
            if (n10 != 0) continue;
            return false;
        }
        descriptorProtos$MessageOptions = null;
        for (n11 = 0; n11 < (n10 = this.getEnumTypeCount()); ++n11) {
            generatedMessageV3 = this.getEnumType(n11);
            n10 = (int)(((DescriptorProtos$EnumDescriptorProto)generatedMessageV3).isInitialized() ? 1 : 0);
            if (n10 != 0) continue;
            return false;
        }
        descriptorProtos$MessageOptions = null;
        for (n11 = 0; n11 < (n10 = this.getExtensionRangeCount()); ++n11) {
            generatedMessageV3 = this.getExtensionRange(n11);
            n10 = (int)(((DescriptorProtos$DescriptorProto$ExtensionRange)generatedMessageV3).isInitialized() ? 1 : 0);
            if (n10 != 0) continue;
            return false;
        }
        descriptorProtos$MessageOptions = null;
        for (n11 = 0; n11 < (n10 = this.getOneofDeclCount()); ++n11) {
            generatedMessageV3 = this.getOneofDecl(n11);
            n10 = (int)(((DescriptorProtos$OneofDescriptorProto)generatedMessageV3).isInitialized() ? 1 : 0);
            if (n10 != 0) continue;
            return false;
        }
        n11 = (int)(this.hasOptions() ? 1 : 0);
        return n11 == 0 || (n11 = (int)((descriptorProtos$MessageOptions = this.getOptions()).isInitialized() ? 1 : 0)) != 0;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public DescriptorProtos$DescriptorProto$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = DescriptorProtos$DescriptorProto.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (DescriptorProtos$DescriptorProto)object;
            if (object == null) break block7;
            this.mergeFrom((DescriptorProtos$DescriptorProto)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (DescriptorProtos$DescriptorProto)object2;
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
            this.mergeFrom((DescriptorProtos$DescriptorProto)object3);
        }
        throw var1_6;
    }

    public DescriptorProtos$DescriptorProto$Builder mergeFrom(DescriptorProtos$DescriptorProto messageLite) {
        List list;
        Object object = DescriptorProtos$DescriptorProto.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        int n10 = messageLite.hasName();
        if (n10 != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 1;
            this.name_ = object = DescriptorProtos$DescriptorProto.access$5000(messageLite);
            this.onChanged();
        }
        object = this.fieldBuilder_;
        Object object2 = null;
        if (object == null) {
            object = DescriptorProtos$DescriptorProto.access$5100(messageLite);
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 == 0) {
                object = this.field_;
                n10 = (int)(object.isEmpty() ? 1 : 0);
                if (n10 != 0) {
                    this.field_ = object = DescriptorProtos$DescriptorProto.access$5100(messageLite);
                    this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
                } else {
                    this.ensureFieldIsMutable();
                    object = this.field_;
                    list = DescriptorProtos$DescriptorProto.access$5100(messageLite);
                    object.addAll(list);
                }
                this.onChanged();
            }
        } else {
            object = DescriptorProtos$DescriptorProto.access$5100(messageLite);
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 == 0) {
                object = this.fieldBuilder_;
                n10 = (int)(((RepeatedFieldBuilderV3)object).isEmpty() ? 1 : 0);
                if (n10 != 0) {
                    this.fieldBuilder_.dispose();
                    this.fieldBuilder_ = null;
                    this.field_ = object = DescriptorProtos$DescriptorProto.access$5100(messageLite);
                    this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
                    n10 = (int)(GeneratedMessageV3.alwaysUseFieldBuilders ? 1 : 0);
                    if (n10 != 0) {
                        object = this.getFieldFieldBuilder();
                    } else {
                        n10 = 0;
                        object = null;
                    }
                    this.fieldBuilder_ = object;
                } else {
                    object = this.fieldBuilder_;
                    list = DescriptorProtos$DescriptorProto.access$5100(messageLite);
                    ((RepeatedFieldBuilderV3)object).addAllMessages(list);
                }
            }
        }
        if ((object = this.extensionBuilder_) == null) {
            object = DescriptorProtos$DescriptorProto.access$5200(messageLite);
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 == 0) {
                object = this.extension_;
                n10 = (int)(object.isEmpty() ? 1 : 0);
                if (n10 != 0) {
                    this.extension_ = object = DescriptorProtos$DescriptorProto.access$5200(messageLite);
                    this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
                } else {
                    this.ensureExtensionIsMutable();
                    object = this.extension_;
                    list = DescriptorProtos$DescriptorProto.access$5200(messageLite);
                    object.addAll(list);
                }
                this.onChanged();
            }
        } else {
            object = DescriptorProtos$DescriptorProto.access$5200(messageLite);
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 == 0) {
                object = this.extensionBuilder_;
                n10 = (int)(((RepeatedFieldBuilderV3)object).isEmpty() ? 1 : 0);
                if (n10 != 0) {
                    this.extensionBuilder_.dispose();
                    this.extensionBuilder_ = null;
                    this.extension_ = object = DescriptorProtos$DescriptorProto.access$5200(messageLite);
                    this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
                    n10 = (int)(GeneratedMessageV3.alwaysUseFieldBuilders ? 1 : 0);
                    if (n10 != 0) {
                        object = this.getExtensionFieldBuilder();
                    } else {
                        n10 = 0;
                        object = null;
                    }
                    this.extensionBuilder_ = object;
                } else {
                    object = this.extensionBuilder_;
                    list = DescriptorProtos$DescriptorProto.access$5200(messageLite);
                    ((RepeatedFieldBuilderV3)object).addAllMessages(list);
                }
            }
        }
        if ((object = this.nestedTypeBuilder_) == null) {
            object = DescriptorProtos$DescriptorProto.access$5300(messageLite);
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 == 0) {
                object = this.nestedType_;
                n10 = (int)(object.isEmpty() ? 1 : 0);
                if (n10 != 0) {
                    this.nestedType_ = object = DescriptorProtos$DescriptorProto.access$5300(messageLite);
                    this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
                } else {
                    this.ensureNestedTypeIsMutable();
                    object = this.nestedType_;
                    list = DescriptorProtos$DescriptorProto.access$5300(messageLite);
                    object.addAll(list);
                }
                this.onChanged();
            }
        } else {
            object = DescriptorProtos$DescriptorProto.access$5300(messageLite);
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 == 0) {
                object = this.nestedTypeBuilder_;
                n10 = (int)(((RepeatedFieldBuilderV3)object).isEmpty() ? 1 : 0);
                if (n10 != 0) {
                    this.nestedTypeBuilder_.dispose();
                    this.nestedTypeBuilder_ = null;
                    this.nestedType_ = object = DescriptorProtos$DescriptorProto.access$5300(messageLite);
                    this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
                    n10 = (int)(GeneratedMessageV3.alwaysUseFieldBuilders ? 1 : 0);
                    if (n10 != 0) {
                        object = this.getNestedTypeFieldBuilder();
                    } else {
                        n10 = 0;
                        object = null;
                    }
                    this.nestedTypeBuilder_ = object;
                } else {
                    object = this.nestedTypeBuilder_;
                    list = DescriptorProtos$DescriptorProto.access$5300(messageLite);
                    ((RepeatedFieldBuilderV3)object).addAllMessages(list);
                }
            }
        }
        if ((object = this.enumTypeBuilder_) == null) {
            object = DescriptorProtos$DescriptorProto.access$5400(messageLite);
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 == 0) {
                object = this.enumType_;
                n10 = (int)(object.isEmpty() ? 1 : 0);
                if (n10 != 0) {
                    this.enumType_ = object = DescriptorProtos$DescriptorProto.access$5400(messageLite);
                    this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFEF;
                } else {
                    this.ensureEnumTypeIsMutable();
                    object = this.enumType_;
                    list = DescriptorProtos$DescriptorProto.access$5400(messageLite);
                    object.addAll(list);
                }
                this.onChanged();
            }
        } else {
            object = DescriptorProtos$DescriptorProto.access$5400(messageLite);
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 == 0) {
                object = this.enumTypeBuilder_;
                n10 = (int)(((RepeatedFieldBuilderV3)object).isEmpty() ? 1 : 0);
                if (n10 != 0) {
                    this.enumTypeBuilder_.dispose();
                    this.enumTypeBuilder_ = null;
                    this.enumType_ = object = DescriptorProtos$DescriptorProto.access$5400(messageLite);
                    this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFEF;
                    n10 = (int)(GeneratedMessageV3.alwaysUseFieldBuilders ? 1 : 0);
                    if (n10 != 0) {
                        object = this.getEnumTypeFieldBuilder();
                    } else {
                        n10 = 0;
                        object = null;
                    }
                    this.enumTypeBuilder_ = object;
                } else {
                    object = this.enumTypeBuilder_;
                    list = DescriptorProtos$DescriptorProto.access$5400(messageLite);
                    ((RepeatedFieldBuilderV3)object).addAllMessages(list);
                }
            }
        }
        if ((object = this.extensionRangeBuilder_) == null) {
            object = DescriptorProtos$DescriptorProto.access$5500(messageLite);
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 == 0) {
                object = this.extensionRange_;
                n10 = (int)(object.isEmpty() ? 1 : 0);
                if (n10 != 0) {
                    this.extensionRange_ = object = DescriptorProtos$DescriptorProto.access$5500(messageLite);
                    this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFDF;
                } else {
                    this.ensureExtensionRangeIsMutable();
                    object = this.extensionRange_;
                    list = DescriptorProtos$DescriptorProto.access$5500(messageLite);
                    object.addAll(list);
                }
                this.onChanged();
            }
        } else {
            object = DescriptorProtos$DescriptorProto.access$5500(messageLite);
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 == 0) {
                object = this.extensionRangeBuilder_;
                n10 = (int)(((RepeatedFieldBuilderV3)object).isEmpty() ? 1 : 0);
                if (n10 != 0) {
                    this.extensionRangeBuilder_.dispose();
                    this.extensionRangeBuilder_ = null;
                    this.extensionRange_ = object = DescriptorProtos$DescriptorProto.access$5500(messageLite);
                    this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFDF;
                    n10 = (int)(GeneratedMessageV3.alwaysUseFieldBuilders ? 1 : 0);
                    if (n10 != 0) {
                        object = this.getExtensionRangeFieldBuilder();
                    } else {
                        n10 = 0;
                        object = null;
                    }
                    this.extensionRangeBuilder_ = object;
                } else {
                    object = this.extensionRangeBuilder_;
                    list = DescriptorProtos$DescriptorProto.access$5500(messageLite);
                    ((RepeatedFieldBuilderV3)object).addAllMessages(list);
                }
            }
        }
        if ((object = this.oneofDeclBuilder_) == null) {
            object = DescriptorProtos$DescriptorProto.access$5600(messageLite);
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 == 0) {
                object = this.oneofDecl_;
                n10 = (int)(object.isEmpty() ? 1 : 0);
                if (n10 != 0) {
                    this.oneofDecl_ = object = DescriptorProtos$DescriptorProto.access$5600(messageLite);
                    this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFBF;
                } else {
                    this.ensureOneofDeclIsMutable();
                    object = this.oneofDecl_;
                    list = DescriptorProtos$DescriptorProto.access$5600(messageLite);
                    object.addAll(list);
                }
                this.onChanged();
            }
        } else {
            object = DescriptorProtos$DescriptorProto.access$5600(messageLite);
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 == 0) {
                object = this.oneofDeclBuilder_;
                n10 = (int)(((RepeatedFieldBuilderV3)object).isEmpty() ? 1 : 0);
                if (n10 != 0) {
                    this.oneofDeclBuilder_.dispose();
                    this.oneofDeclBuilder_ = null;
                    this.oneofDecl_ = object = DescriptorProtos$DescriptorProto.access$5600(messageLite);
                    this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFBF;
                    n10 = (int)(GeneratedMessageV3.alwaysUseFieldBuilders ? 1 : 0);
                    if (n10 != 0) {
                        object = this.getOneofDeclFieldBuilder();
                    } else {
                        n10 = 0;
                        object = null;
                    }
                    this.oneofDeclBuilder_ = object;
                } else {
                    object = this.oneofDeclBuilder_;
                    list = DescriptorProtos$DescriptorProto.access$5600(messageLite);
                    ((RepeatedFieldBuilderV3)object).addAllMessages(list);
                }
            }
        }
        if ((n10 = (int)(messageLite.hasOptions() ? 1 : 0)) != 0) {
            object = messageLite.getOptions();
            this.mergeOptions((DescriptorProtos$MessageOptions)object);
        }
        if ((object = this.reservedRangeBuilder_) == null) {
            object = DescriptorProtos$DescriptorProto.access$5800(messageLite);
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 == 0) {
                object = this.reservedRange_;
                n10 = (int)(object.isEmpty() ? 1 : 0);
                if (n10 != 0) {
                    this.reservedRange_ = object = DescriptorProtos$DescriptorProto.access$5800(messageLite);
                    this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFEFF;
                } else {
                    this.ensureReservedRangeIsMutable();
                    object = this.reservedRange_;
                    object2 = DescriptorProtos$DescriptorProto.access$5800(messageLite);
                    object.addAll(object2);
                }
                this.onChanged();
            }
        } else {
            object = DescriptorProtos$DescriptorProto.access$5800(messageLite);
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 == 0) {
                object = this.reservedRangeBuilder_;
                n10 = (int)(((RepeatedFieldBuilderV3)object).isEmpty() ? 1 : 0);
                if (n10 != 0) {
                    this.reservedRangeBuilder_.dispose();
                    this.reservedRangeBuilder_ = null;
                    this.reservedRange_ = object = DescriptorProtos$DescriptorProto.access$5800(messageLite);
                    this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFEFF;
                    n10 = (int)(GeneratedMessageV3.alwaysUseFieldBuilders ? 1 : 0);
                    if (n10 != 0) {
                        object2 = this.getReservedRangeFieldBuilder();
                    }
                    this.reservedRangeBuilder_ = object2;
                } else {
                    object = this.reservedRangeBuilder_;
                    object2 = DescriptorProtos$DescriptorProto.access$5800(messageLite);
                    ((RepeatedFieldBuilderV3)object).addAllMessages((Iterable)object2);
                }
            }
        }
        if ((n10 = (int)((object = DescriptorProtos$DescriptorProto.access$5900(messageLite)).isEmpty() ? 1 : 0)) == 0) {
            object = this.reservedName_;
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 != 0) {
                this.reservedName_ = object = DescriptorProtos$DescriptorProto.access$5900(messageLite);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFDFF;
            } else {
                this.ensureReservedNameIsMutable();
                object = this.reservedName_;
                object2 = DescriptorProtos$DescriptorProto.access$5900(messageLite);
                object.addAll(object2);
            }
            this.onChanged();
        }
        messageLite = messageLite.unknownFields;
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof DescriptorProtos$DescriptorProto;
        if (bl2) {
            message = (DescriptorProtos$DescriptorProto)message;
            return this.mergeFrom((DescriptorProtos$DescriptorProto)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder mergeOptions(DescriptorProtos$MessageOptions descriptorProtos$MessageOptions) {
        int n10;
        Object object = this.optionsBuilder_;
        if (object == null) {
            DescriptorProtos$MessageOptions descriptorProtos$MessageOptions2;
            int n11 = this.bitField0_ & 0x80;
            if (n11 != 0 && (object = this.options_) != null && object != (descriptorProtos$MessageOptions2 = DescriptorProtos$MessageOptions.getDefaultInstance())) {
                object = DescriptorProtos$MessageOptions.newBuilder(this.options_);
                this.options_ = descriptorProtos$MessageOptions = ((DescriptorProtos$MessageOptions$Builder)object).mergeFrom(descriptorProtos$MessageOptions).buildPartial();
            } else {
                this.options_ = descriptorProtos$MessageOptions;
            }
            this.onChanged();
        } else {
            ((SingleFieldBuilderV3)object).mergeFrom(descriptorProtos$MessageOptions);
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x80;
        return this;
    }

    public final DescriptorProtos$DescriptorProto$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$DescriptorProto$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public DescriptorProtos$DescriptorProto$Builder removeEnumType(int n10) {
        Object object = this.enumTypeBuilder_;
        if (object == null) {
            this.ensureEnumTypeIsMutable();
            object = this.enumType_;
            object.remove(n10);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).remove(n10);
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder removeExtension(int n10) {
        Object object = this.extensionBuilder_;
        if (object == null) {
            this.ensureExtensionIsMutable();
            object = this.extension_;
            object.remove(n10);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).remove(n10);
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder removeExtensionRange(int n10) {
        Object object = this.extensionRangeBuilder_;
        if (object == null) {
            this.ensureExtensionRangeIsMutable();
            object = this.extensionRange_;
            object.remove(n10);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).remove(n10);
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder removeField(int n10) {
        Object object = this.fieldBuilder_;
        if (object == null) {
            this.ensureFieldIsMutable();
            object = this.field_;
            object.remove(n10);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).remove(n10);
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder removeNestedType(int n10) {
        Object object = this.nestedTypeBuilder_;
        if (object == null) {
            this.ensureNestedTypeIsMutable();
            object = this.nestedType_;
            object.remove(n10);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).remove(n10);
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder removeOneofDecl(int n10) {
        Object object = this.oneofDeclBuilder_;
        if (object == null) {
            this.ensureOneofDeclIsMutable();
            object = this.oneofDecl_;
            object.remove(n10);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).remove(n10);
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder removeReservedRange(int n10) {
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

    public DescriptorProtos$DescriptorProto$Builder setEnumType(int n10, DescriptorProtos$EnumDescriptorProto$Builder descriptorProtos$EnumDescriptorProtoOrBuilder) {
        Object object = this.enumTypeBuilder_;
        if (object == null) {
            this.ensureEnumTypeIsMutable();
            object = this.enumType_;
            descriptorProtos$EnumDescriptorProtoOrBuilder = ((DescriptorProtos$EnumDescriptorProto$Builder)descriptorProtos$EnumDescriptorProtoOrBuilder).build();
            object.set(n10, descriptorProtos$EnumDescriptorProtoOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$EnumDescriptorProtoOrBuilder = ((DescriptorProtos$EnumDescriptorProto$Builder)descriptorProtos$EnumDescriptorProtoOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).setMessage(n10, (AbstractMessage)((Object)descriptorProtos$EnumDescriptorProtoOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder setEnumType(int n10, DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto) {
        Object object = this.enumTypeBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$EnumDescriptorProto);
            this.ensureEnumTypeIsMutable();
            object = this.enumType_;
            object.set(n10, descriptorProtos$EnumDescriptorProto);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).setMessage(n10, descriptorProtos$EnumDescriptorProto);
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder setExtension(int n10, DescriptorProtos$FieldDescriptorProto$Builder descriptorProtos$FieldDescriptorProtoOrBuilder) {
        Object object = this.extensionBuilder_;
        if (object == null) {
            this.ensureExtensionIsMutable();
            object = this.extension_;
            descriptorProtos$FieldDescriptorProtoOrBuilder = ((DescriptorProtos$FieldDescriptorProto$Builder)descriptorProtos$FieldDescriptorProtoOrBuilder).build();
            object.set(n10, descriptorProtos$FieldDescriptorProtoOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$FieldDescriptorProtoOrBuilder = ((DescriptorProtos$FieldDescriptorProto$Builder)descriptorProtos$FieldDescriptorProtoOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).setMessage(n10, (AbstractMessage)((Object)descriptorProtos$FieldDescriptorProtoOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder setExtension(int n10, DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
        Object object = this.extensionBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$FieldDescriptorProto);
            this.ensureExtensionIsMutable();
            object = this.extension_;
            object.set(n10, descriptorProtos$FieldDescriptorProto);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).setMessage(n10, descriptorProtos$FieldDescriptorProto);
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder setExtensionRange(int n10, DescriptorProtos$DescriptorProto$ExtensionRange$Builder descriptorProtos$DescriptorProto$ExtensionRangeOrBuilder) {
        Object object = this.extensionRangeBuilder_;
        if (object == null) {
            this.ensureExtensionRangeIsMutable();
            object = this.extensionRange_;
            descriptorProtos$DescriptorProto$ExtensionRangeOrBuilder = ((DescriptorProtos$DescriptorProto$ExtensionRange$Builder)descriptorProtos$DescriptorProto$ExtensionRangeOrBuilder).build();
            object.set(n10, descriptorProtos$DescriptorProto$ExtensionRangeOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$DescriptorProto$ExtensionRangeOrBuilder = ((DescriptorProtos$DescriptorProto$ExtensionRange$Builder)descriptorProtos$DescriptorProto$ExtensionRangeOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).setMessage(n10, (AbstractMessage)((Object)descriptorProtos$DescriptorProto$ExtensionRangeOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder setExtensionRange(int n10, DescriptorProtos$DescriptorProto$ExtensionRange descriptorProtos$DescriptorProto$ExtensionRange) {
        Object object = this.extensionRangeBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$DescriptorProto$ExtensionRange);
            this.ensureExtensionRangeIsMutable();
            object = this.extensionRange_;
            object.set(n10, descriptorProtos$DescriptorProto$ExtensionRange);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).setMessage(n10, descriptorProtos$DescriptorProto$ExtensionRange);
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder setField(int n10, DescriptorProtos$FieldDescriptorProto$Builder descriptorProtos$FieldDescriptorProtoOrBuilder) {
        Object object = this.fieldBuilder_;
        if (object == null) {
            this.ensureFieldIsMutable();
            object = this.field_;
            descriptorProtos$FieldDescriptorProtoOrBuilder = ((DescriptorProtos$FieldDescriptorProto$Builder)descriptorProtos$FieldDescriptorProtoOrBuilder).build();
            object.set(n10, descriptorProtos$FieldDescriptorProtoOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$FieldDescriptorProtoOrBuilder = ((DescriptorProtos$FieldDescriptorProto$Builder)descriptorProtos$FieldDescriptorProtoOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).setMessage(n10, (AbstractMessage)((Object)descriptorProtos$FieldDescriptorProtoOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder setField(int n10, DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
        Object object = this.fieldBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$FieldDescriptorProto);
            this.ensureFieldIsMutable();
            object = this.field_;
            object.set(n10, descriptorProtos$FieldDescriptorProto);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).setMessage(n10, descriptorProtos$FieldDescriptorProto);
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$DescriptorProto$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$DescriptorProto$Builder setName(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.name_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder setNameBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.name_ = byteString;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder setNestedType(int n10, DescriptorProtos$DescriptorProto$Builder descriptorProtos$DescriptorProtoOrBuilder) {
        Object object = this.nestedTypeBuilder_;
        if (object == null) {
            this.ensureNestedTypeIsMutable();
            object = this.nestedType_;
            descriptorProtos$DescriptorProtoOrBuilder = ((DescriptorProtos$DescriptorProto$Builder)descriptorProtos$DescriptorProtoOrBuilder).build();
            object.set(n10, descriptorProtos$DescriptorProtoOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$DescriptorProtoOrBuilder = ((DescriptorProtos$DescriptorProto$Builder)descriptorProtos$DescriptorProtoOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).setMessage(n10, (AbstractMessage)((Object)descriptorProtos$DescriptorProtoOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder setNestedType(int n10, DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        Object object = this.nestedTypeBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$DescriptorProto);
            this.ensureNestedTypeIsMutable();
            object = this.nestedType_;
            object.set(n10, descriptorProtos$DescriptorProto);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).setMessage(n10, descriptorProtos$DescriptorProto);
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder setOneofDecl(int n10, DescriptorProtos$OneofDescriptorProto$Builder descriptorProtos$OneofDescriptorProtoOrBuilder) {
        Object object = this.oneofDeclBuilder_;
        if (object == null) {
            this.ensureOneofDeclIsMutable();
            object = this.oneofDecl_;
            descriptorProtos$OneofDescriptorProtoOrBuilder = ((DescriptorProtos$OneofDescriptorProto$Builder)descriptorProtos$OneofDescriptorProtoOrBuilder).build();
            object.set(n10, descriptorProtos$OneofDescriptorProtoOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$OneofDescriptorProtoOrBuilder = ((DescriptorProtos$OneofDescriptorProto$Builder)descriptorProtos$OneofDescriptorProtoOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).setMessage(n10, (AbstractMessage)((Object)descriptorProtos$OneofDescriptorProtoOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder setOneofDecl(int n10, DescriptorProtos$OneofDescriptorProto descriptorProtos$OneofDescriptorProto) {
        Object object = this.oneofDeclBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$OneofDescriptorProto);
            this.ensureOneofDeclIsMutable();
            object = this.oneofDecl_;
            object.set(n10, descriptorProtos$OneofDescriptorProto);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).setMessage(n10, descriptorProtos$OneofDescriptorProto);
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder setOptions(DescriptorProtos$MessageOptions$Builder descriptorProtos$MessageOptionsOrBuilder) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.optionsBuilder_;
        if (singleFieldBuilderV3 == null) {
            descriptorProtos$MessageOptionsOrBuilder = descriptorProtos$MessageOptionsOrBuilder.build();
            this.options_ = descriptorProtos$MessageOptionsOrBuilder;
            this.onChanged();
        } else {
            descriptorProtos$MessageOptionsOrBuilder = descriptorProtos$MessageOptionsOrBuilder.build();
            singleFieldBuilderV3.setMessage((AbstractMessage)((Object)descriptorProtos$MessageOptionsOrBuilder));
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x80;
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder setOptions(DescriptorProtos$MessageOptions descriptorProtos$MessageOptions) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.optionsBuilder_;
        if (singleFieldBuilderV3 == null) {
            Objects.requireNonNull(descriptorProtos$MessageOptions);
            this.options_ = descriptorProtos$MessageOptions;
            this.onChanged();
        } else {
            singleFieldBuilderV3.setMessage(descriptorProtos$MessageOptions);
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x80;
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (DescriptorProtos$DescriptorProto$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public DescriptorProtos$DescriptorProto$Builder setReservedName(int n10, String string2) {
        Objects.requireNonNull(string2);
        this.ensureReservedNameIsMutable();
        this.reservedName_.set(n10, string2);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder setReservedRange(int n10, DescriptorProtos$DescriptorProto$ReservedRange$Builder descriptorProtos$DescriptorProto$ReservedRangeOrBuilder) {
        Object object = this.reservedRangeBuilder_;
        if (object == null) {
            this.ensureReservedRangeIsMutable();
            object = this.reservedRange_;
            descriptorProtos$DescriptorProto$ReservedRangeOrBuilder = ((DescriptorProtos$DescriptorProto$ReservedRange$Builder)descriptorProtos$DescriptorProto$ReservedRangeOrBuilder).build();
            object.set(n10, descriptorProtos$DescriptorProto$ReservedRangeOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$DescriptorProto$ReservedRangeOrBuilder = ((DescriptorProtos$DescriptorProto$ReservedRange$Builder)descriptorProtos$DescriptorProto$ReservedRangeOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).setMessage(n10, (AbstractMessage)((Object)descriptorProtos$DescriptorProto$ReservedRangeOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder setReservedRange(int n10, DescriptorProtos$DescriptorProto$ReservedRange descriptorProtos$DescriptorProto$ReservedRange) {
        Object object = this.reservedRangeBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$DescriptorProto$ReservedRange);
            this.ensureReservedRangeIsMutable();
            object = this.reservedRange_;
            object.set(n10, descriptorProtos$DescriptorProto$ReservedRange);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).setMessage(n10, descriptorProtos$DescriptorProto$ReservedRange);
        }
        return this;
    }

    public final DescriptorProtos$DescriptorProto$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$DescriptorProto$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

