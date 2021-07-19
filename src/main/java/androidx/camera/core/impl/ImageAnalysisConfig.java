/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.ImageAnalysis$BackpressureStrategy;
import androidx.camera.core.ImageReaderProxyProvider;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Config$Option;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.internal.ThreadConfig;

public final class ImageAnalysisConfig
implements UseCaseConfig,
ImageOutputConfig,
ThreadConfig {
    public static final Config$Option OPTION_BACKPRESSURE_STRATEGY = Config$Option.create("camerax.core.imageAnalysis.backpressureStrategy", ImageAnalysis$BackpressureStrategy.class);
    public static final Config$Option OPTION_IMAGE_QUEUE_DEPTH;
    public static final Config$Option OPTION_IMAGE_READER_PROXY_PROVIDER;
    private final OptionsBundle mConfig;

    static {
        Class<Integer> clazz = Integer.TYPE;
        OPTION_IMAGE_QUEUE_DEPTH = Config$Option.create("camerax.core.imageAnalysis.imageQueueDepth", clazz);
        OPTION_IMAGE_READER_PROXY_PROVIDER = Config$Option.create("camerax.core.imageAnalysis.imageReaderProxyProvider", ImageReaderProxyProvider.class);
    }

    public ImageAnalysisConfig(OptionsBundle optionsBundle) {
        this.mConfig = optionsBundle;
    }

    public int getBackpressureStrategy() {
        Config$Option config$Option = OPTION_BACKPRESSURE_STRATEGY;
        return (Integer)this.retrieveOption(config$Option);
    }

    public int getBackpressureStrategy(int n10) {
        Config$Option config$Option = OPTION_BACKPRESSURE_STRATEGY;
        Integer n11 = n10;
        return (Integer)this.retrieveOption(config$Option, n11);
    }

    public Config getConfig() {
        return this.mConfig;
    }

    public int getImageQueueDepth() {
        Config$Option config$Option = OPTION_IMAGE_QUEUE_DEPTH;
        return (Integer)this.retrieveOption(config$Option);
    }

    public int getImageQueueDepth(int n10) {
        Config$Option config$Option = OPTION_IMAGE_QUEUE_DEPTH;
        Integer n11 = n10;
        return (Integer)this.retrieveOption(config$Option, n11);
    }

    public ImageReaderProxyProvider getImageReaderProxyProvider() {
        Config$Option config$Option = OPTION_IMAGE_READER_PROXY_PROVIDER;
        return (ImageReaderProxyProvider)this.retrieveOption(config$Option, null);
    }

    public int getInputFormat() {
        return 35;
    }
}

