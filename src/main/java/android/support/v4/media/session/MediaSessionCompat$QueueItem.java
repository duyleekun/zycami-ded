/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaDescription
 *  android.media.session.MediaSession$QueueItem
 *  android.os.Build$VERSION
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package android.support.v4.media.session;

import android.media.MediaDescription;
import android.media.session.MediaSession;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.session.MediaSessionCompat$QueueItem$1;
import java.util.ArrayList;
import java.util.List;

public final class MediaSessionCompat$QueueItem
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public static final int UNKNOWN_ID = 255;
    private final MediaDescriptionCompat mDescription;
    private final long mId;
    private MediaSession.QueueItem mItemFwk;

    static {
        MediaSessionCompat$QueueItem$1 mediaSessionCompat$QueueItem$1 = new MediaSessionCompat$QueueItem$1();
        CREATOR = mediaSessionCompat$QueueItem$1;
    }

    private MediaSessionCompat$QueueItem(MediaSession.QueueItem object, MediaDescriptionCompat mediaDescriptionCompat, long l10) {
        if (mediaDescriptionCompat != null) {
            long l11 = -1;
            long l12 = l10 - l11;
            long l13 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (l13 != false) {
                this.mDescription = mediaDescriptionCompat;
                this.mId = l10;
                this.mItemFwk = object;
                return;
            }
            super("Id cannot be QueueItem.UNKNOWN_ID");
            throw object;
        }
        super("Description cannot be null");
        throw object;
    }

    public MediaSessionCompat$QueueItem(Parcel parcel) {
        long l10;
        MediaDescriptionCompat mediaDescriptionCompat;
        this.mDescription = mediaDescriptionCompat = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        this.mId = l10 = parcel.readLong();
    }

    public MediaSessionCompat$QueueItem(MediaDescriptionCompat mediaDescriptionCompat, long l10) {
        this(null, mediaDescriptionCompat, l10);
    }

    public static MediaSessionCompat$QueueItem fromQueueItem(Object object) {
        int n10;
        int n11;
        if (object != null && (n11 = Build.VERSION.SDK_INT) >= (n10 = 21)) {
            object = (MediaSession.QueueItem)object;
            MediaDescriptionCompat mediaDescriptionCompat = MediaDescriptionCompat.fromMediaDescription(object.getDescription());
            long l10 = object.getQueueId();
            MediaSessionCompat$QueueItem mediaSessionCompat$QueueItem = new MediaSessionCompat$QueueItem((MediaSession.QueueItem)object, mediaDescriptionCompat, l10);
            return mediaSessionCompat$QueueItem;
        }
        return null;
    }

    public static List fromQueueItemList(List object) {
        int n10;
        int n11;
        if (object != null && (n11 = Build.VERSION.SDK_INT) >= (n10 = 21)) {
            ArrayList<MediaSessionCompat$QueueItem> arrayList = new ArrayList<MediaSessionCompat$QueueItem>();
            object = object.iterator();
            while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                MediaSessionCompat$QueueItem mediaSessionCompat$QueueItem = MediaSessionCompat$QueueItem.fromQueueItem(object.next());
                arrayList.add(mediaSessionCompat$QueueItem);
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

    public long getQueueId() {
        return this.mId;
    }

    public Object getQueueItem() {
        int n10;
        int n11;
        MediaSession.QueueItem queueItem = this.mItemFwk;
        if (queueItem == null && (n11 = Build.VERSION.SDK_INT) >= (n10 = 21)) {
            MediaDescription mediaDescription = (MediaDescription)this.mDescription.getMediaDescription();
            long l10 = this.mId;
            this.mItemFwk = queueItem = new MediaSession.QueueItem(mediaDescription, l10);
        }
        return queueItem;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MediaSession.QueueItem {Description=");
        MediaDescriptionCompat mediaDescriptionCompat = this.mDescription;
        stringBuilder.append(mediaDescriptionCompat);
        stringBuilder.append(", Id=");
        long l10 = this.mId;
        stringBuilder.append(l10);
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        this.mDescription.writeToParcel(parcel, n10);
        long l10 = this.mId;
        parcel.writeLong(l10);
    }
}

