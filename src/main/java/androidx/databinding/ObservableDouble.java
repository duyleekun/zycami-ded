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
import androidx.databinding.ObservableDouble$1;
import java.io.Serializable;

public class ObservableDouble
extends BaseObservableField
implements Parcelable,
Serializable {
    public static final Parcelable.Creator CREATOR;
    public static final long serialVersionUID = 1L;
    private double mValue;

    static {
        ObservableDouble$1 observableDouble$1 = new ObservableDouble$1();
        CREATOR = observableDouble$1;
    }

    public ObservableDouble() {
    }

    public ObservableDouble(double d10) {
        this.mValue = d10;
    }

    public ObservableDouble(Observable ... observableArray) {
        super(observableArray);
    }

    public int describeContents() {
        return 0;
    }

    public double get() {
        return this.mValue;
    }

    public void set(double d10) {
        double d11 = this.mValue;
        double d12 = d10 - d11;
        Object object = d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1);
        if (object != false) {
            this.mValue = d10;
            this.notifyChange();
        }
    }

    public void writeToParcel(Parcel parcel, int n10) {
        double d10 = this.mValue;
        parcel.writeDouble(d10);
    }
}

