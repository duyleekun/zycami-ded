/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.impl.CameraConfig;
import java.util.LinkedHashSet;

public interface Camera {
    public CameraControl getCameraControl();

    public CameraInfo getCameraInfo();

    public LinkedHashSet getCameraInternals();

    public CameraConfig getExtendedConfig();

    public void setExtendedConfig(CameraConfig var1);
}

