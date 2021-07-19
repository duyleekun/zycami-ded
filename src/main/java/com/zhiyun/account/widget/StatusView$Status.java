/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.account.widget;

public final class StatusView$Status
extends Enum {
    public static final /* enum */ StatusView$Status STATUS_ERROR;
    public static final /* enum */ StatusView$Status STATUS_LOADING;
    public static final /* enum */ StatusView$Status STATUS_NONE;
    private static final /* synthetic */ StatusView$Status[] a;

    static {
        StatusView$Status statusView$Status;
        StatusView$Status statusView$Status2;
        StatusView$Status statusView$Status3;
        STATUS_NONE = statusView$Status3 = new StatusView$Status("STATUS_NONE", 0);
        int n10 = 1;
        STATUS_LOADING = statusView$Status2 = new StatusView$Status("STATUS_LOADING", n10);
        int n11 = 2;
        STATUS_ERROR = statusView$Status = new StatusView$Status("STATUS_ERROR", n11);
        StatusView$Status[] statusView$StatusArray = new StatusView$Status[3];
        statusView$StatusArray[0] = statusView$Status3;
        statusView$StatusArray[n10] = statusView$Status2;
        statusView$StatusArray[n11] = statusView$Status;
        a = statusView$StatusArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private StatusView$Status() {
        void var2_-1;
        void var1_-1;
    }

    public static StatusView$Status valueOf(String string2) {
        return Enum.valueOf(StatusView$Status.class, string2);
    }

    public static StatusView$Status[] values() {
        return (StatusView$Status[])a.clone();
    }
}

