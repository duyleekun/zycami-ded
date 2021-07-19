/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

public class NvsMultiThumbnailSequenceView$ThumbnailSequence {
    public int m_flags;
    public long m_inPoint;
    public int m_index = 0;
    public String m_mediaFilePath;
    public boolean m_onlyDecodeKeyFrame;
    public long m_outPoint;
    public boolean m_stillImageHint;
    public float m_thumbnailAspectRatio;
    public int m_thumbnailWidth;
    public long m_trimDuration;
    public long m_trimIn;
    public int m_width;
    public int m_x;

    public NvsMultiThumbnailSequenceView$ThumbnailSequence() {
        long l10;
        this.m_inPoint = l10 = 0L;
        this.m_outPoint = l10;
        this.m_trimIn = l10;
        this.m_trimDuration = l10;
        this.m_stillImageHint = false;
        this.m_onlyDecodeKeyFrame = false;
        this.m_thumbnailAspectRatio = 0.0f;
        this.m_flags = 0;
        this.m_x = 0;
        this.m_width = 0;
        this.m_thumbnailWidth = 0;
    }

    public long calcTimestampFromX(int n10) {
        long l10 = this.m_trimIn;
        int n11 = this.m_x;
        double d10 = n10 - n11;
        double d11 = this.m_width;
        d10 /= d11;
        d11 = this.m_trimDuration;
        long l11 = (long)Math.floor(d10 * d11 + 0.5);
        return l10 + l11;
    }
}

