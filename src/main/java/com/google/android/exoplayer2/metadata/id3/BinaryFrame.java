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
import com.google.android.exoplayer2.metadata.id3.BinaryFrame$1;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class BinaryFrame
extends Id3Frame {
    public static final Parcelable.Creator CREATOR;
    public final byte[] data;

    static {
        BinaryFrame$1 binaryFrame$1 = new BinaryFrame$1();
        CREATOR = binaryFrame$1;
    }

    public BinaryFrame(Parcel object) {
        String string2 = (String)Util.castNonNull(object.readString());
        super(string2);
        object = (byte[])Util.castNonNull(object.createByteArray());
        this.data = (byte[])object;
    }

    public BinaryFrame(String string2, byte[] byArray) {
        super(string2);
        this.data = byArray;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = BinaryFrame.class) == (object2 = object.getClass())) {
            boolean bl3;
            object = (BinaryFrame)object;
            object3 = this.id;
            object2 = ((Id3Frame)object).id;
            boolean bl4 = ((String)object3).equals(object2);
            if (!bl4 || !(bl3 = Arrays.equals((byte[])(object3 = (Object)this.data), (byte[])(object = (Object)((BinaryFrame)object).data)))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10 = this.id.hashCode();
        int n11 = (527 + n10) * 31;
        n10 = Arrays.hashCode(this.data);
        return n11 + n10;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        Object object = this.id;
        parcel.writeString((String)object);
        object = this.data;
        parcel.writeByteArray((byte[])object);
    }
}

