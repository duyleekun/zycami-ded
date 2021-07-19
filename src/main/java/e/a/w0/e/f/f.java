/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.f;

import e.a.z0.a;
import i.g.c;
import i.g.d;

public final class f
extends a {
    public final c[] a;

    public f(c[] cArray) {
        this.a = cArray;
    }

    public int G() {
        return this.a.length;
    }

    public void a(d[] dArray) {
        int n10 = this.U(dArray);
        if (n10 == 0) {
            return;
        }
        n10 = dArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            c c10 = this.a[i10];
            d d10 = dArray[i10];
            c10.subscribe(d10);
        }
    }
}

