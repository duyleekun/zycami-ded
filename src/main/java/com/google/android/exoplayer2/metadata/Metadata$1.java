/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.exoplayer2.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.Metadata;

public class Metadata$1
implements Parcelable.Creator {
    public Metadata createFromParcel(Parcel parcel) {
        Metadata metadata = new Metadata(parcel);
        return metadata;
    }

    public Metadata[] newArray(int n10) {
        return new Metadata[n10];
    }
}

