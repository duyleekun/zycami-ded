/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraConfigs$EmptyCameraConfig;

public class CameraConfigs {
    private static final CameraConfig EMPTY_CONFIG;

    static {
        CameraConfigs$EmptyCameraConfig cameraConfigs$EmptyCameraConfig = new CameraConfigs$EmptyCameraConfig();
        EMPTY_CONFIG = cameraConfigs$EmptyCameraConfig;
    }

    private CameraConfigs() {
    }

    public static CameraConfig emptyConfig() {
        return EMPTY_CONFIG;
    }
}

