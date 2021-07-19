/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.concurrent.Executor;
import javax.inject.Provider;

public final class Uploader_Factory
implements Factory {
    private final Provider backendRegistryProvider;
    private final Provider clockProvider;
    private final Provider contextProvider;
    private final Provider eventStoreProvider;
    private final Provider executorProvider;
    private final Provider guardProvider;
    private final Provider workSchedulerProvider;

    public Uploader_Factory(Provider provider, Provider provider2, Provider provider3, Provider provider4, Provider provider5, Provider provider6, Provider provider7) {
        this.contextProvider = provider;
        this.backendRegistryProvider = provider2;
        this.eventStoreProvider = provider3;
        this.workSchedulerProvider = provider4;
        this.executorProvider = provider5;
        this.guardProvider = provider6;
        this.clockProvider = provider7;
    }

    public static Uploader_Factory create(Provider provider, Provider provider2, Provider provider3, Provider provider4, Provider provider5, Provider provider6, Provider provider7) {
        Uploader_Factory uploader_Factory = new Uploader_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
        return uploader_Factory;
    }

    public static Uploader newInstance(Context context, BackendRegistry backendRegistry, EventStore eventStore, WorkScheduler workScheduler, Executor executor, SynchronizationGuard synchronizationGuard, Clock clock) {
        Uploader uploader = new Uploader(context, backendRegistry, eventStore, workScheduler, executor, synchronizationGuard, clock);
        return uploader;
    }

    public Uploader get() {
        Object object;
        Object object2 = object = this.contextProvider.get();
        object2 = (Context)object;
        Object object3 = object = this.backendRegistryProvider.get();
        object3 = (BackendRegistry)object;
        Object object4 = object = this.eventStoreProvider.get();
        object4 = (EventStore)object;
        Object object5 = object = this.workSchedulerProvider.get();
        object5 = (WorkScheduler)object;
        Object object6 = object = this.executorProvider.get();
        object6 = (Executor)object;
        Object object7 = object = this.guardProvider.get();
        object7 = (SynchronizationGuard)object;
        Object object8 = object = this.clockProvider.get();
        object8 = (Clock)object;
        return Uploader_Factory.newInstance((Context)object2, (BackendRegistry)object3, (EventStore)object4, (WorkScheduler)object5, (Executor)object6, (SynchronizationGuard)object7, (Clock)object8);
    }
}

