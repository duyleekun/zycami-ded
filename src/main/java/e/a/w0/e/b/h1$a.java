/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.c1.d;
import e.a.h0;
import e.a.o;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;

public final class h1$a
implements o,
e {
    public final i.g.d a;
    public final TimeUnit b;
    public final h0 c;
    public e d;
    public long e;

    public h1$a(i.g.d d10, TimeUnit timeUnit, h0 h02) {
        this.a = d10;
        this.c = h02;
        this.b = timeUnit;
    }

    public void cancel() {
        this.d.cancel();
    }

    public void onComplete() {
        this.a.onComplete();
    }

    public void onError(Throwable throwable) {
        this.a.onError(throwable);
    }

    public void onNext(Object object) {
        h0 h02 = this.c;
        TimeUnit timeUnit = this.b;
        long l10 = h02.d(timeUnit);
        long l11 = this.e;
        this.e = l10;
        i.g.d d10 = this.a;
        TimeUnit timeUnit2 = this.b;
        d d11 = new d(object, l10 -= l11, timeUnit2);
        d10.onNext(d11);
    }

    public void onSubscribe(e object) {
        Object object2 = this.d;
        boolean bl2 = SubscriptionHelper.validate((e)object2, (e)object);
        if (bl2) {
            long l10;
            object2 = this.c;
            TimeUnit timeUnit = this.b;
            this.e = l10 = ((h0)object2).d(timeUnit);
            this.d = object;
            object = this.a;
            object.onSubscribe(this);
        }
    }

    public void request(long l10) {
        this.d.request(l10);
    }
}

