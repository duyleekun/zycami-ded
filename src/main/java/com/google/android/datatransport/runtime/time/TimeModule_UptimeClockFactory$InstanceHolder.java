/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.time;

import com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory;

public final class TimeModule_UptimeClockFactory$InstanceHolder {
    private static final TimeModule_UptimeClockFactory INSTANCE;

    static {
        TimeModule_UptimeClockFactory timeModule_UptimeClockFactory;
        INSTANCE = timeModule_UptimeClockFactory = new TimeModule_UptimeClockFactory();
    }

    private TimeModule_UptimeClockFactory$InstanceHolder() {
    }

    public static /* synthetic */ TimeModule_UptimeClockFactory access$000() {
        return INSTANCE;
    }
}

