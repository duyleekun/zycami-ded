/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package com.tencent.ugc;

import android.graphics.Bitmap;

public final class TXRecordCommon$TXUGCCustomConfig {
    public int audioSampleRate;
    public boolean enableHighResolutionCapture;
    public boolean isFront;
    public int maxDuration;
    public int minDuration;
    public boolean needEdit;
    public boolean touchFocus;
    public int videoBitrate;
    public int videoFps;
    public int videoGop;
    public int videoResolution;
    public Bitmap watermark;
    public int watermarkX;
    public int watermarkY;

    public TXRecordCommon$TXUGCCustomConfig() {
        int n10;
        this.videoResolution = n10 = 1;
        this.videoFps = 20;
        this.videoBitrate = 1800;
        this.videoGop = 3;
        this.watermark = null;
        this.watermarkX = 0;
        this.watermarkY = 0;
        this.isFront = n10;
        this.touchFocus = false;
        this.enableHighResolutionCapture = false;
        this.minDuration = 5000;
        this.maxDuration = 60000;
        this.audioSampleRate = 48000;
        this.needEdit = n10;
    }
}

