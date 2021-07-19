/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package androidx.camera.core;

import android.os.Handler;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraX;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.impl.CameraDeviceSurfaceManager$Provider;
import androidx.camera.core.impl.CameraFactory$Provider;
import androidx.camera.core.impl.Config$Option;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.UseCaseConfigFactory$Provider;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.TargetConfig$Builder;
import java.util.UUID;
import java.util.concurrent.Executor;

public final class CameraXConfig$Builder
implements TargetConfig$Builder {
    private final MutableOptionsBundle mMutableConfig;

    public CameraXConfig$Builder() {
        MutableOptionsBundle mutableOptionsBundle = MutableOptionsBundle.create();
        this(mutableOptionsBundle);
    }

    private CameraXConfig$Builder(MutableOptionsBundle object) {
        boolean bl2;
        Object object2 = CameraX.class;
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

    public static CameraXConfig$Builder fromConfig(CameraXConfig config) {
        config = MutableOptionsBundle.from(config);
        CameraXConfig$Builder cameraXConfig$Builder = new CameraXConfig$Builder((MutableOptionsBundle)config);
        return cameraXConfig$Builder;
    }

    private MutableConfig getMutableConfig() {
        return this.mMutableConfig;
    }

    public CameraXConfig build() {
        OptionsBundle optionsBundle = OptionsBundle.from(this.mMutableConfig);
        CameraXConfig cameraXConfig = new CameraXConfig(optionsBundle);
        return cameraXConfig;
    }

    public CameraXConfig$Builder setAvailableCamerasLimiter(CameraSelector cameraSelector) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = CameraXConfig.OPTION_AVAILABLE_CAMERAS_LIMITER;
        mutableConfig.insertOption(config$Option, cameraSelector);
        return this;
    }

    public CameraXConfig$Builder setCameraExecutor(Executor executor) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = CameraXConfig.OPTION_CAMERA_EXECUTOR;
        mutableConfig.insertOption(config$Option, executor);
        return this;
    }

    public CameraXConfig$Builder setCameraFactoryProvider(CameraFactory$Provider cameraFactory$Provider) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = CameraXConfig.OPTION_CAMERA_FACTORY_PROVIDER;
        mutableConfig.insertOption(config$Option, cameraFactory$Provider);
        return this;
    }

    public CameraXConfig$Builder setDeviceSurfaceManagerProvider(CameraDeviceSurfaceManager$Provider cameraDeviceSurfaceManager$Provider) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = CameraXConfig.OPTION_DEVICE_SURFACE_MANAGER_PROVIDER;
        mutableConfig.insertOption(config$Option, cameraDeviceSurfaceManager$Provider);
        return this;
    }

    public CameraXConfig$Builder setMinimumLoggingLevel(int n10) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = CameraXConfig.OPTION_MIN_LOGGING_LEVEL;
        Integer n11 = n10;
        mutableConfig.insertOption(config$Option, n11);
        return this;
    }

    public CameraXConfig$Builder setSchedulerHandler(Handler handler) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = CameraXConfig.OPTION_SCHEDULER_HANDLER;
        mutableConfig.insertOption(config$Option, handler);
        return this;
    }

    public CameraXConfig$Builder setTargetClass(Class object) {
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

    public CameraXConfig$Builder setTargetName(String string2) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = TargetConfig.OPTION_TARGET_NAME;
        mutableConfig.insertOption(config$Option, string2);
        return this;
    }

    public CameraXConfig$Builder setUseCaseConfigFactoryProvider(UseCaseConfigFactory$Provider useCaseConfigFactory$Provider) {
        MutableConfig mutableConfig = this.getMutableConfig();
        Config$Option config$Option = CameraXConfig.OPTION_USECASE_CONFIG_FACTORY_PROVIDER;
        mutableConfig.insertOption(config$Option, useCaseConfigFactory$Provider);
        return this;
    }
}

