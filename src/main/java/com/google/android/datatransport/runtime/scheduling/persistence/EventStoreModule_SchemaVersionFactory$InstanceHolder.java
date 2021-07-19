/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_SchemaVersionFactory;

public final class EventStoreModule_SchemaVersionFactory$InstanceHolder {
    private static final EventStoreModule_SchemaVersionFactory INSTANCE;

    static {
        EventStoreModule_SchemaVersionFactory eventStoreModule_SchemaVersionFactory;
        INSTANCE = eventStoreModule_SchemaVersionFactory = new EventStoreModule_SchemaVersionFactory();
    }

    private EventStoreModule_SchemaVersionFactory$InstanceHolder() {
    }

    public static /* synthetic */ EventStoreModule_SchemaVersionFactory access$000() {
        return INSTANCE;
    }
}

