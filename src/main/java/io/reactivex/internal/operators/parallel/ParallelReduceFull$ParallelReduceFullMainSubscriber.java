/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.parallel;

import e.a.a1.a;
import e.a.v0.c;
import i.g.d;
import io.reactivex.internal.operators.parallel.ParallelReduceFull$ParallelReduceFullInnerSubscriber;
import io.reactivex.internal.operators.parallel.ParallelReduceFull$SlotPair;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ParallelReduceFull$ParallelReduceFullMainSubscriber
extends DeferredScalarSubscription {
    private static final long serialVersionUID = -5370107872170712765L;
    public final AtomicReference current;
    public final AtomicReference error;
    public final c reducer;
    public final AtomicInteger remaining;
    public final ParallelReduceFull$ParallelReduceFullInnerSubscriber[] subscribers;

    public ParallelReduceFull$ParallelReduceFullMainSubscriber(d parallelReduceFull$ParallelReduceFullInnerSubscriberArray, int n10, c c10) {
        super((d)parallelReduceFull$ParallelReduceFullInnerSubscriberArray);
        parallelReduceFull$ParallelReduceFullInnerSubscriberArray = new AtomicReference();
        this.current = parallelReduceFull$ParallelReduceFullInnerSubscriberArray;
        super();
        this.remaining = parallelReduceFull$ParallelReduceFullInnerSubscriberArray;
        this.error = parallelReduceFull$ParallelReduceFullInnerSubscriberArray = new AtomicReference();
        parallelReduceFull$ParallelReduceFullInnerSubscriberArray = new ParallelReduceFull$ParallelReduceFullInnerSubscriber[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            ParallelReduceFull$ParallelReduceFullInnerSubscriber parallelReduceFull$ParallelReduceFullInnerSubscriber;
            parallelReduceFull$ParallelReduceFullInnerSubscriberArray[i10] = parallelReduceFull$ParallelReduceFullInnerSubscriber = new ParallelReduceFull$ParallelReduceFullInnerSubscriber(this, c10);
        }
        this.subscribers = parallelReduceFull$ParallelReduceFullInnerSubscriberArray;
        this.reducer = c10;
        this.remaining.lazySet(n10);
    }

    public ParallelReduceFull$SlotPair addValue(Object object) {
        int n10;
        ParallelReduceFull$SlotPair parallelReduceFull$SlotPair;
        while (true) {
            AtomicReference atomicReference;
            if ((parallelReduceFull$SlotPair = (ParallelReduceFull$SlotPair)this.current.get()) == null && (n10 = (int)((atomicReference = this.current).compareAndSet(null, parallelReduceFull$SlotPair = new ParallelReduceFull$SlotPair()) ? 1 : 0)) == 0) {
                continue;
            }
            n10 = parallelReduceFull$SlotPair.tryAcquireSlot();
            if (n10 >= 0) break;
            atomicReference = this.current;
            atomicReference.compareAndSet(parallelReduceFull$SlotPair, null);
        }
        if (n10 == 0) {
            parallelReduceFull$SlotPair.first = object;
        } else {
            parallelReduceFull$SlotPair.second = object;
        }
        boolean bl2 = parallelReduceFull$SlotPair.releaseSlot();
        if (bl2) {
            this.current.compareAndSet(parallelReduceFull$SlotPair, null);
            return parallelReduceFull$SlotPair;
        }
        return null;
    }

    public void cancel() {
        for (ParallelReduceFull$ParallelReduceFullInnerSubscriber parallelReduceFull$ParallelReduceFullInnerSubscriber : this.subscribers) {
            parallelReduceFull$ParallelReduceFullInnerSubscriber.cancel();
        }
    }

    public void innerComplete(Object object) {
        int n10;
        Object object2;
        Object object3;
        if (object != null) {
            while ((object = this.addValue(object)) != null) {
                try {
                    object3 = this.reducer;
                }
                catch (Throwable throwable) {
                    e.a.t0.a.b(throwable);
                    this.innerError(throwable);
                    return;
                }
                object2 = ((ParallelReduceFull$SlotPair)object).first;
                object = ((ParallelReduceFull$SlotPair)object).second;
                object = object3.apply(object2, object);
                object3 = "The reducer returned a null value";
                object = e.a.w0.b.a.g(object, (String)object3);
            }
        }
        if ((n10 = ((AtomicInteger)(object = this.remaining)).decrementAndGet()) == 0) {
            object = (ParallelReduceFull$SlotPair)this.current.get();
            object3 = this.current;
            object2 = null;
            ((AtomicReference)object3).lazySet(null);
            if (object != null) {
                object = ((ParallelReduceFull$SlotPair)object).first;
                this.complete(object);
            } else {
                object = this.downstream;
                object.onComplete();
            }
        }
    }

    public void innerError(Throwable throwable) {
        Object object = this.error;
        boolean bl2 = ((AtomicReference)object).compareAndSet(null, throwable);
        if (bl2) {
            this.cancel();
            object = this.downstream;
            object.onError(throwable);
        } else {
            object = this.error.get();
            if (throwable != object) {
                a.Y(throwable);
            }
        }
    }
}

