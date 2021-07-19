/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.time;

import com.google.android.datatransport.runtime.time.Clock;
import java.util.concurrent.atomic.AtomicLong;

public class TestClock
implements Clock {
    private final AtomicLong timestamp;

    public TestClock(long l10) {
        AtomicLong atomicLong;
        this.timestamp = atomicLong = new AtomicLong(l10);
    }

    public void advance(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object >= 0) {
            this.timestamp.addAndGet(l10);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("cannot advance time backwards.");
        throw illegalArgumentException;
    }

    public long getTime() {
        return this.timestamp.get();
    }

    public void tick() {
        this.advance(1L);
    }
}

