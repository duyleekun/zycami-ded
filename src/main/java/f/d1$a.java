/*
 * Decompiled with CFR 0.151.
 */
package f;

import f.c1;
import f.h2.t.f0;
import f.x1.l1;
import java.util.NoSuchElementException;

public final class d1$a
extends l1 {
    private int a;
    private final int[] b;

    public d1$a(int[] nArray) {
        f0.p(nArray, "array");
        this.b = nArray;
    }

    public int c() {
        int n10 = this.a;
        Object object = this.b;
        int n11 = ((int[])object).length;
        if (n10 < n11) {
            this.a = n11 = n10 + 1;
            return c1.h(object[n10]);
        }
        object = String.valueOf(this.a);
        NoSuchElementException noSuchElementException = new NoSuchElementException((String)object);
        throw noSuchElementException;
    }

    public boolean hasNext() {
        int n10 = this.a;
        int[] nArray = this.b;
        int n11 = nArray.length;
        n10 = n10 < n11 ? 1 : 0;
        return n10 != 0;
    }
}

