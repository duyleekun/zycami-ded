/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.g;

import e.a.i0;
import e.a.l0;
import e.a.n0;
import e.a.o0;
import e.a.w0.b.a;
import io.reactivex.internal.disposables.EmptyDisposable;

public final class u
extends i0 {
    public final o0 a;
    public final n0 b;

    public u(o0 o02, n0 n02) {
        this.a = o02;
        this.b = n02;
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
        object = object.a(l02);
        String string2 = "The onLift returned a null SingleObserver";
        object = e.a.w0.b.a.g(object, string2);
        object = (l0)object;
        this.a.f((l0)object);
    }
}

