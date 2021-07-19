/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.job.JobInfo$Builder
 */
package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AutoValue_SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig$Builder;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig$ConfigValue;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig$ConfigValue$Builder;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig$Flag;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class SchedulerConfig {
    private static final long BACKOFF_LOG_BASE = 10000L;
    private static final long ONE_SECOND = 1000L;
    private static final long THIRTY_SECONDS = 30000L;
    private static final long TWENTY_FOUR_HOURS = 86400000L;

    private long adjustedExponentialBackoff(int n10, long l10) {
        n10 += -1;
        long l11 = 1L;
        double d10 = Double.MIN_VALUE;
        Object object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (object > 0) {
            l11 = l10;
        } else {
            l11 = 2;
            d10 = 1.0E-323;
        }
        double d11 = Math.log(10000.0);
        long l12 = n10;
        d10 = Math.log(l11 * l12);
        d11 /= d10;
        d10 = Math.max(1.0, d11);
        double d12 = n10;
        d11 = Math.pow(3.0, d12);
        double d13 = l10;
        return (long)(d11 * d13 * d10);
    }

    public static SchedulerConfig$Builder builder() {
        SchedulerConfig$Builder schedulerConfig$Builder = new SchedulerConfig$Builder();
        return schedulerConfig$Builder;
    }

    public static SchedulerConfig create(Clock clock, Map map) {
        AutoValue_SchedulerConfig autoValue_SchedulerConfig = new AutoValue_SchedulerConfig(clock, map);
        return autoValue_SchedulerConfig;
    }

    public static SchedulerConfig getDefault(Clock clock) {
        SchedulerConfig$Builder schedulerConfig$Builder = SchedulerConfig.builder();
        Priority priority = Priority.DEFAULT;
        Object object = SchedulerConfig$ConfigValue.builder().setDelta(30000L);
        long l10 = 86400000L;
        object = ((SchedulerConfig$ConfigValue$Builder)object).setMaxAllowedDelay(l10).build();
        schedulerConfig$Builder = schedulerConfig$Builder.addConfig(priority, (SchedulerConfig$ConfigValue)object);
        priority = Priority.HIGHEST;
        object = SchedulerConfig$ConfigValue.builder().setDelta(1000L).setMaxAllowedDelay(l10).build();
        schedulerConfig$Builder = schedulerConfig$Builder.addConfig(priority, (SchedulerConfig$ConfigValue)object);
        priority = Priority.VERY_LOW;
        object = SchedulerConfig$ConfigValue.builder().setDelta(l10).setMaxAllowedDelay(l10);
        SchedulerConfig$Flag schedulerConfig$Flag = SchedulerConfig$Flag.NETWORK_UNMETERED;
        schedulerConfig$Flag = SchedulerConfig$Flag.DEVICE_IDLE;
        Object object2 = new SchedulerConfig$Flag[]{schedulerConfig$Flag, schedulerConfig$Flag};
        object2 = SchedulerConfig.immutableSetOf((Object[])object2);
        object = ((SchedulerConfig$ConfigValue$Builder)object).setFlags((Set)object2).build();
        return schedulerConfig$Builder.addConfig(priority, (SchedulerConfig$ConfigValue)object).setClock(clock).build();
    }

    private static Set immutableSetOf(Object ... object) {
        object = Arrays.asList(object);
        HashSet hashSet = new HashSet(object);
        return Collections.unmodifiableSet(hashSet);
    }

    private void populateFlags(JobInfo.Builder builder, Set set) {
        boolean bl2;
        SchedulerConfig$Flag schedulerConfig$Flag = SchedulerConfig$Flag.NETWORK_UNMETERED;
        int n10 = set.contains((Object)schedulerConfig$Flag);
        boolean bl3 = true;
        if (n10 != 0) {
            n10 = 2;
            builder.setRequiredNetworkType(n10);
        } else {
            builder.setRequiredNetworkType((int)(bl3 ? 1 : 0));
        }
        schedulerConfig$Flag = SchedulerConfig$Flag.DEVICE_CHARGING;
        n10 = (int)(set.contains((Object)schedulerConfig$Flag) ? 1 : 0);
        if (n10 != 0) {
            builder.setRequiresCharging(bl3);
        }
        if (bl2 = set.contains((Object)(schedulerConfig$Flag = SchedulerConfig$Flag.DEVICE_IDLE))) {
            builder.setRequiresDeviceIdle(bl3);
        }
    }

    public JobInfo.Builder configureJob(JobInfo.Builder builder, Priority object, long l10, int n10) {
        l10 = this.getScheduleDelay((Priority)((Object)object), l10, n10);
        builder.setMinimumLatency(l10);
        object = ((SchedulerConfig$ConfigValue)this.getValues().get(object)).getFlags();
        this.populateFlags(builder, (Set)object);
        return builder;
    }

    public abstract Clock getClock();

    public Set getFlags(Priority priority) {
        return ((SchedulerConfig$ConfigValue)this.getValues().get((Object)priority)).getFlags();
    }

    public long getScheduleDelay(Priority object, long l10, int n10) {
        long l11 = this.getClock().getTime();
        l10 -= l11;
        object = (SchedulerConfig$ConfigValue)this.getValues().get(object);
        l11 = ((SchedulerConfig$ConfigValue)object).getDelta();
        l10 = Math.max(this.adjustedExponentialBackoff(n10, l11), l10);
        l11 = ((SchedulerConfig$ConfigValue)object).getMaxAllowedDelay();
        return Math.min(l10, l11);
    }

    public abstract Map getValues();
}

