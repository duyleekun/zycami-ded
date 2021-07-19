/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.BloomFilter$Strategy;
import com.google.common.hash.BloomFilterStrategies$LockFreeBitArray;
import com.google.common.hash.Funnel;
import java.io.Serializable;

public class BloomFilter$SerialForm
implements Serializable {
    private static final long serialVersionUID = 1L;
    public final long[] data;
    public final Funnel funnel;
    public final int numHashFunctions;
    public final BloomFilter$Strategy strategy;

    public BloomFilter$SerialForm(BloomFilter serializable) {
        int n10;
        Object object = BloomFilterStrategies$LockFreeBitArray.toPlainArray(BloomFilter.access$000((BloomFilter)serializable).data);
        this.data = object;
        this.numHashFunctions = n10 = BloomFilter.access$100(serializable);
        object = BloomFilter.access$200(serializable);
        this.funnel = object;
        serializable = BloomFilter.access$300(serializable);
        this.strategy = serializable;
    }

    public Object readResolve() {
        BloomFilter bloomFilter;
        Object object = this.data;
        BloomFilterStrategies$LockFreeBitArray bloomFilterStrategies$LockFreeBitArray = new BloomFilterStrategies$LockFreeBitArray((long[])object);
        int n10 = this.numHashFunctions;
        Funnel funnel = this.funnel;
        BloomFilter$Strategy bloomFilter$Strategy = this.strategy;
        object = bloomFilter;
        bloomFilter = new BloomFilter(bloomFilterStrategies$LockFreeBitArray, n10, funnel, bloomFilter$Strategy, null);
        return bloomFilter;
    }
}

