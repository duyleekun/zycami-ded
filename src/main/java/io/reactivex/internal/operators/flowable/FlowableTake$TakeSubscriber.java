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
import java.util.concurrent.atomic.AtomicBoolean;

public final class FlowableTake$TakeSubscriber
extends AtomicBoolean
implements o,
e {
    private static final long serialVersionUID = -5636543848937116287L;
    public boolean done;
    public final d downstream;
    public final long limit;
    public long remaining;
    public e upstream;

    public FlowableTake$TakeSubscriber(d d10, long l10) {
        this.downstream = d10;
        this.limit = l10;
        this.remaining = l10;
    }

    public void cancel() {
        this.upstream.cancel();
    }

    public void onComplete() {
        boolean bl2 = this.done;
        if (!bl2) {
            this.done = bl2 = true;
            d d10 = this.downstream;
            d10.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.done;
        if (!bl2) {
            this.done = bl2 = true;
            this.upstream.cancel();
            d d10 = this.downstream;
            d10.onError(throwable);
        } else {
            a.Y(throwable);
        }
    }

    public void onNext(Object object) {
        Object object2 = this.done;
        if (object2 == 0) {
            long l10;
            long l11 = this.remaining;
            this.remaining = l10 = l11 - 1L;
            long l12 = 0L;
            long l13 = l11 - l12;
            object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object2 > 0) {
                object2 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
                object2 = object2 == 0 ? 1 : 0;
                d d10 = this.downstream;
                d10.onNext(object);
                if (object2 != 0) {
                    object = this.upstream;
                    object.cancel();
                    this.onComplete();
                }
            }
        }
    }

    public void onSubscribe(e object) {
        e e10 = this.upstream;
        Object object2 = SubscriptionHelper.validate(e10, (e)object);
        if (object2) {
            this.upstream = object;
            long l10 = this.limit;
            long l11 = 0L;
            long l12 = l10 - l11;
            object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (!object2) {
                boolean bl2;
                object.cancel();
                this.done = bl2 = true;
                object = this.downstream;
                EmptySubscription.complete((d)object);
            } else {
                object = this.downstream;
                object.onSubscribe(this);
            }
        }
    }

    public void request(long l10) {
        long l11;
        long l12;
        boolean bl2;
        int n10 = SubscriptionHelper.validate(l10);
        if (n10 == 0) {
            return;
        }
        n10 = this.get();
        if (n10 == 0 && (n10 = this.compareAndSet(false, bl2 = true)) != 0 && (n10 = (l12 = l10 - (l11 = this.limit)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) >= 0) {
            this.upstream.request(Long.MAX_VALUE);
            return;
        }
        this.upstream.request(l10);
    }
}

