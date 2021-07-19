/*
 * Decompiled with CFR 0.151.
 */
package e.a.c1;

import e.a.c1.c;
import e.a.c1.c$a$a;
import e.a.c1.c$b;
import e.a.h0$c;
import e.a.s0.b;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.TimeUnit;

public final class c$a
extends h0$c {
    public volatile boolean a;
    public final /* synthetic */ c b;

    public c$a(c c10) {
        this.b = c10;
    }

    public long a(TimeUnit timeUnit) {
        return this.b.d(timeUnit);
    }

    public b b(Runnable runnable) {
        c$b c$b;
        long l10;
        boolean bl2 = this.a;
        if (bl2) {
            return EmptyDisposable.INSTANCE;
        }
        Object object = this.b;
        long l11 = ((c)object).c;
        ((c)object).c = l10 = 1L + l11;
        object = c$b;
        c$b = new c$b(this, 0L, runnable, l11);
        this.b.b.add(c$b);
        runnable = new c$a$a(this, c$b);
        return e.a.s0.c.f(runnable);
    }

    public b c(Runnable runnable, long l10, TimeUnit timeUnit) {
        long l11;
        boolean bl2 = this.a;
        if (bl2) {
            return EmptyDisposable.INSTANCE;
        }
        long l12 = this.b.d;
        l10 = timeUnit.toNanos(l10);
        long l13 = l12 + l10;
        c c10 = this.b;
        long l14 = c10.c;
        c10.c = l11 = 1L + l14;
        c$b c$b = new c$b(this, l13, runnable, l14);
        this.b.b.add(c$b);
        runnable = new c$a$a(this, c$b);
        return e.a.s0.c.f(runnable);
    }

    public void dispose() {
        this.a = true;
    }

    public boolean isDisposed() {
        return this.a;
    }
}

