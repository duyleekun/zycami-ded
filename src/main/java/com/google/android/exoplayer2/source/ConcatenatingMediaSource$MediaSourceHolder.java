/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.MaskingMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import java.util.ArrayList;
import java.util.List;

public final class ConcatenatingMediaSource$MediaSourceHolder {
    public final List activeMediaPeriodIds;
    public int childIndex;
    public int firstWindowIndexInChild;
    public boolean isRemoved;
    public final MaskingMediaSource mediaSource;
    public final Object uid;

    public ConcatenatingMediaSource$MediaSourceHolder(MediaSource object, boolean bl2) {
        MaskingMediaSource maskingMediaSource;
        this.mediaSource = maskingMediaSource = new MaskingMediaSource((MediaSource)object, bl2);
        object = new ArrayList();
        this.activeMediaPeriodIds = object;
        this.uid = object = new Object();
    }

    public void reset(int n10, int n11) {
        this.childIndex = n10;
        this.firstWindowIndexInChild = n11;
        this.isRemoved = false;
        this.activeMediaPeriodIds.clear();
    }
}

