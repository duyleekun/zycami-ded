/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.base.Equivalence;
import com.google.common.cache.LocalCache$1;
import com.google.common.cache.LocalCache$Segment;
import com.google.common.cache.LocalCache$Strength$1;
import com.google.common.cache.LocalCache$Strength$2;
import com.google.common.cache.LocalCache$Strength$3;
import com.google.common.cache.LocalCache$ValueReference;
import com.google.common.cache.ReferenceEntry;

public abstract class LocalCache$Strength
extends Enum {
    private static final /* synthetic */ LocalCache$Strength[] $VALUES;
    public static final /* enum */ LocalCache$Strength SOFT;
    public static final /* enum */ LocalCache$Strength STRONG;
    public static final /* enum */ LocalCache$Strength WEAK;

    static {
        LocalCache$Strength$1 localCache$Strength$1 = new LocalCache$Strength$1();
        STRONG = localCache$Strength$1;
        int n10 = 1;
        LocalCache$Strength$2 localCache$Strength$2 = new LocalCache$Strength$2();
        SOFT = localCache$Strength$2;
        int n11 = 2;
        LocalCache$Strength$3 localCache$Strength$3 = new LocalCache$Strength$3();
        WEAK = localCache$Strength$3;
        LocalCache$Strength[] localCache$StrengthArray = new LocalCache$Strength[3];
        localCache$StrengthArray[0] = localCache$Strength$1;
        localCache$StrengthArray[n10] = localCache$Strength$2;
        localCache$StrengthArray[n11] = localCache$Strength$3;
        $VALUES = localCache$StrengthArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private LocalCache$Strength() {
        void var2_-1;
        void var1_-1;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public /* synthetic */ LocalCache$Strength(LocalCache$1 localCache$1) {
        this((String)var1_-1, (int)var2_1);
        void var2_1;
        void var1_-1;
    }

    public static LocalCache$Strength valueOf(String string2) {
        return Enum.valueOf(LocalCache$Strength.class, string2);
    }

    public static LocalCache$Strength[] values() {
        return (LocalCache$Strength[])$VALUES.clone();
    }

    public abstract Equivalence defaultEquivalence();

    public abstract LocalCache$ValueReference referenceValue(LocalCache$Segment var1, ReferenceEntry var2, Object var3, int var4);
}

