/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.source.chunk.BaseMediaChunkIterator;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$SegmentBase;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.UriUtil;
import java.util.List;

public final class HlsChunkSource$HlsMediaPlaylistSegmentIterator
extends BaseMediaChunkIterator {
    private final String playlistBaseUri;
    private final List segmentBases;
    private final long startOfPlaylistInPeriodUs;

    public HlsChunkSource$HlsMediaPlaylistSegmentIterator(String string2, long l10, List list) {
        long l11 = list.size() + -1;
        super(0L, l11);
        this.playlistBaseUri = string2;
        this.startOfPlaylistInPeriodUs = l10;
        this.segmentBases = list;
    }

    public long getChunkEndTimeUs() {
        this.checkInBounds();
        Object object = this.segmentBases;
        int n10 = (int)this.getCurrentIndex();
        object = (HlsMediaPlaylist$SegmentBase)object.get(n10);
        long l10 = this.startOfPlaylistInPeriodUs;
        long l11 = ((HlsMediaPlaylist$SegmentBase)object).relativeStartTimeUs;
        l10 += l11;
        l11 = ((HlsMediaPlaylist$SegmentBase)object).durationUs;
        return l10 + l11;
    }

    public long getChunkStartTimeUs() {
        this.checkInBounds();
        long l10 = this.startOfPlaylistInPeriodUs;
        List list = this.segmentBases;
        int n10 = (int)this.getCurrentIndex();
        long l11 = ((HlsMediaPlaylist$SegmentBase)list.get((int)n10)).relativeStartTimeUs;
        return l10 + l11;
    }

    public DataSpec getDataSpec() {
        this.checkInBounds();
        Object object = this.segmentBases;
        int n10 = (int)this.getCurrentIndex();
        object = (HlsMediaPlaylist$SegmentBase)object.get(n10);
        Object object2 = this.playlistBaseUri;
        String string2 = ((HlsMediaPlaylist$SegmentBase)object).url;
        Uri uri = UriUtil.resolveToUri((String)object2, string2);
        long l10 = ((HlsMediaPlaylist$SegmentBase)object).byteRangeOffset;
        long l11 = ((HlsMediaPlaylist$SegmentBase)object).byteRangeLength;
        object2 = new DataSpec(uri, l10, l11);
        return object2;
    }
}

