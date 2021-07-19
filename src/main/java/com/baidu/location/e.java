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
import com.baidu.location.PoiRegion;

public final class e
implements Parcelable.Creator {
    public PoiRegion createFromParcel(Parcel object) {
        String string2 = object.readString();
        String string3 = object.readString();
        object = object.readString();
        PoiRegion poiRegion = new PoiRegion(string3, string2, (String)object);
        return poiRegion;
    }

    public PoiRegion[] newArray(int n10) {
        return new PoiRegion[n10];
    }
}

