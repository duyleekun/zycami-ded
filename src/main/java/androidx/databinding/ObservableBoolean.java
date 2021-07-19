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
import androidx.databinding.ObservableBoolean$1;
import java.io.Serializable;

public class ObservableBoolean
extends BaseObservableField
implements Parcelable,
Serializable {
    public static final Parcelable.Creator CREATOR;
    public static final long serialVersionUID = 1L;
    private boolean mValue;

    static {
        ObservableBoolean$1 observableBoolean$1 = new ObservableBoolean$1();
        CREATOR = observableBoolean$1;
    }

    public ObservableBoolean() {
    }

    public ObservableBoolean(boolean bl2) {
        this.mValue = bl2;
    }

    public ObservableBoolean(Observable ... observableArray) {
        super(observableArray);
    }

    public int describeContents() {
        return 0;
    }

    public boolean get() {
        return this.mValue;
    }

    public void set(boolean bl2) {
        boolean bl3 = this.mValue;
        if (bl2 != bl3) {
            this.mValue = bl2;
            this.notifyChange();
        }
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = (int)(this.mValue ? 1 : 0);
        parcel.writeInt(n10);
    }
}

