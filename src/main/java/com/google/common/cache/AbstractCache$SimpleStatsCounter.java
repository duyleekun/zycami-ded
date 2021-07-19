/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.AbstractCache$StatsCounter;
import com.google.common.cache.CacheStats;
import com.google.common.cache.LongAddable;
import com.google.common.cache.LongAddables;

public final class AbstractCache$SimpleStatsCounter
implements AbstractCache$StatsCounter {
    private final LongAddable evictionCount;
    private final LongAddable hitCount;
    private final LongAddable loadExceptionCount;
    private final LongAddable loadSuccessCount;
    private final LongAddable missCount;
    private final LongAddable totalLoadTime;

    public AbstractCache$SimpleStatsCounter() {
        LongAddable longAddable;
        this.hitCount = longAddable = LongAddables.create();
        this.missCount = longAddable = LongAddables.create();
        this.loadSuccessCount = longAddable = LongAddables.create();
        this.loadExceptionCount = longAddable = LongAddables.create();
        this.totalLoadTime = longAddable = LongAddables.create();
        this.evictionCount = longAddable = LongAddables.create();
    }

    private static long negativeToMaxValue(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object < 0) {
            l10 = Long.MAX_VALUE;
        }
        return l10;
    }

    public void incrementBy(AbstractCache$StatsCounter object) {
        object = object.snapshot();
        LongAddable longAddable = this.hitCount;
        long l10 = ((CacheStats)object).hitCount();
        longAddable.add(l10);
        longAddable = this.missCount;
        l10 = ((CacheStats)object).missCount();
        longAddable.add(l10);
        longAddable = this.loadSuccessCount;
        l10 = ((CacheStats)object).loadSuccessCount();
        longAddable.add(l10);
        longAddable = this.loadExceptionCount;
        l10 = ((CacheStats)object).loadExceptionCount();
        longAddable.add(l10);
        longAddable = this.totalLoadTime;
        l10 = ((CacheStats)object).totalLoadTime();
        longAddable.add(l10);
        longAddable = this.evictionCount;
        l10 = ((CacheStats)object).evictionCount();
        longAddable.add(l10);
    }

    public void recordEviction() {
        this.evictionCount.increment();
    }

    public void recordHits(int n10) {
        LongAddable longAddable = this.hitCount;
        long l10 = n10;
        longAddable.add(l10);
    }

    public void recordLoadException(long l10) {
        this.loadExceptionCount.increment();
        this.totalLoadTime.add(l10);
    }

    public void recordLoadSuccess(long l10) {
        this.loadSuccessCount.increment();
        this.totalLoadTime.add(l10);
    }

    public void recordMisses(int n10) {
        LongAddable longAddable = this.missCount;
        long l10 = n10;
        longAddable.add(l10);
    }

    public CacheStats snapshot() {
        long l10 = AbstractCache$SimpleStatsCounter.negativeToMaxValue(this.hitCount.sum());
        long l11 = AbstractCache$SimpleStatsCounter.negativeToMaxValue(this.missCount.sum());
        long l12 = AbstractCache$SimpleStatsCounter.negativeToMaxValue(this.loadSuccessCount.sum());
        long l13 = AbstractCache$SimpleStatsCounter.negativeToMaxValue(this.loadExceptionCount.sum());
        long l14 = AbstractCache$SimpleStatsCounter.negativeToMaxValue(this.totalLoadTime.sum());
        long l15 = AbstractCache$SimpleStatsCounter.negativeToMaxValue(this.evictionCount.sum());
        CacheStats cacheStats = new CacheStats(l10, l11, l12, l13, l14, l15);
        return cacheStats;
    }
}

