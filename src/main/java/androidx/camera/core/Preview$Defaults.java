/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.Preview$Builder;
import androidx.camera.core.impl.ConfigProvider;
import androidx.camera.core.impl.PreviewConfig;

public final class Preview$Defaults
implements ConfigProvider {
    private static final int DEFAULT_ASPECT_RATIO = 0;
    private static final PreviewConfig DEFAULT_CONFIG;
    private static final int DEFAULT_SURFACE_OCCUPANCY_PRIORITY = 2;

    static {
        Preview$Builder preview$Builder = new Preview$Builder();
        DEFAULT_CONFIG = preview$Builder.setSurfaceOccupancyPriority(2).setTargetAspectRatio(0).getUseCaseConfig();
    }

    public PreviewConfig getConfig() {
        return DEFAULT_CONFIG;
    }
}

