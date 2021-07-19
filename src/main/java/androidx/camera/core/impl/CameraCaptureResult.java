/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.CameraCaptureMetaData$AeState;
import androidx.camera.core.impl.CameraCaptureMetaData$AfMode;
import androidx.camera.core.impl.CameraCaptureMetaData$AfState;
import androidx.camera.core.impl.CameraCaptureMetaData$AwbState;
import androidx.camera.core.impl.CameraCaptureMetaData$FlashState;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.ExifData$Builder;

public interface CameraCaptureResult {
    public CameraCaptureMetaData$AeState getAeState();

    public CameraCaptureMetaData$AfMode getAfMode();

    public CameraCaptureMetaData$AfState getAfState();

    public CameraCaptureMetaData$AwbState getAwbState();

    public CameraCaptureMetaData$FlashState getFlashState();

    public TagBundle getTagBundle();

    public long getTimestamp();

    default public void populateExifData(ExifData$Builder exifData$Builder) {
        CameraCaptureMetaData$FlashState cameraCaptureMetaData$FlashState = this.getFlashState();
        exifData$Builder.setFlashState(cameraCaptureMetaData$FlashState);
    }
}

