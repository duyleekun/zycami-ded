/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.e0;
import e.a.g0;
import e.a.w0.e.e.u$a;
import e.a.z;
import io.reactivex.internal.disposables.SequentialDisposable;

public final class u
extends z {
    public final e0 a;
    public final e0 b;

    public u(e0 e02, e0 e03) {
        this.a = e02;
        this.b = e03;
    }

    public void K5(g0 g02) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        g02.onSubscribe(sequentialDisposable);
        u$a u$a = new u$a(this, sequentialDisposable, g02);
        this.b.subscribe(u$a);
    }
}

