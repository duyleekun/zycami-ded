/*
 * Decompiled with CFR 0.151.
 */
package b.a.d;

import androidx.camera.core.CameraSelector;
import androidx.camera.view.CameraController;

public final class d
implements Runnable {
    public final /* synthetic */ CameraController a;
    public final /* synthetic */ CameraSelector b;

    public /* synthetic */ d(CameraController cameraController, CameraSelector cameraSelector) {
        this.a = cameraController;
        this.b = cameraSelector;
    }

    public final void run() {
        CameraController cameraController = this.a;
        CameraSelector cameraSelector = this.b;
        cameraController.d(cameraSelector);
    }
}

