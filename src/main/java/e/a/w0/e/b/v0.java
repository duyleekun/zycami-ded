/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.i0;
import e.a.l0;
import e.a.w0.b.a;
import e.a.w0.e.b.u0$a;
import i.g.c;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

public final class v0
extends i0 {
    public final c a;
    public final Callable b;
    public final e.a.v0.c c;

    public v0(c c10, Callable callable, e.a.v0.c c11) {
        this.a = c10;
        this.b = callable;
        this.c = c11;
    }

    public void e1(l0 l02) {
        Object object;
        try {
            object = this.b;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            EmptyDisposable.error(throwable, l02);
            return;
        }
        object = object.call();
        Object object2 = "The seedSupplier returned a null value";
        object = e.a.w0.b.a.g(object, (String)object2);
        object2 = this.a;
        e.a.v0.c c10 = this.c;
        u0$a u0$a = new u0$a(l02, c10, object);
        object2.subscribe(u0$a);
    }
}

