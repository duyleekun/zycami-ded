/*
 * Decompiled with CFR 0.151.
 */
package f;

import f.h2.t.f0;
import f.x1.i1;
import f.y0;
import java.util.NoSuchElementException;

public final class z0$a
extends i1 {
    private int a;
    private final byte[] b;

    public z0$a(byte[] byArray) {
        f0.p(byArray, "array");
        this.b = byArray;
    }

    public byte c() {
        int n10 = this.a;
        Object object = this.b;
        int n11 = ((byte[])object).length;
        if (n10 < n11) {
            this.a = n11 = n10 + 1;
            return y0.h(object[n10]);
        }
        object = String.valueOf(this.a);
        NoSuchElementException noSuchElementException = new NoSuchElementException((String)object);
        throw noSuchElementException;
    }

    public boolean hasNext() {
        int n10 = this.a;
        byte[] byArray = this.b;
        int n11 = byArray.length;
        n10 = n10 < n11 ? 1 : 0;
        return n10 != 0;
    }
}

