/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects$ToStringHelper;
import com.google.common.base.Preconditions;
import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$Strength;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class MapMaker {
    private static final int DEFAULT_CONCURRENCY_LEVEL = 4;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    public static final int UNSET_INT = 255;
    public int concurrencyLevel;
    public int initialCapacity;
    public Equivalence keyEquivalence;
    public MapMakerInternalMap$Strength keyStrength;
    public boolean useCustomMap;
    public MapMakerInternalMap$Strength valueStrength;

    public MapMaker() {
        int n10;
        this.initialCapacity = n10 = -1;
        this.concurrencyLevel = n10;
    }

    /*
     * WARNING - void declaration
     */
    public MapMaker concurrencyLevel(int n10) {
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

    public int getConcurrencyLevel() {
        int n10 = this.concurrencyLevel;
        int n11 = -1;
        if (n10 == n11) {
            n10 = 4;
        }
        return n10;
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

    public MapMakerInternalMap$Strength getKeyStrength() {
        MapMakerInternalMap$Strength mapMakerInternalMap$Strength = this.keyStrength;
        MapMakerInternalMap$Strength mapMakerInternalMap$Strength2 = MapMakerInternalMap$Strength.STRONG;
        return (MapMakerInternalMap$Strength)((Object)MoreObjects.firstNonNull((Object)mapMakerInternalMap$Strength, (Object)mapMakerInternalMap$Strength2));
    }

    public MapMakerInternalMap$Strength getValueStrength() {
        MapMakerInternalMap$Strength mapMakerInternalMap$Strength = this.valueStrength;
        MapMakerInternalMap$Strength mapMakerInternalMap$Strength2 = MapMakerInternalMap$Strength.STRONG;
        return (MapMakerInternalMap$Strength)((Object)MoreObjects.firstNonNull((Object)mapMakerInternalMap$Strength, (Object)mapMakerInternalMap$Strength2));
    }

    /*
     * WARNING - void declaration
     */
    public MapMaker initialCapacity(int n10) {
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

    public MapMaker keyEquivalence(Equivalence equivalence) {
        Equivalence equivalence2 = this.keyEquivalence;
        boolean bl2 = true;
        boolean bl3 = equivalence2 == null ? bl2 : false;
        Preconditions.checkState(bl3, "key equivalence was already set to %s", (Object)equivalence2);
        this.keyEquivalence = equivalence = (Equivalence)Preconditions.checkNotNull(equivalence);
        this.useCustomMap = bl2;
        return this;
    }

    public ConcurrentMap makeMap() {
        boolean bl2 = this.useCustomMap;
        if (!bl2) {
            int n10 = this.getInitialCapacity();
            int n11 = this.getConcurrencyLevel();
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(n10, 0.75f, n11);
            return concurrentHashMap;
        }
        return MapMakerInternalMap.create(this);
    }

    public MapMaker setKeyStrength(MapMakerInternalMap$Strength mapMakerInternalMap$Strength) {
        MapMakerInternalMap$Strength mapMakerInternalMap$Strength2 = this.keyStrength;
        boolean bl2 = true;
        boolean bl3 = mapMakerInternalMap$Strength2 == null ? bl2 : false;
        String string2 = "Key strength was already set to %s";
        Preconditions.checkState(bl3, string2, (Object)mapMakerInternalMap$Strength2);
        this.keyStrength = mapMakerInternalMap$Strength2 = (MapMakerInternalMap$Strength)((Object)Preconditions.checkNotNull((Object)mapMakerInternalMap$Strength));
        mapMakerInternalMap$Strength2 = MapMakerInternalMap$Strength.STRONG;
        if (mapMakerInternalMap$Strength != mapMakerInternalMap$Strength2) {
            this.useCustomMap = bl2;
        }
        return this;
    }

    public MapMaker setValueStrength(MapMakerInternalMap$Strength mapMakerInternalMap$Strength) {
        MapMakerInternalMap$Strength mapMakerInternalMap$Strength2 = this.valueStrength;
        boolean bl2 = true;
        boolean bl3 = mapMakerInternalMap$Strength2 == null ? bl2 : false;
        String string2 = "Value strength was already set to %s";
        Preconditions.checkState(bl3, string2, (Object)mapMakerInternalMap$Strength2);
        this.valueStrength = mapMakerInternalMap$Strength2 = (MapMakerInternalMap$Strength)((Object)Preconditions.checkNotNull((Object)mapMakerInternalMap$Strength));
        mapMakerInternalMap$Strength2 = MapMakerInternalMap$Strength.STRONG;
        if (mapMakerInternalMap$Strength != mapMakerInternalMap$Strength2) {
            this.useCustomMap = bl2;
        }
        return this;
    }

    public String toString() {
        Object object;
        String string2;
        MoreObjects$ToStringHelper moreObjects$ToStringHelper = MoreObjects.toStringHelper(this);
        int n10 = this.initialCapacity;
        int n11 = -1;
        if (n10 != n11) {
            String string3 = "initialCapacity";
            moreObjects$ToStringHelper.add(string3, n10);
        }
        if ((n10 = this.concurrencyLevel) != n11) {
            string2 = "concurrencyLevel";
            moreObjects$ToStringHelper.add(string2, n10);
        }
        if ((object = this.keyStrength) != null) {
            object = Ascii.toLowerCase(((Enum)object).toString());
            string2 = "keyStrength";
            moreObjects$ToStringHelper.add(string2, object);
        }
        if ((object = this.valueStrength) != null) {
            object = Ascii.toLowerCase(((Enum)object).toString());
            string2 = "valueStrength";
            moreObjects$ToStringHelper.add(string2, object);
        }
        if ((object = this.keyEquivalence) != null) {
            object = "keyEquivalence";
            moreObjects$ToStringHelper.addValue(object);
        }
        return moreObjects$ToStringHelper.toString();
    }

    public MapMaker weakKeys() {
        MapMakerInternalMap$Strength mapMakerInternalMap$Strength = MapMakerInternalMap$Strength.WEAK;
        return this.setKeyStrength(mapMakerInternalMap$Strength);
    }

    public MapMaker weakValues() {
        MapMakerInternalMap$Strength mapMakerInternalMap$Strength = MapMakerInternalMap$Strength.WEAK;
        return this.setValueStrength(mapMakerInternalMap$Strength);
    }
}

