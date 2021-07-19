/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;

public class MdtaMetadataEntry$1
implements Parcelable.Creator {
    public MdtaMetadataEntry createFromParcel(Parcel parcel) {
        MdtaMetadataEntry mdtaMetadataEntry = new MdtaMetadataEntry(parcel, null);
        return mdtaMetadataEntry;
    }

    public MdtaMetadataEntry[] newArray(int n10) {
        return new MdtaMetadataEntry[n10];
    }
}

