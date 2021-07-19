/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.mixed;

import e.a.a1.a;
import e.a.g0;
import e.a.l0;
import e.a.o0;
import e.a.s0.b;
import e.a.v0.o;
import e.a.w0.c.n;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.mixed.ObservableConcatMapSingle$ConcatMapSingleMainObserver$ConcatMapSingleObserver;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableConcatMapSingle$ConcatMapSingleMainObserver
extends AtomicInteger
implements g0,
b {
    public static final int STATE_ACTIVE = 1;
    public static final int STATE_INACTIVE = 0;
    public static final int STATE_RESULT_VALUE = 2;
    private static final long serialVersionUID = -9140123220065488293L;
    public volatile boolean cancelled;
    public volatile boolean done;
    public final g0 downstream;
    public final ErrorMode errorMode;
    public final AtomicThrowable errors;
    public final ObservableConcatMapSingle$ConcatMapSingleMainObserver$ConcatMapSingleObserver inner;
    public Object item;
    public final o mapper;
    public final n queue;
    public volatile int state;
    public b upstream;

    public ObservableConcatMapSingle$ConcatMapSingleMainObserver(g0 object, o o10, int n10, ErrorMode errorMode) {
        this.downstream = object;
        this.mapper = o10;
        this.errorMode = errorMode;
        this.errors = object = new AtomicThrowable();
        this.inner = object = new ObservableConcatMapSingle$ConcatMapSingleMainObserver$ConcatMapSingleObserver(this);
        this.queue = object = new e.a.w0.f.a(n10);
    }

    public void dispose() {
        this.cancelled = true;
        this.upstream.dispose();
        ObservableConcatMapSingle$ConcatMapSingleMainObserver$ConcatMapSingleObserver observableConcatMapSingle$ConcatMapSingleMainObserver$ConcatMapSingleObserver = this.inner;
        observableConcatMapSingle$ConcatMapSingleMainObserver$ConcatMapSingleObserver.dispose();
        int n10 = this.getAndIncrement();
        if (n10 == 0) {
            this.queue.clear();
            n10 = 0;
            observableConcatMapSingle$ConcatMapSingleMainObserver$ConcatMapSingleObserver = null;
            this.item = null;
        }
    }

    public void drain() {
        int n10;
        int n11 = this.getAndIncrement();
        if (n11 != 0) {
            return;
        }
        g0 g02 = this.downstream;
        Object object = this.errorMode;
        n n12 = this.queue;
        AtomicThrowable atomicThrowable = this.errors;
        int n13 = n10 = 1;
        while (true) {
            int n14 = this.cancelled;
            Object object2 = null;
            if (n14 != 0) {
                n12.clear();
                this.item = null;
            } else {
                Object object3;
                n14 = this.state;
                Object object4 = atomicThrowable.get();
                if (object4 != null && (object == (object4 = ErrorMode.IMMEDIATE) || object == (object4 = ErrorMode.BOUNDARY) && n14 == 0)) {
                    n12.clear();
                    this.item = null;
                    object = atomicThrowable.terminate();
                    g02.onError((Throwable)object);
                    return;
                }
                int n15 = 0;
                object4 = null;
                if (n14 == 0) {
                    n14 = (int)(this.done ? 1 : 0);
                    object2 = n12.poll();
                    if (object2 == null) {
                        n15 = n10;
                    }
                    if (n14 != 0 && n15 != 0) {
                        object = atomicThrowable.terminate();
                        if (object == null) {
                            g02.onComplete();
                        } else {
                            g02.onError((Throwable)object);
                        }
                        return;
                    }
                    if (n15 == 0) {
                        try {
                            object3 = this.mapper;
                        }
                        catch (Throwable throwable) {
                            e.a.t0.a.b(throwable);
                            this.upstream.dispose();
                            n12.clear();
                            atomicThrowable.addThrowable(throwable);
                            Throwable throwable2 = atomicThrowable.terminate();
                            g02.onError(throwable2);
                            return;
                        }
                        object3 = object3.apply(object2);
                        object2 = "The mapper returned a null SingleSource";
                        object3 = e.a.w0.b.a.g(object3, (String)object2);
                        object3 = (o0)object3;
                        this.state = n10;
                        object2 = this.inner;
                        object3.f((l0)object2);
                    }
                } else {
                    int n16 = 2;
                    if (n14 == n16) {
                        object3 = this.item;
                        this.item = null;
                        g02.onNext(object3);
                        this.state = 0;
                        continue;
                    }
                }
            }
            n13 = -n13;
            if ((n13 = this.addAndGet(n13)) == 0) break;
        }
    }

    public void innerError(Throwable object) {
        Object object2 = this.errors;
        boolean bl2 = object2.addThrowable((Throwable)object);
        if (bl2) {
            object = this.errorMode;
            object2 = ErrorMode.END;
            if (object != object2) {
                object = this.upstream;
                object.dispose();
            }
            object = null;
            this.state = 0;
            this.drain();
        } else {
            a.Y(object);
        }
    }

    public void innerSuccess(Object object) {
        this.item = object;
        this.state = 2;
        this.drain();
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    public void onComplete() {
        this.done = true;
        this.drain();
    }

    public void onError(Throwable object) {
        Object object2 = this.errors;
        boolean bl2 = object2.addThrowable((Throwable)object);
        if (bl2) {
            boolean bl3;
            object = this.errorMode;
            object2 = ErrorMode.IMMEDIATE;
            if (object == object2) {
                object = this.inner;
                ((ObservableConcatMapSingle$ConcatMapSingleMainObserver$ConcatMapSingleObserver)object).dispose();
            }
            this.done = bl3 = true;
            this.drain();
        } else {
            a.Y(object);
        }
    }

    public void onNext(Object object) {
        this.queue.offer(object);
        this.drain();
    }

    public void onSubscribe(b object) {
        b b10 = this.upstream;
        boolean bl2 = DisposableHelper.validate(b10, (b)object);
        if (bl2) {
            this.upstream = object;
            object = this.downstream;
            object.onSubscribe(this);
        }
    }
}

