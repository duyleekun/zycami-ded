/*
 * Decompiled with CFR 0.151.
 */
package f.h2.t;

import f.h2.t.f0;
import f.h2.t.m0;

public final class m
extends m0 {
    private final boolean[] d;

    public m(int n10) {
        super(n10);
        boolean[] blArray = new boolean[n10];
        this.d = blArray;
    }

    public final void h(boolean bl2) {
        boolean[] blArray = this.d;
        int n10 = this.b();
        int n11 = n10 + 1;
        this.e(n11);
        blArray[n10] = bl2;
    }

    public int i(boolean[] blArray) {
        f0.p(blArray, "$this$getSize");
        return blArray.length;
    }

    public final boolean[] j() {
        boolean[] blArray = this.d;
        boolean[] blArray2 = new boolean[this.f()];
        return (boolean[])this.g(blArray, blArray2);
    }
}

