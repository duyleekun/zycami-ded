/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;

public final class HlsMasterPlaylist$Variant {
    public final String audioGroupId;
    public final String captionGroupId;
    public final Format format;
    public final String subtitleGroupId;
    public final Uri url;
    public final String videoGroupId;

    public HlsMasterPlaylist$Variant(Uri uri, Format format, String string2, String string3, String string4, String string5) {
        this.url = uri;
        this.format = format;
        this.videoGroupId = string2;
        this.audioGroupId = string3;
        this.subtitleGroupId = string4;
        this.captionGroupId = string5;
    }

    public static HlsMasterPlaylist$Variant createMediaPlaylistVariantUrl(Uri uri) {
        Object object = new Format$Builder();
        Format format = ((Format$Builder)object).setId("0").setContainerMimeType("application/x-mpegURL").build();
        object = new HlsMasterPlaylist$Variant(uri, format, null, null, null, null);
        return object;
    }

    public HlsMasterPlaylist$Variant copyWithFormat(Format format) {
        Uri uri = this.url;
        String string2 = this.videoGroupId;
        String string3 = this.audioGroupId;
        String string4 = this.subtitleGroupId;
        String string5 = this.captionGroupId;
        HlsMasterPlaylist$Variant hlsMasterPlaylist$Variant = new HlsMasterPlaylist$Variant(uri, format, string2, string3, string4, string5);
        return hlsMasterPlaylist$Variant;
    }
}

