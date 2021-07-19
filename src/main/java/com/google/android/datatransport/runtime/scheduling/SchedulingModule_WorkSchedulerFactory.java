/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.datatransport.runtime.scheduling;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import com.google.android.datatransport.runtime.scheduling.SchedulingModule;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Provider;

public final class SchedulingModule_WorkSchedulerFactory
implements Factory {
    private final Provider clockProvider;
    private final Provider configProvider;
    private final Provider contextProvider;
    private final Provider eventStoreProvider;

    public SchedulingModule_WorkSchedulerFactory(Provider provider, Provider provider2, Provider provider3, Provider provider4) {
        this.contextProvider = provider;
        this.eventStoreProvider = provider2;
        this.configProvider = provider3;
        this.clockProvider = provider4;
    }

    public static SchedulingModule_WorkSchedulerFactory create(Provider provider, Provider provider2, Provider provider3, Provider provider4) {
        SchedulingModule_WorkSchedulerFactory schedulingModule_WorkSchedulerFactory = new SchedulingModule_WorkSchedulerFactory(provider, provider2, provider3, provider4);
        return schedulingModule_WorkSchedulerFactory;
    }

    public static WorkScheduler workScheduler(Context context, EventStore eventStore, SchedulerConfig schedulerConfig, Clock clock) {
        return (WorkScheduler)Preconditions.checkNotNull(SchedulingModule.workScheduler(context, eventStore, schedulerConfig, clock), "Cannot return null from a non-@Nullable @Provides method");
    }

    public WorkScheduler get() {
        Context context = (Context)this.contextProvider.get();
        EventStore eventStore = (EventStore)this.eventStoreProvider.get();
        SchedulerConfig schedulerConfig = (SchedulerConfig)this.configProvider.get();
        Clock clock = (Clock)this.clockProvider.get();
        return SchedulingModule_WorkSchedulerFactory.workScheduler(context, eventStore, schedulerConfig, clock);
    }
}

