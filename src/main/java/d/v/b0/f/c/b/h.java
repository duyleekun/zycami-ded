/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.view.Surface
 */
package d.v.b0.f.c.b;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import d.v.b0.f.c.b.b;
import d.v.b0.f.c.b.c;

public class h
extends c {
    private Surface f;
    private boolean g;

    public h(b b10, SurfaceTexture surfaceTexture) {
        super(b10);
        this.b(surfaceTexture);
    }

    public h(b b10, Surface surface, boolean bl2) {
        super(b10);
        this.b(surface);
        this.f = surface;
        this.g = bl2;
    }

    public void k(b object) {
        Surface surface = this.f;
        if (surface != null) {
            this.a = object;
            this.b(surface);
            return;
        }
        object = new RuntimeException("not yet implemented for SurfaceTexture");
        throw object;
    }

    public void l() {
        this.g();
        Surface surface = this.f;
        if (surface != null) {
            boolean bl2 = this.g;
            if (bl2) {
                surface.release();
            }
            surface = null;
            this.f = null;
        }
    }
}

