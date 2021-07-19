/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.h0$c;
import e.a.s0.b;
import e.a.w0.e.e.t$a$a;
import e.a.w0.e.e.t$a$b;
import e.a.w0.e.e.t$a$c;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;

public final class t$a
implements g0,
b {
    public final g0 a;
    public final long b;
    public final TimeUnit c;
    public final h0$c d;
    public final boolean e;
    public b f;

    public t$a(g0 g02, long l10, TimeUnit timeUnit, h0$c h0$c, boolean bl2) {
        this.a = g02;
        this.b = l10;
        this.c = timeUnit;
        this.d = h0$c;
        this.e = bl2;
    }

    public void dispose() {
        this.f.dispose();
        this.d.dispose();
    }

    public boolean isDisposed() {
        return this.d.isDisposed();
    }

    public void onComplete() {
        h0$c h0$c = this.d;
        t$a$a t$a$a = new t$a$a(this);
        long l10 = this.b;
        TimeUnit timeUnit = this.c;
        h0$c.c(t$a$a, l10, timeUnit);
    }

    public void onError(Throwable object) {
        h0$c h0$c = this.d;
        t$a$b t$a$b = new t$a$b(this, (Throwable)object);
        boolean bl2 = this.e;
        long l10 = bl2 ? this.b : 0L;
        object = this.c;
        h0$c.c(t$a$b, l10, (TimeUnit)((Object)object));
    }

    public void onNext(Object object) {
        h0$c h0$c = this.d;
        t$a$c t$a$c = new t$a$c(this, object);
        long l10 = this.b;
        object = this.c;
        h0$c.c(t$a$c, l10, (TimeUnit)((Object)object));
    }

    public void onSubscribe(b object) {
        b b10 = this.f;
        boolean bl2 = DisposableHelper.validate(b10, (b)object);
        if (bl2) {
            this.f = object;
            object = this.a;
            object.onSubscribe(this);
        }
    }
}

