/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCharacteristics
 *  android.hardware.camera2.CameraCharacteristics$Key
 *  android.util.Pair
 */
package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Pair;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.camera2.internal.Camera2CameraInfoImpl$RedirectableLiveData;
import androidx.camera.camera2.internal.ExposureControl;
import androidx.camera.camera2.internal.TorchControl;
import androidx.camera.camera2.internal.ZoomControl;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.quirk.CameraQuirks;
import androidx.camera.camera2.interop.Camera2CameraInfo;
import androidx.camera.core.ExposureState;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.utils.CameraOrientationUtil;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LiveData;
import java.util.List;
import java.util.concurrent.Executor;

public final class Camera2CameraInfoImpl
implements CameraInfoInternal {
    private static final String TAG = "Camera2CameraInfo";
    private Camera2CameraControlImpl mCamera2CameraControlImpl;
    private final Camera2CameraInfo mCamera2CameraInfo;
    private List mCameraCaptureCallbacks;
    private final CameraCharacteristicsCompat mCameraCharacteristicsCompat;
    private final String mCameraId;
    private final Quirks mCameraQuirks;
    private final Object mLock;
    private Camera2CameraInfoImpl$RedirectableLiveData mRedirectTorchStateLiveData;
    private Camera2CameraInfoImpl$RedirectableLiveData mRedirectZoomStateLiveData;

    public Camera2CameraInfoImpl(String object, CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        Object object2;
        this.mLock = object2 = new Object();
        this.mRedirectTorchStateLiveData = null;
        this.mRedirectZoomStateLiveData = null;
        this.mCameraCaptureCallbacks = null;
        this.mCameraId = object2 = (String)Preconditions.checkNotNull(object);
        this.mCameraCharacteristicsCompat = cameraCharacteristicsCompat;
        this.mCamera2CameraInfo = object2 = new Camera2CameraInfo(this);
        this.mCameraQuirks = object = CameraQuirks.get((String)object, cameraCharacteristicsCompat);
    }

    private void logDeviceInfo() {
        this.logDeviceLevel();
    }

    private void logDeviceLevel() {
        String string2;
        StringBuilder stringBuilder;
        int n10 = this.getSupportedHardwareLevel();
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 3;
                    if (n10 != n11) {
                        n11 = 4;
                        if (n10 != n11) {
                            stringBuilder = new StringBuilder();
                            String string3 = "Unknown value: ";
                            stringBuilder.append(string3);
                            stringBuilder.append(n10);
                            string2 = stringBuilder.toString();
                        } else {
                            string2 = "INFO_SUPPORTED_HARDWARE_LEVEL_EXTERNAL";
                        }
                    } else {
                        string2 = "INFO_SUPPORTED_HARDWARE_LEVEL_3";
                    }
                } else {
                    string2 = "INFO_SUPPORTED_HARDWARE_LEVEL_LEGACY";
                }
            } else {
                string2 = "INFO_SUPPORTED_HARDWARE_LEVEL_FULL";
            }
        } else {
            string2 = "INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED";
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Device Level: ");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        Logger.i(TAG, string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void addSessionCaptureCallback(Executor executor, CameraCaptureCallback cameraCaptureCallback) {
        Object object = this.mLock;
        synchronized (object) {
            List<Object> list = this.mCamera2CameraControlImpl;
            if (list != null) {
                ((Camera2CameraControlImpl)((Object)list)).addSessionCameraCaptureCallback(executor, cameraCaptureCallback);
                return;
            }
            list = this.mCameraCaptureCallbacks;
            if (list == null) {
                this.mCameraCaptureCallbacks = list = new List<Object>();
            }
            list = this.mCameraCaptureCallbacks;
            Pair pair = new Pair((Object)cameraCaptureCallback, (Object)executor);
            list.add(pair);
            return;
        }
    }

    public Camera2CameraInfo getCamera2CameraInfo() {
        return this.mCamera2CameraInfo;
    }

    public CameraCharacteristicsCompat getCameraCharacteristicsCompat() {
        return this.mCameraCharacteristicsCompat;
    }

    public String getCameraId() {
        return this.mCameraId;
    }

    public Quirks getCameraQuirks() {
        return this.mCameraQuirks;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ExposureState getExposureState() {
        Object object = this.mLock;
        synchronized (object) {
            Object object2 = this.mCamera2CameraControlImpl;
            if (object2 == null) {
                object2 = this.mCameraCharacteristicsCompat;
                return ExposureControl.getDefaultExposureState((CameraCharacteristicsCompat)object2);
            }
            object2 = ((Camera2CameraControlImpl)object2).getExposureControl();
            return ((ExposureControl)object2).getExposureState();
        }
    }

    public String getImplementationType() {
        int n10;
        int n11 = this.getSupportedHardwareLevel();
        String string2 = n11 == (n10 = 2) ? "androidx.camera.camera2.legacy" : "androidx.camera.camera2";
        return string2;
    }

    public Integer getLensFacing() {
        Object object = this.mCameraCharacteristicsCompat;
        CameraCharacteristics.Key key = CameraCharacteristics.LENS_FACING;
        object = (Integer)((CameraCharacteristicsCompat)object).get(key);
        Preconditions.checkNotNull(object);
        int n10 = (Integer)object;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                return null;
            }
            return n11;
        }
        return 0;
    }

    public int getSensorOrientation() {
        Object object = this.mCameraCharacteristicsCompat;
        CameraCharacteristics.Key key = CameraCharacteristics.SENSOR_ORIENTATION;
        object = (Integer)((CameraCharacteristicsCompat)object).get(key);
        Preconditions.checkNotNull(object);
        return (Integer)object;
    }

    public int getSensorRotationDegrees() {
        return this.getSensorRotationDegrees(0);
    }

    public int getSensorRotationDegrees(int n10) {
        boolean bl2;
        int n11 = this.getSensorOrientation();
        Integer n12 = n11;
        n10 = CameraOrientationUtil.surfaceRotationToDegrees(n10);
        Integer n13 = this.getLensFacing();
        boolean bl3 = true;
        if (n13 == null || bl3 != (bl2 = n13.intValue())) {
            bl3 = false;
        }
        n11 = n12;
        return CameraOrientationUtil.getRelativeImageRotation(n10, n11, bl3);
    }

    public int getSupportedHardwareLevel() {
        Object object = this.mCameraCharacteristicsCompat;
        CameraCharacteristics.Key key = CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL;
        object = (Integer)((CameraCharacteristicsCompat)object).get(key);
        Preconditions.checkNotNull(object);
        return (Integer)object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public LiveData getTorchState() {
        Object object = this.mLock;
        synchronized (object) {
            Object object2 = this.mCamera2CameraControlImpl;
            if (object2 == null) {
                object2 = this.mRedirectTorchStateLiveData;
                if (object2 != null) return this.mRedirectTorchStateLiveData;
                Integer n10 = null;
                n10 = 0;
                this.mRedirectTorchStateLiveData = object2 = new Camera2CameraInfoImpl$RedirectableLiveData(n10);
                return this.mRedirectTorchStateLiveData;
            }
            Camera2CameraInfoImpl$RedirectableLiveData camera2CameraInfoImpl$RedirectableLiveData = this.mRedirectTorchStateLiveData;
            if (camera2CameraInfoImpl$RedirectableLiveData != null) {
                return camera2CameraInfoImpl$RedirectableLiveData;
            }
            object2 = ((Camera2CameraControlImpl)object2).getTorchControl();
            return ((TorchControl)object2).getTorchState();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public LiveData getZoomState() {
        Object object = this.mLock;
        synchronized (object) {
            Object object2 = this.mCamera2CameraControlImpl;
            if (object2 == null) {
                object2 = this.mRedirectZoomStateLiveData;
                if (object2 != null) return this.mRedirectZoomStateLiveData;
                Object object3 = this.mCameraCharacteristicsCompat;
                object3 = ZoomControl.getDefaultZoomState((CameraCharacteristicsCompat)object3);
                this.mRedirectZoomStateLiveData = object2 = new Camera2CameraInfoImpl$RedirectableLiveData(object3);
                return this.mRedirectZoomStateLiveData;
            }
            Camera2CameraInfoImpl$RedirectableLiveData camera2CameraInfoImpl$RedirectableLiveData = this.mRedirectZoomStateLiveData;
            if (camera2CameraInfoImpl$RedirectableLiveData != null) {
                return camera2CameraInfoImpl$RedirectableLiveData;
            }
            object2 = ((Camera2CameraControlImpl)object2).getZoomControl();
            return ((ZoomControl)object2).getZoomState();
        }
    }

    public boolean hasFlashUnit() {
        Object object = this.mCameraCharacteristicsCompat;
        CameraCharacteristics.Key key = CameraCharacteristics.FLASH_INFO_AVAILABLE;
        object = (Boolean)((CameraCharacteristicsCompat)object).get(key);
        Preconditions.checkNotNull(object);
        return (Boolean)object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void linkWithCameraControl(Camera2CameraControlImpl iterator2) {
        Object object = this.mLock;
        synchronized (object) {
            this.mCamera2CameraControlImpl = iterator2;
            Object object2 = this.mRedirectZoomStateLiveData;
            if (object2 != null) {
                iterator2 = ((Camera2CameraControlImpl)((Object)iterator2)).getZoomControl();
                iterator2 = ((ZoomControl)((Object)iterator2)).getZoomState();
                ((Camera2CameraInfoImpl$RedirectableLiveData)object2).redirectTo((LiveData)((Object)iterator2));
            }
            if ((iterator2 = this.mRedirectTorchStateLiveData) != null) {
                object2 = this.mCamera2CameraControlImpl;
                object2 = ((Camera2CameraControlImpl)object2).getTorchControl();
                object2 = ((TorchControl)object2).getTorchState();
                ((Camera2CameraInfoImpl$RedirectableLiveData)((Object)iterator2)).redirectTo((LiveData)object2);
            }
            if ((iterator2 = this.mCameraCaptureCallbacks) != null) {
                boolean bl2;
                iterator2 = iterator2.iterator();
                while (bl2 = iterator2.hasNext()) {
                    object2 = iterator2.next();
                    object2 = (Pair)object2;
                    Camera2CameraControlImpl camera2CameraControlImpl = this.mCamera2CameraControlImpl;
                    Object object3 = ((Pair)object2).second;
                    object3 = (Executor)object3;
                    object2 = ((Pair)object2).first;
                    object2 = (CameraCaptureCallback)object2;
                    camera2CameraControlImpl.addSessionCameraCaptureCallback((Executor)object3, (CameraCaptureCallback)object2);
                }
                iterator2 = null;
                this.mCameraCaptureCallbacks = null;
            }
        }
        this.logDeviceInfo();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void removeSessionCaptureCallback(CameraCaptureCallback cameraCaptureCallback) {
        Object object = this.mLock;
        synchronized (object) {
            Object object2 = this.mCamera2CameraControlImpl;
            if (object2 != null) {
                ((Camera2CameraControlImpl)object2).removeSessionCameraCaptureCallback(cameraCaptureCallback);
                return;
            }
            object2 = this.mCameraCaptureCallbacks;
            if (object2 == null) {
                return;
            }
            object2 = object2.iterator();
            boolean bl2;
            while (bl2 = object2.hasNext()) {
                Object object3 = object2.next();
                object3 = (Pair)object3;
                object3 = ((Pair)object3).first;
                if (object3 != cameraCaptureCallback) continue;
                object2.remove();
            }
            return;
        }
    }
}

