/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.formats.proto;

import com.google.mediapipe.formats.proto.LandmarkProto$1;
import com.google.mediapipe.formats.proto.LandmarkProto$Landmark$Builder;
import com.google.mediapipe.formats.proto.LandmarkProto$LandmarkOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite$DefaultInstanceBasedParser;
import com.google.protobuf.GeneratedMessageLite$MethodToInvoke;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class LandmarkProto$Landmark
extends GeneratedMessageLite
implements LandmarkProto$LandmarkOrBuilder {
    private static final LandmarkProto$Landmark DEFAULT_INSTANCE;
    private static volatile Parser PARSER;
    public static final int X_FIELD_NUMBER = 1;
    public static final int Y_FIELD_NUMBER = 2;
    public static final int Z_FIELD_NUMBER = 3;
    private int bitField0_;
    private float x_;
    private float y_;
    private float z_;

    static {
        LandmarkProto$Landmark landmarkProto$Landmark;
        DEFAULT_INSTANCE = landmarkProto$Landmark = new LandmarkProto$Landmark();
        GeneratedMessageLite.registerDefaultInstance(LandmarkProto$Landmark.class, landmarkProto$Landmark);
    }

    private LandmarkProto$Landmark() {
    }

    public static /* synthetic */ LandmarkProto$Landmark access$000() {
        return DEFAULT_INSTANCE;
    }

    public static /* synthetic */ void access$100(LandmarkProto$Landmark landmarkProto$Landmark, float f10) {
        landmarkProto$Landmark.setX(f10);
    }

    public static /* synthetic */ void access$200(LandmarkProto$Landmark landmarkProto$Landmark) {
        landmarkProto$Landmark.clearX();
    }

    public static /* synthetic */ void access$300(LandmarkProto$Landmark landmarkProto$Landmark, float f10) {
        landmarkProto$Landmark.setY(f10);
    }

    public static /* synthetic */ void access$400(LandmarkProto$Landmark landmarkProto$Landmark) {
        landmarkProto$Landmark.clearY();
    }

    public static /* synthetic */ void access$500(LandmarkProto$Landmark landmarkProto$Landmark, float f10) {
        landmarkProto$Landmark.setZ(f10);
    }

    public static /* synthetic */ void access$600(LandmarkProto$Landmark landmarkProto$Landmark) {
        landmarkProto$Landmark.clearZ();
    }

    private void clearX() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.x_ = 0.0f;
    }

    private void clearY() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        this.y_ = 0.0f;
    }

    private void clearZ() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        this.z_ = 0.0f;
    }

    public static LandmarkProto$Landmark getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static LandmarkProto$Landmark$Builder newBuilder() {
        return (LandmarkProto$Landmark$Builder)DEFAULT_INSTANCE.createBuilder();
    }

    public static LandmarkProto$Landmark$Builder newBuilder(LandmarkProto$Landmark landmarkProto$Landmark) {
        return (LandmarkProto$Landmark$Builder)DEFAULT_INSTANCE.createBuilder(landmarkProto$Landmark);
    }

    public static LandmarkProto$Landmark parseDelimitedFrom(InputStream inputStream) {
        return (LandmarkProto$Landmark)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LandmarkProto$Landmark parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (LandmarkProto$Landmark)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static LandmarkProto$Landmark parseFrom(ByteString byteString) {
        return (LandmarkProto$Landmark)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString);
    }

    public static LandmarkProto$Landmark parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (LandmarkProto$Landmark)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static LandmarkProto$Landmark parseFrom(CodedInputStream codedInputStream) {
        return (LandmarkProto$Landmark)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream);
    }

    public static LandmarkProto$Landmark parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (LandmarkProto$Landmark)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static LandmarkProto$Landmark parseFrom(InputStream inputStream) {
        return (LandmarkProto$Landmark)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream);
    }

    public static LandmarkProto$Landmark parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (LandmarkProto$Landmark)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static LandmarkProto$Landmark parseFrom(ByteBuffer byteBuffer) {
        return (LandmarkProto$Landmark)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer);
    }

    public static LandmarkProto$Landmark parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (LandmarkProto$Landmark)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static LandmarkProto$Landmark parseFrom(byte[] byArray) {
        return (LandmarkProto$Landmark)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray);
    }

    public static LandmarkProto$Landmark parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (LandmarkProto$Landmark)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setX(float f10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.x_ = f10;
    }

    private void setY(float f10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.y_ = f10;
    }

    private void setZ(float f10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.z_ = f10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object dynamicMethod(GeneratedMessageLite$MethodToInvoke objectArray, Object clazz, Object object) {
        clazz = (Class<LandmarkProto$Landmark>)LandmarkProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;
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
                clazz = LandmarkProto$Landmark.class;
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
                objectArray = new Object[4];
                objectArray[0] = "bitField0_";
                objectArray[by2] = "x_";
                objectArray[2] = "y_";
                objectArray[3] = "z_";
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0001\u0000\u0002\u0001\u0001\u0003\u0001\u0002", objectArray);
            }
            case 2: {
                return new LandmarkProto$Landmark$Builder(null);
            }
            case 1: 
        }
        return new LandmarkProto$Landmark();
    }

    public float getX() {
        return this.x_;
    }

    public float getY() {
        return this.y_;
    }

    public float getZ() {
        return this.z_;
    }

    public boolean hasX() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean hasY() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasZ() {
        int n10 = this.bitField0_ & 4;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }
}

