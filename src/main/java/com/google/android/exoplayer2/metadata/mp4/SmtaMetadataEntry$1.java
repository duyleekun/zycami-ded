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
import com.google.android.exoplayer2.metadata.mp4.SmtaMetadataEntry;

public class SmtaMetadataEntry$1
implements Parcelable.Creator {
    public SmtaMetadataEntry createFromParcel(Parcel parcel) {
        SmtaMetadataEntry smtaMetadataEntry = new SmtaMetadataEntry(parcel, null);
        return smtaMetadataEntry;
    }

    public SmtaMetadataEntry[] newArray(int n10) {
        return new SmtaMetadataEntry[n10];
    }
}

