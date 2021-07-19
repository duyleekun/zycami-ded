/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ClipData
 *  android.net.Uri
 *  android.os.Bundle
 */
package androidx.core.view;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.view.ContentInfoCompat;

public final class ContentInfoCompat$Builder {
    public ClipData mClip;
    public Bundle mExtras;
    public int mFlags;
    public Uri mLinkUri;
    public int mSource;

    public ContentInfoCompat$Builder(ClipData clipData, int n10) {
        this.mClip = clipData;
        this.mSource = n10;
    }

    public ContentInfoCompat$Builder(ContentInfoCompat contentInfoCompat) {
        int n10;
        ClipData clipData;
        this.mClip = clipData = contentInfoCompat.mClip;
        this.mSource = n10 = contentInfoCompat.mSource;
        this.mFlags = n10 = contentInfoCompat.mFlags;
        clipData = contentInfoCompat.mLinkUri;
        this.mLinkUri = clipData;
        contentInfoCompat = contentInfoCompat.mExtras;
        this.mExtras = contentInfoCompat;
    }

    public ContentInfoCompat build() {
        ContentInfoCompat contentInfoCompat = new ContentInfoCompat(this);
        return contentInfoCompat;
    }

    public ContentInfoCompat$Builder setClip(ClipData clipData) {
        this.mClip = clipData;
        return this;
    }

    public ContentInfoCompat$Builder setExtras(Bundle bundle) {
        this.mExtras = bundle;
        return this;
    }

    public ContentInfoCompat$Builder setFlags(int n10) {
        this.mFlags = n10;
        return this;
    }

    public ContentInfoCompat$Builder setLinkUri(Uri uri) {
        this.mLinkUri = uri;
        return this;
    }

    public ContentInfoCompat$Builder setSource(int n10) {
        this.mSource = n10;
        return this;
    }
}

