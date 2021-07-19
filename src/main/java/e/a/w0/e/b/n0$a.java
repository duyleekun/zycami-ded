/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.l0;
import e.a.o;
import e.a.s0.b;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.NoSuchElementException;

public final class n0$a
implements o,
b {
    public final l0 a;
    public final Object b;
    public e c;
    public Object d;

    public n0$a(l0 l02, Object object) {
        this.a = l02;
        this.b = object;
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
        object = this.d;
        if (object != null) {
            this.d = null;
            l0 l02 = this.a;
            l02.onSuccess(object);
        } else {
            object = this.b;
            if (object != null) {
                l0 l03 = this.a;
                l03.onSuccess(object);
            } else {
                object = this.a;
                NoSuchElementException noSuchElementException = new NoSuchElementException();
                object.onError(noSuchElementException);
            }
        }
    }

    public void onError(Throwable throwable) {
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        this.c = subscriptionHelper;
        this.d = null;
        this.a.onError(throwable);
    }

    public void onNext(Object object) {
        this.d = object;
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

