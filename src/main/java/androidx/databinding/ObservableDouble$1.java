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
import androidx.databinding.ObservableDouble;

public final class ObservableDouble$1
implements Parcelable.Creator {
    public ObservableDouble createFromParcel(Parcel parcel) {
        double d10 = parcel.readDouble();
        ObservableDouble observableDouble = new ObservableDouble(d10);
        return observableDouble;
    }

    public ObservableDouble[] newArray(int n10) {
        return new ObservableDouble[n10];
    }
}

