/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.gauges;

import com.google.firebase.perf.gauges.MemoryGaugeCollector;
import com.google.firebase.perf.util.Timer;

public final class MemoryGaugeCollector$$Lambda$1
implements Runnable {
    private final MemoryGaugeCollector arg$1;
    private final Timer arg$2;

    private MemoryGaugeCollector$$Lambda$1(MemoryGaugeCollector memoryGaugeCollector, Timer timer) {
        this.arg$1 = memoryGaugeCollector;
        this.arg$2 = timer;
    }

    public static Runnable lambdaFactory$(MemoryGaugeCollector memoryGaugeCollector, Timer timer) {
        MemoryGaugeCollector$$Lambda$1 memoryGaugeCollector$$Lambda$1 = new MemoryGaugeCollector$$Lambda$1(memoryGaugeCollector, timer);
        return memoryGaugeCollector$$Lambda$1;
    }

    public void run() {
        MemoryGaugeCollector memoryGaugeCollector = this.arg$1;
        Timer timer = this.arg$2;
        MemoryGaugeCollector.lambda$scheduleMemoryMetricCollectionWithRate$0(memoryGaugeCollector, timer);
    }
}

