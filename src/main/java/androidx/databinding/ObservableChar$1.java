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
import androidx.databinding.ObservableChar;

public final class ObservableChar$1
implements Parcelable.Creator {
    public ObservableChar createFromParcel(Parcel parcel) {
        char c10 = (char)parcel.readInt();
        ObservableChar observableChar = new ObservableChar(c10);
        return observableChar;
    }

    public ObservableChar[] newArray(int n10) {
        return new ObservableChar[n10];
    }
}

