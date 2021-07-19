/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$FileOptions$1;
import com.google.protobuf.DescriptorProtos$FileOptions$Builder;
import com.google.protobuf.DescriptorProtos$FileOptions$OptimizeMode;
import com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder;
import com.google.protobuf.DescriptorProtos$UninterpretedOption;
import com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$ExtendableBuilder;
import com.google.protobuf.GeneratedMessageV3$ExtendableMessage;
import com.google.protobuf.GeneratedMessageV3$ExtendableMessage$ExtensionWriter;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.GeneratedMessageV3$UnusedPrivateParameter;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class DescriptorProtos$FileOptions
extends GeneratedMessageV3$ExtendableMessage
implements DescriptorProtos$FileOptionsOrBuilder {
    public static final int CC_ENABLE_ARENAS_FIELD_NUMBER = 31;
    public static final int CC_GENERIC_SERVICES_FIELD_NUMBER = 16;
    public static final int CSHARP_NAMESPACE_FIELD_NUMBER = 37;
    private static final DescriptorProtos$FileOptions DEFAULT_INSTANCE;
    public static final int DEPRECATED_FIELD_NUMBER = 23;
    public static final int GO_PACKAGE_FIELD_NUMBER = 11;
    public static final int JAVA_GENERATE_EQUALS_AND_HASH_FIELD_NUMBER = 20;
    public static final int JAVA_GENERIC_SERVICES_FIELD_NUMBER = 17;
    public static final int JAVA_MULTIPLE_FILES_FIELD_NUMBER = 10;
    public static final int JAVA_OUTER_CLASSNAME_FIELD_NUMBER = 8;
    public static final int JAVA_PACKAGE_FIELD_NUMBER = 1;
    public static final int JAVA_STRING_CHECK_UTF8_FIELD_NUMBER = 27;
    public static final int OBJC_CLASS_PREFIX_FIELD_NUMBER = 36;
    public static final int OPTIMIZE_FOR_FIELD_NUMBER = 9;
    public static final Parser PARSER;
    public static final int PHP_CLASS_PREFIX_FIELD_NUMBER = 40;
    public static final int PHP_GENERIC_SERVICES_FIELD_NUMBER = 42;
    public static final int PHP_METADATA_NAMESPACE_FIELD_NUMBER = 44;
    public static final int PHP_NAMESPACE_FIELD_NUMBER = 41;
    public static final int PY_GENERIC_SERVICES_FIELD_NUMBER = 18;
    public static final int RUBY_PACKAGE_FIELD_NUMBER = 45;
    public static final int SWIFT_PREFIX_FIELD_NUMBER = 39;
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    private static final long serialVersionUID;
    private int bitField0_;
    private boolean ccEnableArenas_;
    private boolean ccGenericServices_;
    private volatile Object csharpNamespace_;
    private boolean deprecated_;
    private volatile Object goPackage_;
    private boolean javaGenerateEqualsAndHash_;
    private boolean javaGenericServices_;
    private boolean javaMultipleFiles_;
    private volatile Object javaOuterClassname_;
    private volatile Object javaPackage_;
    private boolean javaStringCheckUtf8_;
    private byte memoizedIsInitialized;
    private volatile Object objcClassPrefix_;
    private int optimizeFor_;
    private volatile Object phpClassPrefix_;
    private boolean phpGenericServices_;
    private volatile Object phpMetadataNamespace_;
    private volatile Object phpNamespace_;
    private boolean pyGenericServices_;
    private volatile Object rubyPackage_;
    private volatile Object swiftPrefix_;
    private List uninterpretedOption_;

    static {
        Object object = new DescriptorProtos$FileOptions();
        DEFAULT_INSTANCE = object;
        PARSER = object = new DescriptorProtos$FileOptions$1();
    }

    private DescriptorProtos$FileOptions() {
        Object object;
        this.memoizedIsInitialized = (byte)-1;
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
    }

    /*
     * Exception decompiling
     */
    private DescriptorProtos$FileOptions(CodedInputStream var1_1, ExtensionRegistryLite var2_7) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 61[TRYBLOCK] [273 : 1004->1007)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2289)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:414)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public /* synthetic */ DescriptorProtos$FileOptions(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DescriptorProtos$1 descriptorProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private DescriptorProtos$FileOptions(GeneratedMessageV3$ExtendableBuilder generatedMessageV3$ExtendableBuilder) {
        super(generatedMessageV3$ExtendableBuilder);
        this.memoizedIsInitialized = (byte)-1;
    }

    public /* synthetic */ DescriptorProtos$FileOptions(GeneratedMessageV3$ExtendableBuilder generatedMessageV3$ExtendableBuilder, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$ExtendableBuilder);
    }

    public static /* synthetic */ Object access$15400(DescriptorProtos$FileOptions descriptorProtos$FileOptions) {
        return descriptorProtos$FileOptions.javaPackage_;
    }

    public static /* synthetic */ Object access$15402(DescriptorProtos$FileOptions descriptorProtos$FileOptions, Object object) {
        descriptorProtos$FileOptions.javaPackage_ = object;
        return object;
    }

    public static /* synthetic */ Object access$15500(DescriptorProtos$FileOptions descriptorProtos$FileOptions) {
        return descriptorProtos$FileOptions.javaOuterClassname_;
    }

    public static /* synthetic */ Object access$15502(DescriptorProtos$FileOptions descriptorProtos$FileOptions, Object object) {
        descriptorProtos$FileOptions.javaOuterClassname_ = object;
        return object;
    }

    public static /* synthetic */ boolean access$15602(DescriptorProtos$FileOptions descriptorProtos$FileOptions, boolean bl2) {
        descriptorProtos$FileOptions.javaMultipleFiles_ = bl2;
        return bl2;
    }

    public static /* synthetic */ boolean access$15702(DescriptorProtos$FileOptions descriptorProtos$FileOptions, boolean bl2) {
        descriptorProtos$FileOptions.javaGenerateEqualsAndHash_ = bl2;
        return bl2;
    }

    public static /* synthetic */ boolean access$15802(DescriptorProtos$FileOptions descriptorProtos$FileOptions, boolean bl2) {
        descriptorProtos$FileOptions.javaStringCheckUtf8_ = bl2;
        return bl2;
    }

    public static /* synthetic */ int access$15902(DescriptorProtos$FileOptions descriptorProtos$FileOptions, int n10) {
        descriptorProtos$FileOptions.optimizeFor_ = n10;
        return n10;
    }

    public static /* synthetic */ Object access$16000(DescriptorProtos$FileOptions descriptorProtos$FileOptions) {
        return descriptorProtos$FileOptions.goPackage_;
    }

    public static /* synthetic */ Object access$16002(DescriptorProtos$FileOptions descriptorProtos$FileOptions, Object object) {
        descriptorProtos$FileOptions.goPackage_ = object;
        return object;
    }

    public static /* synthetic */ boolean access$16102(DescriptorProtos$FileOptions descriptorProtos$FileOptions, boolean bl2) {
        descriptorProtos$FileOptions.ccGenericServices_ = bl2;
        return bl2;
    }

    public static /* synthetic */ boolean access$16202(DescriptorProtos$FileOptions descriptorProtos$FileOptions, boolean bl2) {
        descriptorProtos$FileOptions.javaGenericServices_ = bl2;
        return bl2;
    }

    public static /* synthetic */ boolean access$16302(DescriptorProtos$FileOptions descriptorProtos$FileOptions, boolean bl2) {
        descriptorProtos$FileOptions.pyGenericServices_ = bl2;
        return bl2;
    }

    public static /* synthetic */ boolean access$16402(DescriptorProtos$FileOptions descriptorProtos$FileOptions, boolean bl2) {
        descriptorProtos$FileOptions.phpGenericServices_ = bl2;
        return bl2;
    }

    public static /* synthetic */ boolean access$16502(DescriptorProtos$FileOptions descriptorProtos$FileOptions, boolean bl2) {
        descriptorProtos$FileOptions.deprecated_ = bl2;
        return bl2;
    }

    public static /* synthetic */ boolean access$16602(DescriptorProtos$FileOptions descriptorProtos$FileOptions, boolean bl2) {
        descriptorProtos$FileOptions.ccEnableArenas_ = bl2;
        return bl2;
    }

    public static /* synthetic */ Object access$16700(DescriptorProtos$FileOptions descriptorProtos$FileOptions) {
        return descriptorProtos$FileOptions.objcClassPrefix_;
    }

    public static /* synthetic */ Object access$16702(DescriptorProtos$FileOptions descriptorProtos$FileOptions, Object object) {
        descriptorProtos$FileOptions.objcClassPrefix_ = object;
        return object;
    }

    public static /* synthetic */ Object access$16800(DescriptorProtos$FileOptions descriptorProtos$FileOptions) {
        return descriptorProtos$FileOptions.csharpNamespace_;
    }

    public static /* synthetic */ Object access$16802(DescriptorProtos$FileOptions descriptorProtos$FileOptions, Object object) {
        descriptorProtos$FileOptions.csharpNamespace_ = object;
        return object;
    }

    public static /* synthetic */ Object access$16900(DescriptorProtos$FileOptions descriptorProtos$FileOptions) {
        return descriptorProtos$FileOptions.swiftPrefix_;
    }

    public static /* synthetic */ Object access$16902(DescriptorProtos$FileOptions descriptorProtos$FileOptions, Object object) {
        descriptorProtos$FileOptions.swiftPrefix_ = object;
        return object;
    }

    public static /* synthetic */ Object access$17000(DescriptorProtos$FileOptions descriptorProtos$FileOptions) {
        return descriptorProtos$FileOptions.phpClassPrefix_;
    }

    public static /* synthetic */ Object access$17002(DescriptorProtos$FileOptions descriptorProtos$FileOptions, Object object) {
        descriptorProtos$FileOptions.phpClassPrefix_ = object;
        return object;
    }

    public static /* synthetic */ Object access$17100(DescriptorProtos$FileOptions descriptorProtos$FileOptions) {
        return descriptorProtos$FileOptions.phpNamespace_;
    }

    public static /* synthetic */ Object access$17102(DescriptorProtos$FileOptions descriptorProtos$FileOptions, Object object) {
        descriptorProtos$FileOptions.phpNamespace_ = object;
        return object;
    }

    public static /* synthetic */ Object access$17200(DescriptorProtos$FileOptions descriptorProtos$FileOptions) {
        return descriptorProtos$FileOptions.phpMetadataNamespace_;
    }

    public static /* synthetic */ Object access$17202(DescriptorProtos$FileOptions descriptorProtos$FileOptions, Object object) {
        descriptorProtos$FileOptions.phpMetadataNamespace_ = object;
        return object;
    }

    public static /* synthetic */ Object access$17300(DescriptorProtos$FileOptions descriptorProtos$FileOptions) {
        return descriptorProtos$FileOptions.rubyPackage_;
    }

    public static /* synthetic */ Object access$17302(DescriptorProtos$FileOptions descriptorProtos$FileOptions, Object object) {
        descriptorProtos$FileOptions.rubyPackage_ = object;
        return object;
    }

    public static /* synthetic */ List access$17400(DescriptorProtos$FileOptions descriptorProtos$FileOptions) {
        return descriptorProtos$FileOptions.uninterpretedOption_;
    }

    public static /* synthetic */ List access$17402(DescriptorProtos$FileOptions descriptorProtos$FileOptions, List list) {
        descriptorProtos$FileOptions.uninterpretedOption_ = list;
        return list;
    }

    public static /* synthetic */ int access$17502(DescriptorProtos$FileOptions descriptorProtos$FileOptions, int n10) {
        descriptorProtos$FileOptions.bitField0_ = n10;
        return n10;
    }

    public static DescriptorProtos$FileOptions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$14900();
    }

    public static DescriptorProtos$FileOptions$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DescriptorProtos$FileOptions$Builder newBuilder(DescriptorProtos$FileOptions descriptorProtos$FileOptions) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$FileOptions);
    }

    public static DescriptorProtos$FileOptions parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$FileOptions)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$FileOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileOptions)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$FileOptions parseFrom(ByteString byteString) {
        return (DescriptorProtos$FileOptions)PARSER.parseFrom(byteString);
    }

    public static DescriptorProtos$FileOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileOptions)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DescriptorProtos$FileOptions parseFrom(CodedInputStream codedInputStream) {
        return (DescriptorProtos$FileOptions)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static DescriptorProtos$FileOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileOptions)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$FileOptions parseFrom(InputStream inputStream) {
        return (DescriptorProtos$FileOptions)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$FileOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileOptions)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$FileOptions parseFrom(ByteBuffer byteBuffer) {
        return (DescriptorProtos$FileOptions)PARSER.parseFrom(byteBuffer);
    }

    public static DescriptorProtos$FileOptions parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileOptions)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static DescriptorProtos$FileOptions parseFrom(byte[] byArray) {
        return (DescriptorProtos$FileOptions)PARSER.parseFrom(byArray);
    }

    public static DescriptorProtos$FileOptions parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileOptions)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        int n10;
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        int n11 = object instanceof DescriptorProtos$FileOptions;
        if (n11 == 0) {
            return super.equals(object);
        }
        object = (DescriptorProtos$FileOptions)object;
        n11 = this.hasJavaPackage();
        if (n11 != (n10 = ((DescriptorProtos$FileOptions)object).hasJavaPackage())) {
            return false;
        }
        n11 = this.hasJavaPackage();
        if (n11 != 0 && (n11 = ((String)(object3 = this.getJavaPackage())).equals(object2 = ((DescriptorProtos$FileOptions)object).getJavaPackage())) == 0) {
            return false;
        }
        n11 = this.hasJavaOuterClassname();
        if (n11 != (n10 = ((DescriptorProtos$FileOptions)object).hasJavaOuterClassname())) {
            return false;
        }
        n11 = this.hasJavaOuterClassname();
        if (n11 != 0 && (n11 = ((String)(object3 = this.getJavaOuterClassname())).equals(object2 = ((DescriptorProtos$FileOptions)object).getJavaOuterClassname())) == 0) {
            return false;
        }
        n11 = this.hasJavaMultipleFiles();
        if (n11 != (n10 = ((DescriptorProtos$FileOptions)object).hasJavaMultipleFiles())) {
            return false;
        }
        n11 = this.hasJavaMultipleFiles();
        if (n11 != 0 && (n11 = this.getJavaMultipleFiles()) != (n10 = ((DescriptorProtos$FileOptions)object).getJavaMultipleFiles())) {
            return false;
        }
        n11 = this.hasJavaGenerateEqualsAndHash();
        if (n11 != (n10 = ((DescriptorProtos$FileOptions)object).hasJavaGenerateEqualsAndHash())) {
            return false;
        }
        n11 = this.hasJavaGenerateEqualsAndHash();
        if (n11 != 0 && (n11 = this.getJavaGenerateEqualsAndHash()) != (n10 = ((DescriptorProtos$FileOptions)object).getJavaGenerateEqualsAndHash())) {
            return false;
        }
        n11 = this.hasJavaStringCheckUtf8();
        if (n11 != (n10 = ((DescriptorProtos$FileOptions)object).hasJavaStringCheckUtf8())) {
            return false;
        }
        n11 = this.hasJavaStringCheckUtf8();
        if (n11 != 0 && (n11 = this.getJavaStringCheckUtf8()) != (n10 = ((DescriptorProtos$FileOptions)object).getJavaStringCheckUtf8())) {
            return false;
        }
        n11 = this.hasOptimizeFor();
        if (n11 != (n10 = ((DescriptorProtos$FileOptions)object).hasOptimizeFor())) {
            return false;
        }
        n11 = this.hasOptimizeFor();
        if (n11 != 0 && (n11 = this.optimizeFor_) != (n10 = ((DescriptorProtos$FileOptions)object).optimizeFor_)) {
            return false;
        }
        n11 = (int)(this.hasGoPackage() ? 1 : 0);
        if (n11 != (n10 = (int)(((DescriptorProtos$FileOptions)object).hasGoPackage() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasGoPackage() ? 1 : 0);
        if (n11 != 0 && (n11 = (int)(((String)(object3 = this.getGoPackage())).equals(object2 = ((DescriptorProtos$FileOptions)object).getGoPackage()) ? 1 : 0)) == 0) {
            return false;
        }
        n11 = (int)(this.hasCcGenericServices() ? 1 : 0);
        if (n11 != (n10 = (int)(((DescriptorProtos$FileOptions)object).hasCcGenericServices() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasCcGenericServices() ? 1 : 0);
        if (n11 != 0 && (n11 = (int)(this.getCcGenericServices() ? 1 : 0)) != (n10 = (int)(((DescriptorProtos$FileOptions)object).getCcGenericServices() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasJavaGenericServices() ? 1 : 0);
        if (n11 != (n10 = (int)(((DescriptorProtos$FileOptions)object).hasJavaGenericServices() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasJavaGenericServices() ? 1 : 0);
        if (n11 != 0 && (n11 = (int)(this.getJavaGenericServices() ? 1 : 0)) != (n10 = (int)(((DescriptorProtos$FileOptions)object).getJavaGenericServices() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasPyGenericServices() ? 1 : 0);
        if (n11 != (n10 = (int)(((DescriptorProtos$FileOptions)object).hasPyGenericServices() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasPyGenericServices() ? 1 : 0);
        if (n11 != 0 && (n11 = (int)(this.getPyGenericServices() ? 1 : 0)) != (n10 = (int)(((DescriptorProtos$FileOptions)object).getPyGenericServices() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasPhpGenericServices() ? 1 : 0);
        if (n11 != (n10 = (int)(((DescriptorProtos$FileOptions)object).hasPhpGenericServices() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasPhpGenericServices() ? 1 : 0);
        if (n11 != 0 && (n11 = (int)(this.getPhpGenericServices() ? 1 : 0)) != (n10 = (int)(((DescriptorProtos$FileOptions)object).getPhpGenericServices() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasDeprecated() ? 1 : 0);
        if (n11 != (n10 = (int)(((DescriptorProtos$FileOptions)object).hasDeprecated() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasDeprecated() ? 1 : 0);
        if (n11 != 0 && (n11 = (int)(this.getDeprecated() ? 1 : 0)) != (n10 = (int)(((DescriptorProtos$FileOptions)object).getDeprecated() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasCcEnableArenas() ? 1 : 0);
        if (n11 != (n10 = (int)(((DescriptorProtos$FileOptions)object).hasCcEnableArenas() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasCcEnableArenas() ? 1 : 0);
        if (n11 != 0 && (n11 = (int)(this.getCcEnableArenas() ? 1 : 0)) != (n10 = (int)(((DescriptorProtos$FileOptions)object).getCcEnableArenas() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasObjcClassPrefix() ? 1 : 0);
        if (n11 != (n10 = (int)(((DescriptorProtos$FileOptions)object).hasObjcClassPrefix() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasObjcClassPrefix() ? 1 : 0);
        if (n11 != 0 && (n11 = (int)(((String)(object3 = this.getObjcClassPrefix())).equals(object2 = ((DescriptorProtos$FileOptions)object).getObjcClassPrefix()) ? 1 : 0)) == 0) {
            return false;
        }
        n11 = (int)(this.hasCsharpNamespace() ? 1 : 0);
        if (n11 != (n10 = (int)(((DescriptorProtos$FileOptions)object).hasCsharpNamespace() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasCsharpNamespace() ? 1 : 0);
        if (n11 != 0 && (n11 = (int)(((String)(object3 = this.getCsharpNamespace())).equals(object2 = ((DescriptorProtos$FileOptions)object).getCsharpNamespace()) ? 1 : 0)) == 0) {
            return false;
        }
        n11 = (int)(this.hasSwiftPrefix() ? 1 : 0);
        if (n11 != (n10 = (int)(((DescriptorProtos$FileOptions)object).hasSwiftPrefix() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasSwiftPrefix() ? 1 : 0);
        if (n11 != 0 && (n11 = (int)(((String)(object3 = this.getSwiftPrefix())).equals(object2 = ((DescriptorProtos$FileOptions)object).getSwiftPrefix()) ? 1 : 0)) == 0) {
            return false;
        }
        n11 = (int)(this.hasPhpClassPrefix() ? 1 : 0);
        if (n11 != (n10 = (int)(((DescriptorProtos$FileOptions)object).hasPhpClassPrefix() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasPhpClassPrefix() ? 1 : 0);
        if (n11 != 0 && (n11 = (int)(((String)(object3 = this.getPhpClassPrefix())).equals(object2 = ((DescriptorProtos$FileOptions)object).getPhpClassPrefix()) ? 1 : 0)) == 0) {
            return false;
        }
        n11 = (int)(this.hasPhpNamespace() ? 1 : 0);
        if (n11 != (n10 = (int)(((DescriptorProtos$FileOptions)object).hasPhpNamespace() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasPhpNamespace() ? 1 : 0);
        if (n11 != 0 && (n11 = (int)(((String)(object3 = this.getPhpNamespace())).equals(object2 = ((DescriptorProtos$FileOptions)object).getPhpNamespace()) ? 1 : 0)) == 0) {
            return false;
        }
        n11 = (int)(this.hasPhpMetadataNamespace() ? 1 : 0);
        if (n11 != (n10 = (int)(((DescriptorProtos$FileOptions)object).hasPhpMetadataNamespace() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasPhpMetadataNamespace() ? 1 : 0);
        if (n11 != 0 && (n11 = (int)(((String)(object3 = this.getPhpMetadataNamespace())).equals(object2 = ((DescriptorProtos$FileOptions)object).getPhpMetadataNamespace()) ? 1 : 0)) == 0) {
            return false;
        }
        n11 = (int)(this.hasRubyPackage() ? 1 : 0);
        if (n11 != (n10 = (int)(((DescriptorProtos$FileOptions)object).hasRubyPackage() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasRubyPackage() ? 1 : 0);
        if (n11 != 0 && (n11 = (int)(((String)(object3 = this.getRubyPackage())).equals(object2 = ((DescriptorProtos$FileOptions)object).getRubyPackage()) ? 1 : 0)) == 0) {
            return false;
        }
        object3 = this.getUninterpretedOptionList();
        n11 = (int)(object3.equals(object2 = ((DescriptorProtos$FileOptions)object).getUninterpretedOptionList()) ? 1 : 0);
        if (n11 == 0) {
            return false;
        }
        object3 = this.unknownFields;
        object2 = ((GeneratedMessageV3)object).unknownFields;
        n11 = (int)(((UnknownFieldSet)object3).equals(object2) ? 1 : 0);
        if (n11 == 0) {
            return false;
        }
        object3 = this.getExtensionFields();
        boolean bl3 = object3.equals(object = ((GeneratedMessageV3$ExtendableMessage)object).getExtensionFields());
        if (!bl3) {
            return false;
        }
        return bl2;
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
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.csharpNamespace_ = string2;
        }
        return string2;
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
        return DEFAULT_INSTANCE;
    }

    public boolean getDeprecated() {
        return this.deprecated_;
    }

    public String getGoPackage() {
        Object object = this.goPackage_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.goPackage_ = string2;
        }
        return string2;
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
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.javaOuterClassname_ = string2;
        }
        return string2;
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
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.javaPackage_ = string2;
        }
        return string2;
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
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.objcClassPrefix_ = string2;
        }
        return string2;
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

    public Parser getParserForType() {
        return PARSER;
    }

    public String getPhpClassPrefix() {
        Object object = this.phpClassPrefix_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.phpClassPrefix_ = string2;
        }
        return string2;
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
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.phpMetadataNamespace_ = string2;
        }
        return string2;
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
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.phpNamespace_ = string2;
        }
        return string2;
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
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.rubyPackage_ = string2;
        }
        return string2;
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

    public int getSerializedSize() {
        Object object;
        boolean bl2;
        int n10;
        Object object2;
        Object object3;
        int n11 = this.memoizedSize;
        int n12 = -1;
        if (n11 != n12) {
            return n11;
        }
        n11 = this.bitField0_;
        n12 = 1;
        int n13 = 0;
        if ((n11 &= n12) != 0) {
            object3 = this.javaPackage_;
            n11 = GeneratedMessageV3.computeStringSize(n12, object3) + 0;
        } else {
            n11 = 0;
            object3 = null;
        }
        n12 = this.bitField0_ & 2;
        int n14 = 8;
        if (n12 != 0) {
            object2 = this.javaOuterClassname_;
            n12 = GeneratedMessageV3.computeStringSize(n14, object2);
            n11 += n12;
        }
        if ((n12 = this.bitField0_ & 0x20) != 0) {
            n10 = this.optimizeFor_;
            n12 = CodedOutputStream.computeEnumSize(9, n10);
            n11 += n12;
        }
        if ((n12 = this.bitField0_ & 4) != 0) {
            n10 = (int)(this.javaMultipleFiles_ ? 1 : 0);
            n12 = CodedOutputStream.computeBoolSize(10, n10 != 0);
            n11 += n12;
        }
        if ((n12 = this.bitField0_ & 0x40) != 0) {
            Object object4 = this.goPackage_;
            n12 = GeneratedMessageV3.computeStringSize(11, object4);
            n11 += n12;
        }
        n12 = this.bitField0_ & 0x80;
        n10 = 16;
        if (n12 != 0) {
            n12 = (int)(this.ccGenericServices_ ? 1 : 0);
            n12 = CodedOutputStream.computeBoolSize(n10, n12 != 0);
            n11 += n12;
        }
        if ((n12 = this.bitField0_ & 0x100) != 0) {
            bl2 = this.javaGenericServices_;
            n12 = CodedOutputStream.computeBoolSize(17, bl2);
            n11 += n12;
        }
        if ((n12 = this.bitField0_ & 0x200) != 0) {
            bl2 = this.pyGenericServices_;
            n12 = CodedOutputStream.computeBoolSize(18, bl2);
            n11 += n12;
        }
        if ((n12 = this.bitField0_ & n14) != 0) {
            n14 = (int)(this.javaGenerateEqualsAndHash_ ? 1 : 0);
            n12 = CodedOutputStream.computeBoolSize(20, n14 != 0);
            n11 += n12;
        }
        if ((n12 = this.bitField0_ & 0x800) != 0) {
            n14 = this.deprecated_;
            n12 = CodedOutputStream.computeBoolSize(23, n14 != 0);
            n11 += n12;
        }
        if ((n12 = this.bitField0_ & n10) != 0) {
            n14 = this.javaStringCheckUtf8_;
            n12 = CodedOutputStream.computeBoolSize(27, n14 != 0);
            n11 += n12;
        }
        if ((n12 = this.bitField0_ & 0x1000) != 0) {
            n14 = this.ccEnableArenas_;
            n12 = CodedOutputStream.computeBoolSize(31, n14 != 0);
            n11 += n12;
        }
        if ((n12 = this.bitField0_ & 0x2000) != 0) {
            object = this.objcClassPrefix_;
            n12 = GeneratedMessageV3.computeStringSize(36, object);
            n11 += n12;
        }
        if ((n12 = this.bitField0_ & 0x4000) != 0) {
            object = this.csharpNamespace_;
            n12 = GeneratedMessageV3.computeStringSize(37, object);
            n11 += n12;
        }
        n12 = this.bitField0_;
        n14 = 32768;
        if ((n12 &= n14) != 0) {
            object = this.swiftPrefix_;
            n12 = GeneratedMessageV3.computeStringSize(39, object);
            n11 += n12;
        }
        n12 = this.bitField0_;
        n14 = 65536;
        if ((n12 &= n14) != 0) {
            object = this.phpClassPrefix_;
            n12 = GeneratedMessageV3.computeStringSize(40, object);
            n11 += n12;
        }
        n12 = this.bitField0_;
        n14 = 131072;
        if ((n12 &= n14) != 0) {
            object = this.phpNamespace_;
            n12 = GeneratedMessageV3.computeStringSize(41, object);
            n11 += n12;
        }
        if ((n12 = this.bitField0_ & 0x400) != 0) {
            n14 = (int)(this.phpGenericServices_ ? 1 : 0);
            n12 = CodedOutputStream.computeBoolSize(42, n14 != 0);
            n11 += n12;
        }
        n12 = this.bitField0_;
        n14 = 262144;
        if ((n12 &= n14) != 0) {
            object = this.phpMetadataNamespace_;
            n12 = GeneratedMessageV3.computeStringSize(44, object);
            n11 += n12;
        }
        n12 = this.bitField0_;
        n14 = 524288;
        if ((n12 &= n14) != 0) {
            object = this.rubyPackage_;
            n12 = GeneratedMessageV3.computeStringSize(45, object);
            n11 += n12;
        }
        while (n13 < (n12 = (object2 = this.uninterpretedOption_).size())) {
            object = (MessageLite)this.uninterpretedOption_.get(n13);
            n12 = CodedOutputStream.computeMessageSize(999, (MessageLite)object);
            n11 += n12;
            ++n13;
        }
        n12 = this.extensionsSerializedSize();
        n11 += n12;
        n12 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n11 += n12;
        return n11;
    }

    public String getSwiftPrefix() {
        Object object = this.swiftPrefix_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.swiftPrefix_ = string2;
        }
        return string2;
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
        return (DescriptorProtos$UninterpretedOption)this.uninterpretedOption_.get(n10);
    }

    public int getUninterpretedOptionCount() {
        return this.uninterpretedOption_.size();
    }

    public List getUninterpretedOptionList() {
        return this.uninterpretedOption_;
    }

    public DescriptorProtos$UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int n10) {
        return (DescriptorProtos$UninterpretedOptionOrBuilder)this.uninterpretedOption_.get(n10);
    }

    public List getUninterpretedOptionOrBuilderList() {
        return this.uninterpretedOption_;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
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

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        Object object = DescriptorProtos$FileOptions.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = (int)(this.hasJavaPackage() ? 1 : 0);
        if (n11 != 0) {
            n10 = (n10 * 37 + 1) * 53;
            object = this.getJavaPackage();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasJavaOuterClassname() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 8) * 53;
            object = this.getJavaOuterClassname();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasJavaMultipleFiles() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 10) * 53;
            n11 = Internal.hashBoolean(this.getJavaMultipleFiles());
            n10 += n11;
        }
        if ((n11 = (int)(this.hasJavaGenerateEqualsAndHash() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 20) * 53;
            n11 = Internal.hashBoolean(this.getJavaGenerateEqualsAndHash());
            n10 += n11;
        }
        if ((n11 = (int)(this.hasJavaStringCheckUtf8() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 27) * 53;
            n11 = Internal.hashBoolean(this.getJavaStringCheckUtf8());
            n10 += n11;
        }
        if ((n11 = (int)(this.hasOptimizeFor() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 9) * 53;
            n11 = this.optimizeFor_;
            n10 += n11;
        }
        if ((n11 = (int)(this.hasGoPackage() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 11) * 53;
            object = this.getGoPackage();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasCcGenericServices() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 16) * 53;
            n11 = Internal.hashBoolean(this.getCcGenericServices());
            n10 += n11;
        }
        if ((n11 = (int)(this.hasJavaGenericServices() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 17) * 53;
            n11 = Internal.hashBoolean(this.getJavaGenericServices());
            n10 += n11;
        }
        if ((n11 = (int)(this.hasPyGenericServices() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 18) * 53;
            n11 = Internal.hashBoolean(this.getPyGenericServices());
            n10 += n11;
        }
        if ((n11 = (int)(this.hasPhpGenericServices() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 42) * 53;
            n11 = Internal.hashBoolean(this.getPhpGenericServices());
            n10 += n11;
        }
        if ((n11 = (int)(this.hasDeprecated() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 23) * 53;
            n11 = Internal.hashBoolean(this.getDeprecated());
            n10 += n11;
        }
        if ((n11 = (int)(this.hasCcEnableArenas() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 31) * 53;
            n11 = Internal.hashBoolean(this.getCcEnableArenas());
            n10 += n11;
        }
        if ((n11 = (int)(this.hasObjcClassPrefix() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 36) * 53;
            object = this.getObjcClassPrefix();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasCsharpNamespace() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 37) * 53;
            object = this.getCsharpNamespace();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasSwiftPrefix() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 39) * 53;
            object = this.getSwiftPrefix();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasPhpClassPrefix() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 40) * 53;
            object = this.getPhpClassPrefix();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasPhpNamespace() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 41) * 53;
            object = this.getPhpNamespace();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasPhpMetadataNamespace() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 44) * 53;
            object = this.getPhpMetadataNamespace();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasRubyPackage() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 45) * 53;
            object = this.getRubyPackage();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = this.getUninterpretedOptionCount()) > 0) {
            n10 = (n10 * 37 + 999) * 53;
            object = this.getUninterpretedOptionList();
            n11 = object.hashCode();
            n10 += n11;
        }
        object = this.getExtensionFields();
        n10 = AbstractMessage.hashFields(n10, (Map)object) * 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$15000().ensureFieldAccessorsInitialized(DescriptorProtos$FileOptions.class, DescriptorProtos$FileOptions$Builder.class);
    }

    public final boolean isInitialized() {
        int n10;
        int n11 = this.memoizedIsInitialized;
        int n12 = 1;
        if (n11 == n12) {
            return n12 != 0;
        }
        if (n11 == 0) {
            return false;
        }
        for (n11 = 0; n11 < (n10 = this.getUninterpretedOptionCount()); ++n11) {
            DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption = this.getUninterpretedOption(n11);
            n10 = (int)(descriptorProtos$UninterpretedOption.isInitialized() ? 1 : 0);
            if (n10 != 0) continue;
            this.memoizedIsInitialized = 0;
            return false;
        }
        n11 = (int)(this.extensionsAreInitialized() ? 1 : 0);
        if (n11 == 0) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        this.memoizedIsInitialized = (byte)n12;
        return n12 != 0;
    }

    public DescriptorProtos$FileOptions$Builder newBuilderForType() {
        return DescriptorProtos$FileOptions.newBuilder();
    }

    public DescriptorProtos$FileOptions$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        DescriptorProtos$FileOptions$Builder descriptorProtos$FileOptions$Builder = new DescriptorProtos$FileOptions$Builder(generatedMessageV3$BuilderParent, null);
        return descriptorProtos$FileOptions$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new DescriptorProtos$FileOptions();
        return object;
    }

    public DescriptorProtos$FileOptions$Builder toBuilder() {
        DescriptorProtos$FileOptionsOrBuilder descriptorProtos$FileOptionsOrBuilder = DEFAULT_INSTANCE;
        if (this == descriptorProtos$FileOptionsOrBuilder) {
            descriptorProtos$FileOptionsOrBuilder = new DescriptorProtos$FileOptions$Builder(null);
        } else {
            descriptorProtos$FileOptionsOrBuilder = new DescriptorProtos$FileOptions$Builder(null);
            descriptorProtos$FileOptionsOrBuilder = ((DescriptorProtos$FileOptions$Builder)descriptorProtos$FileOptionsOrBuilder).mergeFrom(this);
        }
        return descriptorProtos$FileOptionsOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        Object object;
        boolean bl2;
        Object object2;
        int n10;
        Object object3;
        GeneratedMessageV3$ExtendableMessage$ExtensionWriter generatedMessageV3$ExtendableMessage$ExtensionWriter = this.newExtensionWriter();
        int n11 = this.bitField0_;
        int n12 = 1;
        if ((n11 &= n12) != 0) {
            object3 = this.javaPackage_;
            GeneratedMessageV3.writeString(codedOutputStream, n12, object3);
        }
        n11 = this.bitField0_ & 2;
        n12 = 8;
        if (n11 != 0) {
            object3 = this.javaOuterClassname_;
            GeneratedMessageV3.writeString(codedOutputStream, n12, object3);
        }
        if ((n11 = this.bitField0_ & 0x20) != 0) {
            n11 = 9;
            n10 = this.optimizeFor_;
            codedOutputStream.writeEnum(n11, n10);
        }
        if ((n11 = this.bitField0_ & 4) != 0) {
            n11 = 10;
            n10 = (int)(this.javaMultipleFiles_ ? 1 : 0);
            codedOutputStream.writeBool(n11, n10 != 0);
        }
        if ((n11 = this.bitField0_ & 0x40) != 0) {
            n11 = 11;
            object2 = this.goPackage_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object2);
        }
        n11 = this.bitField0_ & 0x80;
        n10 = 16;
        if (n11 != 0) {
            n11 = (int)(this.ccGenericServices_ ? 1 : 0);
            codedOutputStream.writeBool(n10, n11 != 0);
        }
        if ((n11 = this.bitField0_ & 0x100) != 0) {
            n11 = 17;
            bl2 = this.javaGenericServices_;
            codedOutputStream.writeBool(n11, bl2);
        }
        if ((n11 = this.bitField0_ & 0x200) != 0) {
            n11 = 18;
            bl2 = this.pyGenericServices_;
            codedOutputStream.writeBool(n11, bl2);
        }
        if ((n11 = this.bitField0_ & n12) != 0) {
            n11 = 20;
            n12 = (int)(this.javaGenerateEqualsAndHash_ ? 1 : 0);
            codedOutputStream.writeBool(n11, n12 != 0);
        }
        if ((n11 = this.bitField0_ & 0x800) != 0) {
            n11 = 23;
            n12 = this.deprecated_;
            codedOutputStream.writeBool(n11, n12 != 0);
        }
        if ((n11 = this.bitField0_ & n10) != 0) {
            n11 = 27;
            n12 = this.javaStringCheckUtf8_;
            codedOutputStream.writeBool(n11, n12 != 0);
        }
        if ((n11 = this.bitField0_ & 0x1000) != 0) {
            n11 = 31;
            n12 = this.ccEnableArenas_;
            codedOutputStream.writeBool(n11, n12 != 0);
        }
        if ((n11 = this.bitField0_ & 0x2000) != 0) {
            n11 = 36;
            object = this.objcClassPrefix_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        if ((n11 = this.bitField0_ & 0x4000) != 0) {
            n11 = 37;
            object = this.csharpNamespace_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        n11 = this.bitField0_;
        n12 = 32768;
        if ((n11 &= n12) != 0) {
            n11 = 39;
            object = this.swiftPrefix_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        n11 = this.bitField0_;
        n12 = 65536;
        if ((n11 &= n12) != 0) {
            n11 = 40;
            object = this.phpClassPrefix_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        n11 = this.bitField0_;
        n12 = 131072;
        if ((n11 &= n12) != 0) {
            n11 = 41;
            object = this.phpNamespace_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        if ((n11 = this.bitField0_ & 0x400) != 0) {
            n11 = 42;
            n12 = (int)(this.phpGenericServices_ ? 1 : 0);
            codedOutputStream.writeBool(n11, n12 != 0);
        }
        n11 = this.bitField0_;
        n12 = 262144;
        if ((n11 &= n12) != 0) {
            n11 = 44;
            object = this.phpMetadataNamespace_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        n11 = this.bitField0_;
        n12 = 524288;
        if ((n11 &= n12) != 0) {
            n11 = 45;
            object = this.rubyPackage_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        object3 = null;
        for (n11 = 0; n11 < (n12 = (object = this.uninterpretedOption_).size()); ++n11) {
            n12 = 999;
            object2 = (MessageLite)this.uninterpretedOption_.get(n11);
            codedOutputStream.writeMessage(n12, (MessageLite)object2);
        }
        generatedMessageV3$ExtendableMessage$ExtensionWriter.writeUntil(0x20000000, codedOutputStream);
        this.unknownFields.writeTo(codedOutputStream);
    }
}

