/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.CameraSelector;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.CaptureConfig$OptionUnpacker;
import androidx.camera.core.impl.Config$Option;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionConfig$OptionUnpacker;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.UseCaseEventConfig;
import androidx.core.util.Consumer;

public interface UseCaseConfig
extends TargetConfig,
UseCaseEventConfig,
ImageInputConfig {
    public static final Config$Option OPTION_ATTACHED_USE_CASES_UPDATE_LISTENER;
    public static final Config$Option OPTION_CAMERA_SELECTOR;
    public static final Config$Option OPTION_CAPTURE_CONFIG_UNPACKER;
    public static final Config$Option OPTION_DEFAULT_CAPTURE_CONFIG;
    public static final Config$Option OPTION_DEFAULT_SESSION_CONFIG;
    public static final Config$Option OPTION_SESSION_CONFIG_UNPACKER;
    public static final Config$Option OPTION_SURFACE_OCCUPANCY_PRIORITY;

    static {
        OPTION_DEFAULT_SESSION_CONFIG = Config$Option.create("camerax.core.useCase.defaultSessionConfig", SessionConfig.class);
        OPTION_DEFAULT_CAPTURE_CONFIG = Config$Option.create("camerax.core.useCase.defaultCaptureConfig", CaptureConfig.class);
        OPTION_SESSION_CONFIG_UNPACKER = Config$Option.create("camerax.core.useCase.sessionConfigUnpacker", SessionConfig$OptionUnpacker.class);
        OPTION_CAPTURE_CONFIG_UNPACKER = Config$Option.create("camerax.core.useCase.captureConfigUnpacker", CaptureConfig$OptionUnpacker.class);
        Class<Integer> clazz = Integer.TYPE;
        OPTION_SURFACE_OCCUPANCY_PRIORITY = Config$Option.create("camerax.core.useCase.surfaceOccupancyPriority", clazz);
        OPTION_CAMERA_SELECTOR = Config$Option.create("camerax.core.useCase.cameraSelector", CameraSelector.class);
        OPTION_ATTACHED_USE_CASES_UPDATE_LISTENER = Config$Option.create("camerax.core.useCase.attachedUseCasesUpdateListener", Consumer.class);
    }

    default public Consumer getAttachedUseCasesUpdateListener() {
        Config$Option config$Option = OPTION_ATTACHED_USE_CASES_UPDATE_LISTENER;
        return (Consumer)this.retrieveOption(config$Option);
    }

    default public Consumer getAttachedUseCasesUpdateListener(Consumer consumer) {
        Config$Option config$Option = OPTION_ATTACHED_USE_CASES_UPDATE_LISTENER;
        return (Consumer)this.retrieveOption(config$Option, consumer);
    }

    default public CameraSelector getCameraSelector() {
        Config$Option config$Option = OPTION_CAMERA_SELECTOR;
        return (CameraSelector)this.retrieveOption(config$Option);
    }

    default public CameraSelector getCameraSelector(CameraSelector cameraSelector) {
        Config$Option config$Option = OPTION_CAMERA_SELECTOR;
        return (CameraSelector)this.retrieveOption(config$Option, cameraSelector);
    }

    default public CaptureConfig$OptionUnpacker getCaptureOptionUnpacker() {
        Config$Option config$Option = OPTION_CAPTURE_CONFIG_UNPACKER;
        return (CaptureConfig$OptionUnpacker)this.retrieveOption(config$Option);
    }

    default public CaptureConfig$OptionUnpacker getCaptureOptionUnpacker(CaptureConfig$OptionUnpacker captureConfig$OptionUnpacker) {
        Config$Option config$Option = OPTION_CAPTURE_CONFIG_UNPACKER;
        return (CaptureConfig$OptionUnpacker)this.retrieveOption(config$Option, captureConfig$OptionUnpacker);
    }

    default public CaptureConfig getDefaultCaptureConfig() {
        Config$Option config$Option = OPTION_DEFAULT_CAPTURE_CONFIG;
        return (CaptureConfig)this.retrieveOption(config$Option);
    }

    default public CaptureConfig getDefaultCaptureConfig(CaptureConfig captureConfig) {
        Config$Option config$Option = OPTION_DEFAULT_CAPTURE_CONFIG;
        return (CaptureConfig)this.retrieveOption(config$Option, captureConfig);
    }

    default public SessionConfig getDefaultSessionConfig() {
        Config$Option config$Option = OPTION_DEFAULT_SESSION_CONFIG;
        return (SessionConfig)this.retrieveOption(config$Option);
    }

    default public SessionConfig getDefaultSessionConfig(SessionConfig sessionConfig) {
        Config$Option config$Option = OPTION_DEFAULT_SESSION_CONFIG;
        return (SessionConfig)this.retrieveOption(config$Option, sessionConfig);
    }

    default public SessionConfig$OptionUnpacker getSessionOptionUnpacker() {
        Config$Option config$Option = OPTION_SESSION_CONFIG_UNPACKER;
        return (SessionConfig$OptionUnpacker)this.retrieveOption(config$Option);
    }

    default public SessionConfig$OptionUnpacker getSessionOptionUnpacker(SessionConfig$OptionUnpacker sessionConfig$OptionUnpacker) {
        Config$Option config$Option = OPTION_SESSION_CONFIG_UNPACKER;
        return (SessionConfig$OptionUnpacker)this.retrieveOption(config$Option, sessionConfig$OptionUnpacker);
    }

    default public int getSurfaceOccupancyPriority() {
        Config$Option config$Option = OPTION_SURFACE_OCCUPANCY_PRIORITY;
        return (Integer)this.retrieveOption(config$Option);
    }

    default public int getSurfaceOccupancyPriority(int n10) {
        Config$Option config$Option = OPTION_SURFACE_OCCUPANCY_PRIORITY;
        Integer n11 = n10;
        return (Integer)this.retrieveOption(config$Option, n11);
    }
}

