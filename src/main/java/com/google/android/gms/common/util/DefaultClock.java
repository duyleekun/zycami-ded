/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 */
package com.google.android.gms.common.util;

import android.os.SystemClock;
import com.google.android.gms.common.util.Clock;

public class DefaultClock
implements Clock {
    private static final DefaultClock zza;

    static {
        DefaultClock defaultClock;
        zza = defaultClock = new DefaultClock();
    }

    private DefaultClock() {
    }

    public static Clock getInstance() {
        return zza;
    }

    public long currentThreadTimeMillis() {
        return SystemClock.currentThreadTimeMillis();
    }

    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    public long nanoTime() {
        return System.nanoTime();
    }
}

