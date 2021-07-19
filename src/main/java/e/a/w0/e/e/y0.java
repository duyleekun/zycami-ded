/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.e0;
import e.a.g0;
import e.a.v0.o;
import e.a.w0.e.e.a;
import e.a.w0.e.e.y0$a;
import java.util.concurrent.Callable;

public final class y0
extends a {
    public final o b;
    public final o c;
    public final Callable d;

    public y0(e0 e02, o o10, o o11, Callable callable) {
        super(e02);
        this.b = o10;
        this.c = o11;
        this.d = callable;
    }

    public void K5(g0 g02) {
        e0 e02 = this.a;
        o o10 = this.b;
        o o11 = this.c;
        Callable callable = this.d;
        y0$a y0$a = new y0$a(g02, o10, o11, callable);
        e02.subscribe(y0$a);
    }
}

