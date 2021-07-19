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
import com.google.android.exoplayer2.drm.DrmInitData;

public class DrmInitData$1
implements Parcelable.Creator {
    public DrmInitData createFromParcel(Parcel parcel) {
        DrmInitData drmInitData = new DrmInitData(parcel);
        return drmInitData;
    }

    public DrmInitData[] newArray(int n10) {
        return new DrmInitData[n10];
    }
}

