/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.t0.a;
import e.a.v0.c;
import e.a.v0.g;
import e.a.w0.e.e.p0$a;
import e.a.z;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

public final class p0
extends z {
    public final Callable a;
    public final c b;
    public final g c;

    public p0(Callable callable, c c10, g g10) {
        this.a = callable;
        this.b = c10;
        this.c = g10;
    }

    public void K5(g0 g02) {
        Callable callable;
        try {
            callable = this.a;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            EmptyDisposable.error(throwable, g02);
            return;
        }
        callable = callable.call();
        c c10 = this.b;
        g g10 = this.c;
        p0$a p0$a = new p0$a(g02, c10, g10, callable);
        g02.onSubscribe(p0$a);
        p0$a.b();
    }
}

