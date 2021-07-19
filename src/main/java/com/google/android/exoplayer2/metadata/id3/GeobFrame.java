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
import com.google.android.exoplayer2.metadata.id3.GeobFrame$1;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class GeobFrame
extends Id3Frame {
    public static final Parcelable.Creator CREATOR;
    public static final String ID = "GEOB";
    public final byte[] data;
    public final String description;
    public final String filename;
    public final String mimeType;

    static {
        GeobFrame$1 geobFrame$1 = new GeobFrame$1();
        CREATOR = geobFrame$1;
    }

    public GeobFrame(Parcel object) {
        super(ID);
        String string2;
        this.mimeType = string2 = (String)Util.castNonNull(object.readString());
        this.filename = string2 = (String)Util.castNonNull(object.readString());
        this.description = string2 = (String)Util.castNonNull(object.readString());
        object = (byte[])Util.castNonNull(object.createByteArray());
        this.data = (byte[])object;
    }

    public GeobFrame(String string2, String string3, String string4, byte[] byArray) {
        super(ID);
        this.mimeType = string2;
        this.filename = string3;
        this.description = string4;
        this.data = byArray;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = GeobFrame.class) == (object2 = object.getClass())) {
            boolean bl3;
            object = (GeobFrame)object;
            object3 = this.mimeType;
            object2 = ((GeobFrame)object).mimeType;
            boolean bl4 = Util.areEqual(object3, object2);
            if (!(bl4 && (bl4 = Util.areEqual(object3 = this.filename, object2 = ((GeobFrame)object).filename)) && (bl4 = Util.areEqual(object3 = this.description, object2 = ((GeobFrame)object).description)) && (bl3 = Arrays.equals((byte[])(object3 = (Object)this.data), (byte[])(object = (Object)((GeobFrame)object).data))))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10;
        String string2 = this.mimeType;
        int n11 = 0;
        if (string2 != null) {
            n10 = string2.hashCode();
        } else {
            n10 = 0;
            string2 = null;
        }
        int n12 = (527 + n10) * 31;
        string2 = this.filename;
        if (string2 != null) {
            n10 = string2.hashCode();
        } else {
            n10 = 0;
            string2 = null;
        }
        n12 = (n12 + n10) * 31;
        string2 = this.description;
        if (string2 != null) {
            n11 = string2.hashCode();
        }
        n12 = (n12 + n11) * 31;
        n10 = Arrays.hashCode(this.data);
        return n12 + n10;
    }

    public String toString() {
        String string2 = this.id;
        String string3 = this.mimeType;
        String string4 = this.filename;
        String string5 = this.description;
        int n10 = String.valueOf(string2).length() + 36;
        int n11 = String.valueOf(string3).length();
        n10 += n11;
        n11 = String.valueOf(string4).length();
        n10 += n11;
        n11 = String.valueOf(string5).length();
        StringBuilder stringBuilder = new StringBuilder(n10 += n11);
        stringBuilder.append(string2);
        stringBuilder.append(": mimeType=");
        stringBuilder.append(string3);
        stringBuilder.append(", filename=");
        stringBuilder.append(string4);
        stringBuilder.append(", description=");
        stringBuilder.append(string5);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        Object object = this.mimeType;
        parcel.writeString((String)object);
        object = this.filename;
        parcel.writeString((String)object);
        object = this.description;
        parcel.writeString((String)object);
        object = this.data;
        parcel.writeByteArray((byte[])object);
    }
}

