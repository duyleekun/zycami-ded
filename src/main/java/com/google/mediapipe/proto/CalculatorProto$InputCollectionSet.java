/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.proto;

import com.google.mediapipe.proto.CalculatorProto$1;
import com.google.mediapipe.proto.CalculatorProto$InputCollection;
import com.google.mediapipe.proto.CalculatorProto$InputCollectionOrBuilder;
import com.google.mediapipe.proto.CalculatorProto$InputCollectionSet$Builder;
import com.google.mediapipe.proto.CalculatorProto$InputCollectionSetOrBuilder;
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

public final class CalculatorProto$InputCollectionSet
extends GeneratedMessageLite
implements CalculatorProto$InputCollectionSetOrBuilder {
    private static final CalculatorProto$InputCollectionSet DEFAULT_INSTANCE;
    public static final int INPUT_COLLECTION_FIELD_NUMBER = 1;
    private static volatile Parser PARSER;
    private Internal$ProtobufList inputCollection_;

    static {
        CalculatorProto$InputCollectionSet calculatorProto$InputCollectionSet;
        DEFAULT_INSTANCE = calculatorProto$InputCollectionSet = new CalculatorProto$InputCollectionSet();
        GeneratedMessageLite.registerDefaultInstance(CalculatorProto$InputCollectionSet.class, calculatorProto$InputCollectionSet);
    }

    private CalculatorProto$InputCollectionSet() {
        Internal$ProtobufList internal$ProtobufList;
        this.inputCollection_ = internal$ProtobufList = GeneratedMessageLite.emptyProtobufList();
    }

    public static /* synthetic */ CalculatorProto$InputCollectionSet access$3200() {
        return DEFAULT_INSTANCE;
    }

    public static /* synthetic */ void access$3300(CalculatorProto$InputCollectionSet calculatorProto$InputCollectionSet, int n10, CalculatorProto$InputCollection calculatorProto$InputCollection) {
        calculatorProto$InputCollectionSet.setInputCollection(n10, calculatorProto$InputCollection);
    }

    public static /* synthetic */ void access$3400(CalculatorProto$InputCollectionSet calculatorProto$InputCollectionSet, CalculatorProto$InputCollection calculatorProto$InputCollection) {
        calculatorProto$InputCollectionSet.addInputCollection(calculatorProto$InputCollection);
    }

    public static /* synthetic */ void access$3500(CalculatorProto$InputCollectionSet calculatorProto$InputCollectionSet, int n10, CalculatorProto$InputCollection calculatorProto$InputCollection) {
        calculatorProto$InputCollectionSet.addInputCollection(n10, calculatorProto$InputCollection);
    }

    public static /* synthetic */ void access$3600(CalculatorProto$InputCollectionSet calculatorProto$InputCollectionSet, Iterable iterable) {
        calculatorProto$InputCollectionSet.addAllInputCollection(iterable);
    }

    public static /* synthetic */ void access$3700(CalculatorProto$InputCollectionSet calculatorProto$InputCollectionSet) {
        calculatorProto$InputCollectionSet.clearInputCollection();
    }

    public static /* synthetic */ void access$3800(CalculatorProto$InputCollectionSet calculatorProto$InputCollectionSet, int n10) {
        calculatorProto$InputCollectionSet.removeInputCollection(n10);
    }

    private void addAllInputCollection(Iterable iterable) {
        this.ensureInputCollectionIsMutable();
        Internal$ProtobufList internal$ProtobufList = this.inputCollection_;
        AbstractMessageLite.addAll(iterable, internal$ProtobufList);
    }

    private void addInputCollection(int n10, CalculatorProto$InputCollection calculatorProto$InputCollection) {
        calculatorProto$InputCollection.getClass();
        this.ensureInputCollectionIsMutable();
        this.inputCollection_.add(n10, calculatorProto$InputCollection);
    }

    private void addInputCollection(CalculatorProto$InputCollection calculatorProto$InputCollection) {
        calculatorProto$InputCollection.getClass();
        this.ensureInputCollectionIsMutable();
        this.inputCollection_.add(calculatorProto$InputCollection);
    }

    private void clearInputCollection() {
        Internal$ProtobufList internal$ProtobufList;
        this.inputCollection_ = internal$ProtobufList = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureInputCollectionIsMutable() {
        Internal$ProtobufList internal$ProtobufList = this.inputCollection_;
        boolean bl2 = internal$ProtobufList.isModifiable();
        if (!bl2) {
            this.inputCollection_ = internal$ProtobufList = GeneratedMessageLite.mutableCopy(this.inputCollection_);
        }
    }

    public static CalculatorProto$InputCollectionSet getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static CalculatorProto$InputCollectionSet$Builder newBuilder() {
        return (CalculatorProto$InputCollectionSet$Builder)DEFAULT_INSTANCE.createBuilder();
    }

    public static CalculatorProto$InputCollectionSet$Builder newBuilder(CalculatorProto$InputCollectionSet calculatorProto$InputCollectionSet) {
        return (CalculatorProto$InputCollectionSet$Builder)DEFAULT_INSTANCE.createBuilder(calculatorProto$InputCollectionSet);
    }

    public static CalculatorProto$InputCollectionSet parseDelimitedFrom(InputStream inputStream) {
        return (CalculatorProto$InputCollectionSet)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CalculatorProto$InputCollectionSet parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CalculatorProto$InputCollectionSet)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CalculatorProto$InputCollectionSet parseFrom(ByteString byteString) {
        return (CalculatorProto$InputCollectionSet)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString);
    }

    public static CalculatorProto$InputCollectionSet parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (CalculatorProto$InputCollectionSet)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static CalculatorProto$InputCollectionSet parseFrom(CodedInputStream codedInputStream) {
        return (CalculatorProto$InputCollectionSet)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream);
    }

    public static CalculatorProto$InputCollectionSet parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CalculatorProto$InputCollectionSet)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static CalculatorProto$InputCollectionSet parseFrom(InputStream inputStream) {
        return (CalculatorProto$InputCollectionSet)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream);
    }

    public static CalculatorProto$InputCollectionSet parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CalculatorProto$InputCollectionSet)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CalculatorProto$InputCollectionSet parseFrom(ByteBuffer byteBuffer) {
        return (CalculatorProto$InputCollectionSet)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer);
    }

    public static CalculatorProto$InputCollectionSet parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (CalculatorProto$InputCollectionSet)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static CalculatorProto$InputCollectionSet parseFrom(byte[] byArray) {
        return (CalculatorProto$InputCollectionSet)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray);
    }

    public static CalculatorProto$InputCollectionSet parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (CalculatorProto$InputCollectionSet)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeInputCollection(int n10) {
        this.ensureInputCollectionIsMutable();
        this.inputCollection_.remove(n10);
    }

    private void setInputCollection(int n10, CalculatorProto$InputCollection calculatorProto$InputCollection) {
        calculatorProto$InputCollection.getClass();
        this.ensureInputCollectionIsMutable();
        this.inputCollection_.set(n10, calculatorProto$InputCollection);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object dynamicMethod(GeneratedMessageLite$MethodToInvoke objectArray, Object clazz, Object object) {
        clazz = (Class<CalculatorProto$InputCollectionSet>)CalculatorProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;
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
                clazz = CalculatorProto$InputCollectionSet.class;
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
                objectArray = new Object[2];
                objectArray[0] = "inputCollection_";
                objectArray[by2] = CalculatorProto$InputCollection.class;
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", objectArray);
            }
            case 2: {
                return new CalculatorProto$InputCollectionSet$Builder(null);
            }
            case 1: 
        }
        return new CalculatorProto$InputCollectionSet();
    }

    public CalculatorProto$InputCollection getInputCollection(int n10) {
        return (CalculatorProto$InputCollection)this.inputCollection_.get(n10);
    }

    public int getInputCollectionCount() {
        return this.inputCollection_.size();
    }

    public List getInputCollectionList() {
        return this.inputCollection_;
    }

    public CalculatorProto$InputCollectionOrBuilder getInputCollectionOrBuilder(int n10) {
        return (CalculatorProto$InputCollectionOrBuilder)this.inputCollection_.get(n10);
    }

    public List getInputCollectionOrBuilderList() {
        return this.inputCollection_;
    }
}

