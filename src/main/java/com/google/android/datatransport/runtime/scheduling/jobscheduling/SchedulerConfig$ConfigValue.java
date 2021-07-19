/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.AutoValue_SchedulerConfig_ConfigValue$Builder;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig$ConfigValue$Builder;
import java.util.Collections;
import java.util.Set;

public abstract class SchedulerConfig$ConfigValue {
    public static SchedulerConfig$ConfigValue$Builder builder() {
        AutoValue_SchedulerConfig_ConfigValue$Builder autoValue_SchedulerConfig_ConfigValue$Builder = new AutoValue_SchedulerConfig_ConfigValue$Builder();
        Set set = Collections.emptySet();
        return autoValue_SchedulerConfig_ConfigValue$Builder.setFlags(set);
    }

    public abstract long getDelta();

    public abstract Set getFlags();

    public abstract long getMaxAllowedDelay();
}

