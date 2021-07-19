/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.AndroidMemoryReading;
import com.google.firebase.perf.v1.AndroidMemoryReading$Builder;
import com.google.firebase.perf.v1.CpuMetricReading;
import com.google.firebase.perf.v1.CpuMetricReading$Builder;
import com.google.firebase.perf.v1.GaugeMetadata;
import com.google.firebase.perf.v1.GaugeMetadata$Builder;
import com.google.firebase.perf.v1.GaugeMetric;
import com.google.firebase.perf.v1.GaugeMetric$1;
import com.google.firebase.perf.v1.GaugeMetricOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite$Builder;
import java.util.Collections;
import java.util.List;

public final class GaugeMetric$Builder
extends GeneratedMessageLite$Builder
implements GaugeMetricOrBuilder {
    private GaugeMetric$Builder() {
        GaugeMetric gaugeMetric = GaugeMetric.access$000();
        super(gaugeMetric);
    }

    public /* synthetic */ GaugeMetric$Builder(GaugeMetric$1 gaugeMetric$1) {
        this();
    }

    public GaugeMetric$Builder addAllAndroidMemoryReadings(Iterable iterable) {
        this.copyOnWrite();
        GaugeMetric.access$1600((GaugeMetric)this.instance, iterable);
        return this;
    }

    public GaugeMetric$Builder addAllCpuMetricReadings(Iterable iterable) {
        this.copyOnWrite();
        GaugeMetric.access$1000((GaugeMetric)this.instance, iterable);
        return this;
    }

    public GaugeMetric$Builder addAndroidMemoryReadings(int n10, AndroidMemoryReading$Builder androidMemoryReadingOrBuilder) {
        this.copyOnWrite();
        GaugeMetric gaugeMetric = (GaugeMetric)this.instance;
        androidMemoryReadingOrBuilder = (AndroidMemoryReading)androidMemoryReadingOrBuilder.build();
        GaugeMetric.access$1500(gaugeMetric, n10, (AndroidMemoryReading)androidMemoryReadingOrBuilder);
        return this;
    }

    public GaugeMetric$Builder addAndroidMemoryReadings(int n10, AndroidMemoryReading androidMemoryReading) {
        this.copyOnWrite();
        GaugeMetric.access$1500((GaugeMetric)this.instance, n10, androidMemoryReading);
        return this;
    }

    public GaugeMetric$Builder addAndroidMemoryReadings(AndroidMemoryReading$Builder androidMemoryReadingOrBuilder) {
        this.copyOnWrite();
        GaugeMetric gaugeMetric = (GaugeMetric)this.instance;
        androidMemoryReadingOrBuilder = (AndroidMemoryReading)androidMemoryReadingOrBuilder.build();
        GaugeMetric.access$1400(gaugeMetric, (AndroidMemoryReading)androidMemoryReadingOrBuilder);
        return this;
    }

    public GaugeMetric$Builder addAndroidMemoryReadings(AndroidMemoryReading androidMemoryReading) {
        this.copyOnWrite();
        GaugeMetric.access$1400((GaugeMetric)this.instance, androidMemoryReading);
        return this;
    }

    public GaugeMetric$Builder addCpuMetricReadings(int n10, CpuMetricReading$Builder cpuMetricReadingOrBuilder) {
        this.copyOnWrite();
        GaugeMetric gaugeMetric = (GaugeMetric)this.instance;
        cpuMetricReadingOrBuilder = (CpuMetricReading)cpuMetricReadingOrBuilder.build();
        GaugeMetric.access$900(gaugeMetric, n10, (CpuMetricReading)cpuMetricReadingOrBuilder);
        return this;
    }

    public GaugeMetric$Builder addCpuMetricReadings(int n10, CpuMetricReading cpuMetricReading) {
        this.copyOnWrite();
        GaugeMetric.access$900((GaugeMetric)this.instance, n10, cpuMetricReading);
        return this;
    }

    public GaugeMetric$Builder addCpuMetricReadings(CpuMetricReading$Builder cpuMetricReadingOrBuilder) {
        this.copyOnWrite();
        GaugeMetric gaugeMetric = (GaugeMetric)this.instance;
        cpuMetricReadingOrBuilder = (CpuMetricReading)cpuMetricReadingOrBuilder.build();
        GaugeMetric.access$800(gaugeMetric, (CpuMetricReading)cpuMetricReadingOrBuilder);
        return this;
    }

    public GaugeMetric$Builder addCpuMetricReadings(CpuMetricReading cpuMetricReading) {
        this.copyOnWrite();
        GaugeMetric.access$800((GaugeMetric)this.instance, cpuMetricReading);
        return this;
    }

    public GaugeMetric$Builder clearAndroidMemoryReadings() {
        this.copyOnWrite();
        GaugeMetric.access$1700((GaugeMetric)this.instance);
        return this;
    }

    public GaugeMetric$Builder clearCpuMetricReadings() {
        this.copyOnWrite();
        GaugeMetric.access$1100((GaugeMetric)this.instance);
        return this;
    }

    public GaugeMetric$Builder clearGaugeMetadata() {
        this.copyOnWrite();
        GaugeMetric.access$600((GaugeMetric)this.instance);
        return this;
    }

    public GaugeMetric$Builder clearSessionId() {
        this.copyOnWrite();
        GaugeMetric.access$200((GaugeMetric)this.instance);
        return this;
    }

    public AndroidMemoryReading getAndroidMemoryReadings(int n10) {
        return ((GaugeMetric)this.instance).getAndroidMemoryReadings(n10);
    }

    public int getAndroidMemoryReadingsCount() {
        return ((GaugeMetric)this.instance).getAndroidMemoryReadingsCount();
    }

    public List getAndroidMemoryReadingsList() {
        return Collections.unmodifiableList(((GaugeMetric)this.instance).getAndroidMemoryReadingsList());
    }

    public CpuMetricReading getCpuMetricReadings(int n10) {
        return ((GaugeMetric)this.instance).getCpuMetricReadings(n10);
    }

    public int getCpuMetricReadingsCount() {
        return ((GaugeMetric)this.instance).getCpuMetricReadingsCount();
    }

    public List getCpuMetricReadingsList() {
        return Collections.unmodifiableList(((GaugeMetric)this.instance).getCpuMetricReadingsList());
    }

    public GaugeMetadata getGaugeMetadata() {
        return ((GaugeMetric)this.instance).getGaugeMetadata();
    }

    public String getSessionId() {
        return ((GaugeMetric)this.instance).getSessionId();
    }

    public ByteString getSessionIdBytes() {
        return ((GaugeMetric)this.instance).getSessionIdBytes();
    }

    public boolean hasGaugeMetadata() {
        return ((GaugeMetric)this.instance).hasGaugeMetadata();
    }

    public boolean hasSessionId() {
        return ((GaugeMetric)this.instance).hasSessionId();
    }

    public GaugeMetric$Builder mergeGaugeMetadata(GaugeMetadata gaugeMetadata) {
        this.copyOnWrite();
        GaugeMetric.access$500((GaugeMetric)this.instance, gaugeMetadata);
        return this;
    }

    public GaugeMetric$Builder removeAndroidMemoryReadings(int n10) {
        this.copyOnWrite();
        GaugeMetric.access$1800((GaugeMetric)this.instance, n10);
        return this;
    }

    public GaugeMetric$Builder removeCpuMetricReadings(int n10) {
        this.copyOnWrite();
        GaugeMetric.access$1200((GaugeMetric)this.instance, n10);
        return this;
    }

    public GaugeMetric$Builder setAndroidMemoryReadings(int n10, AndroidMemoryReading$Builder androidMemoryReadingOrBuilder) {
        this.copyOnWrite();
        GaugeMetric gaugeMetric = (GaugeMetric)this.instance;
        androidMemoryReadingOrBuilder = (AndroidMemoryReading)androidMemoryReadingOrBuilder.build();
        GaugeMetric.access$1300(gaugeMetric, n10, (AndroidMemoryReading)androidMemoryReadingOrBuilder);
        return this;
    }

    public GaugeMetric$Builder setAndroidMemoryReadings(int n10, AndroidMemoryReading androidMemoryReading) {
        this.copyOnWrite();
        GaugeMetric.access$1300((GaugeMetric)this.instance, n10, androidMemoryReading);
        return this;
    }

    public GaugeMetric$Builder setCpuMetricReadings(int n10, CpuMetricReading$Builder cpuMetricReadingOrBuilder) {
        this.copyOnWrite();
        GaugeMetric gaugeMetric = (GaugeMetric)this.instance;
        cpuMetricReadingOrBuilder = (CpuMetricReading)cpuMetricReadingOrBuilder.build();
        GaugeMetric.access$700(gaugeMetric, n10, (CpuMetricReading)cpuMetricReadingOrBuilder);
        return this;
    }

    public GaugeMetric$Builder setCpuMetricReadings(int n10, CpuMetricReading cpuMetricReading) {
        this.copyOnWrite();
        GaugeMetric.access$700((GaugeMetric)this.instance, n10, cpuMetricReading);
        return this;
    }

    public GaugeMetric$Builder setGaugeMetadata(GaugeMetadata$Builder gaugeMetadataOrBuilder) {
        this.copyOnWrite();
        GaugeMetric gaugeMetric = (GaugeMetric)this.instance;
        gaugeMetadataOrBuilder = (GaugeMetadata)gaugeMetadataOrBuilder.build();
        GaugeMetric.access$400(gaugeMetric, (GaugeMetadata)gaugeMetadataOrBuilder);
        return this;
    }

    public GaugeMetric$Builder setGaugeMetadata(GaugeMetadata gaugeMetadata) {
        this.copyOnWrite();
        GaugeMetric.access$400((GaugeMetric)this.instance, gaugeMetadata);
        return this;
    }

    public GaugeMetric$Builder setSessionId(String string2) {
        this.copyOnWrite();
        GaugeMetric.access$100((GaugeMetric)this.instance, string2);
        return this;
    }

    public GaugeMetric$Builder setSessionIdBytes(ByteString byteString) {
        this.copyOnWrite();
        GaugeMetric.access$300((GaugeMetric)this.instance, byteString);
        return this;
    }
}

