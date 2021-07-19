/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.gauges;

import com.google.firebase.perf.gauges.CpuGaugeCollector;
import com.google.firebase.perf.util.Timer;

public final class CpuGaugeCollector$$Lambda$1
implements Runnable {
    private final CpuGaugeCollector arg$1;
    private final Timer arg$2;

    private CpuGaugeCollector$$Lambda$1(CpuGaugeCollector cpuGaugeCollector, Timer timer) {
        this.arg$1 = cpuGaugeCollector;
        this.arg$2 = timer;
    }

    public static Runnable lambdaFactory$(CpuGaugeCollector cpuGaugeCollector, Timer timer) {
        CpuGaugeCollector$$Lambda$1 cpuGaugeCollector$$Lambda$1 = new CpuGaugeCollector$$Lambda$1(cpuGaugeCollector, timer);
        return cpuGaugeCollector$$Lambda$1;
    }

    public void run() {
        CpuGaugeCollector cpuGaugeCollector = this.arg$1;
        Timer timer = this.arg$2;
        CpuGaugeCollector.lambda$scheduleCpuMetricCollectionWithRate$0(cpuGaugeCollector, timer);
    }
}

