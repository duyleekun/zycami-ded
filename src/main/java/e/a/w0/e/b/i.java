/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.e1.e;
import e.a.j;
import e.a.w0.e.b.a;
import e.a.w0.e.b.i$b;
import i.g.d;
import java.util.concurrent.Callable;

public final class i
extends a {
    public final Callable c;
    public final Callable d;

    public i(j j10, Callable callable, Callable callable2) {
        super(j10);
        this.c = callable;
        this.d = callable2;
    }

    public void m6(d object) {
        j j10 = this.b;
        e e10 = new e((d)object);
        object = this.d;
        Callable callable = this.c;
        i$b i$b = new i$b(e10, (Callable)object, callable);
        j10.l6(i$b);
    }
}

