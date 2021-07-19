/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.a1.a;
import e.a.l0;
import e.a.o;
import e.a.s0.b;
import e.a.v0.c;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

public final class u0$a
implements o,
b {
    public final l0 a;
    public final c b;
    public Object c;
    public e d;

    public u0$a(l0 l02, c c10, Object object) {
        this.a = l02;
        this.c = object;
        this.b = c10;
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
        Object object = this.c;
        if (object != null) {
            this.c = null;
            Object object2 = SubscriptionHelper.CANCELLED;
            this.d = object2;
            object2 = this.a;
            object2.onSuccess(object);
        }
    }

    public void onError(Throwable throwable) {
        Object object = this.c;
        if (object != null) {
            this.c = null;
            this.d = object = SubscriptionHelper.CANCELLED;
            object = this.a;
            object.onError(throwable);
        } else {
            e.a.a1.a.Y(throwable);
        }
    }

    public void onNext(Object object) {
        Object object2 = this.c;
        if (object2 != null) {
            c c10 = this.b;
            object = c10.apply(object2, object);
            object2 = "The reducer returned a null value";
            object = e.a.w0.b.a.g(object, (String)object2);
            try {
                this.c = object;
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                object2 = this.d;
                object2.cancel();
                this.onError(throwable);
            }
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

