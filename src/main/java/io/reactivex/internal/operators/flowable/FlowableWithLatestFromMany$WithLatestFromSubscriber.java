/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.v0.o;
import e.a.w0.i.g;
import i.g.c;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany$WithLatestInnerSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class FlowableWithLatestFromMany$WithLatestFromSubscriber
extends AtomicInteger
implements e.a.w0.c.a,
e {
    private static final long serialVersionUID = 1577321883966341961L;
    public final o combiner;
    public volatile boolean done;
    public final d downstream;
    public final AtomicThrowable error;
    public final AtomicLong requested;
    public final FlowableWithLatestFromMany$WithLatestInnerSubscriber[] subscribers;
    public final AtomicReference upstream;
    public final AtomicReferenceArray values;

    public FlowableWithLatestFromMany$WithLatestFromSubscriber(d object, o o10, int n10) {
        this.downstream = object;
        this.combiner = o10;
        object = new FlowableWithLatestFromMany$WithLatestInnerSubscriber[n10];
        o10 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            FlowableWithLatestFromMany$WithLatestInnerSubscriber flowableWithLatestFromMany$WithLatestInnerSubscriber;
            object[i10] = flowableWithLatestFromMany$WithLatestInnerSubscriber = new FlowableWithLatestFromMany$WithLatestInnerSubscriber(this, i10);
        }
        this.subscribers = object;
        super(n10);
        this.values = object;
        super();
        this.upstream = object;
        super();
        this.requested = object;
        super();
        this.error = object;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
        for (FlowableWithLatestFromMany$WithLatestInnerSubscriber flowableWithLatestFromMany$WithLatestInnerSubscriber : this.subscribers) {
            flowableWithLatestFromMany$WithLatestInnerSubscriber.dispose();
        }
    }

    public void cancelAllBut(int n10) {
        int n11;
        FlowableWithLatestFromMany$WithLatestInnerSubscriber[] flowableWithLatestFromMany$WithLatestInnerSubscriberArray = this.subscribers;
        for (int i10 = 0; i10 < (n11 = flowableWithLatestFromMany$WithLatestInnerSubscriberArray.length); ++i10) {
            if (i10 == n10) continue;
            FlowableWithLatestFromMany$WithLatestInnerSubscriber flowableWithLatestFromMany$WithLatestInnerSubscriber = flowableWithLatestFromMany$WithLatestInnerSubscriberArray[i10];
            flowableWithLatestFromMany$WithLatestInnerSubscriber.dispose();
        }
    }

    public void innerComplete(int n10, boolean bl2) {
        if (!bl2) {
            this.done = bl2 = true;
            SubscriptionHelper.cancel(this.upstream);
            this.cancelAllBut(n10);
            d d10 = this.downstream;
            AtomicThrowable atomicThrowable = this.error;
            g.b(d10, this, atomicThrowable);
        }
    }

    public void innerError(int n10, Throwable throwable) {
        this.done = true;
        SubscriptionHelper.cancel(this.upstream);
        this.cancelAllBut(n10);
        d d10 = this.downstream;
        AtomicThrowable atomicThrowable = this.error;
        g.d(d10, throwable, this, atomicThrowable);
    }

    public void innerNext(int n10, Object object) {
        this.values.set(n10, object);
    }

    public void onComplete() {
        int n10 = this.done;
        if (n10 == 0) {
            this.done = true;
            n10 = -1;
            this.cancelAllBut(n10);
            d d10 = this.downstream;
            AtomicThrowable atomicThrowable = this.error;
            g.b(d10, this, atomicThrowable);
        }
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.done;
        if (bl2) {
            a.Y(throwable);
            return;
        }
        this.done = true;
        this.cancelAllBut(-1);
        d d10 = this.downstream;
        AtomicThrowable atomicThrowable = this.error;
        g.d(d10, throwable, this, atomicThrowable);
    }

    public void onNext(Object object) {
        boolean bl2 = this.tryOnNext(object);
        if (!bl2 && !(bl2 = this.done)) {
            object = (e)this.upstream.get();
            long l10 = 1L;
            object.request(l10);
        }
    }

    public void onSubscribe(e e10) {
        AtomicReference atomicReference = this.upstream;
        AtomicLong atomicLong = this.requested;
        SubscriptionHelper.deferredSetOnce(atomicReference, atomicLong, e10);
    }

    public void request(long l10) {
        AtomicReference atomicReference = this.upstream;
        AtomicLong atomicLong = this.requested;
        SubscriptionHelper.deferredRequest(atomicReference, atomicLong, l10);
    }

    public void subscribe(c[] cArray, int n10) {
        FlowableWithLatestFromMany$WithLatestInnerSubscriber[] flowableWithLatestFromMany$WithLatestInnerSubscriberArray = this.subscribers;
        AtomicReference atomicReference = this.upstream;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object;
            Object object2 = atomicReference.get();
            if (object2 == (object = SubscriptionHelper.CANCELLED)) {
                return;
            }
            object2 = cArray[i10];
            object = flowableWithLatestFromMany$WithLatestInnerSubscriberArray[i10];
            object2.subscribe((d)object);
        }
    }

    public boolean tryOnNext(Object object) {
        boolean bl2 = this.done;
        AtomicThrowable atomicThrowable = null;
        if (bl2) {
            return false;
        }
        Object object2 = this.values;
        int n10 = ((AtomicReferenceArray)object2).length();
        int n11 = n10 + 1;
        Object[] objectArray = new Object[n11];
        objectArray[0] = object;
        int n12 = 0;
        object = null;
        while (n12 < n10) {
            Object e10 = ((AtomicReferenceArray)object2).get(n12);
            if (e10 == null) {
                return false;
            }
            objectArray[++n12] = e10;
        }
        try {
            object = this.combiner;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.cancel();
            this.onError(throwable);
            return false;
        }
        object = object.apply(objectArray);
        object2 = "The combiner returned a null value";
        object = e.a.w0.b.a.g(object, (String)object2);
        object2 = this.downstream;
        atomicThrowable = this.error;
        g.f((d)object2, object, this, atomicThrowable);
        return true;
    }
}

