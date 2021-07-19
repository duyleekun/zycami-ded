/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.w0.b.a;
import e.a.z;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

public final class g0
extends z {
    public final Callable a;

    public g0(Callable callable) {
        this.a = callable;
    }

    public void K5(e.a.g0 g02) {
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
        EmptyDisposable.error((Throwable)object, g02);
    }
}

