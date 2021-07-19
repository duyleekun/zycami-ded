/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.a;

import e.a.a;
import e.a.d;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

public final class h
extends a {
    public final Callable a;

    public h(Callable callable) {
        this.a = callable;
    }

    public void L0(d d10) {
        Object object = this.a;
        object = object.call();
        String string2 = "The error returned is null";
        object = e.a.w0.b.a.g(object, string2);
        try {
            object = (Throwable)object;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
        }
        EmptyDisposable.error((Throwable)object, d10);
    }
}

