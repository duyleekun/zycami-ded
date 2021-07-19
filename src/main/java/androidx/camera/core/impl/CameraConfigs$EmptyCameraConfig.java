/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraConfigs$EmptyCameraConfig$1;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.UseCaseConfigFactory;

public final class CameraConfigs$EmptyCameraConfig
implements CameraConfig {
    private final UseCaseConfigFactory mUseCaseConfigFactory;

    public CameraConfigs$EmptyCameraConfig() {
        CameraConfigs$EmptyCameraConfig$1 cameraConfigs$EmptyCameraConfig$1 = new CameraConfigs$EmptyCameraConfig$1(this);
        this.mUseCaseConfigFactory = cameraConfigs$EmptyCameraConfig$1;
    }

    public Config getConfig() {
        return OptionsBundle.emptyBundle();
    }

    public UseCaseConfigFactory getUseCaseConfigFactory() {
        return this.mUseCaseConfigFactory;
    }
}

