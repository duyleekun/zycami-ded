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
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle$SwitchMapSingleMainObserver$SwitchMapSingleObserver;
import io.reactivex.internal.util.AtomicThrowable;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSwitchMapSingle$SwitchMapSingleMainObserver
extends AtomicInteger
implements g0,
b {
    public static final ObservableSwitchMapSingle$SwitchMapSingleMainObserver$SwitchMapSingleObserver INNER_DISPOSED;
    private static final long serialVersionUID = -5402190102429853762L;
    public volatile boolean cancelled;
    public final boolean delayErrors;
    public volatile boolean done;
    public final g0 downstream;
    public final AtomicThrowable errors;
    public final AtomicReference inner;
    public final o mapper;
    public b upstream;

    static {
        ObservableSwitchMapSingle$SwitchMapSingleMainObserver$SwitchMapSingleObserver observableSwitchMapSingle$SwitchMapSingleMainObserver$SwitchMapSingleObserver;
        INNER_DISPOSED = observableSwitchMapSingle$SwitchMapSingleMainObserver$SwitchMapSingleObserver = new ObservableSwitchMapSingle$SwitchMapSingleMainObserver$SwitchMapSingleObserver(null);
    }

    public ObservableSwitchMapSingle$SwitchMapSingleMainObserver(g0 atomicReference, o o10, boolean bl2) {
        this.downstream = atomicReference;
        this.mapper = o10;
        this.delayErrors = bl2;
        atomicReference = new AtomicReference();
        this.errors = atomicReference;
        this.inner = atomicReference = new AtomicReference();
    }

    public void dispose() {
        this.cancelled = true;
        this.upstream.dispose();
        this.disposeInner();
    }

    public void disposeInner() {
        AtomicReference atomicReference = this.inner;
        ObservableSwitchMapSingle$SwitchMapSingleMainObserver$SwitchMapSingleObserver observableSwitchMapSingle$SwitchMapSingleMainObserver$SwitchMapSingleObserver = INNER_DISPOSED;
        if ((atomicReference = atomicReference.getAndSet(observableSwitchMapSingle$SwitchMapSingleMainObserver$SwitchMapSingleObserver)) != null && atomicReference != observableSwitchMapSingle$SwitchMapSingleMainObserver$SwitchMapSingleObserver) {
            ((ObservableSwitchMapSingle$SwitchMapSingleMainObserver$SwitchMapSingleObserver)atomicReference).dispose();
        }
    }

    public void drain() {
        int n10;
        int n11 = this.getAndIncrement();
        if (n11 != 0) {
            return;
        }
        g0 g02 = this.downstream;
        Serializable serializable = this.errors;
        AtomicReference atomicReference = this.inner;
        int n12 = n10 = 1;
        while (true) {
            boolean bl2;
            if (bl2 = this.cancelled) {
                return;
            }
            Object object = ((AtomicReference)serializable).get();
            if (object != null && !(bl2 = this.delayErrors)) {
                serializable = ((AtomicThrowable)serializable).terminate();
                g02.onError((Throwable)serializable);
                return;
            }
            bl2 = this.done;
            ObservableSwitchMapSingle$SwitchMapSingleMainObserver$SwitchMapSingleObserver observableSwitchMapSingle$SwitchMapSingleMainObserver$SwitchMapSingleObserver = (ObservableSwitchMapSingle$SwitchMapSingleMainObserver$SwitchMapSingleObserver)atomicReference.get();
            int n13 = observableSwitchMapSingle$SwitchMapSingleMainObserver$SwitchMapSingleObserver == null ? n10 : 0;
            if (bl2 && n13 != 0) {
                if ((serializable = ((AtomicThrowable)serializable).terminate()) != null) {
                    g02.onError((Throwable)serializable);
                } else {
                    g02.onComplete();
                }
                return;
            }
            if (n13 == 0 && (object = observableSwitchMapSingle$SwitchMapSingleMainObserver$SwitchMapSingleObserver.item) != null) {
                bl2 = false;
                atomicReference.compareAndSet(observableSwitchMapSingle$SwitchMapSingleMainObserver$SwitchMapSingleObserver, null);
                object = observableSwitchMapSingle$SwitchMapSingleMainObserver$SwitchMapSingleObserver.item;
                g02.onNext(object);
                continue;
            }
            n12 = -n12;
            if ((n12 = this.addAndGet(n12)) == 0) break;
        }
    }

    public void innerError(ObservableSwitchMapSingle$SwitchMapSingleMainObserver$SwitchMapSingleObserver object, Throwable throwable) {
        AtomicReference atomicReference = this.inner;
        boolean bl2 = atomicReference.compareAndSet(object, null);
        if (bl2 && (bl2 = ((AtomicThrowable)(object = this.errors)).addThrowable(throwable))) {
            bl2 = this.delayErrors;
            if (!bl2) {
                object = this.upstream;
                object.dispose();
                this.disposeInner();
            }
            this.drain();
            return;
        }
        a.Y(throwable);
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    public void onComplete() {
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        AtomicThrowable atomicThrowable = this.errors;
        boolean bl2 = atomicThrowable.addThrowable(throwable);
        if (bl2) {
            boolean bl3 = this.delayErrors;
            if (!bl3) {
                this.disposeInner();
            }
            this.done = bl3 = true;
            this.drain();
        } else {
            a.Y(throwable);
        }
    }

    public void onNext(Object object) {
        AtomicReference atomicReference;
        ObservableSwitchMapSingle$SwitchMapSingleMainObserver$SwitchMapSingleObserver observableSwitchMapSingle$SwitchMapSingleMainObserver$SwitchMapSingleObserver;
        Object object2 = (ObservableSwitchMapSingle$SwitchMapSingleMainObserver$SwitchMapSingleObserver)this.inner.get();
        if (object2 != null) {
            ((ObservableSwitchMapSingle$SwitchMapSingleMainObserver$SwitchMapSingleObserver)object2).dispose();
        }
        object2 = this.mapper;
        object = object2.apply(object);
        object2 = "The mapper returned a null SingleSource";
        object = e.a.w0.b.a.g(object, (String)object2);
        try {
            object = (o0)object;
            object2 = new ObservableSwitchMapSingle$SwitchMapSingleMainObserver$SwitchMapSingleObserver(this);
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.upstream.dispose();
            object2 = this.inner;
            ObservableSwitchMapSingle$SwitchMapSingleMainObserver$SwitchMapSingleObserver observableSwitchMapSingle$SwitchMapSingleMainObserver$SwitchMapSingleObserver2 = INNER_DISPOSED;
            ((AtomicReference)object2).getAndSet(observableSwitchMapSingle$SwitchMapSingleMainObserver$SwitchMapSingleObserver2);
            this.onError(throwable);
            return;
        }
        while ((observableSwitchMapSingle$SwitchMapSingleMainObserver$SwitchMapSingleObserver = (ObservableSwitchMapSingle$SwitchMapSingleMainObserver$SwitchMapSingleObserver)this.inner.get()) != (atomicReference = INNER_DISPOSED)) {
            atomicReference = this.inner;
            boolean bl2 = atomicReference.compareAndSet(observableSwitchMapSingle$SwitchMapSingleMainObserver$SwitchMapSingleObserver, object2);
            if (!bl2) continue;
            object.f((l0)object2);
            break;
        }
        return;
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

