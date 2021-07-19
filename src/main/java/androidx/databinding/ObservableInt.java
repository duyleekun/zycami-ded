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
import androidx.databinding.BaseObservableField;
import androidx.databinding.Observable;
import androidx.databinding.ObservableInt$1;
import java.io.Serializable;

public class ObservableInt
extends BaseObservableField
implements Parcelable,
Serializable {
    public static final Parcelable.Creator CREATOR;
    public static final long serialVersionUID = 1L;
    private int mValue;

    static {
        ObservableInt$1 observableInt$1 = new ObservableInt$1();
        CREATOR = observableInt$1;
    }

    public ObservableInt() {
    }

    public ObservableInt(int n10) {
        this.mValue = n10;
    }

    public ObservableInt(Observable ... observableArray) {
        super(observableArray);
    }

    public int describeContents() {
        return 0;
    }

    public int get() {
        return this.mValue;
    }

    public void set(int n10) {
        int n11 = this.mValue;
        if (n10 != n11) {
            this.mValue = n10;
            this.notifyChange();
        }
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = this.mValue;
        parcel.writeInt(n10);
    }
}

