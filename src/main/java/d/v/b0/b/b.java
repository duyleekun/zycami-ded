/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.view.Surface
 */
package d.v.b0.b;

import android.graphics.SurfaceTexture;
import android.view.Surface;

public class b {
    private Object a;
    private int b;

    public b(SurfaceTexture surfaceTexture) {
        this.a = surfaceTexture;
    }

    public b(Surface surface) {
        this.a = surface;
    }

    public Object a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public void c() {
        Object object = this.a;
        if (object != null) {
            boolean bl2 = object instanceof SurfaceTexture;
            if (bl2) {
                object = (SurfaceTexture)object;
                object.setOnFrameAvailableListener(null);
                object.release();
            }
            if (bl2 = (object = this.a) instanceof Surface) {
                object = (Surface)object;
                object.release();
            }
            this.a = null;
        }
    }

    public void d(int n10) {
        this.b = n10;
    }
}

