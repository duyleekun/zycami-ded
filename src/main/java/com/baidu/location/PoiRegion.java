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
import com.baidu.location.e;

public final class PoiRegion
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    private final String mDirectionDesc;
    private final String mName;
    private final String mTag;

    static {
        e e10 = new e();
        CREATOR = e10;
    }

    public PoiRegion(PoiRegion object) {
        String string2;
        this.mName = string2 = ((PoiRegion)object).getName();
        this.mDirectionDesc = string2 = ((PoiRegion)object).getDerectionDesc();
        this.mTag = object = ((PoiRegion)object).getTags();
    }

    public PoiRegion(String string2, String string3, String string4) {
        this.mName = string3;
        this.mDirectionDesc = string2;
        this.mTag = string4;
    }

    public int describeContents() {
        return 0;
    }

    public String getDerectionDesc() {
        return this.mDirectionDesc;
    }

    public String getName() {
        return this.mName;
    }

    public String getTags() {
        return this.mTag;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        String string2 = this.mName;
        parcel.writeString(string2);
        string2 = this.mDirectionDesc;
        parcel.writeString(string2);
        string2 = this.mTag;
        parcel.writeString(string2);
    }
}

