/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.exoplayer2.metadata.icy;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.icy.IcyInfo;

public class IcyInfo$1
implements Parcelable.Creator {
    public IcyInfo createFromParcel(Parcel parcel) {
        IcyInfo icyInfo = new IcyInfo(parcel);
        return icyInfo;
    }

    public IcyInfo[] newArray(int n10) {
        return new IcyInfo[n10];
    }
}

