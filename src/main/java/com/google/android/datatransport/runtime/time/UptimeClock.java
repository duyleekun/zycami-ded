/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 */
package com.google.android.datatransport.runtime.time;

import android.os.SystemClock;
import com.google.android.datatransport.runtime.time.Clock;

public class UptimeClock
implements Clock {
    public long getTime() {
        return SystemClock.elapsedRealtime();
    }
}

