/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.runtime.DaggerTransportRuntimeComponent$1;
import com.google.android.datatransport.runtime.DaggerTransportRuntimeComponent$Builder;
import com.google.android.datatransport.runtime.ExecutionModule_ExecutorFactory;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.TransportRuntimeComponent;
import com.google.android.datatransport.runtime.TransportRuntimeComponent$Builder;
import com.google.android.datatransport.runtime.TransportRuntime_Factory;
import com.google.android.datatransport.runtime.backends.CreationContextFactory_Factory;
import com.google.android.datatransport.runtime.backends.MetadataBackendRegistry_Factory;
import com.google.android.datatransport.runtime.dagger.internal.DoubleCheck;
import com.google.android.datatransport.runtime.dagger.internal.InstanceFactory;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler_Factory;
import com.google.android.datatransport.runtime.scheduling.SchedulingConfigModule_ConfigFactory;
import com.google.android.datatransport.runtime.scheduling.SchedulingModule_WorkSchedulerFactory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader_Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer_Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_DbNameFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_SchemaVersionFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_StoreConfigFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore_Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager_Factory;
import com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory;
import com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory;
import javax.inject.Provider;

public final class DaggerTransportRuntimeComponent
extends TransportRuntimeComponent {
    private Provider configProvider;
    private Provider creationContextFactoryProvider;
    private Provider defaultSchedulerProvider;
    private Provider executorProvider;
    private Provider metadataBackendRegistryProvider;
    private Provider sQLiteEventStoreProvider;
    private Provider schemaManagerProvider;
    private Provider setApplicationContextProvider;
    private Provider transportRuntimeProvider;
    private Provider uploaderProvider;
    private Provider workInitializerProvider;
    private Provider workSchedulerProvider;

    private DaggerTransportRuntimeComponent(Context context) {
        this.initialize(context);
    }

    public /* synthetic */ DaggerTransportRuntimeComponent(Context context, DaggerTransportRuntimeComponent$1 daggerTransportRuntimeComponent$1) {
        this(context);
    }

    public static TransportRuntimeComponent$Builder builder() {
        DaggerTransportRuntimeComponent$Builder daggerTransportRuntimeComponent$Builder = new DaggerTransportRuntimeComponent$Builder(null);
        return daggerTransportRuntimeComponent$Builder;
    }

    private void initialize(Context object) {
        Provider provider;
        this.executorProvider = provider = DoubleCheck.provider(ExecutionModule_ExecutorFactory.create());
        object = InstanceFactory.create(object);
        this.setApplicationContextProvider = object;
        provider = TimeModule_EventClockFactory.create();
        Provider provider2 = TimeModule_UptimeClockFactory.create();
        object = CreationContextFactory_Factory.create((Provider)object, provider, provider2);
        this.creationContextFactoryProvider = object;
        object = DoubleCheck.provider(MetadataBackendRegistry_Factory.create(this.setApplicationContextProvider, (Provider)object));
        this.metadataBackendRegistryProvider = object;
        object = this.setApplicationContextProvider;
        provider = EventStoreModule_DbNameFactory.create();
        provider2 = EventStoreModule_SchemaVersionFactory.create();
        object = SchemaManager_Factory.create((Provider)object, provider, provider2);
        this.schemaManagerProvider = object;
        object = TimeModule_EventClockFactory.create();
        provider = TimeModule_UptimeClockFactory.create();
        provider2 = EventStoreModule_StoreConfigFactory.create();
        Provider provider3 = this.schemaManagerProvider;
        object = DoubleCheck.provider(SQLiteEventStore_Factory.create((Provider)object, provider, provider2, provider3));
        this.sQLiteEventStoreProvider = object;
        object = SchedulingConfigModule_ConfigFactory.create(TimeModule_EventClockFactory.create());
        this.configProvider = object;
        provider = this.setApplicationContextProvider;
        provider2 = this.sQLiteEventStoreProvider;
        provider3 = TimeModule_UptimeClockFactory.create();
        object = SchedulingModule_WorkSchedulerFactory.create(provider, provider2, (Provider)object, provider3);
        this.workSchedulerProvider = object;
        provider = this.executorProvider;
        provider2 = this.metadataBackendRegistryProvider;
        provider3 = this.sQLiteEventStoreProvider;
        object = DefaultScheduler_Factory.create(provider, provider2, (Provider)object, provider3, provider3);
        this.defaultSchedulerProvider = object;
        provider = this.setApplicationContextProvider;
        provider2 = this.metadataBackendRegistryProvider;
        Provider provider4 = this.sQLiteEventStoreProvider;
        Provider provider5 = this.workSchedulerProvider;
        Provider provider6 = this.executorProvider;
        TimeModule_EventClockFactory timeModule_EventClockFactory = TimeModule_EventClockFactory.create();
        provider3 = provider4;
        object = Uploader_Factory.create(provider, provider2, provider4, provider5, provider6, provider4, timeModule_EventClockFactory);
        this.uploaderProvider = object;
        object = this.executorProvider;
        provider = this.sQLiteEventStoreProvider;
        provider2 = this.workSchedulerProvider;
        object = WorkInitializer_Factory.create((Provider)object, provider, provider2, provider);
        this.workInitializerProvider = object;
        object = TimeModule_EventClockFactory.create();
        provider = TimeModule_UptimeClockFactory.create();
        provider2 = this.defaultSchedulerProvider;
        provider3 = this.uploaderProvider;
        provider5 = this.workInitializerProvider;
        object = DoubleCheck.provider(TransportRuntime_Factory.create((Provider)object, provider, provider2, provider3, provider5));
        this.transportRuntimeProvider = object;
    }

    public EventStore getEventStore() {
        return (EventStore)this.sQLiteEventStoreProvider.get();
    }

    public TransportRuntime getTransportRuntime() {
        return (TransportRuntime)this.transportRuntimeProvider.get();
    }
}

