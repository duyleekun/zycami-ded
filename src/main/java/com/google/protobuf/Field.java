/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Field$1;
import com.google.protobuf.Field$Builder;
import com.google.protobuf.Field$Cardinality;
import com.google.protobuf.Field$Kind;
import com.google.protobuf.FieldOrBuilder;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.GeneratedMessageV3$UnusedPrivateParameter;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Option;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.TypeProto;
import com.google.protobuf.UnknownFieldSet;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class Field
extends GeneratedMessageV3
implements FieldOrBuilder {
    public static final int CARDINALITY_FIELD_NUMBER = 2;
    private static final Field DEFAULT_INSTANCE;
    public static final int DEFAULT_VALUE_FIELD_NUMBER = 11;
    public static final int JSON_NAME_FIELD_NUMBER = 10;
    public static final int KIND_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 4;
    public static final int NUMBER_FIELD_NUMBER = 3;
    public static final int ONEOF_INDEX_FIELD_NUMBER = 7;
    public static final int OPTIONS_FIELD_NUMBER = 9;
    public static final int PACKED_FIELD_NUMBER = 8;
    private static final Parser PARSER;
    public static final int TYPE_URL_FIELD_NUMBER = 6;
    private static final long serialVersionUID;
    private int cardinality_;
    private volatile Object defaultValue_;
    private volatile Object jsonName_;
    private int kind_;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private int number_;
    private int oneofIndex_;
    private List options_;
    private boolean packed_;
    private volatile Object typeUrl_;

    static {
        Object object = new Field();
        DEFAULT_INSTANCE = object;
        PARSER = object = new Field$1();
    }

    private Field() {
        List list;
        this.memoizedIsInitialized = (byte)-1;
        this.kind_ = 0;
        this.cardinality_ = 0;
        String string2 = "";
        this.name_ = string2;
        this.typeUrl_ = string2;
        this.options_ = list = Collections.emptyList();
        this.jsonName_ = string2;
        this.defaultValue_ = string2;
    }

    /*
     * Exception decompiling
     */
    private Field(CodedInputStream var1_1, ExtensionRegistryLite var2_7) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 19[TRYBLOCK] [81 : 367->370)] java.lang.Throwable
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

    public /* synthetic */ Field(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Field$1 field$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private Field(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
        this.memoizedIsInitialized = (byte)-1;
    }

    public /* synthetic */ Field(GeneratedMessageV3$Builder generatedMessageV3$Builder, Field$1 field$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ List access$1000(Field field) {
        return field.options_;
    }

    public static /* synthetic */ List access$1002(Field field, List list) {
        field.options_ = list;
        return list;
    }

    public static /* synthetic */ Object access$1100(Field field) {
        return field.jsonName_;
    }

    public static /* synthetic */ Object access$1102(Field field, Object object) {
        field.jsonName_ = object;
        return object;
    }

    public static /* synthetic */ Object access$1200(Field field) {
        return field.defaultValue_;
    }

    public static /* synthetic */ Object access$1202(Field field, Object object) {
        field.defaultValue_ = object;
        return object;
    }

    public static /* synthetic */ Parser access$1300() {
        return PARSER;
    }

    public static /* synthetic */ int access$300(Field field) {
        return field.kind_;
    }

    public static /* synthetic */ int access$302(Field field, int n10) {
        field.kind_ = n10;
        return n10;
    }

    public static /* synthetic */ int access$400(Field field) {
        return field.cardinality_;
    }

    public static /* synthetic */ int access$402(Field field, int n10) {
        field.cardinality_ = n10;
        return n10;
    }

    public static /* synthetic */ int access$502(Field field, int n10) {
        field.number_ = n10;
        return n10;
    }

    public static /* synthetic */ Object access$600(Field field) {
        return field.name_;
    }

    public static /* synthetic */ Object access$602(Field field, Object object) {
        field.name_ = object;
        return object;
    }

    public static /* synthetic */ Object access$700(Field field) {
        return field.typeUrl_;
    }

    public static /* synthetic */ Object access$702(Field field, Object object) {
        field.typeUrl_ = object;
        return object;
    }

    public static /* synthetic */ int access$802(Field field, int n10) {
        field.oneofIndex_ = n10;
        return n10;
    }

    public static /* synthetic */ boolean access$902(Field field, boolean bl2) {
        field.packed_ = bl2;
        return bl2;
    }

    public static Field getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_Field_descriptor;
    }

    public static Field$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Field$Builder newBuilder(Field field) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(field);
    }

    public static Field parseDelimitedFrom(InputStream inputStream) {
        return (Field)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Field parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Field)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Field parseFrom(ByteString byteString) {
        return (Field)PARSER.parseFrom(byteString);
    }

    public static Field parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Field)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Field parseFrom(CodedInputStream codedInputStream) {
        return (Field)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Field parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Field)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Field parseFrom(InputStream inputStream) {
        return (Field)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Field parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Field)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Field parseFrom(ByteBuffer byteBuffer) {
        return (Field)PARSER.parseFrom(byteBuffer);
    }

    public static Field parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Field)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Field parseFrom(byte[] byArray) {
        return (Field)PARSER.parseFrom(byArray);
    }

    public static Field parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (Field)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        Object object2;
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        int n10 = object instanceof Field;
        if (n10 == 0) {
            return super.equals(object);
        }
        object = (Field)object;
        n10 = this.kind_;
        int n11 = ((Field)object).kind_;
        if (n10 != n11) {
            return false;
        }
        n10 = this.cardinality_;
        n11 = ((Field)object).cardinality_;
        if (n10 != n11) {
            return false;
        }
        n10 = this.getNumber();
        if (n10 != (n11 = ((Field)object).getNumber())) {
            return false;
        }
        Object object3 = this.getName();
        n10 = (int)(((String)object3).equals(object2 = ((Field)object).getName()) ? 1 : 0);
        if (n10 == 0) {
            return false;
        }
        object3 = this.getTypeUrl();
        n10 = (int)(((String)object3).equals(object2 = ((Field)object).getTypeUrl()) ? 1 : 0);
        if (n10 == 0) {
            return false;
        }
        n10 = this.getOneofIndex();
        if (n10 != (n11 = ((Field)object).getOneofIndex())) {
            return false;
        }
        n10 = (int)(this.getPacked() ? 1 : 0);
        if (n10 != (n11 = (int)(((Field)object).getPacked() ? 1 : 0))) {
            return false;
        }
        object3 = this.getOptionsList();
        n10 = (int)(object3.equals(object2 = ((Field)object).getOptionsList()) ? 1 : 0);
        if (n10 == 0) {
            return false;
        }
        object3 = this.getJsonName();
        n10 = (int)(((String)object3).equals(object2 = ((Field)object).getJsonName()) ? 1 : 0);
        if (n10 == 0) {
            return false;
        }
        object3 = this.getDefaultValue();
        n10 = (int)(((String)object3).equals(object2 = ((Field)object).getDefaultValue()) ? 1 : 0);
        if (n10 == 0) {
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

    public Field$Cardinality getCardinality() {
        int n10 = this.cardinality_;
        Field$Cardinality field$Cardinality = Field$Cardinality.valueOf(n10);
        if (field$Cardinality == null) {
            field$Cardinality = Field$Cardinality.UNRECOGNIZED;
        }
        return field$Cardinality;
    }

    public int getCardinalityValue() {
        return this.cardinality_;
    }

    public Field getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public String getDefaultValue() {
        Object object = this.defaultValue_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        this.defaultValue_ = object = ((ByteString)object).toStringUtf8();
        return object;
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

    public String getJsonName() {
        Object object = this.jsonName_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        this.jsonName_ = object = ((ByteString)object).toStringUtf8();
        return object;
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

    public Field$Kind getKind() {
        int n10 = this.kind_;
        Field$Kind field$Kind = Field$Kind.valueOf(n10);
        if (field$Kind == null) {
            field$Kind = Field$Kind.UNRECOGNIZED;
        }
        return field$Kind;
    }

    public int getKindValue() {
        return this.kind_;
    }

    public String getName() {
        Object object = this.name_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        this.name_ = object = ((ByteString)object).toStringUtf8();
        return object;
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

    public Option getOptions(int n10) {
        return (Option)this.options_.get(n10);
    }

    public int getOptionsCount() {
        return this.options_.size();
    }

    public List getOptionsList() {
        return this.options_;
    }

    public OptionOrBuilder getOptionsOrBuilder(int n10) {
        return (OptionOrBuilder)this.options_.get(n10);
    }

    public List getOptionsOrBuilderList() {
        return this.options_;
    }

    public boolean getPacked() {
        return this.packed_;
    }

    public Parser getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int n10 = this.memoizedSize;
        int n11 = -1;
        if (n10 != n11) {
            return n10;
        }
        n10 = this.kind_;
        Object object = Field$Kind.TYPE_UNKNOWN;
        n11 = ((Field$Kind)object).getNumber();
        int n12 = 0;
        Object object2 = null;
        if (n10 != n11) {
            n10 = this.kind_;
            n11 = 1;
            n10 = CodedOutputStream.computeEnumSize(n11, n10) + 0;
        } else {
            n10 = 0;
        }
        n11 = this.cardinality_;
        Object object3 = Field$Cardinality.CARDINALITY_UNKNOWN;
        int n13 = ((Field$Cardinality)object3).getNumber();
        if (n11 != n13) {
            n13 = this.cardinality_;
            n11 = CodedOutputStream.computeEnumSize(2, n13);
            n10 += n11;
        }
        if ((n11 = this.number_) != 0) {
            n13 = 3;
            n11 = CodedOutputStream.computeInt32Size(n13, n11);
            n10 += n11;
        }
        if ((n11 = (int)(((ByteString)(object = this.getNameBytes())).isEmpty() ? 1 : 0)) == 0) {
            object3 = this.name_;
            n11 = GeneratedMessageV3.computeStringSize(4, object3);
            n10 += n11;
        }
        if ((n11 = (int)(((ByteString)(object = this.getTypeUrlBytes())).isEmpty() ? 1 : 0)) == 0) {
            object3 = this.typeUrl_;
            n11 = GeneratedMessageV3.computeStringSize(6, object3);
            n10 += n11;
        }
        if ((n11 = this.oneofIndex_) != 0) {
            n13 = 7;
            n11 = CodedOutputStream.computeInt32Size(n13, n11);
            n10 += n11;
        }
        if ((n11 = (int)(this.packed_ ? 1 : 0)) != 0) {
            n13 = 8;
            n11 = CodedOutputStream.computeBoolSize(n13, n11 != 0);
            n10 += n11;
        }
        while (n12 < (n11 = (object = this.options_).size())) {
            object3 = (MessageLite)this.options_.get(n12);
            n11 = CodedOutputStream.computeMessageSize(9, (MessageLite)object3);
            n10 += n11;
            ++n12;
        }
        object = this.getJsonNameBytes();
        n11 = (int)(((ByteString)object).isEmpty() ? 1 : 0);
        if (n11 == 0) {
            object2 = this.jsonName_;
            n11 = GeneratedMessageV3.computeStringSize(10, object2);
            n10 += n11;
        }
        if ((n11 = (int)(((ByteString)(object = this.getDefaultValueBytes())).isEmpty() ? 1 : 0)) == 0) {
            object2 = this.defaultValue_;
            n11 = GeneratedMessageV3.computeStringSize(11, object2);
            n10 += n11;
        }
        n11 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n10 += n11;
        return n10;
    }

    public String getTypeUrl() {
        Object object = this.typeUrl_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        this.typeUrl_ = object = ((ByteString)object).toStringUtf8();
        return object;
    }

    public ByteString getTypeUrlBytes() {
        Object object = this.typeUrl_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.typeUrl_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        int n11 = Field.getDescriptor().hashCode();
        n10 = ((779 + n11) * 37 + 1) * 53;
        n11 = this.kind_;
        n10 = ((n10 + n11) * 37 + 2) * 53;
        n11 = this.cardinality_;
        n10 = ((n10 + n11) * 37 + 3) * 53;
        n11 = this.getNumber();
        n10 = ((n10 + n11) * 37 + 4) * 53;
        n11 = this.getName().hashCode();
        n10 = ((n10 + n11) * 37 + 6) * 53;
        Object object = this.getTypeUrl();
        n11 = ((String)object).hashCode();
        n10 = ((n10 + n11) * 37 + 7) * 53;
        n11 = this.getOneofIndex();
        n10 = ((n10 + n11) * 37 + 8) * 53;
        n11 = Internal.hashBoolean(this.getPacked());
        n10 += n11;
        n11 = this.getOptionsCount();
        if (n11 > 0) {
            n10 = (n10 * 37 + 9) * 53;
            object = this.getOptionsList();
            n11 = object.hashCode();
            n10 += n11;
        }
        n10 = (n10 * 37 + 10) * 53;
        n11 = this.getJsonName().hashCode();
        n10 = ((n10 + n11) * 37 + 11) * 53;
        n11 = this.getDefaultValue().hashCode();
        n10 = (n10 + n11) * 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_Field_fieldAccessorTable.ensureFieldAccessorsInitialized(Field.class, Field$Builder.class);
    }

    public final boolean isInitialized() {
        byte by2 = this.memoizedIsInitialized;
        byte by3 = 1;
        if (by2 == by3) {
            return by3 != 0;
        }
        if (!by2) {
            return false;
        }
        this.memoizedIsInitialized = by3;
        return by3 != 0;
    }

    public Field$Builder newBuilderForType() {
        return Field.newBuilder();
    }

    public Field$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        Field$Builder field$Builder = new Field$Builder(generatedMessageV3$BuilderParent, null);
        return field$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new Field();
        return object;
    }

    public Field$Builder toBuilder() {
        FieldOrBuilder fieldOrBuilder = DEFAULT_INSTANCE;
        if (this == fieldOrBuilder) {
            fieldOrBuilder = new Field$Builder(null);
        } else {
            fieldOrBuilder = new Field$Builder(null);
            fieldOrBuilder = ((Field$Builder)fieldOrBuilder).mergeFrom(this);
        }
        return fieldOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        ByteString byteString;
        int n10 = this.kind_;
        Object object = Field$Kind.TYPE_UNKNOWN;
        int n11 = ((Field$Kind)object).getNumber();
        if (n10 != n11) {
            n10 = this.kind_;
            n11 = 1;
            codedOutputStream.writeEnum(n11, n10);
        }
        if ((n10 = this.cardinality_) != (n11 = ((Field$Cardinality)(object = Field$Cardinality.CARDINALITY_UNKNOWN)).getNumber())) {
            n10 = 2;
            n11 = this.cardinality_;
            codedOutputStream.writeEnum(n10, n11);
        }
        if ((n10 = this.number_) != 0) {
            n11 = 3;
            codedOutputStream.writeInt32(n11, n10);
        }
        if ((n10 = (int)((byteString = this.getNameBytes()).isEmpty() ? 1 : 0)) == 0) {
            n10 = 4;
            object = this.name_;
            GeneratedMessageV3.writeString(codedOutputStream, n10, object);
        }
        if ((n10 = (int)((byteString = this.getTypeUrlBytes()).isEmpty() ? 1 : 0)) == 0) {
            n10 = 6;
            object = this.typeUrl_;
            GeneratedMessageV3.writeString(codedOutputStream, n10, object);
        }
        if ((n10 = this.oneofIndex_) != 0) {
            n11 = 7;
            codedOutputStream.writeInt32(n11, n10);
        }
        if ((n10 = (int)(this.packed_ ? 1 : 0)) != 0) {
            n11 = 8;
            codedOutputStream.writeBool(n11, n10 != 0);
        }
        byteString = null;
        for (n10 = 0; n10 < (n11 = (object = this.options_).size()); ++n10) {
            n11 = 9;
            MessageLite messageLite = (MessageLite)this.options_.get(n10);
            codedOutputStream.writeMessage(n11, messageLite);
        }
        byteString = this.getJsonNameBytes();
        n10 = (int)(byteString.isEmpty() ? 1 : 0);
        if (n10 == 0) {
            n10 = 10;
            object = this.jsonName_;
            GeneratedMessageV3.writeString(codedOutputStream, n10, object);
        }
        if ((n10 = (int)((byteString = this.getDefaultValueBytes()).isEmpty() ? 1 : 0)) == 0) {
            n10 = 11;
            object = this.defaultValue_;
            GeneratedMessageV3.writeString(codedOutputStream, n10, object);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

