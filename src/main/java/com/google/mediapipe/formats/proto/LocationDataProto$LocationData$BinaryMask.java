/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.formats.proto;

import com.google.mediapipe.formats.annotation.proto.RasterizationProto$Rasterization;
import com.google.mediapipe.formats.annotation.proto.RasterizationProto$Rasterization$Builder;
import com.google.mediapipe.formats.annotation.proto.RasterizationProto$RasterizationOrBuilder;
import com.google.mediapipe.formats.proto.LocationDataProto$1;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$BinaryMask$Builder;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$BinaryMaskOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite$Builder;
import com.google.protobuf.GeneratedMessageLite$DefaultInstanceBasedParser;
import com.google.protobuf.GeneratedMessageLite$MethodToInvoke;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class LocationDataProto$LocationData$BinaryMask
extends GeneratedMessageLite
implements LocationDataProto$LocationData$BinaryMaskOrBuilder {
    private static final LocationDataProto$LocationData$BinaryMask DEFAULT_INSTANCE;
    public static final int HEIGHT_FIELD_NUMBER = 2;
    private static volatile Parser PARSER;
    public static final int RASTERIZATION_FIELD_NUMBER = 3;
    public static final int WIDTH_FIELD_NUMBER = 1;
    private int bitField0_;
    private int height_;
    private byte memoizedIsInitialized = (byte)2;
    private RasterizationProto$Rasterization rasterization_;
    private int width_;

    static {
        LocationDataProto$LocationData$BinaryMask locationDataProto$LocationData$BinaryMask;
        DEFAULT_INSTANCE = locationDataProto$LocationData$BinaryMask = new LocationDataProto$LocationData$BinaryMask();
        GeneratedMessageLite.registerDefaultInstance(LocationDataProto$LocationData$BinaryMask.class, locationDataProto$LocationData$BinaryMask);
    }

    private LocationDataProto$LocationData$BinaryMask() {
    }

    public static /* synthetic */ LocationDataProto$LocationData$BinaryMask access$2000() {
        return DEFAULT_INSTANCE;
    }

    public static /* synthetic */ void access$2100(LocationDataProto$LocationData$BinaryMask locationDataProto$LocationData$BinaryMask, int n10) {
        locationDataProto$LocationData$BinaryMask.setWidth(n10);
    }

    public static /* synthetic */ void access$2200(LocationDataProto$LocationData$BinaryMask locationDataProto$LocationData$BinaryMask) {
        locationDataProto$LocationData$BinaryMask.clearWidth();
    }

    public static /* synthetic */ void access$2300(LocationDataProto$LocationData$BinaryMask locationDataProto$LocationData$BinaryMask, int n10) {
        locationDataProto$LocationData$BinaryMask.setHeight(n10);
    }

    public static /* synthetic */ void access$2400(LocationDataProto$LocationData$BinaryMask locationDataProto$LocationData$BinaryMask) {
        locationDataProto$LocationData$BinaryMask.clearHeight();
    }

    public static /* synthetic */ void access$2500(LocationDataProto$LocationData$BinaryMask locationDataProto$LocationData$BinaryMask, RasterizationProto$Rasterization rasterizationProto$Rasterization) {
        locationDataProto$LocationData$BinaryMask.setRasterization(rasterizationProto$Rasterization);
    }

    public static /* synthetic */ void access$2600(LocationDataProto$LocationData$BinaryMask locationDataProto$LocationData$BinaryMask, RasterizationProto$Rasterization rasterizationProto$Rasterization) {
        locationDataProto$LocationData$BinaryMask.mergeRasterization(rasterizationProto$Rasterization);
    }

    public static /* synthetic */ void access$2700(LocationDataProto$LocationData$BinaryMask locationDataProto$LocationData$BinaryMask) {
        locationDataProto$LocationData$BinaryMask.clearRasterization();
    }

    private void clearHeight() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        this.height_ = 0;
    }

    private void clearRasterization() {
        int n10;
        this.rasterization_ = null;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
    }

    private void clearWidth() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.width_ = 0;
    }

    public static LocationDataProto$LocationData$BinaryMask getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeRasterization(RasterizationProto$Rasterization rasterizationProto$Rasterization) {
        int n10;
        RasterizationProto$Rasterization rasterizationProto$Rasterization2;
        rasterizationProto$Rasterization.getClass();
        RasterizationProto$RasterizationOrBuilder rasterizationProto$RasterizationOrBuilder = this.rasterization_;
        if (rasterizationProto$RasterizationOrBuilder != null && rasterizationProto$RasterizationOrBuilder != (rasterizationProto$Rasterization2 = RasterizationProto$Rasterization.getDefaultInstance())) {
            rasterizationProto$RasterizationOrBuilder = RasterizationProto$Rasterization.newBuilder(this.rasterization_);
            this.rasterization_ = rasterizationProto$Rasterization = (RasterizationProto$Rasterization)((RasterizationProto$Rasterization$Builder)((GeneratedMessageLite$Builder)((Object)rasterizationProto$RasterizationOrBuilder)).mergeFrom(rasterizationProto$Rasterization)).buildPartial();
        } else {
            this.rasterization_ = rasterizationProto$Rasterization;
        }
        this.bitField0_ = n10 = this.bitField0_ | 4;
    }

    public static LocationDataProto$LocationData$BinaryMask$Builder newBuilder() {
        return (LocationDataProto$LocationData$BinaryMask$Builder)DEFAULT_INSTANCE.createBuilder();
    }

    public static LocationDataProto$LocationData$BinaryMask$Builder newBuilder(LocationDataProto$LocationData$BinaryMask locationDataProto$LocationData$BinaryMask) {
        return (LocationDataProto$LocationData$BinaryMask$Builder)DEFAULT_INSTANCE.createBuilder(locationDataProto$LocationData$BinaryMask);
    }

    public static LocationDataProto$LocationData$BinaryMask parseDelimitedFrom(InputStream inputStream) {
        return (LocationDataProto$LocationData$BinaryMask)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LocationDataProto$LocationData$BinaryMask parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (LocationDataProto$LocationData$BinaryMask)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static LocationDataProto$LocationData$BinaryMask parseFrom(ByteString byteString) {
        return (LocationDataProto$LocationData$BinaryMask)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString);
    }

    public static LocationDataProto$LocationData$BinaryMask parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (LocationDataProto$LocationData$BinaryMask)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static LocationDataProto$LocationData$BinaryMask parseFrom(CodedInputStream codedInputStream) {
        return (LocationDataProto$LocationData$BinaryMask)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream);
    }

    public static LocationDataProto$LocationData$BinaryMask parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (LocationDataProto$LocationData$BinaryMask)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static LocationDataProto$LocationData$BinaryMask parseFrom(InputStream inputStream) {
        return (LocationDataProto$LocationData$BinaryMask)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream);
    }

    public static LocationDataProto$LocationData$BinaryMask parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (LocationDataProto$LocationData$BinaryMask)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static LocationDataProto$LocationData$BinaryMask parseFrom(ByteBuffer byteBuffer) {
        return (LocationDataProto$LocationData$BinaryMask)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer);
    }

    public static LocationDataProto$LocationData$BinaryMask parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (LocationDataProto$LocationData$BinaryMask)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static LocationDataProto$LocationData$BinaryMask parseFrom(byte[] byArray) {
        return (LocationDataProto$LocationData$BinaryMask)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray);
    }

    public static LocationDataProto$LocationData$BinaryMask parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (LocationDataProto$LocationData$BinaryMask)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setHeight(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 2;
        this.height_ = n10;
    }

    private void setRasterization(RasterizationProto$Rasterization rasterizationProto$Rasterization) {
        int n10;
        rasterizationProto$Rasterization.getClass();
        this.rasterization_ = rasterizationProto$Rasterization;
        this.bitField0_ = n10 = this.bitField0_ | 4;
    }

    private void setWidth(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 1;
        this.width_ = n10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object dynamicMethod(GeneratedMessageLite$MethodToInvoke objectArray, Object clazz, Object object) {
        object = LocationDataProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;
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
                clazz = LocationDataProto$LocationData$BinaryMask.class;
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
                objectArray[n10] = "width_";
                objectArray[2] = "height_";
                objectArray[3] = "rasterization_";
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001\u0004\u0000\u0002\u0004\u0001\u0003\u0409\u0002", objectArray);
            }
            case 2: {
                return new LocationDataProto$LocationData$BinaryMask$Builder(null);
            }
            case 1: 
        }
        return new LocationDataProto$LocationData$BinaryMask();
    }

    public int getHeight() {
        return this.height_;
    }

    public RasterizationProto$Rasterization getRasterization() {
        RasterizationProto$Rasterization rasterizationProto$Rasterization = this.rasterization_;
        if (rasterizationProto$Rasterization == null) {
            rasterizationProto$Rasterization = RasterizationProto$Rasterization.getDefaultInstance();
        }
        return rasterizationProto$Rasterization;
    }

    public int getWidth() {
        return this.width_;
    }

    public boolean hasHeight() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasRasterization() {
        int n10 = this.bitField0_ & 4;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasWidth() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }
}

