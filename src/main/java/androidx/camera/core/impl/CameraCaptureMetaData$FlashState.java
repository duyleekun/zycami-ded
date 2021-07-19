/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

public final class CameraCaptureMetaData$FlashState
extends Enum {
    private static final /* synthetic */ CameraCaptureMetaData$FlashState[] $VALUES;
    public static final /* enum */ CameraCaptureMetaData$FlashState FIRED;
    public static final /* enum */ CameraCaptureMetaData$FlashState NONE;
    public static final /* enum */ CameraCaptureMetaData$FlashState READY;
    public static final /* enum */ CameraCaptureMetaData$FlashState UNKNOWN;

    static {
        CameraCaptureMetaData$FlashState cameraCaptureMetaData$FlashState;
        CameraCaptureMetaData$FlashState cameraCaptureMetaData$FlashState2;
        CameraCaptureMetaData$FlashState cameraCaptureMetaData$FlashState3;
        CameraCaptureMetaData$FlashState cameraCaptureMetaData$FlashState4;
        UNKNOWN = cameraCaptureMetaData$FlashState4 = new CameraCaptureMetaData$FlashState("UNKNOWN", 0);
        int n10 = 1;
        NONE = cameraCaptureMetaData$FlashState3 = new CameraCaptureMetaData$FlashState("NONE", n10);
        int n11 = 2;
        READY = cameraCaptureMetaData$FlashState2 = new CameraCaptureMetaData$FlashState("READY", n11);
        int n12 = 3;
        FIRED = cameraCaptureMetaData$FlashState = new CameraCaptureMetaData$FlashState("FIRED", n12);
        CameraCaptureMetaData$FlashState[] cameraCaptureMetaData$FlashStateArray = new CameraCaptureMetaData$FlashState[4];
        cameraCaptureMetaData$FlashStateArray[0] = cameraCaptureMetaData$FlashState4;
        cameraCaptureMetaData$FlashStateArray[n10] = cameraCaptureMetaData$FlashState3;
        cameraCaptureMetaData$FlashStateArray[n11] = cameraCaptureMetaData$FlashState2;
        cameraCaptureMetaData$FlashStateArray[n12] = cameraCaptureMetaData$FlashState;
        $VALUES = cameraCaptureMetaData$FlashStateArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private CameraCaptureMetaData$FlashState() {
        void var2_-1;
        void var1_-1;
    }

    public static CameraCaptureMetaData$FlashState valueOf(String string2) {
        return Enum.valueOf(CameraCaptureMetaData$FlashState.class, string2);
    }

    public static CameraCaptureMetaData$FlashState[] values() {
        return (CameraCaptureMetaData$FlashState[])$VALUES.clone();
    }
}

