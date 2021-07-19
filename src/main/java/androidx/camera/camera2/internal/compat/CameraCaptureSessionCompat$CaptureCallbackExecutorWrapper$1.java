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
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper;

public class CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$1
implements Runnable {
    public final /* synthetic */ CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper this$0;
    public final /* synthetic */ long val$frameNumber;
    public final /* synthetic */ CaptureRequest val$request;
    public final /* synthetic */ CameraCaptureSession val$session;
    public final /* synthetic */ long val$timestamp;

    public CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$1(CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper captureCallbackExecutorWrapper, CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long l10, long l11) {
        this.this$0 = captureCallbackExecutorWrapper;
        this.val$session = cameraCaptureSession;
        this.val$request = captureRequest;
        this.val$timestamp = l10;
        this.val$frameNumber = l11;
    }

    public void run() {
        CameraCaptureSession.CaptureCallback captureCallback = this.this$0.mWrappedCallback;
        CameraCaptureSession cameraCaptureSession = this.val$session;
        CaptureRequest captureRequest = this.val$request;
        long l10 = this.val$timestamp;
        long l11 = this.val$frameNumber;
        captureCallback.onCaptureStarted(cameraCaptureSession, captureRequest, l10, l11);
    }
}

