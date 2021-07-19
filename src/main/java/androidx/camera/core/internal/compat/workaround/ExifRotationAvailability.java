/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.internal.compat.workaround;

import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config$Option;
import androidx.camera.core.internal.compat.quirk.DeviceQuirks;
import androidx.camera.core.internal.compat.quirk.ImageCaptureRotationOptionQuirk;

public class ExifRotationAvailability {
    public boolean isRotationOptionSupported() {
        boolean bl2;
        ImageCaptureRotationOptionQuirk imageCaptureRotationOptionQuirk = (ImageCaptureRotationOptionQuirk)DeviceQuirks.get(ImageCaptureRotationOptionQuirk.class);
        if (imageCaptureRotationOptionQuirk != null) {
            Config$Option config$Option = CaptureConfig.OPTION_ROTATION;
            bl2 = imageCaptureRotationOptionQuirk.isSupported(config$Option);
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public boolean shouldUseExifOrientation(ImageProxy imageProxy) {
        boolean bl2;
        Config$Option config$Option;
        boolean bl3;
        ImageCaptureRotationOptionQuirk imageCaptureRotationOptionQuirk = (ImageCaptureRotationOptionQuirk)DeviceQuirks.get(ImageCaptureRotationOptionQuirk.class);
        if ((imageCaptureRotationOptionQuirk == null || (bl3 = (boolean)imageCaptureRotationOptionQuirk.isSupported(config$Option = CaptureConfig.OPTION_ROTATION))) && (bl2 = imageProxy.getFormat()) == (bl3 = 256 != 0)) {
            bl2 = true;
        } else {
            bl2 = false;
            imageProxy = null;
        }
        return bl2;
    }
}

