/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager;
import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Provider;

public final class SQLiteEventStore_Factory
implements Factory {
    private final Provider clockProvider;
    private final Provider configProvider;
    private final Provider schemaManagerProvider;
    private final Provider wallClockProvider;

    public SQLiteEventStore_Factory(Provider provider, Provider provider2, Provider provider3, Provider provider4) {
        this.wallClockProvider = provider;
        this.clockProvider = provider2;
        this.configProvider = provider3;
        this.schemaManagerProvider = provider4;
    }

    public static SQLiteEventStore_Factory create(Provider provider, Provider provider2, Provider provider3, Provider provider4) {
        SQLiteEventStore_Factory sQLiteEventStore_Factory = new SQLiteEventStore_Factory(provider, provider2, provider3, provider4);
        return sQLiteEventStore_Factory;
    }

    public static SQLiteEventStore newInstance(Clock clock, Clock clock2, Object object, Object object2) {
        object = (EventStoreConfig)object;
        object2 = (SchemaManager)((Object)object2);
        SQLiteEventStore sQLiteEventStore = new SQLiteEventStore(clock, clock2, (EventStoreConfig)object, (SchemaManager)((Object)object2));
        return sQLiteEventStore;
    }

    public SQLiteEventStore get() {
        Clock clock = (Clock)this.wallClockProvider.get();
        Clock clock2 = (Clock)this.clockProvider.get();
        Object object = this.configProvider.get();
        Object object2 = this.schemaManagerProvider.get();
        return SQLiteEventStore_Factory.newInstance(clock, clock2, object, object2);
    }
}

