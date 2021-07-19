/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.o;
import i.g.c;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;

public final class d1$a
implements o {
    public final d a;
    public final c b;
    public final SubscriptionArbiter c;
    public boolean d;

    public d1$a(d object, c c10) {
        this.a = object;
        this.b = c10;
        this.d = true;
        this.c = object = new SubscriptionArbiter(false);
    }

    public void onComplete() {
        boolean bl2 = this.d;
        if (bl2) {
            bl2 = false;
            this.d = false;
            c c10 = this.b;
            c10.subscribe(this);
        } else {
            d d10 = this.a;
            d10.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        this.a.onError(throwable);
    }

    public void onNext(Object object) {
        boolean bl2 = this.d;
        if (bl2) {
            bl2 = false;
            this.d = false;
        }
        this.a.onNext(object);
    }

    public void onSubscribe(e e10) {
        this.c.setSubscription(e10);
    }
}

