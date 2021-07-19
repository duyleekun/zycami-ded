/*
 * Decompiled with CFR 0.151.
 */
package f.h2.t;

import f.h2.t.f0;
import f.h2.t.m0;

public final class w
extends m0 {
    private final double[] d;

    public w(int n10) {
        super(n10);
        double[] dArray = new double[n10];
        this.d = dArray;
    }

    public final void h(double d10) {
        double[] dArray = this.d;
        int n10 = this.b();
        int n11 = n10 + 1;
        this.e(n11);
        dArray[n10] = d10;
    }

    public int i(double[] dArray) {
        f0.p(dArray, "$this$getSize");
        return dArray.length;
    }

    public final double[] j() {
        double[] dArray = this.d;
        double[] dArray2 = new double[this.f()];
        return (double[])this.g(dArray, dArray2);
    }
}

