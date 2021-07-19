/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.TotalCaptureResult
 */
package b.a.a.d;

import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.internal.Camera2CameraControlImpl$CaptureResultListener;
import androidx.camera.camera2.internal.ExposureControl;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;

public final class n0
implements Camera2CameraControlImpl$CaptureResultListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ CallbackToFutureAdapter$Completer b;

    public /* synthetic */ n0(int n10, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        this.a = n10;
        this.b = callbackToFutureAdapter$Completer;
    }

    public final boolean onCaptureResult(TotalCaptureResult totalCaptureResult) {
        int n10 = this.a;
        CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = this.b;
        return ExposureControl.a(n10, callbackToFutureAdapter$Completer, totalCaptureResult);
    }
}

