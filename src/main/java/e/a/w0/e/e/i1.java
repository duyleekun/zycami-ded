/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.e0;
import e.a.g0;
import e.a.v0.c;
import e.a.w0.e.e.a;
import e.a.w0.e.e.i1$a;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

public final class i1
extends a {
    public final c b;
    public final Callable c;

    public i1(e0 e02, Callable callable, c c10) {
        super(e02);
        this.b = c10;
        this.c = callable;
    }

    public void K5(g0 g02) {
        Object object;
        try {
            object = this.c;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            EmptyDisposable.error(throwable, g02);
            return;
        }
        object = object.call();
        Object object2 = "The seed supplied is null";
        object = e.a.w0.b.a.g(object, (String)object2);
        object2 = this.a;
        c c10 = this.b;
        i1$a i1$a = new i1$a(g02, c10, object);
        object2.subscribe(i1$a);
    }
}

