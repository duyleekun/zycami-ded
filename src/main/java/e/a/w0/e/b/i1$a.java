/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.l0;
import e.a.o;
import e.a.s0.b;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Collection;

public final class i1$a
implements o,
b {
    public final l0 a;
    public e b;
    public Collection c;

    public i1$a(l0 l02, Collection collection) {
        this.a = l02;
        this.c = collection;
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
        object = this.a;
        Collection collection = this.c;
        object.onSuccess(collection);
    }

    public void onError(Throwable throwable) {
        this.c = null;
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        this.b = subscriptionHelper;
        this.a.onError(throwable);
    }

    public void onNext(Object object) {
        this.c.add(object);
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

