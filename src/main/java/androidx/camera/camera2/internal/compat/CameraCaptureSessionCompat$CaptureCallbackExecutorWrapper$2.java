/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCaptureSession
 *  android.hardware.camera2.CameraCaptureSession$CaptureCallback
 *  android.hardware.camera2.CaptureRequest
 *  android.hardware.camera2.CaptureResult
 */
package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper;

public class CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$2
implements Runnable {
    public final /* synthetic */ CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper this$0;
    public final /* synthetic */ CaptureResult val$partialResult;
    public final /* synthetic */ CaptureRequest val$request;
    public final /* synthetic */ CameraCaptureSession val$session;

    public CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$2(CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper cameraCaptureSessionCompat$CaptureCallbackExecutorWrapper, CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
        this.this$0 = cameraCaptureSessionCompat$CaptureCallbackExecutorWrapper;
        this.val$session = cameraCaptureSession;
        this.val$request = captureRequest;
        this.val$partialResult = captureResult;
    }

    public void run() {
        CameraCaptureSession.CaptureCallback captureCallback = this.this$0.mWrappedCallback;
        CameraCaptureSession cameraCaptureSession = this.val$session;
        CaptureRequest captureRequest = this.val$request;
        CaptureResult captureResult = this.val$partialResult;
        captureCallback.onCaptureProgressed(cameraCaptureSession, captureRequest, captureResult);
    }
}

