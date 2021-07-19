/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_SchemaVersionFactory$InstanceHolder;

public final class EventStoreModule_SchemaVersionFactory
implements Factory {
    public static EventStoreModule_SchemaVersionFactory create() {
        return EventStoreModule_SchemaVersionFactory$InstanceHolder.access$000();
    }

    public static int schemaVersion() {
        return EventStoreModule.schemaVersion();
    }

    public Integer get() {
        return EventStoreModule_SchemaVersionFactory.schemaVersion();
    }
}

