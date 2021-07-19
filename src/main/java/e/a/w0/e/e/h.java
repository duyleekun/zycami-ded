/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.a1.a;
import e.a.e0;
import e.a.i0;
import e.a.l0;
import e.a.v0.r;
import e.a.w0.c.d;
import e.a.w0.e.e.g;
import e.a.w0.e.e.h$a;
import e.a.z;

public final class h
extends i0
implements d {
    public final e0 a;
    public final r b;

    public h(e0 e02, r r10) {
        this.a = e02;
        this.b = r10;
    }

    public void e1(l0 l02) {
        e0 e02 = this.a;
        r r10 = this.b;
        h$a h$a = new h$a(l02, r10);
        e02.subscribe(h$a);
    }

    public z i() {
        e0 e02 = this.a;
        r r10 = this.b;
        g g10 = new g(e02, r10);
        return e.a.a1.a.R(g10);
    }
}

