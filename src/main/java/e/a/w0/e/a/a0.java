/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.a;

import e.a.g;
import e.a.i0;
import e.a.l0;
import e.a.w0.e.a.a0$a;
import java.util.concurrent.Callable;

public final class a0
extends i0 {
    public final g a;
    public final Callable b;
    public final Object c;

    public a0(g g10, Callable callable, Object object) {
        this.a = g10;
        this.c = object;
        this.b = callable;
    }

    public void e1(l0 l02) {
        g g10 = this.a;
        a0$a a0$a = new a0$a(this, l02);
        g10.f(a0$a);
    }
}

