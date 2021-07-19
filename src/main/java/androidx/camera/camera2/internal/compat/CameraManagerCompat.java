/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.hardware.camera2.CameraCharacteristics
 *  android.hardware.camera2.CameraDevice$StateCallback
 *  android.hardware.camera2.CameraManager
 *  android.hardware.camera2.CameraManager$AvailabilityCallback
 *  android.os.Handler
 *  android.util.ArrayMap
 */
package androidx.camera.camera2.internal.compat;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Handler;
import android.util.ArrayMap;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat$CameraManagerCompatImpl;
import androidx.camera.core.impl.utils.MainThreadAsyncHandler;
import java.util.Map;
import java.util.concurrent.Executor;

public final class CameraManagerCompat {
    private final Map mCameraCharacteristicsMap;
    private final CameraManagerCompat$CameraManagerCompatImpl mImpl;

    private CameraManagerCompat(CameraManagerCompat$CameraManagerCompatImpl cameraManagerCompat$CameraManagerCompatImpl) {
        ArrayMap arrayMap = new ArrayMap(4);
        this.mCameraCharacteristicsMap = arrayMap;
        this.mImpl = cameraManagerCompat$CameraManagerCompatImpl;
    }

    public static CameraManagerCompat from(Context context) {
        Handler handler = MainThreadAsyncHandler.getInstance();
        return CameraManagerCompat.from(context, handler);
    }

    public static CameraManagerCompat from(Context object, Handler handler) {
        object = CameraManagerCompat$CameraManagerCompatImpl.from(object, handler);
        CameraManagerCompat cameraManagerCompat = new CameraManagerCompat((CameraManagerCompat$CameraManagerCompatImpl)object);
        return cameraManagerCompat;
    }

    public static CameraManagerCompat from(CameraManagerCompat$CameraManagerCompatImpl cameraManagerCompat$CameraManagerCompatImpl) {
        CameraManagerCompat cameraManagerCompat = new CameraManagerCompat(cameraManagerCompat$CameraManagerCompatImpl);
        return cameraManagerCompat;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public CameraCharacteristicsCompat getCameraCharacteristicsCompat(String string2) {
        Map map = this.mCameraCharacteristicsMap;
        synchronized (map) {
            Object object = this.mCameraCharacteristicsMap;
            object = object.get(string2);
            object = (CameraCharacteristicsCompat)object;
            if (object == null) {
                object = this.mImpl;
                object = object.getCameraCharacteristics(string2);
                object = CameraCharacteristicsCompat.toCameraCharacteristicsCompat((CameraCharacteristics)object);
                Map map2 = this.mCameraCharacteristicsMap;
                map2.put(string2, object);
            }
            return object;
        }
    }

    public String[] getCameraIdList() {
        return this.mImpl.getCameraIdList();
    }

    public void openCamera(String string2, Executor executor, CameraDevice.StateCallback stateCallback) {
        this.mImpl.openCamera(string2, executor, stateCallback);
    }

    public void registerAvailabilityCallback(Executor executor, CameraManager.AvailabilityCallback availabilityCallback) {
        this.mImpl.registerAvailabilityCallback(executor, availabilityCallback);
    }

    public void unregisterAvailabilityCallback(CameraManager.AvailabilityCallback availabilityCallback) {
        this.mImpl.unregisterAvailabilityCallback(availabilityCallback);
    }

    public CameraManager unwrap() {
        return this.mImpl.getCameraManager();
    }
}

