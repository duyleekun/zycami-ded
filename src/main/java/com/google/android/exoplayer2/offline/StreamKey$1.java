/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.exoplayer2.offline;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.offline.StreamKey;

public class StreamKey$1
implements Parcelable.Creator {
    public StreamKey createFromParcel(Parcel parcel) {
        StreamKey streamKey = new StreamKey(parcel);
        return streamKey;
    }

    public StreamKey[] newArray(int n10) {
        return new StreamKey[n10];
    }
}

