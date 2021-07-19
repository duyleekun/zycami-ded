/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig;

public abstract class EventStoreConfig$Builder {
    public abstract EventStoreConfig build();

    public abstract EventStoreConfig$Builder setCriticalSectionEnterTimeoutMs(int var1);

    public abstract EventStoreConfig$Builder setEventCleanUpAge(long var1);

    public abstract EventStoreConfig$Builder setLoadBatchSize(int var1);

    public abstract EventStoreConfig$Builder setMaxBlobByteSizePerRow(int var1);

    public abstract EventStoreConfig$Builder setMaxStorageSizeInBytes(long var1);
}

