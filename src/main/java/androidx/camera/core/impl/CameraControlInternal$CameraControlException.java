/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.CameraCaptureFailure;

public final class CameraControlInternal$CameraControlException
extends Exception {
    private CameraCaptureFailure mCameraCaptureFailure;

    public CameraControlInternal$CameraControlException(CameraCaptureFailure cameraCaptureFailure) {
        this.mCameraCaptureFailure = cameraCaptureFailure;
    }

    public CameraControlInternal$CameraControlException(CameraCaptureFailure cameraCaptureFailure, Throwable throwable) {
        super(throwable);
        this.mCameraCaptureFailure = cameraCaptureFailure;
    }

    public CameraCaptureFailure getCameraCaptureFailure() {
        return this.mCameraCaptureFailure;
    }
}

