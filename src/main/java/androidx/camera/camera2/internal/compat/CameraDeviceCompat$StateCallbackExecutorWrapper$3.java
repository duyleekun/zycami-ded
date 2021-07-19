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

public class CameraDeviceCompat$StateCallbackExecutorWrapper$3
implements Runnable {
    public final /* synthetic */ CameraDeviceCompat$StateCallbackExecutorWrapper this$0;
    public final /* synthetic */ CameraDevice val$camera;
    public final /* synthetic */ int val$error;

    public CameraDeviceCompat$StateCallbackExecutorWrapper$3(CameraDeviceCompat$StateCallbackExecutorWrapper cameraDeviceCompat$StateCallbackExecutorWrapper, CameraDevice cameraDevice, int n10) {
        this.this$0 = cameraDeviceCompat$StateCallbackExecutorWrapper;
        this.val$camera = cameraDevice;
        this.val$error = n10;
    }

    public void run() {
        CameraDevice.StateCallback stateCallback = this.this$0.mWrappedCallback;
        CameraDevice cameraDevice = this.val$camera;
        int n10 = this.val$error;
        stateCallback.onError(cameraDevice, n10);
    }
}

