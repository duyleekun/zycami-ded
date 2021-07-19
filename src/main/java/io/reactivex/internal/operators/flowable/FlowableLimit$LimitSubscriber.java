/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.o;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

public final class FlowableLimit$LimitSubscriber
extends AtomicLong
implements o,
e {
    private static final long serialVersionUID = 2288246011222124525L;
    public final d downstream;
    public long remaining;
    public e upstream;

    public FlowableLimit$LimitSubscriber(d d10, long l10) {
        this.downstream = d10;
        this.remaining = l10;
        this.lazySet(l10);
    }

    public void cancel() {
        this.upstream.cancel();
    }

    public void onComplete() {
        long l10 = this.remaining;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            this.remaining = l11;
            d d10 = this.downstream;
            d10.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        long l10 = this.remaining;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            this.remaining = l11;
            d d10 = this.downstream;
            d10.onError(throwable);
        } else {
            a.Y(throwable);
        }
    }

    public void onNext(Object object) {
        long l10 = this.remaining;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 > 0) {
            long l13 = 1L;
            this.remaining = l10 -= l13;
            d d10 = this.downstream;
            d10.onNext(object);
            long l14 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l14 == false) {
                this.upstream.cancel();
                object = this.downstream;
                object.onComplete();
            }
        }
    }

    public void onSubscribe(e object) {
        e e10 = this.upstream;
        Object object2 = SubscriptionHelper.validate(e10, (e)object);
        if (object2) {
            long l10 = this.remaining;
            long l11 = 0L;
            long l12 = l10 - l11;
            object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (!object2) {
                object.cancel();
                object = this.downstream;
                EmptySubscription.complete((d)object);
            } else {
                this.upstream = object;
                object = this.downstream;
                object.onSubscribe(this);
            }
        }
    }

    public void request(long l10) {
        boolean bl2 = SubscriptionHelper.validate(l10);
        if (bl2) {
            long l11;
            long l12;
            long l13;
            Object object;
            while ((object = (l13 = (l12 = this.get()) - (l11 = 0L)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != false) {
                object = l12 == l10 ? 0 : (l12 < l10 ? -1 : 1);
                l11 = object <= 0 ? l12 : l10;
                long l14 = l12 - l11;
                bl2 = this.compareAndSet(l12, l14);
                if (!bl2) continue;
                e e10 = this.upstream;
                e10.request(l11);
                break;
            }
        }
    }
}

