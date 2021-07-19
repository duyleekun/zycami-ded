/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$1;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$Segment;

public class HlsMediaPlaylist$SegmentBase
implements Comparable {
    public final long byteRangeLength;
    public final long byteRangeOffset;
    public final DrmInitData drmInitData;
    public final long durationUs;
    public final String encryptionIV;
    public final String fullSegmentEncryptionKeyUri;
    public final boolean hasGapTag;
    public final HlsMediaPlaylist$Segment initializationSegment;
    public final int relativeDiscontinuitySequence;
    public final long relativeStartTimeUs;
    public final String url;

    private HlsMediaPlaylist$SegmentBase(String string2, HlsMediaPlaylist$Segment hlsMediaPlaylist$Segment, long l10, int n10, long l11, DrmInitData drmInitData, String string3, String string4, long l12, long l13, boolean bl2) {
        this.url = string2;
        this.initializationSegment = hlsMediaPlaylist$Segment;
        this.durationUs = l10;
        this.relativeDiscontinuitySequence = n10;
        this.relativeStartTimeUs = l11;
        this.drmInitData = drmInitData;
        this.fullSegmentEncryptionKeyUri = string3;
        this.encryptionIV = string4;
        this.byteRangeOffset = l12;
        this.byteRangeLength = l13;
        this.hasGapTag = bl2;
    }

    public /* synthetic */ HlsMediaPlaylist$SegmentBase(String string2, HlsMediaPlaylist$Segment hlsMediaPlaylist$Segment, long l10, int n10, long l11, DrmInitData drmInitData, String string3, String string4, long l12, long l13, boolean bl2, HlsMediaPlaylist$1 hlsMediaPlaylist$1) {
        this(string2, hlsMediaPlaylist$Segment, l10, n10, l11, drmInitData, string3, string4, l12, l13, bl2);
    }

    public int compareTo(Long l10) {
        int n10;
        long l11 = this.relativeStartTimeUs;
        long l12 = l10;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object > 0) {
            n10 = 1;
        } else {
            l11 = this.relativeStartTimeUs;
            l12 = l10;
            long l14 = l11 - l12;
            n10 = (int)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1));
            if (n10 < 0) {
                n10 = -1;
            } else {
                n10 = 0;
                l10 = null;
            }
        }
        return n10;
    }
}

