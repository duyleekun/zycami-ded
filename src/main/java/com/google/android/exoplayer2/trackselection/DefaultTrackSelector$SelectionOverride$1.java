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
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$SelectionOverride;

public class DefaultTrackSelector$SelectionOverride$1
implements Parcelable.Creator {
    public DefaultTrackSelector$SelectionOverride createFromParcel(Parcel parcel) {
        DefaultTrackSelector$SelectionOverride defaultTrackSelector$SelectionOverride = new DefaultTrackSelector$SelectionOverride(parcel);
        return defaultTrackSelector$SelectionOverride;
    }

    public DefaultTrackSelector$SelectionOverride[] newArray(int n10) {
        return new DefaultTrackSelector$SelectionOverride[n10];
    }
}

