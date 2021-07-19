/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.a1.a;
import e.a.e0;
import e.a.i0;
import e.a.l0;
import e.a.v0.b;
import e.a.w0.c.d;
import e.a.w0.e.e.n;
import e.a.w0.e.e.o$a;
import e.a.z;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

public final class o
extends i0
implements d {
    public final e0 a;
    public final Callable b;
    public final b c;

    public o(e0 e02, Callable callable, b b10) {
        this.a = e02;
        this.b = callable;
        this.c = b10;
    }

    public void e1(l0 l02) {
        Object object;
        try {
            object = this.b;
        }
        catch (Throwable throwable) {
            EmptyDisposable.error(throwable, l02);
            return;
        }
        object = object.call();
        Object object2 = "The initialSupplier returned a null value";
        object = e.a.w0.b.a.g(object, (String)object2);
        object2 = this.a;
        b b10 = this.c;
        o$a o$a = new o$a(l02, object, b10);
        object2.subscribe(o$a);
    }

    public z i() {
        e0 e02 = this.a;
        Callable callable = this.b;
        b b10 = this.c;
        n n10 = new n(e02, callable, b10);
        return e.a.a1.a.R(n10);
    }
}

