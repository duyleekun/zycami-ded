/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 */
package d.h.a.a.p0.f0;

import android.graphics.SurfaceTexture;
import com.google.android.exoplayer2.ui.spherical.SphericalGLSurfaceView;

public final class c
implements Runnable {
    public final /* synthetic */ SphericalGLSurfaceView a;
    public final /* synthetic */ SurfaceTexture b;

    public /* synthetic */ c(SphericalGLSurfaceView sphericalGLSurfaceView, SurfaceTexture surfaceTexture) {
        this.a = sphericalGLSurfaceView;
        this.b = surfaceTexture;
    }

    public final void run() {
        SphericalGLSurfaceView sphericalGLSurfaceView = this.a;
        SurfaceTexture surfaceTexture = this.b;
        sphericalGLSurfaceView.d(surfaceTexture);
    }
}

