/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.camera2.internal;

import androidx.camera.camera2.impl.Camera2ImplConfig$Builder;
import androidx.camera.camera2.internal.Camera2CaptureOptionUnpacker;
import androidx.camera.camera2.internal.compat.workaround.ImageCapturePixelHDRPlus;
import androidx.camera.core.impl.CaptureConfig$Builder;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.UseCaseConfig;

public final class ImageCaptureOptionUnpacker
extends Camera2CaptureOptionUnpacker {
    public static final ImageCaptureOptionUnpacker INSTANCE;
    private final ImageCapturePixelHDRPlus mImageCapturePixelHDRPlus;

    static {
        ImageCaptureOptionUnpacker imageCaptureOptionUnpacker;
        ImageCapturePixelHDRPlus imageCapturePixelHDRPlus = new ImageCapturePixelHDRPlus();
        INSTANCE = imageCaptureOptionUnpacker = new ImageCaptureOptionUnpacker(imageCapturePixelHDRPlus);
    }

    private ImageCaptureOptionUnpacker(ImageCapturePixelHDRPlus imageCapturePixelHDRPlus) {
        this.mImageCapturePixelHDRPlus = imageCapturePixelHDRPlus;
    }

    public void unpack(UseCaseConfig object, CaptureConfig$Builder captureConfig$Builder) {
        super.unpack((UseCaseConfig)object, captureConfig$Builder);
        boolean bl2 = object instanceof ImageCaptureConfig;
        if (bl2) {
            object = (ImageCaptureConfig)object;
            Camera2ImplConfig$Builder camera2ImplConfig$Builder = new Camera2ImplConfig$Builder();
            boolean bl3 = ((ImageCaptureConfig)object).hasCaptureMode();
            if (bl3) {
                ImageCapturePixelHDRPlus imageCapturePixelHDRPlus = this.mImageCapturePixelHDRPlus;
                int n10 = ((ImageCaptureConfig)object).getCaptureMode();
                imageCapturePixelHDRPlus.toggleHDRPlus(n10, camera2ImplConfig$Builder);
            }
            object = camera2ImplConfig$Builder.build();
            captureConfig$Builder.addImplementationOptions((Config)object);
            return;
        }
        object = new IllegalArgumentException("config is not ImageCaptureConfig");
        throw object;
    }
}

