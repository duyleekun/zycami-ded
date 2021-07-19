/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;

public final class WorkInitializer$$Lambda$1
implements Runnable {
    private final WorkInitializer arg$1;

    private WorkInitializer$$Lambda$1(WorkInitializer workInitializer) {
        this.arg$1 = workInitializer;
    }

    public static Runnable lambdaFactory$(WorkInitializer workInitializer) {
        WorkInitializer$$Lambda$1 workInitializer$$Lambda$1 = new WorkInitializer$$Lambda$1(workInitializer);
        return workInitializer$$Lambda$1;
    }

    public void run() {
        WorkInitializer.lambda$ensureContextsScheduled$1(this.arg$1);
    }
}

