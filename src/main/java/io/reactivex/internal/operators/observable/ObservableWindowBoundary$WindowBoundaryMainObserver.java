/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.a1.a;
import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableWindowBoundary$a;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.subjects.UnicastSubject;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableWindowBoundary$WindowBoundaryMainObserver
extends AtomicInteger
implements g0,
b,
Runnable {
    public static final Object NEXT_WINDOW;
    private static final long serialVersionUID = 2233020065421370272L;
    public final ObservableWindowBoundary$a boundaryObserver;
    public final int capacityHint;
    public volatile boolean done;
    public final g0 downstream;
    public final AtomicThrowable errors;
    public final MpscLinkedQueue queue;
    public final AtomicBoolean stopWindows;
    public final AtomicReference upstream;
    public UnicastSubject window;
    public final AtomicInteger windows;

    static {
        Object object;
        NEXT_WINDOW = object = new Object();
    }

    public ObservableWindowBoundary$WindowBoundaryMainObserver(g0 object, int n10) {
        this.downstream = object;
        this.capacityHint = n10;
        super(this);
        this.boundaryObserver = object;
        object = new AtomicReference();
        this.upstream = object;
        super(1);
        this.windows = object;
        this.queue = object = new MpscLinkedQueue();
        this.errors = object = new AtomicThrowable();
        this.stopWindows = object = new AtomicBoolean();
    }

    public void dispose() {
        Serializable serializable = this.stopWindows;
        boolean bl2 = true;
        boolean n10 = ((AtomicBoolean)serializable).compareAndSet(false, bl2);
        if (n10) {
            this.boundaryObserver.dispose();
            serializable = this.windows;
            int n11 = ((AtomicInteger)serializable).decrementAndGet();
            if (n11 == 0) {
                serializable = this.upstream;
                DisposableHelper.dispose((AtomicReference)serializable);
            }
        }
    }

    public void drain() {
        int n10;
        int n11 = this.getAndIncrement();
        if (n11 != 0) {
            return;
        }
        g0 g02 = this.downstream;
        Object object = this.queue;
        AtomicThrowable atomicThrowable = this.errors;
        int n12 = n10 = 1;
        while (true) {
            Object object2;
            Object object3 = this.windows;
            int n13 = ((AtomicInteger)object3).get();
            AtomicInteger atomicInteger = null;
            if (n13 == 0) {
                ((MpscLinkedQueue)object).clear();
                this.window = null;
                return;
            }
            object3 = this.window;
            boolean bl2 = this.done;
            if (bl2 && (object2 = atomicThrowable.get()) != null) {
                ((MpscLinkedQueue)object).clear();
                object = atomicThrowable.terminate();
                if (object3 != null) {
                    this.window = null;
                    ((UnicastSubject)object3).onError((Throwable)object);
                }
                g02.onError((Throwable)object);
                return;
            }
            object2 = ((MpscLinkedQueue)object).poll();
            int n14 = object2 == null ? n10 : 0;
            if (bl2 && n14 != 0) {
                object = atomicThrowable.terminate();
                if (object == null) {
                    if (object3 != null) {
                        this.window = null;
                        ((UnicastSubject)object3).onComplete();
                    }
                    g02.onComplete();
                } else {
                    if (object3 != null) {
                        this.window = null;
                        ((UnicastSubject)object3).onError((Throwable)object);
                    }
                    g02.onError((Throwable)object);
                }
                return;
            }
            if (n14 != 0) {
                n12 = -n12;
                if ((n12 = this.addAndGet(n12)) != 0) continue;
                return;
            }
            Object object4 = NEXT_WINDOW;
            if (object2 != object4) {
                ((UnicastSubject)object3).onNext(object2);
                continue;
            }
            if (object3 != null) {
                this.window = null;
                ((UnicastSubject)object3).onComplete();
            }
            if ((n13 = (int)(((AtomicBoolean)(object3 = this.stopWindows)).get() ? 1 : 0)) != 0) continue;
            n13 = this.capacityHint;
            this.window = object3 = UnicastSubject.o8(n13, this);
            atomicInteger = this.windows;
            atomicInteger.getAndIncrement();
            g02.onNext(object3);
        }
    }

    public void innerComplete() {
        DisposableHelper.dispose(this.upstream);
        this.done = true;
        this.drain();
    }

    public void innerError(Throwable throwable) {
        DisposableHelper.dispose(this.upstream);
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

    public boolean isDisposed() {
        return this.stopWindows.get();
    }

    public void onComplete() {
        this.boundaryObserver.dispose();
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        this.boundaryObserver.dispose();
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

    public void onSubscribe(b b10) {
        AtomicReference atomicReference = this.upstream;
        boolean bl2 = DisposableHelper.setOnce(atomicReference, b10);
        if (bl2) {
            this.innerNext();
        }
    }

    public void run() {
        Serializable serializable = this.windows;
        int n10 = serializable.decrementAndGet();
        if (n10 == 0) {
            serializable = this.upstream;
            DisposableHelper.dispose((AtomicReference)serializable);
        }
    }
}

