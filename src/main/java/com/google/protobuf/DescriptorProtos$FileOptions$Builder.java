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
import com.google.protobuf.DescriptorProtos$FileOptions;
import com.google.protobuf.DescriptorProtos$FileOptions$OptimizeMode;
import com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder;
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

public final class DescriptorProtos$FileOptions$Builder
extends GeneratedMessageV3$ExtendableBuilder
implements DescriptorProtos$FileOptionsOrBuilder {
    private int bitField0_;
    private boolean ccEnableArenas_;
    private boolean ccGenericServices_;
    private Object csharpNamespace_;
    private boolean deprecated_;
    private Object goPackage_;
    private boolean javaGenerateEqualsAndHash_;
    private boolean javaGenericServices_;
    private boolean javaMultipleFiles_;
    private Object javaOuterClassname_;
    private Object javaPackage_;
    private boolean javaStringCheckUtf8_;
    private Object objcClassPrefix_;
    private int optimizeFor_;
    private Object phpClassPrefix_;
    private boolean phpGenericServices_;
    private Object phpMetadataNamespace_;
    private Object phpNamespace_;
    private boolean pyGenericServices_;
    private Object rubyPackage_;
    private Object swiftPrefix_;
    private RepeatedFieldBuilderV3 uninterpretedOptionBuilder_;
    private List uninterpretedOption_;

    private DescriptorProtos$FileOptions$Builder() {
        Object object;
        this.javaPackage_ = object = "";
        this.javaOuterClassname_ = object;
        this.optimizeFor_ = 1;
        this.goPackage_ = object;
        this.objcClassPrefix_ = object;
        this.csharpNamespace_ = object;
        this.swiftPrefix_ = object;
        this.phpClassPrefix_ = object;
        this.phpNamespace_ = object;
        this.phpMetadataNamespace_ = object;
        this.rubyPackage_ = object;
        this.uninterpretedOption_ = object = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$FileOptions$Builder(DescriptorProtos$1 descriptorProtos$1) {
        this();
    }

    private DescriptorProtos$FileOptions$Builder(GeneratedMessageV3$BuilderParent list) {
        super((GeneratedMessageV3$BuilderParent)((Object)list));
        list = "";
        this.javaPackage_ = list;
        this.javaOuterClassname_ = list;
        this.optimizeFor_ = 1;
        this.goPackage_ = list;
        this.objcClassPrefix_ = list;
        this.csharpNamespace_ = list;
        this.swiftPrefix_ = list;
        this.phpClassPrefix_ = list;
        this.phpNamespace_ = list;
        this.phpMetadataNamespace_ = list;
        this.rubyPackage_ = list;
        this.uninterpretedOption_ = list = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$FileOptions$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$BuilderParent);
    }

    private void ensureUninterpretedOptionIsMutable() {
        int n10 = this.bitField0_;
        int n11 = 0x100000;
        if ((n10 &= n11) == 0) {
            ArrayList arrayList;
            List list = this.uninterpretedOption_;
            this.uninterpretedOption_ = arrayList = new ArrayList(list);
            this.bitField0_ = n10 = this.bitField0_ | n11;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$14900();
    }

    /*
     * WARNING - void declaration
     */
    private RepeatedFieldBuilderV3 getUninterpretedOptionFieldBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.uninterpretedOptionBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            void var3_7;
            List list = this.uninterpretedOption_;
            int bl2 = this.bitField0_;
            int n10 = 0x100000;
            int n11 = bl2 & n10;
            if (n11 != 0) {
                boolean bl3 = true;
            } else {
                boolean bl4 = false;
            }
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl5 = this.isClean();
            this.uninterpretedOptionBuilder_ = repeatedFieldBuilderV3 = new RepeatedFieldBuilderV3(list, (boolean)var3_7, generatedMessageV3$BuilderParent, bl5);
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

    public DescriptorProtos$FileOptions$Builder addAllUninterpretedOption(Iterable iterable) {
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

    public DescriptorProtos$FileOptions$Builder addExtension(GeneratedMessage$GeneratedExtension generatedMessage$GeneratedExtension, Object object) {
        return (DescriptorProtos$FileOptions$Builder)super.addExtension(generatedMessage$GeneratedExtension, object);
    }

    public DescriptorProtos$FileOptions$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$FileOptions$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$FileOptions$Builder addUninterpretedOption(int n10, DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOptionOrBuilder) {
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

    public DescriptorProtos$FileOptions$Builder addUninterpretedOption(int n10, DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
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

    public DescriptorProtos$FileOptions$Builder addUninterpretedOption(DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOptionOrBuilder) {
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

    public DescriptorProtos$FileOptions$Builder addUninterpretedOption(DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
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

    public DescriptorProtos$FileOptions build() {
        DescriptorProtos$FileOptions descriptorProtos$FileOptions = this.buildPartial();
        boolean bl2 = descriptorProtos$FileOptions.isInitialized();
        if (bl2) {
            return descriptorProtos$FileOptions;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(descriptorProtos$FileOptions);
    }

    public DescriptorProtos$FileOptions buildPartial() {
        List list = null;
        DescriptorProtos$FileOptions descriptorProtos$FileOptions = new DescriptorProtos$FileOptions(this, null);
        int n10 = this.bitField0_;
        int n11 = n10 & 1;
        n11 = n11 != 0 ? 1 : 0;
        Object object = this.javaPackage_;
        DescriptorProtos$FileOptions.access$15402(descriptorProtos$FileOptions, object);
        int n12 = n10 & 2;
        if (n12 != 0) {
            n11 |= 2;
        }
        object = this.javaOuterClassname_;
        DescriptorProtos$FileOptions.access$15502(descriptorProtos$FileOptions, object);
        n12 = n10 & 4;
        if (n12 != 0) {
            n12 = (int)(this.javaMultipleFiles_ ? 1 : 0);
            DescriptorProtos$FileOptions.access$15602(descriptorProtos$FileOptions, n12 != 0);
            n11 |= 4;
        }
        if ((n12 = n10 & 8) != 0) {
            n12 = this.javaGenerateEqualsAndHash_;
            DescriptorProtos$FileOptions.access$15702(descriptorProtos$FileOptions, n12 != 0);
            n11 |= 8;
        }
        if ((n12 = n10 & 0x10) != 0) {
            n12 = this.javaStringCheckUtf8_;
            DescriptorProtos$FileOptions.access$15802(descriptorProtos$FileOptions, n12 != 0);
            n11 |= 0x10;
        }
        if ((n12 = n10 & 0x20) != 0) {
            n11 |= 0x20;
        }
        n12 = this.optimizeFor_;
        DescriptorProtos$FileOptions.access$15902(descriptorProtos$FileOptions, n12);
        n12 = n10 & 0x40;
        if (n12 != 0) {
            n11 |= 0x40;
        }
        object = this.goPackage_;
        DescriptorProtos$FileOptions.access$16002(descriptorProtos$FileOptions, object);
        n12 = n10 & 0x80;
        if (n12 != 0) {
            n12 = (int)(this.ccGenericServices_ ? 1 : 0);
            DescriptorProtos$FileOptions.access$16102(descriptorProtos$FileOptions, n12 != 0);
            n11 |= 0x80;
        }
        if ((n12 = n10 & 0x100) != 0) {
            n12 = this.javaGenericServices_;
            DescriptorProtos$FileOptions.access$16202(descriptorProtos$FileOptions, n12 != 0);
            n11 |= 0x100;
        }
        if ((n12 = n10 & 0x200) != 0) {
            n12 = this.pyGenericServices_;
            DescriptorProtos$FileOptions.access$16302(descriptorProtos$FileOptions, n12 != 0);
            n11 |= 0x200;
        }
        if ((n12 = n10 & 0x400) != 0) {
            n12 = this.phpGenericServices_;
            DescriptorProtos$FileOptions.access$16402(descriptorProtos$FileOptions, n12 != 0);
            n11 |= 0x400;
        }
        if ((n12 = n10 & 0x800) != 0) {
            n12 = this.deprecated_;
            DescriptorProtos$FileOptions.access$16502(descriptorProtos$FileOptions, n12 != 0);
            n11 |= 0x800;
        }
        if ((n12 = n10 & 0x1000) != 0) {
            n12 = this.ccEnableArenas_;
            DescriptorProtos$FileOptions.access$16602(descriptorProtos$FileOptions, n12 != 0);
            n11 |= 0x1000;
        }
        if ((n12 = n10 & 0x2000) != 0) {
            n11 |= 0x2000;
        }
        object = this.objcClassPrefix_;
        DescriptorProtos$FileOptions.access$16702(descriptorProtos$FileOptions, object);
        n12 = n10 & 0x4000;
        if (n12 != 0) {
            n11 |= 0x4000;
        }
        object = this.csharpNamespace_;
        DescriptorProtos$FileOptions.access$16802(descriptorProtos$FileOptions, object);
        n12 = 32768;
        int n13 = n10 & n12;
        if (n13 != 0) {
            n11 |= n12;
        }
        object = this.swiftPrefix_;
        DescriptorProtos$FileOptions.access$16902(descriptorProtos$FileOptions, object);
        n12 = 65536;
        n13 = n10 & n12;
        if (n13 != 0) {
            n11 |= n12;
        }
        object = this.phpClassPrefix_;
        DescriptorProtos$FileOptions.access$17002(descriptorProtos$FileOptions, object);
        n12 = 131072;
        n13 = n10 & n12;
        if (n13 != 0) {
            n11 |= n12;
        }
        object = this.phpNamespace_;
        DescriptorProtos$FileOptions.access$17102(descriptorProtos$FileOptions, object);
        n12 = 262144;
        n13 = n10 & n12;
        if (n13 != 0) {
            n11 |= n12;
        }
        object = this.phpMetadataNamespace_;
        DescriptorProtos$FileOptions.access$17202(descriptorProtos$FileOptions, object);
        n12 = 524288;
        if ((n10 &= n12) != 0) {
            n11 |= n12;
        }
        list = this.rubyPackage_;
        DescriptorProtos$FileOptions.access$17302(descriptorProtos$FileOptions, list);
        list = this.uninterpretedOptionBuilder_;
        if (list == null) {
            n10 = this.bitField0_;
            n12 = 0x100000;
            if ((n10 &= n12) != 0) {
                this.uninterpretedOption_ = list = Collections.unmodifiableList(this.uninterpretedOption_);
                n10 = this.bitField0_;
                n12 = -1048577;
                this.bitField0_ = n10 &= n12;
            }
            list = this.uninterpretedOption_;
            DescriptorProtos$FileOptions.access$17402(descriptorProtos$FileOptions, list);
        } else {
            list = ((RepeatedFieldBuilderV3)((Object)list)).build();
            DescriptorProtos$FileOptions.access$17402(descriptorProtos$FileOptions, list);
        }
        DescriptorProtos$FileOptions.access$17502(descriptorProtos$FileOptions, n11);
        this.onBuilt();
        return descriptorProtos$FileOptions;
    }

    public DescriptorProtos$FileOptions$Builder clear() {
        int n10;
        int n11;
        int n12;
        super.clear();
        List list = "";
        this.javaPackage_ = list;
        this.bitField0_ = n12 = this.bitField0_ & 0xFFFFFFFE;
        this.javaOuterClassname_ = list;
        this.bitField0_ = n12 &= 0xFFFFFFFD;
        this.javaMultipleFiles_ = false;
        this.bitField0_ = n12 &= 0xFFFFFFFB;
        this.javaGenerateEqualsAndHash_ = false;
        this.bitField0_ = n12 &= 0xFFFFFFF7;
        this.javaStringCheckUtf8_ = false;
        this.bitField0_ = n12 &= 0xFFFFFFEF;
        this.optimizeFor_ = n11 = 1;
        this.bitField0_ = n12 &= 0xFFFFFFDF;
        this.goPackage_ = list;
        this.bitField0_ = n12 &= 0xFFFFFFBF;
        this.ccGenericServices_ = false;
        this.bitField0_ = n12 &= 0xFFFFFF7F;
        this.javaGenericServices_ = false;
        this.bitField0_ = n12 &= 0xFFFFFEFF;
        this.pyGenericServices_ = false;
        this.bitField0_ = n12 &= 0xFFFFFDFF;
        this.phpGenericServices_ = false;
        this.bitField0_ = n12 &= 0xFFFFFBFF;
        this.deprecated_ = false;
        this.bitField0_ = n12 &= 0xFFFFF7FF;
        this.ccEnableArenas_ = false;
        this.bitField0_ = n12 &= 0xFFFFEFFF;
        this.objcClassPrefix_ = list;
        this.bitField0_ = n12 &= 0xFFFFDFFF;
        this.csharpNamespace_ = list;
        this.bitField0_ = n12 &= 0xFFFFBFFF;
        this.swiftPrefix_ = list;
        this.bitField0_ = n12 &= 0xFFFF7FFF;
        this.phpClassPrefix_ = list;
        this.bitField0_ = n12 &= 0xFFFEFFFF;
        this.phpNamespace_ = list;
        this.bitField0_ = n12 &= 0xFFFDFFFF;
        this.phpMetadataNamespace_ = list;
        int n13 = -262145;
        this.bitField0_ = n12 &= n13;
        this.rubyPackage_ = list;
        this.bitField0_ = n10 = 0xFFF7FFFF & n12;
        list = this.uninterpretedOptionBuilder_;
        if (list == null) {
            this.uninterpretedOption_ = list = Collections.emptyList();
            n10 = this.bitField0_;
            n12 = -1048577;
            this.bitField0_ = n10 &= n12;
        } else {
            ((RepeatedFieldBuilderV3)((Object)list)).clear();
        }
        return this;
    }

    public DescriptorProtos$FileOptions$Builder clearCcEnableArenas() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFEFFF;
        this.ccEnableArenas_ = false;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder clearCcGenericServices() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFF7F;
        this.ccGenericServices_ = false;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder clearCsharpNamespace() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFBFFF;
        String string2 = DescriptorProtos$FileOptions.getDefaultInstance().getCsharpNamespace();
        this.csharpNamespace_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder clearDeprecated() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFF7FF;
        this.deprecated_ = false;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder clearExtension(GeneratedMessage$GeneratedExtension generatedMessage$GeneratedExtension) {
        return (DescriptorProtos$FileOptions$Builder)super.clearExtension(generatedMessage$GeneratedExtension);
    }

    public DescriptorProtos$FileOptions$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (DescriptorProtos$FileOptions$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public DescriptorProtos$FileOptions$Builder clearGoPackage() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFBF;
        String string2 = DescriptorProtos$FileOptions.getDefaultInstance().getGoPackage();
        this.goPackage_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder clearJavaGenerateEqualsAndHash() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
        this.javaGenerateEqualsAndHash_ = false;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder clearJavaGenericServices() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFEFF;
        this.javaGenericServices_ = false;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder clearJavaMultipleFiles() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        this.javaMultipleFiles_ = false;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder clearJavaOuterClassname() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        String string2 = DescriptorProtos$FileOptions.getDefaultInstance().getJavaOuterClassname();
        this.javaOuterClassname_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder clearJavaPackage() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        String string2 = DescriptorProtos$FileOptions.getDefaultInstance().getJavaPackage();
        this.javaPackage_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder clearJavaStringCheckUtf8() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFEF;
        this.javaStringCheckUtf8_ = false;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder clearObjcClassPrefix() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFDFFF;
        String string2 = DescriptorProtos$FileOptions.getDefaultInstance().getObjcClassPrefix();
        this.objcClassPrefix_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (DescriptorProtos$FileOptions$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public DescriptorProtos$FileOptions$Builder clearOptimizeFor() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFDF;
        this.optimizeFor_ = 1;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder clearPhpClassPrefix() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFEFFFF;
        String string2 = DescriptorProtos$FileOptions.getDefaultInstance().getPhpClassPrefix();
        this.phpClassPrefix_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder clearPhpGenericServices() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFBFF;
        this.phpGenericServices_ = false;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder clearPhpMetadataNamespace() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFBFFFF;
        String string2 = DescriptorProtos$FileOptions.getDefaultInstance().getPhpMetadataNamespace();
        this.phpMetadataNamespace_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder clearPhpNamespace() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFDFFFF;
        String string2 = DescriptorProtos$FileOptions.getDefaultInstance().getPhpNamespace();
        this.phpNamespace_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder clearPyGenericServices() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFDFF;
        this.pyGenericServices_ = false;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder clearRubyPackage() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFF7FFFF;
        String string2 = DescriptorProtos$FileOptions.getDefaultInstance().getRubyPackage();
        this.rubyPackage_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder clearSwiftPrefix() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFF7FFF;
        String string2 = DescriptorProtos$FileOptions.getDefaultInstance().getSwiftPrefix();
        this.swiftPrefix_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder clearUninterpretedOption() {
        Object object = this.uninterpretedOptionBuilder_;
        if (object == null) {
            this.uninterpretedOption_ = object = Collections.emptyList();
            int n10 = this.bitField0_;
            int n11 = -1048577;
            this.bitField0_ = n10 &= n11;
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public DescriptorProtos$FileOptions$Builder clone() {
        return (DescriptorProtos$FileOptions$Builder)super.clone();
    }

    public boolean getCcEnableArenas() {
        return this.ccEnableArenas_;
    }

    public boolean getCcGenericServices() {
        return this.ccGenericServices_;
    }

    public String getCsharpNamespace() {
        Object object = this.csharpNamespace_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.csharpNamespace_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getCsharpNamespaceBytes() {
        Object object = this.csharpNamespace_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.csharpNamespace_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public DescriptorProtos$FileOptions getDefaultInstanceForType() {
        return DescriptorProtos$FileOptions.getDefaultInstance();
    }

    public boolean getDeprecated() {
        return this.deprecated_;
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.access$14900();
    }

    public String getGoPackage() {
        Object object = this.goPackage_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.goPackage_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getGoPackageBytes() {
        Object object = this.goPackage_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.goPackage_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public boolean getJavaGenerateEqualsAndHash() {
        return this.javaGenerateEqualsAndHash_;
    }

    public boolean getJavaGenericServices() {
        return this.javaGenericServices_;
    }

    public boolean getJavaMultipleFiles() {
        return this.javaMultipleFiles_;
    }

    public String getJavaOuterClassname() {
        Object object = this.javaOuterClassname_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.javaOuterClassname_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getJavaOuterClassnameBytes() {
        Object object = this.javaOuterClassname_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.javaOuterClassname_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public String getJavaPackage() {
        Object object = this.javaPackage_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.javaPackage_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getJavaPackageBytes() {
        Object object = this.javaPackage_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.javaPackage_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public boolean getJavaStringCheckUtf8() {
        return this.javaStringCheckUtf8_;
    }

    public String getObjcClassPrefix() {
        Object object = this.objcClassPrefix_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.objcClassPrefix_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getObjcClassPrefixBytes() {
        Object object = this.objcClassPrefix_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.objcClassPrefix_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public DescriptorProtos$FileOptions$OptimizeMode getOptimizeFor() {
        int n10 = this.optimizeFor_;
        DescriptorProtos$FileOptions$OptimizeMode descriptorProtos$FileOptions$OptimizeMode = DescriptorProtos$FileOptions$OptimizeMode.valueOf(n10);
        if (descriptorProtos$FileOptions$OptimizeMode == null) {
            descriptorProtos$FileOptions$OptimizeMode = DescriptorProtos$FileOptions$OptimizeMode.SPEED;
        }
        return descriptorProtos$FileOptions$OptimizeMode;
    }

    public String getPhpClassPrefix() {
        Object object = this.phpClassPrefix_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.phpClassPrefix_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getPhpClassPrefixBytes() {
        Object object = this.phpClassPrefix_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.phpClassPrefix_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public boolean getPhpGenericServices() {
        return this.phpGenericServices_;
    }

    public String getPhpMetadataNamespace() {
        Object object = this.phpMetadataNamespace_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.phpMetadataNamespace_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getPhpMetadataNamespaceBytes() {
        Object object = this.phpMetadataNamespace_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.phpMetadataNamespace_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public String getPhpNamespace() {
        Object object = this.phpNamespace_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.phpNamespace_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getPhpNamespaceBytes() {
        Object object = this.phpNamespace_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.phpNamespace_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public boolean getPyGenericServices() {
        return this.pyGenericServices_;
    }

    public String getRubyPackage() {
        Object object = this.rubyPackage_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.rubyPackage_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getRubyPackageBytes() {
        Object object = this.rubyPackage_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.rubyPackage_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public String getSwiftPrefix() {
        Object object = this.swiftPrefix_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.swiftPrefix_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getSwiftPrefixBytes() {
        Object object = this.swiftPrefix_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.swiftPrefix_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
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

    public boolean hasCcEnableArenas() {
        int n10 = this.bitField0_ & 0x1000;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasCcGenericServices() {
        int n10 = this.bitField0_ & 0x80;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasCsharpNamespace() {
        int n10 = this.bitField0_ & 0x4000;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasDeprecated() {
        int n10 = this.bitField0_ & 0x800;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasGoPackage() {
        int n10 = this.bitField0_ & 0x40;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasJavaGenerateEqualsAndHash() {
        int n10 = this.bitField0_ & 8;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasJavaGenericServices() {
        int n10 = this.bitField0_ & 0x100;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasJavaMultipleFiles() {
        int n10 = this.bitField0_ & 4;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasJavaOuterClassname() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasJavaPackage() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean hasJavaStringCheckUtf8() {
        int n10 = this.bitField0_ & 0x10;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasObjcClassPrefix() {
        int n10 = this.bitField0_ & 0x2000;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasOptimizeFor() {
        int n10 = this.bitField0_ & 0x20;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasPhpClassPrefix() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 65536;
        int n11 = bl2 & n10;
        if (n11 != 0) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    public boolean hasPhpGenericServices() {
        int n10 = this.bitField0_ & 0x400;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasPhpMetadataNamespace() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 262144;
        int n11 = bl2 & n10;
        if (n11 != 0) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasPhpNamespace() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 131072;
        int n11 = bl2 & n10;
        if (n11 != 0) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    public boolean hasPyGenericServices() {
        int n10 = this.bitField0_ & 0x200;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasRubyPackage() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 524288;
        int n11 = bl2 & n10;
        if (n11 != 0) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasSwiftPrefix() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 32768;
        int n11 = bl2 & n10;
        if (n11 != 0) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$15000().ensureFieldAccessorsInitialized(DescriptorProtos$FileOptions.class, DescriptorProtos$FileOptions$Builder.class);
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
    public DescriptorProtos$FileOptions$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = DescriptorProtos$FileOptions.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (DescriptorProtos$FileOptions)object;
            if (object == null) break block7;
            this.mergeFrom((DescriptorProtos$FileOptions)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (DescriptorProtos$FileOptions)object2;
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
            this.mergeFrom((DescriptorProtos$FileOptions)object3);
        }
        throw var1_6;
    }

    public DescriptorProtos$FileOptions$Builder mergeFrom(DescriptorProtos$FileOptions messageLite) {
        int n10;
        Object object = DescriptorProtos$FileOptions.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        int n11 = messageLite.hasJavaPackage();
        if (n11 != 0) {
            this.bitField0_ = n11 = this.bitField0_ | 1;
            this.javaPackage_ = object = DescriptorProtos$FileOptions.access$15400(messageLite);
            this.onChanged();
        }
        if ((n11 = messageLite.hasJavaOuterClassname()) != 0) {
            this.bitField0_ = n11 = this.bitField0_ | 2;
            this.javaOuterClassname_ = object = DescriptorProtos$FileOptions.access$15500(messageLite);
            this.onChanged();
        }
        if ((n11 = (int)(messageLite.hasJavaMultipleFiles() ? 1 : 0)) != 0) {
            n11 = (int)(messageLite.getJavaMultipleFiles() ? 1 : 0);
            this.setJavaMultipleFiles(n11 != 0);
        }
        if ((n11 = (int)(messageLite.hasJavaGenerateEqualsAndHash() ? 1 : 0)) != 0) {
            n11 = messageLite.getJavaGenerateEqualsAndHash();
            this.setJavaGenerateEqualsAndHash(n11 != 0);
        }
        if ((n11 = messageLite.hasJavaStringCheckUtf8()) != 0) {
            n11 = messageLite.getJavaStringCheckUtf8();
            this.setJavaStringCheckUtf8(n11 != 0);
        }
        if ((n11 = messageLite.hasOptimizeFor()) != 0) {
            object = messageLite.getOptimizeFor();
            this.setOptimizeFor((DescriptorProtos$FileOptions$OptimizeMode)object);
        }
        if ((n11 = messageLite.hasGoPackage()) != 0) {
            this.bitField0_ = n11 = this.bitField0_ | 0x40;
            this.goPackage_ = object = DescriptorProtos$FileOptions.access$16000(messageLite);
            this.onChanged();
        }
        if ((n11 = messageLite.hasCcGenericServices()) != 0) {
            n11 = (int)(messageLite.getCcGenericServices() ? 1 : 0);
            this.setCcGenericServices(n11 != 0);
        }
        if ((n11 = (int)(messageLite.hasJavaGenericServices() ? 1 : 0)) != 0) {
            n11 = messageLite.getJavaGenericServices();
            this.setJavaGenericServices(n11 != 0);
        }
        if ((n11 = messageLite.hasPyGenericServices()) != 0) {
            n11 = messageLite.getPyGenericServices();
            this.setPyGenericServices(n11 != 0);
        }
        if ((n11 = messageLite.hasPhpGenericServices()) != 0) {
            n11 = messageLite.getPhpGenericServices();
            this.setPhpGenericServices(n11 != 0);
        }
        if ((n11 = messageLite.hasDeprecated()) != 0) {
            n11 = messageLite.getDeprecated();
            this.setDeprecated(n11 != 0);
        }
        if ((n11 = messageLite.hasCcEnableArenas()) != 0) {
            n11 = messageLite.getCcEnableArenas();
            this.setCcEnableArenas(n11 != 0);
        }
        if ((n11 = messageLite.hasObjcClassPrefix()) != 0) {
            this.bitField0_ = n11 = this.bitField0_ | 0x2000;
            this.objcClassPrefix_ = object = DescriptorProtos$FileOptions.access$16700(messageLite);
            this.onChanged();
        }
        if ((n11 = messageLite.hasCsharpNamespace()) != 0) {
            this.bitField0_ = n11 = this.bitField0_ | 0x4000;
            this.csharpNamespace_ = object = DescriptorProtos$FileOptions.access$16800(messageLite);
            this.onChanged();
        }
        if ((n11 = (int)(messageLite.hasSwiftPrefix() ? 1 : 0)) != 0) {
            n11 = this.bitField0_;
            n10 = 32768;
            this.bitField0_ = n11 |= n10;
            this.swiftPrefix_ = object = DescriptorProtos$FileOptions.access$16900(messageLite);
            this.onChanged();
        }
        if ((n11 = (int)(messageLite.hasPhpClassPrefix() ? 1 : 0)) != 0) {
            n11 = this.bitField0_;
            n10 = 65536;
            this.bitField0_ = n11 |= n10;
            this.phpClassPrefix_ = object = DescriptorProtos$FileOptions.access$17000(messageLite);
            this.onChanged();
        }
        if ((n11 = (int)(messageLite.hasPhpNamespace() ? 1 : 0)) != 0) {
            n11 = this.bitField0_;
            n10 = 131072;
            this.bitField0_ = n11 |= n10;
            this.phpNamespace_ = object = DescriptorProtos$FileOptions.access$17100(messageLite);
            this.onChanged();
        }
        if ((n11 = (int)(messageLite.hasPhpMetadataNamespace() ? 1 : 0)) != 0) {
            n11 = this.bitField0_;
            n10 = 262144;
            this.bitField0_ = n11 |= n10;
            this.phpMetadataNamespace_ = object = DescriptorProtos$FileOptions.access$17200(messageLite);
            this.onChanged();
        }
        if ((n11 = (int)(messageLite.hasRubyPackage() ? 1 : 0)) != 0) {
            n11 = this.bitField0_;
            n10 = 524288;
            this.bitField0_ = n11 |= n10;
            this.rubyPackage_ = object = DescriptorProtos$FileOptions.access$17300(messageLite);
            this.onChanged();
        }
        object = this.uninterpretedOptionBuilder_;
        n10 = -1048577;
        if (object == null) {
            object = DescriptorProtos$FileOptions.access$17400(messageLite);
            n11 = (int)(object.isEmpty() ? 1 : 0);
            if (n11 == 0) {
                object = this.uninterpretedOption_;
                n11 = (int)(object.isEmpty() ? 1 : 0);
                if (n11 != 0) {
                    this.uninterpretedOption_ = object = DescriptorProtos$FileOptions.access$17400(messageLite);
                    this.bitField0_ = n11 = this.bitField0_ & n10;
                } else {
                    this.ensureUninterpretedOptionIsMutable();
                    object = this.uninterpretedOption_;
                    List list = DescriptorProtos$FileOptions.access$17400(messageLite);
                    object.addAll(list);
                }
                this.onChanged();
            }
        } else {
            object = DescriptorProtos$FileOptions.access$17400(messageLite);
            n11 = (int)(object.isEmpty() ? 1 : 0);
            if (n11 == 0) {
                object = this.uninterpretedOptionBuilder_;
                n11 = (int)(((RepeatedFieldBuilderV3)object).isEmpty() ? 1 : 0);
                if (n11 != 0) {
                    List list;
                    this.uninterpretedOptionBuilder_.dispose();
                    n11 = 0;
                    object = null;
                    this.uninterpretedOptionBuilder_ = null;
                    this.uninterpretedOption_ = list = DescriptorProtos$FileOptions.access$17400(messageLite);
                    int n12 = this.bitField0_;
                    this.bitField0_ = n10 &= n12;
                    n10 = (int)(GeneratedMessageV3.alwaysUseFieldBuilders ? 1 : 0);
                    if (n10 != 0) {
                        object = this.getUninterpretedOptionFieldBuilder();
                    }
                    this.uninterpretedOptionBuilder_ = object;
                } else {
                    object = this.uninterpretedOptionBuilder_;
                    List list = DescriptorProtos$FileOptions.access$17400(messageLite);
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

    public DescriptorProtos$FileOptions$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof DescriptorProtos$FileOptions;
        if (bl2) {
            message = (DescriptorProtos$FileOptions)message;
            return this.mergeFrom((DescriptorProtos$FileOptions)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final DescriptorProtos$FileOptions$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$FileOptions$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public DescriptorProtos$FileOptions$Builder removeUninterpretedOption(int n10) {
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

    public DescriptorProtos$FileOptions$Builder setCcEnableArenas(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x1000;
        this.ccEnableArenas_ = bl2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder setCcGenericServices(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x80;
        this.ccGenericServices_ = bl2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder setCsharpNamespace(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x4000;
        this.csharpNamespace_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder setCsharpNamespaceBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x4000;
        this.csharpNamespace_ = byteString;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder setDeprecated(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x800;
        this.deprecated_ = bl2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder setExtension(GeneratedMessage$GeneratedExtension generatedMessage$GeneratedExtension, int n10, Object object) {
        return (DescriptorProtos$FileOptions$Builder)super.setExtension(generatedMessage$GeneratedExtension, n10, object);
    }

    public DescriptorProtos$FileOptions$Builder setExtension(GeneratedMessage$GeneratedExtension generatedMessage$GeneratedExtension, Object object) {
        return (DescriptorProtos$FileOptions$Builder)super.setExtension(generatedMessage$GeneratedExtension, object);
    }

    public DescriptorProtos$FileOptions$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$FileOptions$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$FileOptions$Builder setGoPackage(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x40;
        this.goPackage_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder setGoPackageBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x40;
        this.goPackage_ = byteString;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder setJavaGenerateEqualsAndHash(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 8;
        this.javaGenerateEqualsAndHash_ = bl2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder setJavaGenericServices(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x100;
        this.javaGenericServices_ = bl2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder setJavaMultipleFiles(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.javaMultipleFiles_ = bl2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder setJavaOuterClassname(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.javaOuterClassname_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder setJavaOuterClassnameBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.javaOuterClassname_ = byteString;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder setJavaPackage(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.javaPackage_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder setJavaPackageBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.javaPackage_ = byteString;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder setJavaStringCheckUtf8(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x10;
        this.javaStringCheckUtf8_ = bl2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder setObjcClassPrefix(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x2000;
        this.objcClassPrefix_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder setObjcClassPrefixBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x2000;
        this.objcClassPrefix_ = byteString;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder setOptimizeFor(DescriptorProtos$FileOptions$OptimizeMode descriptorProtos$FileOptions$OptimizeMode) {
        int n10;
        int n11;
        Objects.requireNonNull(descriptorProtos$FileOptions$OptimizeMode);
        this.bitField0_ = n11 = this.bitField0_ | 0x20;
        this.optimizeFor_ = n10 = descriptorProtos$FileOptions$OptimizeMode.getNumber();
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder setPhpClassPrefix(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x10000;
        this.phpClassPrefix_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder setPhpClassPrefixBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x10000;
        this.phpClassPrefix_ = byteString;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder setPhpGenericServices(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x400;
        this.phpGenericServices_ = bl2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder setPhpMetadataNamespace(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x40000;
        this.phpMetadataNamespace_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder setPhpMetadataNamespaceBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x40000;
        this.phpMetadataNamespace_ = byteString;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder setPhpNamespace(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x20000;
        this.phpNamespace_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder setPhpNamespaceBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x20000;
        this.phpNamespace_ = byteString;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder setPyGenericServices(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x200;
        this.pyGenericServices_ = bl2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (DescriptorProtos$FileOptions$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public DescriptorProtos$FileOptions$Builder setRubyPackage(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x80000;
        this.rubyPackage_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder setRubyPackageBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x80000;
        this.rubyPackage_ = byteString;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder setSwiftPrefix(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x8000;
        this.swiftPrefix_ = string2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder setSwiftPrefixBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x8000;
        this.swiftPrefix_ = byteString;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder setUninterpretedOption(int n10, DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOptionOrBuilder) {
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

    public DescriptorProtos$FileOptions$Builder setUninterpretedOption(int n10, DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
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

    public final DescriptorProtos$FileOptions$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$FileOptions$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

