/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.w0.c.j;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableScalarXMap$ScalarDisposable
extends AtomicInteger
implements j,
Runnable {
    public static final int FUSED = 1;
    public static final int ON_COMPLETE = 3;
    public static final int ON_NEXT = 2;
    public static final int START = 0;
    private static final long serialVersionUID = 3880992722410194083L;
    public final g0 observer;
    public final Object value;

    public ObservableScalarXMap$ScalarDisposable(g0 g02, Object object) {
        this.observer = g02;
        this.value = object;
    }

    public void clear() {
        this.lazySet(3);
    }

    public void dispose() {
        this.set(3);
    }

    public boolean isDisposed() {
        int n10;
        int n11 = this.get();
        n11 = n11 == (n10 = 3) ? 1 : 0;
        return n11 != 0;
    }

    public boolean isEmpty() {
        int n10;
        int n11 = this.get();
        if (n11 == (n10 = 1)) {
            n10 = 0;
        }
        return n10 != 0;
    }

    public boolean offer(Object object) {
        object = new UnsupportedOperationException("Should not be called!");
        throw object;
    }

    public boolean offer(Object object, Object object2) {
        object = new UnsupportedOperationException("Should not be called!");
        throw object;
    }

    public Object poll() {
        int n10;
        int n11 = this.get();
        if (n11 == (n10 = 1)) {
            this.lazySet(3);
            return this.value;
        }
        return null;
    }

    public int requestFusion(int n10) {
        int n11 = 1;
        if ((n10 &= n11) != 0) {
            this.lazySet(n11);
            return n11;
        }
        return 0;
    }

    public void run() {
        int n10 = this.get();
        if (n10 == 0) {
            g0 g02 = null;
            int n11 = 2;
            n10 = (int)(this.compareAndSet(0, n11) ? 1 : 0);
            if (n10 != 0) {
                g02 = this.observer;
                Object object = this.value;
                g02.onNext(object);
                n10 = this.get();
                if (n10 == n11) {
                    n10 = 3;
                    this.lazySet(n10);
                    g02 = this.observer;
                    g02.onComplete();
                }
            }
        }
    }
}

