/*
 * Decompiled with CFR 0.151.
 */
package b.a.a.e;

import androidx.camera.camera2.interop.Camera2CameraControl;

public final class g
implements Runnable {
    public final /* synthetic */ Camera2CameraControl a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ g(Camera2CameraControl camera2CameraControl, boolean bl2) {
        this.a = camera2CameraControl;
        this.b = bl2;
    }

    public final void run() {
        Camera2CameraControl camera2CameraControl = this.a;
        boolean bl2 = this.b;
        camera2CameraControl.l(bl2);
    }
}

