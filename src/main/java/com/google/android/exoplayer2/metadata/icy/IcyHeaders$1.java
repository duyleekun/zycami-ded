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
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;

public class IcyHeaders$1
implements Parcelable.Creator {
    public IcyHeaders createFromParcel(Parcel parcel) {
        IcyHeaders icyHeaders = new IcyHeaders(parcel);
        return icyHeaders;
    }

    public IcyHeaders[] newArray(int n10) {
        return new IcyHeaders[n10];
    }
}

