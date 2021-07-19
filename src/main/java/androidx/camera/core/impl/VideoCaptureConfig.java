/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Config$Option;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.internal.ThreadConfig;

public final class VideoCaptureConfig
implements UseCaseConfig,
ImageOutputConfig,
ThreadConfig {
    public static final Config$Option OPTION_AUDIO_BIT_RATE;
    public static final Config$Option OPTION_AUDIO_CHANNEL_COUNT;
    public static final Config$Option OPTION_AUDIO_MIN_BUFFER_SIZE;
    public static final Config$Option OPTION_AUDIO_RECORD_SOURCE;
    public static final Config$Option OPTION_AUDIO_SAMPLE_RATE;
    public static final Config$Option OPTION_BIT_RATE;
    public static final Config$Option OPTION_INTRA_FRAME_INTERVAL;
    public static final Config$Option OPTION_VIDEO_FRAME_RATE;
    private final OptionsBundle mConfig;

    static {
        Class<Integer> clazz = Integer.TYPE;
        OPTION_VIDEO_FRAME_RATE = Config$Option.create("camerax.core.videoCapture.recordingFrameRate", clazz);
        OPTION_BIT_RATE = Config$Option.create("camerax.core.videoCapture.bitRate", clazz);
        OPTION_INTRA_FRAME_INTERVAL = Config$Option.create("camerax.core.videoCapture.intraFrameInterval", clazz);
        OPTION_AUDIO_BIT_RATE = Config$Option.create("camerax.core.videoCapture.audioBitRate", clazz);
        OPTION_AUDIO_SAMPLE_RATE = Config$Option.create("camerax.core.videoCapture.audioSampleRate", clazz);
        OPTION_AUDIO_CHANNEL_COUNT = Config$Option.create("camerax.core.videoCapture.audioChannelCount", clazz);
        OPTION_AUDIO_RECORD_SOURCE = Config$Option.create("camerax.core.videoCapture.audioRecordSource", clazz);
        OPTION_AUDIO_MIN_BUFFER_SIZE = Config$Option.create("camerax.core.videoCapture.audioMinBufferSize", clazz);
    }

    public VideoCaptureConfig(OptionsBundle optionsBundle) {
        this.mConfig = optionsBundle;
    }

    public int getAudioBitRate() {
        Config$Option config$Option = OPTION_AUDIO_BIT_RATE;
        return (Integer)this.retrieveOption(config$Option);
    }

    public int getAudioBitRate(int n10) {
        Config$Option config$Option = OPTION_AUDIO_BIT_RATE;
        Integer n11 = n10;
        return (Integer)this.retrieveOption(config$Option, n11);
    }

    public int getAudioChannelCount() {
        Config$Option config$Option = OPTION_AUDIO_CHANNEL_COUNT;
        return (Integer)this.retrieveOption(config$Option);
    }

    public int getAudioChannelCount(int n10) {
        Config$Option config$Option = OPTION_AUDIO_CHANNEL_COUNT;
        Integer n11 = n10;
        return (Integer)this.retrieveOption(config$Option, n11);
    }

    public int getAudioMinBufferSize() {
        Config$Option config$Option = OPTION_AUDIO_MIN_BUFFER_SIZE;
        return (Integer)this.retrieveOption(config$Option);
    }

    public int getAudioMinBufferSize(int n10) {
        Config$Option config$Option = OPTION_AUDIO_MIN_BUFFER_SIZE;
        Integer n11 = n10;
        return (Integer)this.retrieveOption(config$Option, n11);
    }

    public int getAudioRecordSource() {
        Config$Option config$Option = OPTION_AUDIO_RECORD_SOURCE;
        return (Integer)this.retrieveOption(config$Option);
    }

    public int getAudioRecordSource(int n10) {
        Config$Option config$Option = OPTION_AUDIO_RECORD_SOURCE;
        Integer n11 = n10;
        return (Integer)this.retrieveOption(config$Option, n11);
    }

    public int getAudioSampleRate() {
        Config$Option config$Option = OPTION_AUDIO_SAMPLE_RATE;
        return (Integer)this.retrieveOption(config$Option);
    }

    public int getAudioSampleRate(int n10) {
        Config$Option config$Option = OPTION_AUDIO_SAMPLE_RATE;
        Integer n11 = n10;
        return (Integer)this.retrieveOption(config$Option, n11);
    }

    public int getBitRate() {
        Config$Option config$Option = OPTION_BIT_RATE;
        return (Integer)this.retrieveOption(config$Option);
    }

    public int getBitRate(int n10) {
        Config$Option config$Option = OPTION_BIT_RATE;
        Integer n11 = n10;
        return (Integer)this.retrieveOption(config$Option, n11);
    }

    public Config getConfig() {
        return this.mConfig;
    }

    public int getIFrameInterval() {
        Config$Option config$Option = OPTION_INTRA_FRAME_INTERVAL;
        return (Integer)this.retrieveOption(config$Option);
    }

    public int getIFrameInterval(int n10) {
        Config$Option config$Option = OPTION_INTRA_FRAME_INTERVAL;
        Integer n11 = n10;
        return (Integer)this.retrieveOption(config$Option, n11);
    }

    public int getInputFormat() {
        return 34;
    }

    public int getVideoFrameRate() {
        Config$Option config$Option = OPTION_VIDEO_FRAME_RATE;
        return (Integer)this.retrieveOption(config$Option);
    }

    public int getVideoFrameRate(int n10) {
        Config$Option config$Option = OPTION_VIDEO_FRAME_RATE;
        Integer n11 = n10;
        return (Integer)this.retrieveOption(config$Option, n11);
    }
}

