/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCaptureSession
 *  android.hardware.camera2.CameraCaptureSession$CaptureCallback
 *  android.hardware.camera2.CaptureRequest
 *  android.hardware.camera2.TotalCaptureResult
 */
package d.v.d.g.d.u.f;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import d.v.d.g.d.u.f.f;

public class f$a
extends CameraCaptureSession.CaptureCallback {
    public final /* synthetic */ f a;

    public f$a(f f10) {
        this.a = f10;
    }

    public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        this.a.p();
    }
}

