/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCaptureSession
 *  android.hardware.camera2.CameraCaptureSession$CaptureCallback
 *  android.hardware.camera2.CaptureRequest
 *  android.view.Surface
 */
package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper;

public class CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$7
implements Runnable {
    public final /* synthetic */ CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper this$0;
    public final /* synthetic */ long val$frameNumber;
    public final /* synthetic */ CaptureRequest val$request;
    public final /* synthetic */ CameraCaptureSession val$session;
    public final /* synthetic */ Surface val$target;

    public CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$7(CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper cameraCaptureSessionCompat$CaptureCallbackExecutorWrapper, CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, Surface surface, long l10) {
        this.this$0 = cameraCaptureSessionCompat$CaptureCallbackExecutorWrapper;
        this.val$session = cameraCaptureSession;
        this.val$request = captureRequest;
        this.val$target = surface;
        this.val$frameNumber = l10;
    }

    public void run() {
        CameraCaptureSession.CaptureCallback captureCallback = this.this$0.mWrappedCallback;
        CameraCaptureSession cameraCaptureSession = this.val$session;
        CaptureRequest captureRequest = this.val$request;
        Surface surface = this.val$target;
        long l10 = this.val$frameNumber;
        captureCallback.onCaptureBufferLost(cameraCaptureSession, captureRequest, surface, l10);
    }
}

