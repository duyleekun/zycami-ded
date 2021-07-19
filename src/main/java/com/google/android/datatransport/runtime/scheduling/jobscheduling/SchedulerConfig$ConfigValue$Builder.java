/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig$ConfigValue;
import java.util.Set;

public abstract class SchedulerConfig$ConfigValue$Builder {
    public abstract SchedulerConfig$ConfigValue build();

    public abstract SchedulerConfig$ConfigValue$Builder setDelta(long var1);

    public abstract SchedulerConfig$ConfigValue$Builder setFlags(Set var1);

    public abstract SchedulerConfig$ConfigValue$Builder setMaxAllowedDelay(long var1);
}

