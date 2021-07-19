/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.l0;
import e.a.s0.b;
import e.a.w0.c.o;
import i.g.c;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableSequenceEqual$EqualSubscriber;
import io.reactivex.internal.operators.flowable.FlowableSequenceEqual$a;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;

public final class FlowableSequenceEqualSingle$EqualCoordinator
extends AtomicInteger
implements b,
FlowableSequenceEqual$a {
    private static final long serialVersionUID = -6178010334400373240L;
    public final e.a.v0.d comparer;
    public final l0 downstream;
    public final AtomicThrowable error;
    public final FlowableSequenceEqual$EqualSubscriber first;
    public final FlowableSequenceEqual$EqualSubscriber second;
    public Object v1;
    public Object v2;

    public FlowableSequenceEqualSingle$EqualCoordinator(l0 object, int n10, e.a.v0.d d10) {
        this.downstream = object;
        this.comparer = d10;
        this.first = object = new FlowableSequenceEqual$EqualSubscriber(this, n10);
        this.second = object = new FlowableSequenceEqual$EqualSubscriber(this, n10);
        this.error = object = new AtomicThrowable();
    }

    public void cancelAndClear() {
        this.first.cancel();
        this.first.clear();
        this.second.cancel();
        this.second.clear();
    }

    public void dispose() {
        this.first.cancel();
        FlowableSequenceEqual$EqualSubscriber flowableSequenceEqual$EqualSubscriber = this.second;
        flowableSequenceEqual$EqualSubscriber.cancel();
        int n10 = this.getAndIncrement();
        if (n10 == 0) {
            this.first.clear();
            flowableSequenceEqual$EqualSubscriber = this.second;
            flowableSequenceEqual$EqualSubscriber.clear();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void drain() {
        Object object = Boolean.FALSE;
        int n10 = this.getAndIncrement();
        if (n10 != 0) {
            return;
        }
        int n11 = n10 = 1;
        do {
            Object object2 = this.first.queue;
            o o10 = this.second.queue;
            if (object2 == null || o10 == null) {
                boolean bl2 = this.isDisposed();
                if (bl2) {
                    this.first.clear();
                    this.second.clear();
                    return;
                }
                object2 = (Throwable)this.error.get();
                if (object2 != null) {
                    this.cancelAndClear();
                    object = this.downstream;
                    Throwable throwable = this.error.terminate();
                    object.onError(throwable);
                    return;
                }
            } else {
                while (true) {
                    boolean bl3;
                    if (bl3 = this.isDisposed()) {
                        this.first.clear();
                        this.second.clear();
                        return;
                    }
                    Object object3 = (Throwable)this.error.get();
                    if (object3 != null) {
                        this.cancelAndClear();
                        object = this.downstream;
                        Throwable throwable = this.error.terminate();
                        object.onError(throwable);
                        return;
                    }
                    object3 = this.first;
                    bl3 = ((FlowableSequenceEqual$EqualSubscriber)object3).done;
                    Object object4 = this.v1;
                    if (object4 == null) {
                        try {
                            this.v1 = object4 = object2.poll();
                        }
                        catch (Throwable throwable) {
                            e.a.t0.a.b(throwable);
                            this.cancelAndClear();
                            this.error.addThrowable(throwable);
                            l0 l02 = this.downstream;
                            Throwable throwable2 = this.error.terminate();
                            l02.onError(throwable2);
                            return;
                        }
                    }
                    int n12 = 0;
                    int n13 = object4 == null ? n10 : 0;
                    FlowableSequenceEqual$EqualSubscriber flowableSequenceEqual$EqualSubscriber = this.second;
                    boolean bl4 = flowableSequenceEqual$EqualSubscriber.done;
                    Object object5 = this.v2;
                    if (object5 == null) {
                        try {
                            this.v2 = object5 = o10.poll();
                        }
                        catch (Throwable throwable) {
                            e.a.t0.a.b(throwable);
                            this.cancelAndClear();
                            this.error.addThrowable(throwable);
                            l0 l03 = this.downstream;
                            Throwable throwable3 = this.error.terminate();
                            l03.onError(throwable3);
                            return;
                        }
                    }
                    if (object5 == null) {
                        n12 = n10;
                    }
                    if (bl3 && bl4 && n13 != 0 && n12 != 0) {
                        object = this.downstream;
                        Boolean bl5 = Boolean.TRUE;
                        object.onSuccess(bl5);
                        return;
                    }
                    if (bl3 && bl4 && n13 != n12) {
                        this.cancelAndClear();
                        this.downstream.onSuccess(object);
                        return;
                    }
                    if (n13 != 0 || n12 != 0) break;
                    try {
                        object3 = this.comparer;
                        bl3 = object3.a(object4, object5);
                        if (!bl3) {
                            this.cancelAndClear();
                            this.downstream.onSuccess(object);
                            return;
                        }
                        bl3 = false;
                        this.v1 = null;
                        this.v2 = null;
                        this.first.request();
                        object3 = this.second;
                        ((FlowableSequenceEqual$EqualSubscriber)object3).request();
                    }
                    catch (Throwable throwable) {
                        e.a.t0.a.b(throwable);
                        this.cancelAndClear();
                        this.error.addThrowable(throwable);
                        l0 l04 = this.downstream;
                        Throwable throwable4 = this.error.terminate();
                        l04.onError(throwable4);
                        return;
                    }
                }
            }
            n11 = -n11;
        } while ((n11 = this.addAndGet(n11)) != 0);
    }

    public void innerError(Throwable throwable) {
        AtomicThrowable atomicThrowable = this.error;
        boolean bl2 = atomicThrowable.addThrowable(throwable);
        if (bl2) {
            this.drain();
        } else {
            a.Y(throwable);
        }
    }

    public boolean isDisposed() {
        boolean bl2;
        SubscriptionHelper subscriptionHelper;
        Object v10 = this.first.get();
        if (v10 == (subscriptionHelper = SubscriptionHelper.CANCELLED)) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
    }

    public void subscribe(c object, c c10) {
        FlowableSequenceEqual$EqualSubscriber flowableSequenceEqual$EqualSubscriber = this.first;
        object.subscribe(flowableSequenceEqual$EqualSubscriber);
        object = this.second;
        c10.subscribe((d)object);
    }
}

