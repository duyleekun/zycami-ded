/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.SurfaceHolder
 */
package com.tencent.liteav.txcvodplayer;

import android.os.Build;
import android.view.SurfaceHolder;
import com.tencent.ijk.media.player.IMediaPlayer;
import com.tencent.ijk.media.player.ISurfaceTextureHolder;
import com.tencent.liteav.txcvodplayer.SurfaceRenderView;
import com.tencent.liteav.txcvodplayer.a;
import com.tencent.liteav.txcvodplayer.a$b;

public final class SurfaceRenderView$a
implements a$b {
    private SurfaceRenderView a;
    private SurfaceHolder b;

    public SurfaceRenderView$a(SurfaceRenderView surfaceRenderView, SurfaceHolder surfaceHolder) {
        this.a = surfaceRenderView;
        this.b = surfaceHolder;
    }

    public a a() {
        return this.a;
    }

    public void a(IMediaPlayer iMediaPlayer) {
        if (iMediaPlayer != null) {
            Object object;
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 16;
            if (n10 >= n11 && (n10 = iMediaPlayer instanceof ISurfaceTextureHolder) != 0) {
                object = iMediaPlayer;
                object = (ISurfaceTextureHolder)((Object)iMediaPlayer);
                n11 = 0;
                object.setSurfaceTexture(null);
            }
            object = this.b;
            iMediaPlayer.setDisplay((SurfaceHolder)object);
        }
    }
}

