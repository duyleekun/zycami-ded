/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

import com.google.android.exoplayer2.MediaSourceInfoHolder;
import com.google.android.exoplayer2.Timeline;

public final class ExoPlayerImpl$MediaSourceHolderSnapshot
implements MediaSourceInfoHolder {
    private Timeline timeline;
    private final Object uid;

    public ExoPlayerImpl$MediaSourceHolderSnapshot(Object object, Timeline timeline) {
        this.uid = object;
        this.timeline = timeline;
    }

    public static /* synthetic */ Timeline access$002(ExoPlayerImpl$MediaSourceHolderSnapshot exoPlayerImpl$MediaSourceHolderSnapshot, Timeline timeline) {
        exoPlayerImpl$MediaSourceHolderSnapshot.timeline = timeline;
        return timeline;
    }

    public Timeline getTimeline() {
        return this.timeline;
    }

    public Object getUid() {
        return this.uid;
    }
}

