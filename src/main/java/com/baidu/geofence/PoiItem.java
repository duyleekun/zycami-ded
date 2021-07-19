/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.baidu.geofence;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.geofence.e;

public class PoiItem
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    private double a;
    private double b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;

    static {
        e e10 = new e();
        CREATOR = e10;
    }

    public PoiItem() {
    }

    private PoiItem(Parcel parcel) {
        double d10;
        String string2;
        this.c = string2 = parcel.readString();
        this.k = string2 = parcel.readString();
        this.d = string2 = parcel.readString();
        this.e = string2 = parcel.readString();
        this.i = string2 = parcel.readString();
        this.f = string2 = parcel.readString();
        this.j = string2 = parcel.readString();
        this.g = string2 = parcel.readString();
        this.h = string2 = parcel.readString();
        this.a = d10 = parcel.readDouble();
        this.b = d10 = parcel.readDouble();
    }

    public /* synthetic */ PoiItem(Parcel parcel, e e10) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public String getAdName() {
        return this.j;
    }

    public String getAddress() {
        return this.f;
    }

    public String getCity() {
        return this.i;
    }

    public double getLatitude() {
        return this.a;
    }

    public double getLongitude() {
        return this.b;
    }

    public String getPoiId() {
        return this.c;
    }

    public String getPoiName() {
        return this.k;
    }

    public String getPoiType() {
        return this.d;
    }

    public String getPoiTypeCode() {
        return this.e;
    }

    public String getProvince() {
        return this.h;
    }

    public String getTel() {
        return this.g;
    }

    public void setAdName(String string2) {
        this.j = string2;
    }

    public void setAddress(String string2) {
        this.f = string2;
    }

    public void setCity(String string2) {
        this.i = string2;
    }

    public void setLatitude(double d10) {
        this.a = d10;
    }

    public void setLongitude(double d10) {
        this.b = d10;
    }

    public void setPoiId(String string2) {
        this.c = string2;
    }

    public void setPoiName(String string2) {
        this.k = string2;
    }

    public void setPoiType(String string2) {
        this.d = string2;
    }

    public void setPoiTypeCode(String string2) {
        this.e = string2;
    }

    public void setProvince(String string2) {
        this.h = string2;
    }

    public void setTel(String string2) {
        this.g = string2;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        String string2 = this.c;
        parcel.writeString(string2);
        string2 = this.k;
        parcel.writeString(string2);
        string2 = this.d;
        parcel.writeString(string2);
        string2 = this.e;
        parcel.writeString(string2);
        string2 = this.i;
        parcel.writeString(string2);
        string2 = this.f;
        parcel.writeString(string2);
        string2 = this.j;
        parcel.writeString(string2);
        string2 = this.g;
        parcel.writeString(string2);
        string2 = this.h;
        parcel.writeString(string2);
        double d10 = this.a;
        parcel.writeDouble(d10);
        d10 = this.b;
        parcel.writeDouble(d10);
    }
}

