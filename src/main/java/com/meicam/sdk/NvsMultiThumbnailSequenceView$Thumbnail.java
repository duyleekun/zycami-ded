/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.ImageView
 */
package com.meicam.sdk;

import android.widget.ImageView;
import com.meicam.sdk.NvsMultiThumbnailSequenceView$ThumbnailSequence;

public class NvsMultiThumbnailSequenceView$Thumbnail {
    public long m_iconTaskId;
    public ImageView m_imageView;
    public boolean m_imageViewUpToDate;
    public NvsMultiThumbnailSequenceView.ThumbnailSequence m_owner;
    public long m_timestamp;
    public boolean m_touched;

    public NvsMultiThumbnailSequenceView$Thumbnail() {
        long l10;
        this.m_timestamp = l10 = 0L;
        this.m_iconTaskId = l10;
        this.m_imageViewUpToDate = false;
        this.m_touched = false;
    }
}

