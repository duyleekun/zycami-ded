/*
 * Decompiled with CFR 0.151.
 */
package b.a.a.d;

import androidx.camera.camera2.internal.Camera2CameraImpl;

public final class x
implements Runnable {
    public final /* synthetic */ Camera2CameraImpl a;

    public /* synthetic */ x(Camera2CameraImpl camera2CameraImpl) {
        this.a = camera2CameraImpl;
    }

    public final void run() {
        Camera2CameraImpl.d(this.a);
    }
}

