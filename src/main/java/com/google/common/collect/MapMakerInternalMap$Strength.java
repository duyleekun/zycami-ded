/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.collect.MapMakerInternalMap$1;
import com.google.common.collect.MapMakerInternalMap$Strength$1;
import com.google.common.collect.MapMakerInternalMap$Strength$2;

public abstract class MapMakerInternalMap$Strength
extends Enum {
    private static final /* synthetic */ MapMakerInternalMap$Strength[] $VALUES;
    public static final /* enum */ MapMakerInternalMap$Strength STRONG;
    public static final /* enum */ MapMakerInternalMap$Strength WEAK;

    static {
        MapMakerInternalMap$Strength$1 mapMakerInternalMap$Strength$1 = new MapMakerInternalMap$Strength$1();
        STRONG = mapMakerInternalMap$Strength$1;
        int n10 = 1;
        MapMakerInternalMap$Strength$2 mapMakerInternalMap$Strength$2 = new MapMakerInternalMap$Strength$2();
        WEAK = mapMakerInternalMap$Strength$2;
        MapMakerInternalMap$Strength[] mapMakerInternalMap$StrengthArray = new MapMakerInternalMap$Strength[2];
        mapMakerInternalMap$StrengthArray[0] = mapMakerInternalMap$Strength$1;
        mapMakerInternalMap$StrengthArray[n10] = mapMakerInternalMap$Strength$2;
        $VALUES = mapMakerInternalMap$StrengthArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private MapMakerInternalMap$Strength() {
        void var2_-1;
        void var1_-1;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public /* synthetic */ MapMakerInternalMap$Strength(MapMakerInternalMap$1 mapMakerInternalMap$1) {
        this((String)var1_-1, (int)var2_1);
        void var2_1;
        void var1_-1;
    }

    public static MapMakerInternalMap$Strength valueOf(String string2) {
        return Enum.valueOf(MapMakerInternalMap$Strength.class, string2);
    }

    public static MapMakerInternalMap$Strength[] values() {
        return (MapMakerInternalMap$Strength[])$VALUES.clone();
    }

    public abstract Equivalence defaultEquivalence();
}

