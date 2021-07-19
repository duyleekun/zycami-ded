/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import javax.inject.Provider;

public final class WorkInitializer_Factory
implements Factory {
    private final Provider executorProvider;
    private final Provider guardProvider;
    private final Provider schedulerProvider;
    private final Provider storeProvider;

    public WorkInitializer_Factory(Provider provider, Provider provider2, Provider provider3, Provider provider4) {
        this.executorProvider = provider;
        this.storeProvider = provider2;
        this.schedulerProvider = provider3;
        this.guardProvider = provider4;
    }

    public static WorkInitializer_Factory create(Provider provider, Provider provider2, Provider provider3, Provider provider4) {
        WorkInitializer_Factory workInitializer_Factory = new WorkInitializer_Factory(provider, provider2, provider3, provider4);
        return workInitializer_Factory;
    }

    public static WorkInitializer newInstance(Executor executor, EventStore eventStore, WorkScheduler workScheduler, SynchronizationGuard synchronizationGuard) {
        WorkInitializer workInitializer = new WorkInitializer(executor, eventStore, workScheduler, synchronizationGuard);
        return workInitializer;
    }

    public WorkInitializer get() {
        Executor executor = (Executor)this.executorProvider.get();
        EventStore eventStore = (EventStore)this.storeProvider.get();
        WorkScheduler workScheduler = (WorkScheduler)this.schedulerProvider.get();
        SynchronizationGuard synchronizationGuard = (SynchronizationGuard)this.guardProvider.get();
        return WorkInitializer_Factory.newInstance(executor, eventStore, workScheduler, synchronizationGuard);
    }
}

