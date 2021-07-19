/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.g;

import e.a.h0$c;
import e.a.s0.a;
import e.a.w0.a.b;
import e.a.w0.g.a$c;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.TimeUnit;

public final class a$a
extends h0$c {
    private final b a;
    private final a b;
    private final b c;
    private final a$c d;
    public volatile boolean e;

    public a$a(a$c b10) {
        b b11;
        a a10;
        this.d = b10;
        this.a = b10;
        this.b = a10 = new a();
        this.c = b11 = new b();
        b11.b(b10);
        b11.b(a10);
    }

    public e.a.s0.b b(Runnable runnable) {
        boolean bl2 = this.e;
        if (bl2) {
            return EmptyDisposable.INSTANCE;
        }
        a$c a$c = this.d;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        b b10 = this.a;
        return a$c.e(runnable, 0L, timeUnit, b10);
    }

    public e.a.s0.b c(Runnable runnable, long l10, TimeUnit timeUnit) {
        boolean bl2 = this.e;
        if (bl2) {
            return EmptyDisposable.INSTANCE;
        }
        a$c a$c = this.d;
        a a10 = this.b;
        return a$c.e(runnable, l10, timeUnit, a10);
    }

    public void dispose() {
        boolean bl2 = this.e;
        if (!bl2) {
            this.e = bl2 = true;
            b b10 = this.c;
            b10.dispose();
        }
    }

    public boolean isDisposed() {
        return this.e;
    }
}

