/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCaptureSession
 *  android.hardware.camera2.CameraCaptureSession$CaptureCallback
 *  android.hardware.camera2.CaptureRequest
 */
package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompatBaseImpl;
import java.util.List;
import java.util.concurrent.Executor;

public class CameraCaptureSessionCompatApi28Impl
extends CameraCaptureSessionCompatBaseImpl {
    public CameraCaptureSessionCompatApi28Impl(CameraCaptureSession cameraCaptureSession) {
        super(cameraCaptureSession, null);
    }

    public int captureBurstRequests(List list, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) {
        return this.mCameraCaptureSession.captureBurstRequests(list, executor, captureCallback);
    }

    public int captureSingleRequest(CaptureRequest captureRequest, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) {
        return this.mCameraCaptureSession.captureSingleRequest(captureRequest, executor, captureCallback);
    }

    public int setRepeatingBurstRequests(List list, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) {
        return this.mCameraCaptureSession.setRepeatingBurstRequests(list, executor, captureCallback);
    }

    public int setSingleRepeatingRequest(CaptureRequest captureRequest, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) {
        return this.mCameraCaptureSession.setSingleRepeatingRequest(captureRequest, executor, captureCallback);
    }
}

