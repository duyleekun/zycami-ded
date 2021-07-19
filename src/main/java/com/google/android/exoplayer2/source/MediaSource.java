/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSource$MediaSourceCaller;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;

public interface MediaSource {
    public void addDrmEventListener(Handler var1, DrmSessionEventListener var2);

    public void addEventListener(Handler var1, MediaSourceEventListener var2);

    public MediaPeriod createPeriod(MediaSource$MediaPeriodId var1, Allocator var2, long var3);

    public void disable(MediaSource$MediaSourceCaller var1);

    public void enable(MediaSource$MediaSourceCaller var1);

    default public Timeline getInitialTimeline() {
        return null;
    }

    public MediaItem getMediaItem();

    default public Object getTag() {
        return null;
    }

    default public boolean isSingleWindow() {
        return true;
    }

    public void maybeThrowSourceInfoRefreshError();

    public void prepareSource(MediaSource$MediaSourceCaller var1, TransferListener var2);

    public void releasePeriod(MediaPeriod var1);

    public void releaseSource(MediaSource$MediaSourceCaller var1);

    public void removeDrmEventListener(DrmSessionEventListener var1);

    public void removeEventListener(MediaSourceEventListener var1);
}

