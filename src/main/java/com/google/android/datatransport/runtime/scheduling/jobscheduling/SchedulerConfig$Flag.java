/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.scheduling.jobscheduling;

public final class SchedulerConfig$Flag
extends Enum {
    private static final /* synthetic */ SchedulerConfig$Flag[] $VALUES;
    public static final /* enum */ SchedulerConfig$Flag DEVICE_CHARGING;
    public static final /* enum */ SchedulerConfig$Flag DEVICE_IDLE;
    public static final /* enum */ SchedulerConfig$Flag NETWORK_UNMETERED;

    static {
        SchedulerConfig$Flag schedulerConfig$Flag;
        SchedulerConfig$Flag schedulerConfig$Flag2;
        SchedulerConfig$Flag schedulerConfig$Flag3;
        NETWORK_UNMETERED = schedulerConfig$Flag3 = new SchedulerConfig$Flag("NETWORK_UNMETERED", 0);
        int n10 = 1;
        DEVICE_IDLE = schedulerConfig$Flag2 = new SchedulerConfig$Flag("DEVICE_IDLE", n10);
        int n11 = 2;
        DEVICE_CHARGING = schedulerConfig$Flag = new SchedulerConfig$Flag("DEVICE_CHARGING", n11);
        SchedulerConfig$Flag[] schedulerConfig$FlagArray = new SchedulerConfig$Flag[3];
        schedulerConfig$FlagArray[0] = schedulerConfig$Flag3;
        schedulerConfig$FlagArray[n10] = schedulerConfig$Flag2;
        schedulerConfig$FlagArray[n11] = schedulerConfig$Flag;
        $VALUES = schedulerConfig$FlagArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private SchedulerConfig$Flag() {
        void var2_-1;
        void var1_-1;
    }

    public static SchedulerConfig$Flag valueOf(String string2) {
        return Enum.valueOf(SchedulerConfig$Flag.class, string2);
    }

    public static SchedulerConfig$Flag[] values() {
        return (SchedulerConfig$Flag[])$VALUES.clone();
    }
}

