/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import g.b0;
import g.v;
import h.n;

public final class b0$a$c
extends b0 {
    public final /* synthetic */ byte[] a;
    public final /* synthetic */ v b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;

    public b0$a$c(byte[] byArray, v v10, int n10, int n11) {
        this.a = byArray;
        this.b = v10;
        this.c = n10;
        this.d = n11;
    }

    public long contentLength() {
        return this.c;
    }

    public v contentType() {
        return this.b;
    }

    public void writeTo(n n10) {
        f0.p(n10, "sink");
        byte[] byArray = this.a;
        int n11 = this.d;
        int n12 = this.c;
        n10.write(byArray, n11, n12);
    }
}

