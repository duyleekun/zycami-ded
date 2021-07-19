/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaFormat
 */
package com.google.android.exoplayer2.video;

import android.media.MediaFormat;
import com.google.android.exoplayer2.Format;

public interface VideoFrameMetadataListener {
    public void onVideoFrameAboutToBeRendered(long var1, long var3, Format var5, MediaFormat var6);
}

