/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 */
package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.util.HandlerWrapper;

public final class SystemHandlerWrapper
implements HandlerWrapper {
    private final Handler handler;

    public SystemHandlerWrapper(Handler handler) {
        this.handler = handler;
    }

    public Looper getLooper() {
        return this.handler.getLooper();
    }

    public boolean hasMessages(int n10) {
        return this.handler.hasMessages(n10);
    }

    public Message obtainMessage(int n10) {
        return this.handler.obtainMessage(n10);
    }

    public Message obtainMessage(int n10, int n11, int n12) {
        return this.handler.obtainMessage(n10, n11, n12);
    }

    public Message obtainMessage(int n10, int n11, int n12, Object object) {
        return this.handler.obtainMessage(n10, n11, n12, object);
    }

    public Message obtainMessage(int n10, Object object) {
        return this.handler.obtainMessage(n10, object);
    }

    public boolean post(Runnable runnable) {
        return this.handler.post(runnable);
    }

    public boolean postDelayed(Runnable runnable, long l10) {
        return this.handler.postDelayed(runnable, l10);
    }

    public void removeCallbacksAndMessages(Object object) {
        this.handler.removeCallbacksAndMessages(object);
    }

    public void removeMessages(int n10) {
        this.handler.removeMessages(n10);
    }

    public boolean sendEmptyMessage(int n10) {
        return this.handler.sendEmptyMessage(n10);
    }

    public boolean sendEmptyMessageAtTime(int n10, long l10) {
        return this.handler.sendEmptyMessageAtTime(n10, l10);
    }

    public boolean sendEmptyMessageDelayed(int n10, int n11) {
        Handler handler = this.handler;
        long l10 = n11;
        return handler.sendEmptyMessageDelayed(n10, l10);
    }
}

