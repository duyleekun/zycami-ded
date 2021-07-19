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

public final class z0$a
implements o,
b {
    public final t a;
    public e b;
    public boolean c;
    public Object d;

    public z0$a(t t10) {
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
        boolean bl2 = this.c;
        if (bl2) {
            return;
        }
        this.c = bl2 = true;
        Object object = SubscriptionHelper.CANCELLED;
        this.b = object;
        object = this.d;
        t t10 = null;
        this.d = null;
        if (object == null) {
            object = this.a;
            object.onComplete();
        } else {
            t10 = this.a;
            t10.onSuccess(object);
        }
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.c;
        if (bl2) {
            e.a.a1.a.Y(throwable);
            return;
        }
        this.c = true;
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        this.b = subscriptionHelper;
        this.a.onError(throwable);
    }

    public void onNext(Object object) {
        boolean bl2 = this.c;
        if (bl2) {
            return;
        }
        Object object2 = this.d;
        if (object2 != null) {
            this.c = true;
            this.b.cancel();
            this.b = object = SubscriptionHelper.CANCELLED;
            object = this.a;
            object2 = new IllegalArgumentException("Sequence contains more than one element!");
            object.onError((Throwable)object2);
            return;
        }
        this.d = object;
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

