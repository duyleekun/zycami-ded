/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.ApplicationInfo;
import com.google.firebase.perf.v1.ApplicationInfo$Builder;
import com.google.firebase.perf.v1.GaugeMetric;
import com.google.firebase.perf.v1.GaugeMetric$Builder;
import com.google.firebase.perf.v1.NetworkRequestMetric;
import com.google.firebase.perf.v1.NetworkRequestMetric$Builder;
import com.google.firebase.perf.v1.PerfMetric;
import com.google.firebase.perf.v1.PerfMetric$1;
import com.google.firebase.perf.v1.PerfMetricOrBuilder;
import com.google.firebase.perf.v1.TraceMetric;
import com.google.firebase.perf.v1.TraceMetric$Builder;
import com.google.firebase.perf.v1.TransportInfo;
import com.google.firebase.perf.v1.TransportInfo$Builder;
import com.google.protobuf.GeneratedMessageLite$Builder;

public final class PerfMetric$Builder
extends GeneratedMessageLite$Builder
implements PerfMetricOrBuilder {
    private PerfMetric$Builder() {
        PerfMetric perfMetric = PerfMetric.access$000();
        super(perfMetric);
    }

    public /* synthetic */ PerfMetric$Builder(PerfMetric$1 perfMetric$1) {
        this();
    }

    public PerfMetric$Builder clearApplicationInfo() {
        this.copyOnWrite();
        PerfMetric.access$300((PerfMetric)this.instance);
        return this;
    }

    public PerfMetric$Builder clearGaugeMetric() {
        this.copyOnWrite();
        PerfMetric.access$1200((PerfMetric)this.instance);
        return this;
    }

    public PerfMetric$Builder clearNetworkRequestMetric() {
        this.copyOnWrite();
        PerfMetric.access$900((PerfMetric)this.instance);
        return this;
    }

    public PerfMetric$Builder clearTraceMetric() {
        this.copyOnWrite();
        PerfMetric.access$600((PerfMetric)this.instance);
        return this;
    }

    public PerfMetric$Builder clearTransportInfo() {
        this.copyOnWrite();
        PerfMetric.access$1500((PerfMetric)this.instance);
        return this;
    }

    public ApplicationInfo getApplicationInfo() {
        return ((PerfMetric)this.instance).getApplicationInfo();
    }

    public GaugeMetric getGaugeMetric() {
        return ((PerfMetric)this.instance).getGaugeMetric();
    }

    public NetworkRequestMetric getNetworkRequestMetric() {
        return ((PerfMetric)this.instance).getNetworkRequestMetric();
    }

    public TraceMetric getTraceMetric() {
        return ((PerfMetric)this.instance).getTraceMetric();
    }

    public TransportInfo getTransportInfo() {
        return ((PerfMetric)this.instance).getTransportInfo();
    }

    public boolean hasApplicationInfo() {
        return ((PerfMetric)this.instance).hasApplicationInfo();
    }

    public boolean hasGaugeMetric() {
        return ((PerfMetric)this.instance).hasGaugeMetric();
    }

    public boolean hasNetworkRequestMetric() {
        return ((PerfMetric)this.instance).hasNetworkRequestMetric();
    }

    public boolean hasTraceMetric() {
        return ((PerfMetric)this.instance).hasTraceMetric();
    }

    public boolean hasTransportInfo() {
        return ((PerfMetric)this.instance).hasTransportInfo();
    }

    public PerfMetric$Builder mergeApplicationInfo(ApplicationInfo applicationInfo) {
        this.copyOnWrite();
        PerfMetric.access$200((PerfMetric)this.instance, applicationInfo);
        return this;
    }

    public PerfMetric$Builder mergeGaugeMetric(GaugeMetric gaugeMetric) {
        this.copyOnWrite();
        PerfMetric.access$1100((PerfMetric)this.instance, gaugeMetric);
        return this;
    }

    public PerfMetric$Builder mergeNetworkRequestMetric(NetworkRequestMetric networkRequestMetric) {
        this.copyOnWrite();
        PerfMetric.access$800((PerfMetric)this.instance, networkRequestMetric);
        return this;
    }

    public PerfMetric$Builder mergeTraceMetric(TraceMetric traceMetric) {
        this.copyOnWrite();
        PerfMetric.access$500((PerfMetric)this.instance, traceMetric);
        return this;
    }

    public PerfMetric$Builder mergeTransportInfo(TransportInfo transportInfo) {
        this.copyOnWrite();
        PerfMetric.access$1400((PerfMetric)this.instance, transportInfo);
        return this;
    }

    public PerfMetric$Builder setApplicationInfo(ApplicationInfo$Builder applicationInfoOrBuilder) {
        this.copyOnWrite();
        PerfMetric perfMetric = (PerfMetric)this.instance;
        applicationInfoOrBuilder = (ApplicationInfo)applicationInfoOrBuilder.build();
        PerfMetric.access$100(perfMetric, (ApplicationInfo)applicationInfoOrBuilder);
        return this;
    }

    public PerfMetric$Builder setApplicationInfo(ApplicationInfo applicationInfo) {
        this.copyOnWrite();
        PerfMetric.access$100((PerfMetric)this.instance, applicationInfo);
        return this;
    }

    public PerfMetric$Builder setGaugeMetric(GaugeMetric$Builder gaugeMetricOrBuilder) {
        this.copyOnWrite();
        PerfMetric perfMetric = (PerfMetric)this.instance;
        gaugeMetricOrBuilder = (GaugeMetric)gaugeMetricOrBuilder.build();
        PerfMetric.access$1000(perfMetric, (GaugeMetric)gaugeMetricOrBuilder);
        return this;
    }

    public PerfMetric$Builder setGaugeMetric(GaugeMetric gaugeMetric) {
        this.copyOnWrite();
        PerfMetric.access$1000((PerfMetric)this.instance, gaugeMetric);
        return this;
    }

    public PerfMetric$Builder setNetworkRequestMetric(NetworkRequestMetric$Builder networkRequestMetricOrBuilder) {
        this.copyOnWrite();
        PerfMetric perfMetric = (PerfMetric)this.instance;
        networkRequestMetricOrBuilder = (NetworkRequestMetric)networkRequestMetricOrBuilder.build();
        PerfMetric.access$700(perfMetric, (NetworkRequestMetric)networkRequestMetricOrBuilder);
        return this;
    }

    public PerfMetric$Builder setNetworkRequestMetric(NetworkRequestMetric networkRequestMetric) {
        this.copyOnWrite();
        PerfMetric.access$700((PerfMetric)this.instance, networkRequestMetric);
        return this;
    }

    public PerfMetric$Builder setTraceMetric(TraceMetric$Builder traceMetricOrBuilder) {
        this.copyOnWrite();
        PerfMetric perfMetric = (PerfMetric)this.instance;
        traceMetricOrBuilder = (TraceMetric)traceMetricOrBuilder.build();
        PerfMetric.access$400(perfMetric, (TraceMetric)traceMetricOrBuilder);
        return this;
    }

    public PerfMetric$Builder setTraceMetric(TraceMetric traceMetric) {
        this.copyOnWrite();
        PerfMetric.access$400((PerfMetric)this.instance, traceMetric);
        return this;
    }

    public PerfMetric$Builder setTransportInfo(TransportInfo$Builder transportInfoOrBuilder) {
        this.copyOnWrite();
        PerfMetric perfMetric = (PerfMetric)this.instance;
        transportInfoOrBuilder = (TransportInfo)transportInfoOrBuilder.build();
        PerfMetric.access$1300(perfMetric, (TransportInfo)transportInfoOrBuilder);
        return this;
    }

    public PerfMetric$Builder setTransportInfo(TransportInfo transportInfo) {
        this.copyOnWrite();
        PerfMetric.access$1300((PerfMetric)this.instance, transportInfo);
        return this;
    }
}

