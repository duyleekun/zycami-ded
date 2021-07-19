/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Rational
 *  android.util.Size
 */
package androidx.camera.core;

import android.util.Rational;
import android.util.Size;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageReaderProxyProvider;
import androidx.camera.core.UseCase$EventCallback;
import androidx.camera.core.impl.CaptureBundle;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.CaptureConfig$OptionUnpacker;
import androidx.camera.core.impl.CaptureProcessor;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Config$Option;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.ImageOutputConfig$Builder;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionConfig$OptionUnpacker;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfig$Builder;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.IoConfig;
import androidx.camera.core.internal.IoConfig$Builder;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.UseCaseEventConfig;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;

public final class ImageCapture$Builder
implements UseCaseConfig$Builder,
ImageOutputConfig$Builder,
IoConfig$Builder {
    private final MutableOptionsBundle mMutableConfig;

    public ImageCapture$Builder() {
        MutableOptionsBundle mutableOptionsBundle = MutableOptionsBundle.create();
        this(mutableOptionsBundle);
    }

    private ImageCapture$Builder(MutableOptionsBundle object) {
        boolean bl2;
        Object object2 = ImageCapture.class;
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

    public static ImageCapture$Builder fromConfig(Config config) {
        config = MutableOptionsBundle.from(config);
        ImageCapture$Builder imageCapture$Builder = new ImageCapture$Builder((MutableOptionsBundle)config);
        return imageCapture$Builder;
    }

    public static ImageCapture$Builder fromConfig(ImageCaptureConfig config) {
        config = MutableOptionsBundle.from(config);
        ImageCapture$Builder imageCapture$Builder = new ImageCapture$Builder((MutableOptionsBundle)config);
        return imageCapture$Builder;
    }

    public ImageCapture build() {
        int n10;
        Object object;
        Object object2;
        Object object3 = this.getMutableConfig();
        Object object4 = ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO;
        int n11 = 0;
        Object object5 = null;
        if ((object3 = object3.retrieveOption((Config$Option)object4, null)) != null) {
            object3 = this.getMutableConfig();
            object4 = ImageOutputConfig.OPTION_TARGET_RESOLUTION;
            if ((object3 = object3.retrieveOption((Config$Option)object4, null)) != null) {
                object3 = new IllegalArgumentException("Cannot use both setTargetResolution and setTargetAspectRatio on the same config.");
                throw object3;
            }
        }
        object3 = this.getMutableConfig();
        object4 = ImageCaptureConfig.OPTION_BUFFER_FORMAT;
        object3 = (Integer)object3.retrieveOption((Config$Option)object4, null);
        int n12 = 0;
        object4 = null;
        int n13 = 1;
        if (object3 != null) {
            int n14;
            object2 = this.getMutableConfig();
            object = ImageCaptureConfig.OPTION_CAPTURE_PROCESSOR;
            if ((object2 = object2.retrieveOption((Config$Option)object, null)) == null) {
                n14 = n13;
            } else {
                n14 = 0;
                object2 = null;
            }
            Preconditions.checkArgument(n14 != 0, "Cannot set buffer format with CaptureProcessor defined.");
            object2 = this.getMutableConfig();
            object = ImageInputConfig.OPTION_INPUT_FORMAT;
            object2.insertOption((Config$Option)object, object3);
        } else {
            object3 = this.getMutableConfig();
            object2 = ImageCaptureConfig.OPTION_CAPTURE_PROCESSOR;
            if ((object3 = object3.retrieveOption((Config$Option)object2, null)) != null) {
                object3 = this.getMutableConfig();
                object2 = ImageInputConfig.OPTION_INPUT_FORMAT;
                n10 = 35;
                object = n10;
                object3.insertOption((Config$Option)object2, object);
            } else {
                object3 = this.getMutableConfig();
                object2 = ImageInputConfig.OPTION_INPUT_FORMAT;
                n10 = 256;
                object = n10;
                object3.insertOption((Config$Option)object2, object);
            }
        }
        object2 = this.getUseCaseConfig();
        object3 = new ImageCapture((ImageCaptureConfig)object2);
        object2 = this.getMutableConfig();
        object = ImageOutputConfig.OPTION_TARGET_RESOLUTION;
        object5 = (Size)object2.retrieveOption((Config$Option)object, null);
        if (object5 != null) {
            n10 = object5.getWidth();
            n11 = object5.getHeight();
            object2 = new Rational(n10, n11);
            ((ImageCapture)object3).setCropAspectRatio((Rational)object2);
        }
        object5 = this.getMutableConfig();
        object2 = ImageCaptureConfig.OPTION_MAX_CAPTURE_STAGES;
        n10 = 2;
        Integer n15 = n10;
        n11 = (Integer)(object5 = (Integer)object5.retrieveOption((Config$Option)object2, n15));
        if (n11 >= n13) {
            n12 = n13;
        }
        Preconditions.checkArgument(n12 != 0, "Maximum outstanding image count must be at least 1");
        object4 = this.getMutableConfig();
        object5 = IoConfig.OPTION_IO_EXECUTOR;
        object2 = CameraXExecutors.ioExecutor();
        Preconditions.checkNotNull((Executor)object4.retrieveOption((Config$Option)object5, object2), "The IO executor can't be null");
        object4 = this.getMutableConfig();
        object5 = ImageCaptureConfig.OPTION_FLASH_MODE;
        n12 = object4.containsOption((Config$Option)object5);
        if (n12 != 0 && (n12 = ((Integer)(object4 = (Integer)this.getMutableConfig().retrieveOption((Config$Option)object5))).intValue()) != 0 && n12 != n13 && n12 != n10) {
            object5 = new StringBuilder();
            ((StringBuilder)object5).append("The flash mode is not allowed to set: ");
            ((StringBuilder)object5).append(n12);
            object4 = ((StringBuilder)object5).toString();
            object3 = new IllegalArgumentException((String)object4);
            throw object3;
        }
        return object3;
    }

    public MutableConfig getMutableConfig() {
        return this.mMutableConfig;
    }

    public ImageCaptureConfig getUseCaseConfig() {
        OptionsBundle optionsBundle = OptionsBundle.from(this.mMutableConfig);
        ImageCaptureConfig imageCaptureConfig = new ImageCaptureConfig(optionsBundle);
        return imageCaptureConfig;
    }

    public ImageCapture$Builder setAttachedUseCasesUpdateListener(Consumer consumer) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = UseCaseConfig.OPTION_ATTACHED_USE_CASES_UPDATE_LISTENER;
        mutableConfig.insertOption(config$Option, consumer);
        return this;
    }

    public ImageCapture$Builder setBufferFormat(int n10) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = ImageCaptureConfig.OPTION_BUFFER_FORMAT;
        Integer n11 = n10;
        mutableConfig.insertOption(config$Option, n11);
        return this;
    }

    public ImageCapture$Builder setCameraSelector(CameraSelector cameraSelector) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = UseCaseConfig.OPTION_CAMERA_SELECTOR;
        mutableConfig.insertOption(config$Option, cameraSelector);
        return this;
    }

    public ImageCapture$Builder setCaptureBundle(CaptureBundle captureBundle) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = ImageCaptureConfig.OPTION_CAPTURE_BUNDLE;
        mutableConfig.insertOption(config$Option, captureBundle);
        return this;
    }

    public ImageCapture$Builder setCaptureMode(int n10) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = ImageCaptureConfig.OPTION_IMAGE_CAPTURE_MODE;
        Integer n11 = n10;
        mutableConfig.insertOption(config$Option, n11);
        return this;
    }

    public ImageCapture$Builder setCaptureOptionUnpacker(CaptureConfig$OptionUnpacker captureConfig$OptionUnpacker) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER;
        mutableConfig.insertOption(config$Option, captureConfig$OptionUnpacker);
        return this;
    }

    public ImageCapture$Builder setCaptureProcessor(CaptureProcessor captureProcessor) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = ImageCaptureConfig.OPTION_CAPTURE_PROCESSOR;
        mutableConfig.insertOption(config$Option, captureProcessor);
        return this;
    }

    public ImageCapture$Builder setDefaultCaptureConfig(CaptureConfig captureConfig) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG;
        mutableConfig.insertOption(config$Option, captureConfig);
        return this;
    }

    public ImageCapture$Builder setDefaultResolution(Size size) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = ImageOutputConfig.OPTION_DEFAULT_RESOLUTION;
        mutableConfig.insertOption(config$Option, size);
        return this;
    }

    public ImageCapture$Builder setDefaultSessionConfig(SessionConfig sessionConfig) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG;
        mutableConfig.insertOption(config$Option, sessionConfig);
        return this;
    }

    public ImageCapture$Builder setFlashMode(int n10) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = ImageCaptureConfig.OPTION_FLASH_MODE;
        Integer n11 = n10;
        mutableConfig.insertOption(config$Option, n11);
        return this;
    }

    public ImageCapture$Builder setImageReaderProxyProvider(ImageReaderProxyProvider imageReaderProxyProvider) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = ImageCaptureConfig.OPTION_IMAGE_READER_PROXY_PROVIDER;
        mutableConfig.insertOption(config$Option, imageReaderProxyProvider);
        return this;
    }

    public ImageCapture$Builder setIoExecutor(Executor executor) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = IoConfig.OPTION_IO_EXECUTOR;
        mutableConfig.insertOption(config$Option, executor);
        return this;
    }

    public ImageCapture$Builder setMaxCaptureStages(int n10) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = ImageCaptureConfig.OPTION_MAX_CAPTURE_STAGES;
        Integer n11 = n10;
        mutableConfig.insertOption(config$Option, n11);
        return this;
    }

    public ImageCapture$Builder setMaxResolution(Size size) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = ImageOutputConfig.OPTION_MAX_RESOLUTION;
        mutableConfig.insertOption(config$Option, size);
        return this;
    }

    public ImageCapture$Builder setSessionOptionUnpacker(SessionConfig$OptionUnpacker sessionConfig$OptionUnpacker) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER;
        mutableConfig.insertOption(config$Option, sessionConfig$OptionUnpacker);
        return this;
    }

    public ImageCapture$Builder setSoftwareJpegEncoderRequested(boolean bl2) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = ImageCaptureConfig.OPTION_USE_SOFTWARE_JPEG_ENCODER;
        Boolean bl3 = bl2;
        mutableConfig.insertOption(config$Option, bl3);
        return this;
    }

    public ImageCapture$Builder setSupportedResolutions(List list) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS;
        mutableConfig.insertOption(config$Option, list);
        return this;
    }

    public ImageCapture$Builder setSurfaceOccupancyPriority(int n10) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY;
        Integer n11 = n10;
        mutableConfig.insertOption(config$Option, n11);
        return this;
    }

    public ImageCapture$Builder setTargetAspectRatio(int n10) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO;
        Integer n11 = n10;
        mutableConfig.insertOption(config$Option, n11);
        return this;
    }

    public ImageCapture$Builder setTargetClass(Class object) {
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

    public ImageCapture$Builder setTargetName(String string2) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = TargetConfig.OPTION_TARGET_NAME;
        mutableConfig.insertOption(config$Option, string2);
        return this;
    }

    public ImageCapture$Builder setTargetResolution(Size size) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = ImageOutputConfig.OPTION_TARGET_RESOLUTION;
        mutableConfig.insertOption(config$Option, size);
        return this;
    }

    public ImageCapture$Builder setTargetRotation(int n10) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = ImageOutputConfig.OPTION_TARGET_ROTATION;
        Integer n11 = n10;
        mutableConfig.insertOption(config$Option, n11);
        return this;
    }

    public ImageCapture$Builder setUseCaseEventCallback(UseCase$EventCallback useCase$EventCallback) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = UseCaseEventConfig.OPTION_USE_CASE_EVENT_CALLBACK;
        mutableConfig.insertOption(config$Option, useCase$EventCallback);
        return this;
    }
}

