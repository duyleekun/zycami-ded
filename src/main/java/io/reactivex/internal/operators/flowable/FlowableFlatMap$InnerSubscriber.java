/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.s0.b;
import e.a.w0.c.l;
import e.a.w0.c.o;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableFlatMap$MergeSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableFlatMap$InnerSubscriber
extends AtomicReference
implements e.a.o,
b {
    private static final long serialVersionUID = -4606175640614850599L;
    public final int bufferSize;
    public volatile boolean done;
    public int fusionMode;
    public final long id;
    public final int limit;
    public final FlowableFlatMap$MergeSubscriber parent;
    public long produced;
    public volatile o queue;

    public FlowableFlatMap$InnerSubscriber(FlowableFlatMap$MergeSubscriber flowableFlatMap$MergeSubscriber, long l10) {
        int n10;
        this.id = l10;
        this.parent = flowableFlatMap$MergeSubscriber;
        this.bufferSize = n10 = flowableFlatMap$MergeSubscriber.bufferSize;
        this.limit = n10 >>= 2;
    }

    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    public boolean isDisposed() {
        boolean bl2;
        SubscriptionHelper subscriptionHelper;
        Object v10 = this.get();
        if (v10 == (subscriptionHelper = SubscriptionHelper.CANCELLED)) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
    }

    public void onComplete() {
        this.done = true;
        this.parent.drain();
    }

    public void onError(Throwable throwable) {
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        this.lazySet(subscriptionHelper);
        this.parent.innerError(this, throwable);
    }

    public void onNext(Object object) {
        int n10 = this.fusionMode;
        int n11 = 2;
        if (n10 != n11) {
            FlowableFlatMap$MergeSubscriber flowableFlatMap$MergeSubscriber = this.parent;
            flowableFlatMap$MergeSubscriber.tryEmit(object, this);
        } else {
            object = this.parent;
            ((FlowableFlatMap$MergeSubscriber)object).drain();
        }
    }

    public void onSubscribe(e e10) {
        int n10 = SubscriptionHelper.setOnce(this, e10);
        if (n10 != 0) {
            n10 = e10 instanceof l;
            if (n10 != 0) {
                int n11;
                e e11 = e10;
                e11 = (l)e10;
                int n12 = e11.requestFusion(7);
                if (n12 == (n11 = 1)) {
                    this.fusionMode = n12;
                    this.queue = e11;
                    this.done = n11;
                    this.parent.drain();
                    return;
                }
                n11 = 2;
                if (n12 == n11) {
                    this.fusionMode = n12;
                    this.queue = e11;
                }
            }
            n10 = this.bufferSize;
            long l10 = n10;
            e10.request(l10);
        }
    }

    public void requestMore(long l10) {
        int n10 = this.fusionMode;
        int n11 = 1;
        if (n10 != n11) {
            long l11 = this.produced + l10;
            long l12 = l11 - (l10 = (long)this.limit);
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object >= 0) {
                this.produced = l10 = 0L;
                e e10 = (e)this.get();
                e10.request(l11);
            } else {
                this.produced = l11;
            }
        }
    }
}

