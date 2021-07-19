/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.framework;

import com.google.mediapipe.framework.GlSyncToken;
import com.google.mediapipe.framework.TextureReleaseCallback;

public interface TextureFrame
extends TextureReleaseCallback {
    public int getHeight();

    public int getTextureName();

    public long getTimestamp();

    public int getWidth();

    public void release();

    public void release(GlSyncToken var1);
}

