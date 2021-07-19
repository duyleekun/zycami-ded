/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraCaptureResult$EmptyCameraCaptureResult;

public final class ImageCapture$TakePictureState {
    public boolean mIsAePrecaptureTriggered;
    public boolean mIsAfTriggered;
    public CameraCaptureResult mPreCaptureState;

    public ImageCapture$TakePictureState() {
        CameraCaptureResult cameraCaptureResult;
        this.mPreCaptureState = cameraCaptureResult = CameraCaptureResult$EmptyCameraCaptureResult.create();
        this.mIsAfTriggered = false;
        this.mIsAePrecaptureTriggered = false;
    }
}

