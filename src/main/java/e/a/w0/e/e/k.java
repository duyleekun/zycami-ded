/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.e0;
import e.a.g0;
import e.a.w0.e.e.a;
import e.a.w0.e.e.k$b;
import e.a.y0.l;
import java.util.concurrent.Callable;

public final class k
extends a {
    public final Callable b;
    public final Callable c;

    public k(e0 e02, Callable callable, Callable callable2) {
        super(e02);
        this.b = callable;
        this.c = callable2;
    }

    public void K5(g0 object) {
        e0 e02 = this.a;
        l l10 = new l((g0)object);
        object = this.c;
        Callable callable = this.b;
        k$b k$b = new k$b(l10, (Callable)object, callable);
        e02.subscribe(k$b);
    }
}

