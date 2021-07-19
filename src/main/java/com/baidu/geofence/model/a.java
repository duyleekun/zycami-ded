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
import com.baidu.geofence.model.DPoint;

public final class a
implements Parcelable.Creator {
    public DPoint a(Parcel parcel) {
        DPoint dPoint = new DPoint(parcel, null);
        return dPoint;
    }

    public DPoint[] a(int n10) {
        return new DPoint[n10];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n10) {
        return this.a(n10);
    }
}

