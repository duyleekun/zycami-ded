/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.view.TextureView$SurfaceTextureListener
 */
package d.v.b0.c.c;

import android.graphics.SurfaceTexture;
import android.view.TextureView;
import com.zhiyun.renderengine.business.display.DisplayRender;
import d.v.b0.c.c.b;

public class b$a
implements TextureView.SurfaceTextureListener {
    public final /* synthetic */ b a;

    public b$a(b b10) {
        this.a = b10;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int n10, int n11) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("DisplayView onSurfaceTextureAvailable  Thread id: ");
        Thread thread = Thread.currentThread();
        long l10 = thread.getId();
        ((StringBuilder)object).append(l10);
        d.v.b0.j.b.a(((StringBuilder)object).toString());
        object = b.a(this.a);
        if (object != null) {
            object = b.a(this.a);
            ((DisplayRender)object).S(surfaceTexture, n10, n11);
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture object) {
        object = new StringBuilder();
        ((StringBuilder)object).append("DisplayView onSurfaceTextureDestroyed    Thread id: ");
        Thread thread = Thread.currentThread();
        long l10 = thread.getId();
        ((StringBuilder)object).append(l10);
        d.v.b0.j.b.a(((StringBuilder)object).toString());
        object = b.a(this.a);
        if (object != null) {
            object = b.a(this.a);
            ((DisplayRender)object).U();
        }
        return false;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture object, int n10, int n11) {
        object = new StringBuilder();
        ((StringBuilder)object).append("DisplayView onSurfaceTextureSizeChanged width:");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" x  height:");
        ((StringBuilder)object).append(n11);
        ((StringBuilder)object).append("   Thread id: ");
        Thread thread = Thread.currentThread();
        long l10 = thread.getId();
        ((StringBuilder)object).append(l10);
        d.v.b0.j.b.a(((StringBuilder)object).toString());
        object = b.a(this.a);
        if (object != null) {
            object = b.a(this.a);
            ((DisplayRender)object).W(n10, n11);
        }
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}

