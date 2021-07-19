/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects$ToStringHelper;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.base.Ticker;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder$1;
import com.google.common.cache.CacheBuilder$2;
import com.google.common.cache.CacheBuilder$3;
import com.google.common.cache.CacheBuilder$NullListener;
import com.google.common.cache.CacheBuilder$OneWeigher;
import com.google.common.cache.CacheBuilderSpec;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheStats;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.LocalCache$LocalLoadingCache;
import com.google.common.cache.LocalCache$LocalManualCache;
import com.google.common.cache.LocalCache$Strength;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.Weigher;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class CacheBuilder {
    public static final Supplier CACHE_STATS_COUNTER;
    private static final int DEFAULT_CONCURRENCY_LEVEL = 4;
    private static final int DEFAULT_EXPIRATION_NANOS = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final int DEFAULT_REFRESH_NANOS = 0;
    public static final CacheStats EMPTY_STATS;
    public static final Supplier NULL_STATS_COUNTER;
    public static final Ticker NULL_TICKER;
    public static final int UNSET_INT = 255;
    private static final Logger logger;
    public int concurrencyLevel;
    public long expireAfterAccessNanos;
    public long expireAfterWriteNanos;
    public int initialCapacity;
    public Equivalence keyEquivalence;
    public LocalCache$Strength keyStrength;
    public long maximumSize;
    public long maximumWeight;
    public long refreshNanos;
    public RemovalListener removalListener;
    public Supplier statsCounterSupplier;
    public boolean strictParsing = true;
    public Ticker ticker;
    public Equivalence valueEquivalence;
    public LocalCache$Strength valueStrength;
    public Weigher weigher;

    static {
        Object object = new CacheBuilder$1();
        NULL_STATS_COUNTER = Suppliers.ofInstance(object);
        EMPTY_STATS = object = new CacheStats(0L, 0L, 0L, 0L, 0L, 0L);
        CACHE_STATS_COUNTER = object = new CacheBuilder$2();
        NULL_TICKER = object = new CacheBuilder$3();
        logger = Logger.getLogger(CacheBuilder.class.getName());
    }

    private CacheBuilder() {
        Supplier supplier;
        long l10;
        int n10;
        this.initialCapacity = n10 = -1;
        this.concurrencyLevel = n10;
        this.maximumSize = l10 = (long)-1;
        this.maximumWeight = l10;
        this.expireAfterWriteNanos = l10;
        this.expireAfterAccessNanos = l10;
        this.refreshNanos = l10;
        this.statsCounterSupplier = supplier = NULL_STATS_COUNTER;
    }

    private void checkNonLoadingCache() {
        long l10 = this.refreshNanos;
        long l11 = -1;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object == false ? (Object)1 : (Object)0;
        Preconditions.checkState((boolean)object, "refreshAfterWrite requires a LoadingCache");
    }

    private void checkWeightWithWeigher() {
        Object object = this.weigher;
        boolean bl2 = true;
        String string2 = null;
        long l10 = -1;
        if (object == null) {
            long l11 = this.maximumWeight;
            long l12 = l11 - l10;
            Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 != false) {
                bl2 = false;
                Object var9_9 = null;
            }
            object = "maximumWeight requires weigher";
            Preconditions.checkState(bl2, object);
        } else {
            Object object3 = this.strictParsing;
            if (object3) {
                long l13 = this.maximumWeight;
                long l14 = l13 - l10;
                object3 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                if (!object3) {
                    bl2 = false;
                    Object var9_10 = null;
                }
                object = "weigher requires maximumWeight";
                Preconditions.checkState(bl2, object);
            } else {
                long l15 = this.maximumWeight;
                long l16 = l15 - l10;
                object3 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                if (!object3) {
                    object = logger;
                    Level level = Level.WARNING;
                    string2 = "ignoring weigher specified without maximumWeight";
                    ((Logger)object).log(level, string2);
                }
            }
        }
    }

    public static CacheBuilder from(CacheBuilderSpec cacheBuilderSpec) {
        return cacheBuilderSpec.toCacheBuilder().lenientParsing();
    }

    public static CacheBuilder from(String string2) {
        return CacheBuilder.from(CacheBuilderSpec.parse(string2));
    }

    public static CacheBuilder newBuilder() {
        CacheBuilder cacheBuilder = new CacheBuilder();
        return cacheBuilder;
    }

    public Cache build() {
        this.checkWeightWithWeigher();
        this.checkNonLoadingCache();
        LocalCache$LocalManualCache localCache$LocalManualCache = new LocalCache$LocalManualCache(this);
        return localCache$LocalManualCache;
    }

    public LoadingCache build(CacheLoader cacheLoader) {
        this.checkWeightWithWeigher();
        LocalCache$LocalLoadingCache localCache$LocalLoadingCache = new LocalCache$LocalLoadingCache(this, cacheLoader);
        return localCache$LocalLoadingCache;
    }

    /*
     * WARNING - void declaration
     */
    public CacheBuilder concurrencyLevel(int n10) {
        void var4_7;
        int bl2 = this.concurrencyLevel;
        boolean bl3 = true;
        int bl4 = -1;
        if (bl2 == bl4) {
            boolean bl5 = bl3;
        } else {
            boolean bl6 = false;
        }
        String string2 = "concurrency level was already set to %s";
        Preconditions.checkState((boolean)var4_7, string2, bl2);
        if (n10 <= 0) {
            bl3 = false;
        }
        Preconditions.checkArgument(bl3);
        this.concurrencyLevel = n10;
        return this;
    }

    public CacheBuilder expireAfterAccess(long l10, TimeUnit timeUnit) {
        long l11 = this.expireAfterAccessNanos;
        long l12 = -1;
        long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        boolean bl2 = true;
        l13 = l13 == false ? (long)bl2 : (long)0;
        String string2 = "expireAfterAccess was already set to %s ns";
        Preconditions.checkState((boolean)l13, string2, l11);
        l11 = 0L;
        long l14 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l14 < 0) {
            bl2 = false;
        }
        Preconditions.checkArgument(bl2, "duration cannot be negative: %s %s", l10, (Object)timeUnit);
        this.expireAfterAccessNanos = l10 = timeUnit.toNanos(l10);
        return this;
    }

    public CacheBuilder expireAfterWrite(long l10, TimeUnit timeUnit) {
        long l11 = this.expireAfterWriteNanos;
        long l12 = -1;
        long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        boolean bl2 = true;
        l13 = l13 == false ? (long)bl2 : (long)0;
        String string2 = "expireAfterWrite was already set to %s ns";
        Preconditions.checkState((boolean)l13, string2, l11);
        l11 = 0L;
        long l14 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l14 < 0) {
            bl2 = false;
        }
        Preconditions.checkArgument(bl2, "duration cannot be negative: %s %s", l10, (Object)timeUnit);
        this.expireAfterWriteNanos = l10 = timeUnit.toNanos(l10);
        return this;
    }

    public int getConcurrencyLevel() {
        int n10 = this.concurrencyLevel;
        int n11 = -1;
        if (n10 == n11) {
            n10 = 4;
        }
        return n10;
    }

    public long getExpireAfterAccessNanos() {
        long l10 = this.expireAfterAccessNanos;
        long l11 = -1;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            l10 = 0L;
        }
        return l10;
    }

    public long getExpireAfterWriteNanos() {
        long l10 = this.expireAfterWriteNanos;
        long l11 = -1;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            l10 = 0L;
        }
        return l10;
    }

    public int getInitialCapacity() {
        int n10 = this.initialCapacity;
        int n11 = -1;
        if (n10 == n11) {
            n10 = 16;
        }
        return n10;
    }

    public Equivalence getKeyEquivalence() {
        Equivalence equivalence = this.keyEquivalence;
        Equivalence equivalence2 = this.getKeyStrength().defaultEquivalence();
        return (Equivalence)MoreObjects.firstNonNull(equivalence, equivalence2);
    }

    public LocalCache$Strength getKeyStrength() {
        LocalCache$Strength localCache$Strength = this.keyStrength;
        LocalCache$Strength localCache$Strength2 = LocalCache$Strength.STRONG;
        return (LocalCache$Strength)((Object)MoreObjects.firstNonNull((Object)localCache$Strength, (Object)localCache$Strength2));
    }

    public long getMaximumWeight() {
        long l10;
        long l11 = this.expireAfterWriteNanos;
        long l12 = 0L;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object != false && (object = (l10 = (l11 = this.expireAfterAccessNanos) - l12) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
            Weigher weigher = this.weigher;
            l11 = weigher == null ? this.maximumSize : this.maximumWeight;
            return l11;
        }
        return l12;
    }

    public long getRefreshNanos() {
        long l10 = this.refreshNanos;
        long l11 = -1;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            l10 = 0L;
        }
        return l10;
    }

    public RemovalListener getRemovalListener() {
        RemovalListener removalListener = this.removalListener;
        CacheBuilder$NullListener cacheBuilder$NullListener = CacheBuilder$NullListener.INSTANCE;
        return (RemovalListener)MoreObjects.firstNonNull(removalListener, cacheBuilder$NullListener);
    }

    public Supplier getStatsCounterSupplier() {
        return this.statsCounterSupplier;
    }

    public Ticker getTicker(boolean bl2) {
        Ticker ticker = this.ticker;
        if (ticker != null) {
            return ticker;
        }
        Ticker ticker2 = bl2 ? Ticker.systemTicker() : NULL_TICKER;
        return ticker2;
    }

    public Equivalence getValueEquivalence() {
        Equivalence equivalence = this.valueEquivalence;
        Equivalence equivalence2 = this.getValueStrength().defaultEquivalence();
        return (Equivalence)MoreObjects.firstNonNull(equivalence, equivalence2);
    }

    public LocalCache$Strength getValueStrength() {
        LocalCache$Strength localCache$Strength = this.valueStrength;
        LocalCache$Strength localCache$Strength2 = LocalCache$Strength.STRONG;
        return (LocalCache$Strength)((Object)MoreObjects.firstNonNull((Object)localCache$Strength, (Object)localCache$Strength2));
    }

    public Weigher getWeigher() {
        Weigher weigher = this.weigher;
        CacheBuilder$OneWeigher cacheBuilder$OneWeigher = CacheBuilder$OneWeigher.INSTANCE;
        return (Weigher)MoreObjects.firstNonNull(weigher, cacheBuilder$OneWeigher);
    }

    /*
     * WARNING - void declaration
     */
    public CacheBuilder initialCapacity(int n10) {
        void var4_7;
        int bl2 = this.initialCapacity;
        boolean bl3 = true;
        int bl4 = -1;
        if (bl2 == bl4) {
            boolean bl5 = bl3;
        } else {
            boolean bl6 = false;
        }
        String string2 = "initial capacity was already set to %s";
        Preconditions.checkState((boolean)var4_7, string2, bl2);
        if (n10 < 0) {
            bl3 = false;
        }
        Preconditions.checkArgument(bl3);
        this.initialCapacity = n10;
        return this;
    }

    public boolean isRecordingStats() {
        boolean bl2;
        Supplier supplier = this.statsCounterSupplier;
        Supplier supplier2 = CACHE_STATS_COUNTER;
        if (supplier == supplier2) {
            bl2 = true;
        } else {
            bl2 = false;
            supplier = null;
        }
        return bl2;
    }

    public CacheBuilder keyEquivalence(Equivalence equivalence) {
        Equivalence equivalence2 = this.keyEquivalence;
        boolean bl2 = equivalence2 == null;
        Preconditions.checkState(bl2, "key equivalence was already set to %s", (Object)equivalence2);
        this.keyEquivalence = equivalence = (Equivalence)Preconditions.checkNotNull(equivalence);
        return this;
    }

    public CacheBuilder lenientParsing() {
        this.strictParsing = false;
        return this;
    }

    public CacheBuilder maximumSize(long l10) {
        boolean bl2;
        long l11 = this.maximumSize;
        long l12 = -1;
        long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        boolean bl3 = true;
        l13 = l13 == false ? (long)bl3 : (long)0;
        String string2 = "maximum size was already set to %s";
        Preconditions.checkState((boolean)l13, string2, l11);
        l11 = this.maximumWeight;
        long l14 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        l14 = l14 == false ? (long)bl3 : (long)0;
        String string3 = "maximum weight was already set to %s";
        Preconditions.checkState((boolean)l14, string3, l11);
        Weigher weigher = this.weigher;
        if (weigher == null) {
            bl2 = bl3;
        } else {
            bl2 = false;
            weigher = null;
        }
        String string4 = "maximum size can not be combined with weigher";
        Preconditions.checkState(bl2, string4);
        l11 = 0L;
        bl2 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (bl2 < false) {
            bl3 = false;
        }
        Preconditions.checkArgument(bl3, "maximum size must not be negative");
        this.maximumSize = l10;
        return this;
    }

    public CacheBuilder maximumWeight(long l10) {
        long l11 = this.maximumWeight;
        long l12 = -1;
        long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        boolean bl2 = true;
        l13 = l13 == false ? (long)bl2 : (long)0;
        String string2 = "maximum weight was already set to %s";
        Preconditions.checkState((boolean)l13, string2, l11);
        l11 = this.maximumSize;
        long l14 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        l14 = l14 == false ? (long)bl2 : (long)0;
        String string3 = "maximum size was already set to %s";
        Preconditions.checkState((boolean)l14, string3, l11);
        this.maximumWeight = l10;
        l11 = 0L;
        long l15 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l15 < 0) {
            bl2 = false;
        }
        Preconditions.checkArgument(bl2, "maximum weight must not be negative");
        return this;
    }

    public CacheBuilder recordStats() {
        Supplier supplier;
        this.statsCounterSupplier = supplier = CACHE_STATS_COUNTER;
        return this;
    }

    public CacheBuilder refreshAfterWrite(long l10, TimeUnit timeUnit) {
        Preconditions.checkNotNull((Object)timeUnit);
        long l11 = this.refreshNanos;
        long l12 = -1;
        long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        boolean bl2 = true;
        l13 = l13 == false ? (long)bl2 : (long)0;
        String string2 = "refresh was already set to %s ns";
        Preconditions.checkState((boolean)l13, string2, l11);
        l11 = 0L;
        long l14 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l14 <= 0) {
            bl2 = false;
        }
        Preconditions.checkArgument(bl2, "duration must be positive: %s %s", l10, (Object)timeUnit);
        this.refreshNanos = l10 = timeUnit.toNanos(l10);
        return this;
    }

    public CacheBuilder removalListener(RemovalListener removalListener) {
        boolean bl2;
        RemovalListener removalListener2 = this.removalListener;
        if (removalListener2 == null) {
            bl2 = true;
        } else {
            bl2 = false;
            removalListener2 = null;
        }
        Preconditions.checkState(bl2);
        this.removalListener = removalListener = (RemovalListener)Preconditions.checkNotNull(removalListener);
        return this;
    }

    public CacheBuilder setKeyStrength(LocalCache$Strength localCache$Strength) {
        LocalCache$Strength localCache$Strength2 = this.keyStrength;
        boolean bl2 = localCache$Strength2 == null;
        Preconditions.checkState(bl2, "Key strength was already set to %s", (Object)localCache$Strength2);
        this.keyStrength = localCache$Strength = (LocalCache$Strength)((Object)Preconditions.checkNotNull((Object)localCache$Strength));
        return this;
    }

    public CacheBuilder setValueStrength(LocalCache$Strength localCache$Strength) {
        LocalCache$Strength localCache$Strength2 = this.valueStrength;
        boolean bl2 = localCache$Strength2 == null;
        Preconditions.checkState(bl2, "Value strength was already set to %s", (Object)localCache$Strength2);
        this.valueStrength = localCache$Strength = (LocalCache$Strength)((Object)Preconditions.checkNotNull((Object)localCache$Strength));
        return this;
    }

    public CacheBuilder softValues() {
        LocalCache$Strength localCache$Strength = LocalCache$Strength.SOFT;
        return this.setValueStrength(localCache$Strength);
    }

    public CacheBuilder ticker(Ticker ticker) {
        boolean bl2;
        Ticker ticker2 = this.ticker;
        if (ticker2 == null) {
            bl2 = true;
        } else {
            bl2 = false;
            ticker2 = null;
        }
        Preconditions.checkState(bl2);
        this.ticker = ticker = (Ticker)Preconditions.checkNotNull(ticker);
        return this;
    }

    public String toString() {
        long l10;
        long l11;
        Object object;
        long l12;
        String string2;
        long l13;
        long l14;
        long l15;
        long l16;
        String string3;
        MoreObjects$ToStringHelper moreObjects$ToStringHelper = MoreObjects.toStringHelper(this);
        int n10 = this.initialCapacity;
        int n11 = -1;
        if (n10 != n11) {
            String string4 = "initialCapacity";
            moreObjects$ToStringHelper.add(string4, n10);
        }
        if ((n10 = this.concurrencyLevel) != n11) {
            string3 = "concurrencyLevel";
            moreObjects$ToStringHelper.add(string3, n10);
        }
        if ((l16 = (l15 = (l14 = this.maximumSize) - (l13 = (long)-1)) == 0L ? 0 : (l15 < 0L ? -1 : 1)) != false) {
            string2 = "maximumSize";
            moreObjects$ToStringHelper.add(string2, l14);
        }
        if ((l16 = (l12 = (l14 = this.maximumWeight) - l13) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
            string2 = "maximumWeight";
            moreObjects$ToStringHelper.add(string2, l14);
        }
        l14 = this.expireAfterWriteNanos;
        n10 = (int)(l14 == l13 ? 0 : (l14 < l13 ? -1 : 1));
        string3 = "ns";
        if (n10 != 0) {
            object = new StringBuilder();
            l11 = this.expireAfterWriteNanos;
            ((StringBuilder)object).append(l11);
            ((StringBuilder)object).append(string3);
            object = ((StringBuilder)object).toString();
            string2 = "expireAfterWrite";
            moreObjects$ToStringHelper.add(string2, object);
        }
        if ((n10 = (int)((l10 = (l11 = this.expireAfterAccessNanos) - l13) == 0L ? 0 : (l10 < 0L ? -1 : 1))) != 0) {
            object = new StringBuilder();
            l13 = this.expireAfterAccessNanos;
            ((StringBuilder)object).append(l13);
            ((StringBuilder)object).append(string3);
            object = ((StringBuilder)object).toString();
            string3 = "expireAfterAccess";
            moreObjects$ToStringHelper.add(string3, object);
        }
        if ((object = this.keyStrength) != null) {
            object = Ascii.toLowerCase(((Enum)object).toString());
            string3 = "keyStrength";
            moreObjects$ToStringHelper.add(string3, object);
        }
        if ((object = this.valueStrength) != null) {
            object = Ascii.toLowerCase(((Enum)object).toString());
            string3 = "valueStrength";
            moreObjects$ToStringHelper.add(string3, object);
        }
        if ((object = this.keyEquivalence) != null) {
            object = "keyEquivalence";
            moreObjects$ToStringHelper.addValue(object);
        }
        if ((object = this.valueEquivalence) != null) {
            object = "valueEquivalence";
            moreObjects$ToStringHelper.addValue(object);
        }
        if ((object = this.removalListener) != null) {
            object = "removalListener";
            moreObjects$ToStringHelper.addValue(object);
        }
        return moreObjects$ToStringHelper.toString();
    }

    public CacheBuilder valueEquivalence(Equivalence equivalence) {
        Equivalence equivalence2 = this.valueEquivalence;
        boolean bl2 = equivalence2 == null;
        Preconditions.checkState(bl2, "value equivalence was already set to %s", (Object)equivalence2);
        this.valueEquivalence = equivalence = (Equivalence)Preconditions.checkNotNull(equivalence);
        return this;
    }

    public CacheBuilder weakKeys() {
        LocalCache$Strength localCache$Strength = LocalCache$Strength.WEAK;
        return this.setKeyStrength(localCache$Strength);
    }

    public CacheBuilder weakValues() {
        LocalCache$Strength localCache$Strength = LocalCache$Strength.WEAK;
        return this.setValueStrength(localCache$Strength);
    }

    public CacheBuilder weigher(Weigher weigher) {
        Object object;
        Object object2 = this.weigher;
        boolean bl2 = true;
        if (object2 == null) {
            object = bl2;
        } else {
            object = false;
            object2 = null;
        }
        Preconditions.checkState(object);
        object = this.strictParsing;
        if (object) {
            long l10 = this.maximumSize;
            long l11 = -1;
            long l12 = l10 - l11;
            object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object) {
                bl2 = false;
            }
            object2 = "weigher can not be combined with maximum size";
            Preconditions.checkState(bl2, (String)object2, l10);
        }
        this.weigher = weigher = (Weigher)Preconditions.checkNotNull(weigher);
        return this;
    }
}

