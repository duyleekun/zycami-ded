/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.exoplayer2.metadata.flac;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.Metadata$Entry;
import com.google.android.exoplayer2.metadata.flac.PictureFrame$1;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class PictureFrame
implements Metadata$Entry {
    public static final Parcelable.Creator CREATOR;
    public final int colors;
    public final int depth;
    public final String description;
    public final int height;
    public final String mimeType;
    public final byte[] pictureData;
    public final int pictureType;
    public final int width;

    static {
        PictureFrame$1 pictureFrame$1 = new PictureFrame$1();
        CREATOR = pictureFrame$1;
    }

    public PictureFrame(int n10, String string2, String string3, int n11, int n12, int n13, int n14, byte[] byArray) {
        this.pictureType = n10;
        this.mimeType = string2;
        this.description = string3;
        this.width = n11;
        this.height = n12;
        this.depth = n13;
        this.colors = n14;
        this.pictureData = byArray;
    }

    public PictureFrame(Parcel object) {
        String string2;
        int n10;
        this.pictureType = n10 = object.readInt();
        this.mimeType = string2 = (String)Util.castNonNull(object.readString());
        this.description = string2 = (String)Util.castNonNull(object.readString());
        this.width = n10 = object.readInt();
        this.height = n10 = object.readInt();
        this.depth = n10 = object.readInt();
        this.colors = n10 = object.readInt();
        object = (byte[])Util.castNonNull(object.createByteArray());
        this.pictureData = (byte[])object;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = PictureFrame.class) == (object2 = object.getClass())) {
            boolean bl3;
            object = (PictureFrame)object;
            int n10 = this.pictureType;
            int n11 = ((PictureFrame)object).pictureType;
            if (n10 != n11 || (n10 = (int)(((String)(object3 = this.mimeType)).equals(object2 = ((PictureFrame)object).mimeType) ? 1 : 0)) == 0 || (n10 = (int)(((String)(object3 = this.description)).equals(object2 = ((PictureFrame)object).description) ? 1 : 0)) == 0 || (n10 = this.width) != (n11 = ((PictureFrame)object).width) || (n10 = this.height) != (n11 = ((PictureFrame)object).height) || (n10 = this.depth) != (n11 = ((PictureFrame)object).depth) || (n10 = this.colors) != (n11 = ((PictureFrame)object).colors) || !(bl3 = Arrays.equals((byte[])(object3 = (Object)this.pictureData), (byte[])(object = (Object)((PictureFrame)object).pictureData)))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10 = this.pictureType;
        int n11 = (527 + n10) * 31;
        n10 = this.mimeType.hashCode();
        n11 = (n11 + n10) * 31;
        n10 = this.description.hashCode();
        n11 = (n11 + n10) * 31;
        n10 = this.width;
        n11 = (n11 + n10) * 31;
        n10 = this.height;
        n11 = (n11 + n10) * 31;
        n10 = this.depth;
        n11 = (n11 + n10) * 31;
        n10 = this.colors;
        n11 = (n11 + n10) * 31;
        n10 = Arrays.hashCode(this.pictureData);
        return n11 + n10;
    }

    public String toString() {
        String string2 = this.mimeType;
        String string3 = this.description;
        int n10 = String.valueOf(string2).length() + 32;
        int n11 = String.valueOf(string3).length();
        StringBuilder stringBuilder = new StringBuilder(n10 += n11);
        stringBuilder.append("Picture: mimeType=");
        stringBuilder.append(string2);
        stringBuilder.append(", description=");
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = this.pictureType;
        parcel.writeInt(n10);
        Object object = this.mimeType;
        parcel.writeString((String)object);
        object = this.description;
        parcel.writeString((String)object);
        n10 = this.width;
        parcel.writeInt(n10);
        n10 = this.height;
        parcel.writeInt(n10);
        n10 = this.depth;
        parcel.writeInt(n10);
        n10 = this.colors;
        parcel.writeInt(n10);
        object = this.pictureData;
        parcel.writeByteArray((byte[])object);
    }
}

