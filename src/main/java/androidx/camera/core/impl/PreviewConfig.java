/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.CaptureProcessor;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Config$Option;
import androidx.camera.core.impl.ImageInfoProcessor;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.internal.ThreadConfig;

public final class PreviewConfig
implements UseCaseConfig,
ImageOutputConfig,
ThreadConfig {
    public static final Config$Option IMAGE_INFO_PROCESSOR = Config$Option.create("camerax.core.preview.imageInfoProcessor", ImageInfoProcessor.class);
    public static final Config$Option OPTION_PREVIEW_CAPTURE_PROCESSOR = Config$Option.create("camerax.core.preview.captureProcessor", CaptureProcessor.class);
    private final OptionsBundle mConfig;

    public PreviewConfig(OptionsBundle optionsBundle) {
        this.mConfig = optionsBundle;
    }

    public CaptureProcessor getCaptureProcessor() {
        Config$Option config$Option = OPTION_PREVIEW_CAPTURE_PROCESSOR;
        return (CaptureProcessor)this.retrieveOption(config$Option);
    }

    public CaptureProcessor getCaptureProcessor(CaptureProcessor captureProcessor) {
        Config$Option config$Option = OPTION_PREVIEW_CAPTURE_PROCESSOR;
        return (CaptureProcessor)this.retrieveOption(config$Option, captureProcessor);
    }

    public Config getConfig() {
        return this.mConfig;
    }

    public ImageInfoProcessor getImageInfoProcessor() {
        Config$Option config$Option = IMAGE_INFO_PROCESSOR;
        return (ImageInfoProcessor)this.retrieveOption(config$Option);
    }

    public ImageInfoProcessor getImageInfoProcessor(ImageInfoProcessor imageInfoProcessor) {
        Config$Option config$Option = IMAGE_INFO_PROCESSOR;
        return (ImageInfoProcessor)this.retrieveOption(config$Option, imageInfoProcessor);
    }

    public int getInputFormat() {
        Config$Option config$Option = ImageInputConfig.OPTION_INPUT_FORMAT;
        return (Integer)this.retrieveOption(config$Option);
    }
}

