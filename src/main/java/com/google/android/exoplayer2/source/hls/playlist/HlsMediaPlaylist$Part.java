/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$Segment;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$SegmentBase;

public final class HlsMediaPlaylist$Part
extends HlsMediaPlaylist$SegmentBase {
    public final boolean isIndependent;
    public final boolean isPreload;

    public HlsMediaPlaylist$Part(String string2, HlsMediaPlaylist$Segment hlsMediaPlaylist$Segment, long l10, int n10, long l11, DrmInitData drmInitData, String string3, String string4, long l12, long l13, boolean bl2, boolean bl3, boolean bl4) {
        super(string2, hlsMediaPlaylist$Segment, l10, n10, l11, drmInitData, string3, string4, l12, l13, bl2, null);
        this.isIndependent = bl3;
        this.isPreload = bl4;
    }

    public HlsMediaPlaylist$Part copyWith(long l10, int n10) {
        String string2 = this.url;
        HlsMediaPlaylist$Segment hlsMediaPlaylist$Segment = this.initializationSegment;
        long l11 = this.durationUs;
        DrmInitData drmInitData = this.drmInitData;
        String string3 = this.fullSegmentEncryptionKeyUri;
        String string4 = this.encryptionIV;
        long l12 = this.byteRangeOffset;
        long l13 = this.byteRangeLength;
        boolean bl2 = this.hasGapTag;
        boolean bl3 = this.isIndependent;
        boolean bl4 = this.isPreload;
        HlsMediaPlaylist$Part hlsMediaPlaylist$Part = new HlsMediaPlaylist$Part(string2, hlsMediaPlaylist$Segment, l11, n10, l10, drmInitData, string3, string4, l12, l13, bl2, bl3, bl4);
        return hlsMediaPlaylist$Part;
    }
}

