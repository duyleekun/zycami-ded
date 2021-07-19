/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.s0.b;
import e.a.v0.d;
import e.a.w0.f.a;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.operators.observable.ObservableSequenceEqual$a;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableSequenceEqual$EqualCoordinator
extends AtomicInteger
implements b {
    private static final long serialVersionUID = -6178010334400373240L;
    public volatile boolean cancelled;
    public final d comparer;
    public final g0 downstream;
    public final e0 first;
    public final ObservableSequenceEqual$a[] observers;
    public final ArrayCompositeDisposable resources;
    public final e0 second;
    public Object v1;
    public Object v2;

    public ObservableSequenceEqual$EqualCoordinator(g0 g02, int n10, e0 observableSequenceEqual$aArray, e0 object, d d10) {
        ArrayCompositeDisposable arrayCompositeDisposable;
        this.downstream = g02;
        this.first = observableSequenceEqual$aArray;
        this.second = object;
        this.comparer = d10;
        int n11 = 2;
        observableSequenceEqual$aArray = new ObservableSequenceEqual$a[n11];
        this.observers = observableSequenceEqual$aArray;
        observableSequenceEqual$aArray[0] = object = new ObservableSequenceEqual$a(this, 0, n10);
        int n12 = 1;
        observableSequenceEqual$aArray[n12] = object = new ObservableSequenceEqual$a(this, n12, n10);
        this.resources = arrayCompositeDisposable = new ArrayCompositeDisposable(n11);
    }

    public void cancel(a a10, a a11) {
        this.cancelled = true;
        a10.clear();
        a11.clear();
    }

    public void dispose() {
        int n10 = (int)(this.cancelled ? 1 : 0);
        if (n10 == 0) {
            n10 = 1;
            this.cancelled = n10;
            ObservableSequenceEqual$a[] observableSequenceEqual$aArray = this.resources;
            observableSequenceEqual$aArray.dispose();
            int n11 = this.getAndIncrement();
            if (n11 == 0) {
                observableSequenceEqual$aArray = this.observers;
                a a10 = observableSequenceEqual$aArray[0].b;
                a10.clear();
                a a11 = observableSequenceEqual$aArray[n10].b;
                a11.clear();
            }
        }
    }

    public void drain() {
        Object object = Boolean.FALSE;
        int n10 = this.getAndIncrement();
        if (n10 != 0) {
            return;
        }
        Object object2 = this.observers;
        ObservableSequenceEqual$a observableSequenceEqual$a = object2[0];
        a a10 = observableSequenceEqual$a.b;
        int n11 = 1;
        object2 = object2[n11];
        a a11 = object2.b;
        int n12 = n11;
        while (true) {
            int n13;
            Object object3;
            Object object4;
            boolean bl2;
            if (bl2 = this.cancelled) {
                a10.clear();
                a11.clear();
                return;
            }
            bl2 = observableSequenceEqual$a.d;
            if (bl2 && (object4 = observableSequenceEqual$a.e) != null) {
                this.cancel(a10, a11);
                this.downstream.onError((Throwable)object4);
                return;
            }
            boolean bl3 = object2.d;
            if (bl3 && (object3 = object2.e) != null) {
                this.cancel(a10, a11);
                this.downstream.onError((Throwable)object3);
                return;
            }
            object3 = this.v1;
            if (object3 == null) {
                this.v1 = object3 = a10.poll();
            }
            if ((object3 = this.v1) == null) {
                n13 = n11;
            } else {
                n13 = 0;
                object3 = null;
            }
            Object object5 = this.v2;
            if (object5 == null) {
                this.v2 = object5 = a11.poll();
            }
            int n14 = (object5 = this.v2) == null ? n11 : 0;
            if (bl2 && bl3 && n13 != 0 && n14 != 0) {
                object = this.downstream;
                object2 = Boolean.TRUE;
                object.onNext(object2);
                this.downstream.onComplete();
                return;
            }
            if (bl2 && bl3 && n13 != n14) {
                this.cancel(a10, a11);
                this.downstream.onNext(object);
                this.downstream.onComplete();
                return;
            }
            if (n13 == 0 && n14 == 0) {
                d d10;
                try {
                    d10 = this.comparer;
                }
                catch (Throwable throwable) {
                    e.a.t0.a.b(throwable);
                    this.cancel(a10, a11);
                    this.downstream.onError(throwable);
                    return;
                }
                object4 = this.v1;
                bl2 = d10.a(object4, object5);
                if (!bl2) {
                    this.cancel(a10, a11);
                    this.downstream.onNext(object);
                    this.downstream.onComplete();
                    return;
                }
                bl2 = false;
                d10 = null;
                this.v1 = null;
                this.v2 = null;
            }
            if (n13 == 0 && n14 == 0) continue;
            n12 = -n12;
            if ((n12 = this.addAndGet(n12)) == 0) break;
        }
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    public boolean setDisposable(b b10, int n10) {
        return this.resources.setResource(n10, b10);
    }

    public void subscribe() {
        Object object = this.observers;
        e0 e02 = this.first;
        ObservableSequenceEqual$a observableSequenceEqual$a = object[0];
        e02.subscribe(observableSequenceEqual$a);
        e02 = this.second;
        object = object[1];
        e02.subscribe((g0)object);
    }
}

