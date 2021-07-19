/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.CameraFilter;
import androidx.camera.core.impl.CameraFilters;
import androidx.camera.core.impl.Config$Option;
import androidx.camera.core.impl.ReadableConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;

public interface CameraConfig
extends ReadableConfig {
    public static final Config$Option OPTION_CAMERA_FILTER = Config$Option.create("camerax.core.camera.cameraFilter", CameraFilter.class);
    public static final Config$Option OPTION_USECASE_CONFIG_FACTORY = Config$Option.create("camerax.core.camera.useCaseConfigFactory", UseCaseConfigFactory.class);

    default public CameraFilter getCameraFilter() {
        Config$Option config$Option = OPTION_CAMERA_FILTER;
        CameraFilter cameraFilter = CameraFilters.ANY;
        return (CameraFilter)this.retrieveOption(config$Option, cameraFilter);
    }

    public UseCaseConfigFactory getUseCaseConfigFactory();
}

