/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.d;
import e.a.o;
import e.a.s0.b;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

public final class k0$a
implements o,
b {
    public final d a;
    public e b;

    public k0$a(d d10) {
        this.a = d10;
    }

    public void dispose() {
        this.b.cancel();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        this.b = subscriptionHelper;
    }

    public boolean isDisposed() {
        boolean bl2;
        e e10 = this.b;
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (e10 == subscriptionHelper) {
            bl2 = true;
        } else {
            bl2 = false;
            e10 = null;
        }
        return bl2;
    }

    public void onComplete() {
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        this.b = subscriptionHelper;
        this.a.onComplete();
    }

    public void onError(Throwable throwable) {
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        this.b = subscriptionHelper;
        this.a.onError(throwable);
    }

    public void onNext(Object object) {
    }

    public void onSubscribe(e e10) {
        Object object = this.b;
        boolean bl2 = SubscriptionHelper.validate((e)object, e10);
        if (bl2) {
            this.b = e10;
            object = this.a;
            object.onSubscribe(this);
            long l10 = Long.MAX_VALUE;
            e10.request(l10);
        }
    }
}

