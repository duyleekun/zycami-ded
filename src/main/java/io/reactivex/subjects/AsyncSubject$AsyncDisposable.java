/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.subjects;

import e.a.a1.a;
import e.a.g0;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.subjects.AsyncSubject;

public final class AsyncSubject$AsyncDisposable
extends DeferredScalarDisposable {
    private static final long serialVersionUID = 5629876084736248016L;
    public final AsyncSubject parent;

    public AsyncSubject$AsyncDisposable(g0 g02, AsyncSubject asyncSubject) {
        super(g02);
        this.parent = asyncSubject;
    }

    public void dispose() {
        boolean bl2 = super.tryDispose();
        if (bl2) {
            AsyncSubject asyncSubject = this.parent;
            asyncSubject.s8(this);
        }
    }

    public void onComplete() {
        boolean bl2 = this.isDisposed();
        if (!bl2) {
            g0 g02 = this.downstream;
            g02.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.isDisposed();
        if (bl2) {
            a.Y(throwable);
        } else {
            g0 g02 = this.downstream;
            g02.onError(throwable);
        }
    }
}

