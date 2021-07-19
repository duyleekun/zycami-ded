/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.a;

import e.a.a;
import e.a.d;
import e.a.g;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

public final class b
extends a {
    public final Callable a;

    public b(Callable callable) {
        this.a = callable;
    }

    public void L0(d d10) {
        Object object;
        try {
            object = this.a;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            EmptyDisposable.error(throwable, d10);
            return;
        }
        object = object.call();
        String string2 = "The completableSupplier returned a null CompletableSource";
        object = e.a.w0.b.a.g(object, string2);
        ((g)object).f(d10);
    }
}

