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
import com.baidu.geofence.PoiItem;

public final class e
implements Parcelable.Creator {
    public PoiItem a(Parcel parcel) {
        PoiItem poiItem = new PoiItem(parcel, null);
        return poiItem;
    }

    public PoiItem[] a(int n10) {
        return new PoiItem[0];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n10) {
        return this.a(n10);
    }
}

