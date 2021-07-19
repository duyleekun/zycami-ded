/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.util;

import java.util.Arrays;

public final class LongArray {
    private static final int DEFAULT_INITIAL_CAPACITY = 32;
    private int size;
    private long[] values;

    public LongArray() {
        this(32);
    }

    public LongArray(int n10) {
        long[] lArray = new long[n10];
        this.values = lArray;
    }

    public void add(long l10) {
        long[] lArray;
        int n10 = this.size;
        long[] lArray2 = this.values;
        int n11 = lArray2.length;
        if (n10 == n11) {
            this.values = lArray = Arrays.copyOf(lArray2, n10 *= 2);
        }
        lArray = this.values;
        int n12 = this.size;
        this.size = n11 = n12 + 1;
        lArray[n12] = l10;
    }

    public long get(int n10) {
        int n11;
        if (n10 >= 0 && n10 < (n11 = this.size)) {
            return this.values[n10];
        }
        int n12 = this.size;
        StringBuilder stringBuilder = new StringBuilder(46);
        stringBuilder.append("Invalid index ");
        stringBuilder.append(n10);
        stringBuilder.append(", size is ");
        stringBuilder.append(n12);
        String string2 = stringBuilder.toString();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }

    public int size() {
        return this.size;
    }

    public long[] toArray() {
        long[] lArray = this.values;
        int n10 = this.size;
        return Arrays.copyOf(lArray, n10);
    }
}

