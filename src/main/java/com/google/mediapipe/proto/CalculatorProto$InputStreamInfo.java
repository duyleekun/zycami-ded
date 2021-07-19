/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.proto;

import com.google.mediapipe.proto.CalculatorProto$1;
import com.google.mediapipe.proto.CalculatorProto$InputStreamInfo$Builder;
import com.google.mediapipe.proto.CalculatorProto$InputStreamInfoOrBuilder;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite$DefaultInstanceBasedParser;
import com.google.protobuf.GeneratedMessageLite$MethodToInvoke;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class CalculatorProto$InputStreamInfo
extends GeneratedMessageLite
implements CalculatorProto$InputStreamInfoOrBuilder {
    public static final int BACK_EDGE_FIELD_NUMBER = 2;
    private static final CalculatorProto$InputStreamInfo DEFAULT_INSTANCE;
    private static volatile Parser PARSER;
    public static final int TAG_INDEX_FIELD_NUMBER = 1;
    private boolean backEdge_;
    private String tagIndex_ = "";

    static {
        CalculatorProto$InputStreamInfo calculatorProto$InputStreamInfo;
        DEFAULT_INSTANCE = calculatorProto$InputStreamInfo = new CalculatorProto$InputStreamInfo();
        GeneratedMessageLite.registerDefaultInstance(CalculatorProto$InputStreamInfo.class, calculatorProto$InputStreamInfo);
    }

    private CalculatorProto$InputStreamInfo() {
    }

    public static /* synthetic */ CalculatorProto$InputStreamInfo access$4000() {
        return DEFAULT_INSTANCE;
    }

    public static /* synthetic */ void access$4100(CalculatorProto$InputStreamInfo calculatorProto$InputStreamInfo, String string2) {
        calculatorProto$InputStreamInfo.setTagIndex(string2);
    }

    public static /* synthetic */ void access$4200(CalculatorProto$InputStreamInfo calculatorProto$InputStreamInfo) {
        calculatorProto$InputStreamInfo.clearTagIndex();
    }

    public static /* synthetic */ void access$4300(CalculatorProto$InputStreamInfo calculatorProto$InputStreamInfo, ByteString byteString) {
        calculatorProto$InputStreamInfo.setTagIndexBytes(byteString);
    }

    public static /* synthetic */ void access$4400(CalculatorProto$InputStreamInfo calculatorProto$InputStreamInfo, boolean bl2) {
        calculatorProto$InputStreamInfo.setBackEdge(bl2);
    }

    public static /* synthetic */ void access$4500(CalculatorProto$InputStreamInfo calculatorProto$InputStreamInfo) {
        calculatorProto$InputStreamInfo.clearBackEdge();
    }

    private void clearBackEdge() {
        this.backEdge_ = false;
    }

    private void clearTagIndex() {
        String string2;
        this.tagIndex_ = string2 = CalculatorProto$InputStreamInfo.getDefaultInstance().getTagIndex();
    }

    public static CalculatorProto$InputStreamInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static CalculatorProto$InputStreamInfo$Builder newBuilder() {
        return (CalculatorProto$InputStreamInfo$Builder)DEFAULT_INSTANCE.createBuilder();
    }

    public static CalculatorProto$InputStreamInfo$Builder newBuilder(CalculatorProto$InputStreamInfo calculatorProto$InputStreamInfo) {
        return (CalculatorProto$InputStreamInfo$Builder)DEFAULT_INSTANCE.createBuilder(calculatorProto$InputStreamInfo);
    }

    public static CalculatorProto$InputStreamInfo parseDelimitedFrom(InputStream inputStream) {
        return (CalculatorProto$InputStreamInfo)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CalculatorProto$InputStreamInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CalculatorProto$InputStreamInfo)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CalculatorProto$InputStreamInfo parseFrom(ByteString byteString) {
        return (CalculatorProto$InputStreamInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString);
    }

    public static CalculatorProto$InputStreamInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (CalculatorProto$InputStreamInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static CalculatorProto$InputStreamInfo parseFrom(CodedInputStream codedInputStream) {
        return (CalculatorProto$InputStreamInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream);
    }

    public static CalculatorProto$InputStreamInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CalculatorProto$InputStreamInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static CalculatorProto$InputStreamInfo parseFrom(InputStream inputStream) {
        return (CalculatorProto$InputStreamInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream);
    }

    public static CalculatorProto$InputStreamInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CalculatorProto$InputStreamInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CalculatorProto$InputStreamInfo parseFrom(ByteBuffer byteBuffer) {
        return (CalculatorProto$InputStreamInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer);
    }

    public static CalculatorProto$InputStreamInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (CalculatorProto$InputStreamInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static CalculatorProto$InputStreamInfo parseFrom(byte[] byArray) {
        return (CalculatorProto$InputStreamInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray);
    }

    public static CalculatorProto$InputStreamInfo parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (CalculatorProto$InputStreamInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBackEdge(boolean bl2) {
        this.backEdge_ = bl2;
    }

    private void setTagIndex(String string2) {
        string2.getClass();
        this.tagIndex_ = string2;
    }

    private void setTagIndexBytes(ByteString object) {
        AbstractMessageLite.checkByteStringIsUtf8((ByteString)object);
        this.tagIndex_ = object = ((ByteString)object).toStringUtf8();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object dynamicMethod(GeneratedMessageLite$MethodToInvoke objectArray, Object clazz, Object object) {
        clazz = (Class<CalculatorProto$InputStreamInfo>)CalculatorProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;
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
                clazz = CalculatorProto$InputStreamInfo.class;
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
                objectArray[0] = "tagIndex_";
                objectArray[by2] = "backEdge_";
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0208\u0002\u0007", objectArray);
            }
            case 2: {
                return new CalculatorProto$InputStreamInfo$Builder(null);
            }
            case 1: 
        }
        return new CalculatorProto$InputStreamInfo();
    }

    public boolean getBackEdge() {
        return this.backEdge_;
    }

    public String getTagIndex() {
        return this.tagIndex_;
    }

    public ByteString getTagIndexBytes() {
        return ByteString.copyFromUtf8(this.tagIndex_);
    }
}

