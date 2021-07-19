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
import androidx.databinding.ObservableInt;

public final class ObservableInt$1
implements Parcelable.Creator {
    public ObservableInt createFromParcel(Parcel parcel) {
        int n10 = parcel.readInt();
        ObservableInt observableInt = new ObservableInt(n10);
        return observableInt;
    }

    public ObservableInt[] newArray(int n10) {
        return new ObservableInt[n10];
    }
}

