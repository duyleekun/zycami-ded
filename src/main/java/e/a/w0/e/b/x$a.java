/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.a1.a;
import e.a.o;
import e.a.v0.g;
import e.a.v0.q;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

public final class x$a
implements o,
e {
    public final d a;
    public final g b;
    public final q c;
    public final e.a.v0.a d;
    public e e;

    public x$a(d d10, g g10, q q10, e.a.v0.a a10) {
        this.a = d10;
        this.b = g10;
        this.d = a10;
        this.c = q10;
    }

    public void cancel() {
        e e10 = this.e;
        Object object = SubscriptionHelper.CANCELLED;
        if (e10 != object) {
            this.e = object;
            object = this.d;
            try {
                object.run();
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                e.a.a1.a.Y(throwable);
            }
            e10.cancel();
        }
    }

    public void onComplete() {
        Object object = this.e;
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (object != subscriptionHelper) {
            object = this.a;
            object.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        Object object = this.e;
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (object != subscriptionHelper) {
            object = this.a;
            object.onError(throwable);
        } else {
            e.a.a1.a.Y(throwable);
        }
    }

    public void onNext(Object object) {
        this.a.onNext(object);
    }

    public void onSubscribe(e object) {
        Object object2;
        try {
            object2 = this.b;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            object.cancel();
            object = SubscriptionHelper.CANCELLED;
            this.e = object;
            object = this.a;
            EmptySubscription.error(throwable, (d)object);
            return;
        }
        object2.accept(object);
        object2 = this.e;
        boolean bl2 = SubscriptionHelper.validate((e)object2, (e)object);
        if (bl2) {
            this.e = object;
            object = this.a;
            object.onSubscribe(this);
        }
    }

    public void request(long l10) {
        q q10 = this.c;
        try {
            q10.a(l10);
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            e.a.a1.a.Y(throwable);
        }
        this.e.request(l10);
    }
}

