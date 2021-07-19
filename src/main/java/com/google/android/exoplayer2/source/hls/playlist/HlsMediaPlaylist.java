/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$Part;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$Segment;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$SegmentBase;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$ServerControl;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public final class HlsMediaPlaylist
extends HlsPlaylist {
    public static final int PLAYLIST_TYPE_EVENT = 2;
    public static final int PLAYLIST_TYPE_UNKNOWN = 0;
    public static final int PLAYLIST_TYPE_VOD = 1;
    public final int discontinuitySequence;
    public final long durationUs;
    public final boolean hasDiscontinuitySequence;
    public final boolean hasEndTag;
    public final boolean hasProgramDateTime;
    public final long mediaSequence;
    public final long partTargetDurationUs;
    public final int playlistType;
    public final DrmInitData protectionSchemes;
    public final Map renditionReports;
    public final List segments;
    public final HlsMediaPlaylist$ServerControl serverControl;
    public final long startOffsetUs;
    public final long startTimeUs;
    public final long targetDurationUs;
    public final List trailingParts;
    public final int version;

    public HlsMediaPlaylist(int n10, String string2, List list, long l10, long l11, boolean bl2, int n11, long l12, int n12, long l13, long l14, boolean bl3, boolean bl4, boolean bl5, DrmInitData drmInitData, List list2, List list3, HlsMediaPlaylist$ServerControl hlsMediaPlaylist$ServerControl, Map map) {
        long l15;
        HlsMediaPlaylist hlsMediaPlaylist = this;
        Object object = string2;
        super(string2, list, bl3);
        int n13 = n10;
        this.playlistType = n10;
        long l16 = l11;
        this.startTimeUs = l11;
        n13 = (int)(bl2 ? 1 : 0);
        this.hasDiscontinuitySequence = bl2;
        n13 = n11;
        this.discontinuitySequence = n11;
        l16 = l12;
        this.mediaSequence = l12;
        n13 = n12;
        this.version = n12;
        l16 = l13;
        this.targetDurationUs = l13;
        l16 = l14;
        this.partTargetDurationUs = l14;
        n13 = (int)(bl4 ? 1 : 0);
        this.hasEndTag = bl4;
        n13 = (int)(bl5 ? 1 : 0);
        this.hasProgramDateTime = bl5;
        object = drmInitData;
        this.protectionSchemes = drmInitData;
        this.segments = object = ImmutableList.copyOf((Collection)list2);
        this.trailingParts = object = ImmutableList.copyOf((Collection)list3);
        this.renditionReports = object = ImmutableMap.copyOf(map);
        n13 = (int)(list3.isEmpty() ? 1 : 0);
        long l17 = 0L;
        if (n13 == 0) {
            object = (HlsMediaPlaylist$Part)Iterables.getLast(list3);
            l15 = ((HlsMediaPlaylist$SegmentBase)object).relativeStartTimeUs;
            long l18 = ((HlsMediaPlaylist$SegmentBase)object).durationUs;
            this.durationUs = l15 += l18;
        } else {
            n13 = (int)(list2.isEmpty() ? 1 : 0);
            if (n13 == 0) {
                object = (HlsMediaPlaylist$Segment)Iterables.getLast(list2);
                l15 = ((HlsMediaPlaylist$SegmentBase)object).relativeStartTimeUs;
                long l19 = ((HlsMediaPlaylist$SegmentBase)object).durationUs;
                this.durationUs = l15 += l19;
            } else {
                this.durationUs = l17;
            }
        }
        l15 = -9223372036854775807L;
        n13 = (int)(l10 == l15 ? 0 : (l10 < l15 ? -1 : 1));
        l16 = n13 == 0 ? l15 : ((n13 = (int)(l10 == l17 ? 0 : (l10 < l17 ? -1 : 1))) >= 0 ? l10 : hlsMediaPlaylist.durationUs + l10);
        hlsMediaPlaylist.startOffsetUs = l16;
        object = hlsMediaPlaylist$ServerControl;
        hlsMediaPlaylist.serverControl = hlsMediaPlaylist$ServerControl;
    }

    public HlsMediaPlaylist copy(List list) {
        return this;
    }

    public HlsMediaPlaylist copyWith(long l10, int n10) {
        int n11 = this.playlistType;
        String string2 = this.baseUri;
        List list = this.tags;
        long l11 = this.startOffsetUs;
        long l12 = this.mediaSequence;
        int n12 = this.version;
        long l13 = this.targetDurationUs;
        long l14 = this.partTargetDurationUs;
        boolean bl2 = this.hasIndependentSegments;
        boolean bl3 = this.hasEndTag;
        boolean bl4 = this.hasProgramDateTime;
        DrmInitData drmInitData = this.protectionSchemes;
        List list2 = this.segments;
        List list3 = this.trailingParts;
        HlsMediaPlaylist$ServerControl hlsMediaPlaylist$ServerControl = this.serverControl;
        Map map = this.renditionReports;
        HlsMediaPlaylist hlsMediaPlaylist = new HlsMediaPlaylist(n11, string2, list, l11, l10, true, n10, l12, n12, l13, l14, bl2, bl3, bl4, drmInitData, list2, list3, hlsMediaPlaylist$ServerControl, map);
        return hlsMediaPlaylist;
    }

    public HlsMediaPlaylist copyWithEndTag() {
        boolean bl2 = this.hasEndTag;
        if (bl2) {
            return this;
        }
        int n10 = this.playlistType;
        String string2 = this.baseUri;
        List list = this.tags;
        long l10 = this.startOffsetUs;
        long l11 = this.startTimeUs;
        boolean bl3 = this.hasDiscontinuitySequence;
        int n11 = this.discontinuitySequence;
        long l12 = this.mediaSequence;
        int n12 = this.version;
        long l13 = this.targetDurationUs;
        long l14 = this.partTargetDurationUs;
        boolean bl4 = this.hasIndependentSegments;
        bl2 = this.hasProgramDateTime;
        DrmInitData drmInitData = this.protectionSchemes;
        List list2 = this.segments;
        List list3 = this.trailingParts;
        HlsMediaPlaylist$ServerControl hlsMediaPlaylist$ServerControl = this.serverControl;
        Map map = this.renditionReports;
        HlsMediaPlaylist hlsMediaPlaylist = new HlsMediaPlaylist(n10, string2, list, l10, l11, bl3, n11, l12, n12, l13, l14, bl4, true, bl2, drmInitData, list2, list3, hlsMediaPlaylist$ServerControl, map);
        return hlsMediaPlaylist;
    }

    public long getEndTimeUs() {
        long l10 = this.startTimeUs;
        long l11 = this.durationUs;
        return l10 + l11;
    }

    public boolean isNewerThan(HlsMediaPlaylist hlsMediaPlaylist) {
        long l10;
        long l11;
        long l12;
        long l13;
        boolean bl2 = true;
        if (hlsMediaPlaylist != null && (l13 = (l12 = (l11 = this.mediaSequence) - (l10 = hlsMediaPlaylist.mediaSequence)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) <= 0) {
            boolean bl3;
            Object object = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
            if (object < 0) {
                return false;
            }
            List list = this.segments;
            object = list.size();
            List list2 = hlsMediaPlaylist.segments;
            int n10 = list2.size();
            if ((object -= n10) != false) {
                if (object <= 0) {
                    bl2 = false;
                }
                return bl2;
            }
            list = this.trailingParts;
            object = list.size();
            if (object <= (n10 = (list2 = hlsMediaPlaylist.trailingParts).size()) && (object != n10 || (object = (Object)this.hasEndTag) == false || (bl3 = hlsMediaPlaylist.hasEndTag))) {
                bl2 = false;
            }
        }
        return bl2;
    }
}

