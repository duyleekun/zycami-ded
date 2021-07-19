/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.exoplayer2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;

public class Format$1
implements Parcelable.Creator {
    public Format createFromParcel(Parcel parcel) {
        Format format = new Format(parcel);
        return format;
    }

    public Format[] newArray(int n10) {
        return new Format[n10];
    }
}

