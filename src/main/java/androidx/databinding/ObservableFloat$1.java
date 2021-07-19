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
import androidx.databinding.ObservableFloat;

public final class ObservableFloat$1
implements Parcelable.Creator {
    public ObservableFloat createFromParcel(Parcel parcel) {
        float f10 = parcel.readFloat();
        ObservableFloat observableFloat = new ObservableFloat(f10);
        return observableFloat;
    }

    public ObservableFloat[] newArray(int n10) {
        return new ObservableFloat[n10];
    }
}

