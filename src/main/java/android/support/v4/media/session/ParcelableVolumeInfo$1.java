/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.ParcelableVolumeInfo;

public class ParcelableVolumeInfo$1
implements Parcelable.Creator {
    public ParcelableVolumeInfo createFromParcel(Parcel parcel) {
        ParcelableVolumeInfo parcelableVolumeInfo = new ParcelableVolumeInfo(parcel);
        return parcelableVolumeInfo;
    }

    public ParcelableVolumeInfo[] newArray(int n10) {
        return new ParcelableVolumeInfo[n10];
    }
}

