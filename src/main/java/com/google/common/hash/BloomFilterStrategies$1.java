/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.hash.BloomFilterStrategies;
import com.google.common.hash.BloomFilterStrategies$LockFreeBitArray;
import com.google.common.hash.Funnel;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

public final class BloomFilterStrategies$1
extends BloomFilterStrategies {
    public boolean mightContain(Object object, Funnel funnel, int n10, BloomFilterStrategies$LockFreeBitArray bloomFilterStrategies$LockFreeBitArray) {
        int n11;
        long l10 = bloomFilterStrategies$LockFreeBitArray.bitSize();
        HashFunction hashFunction = Hashing.murmur3_128();
        object = hashFunction.hashObject(object, funnel);
        long l11 = ((HashCode)object).asLong();
        int n12 = (int)l11;
        int n13 = (int)(l11 >>>= 32);
        for (int i10 = n11 = 1; i10 <= n10; ++i10) {
            long l12;
            int n14 = i10 * n13 + n12;
            if (n14 < 0) {
                n14 ^= 0xFFFFFFFF;
            }
            if ((n14 = (int)(bloomFilterStrategies$LockFreeBitArray.get(l12 = (long)n14 % l10) ? 1 : 0)) != 0) continue;
            return false;
        }
        return n11 != 0;
    }

    public boolean put(Object object, Funnel funnel, int n10, BloomFilterStrategies$LockFreeBitArray bloomFilterStrategies$LockFreeBitArray) {
        long l10 = bloomFilterStrategies$LockFreeBitArray.bitSize();
        HashFunction hashFunction = Hashing.murmur3_128();
        object = hashFunction.hashObject(object, funnel);
        long l11 = ((HashCode)object).asLong();
        int n11 = (int)l11;
        int n12 = (int)(l11 >>>= 32);
        int n13 = 0;
        for (int i10 = 1; i10 <= n10; ++i10) {
            int n14 = i10 * n12 + n11;
            if (n14 < 0) {
                n14 ^= 0xFFFFFFFF;
            }
            long l12 = (long)n14 % l10;
            n14 = (int)(bloomFilterStrategies$LockFreeBitArray.set(l12) ? 1 : 0);
            n13 |= n14;
        }
        return n13 != 0;
    }
}

