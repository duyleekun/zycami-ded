/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.o;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableAmb$a;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableAmb$AmbInnerSubscriber
extends AtomicReference
implements o,
e {
    private static final long serialVersionUID = -1185974347409665484L;
    public final d downstream;
    public final int index;
    public final AtomicLong missedRequested;
    public final FlowableAmb$a parent;
    public boolean won;

    public FlowableAmb$AmbInnerSubscriber(FlowableAmb$a flowableAmb$a, int n10, d d10) {
        AtomicLong atomicLong;
        this.missedRequested = atomicLong = new AtomicLong();
        this.parent = flowableAmb$a;
        this.index = n10;
        this.downstream = d10;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public void onComplete() {
        boolean bl2 = this.won;
        if (bl2) {
            d d10 = this.downstream;
            d10.onComplete();
        } else {
            Object object = this.parent;
            int n10 = this.index;
            bl2 = ((FlowableAmb$a)object).b(n10);
            if (bl2) {
                this.won = bl2 = true;
                object = this.downstream;
                object.onComplete();
            } else {
                object = (e)this.get();
                object.cancel();
            }
        }
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.won;
        if (bl2) {
            d d10 = this.downstream;
            d10.onError(throwable);
        } else {
            Object object = this.parent;
            int n10 = this.index;
            bl2 = ((FlowableAmb$a)object).b(n10);
            if (bl2) {
                this.won = bl2 = true;
                object = this.downstream;
                object.onError(throwable);
            } else {
                object = (e)this.get();
                object.cancel();
                a.Y(throwable);
            }
        }
    }

    public void onNext(Object object) {
        boolean bl2 = this.won;
        if (bl2) {
            d d10 = this.downstream;
            d10.onNext(object);
        } else {
            Object object2 = this.parent;
            int n10 = this.index;
            bl2 = ((FlowableAmb$a)object2).b(n10);
            if (bl2) {
                this.won = bl2 = true;
                object2 = this.downstream;
                object2.onNext(object);
            } else {
                object = (e)this.get();
                object.cancel();
            }
        }
    }

    public void onSubscribe(e e10) {
        AtomicLong atomicLong = this.missedRequested;
        SubscriptionHelper.deferredSetOnce(this, atomicLong, e10);
    }

    public void request(long l10) {
        AtomicLong atomicLong = this.missedRequested;
        SubscriptionHelper.deferredRequest(this, atomicLong, l10);
    }
}

