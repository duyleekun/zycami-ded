/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

public final class CameraInternal$State
extends Enum {
    private static final /* synthetic */ CameraInternal$State[] $VALUES;
    public static final /* enum */ CameraInternal$State CLOSED;
    public static final /* enum */ CameraInternal$State CLOSING;
    public static final /* enum */ CameraInternal$State OPEN;
    public static final /* enum */ CameraInternal$State OPENING;
    public static final /* enum */ CameraInternal$State PENDING_OPEN;
    public static final /* enum */ CameraInternal$State RELEASED;
    public static final /* enum */ CameraInternal$State RELEASING;
    private final boolean mHoldsCameraSlot;

    static {
        CameraInternal$State cameraInternal$State;
        CameraInternal$State cameraInternal$State2;
        CameraInternal$State cameraInternal$State3;
        CameraInternal$State cameraInternal$State4;
        CameraInternal$State cameraInternal$State5;
        CameraInternal$State cameraInternal$State6;
        CameraInternal$State cameraInternal$State7;
        PENDING_OPEN = cameraInternal$State7 = new CameraInternal$State("PENDING_OPEN", 0, false);
        int n10 = 1;
        OPENING = cameraInternal$State6 = new CameraInternal$State("OPENING", n10, n10 != 0);
        int n11 = 2;
        OPEN = cameraInternal$State5 = new CameraInternal$State("OPEN", n11, n10 != 0);
        int n12 = 3;
        CLOSING = cameraInternal$State4 = new CameraInternal$State("CLOSING", n12, n10 != 0);
        int n13 = 4;
        CLOSED = cameraInternal$State3 = new CameraInternal$State("CLOSED", n13, false);
        int n14 = 5;
        RELEASING = cameraInternal$State2 = new CameraInternal$State("RELEASING", n14, n10 != 0);
        int n15 = 6;
        RELEASED = cameraInternal$State = new CameraInternal$State("RELEASED", n15, false);
        CameraInternal$State[] cameraInternal$StateArray = new CameraInternal$State[7];
        cameraInternal$StateArray[0] = cameraInternal$State7;
        cameraInternal$StateArray[n10] = cameraInternal$State6;
        cameraInternal$StateArray[n11] = cameraInternal$State5;
        cameraInternal$StateArray[n12] = cameraInternal$State4;
        cameraInternal$StateArray[n13] = cameraInternal$State3;
        cameraInternal$StateArray[n14] = cameraInternal$State2;
        cameraInternal$StateArray[n15] = cameraInternal$State;
        $VALUES = cameraInternal$StateArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private CameraInternal$State() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.mHoldsCameraSlot = var3_1;
    }

    public static CameraInternal$State valueOf(String string2) {
        return Enum.valueOf(CameraInternal$State.class, string2);
    }

    public static CameraInternal$State[] values() {
        return (CameraInternal$State[])$VALUES.clone();
    }

    public boolean holdsCameraSlot() {
        return this.mHoldsCameraSlot;
    }
}

