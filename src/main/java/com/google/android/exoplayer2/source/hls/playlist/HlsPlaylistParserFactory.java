/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.upstream.ParsingLoadable$Parser;

public interface HlsPlaylistParserFactory {
    public ParsingLoadable$Parser createPlaylistParser();

    public ParsingLoadable$Parser createPlaylistParser(HlsMasterPlaylist var1, HlsMediaPlaylist var2);
}

