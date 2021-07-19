/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package com.tencent.ugc;

import android.graphics.Bitmap;

public final class TXRecordCommon$TXUGCSimpleConfig {
    public boolean isFront;
    public int maxDuration;
    public int minDuration;
    public boolean needEdit;
    public boolean touchFocus;
    public int videoQuality;
    public Bitmap watermark;
    public int watermarkX;
    public int watermarkY;

    public TXRecordCommon$TXUGCSimpleConfig() {
        int n10;
        this.videoQuality = n10 = 1;
        this.watermark = null;
        this.watermarkX = 0;
        this.watermarkY = 0;
        this.isFront = n10;
        this.touchFocus = false;
        this.minDuration = 5000;
        this.maxDuration = 60000;
        this.needEdit = n10;
    }
}

