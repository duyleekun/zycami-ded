/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_EventStoreConfig$Builder;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig$Builder;

public abstract class EventStoreConfig {
    public static final EventStoreConfig DEFAULT = EventStoreConfig.builder().setMaxStorageSizeInBytes(0xA00000L).setLoadBatchSize(200).setCriticalSectionEnterTimeoutMs(10000).setEventCleanUpAge(604800000L).setMaxBlobByteSizePerRow(81920).build();
    private static final long DURATION_ONE_WEEK_MS = 604800000L;
    private static final int LOAD_BATCH_SIZE = 200;
    private static final int LOCK_TIME_OUT_MS = 10000;
    private static final int MAX_BLOB_BYTE_SIZE_PER_ROW = 81920;
    private static final long MAX_DB_STORAGE_SIZE_IN_BYTES = 0xA00000L;

    public static EventStoreConfig$Builder builder() {
        AutoValue_EventStoreConfig$Builder autoValue_EventStoreConfig$Builder = new AutoValue_EventStoreConfig$Builder();
        return autoValue_EventStoreConfig$Builder;
    }

    public abstract int getCriticalSectionEnterTimeoutMs();

    public abstract long getEventCleanUpAge();

    public abstract int getLoadBatchSize();

    public abstract int getMaxBlobByteSizePerRow();

    public abstract long getMaxStorageSizeInBytes();

    public EventStoreConfig$Builder toBuilder() {
        EventStoreConfig$Builder eventStoreConfig$Builder = EventStoreConfig.builder();
        long l10 = this.getMaxStorageSizeInBytes();
        eventStoreConfig$Builder = eventStoreConfig$Builder.setMaxStorageSizeInBytes(l10);
        int n10 = this.getLoadBatchSize();
        eventStoreConfig$Builder = eventStoreConfig$Builder.setLoadBatchSize(n10);
        n10 = this.getCriticalSectionEnterTimeoutMs();
        eventStoreConfig$Builder = eventStoreConfig$Builder.setCriticalSectionEnterTimeoutMs(n10);
        l10 = this.getEventCleanUpAge();
        eventStoreConfig$Builder = eventStoreConfig$Builder.setEventCleanUpAge(l10);
        n10 = this.getMaxBlobByteSizePerRow();
        return eventStoreConfig$Builder.setMaxBlobByteSizePerRow(n10);
    }
}

