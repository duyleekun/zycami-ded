/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;

public interface HlsPlaylistTracker$PlaylistEventListener {
    public void onPlaylistChanged();

    public boolean onPlaylistError(Uri var1, long var2);
}

