/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.network;

public final class NetworkingDetector$NetworkType
extends Enum {
    private static final /* synthetic */ NetworkingDetector$NetworkType[] $VALUES;
    public static final /* enum */ NetworkingDetector$NetworkType Mobile;
    public static final /* enum */ NetworkingDetector$NetworkType None;
    public static final /* enum */ NetworkingDetector$NetworkType WIFI;

    static {
        NetworkingDetector$NetworkType networkingDetector$NetworkType;
        NetworkingDetector$NetworkType networkingDetector$NetworkType2;
        NetworkingDetector$NetworkType networkingDetector$NetworkType3;
        WIFI = networkingDetector$NetworkType3 = new NetworkingDetector$NetworkType("WIFI", 0);
        int n10 = 1;
        Mobile = networkingDetector$NetworkType2 = new NetworkingDetector$NetworkType("Mobile", n10);
        int n11 = 2;
        None = networkingDetector$NetworkType = new NetworkingDetector$NetworkType("None", n11);
        NetworkingDetector$NetworkType[] networkingDetector$NetworkTypeArray = new NetworkingDetector$NetworkType[3];
        networkingDetector$NetworkTypeArray[0] = networkingDetector$NetworkType3;
        networkingDetector$NetworkTypeArray[n10] = networkingDetector$NetworkType2;
        networkingDetector$NetworkTypeArray[n11] = networkingDetector$NetworkType;
        $VALUES = networkingDetector$NetworkTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private NetworkingDetector$NetworkType() {
        void var2_-1;
        void var1_-1;
    }

    public static NetworkingDetector$NetworkType valueOf(String string2) {
        return Enum.valueOf(NetworkingDetector$NetworkType.class, string2);
    }

    public static NetworkingDetector$NetworkType[] values() {
        return (NetworkingDetector$NetworkType[])$VALUES.clone();
    }
}

