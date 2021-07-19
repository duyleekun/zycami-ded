/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

public final class CameraCaptureMetaData$AfMode
extends Enum {
    private static final /* synthetic */ CameraCaptureMetaData$AfMode[] $VALUES;
    public static final /* enum */ CameraCaptureMetaData$AfMode OFF;
    public static final /* enum */ CameraCaptureMetaData$AfMode ON_CONTINUOUS_AUTO;
    public static final /* enum */ CameraCaptureMetaData$AfMode ON_MANUAL_AUTO;
    public static final /* enum */ CameraCaptureMetaData$AfMode UNKNOWN;

    static {
        CameraCaptureMetaData$AfMode cameraCaptureMetaData$AfMode;
        CameraCaptureMetaData$AfMode cameraCaptureMetaData$AfMode2;
        CameraCaptureMetaData$AfMode cameraCaptureMetaData$AfMode3;
        CameraCaptureMetaData$AfMode cameraCaptureMetaData$AfMode4;
        UNKNOWN = cameraCaptureMetaData$AfMode4 = new CameraCaptureMetaData$AfMode("UNKNOWN", 0);
        int n10 = 1;
        OFF = cameraCaptureMetaData$AfMode3 = new CameraCaptureMetaData$AfMode("OFF", n10);
        int n11 = 2;
        ON_MANUAL_AUTO = cameraCaptureMetaData$AfMode2 = new CameraCaptureMetaData$AfMode("ON_MANUAL_AUTO", n11);
        int n12 = 3;
        ON_CONTINUOUS_AUTO = cameraCaptureMetaData$AfMode = new CameraCaptureMetaData$AfMode("ON_CONTINUOUS_AUTO", n12);
        CameraCaptureMetaData$AfMode[] cameraCaptureMetaData$AfModeArray = new CameraCaptureMetaData$AfMode[4];
        cameraCaptureMetaData$AfModeArray[0] = cameraCaptureMetaData$AfMode4;
        cameraCaptureMetaData$AfModeArray[n10] = cameraCaptureMetaData$AfMode3;
        cameraCaptureMetaData$AfModeArray[n11] = cameraCaptureMetaData$AfMode2;
        cameraCaptureMetaData$AfModeArray[n12] = cameraCaptureMetaData$AfMode;
        $VALUES = cameraCaptureMetaData$AfModeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private CameraCaptureMetaData$AfMode() {
        void var2_-1;
        void var1_-1;
    }

    public static CameraCaptureMetaData$AfMode valueOf(String string2) {
        return Enum.valueOf(CameraCaptureMetaData$AfMode.class, string2);
    }

    public static CameraCaptureMetaData$AfMode[] values() {
        return (CameraCaptureMetaData$AfMode[])$VALUES.clone();
    }
}

