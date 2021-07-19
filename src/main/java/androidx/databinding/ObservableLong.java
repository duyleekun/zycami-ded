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
import androidx.databinding.ObservableLong$1;
import java.io.Serializable;

public class ObservableLong
extends BaseObservableField
implements Parcelable,
Serializable {
    public static final Parcelable.Creator CREATOR;
    public static final long serialVersionUID = 1L;
    private long mValue;

    static {
        ObservableLong$1 observableLong$1 = new ObservableLong$1();
        CREATOR = observableLong$1;
    }

    public ObservableLong() {
    }

    public ObservableLong(long l10) {
        this.mValue = l10;
    }

    public ObservableLong(Observable ... observableArray) {
        super(observableArray);
    }

    public int describeContents() {
        return 0;
    }

    public long get() {
        return this.mValue;
    }

    public void set(long l10) {
        long l11 = this.mValue;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            this.mValue = l10;
            this.notifyChange();
        }
    }

    public void writeToParcel(Parcel parcel, int n10) {
        long l10 = this.mValue;
        parcel.writeLong(l10);
    }
}

