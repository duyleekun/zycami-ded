/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.formats.proto;

import com.google.mediapipe.formats.proto.LocationDataProto$1;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$RelativeBoundingBox;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$RelativeBoundingBoxOrBuilder;
import com.google.protobuf.GeneratedMessageLite$Builder;

public final class LocationDataProto$LocationData$RelativeBoundingBox$Builder
extends GeneratedMessageLite$Builder
implements LocationDataProto$LocationData$RelativeBoundingBoxOrBuilder {
    private LocationDataProto$LocationData$RelativeBoundingBox$Builder() {
        LocationDataProto$LocationData$RelativeBoundingBox locationDataProto$LocationData$RelativeBoundingBox = LocationDataProto$LocationData$RelativeBoundingBox.access$1000();
        super(locationDataProto$LocationData$RelativeBoundingBox);
    }

    public /* synthetic */ LocationDataProto$LocationData$RelativeBoundingBox$Builder(LocationDataProto$1 locationDataProto$1) {
        this();
    }

    public LocationDataProto$LocationData$RelativeBoundingBox$Builder clearHeight() {
        this.copyOnWrite();
        LocationDataProto$LocationData$RelativeBoundingBox.access$1800((LocationDataProto$LocationData$RelativeBoundingBox)this.instance);
        return this;
    }

    public LocationDataProto$LocationData$RelativeBoundingBox$Builder clearWidth() {
        this.copyOnWrite();
        LocationDataProto$LocationData$RelativeBoundingBox.access$1600((LocationDataProto$LocationData$RelativeBoundingBox)this.instance);
        return this;
    }

    public LocationDataProto$LocationData$RelativeBoundingBox$Builder clearXmin() {
        this.copyOnWrite();
        LocationDataProto$LocationData$RelativeBoundingBox.access$1200((LocationDataProto$LocationData$RelativeBoundingBox)this.instance);
        return this;
    }

    public LocationDataProto$LocationData$RelativeBoundingBox$Builder clearYmin() {
        this.copyOnWrite();
        LocationDataProto$LocationData$RelativeBoundingBox.access$1400((LocationDataProto$LocationData$RelativeBoundingBox)this.instance);
        return this;
    }

    public float getHeight() {
        return ((LocationDataProto$LocationData$RelativeBoundingBox)this.instance).getHeight();
    }

    public float getWidth() {
        return ((LocationDataProto$LocationData$RelativeBoundingBox)this.instance).getWidth();
    }

    public float getXmin() {
        return ((LocationDataProto$LocationData$RelativeBoundingBox)this.instance).getXmin();
    }

    public float getYmin() {
        return ((LocationDataProto$LocationData$RelativeBoundingBox)this.instance).getYmin();
    }

    public boolean hasHeight() {
        return ((LocationDataProto$LocationData$RelativeBoundingBox)this.instance).hasHeight();
    }

    public boolean hasWidth() {
        return ((LocationDataProto$LocationData$RelativeBoundingBox)this.instance).hasWidth();
    }

    public boolean hasXmin() {
        return ((LocationDataProto$LocationData$RelativeBoundingBox)this.instance).hasXmin();
    }

    public boolean hasYmin() {
        return ((LocationDataProto$LocationData$RelativeBoundingBox)this.instance).hasYmin();
    }

    public LocationDataProto$LocationData$RelativeBoundingBox$Builder setHeight(float f10) {
        this.copyOnWrite();
        LocationDataProto$LocationData$RelativeBoundingBox.access$1700((LocationDataProto$LocationData$RelativeBoundingBox)this.instance, f10);
        return this;
    }

    public LocationDataProto$LocationData$RelativeBoundingBox$Builder setWidth(float f10) {
        this.copyOnWrite();
        LocationDataProto$LocationData$RelativeBoundingBox.access$1500((LocationDataProto$LocationData$RelativeBoundingBox)this.instance, f10);
        return this;
    }

    public LocationDataProto$LocationData$RelativeBoundingBox$Builder setXmin(float f10) {
        this.copyOnWrite();
        LocationDataProto$LocationData$RelativeBoundingBox.access$1100((LocationDataProto$LocationData$RelativeBoundingBox)this.instance, f10);
        return this;
    }

    public LocationDataProto$LocationData$RelativeBoundingBox$Builder setYmin(float f10) {
        this.copyOnWrite();
        LocationDataProto$LocationData$RelativeBoundingBox.access$1300((LocationDataProto$LocationData$RelativeBoundingBox)this.instance, f10);
        return this;
    }
}

