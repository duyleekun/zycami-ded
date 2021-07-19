/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.g;

import e.a.h0;
import e.a.i0;
import e.a.l0;
import e.a.o0;
import e.a.w0.e.g.d$a;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.TimeUnit;

public final class d
extends i0 {
    public final o0 a;
    public final long b;
    public final TimeUnit c;
    public final h0 d;
    public final boolean e;

    public d(o0 o02, long l10, TimeUnit timeUnit, h0 h02, boolean bl2) {
        this.a = o02;
        this.b = l10;
        this.c = timeUnit;
        this.d = h02;
        this.e = bl2;
    }

    public void e1(l0 l02) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        l02.onSubscribe(sequentialDisposable);
        o0 o02 = this.a;
        d$a d$a = new d$a(this, sequentialDisposable, l02);
        o02.f(d$a);
    }
}

