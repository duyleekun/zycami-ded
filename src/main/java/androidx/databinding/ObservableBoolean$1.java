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
import androidx.databinding.ObservableBoolean;

public final class ObservableBoolean$1
implements Parcelable.Creator {
    public ObservableBoolean createFromParcel(Parcel parcel) {
        int n10;
        int n11 = parcel.readInt();
        if (n11 != (n10 = 1)) {
            n10 = 0;
        }
        ObservableBoolean observableBoolean = new ObservableBoolean(n10 != 0);
        return observableBoolean;
    }

    public ObservableBoolean[] newArray(int n10) {
        return new ObservableBoolean[n10];
    }
}

