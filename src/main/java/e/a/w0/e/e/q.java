/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.a1.a;
import e.a.e0;
import e.a.i0;
import e.a.l0;
import e.a.w0.c.d;
import e.a.w0.e.e.p;
import e.a.w0.e.e.q$a;
import e.a.z;

public final class q
extends i0
implements d {
    public final e0 a;

    public q(e0 e02) {
        this.a = e02;
    }

    public void e1(l0 l02) {
        e0 e02 = this.a;
        q$a q$a = new q$a(l02);
        e02.subscribe(q$a);
    }

    public z i() {
        e0 e02 = this.a;
        p p10 = new p(e02);
        return e.a.a1.a.R(p10);
    }
}

