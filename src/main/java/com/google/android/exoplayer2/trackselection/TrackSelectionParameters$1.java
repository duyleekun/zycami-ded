/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.exoplayer2.trackselection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;

public class TrackSelectionParameters$1
implements Parcelable.Creator {
    public TrackSelectionParameters createFromParcel(Parcel parcel) {
        TrackSelectionParameters trackSelectionParameters = new TrackSelectionParameters(parcel);
        return trackSelectionParameters;
    }

    public TrackSelectionParameters[] newArray(int n10) {
        return new TrackSelectionParameters[n10];
    }
}

