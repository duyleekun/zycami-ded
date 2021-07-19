/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil$ItemCallback;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class AsyncDifferConfig$Builder {
    private static Executor sDiffExecutor;
    private static final Object sExecutorLock;
    private Executor mBackgroundThreadExecutor;
    private final DiffUtil$ItemCallback mDiffCallback;
    private Executor mMainThreadExecutor;

    static {
        Object object;
        sExecutorLock = object = new Object();
    }

    public AsyncDifferConfig$Builder(DiffUtil$ItemCallback diffUtil$ItemCallback) {
        this.mDiffCallback = diffUtil$ItemCallback;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public AsyncDifferConfig build() {
        Executor executor;
        Object object = this.mBackgroundThreadExecutor;
        if (object == null) {
            object = sExecutorLock;
            synchronized (object) {
                executor = sDiffExecutor;
                if (executor == null) {
                    int n10 = 2;
                    sDiffExecutor = executor = Executors.newFixedThreadPool(n10);
                }
            }
            this.mBackgroundThreadExecutor = object = sDiffExecutor;
        }
        executor = this.mMainThreadExecutor;
        Executor executor2 = this.mBackgroundThreadExecutor;
        DiffUtil$ItemCallback diffUtil$ItemCallback = this.mDiffCallback;
        return new AsyncDifferConfig(executor, executor2, diffUtil$ItemCallback);
    }

    public AsyncDifferConfig$Builder setBackgroundThreadExecutor(Executor executor) {
        this.mBackgroundThreadExecutor = executor;
        return this;
    }

    public AsyncDifferConfig$Builder setMainThreadExecutor(Executor executor) {
        this.mMainThreadExecutor = executor;
        return this;
    }
}

