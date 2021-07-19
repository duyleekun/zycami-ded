/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.CaptureSession$State;

public class CaptureSession$3 {
    public static final /* synthetic */ int[] $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        CaptureSession$State captureSession$State;
        int n12 = CaptureSession$State.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State = nArray;
        try {
            captureSession$State = CaptureSession$State.UNINITIALIZED;
            n11 = captureSession$State.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State;
            captureSession$State = CaptureSession$State.INITIALIZED;
            n11 = captureSession$State.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State;
            captureSession$State = CaptureSession$State.GET_SURFACE;
            n11 = captureSession$State.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State;
            captureSession$State = CaptureSession$State.OPENING;
            n11 = captureSession$State.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State;
            captureSession$State = CaptureSession$State.OPENED;
            n11 = captureSession$State.ordinal();
            nArray[n11] = n10 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State;
            captureSession$State = CaptureSession$State.CLOSED;
            n11 = captureSession$State.ordinal();
            nArray[n11] = n10 = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State;
            captureSession$State = CaptureSession$State.RELEASING;
            n11 = captureSession$State.ordinal();
            nArray[n11] = n10 = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State;
            captureSession$State = CaptureSession$State.RELEASED;
            n11 = captureSession$State.ordinal();
            nArray[n11] = n10 = 8;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

