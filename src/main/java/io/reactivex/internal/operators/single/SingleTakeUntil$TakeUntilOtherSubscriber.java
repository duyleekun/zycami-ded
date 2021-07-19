/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.o;
import i.g.e;
import io.reactivex.internal.operators.single.SingleTakeUntil$TakeUntilMainObserver;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleTakeUntil$TakeUntilOtherSubscriber
extends AtomicReference
implements o {
    private static final long serialVersionUID = 5170026210238877381L;
    public final SingleTakeUntil$TakeUntilMainObserver parent;

    public SingleTakeUntil$TakeUntilOtherSubscriber(SingleTakeUntil$TakeUntilMainObserver singleTakeUntil$TakeUntilMainObserver) {
        this.parent = singleTakeUntil$TakeUntilMainObserver;
    }

    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    public void onComplete() {
        Object object;
        Object object2 = this.get();
        if (object2 != (object = SubscriptionHelper.CANCELLED)) {
            this.lazySet(object);
            object2 = this.parent;
            object = new CancellationException();
            ((SingleTakeUntil$TakeUntilMainObserver)object2).otherError((Throwable)object);
        }
    }

    public void onError(Throwable throwable) {
        this.parent.otherError(throwable);
    }

    public void onNext(Object object) {
        boolean bl2 = SubscriptionHelper.cancel(this);
        if (bl2) {
            object = this.parent;
            CancellationException cancellationException = new CancellationException();
            ((SingleTakeUntil$TakeUntilMainObserver)object).otherError(cancellationException);
        }
    }

    public void onSubscribe(e e10) {
        SubscriptionHelper.setOnce(this, e10, Long.MAX_VALUE);
    }
}

