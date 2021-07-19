/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.internal;

import com.google.firebase.perf.internal.GaugeManager;
import com.google.firebase.perf.v1.ApplicationProcessState;

public final class GaugeManager$$Lambda$2
implements Runnable {
    private final GaugeManager arg$1;
    private final String arg$2;
    private final ApplicationProcessState arg$3;

    private GaugeManager$$Lambda$2(GaugeManager gaugeManager, String string2, ApplicationProcessState applicationProcessState) {
        this.arg$1 = gaugeManager;
        this.arg$2 = string2;
        this.arg$3 = applicationProcessState;
    }

    public static Runnable lambdaFactory$(GaugeManager gaugeManager, String string2, ApplicationProcessState applicationProcessState) {
        GaugeManager$$Lambda$2 gaugeManager$$Lambda$2 = new GaugeManager$$Lambda$2(gaugeManager, string2, applicationProcessState);
        return gaugeManager$$Lambda$2;
    }

    public void run() {
        GaugeManager gaugeManager = this.arg$1;
        String string2 = this.arg$2;
        ApplicationProcessState applicationProcessState = this.arg$3;
        GaugeManager.lambda$stopCollectingGauges$1(gaugeManager, string2, applicationProcessState);
    }
}

