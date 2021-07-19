/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCaptureSession$StateCallback
 *  android.hardware.camera2.CameraDevice
 *  android.hardware.camera2.params.InputConfiguration
 *  android.os.Handler
 */
package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.InputConfiguration;
import android.os.Handler;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$StateCallbackExecutorWrapper;
import androidx.camera.camera2.internal.compat.CameraDeviceCompatApi23Impl;
import androidx.camera.camera2.internal.compat.CameraDeviceCompatBaseImpl;
import androidx.camera.camera2.internal.compat.CameraDeviceCompatBaseImpl$CameraDeviceCompatParamsApi21;
import androidx.camera.camera2.internal.compat.params.InputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.core.util.Preconditions;
import java.util.List;
import java.util.concurrent.Executor;

public class CameraDeviceCompatApi24Impl
extends CameraDeviceCompatApi23Impl {
    public CameraDeviceCompatApi24Impl(CameraDevice cameraDevice, Object object) {
        super(cameraDevice, object);
    }

    public static CameraDeviceCompatApi24Impl create(CameraDevice cameraDevice, Handler handler) {
        CameraDeviceCompatBaseImpl$CameraDeviceCompatParamsApi21 cameraDeviceCompatBaseImpl$CameraDeviceCompatParamsApi21 = new CameraDeviceCompatBaseImpl$CameraDeviceCompatParamsApi21(handler);
        CameraDeviceCompatApi24Impl cameraDeviceCompatApi24Impl = new CameraDeviceCompatApi24Impl(cameraDevice, cameraDeviceCompatBaseImpl$CameraDeviceCompatParamsApi21);
        return cameraDeviceCompatApi24Impl;
    }

    public void createCaptureSession(SessionConfigurationCompat sessionConfigurationCompat) {
        CameraDeviceCompatBaseImpl.checkPreconditions(this.mCameraDevice, sessionConfigurationCompat);
        Object object = sessionConfigurationCompat.getExecutor();
        CameraCaptureSession.StateCallback stateCallback = sessionConfigurationCompat.getStateCallback();
        CameraCaptureSessionCompat$StateCallbackExecutorWrapper cameraCaptureSessionCompat$StateCallbackExecutorWrapper = new CameraCaptureSessionCompat$StateCallbackExecutorWrapper((Executor)object, stateCallback);
        object = sessionConfigurationCompat.getOutputConfigurations();
        stateCallback = ((CameraDeviceCompatBaseImpl$CameraDeviceCompatParamsApi21)Preconditions.checkNotNull((Object)((CameraDeviceCompatBaseImpl$CameraDeviceCompatParamsApi21)this.mImplParams))).mCompatHandler;
        InputConfigurationCompat inputConfigurationCompat = sessionConfigurationCompat.getInputConfiguration();
        if (inputConfigurationCompat != null) {
            sessionConfigurationCompat = (InputConfiguration)inputConfigurationCompat.unwrap();
            Preconditions.checkNotNull(sessionConfigurationCompat);
            inputConfigurationCompat = this.mCameraDevice;
            object = SessionConfigurationCompat.transformFromCompat((List)object);
            inputConfigurationCompat.createReprocessableCaptureSessionByConfigurations((InputConfiguration)sessionConfigurationCompat, (List)object, cameraCaptureSessionCompat$StateCallbackExecutorWrapper, (Handler)stateCallback);
        } else {
            int n10;
            int n11 = sessionConfigurationCompat.getSessionType();
            if (n11 == (n10 = 1)) {
                sessionConfigurationCompat = this.mCameraDevice;
                object = CameraDeviceCompatBaseImpl.unpackSurfaces((List)object);
                sessionConfigurationCompat.createConstrainedHighSpeedCaptureSession((List)object, cameraCaptureSessionCompat$StateCallbackExecutorWrapper, (Handler)stateCallback);
            } else {
                sessionConfigurationCompat = this.mCameraDevice;
                object = SessionConfigurationCompat.transformFromCompat((List)object);
                sessionConfigurationCompat.createCaptureSessionByOutputConfigurations((List)object, cameraCaptureSessionCompat$StateCallbackExecutorWrapper, (Handler)stateCallback);
            }
        }
    }
}

