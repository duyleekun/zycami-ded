/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.internal;

import com.google.firebase.perf.internal.PerfMetricValidator;
import com.google.firebase.perf.v1.GaugeMetadata;
import com.google.firebase.perf.v1.GaugeMetric;
import com.google.protobuf.GeneratedMessageLite;

public final class FirebasePerfGaugeMetricValidator
extends PerfMetricValidator {
    private final GaugeMetric gaugeMetric;

    public FirebasePerfGaugeMetricValidator(GaugeMetric gaugeMetric) {
        this.gaugeMetric = gaugeMetric;
    }

    /*
     * WARNING - void declaration
     */
    public boolean isValidPerfMetric() {
        void var2_9;
        boolean bl2;
        boolean bl3;
        int n10;
        int n11;
        GeneratedMessageLite generatedMessageLite = this.gaugeMetric;
        boolean n102 = ((GaugeMetric)generatedMessageLite).hasSessionId();
        if (n102 && ((n11 = ((GaugeMetric)(generatedMessageLite = this.gaugeMetric)).getCpuMetricReadingsCount()) > 0 || (n10 = ((GaugeMetric)(generatedMessageLite = this.gaugeMetric)).getAndroidMemoryReadingsCount()) > 0 || (bl3 = ((GaugeMetric)(generatedMessageLite = this.gaugeMetric)).hasGaugeMetadata()) && (bl2 = ((GaugeMetadata)(generatedMessageLite = this.gaugeMetric.getGaugeMetadata())).hasMaxAppJavaHeapMemoryKb()))) {
            boolean bl4 = true;
        } else {
            boolean bl5 = false;
            generatedMessageLite = null;
        }
        return (boolean)var2_9;
    }
}

