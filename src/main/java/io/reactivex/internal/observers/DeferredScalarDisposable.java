/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.observers;

import e.a.a1.a;
import e.a.g0;
import io.reactivex.internal.observers.BasicIntQueueDisposable;

public class DeferredScalarDisposable
extends BasicIntQueueDisposable {
    public static final int DISPOSED = 4;
    public static final int FUSED_CONSUMED = 32;
    public static final int FUSED_EMPTY = 8;
    public static final int FUSED_READY = 16;
    public static final int TERMINATED = 2;
    private static final long serialVersionUID = -5502432239815349361L;
    public final g0 downstream;
    public Object value;

    public DeferredScalarDisposable(g0 g02) {
        this.downstream = g02;
    }

    public final void clear() {
        this.lazySet(32);
        this.value = null;
    }

    public final void complete() {
        int n10 = this.get() & 0x36;
        if (n10 != 0) {
            return;
        }
        this.lazySet(2);
        this.downstream.onComplete();
    }

    public final void complete(Object object) {
        int n10;
        int n11 = this.get();
        int n12 = n11 & 0x36;
        if (n12 != 0) {
            return;
        }
        g0 g02 = this.downstream;
        int n13 = 8;
        if (n11 == n13) {
            this.value = object;
            this.lazySet(16);
            n10 = 0;
            object = null;
            g02.onNext(null);
        } else {
            n11 = 2;
            this.lazySet(n11);
            g02.onNext(object);
        }
        n10 = this.get();
        n11 = 4;
        if (n10 != n11) {
            g02.onComplete();
        }
    }

    public void dispose() {
        this.set(4);
        this.value = null;
    }

    public final void error(Throwable throwable) {
        int n10 = this.get() & 0x36;
        if (n10 != 0) {
            a.Y(throwable);
            return;
        }
        this.lazySet(2);
        this.downstream.onError(throwable);
    }

    public final boolean isDisposed() {
        int n10;
        int n11 = this.get();
        n11 = n11 == (n10 = 4) ? 1 : 0;
        return n11 != 0;
    }

    public final boolean isEmpty() {
        int n10;
        int n11 = this.get();
        n11 = n11 != (n10 = 16) ? 1 : 0;
        return n11 != 0;
    }

    public final Object poll() {
        int n10;
        int n11 = this.get();
        if (n11 == (n10 = 16)) {
            Object object = this.value;
            this.value = null;
            this.lazySet(32);
            return object;
        }
        return null;
    }

    public final int requestFusion(int n10) {
        int n11 = 2;
        if ((n10 &= n11) != 0) {
            this.lazySet(8);
            return n11;
        }
        return 0;
    }

    public final boolean tryDispose() {
        int n10 = 4;
        int n11 = this.getAndSet(n10);
        n10 = n11 != n10 ? 1 : 0;
        return n10 != 0;
    }
}

