/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.offline.FilteringManifestParser;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory;
import com.google.android.exoplayer2.upstream.ParsingLoadable$Parser;
import java.util.List;

public final class FilteringHlsPlaylistParserFactory
implements HlsPlaylistParserFactory {
    private final HlsPlaylistParserFactory hlsPlaylistParserFactory;
    private final List streamKeys;

    public FilteringHlsPlaylistParserFactory(HlsPlaylistParserFactory hlsPlaylistParserFactory, List list) {
        this.hlsPlaylistParserFactory = hlsPlaylistParserFactory;
        this.streamKeys = list;
    }

    public ParsingLoadable$Parser createPlaylistParser() {
        ParsingLoadable$Parser parsingLoadable$Parser = this.hlsPlaylistParserFactory.createPlaylistParser();
        List list = this.streamKeys;
        FilteringManifestParser filteringManifestParser = new FilteringManifestParser(parsingLoadable$Parser, list);
        return filteringManifestParser;
    }

    public ParsingLoadable$Parser createPlaylistParser(HlsMasterPlaylist object, HlsMediaPlaylist object2) {
        object = this.hlsPlaylistParserFactory.createPlaylistParser((HlsMasterPlaylist)object, (HlsMediaPlaylist)object2);
        object2 = this.streamKeys;
        FilteringManifestParser filteringManifestParser = new FilteringManifestParser((ParsingLoadable$Parser)object, (List)object2);
        return filteringManifestParser;
    }
}

