/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.message.usb.command;

import com.zhiyun.protocol.message.usb.command.UsbStatus$a;

public final class UsbStatus
extends Enum {
    public static final /* enum */ UsbStatus ALREADY_CONNECTED_USB;
    public static final /* enum */ UsbStatus ALREADY_CONNECTED_WIFI;
    public static final /* enum */ UsbStatus CONNECTED;
    public static final /* enum */ UsbStatus FALED_COMMAND;
    public static final /* enum */ UsbStatus MEDIA_DISABLE;
    public static final /* enum */ UsbStatus MEDIA_ENABLE;
    public static final /* enum */ UsbStatus UNKNOWN;
    private static final int a = 0;
    private static final int b = 1;
    private static final int c = 2;
    private static final int d = 3;
    private static final int e = 4;
    private static final int f = 5;
    private static final int g = 6;
    private static final /* synthetic */ UsbStatus[] h;

    static {
        UsbStatus usbStatus;
        UsbStatus usbStatus2;
        UsbStatus usbStatus3;
        UsbStatus usbStatus4;
        UsbStatus usbStatus5;
        UsbStatus usbStatus6;
        UsbStatus usbStatus7;
        CONNECTED = usbStatus7 = new UsbStatus("CONNECTED", 0);
        int n10 = 1;
        ALREADY_CONNECTED_USB = usbStatus6 = new UsbStatus("ALREADY_CONNECTED_USB", n10);
        int n11 = 2;
        ALREADY_CONNECTED_WIFI = usbStatus5 = new UsbStatus("ALREADY_CONNECTED_WIFI", n11);
        int n12 = 3;
        FALED_COMMAND = usbStatus4 = new UsbStatus("FALED_COMMAND", n12);
        int n13 = 4;
        MEDIA_ENABLE = usbStatus3 = new UsbStatus("MEDIA_ENABLE", n13);
        int n14 = 5;
        MEDIA_DISABLE = usbStatus2 = new UsbStatus("MEDIA_DISABLE", n14);
        int n15 = 6;
        UNKNOWN = usbStatus = new UsbStatus("UNKNOWN", n15);
        UsbStatus[] usbStatusArray = new UsbStatus[7];
        usbStatusArray[0] = usbStatus7;
        usbStatusArray[n10] = usbStatus6;
        usbStatusArray[n11] = usbStatus5;
        usbStatusArray[n12] = usbStatus4;
        usbStatusArray[n13] = usbStatus3;
        usbStatusArray[n14] = usbStatus2;
        usbStatusArray[n15] = usbStatus;
        h = usbStatusArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private UsbStatus() {
        void var2_-1;
        void var1_-1;
    }

    public static UsbStatus toStatus(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 3;
                    if (n10 != n11) {
                        n11 = 4;
                        if (n10 != n11) {
                            n11 = 5;
                            if (n10 != n11) {
                                return UNKNOWN;
                            }
                            return MEDIA_DISABLE;
                        }
                        return MEDIA_ENABLE;
                    }
                    return FALED_COMMAND;
                }
                return ALREADY_CONNECTED_WIFI;
            }
            return ALREADY_CONNECTED_USB;
        }
        return CONNECTED;
    }

    public static int toValue(UsbStatus usbStatus) {
        int[] nArray = UsbStatus$a.a;
        int n10 = usbStatus.ordinal();
        n10 = nArray[n10];
        int n11 = 4;
        switch (n10) {
            default: {
                return 6;
            }
            case 5: 
            case 6: {
                return n11;
            }
            case 4: {
                return 3;
            }
            case 3: {
                return 2;
            }
            case 2: {
                return 1;
            }
            case 1: 
        }
        return 0;
    }

    public static UsbStatus valueOf(String string2) {
        return Enum.valueOf(UsbStatus.class, string2);
    }

    public static UsbStatus[] values() {
        return (UsbStatus[])h.clone();
    }
}

