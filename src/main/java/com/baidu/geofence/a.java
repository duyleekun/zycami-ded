/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.baidu.geofence;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.geofence.GeoFence;

public final class a
implements Parcelable.Creator {
    public GeoFence a(Parcel parcel) {
        GeoFence geoFence = new GeoFence(parcel, null);
        return geoFence;
    }

    public GeoFence[] a(int n10) {
        return new GeoFence[n10];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n10) {
        return this.a(n10);
    }
}

