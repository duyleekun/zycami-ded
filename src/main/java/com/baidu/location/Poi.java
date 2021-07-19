/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.baidu.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.location.d;

public final class Poi
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    private final String mAddr;
    private final String mId;
    private final String mName;
    private final double mRank;
    private final String mTags;

    static {
        d d10 = new d();
        CREATOR = d10;
    }

    public Poi(String string2, String string3, double d10, String string4, String string5) {
        this.mId = string2;
        this.mName = string3;
        this.mRank = d10;
        this.mTags = string4;
        this.mAddr = string5;
    }

    public int describeContents() {
        return 0;
    }

    public String getAddr() {
        return this.mAddr;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public double getRank() {
        return this.mRank;
    }

    public String getTags() {
        return this.mTags;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        String string2 = this.mId;
        parcel.writeString(string2);
        string2 = this.mName;
        parcel.writeString(string2);
        double d10 = this.mRank;
        parcel.writeDouble(d10);
        string2 = this.mTags;
        parcel.writeString(string2);
        string2 = this.mAddr;
        parcel.writeString(string2);
    }
}

