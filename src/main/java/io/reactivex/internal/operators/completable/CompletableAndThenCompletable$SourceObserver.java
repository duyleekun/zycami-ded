/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.completable;

import e.a.d;
import e.a.g;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.completable.CompletableAndThenCompletable$a;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableAndThenCompletable$SourceObserver
extends AtomicReference
implements d,
b {
    private static final long serialVersionUID = -4101678820158072998L;
    public final d actualObserver;
    public final g next;

    public CompletableAndThenCompletable$SourceObserver(d d10, g g10) {
        this.actualObserver = d10;
        this.next = g10;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.get());
    }

    public void onComplete() {
        g g10 = this.next;
        d d10 = this.actualObserver;
        CompletableAndThenCompletable$a completableAndThenCompletable$a = new CompletableAndThenCompletable$a(this, d10);
        g10.f(completableAndThenCompletable$a);
    }

    public void onError(Throwable throwable) {
        this.actualObserver.onError(throwable);
    }

    public void onSubscribe(b object) {
        boolean bl2 = DisposableHelper.setOnce(this, (b)object);
        if (bl2) {
            object = this.actualObserver;
            object.onSubscribe(this);
        }
    }
}

