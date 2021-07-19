/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCaptureSession
 *  android.hardware.camera2.CameraCaptureSession$CaptureCallback
 */
package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCaptureSession;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper;

public class CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$5
implements Runnable {
    public final /* synthetic */ CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper this$0;
    public final /* synthetic */ long val$frameNumber;
    public final /* synthetic */ int val$sequenceId;
    public final /* synthetic */ CameraCaptureSession val$session;

    public CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$5(CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper cameraCaptureSessionCompat$CaptureCallbackExecutorWrapper, CameraCaptureSession cameraCaptureSession, int n10, long l10) {
        this.this$0 = cameraCaptureSessionCompat$CaptureCallbackExecutorWrapper;
        this.val$session = cameraCaptureSession;
        this.val$sequenceId = n10;
        this.val$frameNumber = l10;
    }

    public void run() {
        CameraCaptureSession.CaptureCallback captureCallback = this.this$0.mWrappedCallback;
        CameraCaptureSession cameraCaptureSession = this.val$session;
        int n10 = this.val$sequenceId;
        long l10 = this.val$frameNumber;
        captureCallback.onCaptureSequenceCompleted(cameraCaptureSession, n10, l10);
    }
}

