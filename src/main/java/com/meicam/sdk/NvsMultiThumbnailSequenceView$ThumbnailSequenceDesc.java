/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

public class NvsMultiThumbnailSequenceView$ThumbnailSequenceDesc {
    public long inPoint;
    public String mediaFilePath;
    public boolean onlyDecodeKeyFrame;
    public long outPoint;
    public boolean stillImageHint;
    public float thumbnailAspectRatio;
    public long trimIn;
    public long trimOut;

    public NvsMultiThumbnailSequenceView$ThumbnailSequenceDesc() {
        long l10;
        long l11;
        this.inPoint = l11 = 0L;
        this.outPoint = l10 = 4000000L;
        this.trimIn = l11;
        this.trimOut = l10;
        this.stillImageHint = false;
        this.onlyDecodeKeyFrame = false;
        this.thumbnailAspectRatio = 0.0f;
    }
}

