/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCaptureSession
 *  android.hardware.camera2.CameraCaptureSession$CaptureCallback
 *  android.hardware.camera2.CaptureRequest
 */
package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.internal.SynchronizedCaptureSessionImpl;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;

public class SynchronizedCaptureSessionImpl$1
extends CameraCaptureSession.CaptureCallback {
    public final /* synthetic */ SynchronizedCaptureSessionImpl this$0;

    public SynchronizedCaptureSessionImpl$1(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl) {
        this.this$0 = synchronizedCaptureSessionImpl;
    }

    public void onCaptureSequenceAborted(CameraCaptureSession object, int n10) {
        object = this.this$0.mStartStreamingCompleter;
        if (object != null) {
            ((CallbackToFutureAdapter$Completer)object).setCancelled();
            object = this.this$0;
            ((SynchronizedCaptureSessionImpl)object).mStartStreamingCompleter = null;
        }
    }

    public void onCaptureStarted(CameraCaptureSession object, CaptureRequest captureRequest, long l10, long l11) {
        object = this.this$0.mStartStreamingCompleter;
        if (object != null) {
            ((CallbackToFutureAdapter$Completer)object).set(null);
            object = this.this$0;
            ((SynchronizedCaptureSessionImpl)object).mStartStreamingCompleter = null;
        }
    }
}

