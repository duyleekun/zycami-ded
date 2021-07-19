/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.net.Uri
 *  android.os.Bundle
 */
package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.MediaDescriptionCompat;

public final class MediaDescriptionCompat$Builder {
    private CharSequence mDescription;
    private Bundle mExtras;
    private Bitmap mIcon;
    private Uri mIconUri;
    private String mMediaId;
    private Uri mMediaUri;
    private CharSequence mSubtitle;
    private CharSequence mTitle;

    public MediaDescriptionCompat build() {
        String string2 = this.mMediaId;
        CharSequence charSequence = this.mTitle;
        CharSequence charSequence2 = this.mSubtitle;
        CharSequence charSequence3 = this.mDescription;
        Bitmap bitmap = this.mIcon;
        Uri uri = this.mIconUri;
        Bundle bundle = this.mExtras;
        Uri uri2 = this.mMediaUri;
        MediaDescriptionCompat mediaDescriptionCompat = new MediaDescriptionCompat(string2, charSequence, charSequence2, charSequence3, bitmap, uri, bundle, uri2);
        return mediaDescriptionCompat;
    }

    public MediaDescriptionCompat$Builder setDescription(CharSequence charSequence) {
        this.mDescription = charSequence;
        return this;
    }

    public MediaDescriptionCompat$Builder setExtras(Bundle bundle) {
        this.mExtras = bundle;
        return this;
    }

    public MediaDescriptionCompat$Builder setIconBitmap(Bitmap bitmap) {
        this.mIcon = bitmap;
        return this;
    }

    public MediaDescriptionCompat$Builder setIconUri(Uri uri) {
        this.mIconUri = uri;
        return this;
    }

    public MediaDescriptionCompat$Builder setMediaId(String string2) {
        this.mMediaId = string2;
        return this;
    }

    public MediaDescriptionCompat$Builder setMediaUri(Uri uri) {
        this.mMediaUri = uri;
        return this;
    }

    public MediaDescriptionCompat$Builder setSubtitle(CharSequence charSequence) {
        this.mSubtitle = charSequence;
        return this;
    }

    public MediaDescriptionCompat$Builder setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        return this;
    }
}

