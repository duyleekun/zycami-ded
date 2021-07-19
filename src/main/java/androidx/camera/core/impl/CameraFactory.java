/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.CameraInternal;
import java.util.Set;

public interface CameraFactory {
    public Set getAvailableCameraIds();

    public CameraInternal getCamera(String var1);

    public Object getCameraManager();
}

