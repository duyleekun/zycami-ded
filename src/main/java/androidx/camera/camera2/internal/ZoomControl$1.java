/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.TotalCaptureResult
 */
package androidx.camera.camera2.internal;

import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.internal.Camera2CameraControlImpl$CaptureResultListener;
import androidx.camera.camera2.internal.ZoomControl;

public class ZoomControl$1
implements Camera2CameraControlImpl$CaptureResultListener {
    public final /* synthetic */ ZoomControl this$0;

    public ZoomControl$1(ZoomControl zoomControl) {
        this.this$0 = zoomControl;
    }

    public boolean onCaptureResult(TotalCaptureResult totalCaptureResult) {
        this.this$0.mZoomImpl.onCaptureResult(totalCaptureResult);
        return false;
    }
}

