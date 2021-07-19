/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraDevice
 *  android.hardware.camera2.CameraDevice$StateCallback
 */
package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraDevice;
import androidx.camera.camera2.internal.compat.CameraDeviceCompat$StateCallbackExecutorWrapper;

public class CameraDeviceCompat$StateCallbackExecutorWrapper$1
implements Runnable {
    public final /* synthetic */ CameraDeviceCompat$StateCallbackExecutorWrapper this$0;
    public final /* synthetic */ CameraDevice val$camera;

    public CameraDeviceCompat$StateCallbackExecutorWrapper$1(CameraDeviceCompat$StateCallbackExecutorWrapper stateCallbackExecutorWrapper, CameraDevice cameraDevice) {
        this.this$0 = stateCallbackExecutorWrapper;
        this.val$camera = cameraDevice;
    }

    public void run() {
        CameraDevice.StateCallback stateCallback = this.this$0.mWrappedCallback;
        CameraDevice cameraDevice = this.val$camera;
        stateCallback.onOpened(cameraDevice);
    }
}

