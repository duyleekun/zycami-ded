/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.s0.b;
import e.a.w0.f.a;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.observable.ObservableGroupBy$GroupByObserver;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableGroupBy$State
extends AtomicInteger
implements b,
e0 {
    private static final long serialVersionUID = -3852313036005250360L;
    public final AtomicReference actual;
    public final AtomicBoolean cancelled;
    public final boolean delayError;
    public volatile boolean done;
    public Throwable error;
    public final Object key;
    public final AtomicBoolean once;
    public final ObservableGroupBy$GroupByObserver parent;
    public final a queue;

    public ObservableGroupBy$State(int n10, ObservableGroupBy$GroupByObserver observableGroupBy$GroupByObserver, Object object, boolean bl2) {
        Object object2 = new AtomicBoolean();
        this.cancelled = object2;
        object2 = new AtomicBoolean();
        this.once = object2;
        this.actual = object2;
        this.queue = object2 = new a(n10);
        this.parent = observableGroupBy$GroupByObserver;
        this.key = object;
        this.delayError = bl2;
    }

    public boolean checkTerminated(boolean bl2, boolean bl3, g0 g02, boolean bl4) {
        AtomicBoolean atomicBoolean = this.cancelled;
        boolean bl5 = atomicBoolean.get();
        boolean bl6 = true;
        if (bl5) {
            this.queue.clear();
            ObservableGroupBy$GroupByObserver observableGroupBy$GroupByObserver = this.parent;
            Object object = this.key;
            observableGroupBy$GroupByObserver.cancel(object);
            this.actual.lazySet(null);
            return bl6;
        }
        if (bl2) {
            if (bl4) {
                if (bl3) {
                    Throwable throwable = this.error;
                    AtomicReference atomicReference = this.actual;
                    atomicReference.lazySet(null);
                    if (throwable != null) {
                        g02.onError(throwable);
                    } else {
                        g02.onComplete();
                    }
                    return bl6;
                }
            } else {
                Throwable throwable = this.error;
                if (throwable != null) {
                    this.queue.clear();
                    this.actual.lazySet(null);
                    g02.onError(throwable);
                    return bl6;
                }
                if (bl3) {
                    this.actual.lazySet(null);
                    g02.onComplete();
                    return bl6;
                }
            }
        }
        return false;
    }

    public void dispose() {
        int n10;
        Serializable serializable = this.cancelled;
        Object object = null;
        boolean bl2 = true;
        boolean n102 = ((AtomicBoolean)serializable).compareAndSet(false, bl2);
        if (n102 && (n10 = this.getAndIncrement()) == 0) {
            this.actual.lazySet(null);
            serializable = this.parent;
            object = this.key;
            ((ObservableGroupBy$GroupByObserver)serializable).cancel(object);
        }
    }

    public void drain() {
        boolean bl2;
        int n10 = this.getAndIncrement();
        if (n10 != 0) {
            return;
        }
        a a10 = this.queue;
        boolean bl3 = this.delayError;
        g0 g02 = (g0)this.actual.get();
        boolean bl4 = bl2 = true;
        while (true) {
            if (g02 != null) {
                while (true) {
                    boolean bl5 = this.done;
                    Object object = a10.poll();
                    boolean bl6 = object == null ? bl2 : false;
                    if (bl5 = this.checkTerminated(bl5, bl6, g02, bl3)) {
                        return;
                    }
                    if (bl6) break;
                    g02.onNext(object);
                }
            }
            bl4 = -bl4;
            if (!(bl4 = this.addAndGet((int)(bl4 ? 1 : 0)))) {
                return;
            }
            if (g02 != null) continue;
            g02 = (g0)this.actual.get();
        }
    }

    public boolean isDisposed() {
        return this.cancelled.get();
    }

    public void onComplete() {
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        this.error = throwable;
        this.done = true;
        this.drain();
    }

    public void onNext(Object object) {
        this.queue.offer(object);
        this.drain();
    }

    public void subscribe(g0 object) {
        Serializable serializable = this.once;
        String string2 = null;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)serializable).compareAndSet(false, bl2);
        if (bl3) {
            object.onSubscribe(this);
            serializable = this.actual;
            ((AtomicReference)serializable).lazySet(object);
            object = this.cancelled;
            boolean bl4 = ((AtomicBoolean)object).get();
            if (bl4) {
                object = this.actual;
                bl3 = false;
                serializable = null;
                ((AtomicReference)object).lazySet(null);
            } else {
                this.drain();
            }
        } else {
            string2 = "Only one Observer allowed!";
            serializable = new IllegalStateException(string2);
            EmptyDisposable.error((Throwable)serializable, (g0)object);
        }
    }
}

