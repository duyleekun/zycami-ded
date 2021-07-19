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
import com.baidu.location.Poi;

public final class d
implements Parcelable.Creator {
    public Poi createFromParcel(Parcel object) {
        String string2 = object.readString();
        String string3 = object.readString();
        double d10 = object.readDouble();
        String string4 = object.readString();
        String string5 = object.readString();
        object = new Poi(string2, string3, d10, string4, string5);
        return object;
    }

    public Poi[] newArray(int n10) {
        return new Poi[n10];
    }
}

