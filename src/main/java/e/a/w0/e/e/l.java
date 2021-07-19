/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.e0;
import e.a.g0;
import e.a.w0.e.e.a;
import e.a.w0.e.e.l$b;
import java.util.concurrent.Callable;

public final class l
extends a {
    public final e0 b;
    public final Callable c;

    public l(e0 e02, e0 e03, Callable callable) {
        super(e02);
        this.b = e03;
        this.c = callable;
    }

    public void K5(g0 object) {
        e0 e02 = this.a;
        e.a.y0.l l10 = new e.a.y0.l((g0)object);
        object = this.c;
        e0 e03 = this.b;
        l$b l$b = new l$b(l10, (Callable)object, e03);
        e02.subscribe(l$b);
    }
}

