/*
 * Decompiled with CFR 0.151.
 */
package b.a.a.d;

import androidx.camera.camera2.internal.Camera2CameraControlImpl;

public final class y0
implements Runnable {
    public final /* synthetic */ Camera2CameraControlImpl a;

    public /* synthetic */ y0(Camera2CameraControlImpl camera2CameraControlImpl) {
        this.a = camera2CameraControlImpl;
    }

    public final void run() {
        this.a.updateSessionConfigSynchronous();
    }
}

