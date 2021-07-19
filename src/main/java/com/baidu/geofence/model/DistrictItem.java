/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.baidu.geofence.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.geofence.model.b;

public class DistrictItem
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    private String a;
    private String b;
    private String c;

    static {
        b b10 = new b();
        CREATOR = b10;
    }

    private DistrictItem(Parcel object) {
        String string2;
        this.a = string2 = object.readString();
        this.b = string2 = object.readString();
        object = object.readString();
        this.c = object;
    }

    public /* synthetic */ DistrictItem(Parcel parcel, b b10) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        String string2 = this.a;
        parcel.writeString(string2);
        string2 = this.b;
        parcel.writeString(string2);
        string2 = this.c;
        parcel.writeString(string2);
    }
}

