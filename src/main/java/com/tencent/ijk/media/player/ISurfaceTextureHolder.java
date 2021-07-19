/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 */
package com.tencent.ijk.media.player;

import android.graphics.SurfaceTexture;
import com.tencent.ijk.media.player.ISurfaceTextureHost;

public interface ISurfaceTextureHolder {
    public SurfaceTexture getSurfaceTexture();

    public void setSurfaceTexture(SurfaceTexture var1);

    public void setSurfaceTextureHost(ISurfaceTextureHost var1);
}

