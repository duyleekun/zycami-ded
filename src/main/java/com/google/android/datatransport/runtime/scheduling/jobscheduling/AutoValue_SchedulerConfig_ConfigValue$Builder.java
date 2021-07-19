/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.AutoValue_SchedulerConfig_ConfigValue;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig$ConfigValue;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig$ConfigValue$Builder;
import java.util.Objects;
import java.util.Set;

public final class AutoValue_SchedulerConfig_ConfigValue$Builder
extends SchedulerConfig$ConfigValue$Builder {
    private Long delta;
    private Set flags;
    private Long maxAllowedDelay;

    public SchedulerConfig$ConfigValue build() {
        boolean bl2;
        Object object = this.delta;
        String string2 = "";
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" delta");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.maxAllowedDelay) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" maxAllowedDelay");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.flags) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" flags");
            string2 = ((StringBuilder)object).toString();
        }
        if (bl2 = string2.isEmpty()) {
            long l10 = this.delta;
            long l11 = this.maxAllowedDelay;
            Set set = this.flags;
            Object object2 = object;
            object = new AutoValue_SchedulerConfig_ConfigValue(l10, l11, set, null);
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Missing required properties:");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public SchedulerConfig$ConfigValue$Builder setDelta(long l10) {
        Long l11;
        this.delta = l11 = Long.valueOf(l10);
        return this;
    }

    public SchedulerConfig$ConfigValue$Builder setFlags(Set set) {
        Objects.requireNonNull(set, "Null flags");
        this.flags = set;
        return this;
    }

    public SchedulerConfig$ConfigValue$Builder setMaxAllowedDelay(long l10) {
        Long l11;
        this.maxAllowedDelay = l11 = Long.valueOf(l10);
        return this;
    }
}

