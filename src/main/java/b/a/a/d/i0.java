/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCaptureSession
 */
package b.a.a.d;

import android.hardware.camera2.CameraCaptureSession;
import androidx.camera.camera2.internal.CameraBurstCaptureCallback$CaptureSequenceCallback;
import androidx.camera.camera2.internal.CaptureSession;

public final class i0
implements CameraBurstCaptureCallback$CaptureSequenceCallback {
    public final /* synthetic */ CaptureSession a;

    public /* synthetic */ i0(CaptureSession captureSession) {
        this.a = captureSession;
    }

    public final void onCaptureSequenceCompletedOrAborted(CameraCaptureSession cameraCaptureSession, int n10, boolean bl2) {
        this.a.b(cameraCaptureSession, n10, bl2);
    }
}

