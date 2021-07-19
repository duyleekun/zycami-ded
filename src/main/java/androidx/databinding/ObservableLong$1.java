/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.databinding.ObservableLong;

public final class ObservableLong$1
implements Parcelable.Creator {
    public ObservableLong createFromParcel(Parcel parcel) {
        long l10 = parcel.readLong();
        ObservableLong observableLong = new ObservableLong(l10);
        return observableLong;
    }

    public ObservableLong[] newArray(int n10) {
        return new ObservableLong[n10];
    }
}

