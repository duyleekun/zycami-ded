/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.graphics.SurfaceTexture$OnFrameAvailableListener
 */
package com.tencent.liteav.screencapture;

import android.graphics.SurfaceTexture;
import com.tencent.liteav.screencapture.a;
import com.tencent.liteav.screencapture.a$b;
import com.tencent.liteav.screencapture.a$b$2$1;

public class a$b$2
implements SurfaceTexture.OnFrameAvailableListener {
    public final /* synthetic */ a$b a;

    public a$b$2(a$b a$b) {
        this.a = a$b;
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        a a10 = this.a.n;
        a$b$2$1 a$b$2$1 = new a$b$2$1(this);
        a10.a(104, a$b$2$1);
        surfaceTexture.setOnFrameAvailableListener(null);
    }
}

