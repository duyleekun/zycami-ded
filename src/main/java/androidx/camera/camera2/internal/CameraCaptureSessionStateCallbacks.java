/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCaptureSession$StateCallback
 */
package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import androidx.camera.camera2.internal.CameraCaptureSessionStateCallbacks$ComboSessionStateCallback;
import androidx.camera.camera2.internal.CameraCaptureSessionStateCallbacks$NoOpSessionStateCallback;
import java.util.Arrays;
import java.util.List;

public final class CameraCaptureSessionStateCallbacks {
    private CameraCaptureSessionStateCallbacks() {
    }

    public static CameraCaptureSession.StateCallback createComboCallback(List list) {
        int n10;
        int n11 = list.isEmpty();
        if (n11 != 0) {
            return CameraCaptureSessionStateCallbacks.createNoOpCallback();
        }
        n11 = list.size();
        if (n11 == (n10 = 1)) {
            return (CameraCaptureSession.StateCallback)list.get(0);
        }
        CameraCaptureSessionStateCallbacks$ComboSessionStateCallback cameraCaptureSessionStateCallbacks$ComboSessionStateCallback = new CameraCaptureSessionStateCallbacks$ComboSessionStateCallback(list);
        return cameraCaptureSessionStateCallbacks$ComboSessionStateCallback;
    }

    public static CameraCaptureSession.StateCallback createComboCallback(CameraCaptureSession.StateCallback ... stateCallbackArray) {
        return CameraCaptureSessionStateCallbacks.createComboCallback(Arrays.asList(stateCallbackArray));
    }

    public static CameraCaptureSession.StateCallback createNoOpCallback() {
        CameraCaptureSessionStateCallbacks$NoOpSessionStateCallback cameraCaptureSessionStateCallbacks$NoOpSessionStateCallback = new CameraCaptureSessionStateCallbacks$NoOpSessionStateCallback();
        return cameraCaptureSessionStateCallbacks$NoOpSessionStateCallback;
    }
}

