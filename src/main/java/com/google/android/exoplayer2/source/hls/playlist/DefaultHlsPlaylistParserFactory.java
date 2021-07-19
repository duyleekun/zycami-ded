/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory;
import com.google.android.exoplayer2.upstream.ParsingLoadable$Parser;

public final class DefaultHlsPlaylistParserFactory
implements HlsPlaylistParserFactory {
    public ParsingLoadable$Parser createPlaylistParser() {
        HlsPlaylistParser hlsPlaylistParser = new HlsPlaylistParser();
        return hlsPlaylistParser;
    }

    public ParsingLoadable$Parser createPlaylistParser(HlsMasterPlaylist hlsMasterPlaylist, HlsMediaPlaylist hlsMediaPlaylist) {
        HlsPlaylistParser hlsPlaylistParser = new HlsPlaylistParser(hlsMasterPlaylist, hlsMediaPlaylist);
        return hlsPlaylistParser;
    }
}

