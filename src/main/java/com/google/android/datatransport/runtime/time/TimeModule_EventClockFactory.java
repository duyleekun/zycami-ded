/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.time;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.time.TimeModule;
import com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory$InstanceHolder;

public final class TimeModule_EventClockFactory
implements Factory {
    public static TimeModule_EventClockFactory create() {
        return TimeModule_EventClockFactory$InstanceHolder.access$000();
    }

    public static Clock eventClock() {
        return (Clock)Preconditions.checkNotNull(TimeModule.eventClock(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public Clock get() {
        return TimeModule_EventClockFactory.eventClock();
    }
}

