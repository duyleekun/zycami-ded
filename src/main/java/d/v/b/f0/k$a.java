/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.view.TextureView$SurfaceTextureListener
 */
package d.v.b.f0;

import android.graphics.SurfaceTexture;
import android.view.TextureView;
import d.v.b.f0.k;

public class k$a
implements TextureView.SurfaceTextureListener {
    public final /* synthetic */ k a;

    public k$a(k k10) {
        this.a = k10;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int n10, int n11) {
        k.c(this.a).S(surfaceTexture, n10, n11);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        k.c(this.a).U();
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int n10, int n11) {
        k.c(this.a).W(n10, n11);
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}

