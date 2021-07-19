/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.e0;
import e.a.g0;
import e.a.s0.b;
import e.a.w0.e.e.a;
import e.a.w0.e.e.n1$a;
import e.a.w0.e.e.n1$b;
import e.a.y0.l;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;

public final class n1
extends a {
    public final e0 b;

    public n1(e0 e02, e0 e03) {
        super(e02);
        this.b = e03;
    }

    public void K5(g0 object) {
        l l10 = new l((g0)object);
        object = new ArrayCompositeDisposable(2);
        l10.onSubscribe((b)object);
        n1$b n1$b = new n1$b(l10, (ArrayCompositeDisposable)object);
        e0 e02 = this.b;
        n1$a n1$a = new n1$a(this, (ArrayCompositeDisposable)object, n1$b, l10);
        e02.subscribe(n1$a);
        this.a.subscribe(n1$b);
    }
}

