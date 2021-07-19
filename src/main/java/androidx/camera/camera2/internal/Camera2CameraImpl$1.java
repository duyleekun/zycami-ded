/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.Camera2CameraImpl;
import androidx.camera.camera2.internal.Camera2CameraImpl$3;
import androidx.camera.camera2.internal.CaptureSession;
import androidx.camera.core.impl.utils.futures.FutureCallback;

public class Camera2CameraImpl$1
implements FutureCallback {
    public final /* synthetic */ Camera2CameraImpl this$0;
    public final /* synthetic */ CaptureSession val$captureSession;

    public Camera2CameraImpl$1(Camera2CameraImpl camera2CameraImpl, CaptureSession captureSession) {
        this.this$0 = camera2CameraImpl;
        this.val$captureSession = captureSession;
    }

    public void onFailure(Throwable throwable) {
    }

    public void onSuccess(Void object) {
        block6: {
            Object object2;
            int n10;
            Object object3;
            block4: {
                block5: {
                    object = this.this$0.mReleasedCaptureSessions;
                    object3 = this.val$captureSession;
                    object.remove(object3);
                    object = Camera2CameraImpl$3.$SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState;
                    object3 = this.this$0.mState;
                    n10 = ((Enum)object3).ordinal();
                    object2 = object[n10];
                    n10 = 3;
                    if (object2 == n10) break block4;
                    n10 = 6;
                    if (object2 == n10) break block5;
                    n10 = 7;
                    if (object2 == n10) break block4;
                    break block6;
                }
                object = this.this$0;
                object2 = ((Camera2CameraImpl)object).mCameraDeviceError;
                if (object2 == false) break block6;
            }
            if ((object2 = (Object)((Camera2CameraImpl)(object = this.this$0)).isSessionCloseComplete()) != false && (object = this.this$0.mCameraDevice) != null) {
                object.close();
                object = this.this$0;
                n10 = 0;
                object3 = null;
                ((Camera2CameraImpl)object).mCameraDevice = null;
            }
        }
    }
}

