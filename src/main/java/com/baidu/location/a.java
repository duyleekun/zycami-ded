/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.baidu.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.location.BDLocation;

public final class a
implements Parcelable.Creator {
    public BDLocation createFromParcel(Parcel parcel) {
        BDLocation bDLocation = new BDLocation(parcel, null);
        return bDLocation;
    }

    public BDLocation[] newArray(int n10) {
        return new BDLocation[n10];
    }
}

