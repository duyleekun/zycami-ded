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
import androidx.databinding.ObservableByte;

public final class ObservableByte$1
implements Parcelable.Creator {
    public ObservableByte createFromParcel(Parcel parcel) {
        byte by2 = parcel.readByte();
        ObservableByte observableByte = new ObservableByte(by2);
        return observableByte;
    }

    public ObservableByte[] newArray(int n10) {
        return new ObservableByte[n10];
    }
}

