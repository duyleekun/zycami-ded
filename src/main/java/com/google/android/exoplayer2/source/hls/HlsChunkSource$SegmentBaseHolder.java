/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$Part;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$SegmentBase;

public final class HlsChunkSource$SegmentBaseHolder {
    public final boolean isPreload;
    public final long mediaSequence;
    public final int partIndex;
    public final HlsMediaPlaylist$SegmentBase segmentBase;

    /*
     * Unable to fully structure code
     */
    public HlsChunkSource$SegmentBaseHolder(HlsMediaPlaylist$SegmentBase var1_1, long var2_2, int var4_3) {
        super();
        this.segmentBase = var1_1;
        this.mediaSequence = var2_2;
        this.partIndex = var4_3;
        var5_4 = var1_1 instanceof HlsMediaPlaylist$Part;
        if (!var5_4) ** GOTO lbl-1000
        var1_1 = (HlsMediaPlaylist$Part)var1_1;
        var6_5 = var1_1.isPreload;
        if (var6_5) {
            var6_5 = true;
        } else lbl-1000:
        // 2 sources

        {
            var6_5 = false;
            var1_1 = null;
        }
        this.isPreload = var6_5;
    }
}

