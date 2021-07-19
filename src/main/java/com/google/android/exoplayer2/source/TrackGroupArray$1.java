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
import com.google.android.exoplayer2.source.TrackGroupArray;

public class TrackGroupArray$1
implements Parcelable.Creator {
    public TrackGroupArray createFromParcel(Parcel parcel) {
        TrackGroupArray trackGroupArray = new TrackGroupArray(parcel);
        return trackGroupArray;
    }

    public TrackGroupArray[] newArray(int n10) {
        return new TrackGroupArray[n10];
    }
}

