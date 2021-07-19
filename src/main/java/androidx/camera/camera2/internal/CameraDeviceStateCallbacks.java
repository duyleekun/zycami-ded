/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraDevice$StateCallback
 */
package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import androidx.camera.camera2.internal.CameraDeviceStateCallbacks$ComboDeviceStateCallback;
import androidx.camera.camera2.internal.CameraDeviceStateCallbacks$NoOpDeviceStateCallback;
import java.util.Arrays;
import java.util.List;

public final class CameraDeviceStateCallbacks {
    private CameraDeviceStateCallbacks() {
    }

    public static CameraDevice.StateCallback createComboCallback(List list) {
        int n10;
        int n11 = list.isEmpty();
        if (n11 != 0) {
            return CameraDeviceStateCallbacks.createNoOpCallback();
        }
        n11 = list.size();
        if (n11 == (n10 = 1)) {
            return (CameraDevice.StateCallback)list.get(0);
        }
        CameraDeviceStateCallbacks$ComboDeviceStateCallback cameraDeviceStateCallbacks$ComboDeviceStateCallback = new CameraDeviceStateCallbacks$ComboDeviceStateCallback(list);
        return cameraDeviceStateCallbacks$ComboDeviceStateCallback;
    }

    public static CameraDevice.StateCallback createComboCallback(CameraDevice.StateCallback ... stateCallbackArray) {
        return CameraDeviceStateCallbacks.createComboCallback(Arrays.asList(stateCallbackArray));
    }

    public static CameraDevice.StateCallback createNoOpCallback() {
        CameraDeviceStateCallbacks$NoOpDeviceStateCallback cameraDeviceStateCallbacks$NoOpDeviceStateCallback = new CameraDeviceStateCallbacks$NoOpDeviceStateCallback();
        return cameraDeviceStateCallbacks$NoOpDeviceStateCallback;
    }
}

