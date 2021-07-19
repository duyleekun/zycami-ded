/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.o;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

public final class b1$a
implements o,
e {
    public final d a;
    public long b;
    public e c;

    public b1$a(d d10, long l10) {
        this.a = d10;
        this.b = l10;
    }

    public void cancel() {
        this.c.cancel();
    }

    public void onComplete() {
        this.a.onComplete();
    }

    public void onError(Throwable throwable) {
        this.a.onError(throwable);
    }

    public void onNext(Object object) {
        long l10 = this.b;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 != false) {
            l11 = 1L;
            this.b = l10 -= l11;
        } else {
            d d10 = this.a;
            d10.onNext(object);
        }
    }

    public void onSubscribe(e e10) {
        e e11 = this.c;
        boolean bl2 = SubscriptionHelper.validate(e11, e10);
        if (bl2) {
            long l10 = this.b;
            this.c = e10;
            d d10 = this.a;
            d10.onSubscribe(this);
            e10.request(l10);
        }
    }

    public void request(long l10) {
        this.c.request(l10);
    }
}

