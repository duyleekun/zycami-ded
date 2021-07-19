/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.util.Log
 *  android.util.Size
 *  android.view.Surface
 *  com.huawei.camerakit.api.ActionDataCallback
 *  com.huawei.camerakit.api.ActionStateCallback
 *  com.huawei.camerakit.api.ModeConfigInterface
 *  com.huawei.camerakit.impl.ModeManager
 */
package com.huawei.camera.camerakit;

import android.os.Handler;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import com.huawei.camera.camerakit.ActionDataCallback;
import com.huawei.camera.camerakit.ActionStateCallback;
import com.huawei.camera.camerakit.CameraKit;
import com.huawei.camera.camerakit.Mode;
import com.huawei.camera.camerakit.ModeConfig;
import com.huawei.camerakit.api.ModeConfigInterface;
import com.huawei.camerakit.impl.ModeManager;
import java.util.Objects;

public final class ModeConfig$Builder {
    private ModeConfigInterface config;
    private Mode mode;

    private ModeConfig$Builder(Mode mode) {
        Object object = ModeManager.createModeConfig();
        this.config = object;
        try {
            this.mode = mode;
        }
        catch (NoSuchMethodError noSuchMethodError) {
            object = "Error in build ModeConfigInterface!";
            Log.e((String)"ModeConfigInterface", (String)object);
            mode = null;
            this.config = null;
            this.mode = null;
        }
    }

    public static ModeConfig$Builder getInstance(Mode mode) {
        Class<ModeConfig$Builder> clazz = ModeConfig$Builder.class;
        synchronized (clazz) {
            block5: {
                ModeConfig$Builder modeConfig$Builder = new ModeConfig$Builder(mode);
                mode = modeConfig$Builder.config;
                if (mode == null) break block5;
                mode = modeConfig$Builder.mode;
                if (mode == null) break block5;
                return modeConfig$Builder;
            }
            return null;
        }
    }

    public ModeConfig$Builder addCaptureImage(Size size, int n10) {
        this.config.addCaptureImage(size, n10);
        return this;
    }

    public ModeConfig$Builder addDeferredPreviewSize(Size size, Class clazz) {
        this.config.addDeferredPreviewSize(size, clazz);
        return this;
    }

    public ModeConfig$Builder addDeferredPreviewSurface(Surface surface) {
        this.config.addDeferredPreviewSurface(surface);
        return this;
    }

    public ModeConfig$Builder addPreviewSurface(Surface surface) {
        this.config.addPreviewSurface(surface);
        return this;
    }

    public ModeConfig$Builder addVideoSize(Size size) {
        int n10;
        int n11 = CameraKit.getApiLevel();
        if (n11 >= (n10 = 1)) {
            ModeConfigInterface modeConfigInterface = this.config;
            modeConfigInterface.addVideoSize(size);
        }
        return this;
    }

    public ModeConfig$Builder addVideoSurface(Surface surface) {
        this.config.addVideoSurface(surface);
        return this;
    }

    public ModeConfig build() {
        ModeConfigInterface modeConfigInterface = this.config.build();
        ModeConfig modeConfig = new ModeConfig(modeConfigInterface, null);
        return modeConfig;
    }

    public ModeConfig$Builder removeCaptureImage(Size size, int n10) {
        this.config.removeCaptureImage(size, n10);
        return this;
    }

    public ModeConfig$Builder removePreviewSurface(Surface surface) {
        this.config.removePreviewSurface(surface);
        return this;
    }

    public ModeConfig$Builder removeVideoSize(Size size) {
        int n10;
        int n11 = CameraKit.getApiLevel();
        if (n11 >= (n10 = 1)) {
            ModeConfigInterface modeConfigInterface = this.config;
            modeConfigInterface.removeVideoSize(size);
        }
        return this;
    }

    public ModeConfig$Builder removeVideoSurface(Surface surface) {
        this.config.removeVideoSurface(surface);
        return this;
    }

    public void setConfig(ModeConfigInterface modeConfigInterface) {
        this.config = modeConfigInterface;
    }

    public ModeConfig$Builder setDataCallback(ActionDataCallback object, Handler handler) {
        if (object == null) {
            object = this.config;
            handler = null;
            object.setDataCallback(null, null);
        } else {
            Objects.requireNonNull(handler, "Handler should not be null!");
            ModeConfigInterface modeConfigInterface = this.config;
            Mode mode = this.mode;
            object = ActionDataCallback.obtain(mode, object);
            modeConfigInterface.setDataCallback((com.huawei.camerakit.api.ActionDataCallback)object, handler);
        }
        return this;
    }

    public ModeConfig$Builder setStateCallback(ActionStateCallback object, Handler handler) {
        if (object == null) {
            object = this.config;
            handler = null;
            object.setStateCallback(null, null);
        } else {
            Objects.requireNonNull(handler, "Handler should not be null!");
            ModeConfigInterface modeConfigInterface = this.config;
            Mode mode = this.mode;
            object = ActionStateCallback.obtain(mode, object);
            modeConfigInterface.setStateCallback((com.huawei.camerakit.api.ActionStateCallback)object, handler);
        }
        return this;
    }

    public ModeConfig$Builder setVideoFps(int n10) {
        int n11;
        int n12 = CameraKit.getApiLevel();
        if (n12 >= (n11 = 1)) {
            ModeConfigInterface modeConfigInterface = this.config;
            modeConfigInterface.setVideoFps(n10);
        }
        return this;
    }
}

