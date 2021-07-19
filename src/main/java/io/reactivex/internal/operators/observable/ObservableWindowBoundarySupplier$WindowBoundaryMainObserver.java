/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.a1.a;
import e.a.e0;
import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier$a;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableWindowBoundarySupplier$WindowBoundaryMainObserver
extends AtomicInteger
implements g0,
b,
Runnable {
    public static final ObservableWindowBoundarySupplier$a BOUNDARY_DISPOSED;
    public static final Object NEXT_WINDOW;
    private static final long serialVersionUID = 2233020065421370272L;
    public final AtomicReference boundaryObserver;
    public final int capacityHint;
    public volatile boolean done;
    public final g0 downstream;
    public final AtomicThrowable errors;
    public final Callable other;
    public final MpscLinkedQueue queue;
    public final AtomicBoolean stopWindows;
    public b upstream;
    public UnicastSubject window;
    public final AtomicInteger windows;

    static {
        Object object = new ObservableWindowBoundarySupplier$a(null);
        BOUNDARY_DISPOSED = object;
        NEXT_WINDOW = object = new Object();
    }

    public ObservableWindowBoundarySupplier$WindowBoundaryMainObserver(g0 object, int n10, Callable callable) {
        this.downstream = object;
        this.capacityHint = n10;
        object = new AtomicReference();
        this.boundaryObserver = object;
        super(1);
        this.windows = object;
        this.queue = object = new MpscLinkedQueue();
        this.errors = object = new AtomicThrowable();
        this.stopWindows = object = new AtomicBoolean();
        this.other = callable;
    }

    public void dispose() {
        Object object = this.stopWindows;
        boolean bl2 = true;
        boolean n10 = ((AtomicBoolean)object).compareAndSet(false, bl2);
        if (n10) {
            this.disposeBoundary();
            object = this.windows;
            int n11 = ((AtomicInteger)object).decrementAndGet();
            if (n11 == 0) {
                object = this.upstream;
                object.dispose();
            }
        }
    }

    public void disposeBoundary() {
        Object object = this.boundaryObserver;
        ObservableWindowBoundarySupplier$a observableWindowBoundarySupplier$a = BOUNDARY_DISPOSED;
        if ((object = (b)((AtomicReference)object).getAndSet(observableWindowBoundarySupplier$a)) != null && object != observableWindowBoundarySupplier$a) {
            object.dispose();
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
            AtomicReference atomicReference;
            int n13;
            Object object2;
            Object object3 = this.windows;
            int n14 = ((AtomicInteger)object3).get();
            boolean bl2 = false;
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
                    ((UnicastSubject)object3).onError((Throwable)object);
                }
                g02.onError((Throwable)object);
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
            if (n13 != 0) {
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
            if ((n14 = (int)(((AtomicBoolean)(object3 = this.stopWindows)).get() ? 1 : 0)) != 0) continue;
            n14 = this.capacityHint;
            this.window = object3 = UnicastSubject.o8(n14, this);
            object4 = this.windows;
            ((AtomicInteger)object4).getAndIncrement();
            try {
                object4 = this.other;
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                atomicThrowable.addThrowable(throwable);
                this.done = n10;
                continue;
            }
            object4 = object4.call();
            object2 = "The other Callable returned a null ObservableSource";
            object4 = e.a.w0.b.a.g(object4, object2);
            object4 = (e0)object4;
            atomicReference = this.boundaryObserver;
            object2 = new Object(this);
            bl2 = atomicReference.compareAndSet(null, object2);
            if (!bl2) continue;
            object4.subscribe((g0)object2);
            g02.onNext(object3);
            continue;
            break;
        }
    }

    public void innerComplete() {
        this.upstream.dispose();
        this.done = true;
        this.drain();
    }

    public void innerError(Throwable throwable) {
        this.upstream.dispose();
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

    public void innerNext(ObservableWindowBoundarySupplier$a object) {
        this.boundaryObserver.compareAndSet(object, null);
        object = this.queue;
        Object object2 = NEXT_WINDOW;
        ((MpscLinkedQueue)object).offer(object2);
        this.drain();
    }

    public boolean isDisposed() {
        return this.stopWindows.get();
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
            a.Y(throwable);
        }
    }

    public void onNext(Object object) {
        this.queue.offer(object);
        this.drain();
    }

    public void onSubscribe(b object) {
        Object object2 = this.upstream;
        boolean bl2 = DisposableHelper.validate((b)object2, (b)object);
        if (bl2) {
            this.upstream = object;
            this.downstream.onSubscribe(this);
            object = this.queue;
            object2 = NEXT_WINDOW;
            ((MpscLinkedQueue)object).offer(object2);
            this.drain();
        }
    }

    public void run() {
        Object object = this.windows;
        int n10 = ((AtomicInteger)object).decrementAndGet();
        if (n10 == 0) {
            object = this.upstream;
            object.dispose();
        }
    }
}

