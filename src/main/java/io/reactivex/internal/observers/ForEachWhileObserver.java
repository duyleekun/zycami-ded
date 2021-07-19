/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.observers;

import e.a.a1.a;
import e.a.g0;
import e.a.s0.b;
import e.a.v0.g;
import e.a.v0.r;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ForEachWhileObserver
extends AtomicReference
implements g0,
b {
    private static final long serialVersionUID = -4403180040475402120L;
    public boolean done;
    public final e.a.v0.a onComplete;
    public final g onError;
    public final r onNext;

    public ForEachWhileObserver(r r10, g g10, e.a.v0.a a10) {
        this.onNext = r10;
        this.onError = g10;
        this.onComplete = a10;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.get());
    }

    public void onComplete() {
        boolean bl2 = this.done;
        if (bl2) {
            return;
        }
        this.done = bl2 = true;
        e.a.v0.a a10 = this.onComplete;
        try {
            a10.run();
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            a.Y(throwable);
        }
    }

    public void onError(Throwable throwable) {
        int n10 = (int)(this.done ? 1 : 0);
        if (n10 != 0) {
            a.Y(throwable);
            return;
        }
        n10 = 1;
        this.done = n10;
        g g10 = this.onError;
        try {
            g10.accept(throwable);
        }
        catch (Throwable throwable2) {
            e.a.t0.a.b(throwable2);
            int n11 = 2;
            Throwable[] throwableArray = new Throwable[n11];
            throwableArray[0] = throwable;
            throwableArray[n10] = throwable2;
            CompositeException compositeException = new CompositeException(throwableArray);
            a.Y(compositeException);
        }
    }

    public void onNext(Object object) {
        r r10;
        boolean bl2 = this.done;
        if (bl2) {
            return;
        }
        try {
            r10 = this.onNext;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.dispose();
            this.onError(throwable);
            return;
        }
        boolean bl3 = r10.test(object);
        if (!bl3) {
            this.dispose();
            this.onComplete();
        }
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this, b10);
    }
}

