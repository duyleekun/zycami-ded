/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCaptureSession$CaptureCallback
 *  android.hardware.camera2.CameraCaptureSession$StateCallback
 *  android.hardware.camera2.CameraDevice$StateCallback
 */
package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.impl.CameraEventCallbacks;
import androidx.camera.camera2.internal.Camera2CaptureCallbacks;
import androidx.camera.camera2.internal.CameraCaptureSessionStateCallbacks;
import androidx.camera.camera2.internal.CameraDeviceStateCallbacks;
import androidx.camera.camera2.internal.CaptureCallbackContainer;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Config$Option;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionConfig$Builder;
import androidx.camera.core.impl.SessionConfig$OptionUnpacker;
import androidx.camera.core.impl.UseCaseConfig;
import java.util.Collection;
import java.util.List;

public final class Camera2SessionOptionUnpacker
implements SessionConfig$OptionUnpacker {
    public static final Camera2SessionOptionUnpacker INSTANCE;

    static {
        Camera2SessionOptionUnpacker camera2SessionOptionUnpacker;
        INSTANCE = camera2SessionOptionUnpacker = new Camera2SessionOptionUnpacker();
    }

    public void unpack(UseCaseConfig object, SessionConfig$Builder sessionConfig$Builder) {
        Object object2 = object.getDefaultSessionConfig(null);
        Object object3 = OptionsBundle.emptyBundle();
        Object object4 = SessionConfig.defaultEmptySessionConfig();
        int n10 = ((SessionConfig)object4).getTemplateType();
        if (object2 != null) {
            n10 = ((SessionConfig)object2).getTemplateType();
            object3 = ((SessionConfig)object2).getDeviceStateCallbacks();
            sessionConfig$Builder.addAllDeviceStateCallbacks((Collection)object3);
            object3 = ((SessionConfig)object2).getSessionStateCallbacks();
            sessionConfig$Builder.addAllSessionStateCallbacks((List)object3);
            object3 = ((SessionConfig)object2).getRepeatingCameraCaptureCallbacks();
            sessionConfig$Builder.addAllRepeatingCameraCaptureCallbacks((Collection)object3);
            object3 = ((SessionConfig)object2).getImplementationOptions();
        }
        sessionConfig$Builder.setImplementationOptions((Config)object3);
        object2 = new Camera2ImplConfig((Config)object);
        int n11 = ((Camera2ImplConfig)object2).getCaptureRequestTemplate(n10);
        sessionConfig$Builder.setTemplateType(n11);
        object = CameraDeviceStateCallbacks.createNoOpCallback();
        object = ((Camera2ImplConfig)object2).getDeviceStateCallback((CameraDevice.StateCallback)object);
        sessionConfig$Builder.addDeviceStateCallback((CameraDevice.StateCallback)object);
        object = CameraCaptureSessionStateCallbacks.createNoOpCallback();
        object = ((Camera2ImplConfig)object2).getSessionStateCallback((CameraCaptureSession.StateCallback)object);
        sessionConfig$Builder.addSessionStateCallback((CameraCaptureSession.StateCallback)object);
        object = Camera2CaptureCallbacks.createNoOpCallback();
        object = CaptureCallbackContainer.create(((Camera2ImplConfig)object2).getSessionCaptureCallback((CameraCaptureSession.CaptureCallback)object));
        sessionConfig$Builder.addCameraCaptureCallback((CameraCaptureCallback)object);
        object = MutableOptionsBundle.create();
        object3 = Camera2ImplConfig.CAMERA_EVENT_CALLBACK_OPTION;
        object4 = CameraEventCallbacks.createEmptyCallback();
        object4 = ((Camera2ImplConfig)object2).getCameraEventCallback((CameraEventCallbacks)object4);
        ((MutableOptionsBundle)object).insertOption((Config$Option)object3, object4);
        sessionConfig$Builder.addImplementationOptions((Config)object);
        object = ((Camera2ImplConfig)object2).getCaptureRequestOptions();
        sessionConfig$Builder.addImplementationOptions((Config)object);
    }
}

