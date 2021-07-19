/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCaptureSession$CaptureCallback
 *  android.hardware.camera2.CameraCaptureSession$StateCallback
 *  android.hardware.camera2.CameraDevice$StateCallback
 *  android.hardware.camera2.CaptureRequest$Key
 */
package androidx.camera.camera2.impl;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.impl.CameraEventCallbacks;
import androidx.camera.camera2.interop.CaptureRequestOptions;
import androidx.camera.camera2.interop.CaptureRequestOptions$Builder;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Config$Option;

public final class Camera2ImplConfig
extends CaptureRequestOptions {
    public static final Config$Option CAMERA_EVENT_CALLBACK_OPTION;
    public static final String CAPTURE_REQUEST_ID_STEM = "camera2.captureRequest.option.";
    public static final Config$Option CAPTURE_REQUEST_TAG_OPTION;
    public static final Config$Option DEVICE_STATE_CALLBACK_OPTION;
    public static final Config$Option SESSION_CAPTURE_CALLBACK_OPTION;
    public static final Config$Option SESSION_STATE_CALLBACK_OPTION;
    public static final Config$Option TEMPLATE_TYPE_OPTION;

    static {
        Class<Integer> clazz = Integer.TYPE;
        TEMPLATE_TYPE_OPTION = Config$Option.create("camera2.captureRequest.templateType", clazz);
        DEVICE_STATE_CALLBACK_OPTION = Config$Option.create("camera2.cameraDevice.stateCallback", CameraDevice.StateCallback.class);
        SESSION_STATE_CALLBACK_OPTION = Config$Option.create("camera2.cameraCaptureSession.stateCallback", CameraCaptureSession.StateCallback.class);
        SESSION_CAPTURE_CALLBACK_OPTION = Config$Option.create("camera2.cameraCaptureSession.captureCallback", CameraCaptureSession.CaptureCallback.class);
        CAMERA_EVENT_CALLBACK_OPTION = Config$Option.create("camera2.cameraEvent.callback", CameraEventCallbacks.class);
        CAPTURE_REQUEST_TAG_OPTION = Config$Option.create("camera2.captureRequest.tag", Object.class);
    }

    public Camera2ImplConfig(Config config) {
        super(config);
    }

    public static Config$Option createCaptureRequestOption(CaptureRequest.Key key) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CAPTURE_REQUEST_ID_STEM);
        String string2 = key.getName();
        stringBuilder.append(string2);
        return Config$Option.create(stringBuilder.toString(), Object.class, key);
    }

    public CameraEventCallbacks getCameraEventCallback(CameraEventCallbacks cameraEventCallbacks) {
        Config config = this.getConfig();
        Config$Option config$Option = CAMERA_EVENT_CALLBACK_OPTION;
        return (CameraEventCallbacks)config.retrieveOption(config$Option, cameraEventCallbacks);
    }

    public CaptureRequestOptions getCaptureRequestOptions() {
        return CaptureRequestOptions$Builder.from(this.getConfig()).build();
    }

    public Object getCaptureRequestTag(Object object) {
        Config config = this.getConfig();
        Config$Option config$Option = CAPTURE_REQUEST_TAG_OPTION;
        return config.retrieveOption(config$Option, object);
    }

    public int getCaptureRequestTemplate(int n10) {
        Config config = this.getConfig();
        Config$Option config$Option = TEMPLATE_TYPE_OPTION;
        Integer n11 = n10;
        return (Integer)config.retrieveOption(config$Option, n11);
    }

    public CameraDevice.StateCallback getDeviceStateCallback(CameraDevice.StateCallback stateCallback) {
        Config config = this.getConfig();
        Config$Option config$Option = DEVICE_STATE_CALLBACK_OPTION;
        return (CameraDevice.StateCallback)config.retrieveOption(config$Option, stateCallback);
    }

    public CameraCaptureSession.CaptureCallback getSessionCaptureCallback(CameraCaptureSession.CaptureCallback captureCallback) {
        Config config = this.getConfig();
        Config$Option config$Option = SESSION_CAPTURE_CALLBACK_OPTION;
        return (CameraCaptureSession.CaptureCallback)config.retrieveOption(config$Option, captureCallback);
    }

    public CameraCaptureSession.StateCallback getSessionStateCallback(CameraCaptureSession.StateCallback stateCallback) {
        Config config = this.getConfig();
        Config$Option config$Option = SESSION_STATE_CALLBACK_OPTION;
        return (CameraCaptureSession.StateCallback)config.retrieveOption(config$Option, stateCallback);
    }
}

