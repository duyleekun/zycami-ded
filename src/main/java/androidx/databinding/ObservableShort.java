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
import androidx.databinding.ObservableShort$1;
import java.io.Serializable;

public class ObservableShort
extends BaseObservableField
implements Parcelable,
Serializable {
    public static final Parcelable.Creator CREATOR;
    public static final long serialVersionUID = 1L;
    private short mValue;

    static {
        ObservableShort$1 observableShort$1 = new ObservableShort$1();
        CREATOR = observableShort$1;
    }

    public ObservableShort() {
    }

    public ObservableShort(short s10) {
        this.mValue = s10;
    }

    public ObservableShort(Observable ... observableArray) {
        super(observableArray);
    }

    public int describeContents() {
        return 0;
    }

    public short get() {
        return this.mValue;
    }

    public void set(short s10) {
        short s11 = this.mValue;
        if (s10 != s11) {
            this.mValue = s10;
            this.notifyChange();
        }
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = this.mValue;
        parcel.writeInt(n10);
    }
}

