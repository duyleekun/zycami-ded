/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$DescriptorProto;
import com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$FileDescriptorProto$1;
import com.google.protobuf.DescriptorProtos$FileDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$FileOptions;
import com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder;
import com.google.protobuf.DescriptorProtos$ServiceDescriptorProto;
import com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo;
import com.google.protobuf.DescriptorProtos$SourceCodeInfoOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.GeneratedMessageV3$UnusedPrivateParameter;
import com.google.protobuf.Internal$IntList;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$FileDescriptorProto
extends GeneratedMessageV3
implements DescriptorProtos$FileDescriptorProtoOrBuilder {
    private static final DescriptorProtos$FileDescriptorProto DEFAULT_INSTANCE;
    public static final int DEPENDENCY_FIELD_NUMBER = 3;
    public static final int ENUM_TYPE_FIELD_NUMBER = 5;
    public static final int EXTENSION_FIELD_NUMBER = 7;
    public static final int MESSAGE_TYPE_FIELD_NUMBER = 4;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 8;
    public static final int PACKAGE_FIELD_NUMBER = 2;
    public static final Parser PARSER;
    public static final int PUBLIC_DEPENDENCY_FIELD_NUMBER = 10;
    public static final int SERVICE_FIELD_NUMBER = 6;
    public static final int SOURCE_CODE_INFO_FIELD_NUMBER = 9;
    public static final int SYNTAX_FIELD_NUMBER = 12;
    public static final int WEAK_DEPENDENCY_FIELD_NUMBER = 11;
    private static final long serialVersionUID;
    private int bitField0_;
    private LazyStringList dependency_;
    private List enumType_;
    private List extension_;
    private byte memoizedIsInitialized;
    private List messageType_;
    private volatile Object name_;
    private DescriptorProtos$FileOptions options_;
    private volatile Object package_;
    private Internal$IntList publicDependency_;
    private List service_;
    private DescriptorProtos$SourceCodeInfo sourceCodeInfo_;
    private volatile Object syntax_;
    private Internal$IntList weakDependency_;

    static {
        Object object = new DescriptorProtos$FileDescriptorProto();
        DEFAULT_INSTANCE = object;
        PARSER = object = new DescriptorProtos$FileDescriptorProto$1();
    }

    private DescriptorProtos$FileDescriptorProto() {
        List list;
        this.memoizedIsInitialized = (byte)-1;
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
    }

    /*
     * Exception decompiling
     */
    private DescriptorProtos$FileDescriptorProto(CodedInputStream var1_1, ExtensionRegistryLite var2_7) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 91[TRYBLOCK] [306 : 1128->1131)] java.lang.Throwable
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

    public /* synthetic */ DescriptorProtos$FileDescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DescriptorProtos$1 descriptorProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private DescriptorProtos$FileDescriptorProto(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
        this.memoizedIsInitialized = (byte)-1;
    }

    public /* synthetic */ DescriptorProtos$FileDescriptorProto(GeneratedMessageV3$Builder generatedMessageV3$Builder, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ Object access$1200(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto) {
        return descriptorProtos$FileDescriptorProto.name_;
    }

    public static /* synthetic */ Object access$1202(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto, Object object) {
        descriptorProtos$FileDescriptorProto.name_ = object;
        return object;
    }

    public static /* synthetic */ Object access$1300(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto) {
        return descriptorProtos$FileDescriptorProto.package_;
    }

    public static /* synthetic */ Object access$1302(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto, Object object) {
        descriptorProtos$FileDescriptorProto.package_ = object;
        return object;
    }

    public static /* synthetic */ LazyStringList access$1400(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto) {
        return descriptorProtos$FileDescriptorProto.dependency_;
    }

    public static /* synthetic */ LazyStringList access$1402(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto, LazyStringList lazyStringList) {
        descriptorProtos$FileDescriptorProto.dependency_ = lazyStringList;
        return lazyStringList;
    }

    public static /* synthetic */ Internal$IntList access$1500(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto) {
        return descriptorProtos$FileDescriptorProto.publicDependency_;
    }

    public static /* synthetic */ Internal$IntList access$1502(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto, Internal$IntList internal$IntList) {
        descriptorProtos$FileDescriptorProto.publicDependency_ = internal$IntList;
        return internal$IntList;
    }

    public static /* synthetic */ Internal$IntList access$1600(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto) {
        return descriptorProtos$FileDescriptorProto.weakDependency_;
    }

    public static /* synthetic */ Internal$IntList access$1602(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto, Internal$IntList internal$IntList) {
        descriptorProtos$FileDescriptorProto.weakDependency_ = internal$IntList;
        return internal$IntList;
    }

    public static /* synthetic */ List access$1700(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto) {
        return descriptorProtos$FileDescriptorProto.messageType_;
    }

    public static /* synthetic */ List access$1702(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto, List list) {
        descriptorProtos$FileDescriptorProto.messageType_ = list;
        return list;
    }

    public static /* synthetic */ List access$1800(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto) {
        return descriptorProtos$FileDescriptorProto.enumType_;
    }

    public static /* synthetic */ List access$1802(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto, List list) {
        descriptorProtos$FileDescriptorProto.enumType_ = list;
        return list;
    }

    public static /* synthetic */ List access$1900(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto) {
        return descriptorProtos$FileDescriptorProto.service_;
    }

    public static /* synthetic */ List access$1902(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto, List list) {
        descriptorProtos$FileDescriptorProto.service_ = list;
        return list;
    }

    public static /* synthetic */ List access$2000(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto) {
        return descriptorProtos$FileDescriptorProto.extension_;
    }

    public static /* synthetic */ List access$2002(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto, List list) {
        descriptorProtos$FileDescriptorProto.extension_ = list;
        return list;
    }

    public static /* synthetic */ DescriptorProtos$FileOptions access$2102(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto, DescriptorProtos$FileOptions descriptorProtos$FileOptions) {
        descriptorProtos$FileDescriptorProto.options_ = descriptorProtos$FileOptions;
        return descriptorProtos$FileOptions;
    }

    public static /* synthetic */ DescriptorProtos$SourceCodeInfo access$2202(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto, DescriptorProtos$SourceCodeInfo descriptorProtos$SourceCodeInfo) {
        descriptorProtos$FileDescriptorProto.sourceCodeInfo_ = descriptorProtos$SourceCodeInfo;
        return descriptorProtos$SourceCodeInfo;
    }

    public static /* synthetic */ Object access$2300(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto) {
        return descriptorProtos$FileDescriptorProto.syntax_;
    }

    public static /* synthetic */ Object access$2302(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto, Object object) {
        descriptorProtos$FileDescriptorProto.syntax_ = object;
        return object;
    }

    public static /* synthetic */ int access$2402(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto, int n10) {
        descriptorProtos$FileDescriptorProto.bitField0_ = n10;
        return n10;
    }

    public static DescriptorProtos$FileDescriptorProto getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$700();
    }

    public static DescriptorProtos$FileDescriptorProto$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DescriptorProtos$FileDescriptorProto$Builder newBuilder(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$FileDescriptorProto);
    }

    public static DescriptorProtos$FileDescriptorProto parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$FileDescriptorProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$FileDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileDescriptorProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$FileDescriptorProto parseFrom(ByteString byteString) {
        return (DescriptorProtos$FileDescriptorProto)PARSER.parseFrom(byteString);
    }

    public static DescriptorProtos$FileDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileDescriptorProto)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DescriptorProtos$FileDescriptorProto parseFrom(CodedInputStream codedInputStream) {
        return (DescriptorProtos$FileDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static DescriptorProtos$FileDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$FileDescriptorProto parseFrom(InputStream inputStream) {
        return (DescriptorProtos$FileDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$FileDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$FileDescriptorProto parseFrom(ByteBuffer byteBuffer) {
        return (DescriptorProtos$FileDescriptorProto)PARSER.parseFrom(byteBuffer);
    }

    public static DescriptorProtos$FileDescriptorProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileDescriptorProto)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static DescriptorProtos$FileDescriptorProto parseFrom(byte[] byArray) {
        return (DescriptorProtos$FileDescriptorProto)PARSER.parseFrom(byArray);
    }

    public static DescriptorProtos$FileDescriptorProto parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileDescriptorProto)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2;
        boolean bl3 = true;
        if (object == this) {
            return bl3;
        }
        boolean bl4 = object instanceof DescriptorProtos$FileDescriptorProto;
        if (!bl4) {
            return super.equals(object);
        }
        object = (DescriptorProtos$FileDescriptorProto)object;
        bl4 = this.hasName();
        if (bl4 != (bl2 = ((DescriptorProtos$FileDescriptorProto)object).hasName())) {
            return false;
        }
        bl4 = this.hasName();
        if (bl4 && !(bl4 = ((String)(object3 = this.getName())).equals(object2 = ((DescriptorProtos$FileDescriptorProto)object).getName()))) {
            return false;
        }
        bl4 = this.hasPackage();
        if (bl4 != (bl2 = ((DescriptorProtos$FileDescriptorProto)object).hasPackage())) {
            return false;
        }
        bl4 = this.hasPackage();
        if (bl4 && !(bl4 = ((String)(object3 = this.getPackage())).equals(object2 = ((DescriptorProtos$FileDescriptorProto)object).getPackage()))) {
            return false;
        }
        object3 = this.getDependencyList();
        bl4 = object3.equals(object2 = ((DescriptorProtos$FileDescriptorProto)object).getDependencyList());
        if (!bl4) {
            return false;
        }
        object3 = this.getPublicDependencyList();
        bl4 = object3.equals(object2 = ((DescriptorProtos$FileDescriptorProto)object).getPublicDependencyList());
        if (!bl4) {
            return false;
        }
        object3 = this.getWeakDependencyList();
        bl4 = object3.equals(object2 = ((DescriptorProtos$FileDescriptorProto)object).getWeakDependencyList());
        if (!bl4) {
            return false;
        }
        object3 = this.getMessageTypeList();
        bl4 = object3.equals(object2 = ((DescriptorProtos$FileDescriptorProto)object).getMessageTypeList());
        if (!bl4) {
            return false;
        }
        object3 = this.getEnumTypeList();
        bl4 = object3.equals(object2 = ((DescriptorProtos$FileDescriptorProto)object).getEnumTypeList());
        if (!bl4) {
            return false;
        }
        object3 = this.getServiceList();
        bl4 = object3.equals(object2 = ((DescriptorProtos$FileDescriptorProto)object).getServiceList());
        if (!bl4) {
            return false;
        }
        object3 = this.getExtensionList();
        bl4 = object3.equals(object2 = ((DescriptorProtos$FileDescriptorProto)object).getExtensionList());
        if (!bl4) {
            return false;
        }
        bl4 = this.hasOptions();
        if (bl4 != (bl2 = ((DescriptorProtos$FileDescriptorProto)object).hasOptions())) {
            return false;
        }
        bl4 = this.hasOptions();
        if (bl4 && !(bl4 = ((DescriptorProtos$FileOptions)(object3 = this.getOptions())).equals(object2 = ((DescriptorProtos$FileDescriptorProto)object).getOptions()))) {
            return false;
        }
        bl4 = this.hasSourceCodeInfo();
        if (bl4 != (bl2 = ((DescriptorProtos$FileDescriptorProto)object).hasSourceCodeInfo())) {
            return false;
        }
        bl4 = this.hasSourceCodeInfo();
        if (bl4 && !(bl4 = ((DescriptorProtos$SourceCodeInfo)(object3 = this.getSourceCodeInfo())).equals(object2 = ((DescriptorProtos$FileDescriptorProto)object).getSourceCodeInfo()))) {
            return false;
        }
        bl4 = this.hasSyntax();
        if (bl4 != (bl2 = ((DescriptorProtos$FileDescriptorProto)object).hasSyntax())) {
            return false;
        }
        bl4 = this.hasSyntax();
        if (bl4 && !(bl4 = ((String)(object3 = this.getSyntax())).equals(object2 = ((DescriptorProtos$FileDescriptorProto)object).getSyntax()))) {
            return false;
        }
        object3 = this.unknownFields;
        object = ((GeneratedMessageV3)object).unknownFields;
        boolean bl5 = ((UnknownFieldSet)object3).equals(object);
        if (!bl5) {
            return false;
        }
        return bl3;
    }

    public DescriptorProtos$FileDescriptorProto getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
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
        return this.dependency_;
    }

    public DescriptorProtos$EnumDescriptorProto getEnumType(int n10) {
        return (DescriptorProtos$EnumDescriptorProto)this.enumType_.get(n10);
    }

    public int getEnumTypeCount() {
        return this.enumType_.size();
    }

    public List getEnumTypeList() {
        return this.enumType_;
    }

    public DescriptorProtos$EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(int n10) {
        return (DescriptorProtos$EnumDescriptorProtoOrBuilder)this.enumType_.get(n10);
    }

    public List getEnumTypeOrBuilderList() {
        return this.enumType_;
    }

    public DescriptorProtos$FieldDescriptorProto getExtension(int n10) {
        return (DescriptorProtos$FieldDescriptorProto)this.extension_.get(n10);
    }

    public int getExtensionCount() {
        return this.extension_.size();
    }

    public List getExtensionList() {
        return this.extension_;
    }

    public DescriptorProtos$FieldDescriptorProtoOrBuilder getExtensionOrBuilder(int n10) {
        return (DescriptorProtos$FieldDescriptorProtoOrBuilder)this.extension_.get(n10);
    }

    public List getExtensionOrBuilderList() {
        return this.extension_;
    }

    public DescriptorProtos$DescriptorProto getMessageType(int n10) {
        return (DescriptorProtos$DescriptorProto)this.messageType_.get(n10);
    }

    public int getMessageTypeCount() {
        return this.messageType_.size();
    }

    public List getMessageTypeList() {
        return this.messageType_;
    }

    public DescriptorProtos$DescriptorProtoOrBuilder getMessageTypeOrBuilder(int n10) {
        return (DescriptorProtos$DescriptorProtoOrBuilder)this.messageType_.get(n10);
    }

    public List getMessageTypeOrBuilderList() {
        return this.messageType_;
    }

    public String getName() {
        Object object = this.name_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.name_ = string2;
        }
        return string2;
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
        DescriptorProtos$FileOptions descriptorProtos$FileOptions = this.options_;
        if (descriptorProtos$FileOptions == null) {
            descriptorProtos$FileOptions = DescriptorProtos$FileOptions.getDefaultInstance();
        }
        return descriptorProtos$FileOptions;
    }

    public DescriptorProtos$FileOptionsOrBuilder getOptionsOrBuilder() {
        DescriptorProtos$FileOptions descriptorProtos$FileOptions = this.options_;
        if (descriptorProtos$FileOptions == null) {
            descriptorProtos$FileOptions = DescriptorProtos$FileOptions.getDefaultInstance();
        }
        return descriptorProtos$FileOptions;
    }

    public String getPackage() {
        Object object = this.package_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.package_ = string2;
        }
        return string2;
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

    public Parser getParserForType() {
        return PARSER;
    }

    public int getPublicDependency(int n10) {
        return this.publicDependency_.getInt(n10);
    }

    public int getPublicDependencyCount() {
        return this.publicDependency_.size();
    }

    public List getPublicDependencyList() {
        return this.publicDependency_;
    }

    public int getSerializedSize() {
        MessageLite messageLite;
        Object object;
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
        Object object4 = null;
        if ((n11 &= n12) != 0) {
            object3 = this.name_;
            n11 = GeneratedMessageV3.computeStringSize(n12, object3) + 0;
        } else {
            n11 = 0;
            object3 = null;
        }
        int n14 = this.bitField0_;
        int n15 = 2;
        if ((n14 &= n15) != 0) {
            object2 = this.package_;
            n14 = GeneratedMessageV3.computeStringSize(n15, object2);
            n11 += n14;
        }
        object2 = null;
        n15 = 0;
        Object object5 = null;
        for (n14 = 0; n14 < (n10 = (object = this.dependency_).size()); ++n14) {
            object = this.dependency_.getRaw(n14);
            n10 = GeneratedMessageV3.computeStringSizeNoTag(object);
            n15 += n10;
        }
        n11 += n15;
        n14 = this.getDependencyList().size() * n12;
        n11 += n14;
        n14 = 0;
        object2 = null;
        while (true) {
            object5 = this.messageType_;
            n15 = object5.size();
            n10 = 4;
            if (n14 >= n15) break;
            object5 = (MessageLite)this.messageType_.get(n14);
            n15 = CodedOutputStream.computeMessageSize(n10, (MessageLite)object5);
            n11 += n15;
            ++n14;
        }
        object2 = null;
        for (n14 = 0; n14 < (n15 = (object5 = this.enumType_).size()); ++n14) {
            messageLite = (MessageLite)this.enumType_.get(n14);
            n15 = CodedOutputStream.computeMessageSize(5, messageLite);
            n11 += n15;
        }
        object2 = null;
        for (n14 = 0; n14 < (n15 = (object5 = this.service_).size()); ++n14) {
            messageLite = (MessageLite)this.service_.get(n14);
            n15 = CodedOutputStream.computeMessageSize(6, messageLite);
            n11 += n15;
        }
        object2 = null;
        for (n14 = 0; n14 < (n15 = (object5 = this.extension_).size()); ++n14) {
            messageLite = (MessageLite)this.extension_.get(n14);
            n15 = CodedOutputStream.computeMessageSize(7, messageLite);
            n11 += n15;
        }
        n14 = this.bitField0_ & n10;
        n15 = 8;
        if (n14 != 0) {
            object2 = this.getOptions();
            n14 = CodedOutputStream.computeMessageSize(n15, (MessageLite)object2);
            n11 += n14;
        }
        if ((n14 = this.bitField0_ & n15) != 0) {
            object5 = this.getSourceCodeInfo();
            n14 = CodedOutputStream.computeMessageSize(9, (MessageLite)object5);
            n11 += n14;
        }
        object2 = null;
        n15 = 0;
        object5 = null;
        for (n14 = 0; n14 < (n10 = (object = this.publicDependency_).size()); ++n14) {
            object = this.publicDependency_;
            n10 = CodedOutputStream.computeInt32SizeNoTag(object.getInt(n14));
            n15 += n10;
        }
        n11 += n15;
        n14 = this.getPublicDependencyList().size() * n12;
        n11 += n14;
        n14 = 0;
        object2 = null;
        while (n13 < (n15 = (object5 = this.weakDependency_).size())) {
            object5 = this.weakDependency_;
            n15 = CodedOutputStream.computeInt32SizeNoTag(object5.getInt(n13));
            n14 += n15;
            ++n13;
        }
        n11 += n14;
        object4 = this.getWeakDependencyList();
        n13 = object4.size() * n12;
        n11 += n13;
        n12 = this.bitField0_ & 0x10;
        if (n12 != 0) {
            object4 = this.syntax_;
            n12 = GeneratedMessageV3.computeStringSize(12, object4);
            n11 += n12;
        }
        n12 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n11 += n12;
        return n11;
    }

    public DescriptorProtos$ServiceDescriptorProto getService(int n10) {
        return (DescriptorProtos$ServiceDescriptorProto)this.service_.get(n10);
    }

    public int getServiceCount() {
        return this.service_.size();
    }

    public List getServiceList() {
        return this.service_;
    }

    public DescriptorProtos$ServiceDescriptorProtoOrBuilder getServiceOrBuilder(int n10) {
        return (DescriptorProtos$ServiceDescriptorProtoOrBuilder)this.service_.get(n10);
    }

    public List getServiceOrBuilderList() {
        return this.service_;
    }

    public DescriptorProtos$SourceCodeInfo getSourceCodeInfo() {
        DescriptorProtos$SourceCodeInfo descriptorProtos$SourceCodeInfo = this.sourceCodeInfo_;
        if (descriptorProtos$SourceCodeInfo == null) {
            descriptorProtos$SourceCodeInfo = DescriptorProtos$SourceCodeInfo.getDefaultInstance();
        }
        return descriptorProtos$SourceCodeInfo;
    }

    public DescriptorProtos$SourceCodeInfoOrBuilder getSourceCodeInfoOrBuilder() {
        DescriptorProtos$SourceCodeInfo descriptorProtos$SourceCodeInfo = this.sourceCodeInfo_;
        if (descriptorProtos$SourceCodeInfo == null) {
            descriptorProtos$SourceCodeInfo = DescriptorProtos$SourceCodeInfo.getDefaultInstance();
        }
        return descriptorProtos$SourceCodeInfo;
    }

    public String getSyntax() {
        Object object = this.syntax_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.syntax_ = string2;
        }
        return string2;
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

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public int getWeakDependency(int n10) {
        return this.weakDependency_.getInt(n10);
    }

    public int getWeakDependencyCount() {
        return this.weakDependency_.size();
    }

    public List getWeakDependencyList() {
        return this.weakDependency_;
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

    public boolean hasPackage() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasSourceCodeInfo() {
        int n10 = this.bitField0_ & 8;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasSyntax() {
        int n10 = this.bitField0_ & 0x10;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        Object object = DescriptorProtos$FileDescriptorProto.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = (int)(this.hasName() ? 1 : 0);
        if (n11 != 0) {
            n10 = (n10 * 37 + 1) * 53;
            object = this.getName();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasPackage() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 2) * 53;
            object = this.getPackage();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = this.getDependencyCount()) > 0) {
            n10 = (n10 * 37 + 3) * 53;
            object = this.getDependencyList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = this.getPublicDependencyCount()) > 0) {
            n10 = (n10 * 37 + 10) * 53;
            object = this.getPublicDependencyList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = this.getWeakDependencyCount()) > 0) {
            n10 = (n10 * 37 + 11) * 53;
            object = this.getWeakDependencyList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = this.getMessageTypeCount()) > 0) {
            n10 = (n10 * 37 + 4) * 53;
            object = this.getMessageTypeList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = this.getEnumTypeCount()) > 0) {
            n10 = (n10 * 37 + 5) * 53;
            object = this.getEnumTypeList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = this.getServiceCount()) > 0) {
            n10 = (n10 * 37 + 6) * 53;
            object = this.getServiceList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = this.getExtensionCount()) > 0) {
            n10 = (n10 * 37 + 7) * 53;
            object = this.getExtensionList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasOptions() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 8) * 53;
            object = this.getOptions();
            n11 = ((DescriptorProtos$FileOptions)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasSourceCodeInfo() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 9) * 53;
            object = this.getSourceCodeInfo();
            n11 = ((DescriptorProtos$SourceCodeInfo)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasSyntax() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 12) * 53;
            object = this.getSyntax();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$800().ensureFieldAccessorsInitialized(DescriptorProtos$FileDescriptorProto.class, DescriptorProtos$FileDescriptorProto$Builder.class);
    }

    public final boolean isInitialized() {
        GeneratedMessageV3 generatedMessageV3;
        int n10;
        int n11 = this.memoizedIsInitialized;
        int n12 = 1;
        if (n11 == n12) {
            return n12 != 0;
        }
        if (n11 == 0) {
            return false;
        }
        DescriptorProtos$FileOptions descriptorProtos$FileOptions = null;
        for (n11 = 0; n11 < (n10 = this.getMessageTypeCount()); ++n11) {
            generatedMessageV3 = this.getMessageType(n11);
            n10 = (int)(((DescriptorProtos$DescriptorProto)generatedMessageV3).isInitialized() ? 1 : 0);
            if (n10 != 0) continue;
            this.memoizedIsInitialized = 0;
            return false;
        }
        descriptorProtos$FileOptions = null;
        for (n11 = 0; n11 < (n10 = this.getEnumTypeCount()); ++n11) {
            generatedMessageV3 = this.getEnumType(n11);
            n10 = (int)(((DescriptorProtos$EnumDescriptorProto)generatedMessageV3).isInitialized() ? 1 : 0);
            if (n10 != 0) continue;
            this.memoizedIsInitialized = 0;
            return false;
        }
        descriptorProtos$FileOptions = null;
        for (n11 = 0; n11 < (n10 = this.getServiceCount()); ++n11) {
            generatedMessageV3 = this.getService(n11);
            n10 = (int)(((DescriptorProtos$ServiceDescriptorProto)generatedMessageV3).isInitialized() ? 1 : 0);
            if (n10 != 0) continue;
            this.memoizedIsInitialized = 0;
            return false;
        }
        descriptorProtos$FileOptions = null;
        for (n11 = 0; n11 < (n10 = this.getExtensionCount()); ++n11) {
            generatedMessageV3 = this.getExtension(n11);
            n10 = (int)(((DescriptorProtos$FieldDescriptorProto)generatedMessageV3).isInitialized() ? 1 : 0);
            if (n10 != 0) continue;
            this.memoizedIsInitialized = 0;
            return false;
        }
        n11 = (int)(this.hasOptions() ? 1 : 0);
        if (n11 != 0 && (n11 = (descriptorProtos$FileOptions = this.getOptions()).isInitialized()) == 0) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        this.memoizedIsInitialized = (byte)n12;
        return n12 != 0;
    }

    public DescriptorProtos$FileDescriptorProto$Builder newBuilderForType() {
        return DescriptorProtos$FileDescriptorProto.newBuilder();
    }

    public DescriptorProtos$FileDescriptorProto$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        DescriptorProtos$FileDescriptorProto$Builder descriptorProtos$FileDescriptorProto$Builder = new DescriptorProtos$FileDescriptorProto$Builder(generatedMessageV3$BuilderParent, null);
        return descriptorProtos$FileDescriptorProto$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new DescriptorProtos$FileDescriptorProto();
        return object;
    }

    public DescriptorProtos$FileDescriptorProto$Builder toBuilder() {
        DescriptorProtos$FileDescriptorProtoOrBuilder descriptorProtos$FileDescriptorProtoOrBuilder = DEFAULT_INSTANCE;
        if (this == descriptorProtos$FileDescriptorProtoOrBuilder) {
            descriptorProtos$FileDescriptorProtoOrBuilder = new DescriptorProtos$FileDescriptorProto$Builder(null);
        } else {
            descriptorProtos$FileDescriptorProtoOrBuilder = new DescriptorProtos$FileDescriptorProto$Builder(null);
            descriptorProtos$FileDescriptorProtoOrBuilder = ((DescriptorProtos$FileDescriptorProto$Builder)descriptorProtos$FileDescriptorProtoOrBuilder).mergeFrom(this);
        }
        return descriptorProtos$FileDescriptorProtoOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        MessageLite messageLite;
        int n10;
        Object object;
        Object object2;
        int n11;
        Object object3;
        int n12 = this.bitField0_;
        int n13 = 1;
        if ((n12 &= n13) != 0) {
            object3 = this.name_;
            GeneratedMessageV3.writeString(codedOutputStream, n13, object3);
        }
        n12 = this.bitField0_;
        n13 = 2;
        if ((n12 &= n13) != 0) {
            object3 = this.package_;
            GeneratedMessageV3.writeString(codedOutputStream, n13, object3);
        }
        n12 = 0;
        object3 = null;
        Object object4 = null;
        for (n13 = 0; n13 < (n11 = (object2 = this.dependency_).size()); ++n13) {
            n11 = 3;
            object = this.dependency_.getRaw(n13);
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        n13 = 0;
        object4 = null;
        while (true) {
            object2 = this.messageType_;
            n11 = object2.size();
            n10 = 4;
            if (n13 >= n11) break;
            object2 = (MessageLite)this.messageType_.get(n13);
            codedOutputStream.writeMessage(n10, (MessageLite)object2);
            ++n13;
        }
        object4 = null;
        for (n13 = 0; n13 < (n11 = (object2 = this.enumType_).size()); ++n13) {
            n11 = 5;
            messageLite = (MessageLite)this.enumType_.get(n13);
            codedOutputStream.writeMessage(n11, messageLite);
        }
        object4 = null;
        for (n13 = 0; n13 < (n11 = (object2 = this.service_).size()); ++n13) {
            n11 = 6;
            messageLite = (MessageLite)this.service_.get(n13);
            codedOutputStream.writeMessage(n11, messageLite);
        }
        object4 = null;
        for (n13 = 0; n13 < (n11 = (object2 = this.extension_).size()); ++n13) {
            n11 = 7;
            messageLite = (MessageLite)this.extension_.get(n13);
            codedOutputStream.writeMessage(n11, messageLite);
        }
        n13 = this.bitField0_ & n10;
        n11 = 8;
        if (n13 != 0) {
            object4 = this.getOptions();
            codedOutputStream.writeMessage(n11, (MessageLite)object4);
        }
        if ((n13 = this.bitField0_ & n11) != 0) {
            n13 = 9;
            object2 = this.getSourceCodeInfo();
            codedOutputStream.writeMessage(n13, (MessageLite)object2);
        }
        object4 = null;
        for (n13 = 0; n13 < (n11 = (object2 = this.publicDependency_).size()); ++n13) {
            n11 = 10;
            object = this.publicDependency_;
            n10 = object.getInt(n13);
            codedOutputStream.writeInt32(n11, n10);
        }
        while (n12 < (n13 = (object4 = this.weakDependency_).size())) {
            n13 = 11;
            object2 = this.weakDependency_;
            n11 = object2.getInt(n12);
            codedOutputStream.writeInt32(n13, n11);
            ++n12;
        }
        n12 = this.bitField0_ & 0x10;
        if (n12 != 0) {
            n12 = 12;
            object4 = this.syntax_;
            GeneratedMessageV3.writeString(codedOutputStream, n12, object4);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

