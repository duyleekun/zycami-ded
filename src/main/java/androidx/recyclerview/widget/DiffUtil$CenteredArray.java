/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import java.util.Arrays;

public class DiffUtil$CenteredArray {
    private final int[] mData;
    private final int mMid;

    public DiffUtil$CenteredArray(int n10) {
        int[] nArray = new int[n10];
        this.mData = nArray;
        this.mMid = n10 = nArray.length / 2;
    }

    public int[] backingData() {
        return this.mData;
    }

    public void fill(int n10) {
        Arrays.fill(this.mData, n10);
    }

    public int get(int n10) {
        int[] nArray = this.mData;
        int n11 = this.mMid;
        return nArray[n10 += n11];
    }

    public void set(int n10, int n11) {
        int[] nArray = this.mData;
        int n12 = this.mMid;
        nArray[n10 += n12] = n11;
    }
}

