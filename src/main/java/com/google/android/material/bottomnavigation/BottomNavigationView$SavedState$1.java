/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$ClassLoaderCreator
 */
package com.google.android.material.bottomnavigation;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.bottomnavigation.BottomNavigationView$SavedState;

public final class BottomNavigationView$SavedState$1
implements Parcelable.ClassLoaderCreator {
    public BottomNavigationView$SavedState createFromParcel(Parcel parcel) {
        BottomNavigationView$SavedState bottomNavigationView$SavedState = new BottomNavigationView$SavedState(parcel, null);
        return bottomNavigationView$SavedState;
    }

    public BottomNavigationView$SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        BottomNavigationView$SavedState bottomNavigationView$SavedState = new BottomNavigationView$SavedState(parcel, classLoader);
        return bottomNavigationView$SavedState;
    }

    public BottomNavigationView$SavedState[] newArray(int n10) {
        return new BottomNavigationView$SavedState[n10];
    }
}

