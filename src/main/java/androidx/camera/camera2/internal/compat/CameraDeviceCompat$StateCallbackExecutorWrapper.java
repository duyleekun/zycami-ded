/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraDevice
 *  android.hardware.camera2.CameraDevice$StateCallback
 */
package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraDevice;
import androidx.camera.camera2.internal.compat.CameraDeviceCompat$StateCallbackExecutorWrapper$1;
import androidx.camera.camera2.internal.compat.CameraDeviceCompat$StateCallbackExecutorWrapper$2;
import androidx.camera.camera2.internal.compat.CameraDeviceCompat$StateCallbackExecutorWrapper$3;
import androidx.camera.camera2.internal.compat.CameraDeviceCompat$StateCallbackExecutorWrapper$4;
import java.util.concurrent.Executor;

public final class CameraDeviceCompat$StateCallbackExecutorWrapper
extends CameraDevice.StateCallback {
    private final Executor mExecutor;
    public final CameraDevice.StateCallback mWrappedCallback;

    public CameraDeviceCompat$StateCallbackExecutorWrapper(Executor executor, CameraDevice.StateCallback stateCallback) {
        this.mExecutor = executor;
        this.mWrappedCallback = stateCallback;
    }

    public void onClosed(CameraDevice cameraDevice) {
        Executor executor = this.mExecutor;
        CameraDeviceCompat$StateCallbackExecutorWrapper$4 cameraDeviceCompat$StateCallbackExecutorWrapper$4 = new CameraDeviceCompat$StateCallbackExecutorWrapper$4(this, cameraDevice);
        executor.execute(cameraDeviceCompat$StateCallbackExecutorWrapper$4);
    }

    public void onDisconnected(CameraDevice cameraDevice) {
        Executor executor = this.mExecutor;
        CameraDeviceCompat$StateCallbackExecutorWrapper$2 cameraDeviceCompat$StateCallbackExecutorWrapper$2 = new CameraDeviceCompat$StateCallbackExecutorWrapper$2(this, cameraDevice);
        executor.execute(cameraDeviceCompat$StateCallbackExecutorWrapper$2);
    }

    public void onError(CameraDevice cameraDevice, int n10) {
        Executor executor = this.mExecutor;
        CameraDeviceCompat$StateCallbackExecutorWrapper$3 cameraDeviceCompat$StateCallbackExecutorWrapper$3 = new CameraDeviceCompat$StateCallbackExecutorWrapper$3(this, cameraDevice, n10);
        executor.execute(cameraDeviceCompat$StateCallbackExecutorWrapper$3);
    }

    public void onOpened(CameraDevice cameraDevice) {
        Executor executor = this.mExecutor;
        CameraDeviceCompat$StateCallbackExecutorWrapper$1 cameraDeviceCompat$StateCallbackExecutorWrapper$1 = new CameraDeviceCompat$StateCallbackExecutorWrapper$1(this, cameraDevice);
        executor.execute(cameraDeviceCompat$StateCallbackExecutorWrapper$1);
    }
}

