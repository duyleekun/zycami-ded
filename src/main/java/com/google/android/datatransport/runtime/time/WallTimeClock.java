/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.time;

import com.google.android.datatransport.runtime.time.Clock;

public class WallTimeClock
implements Clock {
    public long getTime() {
        return System.currentTimeMillis();
    }
}

