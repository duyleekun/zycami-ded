/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.LongAddable;
import com.google.common.hash.LongAddables;
import com.google.common.math.LongMath;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLongArray;

public final class BloomFilterStrategies$LockFreeBitArray {
    private static final int LONG_ADDRESSABLE_BITS = 6;
    private final LongAddable bitCount;
    public final AtomicLongArray data;

    public BloomFilterStrategies$LockFreeBitArray(long l10) {
        LongAddable longAddable;
        AtomicLongArray atomicLongArray;
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 > 0) {
            l12 = 1;
        } else {
            l12 = 0;
            atomicLongArray = null;
        }
        Preconditions.checkArgument((boolean)l12, "data length is zero!");
        RoundingMode roundingMode = RoundingMode.CEILING;
        int n10 = Ints.checkedCast(LongMath.divide(l10, 64, roundingMode));
        this.data = atomicLongArray = new AtomicLongArray(n10);
        this.bitCount = longAddable = LongAddables.create();
    }

    public BloomFilterStrategies$LockFreeBitArray(long[] lArray) {
        Object object;
        int n10 = lArray.length;
        int n11 = 0;
        if (n10 > 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        String string2 = "data length is zero!";
        Preconditions.checkArgument(n10 != 0, string2);
        object = new AtomicLongArray(lArray);
        this.data = object;
        this.bitCount = object = LongAddables.create();
        long l10 = 0L;
        n10 = lArray.length;
        while (n11 < n10) {
            int n12 = Long.bitCount(lArray[n11]);
            long l11 = n12;
            l10 += l11;
            ++n11;
        }
        this.bitCount.add(l10);
    }

    public static long[] toPlainArray(AtomicLongArray atomicLongArray) {
        int n10 = atomicLongArray.length();
        long[] lArray = new long[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            long l10;
            lArray[i10] = l10 = atomicLongArray.get(i10);
        }
        return lArray;
    }

    public long bitCount() {
        return this.bitCount.sum();
    }

    public long bitSize() {
        return (long)this.data.length() * (long)64;
    }

    public BloomFilterStrategies$LockFreeBitArray copy() {
        long[] lArray = BloomFilterStrategies$LockFreeBitArray.toPlainArray(this.data);
        BloomFilterStrategies$LockFreeBitArray bloomFilterStrategies$LockFreeBitArray = new BloomFilterStrategies$LockFreeBitArray(lArray);
        return bloomFilterStrategies$LockFreeBitArray;
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof BloomFilterStrategies$LockFreeBitArray;
        if (bl2) {
            object = (BloomFilterStrategies$LockFreeBitArray)object;
            long[] lArray = BloomFilterStrategies$LockFreeBitArray.toPlainArray(this.data);
            object = BloomFilterStrategies$LockFreeBitArray.toPlainArray(((BloomFilterStrategies$LockFreeBitArray)object).data);
            return Arrays.equals(lArray, (long[])object);
        }
        return false;
    }

    /*
     * WARNING - void declaration
     */
    public boolean get(long l10) {
        void var9_10;
        AtomicLongArray atomicLongArray = this.data;
        long l11 = l10 >>> 6;
        int n10 = (int)l11;
        long l12 = atomicLongArray.get(n10);
        long l13 = 1L;
        int bl2 = (int)l10;
        long l14 = (l10 = l13 << bl2 & l12) - (l12 = 0L);
        Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object != false) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var9_10;
    }

    public int hashCode() {
        return Arrays.hashCode(BloomFilterStrategies$LockFreeBitArray.toPlainArray(this.data));
    }

    public void putAll(BloomFilterStrategies$LockFreeBitArray bloomFilterStrategies$LockFreeBitArray) {
        BloomFilterStrategies$LockFreeBitArray bloomFilterStrategies$LockFreeBitArray2 = this;
        BloomFilterStrategies$LockFreeBitArray bloomFilterStrategies$LockFreeBitArray3 = bloomFilterStrategies$LockFreeBitArray;
        AtomicLongArray atomicLongArray = this.data;
        int n10 = atomicLongArray.length();
        AtomicLongArray atomicLongArray2 = bloomFilterStrategies$LockFreeBitArray.data;
        int n11 = atomicLongArray2.length();
        int n12 = 1;
        if (n10 == n11) {
            n10 = n12;
        } else {
            n10 = 0;
            atomicLongArray = null;
        }
        atomicLongArray2 = bloomFilterStrategies$LockFreeBitArray2.data;
        n11 = atomicLongArray2.length();
        Object object = bloomFilterStrategies$LockFreeBitArray3.data;
        int n13 = ((AtomicLongArray)object).length();
        String string2 = "BitArrays must be of equal length (%s != %s)";
        Preconditions.checkArgument(n10 != 0, string2, n11, n13);
        atomicLongArray = null;
        for (n10 = 0; n10 < (n11 = (atomicLongArray2 = bloomFilterStrategies$LockFreeBitArray2.data).length()); ++n10) {
            long l10;
            long l11;
            block4: {
                AtomicLongArray atomicLongArray3;
                atomicLongArray2 = bloomFilterStrategies$LockFreeBitArray3.data;
                long l12 = atomicLongArray2.get(n10);
                do {
                    long l13;
                    if ((n11 = (int)((l13 = (l11 = (atomicLongArray2 = bloomFilterStrategies$LockFreeBitArray2.data).get(n10)) - (l10 = l11 | l12)) == 0L ? 0 : (l13 < 0L ? -1 : 1))) != 0) continue;
                    n11 = 0;
                    atomicLongArray2 = null;
                    break block4;
                } while ((n11 = (int)((atomicLongArray3 = bloomFilterStrategies$LockFreeBitArray2.data).compareAndSet(n10, l11, l10) ? 1 : 0)) == 0);
                n11 = n12;
            }
            if (n11 == 0) continue;
            n11 = Long.bitCount(l10);
            n13 = Long.bitCount(l11);
            object = bloomFilterStrategies$LockFreeBitArray2.bitCount;
            long l14 = n11 -= n13;
            object.add(l14);
        }
    }

    public boolean set(long l10) {
        long l11;
        long l12;
        AtomicLongArray atomicLongArray;
        long l13;
        int n10 = this.get(l10);
        if (n10 != 0) {
            return false;
        }
        n10 = (int)(l10 >>> 6);
        long l14 = 1L;
        int n11 = (int)l10;
        l10 = l14 << n11;
        do {
            AtomicLongArray atomicLongArray2;
            long l15;
            if ((l13 = (l15 = (l12 = (atomicLongArray2 = this.data).get(n10)) - (l11 = l12 | l10)) == 0L ? 0 : (l15 < 0L ? -1 : 1)) != false) continue;
            return false;
        } while ((l13 = (long)(atomicLongArray = this.data).compareAndSet(n10, l12, l11)) == false);
        this.bitCount.increment();
        return true;
    }
}

