/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.base.Equivalence;
import com.google.common.base.Ticker;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheBuilder$OneWeigher;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.ForwardingCache;
import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$Strength;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.Weigher;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

public class LocalCache$ManualSerializationProxy
extends ForwardingCache
implements Serializable {
    private static final long serialVersionUID = 1L;
    public final int concurrencyLevel;
    public transient Cache delegate;
    public final long expireAfterAccessNanos;
    public final long expireAfterWriteNanos;
    public final Equivalence keyEquivalence;
    public final LocalCache$Strength keyStrength;
    public final CacheLoader loader;
    public final long maxWeight;
    public final RemovalListener removalListener;
    public final Ticker ticker;
    public final Equivalence valueEquivalence;
    public final LocalCache$Strength valueStrength;
    public final Weigher weigher;

    private LocalCache$ManualSerializationProxy(LocalCache$Strength object, LocalCache$Strength localCache$Strength, Equivalence equivalence, Equivalence equivalence2, long l10, long l11, long l12, Weigher weigher, int n10, RemovalListener removalListener, Ticker ticker, CacheLoader cacheLoader) {
        this.keyStrength = object;
        this.valueStrength = localCache$Strength;
        this.keyEquivalence = equivalence;
        this.valueEquivalence = equivalence2;
        this.expireAfterWriteNanos = l10;
        this.expireAfterAccessNanos = l11;
        this.maxWeight = l12;
        this.weigher = weigher;
        this.concurrencyLevel = n10;
        this.removalListener = removalListener;
        object = Ticker.systemTicker();
        if (ticker == object || ticker == (object = CacheBuilder.NULL_TICKER)) {
            ticker = null;
        }
        this.ticker = ticker;
        this.loader = cacheLoader;
    }

    public LocalCache$ManualSerializationProxy(LocalCache localCache) {
        LocalCache$Strength localCache$Strength = localCache.keyStrength;
        LocalCache$Strength localCache$Strength2 = localCache.valueStrength;
        Equivalence equivalence = localCache.keyEquivalence;
        Equivalence equivalence2 = localCache.valueEquivalence;
        long l10 = localCache.expireAfterWriteNanos;
        long l11 = localCache.expireAfterAccessNanos;
        long l12 = localCache.maxWeight;
        Weigher weigher = localCache.weigher;
        int n10 = localCache.concurrencyLevel;
        RemovalListener removalListener = localCache.removalListener;
        Ticker ticker = localCache.ticker;
        CacheLoader cacheLoader = localCache.defaultLoader;
        this(localCache$Strength, localCache$Strength2, equivalence, equivalence2, l10, l11, l12, weigher, n10, removalListener, ticker, cacheLoader);
    }

    private void readObject(ObjectInputStream object) {
        ((ObjectInputStream)object).defaultReadObject();
        this.delegate = object = this.recreateCacheBuilder().build();
    }

    private Object readResolve() {
        return this.delegate;
    }

    public Cache delegate() {
        return this.delegate;
    }

    public CacheBuilder recreateCacheBuilder() {
        long l10;
        Object object;
        CacheBuilder cacheBuilder = CacheBuilder.newBuilder();
        Object object2 = this.keyStrength;
        cacheBuilder = cacheBuilder.setKeyStrength((LocalCache$Strength)((Object)object2));
        object2 = this.valueStrength;
        cacheBuilder = cacheBuilder.setValueStrength((LocalCache$Strength)((Object)object2));
        object2 = this.keyEquivalence;
        cacheBuilder = cacheBuilder.keyEquivalence((Equivalence)object2);
        object2 = this.valueEquivalence;
        cacheBuilder = cacheBuilder.valueEquivalence((Equivalence)object2);
        int n10 = this.concurrencyLevel;
        cacheBuilder = cacheBuilder.concurrencyLevel(n10);
        object2 = this.removalListener;
        cacheBuilder = cacheBuilder.removalListener((RemovalListener)object2);
        n10 = 0;
        object2 = null;
        cacheBuilder.strictParsing = false;
        long l11 = this.expireAfterWriteNanos;
        long l12 = 0L;
        long l13 = l11 - l12;
        Object object3 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object3 > 0) {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            cacheBuilder.expireAfterWrite(l11, timeUnit);
        }
        if ((object = (l10 = (l11 = this.expireAfterAccessNanos) - l12) == 0L ? 0 : (l10 < 0L ? -1 : 1)) > 0) {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            cacheBuilder.expireAfterAccess(l11, timeUnit);
        }
        object2 = this.weigher;
        CacheBuilder$OneWeigher cacheBuilder$OneWeigher = CacheBuilder$OneWeigher.INSTANCE;
        l12 = -1;
        if (object2 != cacheBuilder$OneWeigher) {
            cacheBuilder.weigher((Weigher)object2);
            l11 = this.maxWeight;
            object = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
            if (object != false) {
                cacheBuilder.maximumWeight(l11);
            }
        } else {
            l11 = this.maxWeight;
            long l14 = l11 - l12;
            object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object != false) {
                cacheBuilder.maximumSize(l11);
            }
        }
        if ((object2 = this.ticker) != null) {
            cacheBuilder.ticker((Ticker)object2);
        }
        return cacheBuilder;
    }
}

