/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.Camera2CameraImpl$InternalState;

public class Camera2CameraImpl$3 {
    public static final /* synthetic */ int[] $SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        Camera2CameraImpl$InternalState camera2CameraImpl$InternalState;
        int n12 = Camera2CameraImpl$InternalState.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState = nArray;
        try {
            camera2CameraImpl$InternalState = Camera2CameraImpl$InternalState.INITIALIZED;
            n11 = camera2CameraImpl$InternalState.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState;
            camera2CameraImpl$InternalState = Camera2CameraImpl$InternalState.PENDING_OPEN;
            n11 = camera2CameraImpl$InternalState.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState;
            camera2CameraImpl$InternalState = Camera2CameraImpl$InternalState.CLOSING;
            n11 = camera2CameraImpl$InternalState.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState;
            camera2CameraImpl$InternalState = Camera2CameraImpl$InternalState.OPENED;
            n11 = camera2CameraImpl$InternalState.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState;
            camera2CameraImpl$InternalState = Camera2CameraImpl$InternalState.OPENING;
            n11 = camera2CameraImpl$InternalState.ordinal();
            nArray[n11] = n10 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState;
            camera2CameraImpl$InternalState = Camera2CameraImpl$InternalState.REOPENING;
            n11 = camera2CameraImpl$InternalState.ordinal();
            nArray[n11] = n10 = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState;
            camera2CameraImpl$InternalState = Camera2CameraImpl$InternalState.RELEASING;
            n11 = camera2CameraImpl$InternalState.ordinal();
            nArray[n11] = n10 = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState;
            camera2CameraImpl$InternalState = Camera2CameraImpl$InternalState.RELEASED;
            n11 = camera2CameraImpl$InternalState.ordinal();
            nArray[n11] = n10 = 8;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

