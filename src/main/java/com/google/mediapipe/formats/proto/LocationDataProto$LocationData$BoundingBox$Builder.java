/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.formats.proto;

import com.google.mediapipe.formats.proto.LocationDataProto$1;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$BoundingBox;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$BoundingBoxOrBuilder;
import com.google.protobuf.GeneratedMessageLite$Builder;

public final class LocationDataProto$LocationData$BoundingBox$Builder
extends GeneratedMessageLite$Builder
implements LocationDataProto$LocationData$BoundingBoxOrBuilder {
    private LocationDataProto$LocationData$BoundingBox$Builder() {
        LocationDataProto$LocationData$BoundingBox locationDataProto$LocationData$BoundingBox = LocationDataProto$LocationData$BoundingBox.access$000();
        super(locationDataProto$LocationData$BoundingBox);
    }

    public /* synthetic */ LocationDataProto$LocationData$BoundingBox$Builder(LocationDataProto$1 locationDataProto$1) {
        this();
    }

    public LocationDataProto$LocationData$BoundingBox$Builder clearHeight() {
        this.copyOnWrite();
        LocationDataProto$LocationData$BoundingBox.access$800((LocationDataProto$LocationData$BoundingBox)this.instance);
        return this;
    }

    public LocationDataProto$LocationData$BoundingBox$Builder clearWidth() {
        this.copyOnWrite();
        LocationDataProto$LocationData$BoundingBox.access$600((LocationDataProto$LocationData$BoundingBox)this.instance);
        return this;
    }

    public LocationDataProto$LocationData$BoundingBox$Builder clearXmin() {
        this.copyOnWrite();
        LocationDataProto$LocationData$BoundingBox.access$200((LocationDataProto$LocationData$BoundingBox)this.instance);
        return this;
    }

    public LocationDataProto$LocationData$BoundingBox$Builder clearYmin() {
        this.copyOnWrite();
        LocationDataProto$LocationData$BoundingBox.access$400((LocationDataProto$LocationData$BoundingBox)this.instance);
        return this;
    }

    public int getHeight() {
        return ((LocationDataProto$LocationData$BoundingBox)this.instance).getHeight();
    }

    public int getWidth() {
        return ((LocationDataProto$LocationData$BoundingBox)this.instance).getWidth();
    }

    public int getXmin() {
        return ((LocationDataProto$LocationData$BoundingBox)this.instance).getXmin();
    }

    public int getYmin() {
        return ((LocationDataProto$LocationData$BoundingBox)this.instance).getYmin();
    }

    public boolean hasHeight() {
        return ((LocationDataProto$LocationData$BoundingBox)this.instance).hasHeight();
    }

    public boolean hasWidth() {
        return ((LocationDataProto$LocationData$BoundingBox)this.instance).hasWidth();
    }

    public boolean hasXmin() {
        return ((LocationDataProto$LocationData$BoundingBox)this.instance).hasXmin();
    }

    public boolean hasYmin() {
        return ((LocationDataProto$LocationData$BoundingBox)this.instance).hasYmin();
    }

    public LocationDataProto$LocationData$BoundingBox$Builder setHeight(int n10) {
        this.copyOnWrite();
        LocationDataProto$LocationData$BoundingBox.access$700((LocationDataProto$LocationData$BoundingBox)this.instance, n10);
        return this;
    }

    public LocationDataProto$LocationData$BoundingBox$Builder setWidth(int n10) {
        this.copyOnWrite();
        LocationDataProto$LocationData$BoundingBox.access$500((LocationDataProto$LocationData$BoundingBox)this.instance, n10);
        return this;
    }

    public LocationDataProto$LocationData$BoundingBox$Builder setXmin(int n10) {
        this.copyOnWrite();
        LocationDataProto$LocationData$BoundingBox.access$100((LocationDataProto$LocationData$BoundingBox)this.instance, n10);
        return this;
    }

    public LocationDataProto$LocationData$BoundingBox$Builder setYmin(int n10) {
        this.copyOnWrite();
        LocationDataProto$LocationData$BoundingBox.access$300((LocationDataProto$LocationData$BoundingBox)this.instance, n10);
        return this;
    }
}

