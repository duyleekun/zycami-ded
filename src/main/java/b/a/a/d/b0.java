/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.view.Surface
 */
package b.a.a.d;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import androidx.camera.camera2.internal.Camera2CameraImpl;

public final class b0
implements Runnable {
    public final /* synthetic */ Surface a;
    public final /* synthetic */ SurfaceTexture b;

    public /* synthetic */ b0(Surface surface, SurfaceTexture surfaceTexture) {
        this.a = surface;
        this.b = surfaceTexture;
    }

    public final void run() {
        Surface surface = this.a;
        SurfaceTexture surfaceTexture = this.b;
        Camera2CameraImpl.e(surface, surfaceTexture);
    }
}

