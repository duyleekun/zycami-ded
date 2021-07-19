/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

import com.google.android.exoplayer2.PlaybackInfo;
import com.google.android.exoplayer2.util.Assertions;

public final class ExoPlayerImplInternal$PlaybackInfoUpdate {
    public int discontinuityReason;
    private boolean hasPendingChange;
    public boolean hasPlayWhenReadyChangeReason;
    public int operationAcks;
    public int playWhenReadyChangeReason;
    public PlaybackInfo playbackInfo;
    public boolean positionDiscontinuity;

    public ExoPlayerImplInternal$PlaybackInfoUpdate(PlaybackInfo playbackInfo) {
        this.playbackInfo = playbackInfo;
    }

    public static /* synthetic */ boolean access$100(ExoPlayerImplInternal$PlaybackInfoUpdate exoPlayerImplInternal$PlaybackInfoUpdate) {
        return exoPlayerImplInternal$PlaybackInfoUpdate.hasPendingChange;
    }

    public void incrementPendingOperationAcks(int n10) {
        int n11 = this.hasPendingChange;
        int n12 = n10 > 0 ? 1 : 0;
        this.hasPendingChange = n11 |= n12;
        this.operationAcks = n11 = this.operationAcks + n10;
    }

    public void setPlayWhenReadyChangeReason(int n10) {
        boolean bl2;
        this.hasPendingChange = bl2 = true;
        this.hasPlayWhenReadyChangeReason = bl2;
        this.playWhenReadyChangeReason = n10;
    }

    public void setPlaybackInfo(PlaybackInfo playbackInfo) {
        boolean bl2;
        boolean bl3 = this.hasPendingChange;
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        if (playbackInfo2 != playbackInfo) {
            bl2 = true;
        } else {
            bl2 = false;
            playbackInfo2 = null;
        }
        this.hasPendingChange = bl3 |= bl2;
        this.playbackInfo = playbackInfo;
    }

    public void setPositionDiscontinuity(int n10) {
        int n11;
        int n12 = this.positionDiscontinuity;
        boolean bl2 = true;
        if (n12 != 0 && (n12 = this.discontinuityReason) != (n11 = 4)) {
            if (n10 != n11) {
                bl2 = false;
            }
            Assertions.checkArgument(bl2);
            return;
        }
        this.hasPendingChange = bl2;
        this.positionDiscontinuity = bl2;
        this.discontinuityReason = n10;
    }
}

