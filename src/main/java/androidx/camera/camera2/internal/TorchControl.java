/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCharacteristics
 *  android.hardware.camera2.CameraCharacteristics$Key
 */
package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.camera2.internal.Camera2CameraControlImpl$CaptureResultListener;
import androidx.camera.camera2.internal.TorchControl$1;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.CameraControl$OperationCanceledException;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import b.a.a.d.h1;
import b.a.a.d.i1;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

public final class TorchControl {
    public static final int DEFAULT_TORCH_STATE = 0;
    private static final String TAG = "TorchControl";
    private final Camera2CameraControlImpl mCamera2CameraControlImpl;
    private final Camera2CameraControlImpl$CaptureResultListener mCaptureResultListener;
    public CallbackToFutureAdapter$Completer mEnableTorchCompleter;
    private final Executor mExecutor;
    private final boolean mHasFlashUnit;
    private boolean mIsActive;
    public boolean mTargetTorchEnabled;
    private final MutableLiveData mTorchState;

    public TorchControl(Camera2CameraControlImpl camera2CameraControlImpl, CameraCharacteristicsCompat object, Executor object2) {
        boolean bl2;
        TorchControl$1 torchControl$1 = new TorchControl$1(this);
        this.mCaptureResultListener = torchControl$1;
        this.mCamera2CameraControlImpl = camera2CameraControlImpl;
        this.mExecutor = object2;
        object2 = CameraCharacteristics.FLASH_INFO_AVAILABLE;
        object = (Boolean)((CameraCharacteristicsCompat)object).get((CameraCharacteristics.Key)object2);
        object2 = null;
        if (object != null && (bl2 = ((Boolean)object).booleanValue())) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        this.mHasFlashUnit = bl2;
        object2 = 0;
        this.mTorchState = object = new MutableLiveData(object2);
        camera2CameraControlImpl.addCaptureResultListener(torchControl$1);
    }

    private /* synthetic */ void a(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer, boolean bl2) {
        this.enableTorchInternal(callbackToFutureAdapter$Completer, bl2);
    }

    private /* synthetic */ Object c(boolean bl2, CallbackToFutureAdapter$Completer object) {
        Executor executor = this.mExecutor;
        h1 h12 = new h1(this, (CallbackToFutureAdapter$Completer)object, bl2);
        executor.execute(h12);
        object = new StringBuilder();
        ((StringBuilder)object).append("enableTorch: ");
        ((StringBuilder)object).append(bl2);
        return ((StringBuilder)object).toString();
    }

    private void setLiveDataValue(MutableLiveData mutableLiveData, Object object) {
        boolean bl2 = Threads.isMainThread();
        if (bl2) {
            mutableLiveData.setValue(object);
        } else {
            mutableLiveData.postValue(object);
        }
    }

    public /* synthetic */ void b(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer, boolean bl2) {
        this.a(callbackToFutureAdapter$Completer, bl2);
    }

    public /* synthetic */ Object d(boolean bl2, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return this.c(bl2, callbackToFutureAdapter$Completer);
    }

    public ListenableFuture enableTorch(boolean bl2) {
        boolean bl3 = this.mHasFlashUnit;
        if (!bl3) {
            Logger.d(TAG, "Unable to enableTorch due to there is no flash unit.");
            IllegalStateException illegalStateException = new IllegalStateException("No flash unit");
            return Futures.immediateFailedFuture(illegalStateException);
        }
        Object object = this.mTorchState;
        Integer n10 = bl2 ? 1 : 0;
        this.setLiveDataValue((MutableLiveData)object, n10);
        object = new i1(this, bl2);
        return CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter$Resolver)object);
    }

    public void enableTorchInternal(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer, boolean bl2) {
        boolean bl3 = this.mIsActive;
        if (!bl3) {
            Object object = this.mTorchState;
            Integer n10 = 0;
            this.setLiveDataValue((MutableLiveData)object, n10);
            object = new CameraControl$OperationCanceledException("Camera is not active.");
            callbackToFutureAdapter$Completer.setException((Throwable)object);
            return;
        }
        this.mTargetTorchEnabled = bl2;
        this.mCamera2CameraControlImpl.enableTorchInternal(bl2);
        Object object = this.mTorchState;
        Object object2 = bl2 ? 1 : 0;
        this.setLiveDataValue((MutableLiveData)object, object2);
        object2 = this.mEnableTorchCompleter;
        if (object2 != null) {
            String string2 = "There is a new enableTorch being set";
            object = new CameraControl$OperationCanceledException(string2);
            ((CallbackToFutureAdapter$Completer)object2).setException((Throwable)object);
        }
        this.mEnableTorchCompleter = callbackToFutureAdapter$Completer;
    }

    public LiveData getTorchState() {
        return this.mTorchState;
    }

    public void setActive(boolean bl2) {
        boolean bl3 = this.mIsActive;
        if (bl3 == bl2) {
            return;
        }
        this.mIsActive = bl2;
        if (!bl2) {
            Object object;
            Object object2;
            bl2 = this.mTargetTorchEnabled;
            if (bl2) {
                bl2 = false;
                this.mTargetTorchEnabled = false;
                this.mCamera2CameraControlImpl.enableTorchInternal(false);
                object2 = this.mTorchState;
                object = 0;
                this.setLiveDataValue((MutableLiveData)object2, object);
            }
            if ((object = this.mEnableTorchCompleter) != null) {
                String string2 = "Camera is not active.";
                object2 = new CameraControl$OperationCanceledException(string2);
                ((CallbackToFutureAdapter$Completer)object).setException((Throwable)object2);
                bl2 = false;
                object = null;
                this.mEnableTorchCompleter = null;
            }
        }
    }
}

