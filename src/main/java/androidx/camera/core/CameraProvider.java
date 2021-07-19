/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.CameraSelector;
import java.util.List;

public interface CameraProvider {
    public List getAvailableCameraInfos();

    public boolean hasCamera(CameraSelector var1);
}

