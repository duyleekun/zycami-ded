/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.graphics.SurfaceTexture$OnFrameAvailableListener
 */
package com.cdv.io;

import android.graphics.SurfaceTexture;

public class NvCameraSurfaceTextureListener
implements SurfaceTexture.OnFrameAvailableListener {
    private final int m_texId;

    public NvCameraSurfaceTextureListener(int n10) {
        this.m_texId = n10;
    }

    private static native void notifyCameraFrameAvailable(int var0);

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        NvCameraSurfaceTextureListener.notifyCameraFrameAvailable(this.m_texId);
    }
}

