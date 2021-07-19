/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.media.MediaDescription
 *  android.media.MediaDescription$Builder
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 */
package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompat$1;
import android.support.v4.media.MediaDescriptionCompat$Builder;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;

public final class MediaDescriptionCompat
implements Parcelable {
    public static final long BT_FOLDER_TYPE_ALBUMS = 2L;
    public static final long BT_FOLDER_TYPE_ARTISTS = 3L;
    public static final long BT_FOLDER_TYPE_GENRES = 4L;
    public static final long BT_FOLDER_TYPE_MIXED = 0L;
    public static final long BT_FOLDER_TYPE_PLAYLISTS = 5L;
    public static final long BT_FOLDER_TYPE_TITLES = 1L;
    public static final long BT_FOLDER_TYPE_YEARS = 6L;
    public static final Parcelable.Creator CREATOR;
    public static final String DESCRIPTION_KEY_MEDIA_URI = "android.support.v4.media.description.MEDIA_URI";
    public static final String DESCRIPTION_KEY_NULL_BUNDLE_FLAG = "android.support.v4.media.description.NULL_BUNDLE_FLAG";
    public static final String EXTRA_BT_FOLDER_TYPE = "android.media.extra.BT_FOLDER_TYPE";
    public static final String EXTRA_DOWNLOAD_STATUS = "android.media.extra.DOWNLOAD_STATUS";
    public static final long STATUS_DOWNLOADED = 2L;
    public static final long STATUS_DOWNLOADING = 1L;
    public static final long STATUS_NOT_DOWNLOADED = 0L;
    private static final String TAG = "MediaDescriptionCompat";
    private final CharSequence mDescription;
    private MediaDescription mDescriptionFwk;
    private final Bundle mExtras;
    private final Bitmap mIcon;
    private final Uri mIconUri;
    private final String mMediaId;
    private final Uri mMediaUri;
    private final CharSequence mSubtitle;
    private final CharSequence mTitle;

    static {
        MediaDescriptionCompat$1 mediaDescriptionCompat$1 = new MediaDescriptionCompat$1();
        CREATOR = mediaDescriptionCompat$1;
    }

    public MediaDescriptionCompat(Parcel parcel) {
        Bitmap bitmap;
        Object object = parcel.readString();
        this.mMediaId = object;
        object = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mTitle = object;
        object = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mSubtitle = object;
        object = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mDescription = object;
        object = MediaDescriptionCompat.class.getClassLoader();
        this.mIcon = bitmap = (Bitmap)parcel.readParcelable((ClassLoader)object);
        bitmap = (Uri)parcel.readParcelable((ClassLoader)object);
        this.mIconUri = bitmap;
        bitmap = parcel.readBundle((ClassLoader)object);
        this.mExtras = bitmap;
        parcel = (Uri)parcel.readParcelable((ClassLoader)object);
        this.mMediaUri = parcel;
    }

    public MediaDescriptionCompat(String string2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.mMediaId = string2;
        this.mTitle = charSequence;
        this.mSubtitle = charSequence2;
        this.mDescription = charSequence3;
        this.mIcon = bitmap;
        this.mIconUri = uri;
        this.mExtras = bundle;
        this.mMediaUri = uri2;
    }

    public static MediaDescriptionCompat fromMediaDescription(Object object) {
        Object object2;
        block7: {
            Uri uri;
            MediaDescriptionCompat$Builder mediaDescriptionCompat$Builder;
            int n10;
            int n11;
            block9: {
                CharSequence charSequence;
                block8: {
                    int n12;
                    int n13;
                    n11 = 0;
                    object2 = null;
                    if (object == null || (n10 = Build.VERSION.SDK_INT) < (n13 = 21)) break block7;
                    mediaDescriptionCompat$Builder = new MediaDescriptionCompat$Builder();
                    object = (MediaDescription)object;
                    charSequence = object.getMediaId();
                    mediaDescriptionCompat$Builder.setMediaId((String)charSequence);
                    charSequence = object.getTitle();
                    mediaDescriptionCompat$Builder.setTitle(charSequence);
                    charSequence = object.getSubtitle();
                    mediaDescriptionCompat$Builder.setSubtitle(charSequence);
                    charSequence = object.getDescription();
                    mediaDescriptionCompat$Builder.setDescription(charSequence);
                    charSequence = object.getIconBitmap();
                    mediaDescriptionCompat$Builder.setIconBitmap((Bitmap)charSequence);
                    charSequence = object.getIconUri();
                    mediaDescriptionCompat$Builder.setIconUri((Uri)charSequence);
                    charSequence = object.getExtras();
                    if (charSequence != null) {
                        charSequence = MediaSessionCompat.unparcelWithClassLoader((Bundle)charSequence);
                    }
                    String string2 = DESCRIPTION_KEY_MEDIA_URI;
                    uri = charSequence != null ? (Uri)charSequence.getParcelable(string2) : null;
                    if (uri == null) break block8;
                    String string3 = DESCRIPTION_KEY_NULL_BUNDLE_FLAG;
                    int n14 = charSequence.containsKey(string3);
                    if (n14 != 0 && (n14 = charSequence.size()) == (n12 = 2)) break block9;
                    charSequence.remove(string2);
                    charSequence.remove(string3);
                }
                object2 = charSequence;
            }
            mediaDescriptionCompat$Builder.setExtras((Bundle)object2);
            if (uri != null) {
                mediaDescriptionCompat$Builder.setMediaUri(uri);
            } else {
                n11 = 23;
                if (n10 >= n11) {
                    object2 = object.getMediaUri();
                    mediaDescriptionCompat$Builder.setMediaUri((Uri)object2);
                }
            }
            object2 = mediaDescriptionCompat$Builder.build();
            ((MediaDescriptionCompat)object2).mDescriptionFwk = object;
        }
        return object2;
    }

    public int describeContents() {
        return 0;
    }

    public CharSequence getDescription() {
        return this.mDescription;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public Bitmap getIconBitmap() {
        return this.mIcon;
    }

    public Uri getIconUri() {
        return this.mIconUri;
    }

    public Object getMediaDescription() {
        int n10;
        int n11;
        MediaDescription mediaDescription = this.mDescriptionFwk;
        if (mediaDescription == null && (n11 = Build.VERSION.SDK_INT) >= (n10 = 21)) {
            Uri uri;
            mediaDescription = new MediaDescription.Builder();
            CharSequence charSequence = this.mMediaId;
            mediaDescription.setMediaId(charSequence);
            charSequence = this.mTitle;
            mediaDescription.setTitle(charSequence);
            charSequence = this.mSubtitle;
            mediaDescription.setSubtitle(charSequence);
            charSequence = this.mDescription;
            mediaDescription.setDescription(charSequence);
            charSequence = this.mIcon;
            mediaDescription.setIconBitmap((Bitmap)charSequence);
            charSequence = this.mIconUri;
            mediaDescription.setIconUri((Uri)charSequence);
            charSequence = this.mExtras;
            int n12 = 23;
            if (n11 < n12 && (uri = this.mMediaUri) != null) {
                String string2;
                if (charSequence == null) {
                    charSequence = new Bundle();
                    boolean bl2 = true;
                    string2 = DESCRIPTION_KEY_NULL_BUNDLE_FLAG;
                    charSequence.putBoolean(string2, bl2);
                }
                uri = this.mMediaUri;
                string2 = DESCRIPTION_KEY_MEDIA_URI;
                charSequence.putParcelable(string2, (Parcelable)uri);
            }
            mediaDescription.setExtras((Bundle)charSequence);
            if (n11 >= n12) {
                Uri uri2 = this.mMediaUri;
                mediaDescription.setMediaUri(uri2);
            }
            this.mDescriptionFwk = mediaDescription = mediaDescription.build();
        }
        return mediaDescription;
    }

    public String getMediaId() {
        return this.mMediaId;
    }

    public Uri getMediaUri() {
        return this.mMediaUri;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        CharSequence charSequence = this.mTitle;
        stringBuilder.append((Object)charSequence);
        charSequence = ", ";
        stringBuilder.append((String)charSequence);
        CharSequence charSequence2 = this.mSubtitle;
        stringBuilder.append((Object)charSequence2);
        stringBuilder.append((String)charSequence);
        charSequence = this.mDescription;
        stringBuilder.append((Object)charSequence);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 21;
        if (n11 < n12) {
            String string2 = this.mMediaId;
            parcel.writeString(string2);
            TextUtils.writeToParcel((CharSequence)this.mTitle, (Parcel)parcel, (int)n10);
            TextUtils.writeToParcel((CharSequence)this.mSubtitle, (Parcel)parcel, (int)n10);
            TextUtils.writeToParcel((CharSequence)this.mDescription, (Parcel)parcel, (int)n10);
            string2 = this.mIcon;
            parcel.writeParcelable((Parcelable)string2, n10);
            string2 = this.mIconUri;
            parcel.writeParcelable((Parcelable)string2, n10);
            string2 = this.mExtras;
            parcel.writeBundle((Bundle)string2);
            string2 = this.mMediaUri;
            parcel.writeParcelable((Parcelable)string2, n10);
        } else {
            MediaDescription mediaDescription = (MediaDescription)this.getMediaDescription();
            mediaDescription.writeToParcel(parcel, n10);
        }
    }
}

