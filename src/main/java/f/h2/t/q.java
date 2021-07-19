/*
 * Decompiled with CFR 0.151.
 */
package f.h2.t;

import f.h2.t.f0;
import f.h2.t.m0;

public final class q
extends m0 {
    private final char[] d;

    public q(int n10) {
        super(n10);
        char[] cArray = new char[n10];
        this.d = cArray;
    }

    public final void h(char c10) {
        char[] cArray = this.d;
        int n10 = this.b();
        int n11 = n10 + 1;
        this.e(n11);
        cArray[n10] = c10;
    }

    public int i(char[] cArray) {
        f0.p(cArray, "$this$getSize");
        return cArray.length;
    }

    public final char[] j() {
        char[] cArray = this.d;
        char[] cArray2 = new char[this.f()];
        return (char[])this.g(cArray, cArray2);
    }
}

