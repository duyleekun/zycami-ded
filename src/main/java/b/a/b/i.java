/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.CameraX;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.CameraXConfig$Provider;

public final class i
implements CameraXConfig$Provider {
    public final /* synthetic */ CameraXConfig a;

    public /* synthetic */ i(CameraXConfig cameraXConfig) {
        this.a = cameraXConfig;
    }

    public final CameraXConfig getCameraXConfig() {
        CameraXConfig cameraXConfig = this.a;
        CameraX.i(cameraXConfig);
        return cameraXConfig;
    }
}

