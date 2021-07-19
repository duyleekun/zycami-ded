/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.c;

import e.a.q;
import e.a.t;
import e.a.w;
import e.a.w0.b.a;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

public final class e
extends q {
    public final Callable a;

    public e(Callable callable) {
        this.a = callable;
    }

    public void t1(t t10) {
        Object object;
        try {
            object = this.a;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            EmptyDisposable.error(throwable, t10);
            return;
        }
        object = object.call();
        String string2 = "The maybeSupplier returned a null MaybeSource";
        object = e.a.w0.b.a.g(object, string2);
        ((w)object).g(t10);
    }
}

