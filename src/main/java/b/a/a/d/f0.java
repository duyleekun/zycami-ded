/*
 * Decompiled with CFR 0.151.
 */
package b.a.a.d;

import androidx.camera.camera2.internal.Camera2CameraImpl;
import androidx.camera.core.UseCase;

public final class f0
implements Runnable {
    public final /* synthetic */ Camera2CameraImpl a;
    public final /* synthetic */ UseCase b;

    public /* synthetic */ f0(Camera2CameraImpl camera2CameraImpl, UseCase useCase) {
        this.a = camera2CameraImpl;
        this.b = useCase;
    }

    public final void run() {
        Camera2CameraImpl camera2CameraImpl = this.a;
        UseCase useCase = this.b;
        camera2CameraImpl.u(useCase);
    }
}

