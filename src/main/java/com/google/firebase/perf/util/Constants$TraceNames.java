/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.util;

public final class Constants$TraceNames
extends Enum {
    private static final /* synthetic */ Constants$TraceNames[] $VALUES;
    public static final /* enum */ Constants$TraceNames APP_START_TRACE_NAME;
    public static final /* enum */ Constants$TraceNames BACKGROUND_TRACE_NAME;
    public static final /* enum */ Constants$TraceNames FOREGROUND_TRACE_NAME;
    public static final /* enum */ Constants$TraceNames ON_CREATE_TRACE_NAME;
    public static final /* enum */ Constants$TraceNames ON_RESUME_TRACE_NAME;
    public static final /* enum */ Constants$TraceNames ON_START_TRACE_NAME;
    private String mName;

    static {
        Constants$TraceNames constants$TraceNames;
        Constants$TraceNames constants$TraceNames2;
        Constants$TraceNames constants$TraceNames3;
        Constants$TraceNames constants$TraceNames4;
        Constants$TraceNames constants$TraceNames5;
        Constants$TraceNames constants$TraceNames6;
        APP_START_TRACE_NAME = constants$TraceNames6 = new Constants$TraceNames("APP_START_TRACE_NAME", 0, "_as");
        int n10 = 1;
        ON_CREATE_TRACE_NAME = constants$TraceNames5 = new Constants$TraceNames("ON_CREATE_TRACE_NAME", n10, "_astui");
        int n11 = 2;
        ON_START_TRACE_NAME = constants$TraceNames4 = new Constants$TraceNames("ON_START_TRACE_NAME", n11, "_astfd");
        int n12 = 3;
        ON_RESUME_TRACE_NAME = constants$TraceNames3 = new Constants$TraceNames("ON_RESUME_TRACE_NAME", n12, "_asti");
        int n13 = 4;
        FOREGROUND_TRACE_NAME = constants$TraceNames2 = new Constants$TraceNames("FOREGROUND_TRACE_NAME", n13, "_fs");
        int n14 = 5;
        BACKGROUND_TRACE_NAME = constants$TraceNames = new Constants$TraceNames("BACKGROUND_TRACE_NAME", n14, "_bs");
        Constants$TraceNames[] constants$TraceNamesArray = new Constants$TraceNames[6];
        constants$TraceNamesArray[0] = constants$TraceNames6;
        constants$TraceNamesArray[n10] = constants$TraceNames5;
        constants$TraceNamesArray[n11] = constants$TraceNames4;
        constants$TraceNamesArray[n12] = constants$TraceNames3;
        constants$TraceNamesArray[n13] = constants$TraceNames2;
        constants$TraceNamesArray[n14] = constants$TraceNames;
        $VALUES = constants$TraceNamesArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Constants$TraceNames() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.mName = var3_1;
    }

    public static Constants$TraceNames valueOf(String string2) {
        return Enum.valueOf(Constants$TraceNames.class, string2);
    }

    public static Constants$TraceNames[] values() {
        return (Constants$TraceNames[])$VALUES.clone();
    }

    public String toString() {
        return this.mName;
    }
}

