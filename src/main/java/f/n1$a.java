/*
 * Decompiled with CFR 0.151.
 */
package f;

import f.h2.t.f0;
import f.m1;
import f.x1.n1;
import java.util.NoSuchElementException;

public final class n1$a
extends n1 {
    private int a;
    private final short[] b;

    public n1$a(short[] sArray) {
        f0.p(sArray, "array");
        this.b = sArray;
    }

    public short c() {
        int n10 = this.a;
        Object object = this.b;
        int n11 = ((short[])object).length;
        if (n10 < n11) {
            this.a = n11 = n10 + 1;
            return m1.h(object[n10]);
        }
        object = String.valueOf(this.a);
        NoSuchElementException noSuchElementException = new NoSuchElementException((String)object);
        throw noSuchElementException;
    }

    public boolean hasNext() {
        int n10 = this.a;
        short[] sArray = this.b;
        int n11 = sArray.length;
        n10 = n10 < n11 ? 1 : 0;
        return n10 != 0;
    }
}

