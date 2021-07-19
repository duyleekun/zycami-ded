/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraDevice
 *  android.hardware.camera2.CameraDevice$StateCallback
 */
package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import androidx.camera.camera2.internal.CameraDeviceStateCallbacks$NoOpDeviceStateCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class CameraDeviceStateCallbacks$ComboDeviceStateCallback
extends CameraDevice.StateCallback {
    private final List mCallbacks;

    public CameraDeviceStateCallbacks$ComboDeviceStateCallback(List object) {
        boolean bl2;
        CameraDevice.StateCallback stateCallback;
        this.mCallbacks = stateCallback = new ArrayList();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            stateCallback = (CameraDevice.StateCallback)object.next();
            boolean bl3 = stateCallback instanceof CameraDeviceStateCallbacks.NoOpDeviceStateCallback;
            if (bl3) continue;
            List list = this.mCallbacks;
            list.add(stateCallback);
        }
    }

    public void onClosed(CameraDevice cameraDevice) {
        boolean bl2;
        Iterator iterator2 = this.mCallbacks.iterator();
        while (bl2 = iterator2.hasNext()) {
            CameraDevice.StateCallback stateCallback = (CameraDevice.StateCallback)iterator2.next();
            stateCallback.onClosed(cameraDevice);
        }
    }

    public void onDisconnected(CameraDevice cameraDevice) {
        boolean bl2;
        Iterator iterator2 = this.mCallbacks.iterator();
        while (bl2 = iterator2.hasNext()) {
            CameraDevice.StateCallback stateCallback = (CameraDevice.StateCallback)iterator2.next();
            stateCallback.onDisconnected(cameraDevice);
        }
    }

    public void onError(CameraDevice cameraDevice, int n10) {
        boolean bl2;
        Iterator iterator2 = this.mCallbacks.iterator();
        while (bl2 = iterator2.hasNext()) {
            CameraDevice.StateCallback stateCallback = (CameraDevice.StateCallback)iterator2.next();
            stateCallback.onError(cameraDevice, n10);
        }
    }

    public void onOpened(CameraDevice cameraDevice) {
        boolean bl2;
        Iterator iterator2 = this.mCallbacks.iterator();
        while (bl2 = iterator2.hasNext()) {
            CameraDevice.StateCallback stateCallback = (CameraDevice.StateCallback)iterator2.next();
            stateCallback.onOpened(cameraDevice);
        }
    }
}

