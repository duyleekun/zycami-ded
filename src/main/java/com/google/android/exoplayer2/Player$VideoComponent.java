/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 *  android.view.SurfaceHolder
 *  android.view.SurfaceView
 *  android.view.TextureView
 */
package com.google.android.exoplayer2;

import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import com.google.android.exoplayer2.video.VideoListener;
import com.google.android.exoplayer2.video.spherical.CameraMotionListener;

public interface Player$VideoComponent {
    public void addVideoListener(VideoListener var1);

    public void clearCameraMotionListener(CameraMotionListener var1);

    public void clearVideoFrameMetadataListener(VideoFrameMetadataListener var1);

    public void clearVideoSurface();

    public void clearVideoSurface(Surface var1);

    public void clearVideoSurfaceHolder(SurfaceHolder var1);

    public void clearVideoSurfaceView(SurfaceView var1);

    public void clearVideoTextureView(TextureView var1);

    public int getVideoScalingMode();

    public void removeVideoListener(VideoListener var1);

    public void setCameraMotionListener(CameraMotionListener var1);

    public void setVideoFrameMetadataListener(VideoFrameMetadataListener var1);

    public void setVideoScalingMode(int var1);

    public void setVideoSurface(Surface var1);

    public void setVideoSurfaceHolder(SurfaceHolder var1);

    public void setVideoSurfaceView(SurfaceView var1);

    public void setVideoTextureView(TextureView var1);
}

