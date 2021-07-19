/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.opengl.GLSurfaceView
 *  android.opengl.GLSurfaceView$Renderer
 *  android.util.AttributeSet
 */
package com.google.android.exoplayer2.video;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import com.google.android.exoplayer2.video.VideoDecoderGLFrameRenderer;
import com.google.android.exoplayer2.video.VideoDecoderOutputBufferRenderer;

public class VideoDecoderGLSurfaceView
extends GLSurfaceView {
    private final VideoDecoderGLFrameRenderer renderer;

    public VideoDecoderGLSurfaceView(Context context) {
        this(context, null);
    }

    public VideoDecoderGLSurfaceView(Context object, AttributeSet attributeSet) {
        super(object, attributeSet);
        super(this);
        this.renderer = object;
        this.setPreserveEGLContextOnPause(true);
        this.setEGLContextClientVersion(2);
        this.setRenderer((GLSurfaceView.Renderer)object);
        this.setRenderMode(0);
    }

    public VideoDecoderOutputBufferRenderer getVideoDecoderOutputBufferRenderer() {
        return this.renderer;
    }
}

