/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker$PlaylistEventListener;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker$PrimaryPlaylistListener;

public interface HlsPlaylistTracker {
    public void addListener(HlsPlaylistTracker$PlaylistEventListener var1);

    public long getInitialStartTimeUs();

    public HlsMasterPlaylist getMasterPlaylist();

    public HlsMediaPlaylist getPlaylistSnapshot(Uri var1, boolean var2);

    public boolean isLive();

    public boolean isSnapshotValid(Uri var1);

    public void maybeThrowPlaylistRefreshError(Uri var1);

    public void maybeThrowPrimaryPlaylistRefreshError();

    public void refreshPlaylist(Uri var1);

    public void removeListener(HlsPlaylistTracker$PlaylistEventListener var1);

    public void start(Uri var1, MediaSourceEventListener$EventDispatcher var2, HlsPlaylistTracker$PrimaryPlaylistListener var3);

    public void stop();
}

