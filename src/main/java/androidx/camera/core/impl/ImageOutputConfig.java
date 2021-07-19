/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Size
 */
package androidx.camera.core.impl;

import android.util.Size;
import androidx.camera.core.AspectRatio;
import androidx.camera.core.impl.Config$Option;
import androidx.camera.core.impl.ReadableConfig;
import java.util.List;

public interface ImageOutputConfig
extends ReadableConfig {
    public static final int INVALID_ROTATION = 255;
    public static final Config$Option OPTION_DEFAULT_RESOLUTION;
    public static final Config$Option OPTION_MAX_RESOLUTION;
    public static final Config$Option OPTION_SUPPORTED_RESOLUTIONS;
    public static final Config$Option OPTION_TARGET_ASPECT_RATIO;
    public static final Config$Option OPTION_TARGET_RESOLUTION;
    public static final Config$Option OPTION_TARGET_ROTATION;

    static {
        OPTION_TARGET_ASPECT_RATIO = Config$Option.create("camerax.core.imageOutput.targetAspectRatio", AspectRatio.class);
        Class<Integer> clazz = Integer.TYPE;
        OPTION_TARGET_ROTATION = Config$Option.create("camerax.core.imageOutput.targetRotation", clazz);
        OPTION_TARGET_RESOLUTION = Config$Option.create("camerax.core.imageOutput.targetResolution", Size.class);
        OPTION_DEFAULT_RESOLUTION = Config$Option.create("camerax.core.imageOutput.defaultResolution", Size.class);
        OPTION_MAX_RESOLUTION = Config$Option.create("camerax.core.imageOutput.maxResolution", Size.class);
        OPTION_SUPPORTED_RESOLUTIONS = Config$Option.create("camerax.core.imageOutput.supportedResolutions", List.class);
    }

    default public Size getDefaultResolution() {
        Config$Option config$Option = OPTION_DEFAULT_RESOLUTION;
        return (Size)this.retrieveOption(config$Option);
    }

    default public Size getDefaultResolution(Size size) {
        Config$Option config$Option = OPTION_DEFAULT_RESOLUTION;
        return (Size)this.retrieveOption(config$Option, size);
    }

    default public Size getMaxResolution() {
        Config$Option config$Option = OPTION_MAX_RESOLUTION;
        return (Size)this.retrieveOption(config$Option);
    }

    default public Size getMaxResolution(Size size) {
        Config$Option config$Option = OPTION_MAX_RESOLUTION;
        return (Size)this.retrieveOption(config$Option, size);
    }

    default public List getSupportedResolutions() {
        Config$Option config$Option = OPTION_SUPPORTED_RESOLUTIONS;
        return (List)this.retrieveOption(config$Option);
    }

    default public List getSupportedResolutions(List list) {
        Config$Option config$Option = OPTION_SUPPORTED_RESOLUTIONS;
        return (List)this.retrieveOption(config$Option, list);
    }

    default public int getTargetAspectRatio() {
        Config$Option config$Option = OPTION_TARGET_ASPECT_RATIO;
        return (Integer)this.retrieveOption(config$Option);
    }

    default public Size getTargetResolution() {
        Config$Option config$Option = OPTION_TARGET_RESOLUTION;
        return (Size)this.retrieveOption(config$Option);
    }

    default public Size getTargetResolution(Size size) {
        Config$Option config$Option = OPTION_TARGET_RESOLUTION;
        return (Size)this.retrieveOption(config$Option, size);
    }

    default public int getTargetRotation() {
        Config$Option config$Option = OPTION_TARGET_ROTATION;
        return (Integer)this.retrieveOption(config$Option);
    }

    default public int getTargetRotation(int n10) {
        Config$Option config$Option = OPTION_TARGET_ROTATION;
        Integer n11 = n10;
        return (Integer)this.retrieveOption(config$Option, n11);
    }

    default public boolean hasTargetAspectRatio() {
        Config$Option config$Option = OPTION_TARGET_ASPECT_RATIO;
        return this.containsOption(config$Option);
    }
}

