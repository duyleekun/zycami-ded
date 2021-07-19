/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_StoreConfigFactory;

public final class EventStoreModule_StoreConfigFactory$InstanceHolder {
    private static final EventStoreModule_StoreConfigFactory INSTANCE;

    static {
        EventStoreModule_StoreConfigFactory eventStoreModule_StoreConfigFactory;
        INSTANCE = eventStoreModule_StoreConfigFactory = new EventStoreModule_StoreConfigFactory();
    }

    private EventStoreModule_StoreConfigFactory$InstanceHolder() {
    }

    public static /* synthetic */ EventStoreModule_StoreConfigFactory access$000() {
        return INSTANCE;
    }
}

