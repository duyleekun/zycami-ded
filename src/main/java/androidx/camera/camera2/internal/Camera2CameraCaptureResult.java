/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.hardware.camera2.CaptureResult
 *  android.hardware.camera2.CaptureResult$Key
 *  android.os.Build$VERSION
 */
package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CaptureResult;
import android.os.Build;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureMetaData$AeState;
import androidx.camera.core.impl.CameraCaptureMetaData$AfMode;
import androidx.camera.core.impl.CameraCaptureMetaData$AfState;
import androidx.camera.core.impl.CameraCaptureMetaData$AwbState;
import androidx.camera.core.impl.CameraCaptureMetaData$FlashState;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.ExifData$Builder;
import androidx.camera.core.impl.utils.ExifData$WhiteBalanceMode;

public class Camera2CameraCaptureResult
implements CameraCaptureResult {
    private static final String TAG = "C2CameraCaptureResult";
    private final CaptureResult mCaptureResult;
    private final TagBundle mTagBundle;

    public Camera2CameraCaptureResult(TagBundle tagBundle, CaptureResult captureResult) {
        this.mTagBundle = tagBundle;
        this.mCaptureResult = captureResult;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public CameraCaptureMetaData$AeState getAeState() {
        Object object = this.mCaptureResult;
        Object object2 = CaptureResult.CONTROL_AE_STATE;
        if ((object = (Integer)object.get((CaptureResult.Key)object2)) == null) {
            return CameraCaptureMetaData$AeState.UNKNOWN;
        }
        int n10 = (Integer)object;
        if (n10 == 0) return CameraCaptureMetaData$AeState.INACTIVE;
        int n11 = 1;
        if (n10 == n11) return CameraCaptureMetaData$AeState.SEARCHING;
        n11 = 2;
        if (n10 == n11) return CameraCaptureMetaData$AeState.CONVERGED;
        n11 = 3;
        if (n10 == n11) return CameraCaptureMetaData$AeState.LOCKED;
        n11 = 4;
        if (n10 == n11) return CameraCaptureMetaData$AeState.FLASH_REQUIRED;
        n11 = 5;
        if (n10 == n11) return CameraCaptureMetaData$AeState.SEARCHING;
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Undefined ae state: ");
        ((StringBuilder)object2).append(object);
        object = ((StringBuilder)object2).toString();
        Logger.e(TAG, (String)object);
        return CameraCaptureMetaData$AeState.UNKNOWN;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public CameraCaptureMetaData$AfMode getAfMode() {
        Object object = this.mCaptureResult;
        Object object2 = CaptureResult.CONTROL_AF_MODE;
        if ((object = (Integer)object.get((CaptureResult.Key)object2)) == null) {
            return CameraCaptureMetaData$AfMode.UNKNOWN;
        }
        int n10 = (Integer)object;
        if (n10 == 0) return CameraCaptureMetaData$AfMode.OFF;
        int n11 = 1;
        if (n10 == n11 || n10 == (n11 = 2)) return CameraCaptureMetaData$AfMode.ON_MANUAL_AUTO;
        n11 = 3;
        if (n10 == n11 || n10 == (n11 = 4)) return CameraCaptureMetaData$AfMode.ON_CONTINUOUS_AUTO;
        n11 = 5;
        if (n10 == n11) return CameraCaptureMetaData$AfMode.OFF;
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Undefined af mode: ");
        ((StringBuilder)object2).append(object);
        object = ((StringBuilder)object2).toString();
        Logger.e(TAG, (String)object);
        return CameraCaptureMetaData$AfMode.UNKNOWN;
    }

    public CameraCaptureMetaData$AfState getAfState() {
        Object object = this.mCaptureResult;
        Object object2 = CaptureResult.CONTROL_AF_STATE;
        if ((object = (Integer)object.get((CaptureResult.Key)object2)) == null) {
            return CameraCaptureMetaData$AfState.UNKNOWN;
        }
        int n10 = (Integer)object;
        switch (n10) {
            default: {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Undefined af state: ");
                ((StringBuilder)object2).append(object);
                object = ((StringBuilder)object2).toString();
                Logger.e(TAG, (String)object);
                return CameraCaptureMetaData$AfState.UNKNOWN;
            }
            case 5: {
                return CameraCaptureMetaData$AfState.LOCKED_NOT_FOCUSED;
            }
            case 4: {
                return CameraCaptureMetaData$AfState.LOCKED_FOCUSED;
            }
            case 2: {
                return CameraCaptureMetaData$AfState.FOCUSED;
            }
            case 1: 
            case 3: 
            case 6: {
                return CameraCaptureMetaData$AfState.SCANNING;
            }
            case 0: 
        }
        return CameraCaptureMetaData$AfState.INACTIVE;
    }

    public CameraCaptureMetaData$AwbState getAwbState() {
        Object object = this.mCaptureResult;
        Object object2 = CaptureResult.CONTROL_AWB_STATE;
        if ((object = (Integer)object.get((CaptureResult.Key)object2)) == null) {
            return CameraCaptureMetaData$AwbState.UNKNOWN;
        }
        int n10 = (Integer)object;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 3;
                    if (n10 != n11) {
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("Undefined awb state: ");
                        ((StringBuilder)object2).append(object);
                        object = ((StringBuilder)object2).toString();
                        Logger.e(TAG, (String)object);
                        return CameraCaptureMetaData$AwbState.UNKNOWN;
                    }
                    return CameraCaptureMetaData$AwbState.LOCKED;
                }
                return CameraCaptureMetaData$AwbState.CONVERGED;
            }
            return CameraCaptureMetaData$AwbState.METERING;
        }
        return CameraCaptureMetaData$AwbState.INACTIVE;
    }

    public CaptureResult getCaptureResult() {
        return this.mCaptureResult;
    }

    public CameraCaptureMetaData$FlashState getFlashState() {
        int n10;
        Object object = this.mCaptureResult;
        Object object2 = CaptureResult.FLASH_STATE;
        if ((object = (Integer)object.get((CaptureResult.Key)object2)) == null) {
            return CameraCaptureMetaData$FlashState.UNKNOWN;
        }
        int n11 = (Integer)object;
        if (n11 != 0 && n11 != (n10 = 1)) {
            n10 = 2;
            if (n11 != n10) {
                n10 = 3;
                if (n11 != n10 && n11 != (n10 = 4)) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("Undefined flash state: ");
                    ((StringBuilder)object2).append(object);
                    object = ((StringBuilder)object2).toString();
                    Logger.e(TAG, (String)object);
                    return CameraCaptureMetaData$FlashState.UNKNOWN;
                }
                return CameraCaptureMetaData$FlashState.FIRED;
            }
            return CameraCaptureMetaData$FlashState.READY;
        }
        return CameraCaptureMetaData$FlashState.NONE;
    }

    public TagBundle getTagBundle() {
        return this.mTagBundle;
    }

    public long getTimestamp() {
        Object object = this.mCaptureResult;
        CaptureResult.Key key = CaptureResult.SENSOR_TIMESTAMP;
        if ((object = (Long)object.get(key)) == null) {
            return -1;
        }
        return (Long)object;
    }

    public void populateExifData(ExifData$Builder exifData$Builder) {
        float f10;
        int n10;
        int n11;
        CameraCaptureResult.super.populateExifData(exifData$Builder);
        Object object = this.mCaptureResult;
        Object object2 = CaptureResult.SCALER_CROP_REGION;
        object = (Rect)object.get(object2);
        if (object != null) {
            n11 = object.width();
            object2 = exifData$Builder.setImageWidth(n11);
            n10 = object.height();
            object2.setImageHeight(n10);
        }
        object = this.mCaptureResult;
        object2 = CaptureResult.JPEG_ORIENTATION;
        if ((object = (Integer)object.get(object2)) != null) {
            n10 = (Integer)object;
            exifData$Builder.setOrientationDegrees(n10);
        }
        object = this.mCaptureResult;
        object2 = CaptureResult.SENSOR_EXPOSURE_TIME;
        if ((object = (Long)object.get(object2)) != null) {
            long l10 = (Long)object;
            exifData$Builder.setExposureTimeNanos(l10);
        }
        object = this.mCaptureResult;
        object2 = CaptureResult.LENS_APERTURE;
        if ((object = (Float)object.get(object2)) != null) {
            f10 = ((Float)object).floatValue();
            exifData$Builder.setLensFNumber(f10);
        }
        object = this.mCaptureResult;
        object2 = CaptureResult.SENSOR_SENSITIVITY;
        if ((object = (Integer)object.get(object2)) != null) {
            n11 = Build.VERSION.SDK_INT;
            int n12 = 24;
            float f11 = 3.4E-44f;
            if (n11 >= n12) {
                object2 = this.mCaptureResult;
                CaptureResult.Key key = CaptureResult.CONTROL_POST_RAW_SENSITIVITY_BOOST;
                if ((object2 = (Integer)object2.get(key)) != null) {
                    n10 = (Integer)object;
                    float f12 = object2.intValue();
                    n12 = 1120403456;
                    f11 = 100.0f;
                    n11 = (int)(f12 /= f11);
                    object = n10 *= n11;
                }
            }
            n10 = (Integer)object;
            exifData$Builder.setIso(n10);
        }
        object = this.mCaptureResult;
        object2 = CaptureResult.LENS_FOCAL_LENGTH;
        if ((object = (Float)object.get(object2)) != null) {
            f10 = ((Float)object).floatValue();
            exifData$Builder.setFocalLength(f10);
        }
        object = this.mCaptureResult;
        object2 = CaptureResult.CONTROL_AWB_MODE;
        if ((object = (Integer)object.get(object2)) != null) {
            object2 = ExifData$WhiteBalanceMode.AUTO;
            n10 = (Integer)object;
            if (n10 == 0) {
                object2 = ExifData$WhiteBalanceMode.MANUAL;
            }
            exifData$Builder.setWhiteBalanceMode((ExifData$WhiteBalanceMode)((Object)object2));
        }
    }
}

