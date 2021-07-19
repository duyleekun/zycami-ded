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
import com.baidu.geofence.model.a;

public class DPoint
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    private double a;
    private double b;

    static {
        a a10 = new a();
        CREATOR = a10;
    }

    public DPoint(double d10, double d11) {
        this.a = d10;
        this.b = d11;
    }

    private DPoint(Parcel parcel) {
        double d10;
        this.a = d10 = parcel.readDouble();
        this.b = d10 = parcel.readDouble();
    }

    public /* synthetic */ DPoint(Parcel parcel, a a10) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public double getLatitude() {
        return this.a;
    }

    public double getLongitude() {
        return this.b;
    }

    public void setLatitude(double d10) {
        this.a = d10;
    }

    public void setLongitude(double d10) {
        this.b = d10;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        double d10 = this.a;
        parcel.writeDouble(d10);
        d10 = this.b;
        parcel.writeDouble(d10);
    }
}

