/*
 * Decompiled with CFR 0.151.
 */
package com.chad.library.adapter.base.diff;

import androidx.recyclerview.widget.DiffUtil$ItemCallback;
import com.chad.library.adapter.base.diff.BrvahAsyncDifferConfig;
import com.chad.library.adapter.base.diff.BrvahAsyncDifferConfig$Builder$Companion;
import f.h2.t.f0;
import f.q1;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class BrvahAsyncDifferConfig$Builder {
    public static final BrvahAsyncDifferConfig$Builder$Companion Companion;
    private static Executor sDiffExecutor;
    private static final Object sExecutorLock;
    private Executor mBackgroundThreadExecutor;
    private final DiffUtil$ItemCallback mDiffCallback;
    private Executor mMainThreadExecutor;

    static {
        Object object = new BrvahAsyncDifferConfig$Builder$Companion(null);
        Companion = object;
        sExecutorLock = object = new Object();
    }

    public BrvahAsyncDifferConfig$Builder(DiffUtil$ItemCallback diffUtil$ItemCallback) {
        f0.q(diffUtil$ItemCallback, "mDiffCallback");
        this.mDiffCallback = diffUtil$ItemCallback;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final BrvahAsyncDifferConfig build() {
        Object object;
        Object object2 = this.mBackgroundThreadExecutor;
        if (object2 == null) {
            object2 = sExecutorLock;
            synchronized (object2) {
                object = sDiffExecutor;
                if (object == null) {
                    int n10 = 2;
                    sDiffExecutor = object = Executors.newFixedThreadPool(n10);
                }
                object = q1.a;
            }
            this.mBackgroundThreadExecutor = object2 = sDiffExecutor;
        }
        object = this.mMainThreadExecutor;
        Executor executor = this.mBackgroundThreadExecutor;
        if (executor == null) {
            f0.L();
        }
        DiffUtil$ItemCallback diffUtil$ItemCallback = this.mDiffCallback;
        return new BrvahAsyncDifferConfig((Executor)object, executor, diffUtil$ItemCallback);
    }

    public final BrvahAsyncDifferConfig$Builder setBackgroundThreadExecutor(Executor executor) {
        this.mBackgroundThreadExecutor = executor;
        return this;
    }

    public final BrvahAsyncDifferConfig$Builder setMainThreadExecutor(Executor executor) {
        this.mMainThreadExecutor = executor;
        return this;
    }
}

