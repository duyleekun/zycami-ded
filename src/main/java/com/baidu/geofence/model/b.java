/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.baidu.geofence.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.geofence.model.DistrictItem;

public final class b
implements Parcelable.Creator {
    public DistrictItem a(Parcel parcel) {
        DistrictItem districtItem = new DistrictItem(parcel, null);
        return districtItem;
    }

    public DistrictItem[] a(int n10) {
        return new DistrictItem[0];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n10) {
        return this.a(n10);
    }
}

