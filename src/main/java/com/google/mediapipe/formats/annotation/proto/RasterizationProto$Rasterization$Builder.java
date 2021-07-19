/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.formats.annotation.proto;

import com.google.mediapipe.formats.annotation.proto.RasterizationProto$1;
import com.google.mediapipe.formats.annotation.proto.RasterizationProto$Rasterization;
import com.google.mediapipe.formats.annotation.proto.RasterizationProto$Rasterization$Interval;
import com.google.mediapipe.formats.annotation.proto.RasterizationProto$Rasterization$Interval$Builder;
import com.google.mediapipe.formats.annotation.proto.RasterizationProto$RasterizationOrBuilder;
import com.google.protobuf.GeneratedMessageLite$Builder;
import java.util.Collections;
import java.util.List;

public final class RasterizationProto$Rasterization$Builder
extends GeneratedMessageLite$Builder
implements RasterizationProto$RasterizationOrBuilder {
    private RasterizationProto$Rasterization$Builder() {
        RasterizationProto$Rasterization rasterizationProto$Rasterization = RasterizationProto$Rasterization.access$800();
        super(rasterizationProto$Rasterization);
    }

    public /* synthetic */ RasterizationProto$Rasterization$Builder(RasterizationProto$1 rasterizationProto$1) {
        this();
    }

    public RasterizationProto$Rasterization$Builder addAllInterval(Iterable iterable) {
        this.copyOnWrite();
        RasterizationProto$Rasterization.access$1200((RasterizationProto$Rasterization)this.instance, iterable);
        return this;
    }

    public RasterizationProto$Rasterization$Builder addInterval(int n10, RasterizationProto$Rasterization$Interval$Builder rasterizationProto$Rasterization$IntervalOrBuilder) {
        this.copyOnWrite();
        RasterizationProto$Rasterization rasterizationProto$Rasterization = (RasterizationProto$Rasterization)this.instance;
        rasterizationProto$Rasterization$IntervalOrBuilder = (RasterizationProto$Rasterization$Interval)rasterizationProto$Rasterization$IntervalOrBuilder.build();
        RasterizationProto$Rasterization.access$1100(rasterizationProto$Rasterization, n10, (RasterizationProto$Rasterization$Interval)rasterizationProto$Rasterization$IntervalOrBuilder);
        return this;
    }

    public RasterizationProto$Rasterization$Builder addInterval(int n10, RasterizationProto$Rasterization$Interval rasterizationProto$Rasterization$Interval) {
        this.copyOnWrite();
        RasterizationProto$Rasterization.access$1100((RasterizationProto$Rasterization)this.instance, n10, rasterizationProto$Rasterization$Interval);
        return this;
    }

    public RasterizationProto$Rasterization$Builder addInterval(RasterizationProto$Rasterization$Interval$Builder rasterizationProto$Rasterization$IntervalOrBuilder) {
        this.copyOnWrite();
        RasterizationProto$Rasterization rasterizationProto$Rasterization = (RasterizationProto$Rasterization)this.instance;
        rasterizationProto$Rasterization$IntervalOrBuilder = (RasterizationProto$Rasterization$Interval)rasterizationProto$Rasterization$IntervalOrBuilder.build();
        RasterizationProto$Rasterization.access$1000(rasterizationProto$Rasterization, (RasterizationProto$Rasterization$Interval)rasterizationProto$Rasterization$IntervalOrBuilder);
        return this;
    }

    public RasterizationProto$Rasterization$Builder addInterval(RasterizationProto$Rasterization$Interval rasterizationProto$Rasterization$Interval) {
        this.copyOnWrite();
        RasterizationProto$Rasterization.access$1000((RasterizationProto$Rasterization)this.instance, rasterizationProto$Rasterization$Interval);
        return this;
    }

    public RasterizationProto$Rasterization$Builder clearInterval() {
        this.copyOnWrite();
        RasterizationProto$Rasterization.access$1300((RasterizationProto$Rasterization)this.instance);
        return this;
    }

    public RasterizationProto$Rasterization$Interval getInterval(int n10) {
        return ((RasterizationProto$Rasterization)this.instance).getInterval(n10);
    }

    public int getIntervalCount() {
        return ((RasterizationProto$Rasterization)this.instance).getIntervalCount();
    }

    public List getIntervalList() {
        return Collections.unmodifiableList(((RasterizationProto$Rasterization)this.instance).getIntervalList());
    }

    public RasterizationProto$Rasterization$Builder removeInterval(int n10) {
        this.copyOnWrite();
        RasterizationProto$Rasterization.access$1400((RasterizationProto$Rasterization)this.instance, n10);
        return this;
    }

    public RasterizationProto$Rasterization$Builder setInterval(int n10, RasterizationProto$Rasterization$Interval$Builder rasterizationProto$Rasterization$IntervalOrBuilder) {
        this.copyOnWrite();
        RasterizationProto$Rasterization rasterizationProto$Rasterization = (RasterizationProto$Rasterization)this.instance;
        rasterizationProto$Rasterization$IntervalOrBuilder = (RasterizationProto$Rasterization$Interval)rasterizationProto$Rasterization$IntervalOrBuilder.build();
        RasterizationProto$Rasterization.access$900(rasterizationProto$Rasterization, n10, (RasterizationProto$Rasterization$Interval)rasterizationProto$Rasterization$IntervalOrBuilder);
        return this;
    }

    public RasterizationProto$Rasterization$Builder setInterval(int n10, RasterizationProto$Rasterization$Interval rasterizationProto$Rasterization$Interval) {
        this.copyOnWrite();
        RasterizationProto$Rasterization.access$900((RasterizationProto$Rasterization)this.instance, n10, rasterizationProto$Rasterization$Interval);
        return this;
    }
}

