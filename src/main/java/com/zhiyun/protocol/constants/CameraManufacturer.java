/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.constants;

public final class CameraManufacturer
extends Enum {
    private static final /* synthetic */ CameraManufacturer[] $VALUES;
    public static final /* enum */ CameraManufacturer BMPCC;
    public static final /* enum */ CameraManufacturer CANON;
    public static final /* enum */ CameraManufacturer CCS;
    public static final /* enum */ CameraManufacturer CLOSE;
    public static final /* enum */ CameraManufacturer FUJI;
    public static final /* enum */ CameraManufacturer NIKON;
    public static final /* enum */ CameraManufacturer OLYMPUS;
    public static final /* enum */ CameraManufacturer PANASONIC;
    public static final /* enum */ CameraManufacturer SIGMA;
    public static final /* enum */ CameraManufacturer SONY;
    public static final /* enum */ CameraManufacturer V_CANON;
    public static final /* enum */ CameraManufacturer V_SONY;
    public static final /* enum */ CameraManufacturer ZCAM;
    public final int value;

    static {
        CameraManufacturer cameraManufacturer;
        CameraManufacturer cameraManufacturer2;
        CameraManufacturer cameraManufacturer3;
        CameraManufacturer cameraManufacturer4;
        CameraManufacturer cameraManufacturer5;
        CameraManufacturer cameraManufacturer6;
        CameraManufacturer cameraManufacturer7;
        CameraManufacturer cameraManufacturer8;
        CameraManufacturer cameraManufacturer9;
        CameraManufacturer cameraManufacturer10;
        CameraManufacturer cameraManufacturer11;
        CameraManufacturer cameraManufacturer12;
        CameraManufacturer cameraManufacturer13;
        CLOSE = cameraManufacturer13 = new CameraManufacturer("CLOSE", 0, 0);
        int n10 = 1;
        CANON = cameraManufacturer12 = new CameraManufacturer("CANON", n10, n10);
        int n11 = 2;
        SONY = cameraManufacturer11 = new CameraManufacturer("SONY", n11, n11);
        int n12 = 3;
        PANASONIC = cameraManufacturer10 = new CameraManufacturer("PANASONIC", n12, n12);
        int n13 = 4;
        NIKON = cameraManufacturer9 = new CameraManufacturer("NIKON", n13, n13);
        int n14 = 5;
        CCS = cameraManufacturer8 = new CameraManufacturer("CCS", n14, n14);
        int n15 = 6;
        FUJI = cameraManufacturer7 = new CameraManufacturer("FUJI", n15, n15);
        n15 = 7;
        OLYMPUS = cameraManufacturer6 = new CameraManufacturer("OLYMPUS", n15, n15);
        n14 = 8;
        V_CANON = cameraManufacturer5 = new CameraManufacturer("V_CANON", n14, n14);
        n13 = 9;
        V_SONY = cameraManufacturer4 = new CameraManufacturer("V_SONY", n13, n13);
        n12 = 10;
        ZCAM = cameraManufacturer3 = new CameraManufacturer("ZCAM", n12, n12);
        n11 = 11;
        BMPCC = cameraManufacturer2 = new CameraManufacturer("BMPCC", n11, n11);
        n10 = 12;
        SIGMA = cameraManufacturer = new CameraManufacturer("SIGMA", n10, n10);
        CameraManufacturer[] cameraManufacturerArray = new CameraManufacturer[13];
        cameraManufacturerArray[0] = cameraManufacturer13;
        cameraManufacturerArray[1] = cameraManufacturer12;
        cameraManufacturerArray[2] = cameraManufacturer11;
        cameraManufacturerArray[3] = cameraManufacturer10;
        cameraManufacturerArray[4] = cameraManufacturer9;
        cameraManufacturerArray[5] = cameraManufacturer8;
        cameraManufacturerArray[6] = cameraManufacturer7;
        cameraManufacturerArray[7] = cameraManufacturer6;
        cameraManufacturerArray[8] = cameraManufacturer5;
        cameraManufacturerArray[9] = cameraManufacturer4;
        cameraManufacturerArray[10] = cameraManufacturer3;
        cameraManufacturerArray[11] = cameraManufacturer2;
        cameraManufacturerArray[n10] = cameraManufacturer;
        $VALUES = cameraManufacturerArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private CameraManufacturer() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static CameraManufacturer from(int n10) {
        for (CameraManufacturer cameraManufacturer : CameraManufacturer.values()) {
            int n11 = cameraManufacturer.value;
            if (n11 != n10) continue;
            return cameraManufacturer;
        }
        return CLOSE;
    }

    public static CameraManufacturer valueOf(String string2) {
        return Enum.valueOf(CameraManufacturer.class, string2);
    }

    public static CameraManufacturer[] values() {
        return (CameraManufacturer[])$VALUES.clone();
    }
}

