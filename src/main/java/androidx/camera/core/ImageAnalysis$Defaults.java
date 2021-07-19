/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Size
 */
package androidx.camera.core;

import android.util.Size;
import androidx.camera.core.ImageAnalysis$Builder;
import androidx.camera.core.impl.ConfigProvider;
import androidx.camera.core.impl.ImageAnalysisConfig;

public final class ImageAnalysis$Defaults
implements ConfigProvider {
    private static final int DEFAULT_ASPECT_RATIO = 0;
    private static final ImageAnalysisConfig DEFAULT_CONFIG;
    private static final Size DEFAULT_MAX_RESOLUTION;
    private static final int DEFAULT_SURFACE_OCCUPANCY_PRIORITY = 1;
    private static final Size DEFAULT_TARGET_RESOLUTION;

    static {
        Size size;
        Size size2;
        DEFAULT_TARGET_RESOLUTION = size2 = new Size(640, 480);
        DEFAULT_MAX_RESOLUTION = size = new Size(1920, 1080);
        ImageAnalysis$Builder imageAnalysis$Builder = new ImageAnalysis$Builder();
        DEFAULT_CONFIG = imageAnalysis$Builder.setDefaultResolution(size2).setMaxResolution(size).setSurfaceOccupancyPriority(1).setTargetAspectRatio(0).getUseCaseConfig();
    }

    public ImageAnalysisConfig getConfig() {
        return DEFAULT_CONFIG;
    }
}

