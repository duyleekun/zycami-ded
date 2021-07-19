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
import androidx.databinding.ObservableChar$1;
import java.io.Serializable;

public class ObservableChar
extends BaseObservableField
implements Parcelable,
Serializable {
    public static final Parcelable.Creator CREATOR;
    public static final long serialVersionUID = 1L;
    private char mValue;

    static {
        ObservableChar$1 observableChar$1 = new ObservableChar$1();
        CREATOR = observableChar$1;
    }

    public ObservableChar() {
    }

    public ObservableChar(char c10) {
        this.mValue = c10;
    }

    public ObservableChar(Observable ... observableArray) {
        super(observableArray);
    }

    public int describeContents() {
        return 0;
    }

    public char get() {
        return this.mValue;
    }

    public void set(char c10) {
        char c11 = this.mValue;
        if (c10 != c11) {
            this.mValue = c10;
            this.notifyChange();
        }
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = this.mValue;
        parcel.writeInt(n10);
    }
}

