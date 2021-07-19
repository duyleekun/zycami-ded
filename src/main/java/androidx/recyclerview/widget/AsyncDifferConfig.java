/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.DiffUtil$ItemCallback;
import java.util.concurrent.Executor;

public final class AsyncDifferConfig {
    private final Executor mBackgroundThreadExecutor;
    private final DiffUtil$ItemCallback mDiffCallback;
    private final Executor mMainThreadExecutor;

    public AsyncDifferConfig(Executor executor, Executor executor2, DiffUtil$ItemCallback diffUtil$ItemCallback) {
        this.mMainThreadExecutor = executor;
        this.mBackgroundThreadExecutor = executor2;
        this.mDiffCallback = diffUtil$ItemCallback;
    }

    public Executor getBackgroundThreadExecutor() {
        return this.mBackgroundThreadExecutor;
    }

    public DiffUtil$ItemCallback getDiffCallback() {
        return this.mDiffCallback;
    }

    public Executor getMainThreadExecutor() {
        return this.mMainThreadExecutor;
    }
}

