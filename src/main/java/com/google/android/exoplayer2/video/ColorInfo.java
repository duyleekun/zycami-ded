/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.exoplayer2.video;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.ColorInfo$1;
import java.util.Arrays;

public final class ColorInfo
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public final int colorRange;
    public final int colorSpace;
    public final int colorTransfer;
    private int hashCode;
    public final byte[] hdrStaticInfo;

    static {
        ColorInfo$1 colorInfo$1 = new ColorInfo$1();
        CREATOR = colorInfo$1;
    }

    public ColorInfo(int n10, int n11, int n12, byte[] byArray) {
        this.colorSpace = n10;
        this.colorRange = n11;
        this.colorTransfer = n12;
        this.hdrStaticInfo = byArray;
    }

    public ColorInfo(Parcel object) {
        int n10;
        this.colorSpace = n10 = object.readInt();
        this.colorRange = n10 = object.readInt();
        this.colorTransfer = n10 = object.readInt();
        n10 = (int)(Util.readBoolean(object) ? 1 : 0);
        object = n10 != 0 ? (Object)object.createByteArray() : null;
        this.hdrStaticInfo = (byte[])object;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Object object2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object2 = ColorInfo.class) == (clazz = object.getClass())) {
            boolean bl3;
            object = (ColorInfo)object;
            int n10 = this.colorSpace;
            int n11 = ((ColorInfo)object).colorSpace;
            if (n10 != n11 || (n10 = this.colorRange) != (n11 = ((ColorInfo)object).colorRange) || (n10 = this.colorTransfer) != (n11 = ((ColorInfo)object).colorTransfer) || !(bl3 = Arrays.equals((byte[])(object2 = (Object)this.hdrStaticInfo), (byte[])(object = (Object)((ColorInfo)object).hdrStaticInfo)))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10 = this.hashCode;
        if (n10 == 0) {
            int n11 = this.colorSpace;
            n10 = (527 + n11) * 31;
            n11 = this.colorRange;
            n10 = (n10 + n11) * 31;
            n11 = this.colorTransfer;
            n10 = (n10 + n11) * 31;
            byte[] byArray = this.hdrStaticInfo;
            n11 = Arrays.hashCode(byArray);
            this.hashCode = n10 += n11;
        }
        return this.hashCode;
    }

    public String toString() {
        boolean bl2;
        int n10 = this.colorSpace;
        int n11 = this.colorRange;
        int n12 = this.colorTransfer;
        byte[] byArray = this.hdrStaticInfo;
        if (byArray != null) {
            bl2 = true;
        } else {
            bl2 = false;
            byArray = null;
        }
        StringBuilder stringBuilder = new StringBuilder(55);
        stringBuilder.append("ColorInfo(");
        stringBuilder.append(n10);
        String string2 = ", ";
        stringBuilder.append(string2);
        stringBuilder.append(n11);
        stringBuilder.append(string2);
        stringBuilder.append(n12);
        stringBuilder.append(string2);
        stringBuilder.append(bl2);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = this.colorSpace;
        parcel.writeInt(n10);
        n10 = this.colorRange;
        parcel.writeInt(n10);
        n10 = this.colorTransfer;
        parcel.writeInt(n10);
        byte[] byArray = this.hdrStaticInfo;
        if (byArray != null) {
            n10 = 1;
        } else {
            n10 = 0;
            byArray = null;
        }
        Util.writeBoolean(parcel, n10 != 0);
        byArray = this.hdrStaticInfo;
        if (byArray != null) {
            parcel.writeByteArray(byArray);
        }
    }
}

