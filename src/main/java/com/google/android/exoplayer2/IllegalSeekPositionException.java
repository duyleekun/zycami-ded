/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Timeline;

public final class IllegalSeekPositionException
extends IllegalStateException {
    public final long positionMs;
    public final Timeline timeline;
    public final int windowIndex;

    public IllegalSeekPositionException(Timeline timeline, int n10, long l10) {
        this.timeline = timeline;
        this.windowIndex = n10;
        this.positionMs = l10;
    }
}

