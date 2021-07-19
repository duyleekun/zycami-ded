/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.SessionConfig;
import java.util.List;

public interface CameraControlInternal$ControlUpdateCallback {
    public void onCameraControlCaptureRequests(List var1);

    public void onCameraControlUpdateSessionConfig(SessionConfig var1);
}

