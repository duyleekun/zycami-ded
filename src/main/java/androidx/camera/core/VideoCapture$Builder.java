/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Size
 */
package androidx.camera.core;

import android.util.Size;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.UseCase$EventCallback;
import androidx.camera.core.VideoCapture;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.CaptureConfig$OptionUnpacker;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Config$Option;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.ImageOutputConfig$Builder;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionConfig$OptionUnpacker;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfig$Builder;
import androidx.camera.core.impl.VideoCaptureConfig;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.ThreadConfig;
import androidx.camera.core.internal.ThreadConfig$Builder;
import androidx.camera.core.internal.UseCaseEventConfig;
import androidx.core.util.Consumer;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;

public final class VideoCapture$Builder
implements UseCaseConfig$Builder,
ImageOutputConfig$Builder,
ThreadConfig$Builder {
    private final MutableOptionsBundle mMutableConfig;

    public VideoCapture$Builder() {
        MutableOptionsBundle mutableOptionsBundle = MutableOptionsBundle.create();
        this(mutableOptionsBundle);
    }

    private VideoCapture$Builder(MutableOptionsBundle object) {
        boolean bl2;
        Object object2 = VideoCapture.class;
        this.mMutableConfig = object;
        Object object3 = TargetConfig.OPTION_TARGET_CLASS;
        object = (Class)((OptionsBundle)object).retrieveOption((Config$Option)object3, null);
        if (object != null && !(bl2 = object.equals(object2))) {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("Invalid target class configuration for ");
            ((StringBuilder)object3).append(this);
            ((StringBuilder)object3).append(": ");
            ((StringBuilder)object3).append(object);
            object = ((StringBuilder)object3).toString();
            object2 = new IllegalArgumentException((String)object);
            throw object2;
        }
        this.setTargetClass((Class)object2);
    }

    public static VideoCapture$Builder fromConfig(Config config) {
        config = MutableOptionsBundle.from(config);
        VideoCapture$Builder videoCapture$Builder = new VideoCapture$Builder((MutableOptionsBundle)config);
        return videoCapture$Builder;
    }

    public static VideoCapture$Builder fromConfig(VideoCaptureConfig config) {
        config = MutableOptionsBundle.from(config);
        VideoCapture$Builder videoCapture$Builder = new VideoCapture$Builder((MutableOptionsBundle)config);
        return videoCapture$Builder;
    }

    public VideoCapture build() {
        Object object = this.getMutableConfig();
        Object object2 = ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO;
        if ((object = object.retrieveOption((Config$Option)object2, null)) != null) {
            object = this.getMutableConfig();
            object2 = ImageOutputConfig.OPTION_TARGET_RESOLUTION;
            if ((object = object.retrieveOption((Config$Option)object2, null)) != null) {
                object = new IllegalArgumentException("Cannot use both setTargetResolution and setTargetAspectRatio on the same config.");
                throw object;
            }
        }
        object2 = this.getUseCaseConfig();
        object = new VideoCapture((VideoCaptureConfig)object2);
        return object;
    }

    public MutableConfig getMutableConfig() {
        return this.mMutableConfig;
    }

    public VideoCaptureConfig getUseCaseConfig() {
        OptionsBundle optionsBundle = OptionsBundle.from(this.mMutableConfig);
        VideoCaptureConfig videoCaptureConfig = new VideoCaptureConfig(optionsBundle);
        return videoCaptureConfig;
    }

    public VideoCapture$Builder setAttachedUseCasesUpdateListener(Consumer consumer) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = UseCaseConfig.OPTION_ATTACHED_USE_CASES_UPDATE_LISTENER;
        mutableConfig.insertOption(config$Option, consumer);
        return this;
    }

    public VideoCapture$Builder setAudioBitRate(int n10) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = VideoCaptureConfig.OPTION_AUDIO_BIT_RATE;
        Integer n11 = n10;
        mutableConfig.insertOption(config$Option, n11);
        return this;
    }

    public VideoCapture$Builder setAudioChannelCount(int n10) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = VideoCaptureConfig.OPTION_AUDIO_CHANNEL_COUNT;
        Integer n11 = n10;
        mutableConfig.insertOption(config$Option, n11);
        return this;
    }

    public VideoCapture$Builder setAudioMinBufferSize(int n10) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = VideoCaptureConfig.OPTION_AUDIO_MIN_BUFFER_SIZE;
        Integer n11 = n10;
        mutableConfig.insertOption(config$Option, n11);
        return this;
    }

    public VideoCapture$Builder setAudioRecordSource(int n10) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = VideoCaptureConfig.OPTION_AUDIO_RECORD_SOURCE;
        Integer n11 = n10;
        mutableConfig.insertOption(config$Option, n11);
        return this;
    }

    public VideoCapture$Builder setAudioSampleRate(int n10) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = VideoCaptureConfig.OPTION_AUDIO_SAMPLE_RATE;
        Integer n11 = n10;
        mutableConfig.insertOption(config$Option, n11);
        return this;
    }

    public VideoCapture$Builder setBackgroundExecutor(Executor executor) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = ThreadConfig.OPTION_BACKGROUND_EXECUTOR;
        mutableConfig.insertOption(config$Option, executor);
        return this;
    }

    public VideoCapture$Builder setBitRate(int n10) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = VideoCaptureConfig.OPTION_BIT_RATE;
        Integer n11 = n10;
        mutableConfig.insertOption(config$Option, n11);
        return this;
    }

    public VideoCapture$Builder setCameraSelector(CameraSelector cameraSelector) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = UseCaseConfig.OPTION_CAMERA_SELECTOR;
        mutableConfig.insertOption(config$Option, cameraSelector);
        return this;
    }

    public VideoCapture$Builder setCaptureOptionUnpacker(CaptureConfig$OptionUnpacker captureConfig$OptionUnpacker) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER;
        mutableConfig.insertOption(config$Option, captureConfig$OptionUnpacker);
        return this;
    }

    public VideoCapture$Builder setDefaultCaptureConfig(CaptureConfig captureConfig) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG;
        mutableConfig.insertOption(config$Option, captureConfig);
        return this;
    }

    public VideoCapture$Builder setDefaultResolution(Size size) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = ImageOutputConfig.OPTION_DEFAULT_RESOLUTION;
        mutableConfig.insertOption(config$Option, size);
        return this;
    }

    public VideoCapture$Builder setDefaultSessionConfig(SessionConfig sessionConfig) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG;
        mutableConfig.insertOption(config$Option, sessionConfig);
        return this;
    }

    public VideoCapture$Builder setIFrameInterval(int n10) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = VideoCaptureConfig.OPTION_INTRA_FRAME_INTERVAL;
        Integer n11 = n10;
        mutableConfig.insertOption(config$Option, n11);
        return this;
    }

    public VideoCapture$Builder setMaxResolution(Size size) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = ImageOutputConfig.OPTION_MAX_RESOLUTION;
        mutableConfig.insertOption(config$Option, size);
        return this;
    }

    public VideoCapture$Builder setSessionOptionUnpacker(SessionConfig$OptionUnpacker sessionConfig$OptionUnpacker) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER;
        mutableConfig.insertOption(config$Option, sessionConfig$OptionUnpacker);
        return this;
    }

    public VideoCapture$Builder setSupportedResolutions(List list) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS;
        mutableConfig.insertOption(config$Option, list);
        return this;
    }

    public VideoCapture$Builder setSurfaceOccupancyPriority(int n10) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY;
        Integer n11 = n10;
        mutableConfig.insertOption(config$Option, n11);
        return this;
    }

    public VideoCapture$Builder setTargetAspectRatio(int n10) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO;
        Integer n11 = n10;
        mutableConfig.insertOption(config$Option, n11);
        return this;
    }

    public VideoCapture$Builder setTargetClass(Class object) {
        Object object2 = this.getMutableConfig();
        Config$Option config$Option = TargetConfig.OPTION_TARGET_CLASS;
        object2.insertOption(config$Option, object);
        object2 = this.getMutableConfig();
        config$Option = TargetConfig.OPTION_TARGET_NAME;
        object2 = object2.retrieveOption(config$Option, null);
        if (object2 == null) {
            object2 = new StringBuilder();
            object = ((Class)object).getCanonicalName();
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append("-");
            object = UUID.randomUUID();
            ((StringBuilder)object2).append(object);
            object = ((StringBuilder)object2).toString();
            this.setTargetName((String)object);
        }
        return this;
    }

    public VideoCapture$Builder setTargetName(String string2) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = TargetConfig.OPTION_TARGET_NAME;
        mutableConfig.insertOption(config$Option, string2);
        return this;
    }

    public VideoCapture$Builder setTargetResolution(Size size) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = ImageOutputConfig.OPTION_TARGET_RESOLUTION;
        mutableConfig.insertOption(config$Option, size);
        return this;
    }

    public VideoCapture$Builder setTargetRotation(int n10) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = ImageOutputConfig.OPTION_TARGET_ROTATION;
        Integer n11 = n10;
        mutableConfig.insertOption(config$Option, n11);
        return this;
    }

    public VideoCapture$Builder setUseCaseEventCallback(UseCase$EventCallback useCase$EventCallback) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = UseCaseEventConfig.OPTION_USE_CASE_EVENT_CALLBACK;
        mutableConfig.insertOption(config$Option, useCase$EventCallback);
        return this;
    }

    public VideoCapture$Builder setVideoFrameRate(int n10) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = VideoCaptureConfig.OPTION_VIDEO_FRAME_RATE;
        Integer n11 = n10;
        mutableConfig.insertOption(config$Option, n11);
        return this;
    }
}

