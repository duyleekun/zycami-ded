/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.e1.e;
import e.a.w0.e.b.a;
import e.a.w0.e.b.j$b;
import i.g.c;
import i.g.d;
import java.util.concurrent.Callable;

public final class j
extends a {
    public final c c;
    public final Callable d;

    public j(e.a.j j10, c c10, Callable callable) {
        super(j10);
        this.c = c10;
        this.d = callable;
    }

    public void m6(d object) {
        e.a.j j10 = this.b;
        e e10 = new e((d)object);
        object = this.d;
        c c10 = this.c;
        j$b j$b = new j$b(e10, (Callable)object, c10);
        j10.l6(j$b);
    }
}

