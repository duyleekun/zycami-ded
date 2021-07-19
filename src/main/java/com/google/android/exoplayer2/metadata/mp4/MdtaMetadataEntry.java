/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.Metadata$Entry;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry$1;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class MdtaMetadataEntry
implements Metadata$Entry {
    public static final Parcelable.Creator CREATOR;
    public static final String KEY_ANDROID_CAPTURE_FPS = "com.android.capture.fps";
    public final String key;
    public final int localeIndicator;
    public final int typeIndicator;
    public final byte[] value;

    static {
        MdtaMetadataEntry$1 mdtaMetadataEntry$1 = new MdtaMetadataEntry$1();
        CREATOR = mdtaMetadataEntry$1;
    }

    private MdtaMetadataEntry(Parcel parcel) {
        int n10;
        int n11;
        Object object = (String)Util.castNonNull(parcel.readString());
        this.key = object;
        object = (byte[])Util.castNonNull(parcel.createByteArray());
        this.value = (byte[])object;
        this.localeIndicator = n11 = parcel.readInt();
        this.typeIndicator = n10 = parcel.readInt();
    }

    public /* synthetic */ MdtaMetadataEntry(Parcel parcel, MdtaMetadataEntry$1 mdtaMetadataEntry$1) {
        this(parcel);
    }

    public MdtaMetadataEntry(String string2, byte[] byArray, int n10, int n11) {
        this.key = string2;
        this.value = byArray;
        this.localeIndicator = n10;
        this.typeIndicator = n11;
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
        if (object != null && (object3 = MdtaMetadataEntry.class) == (object2 = object.getClass())) {
            int n10;
            int n11;
            int n12;
            int n13;
            boolean bl3;
            object = (MdtaMetadataEntry)object;
            object3 = this.key;
            object2 = ((MdtaMetadataEntry)object).key;
            boolean n122 = ((String)object3).equals(object2);
            if (!n122 || !(bl3 = Arrays.equals((byte[])(object3 = (Object)this.value), (byte[])(object2 = (Object)((MdtaMetadataEntry)object).value))) || (n13 = this.localeIndicator) != (n12 = ((MdtaMetadataEntry)object).localeIndicator) || (n11 = this.typeIndicator) != (n10 = ((MdtaMetadataEntry)object).typeIndicator)) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10 = this.key.hashCode();
        int n11 = (527 + n10) * 31;
        n10 = Arrays.hashCode(this.value);
        n11 = (n11 + n10) * 31;
        n10 = this.localeIndicator;
        n11 = (n11 + n10) * 31;
        n10 = this.typeIndicator;
        return n11 + n10;
    }

    public String toString() {
        String string2 = String.valueOf(this.key);
        int n10 = string2.length();
        String string3 = "mdta: key=";
        string2 = n10 != 0 ? string3.concat(string2) : new String(string3);
        return string2;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        Object object = this.key;
        parcel.writeString((String)object);
        object = this.value;
        parcel.writeByteArray((byte[])object);
        n10 = this.localeIndicator;
        parcel.writeInt(n10);
        n10 = this.typeIndicator;
        parcel.writeInt(n10);
    }
}

