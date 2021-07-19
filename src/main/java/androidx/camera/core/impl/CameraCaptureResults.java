/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.ImageInfo;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.internal.CameraCaptureResultImageInfo;

public final class CameraCaptureResults {
    private CameraCaptureResults() {
    }

    public static CameraCaptureResult retrieveCameraCaptureResult(ImageInfo imageInfo) {
        boolean bl2 = imageInfo instanceof CameraCaptureResultImageInfo;
        if (bl2) {
            return ((CameraCaptureResultImageInfo)imageInfo).getCameraCaptureResult();
        }
        return null;
    }
}

