/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.PrivFrame$1;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class PrivFrame
extends Id3Frame {
    public static final Parcelable.Creator CREATOR;
    public static final String ID = "PRIV";
    public final String owner;
    public final byte[] privateData;

    static {
        PrivFrame$1 privFrame$1 = new PrivFrame$1();
        CREATOR = privFrame$1;
    }

    public PrivFrame(Parcel object) {
        super(ID);
        String string2;
        this.owner = string2 = (String)Util.castNonNull(object.readString());
        object = (byte[])Util.castNonNull(object.createByteArray());
        this.privateData = (byte[])object;
    }

    public PrivFrame(String string2, byte[] byArray) {
        super(ID);
        this.owner = string2;
        this.privateData = byArray;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = PrivFrame.class) == (object2 = object.getClass())) {
            boolean bl3;
            object = (PrivFrame)object;
            object3 = this.owner;
            object2 = ((PrivFrame)object).owner;
            boolean bl4 = Util.areEqual(object3, object2);
            if (!bl4 || !(bl3 = Arrays.equals((byte[])(object3 = (Object)this.privateData), (byte[])(object = (Object)((PrivFrame)object).privateData)))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10;
        String string2 = this.owner;
        if (string2 != null) {
            n10 = string2.hashCode();
        } else {
            n10 = 0;
            string2 = null;
        }
        int n11 = (527 + n10) * 31;
        n10 = Arrays.hashCode(this.privateData);
        return n11 + n10;
    }

    public String toString() {
        String string2 = this.id;
        String string3 = this.owner;
        int n10 = String.valueOf(string2).length() + 8;
        int n11 = String.valueOf(string3).length();
        StringBuilder stringBuilder = new StringBuilder(n10 += n11);
        stringBuilder.append(string2);
        stringBuilder.append(": owner=");
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        Object object = this.owner;
        parcel.writeString((String)object);
        object = this.privateData;
        parcel.writeByteArray((byte[])object);
    }
}

