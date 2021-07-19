/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.s0.b;
import e.a.t;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.maybe.MaybeZipArray$ZipCoordinator;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeZipArray$ZipMaybeObserver
extends AtomicReference
implements t {
    private static final long serialVersionUID = 3323743579927613702L;
    public final int index;
    public final MaybeZipArray$ZipCoordinator parent;

    public MaybeZipArray$ZipMaybeObserver(MaybeZipArray$ZipCoordinator maybeZipArray$ZipCoordinator, int n10) {
        this.parent = maybeZipArray$ZipCoordinator;
        this.index = n10;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public void onComplete() {
        MaybeZipArray$ZipCoordinator maybeZipArray$ZipCoordinator = this.parent;
        int n10 = this.index;
        maybeZipArray$ZipCoordinator.innerComplete(n10);
    }

    public void onError(Throwable throwable) {
        MaybeZipArray$ZipCoordinator maybeZipArray$ZipCoordinator = this.parent;
        int n10 = this.index;
        maybeZipArray$ZipCoordinator.innerError(throwable, n10);
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this, b10);
    }

    public void onSuccess(Object object) {
        MaybeZipArray$ZipCoordinator maybeZipArray$ZipCoordinator = this.parent;
        int n10 = this.index;
        maybeZipArray$ZipCoordinator.innerSuccess(object, n10);
    }
}

