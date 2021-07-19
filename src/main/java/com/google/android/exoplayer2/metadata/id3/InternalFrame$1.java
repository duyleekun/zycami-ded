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
import com.google.android.exoplayer2.metadata.id3.InternalFrame;

public class InternalFrame$1
implements Parcelable.Creator {
    public InternalFrame createFromParcel(Parcel parcel) {
        InternalFrame internalFrame = new InternalFrame(parcel);
        return internalFrame;
    }

    public InternalFrame[] newArray(int n10) {
        return new InternalFrame[n10];
    }
}

