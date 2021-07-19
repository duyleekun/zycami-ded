/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.hardware.camera2.CameraAccessException
 *  android.hardware.camera2.CameraCharacteristics
 *  android.hardware.camera2.CameraDevice$StateCallback
 *  android.hardware.camera2.CameraManager
 */
package androidx.camera.camera2.internal.compat;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompatApi28Impl;
import java.util.concurrent.Executor;

public class CameraManagerCompatApi29Impl
extends CameraManagerCompatApi28Impl {
    public CameraManagerCompatApi29Impl(Context context) {
        super(context);
    }

    public CameraCharacteristics getCameraCharacteristics(String string2) {
        CameraManager cameraManager;
        try {
            cameraManager = this.mCameraManager;
        }
        catch (CameraAccessException cameraAccessException) {
            throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(cameraAccessException);
        }
        return cameraManager.getCameraCharacteristics(string2);
    }

    public void openCamera(String string2, Executor executor, CameraDevice.StateCallback stateCallback) {
        CameraManager cameraManager;
        try {
            cameraManager = this.mCameraManager;
        }
        catch (CameraAccessException cameraAccessException) {
            throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(cameraAccessException);
        }
        cameraManager.openCamera(string2, executor, stateCallback);
    }
}

