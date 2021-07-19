/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.a;

import e.a.a;
import e.a.d;
import io.reactivex.internal.disposables.EmptyDisposable;

public final class g
extends a {
    public final Throwable a;

    public g(Throwable throwable) {
        this.a = throwable;
    }

    public void L0(d d10) {
        EmptyDisposable.error(this.a, d10);
    }
}

