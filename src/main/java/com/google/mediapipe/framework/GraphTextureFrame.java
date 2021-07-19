/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.framework;

import com.google.mediapipe.framework.GlSyncToken;
import com.google.mediapipe.framework.TextureFrame;

public class GraphTextureFrame
implements TextureFrame {
    private int height;
    private long nativeBufferHandle;
    private int textureName;
    private long timestamp = Long.MIN_VALUE;
    private int width;

    public GraphTextureFrame(long l10, long l11) {
        int n10;
        this.nativeBufferHandle = l10;
        this.textureName = n10 = this.nativeGetTextureName(l10);
        l10 = this.nativeBufferHandle;
        this.width = n10 = this.nativeGetWidth(l10);
        l10 = this.nativeBufferHandle;
        this.height = n10 = this.nativeGetHeight(l10);
        this.timestamp = l11;
    }

    private native int nativeGetHeight(long var1);

    private native int nativeGetTextureName(long var1);

    private native int nativeGetWidth(long var1);

    private native void nativeReleaseBuffer(long var1);

    public int getHeight() {
        return this.height;
    }

    public int getTextureName() {
        return this.textureName;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public int getWidth() {
        return this.width;
    }

    public void release() {
        long l10 = this.nativeBufferHandle;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            this.nativeReleaseBuffer(l10);
            this.nativeBufferHandle = l11;
        }
    }

    public void release(GlSyncToken glSyncToken) {
        glSyncToken.release();
        this.release();
    }
}

