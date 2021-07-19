/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.ImageReaderProxyProvider;
import androidx.camera.core.impl.CaptureBundle;
import androidx.camera.core.impl.CaptureProcessor;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Config$Option;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.internal.IoConfig;
import java.util.concurrent.Executor;

public final class ImageCaptureConfig
implements UseCaseConfig,
ImageOutputConfig,
IoConfig {
    public static final Config$Option OPTION_BUFFER_FORMAT;
    public static final Config$Option OPTION_CAPTURE_BUNDLE;
    public static final Config$Option OPTION_CAPTURE_PROCESSOR;
    public static final Config$Option OPTION_FLASH_MODE;
    public static final Config$Option OPTION_IMAGE_CAPTURE_MODE;
    public static final Config$Option OPTION_IMAGE_READER_PROXY_PROVIDER;
    public static final Config$Option OPTION_MAX_CAPTURE_STAGES;
    public static final Config$Option OPTION_USE_SOFTWARE_JPEG_ENCODER;
    private final OptionsBundle mConfig;

    static {
        Class clazz = Integer.class;
        Class<Integer> clazz2 = Integer.TYPE;
        OPTION_IMAGE_CAPTURE_MODE = Config$Option.create("camerax.core.imageCapture.captureMode", clazz2);
        OPTION_FLASH_MODE = Config$Option.create("camerax.core.imageCapture.flashMode", clazz2);
        OPTION_CAPTURE_BUNDLE = Config$Option.create("camerax.core.imageCapture.captureBundle", CaptureBundle.class);
        OPTION_CAPTURE_PROCESSOR = Config$Option.create("camerax.core.imageCapture.captureProcessor", CaptureProcessor.class);
        OPTION_BUFFER_FORMAT = Config$Option.create("camerax.core.imageCapture.bufferFormat", clazz);
        OPTION_MAX_CAPTURE_STAGES = Config$Option.create("camerax.core.imageCapture.maxCaptureStages", clazz);
        OPTION_IMAGE_READER_PROXY_PROVIDER = Config$Option.create("camerax.core.imageCapture.imageReaderProxyProvider", ImageReaderProxyProvider.class);
        clazz = Boolean.TYPE;
        OPTION_USE_SOFTWARE_JPEG_ENCODER = Config$Option.create("camerax.core.imageCapture.useSoftwareJpegEncoder", clazz);
    }

    public ImageCaptureConfig(OptionsBundle optionsBundle) {
        this.mConfig = optionsBundle;
    }

    public Integer getBufferFormat() {
        Config$Option config$Option = OPTION_BUFFER_FORMAT;
        return (Integer)this.retrieveOption(config$Option);
    }

    public Integer getBufferFormat(Integer n10) {
        Config$Option config$Option = OPTION_BUFFER_FORMAT;
        return (Integer)this.retrieveOption(config$Option, n10);
    }

    public CaptureBundle getCaptureBundle() {
        Config$Option config$Option = OPTION_CAPTURE_BUNDLE;
        return (CaptureBundle)this.retrieveOption(config$Option);
    }

    public CaptureBundle getCaptureBundle(CaptureBundle captureBundle) {
        Config$Option config$Option = OPTION_CAPTURE_BUNDLE;
        return (CaptureBundle)this.retrieveOption(config$Option, captureBundle);
    }

    public int getCaptureMode() {
        Config$Option config$Option = OPTION_IMAGE_CAPTURE_MODE;
        return (Integer)this.retrieveOption(config$Option);
    }

    public CaptureProcessor getCaptureProcessor() {
        Config$Option config$Option = OPTION_CAPTURE_PROCESSOR;
        return (CaptureProcessor)this.retrieveOption(config$Option);
    }

    public CaptureProcessor getCaptureProcessor(CaptureProcessor captureProcessor) {
        Config$Option config$Option = OPTION_CAPTURE_PROCESSOR;
        return (CaptureProcessor)this.retrieveOption(config$Option, captureProcessor);
    }

    public Config getConfig() {
        return this.mConfig;
    }

    public int getFlashMode() {
        Config$Option config$Option = OPTION_FLASH_MODE;
        return (Integer)this.retrieveOption(config$Option);
    }

    public int getFlashMode(int n10) {
        Config$Option config$Option = OPTION_FLASH_MODE;
        Integer n11 = n10;
        return (Integer)this.retrieveOption(config$Option, n11);
    }

    public ImageReaderProxyProvider getImageReaderProxyProvider() {
        Config$Option config$Option = OPTION_IMAGE_READER_PROXY_PROVIDER;
        return (ImageReaderProxyProvider)this.retrieveOption(config$Option, null);
    }

    public int getInputFormat() {
        Config$Option config$Option = ImageInputConfig.OPTION_INPUT_FORMAT;
        return (Integer)this.retrieveOption(config$Option);
    }

    public Executor getIoExecutor() {
        Config$Option config$Option = IoConfig.OPTION_IO_EXECUTOR;
        return (Executor)this.retrieveOption(config$Option);
    }

    public Executor getIoExecutor(Executor executor) {
        Config$Option config$Option = IoConfig.OPTION_IO_EXECUTOR;
        return (Executor)this.retrieveOption(config$Option, executor);
    }

    public int getMaxCaptureStages() {
        Config$Option config$Option = OPTION_MAX_CAPTURE_STAGES;
        return (Integer)this.retrieveOption(config$Option);
    }

    public int getMaxCaptureStages(int n10) {
        Config$Option config$Option = OPTION_MAX_CAPTURE_STAGES;
        Integer n11 = n10;
        return (Integer)this.retrieveOption(config$Option, n11);
    }

    public boolean hasCaptureMode() {
        Config$Option config$Option = OPTION_IMAGE_CAPTURE_MODE;
        return this.containsOption(config$Option);
    }

    public boolean isSoftwareJpegEncoderRequested() {
        Config$Option config$Option = OPTION_USE_SOFTWARE_JPEG_ENCODER;
        Boolean bl2 = Boolean.FALSE;
        return (Boolean)this.retrieveOption(config$Option, bl2);
    }
}

