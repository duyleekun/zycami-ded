/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.resource;

public final class Status
extends Enum {
    public static final /* enum */ Status CACHE;
    public static final /* enum */ Status ERROR;
    public static final /* enum */ Status LOADING;
    public static final /* enum */ Status SUCCESS;
    private static final /* synthetic */ Status[] a;

    static {
        Status status;
        Status status2;
        Status status3;
        Status status4;
        SUCCESS = status4 = new Status("SUCCESS", 0);
        int n10 = 1;
        CACHE = status3 = new Status("CACHE", n10);
        int n11 = 2;
        ERROR = status2 = new Status("ERROR", n11);
        int n12 = 3;
        LOADING = status = new Status("LOADING", n12);
        Status[] statusArray = new Status[4];
        statusArray[0] = status4;
        statusArray[n10] = status3;
        statusArray[n11] = status2;
        statusArray[n12] = status;
        a = statusArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Status() {
        void var2_-1;
        void var1_-1;
    }

    public static Status valueOf(String string2) {
        return Enum.valueOf(Status.class, string2);
    }

    public static Status[] values() {
        return (Status[])a.clone();
    }
}

