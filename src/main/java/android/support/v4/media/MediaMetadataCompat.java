/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.media.MediaMetadata
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 *  android.util.Log
 */
package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaMetadata;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaDescriptionCompat$Builder;
import android.support.v4.media.MediaMetadataCompat$1;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import java.util.Set;

public final class MediaMetadataCompat
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public static final ArrayMap METADATA_KEYS_TYPE;
    public static final String METADATA_KEY_ADVERTISEMENT = "android.media.metadata.ADVERTISEMENT";
    public static final String METADATA_KEY_ALBUM = "android.media.metadata.ALBUM";
    public static final String METADATA_KEY_ALBUM_ART = "android.media.metadata.ALBUM_ART";
    public static final String METADATA_KEY_ALBUM_ARTIST = "android.media.metadata.ALBUM_ARTIST";
    public static final String METADATA_KEY_ALBUM_ART_URI = "android.media.metadata.ALBUM_ART_URI";
    public static final String METADATA_KEY_ART = "android.media.metadata.ART";
    public static final String METADATA_KEY_ARTIST = "android.media.metadata.ARTIST";
    public static final String METADATA_KEY_ART_URI = "android.media.metadata.ART_URI";
    public static final String METADATA_KEY_AUTHOR = "android.media.metadata.AUTHOR";
    public static final String METADATA_KEY_BT_FOLDER_TYPE = "android.media.metadata.BT_FOLDER_TYPE";
    public static final String METADATA_KEY_COMPILATION = "android.media.metadata.COMPILATION";
    public static final String METADATA_KEY_COMPOSER = "android.media.metadata.COMPOSER";
    public static final String METADATA_KEY_DATE = "android.media.metadata.DATE";
    public static final String METADATA_KEY_DISC_NUMBER = "android.media.metadata.DISC_NUMBER";
    public static final String METADATA_KEY_DISPLAY_DESCRIPTION = "android.media.metadata.DISPLAY_DESCRIPTION";
    public static final String METADATA_KEY_DISPLAY_ICON = "android.media.metadata.DISPLAY_ICON";
    public static final String METADATA_KEY_DISPLAY_ICON_URI = "android.media.metadata.DISPLAY_ICON_URI";
    public static final String METADATA_KEY_DISPLAY_SUBTITLE = "android.media.metadata.DISPLAY_SUBTITLE";
    public static final String METADATA_KEY_DISPLAY_TITLE = "android.media.metadata.DISPLAY_TITLE";
    public static final String METADATA_KEY_DOWNLOAD_STATUS = "android.media.metadata.DOWNLOAD_STATUS";
    public static final String METADATA_KEY_DURATION = "android.media.metadata.DURATION";
    public static final String METADATA_KEY_GENRE = "android.media.metadata.GENRE";
    public static final String METADATA_KEY_MEDIA_ID = "android.media.metadata.MEDIA_ID";
    public static final String METADATA_KEY_MEDIA_URI = "android.media.metadata.MEDIA_URI";
    public static final String METADATA_KEY_NUM_TRACKS = "android.media.metadata.NUM_TRACKS";
    public static final String METADATA_KEY_RATING = "android.media.metadata.RATING";
    public static final String METADATA_KEY_TITLE = "android.media.metadata.TITLE";
    public static final String METADATA_KEY_TRACK_NUMBER = "android.media.metadata.TRACK_NUMBER";
    public static final String METADATA_KEY_USER_RATING = "android.media.metadata.USER_RATING";
    public static final String METADATA_KEY_WRITER = "android.media.metadata.WRITER";
    public static final String METADATA_KEY_YEAR = "android.media.metadata.YEAR";
    public static final int METADATA_TYPE_BITMAP = 2;
    public static final int METADATA_TYPE_LONG = 0;
    public static final int METADATA_TYPE_RATING = 3;
    public static final int METADATA_TYPE_TEXT = 1;
    private static final String[] PREFERRED_BITMAP_ORDER;
    private static final String[] PREFERRED_DESCRIPTION_ORDER;
    private static final String[] PREFERRED_URI_ORDER;
    private static final String TAG = "MediaMetadata";
    public final Bundle mBundle;
    private MediaDescriptionCompat mDescription;
    private MediaMetadata mMetadataFwk;

    static {
        Object object = new ArrayMap();
        METADATA_KEYS_TYPE = object;
        Integer n10 = 1;
        ((SimpleArrayMap)object).put(METADATA_KEY_TITLE, n10);
        ((SimpleArrayMap)object).put(METADATA_KEY_ARTIST, n10);
        Integer n11 = 0;
        ((SimpleArrayMap)object).put(METADATA_KEY_DURATION, n11);
        ((SimpleArrayMap)object).put(METADATA_KEY_ALBUM, n10);
        ((SimpleArrayMap)object).put(METADATA_KEY_AUTHOR, n10);
        ((SimpleArrayMap)object).put(METADATA_KEY_WRITER, n10);
        ((SimpleArrayMap)object).put(METADATA_KEY_COMPOSER, n10);
        ((SimpleArrayMap)object).put(METADATA_KEY_COMPILATION, n10);
        ((SimpleArrayMap)object).put(METADATA_KEY_DATE, n10);
        ((SimpleArrayMap)object).put(METADATA_KEY_YEAR, n11);
        ((SimpleArrayMap)object).put(METADATA_KEY_GENRE, n10);
        ((SimpleArrayMap)object).put(METADATA_KEY_TRACK_NUMBER, n11);
        ((SimpleArrayMap)object).put(METADATA_KEY_NUM_TRACKS, n11);
        ((SimpleArrayMap)object).put(METADATA_KEY_DISC_NUMBER, n11);
        ((SimpleArrayMap)object).put(METADATA_KEY_ALBUM_ARTIST, n10);
        Object object2 = 2;
        String string2 = METADATA_KEY_ART;
        ((SimpleArrayMap)object).put(string2, object2);
        String string3 = METADATA_KEY_ART_URI;
        ((SimpleArrayMap)object).put(string3, n10);
        String string4 = METADATA_KEY_ALBUM_ART;
        ((SimpleArrayMap)object).put(string4, object2);
        String string5 = METADATA_KEY_ALBUM_ART_URI;
        ((SimpleArrayMap)object).put(string5, n10);
        Object object3 = 3;
        ((SimpleArrayMap)object).put(METADATA_KEY_USER_RATING, object3);
        ((SimpleArrayMap)object).put(METADATA_KEY_RATING, object3);
        ((SimpleArrayMap)object).put(METADATA_KEY_DISPLAY_TITLE, n10);
        ((SimpleArrayMap)object).put(METADATA_KEY_DISPLAY_SUBTITLE, n10);
        ((SimpleArrayMap)object).put(METADATA_KEY_DISPLAY_DESCRIPTION, n10);
        object3 = METADATA_KEY_DISPLAY_ICON;
        ((SimpleArrayMap)object).put(object3, object2);
        object2 = METADATA_KEY_DISPLAY_ICON_URI;
        ((SimpleArrayMap)object).put(object2, n10);
        ((SimpleArrayMap)object).put(METADATA_KEY_MEDIA_ID, n10);
        ((SimpleArrayMap)object).put(METADATA_KEY_BT_FOLDER_TYPE, n11);
        ((SimpleArrayMap)object).put(METADATA_KEY_MEDIA_URI, n10);
        ((SimpleArrayMap)object).put(METADATA_KEY_ADVERTISEMENT, n11);
        ((SimpleArrayMap)object).put(METADATA_KEY_DOWNLOAD_STATUS, n11);
        PREFERRED_DESCRIPTION_ORDER = new String[]{METADATA_KEY_TITLE, METADATA_KEY_ARTIST, METADATA_KEY_ALBUM, METADATA_KEY_ALBUM_ARTIST, METADATA_KEY_WRITER, METADATA_KEY_AUTHOR, METADATA_KEY_COMPOSER};
        PREFERRED_BITMAP_ORDER = new String[]{object3, string2, string4};
        PREFERRED_URI_ORDER = new String[]{object2, string3, string5};
        object = new MediaMetadataCompat$1();
        CREATOR = object;
    }

    public MediaMetadataCompat(Bundle bundle) {
        Bundle bundle2;
        this.mBundle = bundle2 = new Bundle(bundle);
        MediaSessionCompat.ensureClassLoader(bundle2);
    }

    public MediaMetadataCompat(Parcel parcel) {
        ClassLoader classLoader = MediaSessionCompat.class.getClassLoader();
        parcel = parcel.readBundle(classLoader);
        this.mBundle = parcel;
    }

    public static MediaMetadataCompat fromMediaMetadata(Object object) {
        int n10;
        int n11;
        if (object != null && (n11 = Build.VERSION.SDK_INT) >= (n10 = 21)) {
            Parcel parcel = Parcel.obtain();
            object = (MediaMetadata)object;
            object.writeToParcel(parcel, 0);
            parcel.setDataPosition(0);
            MediaMetadataCompat mediaMetadataCompat = (MediaMetadataCompat)CREATOR.createFromParcel(parcel);
            parcel.recycle();
            mediaMetadataCompat.mMetadataFwk = object;
            return mediaMetadataCompat;
        }
        return null;
    }

    public boolean containsKey(String string2) {
        return this.mBundle.containsKey(string2);
    }

    public int describeContents() {
        return 0;
    }

    public Bitmap getBitmap(String string2) {
        Object object = this.mBundle;
        string2 = object.getParcelable(string2);
        try {
            string2 = (Bitmap)string2;
        }
        catch (Exception exception) {
            object = TAG;
            String string3 = "Failed to retrieve a key as Bitmap.";
            Log.w((String)object, (String)string3, (Throwable)exception);
            string2 = null;
        }
        return string2;
    }

    public Bundle getBundle() {
        Bundle bundle = this.mBundle;
        Bundle bundle2 = new Bundle(bundle);
        return bundle2;
    }

    public MediaDescriptionCompat getDescription() {
        long l10;
        Uri uri;
        int n10;
        Object object;
        CharSequence charSequence;
        int n11;
        int n12;
        Object object2;
        Object object3;
        int n13;
        Object object4;
        block13: {
            block12: {
                int n14;
                int n15;
                object4 = this.mDescription;
                if (object4 != null) {
                    return object4;
                }
                object4 = this.getString(METADATA_KEY_MEDIA_ID);
                n13 = 3;
                object3 = new CharSequence[n13];
                object2 = this.getText(METADATA_KEY_DISPLAY_TITLE);
                int n16 = TextUtils.isEmpty((CharSequence)object2);
                n12 = 2;
                n11 = 1;
                if (n16 == 0) {
                    object3[0] = object2;
                    object3[n11] = charSequence = this.getText(METADATA_KEY_DISPLAY_SUBTITLE);
                    object3[n12] = charSequence = this.getText(METADATA_KEY_DISPLAY_DESCRIPTION);
                } else {
                    n15 = 0;
                    object2 = null;
                    n16 = 0;
                    object = null;
                    while (n15 < n13 && n16 < (n10 = ((String[])(uri = PREFERRED_DESCRIPTION_ORDER)).length)) {
                        n10 = n16 + 1;
                        object = uri[n16];
                        n14 = TextUtils.isEmpty((CharSequence)(object = this.getText((String)object)));
                        if (n14 == 0) {
                            n14 = n15 + 1;
                            object3[n15] = object;
                            n15 = n14;
                        }
                        n16 = n10;
                    }
                }
                n13 = 0;
                charSequence = null;
                while (true) {
                    object2 = PREFERRED_BITMAP_ORDER;
                    n16 = ((String[])object2).length;
                    n14 = 0;
                    uri = null;
                    if (n13 >= n16) break;
                    object2 = object2[n13];
                    if ((object2 = this.getBitmap((String)object2)) == null) {
                        ++n13;
                        continue;
                    }
                    break block12;
                    break;
                }
                n15 = 0;
                object2 = null;
            }
            charSequence = null;
            for (n13 = 0; n13 < (n10 = ((String[])(object = PREFERRED_URI_ORDER)).length); ++n13) {
                object = object[n13];
                n10 = TextUtils.isEmpty((CharSequence)(object = this.getString((String)object))) ? 1 : 0;
                if (n10 != 0) continue;
                charSequence = Uri.parse((String)object);
                break block13;
            }
            n13 = 0;
            charSequence = null;
        }
        object = this.getString(METADATA_KEY_MEDIA_URI);
        n10 = TextUtils.isEmpty((CharSequence)object) ? 1 : 0;
        if (n10 == 0) {
            uri = Uri.parse((String)object);
        }
        object = new MediaDescriptionCompat$Builder();
        ((MediaDescriptionCompat$Builder)object).setMediaId((String)object4);
        object4 = object3[0];
        ((MediaDescriptionCompat$Builder)object).setTitle((CharSequence)object4);
        object4 = object3[n11];
        ((MediaDescriptionCompat$Builder)object).setSubtitle((CharSequence)object4);
        object4 = object3[n12];
        ((MediaDescriptionCompat$Builder)object).setDescription((CharSequence)object4);
        ((MediaDescriptionCompat$Builder)object).setIconBitmap((Bitmap)object2);
        ((MediaDescriptionCompat$Builder)object).setIconUri((Uri)charSequence);
        ((MediaDescriptionCompat$Builder)object).setMediaUri(uri);
        object4 = new Bundle();
        charSequence = this.mBundle;
        object3 = METADATA_KEY_BT_FOLDER_TYPE;
        n13 = charSequence.containsKey((String)object3) ? 1 : 0;
        if (n13 != 0) {
            l10 = this.getLong((String)object3);
            object2 = "android.media.extra.BT_FOLDER_TYPE";
            object4.putLong((String)object2, l10);
        }
        if ((n13 = (int)((charSequence = this.mBundle).containsKey((String)(object3 = METADATA_KEY_DOWNLOAD_STATUS)) ? 1 : 0)) != 0) {
            l10 = this.getLong((String)object3);
            object2 = "android.media.extra.DOWNLOAD_STATUS";
            object4.putLong((String)object2, l10);
        }
        if ((n13 = (int)(object4.isEmpty() ? 1 : 0)) == 0) {
            ((MediaDescriptionCompat$Builder)object).setExtras((Bundle)object4);
        }
        this.mDescription = object4 = ((MediaDescriptionCompat$Builder)object).build();
        return object4;
    }

    public long getLong(String string2) {
        return this.mBundle.getLong(string2, 0L);
    }

    public Object getMediaMetadata() {
        int n10;
        int n11;
        MediaMetadata mediaMetadata = this.mMetadataFwk;
        if (mediaMetadata == null && (n11 = Build.VERSION.SDK_INT) >= (n10 = 21)) {
            MediaMetadata mediaMetadata2;
            mediaMetadata = Parcel.obtain();
            n10 = 0;
            this.writeToParcel((Parcel)mediaMetadata, 0);
            mediaMetadata.setDataPosition(0);
            this.mMetadataFwk = mediaMetadata2 = (MediaMetadata)MediaMetadata.CREATOR.createFromParcel((Parcel)mediaMetadata);
            mediaMetadata.recycle();
        }
        return this.mMetadataFwk;
    }

    public RatingCompat getRating(String object) {
        String string2;
        block8: {
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 19;
            if (n10 < n11) break block8;
            string2 = this.mBundle;
            object = string2.getParcelable((String)object);
            object = RatingCompat.fromRating(object);
        }
        string2 = this.mBundle;
        object = string2.getParcelable((String)object);
        try {
            object = (RatingCompat)object;
        }
        catch (Exception exception) {
            string2 = TAG;
            String string3 = "Failed to retrieve a key as Rating.";
            Log.w((String)string2, (String)string3, (Throwable)exception);
            object = null;
        }
        return object;
    }

    public String getString(String charSequence) {
        Bundle bundle = this.mBundle;
        if ((charSequence = bundle.getCharSequence((String)charSequence)) != null) {
            return charSequence.toString();
        }
        return null;
    }

    public CharSequence getText(String string2) {
        return this.mBundle.getCharSequence(string2);
    }

    public Set keySet() {
        return this.mBundle.keySet();
    }

    public int size() {
        return this.mBundle.size();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        Bundle bundle = this.mBundle;
        parcel.writeBundle(bundle);
    }
}

