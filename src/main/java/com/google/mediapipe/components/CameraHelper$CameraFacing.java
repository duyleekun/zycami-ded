/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.components;

public final class CameraHelper$CameraFacing
extends Enum {
    private static final /* synthetic */ CameraHelper$CameraFacing[] $VALUES;
    public static final /* enum */ CameraHelper$CameraFacing BACK;
    public static final /* enum */ CameraHelper$CameraFacing FRONT;

    static {
        CameraHelper$CameraFacing cameraHelper$CameraFacing;
        CameraHelper$CameraFacing cameraHelper$CameraFacing2;
        FRONT = cameraHelper$CameraFacing2 = new CameraHelper$CameraFacing("FRONT", 0);
        int n10 = 1;
        BACK = cameraHelper$CameraFacing = new CameraHelper$CameraFacing("BACK", n10);
        CameraHelper$CameraFacing[] cameraHelper$CameraFacingArray = new CameraHelper$CameraFacing[2];
        cameraHelper$CameraFacingArray[0] = cameraHelper$CameraFacing2;
        cameraHelper$CameraFacingArray[n10] = cameraHelper$CameraFacing;
        $VALUES = cameraHelper$CameraFacingArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private CameraHelper$CameraFacing() {
        void var2_-1;
        void var1_-1;
    }

    public static CameraHelper$CameraFacing valueOf(String string2) {
        return Enum.valueOf(CameraHelper$CameraFacing.class, string2);
    }

    public static CameraHelper$CameraFacing[] values() {
        return (CameraHelper$CameraFacing[])$VALUES.clone();
    }
}

