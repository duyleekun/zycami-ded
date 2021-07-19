/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.Preview;
import androidx.camera.core.Preview$SurfaceProvider;
import androidx.camera.core.SurfaceRequest;

public final class v0
implements Runnable {
    public final /* synthetic */ Preview$SurfaceProvider a;
    public final /* synthetic */ SurfaceRequest b;

    public /* synthetic */ v0(Preview$SurfaceProvider preview$SurfaceProvider, SurfaceRequest surfaceRequest) {
        this.a = preview$SurfaceProvider;
        this.b = surfaceRequest;
    }

    public final void run() {
        Preview$SurfaceProvider preview$SurfaceProvider = this.a;
        SurfaceRequest surfaceRequest = this.b;
        Preview.c(preview$SurfaceProvider, surfaceRequest);
    }
}

