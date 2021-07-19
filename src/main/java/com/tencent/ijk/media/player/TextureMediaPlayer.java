/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.view.Surface
 *  android.view.SurfaceHolder
 */
package com.tencent.ijk.media.player;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.ijk.media.player.IMediaPlayer;
import com.tencent.ijk.media.player.ISurfaceTextureHolder;
import com.tencent.ijk.media.player.ISurfaceTextureHost;
import com.tencent.ijk.media.player.MediaPlayerProxy;
import java.util.ArrayList;

public class TextureMediaPlayer
extends MediaPlayerProxy
implements IMediaPlayer,
ISurfaceTextureHolder {
    private IMediaPlayer mBackEndMediaPlayer;
    private boolean mReuseSurfaceTexture;
    private Surface mSurface;
    private SurfaceTexture mSurfaceTexture;
    private ISurfaceTextureHost mSurfaceTextureHost;

    public TextureMediaPlayer(IMediaPlayer iMediaPlayer) {
        super(iMediaPlayer);
        this.mBackEndMediaPlayer = iMediaPlayer;
    }

    public IMediaPlayer getBackEndMediaPlayer() {
        return this.mBackEndMediaPlayer;
    }

    public int getBitrateIndex() {
        return this.mBackEndMediaPlayer.getBitrateIndex();
    }

    public ArrayList getSupportedBitrates() {
        return this.mBackEndMediaPlayer.getSupportedBitrates();
    }

    public Surface getSurface() {
        return super.getSurface();
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.mSurfaceTexture;
    }

    public void release() {
        super.release();
        this.releaseSurfaceTexture();
    }

    public void releaseSurfaceTexture() {
        boolean bl2;
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture != null && !(bl2 = this.mReuseSurfaceTexture)) {
            ISurfaceTextureHost iSurfaceTextureHost = this.mSurfaceTextureHost;
            if (iSurfaceTextureHost != null) {
                iSurfaceTextureHost.releaseSurfaceTexture(surfaceTexture);
            } else {
                surfaceTexture.release();
            }
            surfaceTexture = null;
            this.mSurfaceTexture = null;
        }
    }

    public void reset() {
        super.reset();
        this.releaseSurfaceTexture();
    }

    public void setBitrateIndex(int n10) {
        this.mBackEndMediaPlayer.setBitrateIndex(n10);
    }

    public void setDisplay(SurfaceHolder surfaceHolder) {
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture == null) {
            super.setDisplay(surfaceHolder);
        }
    }

    public void setReuseSurfaceTexture(boolean bl2) {
        this.mReuseSurfaceTexture = bl2;
    }

    public void setSurface(Surface surface) {
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture == null) {
            super.setSurface(surface);
        }
        this.mSurface = surface;
    }

    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2 = this.mSurfaceTexture;
        if (surfaceTexture2 == surfaceTexture) {
            return;
        }
        this.releaseSurfaceTexture();
        this.mSurfaceTexture = surfaceTexture;
        if (surfaceTexture == null) {
            surfaceTexture = null;
            this.mSurface = null;
            super.setSurface(null);
        } else {
            surfaceTexture2 = this.mSurface;
            if (surfaceTexture2 == null) {
                surfaceTexture2 = new Surface(surfaceTexture);
                this.mSurface = surfaceTexture2;
            }
            surfaceTexture = this.mSurface;
            super.setSurface((Surface)surfaceTexture);
        }
    }

    public void setSurfaceTextureHost(ISurfaceTextureHost iSurfaceTextureHost) {
        this.mSurfaceTextureHost = iSurfaceTextureHost;
    }
}

