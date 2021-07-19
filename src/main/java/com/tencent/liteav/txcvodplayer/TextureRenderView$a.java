/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.os.Build$VERSION
 *  android.view.Surface
 */
package com.tencent.liteav.txcvodplayer;

import android.graphics.SurfaceTexture;
import android.os.Build;
import android.view.Surface;
import com.tencent.ijk.media.player.IMediaPlayer;
import com.tencent.ijk.media.player.ISurfaceTextureHolder;
import com.tencent.ijk.media.player.ISurfaceTextureHost;
import com.tencent.liteav.txcvodplayer.TextureRenderView;
import com.tencent.liteav.txcvodplayer.TextureRenderView$b;
import com.tencent.liteav.txcvodplayer.a;
import com.tencent.liteav.txcvodplayer.a$b;

public final class TextureRenderView$a
implements a$b {
    private TextureRenderView a;
    private SurfaceTexture b;
    private ISurfaceTextureHost c;
    private Surface d;

    public TextureRenderView$a(TextureRenderView textureRenderView, SurfaceTexture surfaceTexture, ISurfaceTextureHost iSurfaceTextureHost) {
        this.a = textureRenderView;
        this.b = surfaceTexture;
        this.c = iSurfaceTextureHost;
    }

    public a a() {
        return this.a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(IMediaPlayer iMediaPlayer) {
        Surface surface;
        if (iMediaPlayer == null) {
            return;
        }
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11 && (n10 = iMediaPlayer instanceof ISurfaceTextureHolder) != 0) {
            Object object = iMediaPlayer;
            object = (ISurfaceTextureHolder)((Object)iMediaPlayer);
            Object object2 = TextureRenderView.access$100(this.a);
            Object object3 = null;
            ((TextureRenderView$b)object2).a(false);
            object2 = this.a.getSurfaceTexture();
            if (object2 != null) {
                object2 = this.a.getSurfaceTexture();
                this.b = object2;
            }
            try {
                object2 = object.getSurfaceTexture();
                if (object2 != null) {
                    object3 = this.a;
                    object3 = TextureRenderView.access$100((TextureRenderView)object3);
                    object.setSurfaceTextureHost((ISurfaceTextureHost)object3);
                    object = this.a;
                    object.setSurfaceTexture((SurfaceTexture)object2);
                    object = this.a;
                    object = TextureRenderView.access$100((TextureRenderView)object);
                    ((TextureRenderView$b)object).a((SurfaceTexture)object2);
                } else {
                    object2 = this.d;
                    if (object2 != null) {
                        iMediaPlayer.setSurface((Surface)object2);
                    }
                    object2 = this.b;
                    object.setSurfaceTexture((SurfaceTexture)object2);
                    object2 = this.a;
                    object2 = TextureRenderView.access$100((TextureRenderView)object2);
                    object.setSurfaceTextureHost((ISurfaceTextureHost)object2);
                }
                iMediaPlayer = iMediaPlayer.getSurface();
                this.d = iMediaPlayer;
                return;
            }
            catch (Exception exception) {
                exception.printStackTrace();
                return;
            }
        }
        this.d = surface = this.b();
        iMediaPlayer.setSurface(surface);
    }

    public Surface b() {
        SurfaceTexture surfaceTexture = this.b;
        if (surfaceTexture == null) {
            return null;
        }
        surfaceTexture = this.d;
        if (surfaceTexture == null) {
            SurfaceTexture surfaceTexture2 = this.b;
            surfaceTexture = new Surface(surfaceTexture2);
            this.d = surfaceTexture;
        }
        return this.d;
    }
}

