/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Timeline;

public final class ExoPlayerImplInternal$SeekPosition {
    public final Timeline timeline;
    public final int windowIndex;
    public final long windowPositionUs;

    public ExoPlayerImplInternal$SeekPosition(Timeline timeline, int n10, long l10) {
        this.timeline = timeline;
        this.windowIndex = n10;
        this.windowPositionUs = l10;
    }
}

