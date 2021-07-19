/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  com.huawei.camerakit.api.CameraDeviceCallback
 */
package com.huawei.camera.camerakit;

import com.huawei.camera.camerakit.CameraDeviceCallback;
import com.huawei.camera.camerakit.CameraDeviceCallback$1;

public class CameraDeviceCallback$CameraDeviceCallbackWrapper
extends com.huawei.camerakit.api.CameraDeviceCallback {
    private CameraDeviceCallback cameraDeviceCallback;

    private CameraDeviceCallback$CameraDeviceCallbackWrapper(CameraDeviceCallback cameraDeviceCallback) {
        this.cameraDeviceCallback = cameraDeviceCallback;
    }

    public /* synthetic */ CameraDeviceCallback$CameraDeviceCallbackWrapper(CameraDeviceCallback cameraDeviceCallback, CameraDeviceCallback$1 cameraDeviceCallback$1) {
        this(cameraDeviceCallback);
    }

    public void onCameraAccessPrioritiesChanged(String string2) {
        this.cameraDeviceCallback.onCameraAccessPrioritiesChanged(string2);
    }

    public void onCameraAvailable(String string2) {
        this.cameraDeviceCallback.onCameraAvailable(string2);
    }

    public void onCameraUnavailable(String string2) {
        this.cameraDeviceCallback.onCameraUnavailable(string2);
    }

    public void onTorchModeChanged(String string2, boolean bl2) {
        this.cameraDeviceCallback.onTorchModeChanged(string2, bl2);
    }

    public void onTorchModeUnavailable(String string2) {
        this.cameraDeviceCallback.onTorchModeUnavailable(string2);
    }
}

