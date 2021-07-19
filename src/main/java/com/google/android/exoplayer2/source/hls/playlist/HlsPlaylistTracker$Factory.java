/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.source.hls.HlsDataSourceFactory;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;

public interface HlsPlaylistTracker$Factory {
    public HlsPlaylistTracker createTracker(HlsDataSourceFactory var1, LoadErrorHandlingPolicy var2, HlsPlaylistParserFactory var3);
}

