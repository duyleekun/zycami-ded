/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCaptureSession
 *  android.hardware.camera2.CameraCaptureSession$CaptureCallback
 *  android.hardware.camera2.CaptureRequest
 *  android.os.Handler
 */
package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$CameraCaptureSessionCompatImpl;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompatBaseImpl$CameraCaptureSessionCompatParamsApi21;
import androidx.core.util.Preconditions;
import java.util.List;
import java.util.concurrent.Executor;

public class CameraCaptureSessionCompatBaseImpl
implements CameraCaptureSessionCompat$CameraCaptureSessionCompatImpl {
    public final CameraCaptureSession mCameraCaptureSession;
    public final Object mObject;

    public CameraCaptureSessionCompatBaseImpl(CameraCaptureSession cameraCaptureSession, Object object) {
        this.mCameraCaptureSession = cameraCaptureSession = (CameraCaptureSession)Preconditions.checkNotNull(cameraCaptureSession);
        this.mObject = object;
    }

    public static CameraCaptureSessionCompat$CameraCaptureSessionCompatImpl create(CameraCaptureSession cameraCaptureSession, Handler handler) {
        CameraCaptureSessionCompatBaseImpl$CameraCaptureSessionCompatParamsApi21 cameraCaptureSessionCompatBaseImpl$CameraCaptureSessionCompatParamsApi21 = new CameraCaptureSessionCompatBaseImpl$CameraCaptureSessionCompatParamsApi21(handler);
        CameraCaptureSessionCompatBaseImpl cameraCaptureSessionCompatBaseImpl = new CameraCaptureSessionCompatBaseImpl(cameraCaptureSession, cameraCaptureSessionCompatBaseImpl$CameraCaptureSessionCompatParamsApi21);
        return cameraCaptureSessionCompatBaseImpl;
    }

    public int captureBurstRequests(List list, Executor object, CameraCaptureSession.CaptureCallback captureCallback) {
        CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper cameraCaptureSessionCompat$CaptureCallbackExecutorWrapper = new CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper((Executor)object, captureCallback);
        object = (CameraCaptureSessionCompatBaseImpl$CameraCaptureSessionCompatParamsApi21)this.mObject;
        captureCallback = this.mCameraCaptureSession;
        object = ((CameraCaptureSessionCompatBaseImpl$CameraCaptureSessionCompatParamsApi21)object).mCompatHandler;
        return captureCallback.captureBurst(list, (CameraCaptureSession.CaptureCallback)cameraCaptureSessionCompat$CaptureCallbackExecutorWrapper, (Handler)object);
    }

    public int captureSingleRequest(CaptureRequest captureRequest, Executor object, CameraCaptureSession.CaptureCallback captureCallback) {
        CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper cameraCaptureSessionCompat$CaptureCallbackExecutorWrapper = new CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper((Executor)object, captureCallback);
        object = (CameraCaptureSessionCompatBaseImpl$CameraCaptureSessionCompatParamsApi21)this.mObject;
        captureCallback = this.mCameraCaptureSession;
        object = ((CameraCaptureSessionCompatBaseImpl$CameraCaptureSessionCompatParamsApi21)object).mCompatHandler;
        return captureCallback.capture(captureRequest, (CameraCaptureSession.CaptureCallback)cameraCaptureSessionCompat$CaptureCallbackExecutorWrapper, (Handler)object);
    }

    public int setRepeatingBurstRequests(List list, Executor object, CameraCaptureSession.CaptureCallback captureCallback) {
        CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper cameraCaptureSessionCompat$CaptureCallbackExecutorWrapper = new CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper((Executor)object, captureCallback);
        object = (CameraCaptureSessionCompatBaseImpl$CameraCaptureSessionCompatParamsApi21)this.mObject;
        captureCallback = this.mCameraCaptureSession;
        object = ((CameraCaptureSessionCompatBaseImpl$CameraCaptureSessionCompatParamsApi21)object).mCompatHandler;
        return captureCallback.setRepeatingBurst(list, (CameraCaptureSession.CaptureCallback)cameraCaptureSessionCompat$CaptureCallbackExecutorWrapper, (Handler)object);
    }

    public int setSingleRepeatingRequest(CaptureRequest captureRequest, Executor object, CameraCaptureSession.CaptureCallback captureCallback) {
        CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper cameraCaptureSessionCompat$CaptureCallbackExecutorWrapper = new CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper((Executor)object, captureCallback);
        object = (CameraCaptureSessionCompatBaseImpl$CameraCaptureSessionCompatParamsApi21)this.mObject;
        captureCallback = this.mCameraCaptureSession;
        object = ((CameraCaptureSessionCompatBaseImpl$CameraCaptureSessionCompatParamsApi21)object).mCompatHandler;
        return captureCallback.setRepeatingRequest(captureRequest, (CameraCaptureSession.CaptureCallback)cameraCaptureSessionCompat$CaptureCallbackExecutorWrapper, (Handler)object);
    }

    public CameraCaptureSession unwrap() {
        return this.mCameraCaptureSession;
    }
}

