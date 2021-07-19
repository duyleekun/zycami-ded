/*
 * Decompiled with CFR 0.151.
 */
package com.chad.library.adapter.base.diff;

import androidx.recyclerview.widget.DiffUtil$ItemCallback;
import f.h2.t.f0;
import java.util.concurrent.Executor;

public final class BrvahAsyncDifferConfig {
    private final Executor backgroundThreadExecutor;
    private final DiffUtil$ItemCallback diffCallback;
    private final Executor mainThreadExecutor;

    public BrvahAsyncDifferConfig(Executor executor, Executor executor2, DiffUtil$ItemCallback diffUtil$ItemCallback) {
        f0.q(executor2, "backgroundThreadExecutor");
        f0.q(diffUtil$ItemCallback, "diffCallback");
        this.mainThreadExecutor = executor;
        this.backgroundThreadExecutor = executor2;
        this.diffCallback = diffUtil$ItemCallback;
    }

    public final Executor getBackgroundThreadExecutor() {
        return this.backgroundThreadExecutor;
    }

    public final DiffUtil$ItemCallback getDiffCallback() {
        return this.diffCallback;
    }

    public final Executor getMainThreadExecutor() {
        return this.mainThreadExecutor;
    }
}

