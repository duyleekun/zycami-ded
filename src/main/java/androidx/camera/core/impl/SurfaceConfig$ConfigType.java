/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

public final class SurfaceConfig$ConfigType
extends Enum {
    private static final /* synthetic */ SurfaceConfig$ConfigType[] $VALUES;
    public static final /* enum */ SurfaceConfig$ConfigType JPEG;
    public static final /* enum */ SurfaceConfig$ConfigType PRIV;
    public static final /* enum */ SurfaceConfig$ConfigType RAW;
    public static final /* enum */ SurfaceConfig$ConfigType YUV;

    static {
        SurfaceConfig$ConfigType surfaceConfig$ConfigType;
        SurfaceConfig$ConfigType surfaceConfig$ConfigType2;
        SurfaceConfig$ConfigType surfaceConfig$ConfigType3;
        SurfaceConfig$ConfigType surfaceConfig$ConfigType4;
        PRIV = surfaceConfig$ConfigType4 = new SurfaceConfig$ConfigType("PRIV", 0);
        int n10 = 1;
        YUV = surfaceConfig$ConfigType3 = new SurfaceConfig$ConfigType("YUV", n10);
        int n11 = 2;
        JPEG = surfaceConfig$ConfigType2 = new SurfaceConfig$ConfigType("JPEG", n11);
        int n12 = 3;
        RAW = surfaceConfig$ConfigType = new SurfaceConfig$ConfigType("RAW", n12);
        SurfaceConfig$ConfigType[] surfaceConfig$ConfigTypeArray = new SurfaceConfig$ConfigType[4];
        surfaceConfig$ConfigTypeArray[0] = surfaceConfig$ConfigType4;
        surfaceConfig$ConfigTypeArray[n10] = surfaceConfig$ConfigType3;
        surfaceConfig$ConfigTypeArray[n11] = surfaceConfig$ConfigType2;
        surfaceConfig$ConfigTypeArray[n12] = surfaceConfig$ConfigType;
        $VALUES = surfaceConfig$ConfigTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private SurfaceConfig$ConfigType() {
        void var2_-1;
        void var1_-1;
    }

    public static SurfaceConfig$ConfigType valueOf(String string2) {
        return Enum.valueOf(SurfaceConfig$ConfigType.class, string2);
    }

    public static SurfaceConfig$ConfigType[] values() {
        return (SurfaceConfig$ConfigType[])$VALUES.clone();
    }
}

