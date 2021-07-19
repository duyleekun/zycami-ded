/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Looper
 */
package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.android.exoplayer2.util.SystemClock;

public interface Clock {
    public static final Clock DEFAULT;

    static {
        SystemClock systemClock = new SystemClock();
        DEFAULT = systemClock;
    }

    public HandlerWrapper createHandler(Looper var1, Handler.Callback var2);

    public long currentTimeMillis();

    public long elapsedRealtime();

    public void sleep(long var1);

    public long uptimeMillis();
}

