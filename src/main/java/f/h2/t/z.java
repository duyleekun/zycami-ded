/*
 * Decompiled with CFR 0.151.
 */
package f.h2.t;

import f.h2.t.f0;
import f.h2.t.m0;

public final class z
extends m0 {
    private final float[] d;

    public z(int n10) {
        super(n10);
        float[] fArray = new float[n10];
        this.d = fArray;
    }

    public final void h(float f10) {
        float[] fArray = this.d;
        int n10 = this.b();
        int n11 = n10 + 1;
        this.e(n11);
        fArray[n10] = f10;
    }

    public int i(float[] fArray) {
        f0.p(fArray, "$this$getSize");
        return fArray.length;
    }

    public final float[] j() {
        float[] fArray = this.d;
        float[] fArray2 = new float[this.f()];
        return (float[])this.g(fArray, fArray2);
    }
}

