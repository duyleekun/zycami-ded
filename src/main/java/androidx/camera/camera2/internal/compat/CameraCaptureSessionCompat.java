/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCaptureSession
 *  android.hardware.camera2.CameraCaptureSession$CaptureCallback
 *  android.hardware.camera2.CaptureRequest
 *  android.os.Build$VERSION
 *  android.os.Handler
 */
package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.os.Build;
import android.os.Handler;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$CameraCaptureSessionCompatImpl;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompatBaseImpl;
import androidx.camera.core.impl.utils.MainThreadAsyncHandler;
import java.util.List;
import java.util.concurrent.Executor;

public final class CameraCaptureSessionCompat {
    private final CameraCaptureSessionCompat$CameraCaptureSessionCompatImpl mImpl;

    private CameraCaptureSessionCompat(CameraCaptureSession object, Handler object2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            super((CameraCaptureSession)object);
            this.mImpl = object2;
        } else {
            object = CameraCaptureSessionCompatBaseImpl.create(object, object2);
            this.mImpl = object;
        }
    }

    public static CameraCaptureSessionCompat toCameraCaptureSessionCompat(CameraCaptureSession cameraCaptureSession) {
        Handler handler = MainThreadAsyncHandler.getInstance();
        return CameraCaptureSessionCompat.toCameraCaptureSessionCompat(cameraCaptureSession, handler);
    }

    public static CameraCaptureSessionCompat toCameraCaptureSessionCompat(CameraCaptureSession cameraCaptureSession, Handler handler) {
        CameraCaptureSessionCompat cameraCaptureSessionCompat = new CameraCaptureSessionCompat(cameraCaptureSession, handler);
        return cameraCaptureSessionCompat;
    }

    public int captureBurstRequests(List list, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) {
        return this.mImpl.captureBurstRequests(list, executor, captureCallback);
    }

    public int captureSingleRequest(CaptureRequest captureRequest, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) {
        return this.mImpl.captureSingleRequest(captureRequest, executor, captureCallback);
    }

    public int setRepeatingBurstRequests(List list, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) {
        return this.mImpl.setRepeatingBurstRequests(list, executor, captureCallback);
    }

    public int setSingleRepeatingRequest(CaptureRequest captureRequest, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) {
        return this.mImpl.setSingleRepeatingRequest(captureRequest, executor, captureCallback);
    }

    public CameraCaptureSession toCameraCaptureSession() {
        return this.mImpl.unwrap();
    }
}

