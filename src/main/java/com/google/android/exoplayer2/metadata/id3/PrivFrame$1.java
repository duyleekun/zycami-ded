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
import com.google.android.exoplayer2.metadata.id3.PrivFrame;

public class PrivFrame$1
implements Parcelable.Creator {
    public PrivFrame createFromParcel(Parcel parcel) {
        PrivFrame privFrame = new PrivFrame(parcel);
        return privFrame;
    }

    public PrivFrame[] newArray(int n10) {
        return new PrivFrame[n10];
    }
}

