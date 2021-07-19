/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.a1.a;
import e.a.l0;
import e.a.o;
import e.a.v0.b;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

public final class l$a
implements o,
e.a.s0.b {
    public final l0 a;
    public final b b;
    public final Object c;
    public e d;
    public boolean e;

    public l$a(l0 l02, Object object, b b10) {
        this.a = l02;
        this.b = b10;
        this.c = object;
    }

    public void dispose() {
        this.d.cancel();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        this.d = subscriptionHelper;
    }

    public boolean isDisposed() {
        boolean bl2;
        e e10 = this.d;
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
        boolean bl2 = this.e;
        if (bl2) {
            return;
        }
        this.e = true;
        Object object = SubscriptionHelper.CANCELLED;
        this.d = object;
        object = this.a;
        Object object2 = this.c;
        object.onSuccess(object2);
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.e;
        if (bl2) {
            e.a.a1.a.Y(throwable);
            return;
        }
        this.e = true;
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        this.d = subscriptionHelper;
        this.a.onError(throwable);
    }

    public void onNext(Object object) {
        boolean bl2 = this.e;
        if (bl2) {
            return;
        }
        Object object2 = this.b;
        Object object3 = this.c;
        try {
            object2.accept(object3, object);
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            object2 = this.d;
            object2.cancel();
            this.onError(throwable);
        }
    }

    public void onSubscribe(e e10) {
        Object object = this.d;
        boolean bl2 = SubscriptionHelper.validate((e)object, e10);
        if (bl2) {
            this.d = e10;
            object = this.a;
            object.onSubscribe(this);
            long l10 = Long.MAX_VALUE;
            e10.request(l10);
        }
    }
}

