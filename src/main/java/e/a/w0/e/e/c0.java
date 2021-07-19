/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.e0;
import e.a.g0;
import e.a.w0.e.e.a;
import e.a.w0.e.e.c0$a;

public final class c0
extends a {
    public final long b;
    public final Object c;
    public final boolean d;

    public c0(e0 e02, long l10, Object object, boolean bl2) {
        super(e02);
        this.b = l10;
        this.c = object;
        this.d = bl2;
    }

    public void K5(g0 g02) {
        e0 e02 = this.a;
        long l10 = this.b;
        Object object = this.c;
        boolean bl2 = this.d;
        c0$a c0$a = new c0$a(g02, l10, object, bl2);
        e02.subscribe(c0$a);
    }
}

