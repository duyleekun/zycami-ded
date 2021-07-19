/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.os.Parcelable
 */
package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.VersionedParcel;

public class IconCompatParcelizer {
    public static IconCompat read(VersionedParcel object) {
        IconCompat iconCompat = new IconCompat();
        int n10 = iconCompat.mType;
        iconCompat.mType = n10 = ((VersionedParcel)object).readInt(n10, 1);
        Object object2 = iconCompat.mData;
        iconCompat.mData = object2 = ((VersionedParcel)object).readByteArray((byte[])object2, 2);
        object2 = iconCompat.mParcelable;
        object2 = ((VersionedParcel)object).readParcelable((Parcelable)object2, 3);
        iconCompat.mParcelable = (Parcelable)object2;
        n10 = iconCompat.mInt1;
        iconCompat.mInt1 = n10 = ((VersionedParcel)object).readInt(n10, 4);
        n10 = iconCompat.mInt2;
        iconCompat.mInt2 = n10 = ((VersionedParcel)object).readInt(n10, 5);
        object2 = iconCompat.mTintList;
        object2 = (ColorStateList)((VersionedParcel)object).readParcelable((Parcelable)object2, 6);
        iconCompat.mTintList = (ColorStateList)object2;
        object2 = iconCompat.mTintModeStr;
        object2 = ((VersionedParcel)object).readString((String)object2, 7);
        iconCompat.mTintModeStr = object2;
        object2 = iconCompat.mString1;
        iconCompat.mString1 = object = ((VersionedParcel)object).readString((String)object2, 8);
        iconCompat.onPostParceling();
        return iconCompat;
    }

    public static void write(IconCompat object, VersionedParcel versionedParcel) {
        Object object2;
        int n10 = 1;
        versionedParcel.setSerializationFlags(n10 != 0, n10 != 0);
        int n11 = versionedParcel.isStream();
        ((IconCompat)object).onPreParceling(n11 != 0);
        n11 = ((IconCompat)object).mType;
        int n12 = -1;
        if (n12 != n11) {
            versionedParcel.writeInt(n11, n10);
        }
        if ((object2 = ((IconCompat)object).mData) != null) {
            n11 = 2;
            versionedParcel.writeByteArray((byte[])object2, n11);
        }
        if ((object2 = (Object)((IconCompat)object).mParcelable) != null) {
            n11 = 3;
            versionedParcel.writeParcelable((Parcelable)object2, n11);
        }
        if ((n10 = ((IconCompat)object).mInt1) != 0) {
            n11 = 4;
            versionedParcel.writeInt(n10, n11);
        }
        if ((n10 = ((IconCompat)object).mInt2) != 0) {
            n11 = 5;
            versionedParcel.writeInt(n10, n11);
        }
        if ((object2 = (Object)((IconCompat)object).mTintList) != null) {
            n11 = 6;
            versionedParcel.writeParcelable((Parcelable)object2, n11);
        }
        if ((object2 = (Object)((IconCompat)object).mTintModeStr) != null) {
            n11 = 7;
            versionedParcel.writeString((String)object2, n11);
        }
        if ((object = ((IconCompat)object).mString1) != null) {
            n10 = 8;
            versionedParcel.writeString((String)object, n10);
        }
    }
}

