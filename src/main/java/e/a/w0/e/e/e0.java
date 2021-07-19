/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.a1.a;
import e.a.i0;
import e.a.l0;
import e.a.w0.c.d;
import e.a.w0.e.e.c0;
import e.a.w0.e.e.e0$a;
import e.a.z;

public final class e0
extends i0
implements d {
    public final e.a.e0 a;
    public final long b;
    public final Object c;

    public e0(e.a.e0 e02, long l10, Object object) {
        this.a = e02;
        this.b = l10;
        this.c = object;
    }

    public void e1(l0 l02) {
        e.a.e0 e02 = this.a;
        long l10 = this.b;
        Object object = this.c;
        e0$a e0$a = new e0$a(l02, l10, object);
        e02.subscribe(e0$a);
    }

    public z i() {
        e.a.e0 e02 = this.a;
        long l10 = this.b;
        Object object = this.c;
        c0 c02 = new c0(e02, l10, object, true);
        return e.a.a1.a.R(c02);
    }
}

