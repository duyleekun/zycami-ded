/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

public final class SurfaceConfig$ConfigSize
extends Enum {
    private static final /* synthetic */ SurfaceConfig$ConfigSize[] $VALUES;
    public static final /* enum */ SurfaceConfig$ConfigSize ANALYSIS;
    public static final /* enum */ SurfaceConfig$ConfigSize MAXIMUM;
    public static final /* enum */ SurfaceConfig$ConfigSize NOT_SUPPORT;
    public static final /* enum */ SurfaceConfig$ConfigSize PREVIEW;
    public static final /* enum */ SurfaceConfig$ConfigSize RECORD;
    public final int mId;

    static {
        SurfaceConfig$ConfigSize surfaceConfig$ConfigSize;
        SurfaceConfig$ConfigSize surfaceConfig$ConfigSize2;
        SurfaceConfig$ConfigSize surfaceConfig$ConfigSize3;
        SurfaceConfig$ConfigSize surfaceConfig$ConfigSize4;
        SurfaceConfig$ConfigSize surfaceConfig$ConfigSize5;
        ANALYSIS = surfaceConfig$ConfigSize5 = new SurfaceConfig$ConfigSize("ANALYSIS", 0, 0);
        int n10 = 1;
        PREVIEW = surfaceConfig$ConfigSize4 = new SurfaceConfig$ConfigSize("PREVIEW", n10, n10);
        int n11 = 2;
        RECORD = surfaceConfig$ConfigSize3 = new SurfaceConfig$ConfigSize("RECORD", n11, n11);
        int n12 = 3;
        MAXIMUM = surfaceConfig$ConfigSize2 = new SurfaceConfig$ConfigSize("MAXIMUM", n12, n12);
        int n13 = 4;
        NOT_SUPPORT = surfaceConfig$ConfigSize = new SurfaceConfig$ConfigSize("NOT_SUPPORT", n13, n13);
        SurfaceConfig$ConfigSize[] surfaceConfig$ConfigSizeArray = new SurfaceConfig$ConfigSize[5];
        surfaceConfig$ConfigSizeArray[0] = surfaceConfig$ConfigSize5;
        surfaceConfig$ConfigSizeArray[n10] = surfaceConfig$ConfigSize4;
        surfaceConfig$ConfigSizeArray[n11] = surfaceConfig$ConfigSize3;
        surfaceConfig$ConfigSizeArray[n12] = surfaceConfig$ConfigSize2;
        surfaceConfig$ConfigSizeArray[n13] = surfaceConfig$ConfigSize;
        $VALUES = surfaceConfig$ConfigSizeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private SurfaceConfig$ConfigSize() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.mId = var3_1;
    }

    public static SurfaceConfig$ConfigSize valueOf(String string2) {
        return Enum.valueOf(SurfaceConfig$ConfigSize.class, string2);
    }

    public static SurfaceConfig$ConfigSize[] values() {
        return (SurfaceConfig$ConfigSize[])$VALUES.clone();
    }

    public int getId() {
        return this.mId;
    }
}

