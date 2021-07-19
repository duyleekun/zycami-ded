/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2;

import android.net.Uri;
import com.google.android.exoplayer2.MediaItem$1;
import com.google.android.exoplayer2.MediaItem$Builder;
import com.google.android.exoplayer2.MediaItem$ClippingProperties;
import com.google.android.exoplayer2.MediaItem$LiveConfiguration;
import com.google.android.exoplayer2.MediaItem$PlaybackProperties;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.util.Util;

public final class MediaItem {
    public final MediaItem$ClippingProperties clippingProperties;
    public final MediaItem$LiveConfiguration liveConfiguration;
    public final String mediaId;
    public final MediaMetadata mediaMetadata;
    public final MediaItem$PlaybackProperties playbackProperties;

    private MediaItem(String string2, MediaItem$ClippingProperties mediaItem$ClippingProperties, MediaItem$PlaybackProperties mediaItem$PlaybackProperties, MediaItem$LiveConfiguration mediaItem$LiveConfiguration, MediaMetadata mediaMetadata) {
        this.mediaId = string2;
        this.playbackProperties = mediaItem$PlaybackProperties;
        this.liveConfiguration = mediaItem$LiveConfiguration;
        this.mediaMetadata = mediaMetadata;
        this.clippingProperties = mediaItem$ClippingProperties;
    }

    public /* synthetic */ MediaItem(String string2, MediaItem$ClippingProperties mediaItem$ClippingProperties, MediaItem$PlaybackProperties mediaItem$PlaybackProperties, MediaItem$LiveConfiguration mediaItem$LiveConfiguration, MediaMetadata mediaMetadata, MediaItem$1 mediaItem$1) {
        this(string2, mediaItem$ClippingProperties, mediaItem$PlaybackProperties, mediaItem$LiveConfiguration, mediaMetadata);
    }

    public static MediaItem fromUri(Uri uri) {
        MediaItem$Builder mediaItem$Builder = new MediaItem$Builder();
        return mediaItem$Builder.setUri(uri).build();
    }

    public static MediaItem fromUri(String string2) {
        MediaItem$Builder mediaItem$Builder = new MediaItem$Builder();
        return mediaItem$Builder.setUri(string2).build();
    }

    public MediaItem$Builder buildUpon() {
        MediaItem$Builder mediaItem$Builder = new MediaItem$Builder(this, null);
        return mediaItem$Builder;
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3 = true;
        if (this == object) {
            return bl3;
        }
        boolean bl4 = object instanceof MediaItem;
        if (!bl4) {
            return false;
        }
        object = (MediaItem)object;
        Object object2 = this.mediaId;
        Object object3 = ((MediaItem)object).mediaId;
        bl4 = Util.areEqual(object2, object3);
        if (!(bl4 && (bl4 = ((MediaItem$ClippingProperties)(object2 = this.clippingProperties)).equals(object3 = ((MediaItem)object).clippingProperties)) && (bl4 = Util.areEqual(object2 = this.playbackProperties, object3 = ((MediaItem)object).playbackProperties)) && (bl4 = Util.areEqual(object2 = this.liveConfiguration, object3 = ((MediaItem)object).liveConfiguration)) && (bl2 = Util.areEqual(object2 = this.mediaMetadata, object = ((MediaItem)object).mediaMetadata)))) {
            bl3 = false;
        }
        return bl3;
    }

    public int hashCode() {
        int n10;
        String string2 = this.mediaId;
        int n11 = string2.hashCode() * 31;
        MediaItem$PlaybackProperties mediaItem$PlaybackProperties = this.playbackProperties;
        if (mediaItem$PlaybackProperties != null) {
            n10 = mediaItem$PlaybackProperties.hashCode();
        } else {
            n10 = 0;
            mediaItem$PlaybackProperties = null;
        }
        n11 = (n11 + n10) * 31;
        n10 = this.liveConfiguration.hashCode();
        n11 = (n11 + n10) * 31;
        n10 = this.clippingProperties.hashCode();
        n11 = (n11 + n10) * 31;
        n10 = this.mediaMetadata.hashCode();
        return n11 + n10;
    }
}

