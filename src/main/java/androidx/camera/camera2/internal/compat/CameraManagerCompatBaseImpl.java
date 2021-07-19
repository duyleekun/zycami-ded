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
 *  android.os.Handler
 */
package androidx.camera.camera2.internal.compat;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Handler;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraDeviceCompat$StateCallbackExecutorWrapper;
import androidx.camera.camera2.internal.compat.CameraManagerCompat$AvailabilityCallbackExecutorWrapper;
import androidx.camera.camera2.internal.compat.CameraManagerCompat$CameraManagerCompatImpl;
import androidx.camera.camera2.internal.compat.CameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21;
import androidx.core.util.Preconditions;
import java.util.Map;
import java.util.concurrent.Executor;

public class CameraManagerCompatBaseImpl
implements CameraManagerCompat$CameraManagerCompatImpl {
    public final CameraManager mCameraManager;
    public final Object mObject;

    public CameraManagerCompatBaseImpl(Context context, Object object) {
        context = (CameraManager)context.getSystemService("camera");
        this.mCameraManager = context;
        this.mObject = object;
    }

    public static CameraManagerCompatBaseImpl create(Context context, Handler handler) {
        CameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21 cameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21 = new CameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21(handler);
        CameraManagerCompatBaseImpl cameraManagerCompatBaseImpl = new CameraManagerCompatBaseImpl(context, cameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21);
        return cameraManagerCompatBaseImpl;
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

    public String[] getCameraIdList() {
        CameraManager cameraManager;
        try {
            cameraManager = this.mCameraManager;
        }
        catch (CameraAccessException cameraAccessException) {
            throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(cameraAccessException);
        }
        return cameraManager.getCameraIdList();
    }

    public CameraManager getCameraManager() {
        return this.mCameraManager;
    }

    public void openCamera(String string2, Executor object, CameraDevice.StateCallback stateCallback) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(stateCallback);
        CameraDeviceCompat$StateCallbackExecutorWrapper cameraDeviceCompat$StateCallbackExecutorWrapper = new CameraDeviceCompat$StateCallbackExecutorWrapper((Executor)object, stateCallback);
        object = (CameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21)this.mObject;
        try {
            stateCallback = this.mCameraManager;
        }
        catch (CameraAccessException cameraAccessException) {
            throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(cameraAccessException);
        }
        object = ((CameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21)object).mCompatHandler;
        stateCallback.openCamera(string2, (CameraDevice.StateCallback)cameraDeviceCompat$StateCallbackExecutorWrapper, (Handler)object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void registerAvailabilityCallback(Executor object, CameraManager.AvailabilityCallback availabilityCallback) {
        if (object == null) {
            object = new IllegalArgumentException("executor was null");
            throw object;
        }
        Object object2 = null;
        CameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21 cameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21 = (CameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21)this.mObject;
        if (availabilityCallback != null) {
            Map map = cameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21.mWrapperMap;
            synchronized (map) {
                object2 = cameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21.mWrapperMap;
                object2 = object2.get(availabilityCallback);
                object2 = (CameraManagerCompat$AvailabilityCallbackExecutorWrapper)((Object)object2);
                if (object2 == null) {
                    object2 = new CameraManagerCompat$AvailabilityCallbackExecutorWrapper((Executor)object, availabilityCallback);
                    object = cameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21.mWrapperMap;
                    object.put(availabilityCallback, object2);
                }
            }
        }
        object = this.mCameraManager;
        availabilityCallback = cameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21.mCompatHandler;
        object.registerAvailabilityCallback((CameraManager.AvailabilityCallback)object2, (Handler)availabilityCallback);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void unregisterAvailabilityCallback(CameraManager.AvailabilityCallback object) {
        if (object != null) {
            Object object2 = (CameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21)this.mObject;
            Map map = ((CameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21)object2).mWrapperMap;
            synchronized (map) {
                object2 = ((CameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21)object2).mWrapperMap;
                object = object2.remove(object);
                object = (CameraManagerCompat$AvailabilityCallbackExecutorWrapper)((Object)object);
            }
        } else {
            object = null;
        }
        if (object != null) {
            object.setDisabled();
        }
        this.mCameraManager.unregisterAvailabilityCallback(object);
    }
}

