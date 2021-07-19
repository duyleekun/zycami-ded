/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.formats.proto;

import com.google.mediapipe.formats.proto.LocationDataProto$1;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$BinaryMask;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$BinaryMask$Builder;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$BoundingBox;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$BoundingBox$Builder;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$Format;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$RelativeBoundingBox;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$RelativeBoundingBox$Builder;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$RelativeKeypoint;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$RelativeKeypoint$Builder;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationDataOrBuilder;
import com.google.protobuf.GeneratedMessageLite$Builder;
import java.util.Collections;
import java.util.List;

public final class LocationDataProto$LocationData$Builder
extends GeneratedMessageLite$Builder
implements LocationDataProto$LocationDataOrBuilder {
    private LocationDataProto$LocationData$Builder() {
        LocationDataProto$LocationData locationDataProto$LocationData = LocationDataProto$LocationData.access$4000();
        super(locationDataProto$LocationData);
    }

    public /* synthetic */ LocationDataProto$LocationData$Builder(LocationDataProto$1 locationDataProto$1) {
        this();
    }

    public LocationDataProto$LocationData$Builder addAllRelativeKeypoints(Iterable iterable) {
        this.copyOnWrite();
        LocationDataProto$LocationData.access$5500((LocationDataProto$LocationData)this.instance, iterable);
        return this;
    }

    public LocationDataProto$LocationData$Builder addRelativeKeypoints(int n10, LocationDataProto$LocationData$RelativeKeypoint$Builder locationDataProto$LocationData$RelativeKeypointOrBuilder) {
        this.copyOnWrite();
        LocationDataProto$LocationData locationDataProto$LocationData = (LocationDataProto$LocationData)this.instance;
        locationDataProto$LocationData$RelativeKeypointOrBuilder = (LocationDataProto$LocationData$RelativeKeypoint)locationDataProto$LocationData$RelativeKeypointOrBuilder.build();
        LocationDataProto$LocationData.access$5400(locationDataProto$LocationData, n10, (LocationDataProto$LocationData$RelativeKeypoint)locationDataProto$LocationData$RelativeKeypointOrBuilder);
        return this;
    }

    public LocationDataProto$LocationData$Builder addRelativeKeypoints(int n10, LocationDataProto$LocationData$RelativeKeypoint locationDataProto$LocationData$RelativeKeypoint) {
        this.copyOnWrite();
        LocationDataProto$LocationData.access$5400((LocationDataProto$LocationData)this.instance, n10, locationDataProto$LocationData$RelativeKeypoint);
        return this;
    }

    public LocationDataProto$LocationData$Builder addRelativeKeypoints(LocationDataProto$LocationData$RelativeKeypoint$Builder locationDataProto$LocationData$RelativeKeypointOrBuilder) {
        this.copyOnWrite();
        LocationDataProto$LocationData locationDataProto$LocationData = (LocationDataProto$LocationData)this.instance;
        locationDataProto$LocationData$RelativeKeypointOrBuilder = (LocationDataProto$LocationData$RelativeKeypoint)locationDataProto$LocationData$RelativeKeypointOrBuilder.build();
        LocationDataProto$LocationData.access$5300(locationDataProto$LocationData, (LocationDataProto$LocationData$RelativeKeypoint)locationDataProto$LocationData$RelativeKeypointOrBuilder);
        return this;
    }

    public LocationDataProto$LocationData$Builder addRelativeKeypoints(LocationDataProto$LocationData$RelativeKeypoint locationDataProto$LocationData$RelativeKeypoint) {
        this.copyOnWrite();
        LocationDataProto$LocationData.access$5300((LocationDataProto$LocationData)this.instance, locationDataProto$LocationData$RelativeKeypoint);
        return this;
    }

    public LocationDataProto$LocationData$Builder clearBoundingBox() {
        this.copyOnWrite();
        LocationDataProto$LocationData.access$4500((LocationDataProto$LocationData)this.instance);
        return this;
    }

    public LocationDataProto$LocationData$Builder clearFormat() {
        this.copyOnWrite();
        LocationDataProto$LocationData.access$4200((LocationDataProto$LocationData)this.instance);
        return this;
    }

    public LocationDataProto$LocationData$Builder clearMask() {
        this.copyOnWrite();
        LocationDataProto$LocationData.access$5100((LocationDataProto$LocationData)this.instance);
        return this;
    }

    public LocationDataProto$LocationData$Builder clearRelativeBoundingBox() {
        this.copyOnWrite();
        LocationDataProto$LocationData.access$4800((LocationDataProto$LocationData)this.instance);
        return this;
    }

    public LocationDataProto$LocationData$Builder clearRelativeKeypoints() {
        this.copyOnWrite();
        LocationDataProto$LocationData.access$5600((LocationDataProto$LocationData)this.instance);
        return this;
    }

    public LocationDataProto$LocationData$BoundingBox getBoundingBox() {
        return ((LocationDataProto$LocationData)this.instance).getBoundingBox();
    }

    public LocationDataProto$LocationData$Format getFormat() {
        return ((LocationDataProto$LocationData)this.instance).getFormat();
    }

    public LocationDataProto$LocationData$BinaryMask getMask() {
        return ((LocationDataProto$LocationData)this.instance).getMask();
    }

    public LocationDataProto$LocationData$RelativeBoundingBox getRelativeBoundingBox() {
        return ((LocationDataProto$LocationData)this.instance).getRelativeBoundingBox();
    }

    public LocationDataProto$LocationData$RelativeKeypoint getRelativeKeypoints(int n10) {
        return ((LocationDataProto$LocationData)this.instance).getRelativeKeypoints(n10);
    }

    public int getRelativeKeypointsCount() {
        return ((LocationDataProto$LocationData)this.instance).getRelativeKeypointsCount();
    }

    public List getRelativeKeypointsList() {
        return Collections.unmodifiableList(((LocationDataProto$LocationData)this.instance).getRelativeKeypointsList());
    }

    public boolean hasBoundingBox() {
        return ((LocationDataProto$LocationData)this.instance).hasBoundingBox();
    }

    public boolean hasFormat() {
        return ((LocationDataProto$LocationData)this.instance).hasFormat();
    }

    public boolean hasMask() {
        return ((LocationDataProto$LocationData)this.instance).hasMask();
    }

    public boolean hasRelativeBoundingBox() {
        return ((LocationDataProto$LocationData)this.instance).hasRelativeBoundingBox();
    }

    public LocationDataProto$LocationData$Builder mergeBoundingBox(LocationDataProto$LocationData$BoundingBox locationDataProto$LocationData$BoundingBox) {
        this.copyOnWrite();
        LocationDataProto$LocationData.access$4400((LocationDataProto$LocationData)this.instance, locationDataProto$LocationData$BoundingBox);
        return this;
    }

    public LocationDataProto$LocationData$Builder mergeMask(LocationDataProto$LocationData$BinaryMask locationDataProto$LocationData$BinaryMask) {
        this.copyOnWrite();
        LocationDataProto$LocationData.access$5000((LocationDataProto$LocationData)this.instance, locationDataProto$LocationData$BinaryMask);
        return this;
    }

    public LocationDataProto$LocationData$Builder mergeRelativeBoundingBox(LocationDataProto$LocationData$RelativeBoundingBox locationDataProto$LocationData$RelativeBoundingBox) {
        this.copyOnWrite();
        LocationDataProto$LocationData.access$4700((LocationDataProto$LocationData)this.instance, locationDataProto$LocationData$RelativeBoundingBox);
        return this;
    }

    public LocationDataProto$LocationData$Builder removeRelativeKeypoints(int n10) {
        this.copyOnWrite();
        LocationDataProto$LocationData.access$5700((LocationDataProto$LocationData)this.instance, n10);
        return this;
    }

    public LocationDataProto$LocationData$Builder setBoundingBox(LocationDataProto$LocationData$BoundingBox$Builder locationDataProto$LocationData$BoundingBoxOrBuilder) {
        this.copyOnWrite();
        LocationDataProto$LocationData locationDataProto$LocationData = (LocationDataProto$LocationData)this.instance;
        locationDataProto$LocationData$BoundingBoxOrBuilder = (LocationDataProto$LocationData$BoundingBox)locationDataProto$LocationData$BoundingBoxOrBuilder.build();
        LocationDataProto$LocationData.access$4300(locationDataProto$LocationData, (LocationDataProto$LocationData$BoundingBox)locationDataProto$LocationData$BoundingBoxOrBuilder);
        return this;
    }

    public LocationDataProto$LocationData$Builder setBoundingBox(LocationDataProto$LocationData$BoundingBox locationDataProto$LocationData$BoundingBox) {
        this.copyOnWrite();
        LocationDataProto$LocationData.access$4300((LocationDataProto$LocationData)this.instance, locationDataProto$LocationData$BoundingBox);
        return this;
    }

    public LocationDataProto$LocationData$Builder setFormat(LocationDataProto$LocationData$Format locationDataProto$LocationData$Format) {
        this.copyOnWrite();
        LocationDataProto$LocationData.access$4100((LocationDataProto$LocationData)this.instance, locationDataProto$LocationData$Format);
        return this;
    }

    public LocationDataProto$LocationData$Builder setMask(LocationDataProto$LocationData$BinaryMask$Builder locationDataProto$LocationData$BinaryMaskOrBuilder) {
        this.copyOnWrite();
        LocationDataProto$LocationData locationDataProto$LocationData = (LocationDataProto$LocationData)this.instance;
        locationDataProto$LocationData$BinaryMaskOrBuilder = (LocationDataProto$LocationData$BinaryMask)locationDataProto$LocationData$BinaryMaskOrBuilder.build();
        LocationDataProto$LocationData.access$4900(locationDataProto$LocationData, (LocationDataProto$LocationData$BinaryMask)locationDataProto$LocationData$BinaryMaskOrBuilder);
        return this;
    }

    public LocationDataProto$LocationData$Builder setMask(LocationDataProto$LocationData$BinaryMask locationDataProto$LocationData$BinaryMask) {
        this.copyOnWrite();
        LocationDataProto$LocationData.access$4900((LocationDataProto$LocationData)this.instance, locationDataProto$LocationData$BinaryMask);
        return this;
    }

    public LocationDataProto$LocationData$Builder setRelativeBoundingBox(LocationDataProto$LocationData$RelativeBoundingBox$Builder locationDataProto$LocationData$RelativeBoundingBoxOrBuilder) {
        this.copyOnWrite();
        LocationDataProto$LocationData locationDataProto$LocationData = (LocationDataProto$LocationData)this.instance;
        locationDataProto$LocationData$RelativeBoundingBoxOrBuilder = (LocationDataProto$LocationData$RelativeBoundingBox)locationDataProto$LocationData$RelativeBoundingBoxOrBuilder.build();
        LocationDataProto$LocationData.access$4600(locationDataProto$LocationData, (LocationDataProto$LocationData$RelativeBoundingBox)locationDataProto$LocationData$RelativeBoundingBoxOrBuilder);
        return this;
    }

    public LocationDataProto$LocationData$Builder setRelativeBoundingBox(LocationDataProto$LocationData$RelativeBoundingBox locationDataProto$LocationData$RelativeBoundingBox) {
        this.copyOnWrite();
        LocationDataProto$LocationData.access$4600((LocationDataProto$LocationData)this.instance, locationDataProto$LocationData$RelativeBoundingBox);
        return this;
    }

    public LocationDataProto$LocationData$Builder setRelativeKeypoints(int n10, LocationDataProto$LocationData$RelativeKeypoint$Builder locationDataProto$LocationData$RelativeKeypointOrBuilder) {
        this.copyOnWrite();
        LocationDataProto$LocationData locationDataProto$LocationData = (LocationDataProto$LocationData)this.instance;
        locationDataProto$LocationData$RelativeKeypointOrBuilder = (LocationDataProto$LocationData$RelativeKeypoint)locationDataProto$LocationData$RelativeKeypointOrBuilder.build();
        LocationDataProto$LocationData.access$5200(locationDataProto$LocationData, n10, (LocationDataProto$LocationData$RelativeKeypoint)locationDataProto$LocationData$RelativeKeypointOrBuilder);
        return this;
    }

    public LocationDataProto$LocationData$Builder setRelativeKeypoints(int n10, LocationDataProto$LocationData$RelativeKeypoint locationDataProto$LocationData$RelativeKeypoint) {
        this.copyOnWrite();
        LocationDataProto$LocationData.access$5200((LocationDataProto$LocationData)this.instance, n10, locationDataProto$LocationData$RelativeKeypoint);
        return this;
    }
}

