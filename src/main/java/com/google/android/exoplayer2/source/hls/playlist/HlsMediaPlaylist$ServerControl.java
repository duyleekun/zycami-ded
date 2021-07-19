/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.hls.playlist;

public final class HlsMediaPlaylist$ServerControl {
    public final boolean canBlockReload;
    public final boolean canSkipDateRanges;
    public final long holdBackUs;
    public final long partHoldBackUs;
    public final long skipUntilUs;

    public HlsMediaPlaylist$ServerControl(long l10, boolean bl2, long l11, long l12, boolean bl3) {
        this.skipUntilUs = l10;
        this.canSkipDateRanges = bl2;
        this.holdBackUs = l11;
        this.partHoldBackUs = l12;
        this.canBlockReload = bl3;
    }
}

