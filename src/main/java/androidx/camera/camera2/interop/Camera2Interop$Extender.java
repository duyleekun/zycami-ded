/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCaptureSession$CaptureCallback
 *  android.hardware.camera2.CameraCaptureSession$StateCallback
 *  android.hardware.camera2.CameraDevice$StateCallback
 *  android.hardware.camera2.CaptureRequest$Key
 */
package androidx.camera.camera2.interop;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.core.ExtendableBuilder;
import androidx.camera.core.impl.Config$Option;
import androidx.camera.core.impl.Config$OptionPriority;
import androidx.camera.core.impl.MutableConfig;

public final class Camera2Interop$Extender {
    public ExtendableBuilder mBaseBuilder;

    public Camera2Interop$Extender(ExtendableBuilder extendableBuilder) {
        this.mBaseBuilder = extendableBuilder;
    }

    public Camera2Interop$Extender setCaptureRequestOption(CaptureRequest.Key object, Object object2) {
        object = Camera2ImplConfig.createCaptureRequestOption(object);
        MutableConfig mutableConfig = this.mBaseBuilder.getMutableConfig();
        Config$OptionPriority config$OptionPriority = Config$OptionPriority.ALWAYS_OVERRIDE;
        mutableConfig.insertOption((Config$Option)object, config$OptionPriority, object2);
        return this;
    }

    public Camera2Interop$Extender setCaptureRequestTemplate(int n10) {
        MutableConfig mutableConfig = this.mBaseBuilder.getMutableConfig();
        Config$Option config$Option = Camera2ImplConfig.TEMPLATE_TYPE_OPTION;
        Integer n11 = n10;
        mutableConfig.insertOption(config$Option, n11);
        return this;
    }

    public Camera2Interop$Extender setDeviceStateCallback(CameraDevice.StateCallback stateCallback) {
        MutableConfig mutableConfig = this.mBaseBuilder.getMutableConfig();
        Config$Option config$Option = Camera2ImplConfig.DEVICE_STATE_CALLBACK_OPTION;
        mutableConfig.insertOption(config$Option, stateCallback);
        return this;
    }

    public Camera2Interop$Extender setSessionCaptureCallback(CameraCaptureSession.CaptureCallback captureCallback) {
        MutableConfig mutableConfig = this.mBaseBuilder.getMutableConfig();
        Config$Option config$Option = Camera2ImplConfig.SESSION_CAPTURE_CALLBACK_OPTION;
        mutableConfig.insertOption(config$Option, captureCallback);
        return this;
    }

    public Camera2Interop$Extender setSessionStateCallback(CameraCaptureSession.StateCallback stateCallback) {
        MutableConfig mutableConfig = this.mBaseBuilder.getMutableConfig();
        Config$Option config$Option = Camera2ImplConfig.SESSION_STATE_CALLBACK_OPTION;
        mutableConfig.insertOption(config$Option, stateCallback);
        return this;
    }
}

