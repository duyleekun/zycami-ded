/*
 * Decompiled with CFR 0.151.
 */
package b.a.b.w1;

import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraRepository;

public final class d
implements Runnable {
    public final /* synthetic */ CameraRepository a;
    public final /* synthetic */ CameraInternal b;

    public /* synthetic */ d(CameraRepository cameraRepository, CameraInternal cameraInternal) {
        this.a = cameraRepository;
        this.b = cameraInternal;
    }

    public final void run() {
        CameraRepository cameraRepository = this.a;
        CameraInternal cameraInternal = this.b;
        cameraRepository.d(cameraInternal);
    }
}

