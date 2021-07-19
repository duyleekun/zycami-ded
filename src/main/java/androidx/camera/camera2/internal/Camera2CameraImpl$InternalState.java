/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.camera2.internal;

public final class Camera2CameraImpl$InternalState
extends Enum {
    private static final /* synthetic */ Camera2CameraImpl$InternalState[] $VALUES;
    public static final /* enum */ Camera2CameraImpl$InternalState CLOSING;
    public static final /* enum */ Camera2CameraImpl$InternalState INITIALIZED;
    public static final /* enum */ Camera2CameraImpl$InternalState OPENED;
    public static final /* enum */ Camera2CameraImpl$InternalState OPENING;
    public static final /* enum */ Camera2CameraImpl$InternalState PENDING_OPEN;
    public static final /* enum */ Camera2CameraImpl$InternalState RELEASED;
    public static final /* enum */ Camera2CameraImpl$InternalState RELEASING;
    public static final /* enum */ Camera2CameraImpl$InternalState REOPENING;

    static {
        Camera2CameraImpl$InternalState camera2CameraImpl$InternalState;
        Camera2CameraImpl$InternalState camera2CameraImpl$InternalState2;
        Camera2CameraImpl$InternalState camera2CameraImpl$InternalState3;
        Camera2CameraImpl$InternalState camera2CameraImpl$InternalState4;
        Camera2CameraImpl$InternalState camera2CameraImpl$InternalState5;
        Camera2CameraImpl$InternalState camera2CameraImpl$InternalState6;
        Camera2CameraImpl$InternalState camera2CameraImpl$InternalState7;
        Camera2CameraImpl$InternalState camera2CameraImpl$InternalState8;
        INITIALIZED = camera2CameraImpl$InternalState8 = new Camera2CameraImpl$InternalState("INITIALIZED", 0);
        int n10 = 1;
        PENDING_OPEN = camera2CameraImpl$InternalState7 = new Camera2CameraImpl$InternalState("PENDING_OPEN", n10);
        int n11 = 2;
        OPENING = camera2CameraImpl$InternalState6 = new Camera2CameraImpl$InternalState("OPENING", n11);
        int n12 = 3;
        OPENED = camera2CameraImpl$InternalState5 = new Camera2CameraImpl$InternalState("OPENED", n12);
        int n13 = 4;
        CLOSING = camera2CameraImpl$InternalState4 = new Camera2CameraImpl$InternalState("CLOSING", n13);
        int n14 = 5;
        REOPENING = camera2CameraImpl$InternalState3 = new Camera2CameraImpl$InternalState("REOPENING", n14);
        RELEASING = camera2CameraImpl$InternalState2 = new Camera2CameraImpl$InternalState("RELEASING", 6);
        int n15 = 7;
        RELEASED = camera2CameraImpl$InternalState = new Camera2CameraImpl$InternalState("RELEASED", n15);
        Camera2CameraImpl$InternalState[] camera2CameraImpl$InternalStateArray = new Camera2CameraImpl$InternalState[8];
        camera2CameraImpl$InternalStateArray[0] = camera2CameraImpl$InternalState8;
        camera2CameraImpl$InternalStateArray[n10] = camera2CameraImpl$InternalState7;
        camera2CameraImpl$InternalStateArray[n11] = camera2CameraImpl$InternalState6;
        camera2CameraImpl$InternalStateArray[n12] = camera2CameraImpl$InternalState5;
        camera2CameraImpl$InternalStateArray[n13] = camera2CameraImpl$InternalState4;
        camera2CameraImpl$InternalStateArray[n14] = camera2CameraImpl$InternalState3;
        camera2CameraImpl$InternalStateArray[6] = camera2CameraImpl$InternalState2;
        camera2CameraImpl$InternalStateArray[n15] = camera2CameraImpl$InternalState;
        $VALUES = camera2CameraImpl$InternalStateArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Camera2CameraImpl$InternalState() {
        void var2_-1;
        void var1_-1;
    }

    public static Camera2CameraImpl$InternalState valueOf(String string2) {
        return Enum.valueOf(Camera2CameraImpl$InternalState.class, string2);
    }

    public static Camera2CameraImpl$InternalState[] values() {
        return (Camera2CameraImpl$InternalState[])$VALUES.clone();
    }
}

