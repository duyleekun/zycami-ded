/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;

public final class HlsMediaPlaylist$RenditionReport {
    public final long lastMediaSequence;
    public final int lastPartIndex;
    public final Uri playlistUri;

    public HlsMediaPlaylist$RenditionReport(Uri uri, long l10, int n10) {
        this.playlistUri = uri;
        this.lastMediaSequence = l10;
        this.lastPartIndex = n10;
    }
}

