/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects$ToStringHelper;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.math.LongMath;

public final class CacheStats {
    private final long evictionCount;
    private final long hitCount;
    private final long loadExceptionCount;
    private final long loadSuccessCount;
    private final long missCount;
    private final long totalLoadTime;

    public CacheStats(long l10, long l11, long l12, long l13, long l14, long l15) {
        CacheStats cacheStats = this;
        long l16 = l10;
        long l17 = l11;
        long l18 = l12;
        long l19 = l13;
        long l20 = l14;
        long l21 = l15;
        long l22 = 0L;
        long l23 = l10 == l22 ? 0 : (l10 < l22 ? -1 : 1);
        boolean bl2 = true;
        l23 = l23 >= 0 ? (long)bl2 : (long)0;
        Preconditions.checkArgument((boolean)l23);
        l23 = l17 == l22 ? 0 : (l17 < l22 ? -1 : 1);
        l23 = l23 >= 0 ? (long)bl2 : (long)0;
        Preconditions.checkArgument((boolean)l23);
        l23 = l18 == l22 ? 0 : (l18 < l22 ? -1 : 1);
        l23 = l23 >= 0 ? (long)bl2 : (long)0;
        Preconditions.checkArgument((boolean)l23);
        l23 = l19 == l22 ? 0 : (l19 < l22 ? -1 : 1);
        l23 = l23 >= 0 ? (long)bl2 : (long)0;
        Preconditions.checkArgument((boolean)l23);
        l23 = l20 == l22 ? 0 : (l20 < l22 ? -1 : 1);
        l23 = l23 >= 0 ? (long)bl2 : (long)0;
        Preconditions.checkArgument((boolean)l23);
        long l24 = l21 == l22 ? 0 : (l21 < l22 ? -1 : 1);
        if (l24 < 0) {
            bl2 = false;
        }
        Preconditions.checkArgument(bl2);
        cacheStats.hitCount = l16;
        cacheStats.missCount = l17;
        cacheStats.loadSuccessCount = l18;
        cacheStats.loadExceptionCount = l19;
        cacheStats.totalLoadTime = l20;
        cacheStats.evictionCount = l21;
    }

    public double averageLoadPenalty() {
        double d10;
        long l10 = this.loadSuccessCount;
        long l11 = this.loadExceptionCount;
        l10 = LongMath.saturatedAdd(l10, l11);
        l11 = 0L;
        double d11 = 0.0;
        Object object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (object == false) {
            l10 = 0L;
            d10 = 0.0;
        } else {
            l11 = this.totalLoadTime;
            d11 = l11;
            d10 = l10;
            d10 = d11 / d10;
        }
        return d10;
    }

    public boolean equals(Object object) {
        Object object2 = object instanceof CacheStats;
        boolean bl2 = false;
        if (object2) {
            long l10;
            long l11;
            long l12;
            long l13;
            long l14;
            long l15;
            object = (CacheStats)object;
            long l16 = this.hitCount;
            long l17 = ((CacheStats)object).hitCount;
            long l18 = l16 - l17;
            object2 = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
            if (!(object2 || (object2 = (l15 = (l16 = this.missCount) - (l17 = ((CacheStats)object).missCount)) == 0L ? 0 : (l15 < 0L ? -1 : 1)) || (object2 = (l14 = (l16 = this.loadSuccessCount) - (l17 = ((CacheStats)object).loadSuccessCount)) == 0L ? 0 : (l14 < 0L ? -1 : 1)) || (object2 = (l13 = (l16 = this.loadExceptionCount) - (l17 = ((CacheStats)object).loadExceptionCount)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) || (object2 = (l12 = (l16 = this.totalLoadTime) - (l17 = ((CacheStats)object).totalLoadTime)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) || (l11 = (l10 = (l16 = this.evictionCount) - (l17 = ((CacheStats)object).evictionCount)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false)) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public long evictionCount() {
        return this.evictionCount;
    }

    public int hashCode() {
        Object[] objectArray = new Object[6];
        Long l10 = this.hitCount;
        objectArray[0] = l10;
        l10 = this.missCount;
        objectArray[1] = l10;
        l10 = this.loadSuccessCount;
        objectArray[2] = l10;
        l10 = this.loadExceptionCount;
        objectArray[3] = l10;
        l10 = this.totalLoadTime;
        objectArray[4] = l10;
        l10 = this.evictionCount;
        objectArray[5] = l10;
        return Objects.hashCode(objectArray);
    }

    public long hitCount() {
        return this.hitCount;
    }

    public double hitRate() {
        double d10;
        long l10 = this.requestCount();
        long l11 = 0L;
        double d11 = 0.0;
        Object object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (object == false) {
            l10 = 0x3FF0000000000000L;
            d10 = 1.0;
        } else {
            l11 = this.hitCount;
            d11 = l11;
            d10 = l10;
            d10 = d11 / d10;
        }
        return d10;
    }

    public long loadCount() {
        long l10 = this.loadSuccessCount;
        long l11 = this.loadExceptionCount;
        return LongMath.saturatedAdd(l10, l11);
    }

    public long loadExceptionCount() {
        return this.loadExceptionCount;
    }

    public double loadExceptionRate() {
        double d10;
        long l10 = this.loadSuccessCount;
        long l11 = this.loadExceptionCount;
        l10 = LongMath.saturatedAdd(l10, l11);
        l11 = 0L;
        double d11 = 0.0;
        Object object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (object == false) {
            l10 = 0L;
            d10 = 0.0;
        } else {
            l11 = this.loadExceptionCount;
            d11 = l11;
            d10 = l10;
            d10 = d11 / d10;
        }
        return d10;
    }

    public long loadSuccessCount() {
        return this.loadSuccessCount;
    }

    public CacheStats minus(CacheStats cacheStats) {
        long l10 = this.hitCount;
        long l11 = cacheStats.hitCount;
        l10 = LongMath.saturatedSubtract(l10, l11);
        l11 = 0L;
        l10 = Math.max(l11, l10);
        long l12 = this.missCount;
        long l13 = cacheStats.missCount;
        l12 = LongMath.saturatedSubtract(l12, l13);
        l12 = Math.max(l11, l12);
        l13 = this.loadSuccessCount;
        long l14 = cacheStats.loadSuccessCount;
        l13 = LongMath.saturatedSubtract(l13, l14);
        l13 = Math.max(l11, l13);
        l14 = this.loadExceptionCount;
        long l15 = cacheStats.loadExceptionCount;
        l14 = LongMath.saturatedSubtract(l14, l15);
        l14 = Math.max(l11, l14);
        l15 = this.totalLoadTime;
        long l16 = l14;
        l14 = cacheStats.totalLoadTime;
        l14 = LongMath.saturatedSubtract(l15, l14);
        l14 = Math.max(l11, l14);
        l15 = this.evictionCount;
        long l17 = cacheStats.evictionCount;
        l17 = LongMath.saturatedSubtract(l15, l17);
        l15 = Math.max(l11, l17);
        l11 = l12;
        l12 = l13;
        l13 = l16;
        CacheStats cacheStats2 = new CacheStats(l10, l11, l12, l16, l14, l15);
        return cacheStats2;
    }

    public long missCount() {
        return this.missCount;
    }

    public double missRate() {
        double d10;
        long l10 = this.requestCount();
        long l11 = 0L;
        double d11 = 0.0;
        Object object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (object == false) {
            l10 = 0L;
            d10 = 0.0;
        } else {
            l11 = this.missCount;
            d11 = l11;
            d10 = l10;
            d10 = d11 / d10;
        }
        return d10;
    }

    public CacheStats plus(CacheStats cacheStats) {
        long l10 = this.hitCount;
        long l11 = cacheStats.hitCount;
        l10 = LongMath.saturatedAdd(l10, l11);
        l11 = this.missCount;
        long l12 = cacheStats.missCount;
        l11 = LongMath.saturatedAdd(l11, l12);
        l12 = this.loadSuccessCount;
        long l13 = cacheStats.loadSuccessCount;
        l12 = LongMath.saturatedAdd(l12, l13);
        l13 = this.loadExceptionCount;
        long l14 = cacheStats.loadExceptionCount;
        l13 = LongMath.saturatedAdd(l13, l14);
        l14 = this.totalLoadTime;
        long l15 = cacheStats.totalLoadTime;
        l14 = LongMath.saturatedAdd(l14, l15);
        l15 = this.evictionCount;
        long l16 = cacheStats.evictionCount;
        l15 = LongMath.saturatedAdd(l15, l16);
        CacheStats cacheStats2 = new CacheStats(l10, l11, l12, l13, l14, l15);
        return cacheStats2;
    }

    public long requestCount() {
        long l10 = this.hitCount;
        long l11 = this.missCount;
        return LongMath.saturatedAdd(l10, l11);
    }

    public String toString() {
        MoreObjects$ToStringHelper moreObjects$ToStringHelper = MoreObjects.toStringHelper(this);
        long l10 = this.hitCount;
        moreObjects$ToStringHelper = moreObjects$ToStringHelper.add("hitCount", l10);
        l10 = this.missCount;
        moreObjects$ToStringHelper = moreObjects$ToStringHelper.add("missCount", l10);
        l10 = this.loadSuccessCount;
        moreObjects$ToStringHelper = moreObjects$ToStringHelper.add("loadSuccessCount", l10);
        l10 = this.loadExceptionCount;
        moreObjects$ToStringHelper = moreObjects$ToStringHelper.add("loadExceptionCount", l10);
        l10 = this.totalLoadTime;
        moreObjects$ToStringHelper = moreObjects$ToStringHelper.add("totalLoadTime", l10);
        l10 = this.evictionCount;
        return moreObjects$ToStringHelper.add("evictionCount", l10).toString();
    }

    public long totalLoadTime() {
        return this.totalLoadTime;
    }
}

