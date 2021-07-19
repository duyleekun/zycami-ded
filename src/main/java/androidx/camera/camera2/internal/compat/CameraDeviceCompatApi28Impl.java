/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraDevice
 *  android.hardware.camera2.params.SessionConfiguration
 */
package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.SessionConfiguration;
import androidx.camera.camera2.internal.compat.CameraDeviceCompatApi24Impl;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.core.util.Preconditions;

public class CameraDeviceCompatApi28Impl
extends CameraDeviceCompatApi24Impl {
    public CameraDeviceCompatApi28Impl(CameraDevice cameraDevice) {
        cameraDevice = (CameraDevice)Preconditions.checkNotNull(cameraDevice);
        super(cameraDevice, null);
    }

    public void createCaptureSession(SessionConfigurationCompat sessionConfigurationCompat) {
        sessionConfigurationCompat = (SessionConfiguration)sessionConfigurationCompat.unwrap();
        Preconditions.checkNotNull(sessionConfigurationCompat);
        this.mCameraDevice.createCaptureSession((SessionConfiguration)sessionConfigurationCompat);
    }
}

