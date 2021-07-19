/*
 * Decompiled with CFR 0.151.
 */
package f.h2.t;

import f.h2.t.f0;
import f.h2.t.m0;

public final class o
extends m0 {
    private final byte[] d;

    public o(int n10) {
        super(n10);
        byte[] byArray = new byte[n10];
        this.d = byArray;
    }

    public final void h(byte by2) {
        byte[] byArray = this.d;
        int n10 = this.b();
        int n11 = n10 + 1;
        this.e(n11);
        byArray[n10] = by2;
    }

    public int i(byte[] byArray) {
        f0.p(byArray, "$this$getSize");
        return byArray.length;
    }

    public final byte[] j() {
        byte[] byArray = this.d;
        byte[] byArray2 = new byte[this.f()];
        return (byte[])this.g(byArray, byArray2);
    }
}

