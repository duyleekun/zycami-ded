/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.NetworkConnectionInfo$MobileSubtype$1;
import com.google.firebase.perf.v1.NetworkConnectionInfo$MobileSubtype$MobileSubtypeVerifier;
import com.google.protobuf.Internal$EnumLite;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.Internal$EnumVerifier;

public final class NetworkConnectionInfo$MobileSubtype
extends Enum
implements Internal$EnumLite {
    private static final /* synthetic */ NetworkConnectionInfo$MobileSubtype[] $VALUES;
    public static final /* enum */ NetworkConnectionInfo$MobileSubtype CDMA;
    public static final int CDMA_VALUE = 4;
    public static final /* enum */ NetworkConnectionInfo$MobileSubtype COMBINED;
    public static final int COMBINED_VALUE = 100;
    public static final /* enum */ NetworkConnectionInfo$MobileSubtype EDGE;
    public static final int EDGE_VALUE = 2;
    public static final /* enum */ NetworkConnectionInfo$MobileSubtype EHRPD;
    public static final int EHRPD_VALUE = 14;
    public static final /* enum */ NetworkConnectionInfo$MobileSubtype EVDO_0;
    public static final int EVDO_0_VALUE = 5;
    public static final /* enum */ NetworkConnectionInfo$MobileSubtype EVDO_A;
    public static final int EVDO_A_VALUE = 6;
    public static final /* enum */ NetworkConnectionInfo$MobileSubtype EVDO_B;
    public static final int EVDO_B_VALUE = 12;
    public static final /* enum */ NetworkConnectionInfo$MobileSubtype GPRS;
    public static final int GPRS_VALUE = 1;
    public static final /* enum */ NetworkConnectionInfo$MobileSubtype GSM;
    public static final int GSM_VALUE = 16;
    public static final /* enum */ NetworkConnectionInfo$MobileSubtype HSDPA;
    public static final int HSDPA_VALUE = 8;
    public static final /* enum */ NetworkConnectionInfo$MobileSubtype HSPA;
    public static final /* enum */ NetworkConnectionInfo$MobileSubtype HSPAP;
    public static final int HSPAP_VALUE = 15;
    public static final int HSPA_VALUE = 10;
    public static final /* enum */ NetworkConnectionInfo$MobileSubtype HSUPA;
    public static final int HSUPA_VALUE = 9;
    public static final /* enum */ NetworkConnectionInfo$MobileSubtype IDEN;
    public static final int IDEN_VALUE = 11;
    public static final /* enum */ NetworkConnectionInfo$MobileSubtype IWLAN;
    public static final int IWLAN_VALUE = 18;
    public static final /* enum */ NetworkConnectionInfo$MobileSubtype LTE;
    public static final /* enum */ NetworkConnectionInfo$MobileSubtype LTE_CA;
    public static final int LTE_CA_VALUE = 19;
    public static final int LTE_VALUE = 13;
    public static final /* enum */ NetworkConnectionInfo$MobileSubtype RTT;
    public static final int RTT_VALUE = 7;
    public static final /* enum */ NetworkConnectionInfo$MobileSubtype TD_SCDMA;
    public static final int TD_SCDMA_VALUE = 17;
    public static final /* enum */ NetworkConnectionInfo$MobileSubtype UMTS;
    public static final int UMTS_VALUE = 3;
    public static final /* enum */ NetworkConnectionInfo$MobileSubtype UNKNOWN_MOBILE_SUBTYPE;
    public static final int UNKNOWN_MOBILE_SUBTYPE_VALUE;
    private static final Internal$EnumLiteMap internalValueMap;
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
        Object object = new NetworkConnectionInfo$MobileSubtype("UNKNOWN_MOBILE_SUBTYPE", 0, 0);
        UNKNOWN_MOBILE_SUBTYPE = object;
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
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype15 = networkConnectionInfo$MobileSubtype2;
        n11 = 14;
        EHRPD = networkConnectionInfo$MobileSubtype = new NetworkConnectionInfo$MobileSubtype("EHRPD", n11, n11);
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype16 = networkConnectionInfo$MobileSubtype;
        n10 = 15;
        NetworkConnectionInfo$MobileSubtype[] networkConnectionInfo$MobileSubtypeArray = new NetworkConnectionInfo$MobileSubtype("HSPAP", n10, n10);
        HSPAP = networkConnectionInfo$MobileSubtypeArray;
        NetworkConnectionInfo$MobileSubtype[] networkConnectionInfo$MobileSubtypeArray2 = networkConnectionInfo$MobileSubtypeArray;
        n16 = 16;
        GSM = networkConnectionInfo$MobileSubtype2 = new NetworkConnectionInfo$MobileSubtype("GSM", n16, n16);
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype17 = networkConnectionInfo$MobileSubtype2;
        n11 = 17;
        TD_SCDMA = networkConnectionInfo$MobileSubtype = new NetworkConnectionInfo$MobileSubtype("TD_SCDMA", n11, n11);
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype18 = networkConnectionInfo$MobileSubtype;
        n10 = 18;
        networkConnectionInfo$MobileSubtypeArray = new NetworkConnectionInfo$MobileSubtype("IWLAN", n10, n10);
        IWLAN = networkConnectionInfo$MobileSubtypeArray;
        NetworkConnectionInfo$MobileSubtype[] networkConnectionInfo$MobileSubtypeArray3 = networkConnectionInfo$MobileSubtypeArray;
        n16 = 19;
        LTE_CA = networkConnectionInfo$MobileSubtype2 = new NetworkConnectionInfo$MobileSubtype("LTE_CA", n16, n16);
        n11 = 20;
        COMBINED = networkConnectionInfo$MobileSubtype = new NetworkConnectionInfo$MobileSubtype("COMBINED", n11, 100);
        networkConnectionInfo$MobileSubtypeArray = new NetworkConnectionInfo$MobileSubtype[21];
        networkConnectionInfo$MobileSubtypeArray[0] = object;
        networkConnectionInfo$MobileSubtypeArray[1] = networkConnectionInfo$MobileSubtype14;
        networkConnectionInfo$MobileSubtypeArray[2] = networkConnectionInfo$MobileSubtype13;
        networkConnectionInfo$MobileSubtypeArray[3] = networkConnectionInfo$MobileSubtype12;
        networkConnectionInfo$MobileSubtypeArray[4] = networkConnectionInfo$MobileSubtype11;
        networkConnectionInfo$MobileSubtypeArray[5] = networkConnectionInfo$MobileSubtype10;
        networkConnectionInfo$MobileSubtypeArray[6] = networkConnectionInfo$MobileSubtype9;
        networkConnectionInfo$MobileSubtypeArray[7] = networkConnectionInfo$MobileSubtype8;
        networkConnectionInfo$MobileSubtypeArray[8] = networkConnectionInfo$MobileSubtype7;
        networkConnectionInfo$MobileSubtypeArray[9] = networkConnectionInfo$MobileSubtype6;
        networkConnectionInfo$MobileSubtypeArray[10] = networkConnectionInfo$MobileSubtype5;
        networkConnectionInfo$MobileSubtypeArray[11] = networkConnectionInfo$MobileSubtype4;
        networkConnectionInfo$MobileSubtypeArray[12] = networkConnectionInfo$MobileSubtype3;
        networkConnectionInfo$MobileSubtypeArray[13] = networkConnectionInfo$MobileSubtype15;
        networkConnectionInfo$MobileSubtypeArray[14] = networkConnectionInfo$MobileSubtype16;
        networkConnectionInfo$MobileSubtypeArray[15] = networkConnectionInfo$MobileSubtypeArray2;
        networkConnectionInfo$MobileSubtypeArray[16] = networkConnectionInfo$MobileSubtype17;
        networkConnectionInfo$MobileSubtypeArray[17] = networkConnectionInfo$MobileSubtype18;
        networkConnectionInfo$MobileSubtypeArray[18] = networkConnectionInfo$MobileSubtypeArray3;
        networkConnectionInfo$MobileSubtypeArray[19] = networkConnectionInfo$MobileSubtype2;
        networkConnectionInfo$MobileSubtypeArray[n11] = networkConnectionInfo$MobileSubtype;
        $VALUES = networkConnectionInfo$MobileSubtypeArray;
        internalValueMap = object = new NetworkConnectionInfo$MobileSubtype$1();
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
        int n11 = 100;
        if (n10 != n11) {
            switch (n10) {
                default: {
                    return null;
                }
                case 19: {
                    return LTE_CA;
                }
                case 18: {
                    return IWLAN;
                }
                case 17: {
                    return TD_SCDMA;
                }
                case 16: {
                    return GSM;
                }
                case 15: {
                    return HSPAP;
                }
                case 14: {
                    return EHRPD;
                }
                case 13: {
                    return LTE;
                }
                case 12: {
                    return EVDO_B;
                }
                case 11: {
                    return IDEN;
                }
                case 10: {
                    return HSPA;
                }
                case 9: {
                    return HSUPA;
                }
                case 8: {
                    return HSDPA;
                }
                case 7: {
                    return RTT;
                }
                case 6: {
                    return EVDO_A;
                }
                case 5: {
                    return EVDO_0;
                }
                case 4: {
                    return CDMA;
                }
                case 3: {
                    return UMTS;
                }
                case 2: {
                    return EDGE;
                }
                case 1: {
                    return GPRS;
                }
                case 0: 
            }
            return UNKNOWN_MOBILE_SUBTYPE;
        }
        return COMBINED;
    }

    public static Internal$EnumLiteMap internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal$EnumVerifier internalGetVerifier() {
        return NetworkConnectionInfo$MobileSubtype$MobileSubtypeVerifier.INSTANCE;
    }

    public static NetworkConnectionInfo$MobileSubtype valueOf(int n10) {
        return NetworkConnectionInfo$MobileSubtype.forNumber(n10);
    }

    public static NetworkConnectionInfo$MobileSubtype valueOf(String string2) {
        return Enum.valueOf(NetworkConnectionInfo$MobileSubtype.class, string2);
    }

    public static NetworkConnectionInfo$MobileSubtype[] values() {
        return (NetworkConnectionInfo$MobileSubtype[])$VALUES.clone();
    }

    public final int getNumber() {
        return this.value;
    }
}

