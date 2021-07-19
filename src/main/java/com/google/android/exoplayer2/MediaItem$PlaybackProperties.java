/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2;

import android.net.Uri;
import com.google.android.exoplayer2.MediaItem$1;
import com.google.android.exoplayer2.MediaItem$AdsConfiguration;
import com.google.android.exoplayer2.MediaItem$DrmConfiguration;
import com.google.android.exoplayer2.util.Util;
import java.util.List;

public final class MediaItem$PlaybackProperties {
    public final MediaItem$AdsConfiguration adsConfiguration;
    public final String customCacheKey;
    public final MediaItem$DrmConfiguration drmConfiguration;
    public final String mimeType;
    public final List streamKeys;
    public final List subtitles;
    public final Object tag;
    public final Uri uri;

    private MediaItem$PlaybackProperties(Uri uri, String string2, MediaItem$DrmConfiguration mediaItem$DrmConfiguration, MediaItem$AdsConfiguration mediaItem$AdsConfiguration, List list, String string3, List list2, Object object) {
        this.uri = uri;
        this.mimeType = string2;
        this.drmConfiguration = mediaItem$DrmConfiguration;
        this.adsConfiguration = mediaItem$AdsConfiguration;
        this.streamKeys = list;
        this.customCacheKey = string3;
        this.subtitles = list2;
        this.tag = object;
    }

    public /* synthetic */ MediaItem$PlaybackProperties(Uri uri, String string2, MediaItem$DrmConfiguration mediaItem$DrmConfiguration, MediaItem$AdsConfiguration mediaItem$AdsConfiguration, List list, String string3, List list2, Object object, MediaItem$1 mediaItem$1) {
        this(uri, string2, mediaItem$DrmConfiguration, mediaItem$AdsConfiguration, list, string3, list2, object);
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3 = true;
        if (this == object) {
            return bl3;
        }
        boolean bl4 = object instanceof MediaItem$PlaybackProperties;
        if (!bl4) {
            return false;
        }
        object = (MediaItem$PlaybackProperties)object;
        Object object2 = this.uri;
        Object object3 = ((MediaItem$PlaybackProperties)object).uri;
        bl4 = object2.equals(object3);
        if (!(bl4 && (bl4 = Util.areEqual(object2 = this.mimeType, object3 = ((MediaItem$PlaybackProperties)object).mimeType)) && (bl4 = Util.areEqual(object2 = this.drmConfiguration, object3 = ((MediaItem$PlaybackProperties)object).drmConfiguration)) && (bl4 = Util.areEqual(object2 = this.adsConfiguration, object3 = ((MediaItem$PlaybackProperties)object).adsConfiguration)) && (bl4 = (object2 = this.streamKeys).equals(object3 = ((MediaItem$PlaybackProperties)object).streamKeys)) && (bl4 = Util.areEqual(object2 = this.customCacheKey, object3 = ((MediaItem$PlaybackProperties)object).customCacheKey)) && (bl4 = (object2 = this.subtitles).equals(object3 = ((MediaItem$PlaybackProperties)object).subtitles)) && (bl2 = Util.areEqual(object2 = this.tag, object = ((MediaItem$PlaybackProperties)object).tag)))) {
            bl3 = false;
        }
        return bl3;
    }

    public int hashCode() {
        int n10;
        Uri uri = this.uri;
        int n11 = uri.hashCode() * 31;
        Object object = this.mimeType;
        int n12 = 0;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = ((String)object).hashCode();
        }
        n11 = (n11 + n10) * 31;
        object = this.drmConfiguration;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = ((MediaItem$DrmConfiguration)object).hashCode();
        }
        n11 = (n11 + n10) * 31;
        object = this.adsConfiguration;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = ((MediaItem$AdsConfiguration)object).hashCode();
        }
        n11 = (n11 + n10) * 31;
        n10 = this.streamKeys.hashCode();
        n11 = (n11 + n10) * 31;
        object = this.customCacheKey;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = ((String)object).hashCode();
        }
        n11 = (n11 + n10) * 31;
        n10 = this.subtitles.hashCode();
        n11 = (n11 + n10) * 31;
        object = this.tag;
        if (object != null) {
            n12 = object.hashCode();
        }
        return n11 + n12;
    }
}

