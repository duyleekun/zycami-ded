/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCaptureSession
 *  android.hardware.camera2.CameraCaptureSession$CaptureCallback
 *  android.hardware.camera2.CaptureFailure
 *  android.hardware.camera2.CaptureRequest
 *  android.hardware.camera2.CaptureResult
 *  android.hardware.camera2.TotalCaptureResult
 */
package d.v.d.g.d;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import d.v.d.g.d.n;
import d.v.d.h.f;
import d.v.d.i.f.u;

public class n$c
extends CameraCaptureSession.CaptureCallback {
    public final /* synthetic */ n a;

    public n$c(n n10) {
        this.a = n10;
    }

    public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        u u10 = this.a.y();
        Integer n10 = 3;
        u10.r(n10);
        this.a.E().q(n10);
        this.a.M((CaptureResult)totalCaptureResult);
        this.a.h((CaptureResult)totalCaptureResult, captureRequest);
        super.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
    }

    public void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
        f.a("onCaptureFailed ");
        super.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
    }

    public void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
        this.a.M(captureResult);
        super.onCaptureProgressed(cameraCaptureSession, captureRequest, captureResult);
    }

    public void onCaptureSequenceAborted(CameraCaptureSession cameraCaptureSession, int n10) {
        f.a("onCaptureSequenceAborted");
        super.onCaptureSequenceAborted(cameraCaptureSession, n10);
    }

    public void onCaptureSequenceCompleted(CameraCaptureSession cameraCaptureSession, int n10, long l10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onCaptureSequenceCompleted sequenceId=");
        stringBuilder.append(n10);
        f.a(stringBuilder.toString());
        super.onCaptureSequenceCompleted(cameraCaptureSession, n10, l10);
    }
}

