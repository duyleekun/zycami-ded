/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard$CriticalSection;

public final class WorkInitializer$$Lambda$2
implements SynchronizationGuard$CriticalSection {
    private final WorkInitializer arg$1;

    private WorkInitializer$$Lambda$2(WorkInitializer workInitializer) {
        this.arg$1 = workInitializer;
    }

    public static SynchronizationGuard$CriticalSection lambdaFactory$(WorkInitializer workInitializer) {
        WorkInitializer$$Lambda$2 workInitializer$$Lambda$2 = new WorkInitializer$$Lambda$2(workInitializer);
        return workInitializer$$Lambda$2;
    }

    public Object execute() {
        return WorkInitializer.lambda$ensureContextsScheduled$0(this.arg$1);
    }
}

