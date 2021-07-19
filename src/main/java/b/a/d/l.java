/*
 * Decompiled with CFR 0.151.
 */
package b.a.d;

import androidx.camera.core.SurfaceRequest;
import androidx.camera.view.SurfaceViewImplementation;

public final class l
implements Runnable {
    public final /* synthetic */ SurfaceViewImplementation a;
    public final /* synthetic */ SurfaceRequest b;

    public /* synthetic */ l(SurfaceViewImplementation surfaceViewImplementation, SurfaceRequest surfaceRequest) {
        this.a = surfaceViewImplementation;
        this.b = surfaceRequest;
    }

    public final void run() {
        SurfaceViewImplementation surfaceViewImplementation = this.a;
        SurfaceRequest surfaceRequest = this.b;
        surfaceViewImplementation.c(surfaceRequest);
    }
}

