/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCaptureSession
 *  android.hardware.camera2.CameraCaptureSession$CaptureCallback
 *  android.hardware.camera2.CaptureFailure
 *  android.hardware.camera2.CaptureRequest
 *  android.hardware.camera2.CaptureResult
 *  android.hardware.camera2.TotalCaptureResult
 *  android.view.Surface
 */
package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$1;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$2;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$3;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$4;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$5;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$6;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$7;
import java.util.concurrent.Executor;

public final class CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper
extends CameraCaptureSession.CaptureCallback {
    private final Executor mExecutor;
    public final CameraCaptureSession.CaptureCallback mWrappedCallback;

    public CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper(Executor executor, CameraCaptureSession.CaptureCallback captureCallback) {
        this.mExecutor = executor;
        this.mWrappedCallback = captureCallback;
    }

    public void onCaptureBufferLost(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, Surface surface, long l10) {
        Executor executor = this.mExecutor;
        CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$7 cameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$7 = new CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$7(this, cameraCaptureSession, captureRequest, surface, l10);
        executor.execute(cameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$7);
    }

    public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        Executor executor = this.mExecutor;
        CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$3 cameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$3 = new CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$3(this, cameraCaptureSession, captureRequest, totalCaptureResult);
        executor.execute(cameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$3);
    }

    public void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
        Executor executor = this.mExecutor;
        CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$4 cameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$4 = new CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$4(this, cameraCaptureSession, captureRequest, captureFailure);
        executor.execute(cameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$4);
    }

    public void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
        Executor executor = this.mExecutor;
        CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$2 cameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$2 = new CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$2(this, cameraCaptureSession, captureRequest, captureResult);
        executor.execute(cameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$2);
    }

    public void onCaptureSequenceAborted(CameraCaptureSession cameraCaptureSession, int n10) {
        Executor executor = this.mExecutor;
        CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$6 cameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$6 = new CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$6(this, cameraCaptureSession, n10);
        executor.execute(cameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$6);
    }

    public void onCaptureSequenceCompleted(CameraCaptureSession cameraCaptureSession, int n10, long l10) {
        Executor executor = this.mExecutor;
        CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$5 cameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$5 = new CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$5(this, cameraCaptureSession, n10, l10);
        executor.execute(cameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$5);
    }

    public void onCaptureStarted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long l10, long l11) {
        Executor executor = this.mExecutor;
        CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$1 cameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$1 = new CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$1(this, cameraCaptureSession, captureRequest, l10, l11);
        executor.execute(cameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$1);
    }
}

