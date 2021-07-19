/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.CameraCaptureMetaData$AeState;
import androidx.camera.core.impl.CameraCaptureMetaData$AfMode;
import androidx.camera.core.impl.CameraCaptureMetaData$AfState;
import androidx.camera.core.impl.CameraCaptureMetaData$AwbState;
import androidx.camera.core.impl.CameraCaptureMetaData$FlashState;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.TagBundle;

public final class CameraCaptureResult$EmptyCameraCaptureResult
implements CameraCaptureResult {
    public static CameraCaptureResult create() {
        CameraCaptureResult$EmptyCameraCaptureResult cameraCaptureResult$EmptyCameraCaptureResult = new CameraCaptureResult$EmptyCameraCaptureResult();
        return cameraCaptureResult$EmptyCameraCaptureResult;
    }

    public CameraCaptureMetaData$AeState getAeState() {
        return CameraCaptureMetaData$AeState.UNKNOWN;
    }

    public CameraCaptureMetaData$AfMode getAfMode() {
        return CameraCaptureMetaData$AfMode.UNKNOWN;
    }

    public CameraCaptureMetaData$AfState getAfState() {
        return CameraCaptureMetaData$AfState.UNKNOWN;
    }

    public CameraCaptureMetaData$AwbState getAwbState() {
        return CameraCaptureMetaData$AwbState.UNKNOWN;
    }

    public CameraCaptureMetaData$FlashState getFlashState() {
        return CameraCaptureMetaData$FlashState.UNKNOWN;
    }

    public TagBundle getTagBundle() {
        return TagBundle.emptyBundle();
    }

    public long getTimestamp() {
        return -1;
    }
}

