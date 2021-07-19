/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.message.bl.wifi.device;

import com.zhiyun.protocol.message.bl.wifi.device.CameraBrand;

public class CameraBrand$a {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        CameraBrand cameraBrand;
        int n12 = CameraBrand.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            cameraBrand = CameraBrand.QUERY;
            n11 = cameraBrand.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            cameraBrand = CameraBrand.SONY;
            n11 = cameraBrand.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            cameraBrand = CameraBrand.PANASONIC;
            n11 = cameraBrand.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            cameraBrand = CameraBrand.CANON;
            n11 = cameraBrand.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            cameraBrand = CameraBrand.GO_PRO;
            n11 = cameraBrand.ordinal();
            nArray[n11] = n10 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            cameraBrand = CameraBrand.FUJIFILM;
            n11 = cameraBrand.ordinal();
            nArray[n11] = n10 = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            cameraBrand = CameraBrand.GO_PRO_EVO2;
            n11 = cameraBrand.ordinal();
            nArray[n11] = n10 = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            cameraBrand = CameraBrand.SJCAM;
            n11 = cameraBrand.ordinal();
            nArray[n11] = n10 = 8;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            cameraBrand = CameraBrand.ERROR;
            n11 = cameraBrand.ordinal();
            nArray[n11] = n10 = 9;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

