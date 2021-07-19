/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.w0.c.l;
import e.a.w0.c.o;
import i.g.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.operators.flowable.FlowableSwitchMap$SwitchMapSubscriber;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableSwitchMap$SwitchMapInnerSubscriber
extends AtomicReference
implements e.a.o {
    private static final long serialVersionUID = 3837284832786408377L;
    public final int bufferSize;
    public volatile boolean done;
    public int fusionMode;
    public final long index;
    public final FlowableSwitchMap$SwitchMapSubscriber parent;
    public volatile o queue;

    public FlowableSwitchMap$SwitchMapInnerSubscriber(FlowableSwitchMap$SwitchMapSubscriber switchMapSubscriber, long l10, int n10) {
        this.parent = switchMapSubscriber;
        this.index = l10;
        this.bufferSize = n10;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public void onComplete() {
        FlowableSwitchMap$SwitchMapSubscriber flowableSwitchMap$SwitchMapSubscriber = this.parent;
        long l10 = this.index;
        long l11 = flowableSwitchMap$SwitchMapSubscriber.unique;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            object = 1;
            this.done = object;
            flowableSwitchMap$SwitchMapSubscriber.drain();
        }
    }

    public void onError(Throwable object) {
        AtomicThrowable atomicThrowable;
        FlowableSwitchMap$SwitchMapSubscriber flowableSwitchMap$SwitchMapSubscriber = this.parent;
        long l10 = this.index;
        long l11 = flowableSwitchMap$SwitchMapSubscriber.unique;
        long l12 = l10 - l11;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 == false && (object2 = (Object)(atomicThrowable = flowableSwitchMap$SwitchMapSubscriber.error).addThrowable((Throwable)object)) != false) {
            boolean bl2 = flowableSwitchMap$SwitchMapSubscriber.delayErrors;
            object2 = 1;
            if (!bl2) {
                object = flowableSwitchMap$SwitchMapSubscriber.upstream;
                object.cancel();
                flowableSwitchMap$SwitchMapSubscriber.done = object2;
            }
            this.done = object2;
            flowableSwitchMap$SwitchMapSubscriber.drain();
        } else {
            a.Y((Throwable)object);
        }
    }

    public void onNext(Object object) {
        FlowableSwitchMap$SwitchMapSubscriber flowableSwitchMap$SwitchMapSubscriber = this.parent;
        long l10 = this.index;
        long l11 = flowableSwitchMap$SwitchMapSubscriber.unique;
        long l12 = l10 - l11;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 == false) {
            o o10;
            boolean bl2;
            object2 = this.fusionMode;
            if (object2 == false && !(bl2 = (o10 = this.queue).offer(object))) {
                object = new MissingBackpressureException("Queue full?!");
                this.onError((Throwable)object);
                return;
            }
            flowableSwitchMap$SwitchMapSubscriber.drain();
        }
    }

    public void onSubscribe(e e10) {
        int n10 = SubscriptionHelper.setOnce(this, e10);
        if (n10 != 0) {
            int n11;
            Object object;
            n10 = e10 instanceof l;
            if (n10 != 0) {
                int n12;
                object = e10;
                object = (l)e10;
                n11 = object.requestFusion(7);
                if (n11 == (n12 = 1)) {
                    this.fusionMode = n11;
                    this.queue = object;
                    this.done = n12;
                    this.parent.drain();
                    return;
                }
                n12 = 2;
                if (n11 == n12) {
                    this.fusionMode = n11;
                    this.queue = object;
                    long l10 = this.bufferSize;
                    e10.request(l10);
                    return;
                }
            }
            n11 = this.bufferSize;
            this.queue = object = new SpscArrayQueue(n11);
            n10 = this.bufferSize;
            long l11 = n10;
            e10.request(l11);
        }
    }

    public void request(long l10) {
        int n10 = this.fusionMode;
        int n11 = 1;
        if (n10 != n11) {
            e e10 = (e)this.get();
            e10.request(l10);
        }
    }
}

