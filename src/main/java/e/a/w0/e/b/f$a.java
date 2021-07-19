/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.a1.a;
import e.a.l0;
import e.a.o;
import e.a.s0.b;
import e.a.v0.r;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

public final class f$a
implements o,
b {
    public final l0 a;
    public final r b;
    public e c;
    public boolean d;

    public f$a(l0 l02, r r10) {
        this.a = l02;
        this.b = r10;
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
        boolean bl2 = this.d;
        if (!bl2) {
            this.d = bl2 = true;
            Object object = SubscriptionHelper.CANCELLED;
            this.c = object;
            object = this.a;
            Boolean bl3 = Boolean.FALSE;
            object.onSuccess(bl3);
        }
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.d;
        if (bl2) {
            e.a.a1.a.Y(throwable);
            return;
        }
        this.d = true;
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        this.c = subscriptionHelper;
        this.a.onError(throwable);
    }

    public void onNext(Object object) {
        Object object2;
        boolean bl2 = this.d;
        if (bl2) {
            return;
        }
        try {
            object2 = this.b;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.c.cancel();
            this.c = object2 = SubscriptionHelper.CANCELLED;
            this.onError(throwable);
            return;
        }
        boolean bl3 = object2.test(object);
        if (bl3) {
            this.d = bl3 = true;
            this.c.cancel();
            this.c = object = SubscriptionHelper.CANCELLED;
            object = this.a;
            object2 = Boolean.TRUE;
            object.onSuccess(object2);
        }
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

