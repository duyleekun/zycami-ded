/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.o;
import e.a.t0.a;
import e.a.v0.r;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

public final class c1$a
implements o,
e {
    public final d a;
    public final r b;
    public e c;
    public boolean d;

    public c1$a(d d10, r r10) {
        this.a = d10;
        this.b = r10;
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

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void onNext(Object object) {
        Object object2;
        boolean bl2 = this.d;
        if (bl2) {
            d d10 = this.a;
            d10.onNext(object);
            return;
        }
        try {
            object2 = this.b;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.c.cancel();
            this.a.onError(throwable);
            return;
        }
        bl2 = object2.test(object);
        if (bl2) {
            object = this.c;
            long l10 = 1L;
            object.request(l10);
            return;
        }
        this.d = bl2 = true;
        object2 = this.a;
        object2.onNext(object);
    }

    public void onSubscribe(e object) {
        e e10 = this.c;
        boolean bl2 = SubscriptionHelper.validate(e10, (e)object);
        if (bl2) {
            this.c = object;
            object = this.a;
            object.onSubscribe(this);
        }
    }

    public void request(long l10) {
        this.c.request(l10);
    }
}

