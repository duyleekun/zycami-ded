/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto$1;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto$Label;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto$Type;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$FieldOptions;
import com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.GeneratedMessageV3$UnusedPrivateParameter;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class DescriptorProtos$FieldDescriptorProto
extends GeneratedMessageV3
implements DescriptorProtos$FieldDescriptorProtoOrBuilder {
    private static final DescriptorProtos$FieldDescriptorProto DEFAULT_INSTANCE;
    public static final int DEFAULT_VALUE_FIELD_NUMBER = 7;
    public static final int EXTENDEE_FIELD_NUMBER = 2;
    public static final int JSON_NAME_FIELD_NUMBER = 10;
    public static final int LABEL_FIELD_NUMBER = 4;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int NUMBER_FIELD_NUMBER = 3;
    public static final int ONEOF_INDEX_FIELD_NUMBER = 9;
    public static final int OPTIONS_FIELD_NUMBER = 8;
    public static final Parser PARSER;
    public static final int TYPE_FIELD_NUMBER = 5;
    public static final int TYPE_NAME_FIELD_NUMBER = 6;
    private static final long serialVersionUID;
    private int bitField0_;
    private volatile Object defaultValue_;
    private volatile Object extendee_;
    private volatile Object jsonName_;
    private int label_;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private int number_;
    private int oneofIndex_;
    private DescriptorProtos$FieldOptions options_;
    private volatile Object typeName_;
    private int type_;

    static {
        Object object = new DescriptorProtos$FieldDescriptorProto();
        DEFAULT_INSTANCE = object;
        PARSER = object = new DescriptorProtos$FieldDescriptorProto$1();
    }

    private DescriptorProtos$FieldDescriptorProto() {
        int n10;
        this.memoizedIsInitialized = (byte)-1;
        String string2 = "";
        this.name_ = string2;
        this.label_ = n10 = 1;
        this.type_ = n10;
        this.typeName_ = string2;
        this.extendee_ = string2;
        this.defaultValue_ = string2;
        this.jsonName_ = string2;
    }

    /*
     * Exception decompiling
     */
    private DescriptorProtos$FieldDescriptorProto(CodedInputStream var1_1, ExtensionRegistryLite var2_7) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 40[TRYBLOCK] [162 : 601->604)] java.lang.Throwable
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

    public /* synthetic */ DescriptorProtos$FieldDescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DescriptorProtos$1 descriptorProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private DescriptorProtos$FieldDescriptorProto(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
        this.memoizedIsInitialized = (byte)-1;
    }

    public /* synthetic */ DescriptorProtos$FieldDescriptorProto(GeneratedMessageV3$Builder generatedMessageV3$Builder, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ Object access$7400(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
        return descriptorProtos$FieldDescriptorProto.name_;
    }

    public static /* synthetic */ Object access$7402(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto, Object object) {
        descriptorProtos$FieldDescriptorProto.name_ = object;
        return object;
    }

    public static /* synthetic */ int access$7502(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto, int n10) {
        descriptorProtos$FieldDescriptorProto.number_ = n10;
        return n10;
    }

    public static /* synthetic */ int access$7602(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto, int n10) {
        descriptorProtos$FieldDescriptorProto.label_ = n10;
        return n10;
    }

    public static /* synthetic */ int access$7702(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto, int n10) {
        descriptorProtos$FieldDescriptorProto.type_ = n10;
        return n10;
    }

    public static /* synthetic */ Object access$7800(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
        return descriptorProtos$FieldDescriptorProto.typeName_;
    }

    public static /* synthetic */ Object access$7802(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto, Object object) {
        descriptorProtos$FieldDescriptorProto.typeName_ = object;
        return object;
    }

    public static /* synthetic */ Object access$7900(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
        return descriptorProtos$FieldDescriptorProto.extendee_;
    }

    public static /* synthetic */ Object access$7902(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto, Object object) {
        descriptorProtos$FieldDescriptorProto.extendee_ = object;
        return object;
    }

    public static /* synthetic */ Object access$8000(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
        return descriptorProtos$FieldDescriptorProto.defaultValue_;
    }

    public static /* synthetic */ Object access$8002(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto, Object object) {
        descriptorProtos$FieldDescriptorProto.defaultValue_ = object;
        return object;
    }

    public static /* synthetic */ int access$8102(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto, int n10) {
        descriptorProtos$FieldDescriptorProto.oneofIndex_ = n10;
        return n10;
    }

    public static /* synthetic */ Object access$8200(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
        return descriptorProtos$FieldDescriptorProto.jsonName_;
    }

    public static /* synthetic */ Object access$8202(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto, Object object) {
        descriptorProtos$FieldDescriptorProto.jsonName_ = object;
        return object;
    }

    public static /* synthetic */ DescriptorProtos$FieldOptions access$8302(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto, DescriptorProtos$FieldOptions descriptorProtos$FieldOptions) {
        descriptorProtos$FieldDescriptorProto.options_ = descriptorProtos$FieldOptions;
        return descriptorProtos$FieldOptions;
    }

    public static /* synthetic */ int access$8402(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto, int n10) {
        descriptorProtos$FieldDescriptorProto.bitField0_ = n10;
        return n10;
    }

    public static DescriptorProtos$FieldDescriptorProto getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$6900();
    }

    public static DescriptorProtos$FieldDescriptorProto$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DescriptorProtos$FieldDescriptorProto$Builder newBuilder(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$FieldDescriptorProto);
    }

    public static DescriptorProtos$FieldDescriptorProto parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$FieldDescriptorProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$FieldDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FieldDescriptorProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$FieldDescriptorProto parseFrom(ByteString byteString) {
        return (DescriptorProtos$FieldDescriptorProto)PARSER.parseFrom(byteString);
    }

    public static DescriptorProtos$FieldDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FieldDescriptorProto)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DescriptorProtos$FieldDescriptorProto parseFrom(CodedInputStream codedInputStream) {
        return (DescriptorProtos$FieldDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static DescriptorProtos$FieldDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FieldDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$FieldDescriptorProto parseFrom(InputStream inputStream) {
        return (DescriptorProtos$FieldDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$FieldDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FieldDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$FieldDescriptorProto parseFrom(ByteBuffer byteBuffer) {
        return (DescriptorProtos$FieldDescriptorProto)PARSER.parseFrom(byteBuffer);
    }

    public static DescriptorProtos$FieldDescriptorProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FieldDescriptorProto)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static DescriptorProtos$FieldDescriptorProto parseFrom(byte[] byArray) {
        return (DescriptorProtos$FieldDescriptorProto)PARSER.parseFrom(byArray);
    }

    public static DescriptorProtos$FieldDescriptorProto parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FieldDescriptorProto)PARSER.parseFrom(byArray, extensionRegistryLite);
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
        int n11 = object instanceof DescriptorProtos$FieldDescriptorProto;
        if (n11 == 0) {
            return super.equals(object);
        }
        object = (DescriptorProtos$FieldDescriptorProto)object;
        n11 = this.hasName();
        if (n11 != (n10 = ((DescriptorProtos$FieldDescriptorProto)object).hasName())) {
            return false;
        }
        n11 = this.hasName();
        if (n11 != 0 && (n11 = ((String)(object3 = this.getName())).equals(object2 = ((DescriptorProtos$FieldDescriptorProto)object).getName())) == 0) {
            return false;
        }
        n11 = this.hasNumber();
        if (n11 != (n10 = ((DescriptorProtos$FieldDescriptorProto)object).hasNumber())) {
            return false;
        }
        n11 = this.hasNumber();
        if (n11 != 0 && (n11 = this.getNumber()) != (n10 = ((DescriptorProtos$FieldDescriptorProto)object).getNumber())) {
            return false;
        }
        n11 = (int)(this.hasLabel() ? 1 : 0);
        if (n11 != (n10 = (int)(((DescriptorProtos$FieldDescriptorProto)object).hasLabel() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasLabel() ? 1 : 0);
        if (n11 != 0 && (n11 = this.label_) != (n10 = ((DescriptorProtos$FieldDescriptorProto)object).label_)) {
            return false;
        }
        n11 = (int)(this.hasType() ? 1 : 0);
        if (n11 != (n10 = (int)(((DescriptorProtos$FieldDescriptorProto)object).hasType() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasType() ? 1 : 0);
        if (n11 != 0 && (n11 = this.type_) != (n10 = ((DescriptorProtos$FieldDescriptorProto)object).type_)) {
            return false;
        }
        n11 = (int)(this.hasTypeName() ? 1 : 0);
        if (n11 != (n10 = (int)(((DescriptorProtos$FieldDescriptorProto)object).hasTypeName() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasTypeName() ? 1 : 0);
        if (n11 != 0 && (n11 = (int)(((String)(object3 = this.getTypeName())).equals(object2 = ((DescriptorProtos$FieldDescriptorProto)object).getTypeName()) ? 1 : 0)) == 0) {
            return false;
        }
        n11 = (int)(this.hasExtendee() ? 1 : 0);
        if (n11 != (n10 = (int)(((DescriptorProtos$FieldDescriptorProto)object).hasExtendee() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasExtendee() ? 1 : 0);
        if (n11 != 0 && (n11 = (int)(((String)(object3 = this.getExtendee())).equals(object2 = ((DescriptorProtos$FieldDescriptorProto)object).getExtendee()) ? 1 : 0)) == 0) {
            return false;
        }
        n11 = (int)(this.hasDefaultValue() ? 1 : 0);
        if (n11 != (n10 = (int)(((DescriptorProtos$FieldDescriptorProto)object).hasDefaultValue() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasDefaultValue() ? 1 : 0);
        if (n11 != 0 && (n11 = (int)(((String)(object3 = this.getDefaultValue())).equals(object2 = ((DescriptorProtos$FieldDescriptorProto)object).getDefaultValue()) ? 1 : 0)) == 0) {
            return false;
        }
        n11 = (int)(this.hasOneofIndex() ? 1 : 0);
        if (n11 != (n10 = (int)(((DescriptorProtos$FieldDescriptorProto)object).hasOneofIndex() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasOneofIndex() ? 1 : 0);
        if (n11 != 0 && (n11 = this.getOneofIndex()) != (n10 = ((DescriptorProtos$FieldDescriptorProto)object).getOneofIndex())) {
            return false;
        }
        n11 = (int)(this.hasJsonName() ? 1 : 0);
        if (n11 != (n10 = (int)(((DescriptorProtos$FieldDescriptorProto)object).hasJsonName() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasJsonName() ? 1 : 0);
        if (n11 != 0 && (n11 = (int)(((String)(object3 = this.getJsonName())).equals(object2 = ((DescriptorProtos$FieldDescriptorProto)object).getJsonName()) ? 1 : 0)) == 0) {
            return false;
        }
        n11 = (int)(this.hasOptions() ? 1 : 0);
        if (n11 != (n10 = (int)(((DescriptorProtos$FieldDescriptorProto)object).hasOptions() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasOptions() ? 1 : 0);
        if (n11 != 0 && (n11 = (int)(((DescriptorProtos$FieldOptions)(object3 = this.getOptions())).equals(object2 = ((DescriptorProtos$FieldDescriptorProto)object).getOptions()) ? 1 : 0)) == 0) {
            return false;
        }
        object3 = this.unknownFields;
        object = ((GeneratedMessageV3)object).unknownFields;
        boolean bl3 = ((UnknownFieldSet)object3).equals(object);
        if (!bl3) {
            return false;
        }
        return bl2;
    }

    public DescriptorProtos$FieldDescriptorProto getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public String getDefaultValue() {
        Object object = this.defaultValue_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.defaultValue_ = string2;
        }
        return string2;
    }

    public ByteString getDefaultValueBytes() {
        Object object = this.defaultValue_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.defaultValue_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public String getExtendee() {
        Object object = this.extendee_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.extendee_ = string2;
        }
        return string2;
    }

    public ByteString getExtendeeBytes() {
        Object object = this.extendee_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.extendee_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public String getJsonName() {
        Object object = this.jsonName_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.jsonName_ = string2;
        }
        return string2;
    }

    public ByteString getJsonNameBytes() {
        Object object = this.jsonName_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.jsonName_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public DescriptorProtos$FieldDescriptorProto$Label getLabel() {
        int n10 = this.label_;
        DescriptorProtos$FieldDescriptorProto$Label descriptorProtos$FieldDescriptorProto$Label = DescriptorProtos$FieldDescriptorProto$Label.valueOf(n10);
        if (descriptorProtos$FieldDescriptorProto$Label == null) {
            descriptorProtos$FieldDescriptorProto$Label = DescriptorProtos$FieldDescriptorProto$Label.LABEL_OPTIONAL;
        }
        return descriptorProtos$FieldDescriptorProto$Label;
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

    public int getNumber() {
        return this.number_;
    }

    public int getOneofIndex() {
        return this.oneofIndex_;
    }

    public DescriptorProtos$FieldOptions getOptions() {
        DescriptorProtos$FieldOptions descriptorProtos$FieldOptions = this.options_;
        if (descriptorProtos$FieldOptions == null) {
            descriptorProtos$FieldOptions = DescriptorProtos$FieldOptions.getDefaultInstance();
        }
        return descriptorProtos$FieldOptions;
    }

    public DescriptorProtos$FieldOptionsOrBuilder getOptionsOrBuilder() {
        DescriptorProtos$FieldOptions descriptorProtos$FieldOptions = this.options_;
        if (descriptorProtos$FieldOptions == null) {
            descriptorProtos$FieldOptions = DescriptorProtos$FieldOptions.getDefaultInstance();
        }
        return descriptorProtos$FieldOptions;
    }

    public Parser getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        Object object;
        Object object2;
        int n10 = this.memoizedSize;
        int n11 = -1;
        if (n10 != n11) {
            return n10;
        }
        n10 = 0;
        n11 = this.bitField0_;
        int n12 = 1;
        if ((n11 &= n12) != 0) {
            object2 = this.name_;
            n11 = GeneratedMessageV3.computeStringSize(n12, object2);
            n10 = 0 + n11;
        }
        n11 = this.bitField0_ & 0x20;
        n12 = 2;
        if (n11 != 0) {
            object2 = this.extendee_;
            n11 = GeneratedMessageV3.computeStringSize(n12, object2);
            n10 += n11;
        }
        if ((n11 = this.bitField0_ & n12) != 0) {
            n12 = this.number_;
            n11 = CodedOutputStream.computeInt32Size(3, n12);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 4;
        if ((n11 &= n12) != 0) {
            n11 = this.label_;
            n11 = CodedOutputStream.computeEnumSize(n12, n11);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 8;
        if ((n11 &= n12) != 0) {
            int n13 = this.type_;
            n11 = CodedOutputStream.computeEnumSize(5, n13);
            n10 += n11;
        }
        if ((n11 = this.bitField0_ & 0x10) != 0) {
            object = this.typeName_;
            n11 = GeneratedMessageV3.computeStringSize(6, object);
            n10 += n11;
        }
        if ((n11 = this.bitField0_ & 0x40) != 0) {
            object = this.defaultValue_;
            n11 = GeneratedMessageV3.computeStringSize(7, object);
            n10 += n11;
        }
        if ((n11 = this.bitField0_ & 0x200) != 0) {
            object2 = this.getOptions();
            n11 = CodedOutputStream.computeMessageSize(n12, (MessageLite)object2);
            n10 += n11;
        }
        if ((n11 = this.bitField0_ & 0x80) != 0) {
            n12 = this.oneofIndex_;
            n11 = CodedOutputStream.computeInt32Size(9, n12);
            n10 += n11;
        }
        if ((n11 = this.bitField0_ & 0x100) != 0) {
            Object object3 = this.jsonName_;
            n11 = GeneratedMessageV3.computeStringSize(10, object3);
            n10 += n11;
        }
        n11 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n10 += n11;
        return n10;
    }

    public DescriptorProtos$FieldDescriptorProto$Type getType() {
        int n10 = this.type_;
        DescriptorProtos$FieldDescriptorProto$Type descriptorProtos$FieldDescriptorProto$Type = DescriptorProtos$FieldDescriptorProto$Type.valueOf(n10);
        if (descriptorProtos$FieldDescriptorProto$Type == null) {
            descriptorProtos$FieldDescriptorProto$Type = DescriptorProtos$FieldDescriptorProto$Type.TYPE_DOUBLE;
        }
        return descriptorProtos$FieldDescriptorProto$Type;
    }

    public String getTypeName() {
        Object object = this.typeName_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.typeName_ = string2;
        }
        return string2;
    }

    public ByteString getTypeNameBytes() {
        Object object = this.typeName_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.typeName_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public boolean hasDefaultValue() {
        int n10 = this.bitField0_ & 0x40;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasExtendee() {
        int n10 = this.bitField0_ & 0x20;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasJsonName() {
        int n10 = this.bitField0_ & 0x100;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasLabel() {
        int n10 = this.bitField0_ & 4;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasName() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean hasNumber() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasOneofIndex() {
        int n10 = this.bitField0_ & 0x80;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasOptions() {
        int n10 = this.bitField0_ & 0x200;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasType() {
        int n10 = this.bitField0_ & 8;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasTypeName() {
        int n10 = this.bitField0_ & 0x10;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        Object object = DescriptorProtos$FieldDescriptorProto.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = (int)(this.hasName() ? 1 : 0);
        if (n11 != 0) {
            n10 = (n10 * 37 + 1) * 53;
            object = this.getName();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasNumber() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 3) * 53;
            n11 = this.getNumber();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasLabel() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 4) * 53;
            n11 = this.label_;
            n10 += n11;
        }
        if ((n11 = (int)(this.hasType() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 5) * 53;
            n11 = this.type_;
            n10 += n11;
        }
        if ((n11 = (int)(this.hasTypeName() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 6) * 53;
            object = this.getTypeName();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasExtendee() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 2) * 53;
            object = this.getExtendee();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasDefaultValue() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 7) * 53;
            object = this.getDefaultValue();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasOneofIndex() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 9) * 53;
            n11 = this.getOneofIndex();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasJsonName() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 10) * 53;
            object = this.getJsonName();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasOptions() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 8) * 53;
            object = this.getOptions();
            n11 = ((DescriptorProtos$FieldOptions)object).hashCode();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$7000().ensureFieldAccessorsInitialized(DescriptorProtos$FieldDescriptorProto.class, DescriptorProtos$FieldDescriptorProto$Builder.class);
    }

    public final boolean isInitialized() {
        DescriptorProtos$FieldOptions descriptorProtos$FieldOptions;
        byte by2 = this.memoizedIsInitialized;
        byte by3 = 1;
        if (by2 == by3) {
            return by3 != 0;
        }
        if (!by2) {
            return false;
        }
        by2 = this.hasOptions();
        if (by2 && !(by2 = (descriptorProtos$FieldOptions = this.getOptions()).isInitialized())) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        this.memoizedIsInitialized = by3;
        return by3 != 0;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder newBuilderForType() {
        return DescriptorProtos$FieldDescriptorProto.newBuilder();
    }

    public DescriptorProtos$FieldDescriptorProto$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        DescriptorProtos$FieldDescriptorProto$Builder descriptorProtos$FieldDescriptorProto$Builder = new DescriptorProtos$FieldDescriptorProto$Builder(generatedMessageV3$BuilderParent, null);
        return descriptorProtos$FieldDescriptorProto$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new DescriptorProtos$FieldDescriptorProto();
        return object;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder toBuilder() {
        DescriptorProtos$FieldDescriptorProtoOrBuilder descriptorProtos$FieldDescriptorProtoOrBuilder = DEFAULT_INSTANCE;
        if (this == descriptorProtos$FieldDescriptorProtoOrBuilder) {
            descriptorProtos$FieldDescriptorProtoOrBuilder = new DescriptorProtos$FieldDescriptorProto$Builder(null);
        } else {
            descriptorProtos$FieldDescriptorProtoOrBuilder = new DescriptorProtos$FieldDescriptorProto$Builder(null);
            descriptorProtos$FieldDescriptorProtoOrBuilder = ((DescriptorProtos$FieldDescriptorProto$Builder)descriptorProtos$FieldDescriptorProtoOrBuilder).mergeFrom(this);
        }
        return descriptorProtos$FieldDescriptorProtoOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        Object object;
        Object object2;
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) != 0) {
            object2 = this.name_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object2);
        }
        n10 = this.bitField0_ & 0x20;
        n11 = 2;
        if (n10 != 0) {
            object2 = this.extendee_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object2);
        }
        if ((n10 = this.bitField0_ & n11) != 0) {
            n10 = 3;
            n11 = this.number_;
            codedOutputStream.writeInt32(n10, n11);
        }
        n10 = this.bitField0_;
        n11 = 4;
        if ((n10 &= n11) != 0) {
            n10 = this.label_;
            codedOutputStream.writeEnum(n11, n10);
        }
        n10 = this.bitField0_;
        n11 = 8;
        if ((n10 &= n11) != 0) {
            n10 = 5;
            int n12 = this.type_;
            codedOutputStream.writeEnum(n10, n12);
        }
        if ((n10 = this.bitField0_ & 0x10) != 0) {
            n10 = 6;
            object = this.typeName_;
            GeneratedMessageV3.writeString(codedOutputStream, n10, object);
        }
        if ((n10 = this.bitField0_ & 0x40) != 0) {
            n10 = 7;
            object = this.defaultValue_;
            GeneratedMessageV3.writeString(codedOutputStream, n10, object);
        }
        if ((n10 = this.bitField0_ & 0x200) != 0) {
            object2 = this.getOptions();
            codedOutputStream.writeMessage(n11, (MessageLite)object2);
        }
        if ((n10 = this.bitField0_ & 0x80) != 0) {
            n10 = 9;
            n11 = this.oneofIndex_;
            codedOutputStream.writeInt32(n10, n11);
        }
        if ((n10 = this.bitField0_ & 0x100) != 0) {
            n10 = 10;
            Object object3 = this.jsonName_;
            GeneratedMessageV3.writeString(codedOutputStream, n10, object3);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

