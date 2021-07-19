/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package androidx.camera.core;

import android.os.Handler;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.impl.CameraDeviceSurfaceManager$Provider;
import androidx.camera.core.impl.CameraFactory$Provider;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Config$Option;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.UseCaseConfigFactory$Provider;
import androidx.camera.core.internal.TargetConfig;
import java.util.concurrent.Executor;

public final class CameraXConfig
implements TargetConfig {
    public static final Config$Option OPTION_AVAILABLE_CAMERAS_LIMITER;
    public static final Config$Option OPTION_CAMERA_EXECUTOR;
    public static final Config$Option OPTION_CAMERA_FACTORY_PROVIDER;
    public static final Config$Option OPTION_DEVICE_SURFACE_MANAGER_PROVIDER;
    public static final Config$Option OPTION_MIN_LOGGING_LEVEL;
    public static final Config$Option OPTION_SCHEDULER_HANDLER;
    public static final Config$Option OPTION_USECASE_CONFIG_FACTORY_PROVIDER;
    private final OptionsBundle mConfig;

    static {
        OPTION_CAMERA_FACTORY_PROVIDER = Config$Option.create("camerax.core.appConfig.cameraFactoryProvider", CameraFactory$Provider.class);
        OPTION_DEVICE_SURFACE_MANAGER_PROVIDER = Config$Option.create("camerax.core.appConfig.deviceSurfaceManagerProvider", CameraDeviceSurfaceManager$Provider.class);
        OPTION_USECASE_CONFIG_FACTORY_PROVIDER = Config$Option.create("camerax.core.appConfig.useCaseConfigFactoryProvider", UseCaseConfigFactory$Provider.class);
        OPTION_CAMERA_EXECUTOR = Config$Option.create("camerax.core.appConfig.cameraExecutor", Executor.class);
        OPTION_SCHEDULER_HANDLER = Config$Option.create("camerax.core.appConfig.schedulerHandler", Handler.class);
        Class<Integer> clazz = Integer.TYPE;
        OPTION_MIN_LOGGING_LEVEL = Config$Option.create("camerax.core.appConfig.minimumLoggingLevel", clazz);
        OPTION_AVAILABLE_CAMERAS_LIMITER = Config$Option.create("camerax.core.appConfig.availableCamerasLimiter", CameraSelector.class);
    }

    public CameraXConfig(OptionsBundle optionsBundle) {
        this.mConfig = optionsBundle;
    }

    public CameraSelector getAvailableCamerasLimiter(CameraSelector cameraSelector) {
        OptionsBundle optionsBundle = this.mConfig;
        Config$Option config$Option = OPTION_AVAILABLE_CAMERAS_LIMITER;
        return (CameraSelector)optionsBundle.retrieveOption(config$Option, cameraSelector);
    }

    public Executor getCameraExecutor(Executor executor) {
        OptionsBundle optionsBundle = this.mConfig;
        Config$Option config$Option = OPTION_CAMERA_EXECUTOR;
        return (Executor)optionsBundle.retrieveOption(config$Option, executor);
    }

    public CameraFactory$Provider getCameraFactoryProvider(CameraFactory$Provider cameraFactory$Provider) {
        OptionsBundle optionsBundle = this.mConfig;
        Config$Option config$Option = OPTION_CAMERA_FACTORY_PROVIDER;
        return (CameraFactory$Provider)optionsBundle.retrieveOption(config$Option, cameraFactory$Provider);
    }

    public Config getConfig() {
        return this.mConfig;
    }

    public CameraDeviceSurfaceManager$Provider getDeviceSurfaceManagerProvider(CameraDeviceSurfaceManager$Provider cameraDeviceSurfaceManager$Provider) {
        OptionsBundle optionsBundle = this.mConfig;
        Config$Option config$Option = OPTION_DEVICE_SURFACE_MANAGER_PROVIDER;
        return (CameraDeviceSurfaceManager$Provider)optionsBundle.retrieveOption(config$Option, cameraDeviceSurfaceManager$Provider);
    }

    public int getMinimumLoggingLevel() {
        OptionsBundle optionsBundle = this.mConfig;
        Config$Option config$Option = OPTION_MIN_LOGGING_LEVEL;
        Integer n10 = 3;
        return (Integer)optionsBundle.retrieveOption(config$Option, n10);
    }

    public Handler getSchedulerHandler(Handler handler) {
        OptionsBundle optionsBundle = this.mConfig;
        Config$Option config$Option = OPTION_SCHEDULER_HANDLER;
        return (Handler)optionsBundle.retrieveOption(config$Option, handler);
    }

    public UseCaseConfigFactory$Provider getUseCaseConfigFactoryProvider(UseCaseConfigFactory$Provider useCaseConfigFactory$Provider) {
        OptionsBundle optionsBundle = this.mConfig;
        Config$Option config$Option = OPTION_USECASE_CONFIG_FACTORY_PROVIDER;
        return (UseCaseConfigFactory$Provider)optionsBundle.retrieveOption(config$Option, useCaseConfigFactory$Provider);
    }
}

