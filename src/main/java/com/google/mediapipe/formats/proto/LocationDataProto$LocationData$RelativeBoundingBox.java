/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.formats.proto;

import com.google.mediapipe.formats.proto.LocationDataProto$1;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$RelativeBoundingBox$Builder;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$RelativeBoundingBoxOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite$DefaultInstanceBasedParser;
import com.google.protobuf.GeneratedMessageLite$MethodToInvoke;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class LocationDataProto$LocationData$RelativeBoundingBox
extends GeneratedMessageLite
implements LocationDataProto$LocationData$RelativeBoundingBoxOrBuilder {
    private static final LocationDataProto$LocationData$RelativeBoundingBox DEFAULT_INSTANCE;
    public static final int HEIGHT_FIELD_NUMBER = 4;
    private static volatile Parser PARSER;
    public static final int WIDTH_FIELD_NUMBER = 3;
    public static final int XMIN_FIELD_NUMBER = 1;
    public static final int YMIN_FIELD_NUMBER = 2;
    private int bitField0_;
    private float height_;
    private float width_;
    private float xmin_;
    private float ymin_;

    static {
        LocationDataProto$LocationData$RelativeBoundingBox locationDataProto$LocationData$RelativeBoundingBox;
        DEFAULT_INSTANCE = locationDataProto$LocationData$RelativeBoundingBox = new LocationDataProto$LocationData$RelativeBoundingBox();
        GeneratedMessageLite.registerDefaultInstance(LocationDataProto$LocationData$RelativeBoundingBox.class, locationDataProto$LocationData$RelativeBoundingBox);
    }

    private LocationDataProto$LocationData$RelativeBoundingBox() {
    }

    public static /* synthetic */ LocationDataProto$LocationData$RelativeBoundingBox access$1000() {
        return DEFAULT_INSTANCE;
    }

    public static /* synthetic */ void access$1100(LocationDataProto$LocationData$RelativeBoundingBox locationDataProto$LocationData$RelativeBoundingBox, float f10) {
        locationDataProto$LocationData$RelativeBoundingBox.setXmin(f10);
    }

    public static /* synthetic */ void access$1200(LocationDataProto$LocationData$RelativeBoundingBox locationDataProto$LocationData$RelativeBoundingBox) {
        locationDataProto$LocationData$RelativeBoundingBox.clearXmin();
    }

    public static /* synthetic */ void access$1300(LocationDataProto$LocationData$RelativeBoundingBox locationDataProto$LocationData$RelativeBoundingBox, float f10) {
        locationDataProto$LocationData$RelativeBoundingBox.setYmin(f10);
    }

    public static /* synthetic */ void access$1400(LocationDataProto$LocationData$RelativeBoundingBox locationDataProto$LocationData$RelativeBoundingBox) {
        locationDataProto$LocationData$RelativeBoundingBox.clearYmin();
    }

    public static /* synthetic */ void access$1500(LocationDataProto$LocationData$RelativeBoundingBox locationDataProto$LocationData$RelativeBoundingBox, float f10) {
        locationDataProto$LocationData$RelativeBoundingBox.setWidth(f10);
    }

    public static /* synthetic */ void access$1600(LocationDataProto$LocationData$RelativeBoundingBox locationDataProto$LocationData$RelativeBoundingBox) {
        locationDataProto$LocationData$RelativeBoundingBox.clearWidth();
    }

    public static /* synthetic */ void access$1700(LocationDataProto$LocationData$RelativeBoundingBox locationDataProto$LocationData$RelativeBoundingBox, float f10) {
        locationDataProto$LocationData$RelativeBoundingBox.setHeight(f10);
    }

    public static /* synthetic */ void access$1800(LocationDataProto$LocationData$RelativeBoundingBox locationDataProto$LocationData$RelativeBoundingBox) {
        locationDataProto$LocationData$RelativeBoundingBox.clearHeight();
    }

    private void clearHeight() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
        this.height_ = 0.0f;
    }

    private void clearWidth() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        this.width_ = 0.0f;
    }

    private void clearXmin() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.xmin_ = 0.0f;
    }

    private void clearYmin() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        this.ymin_ = 0.0f;
    }

    public static LocationDataProto$LocationData$RelativeBoundingBox getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static LocationDataProto$LocationData$RelativeBoundingBox$Builder newBuilder() {
        return (LocationDataProto$LocationData$RelativeBoundingBox$Builder)DEFAULT_INSTANCE.createBuilder();
    }

    public static LocationDataProto$LocationData$RelativeBoundingBox$Builder newBuilder(LocationDataProto$LocationData$RelativeBoundingBox locationDataProto$LocationData$RelativeBoundingBox) {
        return (LocationDataProto$LocationData$RelativeBoundingBox$Builder)DEFAULT_INSTANCE.createBuilder(locationDataProto$LocationData$RelativeBoundingBox);
    }

    public static LocationDataProto$LocationData$RelativeBoundingBox parseDelimitedFrom(InputStream inputStream) {
        return (LocationDataProto$LocationData$RelativeBoundingBox)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LocationDataProto$LocationData$RelativeBoundingBox parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (LocationDataProto$LocationData$RelativeBoundingBox)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static LocationDataProto$LocationData$RelativeBoundingBox parseFrom(ByteString byteString) {
        return (LocationDataProto$LocationData$RelativeBoundingBox)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString);
    }

    public static LocationDataProto$LocationData$RelativeBoundingBox parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (LocationDataProto$LocationData$RelativeBoundingBox)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static LocationDataProto$LocationData$RelativeBoundingBox parseFrom(CodedInputStream codedInputStream) {
        return (LocationDataProto$LocationData$RelativeBoundingBox)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream);
    }

    public static LocationDataProto$LocationData$RelativeBoundingBox parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (LocationDataProto$LocationData$RelativeBoundingBox)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static LocationDataProto$LocationData$RelativeBoundingBox parseFrom(InputStream inputStream) {
        return (LocationDataProto$LocationData$RelativeBoundingBox)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream);
    }

    public static LocationDataProto$LocationData$RelativeBoundingBox parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (LocationDataProto$LocationData$RelativeBoundingBox)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static LocationDataProto$LocationData$RelativeBoundingBox parseFrom(ByteBuffer byteBuffer) {
        return (LocationDataProto$LocationData$RelativeBoundingBox)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer);
    }

    public static LocationDataProto$LocationData$RelativeBoundingBox parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (LocationDataProto$LocationData$RelativeBoundingBox)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static LocationDataProto$LocationData$RelativeBoundingBox parseFrom(byte[] byArray) {
        return (LocationDataProto$LocationData$RelativeBoundingBox)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray);
    }

    public static LocationDataProto$LocationData$RelativeBoundingBox parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (LocationDataProto$LocationData$RelativeBoundingBox)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setHeight(float f10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 8;
        this.height_ = f10;
    }

    private void setWidth(float f10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.width_ = f10;
    }

    private void setXmin(float f10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.xmin_ = f10;
    }

    private void setYmin(float f10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.ymin_ = f10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object dynamicMethod(GeneratedMessageLite$MethodToInvoke objectArray, Object clazz, Object object) {
        clazz = (Class<LocationDataProto$LocationData$RelativeBoundingBox>)LocationDataProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;
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
                clazz = LocationDataProto$LocationData$RelativeBoundingBox.class;
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
                objectArray[by2] = "xmin_";
                objectArray[2] = "ymin_";
                objectArray[3] = "width_";
                objectArray[4] = "height_";
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0001\u0000\u0002\u0001\u0001\u0003\u0001\u0002\u0004\u0001\u0003", objectArray);
            }
            case 2: {
                return new LocationDataProto$LocationData$RelativeBoundingBox$Builder(null);
            }
            case 1: 
        }
        return new LocationDataProto$LocationData$RelativeBoundingBox();
    }

    public float getHeight() {
        return this.height_;
    }

    public float getWidth() {
        return this.width_;
    }

    public float getXmin() {
        return this.xmin_;
    }

    public float getYmin() {
        return this.ymin_;
    }

    public boolean hasHeight() {
        int n10 = this.bitField0_ & 8;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasWidth() {
        int n10 = this.bitField0_ & 4;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasXmin() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean hasYmin() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }
}

