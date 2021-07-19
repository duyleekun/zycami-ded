/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.camera2;

import androidx.camera.camera2.Camera2Config;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.CameraXConfig$Provider;

public final class Camera2Config$DefaultProvider
implements CameraXConfig$Provider {
    public CameraXConfig getCameraXConfig() {
        return Camera2Config.defaultConfig();
    }
}

