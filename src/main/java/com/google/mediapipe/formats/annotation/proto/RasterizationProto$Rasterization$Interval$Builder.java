/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.formats.annotation.proto;

import com.google.mediapipe.formats.annotation.proto.RasterizationProto$1;
import com.google.mediapipe.formats.annotation.proto.RasterizationProto$Rasterization$Interval;
import com.google.mediapipe.formats.annotation.proto.RasterizationProto$Rasterization$IntervalOrBuilder;
import com.google.protobuf.GeneratedMessageLite$Builder;

public final class RasterizationProto$Rasterization$Interval$Builder
extends GeneratedMessageLite$Builder
implements RasterizationProto$Rasterization$IntervalOrBuilder {
    private RasterizationProto$Rasterization$Interval$Builder() {
        RasterizationProto$Rasterization$Interval rasterizationProto$Rasterization$Interval = RasterizationProto$Rasterization$Interval.access$000();
        super(rasterizationProto$Rasterization$Interval);
    }

    public /* synthetic */ RasterizationProto$Rasterization$Interval$Builder(RasterizationProto$1 rasterizationProto$1) {
        this();
    }

    public RasterizationProto$Rasterization$Interval$Builder clearLeftX() {
        this.copyOnWrite();
        RasterizationProto$Rasterization$Interval.access$400((RasterizationProto$Rasterization$Interval)this.instance);
        return this;
    }

    public RasterizationProto$Rasterization$Interval$Builder clearRightX() {
        this.copyOnWrite();
        RasterizationProto$Rasterization$Interval.access$600((RasterizationProto$Rasterization$Interval)this.instance);
        return this;
    }

    public RasterizationProto$Rasterization$Interval$Builder clearY() {
        this.copyOnWrite();
        RasterizationProto$Rasterization$Interval.access$200((RasterizationProto$Rasterization$Interval)this.instance);
        return this;
    }

    public int getLeftX() {
        return ((RasterizationProto$Rasterization$Interval)this.instance).getLeftX();
    }

    public int getRightX() {
        return ((RasterizationProto$Rasterization$Interval)this.instance).getRightX();
    }

    public int getY() {
        return ((RasterizationProto$Rasterization$Interval)this.instance).getY();
    }

    public boolean hasLeftX() {
        return ((RasterizationProto$Rasterization$Interval)this.instance).hasLeftX();
    }

    public boolean hasRightX() {
        return ((RasterizationProto$Rasterization$Interval)this.instance).hasRightX();
    }

    public boolean hasY() {
        return ((RasterizationProto$Rasterization$Interval)this.instance).hasY();
    }

    public RasterizationProto$Rasterization$Interval$Builder setLeftX(int n10) {
        this.copyOnWrite();
        RasterizationProto$Rasterization$Interval.access$300((RasterizationProto$Rasterization$Interval)this.instance, n10);
        return this;
    }

    public RasterizationProto$Rasterization$Interval$Builder setRightX(int n10) {
        this.copyOnWrite();
        RasterizationProto$Rasterization$Interval.access$500((RasterizationProto$Rasterization$Interval)this.instance, n10);
        return this;
    }

    public RasterizationProto$Rasterization$Interval$Builder setY(int n10) {
        this.copyOnWrite();
        RasterizationProto$Rasterization$Interval.access$100((RasterizationProto$Rasterization$Interval)this.instance, n10);
        return this;
    }
}

