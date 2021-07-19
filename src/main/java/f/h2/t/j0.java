/*
 * Decompiled with CFR 0.151.
 */
package f.h2.t;

import f.h2.t.f0;
import f.h2.t.m0;

public final class j0
extends m0 {
    private final long[] d;

    public j0(int n10) {
        super(n10);
        long[] lArray = new long[n10];
        this.d = lArray;
    }

    public final void h(long l10) {
        long[] lArray = this.d;
        int n10 = this.b();
        int n11 = n10 + 1;
        this.e(n11);
        lArray[n10] = l10;
    }

    public int i(long[] lArray) {
        f0.p(lArray, "$this$getSize");
        return lArray.length;
    }

    public final long[] j() {
        long[] lArray = this.d;
        long[] lArray2 = new long[this.f()];
        return (long[])this.g(lArray, lArray2);
    }
}

