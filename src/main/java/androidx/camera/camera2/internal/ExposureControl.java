/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CaptureRequest
 *  android.hardware.camera2.CaptureRequest$Key
 *  android.hardware.camera2.CaptureResult
 *  android.hardware.camera2.CaptureResult$Key
 *  android.hardware.camera2.TotalCaptureResult
 */
package androidx.camera.camera2.internal;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.impl.Camera2ImplConfig$Builder;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.camera2.internal.Camera2CameraControlImpl$CaptureResultListener;
import androidx.camera.camera2.internal.ExposureStateImpl;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.CameraControl$OperationCanceledException;
import androidx.camera.core.ExposureState;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;
import androidx.core.util.Preconditions;
import b.a.a.d.l0;
import b.a.a.d.m0;
import b.a.a.d.n0;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.Serializable;
import java.util.concurrent.Executor;

public class ExposureControl {
    private static final int DEFAULT_EXPOSURE_COMPENSATION;
    private final Camera2CameraControlImpl mCameraControl;
    private final Executor mExecutor;
    private final ExposureStateImpl mExposureStateImpl;
    private boolean mIsActive = false;
    private Camera2CameraControlImpl$CaptureResultListener mRunningCaptureResultListener;
    private CallbackToFutureAdapter$Completer mRunningCompleter;

    public ExposureControl(Camera2CameraControlImpl object, CameraCharacteristicsCompat cameraCharacteristicsCompat, Executor executor) {
        this.mCameraControl = object;
        this.mExposureStateImpl = object = new ExposureStateImpl(cameraCharacteristicsCompat, 0);
        this.mExecutor = executor;
    }

    public static /* synthetic */ boolean a(int n10, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer, TotalCaptureResult object) {
        int n11;
        Object object2 = CaptureResult.CONTROL_AE_STATE;
        object2 = (Integer)object.get((CaptureResult.Key)object2);
        CaptureResult.Key key = CaptureResult.CONTROL_AE_EXPOSURE_COMPENSATION;
        object = (Integer)object.get(key);
        boolean bl2 = true;
        if (object2 != null && object != null) {
            int n12;
            int n13;
            int n14 = (Integer)object2;
            if ((n14 == (n13 = 2) || n14 == (n13 = 3) || n14 == (n13 = 4)) && (n12 = ((Integer)object).intValue()) == n10) {
                Integer n15 = n10;
                callbackToFutureAdapter$Completer.set(n15);
                return bl2;
            }
        } else if (object != null && (n11 = ((Integer)object).intValue()) == n10) {
            Integer n16 = n10;
            callbackToFutureAdapter$Completer.set(n16);
            return bl2;
        }
        return false;
    }

    private /* synthetic */ void b(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer, int n10) {
        boolean bl2 = this.mIsActive;
        boolean bl3 = false;
        if (!bl2) {
            this.mExposureStateImpl.setExposureCompensationIndex(0);
            CameraControl$OperationCanceledException cameraControl$OperationCanceledException = new CameraControl$OperationCanceledException("Camera is not active.");
            callbackToFutureAdapter$Completer.setException(cameraControl$OperationCanceledException);
            return;
        }
        this.clearRunningTask();
        Object object = this.mRunningCompleter;
        boolean bl4 = true;
        if (object == null) {
            bl2 = bl4;
        } else {
            bl2 = false;
            object = null;
        }
        String string2 = "mRunningCompleter should be null when starting set a new exposure compensation value";
        Preconditions.checkState(bl2, string2);
        object = this.mRunningCaptureResultListener;
        if (object == null) {
            bl3 = bl4;
        }
        Preconditions.checkState(bl3, "mRunningCaptureResultListener should be null when starting set a new exposure compensation value");
        this.mRunningCaptureResultListener = object = new n0(n10, callbackToFutureAdapter$Completer);
        this.mRunningCompleter = callbackToFutureAdapter$Completer;
        this.mCameraControl.addCaptureResultListener((Camera2CameraControlImpl$CaptureResultListener)object);
        this.mCameraControl.updateSessionConfigSynchronous();
    }

    private void clearRunningTask() {
        Object object;
        Object object2 = this.mRunningCompleter;
        if (object2 != null) {
            String string2 = "Cancelled by another setExposureCompensationIndex()";
            object = new CameraControl$OperationCanceledException(string2);
            ((CallbackToFutureAdapter$Completer)object2).setException((Throwable)object);
            this.mRunningCompleter = null;
        }
        if ((object2 = this.mRunningCaptureResultListener) != null) {
            object = this.mCameraControl;
            ((Camera2CameraControlImpl)object).removeCaptureResultListener((Camera2CameraControlImpl$CaptureResultListener)object2);
            this.mRunningCaptureResultListener = null;
        }
    }

    private /* synthetic */ Object d(int n10, CallbackToFutureAdapter$Completer object) {
        Executor executor = this.mExecutor;
        m0 m02 = new m0(this, (CallbackToFutureAdapter$Completer)object, n10);
        executor.execute(m02);
        object = new StringBuilder();
        ((StringBuilder)object).append("setExposureCompensationIndex[");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append("]");
        return ((StringBuilder)object).toString();
    }

    public static ExposureState getDefaultExposureState(CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        ExposureStateImpl exposureStateImpl = new ExposureStateImpl(cameraCharacteristicsCompat, 0);
        return exposureStateImpl;
    }

    public /* synthetic */ void c(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer, int n10) {
        this.b(callbackToFutureAdapter$Completer, n10);
    }

    public /* synthetic */ Object e(int n10, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return this.d(n10, callbackToFutureAdapter$Completer);
    }

    public ExposureState getExposureState() {
        return this.mExposureStateImpl;
    }

    public void setActive(boolean bl2) {
        boolean bl3 = this.mIsActive;
        if (bl2 == bl3) {
            return;
        }
        this.mIsActive = bl2;
        if (!bl2) {
            ExposureStateImpl exposureStateImpl = this.mExposureStateImpl;
            bl3 = false;
            exposureStateImpl.setExposureCompensationIndex(0);
            this.clearRunningTask();
        }
    }

    public void setCaptureRequestOption(Camera2ImplConfig$Builder camera2ImplConfig$Builder) {
        CaptureRequest.Key key = CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION;
        Integer n10 = this.mExposureStateImpl.getExposureCompensationIndex();
        camera2ImplConfig$Builder.setCaptureRequestOption(key, n10);
    }

    public ListenableFuture setExposureCompensationIndex(int n10) {
        Serializable serializable;
        Object object = this.mExposureStateImpl;
        boolean bl2 = ((ExposureStateImpl)object).isExposureCompensationSupported();
        if (!bl2) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("ExposureCompensation is not supported");
            return Futures.immediateFailedFuture(illegalArgumentException);
        }
        object = this.mExposureStateImpl.getExposureCompensationRange();
        boolean bl3 = object.contains((Comparable)((Object)(serializable = Integer.valueOf(n10))));
        if (!bl3) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Requested ExposureCompensation ");
            stringBuilder.append(n10);
            stringBuilder.append(" is not within valid range [");
            Object object2 = object.getUpper();
            stringBuilder.append(object2);
            stringBuilder.append("..");
            object2 = object.getLower();
            stringBuilder.append(object2);
            stringBuilder.append("]");
            object2 = stringBuilder.toString();
            serializable = new IllegalArgumentException((String)object2);
            return Futures.immediateFailedFuture((Throwable)serializable);
        }
        this.mExposureStateImpl.setExposureCompensationIndex(n10);
        object = new l0(this, n10);
        return Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter$Resolver)object));
    }
}

