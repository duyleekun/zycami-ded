/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.view.View$BaseSavedState
 */
package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.appcompat.widget.AppCompatSpinner$SavedState$1;

public class AppCompatSpinner$SavedState
extends View.BaseSavedState {
    public static final Parcelable.Creator CREATOR;
    public boolean mShowDropdown;

    static {
        AppCompatSpinner$SavedState$1 appCompatSpinner$SavedState$1 = new AppCompatSpinner$SavedState$1();
        CREATOR = appCompatSpinner$SavedState$1;
    }

    public AppCompatSpinner$SavedState(Parcel parcel) {
        super(parcel);
        byte by2 = parcel.readByte();
        if (by2 != 0) {
            by2 = 1;
        } else {
            by2 = 0;
            parcel = null;
        }
        this.mShowDropdown = by2;
    }

    public AppCompatSpinner$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public void writeToParcel(Parcel parcel, int n10) {
        super.writeToParcel(parcel, n10);
        n10 = (byte)(this.mShowDropdown ? 1 : 0);
        parcel.writeByte((byte)n10);
    }
}

