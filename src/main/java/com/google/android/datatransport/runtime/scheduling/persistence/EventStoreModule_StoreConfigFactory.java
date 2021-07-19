/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_StoreConfigFactory$InstanceHolder;

public final class EventStoreModule_StoreConfigFactory
implements Factory {
    public static EventStoreModule_StoreConfigFactory create() {
        return EventStoreModule_StoreConfigFactory$InstanceHolder.access$000();
    }

    public static EventStoreConfig storeConfig() {
        return (EventStoreConfig)Preconditions.checkNotNull(EventStoreModule.storeConfig(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public EventStoreConfig get() {
        return EventStoreModule_StoreConfigFactory.storeConfig();
    }
}

