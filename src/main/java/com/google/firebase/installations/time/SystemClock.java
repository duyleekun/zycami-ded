/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.installations.time;

import com.google.firebase.installations.time.Clock;

public class SystemClock
implements Clock {
    private static SystemClock singleton;

    private SystemClock() {
    }

    public static SystemClock getInstance() {
        SystemClock systemClock = singleton;
        if (systemClock == null) {
            singleton = systemClock = new SystemClock();
        }
        return singleton;
    }

    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}

