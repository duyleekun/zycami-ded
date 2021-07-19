/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_DbNameFactory;

public final class EventStoreModule_DbNameFactory$InstanceHolder {
    private static final EventStoreModule_DbNameFactory INSTANCE;

    static {
        EventStoreModule_DbNameFactory eventStoreModule_DbNameFactory;
        INSTANCE = eventStoreModule_DbNameFactory = new EventStoreModule_DbNameFactory();
    }

    private EventStoreModule_DbNameFactory$InstanceHolder() {
    }

    public static /* synthetic */ EventStoreModule_DbNameFactory access$000() {
        return INSTANCE;
    }
}

