/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.NetworkConnectionInfo$NetworkType$1;
import com.google.firebase.perf.v1.NetworkConnectionInfo$NetworkType$NetworkTypeVerifier;
import com.google.protobuf.Internal$EnumLite;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.Internal$EnumVerifier;

public final class NetworkConnectionInfo$NetworkType
extends Enum
implements Internal$EnumLite {
    private static final /* synthetic */ NetworkConnectionInfo$NetworkType[] $VALUES;
    public static final /* enum */ NetworkConnectionInfo$NetworkType BLUETOOTH;
    public static final int BLUETOOTH_VALUE = 7;
    public static final /* enum */ NetworkConnectionInfo$NetworkType DUMMY;
    public static final int DUMMY_VALUE = 8;
    public static final /* enum */ NetworkConnectionInfo$NetworkType ETHERNET;
    public static final int ETHERNET_VALUE = 9;
    public static final /* enum */ NetworkConnectionInfo$NetworkType MOBILE;
    public static final /* enum */ NetworkConnectionInfo$NetworkType MOBILE_CBS;
    public static final int MOBILE_CBS_VALUE = 12;
    public static final /* enum */ NetworkConnectionInfo$NetworkType MOBILE_DUN;
    public static final int MOBILE_DUN_VALUE = 4;
    public static final /* enum */ NetworkConnectionInfo$NetworkType MOBILE_EMERGENCY;
    public static final int MOBILE_EMERGENCY_VALUE = 15;
    public static final /* enum */ NetworkConnectionInfo$NetworkType MOBILE_FOTA;
    public static final int MOBILE_FOTA_VALUE = 10;
    public static final /* enum */ NetworkConnectionInfo$NetworkType MOBILE_HIPRI;
    public static final int MOBILE_HIPRI_VALUE = 5;
    public static final /* enum */ NetworkConnectionInfo$NetworkType MOBILE_IA;
    public static final int MOBILE_IA_VALUE = 14;
    public static final /* enum */ NetworkConnectionInfo$NetworkType MOBILE_IMS;
    public static final int MOBILE_IMS_VALUE = 11;
    public static final /* enum */ NetworkConnectionInfo$NetworkType MOBILE_MMS;
    public static final int MOBILE_MMS_VALUE = 2;
    public static final /* enum */ NetworkConnectionInfo$NetworkType MOBILE_SUPL;
    public static final int MOBILE_SUPL_VALUE = 3;
    public static final int MOBILE_VALUE = 0;
    public static final /* enum */ NetworkConnectionInfo$NetworkType NONE;
    public static final int NONE_VALUE = 255;
    public static final /* enum */ NetworkConnectionInfo$NetworkType PROXY;
    public static final int PROXY_VALUE = 16;
    public static final /* enum */ NetworkConnectionInfo$NetworkType VPN;
    public static final int VPN_VALUE = 17;
    public static final /* enum */ NetworkConnectionInfo$NetworkType WIFI;
    public static final /* enum */ NetworkConnectionInfo$NetworkType WIFI_P2P;
    public static final int WIFI_P2P_VALUE = 13;
    public static final int WIFI_VALUE = 1;
    public static final /* enum */ NetworkConnectionInfo$NetworkType WIMAX;
    public static final int WIMAX_VALUE = 6;
    private static final Internal$EnumLiteMap internalValueMap;
    private final int value;

    static {
        NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType;
        NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType2;
        NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType3;
        NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType4;
        NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType5;
        NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType6;
        NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType7;
        NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType8;
        NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType9;
        NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType10;
        NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType11;
        NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType12;
        NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType13;
        NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType14;
        Object object = new NetworkConnectionInfo$NetworkType("NONE", 0, -1);
        NONE = object;
        int n10 = 1;
        MOBILE = networkConnectionInfo$NetworkType14 = new NetworkConnectionInfo$NetworkType("MOBILE", n10, 0);
        int n11 = 2;
        WIFI = networkConnectionInfo$NetworkType13 = new NetworkConnectionInfo$NetworkType("WIFI", n11, n10);
        int n12 = 3;
        MOBILE_MMS = networkConnectionInfo$NetworkType12 = new NetworkConnectionInfo$NetworkType("MOBILE_MMS", n12, n11);
        int n13 = 4;
        MOBILE_SUPL = networkConnectionInfo$NetworkType11 = new NetworkConnectionInfo$NetworkType("MOBILE_SUPL", n13, n12);
        int n14 = 5;
        MOBILE_DUN = networkConnectionInfo$NetworkType10 = new NetworkConnectionInfo$NetworkType("MOBILE_DUN", n14, n13);
        int n15 = 6;
        MOBILE_HIPRI = networkConnectionInfo$NetworkType9 = new NetworkConnectionInfo$NetworkType("MOBILE_HIPRI", n15, n14);
        n14 = 7;
        WIMAX = networkConnectionInfo$NetworkType8 = new NetworkConnectionInfo$NetworkType("WIMAX", n14, n15);
        n13 = 8;
        BLUETOOTH = networkConnectionInfo$NetworkType7 = new NetworkConnectionInfo$NetworkType("BLUETOOTH", n13, n14);
        n12 = 9;
        DUMMY = networkConnectionInfo$NetworkType6 = new NetworkConnectionInfo$NetworkType("DUMMY", n12, n13);
        n11 = 10;
        ETHERNET = networkConnectionInfo$NetworkType5 = new NetworkConnectionInfo$NetworkType("ETHERNET", n11, n12);
        n10 = 11;
        MOBILE_FOTA = networkConnectionInfo$NetworkType4 = new NetworkConnectionInfo$NetworkType("MOBILE_FOTA", n10, n11);
        int n16 = 12;
        MOBILE_IMS = networkConnectionInfo$NetworkType3 = new NetworkConnectionInfo$NetworkType("MOBILE_IMS", n16, n10);
        NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType15 = networkConnectionInfo$NetworkType3;
        n12 = 13;
        MOBILE_CBS = networkConnectionInfo$NetworkType2 = new NetworkConnectionInfo$NetworkType("MOBILE_CBS", n12, n16);
        NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType16 = networkConnectionInfo$NetworkType2;
        n11 = 14;
        WIFI_P2P = networkConnectionInfo$NetworkType = new NetworkConnectionInfo$NetworkType("WIFI_P2P", n11, n12);
        NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType17 = networkConnectionInfo$NetworkType;
        n10 = 15;
        NetworkConnectionInfo$NetworkType[] networkConnectionInfo$NetworkTypeArray = new NetworkConnectionInfo$NetworkType("MOBILE_IA", n10, n11);
        MOBILE_IA = networkConnectionInfo$NetworkTypeArray;
        NetworkConnectionInfo$NetworkType[] networkConnectionInfo$NetworkTypeArray2 = networkConnectionInfo$NetworkTypeArray;
        n16 = 16;
        MOBILE_EMERGENCY = networkConnectionInfo$NetworkType3 = new NetworkConnectionInfo$NetworkType("MOBILE_EMERGENCY", n16, n10);
        n12 = 17;
        PROXY = networkConnectionInfo$NetworkType2 = new NetworkConnectionInfo$NetworkType("PROXY", n12, n16);
        n11 = 18;
        VPN = networkConnectionInfo$NetworkType = new NetworkConnectionInfo$NetworkType("VPN", n11, n12);
        networkConnectionInfo$NetworkTypeArray = new NetworkConnectionInfo$NetworkType[19];
        networkConnectionInfo$NetworkTypeArray[0] = object;
        networkConnectionInfo$NetworkTypeArray[1] = networkConnectionInfo$NetworkType14;
        networkConnectionInfo$NetworkTypeArray[2] = networkConnectionInfo$NetworkType13;
        networkConnectionInfo$NetworkTypeArray[3] = networkConnectionInfo$NetworkType12;
        networkConnectionInfo$NetworkTypeArray[4] = networkConnectionInfo$NetworkType11;
        networkConnectionInfo$NetworkTypeArray[5] = networkConnectionInfo$NetworkType10;
        networkConnectionInfo$NetworkTypeArray[6] = networkConnectionInfo$NetworkType9;
        networkConnectionInfo$NetworkTypeArray[7] = networkConnectionInfo$NetworkType8;
        networkConnectionInfo$NetworkTypeArray[8] = networkConnectionInfo$NetworkType7;
        networkConnectionInfo$NetworkTypeArray[9] = networkConnectionInfo$NetworkType6;
        networkConnectionInfo$NetworkTypeArray[10] = networkConnectionInfo$NetworkType5;
        networkConnectionInfo$NetworkTypeArray[11] = networkConnectionInfo$NetworkType4;
        networkConnectionInfo$NetworkTypeArray[12] = networkConnectionInfo$NetworkType15;
        networkConnectionInfo$NetworkTypeArray[13] = networkConnectionInfo$NetworkType16;
        networkConnectionInfo$NetworkTypeArray[14] = networkConnectionInfo$NetworkType17;
        networkConnectionInfo$NetworkTypeArray[15] = networkConnectionInfo$NetworkTypeArray2;
        networkConnectionInfo$NetworkTypeArray[16] = networkConnectionInfo$NetworkType3;
        networkConnectionInfo$NetworkTypeArray[n12] = networkConnectionInfo$NetworkType2;
        networkConnectionInfo$NetworkTypeArray[n11] = networkConnectionInfo$NetworkType;
        $VALUES = networkConnectionInfo$NetworkTypeArray;
        internalValueMap = object = new NetworkConnectionInfo$NetworkType$1();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private NetworkConnectionInfo$NetworkType() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static NetworkConnectionInfo$NetworkType forNumber(int n10) {
        switch (n10) {
            default: {
                return null;
            }
            case 17: {
                return VPN;
            }
            case 16: {
                return PROXY;
            }
            case 15: {
                return MOBILE_EMERGENCY;
            }
            case 14: {
                return MOBILE_IA;
            }
            case 13: {
                return WIFI_P2P;
            }
            case 12: {
                return MOBILE_CBS;
            }
            case 11: {
                return MOBILE_IMS;
            }
            case 10: {
                return MOBILE_FOTA;
            }
            case 9: {
                return ETHERNET;
            }
            case 8: {
                return DUMMY;
            }
            case 7: {
                return BLUETOOTH;
            }
            case 6: {
                return WIMAX;
            }
            case 5: {
                return MOBILE_HIPRI;
            }
            case 4: {
                return MOBILE_DUN;
            }
            case 3: {
                return MOBILE_SUPL;
            }
            case 2: {
                return MOBILE_MMS;
            }
            case 1: {
                return WIFI;
            }
            case 0: {
                return MOBILE;
            }
            case -1: 
        }
        return NONE;
    }

    public static Internal$EnumLiteMap internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal$EnumVerifier internalGetVerifier() {
        return NetworkConnectionInfo$NetworkType$NetworkTypeVerifier.INSTANCE;
    }

    public static NetworkConnectionInfo$NetworkType valueOf(int n10) {
        return NetworkConnectionInfo$NetworkType.forNumber(n10);
    }

    public static NetworkConnectionInfo$NetworkType valueOf(String string2) {
        return Enum.valueOf(NetworkConnectionInfo$NetworkType.class, string2);
    }

    public static NetworkConnectionInfo$NetworkType[] values() {
        return (NetworkConnectionInfo$NetworkType[])$VALUES.clone();
    }

    public final int getNumber() {
        return this.value;
    }
}

