/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.material.bottomnavigation;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.bottomnavigation.BottomNavigationPresenter$SavedState$1;

public class BottomNavigationPresenter$SavedState
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public int selectedItemId;

    static {
        BottomNavigationPresenter$SavedState$1 bottomNavigationPresenter$SavedState$1 = new BottomNavigationPresenter$SavedState$1();
        CREATOR = bottomNavigationPresenter$SavedState$1;
    }

    public BottomNavigationPresenter$SavedState() {
    }

    public BottomNavigationPresenter$SavedState(Parcel parcel) {
        int n10;
        this.selectedItemId = n10 = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = this.selectedItemId;
        parcel.writeInt(n10);
    }
}

