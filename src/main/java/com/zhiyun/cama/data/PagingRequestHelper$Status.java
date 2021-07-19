/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data;

public final class PagingRequestHelper$Status
extends Enum {
    public static final /* enum */ PagingRequestHelper$Status FAILED;
    public static final /* enum */ PagingRequestHelper$Status RUNNING;
    public static final /* enum */ PagingRequestHelper$Status SUCCESS;
    private static final /* synthetic */ PagingRequestHelper$Status[] a;

    static {
        PagingRequestHelper$Status pagingRequestHelper$Status;
        PagingRequestHelper$Status pagingRequestHelper$Status2;
        PagingRequestHelper$Status pagingRequestHelper$Status3;
        RUNNING = pagingRequestHelper$Status3 = new PagingRequestHelper$Status("RUNNING", 0);
        int n10 = 1;
        SUCCESS = pagingRequestHelper$Status2 = new PagingRequestHelper$Status("SUCCESS", n10);
        int n11 = 2;
        FAILED = pagingRequestHelper$Status = new PagingRequestHelper$Status("FAILED", n11);
        PagingRequestHelper$Status[] pagingRequestHelper$StatusArray = new PagingRequestHelper$Status[3];
        pagingRequestHelper$StatusArray[0] = pagingRequestHelper$Status3;
        pagingRequestHelper$StatusArray[n10] = pagingRequestHelper$Status2;
        pagingRequestHelper$StatusArray[n11] = pagingRequestHelper$Status;
        a = pagingRequestHelper$StatusArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private PagingRequestHelper$Status() {
        void var2_-1;
        void var1_-1;
    }

    public static PagingRequestHelper$Status valueOf(String string2) {
        return Enum.valueOf(PagingRequestHelper$Status.class, string2);
    }

    public static PagingRequestHelper$Status[] values() {
        return (PagingRequestHelper$Status[])a.clone();
    }
}

