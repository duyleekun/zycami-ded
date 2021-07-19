/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.o;
import e.a.w0.i.b;
import i.g.d;
import i.g.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.operators.flowable.FlowableWindowBoundary$a;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.processors.UnicastProcessor;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableWindowBoundary$WindowBoundaryMainSubscriber
extends AtomicInteger
implements o,
e,
Runnable {
    public static final Object NEXT_WINDOW;
    private static final long serialVersionUID = 2233020065421370272L;
    public final FlowableWindowBoundary$a boundarySubscriber;
    public final int capacityHint;
    public volatile boolean done;
    public final d downstream;
    public long emitted;
    public final AtomicThrowable errors;
    public final MpscLinkedQueue queue;
    public final AtomicLong requested;
    public final AtomicBoolean stopWindows;
    public final AtomicReference upstream;
    public UnicastProcessor window;
    public final AtomicInteger windows;

    static {
        Object object;
        NEXT_WINDOW = object = new Object();
    }

    public FlowableWindowBoundary$WindowBoundaryMainSubscriber(d object, int n10) {
        this.downstream = object;
        this.capacityHint = n10;
        super(this);
        this.boundarySubscriber = object;
        object = new AtomicReference();
        this.upstream = object;
        super(1);
        this.windows = object;
        this.queue = object = new MpscLinkedQueue();
        this.errors = object = new AtomicThrowable();
        this.stopWindows = object = new AtomicBoolean();
        this.requested = object = new AtomicLong();
    }

    public void cancel() {
        Serializable serializable = this.stopWindows;
        boolean bl2 = true;
        boolean n10 = ((AtomicBoolean)serializable).compareAndSet(false, bl2);
        if (n10) {
            this.boundarySubscriber.dispose();
            serializable = this.windows;
            int n11 = ((AtomicInteger)serializable).decrementAndGet();
            if (n11 == 0) {
                serializable = this.upstream;
                SubscriptionHelper.cancel((AtomicReference)serializable);
            }
        }
    }

    public void drain() {
        int n10;
        int n11 = this.getAndIncrement();
        if (n11 != 0) {
            return;
        }
        d d10 = this.downstream;
        Object object = this.queue;
        AtomicThrowable atomicThrowable = this.errors;
        long l10 = this.emitted;
        int n12 = n10 = 1;
        while (true) {
            Object object2;
            Object object3 = this.windows;
            int n13 = ((AtomicInteger)object3).get();
            boolean bl2 = false;
            Object object4 = null;
            if (n13 == 0) {
                ((MpscLinkedQueue)object).clear();
                this.window = null;
                return;
            }
            object3 = this.window;
            boolean bl3 = this.done;
            if (bl3 && (object2 = atomicThrowable.get()) != null) {
                ((MpscLinkedQueue)object).clear();
                object = atomicThrowable.terminate();
                if (object3 != null) {
                    this.window = null;
                    ((UnicastProcessor)object3).onError((Throwable)object);
                }
                d10.onError((Throwable)object);
                return;
            }
            object2 = ((MpscLinkedQueue)object).poll();
            int n14 = object2 == null ? n10 : 0;
            if (bl3 && n14 != 0) {
                object = atomicThrowable.terminate();
                if (object == null) {
                    if (object3 != null) {
                        this.window = null;
                        ((UnicastProcessor)object3).onComplete();
                    }
                    d10.onComplete();
                } else {
                    if (object3 != null) {
                        this.window = null;
                        ((UnicastProcessor)object3).onError((Throwable)object);
                    }
                    d10.onError((Throwable)object);
                }
                return;
            }
            if (n14 != 0) {
                this.emitted = l10;
                n12 = -n12;
                if ((n12 = this.addAndGet(n12)) != 0) continue;
                return;
            }
            Object object5 = NEXT_WINDOW;
            if (object2 != object5) {
                ((UnicastProcessor)object3).onNext(object2);
                continue;
            }
            if (object3 != null) {
                this.window = null;
                ((UnicastProcessor)object3).onComplete();
            }
            if ((n13 = (int)(((AtomicBoolean)(object3 = this.stopWindows)).get() ? 1 : 0)) != 0) continue;
            n13 = this.capacityHint;
            this.window = object3 = UnicastProcessor.S8(n13, this);
            this.windows.getAndIncrement();
            object4 = this.requested;
            long l11 = ((AtomicLong)object4).get();
            bl2 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (bl2) {
                l11 = 1L;
                l10 += l11;
                d10.onNext(object3);
                continue;
            }
            SubscriptionHelper.cancel(this.upstream);
            this.boundarySubscriber.dispose();
            object4 = "Could not deliver a window due to lack of requests";
            object3 = new MissingBackpressureException((String)object4);
            atomicThrowable.addThrowable((Throwable)object3);
            this.done = n10;
        }
    }

    public void innerComplete() {
        SubscriptionHelper.cancel(this.upstream);
        this.done = true;
        this.drain();
    }

    public void innerError(Throwable throwable) {
        SubscriptionHelper.cancel(this.upstream);
        AtomicThrowable atomicThrowable = this.errors;
        boolean bl2 = atomicThrowable.addThrowable(throwable);
        if (bl2) {
            boolean bl3;
            this.done = bl3 = true;
            this.drain();
        } else {
            a.Y(throwable);
        }
    }

    public void innerNext() {
        MpscLinkedQueue mpscLinkedQueue = this.queue;
        Object object = NEXT_WINDOW;
        mpscLinkedQueue.offer(object);
        this.drain();
    }

    public void onComplete() {
        this.boundarySubscriber.dispose();
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        this.boundarySubscriber.dispose();
        AtomicThrowable atomicThrowable = this.errors;
        boolean bl2 = atomicThrowable.addThrowable(throwable);
        if (bl2) {
            boolean bl3;
            this.done = bl3 = true;
            this.drain();
        } else {
            a.Y(throwable);
        }
    }

    public void onNext(Object object) {
        this.queue.offer(object);
        this.drain();
    }

    public void onSubscribe(e e10) {
        SubscriptionHelper.setOnce(this.upstream, e10, Long.MAX_VALUE);
    }

    public void request(long l10) {
        b.a(this.requested, l10);
    }

    public void run() {
        Serializable serializable = this.windows;
        int n10 = serializable.decrementAndGet();
        if (n10 == 0) {
            serializable = this.upstream;
            SubscriptionHelper.cancel((AtomicReference)serializable);
        }
    }
}

