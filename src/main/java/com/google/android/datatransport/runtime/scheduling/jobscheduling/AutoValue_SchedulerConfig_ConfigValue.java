/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.AutoValue_SchedulerConfig_ConfigValue$1;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig$ConfigValue;
import java.util.Set;

public final class AutoValue_SchedulerConfig_ConfigValue
extends SchedulerConfig$ConfigValue {
    private final long delta;
    private final Set flags;
    private final long maxAllowedDelay;

    private AutoValue_SchedulerConfig_ConfigValue(long l10, long l11, Set set) {
        this.delta = l10;
        this.maxAllowedDelay = l11;
        this.flags = set;
    }

    public /* synthetic */ AutoValue_SchedulerConfig_ConfigValue(long l10, long l11, Set set, AutoValue_SchedulerConfig_ConfigValue$1 autoValue_SchedulerConfig_ConfigValue$1) {
        this(l10, l11, set);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        Object object2 = object instanceof SchedulerConfig$ConfigValue;
        if (object2) {
            Set set;
            boolean bl3;
            long l10;
            long l11 = this.delta;
            long l12 = ((SchedulerConfig$ConfigValue)(object = (SchedulerConfig$ConfigValue)object)).getDelta();
            long l13 = l11 - l12;
            object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object2 || (object2 = (l10 = (l11 = this.maxAllowedDelay) - (l12 = ((SchedulerConfig$ConfigValue)object).getMaxAllowedDelay())) == 0L ? 0 : (l10 < 0L ? -1 : 1)) || !(bl3 = (set = this.flags).equals(object = ((SchedulerConfig$ConfigValue)object).getFlags()))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public long getDelta() {
        return this.delta;
    }

    public Set getFlags() {
        return this.flags;
    }

    public long getMaxAllowedDelay() {
        return this.maxAllowedDelay;
    }

    public int hashCode() {
        long l10 = this.delta;
        int n10 = 32;
        long l11 = l10 >>> n10;
        int n11 = (int)(l10 ^ l11);
        int n12 = 1000003;
        n11 = (n11 ^ n12) * n12;
        l11 = this.maxAllowedDelay;
        n10 = (int)(l11 >>> n10 ^ l11);
        n11 = (n11 ^ n10) * n12;
        n12 = this.flags.hashCode();
        return n11 ^ n12;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ConfigValue{delta=");
        long l10 = this.delta;
        stringBuilder.append(l10);
        stringBuilder.append(", maxAllowedDelay=");
        l10 = this.maxAllowedDelay;
        stringBuilder.append(l10);
        stringBuilder.append(", flags=");
        Set set = this.flags;
        stringBuilder.append(set);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

