/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.message.bl.wifi;

import com.zhiyun.protocol.message.bl.wifi.WifiDevice;

public class WifiDevice$a {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        WifiDevice wifiDevice;
        int n12 = WifiDevice.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            wifiDevice = WifiDevice.EVO2;
            n11 = wifiDevice.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            wifiDevice = WifiDevice.CARENA3;
            n11 = wifiDevice.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            wifiDevice = WifiDevice.UN_KNOW;
            n11 = wifiDevice.ordinal();
            nArray[n11] = n10 = 3;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

