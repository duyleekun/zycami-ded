/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.TotalCaptureResult
 */
package b.a.a.d;

import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.internal.Camera2CameraControlImpl$CaptureResultListener;
import androidx.camera.camera2.internal.FocusMeteringControl;

public final class t0
implements Camera2CameraControlImpl$CaptureResultListener {
    public final /* synthetic */ FocusMeteringControl a;
    public final /* synthetic */ int b;

    public /* synthetic */ t0(FocusMeteringControl focusMeteringControl, int n10) {
        this.a = focusMeteringControl;
        this.b = n10;
    }

    public final boolean onCaptureResult(TotalCaptureResult totalCaptureResult) {
        FocusMeteringControl focusMeteringControl = this.a;
        int n10 = this.b;
        return focusMeteringControl.f(n10, totalCaptureResult);
    }
}

