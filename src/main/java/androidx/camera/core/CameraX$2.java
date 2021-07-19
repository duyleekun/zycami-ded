/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.CameraX$InternalInitState;

public class CameraX$2 {
    public static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$CameraX$InternalInitState;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        CameraX$InternalInitState cameraX$InternalInitState;
        int n12 = CameraX$InternalInitState.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$androidx$camera$core$CameraX$InternalInitState = nArray;
        try {
            cameraX$InternalInitState = CameraX$InternalInitState.UNINITIALIZED;
            n11 = cameraX$InternalInitState.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$camera$core$CameraX$InternalInitState;
            cameraX$InternalInitState = CameraX$InternalInitState.INITIALIZING;
            n11 = cameraX$InternalInitState.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$camera$core$CameraX$InternalInitState;
            cameraX$InternalInitState = CameraX$InternalInitState.INITIALIZED;
            n11 = cameraX$InternalInitState.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$camera$core$CameraX$InternalInitState;
            cameraX$InternalInitState = CameraX$InternalInitState.SHUTDOWN;
            n11 = cameraX$InternalInitState.ordinal();
            nArray[n11] = n10 = 4;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

