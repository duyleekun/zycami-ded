/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;

public final class ExoPlayerImplInternal$PositionUpdateForPlaylistChange {
    public final boolean endPlayback;
    public final boolean forceBufferingState;
    public final MediaSource.MediaPeriodId periodId;
    public final long periodPositionUs;
    public final long requestedContentPositionUs;
    public final boolean setTargetLiveOffset;

    public ExoPlayerImplInternal$PositionUpdateForPlaylistChange(MediaSource.MediaPeriodId mediaPeriodId, long l10, long l11, boolean bl2, boolean bl3, boolean bl4) {
        this.periodId = mediaPeriodId;
        this.periodPositionUs = l10;
        this.requestedContentPositionUs = l11;
        this.forceBufferingState = bl2;
        this.endPlayback = bl3;
        this.setTargetLiveOffset = bl4;
    }
}

