/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.hash.BloomFilter$1;
import com.google.common.hash.BloomFilter$SerialForm;
import com.google.common.hash.BloomFilter$Strategy;
import com.google.common.hash.BloomFilterStrategies;
import com.google.common.hash.BloomFilterStrategies$LockFreeBitArray;
import com.google.common.hash.Funnel;
import com.google.common.math.DoubleMath;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.RoundingMode;
import java.util.concurrent.atomic.AtomicLongArray;

public final class BloomFilter
implements Predicate,
Serializable {
    private final BloomFilterStrategies$LockFreeBitArray bits;
    private final Funnel funnel;
    private final int numHashFunctions;
    private final BloomFilter$Strategy strategy;

    private BloomFilter(BloomFilterStrategies$LockFreeBitArray object, int n10, Funnel funnel, BloomFilter$Strategy bloomFilter$Strategy) {
        int n11 = 1;
        int n12 = n10 > 0 ? n11 : 0;
        String string2 = "numHashFunctions (%s) must be > 0";
        Preconditions.checkArgument(n12 != 0, string2, n10);
        n12 = 255;
        if (n10 > n12) {
            n11 = 0;
        }
        Preconditions.checkArgument(n11 != 0, "numHashFunctions (%s) must be <= 255", n10);
        object = (BloomFilterStrategies$LockFreeBitArray)Preconditions.checkNotNull(object);
        this.bits = object;
        this.numHashFunctions = n10;
        this.funnel = object = (Funnel)Preconditions.checkNotNull(funnel);
        this.strategy = object = (BloomFilter$Strategy)Preconditions.checkNotNull(bloomFilter$Strategy);
    }

    public /* synthetic */ BloomFilter(BloomFilterStrategies$LockFreeBitArray bloomFilterStrategies$LockFreeBitArray, int n10, Funnel funnel, BloomFilter$Strategy bloomFilter$Strategy, BloomFilter$1 bloomFilter$1) {
        this(bloomFilterStrategies$LockFreeBitArray, n10, funnel, bloomFilter$Strategy);
    }

    public static /* synthetic */ BloomFilterStrategies$LockFreeBitArray access$000(BloomFilter bloomFilter) {
        return bloomFilter.bits;
    }

    public static /* synthetic */ int access$100(BloomFilter bloomFilter) {
        return bloomFilter.numHashFunctions;
    }

    public static /* synthetic */ Funnel access$200(BloomFilter bloomFilter) {
        return bloomFilter.funnel;
    }

    public static /* synthetic */ BloomFilter$Strategy access$300(BloomFilter bloomFilter) {
        return bloomFilter.strategy;
    }

    public static BloomFilter create(Funnel funnel, int n10) {
        long l10 = n10;
        return BloomFilter.create(funnel, l10);
    }

    public static BloomFilter create(Funnel funnel, int n10, double d10) {
        long l10 = n10;
        return BloomFilter.create(funnel, l10, d10);
    }

    public static BloomFilter create(Funnel funnel, long l10) {
        return BloomFilter.create(funnel, l10, 0.03);
    }

    public static BloomFilter create(Funnel funnel, long l10, double d10) {
        BloomFilterStrategies bloomFilterStrategies = BloomFilterStrategies.MURMUR128_MITZ_64;
        return BloomFilter.create(funnel, l10, d10, bloomFilterStrategies);
    }

    public static BloomFilter create(Funnel funnel, long l10, double d10, BloomFilter$Strategy bloomFilter$Strategy) {
        Object object;
        BloomFilterStrategies$LockFreeBitArray bloomFilterStrategies$LockFreeBitArray;
        String string2;
        boolean bl2;
        Preconditions.checkNotNull(funnel);
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        boolean bl3 = true;
        Double d11 = null;
        if (l12 >= 0) {
            bl2 = bl3;
        } else {
            bl2 = false;
            string2 = null;
        }
        Object object2 = "Expected insertions (%s) must be >= 0";
        Preconditions.checkArgument(bl2, (String)object2, l10);
        double d12 = 0.0;
        bl2 = d10 == d12 ? 0 : (d10 > d12 ? 1 : -1);
        if (bl2 > false) {
            bl2 = bl3;
        } else {
            bl2 = false;
            string2 = null;
        }
        object2 = d10;
        String string3 = "False positive probability (%s) must be > 0.0";
        Preconditions.checkArgument(bl2, string3, object2);
        d12 = 1.0;
        bl2 = d10 == d12 ? 0 : (d10 < d12 ? -1 : 1);
        if (bl2 >= false) {
            bl3 = false;
        }
        d11 = d10;
        string2 = "False positive probability (%s) must be < 1.0";
        Preconditions.checkArgument(bl3, string2, (Object)d11);
        Preconditions.checkNotNull(bloomFilter$Strategy);
        if (l12 == false) {
            l10 = 1L;
        }
        long l13 = BloomFilter.optimalNumOfBits(l10, d10);
        int n10 = BloomFilter.optimalNumOfHashFunctions(l10, l13);
        try {
            bloomFilterStrategies$LockFreeBitArray = new BloomFilterStrategies$LockFreeBitArray(l13);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Could not create BloomFilter of ");
            ((StringBuilder)object).append(l13);
            ((StringBuilder)object).append(" bits");
            object = ((StringBuilder)object).toString();
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException((String)object, illegalArgumentException);
            throw illegalArgumentException2;
        }
        object = new BloomFilter(bloomFilterStrategies$LockFreeBitArray, n10, funnel, bloomFilter$Strategy);
        return object;
    }

    public static long optimalNumOfBits(long l10, double d10) {
        double d11 = 0.0;
        double d12 = d10 - d11;
        Object object = d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1);
        if (object == false) {
            d10 = Double.MIN_VALUE;
        }
        double d13 = -l10;
        d10 = Math.log(d10);
        d13 *= d10;
        d10 = 2.0;
        d11 = Math.log(d10);
        d10 = Math.log(d10);
        return (long)(d13 / (d11 *= d10));
    }

    public static int optimalNumOfHashFunctions(long l10, long l11) {
        double d10 = l11;
        double d11 = l10;
        d10 /= d11;
        d11 = Math.log(2.0);
        int n10 = (int)Math.round(d10 * d11);
        return Math.max(1, n10);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static BloomFilter readFrom(InputStream object, Funnel funnel) {
        void var1_5;
        int n10;
        int n11;
        Object object2;
        int n12;
        Object object3;
        block8: {
            Preconditions.checkNotNull(object, "InputStream");
            object3 = "Funnel";
            Preconditions.checkNotNull(funnel, object3);
            n12 = -1;
            try {
                object2 = new DataInputStream((InputStream)object);
                n11 = ((DataInputStream)object2).readByte();
            }
            catch (RuntimeException runtimeException) {
                n11 = n12;
                n10 = n12;
                break block8;
            }
            try {
                n10 = ((DataInputStream)object2).readByte();
                n10 = UnsignedBytes.toInt((byte)n10);
            }
            catch (RuntimeException runtimeException) {
                n10 = n12;
                n12 = n11;
                n11 = n10;
                break block8;
            }
            try {
                n12 = ((DataInputStream)object2).readInt();
                Object object4 = BloomFilterStrategies.values();
                object4 = object4[n11];
                long[] lArray = new long[n12];
                int i10 = 0;
                BloomFilterStrategies$LockFreeBitArray bloomFilterStrategies$LockFreeBitArray = null;
                while (true) {
                    long l10;
                    if (i10 >= n12) {
                        bloomFilterStrategies$LockFreeBitArray = new BloomFilterStrategies$LockFreeBitArray(lArray);
                        return new BloomFilter(bloomFilterStrategies$LockFreeBitArray, n10, funnel, (BloomFilter$Strategy)object4);
                    }
                    lArray[i10] = l10 = ((DataInputStream)object2).readLong();
                    ++i10;
                }
            }
            catch (RuntimeException runtimeException) {
                int n13 = n12;
                n12 = n11;
                n11 = n13;
            }
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: ");
        ((StringBuilder)object2).append(n12);
        ((StringBuilder)object2).append(" numHashFunctions: ");
        ((StringBuilder)object2).append(n10);
        ((StringBuilder)object2).append(" dataLength: ");
        ((StringBuilder)object2).append(n11);
        object = ((StringBuilder)object2).toString();
        object3 = new IOException((String)object, (Throwable)var1_5);
        throw object3;
    }

    private Object writeReplace() {
        BloomFilter$SerialForm bloomFilter$SerialForm = new BloomFilter$SerialForm(this);
        return bloomFilter$SerialForm;
    }

    public boolean apply(Object object) {
        return this.mightContain(object);
    }

    public long approximateElementCount() {
        long l10 = this.bits.bitSize();
        double d10 = this.bits.bitCount();
        double d11 = l10;
        d10 = -Math.log1p(-(d10 / d11)) * d11;
        d11 = this.numHashFunctions;
        RoundingMode roundingMode = RoundingMode.HALF_UP;
        return DoubleMath.roundToLong(d10 /= d11, roundingMode);
    }

    public long bitSize() {
        return this.bits.bitSize();
    }

    public BloomFilter copy() {
        BloomFilterStrategies$LockFreeBitArray bloomFilterStrategies$LockFreeBitArray = this.bits.copy();
        int n10 = this.numHashFunctions;
        Funnel funnel = this.funnel;
        BloomFilter$Strategy bloomFilter$Strategy = this.strategy;
        BloomFilter bloomFilter = new BloomFilter(bloomFilterStrategies$LockFreeBitArray, n10, funnel, bloomFilter$Strategy);
        return bloomFilter;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        int n10 = object instanceof BloomFilter;
        if (n10 != 0) {
            boolean bl3;
            Object object2;
            Object object3;
            object = (BloomFilter)object;
            n10 = this.numHashFunctions;
            int n11 = ((BloomFilter)object).numHashFunctions;
            if (n10 != n11 || (n10 = (int)((object3 = this.funnel).equals(object2 = ((BloomFilter)object).funnel) ? 1 : 0)) == 0 || (n10 = (int)(((BloomFilterStrategies$LockFreeBitArray)(object3 = this.bits)).equals(object2 = ((BloomFilter)object).bits) ? 1 : 0)) == 0 || !(bl3 = (object3 = this.strategy).equals(object = ((BloomFilter)object).strategy))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public double expectedFpp() {
        double d10 = this.bits.bitCount();
        double d11 = this.bitSize();
        d10 /= d11;
        d11 = this.numHashFunctions;
        return Math.pow(d10, d11);
    }

    public int hashCode() {
        Object object = this.numHashFunctions;
        Object[] objectArray = new Object[]{object, object = this.funnel, object = this.strategy, object = this.bits};
        return Objects.hashCode(objectArray);
    }

    public boolean isCompatible(BloomFilter serializable) {
        boolean bl2;
        BloomFilter$Strategy bloomFilter$Strategy;
        Serializable serializable2;
        long l10;
        long l11;
        long l12;
        int n10;
        int n11;
        Preconditions.checkNotNull(serializable);
        if (this != serializable && (n11 = this.numHashFunctions) == (n10 = serializable.numHashFunctions) && (n11 = (int)((l12 = (l11 = this.bitSize()) - (l10 = serializable.bitSize())) == 0L ? 0 : (l12 < 0L ? -1 : 1))) == 0 && (n11 = (int)((serializable2 = this.strategy).equals(bloomFilter$Strategy = serializable.strategy) ? 1 : 0)) != 0 && (bl2 = (serializable2 = this.funnel).equals(serializable = serializable.funnel))) {
            bl2 = true;
        } else {
            bl2 = false;
            serializable = null;
        }
        return bl2;
    }

    public boolean mightContain(Object object) {
        BloomFilter$Strategy bloomFilter$Strategy = this.strategy;
        Funnel funnel = this.funnel;
        int n10 = this.numHashFunctions;
        BloomFilterStrategies$LockFreeBitArray bloomFilterStrategies$LockFreeBitArray = this.bits;
        return bloomFilter$Strategy.mightContain(object, funnel, n10, bloomFilterStrategies$LockFreeBitArray);
    }

    public boolean put(Object object) {
        BloomFilter$Strategy bloomFilter$Strategy = this.strategy;
        Funnel funnel = this.funnel;
        int n10 = this.numHashFunctions;
        BloomFilterStrategies$LockFreeBitArray bloomFilterStrategies$LockFreeBitArray = this.bits;
        return bloomFilter$Strategy.put(object, funnel, n10, bloomFilterStrategies$LockFreeBitArray);
    }

    /*
     * WARNING - void declaration
     */
    public void putAll(BloomFilter object) {
        void var7_14;
        void var4_6;
        Serializable serializable;
        Preconditions.checkNotNull(object);
        boolean bl3 = true;
        Serializable serializable2 = null;
        if (this != object) {
            boolean bl2 = bl3;
        } else {
            boolean bl2 = false;
            serializable = null;
        }
        String string2 = "Cannot combine a BloomFilter with itself.";
        Preconditions.checkArgument((boolean)var4_6, string2);
        int n10 = this.numHashFunctions;
        int n11 = ((BloomFilter)object).numHashFunctions;
        boolean bl4 = n10 == n11 ? bl3 : false;
        String string3 = "BloomFilters must have the same number of hash functions (%s != %s)";
        Preconditions.checkArgument(bl4, string3, n10, n11);
        long l10 = this.bitSize();
        long l11 = ((BloomFilter)object).bitSize();
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 == false) {
            boolean bl5 = bl3;
        } else {
            boolean bl6 = false;
            string2 = null;
        }
        long l13 = this.bitSize();
        long l14 = ((BloomFilter)object).bitSize();
        Preconditions.checkArgument((boolean)var7_14, "BloomFilters must have the same size underlying bit arrays (%s != %s)", l13, l14);
        Object object2 = this.strategy;
        serializable2 = ((BloomFilter)object).strategy;
        bl3 = object2.equals(serializable2);
        serializable2 = this.strategy;
        serializable = ((BloomFilter)object).strategy;
        Preconditions.checkArgument(bl3, "BloomFilters must have equal strategies (%s != %s)", (Object)serializable2, (Object)serializable);
        object2 = this.funnel;
        serializable2 = ((BloomFilter)object).funnel;
        bl3 = object2.equals(serializable2);
        serializable2 = this.funnel;
        serializable = ((BloomFilter)object).funnel;
        Preconditions.checkArgument(bl3, "BloomFilters must have equal funnels (%s != %s)", (Object)serializable2, (Object)serializable);
        object2 = this.bits;
        object = ((BloomFilter)object).bits;
        ((BloomFilterStrategies$LockFreeBitArray)object2).putAll((BloomFilterStrategies$LockFreeBitArray)object);
    }

    public void writeTo(OutputStream outputStream) {
        AtomicLongArray atomicLongArray;
        int n10;
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        int n11 = SignedBytes.checkedCast(this.strategy.ordinal());
        dataOutputStream.writeByte(n11);
        long l10 = this.numHashFunctions;
        n11 = UnsignedBytes.checkedCast(l10);
        dataOutputStream.writeByte(n11);
        n11 = this.bits.data.length();
        dataOutputStream.writeInt(n11);
        outputStream = null;
        for (n11 = 0; n11 < (n10 = (atomicLongArray = this.bits.data).length()); ++n11) {
            atomicLongArray = this.bits.data;
            l10 = atomicLongArray.get(n11);
            dataOutputStream.writeLong(l10);
        }
    }
}

