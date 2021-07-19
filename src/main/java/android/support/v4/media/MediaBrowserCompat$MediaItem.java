/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.browse.MediaBrowser$MediaItem
 *  android.os.Build$VERSION
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 */
package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaBrowserCompat$MediaItem$1;
import android.support.v4.media.MediaDescriptionCompat;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class MediaBrowserCompat$MediaItem
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public static final int FLAG_BROWSABLE = 1;
    public static final int FLAG_PLAYABLE = 2;
    private final MediaDescriptionCompat mDescription;
    private final int mFlags;

    static {
        MediaBrowserCompat$MediaItem$1 mediaBrowserCompat$MediaItem$1 = new MediaBrowserCompat$MediaItem$1();
        CREATOR = mediaBrowserCompat$MediaItem$1;
    }

    public MediaBrowserCompat$MediaItem(Parcel object) {
        int n10;
        this.mFlags = n10 = object.readInt();
        object = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(object);
        this.mDescription = object;
    }

    public MediaBrowserCompat$MediaItem(MediaDescriptionCompat object, int n10) {
        if (object != null) {
            String string2 = ((MediaDescriptionCompat)object).getMediaId();
            boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
            if (!bl2) {
                this.mFlags = n10;
                this.mDescription = object;
                return;
            }
            object = new IllegalArgumentException("description must have a non-empty media id");
            throw object;
        }
        object = new IllegalArgumentException("description cannot be null");
        throw object;
    }

    public static MediaBrowserCompat$MediaItem fromMediaItem(Object object) {
        int n10;
        int n11;
        if (object != null && (n11 = Build.VERSION.SDK_INT) >= (n10 = 21)) {
            object = (MediaBrowser.MediaItem)object;
            n11 = object.getFlags();
            object = MediaDescriptionCompat.fromMediaDescription(object.getDescription());
            MediaBrowserCompat$MediaItem mediaBrowserCompat$MediaItem = new MediaBrowserCompat$MediaItem((MediaDescriptionCompat)object, n11);
            return mediaBrowserCompat$MediaItem;
        }
        return null;
    }

    public static List fromMediaItemList(List object) {
        int n10;
        int n11;
        if (object != null && (n11 = Build.VERSION.SDK_INT) >= (n10 = 21)) {
            n10 = object.size();
            ArrayList<MediaBrowserCompat$MediaItem> arrayList = new ArrayList<MediaBrowserCompat$MediaItem>(n10);
            object = object.iterator();
            while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                MediaBrowserCompat$MediaItem mediaBrowserCompat$MediaItem = MediaBrowserCompat$MediaItem.fromMediaItem(object.next());
                arrayList.add(mediaBrowserCompat$MediaItem);
            }
            return arrayList;
        }
        return null;
    }

    public int describeContents() {
        return 0;
    }

    public MediaDescriptionCompat getDescription() {
        return this.mDescription;
    }

    public int getFlags() {
        return this.mFlags;
    }

    public String getMediaId() {
        return this.mDescription.getMediaId();
    }

    public boolean isBrowsable() {
        int n10 = this.mFlags;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean isPlayable() {
        int n10 = this.mFlags & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("MediaItem{");
        stringBuilder.append("mFlags=");
        int n10 = this.mFlags;
        stringBuilder.append(n10);
        stringBuilder.append(", mDescription=");
        MediaDescriptionCompat mediaDescriptionCompat = this.mDescription;
        stringBuilder.append(mediaDescriptionCompat);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        int n11 = this.mFlags;
        parcel.writeInt(n11);
        this.mDescription.writeToParcel(parcel, n10);
    }
}

