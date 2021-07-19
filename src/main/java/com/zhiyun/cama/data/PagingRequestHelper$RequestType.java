/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data;

public final class PagingRequestHelper$RequestType
extends Enum {
    public static final /* enum */ PagingRequestHelper$RequestType AFTER;
    public static final /* enum */ PagingRequestHelper$RequestType BEFORE;
    public static final /* enum */ PagingRequestHelper$RequestType INITIAL;
    private static final /* synthetic */ PagingRequestHelper$RequestType[] a;

    static {
        PagingRequestHelper$RequestType pagingRequestHelper$RequestType;
        PagingRequestHelper$RequestType pagingRequestHelper$RequestType2;
        PagingRequestHelper$RequestType pagingRequestHelper$RequestType3;
        INITIAL = pagingRequestHelper$RequestType3 = new PagingRequestHelper$RequestType("INITIAL", 0);
        int n10 = 1;
        BEFORE = pagingRequestHelper$RequestType2 = new PagingRequestHelper$RequestType("BEFORE", n10);
        int n11 = 2;
        AFTER = pagingRequestHelper$RequestType = new PagingRequestHelper$RequestType("AFTER", n11);
        PagingRequestHelper$RequestType[] pagingRequestHelper$RequestTypeArray = new PagingRequestHelper$RequestType[3];
        pagingRequestHelper$RequestTypeArray[0] = pagingRequestHelper$RequestType3;
        pagingRequestHelper$RequestTypeArray[n10] = pagingRequestHelper$RequestType2;
        pagingRequestHelper$RequestTypeArray[n11] = pagingRequestHelper$RequestType;
        a = pagingRequestHelper$RequestTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private PagingRequestHelper$RequestType() {
        void var2_-1;
        void var1_-1;
    }

    public static PagingRequestHelper$RequestType valueOf(String string2) {
        return Enum.valueOf(PagingRequestHelper$RequestType.class, string2);
    }

    public static PagingRequestHelper$RequestType[] values() {
        return (PagingRequestHelper$RequestType[])a.clone();
    }
}

