/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.proto;

import com.google.mediapipe.proto.CalculatorProto$1;
import com.google.mediapipe.proto.CalculatorProto$InputCollection$Builder;
import com.google.mediapipe.proto.CalculatorProto$InputCollection$InputType;
import com.google.mediapipe.proto.CalculatorProto$InputCollectionOrBuilder;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite$DefaultInstanceBasedParser;
import com.google.protobuf.GeneratedMessageLite$MethodToInvoke;
import com.google.protobuf.Internal$ProtobufList;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class CalculatorProto$InputCollection
extends GeneratedMessageLite
implements CalculatorProto$InputCollectionOrBuilder {
    private static final CalculatorProto$InputCollection DEFAULT_INSTANCE;
    public static final int EXTERNAL_INPUT_NAME_FIELD_NUMBER = 1002;
    public static final int FILE_NAME_FIELD_NUMBER = 4;
    public static final int INPUT_TYPE_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser PARSER;
    public static final int SIDE_PACKET_NAME_FIELD_NUMBER = 2;
    private Internal$ProtobufList externalInputName_;
    private String fileName_;
    private int inputType_;
    private String name_;
    private Internal$ProtobufList sidePacketName_;

    static {
        CalculatorProto$InputCollection calculatorProto$InputCollection;
        DEFAULT_INSTANCE = calculatorProto$InputCollection = new CalculatorProto$InputCollection();
        GeneratedMessageLite.registerDefaultInstance(CalculatorProto$InputCollection.class, calculatorProto$InputCollection);
    }

    private CalculatorProto$InputCollection() {
        Internal$ProtobufList internal$ProtobufList;
        String string2;
        this.name_ = string2 = "";
        this.sidePacketName_ = internal$ProtobufList = GeneratedMessageLite.emptyProtobufList();
        this.externalInputName_ = internal$ProtobufList = GeneratedMessageLite.emptyProtobufList();
        this.fileName_ = string2;
    }

    public static /* synthetic */ CalculatorProto$InputCollection access$1100() {
        return DEFAULT_INSTANCE;
    }

    public static /* synthetic */ void access$1200(CalculatorProto$InputCollection calculatorProto$InputCollection, String string2) {
        calculatorProto$InputCollection.setName(string2);
    }

    public static /* synthetic */ void access$1300(CalculatorProto$InputCollection calculatorProto$InputCollection) {
        calculatorProto$InputCollection.clearName();
    }

    public static /* synthetic */ void access$1400(CalculatorProto$InputCollection calculatorProto$InputCollection, ByteString byteString) {
        calculatorProto$InputCollection.setNameBytes(byteString);
    }

    public static /* synthetic */ void access$1500(CalculatorProto$InputCollection calculatorProto$InputCollection, int n10, String string2) {
        calculatorProto$InputCollection.setSidePacketName(n10, string2);
    }

    public static /* synthetic */ void access$1600(CalculatorProto$InputCollection calculatorProto$InputCollection, String string2) {
        calculatorProto$InputCollection.addSidePacketName(string2);
    }

    public static /* synthetic */ void access$1700(CalculatorProto$InputCollection calculatorProto$InputCollection, Iterable iterable) {
        calculatorProto$InputCollection.addAllSidePacketName(iterable);
    }

    public static /* synthetic */ void access$1800(CalculatorProto$InputCollection calculatorProto$InputCollection) {
        calculatorProto$InputCollection.clearSidePacketName();
    }

    public static /* synthetic */ void access$1900(CalculatorProto$InputCollection calculatorProto$InputCollection, ByteString byteString) {
        calculatorProto$InputCollection.addSidePacketNameBytes(byteString);
    }

    public static /* synthetic */ void access$2000(CalculatorProto$InputCollection calculatorProto$InputCollection, int n10, String string2) {
        calculatorProto$InputCollection.setExternalInputName(n10, string2);
    }

    public static /* synthetic */ void access$2100(CalculatorProto$InputCollection calculatorProto$InputCollection, String string2) {
        calculatorProto$InputCollection.addExternalInputName(string2);
    }

    public static /* synthetic */ void access$2200(CalculatorProto$InputCollection calculatorProto$InputCollection, Iterable iterable) {
        calculatorProto$InputCollection.addAllExternalInputName(iterable);
    }

    public static /* synthetic */ void access$2300(CalculatorProto$InputCollection calculatorProto$InputCollection) {
        calculatorProto$InputCollection.clearExternalInputName();
    }

    public static /* synthetic */ void access$2400(CalculatorProto$InputCollection calculatorProto$InputCollection, ByteString byteString) {
        calculatorProto$InputCollection.addExternalInputNameBytes(byteString);
    }

    public static /* synthetic */ void access$2500(CalculatorProto$InputCollection calculatorProto$InputCollection, int n10) {
        calculatorProto$InputCollection.setInputTypeValue(n10);
    }

    public static /* synthetic */ void access$2600(CalculatorProto$InputCollection calculatorProto$InputCollection, CalculatorProto$InputCollection$InputType calculatorProto$InputCollection$InputType) {
        calculatorProto$InputCollection.setInputType(calculatorProto$InputCollection$InputType);
    }

    public static /* synthetic */ void access$2700(CalculatorProto$InputCollection calculatorProto$InputCollection) {
        calculatorProto$InputCollection.clearInputType();
    }

    public static /* synthetic */ void access$2800(CalculatorProto$InputCollection calculatorProto$InputCollection, String string2) {
        calculatorProto$InputCollection.setFileName(string2);
    }

    public static /* synthetic */ void access$2900(CalculatorProto$InputCollection calculatorProto$InputCollection) {
        calculatorProto$InputCollection.clearFileName();
    }

    public static /* synthetic */ void access$3000(CalculatorProto$InputCollection calculatorProto$InputCollection, ByteString byteString) {
        calculatorProto$InputCollection.setFileNameBytes(byteString);
    }

    private void addAllExternalInputName(Iterable iterable) {
        this.ensureExternalInputNameIsMutable();
        Internal$ProtobufList internal$ProtobufList = this.externalInputName_;
        AbstractMessageLite.addAll(iterable, internal$ProtobufList);
    }

    private void addAllSidePacketName(Iterable iterable) {
        this.ensureSidePacketNameIsMutable();
        Internal$ProtobufList internal$ProtobufList = this.sidePacketName_;
        AbstractMessageLite.addAll(iterable, internal$ProtobufList);
    }

    private void addExternalInputName(String string2) {
        string2.getClass();
        this.ensureExternalInputNameIsMutable();
        this.externalInputName_.add(string2);
    }

    private void addExternalInputNameBytes(ByteString object) {
        AbstractMessageLite.checkByteStringIsUtf8((ByteString)object);
        this.ensureExternalInputNameIsMutable();
        Internal$ProtobufList internal$ProtobufList = this.externalInputName_;
        object = ((ByteString)object).toStringUtf8();
        internal$ProtobufList.add(object);
    }

    private void addSidePacketName(String string2) {
        string2.getClass();
        this.ensureSidePacketNameIsMutable();
        this.sidePacketName_.add(string2);
    }

    private void addSidePacketNameBytes(ByteString object) {
        AbstractMessageLite.checkByteStringIsUtf8((ByteString)object);
        this.ensureSidePacketNameIsMutable();
        Internal$ProtobufList internal$ProtobufList = this.sidePacketName_;
        object = ((ByteString)object).toStringUtf8();
        internal$ProtobufList.add(object);
    }

    private void clearExternalInputName() {
        Internal$ProtobufList internal$ProtobufList;
        this.externalInputName_ = internal$ProtobufList = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearFileName() {
        String string2;
        this.fileName_ = string2 = CalculatorProto$InputCollection.getDefaultInstance().getFileName();
    }

    private void clearInputType() {
        this.inputType_ = 0;
    }

    private void clearName() {
        String string2;
        this.name_ = string2 = CalculatorProto$InputCollection.getDefaultInstance().getName();
    }

    private void clearSidePacketName() {
        Internal$ProtobufList internal$ProtobufList;
        this.sidePacketName_ = internal$ProtobufList = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureExternalInputNameIsMutable() {
        Internal$ProtobufList internal$ProtobufList = this.externalInputName_;
        boolean bl2 = internal$ProtobufList.isModifiable();
        if (!bl2) {
            this.externalInputName_ = internal$ProtobufList = GeneratedMessageLite.mutableCopy(this.externalInputName_);
        }
    }

    private void ensureSidePacketNameIsMutable() {
        Internal$ProtobufList internal$ProtobufList = this.sidePacketName_;
        boolean bl2 = internal$ProtobufList.isModifiable();
        if (!bl2) {
            this.sidePacketName_ = internal$ProtobufList = GeneratedMessageLite.mutableCopy(this.sidePacketName_);
        }
    }

    public static CalculatorProto$InputCollection getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static CalculatorProto$InputCollection$Builder newBuilder() {
        return (CalculatorProto$InputCollection$Builder)DEFAULT_INSTANCE.createBuilder();
    }

    public static CalculatorProto$InputCollection$Builder newBuilder(CalculatorProto$InputCollection calculatorProto$InputCollection) {
        return (CalculatorProto$InputCollection$Builder)DEFAULT_INSTANCE.createBuilder(calculatorProto$InputCollection);
    }

    public static CalculatorProto$InputCollection parseDelimitedFrom(InputStream inputStream) {
        return (CalculatorProto$InputCollection)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CalculatorProto$InputCollection parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CalculatorProto$InputCollection)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CalculatorProto$InputCollection parseFrom(ByteString byteString) {
        return (CalculatorProto$InputCollection)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString);
    }

    public static CalculatorProto$InputCollection parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (CalculatorProto$InputCollection)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static CalculatorProto$InputCollection parseFrom(CodedInputStream codedInputStream) {
        return (CalculatorProto$InputCollection)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream);
    }

    public static CalculatorProto$InputCollection parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CalculatorProto$InputCollection)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static CalculatorProto$InputCollection parseFrom(InputStream inputStream) {
        return (CalculatorProto$InputCollection)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream);
    }

    public static CalculatorProto$InputCollection parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CalculatorProto$InputCollection)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CalculatorProto$InputCollection parseFrom(ByteBuffer byteBuffer) {
        return (CalculatorProto$InputCollection)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer);
    }

    public static CalculatorProto$InputCollection parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (CalculatorProto$InputCollection)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static CalculatorProto$InputCollection parseFrom(byte[] byArray) {
        return (CalculatorProto$InputCollection)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray);
    }

    public static CalculatorProto$InputCollection parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (CalculatorProto$InputCollection)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setExternalInputName(int n10, String string2) {
        string2.getClass();
        this.ensureExternalInputNameIsMutable();
        this.externalInputName_.set(n10, string2);
    }

    private void setFileName(String string2) {
        string2.getClass();
        this.fileName_ = string2;
    }

    private void setFileNameBytes(ByteString object) {
        AbstractMessageLite.checkByteStringIsUtf8((ByteString)object);
        this.fileName_ = object = ((ByteString)object).toStringUtf8();
    }

    private void setInputType(CalculatorProto$InputCollection$InputType calculatorProto$InputCollection$InputType) {
        int n10;
        this.inputType_ = n10 = calculatorProto$InputCollection$InputType.getNumber();
    }

    private void setInputTypeValue(int n10) {
        this.inputType_ = n10;
    }

    private void setName(String string2) {
        string2.getClass();
        this.name_ = string2;
    }

    private void setNameBytes(ByteString object) {
        AbstractMessageLite.checkByteStringIsUtf8((ByteString)object);
        this.name_ = object = ((ByteString)object).toStringUtf8();
    }

    private void setSidePacketName(int n10, String string2) {
        string2.getClass();
        this.ensureSidePacketNameIsMutable();
        this.sidePacketName_.set(n10, string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object dynamicMethod(GeneratedMessageLite$MethodToInvoke objectArray, Object clazz, Object object) {
        clazz = (Class<CalculatorProto$InputCollection>)CalculatorProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;
        Object object2 = objectArray.ordinal();
        object2 = clazz[object2];
        byte by2 = 1;
        object = null;
        switch (object2) {
            default: {
                objectArray = new UnsupportedOperationException();
                throw objectArray;
            }
            case 7: {
                return null;
            }
            case 6: {
                return by2;
            }
            case 5: {
                objectArray = PARSER;
                if (objectArray != null) return objectArray;
                clazz = CalculatorProto$InputCollection.class;
                synchronized (clazz) {
                    objectArray = PARSER;
                    if (objectArray != null) return objectArray;
                    object = DEFAULT_INSTANCE;
                    PARSER = objectArray = new GeneratedMessageLite$DefaultInstanceBasedParser((GeneratedMessageLite)object);
                    return objectArray;
                }
            }
            case 4: {
                return DEFAULT_INSTANCE;
            }
            case 3: {
                objectArray = new Object[5];
                objectArray[0] = "name_";
                objectArray[by2] = "sidePacketName_";
                objectArray[2] = "inputType_";
                objectArray[3] = "fileName_";
                objectArray[4] = "externalInputName_";
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u03ea\u0005\u0000\u0002\u0000\u0001\u0208\u0002\u021a\u0003\f\u0004\u0208\u03ea\u021a", objectArray);
            }
            case 2: {
                return new CalculatorProto$InputCollection$Builder(null);
            }
            case 1: 
        }
        return new CalculatorProto$InputCollection();
    }

    public String getExternalInputName(int n10) {
        return (String)this.externalInputName_.get(n10);
    }

    public ByteString getExternalInputNameBytes(int n10) {
        return ByteString.copyFromUtf8((String)this.externalInputName_.get(n10));
    }

    public int getExternalInputNameCount() {
        return this.externalInputName_.size();
    }

    public List getExternalInputNameList() {
        return this.externalInputName_;
    }

    public String getFileName() {
        return this.fileName_;
    }

    public ByteString getFileNameBytes() {
        return ByteString.copyFromUtf8(this.fileName_);
    }

    public CalculatorProto$InputCollection$InputType getInputType() {
        int n10 = this.inputType_;
        CalculatorProto$InputCollection$InputType calculatorProto$InputCollection$InputType = CalculatorProto$InputCollection$InputType.forNumber(n10);
        if (calculatorProto$InputCollection$InputType == null) {
            calculatorProto$InputCollection$InputType = CalculatorProto$InputCollection$InputType.UNRECOGNIZED;
        }
        return calculatorProto$InputCollection$InputType;
    }

    public int getInputTypeValue() {
        return this.inputType_;
    }

    public String getName() {
        return this.name_;
    }

    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    public String getSidePacketName(int n10) {
        return (String)this.sidePacketName_.get(n10);
    }

    public ByteString getSidePacketNameBytes(int n10) {
        return ByteString.copyFromUtf8((String)this.sidePacketName_.get(n10));
    }

    public int getSidePacketNameCount() {
        return this.sidePacketName_.size();
    }

    public List getSidePacketNameList() {
        return this.sidePacketName_;
    }
}

