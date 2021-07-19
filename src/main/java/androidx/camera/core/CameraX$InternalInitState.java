/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

public final class CameraX$InternalInitState
extends Enum {
    private static final /* synthetic */ CameraX$InternalInitState[] $VALUES;
    public static final /* enum */ CameraX$InternalInitState INITIALIZED;
    public static final /* enum */ CameraX$InternalInitState INITIALIZING;
    public static final /* enum */ CameraX$InternalInitState SHUTDOWN;
    public static final /* enum */ CameraX$InternalInitState UNINITIALIZED;

    static {
        CameraX$InternalInitState cameraX$InternalInitState;
        CameraX$InternalInitState cameraX$InternalInitState2;
        CameraX$InternalInitState cameraX$InternalInitState3;
        CameraX$InternalInitState cameraX$InternalInitState4;
        UNINITIALIZED = cameraX$InternalInitState4 = new CameraX$InternalInitState("UNINITIALIZED", 0);
        int n10 = 1;
        INITIALIZING = cameraX$InternalInitState3 = new CameraX$InternalInitState("INITIALIZING", n10);
        int n11 = 2;
        INITIALIZED = cameraX$InternalInitState2 = new CameraX$InternalInitState("INITIALIZED", n11);
        int n12 = 3;
        SHUTDOWN = cameraX$InternalInitState = new CameraX$InternalInitState("SHUTDOWN", n12);
        CameraX$InternalInitState[] cameraX$InternalInitStateArray = new CameraX$InternalInitState[4];
        cameraX$InternalInitStateArray[0] = cameraX$InternalInitState4;
        cameraX$InternalInitStateArray[n10] = cameraX$InternalInitState3;
        cameraX$InternalInitStateArray[n11] = cameraX$InternalInitState2;
        cameraX$InternalInitStateArray[n12] = cameraX$InternalInitState;
        $VALUES = cameraX$InternalInitStateArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private CameraX$InternalInitState() {
        void var2_-1;
        void var1_-1;
    }

    public static CameraX$InternalInitState valueOf(String string2) {
        return Enum.valueOf(CameraX$InternalInitState.class, string2);
    }

    public static CameraX$InternalInitState[] values() {
        return (CameraX$InternalInitState[])$VALUES.clone();
    }
}

