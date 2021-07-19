/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.o;
import e.a.t;
import i.g.e;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeDelayOtherPublisher$OtherSubscriber
extends AtomicReference
implements o {
    private static final long serialVersionUID = -1215060610805418006L;
    public final t downstream;
    public Throwable error;
    public Object value;

    public MaybeDelayOtherPublisher$OtherSubscriber(t t10) {
        this.downstream = t10;
    }

    public void onComplete() {
        Object object = this.error;
        if (object != null) {
            t t10 = this.downstream;
            t10.onError((Throwable)object);
        } else {
            object = this.value;
            if (object != null) {
                t t11 = this.downstream;
                t11.onSuccess(object);
            } else {
                object = this.downstream;
                object.onComplete();
            }
        }
    }

    public void onError(Throwable throwable) {
        Object object = this.error;
        if (object == null) {
            object = this.downstream;
            object.onError(throwable);
        } else {
            t t10 = this.downstream;
            int n10 = 2;
            Throwable[] throwableArray = new Throwable[n10];
            throwableArray[0] = object;
            int n11 = 1;
            throwableArray[n11] = throwable;
            CompositeException compositeException = new CompositeException(throwableArray);
            t10.onError(compositeException);
        }
    }

    public void onNext(Object object) {
        SubscriptionHelper subscriptionHelper;
        object = (e)this.get();
        if (object != (subscriptionHelper = SubscriptionHelper.CANCELLED)) {
            this.lazySet(subscriptionHelper);
            object.cancel();
            this.onComplete();
        }
    }

    public void onSubscribe(e e10) {
        SubscriptionHelper.setOnce(this, e10, Long.MAX_VALUE);
    }
}

