/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.view;

public final class CameraView$CaptureMode
extends Enum {
    private static final /* synthetic */ CameraView$CaptureMode[] $VALUES;
    public static final /* enum */ CameraView$CaptureMode IMAGE;
    public static final /* enum */ CameraView$CaptureMode MIXED;
    public static final /* enum */ CameraView$CaptureMode VIDEO;
    private final int mId;

    static {
        CameraView$CaptureMode cameraView$CaptureMode;
        CameraView$CaptureMode cameraView$CaptureMode2;
        CameraView$CaptureMode cameraView$CaptureMode3;
        IMAGE = cameraView$CaptureMode3 = new CameraView$CaptureMode("IMAGE", 0, 0);
        int n10 = 1;
        VIDEO = cameraView$CaptureMode2 = new CameraView$CaptureMode("VIDEO", n10, n10);
        int n11 = 2;
        MIXED = cameraView$CaptureMode = new CameraView$CaptureMode("MIXED", n11, n11);
        CameraView$CaptureMode[] cameraView$CaptureModeArray = new CameraView$CaptureMode[3];
        cameraView$CaptureModeArray[0] = cameraView$CaptureMode3;
        cameraView$CaptureModeArray[n10] = cameraView$CaptureMode2;
        cameraView$CaptureModeArray[n11] = cameraView$CaptureMode;
        $VALUES = cameraView$CaptureModeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private CameraView$CaptureMode() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.mId = var3_1;
    }

    public static CameraView$CaptureMode fromId(int n10) {
        for (CameraView$CaptureMode cameraView$CaptureMode : CameraView$CaptureMode.values()) {
            int n11 = cameraView$CaptureMode.mId;
            if (n11 != n10) continue;
            return cameraView$CaptureMode;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }

    public static CameraView$CaptureMode valueOf(String string2) {
        return Enum.valueOf(CameraView$CaptureMode.class, string2);
    }

    public static CameraView$CaptureMode[] values() {
        return (CameraView$CaptureMode[])$VALUES.clone();
    }

    public int getId() {
        return this.mId;
    }
}

