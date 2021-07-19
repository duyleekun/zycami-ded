/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.s0.b;
import e.a.v0.a;
import e.a.w0.c.j;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;

public final class ObservableDoFinally$DoFinallyObserver
extends BasicIntQueueDisposable
implements g0 {
    private static final long serialVersionUID = 4109457741734051389L;
    public final g0 downstream;
    public final a onFinally;
    public j qd;
    public boolean syncFused;
    public b upstream;

    public ObservableDoFinally$DoFinallyObserver(g0 g02, a a10) {
        this.downstream = g02;
        this.onFinally = a10;
    }

    public void clear() {
        this.qd.clear();
    }

    public void dispose() {
        this.upstream.dispose();
        this.runFinally();
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public boolean isEmpty() {
        return this.qd.isEmpty();
    }

    public void onComplete() {
        this.downstream.onComplete();
        this.runFinally();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
        this.runFinally();
    }

    public void onNext(Object object) {
        this.downstream.onNext(object);
    }

    public void onSubscribe(b object) {
        b b10 = this.upstream;
        boolean bl2 = DisposableHelper.validate(b10, (b)object);
        if (bl2) {
            this.upstream = object;
            bl2 = object instanceof j;
            if (bl2) {
                this.qd = object = (j)object;
            }
            object = this.downstream;
            object.onSubscribe(this);
        }
    }

    public Object poll() {
        boolean bl2;
        Object object = this.qd.poll();
        if (object == null && (bl2 = this.syncFused)) {
            this.runFinally();
        }
        return object;
    }

    public int requestFusion(int n10) {
        int n11;
        j j10 = this.qd;
        int n12 = 0;
        if (j10 != null && (n11 = n10 & 4) == 0) {
            if ((n10 = j10.requestFusion(n10)) != 0) {
                int n13 = 1;
                if (n10 == n13) {
                    n12 = n13;
                }
                this.syncFused = n12;
            }
            return n10;
        }
        return 0;
    }

    public void runFinally() {
        a a10 = null;
        int n10 = 1;
        boolean bl2 = this.compareAndSet(0, n10);
        if (bl2) {
            a10 = this.onFinally;
            try {
                a10.run();
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                e.a.a1.a.Y(throwable);
            }
        }
    }
}

