/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.exoplayer2.source;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.source.TrackGroup;

public class TrackGroup$1
implements Parcelable.Creator {
    public TrackGroup createFromParcel(Parcel parcel) {
        TrackGroup trackGroup = new TrackGroup(parcel);
        return trackGroup;
    }

    public TrackGroup[] newArray(int n10) {
        return new TrackGroup[n10];
    }
}

