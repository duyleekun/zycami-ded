/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.Map;
import java.util.Objects;

public final class AutoValue_SchedulerConfig
extends SchedulerConfig {
    private final Clock clock;
    private final Map values;

    public AutoValue_SchedulerConfig(Clock clock, Map map) {
        Objects.requireNonNull(clock, "Null clock");
        this.clock = clock;
        Objects.requireNonNull(map, "Null values");
        this.values = map;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof SchedulerConfig;
        if (bl3) {
            boolean bl4;
            Object object2 = this.clock;
            Clock clock = ((SchedulerConfig)(object = (SchedulerConfig)object)).getClock();
            bl3 = object2.equals(clock);
            if (!bl3 || !(bl4 = (object2 = this.values).equals(object = ((SchedulerConfig)object).getValues()))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public Clock getClock() {
        return this.clock;
    }

    public Map getValues() {
        return this.values;
    }

    public int hashCode() {
        int n10 = this.clock.hashCode();
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        n11 = this.values.hashCode();
        return n10 ^ n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SchedulerConfig{clock=");
        Object object = this.clock;
        stringBuilder.append(object);
        stringBuilder.append(", values=");
        object = this.values;
        stringBuilder.append(object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

