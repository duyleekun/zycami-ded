/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.hash.BloomFilterStrategies;
import com.google.common.hash.BloomFilterStrategies$LockFreeBitArray;
import com.google.common.hash.Funnel;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.google.common.primitives.Longs;

public final class BloomFilterStrategies$2
extends BloomFilterStrategies {
    private long lowerEight(byte[] byArray) {
        byte by2 = byArray[7];
        byte by3 = byArray[6];
        byte by4 = byArray[5];
        byte by5 = byArray[4];
        byte by6 = byArray[3];
        byte by7 = byArray[2];
        byte by8 = byArray[1];
        byte by9 = byArray[0];
        return Longs.fromBytes(by2, by3, by4, by5, by6, by7, by8, by9);
    }

    private long upperEight(byte[] byArray) {
        byte by2 = byArray[15];
        byte by3 = byArray[14];
        byte by4 = byArray[13];
        byte by5 = byArray[12];
        byte by6 = byArray[11];
        byte by7 = byArray[10];
        byte by8 = byArray[9];
        byte by9 = byArray[8];
        return Longs.fromBytes(by2, by3, by4, by5, by6, by7, by8, by9);
    }

    public boolean mightContain(Object object, Funnel funnel, int n10, BloomFilterStrategies$LockFreeBitArray bloomFilterStrategies$LockFreeBitArray) {
        long l10 = bloomFilterStrategies$LockFreeBitArray.bitSize();
        HashFunction hashFunction = Hashing.murmur3_128();
        object = hashFunction.hashObject(object, funnel).getBytesInternal();
        long l11 = this.lowerEight((byte[])object);
        long l12 = this.upperEight((byte[])object);
        for (int i10 = 0; i10 < n10; ++i10) {
            long l13 = (Long.MAX_VALUE & l11) % l10;
            boolean bl2 = bloomFilterStrategies$LockFreeBitArray.get(l13);
            if (!bl2) {
                return false;
            }
            l11 += l12;
        }
        return true;
    }

    public boolean put(Object object, Funnel funnel, int n10, BloomFilterStrategies$LockFreeBitArray bloomFilterStrategies$LockFreeBitArray) {
        long l10 = bloomFilterStrategies$LockFreeBitArray.bitSize();
        HashFunction hashFunction = Hashing.murmur3_128();
        object = hashFunction.hashObject(object, funnel).getBytesInternal();
        long l11 = this.lowerEight((byte[])object);
        long l12 = this.upperEight((byte[])object);
        boolean bl2 = false;
        for (int i10 = 0; i10 < n10; ++i10) {
            long l13 = (Long.MAX_VALUE & l11) % l10;
            boolean bl3 = bloomFilterStrategies$LockFreeBitArray.set(l13);
            bl2 |= bl3;
            l11 += l12;
        }
        return bl2;
    }
}

