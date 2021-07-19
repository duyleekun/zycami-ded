/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.util;

import java.util.NoSuchElementException;

public final class IntArrayQueue {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private int[] data;
    private int headIndex = 0;
    private int size = 0;
    private int tailIndex = -1;
    private int wrapAroundMask;

    public IntArrayQueue() {
        int n10;
        int[] nArray = new int[16];
        this.data = nArray;
        this.wrapAroundMask = n10 = nArray.length + -1;
    }

    private void doubleArraySize() {
        Object object = this.data;
        int n10 = ((int[])object).length << 1;
        if (n10 >= 0) {
            int n11;
            int[] nArray = new int[n10];
            int n12 = ((int[])object).length;
            int n13 = this.headIndex;
            System.arraycopy(object, n13, nArray, 0, n12 -= n13);
            System.arraycopy(this.data, 0, nArray, n12, n13);
            this.headIndex = 0;
            this.tailIndex = n11 = this.size + -1;
            this.data = nArray;
            this.wrapAroundMask = n11 = nArray.length + -1;
            return;
        }
        object = new IllegalStateException;
        object();
        throw object;
    }

    public void add(int n10) {
        int n11 = this.size;
        int[] nArray = this.data;
        int n12 = nArray.length;
        if (n11 == n12) {
            this.doubleArraySize();
        }
        n11 = this.tailIndex + 1;
        n12 = this.wrapAroundMask;
        this.tailIndex = n11 &= n12;
        this.data[n11] = n10;
        this.size = n10 = this.size + 1;
    }

    public int capacity() {
        return this.data.length;
    }

    public void clear() {
        this.headIndex = 0;
        this.tailIndex = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        int n10 = this.size;
        n10 = n10 == 0 ? 1 : 0;
        return n10 != 0;
    }

    public int remove() {
        int n10 = this.size;
        if (n10 != 0) {
            int[] nArray = this.data;
            int n11 = this.headIndex;
            int n12 = nArray[n11];
            ++n11;
            int n13 = this.wrapAroundMask;
            this.headIndex = n11 &= n13;
            this.size = n10 += -1;
            return n12;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public int size() {
        return this.size;
    }
}

