/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.util;

public final class Constants$CounterNames
extends Enum {
    private static final /* synthetic */ Constants$CounterNames[] $VALUES;
    public static final /* enum */ Constants$CounterNames FRAMES_FROZEN;
    public static final /* enum */ Constants$CounterNames FRAMES_SLOW;
    public static final /* enum */ Constants$CounterNames FRAMES_TOTAL;
    public static final /* enum */ Constants$CounterNames NETWORK_TRACE_EVENT_RATE_LIMITED;
    public static final /* enum */ Constants$CounterNames TRACE_EVENT_RATE_LIMITED;
    public static final /* enum */ Constants$CounterNames TRACE_STARTED_NOT_STOPPED;
    private String mName;

    static {
        Constants$CounterNames constants$CounterNames;
        Constants$CounterNames constants$CounterNames2;
        Constants$CounterNames constants$CounterNames3;
        Constants$CounterNames constants$CounterNames4;
        Constants$CounterNames constants$CounterNames5;
        Constants$CounterNames constants$CounterNames6;
        TRACE_EVENT_RATE_LIMITED = constants$CounterNames6 = new Constants$CounterNames("TRACE_EVENT_RATE_LIMITED", 0, "_fstec");
        int n10 = 1;
        NETWORK_TRACE_EVENT_RATE_LIMITED = constants$CounterNames5 = new Constants$CounterNames("NETWORK_TRACE_EVENT_RATE_LIMITED", n10, "_fsntc");
        int n11 = 2;
        TRACE_STARTED_NOT_STOPPED = constants$CounterNames4 = new Constants$CounterNames("TRACE_STARTED_NOT_STOPPED", n11, "_tsns");
        int n12 = 3;
        FRAMES_TOTAL = constants$CounterNames3 = new Constants$CounterNames("FRAMES_TOTAL", n12, "_fr_tot");
        int n13 = 4;
        FRAMES_SLOW = constants$CounterNames2 = new Constants$CounterNames("FRAMES_SLOW", n13, "_fr_slo");
        int n14 = 5;
        FRAMES_FROZEN = constants$CounterNames = new Constants$CounterNames("FRAMES_FROZEN", n14, "_fr_fzn");
        Constants$CounterNames[] constants$CounterNamesArray = new Constants$CounterNames[6];
        constants$CounterNamesArray[0] = constants$CounterNames6;
        constants$CounterNamesArray[n10] = constants$CounterNames5;
        constants$CounterNamesArray[n11] = constants$CounterNames4;
        constants$CounterNamesArray[n12] = constants$CounterNames3;
        constants$CounterNamesArray[n13] = constants$CounterNames2;
        constants$CounterNamesArray[n14] = constants$CounterNames;
        $VALUES = constants$CounterNamesArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Constants$CounterNames() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.mName = var3_1;
    }

    public static Constants$CounterNames valueOf(String string2) {
        return Enum.valueOf(Constants$CounterNames.class, string2);
    }

    public static Constants$CounterNames[] values() {
        return (Constants$CounterNames[])$VALUES.clone();
    }

    public String toString() {
        return this.mName;
    }
}

