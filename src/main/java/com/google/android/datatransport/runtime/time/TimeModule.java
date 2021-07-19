/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.time;

import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.time.UptimeClock;
import com.google.android.datatransport.runtime.time.WallTimeClock;

public abstract class TimeModule {
    public static Clock eventClock() {
        WallTimeClock wallTimeClock = new WallTimeClock();
        return wallTimeClock;
    }

    public static Clock uptimeClock() {
        UptimeClock uptimeClock = new UptimeClock();
        return uptimeClock;
    }
}

