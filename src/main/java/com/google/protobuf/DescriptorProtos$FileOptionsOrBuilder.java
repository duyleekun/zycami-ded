/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos$FileOptions$OptimizeMode;
import com.google.protobuf.DescriptorProtos$UninterpretedOption;
import com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder;
import com.google.protobuf.GeneratedMessageV3$ExtendableMessageOrBuilder;
import java.util.List;

public interface DescriptorProtos$FileOptionsOrBuilder
extends GeneratedMessageV3$ExtendableMessageOrBuilder {
    public boolean getCcEnableArenas();

    public boolean getCcGenericServices();

    public String getCsharpNamespace();

    public ByteString getCsharpNamespaceBytes();

    public boolean getDeprecated();

    public String getGoPackage();

    public ByteString getGoPackageBytes();

    public boolean getJavaGenerateEqualsAndHash();

    public boolean getJavaGenericServices();

    public boolean getJavaMultipleFiles();

    public String getJavaOuterClassname();

    public ByteString getJavaOuterClassnameBytes();

    public String getJavaPackage();

    public ByteString getJavaPackageBytes();

    public boolean getJavaStringCheckUtf8();

    public String getObjcClassPrefix();

    public ByteString getObjcClassPrefixBytes();

    public DescriptorProtos$FileOptions$OptimizeMode getOptimizeFor();

    public String getPhpClassPrefix();

    public ByteString getPhpClassPrefixBytes();

    public boolean getPhpGenericServices();

    public String getPhpMetadataNamespace();

    public ByteString getPhpMetadataNamespaceBytes();

    public String getPhpNamespace();

    public ByteString getPhpNamespaceBytes();

    public boolean getPyGenericServices();

    public String getRubyPackage();

    public ByteString getRubyPackageBytes();

    public String getSwiftPrefix();

    public ByteString getSwiftPrefixBytes();

    public DescriptorProtos$UninterpretedOption getUninterpretedOption(int var1);

    public int getUninterpretedOptionCount();

    public List getUninterpretedOptionList();

    public DescriptorProtos$UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int var1);

    public List getUninterpretedOptionOrBuilderList();

    public boolean hasCcEnableArenas();

    public boolean hasCcGenericServices();

    public boolean hasCsharpNamespace();

    public boolean hasDeprecated();

    public boolean hasGoPackage();

    public boolean hasJavaGenerateEqualsAndHash();

    public boolean hasJavaGenericServices();

    public boolean hasJavaMultipleFiles();

    public boolean hasJavaOuterClassname();

    public boolean hasJavaPackage();

    public boolean hasJavaStringCheckUtf8();

    public boolean hasObjcClassPrefix();

    public boolean hasOptimizeFor();

    public boolean hasPhpClassPrefix();

    public boolean hasPhpGenericServices();

    public boolean hasPhpMetadataNamespace();

    public boolean hasPhpNamespace();

    public boolean hasPyGenericServices();

    public boolean hasRubyPackage();

    public boolean hasSwiftPrefix();
}

