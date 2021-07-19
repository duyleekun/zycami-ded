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
import android.support.v4.media.RatingCompat;

public class RatingCompat$1
implements Parcelable.Creator {
    public RatingCompat createFromParcel(Parcel parcel) {
        int n10 = parcel.readInt();
        float f10 = parcel.readFloat();
        RatingCompat ratingCompat = new RatingCompat(n10, f10);
        return ratingCompat;
    }

    public RatingCompat[] newArray(int n10) {
        return new RatingCompat[n10];
    }
}

