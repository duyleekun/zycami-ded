/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.message.bl.wifi.device;

import com.zhiyun.protocol.message.bl.wifi.device.WifiStatus;

public class WifiStatus$a {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        WifiStatus wifiStatus;
        int n12 = WifiStatus.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            wifiStatus = WifiStatus.ENABLE;
            n11 = wifiStatus.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            wifiStatus = WifiStatus.SCANNING;
            n11 = wifiStatus.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            wifiStatus = WifiStatus.CONNECTING;
            n11 = wifiStatus.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            wifiStatus = WifiStatus.CONNECTED;
            n11 = wifiStatus.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            wifiStatus = WifiStatus.DISCONNECTED;
            n11 = wifiStatus.ordinal();
            nArray[n11] = n10 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            wifiStatus = WifiStatus.ERROR;
            n11 = wifiStatus.ordinal();
            nArray[n11] = n10 = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            wifiStatus = WifiStatus.CONNECTED_AND_SCANNING;
            n11 = wifiStatus.ordinal();
            nArray[n11] = n10 = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            wifiStatus = WifiStatus.DISABLE;
            n11 = wifiStatus.ordinal();
            nArray[n11] = n10 = 8;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

