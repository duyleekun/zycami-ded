/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.c;

import e.a.i0;
import e.a.l0;
import e.a.w;
import e.a.w0.c.f;
import e.a.w0.e.c.c$a;

public final class c
extends i0
implements f {
    public final w a;
    public final Object b;

    public c(w w10, Object object) {
        this.a = w10;
        this.b = object;
    }

    public void e1(l0 l02) {
        w w10 = this.a;
        Object object = this.b;
        c$a c$a = new c$a(l02, object);
        w10.g(c$a);
    }

    public w source() {
        return this.a;
    }
}

