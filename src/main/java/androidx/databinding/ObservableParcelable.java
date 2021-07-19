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
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableParcelable$1;
import java.io.Serializable;

public class ObservableParcelable
extends ObservableField
implements Parcelable,
Serializable {
    public static final Parcelable.Creator CREATOR;
    public static final long serialVersionUID = 1L;

    static {
        ObservableParcelable$1 observableParcelable$1 = new ObservableParcelable$1();
        CREATOR = observableParcelable$1;
    }

    public ObservableParcelable() {
    }

    public ObservableParcelable(Parcelable parcelable) {
        super(parcelable);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        Parcelable parcelable = (Parcelable)this.get();
        parcel.writeParcelable(parcelable, 0);
    }
}

