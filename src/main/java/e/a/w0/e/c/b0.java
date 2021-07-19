/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.c;

import e.a.t;
import e.a.v;
import e.a.w;
import e.a.w0.e.c.a;
import io.reactivex.internal.disposables.EmptyDisposable;

public final class b0
extends a {
    public final v b;

    public b0(w w10, v v10) {
        super(w10);
        this.b = v10;
    }

    public void t1(t t10) {
        Object object;
        try {
            object = this.b;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            EmptyDisposable.error(throwable, t10);
            return;
        }
        object = object.a(t10);
        String string2 = "The operator returned a null MaybeObserver";
        object = e.a.w0.b.a.g(object, string2);
        object = (t)object;
        this.a.g((t)object);
    }
}

