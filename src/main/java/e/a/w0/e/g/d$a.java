/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.g;

import e.a.h0;
import e.a.l0;
import e.a.s0.b;
import e.a.w0.e.g.d;
import e.a.w0.e.g.d$a$a;
import e.a.w0.e.g.d$a$b;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.TimeUnit;

public final class d$a
implements l0 {
    private final SequentialDisposable a;
    public final l0 b;
    public final /* synthetic */ d c;

    public d$a(d d10, SequentialDisposable sequentialDisposable, l0 l02) {
        this.c = d10;
        this.a = sequentialDisposable;
        this.b = l02;
    }

    public void onError(Throwable object) {
        SequentialDisposable sequentialDisposable = this.a;
        h0 h02 = this.c.d;
        d$a$a d$a$a = new d$a$a(this, (Throwable)object);
        object = this.c;
        boolean bl2 = ((d)object).e;
        long l10 = bl2 ? ((d)object).b : 0L;
        object = ((d)object).c;
        object = h02.f(d$a$a, l10, (TimeUnit)((Object)object));
        sequentialDisposable.replace((b)object);
    }

    public void onSubscribe(b b10) {
        this.a.replace(b10);
    }

    public void onSuccess(Object object) {
        SequentialDisposable sequentialDisposable = this.a;
        h0 h02 = this.c.d;
        d$a$b d$a$b = new d$a$b(this, object);
        object = this.c;
        long l10 = ((d)object).b;
        object = ((d)object).c;
        object = h02.f(d$a$b, l10, (TimeUnit)((Object)object));
        sequentialDisposable.replace((b)object);
    }
}

