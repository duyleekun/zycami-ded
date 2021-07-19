/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.TotalCaptureResult
 *  android.hardware.camera2.params.MeteringRectangle
 */
package b.a.a.d;

import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import androidx.camera.camera2.internal.Camera2CameraControlImpl$CaptureResultListener;
import androidx.camera.camera2.internal.FocusMeteringControl;

public final class s0
implements Camera2CameraControlImpl$CaptureResultListener {
    public final /* synthetic */ FocusMeteringControl a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ MeteringRectangle[] c;
    public final /* synthetic */ MeteringRectangle[] d;
    public final /* synthetic */ MeteringRectangle[] e;

    public /* synthetic */ s0(FocusMeteringControl focusMeteringControl, boolean bl2, MeteringRectangle[] meteringRectangleArray, MeteringRectangle[] meteringRectangleArray2, MeteringRectangle[] meteringRectangleArray3) {
        this.a = focusMeteringControl;
        this.b = bl2;
        this.c = meteringRectangleArray;
        this.d = meteringRectangleArray2;
        this.e = meteringRectangleArray3;
    }

    public final boolean onCaptureResult(TotalCaptureResult totalCaptureResult) {
        FocusMeteringControl focusMeteringControl = this.a;
        boolean bl2 = this.b;
        MeteringRectangle[] meteringRectangleArray = this.c;
        MeteringRectangle[] meteringRectangleArray2 = this.d;
        MeteringRectangle[] meteringRectangleArray3 = this.e;
        return focusMeteringControl.h(bl2, meteringRectangleArray, meteringRectangleArray2, meteringRectangleArray3, totalCaptureResult);
    }
}

