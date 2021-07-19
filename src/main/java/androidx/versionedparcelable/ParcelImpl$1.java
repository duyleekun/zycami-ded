/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.versionedparcelable.ParcelImpl;

public final class ParcelImpl$1
implements Parcelable.Creator {
    public ParcelImpl createFromParcel(Parcel parcel) {
        ParcelImpl parcelImpl = new ParcelImpl(parcel);
        return parcelImpl;
    }

    public ParcelImpl[] newArray(int n10) {
        return new ParcelImpl[n10];
    }
}

