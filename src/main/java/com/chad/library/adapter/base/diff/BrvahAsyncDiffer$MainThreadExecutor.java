/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package com.chad.library.adapter.base.diff;

import android.os.Handler;
import android.os.Looper;
import f.h2.t.f0;
import java.util.concurrent.Executor;

public final class BrvahAsyncDiffer$MainThreadExecutor
implements Executor {
    private final Handler mHandler;

    public BrvahAsyncDiffer$MainThreadExecutor() {
        Handler handler;
        Looper looper = Looper.getMainLooper();
        this.mHandler = handler = new Handler(looper);
    }

    public void execute(Runnable runnable) {
        f0.q(runnable, "command");
        this.mHandler.post(runnable);
    }

    public final Handler getMHandler() {
        return this.mHandler;
    }
}

