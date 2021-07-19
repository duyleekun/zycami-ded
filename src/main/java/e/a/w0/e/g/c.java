/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.g;

import e.a.i0;
import e.a.l0;
import e.a.o0;
import e.a.w0.b.a;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

public final class c
extends i0 {
    public final Callable a;

    public c(Callable callable) {
        this.a = callable;
    }

    public void e1(l0 l02) {
        Object object;
        try {
            object = this.a;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            EmptyDisposable.error(throwable, l02);
            return;
        }
        object = object.call();
        String string2 = "The singleSupplier returned a null SingleSource";
        object = e.a.w0.b.a.g(object, string2);
        ((o0)object).f(l02);
    }
}

