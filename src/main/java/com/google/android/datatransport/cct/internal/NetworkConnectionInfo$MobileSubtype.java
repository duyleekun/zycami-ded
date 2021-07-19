/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 */
package com.google.android.datatransport.cct.internal;

import android.util.SparseArray;

public final class NetworkConnectionInfo$MobileSubtype
extends Enum {
    private static final /* synthetic */ NetworkConnectionInfo$MobileSubtype[] $VALUES;
    public static final /* enum */ NetworkConnectionInfo$MobileSubtype CDMA;
    public static final /* enum */ NetworkConnectionInfo$MobileSubtype COMBINED;
    public static final /* enum */ NetworkConnectionInfo$MobileSubtype EDGE;
    public static final /* enum */ NetworkConnectionInfo$MobileSubtype EHRPD;
    public static final /* enum */ NetworkConnectionInfo$MobileSubtype EVDO_0;
    public static final /* enum */ NetworkConnectionInfo$MobileSubtype EVDO_A;
    public static final /* enum */ NetworkConnectionInfo$MobileSubtype EVDO_B;
    public static final /* enum */ NetworkConnectionInfo$MobileSubtype GPRS;
    public static final /* enum */ NetworkConnectionInfo$MobileSubtype GSM;
    public static final /* enum */ NetworkConnectionInfo$MobileSubtype HSDPA;
    public static final /* enum */ NetworkConnectionInfo$MobileSubtype HSPA;
    public static final /* enum */ NetworkConnectionInfo$MobileSubtype HSPAP;
    public static final /* enum */ NetworkConnectionInfo$MobileSubtype HSUPA;
    public static final /* enum */ NetworkConnectionInfo$MobileSubtype IDEN;
    public static final /* enum */ NetworkConnectionInfo$MobileSubtype IWLAN;
    public static final /* enum */ NetworkConnectionInfo$MobileSubtype LTE;
    public static final /* enum */ NetworkConnectionInfo$MobileSubtype LTE_CA;
    public static final /* enum */ NetworkConnectionInfo$MobileSubtype RTT;
    public static final /* enum */ NetworkConnectionInfo$MobileSubtype TD_SCDMA;
    public static final /* enum */ NetworkConnectionInfo$MobileSubtype UMTS;
    public static final /* enum */ NetworkConnectionInfo$MobileSubtype UNKNOWN_MOBILE_SUBTYPE;
    private static final SparseArray valueMap;
    private final int value;

    static {
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype;
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype2;
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype3;
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype4;
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype5;
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype6;
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype7;
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype8;
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype9;
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype10;
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype11;
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype12;
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype13;
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype14;
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype15;
        UNKNOWN_MOBILE_SUBTYPE = networkConnectionInfo$MobileSubtype15 = new NetworkConnectionInfo$MobileSubtype("UNKNOWN_MOBILE_SUBTYPE", 0, 0);
        int n10 = 1;
        GPRS = networkConnectionInfo$MobileSubtype14 = new NetworkConnectionInfo$MobileSubtype("GPRS", n10, n10);
        int n11 = 2;
        EDGE = networkConnectionInfo$MobileSubtype13 = new NetworkConnectionInfo$MobileSubtype("EDGE", n11, n11);
        int n12 = 3;
        UMTS = networkConnectionInfo$MobileSubtype12 = new NetworkConnectionInfo$MobileSubtype("UMTS", n12, n12);
        int n13 = 4;
        CDMA = networkConnectionInfo$MobileSubtype11 = new NetworkConnectionInfo$MobileSubtype("CDMA", n13, n13);
        int n14 = 5;
        EVDO_0 = networkConnectionInfo$MobileSubtype10 = new NetworkConnectionInfo$MobileSubtype("EVDO_0", n14, n14);
        int n15 = 6;
        EVDO_A = networkConnectionInfo$MobileSubtype9 = new NetworkConnectionInfo$MobileSubtype("EVDO_A", n15, n15);
        n15 = 7;
        RTT = networkConnectionInfo$MobileSubtype8 = new NetworkConnectionInfo$MobileSubtype("RTT", n15, n15);
        n14 = 8;
        HSDPA = networkConnectionInfo$MobileSubtype7 = new NetworkConnectionInfo$MobileSubtype("HSDPA", n14, n14);
        n13 = 9;
        HSUPA = networkConnectionInfo$MobileSubtype6 = new NetworkConnectionInfo$MobileSubtype("HSUPA", n13, n13);
        n12 = 10;
        HSPA = networkConnectionInfo$MobileSubtype5 = new NetworkConnectionInfo$MobileSubtype("HSPA", n12, n12);
        n11 = 11;
        IDEN = networkConnectionInfo$MobileSubtype4 = new NetworkConnectionInfo$MobileSubtype("IDEN", n11, n11);
        n10 = 12;
        EVDO_B = networkConnectionInfo$MobileSubtype3 = new NetworkConnectionInfo$MobileSubtype("EVDO_B", n10, n10);
        int n16 = 13;
        LTE = networkConnectionInfo$MobileSubtype2 = new NetworkConnectionInfo$MobileSubtype("LTE", n16, n16);
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype16 = networkConnectionInfo$MobileSubtype2;
        n11 = 14;
        EHRPD = networkConnectionInfo$MobileSubtype = new NetworkConnectionInfo$MobileSubtype("EHRPD", n11, n11);
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype17 = networkConnectionInfo$MobileSubtype;
        n10 = 15;
        SparseArray sparseArray = new NetworkConnectionInfo$MobileSubtype("HSPAP", n10, n10);
        HSPAP = sparseArray;
        SparseArray sparseArray2 = sparseArray;
        n16 = 16;
        GSM = networkConnectionInfo$MobileSubtype2 = new NetworkConnectionInfo$MobileSubtype("GSM", n16, n16);
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype18 = networkConnectionInfo$MobileSubtype2;
        n11 = 17;
        TD_SCDMA = networkConnectionInfo$MobileSubtype = new NetworkConnectionInfo$MobileSubtype("TD_SCDMA", n11, n11);
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype19 = networkConnectionInfo$MobileSubtype;
        n10 = 18;
        sparseArray = new NetworkConnectionInfo$MobileSubtype("IWLAN", n10, n10);
        IWLAN = sparseArray;
        SparseArray sparseArray3 = sparseArray;
        n16 = 19;
        LTE_CA = networkConnectionInfo$MobileSubtype2 = new NetworkConnectionInfo$MobileSubtype("LTE_CA", n16, n16);
        n11 = 20;
        COMBINED = networkConnectionInfo$MobileSubtype = new NetworkConnectionInfo$MobileSubtype("COMBINED", n11, 100);
        sparseArray = new NetworkConnectionInfo$MobileSubtype[21];
        sparseArray[0] = networkConnectionInfo$MobileSubtype15;
        sparseArray[1] = networkConnectionInfo$MobileSubtype14;
        sparseArray[2] = networkConnectionInfo$MobileSubtype13;
        sparseArray[3] = networkConnectionInfo$MobileSubtype12;
        sparseArray[4] = networkConnectionInfo$MobileSubtype11;
        sparseArray[5] = networkConnectionInfo$MobileSubtype10;
        sparseArray[6] = networkConnectionInfo$MobileSubtype9;
        sparseArray[7] = networkConnectionInfo$MobileSubtype8;
        sparseArray[8] = networkConnectionInfo$MobileSubtype7;
        sparseArray[9] = networkConnectionInfo$MobileSubtype6;
        sparseArray[10] = networkConnectionInfo$MobileSubtype5;
        sparseArray[11] = networkConnectionInfo$MobileSubtype4;
        sparseArray[12] = networkConnectionInfo$MobileSubtype3;
        sparseArray[13] = networkConnectionInfo$MobileSubtype16;
        sparseArray[14] = networkConnectionInfo$MobileSubtype17;
        sparseArray[15] = sparseArray2;
        sparseArray[16] = networkConnectionInfo$MobileSubtype18;
        sparseArray[17] = networkConnectionInfo$MobileSubtype19;
        sparseArray[18] = sparseArray3;
        sparseArray[19] = networkConnectionInfo$MobileSubtype2;
        sparseArray[n11] = networkConnectionInfo$MobileSubtype;
        $VALUES = sparseArray;
        valueMap = sparseArray = new SparseArray();
        sparseArray.put(0, (Object)networkConnectionInfo$MobileSubtype15);
        sparseArray.put(1, (Object)networkConnectionInfo$MobileSubtype14);
        sparseArray.put(2, (Object)networkConnectionInfo$MobileSubtype13);
        sparseArray.put(3, (Object)networkConnectionInfo$MobileSubtype12);
        sparseArray.put(4, (Object)networkConnectionInfo$MobileSubtype11);
        sparseArray.put(5, (Object)networkConnectionInfo$MobileSubtype10);
        sparseArray.put(6, (Object)networkConnectionInfo$MobileSubtype9);
        sparseArray.put(7, (Object)networkConnectionInfo$MobileSubtype8);
        sparseArray.put(8, (Object)networkConnectionInfo$MobileSubtype7);
        sparseArray.put(9, (Object)networkConnectionInfo$MobileSubtype6);
        sparseArray.put(10, (Object)networkConnectionInfo$MobileSubtype5);
        sparseArray.put(11, (Object)networkConnectionInfo$MobileSubtype4);
        networkConnectionInfo$MobileSubtype15 = networkConnectionInfo$MobileSubtype3;
        sparseArray.put(12, (Object)networkConnectionInfo$MobileSubtype3);
        networkConnectionInfo$MobileSubtype15 = networkConnectionInfo$MobileSubtype16;
        sparseArray.put(13, (Object)networkConnectionInfo$MobileSubtype16);
        networkConnectionInfo$MobileSubtype15 = networkConnectionInfo$MobileSubtype17;
        sparseArray.put(14, (Object)networkConnectionInfo$MobileSubtype17);
        networkConnectionInfo$MobileSubtype15 = sparseArray2;
        sparseArray.put(15, (Object)sparseArray2);
        networkConnectionInfo$MobileSubtype15 = networkConnectionInfo$MobileSubtype18;
        sparseArray.put(16, (Object)networkConnectionInfo$MobileSubtype18);
        networkConnectionInfo$MobileSubtype15 = networkConnectionInfo$MobileSubtype19;
        sparseArray.put(17, (Object)networkConnectionInfo$MobileSubtype19);
        networkConnectionInfo$MobileSubtype15 = sparseArray3;
        sparseArray.put(18, (Object)sparseArray3);
        networkConnectionInfo$MobileSubtype15 = networkConnectionInfo$MobileSubtype2;
        sparseArray.put(19, (Object)networkConnectionInfo$MobileSubtype2);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private NetworkConnectionInfo$MobileSubtype() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static NetworkConnectionInfo$MobileSubtype forNumber(int n10) {
        return (NetworkConnectionInfo$MobileSubtype)((Object)valueMap.get(n10));
    }

    public static NetworkConnectionInfo$MobileSubtype valueOf(String string2) {
        return Enum.valueOf(NetworkConnectionInfo$MobileSubtype.class, string2);
    }

    public static NetworkConnectionInfo$MobileSubtype[] values() {
        return (NetworkConnectionInfo$MobileSubtype[])$VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }
}

