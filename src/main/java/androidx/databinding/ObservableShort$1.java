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
import androidx.databinding.ObservableShort;

public final class ObservableShort$1
implements Parcelable.Creator {
    public ObservableShort createFromParcel(Parcel parcel) {
        short s10 = (short)parcel.readInt();
        ObservableShort observableShort = new ObservableShort(s10);
        return observableShort;
    }

    public ObservableShort[] newArray(int n10) {
        return new ObservableShort[n10];
    }
}

