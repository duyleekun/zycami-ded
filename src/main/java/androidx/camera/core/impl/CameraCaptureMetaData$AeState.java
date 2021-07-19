/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

public final class CameraCaptureMetaData$AeState
extends Enum {
    private static final /* synthetic */ CameraCaptureMetaData$AeState[] $VALUES;
    public static final /* enum */ CameraCaptureMetaData$AeState CONVERGED;
    public static final /* enum */ CameraCaptureMetaData$AeState FLASH_REQUIRED;
    public static final /* enum */ CameraCaptureMetaData$AeState INACTIVE;
    public static final /* enum */ CameraCaptureMetaData$AeState LOCKED;
    public static final /* enum */ CameraCaptureMetaData$AeState SEARCHING;
    public static final /* enum */ CameraCaptureMetaData$AeState UNKNOWN;

    static {
        CameraCaptureMetaData$AeState cameraCaptureMetaData$AeState;
        CameraCaptureMetaData$AeState cameraCaptureMetaData$AeState2;
        CameraCaptureMetaData$AeState cameraCaptureMetaData$AeState3;
        CameraCaptureMetaData$AeState cameraCaptureMetaData$AeState4;
        CameraCaptureMetaData$AeState cameraCaptureMetaData$AeState5;
        CameraCaptureMetaData$AeState cameraCaptureMetaData$AeState6;
        UNKNOWN = cameraCaptureMetaData$AeState6 = new CameraCaptureMetaData$AeState("UNKNOWN", 0);
        int n10 = 1;
        INACTIVE = cameraCaptureMetaData$AeState5 = new CameraCaptureMetaData$AeState("INACTIVE", n10);
        int n11 = 2;
        SEARCHING = cameraCaptureMetaData$AeState4 = new CameraCaptureMetaData$AeState("SEARCHING", n11);
        int n12 = 3;
        FLASH_REQUIRED = cameraCaptureMetaData$AeState3 = new CameraCaptureMetaData$AeState("FLASH_REQUIRED", n12);
        int n13 = 4;
        CONVERGED = cameraCaptureMetaData$AeState2 = new CameraCaptureMetaData$AeState("CONVERGED", n13);
        int n14 = 5;
        LOCKED = cameraCaptureMetaData$AeState = new CameraCaptureMetaData$AeState("LOCKED", n14);
        CameraCaptureMetaData$AeState[] cameraCaptureMetaData$AeStateArray = new CameraCaptureMetaData$AeState[6];
        cameraCaptureMetaData$AeStateArray[0] = cameraCaptureMetaData$AeState6;
        cameraCaptureMetaData$AeStateArray[n10] = cameraCaptureMetaData$AeState5;
        cameraCaptureMetaData$AeStateArray[n11] = cameraCaptureMetaData$AeState4;
        cameraCaptureMetaData$AeStateArray[n12] = cameraCaptureMetaData$AeState3;
        cameraCaptureMetaData$AeStateArray[n13] = cameraCaptureMetaData$AeState2;
        cameraCaptureMetaData$AeStateArray[n14] = cameraCaptureMetaData$AeState;
        $VALUES = cameraCaptureMetaData$AeStateArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private CameraCaptureMetaData$AeState() {
        void var2_-1;
        void var1_-1;
    }

    public static CameraCaptureMetaData$AeState valueOf(String string2) {
        return Enum.valueOf(CameraCaptureMetaData$AeState.class, string2);
    }

    public static CameraCaptureMetaData$AeState[] values() {
        return (CameraCaptureMetaData$AeState[])$VALUES.clone();
    }
}

