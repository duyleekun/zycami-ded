/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CaptureResult
 */
package androidx.camera.camera2.impl;

import android.hardware.camera2.CaptureResult;
import androidx.camera.camera2.internal.Camera2CameraCaptureResult;
import androidx.camera.core.impl.CameraCaptureResult;

public final class Camera2CameraCaptureResultConverter {
    private Camera2CameraCaptureResultConverter() {
    }

    public static CaptureResult getCaptureResult(CameraCaptureResult cameraCaptureResult) {
        boolean bl2 = cameraCaptureResult instanceof Camera2CameraCaptureResult;
        if (bl2) {
            return ((Camera2CameraCaptureResult)cameraCaptureResult).getCaptureResult();
        }
        return null;
    }
}

