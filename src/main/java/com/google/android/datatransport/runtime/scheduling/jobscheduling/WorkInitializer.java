/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer$$Lambda$1;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer$$Lambda$2;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard$CriticalSection;
import java.util.Iterator;
import java.util.concurrent.Executor;

public class WorkInitializer {
    private final Executor executor;
    private final SynchronizationGuard guard;
    private final WorkScheduler scheduler;
    private final EventStore store;

    public WorkInitializer(Executor executor, EventStore eventStore, WorkScheduler workScheduler, SynchronizationGuard synchronizationGuard) {
        this.executor = executor;
        this.store = eventStore;
        this.scheduler = workScheduler;
        this.guard = synchronizationGuard;
    }

    public static /* synthetic */ Object lambda$ensureContextsScheduled$0(WorkInitializer workInitializer) {
        boolean bl2;
        Iterator iterator2 = workInitializer.store.loadActiveContexts().iterator();
        while (bl2 = iterator2.hasNext()) {
            TransportContext transportContext = (TransportContext)iterator2.next();
            WorkScheduler workScheduler = workInitializer.scheduler;
            int n10 = 1;
            workScheduler.schedule(transportContext, n10);
        }
        return null;
    }

    public static /* synthetic */ void lambda$ensureContextsScheduled$1(WorkInitializer object) {
        SynchronizationGuard synchronizationGuard = ((WorkInitializer)object).guard;
        object = WorkInitializer$$Lambda$2.lambdaFactory$((WorkInitializer)object);
        synchronizationGuard.runCriticalSection((SynchronizationGuard$CriticalSection)object);
    }

    public void ensureContextsScheduled() {
        Executor executor = this.executor;
        Runnable runnable = WorkInitializer$$Lambda$1.lambdaFactory$(this);
        executor.execute(runnable);
    }
}

