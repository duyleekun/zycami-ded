/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$DescriptorProto$1;
import com.google.protobuf.DescriptorProtos$DescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRange;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRange;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder;
import com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$MessageOptions;
import com.google.protobuf.DescriptorProtos$MessageOptionsOrBuilder;
import com.google.protobuf.DescriptorProtos$OneofDescriptorProto;
import com.google.protobuf.DescriptorProtos$OneofDescriptorProtoOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.GeneratedMessageV3$UnusedPrivateParameter;
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

public final class DescriptorProtos$DescriptorProto
extends GeneratedMessageV3
implements DescriptorProtos$DescriptorProtoOrBuilder {
    private static final DescriptorProtos$DescriptorProto DEFAULT_INSTANCE;
    public static final int ENUM_TYPE_FIELD_NUMBER = 4;
    public static final int EXTENSION_FIELD_NUMBER = 6;
    public static final int EXTENSION_RANGE_FIELD_NUMBER = 5;
    public static final int FIELD_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int NESTED_TYPE_FIELD_NUMBER = 3;
    public static final int ONEOF_DECL_FIELD_NUMBER = 8;
    public static final int OPTIONS_FIELD_NUMBER = 7;
    public static final Parser PARSER;
    public static final int RESERVED_NAME_FIELD_NUMBER = 10;
    public static final int RESERVED_RANGE_FIELD_NUMBER = 9;
    private static final long serialVersionUID;
    private int bitField0_;
    private List enumType_;
    private List extensionRange_;
    private List extension_;
    private List field_;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private List nestedType_;
    private List oneofDecl_;
    private DescriptorProtos$MessageOptions options_;
    private LazyStringList reservedName_;
    private List reservedRange_;

    static {
        Object object = new DescriptorProtos$DescriptorProto();
        DEFAULT_INSTANCE = object;
        PARSER = object = new DescriptorProtos$DescriptorProto$1();
    }

    private DescriptorProtos$DescriptorProto() {
        LazyStringList lazyStringList;
        this.memoizedIsInitialized = (byte)-1;
        this.name_ = "";
        this.field_ = lazyStringList = Collections.emptyList();
        this.extension_ = lazyStringList = Collections.emptyList();
        this.nestedType_ = lazyStringList = Collections.emptyList();
        this.enumType_ = lazyStringList = Collections.emptyList();
        this.extensionRange_ = lazyStringList = Collections.emptyList();
        this.oneofDecl_ = lazyStringList = Collections.emptyList();
        this.reservedRange_ = lazyStringList = Collections.emptyList();
        this.reservedName_ = lazyStringList = LazyStringArrayList.EMPTY;
    }

    /*
     * Exception decompiling
     */
    private DescriptorProtos$DescriptorProto(CodedInputStream var1_1, ExtensionRegistryLite var2_7) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 70[TRYBLOCK] [219 : 837->840)] java.lang.Throwable
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

    public /* synthetic */ DescriptorProtos$DescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DescriptorProtos$1 descriptorProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private DescriptorProtos$DescriptorProto(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
        this.memoizedIsInitialized = (byte)-1;
    }

    public /* synthetic */ DescriptorProtos$DescriptorProto(GeneratedMessageV3$Builder generatedMessageV3$Builder, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ Object access$5000(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        return descriptorProtos$DescriptorProto.name_;
    }

    public static /* synthetic */ Object access$5002(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto, Object object) {
        descriptorProtos$DescriptorProto.name_ = object;
        return object;
    }

    public static /* synthetic */ List access$5100(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        return descriptorProtos$DescriptorProto.field_;
    }

    public static /* synthetic */ List access$5102(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto, List list) {
        descriptorProtos$DescriptorProto.field_ = list;
        return list;
    }

    public static /* synthetic */ List access$5200(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        return descriptorProtos$DescriptorProto.extension_;
    }

    public static /* synthetic */ List access$5202(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto, List list) {
        descriptorProtos$DescriptorProto.extension_ = list;
        return list;
    }

    public static /* synthetic */ List access$5300(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        return descriptorProtos$DescriptorProto.nestedType_;
    }

    public static /* synthetic */ List access$5302(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto, List list) {
        descriptorProtos$DescriptorProto.nestedType_ = list;
        return list;
    }

    public static /* synthetic */ List access$5400(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        return descriptorProtos$DescriptorProto.enumType_;
    }

    public static /* synthetic */ List access$5402(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto, List list) {
        descriptorProtos$DescriptorProto.enumType_ = list;
        return list;
    }

    public static /* synthetic */ List access$5500(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        return descriptorProtos$DescriptorProto.extensionRange_;
    }

    public static /* synthetic */ List access$5502(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto, List list) {
        descriptorProtos$DescriptorProto.extensionRange_ = list;
        return list;
    }

    public static /* synthetic */ List access$5600(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        return descriptorProtos$DescriptorProto.oneofDecl_;
    }

    public static /* synthetic */ List access$5602(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto, List list) {
        descriptorProtos$DescriptorProto.oneofDecl_ = list;
        return list;
    }

    public static /* synthetic */ DescriptorProtos$MessageOptions access$5702(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto, DescriptorProtos$MessageOptions descriptorProtos$MessageOptions) {
        descriptorProtos$DescriptorProto.options_ = descriptorProtos$MessageOptions;
        return descriptorProtos$MessageOptions;
    }

    public static /* synthetic */ List access$5800(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        return descriptorProtos$DescriptorProto.reservedRange_;
    }

    public static /* synthetic */ List access$5802(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto, List list) {
        descriptorProtos$DescriptorProto.reservedRange_ = list;
        return list;
    }

    public static /* synthetic */ LazyStringList access$5900(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        return descriptorProtos$DescriptorProto.reservedName_;
    }

    public static /* synthetic */ LazyStringList access$5902(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto, LazyStringList lazyStringList) {
        descriptorProtos$DescriptorProto.reservedName_ = lazyStringList;
        return lazyStringList;
    }

    public static /* synthetic */ int access$6002(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto, int n10) {
        descriptorProtos$DescriptorProto.bitField0_ = n10;
        return n10;
    }

    public static DescriptorProtos$DescriptorProto getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$2600();
    }

    public static DescriptorProtos$DescriptorProto$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DescriptorProtos$DescriptorProto$Builder newBuilder(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$DescriptorProto);
    }

    public static DescriptorProtos$DescriptorProto parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$DescriptorProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$DescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$DescriptorProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$DescriptorProto parseFrom(ByteString byteString) {
        return (DescriptorProtos$DescriptorProto)PARSER.parseFrom(byteString);
    }

    public static DescriptorProtos$DescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$DescriptorProto)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DescriptorProtos$DescriptorProto parseFrom(CodedInputStream codedInputStream) {
        return (DescriptorProtos$DescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static DescriptorProtos$DescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$DescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$DescriptorProto parseFrom(InputStream inputStream) {
        return (DescriptorProtos$DescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$DescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$DescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$DescriptorProto parseFrom(ByteBuffer byteBuffer) {
        return (DescriptorProtos$DescriptorProto)PARSER.parseFrom(byteBuffer);
    }

    public static DescriptorProtos$DescriptorProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$DescriptorProto)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static DescriptorProtos$DescriptorProto parseFrom(byte[] byArray) {
        return (DescriptorProtos$DescriptorProto)PARSER.parseFrom(byArray);
    }

    public static DescriptorProtos$DescriptorProto parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$DescriptorProto)PARSER.parseFrom(byArray, extensionRegistryLite);
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
        boolean bl4 = object instanceof DescriptorProtos$DescriptorProto;
        if (!bl4) {
            return super.equals(object);
        }
        object = (DescriptorProtos$DescriptorProto)object;
        bl4 = this.hasName();
        if (bl4 != (bl2 = ((DescriptorProtos$DescriptorProto)object).hasName())) {
            return false;
        }
        bl4 = this.hasName();
        if (bl4 && !(bl4 = ((String)(object3 = this.getName())).equals(object2 = ((DescriptorProtos$DescriptorProto)object).getName()))) {
            return false;
        }
        object3 = this.getFieldList();
        bl4 = object3.equals(object2 = ((DescriptorProtos$DescriptorProto)object).getFieldList());
        if (!bl4) {
            return false;
        }
        object3 = this.getExtensionList();
        bl4 = object3.equals(object2 = ((DescriptorProtos$DescriptorProto)object).getExtensionList());
        if (!bl4) {
            return false;
        }
        object3 = this.getNestedTypeList();
        bl4 = object3.equals(object2 = ((DescriptorProtos$DescriptorProto)object).getNestedTypeList());
        if (!bl4) {
            return false;
        }
        object3 = this.getEnumTypeList();
        bl4 = object3.equals(object2 = ((DescriptorProtos$DescriptorProto)object).getEnumTypeList());
        if (!bl4) {
            return false;
        }
        object3 = this.getExtensionRangeList();
        bl4 = object3.equals(object2 = ((DescriptorProtos$DescriptorProto)object).getExtensionRangeList());
        if (!bl4) {
            return false;
        }
        object3 = this.getOneofDeclList();
        bl4 = object3.equals(object2 = ((DescriptorProtos$DescriptorProto)object).getOneofDeclList());
        if (!bl4) {
            return false;
        }
        bl4 = this.hasOptions();
        if (bl4 != (bl2 = ((DescriptorProtos$DescriptorProto)object).hasOptions())) {
            return false;
        }
        bl4 = this.hasOptions();
        if (bl4 && !(bl4 = ((DescriptorProtos$MessageOptions)(object3 = this.getOptions())).equals(object2 = ((DescriptorProtos$DescriptorProto)object).getOptions()))) {
            return false;
        }
        object3 = this.getReservedRangeList();
        bl4 = object3.equals(object2 = ((DescriptorProtos$DescriptorProto)object).getReservedRangeList());
        if (!bl4) {
            return false;
        }
        object3 = this.getReservedNameList();
        bl4 = object3.equals(object2 = ((DescriptorProtos$DescriptorProto)object).getReservedNameList());
        if (!bl4) {
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

    public DescriptorProtos$DescriptorProto getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
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

    public DescriptorProtos$DescriptorProto$ExtensionRange getExtensionRange(int n10) {
        return (DescriptorProtos$DescriptorProto$ExtensionRange)this.extensionRange_.get(n10);
    }

    public int getExtensionRangeCount() {
        return this.extensionRange_.size();
    }

    public List getExtensionRangeList() {
        return this.extensionRange_;
    }

    public DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder getExtensionRangeOrBuilder(int n10) {
        return (DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder)this.extensionRange_.get(n10);
    }

    public List getExtensionRangeOrBuilderList() {
        return this.extensionRange_;
    }

    public DescriptorProtos$FieldDescriptorProto getField(int n10) {
        return (DescriptorProtos$FieldDescriptorProto)this.field_.get(n10);
    }

    public int getFieldCount() {
        return this.field_.size();
    }

    public List getFieldList() {
        return this.field_;
    }

    public DescriptorProtos$FieldDescriptorProtoOrBuilder getFieldOrBuilder(int n10) {
        return (DescriptorProtos$FieldDescriptorProtoOrBuilder)this.field_.get(n10);
    }

    public List getFieldOrBuilderList() {
        return this.field_;
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

    public DescriptorProtos$DescriptorProto getNestedType(int n10) {
        return (DescriptorProtos$DescriptorProto)this.nestedType_.get(n10);
    }

    public int getNestedTypeCount() {
        return this.nestedType_.size();
    }

    public List getNestedTypeList() {
        return this.nestedType_;
    }

    public DescriptorProtos$DescriptorProtoOrBuilder getNestedTypeOrBuilder(int n10) {
        return (DescriptorProtos$DescriptorProtoOrBuilder)this.nestedType_.get(n10);
    }

    public List getNestedTypeOrBuilderList() {
        return this.nestedType_;
    }

    public DescriptorProtos$OneofDescriptorProto getOneofDecl(int n10) {
        return (DescriptorProtos$OneofDescriptorProto)this.oneofDecl_.get(n10);
    }

    public int getOneofDeclCount() {
        return this.oneofDecl_.size();
    }

    public List getOneofDeclList() {
        return this.oneofDecl_;
    }

    public DescriptorProtos$OneofDescriptorProtoOrBuilder getOneofDeclOrBuilder(int n10) {
        return (DescriptorProtos$OneofDescriptorProtoOrBuilder)this.oneofDecl_.get(n10);
    }

    public List getOneofDeclOrBuilderList() {
        return this.oneofDecl_;
    }

    public DescriptorProtos$MessageOptions getOptions() {
        DescriptorProtos$MessageOptions descriptorProtos$MessageOptions = this.options_;
        if (descriptorProtos$MessageOptions == null) {
            descriptorProtos$MessageOptions = DescriptorProtos$MessageOptions.getDefaultInstance();
        }
        return descriptorProtos$MessageOptions;
    }

    public DescriptorProtos$MessageOptionsOrBuilder getOptionsOrBuilder() {
        DescriptorProtos$MessageOptions descriptorProtos$MessageOptions = this.options_;
        if (descriptorProtos$MessageOptions == null) {
            descriptorProtos$MessageOptions = DescriptorProtos$MessageOptions.getDefaultInstance();
        }
        return descriptorProtos$MessageOptions;
    }

    public Parser getParserForType() {
        return PARSER;
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
        return this.reservedName_;
    }

    public DescriptorProtos$DescriptorProto$ReservedRange getReservedRange(int n10) {
        return (DescriptorProtos$DescriptorProto$ReservedRange)this.reservedRange_.get(n10);
    }

    public int getReservedRangeCount() {
        return this.reservedRange_.size();
    }

    public List getReservedRangeList() {
        return this.reservedRange_;
    }

    public DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder getReservedRangeOrBuilder(int n10) {
        return (DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder)this.reservedRange_.get(n10);
    }

    public List getReservedRangeOrBuilderList() {
        return this.reservedRange_;
    }

    public int getSerializedSize() {
        MessageLite messageLite;
        MessageLite messageLite2;
        int n10;
        int n11;
        Object object;
        Object object2;
        int n12 = this.memoizedSize;
        int n13 = -1;
        if (n12 != n13) {
            return n12;
        }
        n12 = this.bitField0_;
        n13 = 1;
        int n14 = 0;
        if ((n12 &= n13) != 0) {
            object2 = this.name_;
            n12 = GeneratedMessageV3.computeStringSize(n13, object2) + 0;
        } else {
            n12 = 0;
            object2 = null;
        }
        int n15 = 0;
        while (true) {
            object = this.field_;
            n11 = object.size();
            n10 = 2;
            if (n15 >= n11) break;
            object = (MessageLite)this.field_.get(n15);
            n11 = CodedOutputStream.computeMessageSize(n10, (MessageLite)object);
            n12 += n11;
            ++n15;
        }
        for (n15 = 0; n15 < (n11 = (object = this.nestedType_).size()); ++n15) {
            messageLite2 = (MessageLite)this.nestedType_.get(n15);
            n11 = CodedOutputStream.computeMessageSize(3, messageLite2);
            n12 += n11;
        }
        for (n15 = 0; n15 < (n11 = (object = this.enumType_).size()); ++n15) {
            messageLite2 = (MessageLite)this.enumType_.get(n15);
            n11 = CodedOutputStream.computeMessageSize(4, messageLite2);
            n12 += n11;
        }
        for (n15 = 0; n15 < (n11 = (object = this.extensionRange_).size()); ++n15) {
            messageLite2 = (MessageLite)this.extensionRange_.get(n15);
            n11 = CodedOutputStream.computeMessageSize(5, messageLite2);
            n12 += n11;
        }
        for (n15 = 0; n15 < (n11 = (object = this.extension_).size()); ++n15) {
            messageLite2 = (MessageLite)this.extension_.get(n15);
            n11 = CodedOutputStream.computeMessageSize(6, messageLite2);
            n12 += n11;
        }
        n15 = this.bitField0_ & n10;
        if (n15 != 0) {
            object = this.getOptions();
            n15 = CodedOutputStream.computeMessageSize(7, (MessageLite)object);
            n12 += n15;
        }
        for (n15 = 0; n15 < (n11 = (object = this.oneofDecl_).size()); ++n15) {
            messageLite = (MessageLite)this.oneofDecl_.get(n15);
            n11 = CodedOutputStream.computeMessageSize(8, messageLite);
            n12 += n11;
        }
        for (n15 = 0; n15 < (n11 = (object = this.reservedRange_).size()); ++n15) {
            messageLite = (MessageLite)this.reservedRange_.get(n15);
            n11 = CodedOutputStream.computeMessageSize(9, messageLite);
            n12 += n11;
        }
        n15 = 0;
        while (n14 < (n11 = (object = this.reservedName_).size())) {
            object = this.reservedName_.getRaw(n14);
            n11 = GeneratedMessageV3.computeStringSizeNoTag(object);
            n15 += n11;
            ++n14;
        }
        n12 += n15;
        n14 = this.getReservedNameList().size() * n13;
        n12 += n14;
        n13 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n12 += n13;
        return n12;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
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
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        Object object = DescriptorProtos$DescriptorProto.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = (int)(this.hasName() ? 1 : 0);
        if (n11 != 0) {
            n10 = (n10 * 37 + 1) * 53;
            object = this.getName();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = this.getFieldCount()) > 0) {
            n10 = (n10 * 37 + 2) * 53;
            object = this.getFieldList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = this.getExtensionCount()) > 0) {
            n10 = (n10 * 37 + 6) * 53;
            object = this.getExtensionList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = this.getNestedTypeCount()) > 0) {
            n10 = (n10 * 37 + 3) * 53;
            object = this.getNestedTypeList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = this.getEnumTypeCount()) > 0) {
            n10 = (n10 * 37 + 4) * 53;
            object = this.getEnumTypeList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = this.getExtensionRangeCount()) > 0) {
            n10 = (n10 * 37 + 5) * 53;
            object = this.getExtensionRangeList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = this.getOneofDeclCount()) > 0) {
            n10 = (n10 * 37 + 8) * 53;
            object = this.getOneofDeclList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasOptions() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 7) * 53;
            object = this.getOptions();
            n11 = ((DescriptorProtos$MessageOptions)object).hashCode();
            n10 += n11;
        }
        if ((n11 = this.getReservedRangeCount()) > 0) {
            n10 = (n10 * 37 + 9) * 53;
            object = this.getReservedRangeList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = this.getReservedNameCount()) > 0) {
            n10 = (n10 * 37 + 10) * 53;
            object = this.getReservedNameList();
            n11 = object.hashCode();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$2700().ensureFieldAccessorsInitialized(DescriptorProtos$DescriptorProto.class, DescriptorProtos$DescriptorProto$Builder.class);
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
        DescriptorProtos$MessageOptions descriptorProtos$MessageOptions = null;
        for (n11 = 0; n11 < (n10 = this.getFieldCount()); ++n11) {
            generatedMessageV3 = this.getField(n11);
            n10 = (int)(((DescriptorProtos$FieldDescriptorProto)generatedMessageV3).isInitialized() ? 1 : 0);
            if (n10 != 0) continue;
            this.memoizedIsInitialized = 0;
            return false;
        }
        descriptorProtos$MessageOptions = null;
        for (n11 = 0; n11 < (n10 = this.getExtensionCount()); ++n11) {
            generatedMessageV3 = this.getExtension(n11);
            n10 = (int)(((DescriptorProtos$FieldDescriptorProto)generatedMessageV3).isInitialized() ? 1 : 0);
            if (n10 != 0) continue;
            this.memoizedIsInitialized = 0;
            return false;
        }
        descriptorProtos$MessageOptions = null;
        for (n11 = 0; n11 < (n10 = this.getNestedTypeCount()); ++n11) {
            generatedMessageV3 = this.getNestedType(n11);
            n10 = (int)(((DescriptorProtos$DescriptorProto)generatedMessageV3).isInitialized() ? 1 : 0);
            if (n10 != 0) continue;
            this.memoizedIsInitialized = 0;
            return false;
        }
        descriptorProtos$MessageOptions = null;
        for (n11 = 0; n11 < (n10 = this.getEnumTypeCount()); ++n11) {
            generatedMessageV3 = this.getEnumType(n11);
            n10 = (int)(((DescriptorProtos$EnumDescriptorProto)generatedMessageV3).isInitialized() ? 1 : 0);
            if (n10 != 0) continue;
            this.memoizedIsInitialized = 0;
            return false;
        }
        descriptorProtos$MessageOptions = null;
        for (n11 = 0; n11 < (n10 = this.getExtensionRangeCount()); ++n11) {
            generatedMessageV3 = this.getExtensionRange(n11);
            n10 = (int)(((DescriptorProtos$DescriptorProto$ExtensionRange)generatedMessageV3).isInitialized() ? 1 : 0);
            if (n10 != 0) continue;
            this.memoizedIsInitialized = 0;
            return false;
        }
        descriptorProtos$MessageOptions = null;
        for (n11 = 0; n11 < (n10 = this.getOneofDeclCount()); ++n11) {
            generatedMessageV3 = this.getOneofDecl(n11);
            n10 = (int)(((DescriptorProtos$OneofDescriptorProto)generatedMessageV3).isInitialized() ? 1 : 0);
            if (n10 != 0) continue;
            this.memoizedIsInitialized = 0;
            return false;
        }
        n11 = (int)(this.hasOptions() ? 1 : 0);
        if (n11 != 0 && (n11 = (descriptorProtos$MessageOptions = this.getOptions()).isInitialized()) == 0) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        this.memoizedIsInitialized = (byte)n12;
        return n12 != 0;
    }

    public DescriptorProtos$DescriptorProto$Builder newBuilderForType() {
        return DescriptorProtos$DescriptorProto.newBuilder();
    }

    public DescriptorProtos$DescriptorProto$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        DescriptorProtos$DescriptorProto$Builder descriptorProtos$DescriptorProto$Builder = new DescriptorProtos$DescriptorProto$Builder(generatedMessageV3$BuilderParent, null);
        return descriptorProtos$DescriptorProto$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new DescriptorProtos$DescriptorProto();
        return object;
    }

    public DescriptorProtos$DescriptorProto$Builder toBuilder() {
        DescriptorProtos$DescriptorProtoOrBuilder descriptorProtos$DescriptorProtoOrBuilder = DEFAULT_INSTANCE;
        if (this == descriptorProtos$DescriptorProtoOrBuilder) {
            descriptorProtos$DescriptorProtoOrBuilder = new DescriptorProtos$DescriptorProto$Builder(null);
        } else {
            descriptorProtos$DescriptorProtoOrBuilder = new DescriptorProtos$DescriptorProto$Builder(null);
            descriptorProtos$DescriptorProtoOrBuilder = ((DescriptorProtos$DescriptorProto$Builder)descriptorProtos$DescriptorProtoOrBuilder).mergeFrom(this);
        }
        return descriptorProtos$DescriptorProtoOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        MessageLite messageLite;
        MessageLite messageLite2;
        int n10;
        int n11;
        Object object;
        Object object2;
        int n12 = this.bitField0_;
        int n13 = 1;
        if ((n12 &= n13) != 0) {
            object2 = this.name_;
            GeneratedMessageV3.writeString(codedOutputStream, n13, object2);
        }
        n12 = 0;
        object2 = null;
        n13 = 0;
        LazyStringList lazyStringList = null;
        while (true) {
            object = this.field_;
            n11 = object.size();
            n10 = 2;
            if (n13 >= n11) break;
            object = (MessageLite)this.field_.get(n13);
            codedOutputStream.writeMessage(n10, (MessageLite)object);
            ++n13;
        }
        lazyStringList = null;
        for (n13 = 0; n13 < (n11 = (object = this.nestedType_).size()); ++n13) {
            n11 = 3;
            messageLite2 = (MessageLite)this.nestedType_.get(n13);
            codedOutputStream.writeMessage(n11, messageLite2);
        }
        lazyStringList = null;
        for (n13 = 0; n13 < (n11 = (object = this.enumType_).size()); ++n13) {
            n11 = 4;
            messageLite2 = (MessageLite)this.enumType_.get(n13);
            codedOutputStream.writeMessage(n11, messageLite2);
        }
        lazyStringList = null;
        for (n13 = 0; n13 < (n11 = (object = this.extensionRange_).size()); ++n13) {
            n11 = 5;
            messageLite2 = (MessageLite)this.extensionRange_.get(n13);
            codedOutputStream.writeMessage(n11, messageLite2);
        }
        lazyStringList = null;
        for (n13 = 0; n13 < (n11 = (object = this.extension_).size()); ++n13) {
            n11 = 6;
            messageLite2 = (MessageLite)this.extension_.get(n13);
            codedOutputStream.writeMessage(n11, messageLite2);
        }
        n13 = this.bitField0_ & n10;
        if (n13 != 0) {
            n13 = 7;
            object = this.getOptions();
            codedOutputStream.writeMessage(n13, (MessageLite)object);
        }
        lazyStringList = null;
        for (n13 = 0; n13 < (n11 = (object = this.oneofDecl_).size()); ++n13) {
            n11 = 8;
            messageLite = (MessageLite)this.oneofDecl_.get(n13);
            codedOutputStream.writeMessage(n11, messageLite);
        }
        lazyStringList = null;
        for (n13 = 0; n13 < (n11 = (object = this.reservedRange_).size()); ++n13) {
            n11 = 9;
            messageLite = (MessageLite)this.reservedRange_.get(n13);
            codedOutputStream.writeMessage(n11, messageLite);
        }
        while (n12 < (n13 = (lazyStringList = this.reservedName_).size())) {
            n13 = 10;
            object = this.reservedName_.getRaw(n12);
            GeneratedMessageV3.writeString(codedOutputStream, n13, object);
            ++n12;
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

