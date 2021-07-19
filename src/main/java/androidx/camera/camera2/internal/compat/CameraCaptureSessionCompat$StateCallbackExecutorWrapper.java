/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCaptureSession
 *  android.hardware.camera2.CameraCaptureSession$StateCallback
 *  android.view.Surface
 */
package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCaptureSession;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$StateCallbackExecutorWrapper$1;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$StateCallbackExecutorWrapper$2;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$StateCallbackExecutorWrapper$3;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$StateCallbackExecutorWrapper$4;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$StateCallbackExecutorWrapper$5;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$StateCallbackExecutorWrapper$6;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$StateCallbackExecutorWrapper$7;
import java.util.concurrent.Executor;

public final class CameraCaptureSessionCompat$StateCallbackExecutorWrapper
extends CameraCaptureSession.StateCallback {
    private final Executor mExecutor;
    public final CameraCaptureSession.StateCallback mWrappedCallback;

    public CameraCaptureSessionCompat$StateCallbackExecutorWrapper(Executor executor, CameraCaptureSession.StateCallback stateCallback) {
        this.mExecutor = executor;
        this.mWrappedCallback = stateCallback;
    }

    public void onActive(CameraCaptureSession cameraCaptureSession) {
        Executor executor = this.mExecutor;
        CameraCaptureSessionCompat$StateCallbackExecutorWrapper$4 cameraCaptureSessionCompat$StateCallbackExecutorWrapper$4 = new CameraCaptureSessionCompat$StateCallbackExecutorWrapper$4(this, cameraCaptureSession);
        executor.execute(cameraCaptureSessionCompat$StateCallbackExecutorWrapper$4);
    }

    public void onCaptureQueueEmpty(CameraCaptureSession cameraCaptureSession) {
        Executor executor = this.mExecutor;
        CameraCaptureSessionCompat$StateCallbackExecutorWrapper$5 cameraCaptureSessionCompat$StateCallbackExecutorWrapper$5 = new CameraCaptureSessionCompat$StateCallbackExecutorWrapper$5(this, cameraCaptureSession);
        executor.execute(cameraCaptureSessionCompat$StateCallbackExecutorWrapper$5);
    }

    public void onClosed(CameraCaptureSession cameraCaptureSession) {
        Executor executor = this.mExecutor;
        CameraCaptureSessionCompat$StateCallbackExecutorWrapper$6 cameraCaptureSessionCompat$StateCallbackExecutorWrapper$6 = new CameraCaptureSessionCompat$StateCallbackExecutorWrapper$6(this, cameraCaptureSession);
        executor.execute(cameraCaptureSessionCompat$StateCallbackExecutorWrapper$6);
    }

    public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
        Executor executor = this.mExecutor;
        CameraCaptureSessionCompat$StateCallbackExecutorWrapper$2 cameraCaptureSessionCompat$StateCallbackExecutorWrapper$2 = new CameraCaptureSessionCompat$StateCallbackExecutorWrapper$2(this, cameraCaptureSession);
        executor.execute(cameraCaptureSessionCompat$StateCallbackExecutorWrapper$2);
    }

    public void onConfigured(CameraCaptureSession cameraCaptureSession) {
        Executor executor = this.mExecutor;
        CameraCaptureSessionCompat$StateCallbackExecutorWrapper$1 cameraCaptureSessionCompat$StateCallbackExecutorWrapper$1 = new CameraCaptureSessionCompat$StateCallbackExecutorWrapper$1(this, cameraCaptureSession);
        executor.execute(cameraCaptureSessionCompat$StateCallbackExecutorWrapper$1);
    }

    public void onReady(CameraCaptureSession cameraCaptureSession) {
        Executor executor = this.mExecutor;
        CameraCaptureSessionCompat$StateCallbackExecutorWrapper$3 cameraCaptureSessionCompat$StateCallbackExecutorWrapper$3 = new CameraCaptureSessionCompat$StateCallbackExecutorWrapper$3(this, cameraCaptureSession);
        executor.execute(cameraCaptureSessionCompat$StateCallbackExecutorWrapper$3);
    }

    public void onSurfacePrepared(CameraCaptureSession cameraCaptureSession, Surface surface) {
        Executor executor = this.mExecutor;
        CameraCaptureSessionCompat$StateCallbackExecutorWrapper$7 cameraCaptureSessionCompat$StateCallbackExecutorWrapper$7 = new CameraCaptureSessionCompat$StateCallbackExecutorWrapper$7(this, cameraCaptureSession, surface);
        executor.execute(cameraCaptureSessionCompat$StateCallbackExecutorWrapper$7);
    }
}

