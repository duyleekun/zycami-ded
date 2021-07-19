/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.formats.proto;

import com.google.mediapipe.formats.proto.LandmarkProto$1;
import com.google.mediapipe.formats.proto.LandmarkProto$NormalizedLandmark$Builder;
import com.google.mediapipe.formats.proto.LandmarkProto$NormalizedLandmarkOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite$DefaultInstanceBasedParser;
import com.google.protobuf.GeneratedMessageLite$MethodToInvoke;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class LandmarkProto$NormalizedLandmark
extends GeneratedMessageLite
implements LandmarkProto$NormalizedLandmarkOrBuilder {
    private static final LandmarkProto$NormalizedLandmark DEFAULT_INSTANCE;
    private static volatile Parser PARSER;
    public static final int X_FIELD_NUMBER = 1;
    public static final int Y_FIELD_NUMBER = 2;
    public static final int Z_FIELD_NUMBER = 3;
    private int bitField0_;
    private float x_;
    private float y_;
    private float z_;

    static {
        LandmarkProto$NormalizedLandmark landmarkProto$NormalizedLandmark;
        DEFAULT_INSTANCE = landmarkProto$NormalizedLandmark = new LandmarkProto$NormalizedLandmark();
        GeneratedMessageLite.registerDefaultInstance(LandmarkProto$NormalizedLandmark.class, landmarkProto$NormalizedLandmark);
    }

    private LandmarkProto$NormalizedLandmark() {
    }

    public static /* synthetic */ LandmarkProto$NormalizedLandmark access$1600() {
        return DEFAULT_INSTANCE;
    }

    public static /* synthetic */ void access$1700(LandmarkProto$NormalizedLandmark landmarkProto$NormalizedLandmark, float f10) {
        landmarkProto$NormalizedLandmark.setX(f10);
    }

    public static /* synthetic */ void access$1800(LandmarkProto$NormalizedLandmark landmarkProto$NormalizedLandmark) {
        landmarkProto$NormalizedLandmark.clearX();
    }

    public static /* synthetic */ void access$1900(LandmarkProto$NormalizedLandmark landmarkProto$NormalizedLandmark, float f10) {
        landmarkProto$NormalizedLandmark.setY(f10);
    }

    public static /* synthetic */ void access$2000(LandmarkProto$NormalizedLandmark landmarkProto$NormalizedLandmark) {
        landmarkProto$NormalizedLandmark.clearY();
    }

    public static /* synthetic */ void access$2100(LandmarkProto$NormalizedLandmark landmarkProto$NormalizedLandmark, float f10) {
        landmarkProto$NormalizedLandmark.setZ(f10);
    }

    public static /* synthetic */ void access$2200(LandmarkProto$NormalizedLandmark landmarkProto$NormalizedLandmark) {
        landmarkProto$NormalizedLandmark.clearZ();
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

    public static LandmarkProto$NormalizedLandmark getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static LandmarkProto$NormalizedLandmark$Builder newBuilder() {
        return (LandmarkProto$NormalizedLandmark$Builder)DEFAULT_INSTANCE.createBuilder();
    }

    public static LandmarkProto$NormalizedLandmark$Builder newBuilder(LandmarkProto$NormalizedLandmark landmarkProto$NormalizedLandmark) {
        return (LandmarkProto$NormalizedLandmark$Builder)DEFAULT_INSTANCE.createBuilder(landmarkProto$NormalizedLandmark);
    }

    public static LandmarkProto$NormalizedLandmark parseDelimitedFrom(InputStream inputStream) {
        return (LandmarkProto$NormalizedLandmark)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LandmarkProto$NormalizedLandmark parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (LandmarkProto$NormalizedLandmark)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static LandmarkProto$NormalizedLandmark parseFrom(ByteString byteString) {
        return (LandmarkProto$NormalizedLandmark)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString);
    }

    public static LandmarkProto$NormalizedLandmark parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (LandmarkProto$NormalizedLandmark)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static LandmarkProto$NormalizedLandmark parseFrom(CodedInputStream codedInputStream) {
        return (LandmarkProto$NormalizedLandmark)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream);
    }

    public static LandmarkProto$NormalizedLandmark parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (LandmarkProto$NormalizedLandmark)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static LandmarkProto$NormalizedLandmark parseFrom(InputStream inputStream) {
        return (LandmarkProto$NormalizedLandmark)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream);
    }

    public static LandmarkProto$NormalizedLandmark parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (LandmarkProto$NormalizedLandmark)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static LandmarkProto$NormalizedLandmark parseFrom(ByteBuffer byteBuffer) {
        return (LandmarkProto$NormalizedLandmark)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer);
    }

    public static LandmarkProto$NormalizedLandmark parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (LandmarkProto$NormalizedLandmark)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static LandmarkProto$NormalizedLandmark parseFrom(byte[] byArray) {
        return (LandmarkProto$NormalizedLandmark)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray);
    }

    public static LandmarkProto$NormalizedLandmark parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (LandmarkProto$NormalizedLandmark)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray, extensionRegistryLite);
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
        clazz = (Class<LandmarkProto$NormalizedLandmark>)LandmarkProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;
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
                clazz = LandmarkProto$NormalizedLandmark.class;
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
                return new LandmarkProto$NormalizedLandmark$Builder(null);
            }
            case 1: 
        }
        return new LandmarkProto$NormalizedLandmark();
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

