/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.formats.proto;

import com.google.mediapipe.formats.annotation.proto.RasterizationProto$Rasterization;
import com.google.mediapipe.formats.annotation.proto.RasterizationProto$Rasterization$Builder;
import com.google.mediapipe.formats.proto.LocationDataProto$1;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$BinaryMask;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$BinaryMaskOrBuilder;
import com.google.protobuf.GeneratedMessageLite$Builder;

public final class LocationDataProto$LocationData$BinaryMask$Builder
extends GeneratedMessageLite$Builder
implements LocationDataProto$LocationData$BinaryMaskOrBuilder {
    private LocationDataProto$LocationData$BinaryMask$Builder() {
        LocationDataProto$LocationData$BinaryMask locationDataProto$LocationData$BinaryMask = LocationDataProto$LocationData$BinaryMask.access$2000();
        super(locationDataProto$LocationData$BinaryMask);
    }

    public /* synthetic */ LocationDataProto$LocationData$BinaryMask$Builder(LocationDataProto$1 locationDataProto$1) {
        this();
    }

    public LocationDataProto$LocationData$BinaryMask$Builder clearHeight() {
        this.copyOnWrite();
        LocationDataProto$LocationData$BinaryMask.access$2400((LocationDataProto$LocationData$BinaryMask)this.instance);
        return this;
    }

    public LocationDataProto$LocationData$BinaryMask$Builder clearRasterization() {
        this.copyOnWrite();
        LocationDataProto$LocationData$BinaryMask.access$2700((LocationDataProto$LocationData$BinaryMask)this.instance);
        return this;
    }

    public LocationDataProto$LocationData$BinaryMask$Builder clearWidth() {
        this.copyOnWrite();
        LocationDataProto$LocationData$BinaryMask.access$2200((LocationDataProto$LocationData$BinaryMask)this.instance);
        return this;
    }

    public int getHeight() {
        return ((LocationDataProto$LocationData$BinaryMask)this.instance).getHeight();
    }

    public RasterizationProto$Rasterization getRasterization() {
        return ((LocationDataProto$LocationData$BinaryMask)this.instance).getRasterization();
    }

    public int getWidth() {
        return ((LocationDataProto$LocationData$BinaryMask)this.instance).getWidth();
    }

    public boolean hasHeight() {
        return ((LocationDataProto$LocationData$BinaryMask)this.instance).hasHeight();
    }

    public boolean hasRasterization() {
        return ((LocationDataProto$LocationData$BinaryMask)this.instance).hasRasterization();
    }

    public boolean hasWidth() {
        return ((LocationDataProto$LocationData$BinaryMask)this.instance).hasWidth();
    }

    public LocationDataProto$LocationData$BinaryMask$Builder mergeRasterization(RasterizationProto$Rasterization rasterizationProto$Rasterization) {
        this.copyOnWrite();
        LocationDataProto$LocationData$BinaryMask.access$2600((LocationDataProto$LocationData$BinaryMask)this.instance, rasterizationProto$Rasterization);
        return this;
    }

    public LocationDataProto$LocationData$BinaryMask$Builder setHeight(int n10) {
        this.copyOnWrite();
        LocationDataProto$LocationData$BinaryMask.access$2300((LocationDataProto$LocationData$BinaryMask)this.instance, n10);
        return this;
    }

    public LocationDataProto$LocationData$BinaryMask$Builder setRasterization(RasterizationProto$Rasterization$Builder rasterizationProto$RasterizationOrBuilder) {
        this.copyOnWrite();
        LocationDataProto$LocationData$BinaryMask locationDataProto$LocationData$BinaryMask = (LocationDataProto$LocationData$BinaryMask)this.instance;
        rasterizationProto$RasterizationOrBuilder = (RasterizationProto$Rasterization)rasterizationProto$RasterizationOrBuilder.build();
        LocationDataProto$LocationData$BinaryMask.access$2500(locationDataProto$LocationData$BinaryMask, (RasterizationProto$Rasterization)rasterizationProto$RasterizationOrBuilder);
        return this;
    }

    public LocationDataProto$LocationData$BinaryMask$Builder setRasterization(RasterizationProto$Rasterization rasterizationProto$Rasterization) {
        this.copyOnWrite();
        LocationDataProto$LocationData$BinaryMask.access$2500((LocationDataProto$LocationData$BinaryMask)this.instance, rasterizationProto$Rasterization);
        return this;
    }

    public LocationDataProto$LocationData$BinaryMask$Builder setWidth(int n10) {
        this.copyOnWrite();
        LocationDataProto$LocationData$BinaryMask.access$2100((LocationDataProto$LocationData$BinaryMask)this.instance, n10);
        return this;
    }
}

