/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.disposables;

import io.reactivex.disposables.ReferenceDisposable;

public final class RunnableDisposable
extends ReferenceDisposable {
    private static final long serialVersionUID = -8219729196779211169L;

    public RunnableDisposable(Runnable runnable) {
        super(runnable);
    }

    public void onDisposed(Runnable runnable) {
        runnable.run();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RunnableDisposable(disposed=");
        boolean bl2 = this.isDisposed();
        stringBuilder.append(bl2);
        stringBuilder.append(", ");
        Object v10 = this.get();
        stringBuilder.append(v10);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

