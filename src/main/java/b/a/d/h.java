/*
 * Decompiled with CFR 0.151.
 */
package b.a.d;

import androidx.camera.core.impl.CameraInternal;
import androidx.camera.view.PreviewStreamStateObserver;
import androidx.camera.view.PreviewView$1;
import androidx.camera.view.PreviewViewImplementation$OnSurfaceNotInUseListener;

public final class h
implements PreviewViewImplementation$OnSurfaceNotInUseListener {
    public final /* synthetic */ PreviewView$1 a;
    public final /* synthetic */ PreviewStreamStateObserver b;
    public final /* synthetic */ CameraInternal c;

    public /* synthetic */ h(PreviewView$1 previewView$1, PreviewStreamStateObserver previewStreamStateObserver, CameraInternal cameraInternal) {
        this.a = previewView$1;
        this.b = previewStreamStateObserver;
        this.c = cameraInternal;
    }

    public final void onSurfaceNotInUse() {
        PreviewView$1 previewView$1 = this.a;
        PreviewStreamStateObserver previewStreamStateObserver = this.b;
        CameraInternal cameraInternal = this.c;
        previewView$1.f(previewStreamStateObserver, cameraInternal);
    }
}

