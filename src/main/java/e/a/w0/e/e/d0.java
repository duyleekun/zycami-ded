/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.a1.a;
import e.a.e0;
import e.a.q;
import e.a.t;
import e.a.w0.c.d;
import e.a.w0.e.e.c0;
import e.a.w0.e.e.d0$a;
import e.a.z;

public final class d0
extends q
implements d {
    public final e0 a;
    public final long b;

    public d0(e0 e02, long l10) {
        this.a = e02;
        this.b = l10;
    }

    public z i() {
        e0 e02 = this.a;
        long l10 = this.b;
        c0 c02 = new c0(e02, l10, null, false);
        return e.a.a1.a.R(c02);
    }

    public void t1(t t10) {
        e0 e02 = this.a;
        long l10 = this.b;
        d0$a d0$a = new d0$a(t10, l10);
        e02.subscribe(d0$a);
    }
}

