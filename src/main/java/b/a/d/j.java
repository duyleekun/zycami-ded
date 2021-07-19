/*
 * Decompiled with CFR 0.151.
 */
package b.a.d;

import androidx.camera.core.SurfaceRequest;
import androidx.camera.view.PreviewView$1;

public final class j
implements Runnable {
    public final /* synthetic */ PreviewView$1 a;
    public final /* synthetic */ SurfaceRequest b;

    public /* synthetic */ j(PreviewView$1 previewView$1, SurfaceRequest surfaceRequest) {
        this.a = previewView$1;
        this.b = surfaceRequest;
    }

    public final void run() {
        PreviewView$1 previewView$1 = this.a;
        SurfaceRequest surfaceRequest = this.b;
        previewView$1.b(surfaceRequest);
    }
}

