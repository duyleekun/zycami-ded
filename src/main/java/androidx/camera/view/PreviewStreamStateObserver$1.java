/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.view;

import androidx.camera.core.CameraInfo;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.view.PreviewStreamStateObserver;
import java.util.List;

public class PreviewStreamStateObserver$1
implements FutureCallback {
    public final /* synthetic */ PreviewStreamStateObserver this$0;
    public final /* synthetic */ List val$callbacksToClear;
    public final /* synthetic */ CameraInfo val$cameraInfo;

    public PreviewStreamStateObserver$1(PreviewStreamStateObserver previewStreamStateObserver, List list, CameraInfo cameraInfo) {
        this.this$0 = previewStreamStateObserver;
        this.val$callbacksToClear = list;
        this.val$cameraInfo = cameraInfo;
    }

    public void onFailure(Throwable object) {
        object = this.this$0;
        boolean bl2 = false;
        CameraCaptureCallback cameraCaptureCallback = null;
        ((PreviewStreamStateObserver)object).mFlowFuture = null;
        object = this.val$callbacksToClear;
        boolean bl3 = object.isEmpty();
        if (!bl3) {
            object = this.val$callbacksToClear.iterator();
            while (bl2 = object.hasNext()) {
                cameraCaptureCallback = (CameraCaptureCallback)object.next();
                CameraInfoInternal cameraInfoInternal = (CameraInfoInternal)this.val$cameraInfo;
                cameraInfoInternal.removeSessionCaptureCallback(cameraCaptureCallback);
            }
            object = this.val$callbacksToClear;
            object.clear();
        }
    }

    public void onSuccess(Void void_) {
        this.this$0.mFlowFuture = null;
    }
}

