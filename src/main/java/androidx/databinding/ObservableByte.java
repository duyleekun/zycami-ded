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
import androidx.databinding.ObservableByte$1;
import java.io.Serializable;

public class ObservableByte
extends BaseObservableField
implements Parcelable,
Serializable {
    public static final Parcelable.Creator CREATOR;
    public static final long serialVersionUID = 1L;
    private byte mValue;

    static {
        ObservableByte$1 observableByte$1 = new ObservableByte$1();
        CREATOR = observableByte$1;
    }

    public ObservableByte() {
    }

    public ObservableByte(byte by2) {
        this.mValue = by2;
    }

    public ObservableByte(Observable ... observableArray) {
        super(observableArray);
    }

    public int describeContents() {
        return 0;
    }

    public byte get() {
        return this.mValue;
    }

    public void set(byte by2) {
        byte by3 = this.mValue;
        if (by2 != by3) {
            this.mValue = by2;
            this.notifyChange();
        }
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = this.mValue;
        parcel.writeByte((byte)n10);
    }
}

