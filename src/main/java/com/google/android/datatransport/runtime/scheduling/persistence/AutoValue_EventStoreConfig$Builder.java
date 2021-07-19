/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_EventStoreConfig;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig$Builder;

public final class AutoValue_EventStoreConfig$Builder
extends EventStoreConfig$Builder {
    private Integer criticalSectionEnterTimeoutMs;
    private Long eventCleanUpAge;
    private Integer loadBatchSize;
    private Integer maxBlobByteSizePerRow;
    private Long maxStorageSizeInBytes;

    public EventStoreConfig build() {
        boolean bl2;
        Object object = this.maxStorageSizeInBytes;
        String string2 = "";
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" maxStorageSizeInBytes");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.loadBatchSize) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" loadBatchSize");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.criticalSectionEnterTimeoutMs) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" criticalSectionEnterTimeoutMs");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.eventCleanUpAge) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" eventCleanUpAge");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.maxBlobByteSizePerRow) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" maxBlobByteSizePerRow");
            string2 = ((StringBuilder)object).toString();
        }
        if (bl2 = string2.isEmpty()) {
            long l10 = this.maxStorageSizeInBytes;
            int n10 = this.loadBatchSize;
            int n11 = this.criticalSectionEnterTimeoutMs;
            long l11 = this.eventCleanUpAge;
            int n12 = this.maxBlobByteSizePerRow;
            Object object2 = object;
            object = new AutoValue_EventStoreConfig(l10, n10, n11, l11, n12, null);
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Missing required properties:");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public EventStoreConfig$Builder setCriticalSectionEnterTimeoutMs(int n10) {
        Integer n11;
        this.criticalSectionEnterTimeoutMs = n11 = Integer.valueOf(n10);
        return this;
    }

    public EventStoreConfig$Builder setEventCleanUpAge(long l10) {
        Long l11;
        this.eventCleanUpAge = l11 = Long.valueOf(l10);
        return this;
    }

    public EventStoreConfig$Builder setLoadBatchSize(int n10) {
        Integer n11;
        this.loadBatchSize = n11 = Integer.valueOf(n10);
        return this;
    }

    public EventStoreConfig$Builder setMaxBlobByteSizePerRow(int n10) {
        Integer n11;
        this.maxBlobByteSizePerRow = n11 = Integer.valueOf(n10);
        return this;
    }

    public EventStoreConfig$Builder setMaxStorageSizeInBytes(long l10) {
        Long l11;
        this.maxStorageSizeInBytes = l11 = Long.valueOf(l10);
        return this;
    }
}

