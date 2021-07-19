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
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$StateCallbackExecutorWrapper;

public class CameraCaptureSessionCompat$StateCallbackExecutorWrapper$7
implements Runnable {
    public final /* synthetic */ CameraCaptureSessionCompat$StateCallbackExecutorWrapper this$0;
    public final /* synthetic */ CameraCaptureSession val$session;
    public final /* synthetic */ Surface val$surface;

    public CameraCaptureSessionCompat$StateCallbackExecutorWrapper$7(CameraCaptureSessionCompat$StateCallbackExecutorWrapper cameraCaptureSessionCompat$StateCallbackExecutorWrapper, CameraCaptureSession cameraCaptureSession, Surface surface) {
        this.this$0 = cameraCaptureSessionCompat$StateCallbackExecutorWrapper;
        this.val$session = cameraCaptureSession;
        this.val$surface = surface;
    }

    public void run() {
        CameraCaptureSession.StateCallback stateCallback = this.this$0.mWrappedCallback;
        CameraCaptureSession cameraCaptureSession = this.val$session;
        Surface surface = this.val$surface;
        stateCallback.onSurfacePrepared(cameraCaptureSession, surface);
    }
}

