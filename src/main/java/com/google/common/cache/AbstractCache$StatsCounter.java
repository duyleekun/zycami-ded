/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.CacheStats;

public interface AbstractCache$StatsCounter {
    public void recordEviction();

    public void recordHits(int var1);

    public void recordLoadException(long var1);

    public void recordLoadSuccess(long var1);

    public void recordMisses(int var1);

    public CacheStats snapshot();
}

