/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2;

import android.net.Uri;
import com.google.android.exoplayer2.MediaItem$1;
import com.google.android.exoplayer2.util.Util;

public final class MediaItem$AdsConfiguration {
    public final Uri adTagUri;
    public final Object adsId;

    private MediaItem$AdsConfiguration(Uri uri, Object object) {
        this.adTagUri = uri;
        this.adsId = object;
    }

    public /* synthetic */ MediaItem$AdsConfiguration(Uri uri, Object object, MediaItem$1 mediaItem$1) {
        this(uri, object);
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3 = true;
        if (this == object) {
            return bl3;
        }
        boolean bl4 = object instanceof MediaItem$AdsConfiguration;
        if (!bl4) {
            return false;
        }
        object = (MediaItem$AdsConfiguration)object;
        Object object2 = this.adTagUri;
        Uri uri = ((MediaItem$AdsConfiguration)object).adTagUri;
        bl4 = object2.equals((Object)uri);
        if (!bl4 || !(bl2 = Util.areEqual(object2 = this.adsId, object = ((MediaItem$AdsConfiguration)object).adsId))) {
            bl3 = false;
        }
        return bl3;
    }

    public int hashCode() {
        int n10;
        Uri uri = this.adTagUri;
        int n11 = uri.hashCode() * 31;
        Object object = this.adsId;
        if (object != null) {
            n10 = object.hashCode();
        } else {
            n10 = 0;
            object = null;
        }
        return n11 + n10;
    }
}

