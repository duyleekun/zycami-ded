/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.primitives.ImmutableLongArray;
import com.google.common.primitives.ImmutableLongArray$Builder;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLongArray;

public class AtomicDoubleArray
implements Serializable {
    private static final long serialVersionUID;
    private transient AtomicLongArray longs;

    public AtomicDoubleArray(int n10) {
        AtomicLongArray atomicLongArray;
        this.longs = atomicLongArray = new AtomicLongArray(n10);
    }

    public AtomicDoubleArray(double[] object) {
        int n10 = ((double[])object).length;
        long[] lArray = new long[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            long l10;
            double d10 = object[i10];
            lArray[i10] = l10 = Double.doubleToRawLongBits(d10);
        }
        object = new AtomicLongArray;
        super(lArray);
        this.longs = object;
    }

    private void readObject(ObjectInputStream object) {
        ((ObjectInputStream)object).defaultReadObject();
        int n10 = ((ObjectInputStream)object).readInt();
        ImmutableLongArray$Builder immutableLongArray$Builder = ImmutableLongArray.builder();
        for (int i10 = 0; i10 < n10; ++i10) {
            double d10 = ((ObjectInputStream)object).readDouble();
            long l10 = Double.doubleToRawLongBits(d10);
            immutableLongArray$Builder.add(l10);
        }
        long[] lArray = immutableLongArray$Builder.build().toArray();
        this.longs = object = new AtomicLongArray(lArray);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        int n10 = this.length();
        objectOutputStream.writeInt(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            double d10 = this.get(i10);
            objectOutputStream.writeDouble(d10);
        }
    }

    public double addAndGet(int n10, double d10) {
        double d11;
        double d12;
        long l10;
        AtomicLongArray atomicLongArray;
        long l11;
        AtomicLongArray atomicLongArray2;
        boolean bl2;
        while (!(bl2 = (atomicLongArray2 = this.longs).compareAndSet(n10, l11 = (atomicLongArray = this.longs).get(n10), l10 = Double.doubleToRawLongBits(d12 = (d11 = Double.longBitsToDouble(l11)) + d10)))) {
        }
        return d12;
    }

    public final boolean compareAndSet(int n10, double d10, double d11) {
        AtomicLongArray atomicLongArray = this.longs;
        long l10 = Double.doubleToRawLongBits(d10);
        long l11 = Double.doubleToRawLongBits(d11);
        return atomicLongArray.compareAndSet(n10, l10, l11);
    }

    public final double get(int n10) {
        return Double.longBitsToDouble(this.longs.get(n10));
    }

    public final double getAndAdd(int n10, double d10) {
        double d11;
        double d12;
        long l10;
        AtomicLongArray atomicLongArray;
        long l11;
        AtomicLongArray atomicLongArray2;
        boolean bl2;
        while (!(bl2 = (atomicLongArray2 = this.longs).compareAndSet(n10, l11 = (atomicLongArray = this.longs).get(n10), l10 = Double.doubleToRawLongBits(d12 = (d11 = Double.longBitsToDouble(l11)) + d10)))) {
        }
        return d11;
    }

    public final double getAndSet(int n10, double d10) {
        long l10 = Double.doubleToRawLongBits(d10);
        return Double.longBitsToDouble(this.longs.getAndSet(n10, l10));
    }

    public final void lazySet(int n10, double d10) {
        long l10 = Double.doubleToRawLongBits(d10);
        this.longs.lazySet(n10, l10);
    }

    public final int length() {
        return this.longs.length();
    }

    public final void set(int n10, double d10) {
        long l10 = Double.doubleToRawLongBits(d10);
        this.longs.set(n10, l10);
    }

    public String toString() {
        int n10;
        int n11 = this.length() + -1;
        if (n11 == (n10 = -1)) {
            return "[]";
        }
        int n12 = (n11 + 1) * 19;
        StringBuilder stringBuilder = new StringBuilder(n12);
        stringBuilder.append('[');
        n12 = 0;
        while (true) {
            AtomicLongArray atomicLongArray = this.longs;
            long l10 = atomicLongArray.get(n12);
            double d10 = Double.longBitsToDouble(l10);
            stringBuilder.append(d10);
            if (n12 == n11) {
                stringBuilder.append(']');
                return stringBuilder.toString();
            }
            stringBuilder.append(',');
            char c10 = ' ';
            stringBuilder.append(c10);
            ++n12;
        }
    }

    public final boolean weakCompareAndSet(int n10, double d10, double d11) {
        AtomicLongArray atomicLongArray = this.longs;
        long l10 = Double.doubleToRawLongBits(d10);
        long l11 = Double.doubleToRawLongBits(d11);
        return atomicLongArray.weakCompareAndSet(n10, l10, l11);
    }
}

