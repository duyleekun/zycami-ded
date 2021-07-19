/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.processors;

import e.a.a1.a;
import e.a.w0.i.b;
import i.g.d;
import i.g.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.processors.PublishProcessor;
import java.util.concurrent.atomic.AtomicLong;

public final class PublishProcessor$PublishSubscription
extends AtomicLong
implements e {
    private static final long serialVersionUID = 3562861878281475070L;
    public final d downstream;
    public final PublishProcessor parent;

    public PublishProcessor$PublishSubscription(d d10, PublishProcessor publishProcessor) {
        this.downstream = d10;
        this.parent = publishProcessor;
    }

    public void cancel() {
        long l10 = Long.MIN_VALUE;
        long l11 = this.getAndSet(l10);
        long l12 = l11 - l10;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            PublishProcessor publishProcessor = this.parent;
            publishProcessor.S8(this);
        }
    }

    public boolean isCancelled() {
        long l10;
        long l11 = this.get();
        long l12 = l11 - (l10 = Long.MIN_VALUE);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object == false ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public boolean isFull() {
        long l10;
        long l11 = this.get();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object == false ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public void onComplete() {
        long l10;
        long l11 = this.get();
        long l12 = l11 - (l10 = Long.MIN_VALUE);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            d d10 = this.downstream;
            d10.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        long l10;
        long l11 = this.get();
        long l12 = l11 - (l10 = Long.MIN_VALUE);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            d d10 = this.downstream;
            d10.onError(throwable);
        } else {
            a.Y(throwable);
        }
    }

    public void onNext(Object object) {
        long l10;
        long l11 = this.get();
        long l12 = l11 - (l10 = Long.MIN_VALUE);
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 == false) {
            return;
        }
        l10 = 0L;
        long l13 = l11 - l10;
        Object object3 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object3 != false) {
            d d10 = this.downstream;
            d10.onNext(object);
            l11 = 1L;
            b.f(this, l11);
        } else {
            this.cancel();
            object = this.downstream;
            String string2 = "Could not emit value due to lack of requests";
            MissingBackpressureException missingBackpressureException = new MissingBackpressureException(string2);
            object.onError(missingBackpressureException);
        }
    }

    public void request(long l10) {
        boolean bl2 = SubscriptionHelper.validate(l10);
        if (bl2) {
            b.b(this, l10);
        }
    }
}

