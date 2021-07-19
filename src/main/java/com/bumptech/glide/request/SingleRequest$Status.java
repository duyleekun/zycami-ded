/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide.request;

public final class SingleRequest$Status
extends Enum {
    public static final /* enum */ SingleRequest$Status CLEARED;
    public static final /* enum */ SingleRequest$Status COMPLETE;
    public static final /* enum */ SingleRequest$Status FAILED;
    public static final /* enum */ SingleRequest$Status PENDING;
    public static final /* enum */ SingleRequest$Status RUNNING;
    public static final /* enum */ SingleRequest$Status WAITING_FOR_SIZE;
    private static final /* synthetic */ SingleRequest$Status[] a;

    static {
        SingleRequest$Status singleRequest$Status;
        SingleRequest$Status singleRequest$Status2;
        SingleRequest$Status singleRequest$Status3;
        SingleRequest$Status singleRequest$Status4;
        SingleRequest$Status singleRequest$Status5;
        SingleRequest$Status singleRequest$Status6;
        PENDING = singleRequest$Status6 = new SingleRequest$Status("PENDING", 0);
        int n10 = 1;
        RUNNING = singleRequest$Status5 = new SingleRequest$Status("RUNNING", n10);
        int n11 = 2;
        WAITING_FOR_SIZE = singleRequest$Status4 = new SingleRequest$Status("WAITING_FOR_SIZE", n11);
        int n12 = 3;
        COMPLETE = singleRequest$Status3 = new SingleRequest$Status("COMPLETE", n12);
        int n13 = 4;
        FAILED = singleRequest$Status2 = new SingleRequest$Status("FAILED", n13);
        int n14 = 5;
        CLEARED = singleRequest$Status = new SingleRequest$Status("CLEARED", n14);
        SingleRequest$Status[] singleRequest$StatusArray = new SingleRequest$Status[6];
        singleRequest$StatusArray[0] = singleRequest$Status6;
        singleRequest$StatusArray[n10] = singleRequest$Status5;
        singleRequest$StatusArray[n11] = singleRequest$Status4;
        singleRequest$StatusArray[n12] = singleRequest$Status3;
        singleRequest$StatusArray[n13] = singleRequest$Status2;
        singleRequest$StatusArray[n14] = singleRequest$Status;
        a = singleRequest$StatusArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private SingleRequest$Status() {
        void var2_-1;
        void var1_-1;
    }

    public static SingleRequest$Status valueOf(String string2) {
        return Enum.valueOf(SingleRequest$Status.class, string2);
    }

    public static SingleRequest$Status[] values() {
        return (SingleRequest$Status[])a.clone();
    }
}

