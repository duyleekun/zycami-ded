/*
 * Decompiled with CFR 0.151.
 */
package b.a.a.d;

import androidx.camera.camera2.internal.Camera2CameraControlImpl;

public final class g
implements Runnable {
    public final /* synthetic */ Camera2CameraControlImpl a;

    public /* synthetic */ g(Camera2CameraControlImpl camera2CameraControlImpl) {
        this.a = camera2CameraControlImpl;
    }

    public final void run() {
        this.a.h();
    }
}

