/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.formats.proto;

import com.google.mediapipe.formats.proto.LocationDataProto$1;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$BoundingBox$Builder;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$BoundingBoxOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite$DefaultInstanceBasedParser;
import com.google.protobuf.GeneratedMessageLite$MethodToInvoke;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class LocationDataProto$LocationData$BoundingBox
extends GeneratedMessageLite
implements LocationDataProto$LocationData$BoundingBoxOrBuilder {
    private static final LocationDataProto$LocationData$BoundingBox DEFAULT_INSTANCE;
    public static final int HEIGHT_FIELD_NUMBER = 4;
    private static volatile Parser PARSER;
    public static final int WIDTH_FIELD_NUMBER = 3;
    public static final int XMIN_FIELD_NUMBER = 1;
    public static final int YMIN_FIELD_NUMBER = 2;
    private int bitField0_;
    private int height_;
    private int width_;
    private int xmin_;
    private int ymin_;

    static {
        LocationDataProto$LocationData$BoundingBox locationDataProto$LocationData$BoundingBox;
        DEFAULT_INSTANCE = locationDataProto$LocationData$BoundingBox = new LocationDataProto$LocationData$BoundingBox();
        GeneratedMessageLite.registerDefaultInstance(LocationDataProto$LocationData$BoundingBox.class, locationDataProto$LocationData$BoundingBox);
    }

    private LocationDataProto$LocationData$BoundingBox() {
    }

    public static /* synthetic */ LocationDataProto$LocationData$BoundingBox access$000() {
        return DEFAULT_INSTANCE;
    }

    public static /* synthetic */ void access$100(LocationDataProto$LocationData$BoundingBox locationDataProto$LocationData$BoundingBox, int n10) {
        locationDataProto$LocationData$BoundingBox.setXmin(n10);
    }

    public static /* synthetic */ void access$200(LocationDataProto$LocationData$BoundingBox locationDataProto$LocationData$BoundingBox) {
        locationDataProto$LocationData$BoundingBox.clearXmin();
    }

    public static /* synthetic */ void access$300(LocationDataProto$LocationData$BoundingBox locationDataProto$LocationData$BoundingBox, int n10) {
        locationDataProto$LocationData$BoundingBox.setYmin(n10);
    }

    public static /* synthetic */ void access$400(LocationDataProto$LocationData$BoundingBox locationDataProto$LocationData$BoundingBox) {
        locationDataProto$LocationData$BoundingBox.clearYmin();
    }

    public static /* synthetic */ void access$500(LocationDataProto$LocationData$BoundingBox locationDataProto$LocationData$BoundingBox, int n10) {
        locationDataProto$LocationData$BoundingBox.setWidth(n10);
    }

    public static /* synthetic */ void access$600(LocationDataProto$LocationData$BoundingBox locationDataProto$LocationData$BoundingBox) {
        locationDataProto$LocationData$BoundingBox.clearWidth();
    }

    public static /* synthetic */ void access$700(LocationDataProto$LocationData$BoundingBox locationDataProto$LocationData$BoundingBox, int n10) {
        locationDataProto$LocationData$BoundingBox.setHeight(n10);
    }

    public static /* synthetic */ void access$800(LocationDataProto$LocationData$BoundingBox locationDataProto$LocationData$BoundingBox) {
        locationDataProto$LocationData$BoundingBox.clearHeight();
    }

    private void clearHeight() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
        this.height_ = 0;
    }

    private void clearWidth() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        this.width_ = 0;
    }

    private void clearXmin() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.xmin_ = 0;
    }

    private void clearYmin() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        this.ymin_ = 0;
    }

    public static LocationDataProto$LocationData$BoundingBox getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static LocationDataProto$LocationData$BoundingBox$Builder newBuilder() {
        return (LocationDataProto$LocationData$BoundingBox$Builder)DEFAULT_INSTANCE.createBuilder();
    }

    public static LocationDataProto$LocationData$BoundingBox$Builder newBuilder(LocationDataProto$LocationData$BoundingBox locationDataProto$LocationData$BoundingBox) {
        return (LocationDataProto$LocationData$BoundingBox$Builder)DEFAULT_INSTANCE.createBuilder(locationDataProto$LocationData$BoundingBox);
    }

    public static LocationDataProto$LocationData$BoundingBox parseDelimitedFrom(InputStream inputStream) {
        return (LocationDataProto$LocationData$BoundingBox)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LocationDataProto$LocationData$BoundingBox parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (LocationDataProto$LocationData$BoundingBox)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static LocationDataProto$LocationData$BoundingBox parseFrom(ByteString byteString) {
        return (LocationDataProto$LocationData$BoundingBox)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString);
    }

    public static LocationDataProto$LocationData$BoundingBox parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (LocationDataProto$LocationData$BoundingBox)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static LocationDataProto$LocationData$BoundingBox parseFrom(CodedInputStream codedInputStream) {
        return (LocationDataProto$LocationData$BoundingBox)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream);
    }

    public static LocationDataProto$LocationData$BoundingBox parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (LocationDataProto$LocationData$BoundingBox)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static LocationDataProto$LocationData$BoundingBox parseFrom(InputStream inputStream) {
        return (LocationDataProto$LocationData$BoundingBox)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream);
    }

    public static LocationDataProto$LocationData$BoundingBox parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (LocationDataProto$LocationData$BoundingBox)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static LocationDataProto$LocationData$BoundingBox parseFrom(ByteBuffer byteBuffer) {
        return (LocationDataProto$LocationData$BoundingBox)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer);
    }

    public static LocationDataProto$LocationData$BoundingBox parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (LocationDataProto$LocationData$BoundingBox)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static LocationDataProto$LocationData$BoundingBox parseFrom(byte[] byArray) {
        return (LocationDataProto$LocationData$BoundingBox)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray);
    }

    public static LocationDataProto$LocationData$BoundingBox parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (LocationDataProto$LocationData$BoundingBox)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setHeight(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 8;
        this.height_ = n10;
    }

    private void setWidth(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 4;
        this.width_ = n10;
    }

    private void setXmin(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 1;
        this.xmin_ = n10;
    }

    private void setYmin(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 2;
        this.ymin_ = n10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object dynamicMethod(GeneratedMessageLite$MethodToInvoke objectArray, Object clazz, Object object) {
        clazz = (Class<LocationDataProto$LocationData$BoundingBox>)LocationDataProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;
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
                clazz = LocationDataProto$LocationData$BoundingBox.class;
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
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001\u0003\u0004\u0002\u0004\u0004\u0003", objectArray);
            }
            case 2: {
                return new LocationDataProto$LocationData$BoundingBox$Builder(null);
            }
            case 1: 
        }
        return new LocationDataProto$LocationData$BoundingBox();
    }

    public int getHeight() {
        return this.height_;
    }

    public int getWidth() {
        return this.width_;
    }

    public int getXmin() {
        return this.xmin_;
    }

    public int getYmin() {
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

