/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.a;

import e.a.a;
import e.a.d;
import io.reactivex.internal.disposables.EmptyDisposable;

public final class u
extends a {
    public static final a a;

    static {
        u u10 = new u();
        a = u10;
    }

    private u() {
    }

    public void L0(d d10) {
        EmptyDisposable emptyDisposable = EmptyDisposable.NEVER;
        d10.onSubscribe(emptyDisposable);
    }
}

