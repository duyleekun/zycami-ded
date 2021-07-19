/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.observers;

import e.a.g0;
import e.a.s0.b;
import e.a.w0.c.o;
import e.a.w0.d.j;
import e.a.w0.i.n;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class InnerQueuedObserver
extends AtomicReference
implements g0,
b {
    private static final long serialVersionUID = -5417183359794346637L;
    public volatile boolean done;
    public int fusionMode;
    public final j parent;
    public final int prefetch;
    public o queue;

    public InnerQueuedObserver(j j10, int n10) {
        this.parent = j10;
        this.prefetch = n10;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public int fusionMode() {
        return this.fusionMode;
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.get());
    }

    public boolean isDone() {
        return this.done;
    }

    public void onComplete() {
        this.parent.innerComplete(this);
    }

    public void onError(Throwable throwable) {
        this.parent.innerError(this, throwable);
    }

    public void onNext(Object object) {
        int n10 = this.fusionMode;
        if (n10 == 0) {
            j j10 = this.parent;
            j10.innerNext(this, object);
        } else {
            object = this.parent;
            object.drain();
        }
    }

    public void onSubscribe(b object) {
        int n10 = DisposableHelper.setOnce(this, (b)object);
        if (n10 != 0) {
            n10 = object instanceof e.a.w0.c.j;
            if (n10 != 0) {
                int n11;
                n10 = (object = (e.a.w0.c.j)object).requestFusion(3);
                if (n10 == (n11 = 1)) {
                    this.fusionMode = n10;
                    this.queue = object;
                    this.done = n11;
                    this.parent.innerComplete(this);
                    return;
                }
                n11 = 2;
                if (n10 == n11) {
                    this.fusionMode = n10;
                    this.queue = object;
                    return;
                }
            }
            int n12 = -this.prefetch;
            this.queue = object = n.c(n12);
        }
    }

    public o queue() {
        return this.queue;
    }

    public void setDone() {
        this.done = true;
    }
}

