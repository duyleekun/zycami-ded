/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.g;

import e.a.i0;
import e.a.l0;
import e.a.w0.b.a;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

public final class o
extends i0 {
    public final Callable a;

    public o(Callable callable) {
        this.a = callable;
    }

    public void e1(l0 l02) {
        Object object = this.a;
        object = object.call();
        String string2 = "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.";
        object = e.a.w0.b.a.g(object, string2);
        try {
            object = (Throwable)object;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
        }
        EmptyDisposable.error((Throwable)object, l02);
    }
}

