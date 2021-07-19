/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.hardware.camera2.CameraAccessException
 *  android.hardware.camera2.CameraCharacteristics
 *  android.hardware.camera2.CameraDevice$StateCallback
 *  android.hardware.camera2.CameraManager
 *  android.hardware.camera2.CameraManager$AvailabilityCallback
 *  android.os.Build$VERSION
 */
package androidx.camera.camera2.internal.compat;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompatBaseImpl;
import java.util.concurrent.Executor;

public class CameraManagerCompatApi28Impl
extends CameraManagerCompatBaseImpl {
    public CameraManagerCompatApi28Impl(Context context) {
        super(context, null);
    }

    public static CameraManagerCompatApi28Impl create(Context context) {
        CameraManagerCompatApi28Impl cameraManagerCompatApi28Impl = new CameraManagerCompatApi28Impl(context);
        return cameraManagerCompatApi28Impl;
    }

    private boolean isDndFailCase(Throwable throwable) {
        boolean bl2;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 == n11 && (bl2 = CameraManagerCompatApi28Impl.isDndRuntimeException(throwable))) {
            bl2 = true;
        } else {
            bl2 = false;
            throwable = null;
        }
        return bl2;
    }

    private static boolean isDndRuntimeException(Throwable object) {
        Class<?> clazz = object.getClass();
        int n10 = clazz.equals(RuntimeException.class);
        if (n10 != 0 && (object = object.getStackTrace()) != null && (n10 = ((StackTraceElement[])object).length) >= 0) {
            object = object[0].getMethodName();
            return "_enableShutterSound".equals(object);
        }
        return false;
    }

    private void throwDndException(Throwable throwable) {
        CameraAccessExceptionCompat cameraAccessExceptionCompat = new CameraAccessExceptionCompat(10001, throwable);
        throw cameraAccessExceptionCompat;
    }

    public CameraCharacteristics getCameraCharacteristics(String string2) {
        try {
            return super.getCameraCharacteristics(string2);
        }
        catch (RuntimeException runtimeException) {
            boolean bl2 = this.isDndFailCase(runtimeException);
            if (bl2) {
                this.throwDndException(runtimeException);
            }
            throw runtimeException;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void openCamera(String string2, Executor executor, CameraDevice.StateCallback stateCallback) {
        void var1_5;
        try {
            CameraManager cameraManager = this.mCameraManager;
            cameraManager.openCamera(string2, executor, stateCallback);
            return;
        }
        catch (RuntimeException runtimeException) {
            boolean bl2 = this.isDndFailCase(runtimeException);
            if (!bl2) throw runtimeException;
            this.throwDndException(runtimeException);
            throw runtimeException;
        }
        catch (SecurityException securityException) {
            throw var1_5;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            // empty catch block
            throw var1_5;
        }
        catch (CameraAccessException cameraAccessException) {
            throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(cameraAccessException);
        }
    }

    public void registerAvailabilityCallback(Executor executor, CameraManager.AvailabilityCallback availabilityCallback) {
        this.mCameraManager.registerAvailabilityCallback(executor, availabilityCallback);
    }

    public void unregisterAvailabilityCallback(CameraManager.AvailabilityCallback availabilityCallback) {
        this.mCameraManager.unregisterAvailabilityCallback(availabilityCallback);
    }
}

