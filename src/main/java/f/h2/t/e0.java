/*
 * Decompiled with CFR 0.151.
 */
package f.h2.t;

import f.h2.t.f0;
import f.h2.t.m0;

public final class e0
extends m0 {
    private final int[] d;

    public e0(int n10) {
        super(n10);
        int[] nArray = new int[n10];
        this.d = nArray;
    }

    public final void h(int n10) {
        int[] nArray = this.d;
        int n11 = this.b();
        int n12 = n11 + 1;
        this.e(n12);
        nArray[n11] = n10;
    }

    public int i(int[] nArray) {
        f0.p(nArray, "$this$getSize");
        return nArray.length;
    }

    public final int[] j() {
        int[] nArray = this.d;
        int[] nArray2 = new int[this.f()];
        return (int[])this.g(nArray, nArray2);
    }
}

