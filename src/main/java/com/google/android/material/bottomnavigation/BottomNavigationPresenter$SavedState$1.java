/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.material.bottomnavigation;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.bottomnavigation.BottomNavigationPresenter$SavedState;

public final class BottomNavigationPresenter$SavedState$1
implements Parcelable.Creator {
    public BottomNavigationPresenter$SavedState createFromParcel(Parcel parcel) {
        BottomNavigationPresenter$SavedState bottomNavigationPresenter$SavedState = new BottomNavigationPresenter$SavedState(parcel);
        return bottomNavigationPresenter$SavedState;
    }

    public BottomNavigationPresenter$SavedState[] newArray(int n10) {
        return new BottomNavigationPresenter$SavedState[n10];
    }
}

