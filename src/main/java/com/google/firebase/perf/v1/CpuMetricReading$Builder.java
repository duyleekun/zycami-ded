/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.CpuMetricReading;
import com.google.firebase.perf.v1.CpuMetricReading$1;
import com.google.firebase.perf.v1.CpuMetricReadingOrBuilder;
import com.google.protobuf.GeneratedMessageLite$Builder;

public final class CpuMetricReading$Builder
extends GeneratedMessageLite$Builder
implements CpuMetricReadingOrBuilder {
    private CpuMetricReading$Builder() {
        CpuMetricReading cpuMetricReading = CpuMetricReading.access$000();
        super(cpuMetricReading);
    }

    public /* synthetic */ CpuMetricReading$Builder(CpuMetricReading$1 cpuMetricReading$1) {
        this();
    }

    public CpuMetricReading$Builder clearClientTimeUs() {
        this.copyOnWrite();
        CpuMetricReading.access$200((CpuMetricReading)this.instance);
        return this;
    }

    public CpuMetricReading$Builder clearSystemTimeUs() {
        this.copyOnWrite();
        CpuMetricReading.access$600((CpuMetricReading)this.instance);
        return this;
    }

    public CpuMetricReading$Builder clearUserTimeUs() {
        this.copyOnWrite();
        CpuMetricReading.access$400((CpuMetricReading)this.instance);
        return this;
    }

    public long getClientTimeUs() {
        return ((CpuMetricReading)this.instance).getClientTimeUs();
    }

    public long getSystemTimeUs() {
        return ((CpuMetricReading)this.instance).getSystemTimeUs();
    }

    public long getUserTimeUs() {
        return ((CpuMetricReading)this.instance).getUserTimeUs();
    }

    public boolean hasClientTimeUs() {
        return ((CpuMetricReading)this.instance).hasClientTimeUs();
    }

    public boolean hasSystemTimeUs() {
        return ((CpuMetricReading)this.instance).hasSystemTimeUs();
    }

    public boolean hasUserTimeUs() {
        return ((CpuMetricReading)this.instance).hasUserTimeUs();
    }

    public CpuMetricReading$Builder setClientTimeUs(long l10) {
        this.copyOnWrite();
        CpuMetricReading.access$100((CpuMetricReading)this.instance, l10);
        return this;
    }

    public CpuMetricReading$Builder setSystemTimeUs(long l10) {
        this.copyOnWrite();
        CpuMetricReading.access$500((CpuMetricReading)this.instance, l10);
        return this;
    }

    public CpuMetricReading$Builder setUserTimeUs(long l10) {
        this.copyOnWrite();
        CpuMetricReading.access$300((CpuMetricReading)this.instance, l10);
        return this;
    }
}

