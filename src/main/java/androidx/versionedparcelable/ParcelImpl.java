/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.versionedparcelable.ParcelImpl$1;
import androidx.versionedparcelable.VersionedParcelParcel;
import androidx.versionedparcelable.VersionedParcelable;

public class ParcelImpl
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    private final VersionedParcelable mParcel;

    static {
        ParcelImpl$1 parcelImpl$1 = new ParcelImpl$1();
        CREATOR = parcelImpl$1;
    }

    public ParcelImpl(Parcel object) {
        VersionedParcelParcel versionedParcelParcel = new VersionedParcelParcel((Parcel)object);
        object = versionedParcelParcel.readVersionedParcelable();
        this.mParcel = object;
    }

    public ParcelImpl(VersionedParcelable versionedParcelable) {
        this.mParcel = versionedParcelable;
    }

    public int describeContents() {
        return 0;
    }

    public VersionedParcelable getVersionedParcel() {
        return this.mParcel;
    }

    public void writeToParcel(Parcel object, int n10) {
        VersionedParcelParcel versionedParcelParcel = new VersionedParcelParcel((Parcel)object);
        object = this.mParcel;
        versionedParcelParcel.writeVersionedParcelable((VersionedParcelable)object);
    }
}

