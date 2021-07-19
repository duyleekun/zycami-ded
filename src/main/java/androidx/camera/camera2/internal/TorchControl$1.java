/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CaptureRequest
 *  android.hardware.camera2.CaptureRequest$Key
 *  android.hardware.camera2.TotalCaptureResult
 */
package androidx.camera.camera2.internal;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.internal.Camera2CameraControlImpl$CaptureResultListener;
import androidx.camera.camera2.internal.TorchControl;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;

public class TorchControl$1
implements Camera2CameraControlImpl$CaptureResultListener {
    public final /* synthetic */ TorchControl this$0;

    public TorchControl$1(TorchControl torchControl) {
        this.this$0 = torchControl;
    }

    public boolean onCaptureResult(TotalCaptureResult object) {
        Object object2 = this.this$0.mEnableTorchCompleter;
        if (object2 != null) {
            int n10;
            int n11;
            object = object.getRequest();
            object2 = CaptureRequest.FLASH_MODE;
            if ((object = (Integer)object.get((CaptureRequest.Key)object2)) != null && (n11 = ((Integer)object).intValue()) == (n10 = 2)) {
                n11 = 1;
            } else {
                n11 = 0;
                object = null;
            }
            object2 = this.this$0;
            int n12 = ((TorchControl)object2).mTargetTorchEnabled;
            if (n11 == n12) {
                object = ((TorchControl)object2).mEnableTorchCompleter;
                n10 = 0;
                object2 = null;
                ((CallbackToFutureAdapter$Completer)object).set(null);
                object = this.this$0;
                ((TorchControl)object).mEnableTorchCompleter = null;
            }
        }
        return false;
    }
}

