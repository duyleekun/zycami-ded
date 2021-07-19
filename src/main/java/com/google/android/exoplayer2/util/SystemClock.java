/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  android.os.SystemClock
 */
package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.android.exoplayer2.util.SystemHandlerWrapper;

public class SystemClock
implements Clock {
    public HandlerWrapper createHandler(Looper looper, Handler.Callback callback) {
        Handler handler = new Handler(looper, callback);
        SystemHandlerWrapper systemHandlerWrapper = new SystemHandlerWrapper(handler);
        return systemHandlerWrapper;
    }

    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public long elapsedRealtime() {
        return android.os.SystemClock.elapsedRealtime();
    }

    public void sleep(long l10) {
        android.os.SystemClock.sleep((long)l10);
    }

    public long uptimeMillis() {
        return android.os.SystemClock.uptimeMillis();
    }
}

