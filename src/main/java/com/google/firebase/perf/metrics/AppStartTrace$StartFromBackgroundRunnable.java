/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.metrics;

import com.google.firebase.perf.metrics.AppStartTrace;

public class AppStartTrace$StartFromBackgroundRunnable
implements Runnable {
    private final AppStartTrace mTrace;

    public AppStartTrace$StartFromBackgroundRunnable(AppStartTrace appStartTrace) {
        this.mTrace = appStartTrace;
    }

    public void run() {
        Object object = AppStartTrace.access$000(this.mTrace);
        if (object == null) {
            object = this.mTrace;
            boolean bl2 = true;
            AppStartTrace.access$102((AppStartTrace)object, bl2);
        }
    }
}

