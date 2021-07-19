/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.o;
import e.a.s0.b;
import e.a.t;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

public final class m0$a
implements o,
b {
    public final t a;
    public e b;
    public Object c;

    public m0$a(t t10) {
        this.a = t10;
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
        Object object = SubscriptionHelper.CANCELLED;
        this.b = object;
        object = this.c;
        if (object != null) {
            this.c = null;
            t t10 = this.a;
            t10.onSuccess(object);
        } else {
            object = this.a;
            object.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        this.b = subscriptionHelper;
        this.c = null;
        this.a.onError(throwable);
    }

    public void onNext(Object object) {
        this.c = object;
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

