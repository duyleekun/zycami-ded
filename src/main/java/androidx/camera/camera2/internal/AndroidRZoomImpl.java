/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.hardware.camera2.CameraCharacteristics
 *  android.hardware.camera2.CameraCharacteristics$Key
 *  android.hardware.camera2.CaptureRequest
 *  android.hardware.camera2.CaptureRequest$Key
 *  android.hardware.camera2.CaptureResult
 *  android.hardware.camera2.CaptureResult$Key
 *  android.hardware.camera2.TotalCaptureResult
 *  android.util.Range
 */
package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.util.Range;
import androidx.camera.camera2.impl.Camera2ImplConfig$Builder;
import androidx.camera.camera2.internal.ZoomControl$ZoomImpl;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.CameraControl$OperationCanceledException;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.core.util.Preconditions;

public final class AndroidRZoomImpl
implements ZoomControl$ZoomImpl {
    public static final float DEFAULT_ZOOM_RATIO = 1.0f;
    private final CameraCharacteristicsCompat mCameraCharacteristics;
    private float mCurrentZoomRatio;
    private float mPendingZoomRatio;
    private CallbackToFutureAdapter$Completer mPendingZoomRatioCompleter;
    private final Range mZoomRatioRange;

    public AndroidRZoomImpl(CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        float f10;
        this.mCurrentZoomRatio = f10 = 1.0f;
        this.mPendingZoomRatio = f10;
        this.mCameraCharacteristics = cameraCharacteristicsCompat;
        CameraCharacteristics.Key key = CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE;
        cameraCharacteristicsCompat = (Range)cameraCharacteristicsCompat.get(key);
        this.mZoomRatioRange = cameraCharacteristicsCompat;
    }

    public void addRequestOption(Camera2ImplConfig$Builder camera2ImplConfig$Builder) {
        CaptureRequest.Key key = CaptureRequest.CONTROL_ZOOM_RATIO;
        Float f10 = Float.valueOf(this.mCurrentZoomRatio);
        camera2ImplConfig$Builder.setCaptureRequestOption(key, f10);
    }

    public Rect getCropSensorRegion() {
        CameraCharacteristicsCompat cameraCharacteristicsCompat = this.mCameraCharacteristics;
        CameraCharacteristics.Key key = CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE;
        return (Rect)Preconditions.checkNotNull((Rect)cameraCharacteristicsCompat.get(key));
    }

    public float getMaxZoom() {
        return ((Float)this.mZoomRatioRange.getUpper()).floatValue();
    }

    public float getMinZoom() {
        return ((Float)this.mZoomRatioRange.getLower()).floatValue();
    }

    public void onCaptureResult(TotalCaptureResult object) {
        CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = this.mPendingZoomRatioCompleter;
        if (callbackToFutureAdapter$Completer != null) {
            callbackToFutureAdapter$Completer = CaptureResult.CONTROL_ZOOM_RATIO;
            if ((object = (Float)object.get((CaptureResult.Key)callbackToFutureAdapter$Completer)) == null) {
                return;
            }
            float f10 = this.mPendingZoomRatio;
            float f11 = ((Float)object).floatValue();
            float f12 = f10 - f11;
            Object object2 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
            if (object2 == false) {
                object = this.mPendingZoomRatioCompleter;
                f10 = 0.0f;
                callbackToFutureAdapter$Completer = null;
                ((CallbackToFutureAdapter$Completer)object).set(null);
                this.mPendingZoomRatioCompleter = null;
            }
        }
    }

    public void resetZoom() {
        float f10;
        this.mCurrentZoomRatio = f10 = 1.0f;
        CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = this.mPendingZoomRatioCompleter;
        if (callbackToFutureAdapter$Completer != null) {
            String string2 = "Camera is not active.";
            CameraControl$OperationCanceledException cameraControl$OperationCanceledException = new CameraControl$OperationCanceledException(string2);
            callbackToFutureAdapter$Completer.setException(cameraControl$OperationCanceledException);
            f10 = 0.0f;
            callbackToFutureAdapter$Completer = null;
            this.mPendingZoomRatioCompleter = null;
        }
    }

    public void setZoomRatio(float f10, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        this.mCurrentZoomRatio = f10;
        CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer2 = this.mPendingZoomRatioCompleter;
        if (callbackToFutureAdapter$Completer2 != null) {
            String string2 = "There is a new zoomRatio being set";
            CameraControl$OperationCanceledException cameraControl$OperationCanceledException = new CameraControl$OperationCanceledException(string2);
            callbackToFutureAdapter$Completer2.setException(cameraControl$OperationCanceledException);
        }
        this.mPendingZoomRatio = f10 = this.mCurrentZoomRatio;
        this.mPendingZoomRatioCompleter = callbackToFutureAdapter$Completer;
    }
}

