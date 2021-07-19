/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.g;

import e.a.i0;
import e.a.l0;
import io.reactivex.internal.disposables.EmptyDisposable;

public final class x
extends i0 {
    public static final i0 a;

    static {
        x x10 = new x();
        a = x10;
    }

    private x() {
    }

    public void e1(l0 l02) {
        EmptyDisposable emptyDisposable = EmptyDisposable.NEVER;
        l02.onSubscribe(emptyDisposable);
    }
}

