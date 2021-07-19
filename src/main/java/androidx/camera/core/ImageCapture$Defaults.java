/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.ImageCapture$Builder;
import androidx.camera.core.impl.ConfigProvider;
import androidx.camera.core.impl.ImageCaptureConfig;

public final class ImageCapture$Defaults
implements ConfigProvider {
    private static final int DEFAULT_ASPECT_RATIO = 0;
    private static final ImageCaptureConfig DEFAULT_CONFIG;
    private static final int DEFAULT_SURFACE_OCCUPANCY_PRIORITY = 4;

    static {
        ImageCapture$Builder imageCapture$Builder = new ImageCapture$Builder();
        DEFAULT_CONFIG = imageCapture$Builder.setSurfaceOccupancyPriority(4).setTargetAspectRatio(0).getUseCaseConfig();
    }

    public ImageCaptureConfig getConfig() {
        return DEFAULT_CONFIG;
    }
}

