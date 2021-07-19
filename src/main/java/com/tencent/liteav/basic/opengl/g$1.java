/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.graphics.SurfaceTexture$OnFrameAvailableListener
 */
package com.tencent.liteav.basic.opengl;

import android.graphics.SurfaceTexture;
import com.tencent.liteav.basic.opengl.g;
import com.tencent.liteav.basic.opengl.g$1$1;

public class g$1
implements SurfaceTexture.OnFrameAvailableListener {
    public final /* synthetic */ g a;

    public g$1(g g10) {
        this.a = g10;
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        g g10 = this.a;
        g$1$1 g$1$1 = new g$1$1(this);
        g.a(g10, 103, g$1$1);
        surfaceTexture.setOnFrameAvailableListener(null);
    }
}

