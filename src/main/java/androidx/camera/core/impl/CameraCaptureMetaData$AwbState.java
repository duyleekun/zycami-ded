/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

public final class CameraCaptureMetaData$AwbState
extends Enum {
    private static final /* synthetic */ CameraCaptureMetaData$AwbState[] $VALUES;
    public static final /* enum */ CameraCaptureMetaData$AwbState CONVERGED;
    public static final /* enum */ CameraCaptureMetaData$AwbState INACTIVE;
    public static final /* enum */ CameraCaptureMetaData$AwbState LOCKED;
    public static final /* enum */ CameraCaptureMetaData$AwbState METERING;
    public static final /* enum */ CameraCaptureMetaData$AwbState UNKNOWN;

    static {
        CameraCaptureMetaData$AwbState cameraCaptureMetaData$AwbState;
        CameraCaptureMetaData$AwbState cameraCaptureMetaData$AwbState2;
        CameraCaptureMetaData$AwbState cameraCaptureMetaData$AwbState3;
        CameraCaptureMetaData$AwbState cameraCaptureMetaData$AwbState4;
        CameraCaptureMetaData$AwbState cameraCaptureMetaData$AwbState5;
        UNKNOWN = cameraCaptureMetaData$AwbState5 = new CameraCaptureMetaData$AwbState("UNKNOWN", 0);
        int n10 = 1;
        INACTIVE = cameraCaptureMetaData$AwbState4 = new CameraCaptureMetaData$AwbState("INACTIVE", n10);
        int n11 = 2;
        METERING = cameraCaptureMetaData$AwbState3 = new CameraCaptureMetaData$AwbState("METERING", n11);
        int n12 = 3;
        CONVERGED = cameraCaptureMetaData$AwbState2 = new CameraCaptureMetaData$AwbState("CONVERGED", n12);
        int n13 = 4;
        LOCKED = cameraCaptureMetaData$AwbState = new CameraCaptureMetaData$AwbState("LOCKED", n13);
        CameraCaptureMetaData$AwbState[] cameraCaptureMetaData$AwbStateArray = new CameraCaptureMetaData$AwbState[5];
        cameraCaptureMetaData$AwbStateArray[0] = cameraCaptureMetaData$AwbState5;
        cameraCaptureMetaData$AwbStateArray[n10] = cameraCaptureMetaData$AwbState4;
        cameraCaptureMetaData$AwbStateArray[n11] = cameraCaptureMetaData$AwbState3;
        cameraCaptureMetaData$AwbStateArray[n12] = cameraCaptureMetaData$AwbState2;
        cameraCaptureMetaData$AwbStateArray[n13] = cameraCaptureMetaData$AwbState;
        $VALUES = cameraCaptureMetaData$AwbStateArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private CameraCaptureMetaData$AwbState() {
        void var2_-1;
        void var1_-1;
    }

    public static CameraCaptureMetaData$AwbState valueOf(String string2) {
        return Enum.valueOf(CameraCaptureMetaData$AwbState.class, string2);
    }

    public static CameraCaptureMetaData$AwbState[] values() {
        return (CameraCaptureMetaData$AwbState[])$VALUES.clone();
    }
}

