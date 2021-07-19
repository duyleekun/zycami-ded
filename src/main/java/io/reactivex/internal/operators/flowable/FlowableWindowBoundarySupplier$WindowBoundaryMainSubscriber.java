/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.o;
import e.a.t0.a;
import e.a.w0.i.b;
import i.g.c;
import i.g.d;
import i.g.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.operators.flowable.FlowableWindowBoundarySupplier$a;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.processors.UnicastProcessor;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableWindowBoundarySupplier$WindowBoundaryMainSubscriber
extends AtomicInteger
implements o,
e,
Runnable {
    public static final FlowableWindowBoundarySupplier$a BOUNDARY_DISPOSED;
    public static final Object NEXT_WINDOW;
    private static final long serialVersionUID = 2233020065421370272L;
    public final AtomicReference boundarySubscriber;
    public final int capacityHint;
    public volatile boolean done;
    public final d downstream;
    public long emitted;
    public final AtomicThrowable errors;
    public final Callable other;
    public final MpscLinkedQueue queue;
    public final AtomicLong requested;
    public final AtomicBoolean stopWindows;
    public e upstream;
    public UnicastProcessor window;
    public final AtomicInteger windows;

    static {
        Object object = new FlowableWindowBoundarySupplier$a(null);
        BOUNDARY_DISPOSED = object;
        NEXT_WINDOW = object = new Object();
    }

    public FlowableWindowBoundarySupplier$WindowBoundaryMainSubscriber(d object, int n10, Callable callable) {
        this.downstream = object;
        this.capacityHint = n10;
        object = new AtomicReference();
        this.boundarySubscriber = object;
        super(1);
        this.windows = object;
        this.queue = object = new MpscLinkedQueue();
        this.errors = object = new AtomicThrowable();
        this.stopWindows = object = new AtomicBoolean();
        this.other = callable;
        this.requested = object = new AtomicLong();
    }

    public void cancel() {
        Object object = this.stopWindows;
        boolean bl2 = true;
        boolean n10 = ((AtomicBoolean)object).compareAndSet(false, bl2);
        if (n10) {
            this.disposeBoundary();
            object = this.windows;
            int n11 = ((AtomicInteger)object).decrementAndGet();
            if (n11 == 0) {
                object = this.upstream;
                object.cancel();
            }
        }
    }

    public void disposeBoundary() {
        Object object = this.boundarySubscriber;
        FlowableWindowBoundarySupplier$a flowableWindowBoundarySupplier$a = BOUNDARY_DISPOSED;
        if ((object = (e.a.s0.b)((AtomicReference)object).getAndSet(flowableWindowBoundarySupplier$a)) != null && object != flowableWindowBoundarySupplier$a) {
            object.dispose();
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
            AtomicReference atomicReference;
            int n13;
            Object object2;
            Object object3 = this.windows;
            int n14 = ((AtomicInteger)object3).get();
            boolean bl2 = false;
            String string2 = null;
            if (n14 == 0) {
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
            if (object2 == null) {
                n13 = n10;
            } else {
                n13 = 0;
                atomicReference = null;
            }
            if (bl3 && n13 != 0) {
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
            if (n13 != 0) {
                this.emitted = l10;
                n12 = -n12;
                if ((n12 = this.addAndGet(n12)) != 0) continue;
                return;
            }
            Object object4 = NEXT_WINDOW;
            if (object2 != object4) {
                ((UnicastProcessor)object3).onNext(object2);
                continue;
            }
            if (object3 != null) {
                this.window = null;
                ((UnicastProcessor)object3).onComplete();
            }
            if ((n14 = (int)(((AtomicBoolean)(object3 = this.stopWindows)).get() ? 1 : 0)) != 0) continue;
            object3 = this.requested;
            long l11 = ((AtomicLong)object3).get();
            long l12 = l10 - l11;
            n14 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n14 != 0) {
                n14 = this.capacityHint;
                this.window = object3 = UnicastProcessor.S8(n14, this);
                object4 = this.windows;
                ((AtomicInteger)object4).getAndIncrement();
                object4 = this.other;
                object4 = object4.call();
                object2 = "The other Callable returned a null Publisher";
                object4 = e.a.w0.b.a.g(object4, object2);
                try {
                    object4 = (c)object4;
                    atomicReference = this.boundarySubscriber;
                    object2 = new Object(this);
                    bl2 = atomicReference.compareAndSet(null, object2);
                    if (!bl2) continue;
                    object4.subscribe((d)object2);
                    long l13 = 1L;
                    l10 += l13;
                    d10.onNext(object3);
                }
                catch (Throwable throwable) {
                    a.b(throwable);
                    atomicThrowable.addThrowable(throwable);
                    this.done = n10;
                }
                continue;
            }
            this.upstream.cancel();
            this.disposeBoundary();
            string2 = "Could not deliver a window due to lack of requests";
            object3 = new MissingBackpressureException(string2);
            atomicThrowable.addThrowable((Throwable)object3);
            this.done = n10;
        }
    }

    public void innerComplete() {
        this.upstream.cancel();
        this.done = true;
        this.drain();
    }

    public void innerError(Throwable throwable) {
        this.upstream.cancel();
        AtomicThrowable atomicThrowable = this.errors;
        boolean bl2 = atomicThrowable.addThrowable(throwable);
        if (bl2) {
            boolean bl3;
            this.done = bl3 = true;
            this.drain();
        } else {
            e.a.a1.a.Y(throwable);
        }
    }

    public void innerNext(FlowableWindowBoundarySupplier$a object) {
        this.boundarySubscriber.compareAndSet(object, null);
        object = this.queue;
        Object object2 = NEXT_WINDOW;
        ((MpscLinkedQueue)object).offer(object2);
        this.drain();
    }

    public void onComplete() {
        this.disposeBoundary();
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        this.disposeBoundary();
        AtomicThrowable atomicThrowable = this.errors;
        boolean bl2 = atomicThrowable.addThrowable(throwable);
        if (bl2) {
            boolean bl3;
            this.done = bl3 = true;
            this.drain();
        } else {
            e.a.a1.a.Y(throwable);
        }
    }

    public void onNext(Object object) {
        this.queue.offer(object);
        this.drain();
    }

    public void onSubscribe(e e10) {
        Object object = this.upstream;
        boolean bl2 = SubscriptionHelper.validate((e)object, e10);
        if (bl2) {
            this.upstream = e10;
            this.downstream.onSubscribe(this);
            object = this.queue;
            Object object2 = NEXT_WINDOW;
            ((MpscLinkedQueue)object).offer(object2);
            this.drain();
            long l10 = Long.MAX_VALUE;
            e10.request(l10);
        }
    }

    public void request(long l10) {
        b.a(this.requested, l10);
    }

    public void run() {
        Object object = this.windows;
        int n10 = ((AtomicInteger)object).decrementAndGet();
        if (n10 == 0) {
            object = this.upstream;
            object.cancel();
        }
    }
}

