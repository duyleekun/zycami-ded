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

public final class z$a
implements o,
b {
    public final l0 a;
    public final long b;
    public final Object c;
    public e d;
    public long e;
    public boolean f;

    public z$a(l0 l02, long l10, Object object) {
        this.a = l02;
        this.b = l10;
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
        Object object = SubscriptionHelper.CANCELLED;
        this.d = object;
        boolean bl2 = this.f;
        if (!bl2) {
            this.f = bl2 = true;
            object = this.c;
            if (object != null) {
                l0 l02 = this.a;
                l02.onSuccess(object);
            } else {
                object = this.a;
                NoSuchElementException noSuchElementException = new NoSuchElementException();
                object.onError(noSuchElementException);
            }
        }
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.f;
        if (bl2) {
            e.a.a1.a.Y(throwable);
            return;
        }
        this.f = true;
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        this.d = subscriptionHelper;
        this.a.onError(throwable);
    }

    public void onNext(Object object) {
        boolean bl2 = this.f;
        if (bl2) {
            return;
        }
        long l10 = this.e;
        long l11 = this.b;
        long l12 = l10 - l11;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 == false) {
            this.f = true;
            this.d.cancel();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            this.d = subscriptionHelper;
            this.a.onSuccess(object);
            return;
        }
        this.e = ++l10;
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

