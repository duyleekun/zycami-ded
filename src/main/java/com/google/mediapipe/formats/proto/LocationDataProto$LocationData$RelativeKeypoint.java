/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.formats.proto;

import com.google.mediapipe.formats.proto.LocationDataProto$1;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$RelativeKeypoint$Builder;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$RelativeKeypointOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite$DefaultInstanceBasedParser;
import com.google.protobuf.GeneratedMessageLite$MethodToInvoke;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class LocationDataProto$LocationData$RelativeKeypoint
extends GeneratedMessageLite
implements LocationDataProto$LocationData$RelativeKeypointOrBuilder {
    private static final LocationDataProto$LocationData$RelativeKeypoint DEFAULT_INSTANCE;
    public static final int KEYPOINT_LABEL_FIELD_NUMBER = 3;
    private static volatile Parser PARSER;
    public static final int SCORE_FIELD_NUMBER = 4;
    public static final int X_FIELD_NUMBER = 1;
    public static final int Y_FIELD_NUMBER = 2;
    private int bitField0_;
    private String keypointLabel_ = "";
    private float score_;
    private float x_;
    private float y_;

    static {
        LocationDataProto$LocationData$RelativeKeypoint locationDataProto$LocationData$RelativeKeypoint;
        DEFAULT_INSTANCE = locationDataProto$LocationData$RelativeKeypoint = new LocationDataProto$LocationData$RelativeKeypoint();
        GeneratedMessageLite.registerDefaultInstance(LocationDataProto$LocationData$RelativeKeypoint.class, locationDataProto$LocationData$RelativeKeypoint);
    }

    private LocationDataProto$LocationData$RelativeKeypoint() {
    }

    public static /* synthetic */ LocationDataProto$LocationData$RelativeKeypoint access$2900() {
        return DEFAULT_INSTANCE;
    }

    public static /* synthetic */ void access$3000(LocationDataProto$LocationData$RelativeKeypoint locationDataProto$LocationData$RelativeKeypoint, float f10) {
        locationDataProto$LocationData$RelativeKeypoint.setX(f10);
    }

    public static /* synthetic */ void access$3100(LocationDataProto$LocationData$RelativeKeypoint locationDataProto$LocationData$RelativeKeypoint) {
        locationDataProto$LocationData$RelativeKeypoint.clearX();
    }

    public static /* synthetic */ void access$3200(LocationDataProto$LocationData$RelativeKeypoint locationDataProto$LocationData$RelativeKeypoint, float f10) {
        locationDataProto$LocationData$RelativeKeypoint.setY(f10);
    }

    public static /* synthetic */ void access$3300(LocationDataProto$LocationData$RelativeKeypoint locationDataProto$LocationData$RelativeKeypoint) {
        locationDataProto$LocationData$RelativeKeypoint.clearY();
    }

    public static /* synthetic */ void access$3400(LocationDataProto$LocationData$RelativeKeypoint locationDataProto$LocationData$RelativeKeypoint, String string2) {
        locationDataProto$LocationData$RelativeKeypoint.setKeypointLabel(string2);
    }

    public static /* synthetic */ void access$3500(LocationDataProto$LocationData$RelativeKeypoint locationDataProto$LocationData$RelativeKeypoint) {
        locationDataProto$LocationData$RelativeKeypoint.clearKeypointLabel();
    }

    public static /* synthetic */ void access$3600(LocationDataProto$LocationData$RelativeKeypoint locationDataProto$LocationData$RelativeKeypoint, ByteString byteString) {
        locationDataProto$LocationData$RelativeKeypoint.setKeypointLabelBytes(byteString);
    }

    public static /* synthetic */ void access$3700(LocationDataProto$LocationData$RelativeKeypoint locationDataProto$LocationData$RelativeKeypoint, float f10) {
        locationDataProto$LocationData$RelativeKeypoint.setScore(f10);
    }

    public static /* synthetic */ void access$3800(LocationDataProto$LocationData$RelativeKeypoint locationDataProto$LocationData$RelativeKeypoint) {
        locationDataProto$LocationData$RelativeKeypoint.clearScore();
    }

    private void clearKeypointLabel() {
        String string2;
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        this.keypointLabel_ = string2 = LocationDataProto$LocationData$RelativeKeypoint.getDefaultInstance().getKeypointLabel();
    }

    private void clearScore() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
        this.score_ = 0.0f;
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

    public static LocationDataProto$LocationData$RelativeKeypoint getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static LocationDataProto$LocationData$RelativeKeypoint$Builder newBuilder() {
        return (LocationDataProto$LocationData$RelativeKeypoint$Builder)DEFAULT_INSTANCE.createBuilder();
    }

    public static LocationDataProto$LocationData$RelativeKeypoint$Builder newBuilder(LocationDataProto$LocationData$RelativeKeypoint locationDataProto$LocationData$RelativeKeypoint) {
        return (LocationDataProto$LocationData$RelativeKeypoint$Builder)DEFAULT_INSTANCE.createBuilder(locationDataProto$LocationData$RelativeKeypoint);
    }

    public static LocationDataProto$LocationData$RelativeKeypoint parseDelimitedFrom(InputStream inputStream) {
        return (LocationDataProto$LocationData$RelativeKeypoint)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LocationDataProto$LocationData$RelativeKeypoint parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (LocationDataProto$LocationData$RelativeKeypoint)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static LocationDataProto$LocationData$RelativeKeypoint parseFrom(ByteString byteString) {
        return (LocationDataProto$LocationData$RelativeKeypoint)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString);
    }

    public static LocationDataProto$LocationData$RelativeKeypoint parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (LocationDataProto$LocationData$RelativeKeypoint)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static LocationDataProto$LocationData$RelativeKeypoint parseFrom(CodedInputStream codedInputStream) {
        return (LocationDataProto$LocationData$RelativeKeypoint)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream);
    }

    public static LocationDataProto$LocationData$RelativeKeypoint parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (LocationDataProto$LocationData$RelativeKeypoint)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static LocationDataProto$LocationData$RelativeKeypoint parseFrom(InputStream inputStream) {
        return (LocationDataProto$LocationData$RelativeKeypoint)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream);
    }

    public static LocationDataProto$LocationData$RelativeKeypoint parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (LocationDataProto$LocationData$RelativeKeypoint)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static LocationDataProto$LocationData$RelativeKeypoint parseFrom(ByteBuffer byteBuffer) {
        return (LocationDataProto$LocationData$RelativeKeypoint)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer);
    }

    public static LocationDataProto$LocationData$RelativeKeypoint parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (LocationDataProto$LocationData$RelativeKeypoint)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static LocationDataProto$LocationData$RelativeKeypoint parseFrom(byte[] byArray) {
        return (LocationDataProto$LocationData$RelativeKeypoint)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray);
    }

    public static LocationDataProto$LocationData$RelativeKeypoint parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (LocationDataProto$LocationData$RelativeKeypoint)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setKeypointLabel(String string2) {
        int n10;
        string2.getClass();
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.keypointLabel_ = string2;
    }

    private void setKeypointLabelBytes(ByteString object) {
        int n10;
        this.keypointLabel_ = object = ((ByteString)object).toStringUtf8();
        this.bitField0_ = n10 = this.bitField0_ | 4;
    }

    private void setScore(float f10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 8;
        this.score_ = f10;
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object dynamicMethod(GeneratedMessageLite$MethodToInvoke objectArray, Object clazz, Object object) {
        clazz = (Class<LocationDataProto$LocationData$RelativeKeypoint>)LocationDataProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;
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
                clazz = LocationDataProto$LocationData$RelativeKeypoint.class;
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
                objectArray[0] = "bitField0_";
                objectArray[by2] = "x_";
                objectArray[2] = "y_";
                objectArray[3] = "keypointLabel_";
                objectArray[4] = "score_";
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0001\u0000\u0002\u0001\u0001\u0003\b\u0002\u0004\u0001\u0003", objectArray);
            }
            case 2: {
                return new LocationDataProto$LocationData$RelativeKeypoint$Builder(null);
            }
            case 1: 
        }
        return new LocationDataProto$LocationData$RelativeKeypoint();
    }

    public String getKeypointLabel() {
        return this.keypointLabel_;
    }

    public ByteString getKeypointLabelBytes() {
        return ByteString.copyFromUtf8(this.keypointLabel_);
    }

    public float getScore() {
        return this.score_;
    }

    public float getX() {
        return this.x_;
    }

    public float getY() {
        return this.y_;
    }

    public boolean hasKeypointLabel() {
        int n10 = this.bitField0_ & 4;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasScore() {
        int n10 = this.bitField0_ & 8;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
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
}

