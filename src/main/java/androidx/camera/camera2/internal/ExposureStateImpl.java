/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCharacteristics
 *  android.hardware.camera2.CameraCharacteristics$Key
 *  android.util.Range
 *  android.util.Rational
 */
package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Range;
import android.util.Rational;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.ExposureState;

public class ExposureStateImpl
implements ExposureState {
    private final CameraCharacteristicsCompat mCameraCharacteristics;
    private int mExposureCompensation;
    private final Object mLock;

    public ExposureStateImpl(CameraCharacteristicsCompat cameraCharacteristicsCompat, int n10) {
        Object object;
        this.mLock = object = new Object();
        this.mCameraCharacteristics = cameraCharacteristicsCompat;
        this.mExposureCompensation = n10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int getExposureCompensationIndex() {
        Object object = this.mLock;
        synchronized (object) {
            return this.mExposureCompensation;
        }
    }

    public Range getExposureCompensationRange() {
        CameraCharacteristicsCompat cameraCharacteristicsCompat = this.mCameraCharacteristics;
        CameraCharacteristics.Key key = CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE;
        return (Range)cameraCharacteristicsCompat.get(key);
    }

    public Rational getExposureCompensationStep() {
        boolean bl2 = this.isExposureCompensationSupported();
        if (!bl2) {
            return Rational.ZERO;
        }
        CameraCharacteristicsCompat cameraCharacteristicsCompat = this.mCameraCharacteristics;
        CameraCharacteristics.Key key = CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP;
        return (Rational)cameraCharacteristicsCompat.get(key);
    }

    public boolean isExposureCompensationSupported() {
        int n10;
        int n11;
        Object object = this.mCameraCharacteristics;
        Object object2 = CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE;
        if ((object = (Range)((CameraCharacteristicsCompat)object).get((CameraCharacteristics.Key)object2)) != null && (n11 = ((Integer)(object2 = (Integer)object.getLower())).intValue()) != 0 && (n10 = ((Integer)(object = (Integer)object.getUpper())).intValue()) != 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        return n10 != 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setExposureCompensationIndex(int n10) {
        Object object = this.mLock;
        synchronized (object) {
            this.mExposureCompensation = n10;
            return;
        }
    }
}

