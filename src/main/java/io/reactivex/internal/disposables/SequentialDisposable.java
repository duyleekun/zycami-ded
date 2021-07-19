/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.disposables;

import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SequentialDisposable
extends AtomicReference
implements b {
    private static final long serialVersionUID = -754898800686245608L;

    public SequentialDisposable() {
    }

    public SequentialDisposable(b b10) {
        this.lazySet(b10);
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.get());
    }

    public boolean replace(b b10) {
        return DisposableHelper.replace(this, b10);
    }

    public boolean update(b b10) {
        return DisposableHelper.set(this, b10);
    }
}

