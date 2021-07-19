/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

public class NvsLiveWindow$VideoFrameInfo {
    public float captionAnchorX = 0.0f;
    public float captionAnchorY = 0.0f;
    public float captionRotationZ;
    public float captionScaleX;
    public float captionScaleY;
    public float captionTransX;
    public float captionTransY;
    public long frameId;
    public long streamTime;

    public NvsLiveWindow$VideoFrameInfo() {
        float f10;
        this.captionScaleX = f10 = 1.0f;
        this.captionScaleY = f10;
        this.captionRotationZ = 0.0f;
        this.captionTransX = 0.0f;
        this.captionTransY = 0.0f;
    }
}

