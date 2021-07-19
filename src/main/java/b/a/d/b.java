/*
 * Decompiled with CFR 0.151.
 */
package b.a.d;

import androidx.camera.view.CameraController;

public final class b
implements Runnable {
    public final /* synthetic */ CameraController a;
    public final /* synthetic */ int b;

    public /* synthetic */ b(CameraController cameraController, int n10) {
        this.a = cameraController;
        this.b = n10;
    }

    public final void run() {
        CameraController cameraController = this.a;
        int n10 = this.b;
        cameraController.f(n10);
    }
}

