/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects$ToStringHelper;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheBuilderSpec$1;
import com.google.common.cache.CacheBuilderSpec$AccessDurationParser;
import com.google.common.cache.CacheBuilderSpec$ConcurrencyLevelParser;
import com.google.common.cache.CacheBuilderSpec$InitialCapacityParser;
import com.google.common.cache.CacheBuilderSpec$KeyStrengthParser;
import com.google.common.cache.CacheBuilderSpec$MaximumSizeParser;
import com.google.common.cache.CacheBuilderSpec$MaximumWeightParser;
import com.google.common.cache.CacheBuilderSpec$RecordStatsParser;
import com.google.common.cache.CacheBuilderSpec$RefreshDurationParser;
import com.google.common.cache.CacheBuilderSpec$ValueParser;
import com.google.common.cache.CacheBuilderSpec$ValueStrengthParser;
import com.google.common.cache.CacheBuilderSpec$WriteDurationParser;
import com.google.common.cache.LocalCache$Strength;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$Builder;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class CacheBuilderSpec {
    private static final Splitter KEYS_SPLITTER = Splitter.on(',').trimResults();
    private static final Splitter KEY_VALUE_SPLITTER = Splitter.on('=').trimResults();
    private static final ImmutableMap VALUE_PARSERS;
    public long accessExpirationDuration;
    public TimeUnit accessExpirationTimeUnit;
    public Integer concurrencyLevel;
    public Integer initialCapacity;
    public LocalCache$Strength keyStrength;
    public Long maximumSize;
    public Long maximumWeight;
    public Boolean recordStats;
    public long refreshDuration;
    public TimeUnit refreshTimeUnit;
    private final String specification;
    public LocalCache$Strength valueStrength;
    public long writeExpirationDuration;
    public TimeUnit writeExpirationTimeUnit;

    static {
        ImmutableMap$Builder immutableMap$Builder = ImmutableMap.builder();
        CacheBuilderSpec$ValueParser cacheBuilderSpec$ValueParser = new CacheBuilderSpec$InitialCapacityParser();
        immutableMap$Builder = immutableMap$Builder.put("initialCapacity", cacheBuilderSpec$ValueParser);
        cacheBuilderSpec$ValueParser = new CacheBuilderSpec$MaximumSizeParser();
        immutableMap$Builder = immutableMap$Builder.put("maximumSize", cacheBuilderSpec$ValueParser);
        cacheBuilderSpec$ValueParser = new CacheBuilderSpec$MaximumWeightParser();
        immutableMap$Builder = immutableMap$Builder.put("maximumWeight", cacheBuilderSpec$ValueParser);
        cacheBuilderSpec$ValueParser = new CacheBuilderSpec$ConcurrencyLevelParser();
        immutableMap$Builder = immutableMap$Builder.put("concurrencyLevel", cacheBuilderSpec$ValueParser);
        LocalCache$Strength localCache$Strength = LocalCache$Strength.WEAK;
        cacheBuilderSpec$ValueParser = new CacheBuilderSpec$KeyStrengthParser(localCache$Strength);
        immutableMap$Builder = immutableMap$Builder.put("weakKeys", cacheBuilderSpec$ValueParser);
        LocalCache$Strength localCache$Strength2 = LocalCache$Strength.SOFT;
        cacheBuilderSpec$ValueParser = new CacheBuilderSpec$ValueStrengthParser(localCache$Strength2);
        immutableMap$Builder = immutableMap$Builder.put("softValues", cacheBuilderSpec$ValueParser);
        cacheBuilderSpec$ValueParser = new CacheBuilderSpec$ValueStrengthParser(localCache$Strength);
        immutableMap$Builder = immutableMap$Builder.put("weakValues", cacheBuilderSpec$ValueParser);
        cacheBuilderSpec$ValueParser = new CacheBuilderSpec$RecordStatsParser();
        immutableMap$Builder = immutableMap$Builder.put("recordStats", cacheBuilderSpec$ValueParser);
        cacheBuilderSpec$ValueParser = new CacheBuilderSpec$AccessDurationParser();
        immutableMap$Builder = immutableMap$Builder.put("expireAfterAccess", cacheBuilderSpec$ValueParser);
        cacheBuilderSpec$ValueParser = new CacheBuilderSpec$WriteDurationParser();
        immutableMap$Builder = immutableMap$Builder.put("expireAfterWrite", cacheBuilderSpec$ValueParser);
        cacheBuilderSpec$ValueParser = new CacheBuilderSpec$RefreshDurationParser();
        immutableMap$Builder = immutableMap$Builder.put("refreshAfterWrite", cacheBuilderSpec$ValueParser);
        cacheBuilderSpec$ValueParser = new CacheBuilderSpec$RefreshDurationParser();
        VALUE_PARSERS = immutableMap$Builder.put("refreshInterval", cacheBuilderSpec$ValueParser).build();
    }

    private CacheBuilderSpec(String string2) {
        this.specification = string2;
    }

    public static /* synthetic */ String access$000(String string2, Object[] objectArray) {
        return CacheBuilderSpec.format(string2, objectArray);
    }

    public static CacheBuilderSpec disableCaching() {
        return CacheBuilderSpec.parse("maximumSize=0");
    }

    private static Long durationInNanos(long l10, TimeUnit timeUnit) {
        Long l11;
        if (timeUnit == null) {
            l11 = null;
        } else {
            l10 = timeUnit.toNanos(l10);
            l11 = l10;
        }
        return l11;
    }

    private static String format(String string2, Object ... objectArray) {
        return String.format(Locale.ROOT, string2, objectArray);
    }

    public static CacheBuilderSpec parse(String object) {
        CacheBuilderSpec cacheBuilderSpec = new CacheBuilderSpec((String)object);
        boolean bl2 = ((String)object).isEmpty();
        if (!bl2) {
            Object object2 = KEYS_SPLITTER;
            object = ((Splitter)object2).split((CharSequence)object).iterator();
            while (bl2 = object.hasNext()) {
                CacheBuilderSpec$ValueParser cacheBuilderSpec$ValueParser;
                object2 = (String)object.next();
                Object object3 = ImmutableList.copyOf(KEY_VALUE_SPLITTER.split((CharSequence)object2));
                int n10 = object3.isEmpty();
                int n11 = 1;
                String string2 = "blank key-value pair";
                Preconditions.checkArgument((n10 ^= n11) != 0, string2);
                n10 = object3.size();
                int n12 = 2;
                int n13 = 0;
                if (n10 <= n12) {
                    n10 = n11;
                } else {
                    n10 = 0;
                    cacheBuilderSpec$ValueParser = null;
                }
                string2 = "key-value pair %s with more than one equals sign";
                Preconditions.checkArgument(n10 != 0, string2, object2);
                object2 = (String)object3.get(0);
                cacheBuilderSpec$ValueParser = (CacheBuilderSpec$ValueParser)VALUE_PARSERS.get(object2);
                if (cacheBuilderSpec$ValueParser != null) {
                    n13 = n11;
                }
                string2 = "unknown key %s";
                Preconditions.checkArgument(n13 != 0, string2, object2);
                n12 = object3.size();
                object3 = n12 == n11 ? null : (String)object3.get(n11);
                cacheBuilderSpec$ValueParser.parse(cacheBuilderSpec, (String)object2, (String)object3);
            }
        }
        return cacheBuilderSpec;
    }

    public boolean equals(Object object) {
        boolean bl2;
        block6: {
            block5: {
                TimeUnit timeUnit;
                bl2 = true;
                if (this == object) {
                    return bl2;
                }
                boolean bl3 = object instanceof CacheBuilderSpec;
                if (!bl3) {
                    return false;
                }
                object = (CacheBuilderSpec)object;
                Object object2 = this.initialCapacity;
                Object object3 = ((CacheBuilderSpec)object).initialCapacity;
                bl3 = Objects.equal(object2, object3);
                if (!bl3 || !(bl3 = Objects.equal(object2 = this.maximumSize, object3 = ((CacheBuilderSpec)object).maximumSize)) || !(bl3 = Objects.equal(object2 = this.maximumWeight, object3 = ((CacheBuilderSpec)object).maximumWeight)) || !(bl3 = Objects.equal(object2 = this.concurrencyLevel, object3 = ((CacheBuilderSpec)object).concurrencyLevel)) || !(bl3 = Objects.equal(object2 = this.keyStrength, object3 = ((CacheBuilderSpec)object).keyStrength)) || !(bl3 = Objects.equal(object2 = this.valueStrength, object3 = ((CacheBuilderSpec)object).valueStrength)) || !(bl3 = Objects.equal(object2 = this.recordStats, object3 = ((CacheBuilderSpec)object).recordStats))) break block5;
                long l10 = this.writeExpirationDuration;
                object2 = this.writeExpirationTimeUnit;
                bl3 = Objects.equal(object2 = CacheBuilderSpec.durationInNanos(l10, (TimeUnit)((Object)object2)), object3 = CacheBuilderSpec.durationInNanos(l10 = ((CacheBuilderSpec)object).writeExpirationDuration, timeUnit = ((CacheBuilderSpec)object).writeExpirationTimeUnit));
                if (!bl3) break block5;
                l10 = this.accessExpirationDuration;
                object2 = this.accessExpirationTimeUnit;
                bl3 = Objects.equal(object2 = CacheBuilderSpec.durationInNanos(l10, (TimeUnit)((Object)object2)), object3 = CacheBuilderSpec.durationInNanos(l10 = ((CacheBuilderSpec)object).accessExpirationDuration, timeUnit = ((CacheBuilderSpec)object).accessExpirationTimeUnit));
                if (!bl3) break block5;
                l10 = this.refreshDuration;
                object2 = this.refreshTimeUnit;
                object2 = CacheBuilderSpec.durationInNanos(l10, (TimeUnit)((Object)object2));
                l10 = ((CacheBuilderSpec)object).refreshDuration;
                object = ((CacheBuilderSpec)object).refreshTimeUnit;
                boolean bl4 = Objects.equal(object2, object = CacheBuilderSpec.durationInNanos(l10, (TimeUnit)((Object)object)));
                if (bl4) break block6;
            }
            bl2 = false;
        }
        return bl2;
    }

    public int hashCode() {
        Object[] objectArray = new Object[10];
        Object object = this.initialCapacity;
        objectArray[0] = object;
        object = this.maximumSize;
        objectArray[1] = object;
        object = this.maximumWeight;
        objectArray[2] = object;
        object = this.concurrencyLevel;
        objectArray[3] = object;
        object = this.keyStrength;
        objectArray[4] = object;
        object = this.valueStrength;
        objectArray[5] = object;
        object = this.recordStats;
        objectArray[6] = object;
        long l10 = this.writeExpirationDuration;
        TimeUnit timeUnit = this.writeExpirationTimeUnit;
        object = CacheBuilderSpec.durationInNanos(l10, timeUnit);
        objectArray[7] = object;
        l10 = this.accessExpirationDuration;
        timeUnit = this.accessExpirationTimeUnit;
        object = CacheBuilderSpec.durationInNanos(l10, timeUnit);
        objectArray[8] = object;
        l10 = this.refreshDuration;
        timeUnit = this.refreshTimeUnit;
        object = CacheBuilderSpec.durationInNanos(l10, timeUnit);
        objectArray[9] = object;
        return Objects.hashCode(objectArray);
    }

    /*
     * Enabled aggressive block sorting
     */
    public CacheBuilder toCacheBuilder() {
        TimeUnit timeUnit;
        TimeUnit timeUnit2;
        long l10;
        TimeUnit timeUnit3;
        Boolean bl2;
        LocalCache$Strength localCache$Strength;
        int[] nArray;
        Integer n10;
        Long l11;
        long l12;
        Long l13;
        int n11;
        Object object = CacheBuilder.newBuilder();
        Integer n12 = this.initialCapacity;
        if (n12 != null) {
            n11 = n12;
            ((CacheBuilder)object).initialCapacity(n11);
        }
        if ((l13 = this.maximumSize) != null) {
            l12 = l13;
            ((CacheBuilder)object).maximumSize(l12);
        }
        if ((l11 = this.maximumWeight) != null) {
            l12 = l11;
            ((CacheBuilder)object).maximumWeight(l12);
        }
        if ((n10 = this.concurrencyLevel) != null) {
            n11 = n10;
            ((CacheBuilder)object).concurrencyLevel(n11);
        }
        LocalCache$Strength localCache$Strength2 = this.keyStrength;
        int n13 = 1;
        if (localCache$Strength2 != null) {
            nArray = CacheBuilderSpec$1.$SwitchMap$com$google$common$cache$LocalCache$Strength;
            n11 = localCache$Strength2.ordinal();
            if ((n11 = nArray[n11]) != n13) {
                object = new AssertionError();
                throw object;
            }
            ((CacheBuilder)object).weakKeys();
        }
        if ((localCache$Strength = this.valueStrength) != null) {
            nArray = CacheBuilderSpec$1.$SwitchMap$com$google$common$cache$LocalCache$Strength;
            n11 = localCache$Strength.ordinal();
            if ((n11 = nArray[n11]) != n13) {
                n13 = 2;
                if (n11 != n13) {
                    object = new AssertionError();
                    throw object;
                }
                ((CacheBuilder)object).softValues();
            } else {
                ((CacheBuilder)object).weakValues();
            }
        }
        if ((bl2 = this.recordStats) != null && (n11 = (int)(bl2.booleanValue() ? 1 : 0)) != 0) {
            ((CacheBuilder)object).recordStats();
        }
        if ((timeUnit3 = this.writeExpirationTimeUnit) != null) {
            l10 = this.writeExpirationDuration;
            ((CacheBuilder)object).expireAfterWrite(l10, timeUnit3);
        }
        if ((timeUnit2 = this.accessExpirationTimeUnit) != null) {
            l10 = this.accessExpirationDuration;
            ((CacheBuilder)object).expireAfterAccess(l10, timeUnit2);
        }
        if ((timeUnit = this.refreshTimeUnit) != null) {
            l10 = this.refreshDuration;
            ((CacheBuilder)object).refreshAfterWrite(l10, timeUnit);
        }
        return object;
    }

    public String toParsableString() {
        return this.specification;
    }

    public String toString() {
        MoreObjects$ToStringHelper moreObjects$ToStringHelper = MoreObjects.toStringHelper(this);
        String string2 = this.toParsableString();
        return moreObjects$ToStringHelper.addValue(string2).toString();
    }
}

