/*
 * Decompiled with CFR 0.151.
 */
package f.h2.t;

import f.h2.t.f0;
import f.h2.t.m0;

public final class q0
extends m0 {
    private final short[] d;

    public q0(int n10) {
        super(n10);
        short[] sArray = new short[n10];
        this.d = sArray;
    }

    public final void h(short s10) {
        short[] sArray = this.d;
        int n10 = this.b();
        int n11 = n10 + 1;
        this.e(n11);
        sArray[n10] = s10;
    }

    public int i(short[] sArray) {
        f0.p(sArray, "$this$getSize");
        return sArray.length;
    }

    public final short[] j() {
        short[] sArray = this.d;
        short[] sArray2 = new short[this.f()];
        return (short[])this.g(sArray, sArray2);
    }
}

