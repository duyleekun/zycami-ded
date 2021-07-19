/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.a1.a;
import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableBufferBoundary$BufferBoundaryObserver;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableBufferBoundary$BufferCloseObserver
extends AtomicReference
implements g0,
b {
    private static final long serialVersionUID = -8498650778633225126L;
    public final long index;
    public final ObservableBufferBoundary$BufferBoundaryObserver parent;

    public ObservableBufferBoundary$BufferCloseObserver(ObservableBufferBoundary$BufferBoundaryObserver observableBufferBoundary$BufferBoundaryObserver, long l10) {
        this.parent = observableBufferBoundary$BufferBoundaryObserver;
        this.index = l10;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        boolean bl2;
        DisposableHelper disposableHelper;
        Object v10 = this.get();
        if (v10 == (disposableHelper = DisposableHelper.DISPOSED)) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
    }

    public void onComplete() {
        DisposableHelper disposableHelper;
        Object object = this.get();
        if (object != (disposableHelper = DisposableHelper.DISPOSED)) {
            this.lazySet(disposableHelper);
            object = this.parent;
            long l10 = this.index;
            ((ObservableBufferBoundary$BufferBoundaryObserver)object).close(this, l10);
        }
    }

    public void onError(Throwable throwable) {
        DisposableHelper disposableHelper;
        Object object = this.get();
        if (object != (disposableHelper = DisposableHelper.DISPOSED)) {
            this.lazySet(disposableHelper);
            object = this.parent;
            ((ObservableBufferBoundary$BufferBoundaryObserver)object).boundaryError(this, throwable);
        } else {
            a.Y(throwable);
        }
    }

    public void onNext(Object object) {
        DisposableHelper disposableHelper;
        object = (b)this.get();
        if (object != (disposableHelper = DisposableHelper.DISPOSED)) {
            this.lazySet(disposableHelper);
            object.dispose();
            object = this.parent;
            long l10 = this.index;
            ((ObservableBufferBoundary$BufferBoundaryObserver)object).close(this, l10);
        }
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this, b10);
    }
}

