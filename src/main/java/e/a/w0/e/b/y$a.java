/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.a1.a;
import e.a.o;
import e.a.s0.b;
import e.a.t;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

public final class y$a
implements o,
b {
    public final t a;
    public final long b;
    public e c;
    public long d;
    public boolean e;

    public y$a(t t10, long l10) {
        this.a = t10;
        this.b = l10;
    }

    public void dispose() {
        this.c.cancel();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        this.c = subscriptionHelper;
    }

    public boolean isDisposed() {
        boolean bl2;
        e e10 = this.c;
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
        Object object = SubscriptionHelper.CANCELLED;
        this.c = object;
        boolean bl2 = this.e;
        if (!bl2) {
            this.e = bl2 = true;
            object = this.a;
            object.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.e;
        if (bl2) {
            e.a.a1.a.Y(throwable);
            return;
        }
        this.e = true;
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        this.c = subscriptionHelper;
        this.a.onError(throwable);
    }

    public void onNext(Object object) {
        boolean bl2 = this.e;
        if (bl2) {
            return;
        }
        long l10 = this.d;
        long l11 = this.b;
        long l12 = l10 - l11;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 == false) {
            this.e = true;
            this.c.cancel();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            this.c = subscriptionHelper;
            this.a.onSuccess(object);
            return;
        }
        this.d = ++l10;
    }

    public void onSubscribe(e e10) {
        Object object = this.c;
        boolean bl2 = SubscriptionHelper.validate((e)object, e10);
        if (bl2) {
            this.c = e10;
            object = this.a;
            object.onSubscribe(this);
            long l10 = Long.MAX_VALUE;
            e10.request(l10);
        }
    }
}

