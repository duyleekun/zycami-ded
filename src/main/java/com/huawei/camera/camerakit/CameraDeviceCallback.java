/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.camera.camerakit;

import com.huawei.camera.camerakit.CameraDeviceCallback$CameraDeviceCallbackWrapper;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class CameraDeviceCallback {
    private static final Map CALLBACK_MAP;

    static {
        ConcurrentHashMap concurrentHashMap;
        CALLBACK_MAP = concurrentHashMap = new ConcurrentHashMap(0);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static CameraDeviceCallback$CameraDeviceCallbackWrapper obtain(CameraDeviceCallback cameraDeviceCallback) {
        Class<CameraDeviceCallback> clazz = CameraDeviceCallback.class;
        synchronized (clazz) {
            CameraDeviceCallback$CameraDeviceCallbackWrapper cameraDeviceCallback$CameraDeviceCallbackWrapper = CameraDeviceCallback.query(cameraDeviceCallback);
            if (cameraDeviceCallback$CameraDeviceCallbackWrapper == null) {
                Map map = null;
                cameraDeviceCallback$CameraDeviceCallbackWrapper = new CameraDeviceCallback$CameraDeviceCallbackWrapper(cameraDeviceCallback, null);
                map = CALLBACK_MAP;
                map.put(cameraDeviceCallback, cameraDeviceCallback$CameraDeviceCallbackWrapper);
            }
            return cameraDeviceCallback$CameraDeviceCallbackWrapper;
        }
    }

    public static CameraDeviceCallback$CameraDeviceCallbackWrapper query(CameraDeviceCallback object) {
        Class<CameraDeviceCallback> clazz = CameraDeviceCallback.class;
        synchronized (clazz) {
            block7: {
                Map map = CALLBACK_MAP;
                boolean bl2 = map.containsKey(object);
                if (!bl2) break block7;
                object = map.get(object);
                object = (CameraDeviceCallback$CameraDeviceCallbackWrapper)((Object)object);
                return object;
            }
            return null;
            finally {
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void release(CameraDeviceCallback cameraDeviceCallback) {
        Class<CameraDeviceCallback> clazz = CameraDeviceCallback.class;
        synchronized (clazz) {
            Map map = CALLBACK_MAP;
            boolean bl2 = map.containsKey(cameraDeviceCallback);
            if (bl2) {
                map.remove(cameraDeviceCallback);
            }
            return;
        }
    }

    public void onCameraAccessPrioritiesChanged(String string2) {
    }

    public void onCameraAvailable(String string2) {
    }

    public void onCameraUnavailable(String string2) {
    }

    public void onTorchModeChanged(String string2, boolean bl2) {
    }

    public void onTorchModeUnavailable(String string2) {
    }
}

