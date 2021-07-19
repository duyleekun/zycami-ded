/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.w0.c.o;
import i.g.c;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableSequenceEqual$EqualSubscriber;
import io.reactivex.internal.operators.flowable.FlowableSequenceEqual$a;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.util.AtomicThrowable;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public final class FlowableSequenceEqual$EqualCoordinator
extends DeferredScalarSubscription
implements FlowableSequenceEqual$a {
    private static final long serialVersionUID = -6178010334400373240L;
    public final e.a.v0.d comparer;
    public final AtomicThrowable error;
    public final FlowableSequenceEqual$EqualSubscriber first;
    public final FlowableSequenceEqual$EqualSubscriber second;
    public Object v1;
    public Object v2;
    public final AtomicInteger wip;

    public FlowableSequenceEqual$EqualCoordinator(d object, int n10, e.a.v0.d d10) {
        super((d)object);
        this.comparer = d10;
        this.wip = object = new AtomicInteger();
        this.first = object = new FlowableSequenceEqual$EqualSubscriber(this, n10);
        this.second = object = new FlowableSequenceEqual$EqualSubscriber(this, n10);
        this.error = object = new AtomicThrowable();
    }

    public void cancel() {
        super.cancel();
        this.first.cancel();
        this.second.cancel();
        Serializable serializable = this.wip;
        int n10 = ((AtomicInteger)serializable).getAndIncrement();
        if (n10 == 0) {
            this.first.clear();
            serializable = this.second;
            ((FlowableSequenceEqual$EqualSubscriber)serializable).clear();
        }
    }

    public void cancelAndClear() {
        this.first.cancel();
        this.first.clear();
        this.second.cancel();
        this.second.clear();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void drain() {
        Object object;
        Object object2 = Boolean.FALSE;
        Serializable serializable = this.wip;
        int n10 = serializable.getAndIncrement();
        if (n10 != 0) {
            return;
        }
        int n11 = n10 = 1;
        do {
            object = this.first.queue;
            o o10 = this.second.queue;
            if (object == null || o10 == null) {
                boolean bl2 = this.isCancelled();
                if (bl2) {
                    this.first.clear();
                    this.second.clear();
                    return;
                }
                object = (Throwable)this.error.get();
                if (object != null) {
                    this.cancelAndClear();
                    object2 = this.downstream;
                    serializable = this.error.terminate();
                    object2.onError((Throwable)serializable);
                    return;
                }
            } else {
                while (true) {
                    boolean bl3;
                    if (bl3 = this.isCancelled()) {
                        this.first.clear();
                        this.second.clear();
                        return;
                    }
                    Object object3 = (Throwable)this.error.get();
                    if (object3 != null) {
                        this.cancelAndClear();
                        object2 = this.downstream;
                        serializable = this.error.terminate();
                        object2.onError((Throwable)serializable);
                        return;
                    }
                    object3 = this.first;
                    bl3 = ((FlowableSequenceEqual$EqualSubscriber)object3).done;
                    Object object4 = this.v1;
                    if (object4 == null) {
                        try {
                            this.v1 = object4 = object.poll();
                        }
                        catch (Throwable throwable) {
                            e.a.t0.a.b(throwable);
                            this.cancelAndClear();
                            this.error.addThrowable(throwable);
                            d d10 = this.downstream;
                            serializable = this.error.terminate();
                            d10.onError((Throwable)serializable);
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
                            d d11 = this.downstream;
                            serializable = this.error.terminate();
                            d11.onError((Throwable)serializable);
                            return;
                        }
                    }
                    if (object5 == null) {
                        n12 = n10;
                    }
                    if (bl3 && bl4 && n13 != 0 && n12 != 0) {
                        object2 = Boolean.TRUE;
                        this.complete(object2);
                        return;
                    }
                    if (bl3 && bl4 && n13 != n12) {
                        this.cancelAndClear();
                        this.complete(object2);
                        return;
                    }
                    if (n13 != 0 || n12 != 0) break;
                    try {
                        object3 = this.comparer;
                        bl3 = object3.a(object4, object5);
                        if (!bl3) {
                            this.cancelAndClear();
                            this.complete(object2);
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
                        d d12 = this.downstream;
                        serializable = this.error.terminate();
                        d12.onError((Throwable)serializable);
                        return;
                    }
                }
            }
            object = this.wip;
            n11 = -n11;
        } while ((n11 = ((AtomicInteger)object).addAndGet(n11)) != 0);
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

    public void subscribe(c object, c c10) {
        FlowableSequenceEqual$EqualSubscriber flowableSequenceEqual$EqualSubscriber = this.first;
        object.subscribe(flowableSequenceEqual$EqualSubscriber);
        object = this.second;
        c10.subscribe((d)object);
    }
}

