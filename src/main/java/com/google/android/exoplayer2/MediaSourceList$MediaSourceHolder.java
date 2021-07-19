/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

import com.google.android.exoplayer2.MediaSourceInfoHolder;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MaskingMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import java.util.ArrayList;
import java.util.List;

public final class MediaSourceList$MediaSourceHolder
implements MediaSourceInfoHolder {
    public final List activeMediaPeriodIds;
    public int firstWindowIndexInChild;
    public boolean isRemoved;
    public final MaskingMediaSource mediaSource;
    public final Object uid;

    public MediaSourceList$MediaSourceHolder(MediaSource object, boolean bl2) {
        MaskingMediaSource maskingMediaSource;
        this.mediaSource = maskingMediaSource = new MaskingMediaSource((MediaSource)object, bl2);
        object = new ArrayList();
        this.activeMediaPeriodIds = object;
        this.uid = object = new Object();
    }

    public Timeline getTimeline() {
        return this.mediaSource.getTimeline();
    }

    public Object getUid() {
        return this.uid;
    }

    public void reset(int n10) {
        this.firstWindowIndexInChild = n10;
        this.isRemoved = false;
        this.activeMediaPeriodIds.clear();
    }
}

