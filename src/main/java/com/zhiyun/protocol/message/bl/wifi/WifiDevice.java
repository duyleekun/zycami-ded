/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.message.bl.wifi;

import com.zhiyun.protocol.message.bl.wifi.WifiDevice$a;

public final class WifiDevice
extends Enum {
    public static final /* enum */ WifiDevice CARENA3;
    public static final /* enum */ WifiDevice EVO2;
    public static final /* enum */ WifiDevice UN_KNOW;
    private static final byte a = 0;
    private static final byte b = 32;
    private static final /* synthetic */ WifiDevice[] c;

    static {
        WifiDevice wifiDevice;
        WifiDevice wifiDevice2;
        WifiDevice wifiDevice3;
        UN_KNOW = wifiDevice3 = new WifiDevice("UN_KNOW", 0);
        int n10 = 1;
        EVO2 = wifiDevice2 = new WifiDevice("EVO2", n10);
        int n11 = 2;
        CARENA3 = wifiDevice = new WifiDevice("CARENA3", n11);
        WifiDevice[] wifiDeviceArray = new WifiDevice[3];
        wifiDeviceArray[0] = wifiDevice3;
        wifiDeviceArray[n10] = wifiDevice2;
        wifiDeviceArray[n11] = wifiDevice;
        c = wifiDeviceArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private WifiDevice() {
        void var2_-1;
        void var1_-1;
    }

    public static WifiDevice toDevice(int n10) {
        int n11 = 32;
        if (n10 != n11) {
            return EVO2;
        }
        return CARENA3;
    }

    public static byte toDeviceCode(WifiDevice wifiDevice) {
        int[] nArray = WifiDevice$a.a;
        int n10 = wifiDevice.ordinal();
        int n11 = 2;
        if ((n10 = nArray[n10]) != n11) {
            return 0;
        }
        return 32;
    }

    public static WifiDevice valueOf(String string2) {
        return Enum.valueOf(WifiDevice.class, string2);
    }

    public static WifiDevice[] values() {
        return (WifiDevice[])c.clone();
    }
}

