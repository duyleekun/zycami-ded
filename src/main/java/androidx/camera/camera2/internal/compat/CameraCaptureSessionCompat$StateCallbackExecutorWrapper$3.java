/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCaptureSession
 *  android.hardware.camera2.CameraCaptureSession$StateCallback
 */
package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCaptureSession;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$StateCallbackExecutorWrapper;

public class CameraCaptureSessionCompat$StateCallbackExecutorWrapper$3
implements Runnable {
    public final /* synthetic */ CameraCaptureSessionCompat$StateCallbackExecutorWrapper this$0;
    public final /* synthetic */ CameraCaptureSession val$session;

    public CameraCaptureSessionCompat$StateCallbackExecutorWrapper$3(CameraCaptureSessionCompat$StateCallbackExecutorWrapper cameraCaptureSessionCompat$StateCallbackExecutorWrapper, CameraCaptureSession cameraCaptureSession) {
        this.this$0 = cameraCaptureSessionCompat$StateCallbackExecutorWrapper;
        this.val$session = cameraCaptureSession;
    }

    public void run() {
        CameraCaptureSession.StateCallback stateCallback = this.this$0.mWrappedCallback;
        CameraCaptureSession cameraCaptureSession = this.val$session;
        stateCallback.onReady(cameraCaptureSession);
    }
}

