/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.a1.a;
import e.a.l0;
import e.a.o;
import e.a.s0.b;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.NoSuchElementException;

public final class a1$a
implements o,
b {
    public final l0 a;
    public final Object b;
    public e c;
    public boolean d;
    public Object e;

    public a1$a(l0 l02, Object object) {
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
        boolean bl2 = this.d;
        if (bl2) {
            return;
        }
        this.d = bl2 = true;
        Object object = SubscriptionHelper.CANCELLED;
        this.c = object;
        object = this.e;
        Object object2 = null;
        this.e = null;
        if (object == null) {
            object = this.b;
        }
        if (object != null) {
            object2 = this.a;
            object2.onSuccess(object);
        } else {
            object = this.a;
            object2 = new NoSuchElementException();
            object.onError((Throwable)object2);
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
        boolean bl2 = this.d;
        if (bl2) {
            return;
        }
        Object object2 = this.e;
        if (object2 != null) {
            this.d = true;
            this.c.cancel();
            this.c = object = SubscriptionHelper.CANCELLED;
            object = this.a;
            object2 = new IllegalArgumentException("Sequence contains more than one element!");
            object.onError((Throwable)object2);
            return;
        }
        this.e = object;
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

