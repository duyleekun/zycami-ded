/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.ApplicationInfo;
import com.google.firebase.perf.v1.GaugeMetric;
import com.google.firebase.perf.v1.NetworkRequestMetric;
import com.google.firebase.perf.v1.TraceMetric;
import com.google.firebase.perf.v1.TransportInfo;
import com.google.protobuf.MessageLiteOrBuilder;

public interface PerfMetricOrBuilder
extends MessageLiteOrBuilder {
    public ApplicationInfo getApplicationInfo();

    public GaugeMetric getGaugeMetric();

    public NetworkRequestMetric getNetworkRequestMetric();

    public TraceMetric getTraceMetric();

    public TransportInfo getTransportInfo();

    public boolean hasApplicationInfo();

    public boolean hasGaugeMetric();

    public boolean hasNetworkRequestMetric();

    public boolean hasTraceMetric();

    public boolean hasTransportInfo();
}

