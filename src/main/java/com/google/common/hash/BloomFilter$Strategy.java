/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.hash.BloomFilterStrategies$LockFreeBitArray;
import com.google.common.hash.Funnel;
import java.io.Serializable;

public interface BloomFilter$Strategy
extends Serializable {
    public boolean mightContain(Object var1, Funnel var2, int var3, BloomFilterStrategies$LockFreeBitArray var4);

    public int ordinal();

    public boolean put(Object var1, Funnel var2, int var3, BloomFilterStrategies$LockFreeBitArray var4);
}

