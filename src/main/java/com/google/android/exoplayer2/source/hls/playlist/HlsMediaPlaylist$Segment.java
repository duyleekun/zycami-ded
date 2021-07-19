/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$Part;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$SegmentBase;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class HlsMediaPlaylist$Segment
extends HlsMediaPlaylist$SegmentBase {
    public final List parts;
    public final String title;

    public HlsMediaPlaylist$Segment(String string2, long l10, long l11, String string3, String string4) {
        ImmutableList immutableList = ImmutableList.of();
        this(string2, null, "", 0L, -1, -9223372036854775807L, null, string3, string4, l10, l11, false, immutableList);
    }

    public HlsMediaPlaylist$Segment(String string2, HlsMediaPlaylist$Segment hlsMediaPlaylist$Segment, String string3, long l10, int n10, long l11, DrmInitData drmInitData, String string4, String string5, long l12, long l13, boolean bl2, List list) {
        Object object = string2;
        super(string2, hlsMediaPlaylist$Segment, l10, n10, l11, drmInitData, string4, string5, l12, l13, bl2, null);
        object = string3;
        this.title = string3;
        this.parts = object = ImmutableList.copyOf((Collection)list);
    }

    public HlsMediaPlaylist$Segment copyWith(long l10, int n10) {
        Object object;
        int n11;
        HlsMediaPlaylist$Segment hlsMediaPlaylist$Segment = this;
        ArrayList<HlsMediaPlaylist$Part> arrayList = new ArrayList<HlsMediaPlaylist$Part>();
        long l11 = l10;
        for (int i10 = 0; i10 < (n11 = (object = hlsMediaPlaylist$Segment.parts).size()); ++i10) {
            object = (HlsMediaPlaylist$Part)hlsMediaPlaylist$Segment.parts.get(i10);
            HlsMediaPlaylist$Part hlsMediaPlaylist$Part = ((HlsMediaPlaylist$Part)object).copyWith(l11, n10);
            arrayList.add(hlsMediaPlaylist$Part);
            long l12 = ((HlsMediaPlaylist$SegmentBase)object).durationUs;
            l11 += l12;
        }
        String string2 = hlsMediaPlaylist$Segment.url;
        HlsMediaPlaylist$Segment hlsMediaPlaylist$Segment2 = hlsMediaPlaylist$Segment.initializationSegment;
        object = hlsMediaPlaylist$Segment.title;
        long l13 = hlsMediaPlaylist$Segment.durationUs;
        DrmInitData drmInitData = hlsMediaPlaylist$Segment.drmInitData;
        String string3 = hlsMediaPlaylist$Segment.fullSegmentEncryptionKeyUri;
        String string4 = hlsMediaPlaylist$Segment.encryptionIV;
        long l14 = hlsMediaPlaylist$Segment.byteRangeOffset;
        long l15 = hlsMediaPlaylist$Segment.byteRangeLength;
        boolean bl2 = hlsMediaPlaylist$Segment.hasGapTag;
        HlsMediaPlaylist$Segment hlsMediaPlaylist$Segment3 = new HlsMediaPlaylist$Segment(string2, hlsMediaPlaylist$Segment2, (String)object, l13, n10, l10, drmInitData, string3, string4, l14, l15, bl2, arrayList);
        return hlsMediaPlaylist$Segment3;
    }
}

