/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.Camera2CameraImpl;
import androidx.camera.core.impl.CameraControlInternal$ControlUpdateCallback;
import androidx.camera.core.impl.SessionConfig;
import androidx.core.util.Preconditions;
import java.util.List;

public final class Camera2CameraImpl$ControlUpdateListenerInternal
implements CameraControlInternal$ControlUpdateCallback {
    public final /* synthetic */ Camera2CameraImpl this$0;

    public Camera2CameraImpl$ControlUpdateListenerInternal(Camera2CameraImpl camera2CameraImpl) {
        this.this$0 = camera2CameraImpl;
    }

    public void onCameraControlCaptureRequests(List list) {
        Camera2CameraImpl camera2CameraImpl = this.this$0;
        list = (List)Preconditions.checkNotNull(list);
        camera2CameraImpl.submitCaptureRequests(list);
    }

    public void onCameraControlUpdateSessionConfig(SessionConfig sessionConfig) {
        Camera2CameraImpl camera2CameraImpl = this.this$0;
        camera2CameraImpl.mCameraControlSessionConfig = sessionConfig = (SessionConfig)Preconditions.checkNotNull(sessionConfig);
        this.this$0.updateCaptureSessionConfig();
    }
}

