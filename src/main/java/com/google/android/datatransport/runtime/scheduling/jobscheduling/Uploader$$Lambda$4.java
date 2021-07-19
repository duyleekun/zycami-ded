/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard$CriticalSection;

public final class Uploader$$Lambda$4
implements SynchronizationGuard$CriticalSection {
    private final EventStore arg$1;

    private Uploader$$Lambda$4(EventStore eventStore) {
        this.arg$1 = eventStore;
    }

    public static SynchronizationGuard$CriticalSection lambdaFactory$(EventStore eventStore) {
        Uploader$$Lambda$4 uploader$$Lambda$4 = new Uploader$$Lambda$4(eventStore);
        return uploader$$Lambda$4;
    }

    public Object execute() {
        return this.arg$1.cleanUp();
    }
}

