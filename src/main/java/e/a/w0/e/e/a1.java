/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.z;
import io.reactivex.internal.disposables.EmptyDisposable;

public final class a1
extends z {
    public static final z a;

    static {
        a1 a12 = new a1();
        a = a12;
    }

    private a1() {
    }

    public void K5(g0 g02) {
        EmptyDisposable emptyDisposable = EmptyDisposable.NEVER;
        g02.onSubscribe(emptyDisposable);
    }
}

