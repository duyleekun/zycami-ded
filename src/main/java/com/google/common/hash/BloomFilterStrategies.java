/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.hash.BloomFilter$Strategy;
import com.google.common.hash.BloomFilterStrategies$1;
import com.google.common.hash.BloomFilterStrategies$2;

public abstract class BloomFilterStrategies
extends Enum
implements BloomFilter$Strategy {
    private static final /* synthetic */ BloomFilterStrategies[] $VALUES;
    public static final /* enum */ BloomFilterStrategies MURMUR128_MITZ_32;
    public static final /* enum */ BloomFilterStrategies MURMUR128_MITZ_64;

    static {
        BloomFilterStrategies$1 bloomFilterStrategies$1 = new BloomFilterStrategies$1();
        MURMUR128_MITZ_32 = bloomFilterStrategies$1;
        int n10 = 1;
        BloomFilterStrategies$2 bloomFilterStrategies$2 = new BloomFilterStrategies$2();
        MURMUR128_MITZ_64 = bloomFilterStrategies$2;
        BloomFilterStrategies[] bloomFilterStrategiesArray = new BloomFilterStrategies[2];
        bloomFilterStrategiesArray[0] = bloomFilterStrategies$1;
        bloomFilterStrategiesArray[n10] = bloomFilterStrategies$2;
        $VALUES = bloomFilterStrategiesArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private BloomFilterStrategies() {
        void var2_-1;
        void var1_-1;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public /* synthetic */ BloomFilterStrategies(BloomFilterStrategies$1 varnull) {
        this((String)var1_-1, (int)var2_1);
        void var2_1;
        void var1_-1;
    }

    public static BloomFilterStrategies valueOf(String string2) {
        return Enum.valueOf(BloomFilterStrategies.class, string2);
    }

    public static BloomFilterStrategies[] values() {
        return (BloomFilterStrategies[])$VALUES.clone();
    }
}

