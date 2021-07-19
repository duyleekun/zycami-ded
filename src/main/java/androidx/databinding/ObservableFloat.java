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
import androidx.databinding.ObservableFloat$1;
import java.io.Serializable;

public class ObservableFloat
extends BaseObservableField
implements Parcelable,
Serializable {
    public static final Parcelable.Creator CREATOR;
    public static final long serialVersionUID = 1L;
    private float mValue;

    static {
        ObservableFloat$1 observableFloat$1 = new ObservableFloat$1();
        CREATOR = observableFloat$1;
    }

    public ObservableFloat() {
    }

    public ObservableFloat(float f10) {
        this.mValue = f10;
    }

    public ObservableFloat(Observable ... observableArray) {
        super(observableArray);
    }

    public int describeContents() {
        return 0;
    }

    public float get() {
        return this.mValue;
    }

    public void set(float f10) {
        float f11 = this.mValue;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            this.mValue = f10;
            this.notifyChange();
        }
    }

    public void writeToParcel(Parcel parcel, int n10) {
        float f10 = this.mValue;
        parcel.writeFloat(f10);
    }
}

