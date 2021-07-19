/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig$ConfigValue;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SchedulerConfig$Builder {
    private Clock clock;
    private Map values;

    public SchedulerConfig$Builder() {
        HashMap hashMap;
        this.values = hashMap = new HashMap();
    }

    public SchedulerConfig$Builder addConfig(Priority priority, SchedulerConfig$ConfigValue schedulerConfig$ConfigValue) {
        this.values.put(priority, schedulerConfig$ConfigValue);
        return this;
    }

    public SchedulerConfig build() {
        Objects.requireNonNull(this.clock, "missing required property: clock");
        Object object = this.values.keySet();
        int n10 = object.size();
        Object object2 = Priority.values();
        int n11 = ((Priority[])object2).length;
        if (n10 >= n11) {
            object = this.values;
            this.values = object2 = new HashMap();
            return SchedulerConfig.create(this.clock, (Map)object);
        }
        object = new IllegalStateException("Not all priorities have been configured");
        throw object;
    }

    public SchedulerConfig$Builder setClock(Clock clock) {
        this.clock = clock;
        return this;
    }
}

