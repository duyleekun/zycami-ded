/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.camera2.internal;

public final class CaptureSession$State
extends Enum {
    private static final /* synthetic */ CaptureSession$State[] $VALUES;
    public static final /* enum */ CaptureSession$State CLOSED;
    public static final /* enum */ CaptureSession$State GET_SURFACE;
    public static final /* enum */ CaptureSession$State INITIALIZED;
    public static final /* enum */ CaptureSession$State OPENED;
    public static final /* enum */ CaptureSession$State OPENING;
    public static final /* enum */ CaptureSession$State RELEASED;
    public static final /* enum */ CaptureSession$State RELEASING;
    public static final /* enum */ CaptureSession$State UNINITIALIZED;

    static {
        CaptureSession$State captureSession$State;
        CaptureSession$State captureSession$State2;
        CaptureSession$State captureSession$State3;
        CaptureSession$State captureSession$State4;
        CaptureSession$State captureSession$State5;
        CaptureSession$State captureSession$State6;
        CaptureSession$State captureSession$State7;
        CaptureSession$State captureSession$State8;
        UNINITIALIZED = captureSession$State8 = new CaptureSession$State("UNINITIALIZED", 0);
        int n10 = 1;
        INITIALIZED = captureSession$State7 = new CaptureSession$State("INITIALIZED", n10);
        int n11 = 2;
        GET_SURFACE = captureSession$State6 = new CaptureSession$State("GET_SURFACE", n11);
        int n12 = 3;
        OPENING = captureSession$State5 = new CaptureSession$State("OPENING", n12);
        int n13 = 4;
        OPENED = captureSession$State4 = new CaptureSession$State("OPENED", n13);
        int n14 = 5;
        CLOSED = captureSession$State3 = new CaptureSession$State("CLOSED", n14);
        RELEASING = captureSession$State2 = new CaptureSession$State("RELEASING", 6);
        int n15 = 7;
        RELEASED = captureSession$State = new CaptureSession$State("RELEASED", n15);
        CaptureSession$State[] captureSession$StateArray = new CaptureSession$State[8];
        captureSession$StateArray[0] = captureSession$State8;
        captureSession$StateArray[n10] = captureSession$State7;
        captureSession$StateArray[n11] = captureSession$State6;
        captureSession$StateArray[n12] = captureSession$State5;
        captureSession$StateArray[n13] = captureSession$State4;
        captureSession$StateArray[n14] = captureSession$State3;
        captureSession$StateArray[6] = captureSession$State2;
        captureSession$StateArray[n15] = captureSession$State;
        $VALUES = captureSession$StateArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private CaptureSession$State() {
        void var2_-1;
        void var1_-1;
    }

    public static CaptureSession$State valueOf(String string2) {
        return Enum.valueOf(CaptureSession$State.class, string2);
    }

    public static CaptureSession$State[] values() {
        return (CaptureSession$State[])$VALUES.clone();
    }
}

