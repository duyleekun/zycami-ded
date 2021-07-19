/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.graphics.SurfaceTexture$OnFrameAvailableListener
 */
package d.h.a.a.p0.f0;

import android.graphics.SurfaceTexture;
import com.google.android.exoplayer2.ui.spherical.SceneRenderer;

public final class a
implements SurfaceTexture.OnFrameAvailableListener {
    public final /* synthetic */ SceneRenderer a;

    public /* synthetic */ a(SceneRenderer sceneRenderer) {
        this.a = sceneRenderer;
    }

    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.a.b(surfaceTexture);
    }
}

