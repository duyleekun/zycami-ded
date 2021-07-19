/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraDevice
 *  android.os.Build$VERSION
 *  android.os.Handler
 */
package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraDevice;
import android.os.Build;
import android.os.Handler;
import androidx.camera.camera2.internal.compat.CameraDeviceCompat$CameraDeviceCompatImpl;
import androidx.camera.camera2.internal.compat.CameraDeviceCompatApi23Impl;
import androidx.camera.camera2.internal.compat.CameraDeviceCompatApi24Impl;
import androidx.camera.camera2.internal.compat.CameraDeviceCompatBaseImpl;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.core.impl.utils.MainThreadAsyncHandler;

public final class CameraDeviceCompat {
    public static final int SESSION_OPERATION_MODE_CONSTRAINED_HIGH_SPEED = 1;
    public static final int SESSION_OPERATION_MODE_NORMAL;
    private final CameraDeviceCompat$CameraDeviceCompatImpl mImpl;

    private CameraDeviceCompat(CameraDevice object, Handler object2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            super((CameraDevice)object);
            this.mImpl = object2;
        } else {
            n11 = 24;
            if (n10 >= n11) {
                object = CameraDeviceCompatApi24Impl.create(object, object2);
                this.mImpl = object;
            } else {
                n11 = 23;
                if (n10 >= n11) {
                    object = CameraDeviceCompatApi23Impl.create(object, object2);
                    this.mImpl = object;
                } else {
                    object = CameraDeviceCompatBaseImpl.create(object, object2);
                    this.mImpl = object;
                }
            }
        }
    }

    public static CameraDeviceCompat toCameraDeviceCompat(CameraDevice cameraDevice) {
        Handler handler = MainThreadAsyncHandler.getInstance();
        return CameraDeviceCompat.toCameraDeviceCompat(cameraDevice, handler);
    }

    public static CameraDeviceCompat toCameraDeviceCompat(CameraDevice cameraDevice, Handler handler) {
        CameraDeviceCompat cameraDeviceCompat = new CameraDeviceCompat(cameraDevice, handler);
        return cameraDeviceCompat;
    }

    public void createCaptureSession(SessionConfigurationCompat sessionConfigurationCompat) {
        this.mImpl.createCaptureSession(sessionConfigurationCompat);
    }

    public CameraDevice toCameraDevice() {
        return this.mImpl.unwrap();
    }
}

