/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaMetadataCompat;

public class MediaMetadataCompat$1
implements Parcelable.Creator {
    public MediaMetadataCompat createFromParcel(Parcel parcel) {
        MediaMetadataCompat mediaMetadataCompat = new MediaMetadataCompat(parcel);
        return mediaMetadataCompat;
    }

    public MediaMetadataCompat[] newArray(int n10) {
        return new MediaMetadataCompat[n10];
    }
}

