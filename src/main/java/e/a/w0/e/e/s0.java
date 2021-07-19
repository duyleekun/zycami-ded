/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.a;
import e.a.d;
import e.a.e0;
import e.a.w0.e.e.r0;
import e.a.w0.e.e.s0$a;
import e.a.z;

public final class s0
extends a
implements e.a.w0.c.d {
    public final e0 a;

    public s0(e0 e02) {
        this.a = e02;
    }

    public void L0(d d10) {
        e0 e02 = this.a;
        s0$a s0$a = new s0$a(d10);
        e02.subscribe(s0$a);
    }

    public z i() {
        e0 e02 = this.a;
        r0 r02 = new r0(e02);
        return e.a.a1.a.R(r02);
    }
}

