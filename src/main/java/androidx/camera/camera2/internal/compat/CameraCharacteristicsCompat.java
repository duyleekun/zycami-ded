/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCharacteristics
 *  android.hardware.camera2.CameraCharacteristics$Key
 */
package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCharacteristics;
import java.util.HashMap;
import java.util.Map;

public class CameraCharacteristicsCompat {
    private final CameraCharacteristics mCameraCharacteristics;
    private final Map mValuesCache;

    private CameraCharacteristicsCompat(CameraCharacteristics cameraCharacteristics) {
        HashMap hashMap;
        this.mValuesCache = hashMap = new HashMap();
        this.mCameraCharacteristics = cameraCharacteristics;
    }

    public static CameraCharacteristicsCompat toCameraCharacteristicsCompat(CameraCharacteristics cameraCharacteristics) {
        CameraCharacteristicsCompat cameraCharacteristicsCompat = new CameraCharacteristicsCompat(cameraCharacteristics);
        return cameraCharacteristicsCompat;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object get(CameraCharacteristics.Key key) {
        synchronized (this) {
            Object object = this.mValuesCache;
            object = object.get(key);
            if (object != null) {
                return object;
            }
            object = this.mCameraCharacteristics;
            if ((object = object.get(key)) != null) {
                Map map = this.mValuesCache;
                map.put(key, object);
            }
            return object;
        }
    }

    public CameraCharacteristics toCameraCharacteristics() {
        return this.mCameraCharacteristics;
    }
}

