/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.message.usb.command;

import com.zhiyun.protocol.message.usb.command.UsbStatus;

public class UsbStatus$a {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        UsbStatus usbStatus;
        int n12 = UsbStatus.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            usbStatus = UsbStatus.CONNECTED;
            n11 = usbStatus.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            usbStatus = UsbStatus.ALREADY_CONNECTED_USB;
            n11 = usbStatus.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            usbStatus = UsbStatus.ALREADY_CONNECTED_WIFI;
            n11 = usbStatus.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            usbStatus = UsbStatus.FALED_COMMAND;
            n11 = usbStatus.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            usbStatus = UsbStatus.MEDIA_ENABLE;
            n11 = usbStatus.ordinal();
            nArray[n11] = n10 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            usbStatus = UsbStatus.MEDIA_DISABLE;
            n11 = usbStatus.ordinal();
            nArray[n11] = n10 = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            usbStatus = UsbStatus.UNKNOWN;
            n11 = usbStatus.ordinal();
            nArray[n11] = n10 = 7;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

