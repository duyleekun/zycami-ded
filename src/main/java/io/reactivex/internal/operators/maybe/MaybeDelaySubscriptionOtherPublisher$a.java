/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.a1.a;
import e.a.o;
import e.a.s0.b;
import e.a.t;
import e.a.w;
import i.g.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.maybe.MaybeDelaySubscriptionOtherPublisher$DelayMaybeObserver;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

public final class MaybeDelaySubscriptionOtherPublisher$a
implements o,
b {
    public final MaybeDelaySubscriptionOtherPublisher$DelayMaybeObserver a;
    public w b;
    public e c;

    public MaybeDelaySubscriptionOtherPublisher$a(t t10, w w10) {
        MaybeDelaySubscriptionOtherPublisher$DelayMaybeObserver maybeDelaySubscriptionOtherPublisher$DelayMaybeObserver;
        this.a = maybeDelaySubscriptionOtherPublisher$DelayMaybeObserver = new MaybeDelaySubscriptionOtherPublisher$DelayMaybeObserver(t10);
        this.b = w10;
    }

    public void a() {
        w w10 = this.b;
        this.b = null;
        MaybeDelaySubscriptionOtherPublisher$DelayMaybeObserver maybeDelaySubscriptionOtherPublisher$DelayMaybeObserver = this.a;
        w10.g(maybeDelaySubscriptionOtherPublisher$DelayMaybeObserver);
    }

    public void dispose() {
        this.c.cancel();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        this.c = subscriptionHelper;
        DisposableHelper.dispose(this.a);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.a.get());
    }

    public void onComplete() {
        e e10 = this.c;
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (e10 != subscriptionHelper) {
            this.c = subscriptionHelper;
            this.a();
        }
    }

    public void onError(Throwable throwable) {
        Object object = this.c;
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (object != subscriptionHelper) {
            this.c = subscriptionHelper;
            object = this.a.downstream;
            object.onError(throwable);
        } else {
            e.a.a1.a.Y(throwable);
        }
    }

    public void onNext(Object object) {
        object = this.c;
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (object != subscriptionHelper) {
            object.cancel();
            this.c = subscriptionHelper;
            this.a();
        }
    }

    public void onSubscribe(e e10) {
        Object object = this.c;
        boolean bl2 = SubscriptionHelper.validate((e)object, e10);
        if (bl2) {
            this.c = e10;
            object = this.a.downstream;
            object.onSubscribe(this);
            long l10 = Long.MAX_VALUE;
            e10.request(l10);
        }
    }
}

