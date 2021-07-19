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
package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.internal.Camera2CameraCaptureResult;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CameraCaptureFailure$Reason;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.TagBundle;
import androidx.core.util.Preconditions;
import java.util.Objects;

public final class CaptureCallbackAdapter
extends CameraCaptureSession.CaptureCallback {
    private final CameraCaptureCallback mCameraCaptureCallback;

    public CaptureCallbackAdapter(CameraCaptureCallback cameraCaptureCallback) {
        Objects.requireNonNull(cameraCaptureCallback, "cameraCaptureCallback is null");
        this.mCameraCaptureCallback = cameraCaptureCallback;
    }

    public void onCaptureCompleted(CameraCaptureSession object, CaptureRequest object2, TotalCaptureResult totalCaptureResult) {
        Object object3;
        super.onCaptureCompleted(object, (CaptureRequest)object2, totalCaptureResult);
        object = object2.getTag();
        if (object != null) {
            boolean bl2 = object instanceof TagBundle;
            object3 = "The tagBundle object from the CaptureResult is not a TagBundle object.";
            Preconditions.checkArgument(bl2, object3);
            object = (TagBundle)object;
        } else {
            object = TagBundle.emptyBundle();
        }
        object2 = this.mCameraCaptureCallback;
        object3 = new Camera2CameraCaptureResult((TagBundle)object, (CaptureResult)totalCaptureResult);
        ((CameraCaptureCallback)object2).onCaptureCompleted((CameraCaptureResult)object3);
    }

    public void onCaptureFailed(CameraCaptureSession object, CaptureRequest object2, CaptureFailure captureFailure) {
        super.onCaptureFailed(object, object2, captureFailure);
        object2 = CameraCaptureFailure$Reason.ERROR;
        object = new CameraCaptureFailure((CameraCaptureFailure$Reason)((Object)object2));
        this.mCameraCaptureCallback.onCaptureFailed((CameraCaptureFailure)object);
    }
}

