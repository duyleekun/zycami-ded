/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.time;

import com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory;

public final class TimeModule_EventClockFactory$InstanceHolder {
    private static final TimeModule_EventClockFactory INSTANCE;

    static {
        TimeModule_EventClockFactory timeModule_EventClockFactory;
        INSTANCE = timeModule_EventClockFactory = new TimeModule_EventClockFactory();
    }

    private TimeModule_EventClockFactory$InstanceHolder() {
    }

    public static /* synthetic */ TimeModule_EventClockFactory access$000() {
        return INSTANCE;
    }
}

