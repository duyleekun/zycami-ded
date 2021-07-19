/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CameraCaptureResult;

public abstract class CameraCaptureCallback {
    public void onCaptureCancelled() {
    }

    public void onCaptureCompleted(CameraCaptureResult cameraCaptureResult) {
    }

    public void onCaptureFailed(CameraCaptureFailure cameraCaptureFailure) {
    }
}

