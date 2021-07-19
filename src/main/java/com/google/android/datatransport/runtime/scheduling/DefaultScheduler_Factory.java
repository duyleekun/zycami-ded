/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import javax.inject.Provider;

public final class DefaultScheduler_Factory
implements Factory {
    private final Provider backendRegistryProvider;
    private final Provider eventStoreProvider;
    private final Provider executorProvider;
    private final Provider guardProvider;
    private final Provider workSchedulerProvider;

    public DefaultScheduler_Factory(Provider provider, Provider provider2, Provider provider3, Provider provider4, Provider provider5) {
        this.executorProvider = provider;
        this.backendRegistryProvider = provider2;
        this.workSchedulerProvider = provider3;
        this.eventStoreProvider = provider4;
        this.guardProvider = provider5;
    }

    public static DefaultScheduler_Factory create(Provider provider, Provider provider2, Provider provider3, Provider provider4, Provider provider5) {
        DefaultScheduler_Factory defaultScheduler_Factory = new DefaultScheduler_Factory(provider, provider2, provider3, provider4, provider5);
        return defaultScheduler_Factory;
    }

    public static DefaultScheduler newInstance(Executor executor, BackendRegistry backendRegistry, WorkScheduler workScheduler, EventStore eventStore, SynchronizationGuard synchronizationGuard) {
        DefaultScheduler defaultScheduler = new DefaultScheduler(executor, backendRegistry, workScheduler, eventStore, synchronizationGuard);
        return defaultScheduler;
    }

    public DefaultScheduler get() {
        Executor executor = (Executor)this.executorProvider.get();
        BackendRegistry backendRegistry = (BackendRegistry)this.backendRegistryProvider.get();
        WorkScheduler workScheduler = (WorkScheduler)this.workSchedulerProvider.get();
        EventStore eventStore = (EventStore)this.eventStoreProvider.get();
        SynchronizationGuard synchronizationGuard = (SynchronizationGuard)this.guardProvider.get();
        return DefaultScheduler_Factory.newInstance(executor, backendRegistry, workScheduler, eventStore, synchronizationGuard);
    }
}

