/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package com.google.android.exoplayer2.source;

import android.os.Handler;

public final class ConcatenatingMediaSource$HandlerAndRunnable {
    private final Handler handler;
    private final Runnable runnable;

    public ConcatenatingMediaSource$HandlerAndRunnable(Handler handler, Runnable runnable) {
        this.handler = handler;
        this.runnable = runnable;
    }

    public void dispatch() {
        Handler handler = this.handler;
        Runnable runnable = this.runnable;
        handler.post(runnable);
    }
}

