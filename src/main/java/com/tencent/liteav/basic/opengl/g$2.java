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
import com.tencent.liteav.basic.opengl.g$2$1;

public class g$2
implements SurfaceTexture.OnFrameAvailableListener {
    public final /* synthetic */ g a;

    public g$2(g g10) {
        this.a = g10;
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        g g10 = this.a;
        g$2$1 g$2$1 = new g$2$1(this);
        g.a(g10, 103, g$2$1);
        surfaceTexture.setOnFrameAvailableListener(null);
    }
}

