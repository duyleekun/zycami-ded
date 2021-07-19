/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.message.bl.wifi.device;

import com.zhiyun.protocol.message.bl.wifi.device.CameraBrand$a;

public final class CameraBrand
extends Enum {
    public static final /* enum */ CameraBrand CANON;
    public static final /* enum */ CameraBrand ERROR;
    public static final /* enum */ CameraBrand FUJIFILM;
    public static final /* enum */ CameraBrand GO_PRO;
    public static final /* enum */ CameraBrand GO_PRO_EVO2;
    public static final /* enum */ CameraBrand PANASONIC;
    public static final /* enum */ CameraBrand QUERY;
    public static final /* enum */ CameraBrand SJCAM;
    public static final /* enum */ CameraBrand SONY;
    private static final int a = 0;
    private static final int b = 1;
    private static final int c = 2;
    private static final int d = 3;
    private static final int e = 4;
    private static final int f = 5;
    private static final int g = 6;
    private static final int h = 7;
    private static final int i = 8;
    private static final /* synthetic */ CameraBrand[] j;

    static {
        CameraBrand cameraBrand;
        CameraBrand cameraBrand2;
        CameraBrand cameraBrand3;
        CameraBrand cameraBrand4;
        CameraBrand cameraBrand5;
        CameraBrand cameraBrand6;
        CameraBrand cameraBrand7;
        CameraBrand cameraBrand8;
        CameraBrand cameraBrand9;
        ERROR = cameraBrand9 = new CameraBrand("ERROR", 0);
        int n10 = 1;
        QUERY = cameraBrand8 = new CameraBrand("QUERY", n10);
        int n11 = 2;
        SONY = cameraBrand7 = new CameraBrand("SONY", n11);
        int n12 = 3;
        PANASONIC = cameraBrand6 = new CameraBrand("PANASONIC", n12);
        int n13 = 4;
        CANON = cameraBrand5 = new CameraBrand("CANON", n13);
        GO_PRO = cameraBrand4 = new CameraBrand("GO_PRO", 5);
        FUJIFILM = cameraBrand3 = new CameraBrand("FUJIFILM", 6);
        GO_PRO_EVO2 = cameraBrand2 = new CameraBrand("GO_PRO_EVO2", 7);
        int n14 = 8;
        SJCAM = cameraBrand = new CameraBrand("SJCAM", n14);
        CameraBrand[] cameraBrandArray = new CameraBrand[9];
        cameraBrandArray[0] = cameraBrand9;
        cameraBrandArray[n10] = cameraBrand8;
        cameraBrandArray[n11] = cameraBrand7;
        cameraBrandArray[n12] = cameraBrand6;
        cameraBrandArray[n13] = cameraBrand5;
        cameraBrandArray[5] = cameraBrand4;
        cameraBrandArray[6] = cameraBrand3;
        cameraBrandArray[7] = cameraBrand2;
        cameraBrandArray[n14] = cameraBrand;
        j = cameraBrandArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private CameraBrand() {
        void var2_-1;
        void var1_-1;
    }

    public static CameraBrand from(int n10) {
        switch (n10) {
            default: {
                return ERROR;
            }
            case 8: {
                return SJCAM;
            }
            case 7: {
                return GO_PRO_EVO2;
            }
            case 6: {
                return FUJIFILM;
            }
            case 5: {
                return GO_PRO;
            }
            case 4: {
                return CANON;
            }
            case 3: {
                return PANASONIC;
            }
            case 2: {
                return SONY;
            }
            case 1: 
        }
        return QUERY;
    }

    public static int to(CameraBrand cameraBrand) {
        int[] nArray = CameraBrand$a.a;
        int n10 = cameraBrand.ordinal();
        n10 = nArray[n10];
        switch (n10) {
            default: {
                return 0;
            }
            case 8: {
                return 8;
            }
            case 7: {
                return 7;
            }
            case 6: {
                return 6;
            }
            case 5: {
                return 5;
            }
            case 4: {
                return 4;
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

    public static CameraBrand valueOf(String string2) {
        return Enum.valueOf(CameraBrand.class, string2);
    }

    public static CameraBrand[] values() {
        return (CameraBrand[])j.clone();
    }
}

