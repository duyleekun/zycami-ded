/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.AbstractCache$StatsCounter;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheStats;

public final class CacheBuilder$1
implements AbstractCache$StatsCounter {
    public void recordEviction() {
    }

    public void recordHits(int n10) {
    }

    public void recordLoadException(long l10) {
    }

    public void recordLoadSuccess(long l10) {
    }

    public void recordMisses(int n10) {
    }

    public CacheStats snapshot() {
        return CacheBuilder.EMPTY_STATS;
    }
}

