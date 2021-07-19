/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.formats.proto;

import com.google.mediapipe.formats.proto.LocationDataProto$1;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$BinaryMask;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$BinaryMask$Builder;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$BinaryMaskOrBuilder;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$BoundingBox;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$BoundingBox$Builder;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$BoundingBoxOrBuilder;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$Builder;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$Format;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$RelativeBoundingBox;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$RelativeBoundingBox$Builder;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$RelativeBoundingBoxOrBuilder;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$RelativeKeypoint;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$RelativeKeypointOrBuilder;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationDataOrBuilder;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite$Builder;
import com.google.protobuf.GeneratedMessageLite$DefaultInstanceBasedParser;
import com.google.protobuf.GeneratedMessageLite$MethodToInvoke;
import com.google.protobuf.Internal$ProtobufList;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class LocationDataProto$LocationData
extends GeneratedMessageLite
implements LocationDataProto$LocationDataOrBuilder {
    public static final int BOUNDING_BOX_FIELD_NUMBER = 2;
    private static final LocationDataProto$LocationData DEFAULT_INSTANCE;
    public static final int FORMAT_FIELD_NUMBER = 1;
    public static final int MASK_FIELD_NUMBER = 4;
    private static volatile Parser PARSER;
    public static final int RELATIVE_BOUNDING_BOX_FIELD_NUMBER = 3;
    public static final int RELATIVE_KEYPOINTS_FIELD_NUMBER = 5;
    private int bitField0_;
    private LocationDataProto$LocationData$BoundingBox boundingBox_;
    private int format_;
    private LocationDataProto$LocationData$BinaryMask mask_;
    private byte memoizedIsInitialized = (byte)2;
    private LocationDataProto$LocationData$RelativeBoundingBox relativeBoundingBox_;
    private Internal$ProtobufList relativeKeypoints_;

    static {
        LocationDataProto$LocationData locationDataProto$LocationData;
        DEFAULT_INSTANCE = locationDataProto$LocationData = new LocationDataProto$LocationData();
        GeneratedMessageLite.registerDefaultInstance(LocationDataProto$LocationData.class, locationDataProto$LocationData);
    }

    private LocationDataProto$LocationData() {
        Internal$ProtobufList internal$ProtobufList;
        this.relativeKeypoints_ = internal$ProtobufList = GeneratedMessageLite.emptyProtobufList();
    }

    public static /* synthetic */ LocationDataProto$LocationData access$4000() {
        return DEFAULT_INSTANCE;
    }

    public static /* synthetic */ void access$4100(LocationDataProto$LocationData locationDataProto$LocationData, LocationDataProto$LocationData$Format locationDataProto$LocationData$Format) {
        locationDataProto$LocationData.setFormat(locationDataProto$LocationData$Format);
    }

    public static /* synthetic */ void access$4200(LocationDataProto$LocationData locationDataProto$LocationData) {
        locationDataProto$LocationData.clearFormat();
    }

    public static /* synthetic */ void access$4300(LocationDataProto$LocationData locationDataProto$LocationData, LocationDataProto$LocationData$BoundingBox locationDataProto$LocationData$BoundingBox) {
        locationDataProto$LocationData.setBoundingBox(locationDataProto$LocationData$BoundingBox);
    }

    public static /* synthetic */ void access$4400(LocationDataProto$LocationData locationDataProto$LocationData, LocationDataProto$LocationData$BoundingBox locationDataProto$LocationData$BoundingBox) {
        locationDataProto$LocationData.mergeBoundingBox(locationDataProto$LocationData$BoundingBox);
    }

    public static /* synthetic */ void access$4500(LocationDataProto$LocationData locationDataProto$LocationData) {
        locationDataProto$LocationData.clearBoundingBox();
    }

    public static /* synthetic */ void access$4600(LocationDataProto$LocationData locationDataProto$LocationData, LocationDataProto$LocationData$RelativeBoundingBox locationDataProto$LocationData$RelativeBoundingBox) {
        locationDataProto$LocationData.setRelativeBoundingBox(locationDataProto$LocationData$RelativeBoundingBox);
    }

    public static /* synthetic */ void access$4700(LocationDataProto$LocationData locationDataProto$LocationData, LocationDataProto$LocationData$RelativeBoundingBox locationDataProto$LocationData$RelativeBoundingBox) {
        locationDataProto$LocationData.mergeRelativeBoundingBox(locationDataProto$LocationData$RelativeBoundingBox);
    }

    public static /* synthetic */ void access$4800(LocationDataProto$LocationData locationDataProto$LocationData) {
        locationDataProto$LocationData.clearRelativeBoundingBox();
    }

    public static /* synthetic */ void access$4900(LocationDataProto$LocationData locationDataProto$LocationData, LocationDataProto$LocationData$BinaryMask locationDataProto$LocationData$BinaryMask) {
        locationDataProto$LocationData.setMask(locationDataProto$LocationData$BinaryMask);
    }

    public static /* synthetic */ void access$5000(LocationDataProto$LocationData locationDataProto$LocationData, LocationDataProto$LocationData$BinaryMask locationDataProto$LocationData$BinaryMask) {
        locationDataProto$LocationData.mergeMask(locationDataProto$LocationData$BinaryMask);
    }

    public static /* synthetic */ void access$5100(LocationDataProto$LocationData locationDataProto$LocationData) {
        locationDataProto$LocationData.clearMask();
    }

    public static /* synthetic */ void access$5200(LocationDataProto$LocationData locationDataProto$LocationData, int n10, LocationDataProto$LocationData$RelativeKeypoint locationDataProto$LocationData$RelativeKeypoint) {
        locationDataProto$LocationData.setRelativeKeypoints(n10, locationDataProto$LocationData$RelativeKeypoint);
    }

    public static /* synthetic */ void access$5300(LocationDataProto$LocationData locationDataProto$LocationData, LocationDataProto$LocationData$RelativeKeypoint locationDataProto$LocationData$RelativeKeypoint) {
        locationDataProto$LocationData.addRelativeKeypoints(locationDataProto$LocationData$RelativeKeypoint);
    }

    public static /* synthetic */ void access$5400(LocationDataProto$LocationData locationDataProto$LocationData, int n10, LocationDataProto$LocationData$RelativeKeypoint locationDataProto$LocationData$RelativeKeypoint) {
        locationDataProto$LocationData.addRelativeKeypoints(n10, locationDataProto$LocationData$RelativeKeypoint);
    }

    public static /* synthetic */ void access$5500(LocationDataProto$LocationData locationDataProto$LocationData, Iterable iterable) {
        locationDataProto$LocationData.addAllRelativeKeypoints(iterable);
    }

    public static /* synthetic */ void access$5600(LocationDataProto$LocationData locationDataProto$LocationData) {
        locationDataProto$LocationData.clearRelativeKeypoints();
    }

    public static /* synthetic */ void access$5700(LocationDataProto$LocationData locationDataProto$LocationData, int n10) {
        locationDataProto$LocationData.removeRelativeKeypoints(n10);
    }

    private void addAllRelativeKeypoints(Iterable iterable) {
        this.ensureRelativeKeypointsIsMutable();
        Internal$ProtobufList internal$ProtobufList = this.relativeKeypoints_;
        AbstractMessageLite.addAll(iterable, internal$ProtobufList);
    }

    private void addRelativeKeypoints(int n10, LocationDataProto$LocationData$RelativeKeypoint locationDataProto$LocationData$RelativeKeypoint) {
        locationDataProto$LocationData$RelativeKeypoint.getClass();
        this.ensureRelativeKeypointsIsMutable();
        this.relativeKeypoints_.add(n10, locationDataProto$LocationData$RelativeKeypoint);
    }

    private void addRelativeKeypoints(LocationDataProto$LocationData$RelativeKeypoint locationDataProto$LocationData$RelativeKeypoint) {
        locationDataProto$LocationData$RelativeKeypoint.getClass();
        this.ensureRelativeKeypointsIsMutable();
        this.relativeKeypoints_.add(locationDataProto$LocationData$RelativeKeypoint);
    }

    private void clearBoundingBox() {
        int n10;
        this.boundingBox_ = null;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
    }

    private void clearFormat() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.format_ = 0;
    }

    private void clearMask() {
        int n10;
        this.mask_ = null;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
    }

    private void clearRelativeBoundingBox() {
        int n10;
        this.relativeBoundingBox_ = null;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
    }

    private void clearRelativeKeypoints() {
        Internal$ProtobufList internal$ProtobufList;
        this.relativeKeypoints_ = internal$ProtobufList = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureRelativeKeypointsIsMutable() {
        Internal$ProtobufList internal$ProtobufList = this.relativeKeypoints_;
        boolean bl2 = internal$ProtobufList.isModifiable();
        if (!bl2) {
            this.relativeKeypoints_ = internal$ProtobufList = GeneratedMessageLite.mutableCopy(this.relativeKeypoints_);
        }
    }

    public static LocationDataProto$LocationData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeBoundingBox(LocationDataProto$LocationData$BoundingBox locationDataProto$LocationData$BoundingBox) {
        int n10;
        LocationDataProto$LocationData$BoundingBox locationDataProto$LocationData$BoundingBox2;
        locationDataProto$LocationData$BoundingBox.getClass();
        LocationDataProto$LocationData$BoundingBoxOrBuilder locationDataProto$LocationData$BoundingBoxOrBuilder = this.boundingBox_;
        if (locationDataProto$LocationData$BoundingBoxOrBuilder != null && locationDataProto$LocationData$BoundingBoxOrBuilder != (locationDataProto$LocationData$BoundingBox2 = LocationDataProto$LocationData$BoundingBox.getDefaultInstance())) {
            locationDataProto$LocationData$BoundingBoxOrBuilder = LocationDataProto$LocationData$BoundingBox.newBuilder(this.boundingBox_);
            this.boundingBox_ = locationDataProto$LocationData$BoundingBox = (LocationDataProto$LocationData$BoundingBox)((LocationDataProto$LocationData$BoundingBox$Builder)((GeneratedMessageLite$Builder)((Object)locationDataProto$LocationData$BoundingBoxOrBuilder)).mergeFrom(locationDataProto$LocationData$BoundingBox)).buildPartial();
        } else {
            this.boundingBox_ = locationDataProto$LocationData$BoundingBox;
        }
        this.bitField0_ = n10 = this.bitField0_ | 2;
    }

    private void mergeMask(LocationDataProto$LocationData$BinaryMask locationDataProto$LocationData$BinaryMask) {
        int n10;
        LocationDataProto$LocationData$BinaryMask locationDataProto$LocationData$BinaryMask2;
        locationDataProto$LocationData$BinaryMask.getClass();
        LocationDataProto$LocationData$BinaryMaskOrBuilder locationDataProto$LocationData$BinaryMaskOrBuilder = this.mask_;
        if (locationDataProto$LocationData$BinaryMaskOrBuilder != null && locationDataProto$LocationData$BinaryMaskOrBuilder != (locationDataProto$LocationData$BinaryMask2 = LocationDataProto$LocationData$BinaryMask.getDefaultInstance())) {
            locationDataProto$LocationData$BinaryMaskOrBuilder = LocationDataProto$LocationData$BinaryMask.newBuilder(this.mask_);
            this.mask_ = locationDataProto$LocationData$BinaryMask = (LocationDataProto$LocationData$BinaryMask)((LocationDataProto$LocationData$BinaryMask$Builder)((GeneratedMessageLite$Builder)((Object)locationDataProto$LocationData$BinaryMaskOrBuilder)).mergeFrom(locationDataProto$LocationData$BinaryMask)).buildPartial();
        } else {
            this.mask_ = locationDataProto$LocationData$BinaryMask;
        }
        this.bitField0_ = n10 = this.bitField0_ | 8;
    }

    private void mergeRelativeBoundingBox(LocationDataProto$LocationData$RelativeBoundingBox locationDataProto$LocationData$RelativeBoundingBox) {
        int n10;
        LocationDataProto$LocationData$RelativeBoundingBox locationDataProto$LocationData$RelativeBoundingBox2;
        locationDataProto$LocationData$RelativeBoundingBox.getClass();
        LocationDataProto$LocationData$RelativeBoundingBoxOrBuilder locationDataProto$LocationData$RelativeBoundingBoxOrBuilder = this.relativeBoundingBox_;
        if (locationDataProto$LocationData$RelativeBoundingBoxOrBuilder != null && locationDataProto$LocationData$RelativeBoundingBoxOrBuilder != (locationDataProto$LocationData$RelativeBoundingBox2 = LocationDataProto$LocationData$RelativeBoundingBox.getDefaultInstance())) {
            locationDataProto$LocationData$RelativeBoundingBoxOrBuilder = LocationDataProto$LocationData$RelativeBoundingBox.newBuilder(this.relativeBoundingBox_);
            this.relativeBoundingBox_ = locationDataProto$LocationData$RelativeBoundingBox = (LocationDataProto$LocationData$RelativeBoundingBox)((LocationDataProto$LocationData$RelativeBoundingBox$Builder)((GeneratedMessageLite$Builder)((Object)locationDataProto$LocationData$RelativeBoundingBoxOrBuilder)).mergeFrom(locationDataProto$LocationData$RelativeBoundingBox)).buildPartial();
        } else {
            this.relativeBoundingBox_ = locationDataProto$LocationData$RelativeBoundingBox;
        }
        this.bitField0_ = n10 = this.bitField0_ | 4;
    }

    public static LocationDataProto$LocationData$Builder newBuilder() {
        return (LocationDataProto$LocationData$Builder)DEFAULT_INSTANCE.createBuilder();
    }

    public static LocationDataProto$LocationData$Builder newBuilder(LocationDataProto$LocationData locationDataProto$LocationData) {
        return (LocationDataProto$LocationData$Builder)DEFAULT_INSTANCE.createBuilder(locationDataProto$LocationData);
    }

    public static LocationDataProto$LocationData parseDelimitedFrom(InputStream inputStream) {
        return (LocationDataProto$LocationData)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LocationDataProto$LocationData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (LocationDataProto$LocationData)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static LocationDataProto$LocationData parseFrom(ByteString byteString) {
        return (LocationDataProto$LocationData)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString);
    }

    public static LocationDataProto$LocationData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (LocationDataProto$LocationData)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static LocationDataProto$LocationData parseFrom(CodedInputStream codedInputStream) {
        return (LocationDataProto$LocationData)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream);
    }

    public static LocationDataProto$LocationData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (LocationDataProto$LocationData)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static LocationDataProto$LocationData parseFrom(InputStream inputStream) {
        return (LocationDataProto$LocationData)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream);
    }

    public static LocationDataProto$LocationData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (LocationDataProto$LocationData)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static LocationDataProto$LocationData parseFrom(ByteBuffer byteBuffer) {
        return (LocationDataProto$LocationData)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer);
    }

    public static LocationDataProto$LocationData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (LocationDataProto$LocationData)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static LocationDataProto$LocationData parseFrom(byte[] byArray) {
        return (LocationDataProto$LocationData)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray);
    }

    public static LocationDataProto$LocationData parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (LocationDataProto$LocationData)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeRelativeKeypoints(int n10) {
        this.ensureRelativeKeypointsIsMutable();
        this.relativeKeypoints_.remove(n10);
    }

    private void setBoundingBox(LocationDataProto$LocationData$BoundingBox locationDataProto$LocationData$BoundingBox) {
        int n10;
        locationDataProto$LocationData$BoundingBox.getClass();
        this.boundingBox_ = locationDataProto$LocationData$BoundingBox;
        this.bitField0_ = n10 = this.bitField0_ | 2;
    }

    private void setFormat(LocationDataProto$LocationData$Format locationDataProto$LocationData$Format) {
        int n10;
        this.format_ = n10 = locationDataProto$LocationData$Format.getNumber();
        this.bitField0_ = n10 = this.bitField0_ | 1;
    }

    private void setMask(LocationDataProto$LocationData$BinaryMask locationDataProto$LocationData$BinaryMask) {
        int n10;
        locationDataProto$LocationData$BinaryMask.getClass();
        this.mask_ = locationDataProto$LocationData$BinaryMask;
        this.bitField0_ = n10 = this.bitField0_ | 8;
    }

    private void setRelativeBoundingBox(LocationDataProto$LocationData$RelativeBoundingBox locationDataProto$LocationData$RelativeBoundingBox) {
        int n10;
        locationDataProto$LocationData$RelativeBoundingBox.getClass();
        this.relativeBoundingBox_ = locationDataProto$LocationData$RelativeBoundingBox;
        this.bitField0_ = n10 = this.bitField0_ | 4;
    }

    private void setRelativeKeypoints(int n10, LocationDataProto$LocationData$RelativeKeypoint locationDataProto$LocationData$RelativeKeypoint) {
        locationDataProto$LocationData$RelativeKeypoint.getClass();
        this.ensureRelativeKeypointsIsMutable();
        this.relativeKeypoints_.set(n10, locationDataProto$LocationData$RelativeKeypoint);
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
                clazz = LocationDataProto$LocationData.class;
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
                objectArray = new Object[8];
                objectArray[0] = "bitField0_";
                objectArray[n10] = "format_";
                objectArray[2] = object = LocationDataProto$LocationData$Format.internalGetVerifier();
                objectArray[3] = "boundingBox_";
                objectArray[4] = "relativeBoundingBox_";
                objectArray[5] = "mask_";
                objectArray[6] = "relativeKeypoints_";
                objectArray[7] = LocationDataProto$LocationData$RelativeKeypoint.class;
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0001\u0001\f\u0000\u0002\t\u0001\u0003\t\u0002\u0004\u0409\u0003\u0005\u001b", objectArray);
            }
            case 2: {
                return new LocationDataProto$LocationData$Builder(null);
            }
            case 1: 
        }
        return new LocationDataProto$LocationData();
    }

    public LocationDataProto$LocationData$BoundingBox getBoundingBox() {
        LocationDataProto$LocationData$BoundingBox locationDataProto$LocationData$BoundingBox = this.boundingBox_;
        if (locationDataProto$LocationData$BoundingBox == null) {
            locationDataProto$LocationData$BoundingBox = LocationDataProto$LocationData$BoundingBox.getDefaultInstance();
        }
        return locationDataProto$LocationData$BoundingBox;
    }

    public LocationDataProto$LocationData$Format getFormat() {
        int n10 = this.format_;
        LocationDataProto$LocationData$Format locationDataProto$LocationData$Format = LocationDataProto$LocationData$Format.forNumber(n10);
        if (locationDataProto$LocationData$Format == null) {
            locationDataProto$LocationData$Format = LocationDataProto$LocationData$Format.GLOBAL;
        }
        return locationDataProto$LocationData$Format;
    }

    public LocationDataProto$LocationData$BinaryMask getMask() {
        LocationDataProto$LocationData$BinaryMask locationDataProto$LocationData$BinaryMask = this.mask_;
        if (locationDataProto$LocationData$BinaryMask == null) {
            locationDataProto$LocationData$BinaryMask = LocationDataProto$LocationData$BinaryMask.getDefaultInstance();
        }
        return locationDataProto$LocationData$BinaryMask;
    }

    public LocationDataProto$LocationData$RelativeBoundingBox getRelativeBoundingBox() {
        LocationDataProto$LocationData$RelativeBoundingBox locationDataProto$LocationData$RelativeBoundingBox = this.relativeBoundingBox_;
        if (locationDataProto$LocationData$RelativeBoundingBox == null) {
            locationDataProto$LocationData$RelativeBoundingBox = LocationDataProto$LocationData$RelativeBoundingBox.getDefaultInstance();
        }
        return locationDataProto$LocationData$RelativeBoundingBox;
    }

    public LocationDataProto$LocationData$RelativeKeypoint getRelativeKeypoints(int n10) {
        return (LocationDataProto$LocationData$RelativeKeypoint)this.relativeKeypoints_.get(n10);
    }

    public int getRelativeKeypointsCount() {
        return this.relativeKeypoints_.size();
    }

    public List getRelativeKeypointsList() {
        return this.relativeKeypoints_;
    }

    public LocationDataProto$LocationData$RelativeKeypointOrBuilder getRelativeKeypointsOrBuilder(int n10) {
        return (LocationDataProto$LocationData$RelativeKeypointOrBuilder)this.relativeKeypoints_.get(n10);
    }

    public List getRelativeKeypointsOrBuilderList() {
        return this.relativeKeypoints_;
    }

    public boolean hasBoundingBox() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasFormat() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean hasMask() {
        int n10 = this.bitField0_ & 8;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasRelativeBoundingBox() {
        int n10 = this.bitField0_ & 4;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }
}

