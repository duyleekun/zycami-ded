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
import com.google.protobuf.DescriptorProtos$DescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$FileDescriptorProto;
import com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$FileOptions;
import com.google.protobuf.DescriptorProtos$FileOptions$Builder;
import com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder;
import com.google.protobuf.DescriptorProtos$ServiceDescriptorProto;
import com.google.protobuf.DescriptorProtos$ServiceDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo$Builder;
import com.google.protobuf.DescriptorProtos$SourceCodeInfoOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.Internal$IntList;
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

public final class DescriptorProtos$FileDescriptorProto$Builder
extends GeneratedMessageV3$Builder
implements DescriptorProtos$FileDescriptorProtoOrBuilder {
    private int bitField0_;
    private LazyStringList dependency_;
    private RepeatedFieldBuilderV3 enumTypeBuilder_;
    private List enumType_;
    private RepeatedFieldBuilderV3 extensionBuilder_;
    private List extension_;
    private RepeatedFieldBuilderV3 messageTypeBuilder_;
    private List messageType_;
    private Object name_;
    private SingleFieldBuilderV3 optionsBuilder_;
    private DescriptorProtos$FileOptions options_;
    private Object package_;
    private Internal$IntList publicDependency_;
    private RepeatedFieldBuilderV3 serviceBuilder_;
    private List service_;
    private SingleFieldBuilderV3 sourceCodeInfoBuilder_;
    private DescriptorProtos$SourceCodeInfo sourceCodeInfo_;
    private Object syntax_;
    private Internal$IntList weakDependency_;

    private DescriptorProtos$FileDescriptorProto$Builder() {
        List list;
        String string2 = "";
        this.name_ = string2;
        this.package_ = string2;
        this.dependency_ = list = LazyStringArrayList.EMPTY;
        list = GeneratedMessageV3.emptyIntList();
        this.publicDependency_ = list;
        list = GeneratedMessageV3.emptyIntList();
        this.weakDependency_ = list;
        list = Collections.emptyList();
        this.messageType_ = list;
        list = Collections.emptyList();
        this.enumType_ = list;
        list = Collections.emptyList();
        this.service_ = list;
        list = Collections.emptyList();
        this.extension_ = list;
        this.syntax_ = string2;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$FileDescriptorProto$Builder(DescriptorProtos$1 descriptorProtos$1) {
        this();
    }

    private DescriptorProtos$FileDescriptorProto$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        List list;
        this.name_ = object = "";
        this.package_ = object;
        this.dependency_ = list = LazyStringArrayList.EMPTY;
        list = GeneratedMessageV3.emptyIntList();
        this.publicDependency_ = list;
        list = GeneratedMessageV3.emptyIntList();
        this.weakDependency_ = list;
        list = Collections.emptyList();
        this.messageType_ = list;
        list = Collections.emptyList();
        this.enumType_ = list;
        list = Collections.emptyList();
        this.service_ = list;
        list = Collections.emptyList();
        this.extension_ = list;
        this.syntax_ = object;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$FileDescriptorProto$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$BuilderParent);
    }

    private void ensureDependencyIsMutable() {
        int n10 = this.bitField0_ & 4;
        if (n10 == 0) {
            LazyStringList lazyStringList = this.dependency_;
            LazyStringArrayList lazyStringArrayList = new LazyStringArrayList(lazyStringList);
            this.dependency_ = lazyStringArrayList;
            this.bitField0_ = n10 = this.bitField0_ | 4;
        }
    }

    private void ensureEnumTypeIsMutable() {
        int n10 = this.bitField0_ & 0x40;
        if (n10 == 0) {
            ArrayList arrayList;
            List list = this.enumType_;
            this.enumType_ = arrayList = new ArrayList(list);
            this.bitField0_ = n10 = this.bitField0_ | 0x40;
        }
    }

    private void ensureExtensionIsMutable() {
        int n10 = this.bitField0_ & 0x100;
        if (n10 == 0) {
            ArrayList arrayList;
            List list = this.extension_;
            this.extension_ = arrayList = new ArrayList(list);
            this.bitField0_ = n10 = this.bitField0_ | 0x100;
        }
    }

    private void ensureMessageTypeIsMutable() {
        int n10 = this.bitField0_ & 0x20;
        if (n10 == 0) {
            ArrayList arrayList;
            List list = this.messageType_;
            this.messageType_ = arrayList = new ArrayList(list);
            this.bitField0_ = n10 = this.bitField0_ | 0x20;
        }
    }

    private void ensurePublicDependencyIsMutable() {
        int n10 = this.bitField0_ & 8;
        if (n10 == 0) {
            Internal$IntList internal$IntList;
            this.publicDependency_ = internal$IntList = GeneratedMessageV3.mutableCopy(this.publicDependency_);
            this.bitField0_ = n10 = this.bitField0_ | 8;
        }
    }

    private void ensureServiceIsMutable() {
        int n10 = this.bitField0_ & 0x80;
        if (n10 == 0) {
            ArrayList arrayList;
            List list = this.service_;
            this.service_ = arrayList = new ArrayList(list);
            this.bitField0_ = n10 = this.bitField0_ | 0x80;
        }
    }

    private void ensureWeakDependencyIsMutable() {
        int n10 = this.bitField0_ & 0x10;
        if (n10 == 0) {
            Internal$IntList internal$IntList;
            this.weakDependency_ = internal$IntList = GeneratedMessageV3.mutableCopy(this.weakDependency_);
            this.bitField0_ = n10 = this.bitField0_ | 0x10;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$700();
    }

    private RepeatedFieldBuilderV3 getEnumTypeFieldBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.enumTypeBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            List list = this.enumType_;
            int n10 = this.bitField0_ & 0x40;
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
            int n10 = this.bitField0_ & 0x100;
            n10 = n10 != 0 ? 1 : 0;
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.extensionBuilder_ = repeatedFieldBuilderV3 = new RepeatedFieldBuilderV3(list, n10 != 0, generatedMessageV3$BuilderParent, bl2);
            repeatedFieldBuilderV3 = null;
            this.extension_ = null;
        }
        return this.extensionBuilder_;
    }

    private RepeatedFieldBuilderV3 getMessageTypeFieldBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.messageTypeBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            List list = this.messageType_;
            int n10 = this.bitField0_ & 0x20;
            n10 = n10 != 0 ? 1 : 0;
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.messageTypeBuilder_ = repeatedFieldBuilderV3 = new RepeatedFieldBuilderV3(list, n10 != 0, generatedMessageV3$BuilderParent, bl2);
            repeatedFieldBuilderV3 = null;
            this.messageType_ = null;
        }
        return this.messageTypeBuilder_;
    }

    private SingleFieldBuilderV3 getOptionsFieldBuilder() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.optionsBuilder_;
        if (singleFieldBuilderV3 == null) {
            DescriptorProtos$FileOptions descriptorProtos$FileOptions = this.getOptions();
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.optionsBuilder_ = singleFieldBuilderV3 = new SingleFieldBuilderV3(descriptorProtos$FileOptions, generatedMessageV3$BuilderParent, bl2);
            singleFieldBuilderV3 = null;
            this.options_ = null;
        }
        return this.optionsBuilder_;
    }

    private RepeatedFieldBuilderV3 getServiceFieldBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.serviceBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            List list = this.service_;
            int n10 = this.bitField0_ & 0x80;
            n10 = n10 != 0 ? 1 : 0;
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.serviceBuilder_ = repeatedFieldBuilderV3 = new RepeatedFieldBuilderV3(list, n10 != 0, generatedMessageV3$BuilderParent, bl2);
            repeatedFieldBuilderV3 = null;
            this.service_ = null;
        }
        return this.serviceBuilder_;
    }

    private SingleFieldBuilderV3 getSourceCodeInfoFieldBuilder() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.sourceCodeInfoBuilder_;
        if (singleFieldBuilderV3 == null) {
            DescriptorProtos$SourceCodeInfo descriptorProtos$SourceCodeInfo = this.getSourceCodeInfo();
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.sourceCodeInfoBuilder_ = singleFieldBuilderV3 = new SingleFieldBuilderV3(descriptorProtos$SourceCodeInfo, generatedMessageV3$BuilderParent, bl2);
            singleFieldBuilderV3 = null;
            this.sourceCodeInfo_ = null;
        }
        return this.sourceCodeInfoBuilder_;
    }

    private void maybeForceBuilderInitialization() {
        boolean bl2 = GeneratedMessageV3.alwaysUseFieldBuilders;
        if (bl2) {
            this.getMessageTypeFieldBuilder();
            this.getEnumTypeFieldBuilder();
            this.getServiceFieldBuilder();
            this.getExtensionFieldBuilder();
            this.getOptionsFieldBuilder();
            this.getSourceCodeInfoFieldBuilder();
        }
    }

    public DescriptorProtos$FileDescriptorProto$Builder addAllDependency(Iterable iterable) {
        this.ensureDependencyIsMutable();
        LazyStringList lazyStringList = this.dependency_;
        AbstractMessageLite$Builder.addAll(iterable, lazyStringList);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder addAllEnumType(Iterable iterable) {
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

    public DescriptorProtos$FileDescriptorProto$Builder addAllExtension(Iterable iterable) {
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

    public DescriptorProtos$FileDescriptorProto$Builder addAllMessageType(Iterable iterable) {
        Object object = this.messageTypeBuilder_;
        if (object == null) {
            this.ensureMessageTypeIsMutable();
            object = this.messageType_;
            AbstractMessageLite$Builder.addAll(iterable, (List)object);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addAllMessages(iterable);
        }
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder addAllPublicDependency(Iterable iterable) {
        this.ensurePublicDependencyIsMutable();
        Internal$IntList internal$IntList = this.publicDependency_;
        AbstractMessageLite$Builder.addAll(iterable, internal$IntList);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder addAllService(Iterable iterable) {
        Object object = this.serviceBuilder_;
        if (object == null) {
            this.ensureServiceIsMutable();
            object = this.service_;
            AbstractMessageLite$Builder.addAll(iterable, (List)object);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addAllMessages(iterable);
        }
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder addAllWeakDependency(Iterable iterable) {
        this.ensureWeakDependencyIsMutable();
        Internal$IntList internal$IntList = this.weakDependency_;
        AbstractMessageLite$Builder.addAll(iterable, internal$IntList);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder addDependency(String string2) {
        Objects.requireNonNull(string2);
        this.ensureDependencyIsMutable();
        this.dependency_.add(string2);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder addDependencyBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        this.ensureDependencyIsMutable();
        this.dependency_.add(byteString);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder addEnumType(int n10, DescriptorProtos$EnumDescriptorProto$Builder descriptorProtos$EnumDescriptorProtoOrBuilder) {
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

    public DescriptorProtos$FileDescriptorProto$Builder addEnumType(int n10, DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto) {
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

    public DescriptorProtos$FileDescriptorProto$Builder addEnumType(DescriptorProtos$EnumDescriptorProto$Builder descriptorProtos$EnumDescriptorProtoOrBuilder) {
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

    public DescriptorProtos$FileDescriptorProto$Builder addEnumType(DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto) {
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

    public DescriptorProtos$FileDescriptorProto$Builder addExtension(int n10, DescriptorProtos$FieldDescriptorProto$Builder descriptorProtos$FieldDescriptorProtoOrBuilder) {
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

    public DescriptorProtos$FileDescriptorProto$Builder addExtension(int n10, DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
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

    public DescriptorProtos$FileDescriptorProto$Builder addExtension(DescriptorProtos$FieldDescriptorProto$Builder descriptorProtos$FieldDescriptorProtoOrBuilder) {
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

    public DescriptorProtos$FileDescriptorProto$Builder addExtension(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
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

    public DescriptorProtos$FileDescriptorProto$Builder addMessageType(int n10, DescriptorProtos$DescriptorProto$Builder descriptorProtos$DescriptorProtoOrBuilder) {
        Object object = this.messageTypeBuilder_;
        if (object == null) {
            this.ensureMessageTypeIsMutable();
            object = this.messageType_;
            descriptorProtos$DescriptorProtoOrBuilder = ((DescriptorProtos$DescriptorProto$Builder)descriptorProtos$DescriptorProtoOrBuilder).build();
            object.add(n10, descriptorProtos$DescriptorProtoOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$DescriptorProtoOrBuilder = ((DescriptorProtos$DescriptorProto$Builder)descriptorProtos$DescriptorProtoOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage(n10, (AbstractMessage)((Object)descriptorProtos$DescriptorProtoOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder addMessageType(int n10, DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        Object object = this.messageTypeBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$DescriptorProto);
            this.ensureMessageTypeIsMutable();
            object = this.messageType_;
            object.add(n10, descriptorProtos$DescriptorProto);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(n10, descriptorProtos$DescriptorProto);
        }
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder addMessageType(DescriptorProtos$DescriptorProto$Builder descriptorProtos$DescriptorProtoOrBuilder) {
        Object object = this.messageTypeBuilder_;
        if (object == null) {
            this.ensureMessageTypeIsMutable();
            object = this.messageType_;
            descriptorProtos$DescriptorProtoOrBuilder = ((DescriptorProtos$DescriptorProto$Builder)descriptorProtos$DescriptorProtoOrBuilder).build();
            object.add(descriptorProtos$DescriptorProtoOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$DescriptorProtoOrBuilder = ((DescriptorProtos$DescriptorProto$Builder)descriptorProtos$DescriptorProtoOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage((AbstractMessage)((Object)descriptorProtos$DescriptorProtoOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder addMessageType(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        Object object = this.messageTypeBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$DescriptorProto);
            this.ensureMessageTypeIsMutable();
            object = this.messageType_;
            object.add(descriptorProtos$DescriptorProto);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(descriptorProtos$DescriptorProto);
        }
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addMessageTypeBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getMessageTypeFieldBuilder();
        DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto = DescriptorProtos$DescriptorProto.getDefaultInstance();
        return (DescriptorProtos$DescriptorProto$Builder)repeatedFieldBuilderV3.addBuilder(descriptorProtos$DescriptorProto);
    }

    public DescriptorProtos$DescriptorProto$Builder addMessageTypeBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getMessageTypeFieldBuilder();
        DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto = DescriptorProtos$DescriptorProto.getDefaultInstance();
        return (DescriptorProtos$DescriptorProto$Builder)repeatedFieldBuilderV3.addBuilder(n10, descriptorProtos$DescriptorProto);
    }

    public DescriptorProtos$FileDescriptorProto$Builder addPublicDependency(int n10) {
        this.ensurePublicDependencyIsMutable();
        this.publicDependency_.addInt(n10);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$FileDescriptorProto$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$FileDescriptorProto$Builder addService(int n10, DescriptorProtos$ServiceDescriptorProto$Builder descriptorProtos$ServiceDescriptorProtoOrBuilder) {
        Object object = this.serviceBuilder_;
        if (object == null) {
            this.ensureServiceIsMutable();
            object = this.service_;
            descriptorProtos$ServiceDescriptorProtoOrBuilder = ((DescriptorProtos$ServiceDescriptorProto$Builder)descriptorProtos$ServiceDescriptorProtoOrBuilder).build();
            object.add(n10, descriptorProtos$ServiceDescriptorProtoOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$ServiceDescriptorProtoOrBuilder = ((DescriptorProtos$ServiceDescriptorProto$Builder)descriptorProtos$ServiceDescriptorProtoOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage(n10, (AbstractMessage)((Object)descriptorProtos$ServiceDescriptorProtoOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder addService(int n10, DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto) {
        Object object = this.serviceBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$ServiceDescriptorProto);
            this.ensureServiceIsMutable();
            object = this.service_;
            object.add(n10, descriptorProtos$ServiceDescriptorProto);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(n10, descriptorProtos$ServiceDescriptorProto);
        }
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder addService(DescriptorProtos$ServiceDescriptorProto$Builder descriptorProtos$ServiceDescriptorProtoOrBuilder) {
        Object object = this.serviceBuilder_;
        if (object == null) {
            this.ensureServiceIsMutable();
            object = this.service_;
            descriptorProtos$ServiceDescriptorProtoOrBuilder = ((DescriptorProtos$ServiceDescriptorProto$Builder)descriptorProtos$ServiceDescriptorProtoOrBuilder).build();
            object.add(descriptorProtos$ServiceDescriptorProtoOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$ServiceDescriptorProtoOrBuilder = ((DescriptorProtos$ServiceDescriptorProto$Builder)descriptorProtos$ServiceDescriptorProtoOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage((AbstractMessage)((Object)descriptorProtos$ServiceDescriptorProtoOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder addService(DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto) {
        Object object = this.serviceBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$ServiceDescriptorProto);
            this.ensureServiceIsMutable();
            object = this.service_;
            object.add(descriptorProtos$ServiceDescriptorProto);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(descriptorProtos$ServiceDescriptorProto);
        }
        return this;
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder addServiceBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getServiceFieldBuilder();
        DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto = DescriptorProtos$ServiceDescriptorProto.getDefaultInstance();
        return (DescriptorProtos$ServiceDescriptorProto$Builder)repeatedFieldBuilderV3.addBuilder(descriptorProtos$ServiceDescriptorProto);
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder addServiceBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getServiceFieldBuilder();
        DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto = DescriptorProtos$ServiceDescriptorProto.getDefaultInstance();
        return (DescriptorProtos$ServiceDescriptorProto$Builder)repeatedFieldBuilderV3.addBuilder(n10, descriptorProtos$ServiceDescriptorProto);
    }

    public DescriptorProtos$FileDescriptorProto$Builder addWeakDependency(int n10) {
        this.ensureWeakDependencyIsMutable();
        this.weakDependency_.addInt(n10);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto build() {
        DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto = this.buildPartial();
        boolean bl2 = descriptorProtos$FileDescriptorProto.isInitialized();
        if (bl2) {
            return descriptorProtos$FileDescriptorProto;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(descriptorProtos$FileDescriptorProto);
    }

    public DescriptorProtos$FileDescriptorProto buildPartial() {
        Object object = null;
        DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto = new DescriptorProtos$FileDescriptorProto(this, null);
        int n10 = this.bitField0_;
        int n11 = n10 & 1;
        n11 = n11 != 0 ? 1 : 0;
        Object object2 = this.name_;
        DescriptorProtos$FileDescriptorProto.access$1202(descriptorProtos$FileDescriptorProto, object2);
        int n12 = n10 & 2;
        if (n12 != 0) {
            n11 |= 2;
        }
        object2 = this.package_;
        DescriptorProtos$FileDescriptorProto.access$1302(descriptorProtos$FileDescriptorProto, object2);
        n12 = this.bitField0_ & 4;
        if (n12 != 0) {
            this.dependency_ = object2 = this.dependency_.getUnmodifiableView();
            this.bitField0_ = n12 = this.bitField0_ & 0xFFFFFFFB;
        }
        object2 = this.dependency_;
        DescriptorProtos$FileDescriptorProto.access$1402(descriptorProtos$FileDescriptorProto, (LazyStringList)object2);
        n12 = this.bitField0_ & 8;
        if (n12 != 0) {
            object2 = this.publicDependency_;
            object2.makeImmutable();
            this.bitField0_ = n12 = this.bitField0_ & 0xFFFFFFF7;
        }
        object2 = this.publicDependency_;
        DescriptorProtos$FileDescriptorProto.access$1502(descriptorProtos$FileDescriptorProto, (Internal$IntList)object2);
        n12 = this.bitField0_ & 0x10;
        if (n12 != 0) {
            object2 = this.weakDependency_;
            object2.makeImmutable();
            this.bitField0_ = n12 = this.bitField0_ & 0xFFFFFFEF;
        }
        object2 = this.weakDependency_;
        DescriptorProtos$FileDescriptorProto.access$1602(descriptorProtos$FileDescriptorProto, (Internal$IntList)object2);
        object2 = this.messageTypeBuilder_;
        if (object2 == null) {
            n12 = this.bitField0_ & 0x20;
            if (n12 != 0) {
                object2 = Collections.unmodifiableList(this.messageType_);
                this.messageType_ = object2;
                this.bitField0_ = n12 = this.bitField0_ & 0xFFFFFFDF;
            }
            object2 = this.messageType_;
            DescriptorProtos$FileDescriptorProto.access$1702(descriptorProtos$FileDescriptorProto, object2);
        } else {
            object2 = ((RepeatedFieldBuilderV3)object2).build();
            DescriptorProtos$FileDescriptorProto.access$1702(descriptorProtos$FileDescriptorProto, (List)object2);
        }
        object2 = this.enumTypeBuilder_;
        if (object2 == null) {
            n12 = this.bitField0_ & 0x40;
            if (n12 != 0) {
                object2 = Collections.unmodifiableList(this.enumType_);
                this.enumType_ = object2;
                this.bitField0_ = n12 = this.bitField0_ & 0xFFFFFFBF;
            }
            object2 = this.enumType_;
            DescriptorProtos$FileDescriptorProto.access$1802(descriptorProtos$FileDescriptorProto, object2);
        } else {
            object2 = ((RepeatedFieldBuilderV3)object2).build();
            DescriptorProtos$FileDescriptorProto.access$1802(descriptorProtos$FileDescriptorProto, (List)object2);
        }
        object2 = this.serviceBuilder_;
        if (object2 == null) {
            n12 = this.bitField0_ & 0x80;
            if (n12 != 0) {
                object2 = Collections.unmodifiableList(this.service_);
                this.service_ = object2;
                this.bitField0_ = n12 = this.bitField0_ & 0xFFFFFF7F;
            }
            object2 = this.service_;
            DescriptorProtos$FileDescriptorProto.access$1902(descriptorProtos$FileDescriptorProto, object2);
        } else {
            object2 = ((RepeatedFieldBuilderV3)object2).build();
            DescriptorProtos$FileDescriptorProto.access$1902(descriptorProtos$FileDescriptorProto, (List)object2);
        }
        object2 = this.extensionBuilder_;
        if (object2 == null) {
            n12 = this.bitField0_ & 0x100;
            if (n12 != 0) {
                object2 = Collections.unmodifiableList(this.extension_);
                this.extension_ = object2;
                this.bitField0_ = n12 = this.bitField0_ & 0xFFFFFEFF;
            }
            object2 = this.extension_;
            DescriptorProtos$FileDescriptorProto.access$2002(descriptorProtos$FileDescriptorProto, object2);
        } else {
            object2 = ((RepeatedFieldBuilderV3)object2).build();
            DescriptorProtos$FileDescriptorProto.access$2002(descriptorProtos$FileDescriptorProto, (List)object2);
        }
        n12 = n10 & 0x200;
        if (n12 != 0) {
            object2 = this.optionsBuilder_;
            if (object2 == null) {
                object2 = this.options_;
                DescriptorProtos$FileDescriptorProto.access$2102(descriptorProtos$FileDescriptorProto, (DescriptorProtos$FileOptions)object2);
            } else {
                object2 = (DescriptorProtos$FileOptions)((SingleFieldBuilderV3)object2).build();
                DescriptorProtos$FileDescriptorProto.access$2102(descriptorProtos$FileDescriptorProto, (DescriptorProtos$FileOptions)object2);
            }
            n11 |= 4;
        }
        if ((n12 = n10 & 0x400) != 0) {
            object2 = this.sourceCodeInfoBuilder_;
            if (object2 == null) {
                object2 = this.sourceCodeInfo_;
                DescriptorProtos$FileDescriptorProto.access$2202(descriptorProtos$FileDescriptorProto, (DescriptorProtos$SourceCodeInfo)object2);
            } else {
                object2 = (DescriptorProtos$SourceCodeInfo)((SingleFieldBuilderV3)object2).build();
                DescriptorProtos$FileDescriptorProto.access$2202(descriptorProtos$FileDescriptorProto, (DescriptorProtos$SourceCodeInfo)object2);
            }
            n11 |= 8;
        }
        if ((n10 &= 0x800) != 0) {
            n11 |= 0x10;
        }
        object = this.syntax_;
        DescriptorProtos$FileDescriptorProto.access$2302(descriptorProtos$FileDescriptorProto, object);
        DescriptorProtos$FileDescriptorProto.access$2402(descriptorProtos$FileDescriptorProto, n11);
        this.onBuilt();
        return descriptorProtos$FileDescriptorProto;
    }

    public DescriptorProtos$FileDescriptorProto$Builder clear() {
        int n10;
        LazyStringList lazyStringList;
        int n11;
        super.clear();
        String string2 = "";
        this.name_ = string2;
        this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
        this.package_ = string2;
        this.bitField0_ = n11 &= 0xFFFFFFFD;
        this.dependency_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n11 &= 0xFFFFFFFB;
        Object object = GeneratedMessageV3.emptyIntList();
        this.publicDependency_ = object;
        this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFF7;
        object = GeneratedMessageV3.emptyIntList();
        this.weakDependency_ = object;
        this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFEF;
        object = this.messageTypeBuilder_;
        if (object == null) {
            object = Collections.emptyList();
            this.messageType_ = object;
            this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFDF;
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        object = this.enumTypeBuilder_;
        if (object == null) {
            object = Collections.emptyList();
            this.enumType_ = object;
            this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFBF;
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        object = this.serviceBuilder_;
        if (object == null) {
            object = Collections.emptyList();
            this.service_ = object;
            this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFF7F;
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        object = this.extensionBuilder_;
        if (object == null) {
            object = Collections.emptyList();
            this.extension_ = object;
            this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFEFF;
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        object = this.optionsBuilder_;
        lazyStringList = null;
        if (object == null) {
            this.options_ = null;
        } else {
            ((SingleFieldBuilderV3)object).clear();
        }
        this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFDFF;
        object = this.sourceCodeInfoBuilder_;
        if (object == null) {
            this.sourceCodeInfo_ = null;
        } else {
            ((SingleFieldBuilderV3)object).clear();
        }
        this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFBFF;
        this.syntax_ = string2;
        this.bitField0_ = n10 = n11 & 0xFFFFF7FF;
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder clearDependency() {
        int n10;
        LazyStringList lazyStringList;
        this.dependency_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder clearEnumType() {
        Object object = this.enumTypeBuilder_;
        if (object == null) {
            int n10;
            this.enumType_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFBF;
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder clearExtension() {
        Object object = this.extensionBuilder_;
        if (object == null) {
            int n10;
            this.extension_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFEFF;
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (DescriptorProtos$FileDescriptorProto$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public DescriptorProtos$FileDescriptorProto$Builder clearMessageType() {
        Object object = this.messageTypeBuilder_;
        if (object == null) {
            int n10;
            this.messageType_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFDF;
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder clearName() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        String string2 = DescriptorProtos$FileDescriptorProto.getDefaultInstance().getName();
        this.name_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (DescriptorProtos$FileDescriptorProto$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public DescriptorProtos$FileDescriptorProto$Builder clearOptions() {
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
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFDFF;
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder clearPackage() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        String string2 = DescriptorProtos$FileDescriptorProto.getDefaultInstance().getPackage();
        this.package_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder clearPublicDependency() {
        int n10;
        Internal$IntList internal$IntList;
        this.publicDependency_ = internal$IntList = GeneratedMessageV3.emptyIntList();
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder clearService() {
        Object object = this.serviceBuilder_;
        if (object == null) {
            int n10;
            this.service_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFF7F;
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder clearSourceCodeInfo() {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.sourceCodeInfoBuilder_;
        if (singleFieldBuilderV3 == null) {
            n10 = 0;
            singleFieldBuilderV3 = null;
            this.sourceCodeInfo_ = null;
            this.onChanged();
        } else {
            singleFieldBuilderV3.clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFBFF;
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder clearSyntax() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFF7FF;
        String string2 = DescriptorProtos$FileDescriptorProto.getDefaultInstance().getSyntax();
        this.syntax_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder clearWeakDependency() {
        int n10;
        Internal$IntList internal$IntList;
        this.weakDependency_ = internal$IntList = GeneratedMessageV3.emptyIntList();
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFEF;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder clone() {
        return (DescriptorProtos$FileDescriptorProto$Builder)super.clone();
    }

    public DescriptorProtos$FileDescriptorProto getDefaultInstanceForType() {
        return DescriptorProtos$FileDescriptorProto.getDefaultInstance();
    }

    public String getDependency(int n10) {
        return (String)this.dependency_.get(n10);
    }

    public ByteString getDependencyBytes(int n10) {
        return this.dependency_.getByteString(n10);
    }

    public int getDependencyCount() {
        return this.dependency_.size();
    }

    public ProtocolStringList getDependencyList() {
        return this.dependency_.getUnmodifiableView();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.access$700();
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

    public DescriptorProtos$DescriptorProto getMessageType(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.messageTypeBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (DescriptorProtos$DescriptorProto)this.messageType_.get(n10);
        }
        return (DescriptorProtos$DescriptorProto)repeatedFieldBuilderV3.getMessage(n10);
    }

    public DescriptorProtos$DescriptorProto$Builder getMessageTypeBuilder(int n10) {
        return (DescriptorProtos$DescriptorProto$Builder)this.getMessageTypeFieldBuilder().getBuilder(n10);
    }

    public List getMessageTypeBuilderList() {
        return this.getMessageTypeFieldBuilder().getBuilderList();
    }

    public int getMessageTypeCount() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.messageTypeBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return this.messageType_.size();
        }
        return repeatedFieldBuilderV3.getCount();
    }

    public List getMessageTypeList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.messageTypeBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return Collections.unmodifiableList(this.messageType_);
        }
        return repeatedFieldBuilderV3.getMessageList();
    }

    public DescriptorProtos$DescriptorProtoOrBuilder getMessageTypeOrBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.messageTypeBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (DescriptorProtos$DescriptorProtoOrBuilder)this.messageType_.get(n10);
        }
        return (DescriptorProtos$DescriptorProtoOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(n10);
    }

    public List getMessageTypeOrBuilderList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.messageTypeBuilder_;
        if (repeatedFieldBuilderV3 != null) {
            return repeatedFieldBuilderV3.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(this.messageType_);
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

    public DescriptorProtos$FileOptions getOptions() {
        Object object = this.optionsBuilder_;
        if (object == null) {
            object = this.options_;
            if (object == null) {
                object = DescriptorProtos$FileOptions.getDefaultInstance();
            }
            return object;
        }
        return (DescriptorProtos$FileOptions)((SingleFieldBuilderV3)object).getMessage();
    }

    public DescriptorProtos$FileOptions$Builder getOptionsBuilder() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x200;
        this.onChanged();
        return (DescriptorProtos$FileOptions$Builder)this.getOptionsFieldBuilder().getBuilder();
    }

    public DescriptorProtos$FileOptionsOrBuilder getOptionsOrBuilder() {
        Object object = this.optionsBuilder_;
        if (object != null) {
            return (DescriptorProtos$FileOptionsOrBuilder)((SingleFieldBuilderV3)object).getMessageOrBuilder();
        }
        object = this.options_;
        if (object == null) {
            object = DescriptorProtos$FileOptions.getDefaultInstance();
        }
        return object;
    }

    public String getPackage() {
        Object object = this.package_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.package_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getPackageBytes() {
        Object object = this.package_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.package_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public int getPublicDependency(int n10) {
        return this.publicDependency_.getInt(n10);
    }

    public int getPublicDependencyCount() {
        return this.publicDependency_.size();
    }

    public List getPublicDependencyList() {
        int n10 = this.bitField0_ & 8;
        List list = n10 != 0 ? Collections.unmodifiableList(this.publicDependency_) : this.publicDependency_;
        return list;
    }

    public DescriptorProtos$ServiceDescriptorProto getService(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.serviceBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (DescriptorProtos$ServiceDescriptorProto)this.service_.get(n10);
        }
        return (DescriptorProtos$ServiceDescriptorProto)repeatedFieldBuilderV3.getMessage(n10);
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder getServiceBuilder(int n10) {
        return (DescriptorProtos$ServiceDescriptorProto$Builder)this.getServiceFieldBuilder().getBuilder(n10);
    }

    public List getServiceBuilderList() {
        return this.getServiceFieldBuilder().getBuilderList();
    }

    public int getServiceCount() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.serviceBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return this.service_.size();
        }
        return repeatedFieldBuilderV3.getCount();
    }

    public List getServiceList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.serviceBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return Collections.unmodifiableList(this.service_);
        }
        return repeatedFieldBuilderV3.getMessageList();
    }

    public DescriptorProtos$ServiceDescriptorProtoOrBuilder getServiceOrBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.serviceBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (DescriptorProtos$ServiceDescriptorProtoOrBuilder)this.service_.get(n10);
        }
        return (DescriptorProtos$ServiceDescriptorProtoOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(n10);
    }

    public List getServiceOrBuilderList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.serviceBuilder_;
        if (repeatedFieldBuilderV3 != null) {
            return repeatedFieldBuilderV3.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(this.service_);
    }

    public DescriptorProtos$SourceCodeInfo getSourceCodeInfo() {
        Object object = this.sourceCodeInfoBuilder_;
        if (object == null) {
            object = this.sourceCodeInfo_;
            if (object == null) {
                object = DescriptorProtos$SourceCodeInfo.getDefaultInstance();
            }
            return object;
        }
        return (DescriptorProtos$SourceCodeInfo)((SingleFieldBuilderV3)object).getMessage();
    }

    public DescriptorProtos$SourceCodeInfo$Builder getSourceCodeInfoBuilder() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x400;
        this.onChanged();
        return (DescriptorProtos$SourceCodeInfo$Builder)this.getSourceCodeInfoFieldBuilder().getBuilder();
    }

    public DescriptorProtos$SourceCodeInfoOrBuilder getSourceCodeInfoOrBuilder() {
        Object object = this.sourceCodeInfoBuilder_;
        if (object != null) {
            return (DescriptorProtos$SourceCodeInfoOrBuilder)((SingleFieldBuilderV3)object).getMessageOrBuilder();
        }
        object = this.sourceCodeInfo_;
        if (object == null) {
            object = DescriptorProtos$SourceCodeInfo.getDefaultInstance();
        }
        return object;
    }

    public String getSyntax() {
        Object object = this.syntax_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.syntax_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getSyntaxBytes() {
        Object object = this.syntax_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.syntax_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public int getWeakDependency(int n10) {
        return this.weakDependency_.getInt(n10);
    }

    public int getWeakDependencyCount() {
        return this.weakDependency_.size();
    }

    public List getWeakDependencyList() {
        int n10 = this.bitField0_ & 0x10;
        List list = n10 != 0 ? Collections.unmodifiableList(this.weakDependency_) : this.weakDependency_;
        return list;
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
        int n10 = this.bitField0_ & 0x200;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasPackage() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasSourceCodeInfo() {
        int n10 = this.bitField0_ & 0x400;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasSyntax() {
        int n10 = this.bitField0_ & 0x800;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$800().ensureFieldAccessorsInitialized(DescriptorProtos$FileDescriptorProto.class, DescriptorProtos$FileDescriptorProto$Builder.class);
    }

    public final boolean isInitialized() {
        GeneratedMessageV3 generatedMessageV3;
        int n10;
        int n11;
        DescriptorProtos$FileOptions descriptorProtos$FileOptions = null;
        for (n11 = 0; n11 < (n10 = this.getMessageTypeCount()); ++n11) {
            generatedMessageV3 = this.getMessageType(n11);
            n10 = (int)(((DescriptorProtos$DescriptorProto)generatedMessageV3).isInitialized() ? 1 : 0);
            if (n10 != 0) continue;
            return false;
        }
        descriptorProtos$FileOptions = null;
        for (n11 = 0; n11 < (n10 = this.getEnumTypeCount()); ++n11) {
            generatedMessageV3 = this.getEnumType(n11);
            n10 = (int)(((DescriptorProtos$EnumDescriptorProto)generatedMessageV3).isInitialized() ? 1 : 0);
            if (n10 != 0) continue;
            return false;
        }
        descriptorProtos$FileOptions = null;
        for (n11 = 0; n11 < (n10 = this.getServiceCount()); ++n11) {
            generatedMessageV3 = this.getService(n11);
            n10 = (int)(((DescriptorProtos$ServiceDescriptorProto)generatedMessageV3).isInitialized() ? 1 : 0);
            if (n10 != 0) continue;
            return false;
        }
        descriptorProtos$FileOptions = null;
        for (n11 = 0; n11 < (n10 = this.getExtensionCount()); ++n11) {
            generatedMessageV3 = this.getExtension(n11);
            n10 = (int)(((DescriptorProtos$FieldDescriptorProto)generatedMessageV3).isInitialized() ? 1 : 0);
            if (n10 != 0) continue;
            return false;
        }
        n11 = (int)(this.hasOptions() ? 1 : 0);
        return n11 == 0 || (n11 = (int)((descriptorProtos$FileOptions = this.getOptions()).isInitialized() ? 1 : 0)) != 0;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public DescriptorProtos$FileDescriptorProto$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = DescriptorProtos$FileDescriptorProto.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (DescriptorProtos$FileDescriptorProto)object;
            if (object == null) break block7;
            this.mergeFrom((DescriptorProtos$FileDescriptorProto)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (DescriptorProtos$FileDescriptorProto)object2;
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
            this.mergeFrom((DescriptorProtos$FileDescriptorProto)object3);
        }
        throw var1_6;
    }

    public DescriptorProtos$FileDescriptorProto$Builder mergeFrom(DescriptorProtos$FileDescriptorProto messageLite) {
        List list;
        Object object;
        Object object2 = DescriptorProtos$FileDescriptorProto.getDefaultInstance();
        if (messageLite == object2) {
            return this;
        }
        int n10 = messageLite.hasName();
        if (n10 != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 1;
            this.name_ = object2 = DescriptorProtos$FileDescriptorProto.access$1200(messageLite);
            this.onChanged();
        }
        if ((n10 = messageLite.hasPackage()) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 2;
            this.package_ = object2 = DescriptorProtos$FileDescriptorProto.access$1300(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)((object2 = DescriptorProtos$FileDescriptorProto.access$1400(messageLite)).isEmpty() ? 1 : 0)) == 0) {
            object2 = this.dependency_;
            n10 = (int)(object2.isEmpty() ? 1 : 0);
            if (n10 != 0) {
                this.dependency_ = object2 = DescriptorProtos$FileDescriptorProto.access$1400(messageLite);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
            } else {
                this.ensureDependencyIsMutable();
                object2 = this.dependency_;
                object = DescriptorProtos$FileDescriptorProto.access$1400(messageLite);
                object2.addAll(object);
            }
            this.onChanged();
        }
        if ((n10 = (int)((object2 = DescriptorProtos$FileDescriptorProto.access$1500(messageLite)).isEmpty() ? 1 : 0)) == 0) {
            object2 = this.publicDependency_;
            n10 = (int)(object2.isEmpty() ? 1 : 0);
            if (n10 != 0) {
                this.publicDependency_ = object2 = DescriptorProtos$FileDescriptorProto.access$1500(messageLite);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
            } else {
                this.ensurePublicDependencyIsMutable();
                object2 = this.publicDependency_;
                object = DescriptorProtos$FileDescriptorProto.access$1500(messageLite);
                object2.addAll(object);
            }
            this.onChanged();
        }
        if ((n10 = (int)((object2 = DescriptorProtos$FileDescriptorProto.access$1600(messageLite)).isEmpty() ? 1 : 0)) == 0) {
            object2 = this.weakDependency_;
            n10 = (int)(object2.isEmpty() ? 1 : 0);
            if (n10 != 0) {
                this.weakDependency_ = object2 = DescriptorProtos$FileDescriptorProto.access$1600(messageLite);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFEF;
            } else {
                this.ensureWeakDependencyIsMutable();
                object2 = this.weakDependency_;
                object = DescriptorProtos$FileDescriptorProto.access$1600(messageLite);
                object2.addAll(object);
            }
            this.onChanged();
        }
        object2 = this.messageTypeBuilder_;
        object = null;
        if (object2 == null) {
            object2 = DescriptorProtos$FileDescriptorProto.access$1700(messageLite);
            n10 = (int)(object2.isEmpty() ? 1 : 0);
            if (n10 == 0) {
                object2 = this.messageType_;
                n10 = (int)(object2.isEmpty() ? 1 : 0);
                if (n10 != 0) {
                    this.messageType_ = object2 = DescriptorProtos$FileDescriptorProto.access$1700(messageLite);
                    this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFDF;
                } else {
                    this.ensureMessageTypeIsMutable();
                    object2 = this.messageType_;
                    list = DescriptorProtos$FileDescriptorProto.access$1700(messageLite);
                    object2.addAll(list);
                }
                this.onChanged();
            }
        } else {
            object2 = DescriptorProtos$FileDescriptorProto.access$1700(messageLite);
            n10 = (int)(object2.isEmpty() ? 1 : 0);
            if (n10 == 0) {
                object2 = this.messageTypeBuilder_;
                n10 = (int)(((RepeatedFieldBuilderV3)object2).isEmpty() ? 1 : 0);
                if (n10 != 0) {
                    this.messageTypeBuilder_.dispose();
                    this.messageTypeBuilder_ = null;
                    this.messageType_ = object2 = DescriptorProtos$FileDescriptorProto.access$1700(messageLite);
                    this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFDF;
                    n10 = (int)(GeneratedMessageV3.alwaysUseFieldBuilders ? 1 : 0);
                    if (n10 != 0) {
                        object2 = this.getMessageTypeFieldBuilder();
                    } else {
                        n10 = 0;
                        object2 = null;
                    }
                    this.messageTypeBuilder_ = object2;
                } else {
                    object2 = this.messageTypeBuilder_;
                    list = DescriptorProtos$FileDescriptorProto.access$1700(messageLite);
                    ((RepeatedFieldBuilderV3)object2).addAllMessages(list);
                }
            }
        }
        if ((object2 = this.enumTypeBuilder_) == null) {
            object2 = DescriptorProtos$FileDescriptorProto.access$1800(messageLite);
            n10 = (int)(object2.isEmpty() ? 1 : 0);
            if (n10 == 0) {
                object2 = this.enumType_;
                n10 = (int)(object2.isEmpty() ? 1 : 0);
                if (n10 != 0) {
                    this.enumType_ = object2 = DescriptorProtos$FileDescriptorProto.access$1800(messageLite);
                    this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFBF;
                } else {
                    this.ensureEnumTypeIsMutable();
                    object2 = this.enumType_;
                    list = DescriptorProtos$FileDescriptorProto.access$1800(messageLite);
                    object2.addAll(list);
                }
                this.onChanged();
            }
        } else {
            object2 = DescriptorProtos$FileDescriptorProto.access$1800(messageLite);
            n10 = (int)(object2.isEmpty() ? 1 : 0);
            if (n10 == 0) {
                object2 = this.enumTypeBuilder_;
                n10 = (int)(((RepeatedFieldBuilderV3)object2).isEmpty() ? 1 : 0);
                if (n10 != 0) {
                    this.enumTypeBuilder_.dispose();
                    this.enumTypeBuilder_ = null;
                    this.enumType_ = object2 = DescriptorProtos$FileDescriptorProto.access$1800(messageLite);
                    this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFBF;
                    n10 = (int)(GeneratedMessageV3.alwaysUseFieldBuilders ? 1 : 0);
                    if (n10 != 0) {
                        object2 = this.getEnumTypeFieldBuilder();
                    } else {
                        n10 = 0;
                        object2 = null;
                    }
                    this.enumTypeBuilder_ = object2;
                } else {
                    object2 = this.enumTypeBuilder_;
                    list = DescriptorProtos$FileDescriptorProto.access$1800(messageLite);
                    ((RepeatedFieldBuilderV3)object2).addAllMessages(list);
                }
            }
        }
        if ((object2 = this.serviceBuilder_) == null) {
            object2 = DescriptorProtos$FileDescriptorProto.access$1900(messageLite);
            n10 = (int)(object2.isEmpty() ? 1 : 0);
            if (n10 == 0) {
                object2 = this.service_;
                n10 = (int)(object2.isEmpty() ? 1 : 0);
                if (n10 != 0) {
                    this.service_ = object2 = DescriptorProtos$FileDescriptorProto.access$1900(messageLite);
                    this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFF7F;
                } else {
                    this.ensureServiceIsMutable();
                    object2 = this.service_;
                    list = DescriptorProtos$FileDescriptorProto.access$1900(messageLite);
                    object2.addAll(list);
                }
                this.onChanged();
            }
        } else {
            object2 = DescriptorProtos$FileDescriptorProto.access$1900(messageLite);
            n10 = (int)(object2.isEmpty() ? 1 : 0);
            if (n10 == 0) {
                object2 = this.serviceBuilder_;
                n10 = (int)(((RepeatedFieldBuilderV3)object2).isEmpty() ? 1 : 0);
                if (n10 != 0) {
                    this.serviceBuilder_.dispose();
                    this.serviceBuilder_ = null;
                    this.service_ = object2 = DescriptorProtos$FileDescriptorProto.access$1900(messageLite);
                    this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFF7F;
                    n10 = (int)(GeneratedMessageV3.alwaysUseFieldBuilders ? 1 : 0);
                    if (n10 != 0) {
                        object2 = this.getServiceFieldBuilder();
                    } else {
                        n10 = 0;
                        object2 = null;
                    }
                    this.serviceBuilder_ = object2;
                } else {
                    object2 = this.serviceBuilder_;
                    list = DescriptorProtos$FileDescriptorProto.access$1900(messageLite);
                    ((RepeatedFieldBuilderV3)object2).addAllMessages(list);
                }
            }
        }
        if ((object2 = this.extensionBuilder_) == null) {
            object2 = DescriptorProtos$FileDescriptorProto.access$2000(messageLite);
            n10 = (int)(object2.isEmpty() ? 1 : 0);
            if (n10 == 0) {
                object2 = this.extension_;
                n10 = (int)(object2.isEmpty() ? 1 : 0);
                if (n10 != 0) {
                    this.extension_ = object2 = DescriptorProtos$FileDescriptorProto.access$2000(messageLite);
                    this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFEFF;
                } else {
                    this.ensureExtensionIsMutable();
                    object2 = this.extension_;
                    object = DescriptorProtos$FileDescriptorProto.access$2000(messageLite);
                    object2.addAll(object);
                }
                this.onChanged();
            }
        } else {
            object2 = DescriptorProtos$FileDescriptorProto.access$2000(messageLite);
            n10 = (int)(object2.isEmpty() ? 1 : 0);
            if (n10 == 0) {
                object2 = this.extensionBuilder_;
                n10 = (int)(((RepeatedFieldBuilderV3)object2).isEmpty() ? 1 : 0);
                if (n10 != 0) {
                    this.extensionBuilder_.dispose();
                    this.extensionBuilder_ = null;
                    this.extension_ = object2 = DescriptorProtos$FileDescriptorProto.access$2000(messageLite);
                    this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFEFF;
                    n10 = (int)(GeneratedMessageV3.alwaysUseFieldBuilders ? 1 : 0);
                    if (n10 != 0) {
                        object = this.getExtensionFieldBuilder();
                    }
                    this.extensionBuilder_ = object;
                } else {
                    object2 = this.extensionBuilder_;
                    object = DescriptorProtos$FileDescriptorProto.access$2000(messageLite);
                    ((RepeatedFieldBuilderV3)object2).addAllMessages((Iterable)object);
                }
            }
        }
        if ((n10 = (int)(messageLite.hasOptions() ? 1 : 0)) != 0) {
            object2 = messageLite.getOptions();
            this.mergeOptions((DescriptorProtos$FileOptions)object2);
        }
        if ((n10 = (int)(messageLite.hasSourceCodeInfo() ? 1 : 0)) != 0) {
            object2 = messageLite.getSourceCodeInfo();
            this.mergeSourceCodeInfo((DescriptorProtos$SourceCodeInfo)object2);
        }
        if ((n10 = (int)(messageLite.hasSyntax() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 0x800;
            this.syntax_ = object2 = DescriptorProtos$FileDescriptorProto.access$2300(messageLite);
            this.onChanged();
        }
        messageLite = messageLite.unknownFields;
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof DescriptorProtos$FileDescriptorProto;
        if (bl2) {
            message = (DescriptorProtos$FileDescriptorProto)message;
            return this.mergeFrom((DescriptorProtos$FileDescriptorProto)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder mergeOptions(DescriptorProtos$FileOptions descriptorProtos$FileOptions) {
        int n10;
        Object object = this.optionsBuilder_;
        if (object == null) {
            DescriptorProtos$FileOptions descriptorProtos$FileOptions2;
            int n11 = this.bitField0_ & 0x200;
            if (n11 != 0 && (object = this.options_) != null && object != (descriptorProtos$FileOptions2 = DescriptorProtos$FileOptions.getDefaultInstance())) {
                object = DescriptorProtos$FileOptions.newBuilder(this.options_);
                this.options_ = descriptorProtos$FileOptions = ((DescriptorProtos$FileOptions$Builder)object).mergeFrom(descriptorProtos$FileOptions).buildPartial();
            } else {
                this.options_ = descriptorProtos$FileOptions;
            }
            this.onChanged();
        } else {
            ((SingleFieldBuilderV3)object).mergeFrom(descriptorProtos$FileOptions);
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x200;
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder mergeSourceCodeInfo(DescriptorProtos$SourceCodeInfo descriptorProtos$SourceCodeInfo) {
        int n10;
        Object object = this.sourceCodeInfoBuilder_;
        if (object == null) {
            DescriptorProtos$SourceCodeInfo descriptorProtos$SourceCodeInfo2;
            int n11 = this.bitField0_ & 0x400;
            if (n11 != 0 && (object = this.sourceCodeInfo_) != null && object != (descriptorProtos$SourceCodeInfo2 = DescriptorProtos$SourceCodeInfo.getDefaultInstance())) {
                object = DescriptorProtos$SourceCodeInfo.newBuilder(this.sourceCodeInfo_);
                this.sourceCodeInfo_ = descriptorProtos$SourceCodeInfo = ((DescriptorProtos$SourceCodeInfo$Builder)object).mergeFrom(descriptorProtos$SourceCodeInfo).buildPartial();
            } else {
                this.sourceCodeInfo_ = descriptorProtos$SourceCodeInfo;
            }
            this.onChanged();
        } else {
            ((SingleFieldBuilderV3)object).mergeFrom(descriptorProtos$SourceCodeInfo);
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x400;
        return this;
    }

    public final DescriptorProtos$FileDescriptorProto$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$FileDescriptorProto$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public DescriptorProtos$FileDescriptorProto$Builder removeEnumType(int n10) {
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

    public DescriptorProtos$FileDescriptorProto$Builder removeExtension(int n10) {
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

    public DescriptorProtos$FileDescriptorProto$Builder removeMessageType(int n10) {
        Object object = this.messageTypeBuilder_;
        if (object == null) {
            this.ensureMessageTypeIsMutable();
            object = this.messageType_;
            object.remove(n10);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).remove(n10);
        }
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder removeService(int n10) {
        Object object = this.serviceBuilder_;
        if (object == null) {
            this.ensureServiceIsMutable();
            object = this.service_;
            object.remove(n10);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).remove(n10);
        }
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder setDependency(int n10, String string2) {
        Objects.requireNonNull(string2);
        this.ensureDependencyIsMutable();
        this.dependency_.set(n10, string2);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder setEnumType(int n10, DescriptorProtos$EnumDescriptorProto$Builder descriptorProtos$EnumDescriptorProtoOrBuilder) {
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

    public DescriptorProtos$FileDescriptorProto$Builder setEnumType(int n10, DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto) {
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

    public DescriptorProtos$FileDescriptorProto$Builder setExtension(int n10, DescriptorProtos$FieldDescriptorProto$Builder descriptorProtos$FieldDescriptorProtoOrBuilder) {
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

    public DescriptorProtos$FileDescriptorProto$Builder setExtension(int n10, DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
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

    public DescriptorProtos$FileDescriptorProto$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$FileDescriptorProto$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$FileDescriptorProto$Builder setMessageType(int n10, DescriptorProtos$DescriptorProto$Builder descriptorProtos$DescriptorProtoOrBuilder) {
        Object object = this.messageTypeBuilder_;
        if (object == null) {
            this.ensureMessageTypeIsMutable();
            object = this.messageType_;
            descriptorProtos$DescriptorProtoOrBuilder = ((DescriptorProtos$DescriptorProto$Builder)descriptorProtos$DescriptorProtoOrBuilder).build();
            object.set(n10, descriptorProtos$DescriptorProtoOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$DescriptorProtoOrBuilder = ((DescriptorProtos$DescriptorProto$Builder)descriptorProtos$DescriptorProtoOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).setMessage(n10, (AbstractMessage)((Object)descriptorProtos$DescriptorProtoOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder setMessageType(int n10, DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        Object object = this.messageTypeBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$DescriptorProto);
            this.ensureMessageTypeIsMutable();
            object = this.messageType_;
            object.set(n10, descriptorProtos$DescriptorProto);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).setMessage(n10, descriptorProtos$DescriptorProto);
        }
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder setName(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.name_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder setNameBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.name_ = byteString;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder setOptions(DescriptorProtos$FileOptions$Builder descriptorProtos$FileOptionsOrBuilder) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.optionsBuilder_;
        if (singleFieldBuilderV3 == null) {
            descriptorProtos$FileOptionsOrBuilder = descriptorProtos$FileOptionsOrBuilder.build();
            this.options_ = descriptorProtos$FileOptionsOrBuilder;
            this.onChanged();
        } else {
            descriptorProtos$FileOptionsOrBuilder = descriptorProtos$FileOptionsOrBuilder.build();
            singleFieldBuilderV3.setMessage((AbstractMessage)((Object)descriptorProtos$FileOptionsOrBuilder));
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x200;
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder setOptions(DescriptorProtos$FileOptions descriptorProtos$FileOptions) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.optionsBuilder_;
        if (singleFieldBuilderV3 == null) {
            Objects.requireNonNull(descriptorProtos$FileOptions);
            this.options_ = descriptorProtos$FileOptions;
            this.onChanged();
        } else {
            singleFieldBuilderV3.setMessage(descriptorProtos$FileOptions);
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x200;
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder setPackage(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.package_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder setPackageBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.package_ = byteString;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder setPublicDependency(int n10, int n11) {
        this.ensurePublicDependencyIsMutable();
        this.publicDependency_.setInt(n10, n11);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (DescriptorProtos$FileDescriptorProto$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public DescriptorProtos$FileDescriptorProto$Builder setService(int n10, DescriptorProtos$ServiceDescriptorProto$Builder descriptorProtos$ServiceDescriptorProtoOrBuilder) {
        Object object = this.serviceBuilder_;
        if (object == null) {
            this.ensureServiceIsMutable();
            object = this.service_;
            descriptorProtos$ServiceDescriptorProtoOrBuilder = ((DescriptorProtos$ServiceDescriptorProto$Builder)descriptorProtos$ServiceDescriptorProtoOrBuilder).build();
            object.set(n10, descriptorProtos$ServiceDescriptorProtoOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$ServiceDescriptorProtoOrBuilder = ((DescriptorProtos$ServiceDescriptorProto$Builder)descriptorProtos$ServiceDescriptorProtoOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).setMessage(n10, (AbstractMessage)((Object)descriptorProtos$ServiceDescriptorProtoOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder setService(int n10, DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto) {
        Object object = this.serviceBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$ServiceDescriptorProto);
            this.ensureServiceIsMutable();
            object = this.service_;
            object.set(n10, descriptorProtos$ServiceDescriptorProto);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).setMessage(n10, descriptorProtos$ServiceDescriptorProto);
        }
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder setSourceCodeInfo(DescriptorProtos$SourceCodeInfo$Builder descriptorProtos$SourceCodeInfoOrBuilder) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.sourceCodeInfoBuilder_;
        if (singleFieldBuilderV3 == null) {
            descriptorProtos$SourceCodeInfoOrBuilder = descriptorProtos$SourceCodeInfoOrBuilder.build();
            this.sourceCodeInfo_ = descriptorProtos$SourceCodeInfoOrBuilder;
            this.onChanged();
        } else {
            descriptorProtos$SourceCodeInfoOrBuilder = descriptorProtos$SourceCodeInfoOrBuilder.build();
            singleFieldBuilderV3.setMessage((AbstractMessage)((Object)descriptorProtos$SourceCodeInfoOrBuilder));
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x400;
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder setSourceCodeInfo(DescriptorProtos$SourceCodeInfo descriptorProtos$SourceCodeInfo) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.sourceCodeInfoBuilder_;
        if (singleFieldBuilderV3 == null) {
            Objects.requireNonNull(descriptorProtos$SourceCodeInfo);
            this.sourceCodeInfo_ = descriptorProtos$SourceCodeInfo;
            this.onChanged();
        } else {
            singleFieldBuilderV3.setMessage(descriptorProtos$SourceCodeInfo);
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x400;
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder setSyntax(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x800;
        this.syntax_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder setSyntaxBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x800;
        this.syntax_ = byteString;
        this.onChanged();
        return this;
    }

    public final DescriptorProtos$FileDescriptorProto$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$FileDescriptorProto$Builder)super.setUnknownFields(unknownFieldSet);
    }

    public DescriptorProtos$FileDescriptorProto$Builder setWeakDependency(int n10, int n11) {
        this.ensureWeakDependencyIsMutable();
        this.weakDependency_.setInt(n10, n11);
        this.onChanged();
        return this;
    }
}

