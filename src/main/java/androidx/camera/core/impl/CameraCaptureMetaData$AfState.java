/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

public final class CameraCaptureMetaData$AfState
extends Enum {
    private static final /* synthetic */ CameraCaptureMetaData$AfState[] $VALUES;
    public static final /* enum */ CameraCaptureMetaData$AfState FOCUSED;
    public static final /* enum */ CameraCaptureMetaData$AfState INACTIVE;
    public static final /* enum */ CameraCaptureMetaData$AfState LOCKED_FOCUSED;
    public static final /* enum */ CameraCaptureMetaData$AfState LOCKED_NOT_FOCUSED;
    public static final /* enum */ CameraCaptureMetaData$AfState SCANNING;
    public static final /* enum */ CameraCaptureMetaData$AfState UNKNOWN;

    static {
        CameraCaptureMetaData$AfState cameraCaptureMetaData$AfState;
        CameraCaptureMetaData$AfState cameraCaptureMetaData$AfState2;
        CameraCaptureMetaData$AfState cameraCaptureMetaData$AfState3;
        CameraCaptureMetaData$AfState cameraCaptureMetaData$AfState4;
        CameraCaptureMetaData$AfState cameraCaptureMetaData$AfState5;
        CameraCaptureMetaData$AfState cameraCaptureMetaData$AfState6;
        UNKNOWN = cameraCaptureMetaData$AfState6 = new CameraCaptureMetaData$AfState("UNKNOWN", 0);
        int n10 = 1;
        INACTIVE = cameraCaptureMetaData$AfState5 = new CameraCaptureMetaData$AfState("INACTIVE", n10);
        int n11 = 2;
        SCANNING = cameraCaptureMetaData$AfState4 = new CameraCaptureMetaData$AfState("SCANNING", n11);
        int n12 = 3;
        FOCUSED = cameraCaptureMetaData$AfState3 = new CameraCaptureMetaData$AfState("FOCUSED", n12);
        int n13 = 4;
        LOCKED_FOCUSED = cameraCaptureMetaData$AfState2 = new CameraCaptureMetaData$AfState("LOCKED_FOCUSED", n13);
        int n14 = 5;
        LOCKED_NOT_FOCUSED = cameraCaptureMetaData$AfState = new CameraCaptureMetaData$AfState("LOCKED_NOT_FOCUSED", n14);
        CameraCaptureMetaData$AfState[] cameraCaptureMetaData$AfStateArray = new CameraCaptureMetaData$AfState[6];
        cameraCaptureMetaData$AfStateArray[0] = cameraCaptureMetaData$AfState6;
        cameraCaptureMetaData$AfStateArray[n10] = cameraCaptureMetaData$AfState5;
        cameraCaptureMetaData$AfStateArray[n11] = cameraCaptureMetaData$AfState4;
        cameraCaptureMetaData$AfStateArray[n12] = cameraCaptureMetaData$AfState3;
        cameraCaptureMetaData$AfStateArray[n13] = cameraCaptureMetaData$AfState2;
        cameraCaptureMetaData$AfStateArray[n14] = cameraCaptureMetaData$AfState;
        $VALUES = cameraCaptureMetaData$AfStateArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private CameraCaptureMetaData$AfState() {
        void var2_-1;
        void var1_-1;
    }

    public static CameraCaptureMetaData$AfState valueOf(String string2) {
        return Enum.valueOf(CameraCaptureMetaData$AfState.class, string2);
    }

    public static CameraCaptureMetaData$AfState[] values() {
        return (CameraCaptureMetaData$AfState[])$VALUES.clone();
    }
}

