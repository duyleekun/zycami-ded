/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 */
package d.v.d.g.e;

import android.graphics.SurfaceTexture;
import d.v.d.g.e.e;

public final class c
implements Runnable {
    public final /* synthetic */ e a;
    public final /* synthetic */ SurfaceTexture b;

    public /* synthetic */ c(e e10, SurfaceTexture surfaceTexture) {
        this.a = e10;
        this.b = surfaceTexture;
    }

    public final void run() {
        e e10 = this.a;
        SurfaceTexture surfaceTexture = this.b;
        e10.i(surfaceTexture);
    }
}

