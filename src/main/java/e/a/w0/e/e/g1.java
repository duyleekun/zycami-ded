/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.e0;
import e.a.i0;
import e.a.l0;
import e.a.v0.c;
import e.a.w0.b.a;
import e.a.w0.e.e.f1$a;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

public final class g1
extends i0 {
    public final e0 a;
    public final Callable b;
    public final c c;

    public g1(e0 e02, Callable callable, c c10) {
        this.a = e02;
        this.b = callable;
        this.c = c10;
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
        c c10 = this.c;
        f1$a f1$a = new f1$a(l02, c10, object);
        object2.subscribe(f1$a);
    }
}

