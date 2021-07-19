/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_EventStoreConfig$1;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig;

public final class AutoValue_EventStoreConfig
extends EventStoreConfig {
    private final int criticalSectionEnterTimeoutMs;
    private final long eventCleanUpAge;
    private final int loadBatchSize;
    private final int maxBlobByteSizePerRow;
    private final long maxStorageSizeInBytes;

    private AutoValue_EventStoreConfig(long l10, int n10, int n11, long l11, int n12) {
        this.maxStorageSizeInBytes = l10;
        this.loadBatchSize = n10;
        this.criticalSectionEnterTimeoutMs = n11;
        this.eventCleanUpAge = l11;
        this.maxBlobByteSizePerRow = n12;
    }

    public /* synthetic */ AutoValue_EventStoreConfig(long l10, int n10, int n11, long l11, int n12, AutoValue_EventStoreConfig$1 autoValue_EventStoreConfig$1) {
        this(l10, n10, n11, l11, n12);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        Object object2 = object instanceof EventStoreConfig;
        if (object2 != 0) {
            int n10;
            long l10;
            int n11;
            long l11 = this.maxStorageSizeInBytes;
            long l12 = ((EventStoreConfig)(object = (EventStoreConfig)object)).getMaxStorageSizeInBytes();
            long l13 = l11 - l12;
            object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object2 != 0 || (object2 = this.loadBatchSize) != (n11 = ((EventStoreConfig)object).getLoadBatchSize()) || (object2 = this.criticalSectionEnterTimeoutMs) != (n11 = ((EventStoreConfig)object).getCriticalSectionEnterTimeoutMs()) || (object2 = (Object)((l10 = (l11 = this.eventCleanUpAge) - (l12 = ((EventStoreConfig)object).getEventCleanUpAge())) == 0L ? 0 : (l10 < 0L ? -1 : 1))) != 0 || (object2 = this.maxBlobByteSizePerRow) != (n10 = ((EventStoreConfig)object).getMaxBlobByteSizePerRow())) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int getCriticalSectionEnterTimeoutMs() {
        return this.criticalSectionEnterTimeoutMs;
    }

    public long getEventCleanUpAge() {
        return this.eventCleanUpAge;
    }

    public int getLoadBatchSize() {
        return this.loadBatchSize;
    }

    public int getMaxBlobByteSizePerRow() {
        return this.maxBlobByteSizePerRow;
    }

    public long getMaxStorageSizeInBytes() {
        return this.maxStorageSizeInBytes;
    }

    public int hashCode() {
        long l10 = this.maxStorageSizeInBytes;
        int n10 = 32;
        long l11 = l10 >>> n10;
        int n11 = (int)(l10 ^ l11);
        int n12 = 1000003;
        n11 = (n11 ^ n12) * n12;
        int n13 = this.loadBatchSize;
        n11 = (n11 ^ n13) * n12;
        n13 = this.criticalSectionEnterTimeoutMs;
        n11 = (n11 ^ n13) * n12;
        l11 = this.eventCleanUpAge;
        n10 = (int)(l11 >>> n10 ^ l11);
        n11 = (n11 ^ n10) * n12;
        n12 = this.maxBlobByteSizePerRow;
        return n11 ^ n12;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("EventStoreConfig{maxStorageSizeInBytes=");
        long l10 = this.maxStorageSizeInBytes;
        stringBuilder.append(l10);
        stringBuilder.append(", loadBatchSize=");
        int n10 = this.loadBatchSize;
        stringBuilder.append(n10);
        stringBuilder.append(", criticalSectionEnterTimeoutMs=");
        n10 = this.criticalSectionEnterTimeoutMs;
        stringBuilder.append(n10);
        stringBuilder.append(", eventCleanUpAge=");
        l10 = this.eventCleanUpAge;
        stringBuilder.append(l10);
        stringBuilder.append(", maxBlobByteSizePerRow=");
        n10 = this.maxBlobByteSizePerRow;
        stringBuilder.append(n10);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

