/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

public final class CameraCaptureFailure$Reason
extends Enum {
    private static final /* synthetic */ CameraCaptureFailure$Reason[] $VALUES;
    public static final /* enum */ CameraCaptureFailure$Reason ERROR;

    static {
        CameraCaptureFailure$Reason cameraCaptureFailure$Reason;
        ERROR = cameraCaptureFailure$Reason = new CameraCaptureFailure$Reason("ERROR", 0);
        CameraCaptureFailure$Reason[] cameraCaptureFailure$ReasonArray = new CameraCaptureFailure$Reason[]{cameraCaptureFailure$Reason};
        $VALUES = cameraCaptureFailure$ReasonArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private CameraCaptureFailure$Reason() {
        void var2_-1;
        void var1_-1;
    }

    public static CameraCaptureFailure$Reason valueOf(String string2) {
        return Enum.valueOf(CameraCaptureFailure$Reason.class, string2);
    }

    public static CameraCaptureFailure$Reason[] values() {
        return (CameraCaptureFailure$Reason[])$VALUES.clone();
    }
}

