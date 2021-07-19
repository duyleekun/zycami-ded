/*
 * Decompiled with CFR 0.151.
 */
package b.a.a.d;

import androidx.camera.camera2.internal.Camera2CameraControlImpl;

public final class k
implements Runnable {
    public final /* synthetic */ Camera2CameraControlImpl a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ boolean c;

    public /* synthetic */ k(Camera2CameraControlImpl camera2CameraControlImpl, boolean bl2, boolean bl3) {
        this.a = camera2CameraControlImpl;
        this.b = bl2;
        this.c = bl3;
    }

    public final void run() {
        Camera2CameraControlImpl camera2CameraControlImpl = this.a;
        boolean bl2 = this.b;
        boolean bl3 = this.c;
        camera2CameraControlImpl.e(bl2, bl3);
    }
}

