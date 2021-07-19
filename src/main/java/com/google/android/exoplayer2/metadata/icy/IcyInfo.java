/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.exoplayer2.metadata.icy;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.Metadata$Entry;
import com.google.android.exoplayer2.metadata.icy.IcyInfo$1;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;

public final class IcyInfo
implements Metadata$Entry {
    public static final Parcelable.Creator CREATOR;
    public final byte[] rawMetadata;
    public final String title;
    public final String url;

    static {
        IcyInfo$1 icyInfo$1 = new IcyInfo$1();
        CREATOR = icyInfo$1;
    }

    public IcyInfo(Parcel object) {
        Object object2 = (byte[])Assertions.checkNotNull(object.createByteArray());
        this.rawMetadata = object2;
        object2 = object.readString();
        this.title = object2;
        object = object.readString();
        this.url = object;
    }

    public IcyInfo(byte[] byArray, String string2, String string3) {
        this.rawMetadata = byArray;
        this.title = string2;
        this.url = string3;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Object object2;
        if (this == object) {
            return true;
        }
        if (object != null && (object2 = IcyInfo.class) == (clazz = object.getClass())) {
            object = (IcyInfo)object;
            object2 = this.rawMetadata;
            object = ((IcyInfo)object).rawMetadata;
            return Arrays.equals((byte[])object2, (byte[])object);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.rawMetadata);
    }

    public String toString() {
        Object object = this.title;
        object = this.url;
        object = this.rawMetadata.length;
        Object[] objectArray = new Object[]{object, object, object};
        return String.format("ICY: title=\"%s\", url=\"%s\", rawMetadata.length=\"%s\"", objectArray);
    }

    public void writeToParcel(Parcel parcel, int n10) {
        Object object = this.rawMetadata;
        parcel.writeByteArray(object);
        object = this.title;
        parcel.writeString((String)object);
        object = this.url;
        parcel.writeString((String)object);
    }
}

