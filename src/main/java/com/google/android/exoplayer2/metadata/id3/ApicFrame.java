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
import com.google.android.exoplayer2.metadata.id3.ApicFrame$1;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class ApicFrame
extends Id3Frame {
    public static final Parcelable.Creator CREATOR;
    public static final String ID = "APIC";
    public final String description;
    public final String mimeType;
    public final byte[] pictureData;
    public final int pictureType;

    static {
        ApicFrame$1 apicFrame$1 = new ApicFrame$1();
        CREATOR = apicFrame$1;
    }

    public ApicFrame(Parcel object) {
        super(ID);
        int n10;
        String string2;
        this.mimeType = string2 = (String)Util.castNonNull(object.readString());
        this.description = string2 = object.readString();
        this.pictureType = n10 = object.readInt();
        object = (byte[])Util.castNonNull(object.createByteArray());
        this.pictureData = (byte[])object;
    }

    public ApicFrame(String string2, String string3, int n10, byte[] byArray) {
        super(ID);
        this.mimeType = string2;
        this.description = string3;
        this.pictureType = n10;
        this.pictureData = byArray;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = ApicFrame.class) == (object2 = object.getClass())) {
            boolean bl3;
            object = (ApicFrame)object;
            int n10 = this.pictureType;
            int n11 = ((ApicFrame)object).pictureType;
            if (n10 != n11 || (n10 = (int)(Util.areEqual(object3 = this.mimeType, object2 = ((ApicFrame)object).mimeType) ? 1 : 0)) == 0 || (n10 = (int)(Util.areEqual(object3 = this.description, object2 = ((ApicFrame)object).description) ? 1 : 0)) == 0 || !(bl3 = Arrays.equals((byte[])(object3 = (Object)this.pictureData), (byte[])(object = (Object)((ApicFrame)object).pictureData)))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10 = this.pictureType;
        int n11 = (527 + n10) * 31;
        String string2 = this.mimeType;
        int n12 = 0;
        if (string2 != null) {
            n10 = string2.hashCode();
        } else {
            n10 = 0;
            string2 = null;
        }
        n11 = (n11 + n10) * 31;
        string2 = this.description;
        if (string2 != null) {
            n12 = string2.hashCode();
        }
        n11 = (n11 + n12) * 31;
        n10 = Arrays.hashCode(this.pictureData);
        return n11 + n10;
    }

    public String toString() {
        String string2 = this.id;
        String string3 = this.mimeType;
        String string4 = this.description;
        int n10 = String.valueOf(string2).length() + 25;
        int n11 = String.valueOf(string3).length();
        n10 += n11;
        n11 = String.valueOf(string4).length();
        StringBuilder stringBuilder = new StringBuilder(n10 += n11);
        stringBuilder.append(string2);
        stringBuilder.append(": mimeType=");
        stringBuilder.append(string3);
        stringBuilder.append(", description=");
        stringBuilder.append(string4);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        Object object = this.mimeType;
        parcel.writeString((String)object);
        object = this.description;
        parcel.writeString((String)object);
        n10 = this.pictureType;
        parcel.writeInt(n10);
        object = this.pictureData;
        parcel.writeByteArray((byte[])object);
    }
}

