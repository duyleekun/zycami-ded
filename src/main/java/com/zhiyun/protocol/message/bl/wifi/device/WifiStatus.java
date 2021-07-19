/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.message.bl.wifi.device;

import com.zhiyun.protocol.message.bl.wifi.device.WifiStatus$a;

public final class WifiStatus
extends Enum {
    public static final /* enum */ WifiStatus CONNECTED;
    public static final /* enum */ WifiStatus CONNECTED_AND_SCANNING;
    public static final /* enum */ WifiStatus CONNECTING;
    public static final /* enum */ WifiStatus DISABLE;
    public static final /* enum */ WifiStatus DISCONNECTED;
    public static final /* enum */ WifiStatus ENABLE;
    public static final /* enum */ WifiStatus ERROR;
    public static final /* enum */ WifiStatus SCANNING;
    private static final int a = 0;
    private static final int b = 1;
    private static final int c = 2;
    private static final int d = 3;
    private static final int e = 5;
    private static final int f = 6;
    private static final int g = 7;
    private static final int h = 8;
    private static final /* synthetic */ WifiStatus[] i;

    static {
        WifiStatus wifiStatus;
        WifiStatus wifiStatus2;
        WifiStatus wifiStatus3;
        WifiStatus wifiStatus4;
        WifiStatus wifiStatus5;
        WifiStatus wifiStatus6;
        WifiStatus wifiStatus7;
        WifiStatus wifiStatus8;
        DISABLE = wifiStatus8 = new WifiStatus("DISABLE", 0);
        int n10 = 1;
        ENABLE = wifiStatus7 = new WifiStatus("ENABLE", n10);
        int n11 = 2;
        SCANNING = wifiStatus6 = new WifiStatus("SCANNING", n11);
        int n12 = 3;
        CONNECTING = wifiStatus5 = new WifiStatus("CONNECTING", n12);
        int n13 = 4;
        CONNECTED = wifiStatus4 = new WifiStatus("CONNECTED", n13);
        int n14 = 5;
        DISCONNECTED = wifiStatus3 = new WifiStatus("DISCONNECTED", n14);
        ERROR = wifiStatus2 = new WifiStatus("ERROR", 6);
        int n15 = 7;
        CONNECTED_AND_SCANNING = wifiStatus = new WifiStatus("CONNECTED_AND_SCANNING", n15);
        WifiStatus[] wifiStatusArray = new WifiStatus[8];
        wifiStatusArray[0] = wifiStatus8;
        wifiStatusArray[n10] = wifiStatus7;
        wifiStatusArray[n11] = wifiStatus6;
        wifiStatusArray[n12] = wifiStatus5;
        wifiStatusArray[n13] = wifiStatus4;
        wifiStatusArray[n14] = wifiStatus3;
        wifiStatusArray[6] = wifiStatus2;
        wifiStatusArray[n15] = wifiStatus;
        i = wifiStatusArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private WifiStatus() {
        void var2_-1;
        void var1_-1;
    }

    public static int toCode(WifiStatus wifiStatus) {
        int[] nArray = WifiStatus$a.a;
        int n10 = wifiStatus.ordinal();
        n10 = nArray[n10];
        switch (n10) {
            default: {
                return 0;
            }
            case 7: {
                return 8;
            }
            case 6: {
                return 7;
            }
            case 5: {
                return 6;
            }
            case 4: {
                return 5;
            }
            case 3: {
                return 3;
            }
            case 2: {
                return 2;
            }
            case 1: 
        }
        return 1;
    }

    public static WifiStatus toStatus(int n10) {
        switch (n10) {
            default: {
                return DISABLE;
            }
            case 8: {
                return CONNECTED_AND_SCANNING;
            }
            case 7: {
                return ERROR;
            }
            case 6: {
                return DISCONNECTED;
            }
            case 5: {
                return CONNECTED;
            }
            case 3: {
                return CONNECTING;
            }
            case 2: {
                return SCANNING;
            }
            case 1: 
        }
        return ENABLE;
    }

    public static WifiStatus valueOf(String string2) {
        return Enum.valueOf(WifiStatus.class, string2);
    }

    public static WifiStatus[] values() {
        return (WifiStatus[])i.clone();
    }
}

