/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public abstract class EventStoreModule {
    public static String dbName() {
        return "com.google.android.datatransport.events";
    }

    public static int schemaVersion() {
        return SchemaManager.SCHEMA_VERSION;
    }

    public static EventStoreConfig storeConfig() {
        return EventStoreConfig.DEFAULT;
    }

    public abstract EventStore eventStore(SQLiteEventStore var1);

    public abstract SynchronizationGuard synchronizationGuard(SQLiteEventStore var1);
}

