/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaDescription
 *  android.os.Build$VERSION
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package android.support.v4.media;

import android.media.MediaDescription;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompat;

public class MediaDescriptionCompat$1
implements Parcelable.Creator {
    public MediaDescriptionCompat createFromParcel(Parcel parcel) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 < n11) {
            MediaDescriptionCompat mediaDescriptionCompat = new MediaDescriptionCompat(parcel);
            return mediaDescriptionCompat;
        }
        return MediaDescriptionCompat.fromMediaDescription(MediaDescription.CREATOR.createFromParcel(parcel));
    }

    public MediaDescriptionCompat[] newArray(int n10) {
        return new MediaDescriptionCompat[n10];
    }
}

