/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import com.google.android.exoplayer2.Format;

public final class HlsMasterPlaylist$Rendition {
    public final Format format;
    public final String groupId;
    public final String name;
    public final Uri url;

    public HlsMasterPlaylist$Rendition(Uri uri, Format format, String string2, String string3) {
        this.url = uri;
        this.format = format;
        this.groupId = string2;
        this.name = string3;
    }
}

