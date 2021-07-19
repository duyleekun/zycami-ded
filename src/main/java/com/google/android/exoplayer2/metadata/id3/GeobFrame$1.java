/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.id3.GeobFrame;

public class GeobFrame$1
implements Parcelable.Creator {
    public GeobFrame createFromParcel(Parcel parcel) {
        GeobFrame geobFrame = new GeobFrame(parcel);
        return geobFrame;
    }

    public GeobFrame[] newArray(int n10) {
        return new GeobFrame[n10];
    }
}

