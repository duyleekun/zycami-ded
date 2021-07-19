/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.formats.proto;

import com.google.mediapipe.formats.proto.DetectionProto$1;
import com.google.mediapipe.formats.proto.DetectionProto$Detection;
import com.google.mediapipe.formats.proto.DetectionProto$DetectionList$Builder;
import com.google.mediapipe.formats.proto.DetectionProto$DetectionListOrBuilder;
import com.google.mediapipe.formats.proto.DetectionProto$DetectionOrBuilder;
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

public final class DetectionProto$DetectionList
extends GeneratedMessageLite
implements DetectionProto$DetectionListOrBuilder {
    private static final DetectionProto$DetectionList DEFAULT_INSTANCE;
    public static final int DETECTION_FIELD_NUMBER = 1;
    private static volatile Parser PARSER;
    private Internal$ProtobufList detection_;
    private byte memoizedIsInitialized = (byte)2;

    static {
        DetectionProto$DetectionList detectionProto$DetectionList;
        DEFAULT_INSTANCE = detectionProto$DetectionList = new DetectionProto$DetectionList();
        GeneratedMessageLite.registerDefaultInstance(DetectionProto$DetectionList.class, detectionProto$DetectionList);
    }

    private DetectionProto$DetectionList() {
        Internal$ProtobufList internal$ProtobufList;
        this.detection_ = internal$ProtobufList = GeneratedMessageLite.emptyProtobufList();
    }

    public static /* synthetic */ DetectionProto$DetectionList access$4500() {
        return DEFAULT_INSTANCE;
    }

    public static /* synthetic */ void access$4600(DetectionProto$DetectionList detectionProto$DetectionList, int n10, DetectionProto$Detection detectionProto$Detection) {
        detectionProto$DetectionList.setDetection(n10, detectionProto$Detection);
    }

    public static /* synthetic */ void access$4700(DetectionProto$DetectionList detectionProto$DetectionList, DetectionProto$Detection detectionProto$Detection) {
        detectionProto$DetectionList.addDetection(detectionProto$Detection);
    }

    public static /* synthetic */ void access$4800(DetectionProto$DetectionList detectionProto$DetectionList, int n10, DetectionProto$Detection detectionProto$Detection) {
        detectionProto$DetectionList.addDetection(n10, detectionProto$Detection);
    }

    public static /* synthetic */ void access$4900(DetectionProto$DetectionList detectionProto$DetectionList, Iterable iterable) {
        detectionProto$DetectionList.addAllDetection(iterable);
    }

    public static /* synthetic */ void access$5000(DetectionProto$DetectionList detectionProto$DetectionList) {
        detectionProto$DetectionList.clearDetection();
    }

    public static /* synthetic */ void access$5100(DetectionProto$DetectionList detectionProto$DetectionList, int n10) {
        detectionProto$DetectionList.removeDetection(n10);
    }

    private void addAllDetection(Iterable iterable) {
        this.ensureDetectionIsMutable();
        Internal$ProtobufList internal$ProtobufList = this.detection_;
        AbstractMessageLite.addAll(iterable, internal$ProtobufList);
    }

    private void addDetection(int n10, DetectionProto$Detection detectionProto$Detection) {
        detectionProto$Detection.getClass();
        this.ensureDetectionIsMutable();
        this.detection_.add(n10, detectionProto$Detection);
    }

    private void addDetection(DetectionProto$Detection detectionProto$Detection) {
        detectionProto$Detection.getClass();
        this.ensureDetectionIsMutable();
        this.detection_.add(detectionProto$Detection);
    }

    private void clearDetection() {
        Internal$ProtobufList internal$ProtobufList;
        this.detection_ = internal$ProtobufList = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureDetectionIsMutable() {
        Internal$ProtobufList internal$ProtobufList = this.detection_;
        boolean bl2 = internal$ProtobufList.isModifiable();
        if (!bl2) {
            this.detection_ = internal$ProtobufList = GeneratedMessageLite.mutableCopy(this.detection_);
        }
    }

    public static DetectionProto$DetectionList getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static DetectionProto$DetectionList$Builder newBuilder() {
        return (DetectionProto$DetectionList$Builder)DEFAULT_INSTANCE.createBuilder();
    }

    public static DetectionProto$DetectionList$Builder newBuilder(DetectionProto$DetectionList detectionProto$DetectionList) {
        return (DetectionProto$DetectionList$Builder)DEFAULT_INSTANCE.createBuilder(detectionProto$DetectionList);
    }

    public static DetectionProto$DetectionList parseDelimitedFrom(InputStream inputStream) {
        return (DetectionProto$DetectionList)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DetectionProto$DetectionList parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DetectionProto$DetectionList)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DetectionProto$DetectionList parseFrom(ByteString byteString) {
        return (DetectionProto$DetectionList)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString);
    }

    public static DetectionProto$DetectionList parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DetectionProto$DetectionList)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static DetectionProto$DetectionList parseFrom(CodedInputStream codedInputStream) {
        return (DetectionProto$DetectionList)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream);
    }

    public static DetectionProto$DetectionList parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DetectionProto$DetectionList)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static DetectionProto$DetectionList parseFrom(InputStream inputStream) {
        return (DetectionProto$DetectionList)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream);
    }

    public static DetectionProto$DetectionList parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DetectionProto$DetectionList)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DetectionProto$DetectionList parseFrom(ByteBuffer byteBuffer) {
        return (DetectionProto$DetectionList)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer);
    }

    public static DetectionProto$DetectionList parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (DetectionProto$DetectionList)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static DetectionProto$DetectionList parseFrom(byte[] byArray) {
        return (DetectionProto$DetectionList)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray);
    }

    public static DetectionProto$DetectionList parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (DetectionProto$DetectionList)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeDetection(int n10) {
        this.ensureDetectionIsMutable();
        this.detection_.remove(n10);
    }

    private void setDetection(int n10, DetectionProto$Detection detectionProto$Detection) {
        detectionProto$Detection.getClass();
        this.ensureDetectionIsMutable();
        this.detection_.set(n10, detectionProto$Detection);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object dynamicMethod(GeneratedMessageLite$MethodToInvoke objectArray, Object clazz, Object object) {
        object = DetectionProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;
        Object object2 = objectArray.ordinal();
        object2 = object[object2];
        int n10 = 1;
        switch (object2) {
            default: {
                objectArray = new UnsupportedOperationException();
                throw objectArray;
            }
            case 7: {
                if (clazz == null) {
                    n10 = 0;
                    object = null;
                }
                object2 = (byte)n10;
                this.memoizedIsInitialized = (byte)object2;
                return null;
            }
            case 6: {
                return this.memoizedIsInitialized;
            }
            case 5: {
                objectArray = PARSER;
                if (objectArray != null) return objectArray;
                clazz = DetectionProto$DetectionList.class;
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
                objectArray[0] = "detection_";
                objectArray[n10] = DetectionProto$Detection.class;
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u041b", objectArray);
            }
            case 2: {
                return new DetectionProto$DetectionList$Builder(null);
            }
            case 1: 
        }
        return new DetectionProto$DetectionList();
    }

    public DetectionProto$Detection getDetection(int n10) {
        return (DetectionProto$Detection)this.detection_.get(n10);
    }

    public int getDetectionCount() {
        return this.detection_.size();
    }

    public List getDetectionList() {
        return this.detection_;
    }

    public DetectionProto$DetectionOrBuilder getDetectionOrBuilder(int n10) {
        return (DetectionProto$DetectionOrBuilder)this.detection_.get(n10);
    }

    public List getDetectionOrBuilderList() {
        return this.detection_;
    }
}

