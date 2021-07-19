/*
 * Decompiled with CFR 0.151.
 */
package f;

import f.g1;
import f.h2.t.f0;
import f.x1.m1;
import java.util.NoSuchElementException;

public final class h1$a
extends m1 {
    private int a;
    private final long[] b;

    public h1$a(long[] lArray) {
        f0.p(lArray, "array");
        this.b = lArray;
    }

    public long c() {
        int n10 = this.a;
        Object object = this.b;
        int n11 = ((long[])object).length;
        if (n10 < n11) {
            this.a = n11 = n10 + 1;
            return g1.h(object[n10]);
        }
        object = String.valueOf(this.a);
        NoSuchElementException noSuchElementException = new NoSuchElementException((String)object);
        throw noSuchElementException;
    }

    public boolean hasNext() {
        int n10 = this.a;
        long[] lArray = this.b;
        int n11 = lArray.length;
        n10 = n10 < n11 ? 1 : 0;
        return n10 != 0;
    }
}

