/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.drm.DrmInitData$SchemeData;

public class DrmInitData$SchemeData$1
implements Parcelable.Creator {
    public DrmInitData$SchemeData createFromParcel(Parcel parcel) {
        DrmInitData$SchemeData drmInitData$SchemeData = new DrmInitData$SchemeData(parcel);
        return drmInitData$SchemeData;
    }

    public DrmInitData$SchemeData[] newArray(int n10) {
        return new DrmInitData$SchemeData[n10];
    }
}

