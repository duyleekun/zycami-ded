/*
 * Decompiled with CFR 0.151.
 */
package b.a.a.d;

import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import java.util.List;

public final class n
implements Runnable {
    public final /* synthetic */ Camera2CameraControlImpl a;
    public final /* synthetic */ List b;

    public /* synthetic */ n(Camera2CameraControlImpl camera2CameraControlImpl, List list) {
        this.a = camera2CameraControlImpl;
        this.b = list;
    }

    public final void run() {
        Camera2CameraControlImpl camera2CameraControlImpl = this.a;
        List list = this.b;
        camera2CameraControlImpl.l(list);
    }
}

