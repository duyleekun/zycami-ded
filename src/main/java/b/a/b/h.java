/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.CameraX;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.CameraXConfig$Provider;

public final class h
implements CameraXConfig$Provider {
    public final /* synthetic */ CameraXConfig a;

    public /* synthetic */ h(CameraXConfig cameraXConfig) {
        this.a = cameraXConfig;
    }

    public final CameraXConfig getCameraXConfig() {
        CameraXConfig cameraXConfig = this.a;
        CameraX.a(cameraXConfig);
        return cameraXConfig;
    }
}

