/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraDevice
 */
package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraDevice;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;

public interface CameraDeviceCompat$CameraDeviceCompatImpl {
    public void createCaptureSession(SessionConfigurationCompat var1);

    public CameraDevice unwrap();
}

