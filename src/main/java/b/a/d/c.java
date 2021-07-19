/*
 * Decompiled with CFR 0.151.
 */
package b.a.d;

import androidx.arch.core.util.Function;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.CameraController;

public final class c
implements Function {
    public final /* synthetic */ CameraController a;

    public /* synthetic */ c(CameraController cameraController) {
        this.a = cameraController;
    }

    public final Object apply(Object object) {
        CameraController cameraController = this.a;
        object = (ProcessCameraProvider)object;
        return cameraController.b((ProcessCameraProvider)object);
    }
}

