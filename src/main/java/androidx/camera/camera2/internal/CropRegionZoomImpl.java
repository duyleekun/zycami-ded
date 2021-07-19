/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.hardware.camera2.CameraCharacteristics
 *  android.hardware.camera2.CameraCharacteristics$Key
 *  android.hardware.camera2.CaptureRequest
 *  android.hardware.camera2.CaptureRequest$Key
 *  android.hardware.camera2.TotalCaptureResult
 */
package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.impl.Camera2ImplConfig$Builder;
import androidx.camera.camera2.internal.ZoomControl$ZoomImpl;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.CameraControl$OperationCanceledException;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.core.util.Preconditions;

public final class CropRegionZoomImpl
implements ZoomControl$ZoomImpl {
    public static final float MIN_DIGITAL_ZOOM = 1.0f;
    private final CameraCharacteristicsCompat mCameraCharacteristics;
    private Rect mCurrentCropRect = null;
    private Rect mPendingZoomCropRegion = null;
    private CallbackToFutureAdapter$Completer mPendingZoomRatioCompleter;

    public CropRegionZoomImpl(CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        this.mCameraCharacteristics = cameraCharacteristicsCompat;
    }

    private static Rect getCropRectByRatio(Rect rect, float f10) {
        float f11 = (float)rect.width() / f10;
        float f12 = (float)rect.height() / f10;
        f10 = (float)rect.width() - f11;
        float f13 = 2.0f;
        float f14 = ((float)rect.height() - f12) / f13;
        int n10 = (int)(f10 /= f13);
        int n11 = (int)f14;
        int n12 = (int)(f10 + f11);
        int n13 = (int)(f14 + f12);
        Rect rect2 = new Rect(n10, n11, n12, n13);
        return rect2;
    }

    private Rect getSensorRect() {
        CameraCharacteristicsCompat cameraCharacteristicsCompat = this.mCameraCharacteristics;
        CameraCharacteristics.Key key = CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE;
        return (Rect)Preconditions.checkNotNull((Rect)cameraCharacteristicsCompat.get(key));
    }

    public void addRequestOption(Camera2ImplConfig$Builder camera2ImplConfig$Builder) {
        Rect rect = this.mCurrentCropRect;
        if (rect != null) {
            CaptureRequest.Key key = CaptureRequest.SCALER_CROP_REGION;
            camera2ImplConfig$Builder.setCaptureRequestOption(key, rect);
        }
    }

    public Rect getCropSensorRegion() {
        Rect rect = this.mCurrentCropRect;
        if (rect == null) {
            rect = this.getSensorRect();
        }
        return rect;
    }

    public float getMaxZoom() {
        Object object = this.mCameraCharacteristics;
        CameraCharacteristics.Key key = CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM;
        if ((object = (Float)((CameraCharacteristicsCompat)object).get(key)) == null) {
            return 1.0f;
        }
        return ((Float)object).floatValue();
    }

    public float getMinZoom() {
        return 1.0f;
    }

    public void onCaptureResult(TotalCaptureResult object) {
        CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = this.mPendingZoomRatioCompleter;
        if (callbackToFutureAdapter$Completer != null) {
            CaptureRequest.Key key;
            boolean bl2;
            object = object.getRequest();
            callbackToFutureAdapter$Completer = null;
            if (object == null) {
                bl2 = false;
                object = null;
            } else {
                key = CaptureRequest.SCALER_CROP_REGION;
                object = (Rect)object.get(key);
            }
            key = this.mPendingZoomCropRegion;
            if (key != null && (bl2 = key.equals(object))) {
                object = this.mPendingZoomRatioCompleter;
                ((CallbackToFutureAdapter$Completer)object).set(null);
                this.mPendingZoomRatioCompleter = null;
                this.mPendingZoomCropRegion = null;
            }
        }
    }

    public void resetZoom() {
        this.mPendingZoomCropRegion = null;
        this.mCurrentCropRect = null;
        CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = this.mPendingZoomRatioCompleter;
        if (callbackToFutureAdapter$Completer != null) {
            String string2 = "Camera is not active.";
            CameraControl$OperationCanceledException cameraControl$OperationCanceledException = new CameraControl$OperationCanceledException(string2);
            callbackToFutureAdapter$Completer.setException(cameraControl$OperationCanceledException);
            this.mPendingZoomRatioCompleter = null;
        }
    }

    public void setZoomRatio(float f10, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        Object object = this.getSensorRect();
        Object object2 = CropRegionZoomImpl.getCropRectByRatio(object, f10);
        this.mCurrentCropRect = object2;
        object2 = this.mPendingZoomRatioCompleter;
        if (object2 != null) {
            String string2 = "There is a new zoomRatio being set";
            object = new CameraControl$OperationCanceledException(string2);
            ((CallbackToFutureAdapter$Completer)object2).setException((Throwable)object);
        }
        object2 = this.mCurrentCropRect;
        this.mPendingZoomCropRegion = object2;
        this.mPendingZoomRatioCompleter = callbackToFutureAdapter$Completer;
    }
}

