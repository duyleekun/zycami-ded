/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.view.Surface
 *  android.view.TextureView$SurfaceTextureListener
 */
package d.v.b.f0;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import d.v.b.f0.j;
import d.v.b.f0.l.g;
import d.v.d.h.f;

public class j$a
implements TextureView.SurfaceTextureListener {
    public final /* synthetic */ j a;

    public j$a(j j10) {
        this.a = j10;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture object, int n10, int n11) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SurfaceTexture  Available width=");
        stringBuilder.append(n10);
        stringBuilder.append(",height=");
        stringBuilder.append(n11);
        f.a(stringBuilder.toString());
        j.d(this.a, (SurfaceTexture)object);
        object = this.a;
        SurfaceTexture surfaceTexture = j.c(this.a);
        stringBuilder = new Surface(surfaceTexture);
        j.e((j)object, (Surface)stringBuilder);
        j.f(this.a, n10, n11);
        object = j.g(this.a);
        Integer n12 = 1;
        ((g)object).p(n12);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture object) {
        object = j.g(this.a);
        Integer n10 = 4;
        ((g)object).p(n10);
        j.e(this.a, null);
        j.d(this.a, null);
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture object, int n10, int n11) {
        j.f(this.a, n10, n11);
        j.h(this.a);
        object = j.g(this.a);
        Integer n12 = 2;
        ((g)object).p(n12);
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}

