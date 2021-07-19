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
import com.google.android.exoplayer2.metadata.id3.ApicFrame;

public class ApicFrame$1
implements Parcelable.Creator {
    public ApicFrame createFromParcel(Parcel parcel) {
        ApicFrame apicFrame = new ApicFrame(parcel);
        return apicFrame;
    }

    public ApicFrame[] newArray(int n10) {
        return new ApicFrame[n10];
    }
}

