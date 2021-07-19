/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist$Rendition;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist$Variant;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class HlsMasterPlaylist
extends HlsPlaylist {
    public static final HlsMasterPlaylist EMPTY;
    public static final int GROUP_INDEX_AUDIO = 1;
    public static final int GROUP_INDEX_SUBTITLE = 2;
    public static final int GROUP_INDEX_VARIANT;
    public final List audios;
    public final List closedCaptions;
    public final List mediaPlaylistUrls;
    public final Format muxedAudioFormat;
    public final List muxedCaptionFormats;
    public final List sessionKeyDrmInitData;
    public final List subtitles;
    public final Map variableDefinitions;
    public final List variants;
    public final List videos;

    static {
        HlsMasterPlaylist hlsMasterPlaylist;
        List list = Collections.emptyList();
        List list2 = Collections.emptyList();
        List list3 = Collections.emptyList();
        List list4 = Collections.emptyList();
        List list5 = Collections.emptyList();
        List list6 = Collections.emptyList();
        List list7 = Collections.emptyList();
        Map map = Collections.emptyMap();
        List list8 = Collections.emptyList();
        EMPTY = hlsMasterPlaylist = new HlsMasterPlaylist("", list, list2, list3, list4, list5, list6, null, list7, false, map, list8);
    }

    public HlsMasterPlaylist(String list, List list2, List list3, List list4, List list5, List list6, List list7, Format format, List list8, boolean bl2, Map map, List list9) {
        super((String)((Object)list), list2, bl2);
        list = Collections.unmodifiableList(HlsMasterPlaylist.getMediaPlaylistUrls(list3, list4, list5, list6, list7));
        this.mediaPlaylistUrls = list;
        list = Collections.unmodifiableList(list3);
        this.variants = list;
        list = Collections.unmodifiableList(list4);
        this.videos = list;
        list = Collections.unmodifiableList(list5);
        this.audios = list;
        list = Collections.unmodifiableList(list6);
        this.subtitles = list;
        list = Collections.unmodifiableList(list7);
        this.closedCaptions = list;
        this.muxedAudioFormat = format;
        list = list8 != null ? Collections.unmodifiableList(list8) : null;
        this.muxedCaptionFormats = list;
        list = Collections.unmodifiableMap(map);
        this.variableDefinitions = list;
        this.sessionKeyDrmInitData = list = Collections.unmodifiableList(list9);
    }

    private static void addMediaPlaylistUrls(List list, List list2) {
        int n10;
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            boolean bl2;
            Uri uri = ((HlsMasterPlaylist$Rendition)list.get((int)i10)).url;
            if (uri == null || (bl2 = list2.contains(uri))) continue;
            list2.add(uri);
        }
    }

    private static List copyStreams(List list, int n10, List list2) {
        int n11;
        int n12 = list2.size();
        ArrayList arrayList = new ArrayList(n12);
        n12 = 0;
        block0: for (int i10 = 0; i10 < (n11 = list.size()); ++i10) {
            int n13;
            Object e10 = list.get(i10);
            for (int i11 = 0; i11 < (n13 = list2.size()); ++i11) {
                StreamKey streamKey = (StreamKey)list2.get(i11);
                int n14 = streamKey.groupIndex;
                if (n14 != n10 || (n13 = streamKey.trackIndex) != i10) continue;
                arrayList.add(e10);
                continue block0;
            }
        }
        return arrayList;
    }

    public static HlsMasterPlaylist createSingleVariantMasterPlaylist(String object) {
        List<HlsMasterPlaylist$Variant> list = Collections.singletonList(HlsMasterPlaylist$Variant.createMediaPlaylistVariantUrl(Uri.parse((String)object)));
        List list2 = Collections.emptyList();
        List list3 = Collections.emptyList();
        List list4 = Collections.emptyList();
        List list5 = Collections.emptyList();
        List list6 = Collections.emptyList();
        Map map = Collections.emptyMap();
        List list7 = Collections.emptyList();
        object = new HlsMasterPlaylist("", list2, list, list3, list4, list5, list6, null, null, false, map, list7);
        return object;
    }

    private static List getMediaPlaylistUrls(List list, List list2, List list3, List list4, List list5) {
        int n10;
        ArrayList<Uri> arrayList = new ArrayList<Uri>();
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            Uri uri = ((HlsMasterPlaylist$Variant)list.get((int)i10)).url;
            boolean bl2 = arrayList.contains(uri);
            if (bl2) continue;
            arrayList.add(uri);
        }
        HlsMasterPlaylist.addMediaPlaylistUrls(list2, arrayList);
        HlsMasterPlaylist.addMediaPlaylistUrls(list3, arrayList);
        HlsMasterPlaylist.addMediaPlaylistUrls(list4, arrayList);
        HlsMasterPlaylist.addMediaPlaylistUrls(list5, arrayList);
        return arrayList;
    }

    public HlsMasterPlaylist copy(List list) {
        String string2 = this.baseUri;
        List list2 = this.tags;
        List list3 = HlsMasterPlaylist.copyStreams(this.variants, 0, list);
        List list4 = Collections.emptyList();
        List list5 = HlsMasterPlaylist.copyStreams(this.audios, 1, list);
        List list6 = HlsMasterPlaylist.copyStreams(this.subtitles, 2, list);
        List list7 = Collections.emptyList();
        Format format = this.muxedAudioFormat;
        List list8 = this.muxedCaptionFormats;
        boolean bl2 = this.hasIndependentSegments;
        Map map = this.variableDefinitions;
        List list9 = this.sessionKeyDrmInitData;
        HlsMasterPlaylist hlsMasterPlaylist = new HlsMasterPlaylist(string2, list2, list3, list4, list5, list6, list7, format, list8, bl2, map, list9);
        return hlsMasterPlaylist;
    }
}

