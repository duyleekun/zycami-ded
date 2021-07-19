/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.CameraInfo;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.Quirks;
import java.util.concurrent.Executor;

public interface CameraInfoInternal
extends CameraInfo {
    public void addSessionCaptureCallback(Executor var1, CameraCaptureCallback var2);

    public String getCameraId();

    public Quirks getCameraQuirks();

    public Integer getLensFacing();

    public void removeSessionCaptureCallback(CameraCaptureCallback var1);
}

