/*
 * Decompiled with CFR 0.151.
 */
package b.a.b.w1;

import androidx.camera.core.impl.CameraStateRegistry$OnOpenAvailableListener;

public final class o
implements Runnable {
    public final /* synthetic */ CameraStateRegistry$OnOpenAvailableListener a;

    public /* synthetic */ o(CameraStateRegistry$OnOpenAvailableListener cameraStateRegistry$OnOpenAvailableListener) {
        this.a = cameraStateRegistry$OnOpenAvailableListener;
    }

    public final void run() {
        this.a.onOpenAvailable();
    }
}

