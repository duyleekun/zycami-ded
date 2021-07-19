/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.view;

import androidx.camera.core.FocusMeteringResult;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.view.CameraView;

public class CameraView$3
implements FutureCallback {
    public final /* synthetic */ CameraView this$0;

    public CameraView$3(CameraView cameraView) {
        this.this$0 = cameraView;
    }

    public void onFailure(Throwable throwable) {
        RuntimeException runtimeException = new RuntimeException(throwable);
        throw runtimeException;
    }

    public void onSuccess(FocusMeteringResult focusMeteringResult) {
    }
}

