/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.backends;

public final class BackendResponse$Status
extends Enum {
    private static final /* synthetic */ BackendResponse$Status[] $VALUES;
    public static final /* enum */ BackendResponse$Status FATAL_ERROR;
    public static final /* enum */ BackendResponse$Status OK;
    public static final /* enum */ BackendResponse$Status TRANSIENT_ERROR;

    static {
        BackendResponse$Status backendResponse$Status;
        BackendResponse$Status backendResponse$Status2;
        BackendResponse$Status backendResponse$Status3;
        OK = backendResponse$Status3 = new BackendResponse$Status("OK", 0);
        int n10 = 1;
        TRANSIENT_ERROR = backendResponse$Status2 = new BackendResponse$Status("TRANSIENT_ERROR", n10);
        int n11 = 2;
        FATAL_ERROR = backendResponse$Status = new BackendResponse$Status("FATAL_ERROR", n11);
        BackendResponse$Status[] backendResponse$StatusArray = new BackendResponse$Status[3];
        backendResponse$StatusArray[0] = backendResponse$Status3;
        backendResponse$StatusArray[n10] = backendResponse$Status2;
        backendResponse$StatusArray[n11] = backendResponse$Status;
        $VALUES = backendResponse$StatusArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private BackendResponse$Status() {
        void var2_-1;
        void var1_-1;
    }

    public static BackendResponse$Status valueOf(String string2) {
        return Enum.valueOf(BackendResponse$Status.class, string2);
    }

    public static BackendResponse$Status[] values() {
        return (BackendResponse$Status[])$VALUES.clone();
    }
}

