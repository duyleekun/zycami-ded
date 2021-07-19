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
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$Parameters;

public class DefaultTrackSelector$Parameters$1
implements Parcelable.Creator {
    public DefaultTrackSelector$Parameters createFromParcel(Parcel parcel) {
        DefaultTrackSelector$Parameters defaultTrackSelector$Parameters = new DefaultTrackSelector$Parameters(parcel);
        return defaultTrackSelector$Parameters;
    }

    public DefaultTrackSelector$Parameters[] newArray(int n10) {
        return new DefaultTrackSelector$Parameters[n10];
    }
}

