/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.h0$c;
import e.a.o;
import e.a.w0.e.b.q$a$a;
import e.a.w0.e.b.q$a$b;
import e.a.w0.e.b.q$a$c;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;

public final class q$a
implements o,
e {
    public final d a;
    public final long b;
    public final TimeUnit c;
    public final h0$c d;
    public final boolean e;
    public e f;

    public q$a(d d10, long l10, TimeUnit timeUnit, h0$c h0$c, boolean bl2) {
        this.a = d10;
        this.b = l10;
        this.c = timeUnit;
        this.d = h0$c;
        this.e = bl2;
    }

    public void cancel() {
        this.f.cancel();
        this.d.dispose();
    }

    public void onComplete() {
        h0$c h0$c = this.d;
        q$a$a q$a$a = new q$a$a(this);
        long l10 = this.b;
        TimeUnit timeUnit = this.c;
        h0$c.c(q$a$a, l10, timeUnit);
    }

    public void onError(Throwable object) {
        h0$c h0$c = this.d;
        q$a$b q$a$b = new q$a$b(this, (Throwable)object);
        boolean bl2 = this.e;
        long l10 = bl2 ? this.b : 0L;
        object = this.c;
        h0$c.c(q$a$b, l10, (TimeUnit)((Object)object));
    }

    public void onNext(Object object) {
        h0$c h0$c = this.d;
        q$a$c q$a$c = new q$a$c(this, object);
        long l10 = this.b;
        object = this.c;
        h0$c.c(q$a$c, l10, (TimeUnit)((Object)object));
    }

    public void onSubscribe(e object) {
        e e10 = this.f;
        boolean bl2 = SubscriptionHelper.validate(e10, (e)object);
        if (bl2) {
            this.f = object;
            object = this.a;
            object.onSubscribe(this);
        }
    }

    public void request(long l10) {
        this.f.request(l10);
    }
}

