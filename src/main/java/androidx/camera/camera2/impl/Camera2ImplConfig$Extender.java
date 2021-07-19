/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.camera2.impl;

import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.impl.CameraEventCallbacks;
import androidx.camera.core.ExtendableBuilder;
import androidx.camera.core.impl.Config$Option;
import androidx.camera.core.impl.MutableConfig;

public final class Camera2ImplConfig$Extender {
    public ExtendableBuilder mBaseBuilder;

    public Camera2ImplConfig$Extender(ExtendableBuilder extendableBuilder) {
        this.mBaseBuilder = extendableBuilder;
    }

    public Camera2ImplConfig$Extender setCameraEventCallback(CameraEventCallbacks cameraEventCallbacks) {
        MutableConfig mutableConfig = this.mBaseBuilder.getMutableConfig();
        Config.Option option = Camera2ImplConfig.CAMERA_EVENT_CALLBACK_OPTION;
        mutableConfig.insertOption(option, cameraEventCallbacks);
        return this;
    }
}

