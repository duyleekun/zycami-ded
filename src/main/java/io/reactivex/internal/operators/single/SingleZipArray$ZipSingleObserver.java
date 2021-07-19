/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.l0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.single.SingleZipArray$ZipCoordinator;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleZipArray$ZipSingleObserver
extends AtomicReference
implements l0 {
    private static final long serialVersionUID = 3323743579927613702L;
    public final int index;
    public final SingleZipArray$ZipCoordinator parent;

    public SingleZipArray$ZipSingleObserver(SingleZipArray$ZipCoordinator singleZipArray$ZipCoordinator, int n10) {
        this.parent = singleZipArray$ZipCoordinator;
        this.index = n10;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public void onError(Throwable throwable) {
        SingleZipArray$ZipCoordinator singleZipArray$ZipCoordinator = this.parent;
        int n10 = this.index;
        singleZipArray$ZipCoordinator.innerError(throwable, n10);
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this, b10);
    }

    public void onSuccess(Object object) {
        SingleZipArray$ZipCoordinator singleZipArray$ZipCoordinator = this.parent;
        int n10 = this.index;
        singleZipArray$ZipCoordinator.innerSuccess(object, n10);
    }
}

