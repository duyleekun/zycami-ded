/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import java.io.IOException;

public final class HlsPlaylistTracker$PlaylistStuckException
extends IOException {
    public final Uri url;

    public HlsPlaylistTracker$PlaylistStuckException(Uri uri) {
        this.url = uri;
    }
}

