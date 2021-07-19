/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.formats.proto;

import com.google.mediapipe.formats.proto.DetectionProto$1;
import com.google.mediapipe.formats.proto.DetectionProto$Detection$AssociatedDetection$Builder;
import com.google.mediapipe.formats.proto.DetectionProto$Detection$AssociatedDetectionOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite$DefaultInstanceBasedParser;
import com.google.protobuf.GeneratedMessageLite$MethodToInvoke;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class DetectionProto$Detection$AssociatedDetection
extends GeneratedMessageLite
implements DetectionProto$Detection$AssociatedDetectionOrBuilder {
    public static final int CONFIDENCE_FIELD_NUMBER = 2;
    private static final DetectionProto$Detection$AssociatedDetection DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    private static volatile Parser PARSER;
    private int bitField0_;
    private float confidence_;
    private int id_;

    static {
        DetectionProto$Detection$AssociatedDetection detectionProto$Detection$AssociatedDetection;
        DEFAULT_INSTANCE = detectionProto$Detection$AssociatedDetection = new DetectionProto$Detection$AssociatedDetection();
        GeneratedMessageLite.registerDefaultInstance(DetectionProto$Detection$AssociatedDetection.class, detectionProto$Detection$AssociatedDetection);
    }

    private DetectionProto$Detection$AssociatedDetection() {
    }

    public static /* synthetic */ DetectionProto$Detection$AssociatedDetection access$000() {
        return DEFAULT_INSTANCE;
    }

    public static /* synthetic */ void access$100(DetectionProto$Detection$AssociatedDetection detectionProto$Detection$AssociatedDetection, int n10) {
        detectionProto$Detection$AssociatedDetection.setId(n10);
    }

    public static /* synthetic */ void access$200(DetectionProto$Detection$AssociatedDetection detectionProto$Detection$AssociatedDetection) {
        detectionProto$Detection$AssociatedDetection.clearId();
    }

    public static /* synthetic */ void access$300(DetectionProto$Detection$AssociatedDetection detectionProto$Detection$AssociatedDetection, float f10) {
        detectionProto$Detection$AssociatedDetection.setConfidence(f10);
    }

    public static /* synthetic */ void access$400(DetectionProto$Detection$AssociatedDetection detectionProto$Detection$AssociatedDetection) {
        detectionProto$Detection$AssociatedDetection.clearConfidence();
    }

    private void clearConfidence() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        this.confidence_ = 0.0f;
    }

    private void clearId() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.id_ = 0;
    }

    public static DetectionProto$Detection$AssociatedDetection getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static DetectionProto$Detection$AssociatedDetection$Builder newBuilder() {
        return (DetectionProto$Detection$AssociatedDetection$Builder)DEFAULT_INSTANCE.createBuilder();
    }

    public static DetectionProto$Detection$AssociatedDetection$Builder newBuilder(DetectionProto$Detection$AssociatedDetection detectionProto$Detection$AssociatedDetection) {
        return (DetectionProto$Detection$AssociatedDetection$Builder)DEFAULT_INSTANCE.createBuilder(detectionProto$Detection$AssociatedDetection);
    }

    public static DetectionProto$Detection$AssociatedDetection parseDelimitedFrom(InputStream inputStream) {
        return (DetectionProto$Detection$AssociatedDetection)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DetectionProto$Detection$AssociatedDetection parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DetectionProto$Detection$AssociatedDetection)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DetectionProto$Detection$AssociatedDetection parseFrom(ByteString byteString) {
        return (DetectionProto$Detection$AssociatedDetection)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString);
    }

    public static DetectionProto$Detection$AssociatedDetection parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DetectionProto$Detection$AssociatedDetection)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static DetectionProto$Detection$AssociatedDetection parseFrom(CodedInputStream codedInputStream) {
        return (DetectionProto$Detection$AssociatedDetection)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream);
    }

    public static DetectionProto$Detection$AssociatedDetection parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DetectionProto$Detection$AssociatedDetection)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static DetectionProto$Detection$AssociatedDetection parseFrom(InputStream inputStream) {
        return (DetectionProto$Detection$AssociatedDetection)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream);
    }

    public static DetectionProto$Detection$AssociatedDetection parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DetectionProto$Detection$AssociatedDetection)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DetectionProto$Detection$AssociatedDetection parseFrom(ByteBuffer byteBuffer) {
        return (DetectionProto$Detection$AssociatedDetection)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer);
    }

    public static DetectionProto$Detection$AssociatedDetection parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (DetectionProto$Detection$AssociatedDetection)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static DetectionProto$Detection$AssociatedDetection parseFrom(byte[] byArray) {
        return (DetectionProto$Detection$AssociatedDetection)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray);
    }

    public static DetectionProto$Detection$AssociatedDetection parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (DetectionProto$Detection$AssociatedDetection)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setConfidence(float f10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.confidence_ = f10;
    }

    private void setId(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 1;
        this.id_ = n10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object dynamicMethod(GeneratedMessageLite$MethodToInvoke objectArray, Object clazz, Object object) {
        clazz = (Class<DetectionProto$Detection$AssociatedDetection>)DetectionProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;
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
                clazz = DetectionProto$Detection$AssociatedDetection.class;
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
                objectArray = new Object[3];
                objectArray[0] = "bitField0_";
                objectArray[by2] = "id_";
                objectArray[2] = "confidence_";
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0001\u0001", objectArray);
            }
            case 2: {
                return new DetectionProto$Detection$AssociatedDetection$Builder(null);
            }
            case 1: 
        }
        return new DetectionProto$Detection$AssociatedDetection();
    }

    public float getConfidence() {
        return this.confidence_;
    }

    public int getId() {
        return this.id_;
    }

    public boolean hasConfidence() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasId() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }
}

