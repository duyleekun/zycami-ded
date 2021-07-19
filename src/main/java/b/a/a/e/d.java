/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.TotalCaptureResult
 */
package b.a.a.e;

import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.internal.Camera2CameraControlImpl$CaptureResultListener;
import androidx.camera.camera2.interop.Camera2CameraControl;

public final class d
implements Camera2CameraControlImpl$CaptureResultListener {
    public final /* synthetic */ Camera2CameraControl a;

    public /* synthetic */ d(Camera2CameraControl camera2CameraControl) {
        this.a = camera2CameraControl;
    }

    public final boolean onCaptureResult(TotalCaptureResult totalCaptureResult) {
        return this.a.j(totalCaptureResult);
    }
}

