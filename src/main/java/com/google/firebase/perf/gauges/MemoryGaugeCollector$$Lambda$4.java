/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.gauges;

import com.google.firebase.perf.gauges.MemoryGaugeCollector;
import com.google.firebase.perf.util.Timer;

public final class MemoryGaugeCollector$$Lambda$4
implements Runnable {
    private final MemoryGaugeCollector arg$1;
    private final Timer arg$2;

    private MemoryGaugeCollector$$Lambda$4(MemoryGaugeCollector memoryGaugeCollector, Timer timer) {
        this.arg$1 = memoryGaugeCollector;
        this.arg$2 = timer;
    }

    public static Runnable lambdaFactory$(MemoryGaugeCollector memoryGaugeCollector, Timer timer) {
        MemoryGaugeCollector$$Lambda$4 memoryGaugeCollector$$Lambda$4 = new MemoryGaugeCollector$$Lambda$4(memoryGaugeCollector, timer);
        return memoryGaugeCollector$$Lambda$4;
    }

    public void run() {
        MemoryGaugeCollector memoryGaugeCollector = this.arg$1;
        Timer timer = this.arg$2;
        MemoryGaugeCollector.lambda$scheduleMemoryMetricCollectionOnce$1(memoryGaugeCollector, timer);
    }
}

