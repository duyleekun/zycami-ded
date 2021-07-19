/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.databinding.ObservableParcelable;

public final class ObservableParcelable$1
implements Parcelable.Creator {
    public ObservableParcelable createFromParcel(Parcel parcel) {
        ClassLoader classLoader = ObservableParcelable$1.class.getClassLoader();
        parcel = parcel.readParcelable(classLoader);
        ObservableParcelable observableParcelable = new ObservableParcelable((Parcelable)parcel);
        return observableParcelable;
    }

    public ObservableParcelable[] newArray(int n10) {
        return new ObservableParcelable[n10];
    }
}

