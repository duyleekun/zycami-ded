/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.TotalCaptureResult
 */
package b.a.a.d;

import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.internal.Camera2CameraControlImpl$CameraControlSessionCallback;

public final class f
implements Runnable {
    public final /* synthetic */ Camera2CameraControlImpl$CameraControlSessionCallback a;
    public final /* synthetic */ TotalCaptureResult b;

    public /* synthetic */ f(Camera2CameraControlImpl$CameraControlSessionCallback camera2CameraControlImpl$CameraControlSessionCallback, TotalCaptureResult totalCaptureResult) {
        this.a = camera2CameraControlImpl$CameraControlSessionCallback;
        this.b = totalCaptureResult;
    }

    public final void run() {
        Camera2CameraControlImpl$CameraControlSessionCallback camera2CameraControlImpl$CameraControlSessionCallback = this.a;
        TotalCaptureResult totalCaptureResult = this.b;
        camera2CameraControlImpl$CameraControlSessionCallback.b(totalCaptureResult);
    }
}

