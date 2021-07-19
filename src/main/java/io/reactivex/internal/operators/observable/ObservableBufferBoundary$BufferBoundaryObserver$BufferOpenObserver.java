/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableBufferBoundary$BufferBoundaryObserver;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableBufferBoundary$BufferBoundaryObserver$BufferOpenObserver
extends AtomicReference
implements g0,
b {
    private static final long serialVersionUID = -8498650778633225126L;
    public final ObservableBufferBoundary$BufferBoundaryObserver parent;

    public ObservableBufferBoundary$BufferBoundaryObserver$BufferOpenObserver(ObservableBufferBoundary$BufferBoundaryObserver bufferBoundaryObserver) {
        this.parent = bufferBoundaryObserver;
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
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        this.lazySet(disposableHelper);
        this.parent.openComplete(this);
    }

    public void onError(Throwable throwable) {
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        this.lazySet(disposableHelper);
        this.parent.boundaryError(this, throwable);
    }

    public void onNext(Object object) {
        this.parent.open(object);
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this, b10);
    }
}

