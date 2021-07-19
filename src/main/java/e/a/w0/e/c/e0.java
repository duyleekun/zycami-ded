/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.c;

import e.a.q;
import e.a.t;
import io.reactivex.internal.disposables.EmptyDisposable;

public final class e0
extends q {
    public static final e0 a;

    static {
        e0 e02;
        a = e02 = new e0();
    }

    public void t1(t t10) {
        EmptyDisposable emptyDisposable = EmptyDisposable.NEVER;
        t10.onSubscribe(emptyDisposable);
    }
}

